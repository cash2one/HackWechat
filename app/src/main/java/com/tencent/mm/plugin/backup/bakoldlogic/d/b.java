package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.by.h;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.backup.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c.1;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c.2;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.t;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashMap;
import junit.framework.Assert;

public final class b extends a {
    private static b ksg;
    private static int ksj = 0;
    private c ksh;
    private a ksi;
    private c ksk;

    static /* synthetic */ void aqP() {
        long Wp = bh.Wp();
        ar.Hg();
        c.ES();
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        String stringBuilder2 = stringBuilder.append(c.CR()).append(".tem").toString();
        ar.Hg();
        k.q(stringBuilder2, c.CR(), false);
        stringBuilder = new StringBuilder();
        ar.Hg();
        stringBuilder2 = stringBuilder.append(c.CS()).append(".tem").toString();
        ar.Hg();
        k.q(stringBuilder2, c.CS(), false);
        stringBuilder = new StringBuilder();
        ar.Hg();
        stringBuilder2 = stringBuilder.append(c.CS()).append(".tem-journal").toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        ar.Hg();
        k.q(stringBuilder2, stringBuilder3.append(c.CS()).append("-journal").toString(), false);
        stringBuilder = new StringBuilder();
        ar.Hg();
        stringBuilder2 = stringBuilder.append(c.CS()).append(".tem-wal").toString();
        stringBuilder3 = new StringBuilder();
        ar.Hg();
        k.q(stringBuilder2, stringBuilder3.append(c.CS()).append("-wal").toString(), false);
        com.tencent.mm.sdk.b.a.xef.m(new bl());
        g.Dh().release();
        g.Dh().initialize();
        aqO();
        aqM();
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDbImp finish cost time[%d]", new Object[]{Long.valueOf(bh.bz(Wp))});
    }

    static /* synthetic */ int vC() {
        int i = ksj;
        ksj = i + 1;
        return i;
    }

    static /* synthetic */ int vD() {
        int i = ksj;
        ksj = i - 1;
        return i;
    }

    public static b aqJ() {
        if (ksg == null) {
            a bVar = new b();
            ksg = bVar;
            a(bVar);
        }
        return ksg;
    }

    public final void aog() {
        ksg = null;
    }

    public final c aqK() {
        if (this.ksh == null) {
            this.ksh = new c();
        }
        return this.ksh;
    }

    public final a aqL() {
        if (this.ksi == null) {
            this.ksi = new a();
        }
        return this.ksi;
    }

    private static void aqM() {
        com.tencent.mm.sdk.b.a.xef.m(new z());
    }

    private c aqN() {
        if (this.ksk == null) {
            this.ksk = new c();
        }
        return this.ksk;
    }

    public final void a(a aVar) {
        long Wp = bh.Wp();
        x.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", new Object[]{Boolean.valueOf(false), bh.cgy()});
        ag.h(new 1(this, Wp, aVar, -1), 1000);
    }

    private boolean a(PLong pLong, PLong pLong2, PLong pLong3, a aVar, int i) {
        ar.Hg();
        c.ES();
        x.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
        ar.Hg();
        int bN = e.bN(c.CR());
        ar.Hg();
        pLong3.value = (long) (bN + e.bN(c.CS()));
        long j = pLong3.value;
        ar.Hg();
        if (com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(j, pLong, pLong2, c.FC())) {
            ar.Hg();
            String CR = c.CR();
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            k.q(CR, stringBuilder.append(c.CR()).append(".tem").toString(), false);
            ar.Hg();
            CR = c.CS();
            stringBuilder = new StringBuilder();
            ar.Hg();
            k.q(CR, stringBuilder.append(c.CS()).append(".tem").toString(), false);
            StringBuilder stringBuilder2 = new StringBuilder();
            ar.Hg();
            CR = stringBuilder2.append(c.CS()).append("-journal").toString();
            stringBuilder = new StringBuilder();
            ar.Hg();
            k.q(CR, stringBuilder.append(c.CS()).append(".tem-journal").toString(), false);
            stringBuilder2 = new StringBuilder();
            ar.Hg();
            CR = stringBuilder2.append(c.CS()).append("-wal").toString();
            stringBuilder = new StringBuilder();
            ar.Hg();
            k.q(CR, stringBuilder.append(c.CS()).append(".tem-wal").toString(), false);
            x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
            g.Dh().release();
            g.Dh().initialize();
            x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
            c aqN = aqN();
            ar.Hg();
            String FC = c.FC();
            ar.Hg();
            x.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[]{FC, Integer.valueOf(c.Cg())});
            aqN.uin = r2;
            aqN.gQi = FC;
            x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
            c aqN2 = aqN();
            stringBuilder2 = new StringBuilder();
            ar.Hg();
            FC = stringBuilder2.append(c.CR()).append(".tem").toString();
            ar.Hg();
            int Cg = c.Cg();
            stringBuilder2 = new StringBuilder();
            ar.Hg();
            x.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[]{aqN2.ksy, FC, Integer.valueOf(Cg), stringBuilder2.append(c.CS()).append(".tem").toString(), bh.cgy()});
            if (aqN2.gQj != null) {
                x.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
            }
            if (i > 0) {
                if (!(aqN2.ksy == null || aqN2.ksy.booleanValue())) {
                    x.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
                    aqN2.aqQ();
                }
                Assert.assertTrue("bakoldInitDB here  isTempDb should null :" + aqN2.ksy, aqN2.ksy == null);
            }
            aqN2.ksy = Boolean.valueOf(true);
            aqN2.gQj = new h(new 2(aqN2));
            if (aqN2.gQj.a(FC, r2, "", (long) Cg, q.yE(), new HashMap(), false)) {
                aqN2.kpK = new t(aqN2.gQj);
                i iVar = (i) g.h(i.class);
                aqN2.kpL = iVar.d(aqN2.gQj);
                aqN2.kpN = iVar.e(aqN2.gQj);
                aqN2.kpM = iVar.a(aqN2.gQj, aqN2.kpL, aqN2.kpN);
                aqN2.kpM.a(new am(aqN2.kpM));
                aqN2.kpM.a(new o(aqN2.kpM));
                aqN2.kpQ = iVar.f(aqN2.gQj);
                aqN2.kpO = new com.tencent.mm.aq.g(aqN2.gQj);
                if (d.OQ("emoji")) {
                    aqN2.kpP = new com.tencent.mm.storage.emotion.d(aqN2.gQj);
                }
                aqN2.kpS = ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).c(aqN2.gQj);
                aqN2.kpR = new s(aqN2.gQj);
                aqN2.kpT = new com.tencent.mm.pluginsdk.model.app.k(aqN2.gQj);
                aqN2.kpU = new com.tencent.mm.pluginsdk.model.app.i(aqN2.gQj);
                aqN2.kpV = new com.tencent.mm.pluginsdk.model.app.c(aqN2.gQj);
                aqN2.ksw = new be(aqN2.kpK);
                aqN2.ksw.c(new 1(aqN2));
                aqN2.ksw.cjT();
                x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
                aqM();
                aVar.kst = true;
                aVar.ksu = pLong.value;
                aVar.ksv = pLong2.value;
                aVar.dbSize = pLong3.value;
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.vz(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aqi());
                return true;
            }
            throw new com.tencent.mm.z.b((byte) 0);
        }
        x.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[]{Long.valueOf(pLong3.value)});
        aVar.kst = false;
        aVar.ksu = pLong.value;
        aVar.ksv = pLong2.value;
        aVar.dbSize = pLong3.value;
        return false;
    }

    public static void aqO() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.CR()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        ar.Hg();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.CR()).append(".ini.tem").toString());
        stringBuilder = new StringBuilder();
        ar.Hg();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.CS()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        ar.Hg();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.CS()).append(".ini.tem").toString());
    }

    public final void a(Runnable runnable, int i) {
        if (i < 0 || ksj == 0) {
            if (i < 0) {
                x.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
            }
            x.i("MicroMsg.BakOldTempDbModel", "closeDB before");
            aqN().aqQ();
            x.i("MicroMsg.BakOldTempDbModel", "closeDB after");
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        new af(Looper.getMainLooper()).postDelayed(new 3(this, runnable, i), 500);
    }
}
