package iut.labbeh.simon;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {
    SurfaceView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv = (SurfaceView)findViewById(R.id.surfaceView);

        Canvas canvas
    }
}
