package iut.labbeh.simon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Surface extends SurfaceView
        implements SurfaceHolder.Callback {
    private SurfaceHolder sh;
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public Surface(Context context) {
        super(context);
        sh = getHolder();
        sh.addCallback(this);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
    }
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = sh.lockCanvas();

        // couleurs des rectangles:
        /*
             V
            B R
             J
        */

        paint.setColor(Color.GREEN);
        canvas.drawRect(250,200,450,400, paint);

        paint.setColor(Color.RED);
        canvas.drawRect(450,400,650,600, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(250,600,450,800, paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(50,400,250,600, paint);

        sh.unlockCanvasAndPost(canvas);
    }
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
