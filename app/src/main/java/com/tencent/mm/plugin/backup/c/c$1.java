package com.tencent.mm.plugin.backup.c;

import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$1 implements e {
    final /* synthetic */ c klx;

    c$1(c cVar) {
        this.klx = cVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(595, c.a(this.klx));
        if (i == 0 && i2 == 0) {
            abb apY = ((com.tencent.mm.plugin.backup.f.e) kVar).apY();
            ar.Hg();
            if (bh.ou((String) c.CU().get(2, null)).equals(apY.vJR)) {
                String str2;
                b.aoR().kiB = apY.ID;
                b.aoR().kiC = apY.vJY;
                b.aoR().kiD = apY.vJZ;
                b.a(this.klx.klu);
                b.aoR().aom();
                b.a(b.aoR().aoU());
                b.a(b.aoR().aoS());
                b.mA(2);
                b.a(c.b(this.klx));
                b.a(c.c(this.klx));
                int i3 = 0;
                if (apY.vJO > 0) {
                    ov ovVar = (ov) apY.vJP.getFirst();
                    String str3 = ovVar.vXG;
                    i3 = ((Integer) ovVar.vXH.getFirst()).intValue();
                    str2 = str3;
                } else {
                    x.e("MicroMsg.BackupMoveRecoverServer", "summerbak address convMsgCount is empty");
                    str2 = null;
                }
                c cVar = this.klx;
                cVar.klk = apY.vJS;
                cVar.kll = str2;
                cVar.klm = i3;
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[]{Integer.valueOf(apY.ktN), Integer.valueOf(apY.rYW), apY.vJS, str2, Integer.valueOf(i3)});
                d.mA(22);
                b.aoR().aol().kiJ = 1;
                Intent className = new Intent().setClassName(ac.getContext(), "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "backup_move_notification");
                ac.getContext().startActivity(className);
                g.pQN.a(485, 41, 1, false);
                c.dE(false);
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[]{str2, apY.vJS, com.tencent.mm.plugin.backup.a.g.cl(ac.getContext())});
                c.apb();
                c.a(this.klx, str2, i3);
                return;
            }
            x.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnectinfo not the same account");
            b.aoR().aol().kiJ = -5;
            this.klx.mz(-5);
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info other error [%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 4 && i2 == -2011) {
            x.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info: INVALID URL");
        }
        b.aoR().aol().kiJ = -5;
        this.klx.mz(-5);
    }
}
