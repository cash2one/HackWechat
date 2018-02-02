package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;

public class PickPoi extends RelativeLayout {
    private Context context;
    Animation nSy;
    View nSz;
    protected b nVX;
    public a nWe = new 1(this);
    private double nXl;
    private double nXm;
    f nXn = new f();
    boolean nXo = true;
    e nXp = null;

    public PickPoi(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public PickPoi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PickPoi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        this.nVX = b.ON();
        this.nSy = AnimationUtils.loadAnimation(this.context, R.a.bqH);
        this.nSz = LayoutInflater.from(this.context).inflate(R.i.dmI, this, true).findViewById(R.h.ctM);
    }

    public final void k(double d, double d2) {
        this.nXl = d;
        this.nXm = d2;
        this.nXn = new f();
        this.nXn.type = 3;
        this.nXn.mName = this.context.getResources().getString(R.l.eth);
        this.nXn.bhC = d;
        this.nXn.bhD = d2;
        this.nXn.nXy = "";
        this.nVX.a(this.nWe);
        this.nVX.a(d, d2, this.nWe);
        this.nXo = true;
    }
}
