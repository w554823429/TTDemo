package tdemo.wu.com.tdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MX on 2018/5/28.
 */

public class AAdapter extends FragmentPagerAdapter {

    private FragmentManager mfm=null;
    private List<Fragment> mList=new ArrayList<>();
    private List<String> mTitles=new ArrayList<>();

    public AAdapter(FragmentManager fm,List<Fragment> mList,List<String> mTitles) {
        super(fm);
        this.mfm=fm;
        this.mList=mList;
        this.mTitles=mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mTitles.get(position);
    }
}
