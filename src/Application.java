package src;
import static com.raylib.Raylib.*;
import static src.Utils.*;

public class Application {

    private RenderTexture target;
    private Texture boardTexture;
    private Texture cursorTexture;
    private final int appScreenWidth = 3840;
    private final int appScreenHeight = 2160;
    private Camera2D camera;
    
    public Application() {
        
        final int screenWidth = 800;
        final int screenHeight = 600;
        SetConfigFlags(FLAG_WINDOW_RESIZABLE | FLAG_VSYNC_HINT);
        InitWindow(screenWidth, screenHeight, "AI Calculator"); 
        SetTargetFPS(60); 

        target = LoadRenderTexture(appScreenWidth, appScreenHeight);
        SetTextureFilter(target.texture(), TEXTURE_FILTER_BILINEAR);

        camera = new Camera2D();
        camera.offset(Vector2Zero());
        camera.target(Vector2Zero());
        camera.rotation(0.0f);
        camera.zoom(1.0f);

        boardTexture = LoadTexture("assets/board.png");
        cursorTexture = LoadTexture("assets/cursor.png");
    }

    public void run() {
        
        while (!WindowShouldClose()) {

            float scale = Math.min((float)GetScreenWidth()/appScreenWidth, (float)GetScreenHeight()/appScreenHeight);
            Vector2 mouse = GetMousePosition();
            Vector2 virtualMouse = Vector2Zero();
            virtualMouse.x((mouse.x() - ((float)GetScreenWidth() - ((float)appScreenWidth * scale)) * 0.5f) / 2);
            virtualMouse.y((mouse.y() - ((float)GetScreenHeight() - ((float)appScreenHeight * scale)) * 0.5f) / 2);
            virtualMouse = Vector2Clamp(virtualMouse, Vector2Zero(), vec2((float)appScreenWidth, (float)appScreenHeight));
            int offsetX = (int)(-((float)GetScreenWidth() - (appScreenWidth * scale)) * 0.5f);
            int offsetY = (int)(-((float)GetScreenHeight() - (appScreenHeight * scale)) * 0.5f);
            SetMouseOffset(offsetX, offsetY);
            SetMouseScale(1 / scale, 1 / scale);

            float renderWidth = appScreenWidth * scale;
            float renderHeight = appScreenHeight * scale;
            float renderOffsetX = (GetScreenWidth() - renderWidth) * 0.5f;
            float renderOffsetY = (GetScreenHeight() - renderHeight) * 0.5f;

            BeginTextureMode(target);
                ClearBackground(white);  
            EndTextureMode();

            BeginDrawing();
                ClearBackground(black);
                DrawTexturePro(target.texture(),
                    rect(0.0f, 0.0f, (float)target.texture().width(), -((float)target.texture().height())),
                    rect(renderOffsetX, renderOffsetY, renderWidth, renderHeight),
                    Vector2Zero(), 0.0f, white);
            EndDrawing();
        }
    }
}
