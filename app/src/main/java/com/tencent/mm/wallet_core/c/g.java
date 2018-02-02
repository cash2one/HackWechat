package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class g extends k implements com.tencent.mm.network.k {
    private static final String zHo = ac.getResources().getString(i.uXa);
    protected int errCode = 0;
    protected int errType = 0;
    protected String fnL;
    private WeakReference<MMActivity> fqH;
    public b gJQ;
    public e gJT;
    public boolean ljp = false;
    public boolean ljq = false;
    public int zHp = 0;
    public String zHq;

    public abstract void b(int i, int i2, String str, q qVar);

    public abstract void f(q qVar);

    public final void k(MMActivity mMActivity) {
        this.fqH = new WeakReference(mMActivity);
    }

    public boolean ayS() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            this.ljp = true;
        }
        if (!this.ljp) {
            f(qVar);
            if (this.zHp != 0) {
                this.ljq = true;
            }
        }
        this.errCode = i3;
        this.errType = i2;
        this.fnL = str;
        x.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.zHp), this.zHq});
        b(i2, i3, str, qVar);
        if (this.fqH != null) {
            Context context = (MMActivity) this.fqH.get();
            if (context == null) {
                return;
            }
            if (this.ljp) {
                x.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
                h.a(context, zHo, null, false, new 1(this, context));
            } else if (this.ljq && !bh.ov(this.zHq) && ayS()) {
                x.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
                Toast.makeText(context, this.zHq, 1).show();
            }
        }
    }

    public int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        Assert.assertNotNull("rr can't be null!", this.gJQ);
        return a(eVar, this.gJQ, this);
    }

    public final g a(a aVar) {
        if (!(this.ljp || this.ljq)) {
            aVar.f(this.errCode, this.errType, this.fnL, this);
        }
        return this;
    }

    public final g b(a aVar) {
        if (this.ljq) {
            aVar.f(this.errCode, this.errType, this.fnL, this);
        }
        return this;
    }

    public final g c(a aVar) {
        if (this.ljp) {
            aVar.f(this.errCode, this.errType, this.fnL, this);
        }
        return this;
    }
}
