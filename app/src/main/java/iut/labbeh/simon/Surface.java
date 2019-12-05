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
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = sh.lockCanvas();

        // couleurs des rectangles:
        /*
            V R
            J B
        */

        canvas.drawColor(Color.GREEN);
        canvas.drawCircle(100, 200, 50, paint);

        canvas.drawColor(Color.RED);
        //canvas.drawRect();

        canvas.drawColor(Color.YELLOW);
        canvas.drawColor(Color.BLUE);

        sh.unlockCanvasAndPost(canvas);
    }
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
    }
    public void surfaceDestroyed(SurfaceHolder holder) {
    }
}
