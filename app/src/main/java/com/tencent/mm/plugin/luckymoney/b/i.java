package com.tencent.mm.plugin.luckymoney.b;

import android.content.Context;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.wallet_core.d.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i implements e, c {
    private String gOs;
    HashSet<k> ilQ = new HashSet();
    HashSet<k> ilR = new HashSet();
    private Set<Integer> img = new HashSet();
    private Context mContext;
    private d ocw = null;
    r tipDialog = null;

    public i(Context context, d dVar) {
        this.mContext = context;
        this.ocw = dVar;
    }

    public final void a(k kVar, boolean z) {
        k(kVar);
        this.ilQ.add(kVar);
        if (z && (this.tipDialog == null || !(this.tipDialog == null || this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.a(this.mContext, this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.ctB), false, new 1(this));
        }
        g.Dk();
        g.Di().gPJ.a(kVar, 0);
    }

    public final void b(k kVar, boolean z) {
        x.d("MicroMsg.WalletNetSceneMgr", "isShowProgress " + z);
        k(kVar);
        this.ilR.add(kVar);
        if (z && (this.tipDialog == null || !(this.tipDialog == null || this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.a(this.mContext, this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.ctB), true, new 2(this));
        }
        g.Dk();
        g.Di().gPJ.a(kVar, 0);
    }

    public final void aXc() {
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        Iterator it = this.ilQ.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            g.Dk();
            g.Di().gPJ.c(kVar);
        }
        it = this.ilR.iterator();
        while (it.hasNext()) {
            kVar = (k) it.next();
            g.Dk();
            g.Di().gPJ.c(kVar);
        }
        this.ilQ.clear();
        this.ilR.clear();
    }

    public final void ji(int i) {
        this.img.add(Integer.valueOf(i));
        g.Dk();
        g.Di().gPJ.a(i, this);
    }

    public final void jj(int i) {
        g.Dk();
        g.Di().gPJ.b(i, this);
        this.img.remove(Integer.valueOf(i));
        if (this.img.isEmpty()) {
            aXc();
            this.ocw = null;
            this.mContext = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj;
        boolean z;
        if (this.ilR.contains(kVar)) {
            this.ilR.remove(kVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
            obj = 1;
        } else if (this.ilQ.contains(kVar)) {
            this.ilQ.remove(kVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
            int i3 = 1;
        } else {
            obj = null;
        }
        if (this.ilR.isEmpty() && this.ilQ.isEmpty()) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            z = true;
        } else {
            z = false;
        }
        if (obj != null && this.ocw != null) {
            this.ocw.b(i, i2, str, kVar, z);
        }
    }

    public final boolean aXd() {
        if (this.ilR.isEmpty() && this.ilQ.isEmpty()) {
            return false;
        }
        return true;
    }

    private void k(k kVar) {
        if (kVar != null && (kVar instanceof l)) {
            ((l) kVar).gOs = this.gOs;
        }
    }

    public final void aXe() {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }
}
