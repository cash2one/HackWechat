package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q$e;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.b;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.c;
import com.tencent.mm.ui.v;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public final class a extends LinearLayout implements c {
    private int Df;
    private ImageView jVA;
    private View jVB;
    private ImageButton jVC;
    private AppBrandOptionButton jVD;
    private AppBrandCapsuleHomeButton jVE;
    private ProgressBar jVF;
    private CircleProgressDrawable jVG;
    private LinearLayout jVH;
    private ImageView jVI;
    private int jVJ;
    private double jVK;
    private OnClickListener jVL = null;
    private OnClickListener jVM = null;
    private long jVN = 0;
    private View jVx;
    private TextView jVy;
    private TextView jVz;

    public a(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.a.ci(getContext())));
        setGravity(19);
        setBackgroundResource(d.bre);
        addView(v.fv(getContext()).inflate(h.iwG, this, false));
        this.jVJ = -1;
        this.Df = getResources().getColor(d.bre);
        this.jVK = 1.0d;
        this.jVx = findViewById(q$g.itw);
        this.jVy = (TextView) findViewById(q$g.itx);
        this.jVz = (TextView) findViewById(q$g.ity);
        this.jVA = (ImageView) findViewById(q$g.itv);
        this.jVB = findViewById(q$g.itu);
        this.jVC = (ImageButton) findViewById(q$g.its);
        this.jVD = (AppBrandOptionButton) findViewById(q$g.itr);
        this.jVE = (AppBrandCapsuleHomeButton) findViewById(q$g.itq);
        this.jVF = (ProgressBar) findViewById(q$g.itt);
        this.jVH = (LinearLayout) findViewById(q$g.ito);
        this.jVI = (ImageView) findViewById(q$g.itp);
        this.jVG = new CircleProgressDrawable();
        this.jVB.setOnClickListener(new 1(this));
        this.jVE.setOnClickListener(new 2(this));
    }

    public final void a(OnClickListener onClickListener) {
        this.jVL = onClickListener;
    }

    public final void b(OnClickListener onClickListener) {
        this.jVM = onClickListener;
    }

    public final void a(OnLongClickListener onLongClickListener) {
        this.jVE.setOnLongClickListener(onLongClickListener);
    }

    public final void uT(String str) {
        this.jVy.setText(str);
    }

    public final CharSequence amk() {
        return this.jVy.getText();
    }

    public final void c(OnClickListener onClickListener) {
        this.jVx.setOnClickListener(new 3(this, onClickListener));
    }

    public final double aml() {
        return this.jVK;
    }

    public final void k(double d) {
        this.jVK = d;
        super.getBackground().setAlpha((int) (255.0d * d));
    }

    public final void uU(String str) {
        this.Df = j.aK(str, this.Df);
        setBackgroundColor(this.Df);
    }

    public final void setBackgroundColor(int i) {
        this.Df = i;
        super.setBackgroundColor(i);
        k(this.jVK);
    }

    public final int getBackgroundColor() {
        return this.Df;
    }

    public final void d(OnClickListener onClickListener) {
        this.jVD.setOnClickListener(onClickListener);
    }

    public final void do(boolean z) {
        if (z) {
            this.jVH.setVisibility(0);
        } else {
            this.jVH.setVisibility(8);
        }
        if (z) {
            this.jVD.setVisibility(0);
        } else {
            this.jVD.setVisibility(8);
        }
        if (z) {
            this.jVE.setVisibility(0);
        } else {
            this.jVE.setVisibility(8);
        }
    }

    public final void amm() {
        this.jVD.reset();
        this.jVE.reset();
        amo();
    }

    public final void e(OnClickListener onClickListener) {
        this.jVC.setOnClickListener(onClickListener);
    }

    public final void uV(String str) {
        if ("white".equals(str)) {
            this.jVJ = -1;
        } else if ("black".equals(str)) {
            this.jVJ = WebView.NIGHT_MODE_COLOR;
        }
        amn();
    }

    public final void lS(int i) {
        this.jVJ = i;
        amn();
    }

    public final int getForegroundColor() {
        return this.jVJ;
    }

    private void amn() {
        this.jVA.setImageResource(i.ixW);
        this.jVA.setColorFilter(this.jVJ, Mode.SRC_ATOP);
        this.jVy.setTextColor(this.jVJ);
        this.jVz.setTextColor(this.jVJ);
        this.jVC.setImageDrawable(j.c(getContext(), i.ixP, this.jVJ));
        CircleProgressDrawable circleProgressDrawable = this.jVG;
        circleProgressDrawable.mz = this.jVJ;
        circleProgressDrawable.invalidateSelf();
        this.jVF.setLayerType(1, null);
        this.jVF.setIndeterminateDrawable(this.jVG);
        amo();
        if (this.jVJ == -1) {
            this.jVI.setImageResource(d.isx);
            this.jVH.setBackgroundResource(f.ita);
            return;
        }
        this.jVI.setImageResource(d.isy);
        this.jVH.setBackgroundResource(f.itb);
    }

    private void amo() {
        if (this.jVJ == -1) {
            this.jVD.setColor(-1);
            this.jVE.setColor(-1);
            return;
        }
        this.jVD.setColor(WebView.NIGHT_MODE_COLOR);
        this.jVE.setColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void amp() {
        amn();
    }

    public final void dp(boolean z) {
        int i;
        View view = this.jVB;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        view = this.jVx;
        if (z) {
            i = getContext().getResources().getDimensionPixelSize(q$e.bvv);
        } else {
            i = 0;
        }
        view.setPadding(i, 0, 0, 0);
    }

    public final void dq(boolean z) {
        this.jVF.setVisibility(z ? 0 : 8);
        if (z) {
            CircleProgressDrawable circleProgressDrawable = this.jVG;
            circleProgressDrawable.mg.clear();
            ArrayList arrayList = circleProgressDrawable.mg;
            CircleProgressDrawable$RingPathTransform circleProgressDrawable$RingPathTransform = circleProgressDrawable.jUX;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(circleProgressDrawable$RingPathTransform, "trimPathStart", new float[]{0.0f, 0.75f});
            ofFloat.setDuration(1333);
            ofFloat.setInterpolator(c.jUZ);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(circleProgressDrawable$RingPathTransform, "trimPathEnd", new float[]{0.0f, 0.75f});
            ofFloat2.setDuration(1333);
            ofFloat2.setInterpolator(b.jUZ);
            ofFloat2.setRepeatCount(-1);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(circleProgressDrawable$RingPathTransform, "trimPathOffset", new float[]{0.0f, 0.25f});
            ofFloat3.setDuration(1333);
            ofFloat3.setInterpolator(com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.a.jUZ);
            ofFloat3.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            arrayList.add(animatorSet);
            ArrayList arrayList2 = circleProgressDrawable.mg;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(circleProgressDrawable.jUY, "rotation", new float[]{0.0f, 720.0f});
            ofFloat4.setDuration(6665);
            ofFloat4.setInterpolator(com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.a.jUZ);
            ofFloat4.setRepeatCount(-1);
            arrayList2.add(ofFloat4);
            this.jVG.start();
            return;
        }
        this.jVG.stop();
    }

    public final void b(com.tencent.mm.plugin.appbrand.page.a.a aVar) {
        this.jVD.a(aVar, this.jVJ);
    }

    public final View getActionView() {
        return this;
    }
}
