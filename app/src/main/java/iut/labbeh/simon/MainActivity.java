package iut.labbeh.simon;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * Instance de sound manager pour jouer des bruitages
     * */
    //SoundManager sm;

    /**
     * Insrtance de la surface
     * */
    Surface sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sf = new Surface(this);
        setContentView(sf);

        /*sm = new SoundManager();
        sm.initSounds(this);

        sm.addSound(1, R.raw.aaaah);
        sm.addSound(2, R.raw.aahhh2);
        sm.addSound(3, R.raw.aahhzz);
        sm.addSound(4, R.raw.ah);*/
    }

   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        /*
        if(this.x1 < this.x2 && this.y1 < this.y2)
				g.drawRect(this.x1+5, this.y1+5, this.x2-this.x1, this.y2-this.y1);

			else if(this.x1 > this.x2 && this.y1 > this.y2)
				g.drawRect(this.x2+5, this.y2+5, this.x1-this.x2, this.y1-this.y2);

			else if(this.x1 < this.x2 && this.y1 > this.y2)
				g.drawRect(this.x1+5, this.y2+5, this.x2-this.x1, this.y1-this.y2);

			else if(this.x1 > this.x2 && this.y1 < this.y2)
				g.drawRect(this.x2+5, this.y1+5, this.x1-this.x2, this.y2-this.y1);


        // vert : 350 456
        // rouge: 611 613
        // jaune: 361 892
        // bleu : 156 659

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            sm.playSound(1);
            Toast.makeText(this, String.format("%s %s", x, y), Toast.LENGTH_SHORT).show();
        }

        return true;
    }*/
}
