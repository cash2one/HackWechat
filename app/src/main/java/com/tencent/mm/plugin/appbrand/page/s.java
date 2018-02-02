package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.p.l;

public final class s extends l {
    private p jcr;
    private String mUrl;

    public s(Context context, n nVar) {
        super(context, nVar);
    }

    protected final View aep() {
        if (this.jcr == null) {
            this.jcr = this.iqC.aiU();
        }
        return this.jcr.getContentView();
    }

    public final void loadUrl(String str) {
        if (this.mUrl == null) {
            this.mUrl = str;
            this.jcr.rQ(str);
            aev();
        }
    }

    public final boolean rO(String str) {
        return l.uB(this.mUrl).equals(l.uB(str));
    }

    public final boolean rP(String str) {
        return this.mUrl != null && this.mUrl.equals(str);
    }

    protected final void aer() {
        super.aer();
        this.jcr.onDestroy();
    }

    public final void cleanup() {
        super.cleanup();
        this.jcr.cleanup();
    }

    public final void aes() {
        super.aes();
        this.jcr.aga();
    }

    public final void aet() {
        super.aet();
        this.jcr.afA();
    }

    public final void b(String str, String str2, int[] iArr) {
        if (c(iArr, this.jcr.hashCode())) {
            this.jcr.h(str, str2, 0);
        }
    }

    public final p aex() {
        return this.jcr;
    }

    public final String aeq() {
        return this.mUrl;
    }
}
