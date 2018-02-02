package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b implements e {
    HashSet<k> ilQ = new HashSet();
    HashSet<k> ilR = new HashSet();
    Dialog ilS = null;
    private a imf = null;
    private Set<Integer> img = new HashSet();
    private Context mContext;

    public b(Context context, a aVar) {
        this.mContext = context;
        this.imf = aVar;
    }

    public final void g(k kVar) {
        x.d("MicroMsg.WalletNetSceneMgr", new StringBuilder("isShowProgress true").toString());
        this.ilR.add(kVar);
        if (this.ilS == null || !(this.ilS == null || this.ilS.isShowing())) {
            if (this.ilS != null) {
                this.ilS.dismiss();
            }
            this.ilS = h.a(this.mContext, "", true, new 1(this));
        }
        ar.CG().a(kVar, 0);
    }

    public final void ji(int i) {
        this.img.add(Integer.valueOf(i));
        ar.CG().a(i, this);
    }

    public final void jj(int i) {
        ar.CG().b(i, this);
        this.img.remove(Integer.valueOf(i));
        if (this.img.isEmpty()) {
            if (this.ilS != null) {
                this.ilS.dismiss();
                this.ilS = null;
            }
            Iterator it = this.ilQ.iterator();
            while (it.hasNext()) {
                ar.CG().c((k) it.next());
            }
            it = this.ilR.iterator();
            while (it.hasNext()) {
                ar.CG().c((k) it.next());
            }
            this.ilQ.clear();
            this.ilR.clear();
            this.imf = null;
            this.mContext = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        if (this.ilR.contains(kVar)) {
            this.ilR.remove(kVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
        } else if (this.ilQ.contains(kVar)) {
            this.ilQ.remove(kVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        } else {
            obj = null;
        }
        if (this.ilR.isEmpty() && this.ilQ.isEmpty() && this.ilS != null) {
            this.ilS.dismiss();
            this.ilS = null;
        }
        if (obj != null && this.imf != null) {
            this.imf.e(i, i2, str, kVar);
        }
    }
}
