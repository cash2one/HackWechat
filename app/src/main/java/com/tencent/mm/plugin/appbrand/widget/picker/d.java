package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.q$d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.k;

public class d extends RelativeLayout {
    private static final int kds = Color.parseColor("#F9F9F9");
    private final int kdl;
    private final int kdm;
    public e kdn;
    FrameLayout kdo;
    public a kdp;
    private boolean kdq;
    public b kdr;

    final void anM() {
        this.kdp = null;
        this.kdr = null;
    }

    private void g(boolean z, Object obj) {
        if (!this.kdq && this.kdp != null) {
            this.kdq = true;
            this.kdp.f(z, obj);
            this.kdq = false;
        }
    }

    public d(Context context) {
        super(context);
        this.kdl = a.fromDPToPix(context, 48);
        this.kdm = a.fromDPToPix(context, 240);
        setClickable(true);
        setLongClickable(true);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kdm);
        layoutParams.addRule(12);
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setId(g.iuB);
        frameLayout.setOnClickListener(new 4(this));
        frameLayout.setBackgroundColor(kds);
        this.kdo = frameLayout;
        addView(frameLayout, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-1, this.kdl);
        layoutParams.addRule(2, g.iuB);
        frameLayout = new RelativeLayout(getContext());
        View bX = bX(j.dUc, q$d.bsE);
        bX.setOnClickListener(new 1(this));
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        frameLayout.addView(bX, layoutParams2);
        bX = bX(j.dUa, q$d.brF);
        bX.setOnClickListener(new 2(this));
        layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        frameLayout.addView(bX, layoutParams2);
        frameLayout.setOnClickListener(new 3(this));
        frameLayout.setBackgroundColor(kds);
        addView(frameLayout, layoutParams);
    }

    public void show() {
        if (this.kdn == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.kdn != null) {
            this.kdn.a(this);
        }
    }

    public void hide() {
        super.setVisibility(8);
        g(false, null);
        if (this.kdn != null) {
            this.kdn.anH();
        }
    }

    public void setVisibility(int i) {
        if (i != 0) {
            hide();
        } else {
            super.setVisibility(i);
        }
    }

    @SuppressLint({"WrongCall"})
    protected final void bV(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onMeasure(int i, int i2) {
        if (isShown()) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.kdl + this.kdm, 1073741824));
        } else {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
        }
    }

    private View bX(int i, int i2) {
        View textView = new TextView(new ContextThemeWrapper(getContext(), k.iCa));
        textView.setTextColor(getResources().getColor(i2));
        textView.setText(i);
        textView.setGravity(17);
        return textView;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        anM();
        removeAllViews();
    }
}
