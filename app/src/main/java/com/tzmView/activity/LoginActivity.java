package com.tzmView.activity;

import com.netease.nimlib.sdk.auth.LoginInfo;
import com.tzmModel.LoginModel;
import com.tzmView.MainActivity;
import com.tzmView.R;
import com.tzmView.view.TextURLView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private Context mContext;
	private RelativeLayout rl_user;
	private Button mLogin;
	private Button register;
	private TextURLView mTextViewURL;
	private EditText account;
	private EditText password;
	private LoginModel loginModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mContext=this;
		findView();
		initTvUrl();
		init();
	}
	
	private void findView(){
		rl_user=(RelativeLayout) findViewById(R.id.rl_user);
		mLogin=(Button) findViewById(R.id.login);
		register=(Button) findViewById(R.id.register);
		mTextViewURL=(TextURLView) findViewById(R.id.tv_forget_password);
		account=(EditText) findViewById(R.id.account);
		password=(EditText)findViewById(R.id.password);
	}

//	初始化数据，给动画和按钮注册监听器
	private void init(){
		Animation anim=AnimationUtils.loadAnimation(mContext, R.anim.login_anim);
		anim.setFillAfter(true);
		rl_user.startAnimation(anim);
		
		mLogin.setOnClickListener(loginOnClickListener);
		register.setOnClickListener(registerOnClickListener);
	}

//	设置忘记密码文字
	private void initTvUrl(){
		mTextViewURL.setText(R.string.forget_password);
	}

//	登录监听
	private OnClickListener loginOnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
//	待实现验证功能->伟哥
			if(checkAccountAndPassword()) {
				LoginInfo info = new LoginInfo(account.getText().toString(), password.getText().toString()); // config...
				loginModel = LoginModel.getInstance();
				loginModel.login(info, account.getText().toString());
			}
		}
	};

//	注册监听
	private OnClickListener registerOnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			//	待实现验证功能->伟哥
			Intent intent=new Intent(mContext, RegisterPhoneActivity.class);
			startActivity(intent);
			
		}
	};

//	忘记密码监听
	private OnClickListener forgetPasswordOnClickListener=new OnClickListener() {
	@Override
	public void onClick(View view) {
//		待实现验证功能->莫磊

		}
	};

//	检查用户名和密码是否为空
	private boolean checkAccountAndPassword(){
		if(!account.getText().toString().equals("")){
			if(!password.getText().toString().equals("")){
				return true;
			}
			Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
			return false;
		}
		Toast.makeText(this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
		return false;
	}
}
