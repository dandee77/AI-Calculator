package src;
import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.*;


public class Application {
    
    public Application() {
        
        InitWindow(800, 600, "AI Calculator"); 
        SetTargetFPS(60); 
    }

    public void run() {
        
        while (!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);
            
            DrawText("AI Calculator", 10, 10, 20, BLACK);
            
            EndDrawing();
        }
    }

}
