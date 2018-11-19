package com.github.markzhai.sample;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.github.markzhai.sample.databinding.ActivityLmtestBinding;

/**
 * 自定义属性
 */
public class LMTestActivity extends AppCompatActivity {

    private ActivityLmtestBinding mBinding;
    Student mLiumeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lmtest);
//        mBinding.addOnRebindCallback(new OnRebindCallback() {
//            @Override
//            public boolean onPreBind(ViewDataBinding binding) {
//                ViewGroup root = (ViewGroup)binding.getRoot();
//                TransitionManager.beginDelayedTransition(root);
//                return true;
//            }
//        });
//        mBinding.setPresenter(new Presenter());

        mBinding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup view = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(view);
                return true;
            }
        });
        mBinding.setPresenter(new Presenter());


    }

    public class Presenter {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            mBinding.iv.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            mBinding.setShow(isChecked);
        }
    }

}
