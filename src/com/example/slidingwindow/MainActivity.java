package com.example.slidingwindow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private Button  btn;
	private LinearLayout l1,l2;
	private boolean flag = false;
	private Animation l_to_r, r_to_l;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button)findViewById(R.id.button1);
		l1 = (LinearLayout)findViewById(R.id.l1);
		l2 = (LinearLayout)findViewById(R.id.l2);
		
		l_to_r = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
		l_to_r.setDuration(2000);
		r_to_l = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
		r_to_l.setDuration(2000);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!flag){
					l1.startAnimation(r_to_l);
					l1.setVisibility(View.GONE);
					
					l2.startAnimation(l_to_r);
					l2.setVisibility(View.VISIBLE);
					
				}else{
					l2.startAnimation(r_to_l);
					l2.setVisibility(View.GONE);
					
					l1.startAnimation(l_to_r);
					l1.setVisibility(View.VISIBLE);
				}
				flag = !flag;
				
				
			}
		});
		
		
	}

}
