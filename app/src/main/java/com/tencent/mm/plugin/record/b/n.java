package com.tencent.mm.plugin.record.b;

import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class n implements ap {
    private static HashMap<Integer, d> gwY;
    private k pFA = null;
    private d pFB = null;
    private l pFC = new l();
    private c pFD = new c<mc>(this) {
        final /* synthetic */ n pFE;

        {
            this.pFE = r2;
            this.xen = mc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mc mcVar = (mc) bVar;
            String str = mcVar.fDK.fCs;
            long j = mcVar.fDK.fpG;
            Iterator it = h.Ik(str).hdX.iterator();
            String str2 = "";
            while (it.hasNext()) {
                str2 = str2 + h.c((uq) it.next(), j) + ":";
            }
            mcVar.fDL.fDM = str2;
            return true;
        }
    };

    private static n bmR() {
        ar.Ha();
        n nVar = (n) bp.hY("plugin.record");
        if (nVar != null) {
            return nVar;
        }
        Object nVar2 = new n();
        ar.Ha().a("plugin.record", nVar2);
        return nVar2;
    }

    public static e bmS() {
        return ((a) g.k(a.class)).getRecordMsgInfoStorage();
    }

    public static com.tencent.mm.plugin.record.a.d getRecordMsgCDNStorage() {
        return ((a) g.k(a.class)).getRecordMsgCDNStorage();
    }

    public static k bmT() {
        g.Dh().Ct();
        if (bmR().pFA == null) {
            bmR().pFA = new k();
        }
        return bmR().pFA;
    }

    public static d bmU() {
        g.Dh().Ct();
        if (bmR().pFB == null) {
            bmR().pFB = new d();
        }
        return bmR().pFB;
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return e.gJN;
            }
        });
        gwY.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new 3());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.d("MicroMsg.SubCoreRecordMsg", "on account post reset");
        com.tencent.mm.sdk.b.a.xef.b(this.pFC);
        com.tencent.mm.sdk.b.a.xef.b(this.pFD);
        ar.Hg();
        File file = new File(com.tencent.mm.z.c.Fw());
        if (!file.exists() || !file.isDirectory()) {
            x.d("MicroMsg.SubCoreRecordMsg", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreRecordMsg", "on account post release");
        com.tencent.mm.sdk.b.a.xef.c(this.pFC);
        com.tencent.mm.sdk.b.a.xef.c(this.pFD);
        Object obj = bmR().pFA;
        if (obj != null) {
            obj.finish();
            ar.CG().b(632, obj);
            getRecordMsgCDNStorage().b(obj);
        }
        c cVar = bmR().pFB;
        if (cVar != null) {
            cVar.finish();
        }
    }
}
