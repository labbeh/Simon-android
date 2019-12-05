package iut.labbeh.simon;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {
    /**
     * Instance de sound manager pour jouer des bruitages
     * */
    SoundManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Surface(this));

        sm = new SoundManager();
        sm.initSounds(this);

        sm.addSound(1, R.raw.aaaah);
        sm.addSound(2, R.raw.aahhh2);
        sm.addSound(3, R.raw.aahhzz);
        sm.addSound(4, R.raw.ah);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
            sm.playSound(1);

        return true;
    }
}
