package tdemo.wu.com.tdemo.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import tdemo.wu.com.tdemo.R;
import tdemo.wu.com.tdemo.adapter.AAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends BaseFragment {

    private List<String> mTabs=new ArrayList<>();
    private List<Fragment> mFragments=new ArrayList<>();
    private A1Fragment a1Fragment;
    private A2Fragment a2Fragment;
    private A3Fragment a3Fragment;

    @BindView(R.id.vp_content)
    ViewPager vp_content;
    @BindView(R.id.tabs)
    TabLayout tabs;

    private static AFragment fragmetnta;

    public static AFragment getAFragmetnt(){
        if(fragmetnta == null){
            fragmetnta = new AFragment();
        }
        return fragmetnta;
    }

    @Override
    int getLayoutResources() {
        return R.layout.fragment_a;
    }

    @Override
    public void initView(){
        a1Fragment=A1Fragment.getA1Fragmetnt();
        a2Fragment=A2Fragment.getA2Fragmetnt();
        a3Fragment=A3Fragment.getA3Fragmetnt();
        mFragments.add(a1Fragment);
        mFragments.add(a2Fragment);
        mFragments.add(a3Fragment);
        initTab();
        vp_content.setAdapter(new AAdapter(getActivity().getSupportFragmentManager(),mFragments,mTabs));
        tabs.setupWithViewPager(vp_content);
    }

    public void initTab(){
        mTabs.add("A1");
        mTabs.add("A2");
        mTabs.add("A3");
    }

}
