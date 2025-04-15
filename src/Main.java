package src;
import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.*;


public class Main {
    public static void main(String[] args) {
        
        InitWindow(800, 450, "Test");
        SetTargetFPS(60);

        while (!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);
            DrawText("Congrats! You created your first window!", 190, 200, 20, LIGHTGRAY);
            EndDrawing();
        }

        CloseWindow();
    }
}

