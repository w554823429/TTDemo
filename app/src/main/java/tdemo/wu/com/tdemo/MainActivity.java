package tdemo.wu.com.tdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tdemo.wu.com.tdemo.fragment.AFragment;
import tdemo.wu.com.tdemo.fragment.BFragment;
import tdemo.wu.com.tdemo.fragment.CFragment;
import tdemo.wu.com.tdemo.fragment.DFragment;

public class MainActivity extends AppCompatActivity{

    private AFragment aFragment = null;
    private BFragment bFragment = null;
    private CFragment cFragment = null;
    private DFragment dFragment = null;
    @BindView(R.id.fl_content)
    FrameLayout fl_content;
    @BindViews({R.id.rb_a,R.id.rb_b,R.id.rb_c,R.id.rb_d})
    List<RadioButton> rb;
    @BindView(R.id.rg_root)
    RadioGroup rg_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setRadioButton();
        initFragment(savedInstanceState);
    }

    private void setRadioButton() {
        rb.get(0).setChecked(true);
        rb.get(0).setTextColor(getApplicationContext().getResources().getColor(R.color.black));
    }

    private void clearState(){
        rg_root.clearCheck();
        rb.get(0).setTextColor(getApplicationContext().getResources().getColor(R.color.gray));
        rb.get(1).setTextColor(getApplicationContext().getResources().getColor(R.color.gray));
        rb.get(2).setTextColor(getApplicationContext().getResources().getColor(R.color.gray));
        rb.get(3).setTextColor(getApplicationContext().getResources().getColor(R.color.gray));
    }

    @SuppressLint("RestrictedApi")
    private void initFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            List<Fragment> mFragments = getSupportFragmentManager().getFragments();
            for (Fragment item : mFragments) {
                if (item instanceof AFragment) {
                    aFragment = (AFragment) item;
                }
                if (item instanceof BFragment) {
                    bFragment = (BFragment) item;
                }
                if (item instanceof CFragment) {
                    cFragment = (CFragment) item;
                }
                if (item instanceof DFragment) {
                    dFragment = (DFragment) item;
                }
            }
        } else {
            aFragment = AFragment.getAFragmetnt();
            bFragment = BFragment.getBFragmetnt();
            cFragment = CFragment.getCFragmetnt();
            dFragment = DFragment.getDFragmetnt();
            FragmentTransaction fragmentTrans = getSupportFragmentManager().beginTransaction();
            fragmentTrans.add(R.id.fl_content, aFragment);
            fragmentTrans.add(R.id.fl_content, bFragment);
            fragmentTrans.add(R.id.fl_content, cFragment);
            fragmentTrans.add(R.id.fl_content, dFragment);
            fragmentTrans.commit();
        }
        getSupportFragmentManager().beginTransaction().show(aFragment)
                .hide(bFragment)
                .hide(cFragment)
                .hide(dFragment)
                .commit();
    }

    @OnClick({R.id.rb_a,R.id.rb_b,R.id.rb_c,R.id.rb_d})
    public void onClick(View v){
        clearState();
        switch (v.getId()){
            case R.id.rb_a:
                rb.get(0).setChecked(true);
                rb.get(0).setTextColor(getApplicationContext().getResources().getColor(R.color.black));
                getSupportFragmentManager().beginTransaction().show(aFragment)
                        .hide(bFragment)
                        .hide(cFragment)
                        .hide(dFragment)
                        .commit();
                break;
            case R.id.rb_b:
                rb.get(1).setChecked(true);
                rb.get(1).setTextColor(getApplicationContext().getResources().getColor(R.color.black));
                getSupportFragmentManager().beginTransaction().show(bFragment)
                        .hide(aFragment)
                        .hide(cFragment)
                        .hide(dFragment)
                        .commit();
                break;
            case R.id.rb_c:
                rb.get(2).setChecked(true);
                rb.get(2).setTextColor(getApplicationContext().getResources().getColor(R.color.black));
                getSupportFragmentManager().beginTransaction().show(cFragment)
                        .hide(aFragment)
                        .hide(bFragment)
                        .hide(dFragment)
                        .commit();
                break;
            case R.id.rb_d:
                rb.get(3).setChecked(true);
                rb.get(3).setTextColor(getApplicationContext().getResources().getColor(R.color.black));
                getSupportFragmentManager().beginTransaction().show(dFragment)
                            .hide(aFragment)
                            .hide(bFragment)
                            .hide(cFragment)
                            .commit();
                    break;
        }
    }


    private long mExitTime = 0;
    @Override
     public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if((System.currentTimeMillis()-mExitTime)<=3000) {
                finish();
            }else{
                mExitTime=System.currentTimeMillis();
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
