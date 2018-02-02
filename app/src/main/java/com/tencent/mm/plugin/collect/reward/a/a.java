package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a extends k implements com.tencent.mm.network.k {
    protected int errCode = 0;
    protected int errType = 0;
    protected String fnL;
    protected WeakReference<Activity> ljo;
    protected boolean ljp = false;
    protected boolean ljq = false;

    protected abstract void b(int i, int i2, String str, q qVar);

    protected boolean ayR() {
        return true;
    }

    public final void m(Activity activity) {
        this.ljo = new WeakReference(activity);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            this.ljp = true;
            if (ayR() && this.ljo != null) {
                Activity activity = (Activity) this.ljo.get();
                if (activity != null) {
                    h.a(activity, activity.getString(i.uXa), null, false, new 1(this));
                }
            }
        }
        this.errCode = i3;
        this.errType = i2;
        this.fnL = str;
        b(i2, i3, str, qVar);
    }

    public final a a(a aVar) {
        if (!(this.ljp || this.ljq)) {
            aVar.i(this);
        }
        return this;
    }

    public final a b(a aVar) {
        if (this.ljq) {
            aVar.i(this);
        }
        return this;
    }

    public final a c(a aVar) {
        if (this.ljp) {
            aVar.i(this);
        }
        return this;
    }
}
