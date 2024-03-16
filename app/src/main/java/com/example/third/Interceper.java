package com.example.third;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;


@Interceptor(priority = 2, name = "打点拦截器")
public class Interceper implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        // 获取传递的 age 参数
        int age = postcard.getExtras().getInt("age", -1); // 默认值为 -1

        // 判断 age 是否小于 18
        if (age < 18) {
            // 如果小于 18，则不允许导航，并调用 onInterrupt
            Log.d("NavigationDebug", "Navigation is interrupted because age is less than 18.");
            callback.onInterrupt(null); // 可以创建一个 Throwable 对象提供给 onInterrupt，这里传 null 表示没有异常对象
        } else {
            // 如果 age 大于等于 18，则允许导航
            Log.d("NavigationDebug", "upload navigation log");
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
