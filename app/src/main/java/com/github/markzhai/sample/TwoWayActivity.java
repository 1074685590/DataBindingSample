package com.github.markzhai.sample;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.github.markzhai.sample.databinding.ActivityTwoWayBinding;

/**
 * @author markzhai on 16/7/7
 * @version 1.0.0
 */
public class TwoWayActivity extends AppCompatActivity {
    private static final String TAG = "TwoWayActivity";
    ActivityTwoWayBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);

        final FormModel model = new FormModel("markzhai", "123456");
        model.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(TwoWayActivity.this, String.valueOf(i),
                        Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPropertyChanged: "+model.toString());
            }
        });
        mBinding.setModel(model);
    }
}
