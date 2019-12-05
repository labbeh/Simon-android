package iut.labbeh.simon;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {
    SoundManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Surface(this));

        sm = new SoundManager();
        sm.initSounds(this);
        sm.addSound(1, R.raw.birds);
    }
}
