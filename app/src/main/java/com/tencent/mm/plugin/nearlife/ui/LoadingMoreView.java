package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;

public class LoadingMoreView extends LinearLayout {
    private Context context;
    private ImageView fyg = ((ImageView) findViewById(R.h.csR));
    protected LinearLayout kOG;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = LayoutInflater.from(this.context).inflate(R.i.dmE, this, true);
        this.kOG = (LinearLayout) inflate.findViewById(R.h.ctv);
        this.kOG.setVisibility(0);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.fyg.startAnimation(rotateAnimation);
    }
}
