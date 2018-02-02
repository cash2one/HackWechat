package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.pluginsdk.ui.a.b;

public class TrackPoint extends LinearLayout {
    private ImageView hvY;
    public double jlP = -1.0d;
    public double jlQ = -1.0d;
    public double jlR = -1.0d;
    public double jlS = -1.0d;
    private Context mContext;
    public ImageView nYo;
    public ImageView nYp;
    public View nYq;
    private double nYr = 0.0d;
    private String username;
    public boolean visible = true;

    public TrackPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TrackPoint(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, R.i.dth, this);
        this.hvY = (ImageView) inflate.findViewById(R.h.cSI);
        this.nYo = (ImageView) inflate.findViewById(R.h.cSK);
        this.nYp = (ImageView) inflate.findViewById(R.h.cSJ);
        this.nYp.setVisibility(4);
        this.nYq = inflate.findViewById(R.h.cSH);
        this.hvY.setOnLongClickListener(new 1(this));
        this.nYo.requestFocus();
    }

    public final void g(OnClickListener onClickListener) {
        this.nYo.setOnClickListener(onClickListener);
    }

    public final void h(OnClickListener onClickListener) {
        this.hvY.setOnClickListener(onClickListener);
    }

    public final void DR(String str) {
        this.username = str;
        this.nYo.setTag(str);
        b.o(this.hvY, str);
        this.hvY.setTag(str);
    }

    public final void aWI() {
        this.visible = false;
        this.nYq.setVisibility(4);
    }

    public final void aWJ() {
        this.visible = true;
        this.nYq.setVisibility(0);
    }

    public final void o(double d) {
        float f = (float) this.nYr;
        float f2 = (float) d;
        Animation rotateAnimation = new RotateAnimation(f.x(f, f2), f.w(f, f2), 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);
        this.nYo.startAnimation(rotateAnimation);
        this.nYr = d;
    }

    public final void aWK() {
        this.nYp.setVisibility(4);
    }
}
