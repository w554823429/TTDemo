package tdemo.wu.com.tdemo.fragment;


import android.support.v4.app.Fragment;

import tdemo.wu.com.tdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class A2Fragment extends BaseFragment {
    private static A2Fragment fragmetnta2;

    public static A2Fragment getA2Fragmetnt(){
        if(fragmetnta2 == null){
            fragmetnta2 = new A2Fragment();
        }
        return fragmetnta2;
    }

    @Override
    int getLayoutResources() {
        return R.layout.fragment_a2;
    }

    @Override
    void initView() {

    }

}
