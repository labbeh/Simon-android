package iut.labbeh.simon;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    SoundManager sm;
    List<Integer> parcours;

    public GamePlay(Context context){
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
    }
}
