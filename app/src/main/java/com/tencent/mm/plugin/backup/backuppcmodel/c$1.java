package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$1 implements e {
    final /* synthetic */ c knN;

    c$1(c cVar) {
        this.knN = cVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(595, c.a(this.knN));
        if (i == 0 && i2 == 0) {
            abb apY = ((com.tencent.mm.plugin.backup.f.e) kVar).apY();
            ar.Hg();
            if (!bh.ou((String) c.CU().get(2, null)).equals(apY.vJR)) {
                x.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
                b.aps().aol().kiJ = -5;
                b.aps().apu().mK(-5);
                g.pQN.a(400, 112, 1, false);
                return;
            } else if (apY.vJP == null || apY.vJP.size() <= 0 || apY.vJP.getFirst() == null) {
                r2 = "MicroMsg.BackupPcProcessMgr";
                String str2 = "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(apY.vJO);
                objArr[1] = apY.vJP == null ? "null" : apY.vJP.size();
                x.e(r2, str2, objArr);
                b.aps().aol().kiJ = -5;
                b.aps().apu().mK(-5);
                g.pQN.a(400, 113, 1, false);
                return;
            } else {
                ov ovVar = (ov) apY.vJP.getFirst();
                r2 = ovVar.vXG;
                int intValue = ((Integer) ovVar.vXH.getFirst()).intValue();
                c cVar = this.knN;
                cVar.knE = apY.vJS;
                cVar.knF = r2;
                cVar.knG = intValue;
                x.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[]{Integer.valueOf(apY.ktN), Integer.valueOf(apY.rYW), apY.vJS, r2, Integer.valueOf(intValue)});
                b.aps().kiB = apY.ID;
                b.aps().kiC = apY.vJY;
                b.aps().kiD = apY.vJZ;
                b.aps().kiH = apY.vJC.wJD.oz;
                c.b(this.knN);
                return;
            }
        }
        x.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        g.pQN.a(400, 111, 1, false);
        if (i == 4 && i2 == -2011) {
            x.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
        }
        b.aps().aol().kiJ = -5;
        b.aps().apu().mK(-5);
    }
}
