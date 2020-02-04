package iut.labbeh.simon;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.os.SystemClock.sleep;


public class GamePlay {
    SoundManager sm;
    //List<Integer> parcours;
    private DessinJeu dj;
    public String etat;
    List<Integer> L;
    Random random;
    private int indexSequence;
    private Context context;
    private AlertDialog.Builder builder;

    public GamePlay(Context context, DessinJeu dj){

        sm=new SoundManager();
        sm.initSounds(context);
        sm.addSound(1,R.raw.aaaah);
        sm.addSound(2,R.raw.aahhh2);
        sm.addSound(3,R.raw.aahhzz);
        sm.addSound(4,R.raw.ah);
        this.dj = dj;
        etat = "off";
        random = new Random();
        L = new ArrayList<Integer>();
        this.context=context;
        builder = new AlertDialog.Builder(context);

    }

    public void initSequence(){
        L.clear();
        etat="play";
        indexSequence=0;
        Play(null);
    }

    public void PlaySequence(){
        etat="sequence";
        sleep(1000);

        for (int i : L) {
            dj.AfficheCanvas(i);
            sm.playSound(i+1);
            sleep(600);
            dj.AfficheCanvas(0,0);
            sleep(100);
        }
        dj.AfficheCanvas(0,0);
        etat="play";
    }

    public boolean Play(MotionEvent event){
        if (etat=="play") {
            L.add(random.nextInt(4) );
            PlaySequence();
            indexSequence = 0;
            etat="doSequence";
            return true;
        }
        if (etat=="doSequence")
            testSequence(dj.determineRectangle(event.getX(), event.getY()));

        if (etat=="erreur") {
            builder.setTitle("Perdu !");
            builder.setMessage("Score : "+String.valueOf(L.size()-1));
            builder.setPositiveButton("Rejouer", (dialog, which) -> onBackPressed());
            builder.setNegativeButton("Arrêter", (dialog, which) -> onExitPressed());
            builder.show();
        }
        if (etat=="finSequence") {
            L.add(random.nextInt(4)) ;
            PlaySequence();
            indexSequence = 0;
            etat="doSequence";
            return true;
        }
        return true;
    }
    public void onBackPressed(){initSequence();}
    public void onExitPressed(){System.exit(0);}
    public boolean testSequence (int place){
        sm.playSound(place+1);
        if (L.get(indexSequence) == place) {
            indexSequence++;
            if (indexSequence>=L.size()) etat="finSequence";
            return true;
        }
        etat = "erreur";
        return false;
    }


    /*private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

}


    /*public GamePlay(Context context){
        sm = new SoundManager();
        parcours = new ArrayList<>();
        ajouter();


        sm.initSounds(context);
        sm.addSound(1, R.raw.ah);

        sm.addSound(1, R.raw.aaaah);
        sm.addSound(2, R.raw.aahhh2);
        sm.addSound(3, R.raw.aahhzz);
        sm.addSound(4, R.raw.ah);
    }

    public void player(int i) {
        sm.playSound(i);
    }

    public void ajouter(){
        parcours.add((int)(Math.random() * ((4 - 1) + 1)) + 1);
    }*/

