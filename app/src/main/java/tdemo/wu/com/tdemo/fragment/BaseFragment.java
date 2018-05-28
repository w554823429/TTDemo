package tdemo.wu.com.tdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by MX on 2018/5/28.
 */

abstract class BaseFragment extends Fragment {
    private boolean isFirst = false;
    private View rootView= null;
    private boolean isFragmentVisiable = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        if(rootView==null){
            rootView=inflater.inflate(getLayoutResources(),container,false);
        }
        ButterKnife.bind(this,rootView);
        return rootView;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        initView();
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            isFragmentVisiable=true;
        }
        if(rootView==null){
            return;
        }
        //可见,并且没有加载过
        if(!isFirst&&isFragmentVisiable){
            onFragmentVisiableChange(true);
        }
        //由可见到不可见  已经加载过
        if(isFragmentVisiable){
            onFragmentVisiableChange(false);
            isFragmentVisiable=false;
        }
    }

    protected void onFragmentVisiableChange(boolean b){}


    abstract int getLayoutResources();

    abstract void initView();
}
