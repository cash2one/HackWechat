package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.z.ar;

public abstract class c extends k implements com.tencent.mm.network.k {
    protected Activity activity;
    protected b gJQ;
    protected e gJT;
    protected e mEQ;

    protected abstract void aLV();

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        m.AG("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + i2 + "," + i3 + "]");
        if (this.mEQ != null) {
            this.mEQ.a(i2, i3, str, this);
        }
        if ((this.activity == null || !this.activity.isFinishing()) && this.gJT != null) {
            ag.y(new 1(this, i, i2, i3, str, qVar, bArr));
        }
    }

    protected void b(int i, int i2, int i3, String str) {
    }

    public final void b(e eVar) {
        this.gJT = eVar;
        m.AG("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        ar.CG().a(this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.mEQ = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final c v(Activity activity) {
        this.activity = activity;
        return this;
    }
}
