package iut.labbeh.simon;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DessinJeu {
    private final SurfaceHolder sh;
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int sizeX, sizeY;
    public DessinJeu(SurfaceHolder sh) {
        paint.setStyle(Paint.Style.FILL);
        this.sh = sh;
        sizeX=Resources.getSystem().getDisplayMetrics().widthPixels;
        sizeY=Resources.getSystem().getDisplayMetrics().heightPixels;



    }

    private static int darkerColor(int color){
        float ratio = 1.0f- 0.5f;
        int a = (color >> 24) & 0xFF;
        int r = (int) (((color >> 16) & 0xFF) * ratio);
        int g = (int) (((color >> 8) & 0xFF) * ratio);
        int b = (int) ((color & 0xFF) * ratio);
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    protected void AfficheCanvas(float x,float y){
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

    protected void AfficheCanvas(int place){
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
    }
}
