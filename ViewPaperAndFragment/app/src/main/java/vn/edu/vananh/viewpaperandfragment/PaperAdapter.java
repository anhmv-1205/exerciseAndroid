package vn.edu.vananh.viewpaperandfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PaperAdapter extends FragmentPagerAdapter {

    int mNumberOfTab;
    public PaperAdapter(FragmentManager fm, int numberOfTab) {
        super(fm);
        this.mNumberOfTab = numberOfTab;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                TapFragment1 tab1 = new TapFragment1();
                return tab1;
            case 1:
                TapFragment2 tab2 = new TapFragment2();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfTab;
    }
}
