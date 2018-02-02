package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;

@SuppressLint({"ViewConstructor"})
public final class b extends l {
    private c iZN;
    private String mURL;

    public final /* bridge */ /* synthetic */ p aex() {
        return this.iZN;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
    }

    protected final View aeo() {
        return new FrameLayout(getContext());
    }

    protected final View aep() {
        c cVar = new c(getContext(), this.iqC.irP);
        this.iZN = cVar;
        return cVar.iZP;
    }

    public final void loadUrl(String str) {
        this.mURL = str;
        this.iZN.rQ(str);
        aeu();
    }

    public final boolean rO(String str) {
        return true;
    }

    public final boolean rP(String str) {
        return true;
    }

    public final void b(String str, String str2, int[] iArr) {
        this.iZN.h(str, str2, 0);
    }

    public final String aeq() {
        return this.mURL;
    }

    public final void cleanup() {
        super.cleanup();
        this.iZN.cleanup();
    }

    protected final void aer() {
        super.aer();
        this.iZN.onDestroy();
    }

    public final void aes() {
        super.aes();
        this.iZN.aga();
    }

    public final void aet() {
        super.aet();
        cz(false);
        this.iZN.afA();
    }

    private void cz(boolean z) {
        if (VERSION.SDK_INT >= 21 && (getContext() instanceof Activity)) {
            Window window = ((Activity) getContext()).getWindow();
            if (window == null) {
                return;
            }
            if (z) {
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                return;
            }
            window.clearFlags(Integer.MIN_VALUE);
        }
    }

    protected final void aeu() {
        if (this.iqC.irP.iqy.iMC.iMH) {
            this.iZN.cB(false);
            cz(true);
            return;
        }
        this.iZN.cB(true);
    }

    protected final void aev() {
        aeu();
    }

    public final void aew() {
        if (this.iZN != null) {
            c cVar = this.iZN;
            if (cVar.iZQ != null) {
                com.tencent.mm.plugin.appbrand.game.b bVar = cVar.iZQ.iXv;
            }
        }
    }
}
