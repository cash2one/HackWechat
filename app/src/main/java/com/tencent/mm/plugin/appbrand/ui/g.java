package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

@SuppressLint({"ViewConstructor"})
final class g extends b implements l {
    private e irP;
    private ThreeDotsLoadingView jJq;
    private LinearLayout jKA;
    private c jKB;
    private ImageView jKx = ((ImageView) findViewById(com.tencent.mm.plugin.appbrand.q.g.iuq));
    private TextView jKz;
    private View jMW;
    private View jMX;

    public g(Context context, e eVar) {
        super(context);
        this.irP = eVar;
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(h.ixq, this);
        this.jKx.setImageDrawable(a.Ji());
        this.jKz = (TextView) findViewById(com.tencent.mm.plugin.appbrand.q.g.ius);
        this.jJq = (ThreeDotsLoadingView) findViewById(com.tencent.mm.plugin.appbrand.q.g.iuv);
        this.jKA = (LinearLayout) findViewById(com.tencent.mm.plugin.appbrand.q.g.iur);
        this.jMX = findViewById(com.tencent.mm.plugin.appbrand.q.g.iuu);
        this.jMW = findViewById(com.tencent.mm.plugin.appbrand.q.g.iut);
        this.jKB = c.a.c(getContext(), this.irP);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 21;
        layoutParams.rightMargin = com.tencent.mm.bv.a.ab(getContext(), q.e.isJ);
        this.jKA.addView(this.jKB.getActionView(), layoutParams);
        this.jKz.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.a.ci(getContext());
        ak(-1, true);
        this.jKB.setBackgroundColor(0);
        this.jKB.uV("black");
        this.jKB.amp();
        OnClickListener 2 = new 2(this);
        this.jKB.b(2);
        this.jKB.a(2);
        this.jJq.cze();
    }

    public final void bA(String str, String str2) {
        com.tencent.mm.modelappbrand.a.b.Jj().a(this.jKx, str, null, f.hkr);
        this.jKz.setText(str2);
    }

    public final void akz() {
        post(new 1(this));
    }

    public final void akA() {
        this.jKB.dp(true);
    }

    public final void a(d dVar) {
    }

    public final View getView() {
        return this;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getContext() instanceof Activity) {
            j.c(((Activity) getContext()).getWindow(), false);
        }
    }

    public final boolean hasOverlappingRendering() {
        return false;
    }
}
