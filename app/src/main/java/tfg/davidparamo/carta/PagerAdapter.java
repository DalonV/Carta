package tfg.davidparamo.carta;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by david on 19/02/2017.
 */

public class PagerAdapter  extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new primerosFragment();
                break;
            case 1:
                frag=new segundosFragment();
                break;
            case 2:
                frag=new postresFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="Primeros";
                break;
            case 1:
                title="Segundos";
                break;
            case 2:
                title="Postres";
                break;
        }

        return title;
    }
}
