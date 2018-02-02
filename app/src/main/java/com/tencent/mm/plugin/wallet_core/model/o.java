package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.by.h.d;
import com.tencent.mm.cd.g;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.td;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.d.a;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.h;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.b;
import com.tencent.mm.z.bs;
import com.tencent.mm.z.p;
import com.tencent.mm.z.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public class o implements ap {
    private static HashMap<Integer, d> gwY;
    private volatile q sOQ = new q();
    private g<ag> sOR = new g(new 1(this));
    private volatile aa sOS = null;
    private g<ad> sOT = new g(new 12(this));
    private g<j> sOU = new g(new 17(this));
    private g<c> sOV = new g(new 18(this));
    private g<a> sOW = new g(new 19(this));
    private g<f> sOX = new g(new 20(this));
    private g<com.tencent.mm.plugin.wallet_core.d.d> sOY = new g(new 21(this));
    private u sOZ = new u();
    private g<e> sPa = new g(new com.tencent.mm.cd.c<e>(this) {
        final /* synthetic */ o sPi;

        {
            this.sPi = r1;
        }

        public final /* synthetic */ Object get() {
            com.tencent.mm.kernel.g.Dk();
            return new e(com.tencent.mm.kernel.g.Dj().gQj);
        }
    });
    private g<i> sPb = new g(new com.tencent.mm.cd.c<i>(this) {
        final /* synthetic */ o sPi;

        {
            this.sPi = r1;
        }

        public final /* synthetic */ Object get() {
            com.tencent.mm.kernel.g.Dk();
            return new i(com.tencent.mm.kernel.g.Dj().gQj);
        }
    });
    private g<h> sPc = new g(new 2(this));
    private g<com.tencent.mm.plugin.wallet_core.d.g> sPd = new g(new 3(this));
    private com.tencent.mm.plugin.wallet_core.id_verify.util.a sPe = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    private com.tencent.mm.sdk.b.c sPf = new 4(this);
    private com.tencent.mm.sdk.b.c<td> sPg = new 5(this);
    private bs.a sPh = new 6(this);

    static {
        k.b("tenpay_utils", o.class.getClassLoader());
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new 7());
        gwY.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new 8());
        gwY.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new 9());
        gwY.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return f.gJN;
            }
        });
        gwY.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new 11());
        gwY.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new 13());
        gwY.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new 14());
        gwY.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new 15());
        gwY.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new 16());
    }

    public static o bLl() {
        return (o) p.s(o.class);
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public static j bLm() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (j) bLl().sOU.get();
        }
        throw new b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.g bLn() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (com.tencent.mm.plugin.wallet_core.d.g) bLl().sPd.get();
        }
        throw new b();
    }

    public static c bLo() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (c) bLl().sOV.get();
        }
        throw new b();
    }

    public static h bLp() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (h) bLl().sPc.get();
        }
        throw new b();
    }

    public static ag bLq() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (ag) bLl().sOR.get();
        }
        throw new b();
    }

    public static ad bLr() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (ad) bLl().sOT.get();
        }
        throw new b();
    }

    public static a bLs() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (a) bLl().sOW.get();
        }
        throw new b();
    }

    public static f bLt() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (f) bLl().sOX.get();
        }
        throw new b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.d bLu() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (com.tencent.mm.plugin.wallet_core.d.d) bLl().sOY.get();
        }
        throw new b();
    }

    public static e bLv() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (e) bLl().sPa.get();
        }
        throw new b();
    }

    public static i bLw() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return (i) bLl().sPb.get();
        }
        throw new b();
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public static aa bLx() {
        return bLl().sOS;
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreNfc", "onAccountPostReset subcore walletCore");
        com.tencent.mm.wallet_core.c.a.cBn();
        com.tencent.mm.wallet_core.c.a.init(ac.getContext());
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.sPh, true);
        bLq().bLV();
        this.sOS = aa.bLA();
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.sOS.lhZ, true);
        com.tencent.mm.sdk.b.a.xef.b(this.sPf);
        com.tencent.mm.sdk.b.a.xef.b(this.sOZ);
        com.tencent.mm.sdk.b.a.xef.a(this.sPg);
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[]{"//cleanpaycn"});
    }

    public final void onAccountRelease() {
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.sPh, true);
        bLq().aJh();
        ad bLr = bLr();
        bLr.sPV = null;
        bLr.sPU.clear();
        bLr.sPU = new ArrayList();
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.sOS.lhZ, true);
        if (aa.mhp != null) {
            aa.mhp.clear();
        }
        this.sOS = null;
        com.tencent.mm.sdk.b.a.xef.c(this.sPf);
        com.tencent.mm.sdk.b.a.xef.c(this.sOZ);
        com.tencent.mm.sdk.b.a.xef.c(this.sPg);
    }

    public static void t(Context context, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (q.Gg()) {
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            x.i("MicroMsg.SubCoreNfc", "entryWalletIndexPage wallet type is h5,jump to ibg");
            com.tencent.mm.bm.d.b(context, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", intent);
        } else if (q.Gh()) {
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            com.tencent.mm.bm.d.b(context, "mall", ".ui.MallIndexOSUI", intent);
        } else {
            x.i("MicroMsg.SubCoreNfc", "entryWalletIndexPage wallet type is native");
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            com.tencent.mm.bm.d.b(context, "mall", ".ui.MallIndexUI", intent);
            com.tencent.mm.kernel.g.Dk();
            if (com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
                com.tencent.mm.ae.k kVar = new com.tencent.mm.az.k(11);
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(kVar, 0);
            }
        }
    }

    public static q bLy() {
        return bLl().sOQ;
    }

    public static boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.c cVar, com.tencent.mm.plugin.wallet_core.id_verify.util.a.a aVar) {
        return bLl().sPe.a(mMActivity, cVar, false, 1008);
    }

    public static boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.c cVar) {
        return bLl().sPe.a(mMActivity, cVar, false, 1006);
    }
}
