package iut.labbeh.simon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import static java.lang.Thread.*;

public class Surface extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder sh;
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private GamePlay gp;
    private DessinJeu dj;

    public Surface(Context context) {
        super(context);


        sh = getHolder();
        sh.addCallback(this);

        dj = new DessinJeu(sh);

        gp = new GamePlay(getContext(), dj);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
    }

    public static int darkerColor(int color){
        float ratio = 10.f - 0.5f;
        int a = (color >> 24) & 0xFF;
        int r, g, b;

        r= (int) (((color >> 16) & 0xFF) * ratio);
        g= (int) (((color >> 8) & 0xFF) * ratio);
        b= (int) ((color >> 16 & 0xFF) * ratio);

        return (a << 24) | (r << 16) | (g << 8) | b;
    }

   /* private static int darkerColor(int color){
        float ratio = 1.0f- 0.5f;
        int a = (color >> 24) & 0xFF;
        int r = (int) (((color >> 16) & 0xFF) * ratio);
        int g = (int) (((color >> 8) & 0xFF) * ratio);
        int b = (int) ((color & 0xFF) * ratio);
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = sh.lockCanvas();
        canvas.drawColor(Color.BLACK);

        // couleurs des rectangles:
        /*
             V
            B R
             J
        */

       /* paint.setColor(Color.GREEN);
        canvas.drawRect(250,200,450,400, paint);

        paint.setColor(Color.RED);
        canvas.drawRect(450,400,650,600, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(250,600,450,800, paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(50,400,250,600, paint);

        sh.unlockCanvasAndPost(canvas);
    }

    protected void afficheCanvas(float x,float y){
        int [] couleur = {darkerColor(Color.BLUE), darkerColor(Color.RED),darkerColor(Color.YELLOW),darkerColor(Color.GREEN)};
        if (x!=0 && y!=0)
            switch (determineRectangle(x,y)){
                case 0: couleur[0] = Color.BLUE;break;
                case 1: couleur[2] = Color.YELLOW;break;
                case 2: couleur[1] = Color.RED;break;
                case 3: couleur[3] = Color.GREEN;
            }
        Canvas canvas = sh.lockCanvas();
        canvas.drawColor(Color.BLACK);
        paint.setColor(couleur[0]);
        canvas.drawRect(0, 0, sizeX/2,sizeY/2, paint);
        paint.setColor(couleur[1]);
        canvas.drawRect(0, sizeY/2, sizeX/2,sizeY, paint);
        paint.setColor(couleur[2]);
        canvas.drawRect(sizeX/2, 0, sizeX,sizeY/2, paint);
        paint.setColor(couleur[3]);
        canvas.drawRect(sizeX/2, sizeY/2, sizeX,sizeY, paint);
        sh.unlockCanvasAndPost(canvas);
    }


    /*public void afficherCanvas(int place) {
        int[] couleurs = {
                darkerColor(Color.BLUE),
                darkerColor(Color.RED ),
                darkerColor(Color.YELLOW),
                darkerColor(Color.GREEN)
        };

        switch(place){
            case 0: couleurs[0] = Color.BLACK; break;
            case 1: couleurs[2] = Color.YELLOW; break;
            case 2: couleurs[1] = Color.RED; break;
            case 3: couleurs[3] = Color.GREEN;
        }

        Canvas canvas = sh.lockCanvas();
        canvas.drawColor(Color.BLACK);

        paint.setColor(couleurs[0]);
        canvas.drawRect(250,200,450,400, paint);

        paint.setColor(couleurs[1]);
        canvas.drawRect(450,400,650,600, paint);

        paint.setColor(couleurs[2]);
        canvas.drawRect(250,600,450,800, paint);

        paint.setColor(couleurs[3]);
        canvas.drawRect(50,400,250,600, paint);

        sh.unlockCanvasAndPost(canvas);
    }

    private int determineRectangle(float x, float y) {
        if(x<450) return 0;
        if(x>450) return 2;
        if(y<600) return 3;
        return 1;
    }*/

    /*protected void AfficheCanvas(int place){
        int [] couleur = {darkerColor(Color.BLUE), darkerColor(Color.RED),darkerColor(Color.YELLOW),darkerColor(Color.GREEN)};
        if (place>=0)
            switch (place){
                case 0: couleur[0] = Color.BLUE;break;
                case 1: couleur[2] = Color.YELLOW;break;
                case 2: couleur[1] = Color.RED;break;
                case 3: couleur[3] = Color.GREEN;
            }
        Canvas canvas = sh.lockCanvas();
        canvas.drawColor(Color.BLACK);
        paint.setColor(couleur[0]);
        canvas.drawRect(0, 0, sizeX/2,sizeY/2, paint);
        paint.setColor(couleur[1]);
        canvas.drawRect(0, sizeY/2, sizeX/2,sizeY, paint);
        paint.setColor(couleur[2]);
        canvas.drawRect(sizeX/2, 0, sizeX,sizeY/2, paint);
        paint.setColor(couleur[3]);
        canvas.drawRect(sizeX/2, sizeY/2, sizeX,sizeY, paint);
        sh.unlockCanvasAndPost(canvas);
    }

    protected int determineRectangle(float x,float y ){
        if (x<sizeX/2 )
            if (y<sizeY/2) return 0;
            else return 2;
        if (y<sizeY/2) return 1;
        return 3;
    }*/

    public void surfaceCreated(SurfaceHolder holder){
        dj.AfficheCanvas(0,0);
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        // vert : 350 456
        // rouge: 611 613
        // jaune: 361 892
        // bleu : 156 659

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            dj.AfficheCanvas(x,y);
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            dj.AfficheCanvas(x,y);
            if(gp.etat.equals("off"))
                gp.initSequence();
            else gp.Play(event);
        }

        return true;
    }
}