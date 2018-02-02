package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.a$d;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.config.d$b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q$e;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

@SuppressLint({"ViewConstructor"})
final class b extends com.tencent.mm.ui.statusbar.b implements l {
    private e irP;
    private ThreeDotsLoadingView jJq;
    private LinearLayout jKA;
    private c jKB;
    private d$b jKC = d$b.PORTRAIT;
    private ImageView jKx;
    private ImageView jKy;
    private TextView jKz;

    public b(Context context, e eVar) {
        super(context);
        this.irP = eVar;
        x.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(h.ixp, this);
        this.jKx = (ImageView) findViewById(q$g.itJ);
        this.jKx.setImageDrawable(a.Ji());
        this.jKz = (TextView) findViewById(q$g.itK);
        this.jKy = (ImageView) findViewById(q$g.itM);
        this.jJq = (ThreeDotsLoadingView) findViewById(q$g.itL);
        this.jKA = (LinearLayout) findViewById(q$g.itI);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJq.getLayoutParams();
        this.jKB = c.a.c(getContext(), this.irP);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 21;
        layoutParams2.rightMargin = com.tencent.mm.bv.a.ab(getContext(), q$e.isJ);
        layoutParams2.topMargin = com.tencent.mm.bv.a.ab(getContext(), q$e.isK);
        this.jKA.addView(this.jKB.getActionView(), layoutParams2);
        d.e.abO();
        this.jKC = d.bQ(getContext());
        x.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[]{this.jKC});
        if (this.jKC == d$b.LANDSCAPE) {
            layoutParams.topMargin = com.tencent.mm.bv.a.ab(getContext(), q$e.isM);
            this.jKz.setPadding(0, 0, 0, 0);
            this.jJq.setLayoutParams(layoutParams);
        } else {
            layoutParams.topMargin = com.tencent.mm.bv.a.ab(getContext(), q$e.isN);
            this.jKz.setPadding(0, 0, 0, com.tencent.mm.bv.a.ab(getContext(), q$e.isL));
            this.jJq.setLayoutParams(layoutParams);
        }
        ak(-1, true);
        this.jKB.setBackgroundColor(0);
        this.jKB.uV("black");
        this.jKB.amp();
        OnClickListener 2 = new 2(this);
        this.jKB.b(2);
        this.jKB.a(2);
        if (getContext() != null && (getContext() instanceof Activity)) {
            Window window = ((Activity) getContext()).getWindow();
            if (window != null) {
                j.c(window, true);
            }
        }
        this.jJq.cze();
    }

    public final void bA(String str, String str2) {
        com.tencent.mm.modelappbrand.a.b.Jj().a(this.jKx, str, null, f.hkr);
        this.jKz.setText(str2);
    }

    public final void akz() {
        x.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
        post(new 1(this));
    }

    public final void akA() {
    }

    public final void a(a$d com_tencent_mm_plugin_appbrand_config_a_d) {
    }

    public final View getView() {
        return this;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.i("MicroMsg.AppBrandGameUILoadingSplash", "onLayout changed:%s", new Object[]{Boolean.valueOf(z)});
        super.onLayout(z, i, i2, i3, i4);
        d.e.abO();
        d$b bQ = d.bQ(getContext());
        x.i("MicroMsg.AppBrandGameUILoadingSplash", "curDeviceOrientation: %s,mLastDeviceOrientation: %s", new Object[]{bQ, this.jKC});
        if (bQ != this.jKC) {
            this.jKC = bQ;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJq.getLayoutParams();
            if (bQ == d$b.LANDSCAPE) {
                layoutParams.topMargin = com.tencent.mm.bv.a.ab(getContext(), q$e.isM);
                this.jKz.setPadding(0, 0, 0, 0);
            } else {
                layoutParams.topMargin = com.tencent.mm.bv.a.ab(getContext(), q$e.isN);
                this.jKz.setPadding(0, 0, 0, com.tencent.mm.bv.a.ab(getContext(), q$e.isL));
            }
            this.jJq.setLayoutParams(layoutParams);
            requestLayout();
        }
    }
}
