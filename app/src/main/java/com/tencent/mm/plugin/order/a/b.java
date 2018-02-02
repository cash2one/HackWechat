package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class b implements ap {
    private static HashMap<Integer, d> gwY;
    private List<WeakReference<Object>> kIv = new ArrayList();
    private a lhZ = new 3(this);
    private af mHandler = new af(Looper.getMainLooper());
    com.tencent.mm.plugin.order.model.b oZO = null;
    private com.tencent.mm.plugin.order.b.b oZP;
    private c oZQ = null;
    private a oZR = new 2(this);

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new 1());
        com.tencent.mm.wallet_core.a.i("ShowOrdersInfoProcess", a.class);
    }

    public static b bit() {
        return (b) p.s(b.class);
    }

    public final void biu() {
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
        }
    }

    public final void asi() {
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
        }
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        this.oZO = null;
        this.oZQ = null;
    }

    public final void onAccountRelease() {
    }

    public static com.tencent.mm.plugin.order.b.b biv() {
        g.Dh().Ct();
        if (bit().oZP == null) {
            b bit = bit();
            g.Dk();
            bit.oZP = new com.tencent.mm.plugin.order.b.b(g.Dj().gQj);
        }
        return bit().oZP;
    }

    public static c biw() {
        g.Dh().Ct();
        if (bit().oZQ == null) {
            bit().oZQ = new c();
        }
        return bit().oZQ;
    }

    public static String aWR() {
        if (g.Dh().Cy()) {
            return com.tencent.mm.plugin.n.c.Fi() + "order";
        }
        return "";
    }
}
