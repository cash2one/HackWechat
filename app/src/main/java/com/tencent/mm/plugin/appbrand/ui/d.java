package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.config.a$d;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.statusbar.b;

@SuppressLint({"ViewConstructor"})
final class d extends b implements l {
    private e irP;
    private c jDN = a.c(getContext(), this.irP);
    private Runnable jLh;

    public d(Context context, e eVar) {
        super(context);
        this.irP = eVar;
        addView(this.jDN.getActionView());
        this.jDN.do(false);
        OnClickListener 1 = new 1(this);
        this.jDN.b(1);
        this.jDN.a(1);
        o(ac.getContext().getString(j.iyp), -1, "black");
        setBackgroundColor(-1);
    }

    private void o(String str, int i, String str2) {
        this.jDN.uT(str);
        this.jDN.setBackgroundColor(i);
        this.jDN.uV(str2);
        this.jDN.amp();
        this.jDN.dq(true);
        ak(i, "black".equals(str2));
    }

    public final void bA(String str, String str2) {
        this.jDN.uT(ac.getContext().getString(j.iyp));
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jLh == null) {
            this.jLh = new 2(this);
            postDelayed(this.jLh, 1500);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.jLh);
    }

    public final void akz() {
        removeCallbacks(this.jLh);
        post(new 3(this));
    }

    public final void akA() {
        this.jDN.dp(true);
    }

    public final void a(a$d com_tencent_mm_plugin_appbrand_config_a_d) {
        if (!this.irP.iqy.iMy.abN()) {
            o(com_tencent_mm_plugin_appbrand_config_a_d.iMQ, j.aK(com_tencent_mm_plugin_appbrand_config_a_d.iMU, -1), com_tencent_mm_plugin_appbrand_config_a_d.iMR);
            setBackgroundColor(j.aK(com_tencent_mm_plugin_appbrand_config_a_d.iMN, -1));
        }
    }

    public final View getView() {
        return this;
    }
}
