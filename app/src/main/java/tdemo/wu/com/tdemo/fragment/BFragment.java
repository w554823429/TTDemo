package tdemo.wu.com.tdemo.fragment;

import android.support.v4.app.Fragment;

import tdemo.wu.com.tdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends BaseFragment {

    private static BFragment fragmetntb;

    public static BFragment getBFragmetnt(){
        if(fragmetntb == null){
            fragmetntb = new BFragment();
        }
        return fragmetntb;
    }

    @Override
    int getLayoutResources() {
        return R.layout.fragment_b;
    }

    @Override
    void initView() {

    }
}
