package tdemo.wu.com.tdemo.fragment;


import android.support.v4.app.Fragment;

import tdemo.wu.com.tdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DFragment extends BaseFragment {


    private static DFragment fragmetntd;

    public static DFragment getDFragmetnt(){
        if(fragmetntd == null){
            fragmetntd = new DFragment();
        }
        return fragmetntd;
    }

    @Override
    int getLayoutResources() {
        return R.layout.fragment_d;
    }

    @Override
    void initView() {

    }

}
