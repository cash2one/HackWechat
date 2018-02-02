package com.tencent.mm.z.c;

import android.annotation.SuppressLint;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.bs;
import com.tencent.mm.z.p;
import java.util.HashMap;
import java.util.Map;

public class c implements ap {
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, d> gwY;
    private com.tencent.mm.sdk.b.c hiA = new 2(this);
    private a hiB = new 3(this);
    private b hiC = null;
    private final com.tencent.mm.plugin.auth.a.a hiD = new 4(this);
    private com.tencent.mm.storage.d hix;
    private com.tencent.mm.storage.b hiy;
    private bs.a hiz = new 1(this);

    static /* synthetic */ void IH() {
        com.tencent.mm.storage.c fn = IF().fn("100229");
        if (fn.isValid()) {
            Map chI = fn.chI();
            int i = bh.getInt((String) chI.get("UseSvrTime"), 0);
            ac.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("client_server_diff_time_enable", i).putInt("client_server_diff_time_interval", bh.getInt((String) chI.get("MinDiffTime"), 0)).commit();
            x.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time enable[%d] diffTime[%d]", Integer.valueOf(i), Integer.valueOf(r0));
            return;
        }
        ac.getContext().getSharedPreferences("system_config_prefs", 4).edit().remove("client_server_diff_time_enable").remove("client_server_diff_time_interval").commit();
        x.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time abtest is not valid, then delete data");
    }

    private static synchronized c IE() {
        c cVar;
        synchronized (c.class) {
            cVar = (c) p.s(c.class);
        }
        return cVar;
    }

    public static com.tencent.mm.storage.d IF() {
        g.Dh().Ct();
        if (IE().hix == null) {
            IE().hix = new com.tencent.mm.storage.d(g.Dj().gQj);
        }
        return IE().hix;
    }

    public static com.tencent.mm.storage.b IG() {
        g.Dh().Ct();
        if (IE().hiy == null) {
            IE().hiy = new com.tencent.mm.storage.b(g.Dj().gQj);
        }
        return IE().hiy;
    }

    public final void bq(boolean z) {
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("newabtest", this.hiz, true);
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("newabtestinfo", this.hiz, true);
        com.tencent.mm.sdk.b.a.xef.b(this.hiA);
        IF().c(this.hiB);
        this.hiC = ((com.tencent.mm.plugin.auth.a.b) g.k(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.hiD);
    }

    public final void onAccountRelease() {
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("newabtest", this.hiz, true);
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("newabtestinfo", this.hiz, true);
        com.tencent.mm.sdk.b.a.xef.c(this.hiA);
        IF().j(this.hiB);
        if (this.hiC != null) {
            this.hiC.dead();
            this.hiC = null;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new 5());
        gwY.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new 6());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }
}
