package com.tzmModel;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.tzmView.MainActivity;
import com.tzmView.activity.LoginActivity;
import com.tzmView.util.CacheUtil;

/**
 * Created by kal-al on 18-1-2.
 */

public class LoginModel extends LoginActivity {
    private static final LoginModel ourInstance = new LoginModel();

    public static LoginModel getInstance() {
        return ourInstance;
    }

    private LoginModel() {
    }

    public void login(LoginInfo loginInfo, final String account){
        RequestCallback<LoginInfo> callback =
                new RequestCallback<LoginInfo>() {
                    @Override
                    public void onSuccess(LoginInfo loginInfo) {
                        CacheUtil.setAccount(account);
                        Intent intent=new Intent(getBaseContext(),MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailed(int i) {
                        Toast.makeText(LoginModel.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        Log.e("RequestErr->","Errors happened in LoginModel.java at function: login");
                    }
                    // overwrite methods
                };
        NIMClient.getService(AuthService.class).login(loginInfo)
                .setCallback(callback);
    }
}
