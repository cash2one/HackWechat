package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.support.v4.view.z;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.page.a$a;
import com.tencent.mm.plugin.appbrand.q$d;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.a;
import com.tencent.mm.ui.v;
import com.tencent.smtt.sdk.WebView;

public final class b extends LinearLayout implements c {
    private int Df;
    private AppBrandCapsuleHomeButton jVE;
    private LinearLayout jVH;
    private ImageView jVI;
    private int jVJ;
    private double jVK;
    private OnClickListener jVL = null;
    private OnClickListener jVM = null;
    private AppBrandCapsuleOptionButton jVQ;
    public boolean jVR;

    public b(Context context, boolean z) {
        super(context);
        this.jVR = z;
        setLayoutParams(new MarginLayoutParams(-1, a.ci(getContext())));
        setGravity(19);
        addView(v.fv(getContext()).inflate(h.iwN, this, false));
        this.jVJ = -1;
        this.Df = getResources().getColor(q$d.bre);
        this.jVK = 1.0d;
        this.jVQ = (AppBrandCapsuleOptionButton) findViewById(g.ivn);
        this.jVE = (AppBrandCapsuleHomeButton) findViewById(g.ivm);
        this.jVI = (ImageView) findViewById(g.ivl);
        this.jVH = (LinearLayout) findViewById(g.ivk);
        this.jVE.setOnClickListener(new 1(this));
        this.jVQ.setVisibility(0);
        this.jVE.setVisibility(0);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        amq();
    }

    public final void amq() {
        if (!this.jVR && getPaddingTop() == 0) {
            return;
        }
        if (z.ai(this)) {
            setPadding(0, Math.max(com.tencent.mm.ui.statusbar.a.ab(j.cg(getContext())), 0), 0, 0);
            requestLayout();
            return;
        }
        post(new 2(this));
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
    }

    public final CharSequence amk() {
        return null;
    }

    public final void c(OnClickListener onClickListener) {
    }

    public final double aml() {
        return this.jVK;
    }

    public final void k(double d) {
    }

    public final void uU(String str) {
    }

    public final void setBackgroundColor(int i) {
    }

    public final int getBackgroundColor() {
        return this.Df;
    }

    public final void d(OnClickListener onClickListener) {
        this.jVQ.setOnClickListener(onClickListener);
    }

    public final void do(boolean z) {
        if (z) {
            this.jVH.setVisibility(0);
        } else {
            this.jVH.setVisibility(8);
        }
        if (z) {
            this.jVQ.setVisibility(0);
        } else {
            this.jVQ.setVisibility(8);
        }
        if (z) {
            this.jVE.setVisibility(0);
        } else {
            this.jVE.setVisibility(8);
        }
    }

    public final void amm() {
        this.jVQ.reset();
        this.jVE.reset();
        amo();
    }

    public final void e(OnClickListener onClickListener) {
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
        amo();
        if (this.jVJ == -1) {
            this.jVI.setImageResource(q$d.isx);
            this.jVH.setBackgroundResource(f.ita);
            return;
        }
        this.jVI.setImageResource(q$d.isy);
        this.jVH.setBackgroundResource(f.itb);
    }

    private void amo() {
        if (this.jVJ == -1) {
            this.jVQ.setColor(-1);
            this.jVE.setColor(-1);
            return;
        }
        this.jVQ.setColor(WebView.NIGHT_MODE_COLOR);
        this.jVE.setColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void amp() {
    }

    public final void dp(boolean z) {
    }

    public final void dq(boolean z) {
    }

    public final void b(a$a com_tencent_mm_plugin_appbrand_page_a_a) {
        this.jVQ.a(com_tencent_mm_plugin_appbrand_page_a_a, this.jVJ);
    }

    public final View getActionView() {
        return this;
    }
}
