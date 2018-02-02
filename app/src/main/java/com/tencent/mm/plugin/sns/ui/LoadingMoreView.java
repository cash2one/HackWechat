package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.rtmp.TXLiveConstants;

public class LoadingMoreView extends LinearLayout {
    private Context context;
    private ImageView fyg;
    protected LinearLayout kOG;
    protected LinearLayout kOH;
    protected LinearLayout rtU;
    protected LinearLayout rtV;
    protected TextView rtW;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public LoadingMoreView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.context).inflate(g.qHE, this, true);
        this.fyg = (ImageView) findViewById(f.bJR);
        this.kOG = (LinearLayout) inflate.findViewById(f.ctv);
        this.kOH = (LinearLayout) inflate.findViewById(f.ctt);
        this.rtU = (LinearLayout) inflate.findViewById(f.qFF);
        this.rtV = (LinearLayout) inflate.findViewById(f.qDf);
        this.rtW = (TextView) inflate.findViewById(f.qDg);
        this.kOG.setVisibility(0);
        this.kOH.setVisibility(8);
        this.rtU.setVisibility(8);
        this.rtV.setVisibility(8);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.fyg.startAnimation(rotateAnimation);
    }

    public final void iE(boolean z) {
        this.kOG.setVisibility(8);
        if (z) {
            this.rtU.setVisibility(0);
            this.kOH.setVisibility(8);
        } else {
            this.kOH.setVisibility(0);
            this.rtU.setVisibility(8);
        }
        this.rtV.setVisibility(8);
    }

    public final void xv(int i) {
        this.kOG.setVisibility(8);
        this.rtU.setVisibility(8);
        this.kOH.setVisibility(8);
        this.rtV.setVisibility(0);
        if (i == 2001) {
            this.rtW.setText(getContext().getResources().getString(j.qLX));
        } else if (i == 2003) {
            this.rtW.setText(getContext().getResources().getString(j.qKn));
        } else if (i == TXLiveConstants.PLAY_EVT_PLAY_BEGIN) {
            this.rtW.setText(getContext().getResources().getString(j.qLY));
        }
    }
}
