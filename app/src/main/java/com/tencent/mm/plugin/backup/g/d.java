package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.aq.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.a.a;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class d extends a {
    private static String TAG = "MicroMsg.BackupStorageModel";
    private static d kpW;
    private b kpX;
    private a kpY;

    public static d aqe() {
        if (kpW == null) {
            a dVar = new d();
            kpW = dVar;
            a(dVar);
        }
        return kpW;
    }

    public final void aog() {
        kpW = null;
    }

    public final b aqf() {
        if (this.kpX == null) {
            this.kpX = new b();
        }
        return this.kpX;
    }

    public final a aqg() {
        if (this.kpY == null) {
            this.kpY = new a();
        }
        return this.kpY;
    }

    public final void aqh() {
        x.i(TAG, "backupInitStorage");
        b aqf = aqf();
        ar.Hg();
        String FC = c.FC();
        ar.Hg();
        x.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[]{FC, Integer.valueOf(c.Cg()), bh.cgy()});
        aqf.uin = r2;
        aqf.gQi = FC;
        ar.Hg();
        aqf.gQj = c.EV();
        ar.Hg();
        aqf.kpK = c.CU();
        ar.Hg();
        aqf.kpL = c.EY();
        ar.Hg();
        aqf.kpN = c.Fd();
        ar.Hg();
        aqf.kpM = c.Fa();
        ar.Hg();
        aqf.kpQ = c.Fg();
        aqf.kpO = o.Pw();
        aqf.kpP = i.aBE().lwL;
        aqf.kpS = ((b) g.h(b.class)).Fh();
        aqf.kpR = com.tencent.mm.modelvideo.o.TU();
        aqf.kpT = com.tencent.mm.plugin.y.a.bio();
        aqf.kpU = com.tencent.mm.plugin.y.a.bin();
        aqf.kpV = com.tencent.mm.plugin.y.a.aqd();
    }
}
