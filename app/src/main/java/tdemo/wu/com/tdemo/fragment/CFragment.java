package tdemo.wu.com.tdemo.fragment;


import android.support.v4.app.Fragment;

import tdemo.wu.com.tdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends BaseFragment {


    private static CFragment fragmetntc;

    public static CFragment getCFragmetnt(){
        if(fragmetntc == null){
            fragmetntc = new CFragment();
        }
        return fragmetntc;
    }

    @Override
    int getLayoutResources() {
        return R.layout.fragment_c;
    }

    @Override
    void initView() {

    }

}
