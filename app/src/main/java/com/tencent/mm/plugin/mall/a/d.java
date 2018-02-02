package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.p;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class d implements e, ap {
    private af mHandler = new af(Looper.getMainLooper());
    ConcurrentHashMap<Integer, t> okT = new ConcurrentHashMap();
    private boolean okU = false;
    private a okV = new 1(this);
    private a okW = new 2(this);

    public static d aXX() {
        return (d) p.s(d.class);
    }

    public final t sn(int i) {
        Object obj = null;
        if (!this.okT.contains(Integer.valueOf(i))) {
            com.tencent.mm.plugin.wallet_core.d.e bLv = o.bLv();
            String str = "select * from WalletFunciontList where wallet_region = " + i;
            Cursor a = bLv.gJP.a(str, null, 2);
            x.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo " + str);
            if (a != null) {
                if (a.moveToNext()) {
                    obj = new t();
                    obj.b(a);
                }
                a.close();
            }
            if (obj != null) {
                this.okT.put(Integer.valueOf(i), obj);
            }
        }
        t tVar = (t) this.okT.get(Integer.valueOf(i));
        if (tVar == null) {
            return new t();
        }
        return tVar;
    }

    public final ArrayList<MallFunction> so(int i) {
        return sn(i).okM;
    }

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("mallactivity", this.okV, true);
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.okW, true);
        c.bMe().WT();
        com.tencent.mm.plugin.wallet_core.model.mall.d.bMi().WT();
        if (q.Gf() && q.Gb()) {
            b.zl(b.sQy);
        } else {
            b.zl(b.sQx);
        }
        g.Dk();
        g.Di().gPJ.a(HardCoderJNI.SCENE_QUIT_CHATTING, this);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("mallactivity", this.okV, true);
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.okW, true);
        g.Dk();
        g.Di().gPJ.b(HardCoderJNI.SCENE_QUIT_CHATTING, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i2 == 0 && i == 0 && !this.okU && q.Gf()) {
            this.okU = true;
            b.zl(b.sQy);
        }
    }
}
