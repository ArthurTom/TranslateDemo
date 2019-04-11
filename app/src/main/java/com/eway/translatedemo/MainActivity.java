package com.eway.translatedemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wx.goodview.GoodView;

/**
 * 侧边划出的点赞的效果
 */
public class MainActivity extends AppCompatActivity {

	private LinearLayout btn;
	private ImageView img;
	private int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn = findViewById(R.id.btn);
		img = findViewById(R.id.img);
		final GoodView goodView = new GoodView(this);


		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
//                  if (i==0){
//					  Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.out);
//					  btn.startAnimation(animation);
//					  i++;
//				  }else {
//					  Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.in);
//					  btn.startAnimation(animation);
//					  i=0;
//				}
				int tranSalte = dip2px(MainActivity.this, 40);
				if (i == 0) {
					ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "translationX", 0, -tranSalte);
					objectAnimator.setDuration(2000);
					objectAnimator.start();
					i++;
					Log.d("zwk", "最左面的位置" + btn.getLeft());
				} else {
					ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(v, "translationX", -tranSalte, 0);
					objectAnimator1.setDuration(2000);
					objectAnimator1.start();
					i = 0;
					Log.d("zwk", "最左面展开的时候的位置" + btn.getLeft());
				}
			}

		});

		img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				goodView.setText("+1");
				goodView.setImage(R.drawable.good_checked);
				goodView.show(v);

			}
		});


	}

	/**
	 * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

}
