package com.tencent.mm.aw;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.x.a;
import com.tencent.mm.protocal.c.bnw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;

public final class d implements e {
    public a hIq = null;

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.NewTipsManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 597 && i == 0 && i2 == 0) {
            boolean z = ((a) kVar).hHZ;
            ay Dr = a.bfn().Dr(((a) kVar).hIa);
            if (Dr != null) {
                Dr.field_isReject = z;
                x.i("MicroMsg.NewTipsManager", "Newtips push is reject: %s", new Object[]{Boolean.valueOf(z)});
                a.bfn().a(Dr, new String[0]);
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, String str2) {
        ay Dr = a.bfn().Dr(i);
        if (Dr == null) {
            Dr = new ay();
            Dr.field_tipId = i;
            Dr.field_tipVersion = 1;
            Dr.field_tipkey = str;
            Dr.field_tipType = i3;
            if (Dr.field_tipsShowInfo == null) {
                Dr.field_tipsShowInfo = new bnw();
            }
            Dr.field_tipsShowInfo.path = str2;
            a.bfn().d(Dr);
            if (i3 != b.hIb) {
                return;
            }
            if (!Dr.field_isExit || 1 != Dr.field_tipVersion) {
                g.CG().a(new a(i, 1, str), 0);
                x.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
                return;
            }
            return;
        }
        if (i3 == b.hIb && !(Dr.field_isExit && 1 == Dr.field_tipVersion)) {
            g.CG().a(new a(i, 1, str), 0);
            x.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
        }
        if ((i3 == b.hIb && 1 != Dr.field_tipVersion) || (i3 == b.hIc && Dr.field_tipVersion <= 0)) {
            Dr.field_tipId = i;
            Dr.field_tipVersion = 1;
            Dr.field_tipkey = str;
            Dr.field_tipType = i3;
            Dr.field_isExit = false;
            if (Dr.field_tipsShowInfo == null) {
                Dr.field_tipsShowInfo = new bnw();
            }
            Dr.field_tipsShowInfo.path = str2;
            a.bfn().a(Dr, new String[0]);
        }
    }

    public static void ih(int i) {
        ay Dr = a.bfn().Dr(i);
        if (Dr == null) {
            x.e("MicroMsg.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
            return;
        }
        x.i("MicroMsg.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(true)});
        if (Dr.field_tipType == b.hIb) {
            Dr.field_hadRead = true;
            a.bfn().a(Dr, new String[0]);
        }
        if (Dr.field_tipType == b.hIc) {
            az bfn = a.bfn();
            String str = "delete from NewTipsInfo where tipId = " + Dr.field_tipId;
            x.i("MicroMsg.NewTipsInfoStorage", "delete sql: " + str);
            bfn.gJP.fx("NewTipsInfo", str);
            bfn.b(Dr.field_tipId, 5, Integer.valueOf(Dr.field_tipId));
        }
    }
}
