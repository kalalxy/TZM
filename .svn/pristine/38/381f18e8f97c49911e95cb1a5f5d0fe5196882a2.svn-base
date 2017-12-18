package com.tzmView.activity;

import com.tzmView.R;
import com.tzmView.view.TextURLView;
import com.tzmView.view.TitleBarView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegisterPhoneActivity extends Activity {

	private Context mContext;
	private TitleBarView mTitleBarView;
	private TextURLView mTextViewURL;
	private Button next;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_phone);
		mContext=this;
		findView();
		initTitleView();
		initTvUrl();
		init();
	}
	
	private void findView(){
		mTitleBarView=(TitleBarView) findViewById(R.id.title_bar);
		mTextViewURL=(TextURLView) findViewById(R.id.tv_url);
		next=(Button) findViewById(R.id.btn_next);
	}
	
	private void init(){
//		给下一步按钮添加监听器
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

//				待实现验证功能

				Intent intent=new Intent(mContext,RegisterInfoActivity.class);
				startActivity(intent);
				
			}
		});
	}
	
	private void initTitleView(){
		mTitleBarView.setCommonTitle(View.VISIBLE, View.VISIBLE,View.GONE, View.GONE);
		mTitleBarView.setBtnLeft(R.drawable.boss_unipay_icon_back, R.string.back);
		mTitleBarView.setTitleText(R.string.title_phoneNumber);
		mTitleBarView.setBtnLeftOnclickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	private void initTvUrl(){
		mTextViewURL.setText(R.string.tv_xieyi_url);
	}

}
