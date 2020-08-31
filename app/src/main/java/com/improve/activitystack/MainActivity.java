package com.improve.activitystack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * https://www.jianshu.com/p/f3170fb1aaa8
 */
public class MainActivity extends AppCompatActivity {
    private String TAG = "Main";

    /**
     * @param savedInstanceState
     * @onCreate 创建新的activity
     * 如果参数不为空，说明它之前被回收了
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG = toString();
        Log.e(TAG, "onCreate: ");
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 可能从onCreate过来，也有可能从onStop-onRestart过来
     * onStart调用的地方 {@link android.app.Activity}
     * 最终在{@link ActivityThread handleStartActivity }调用
     * 之后
     * callActivityOnRestoreInstanceState
     * callActivityOnPostCreate
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    /**
     * 调用之前 会deliverNewIntents deliverResults
     * 然后将activity添加到window中,此时对view属性进行计算
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    /**
     * 当activity部分不可见时调用，如半透明盒子覆盖在上面
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    /**
     * activity完全不可见时调用
     * 调用之前必定经过{@link #onPause}
     * 执行完后可能直接销毁activity实例，越过onDestroy
     * 回到前台会调用onRestart
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

//    @Override
//    public void finish() {
//        super.finish();
//        Log.e("TAG", "finish: ");
//    }

    /**
     * activity真正销毁
     * 应释放所有用到的资源，防止内存泄露
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }
}