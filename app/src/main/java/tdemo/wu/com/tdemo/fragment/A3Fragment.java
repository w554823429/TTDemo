package tdemo.wu.com.tdemo.fragment;


import android.support.v4.app.Fragment;

import tdemo.wu.com.tdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class A3Fragment extends BaseFragment {

    private static A3Fragment fragmetnta3;

    public static A3Fragment getA3Fragmetnt(){
        if(fragmetnta3 == null){
            fragmetnta3 = new A3Fragment();
        }
        return fragmetnta3;
    }

    @Override
    int getLayoutResources() {
        return R.layout.fragment_a3;
    }

    @Override
    void initView() {

    }

}
