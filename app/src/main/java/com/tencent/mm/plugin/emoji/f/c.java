package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gJT;
    public int hyU;
    private List<String> lyz;

    public c(int i, List<String> list) {
        a aVar = new a();
        aVar.hmj = new ej();
        aVar.hmk = new ek();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
        aVar.hmi = 698;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.hyU = i;
        this.lyz = list;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i3 == -434) {
            x.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xng, Boolean.valueOf(true));
            g.pQN.a(164, 7, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xng, Boolean.valueOf(false));
            if (this.hyU == 1) {
                g.pQN.a(164, 5, 1, false);
            } else {
                g.pQN.a(164, 8, 1, false);
            }
        } else if (this.hyU == 1) {
            g.pQN.a(164, 6, 1, false);
        } else {
            g.pQN.a(164, 9, 1, false);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 698;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        ej ejVar = (ej) this.gJQ.hmg.hmo;
        ejVar.vJL = this.hyU;
        ejVar.vJK = new LinkedList(this.lyz);
        if (ejVar.vJK == null || ejVar.vJK.size() <= 0) {
            x.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
        } else {
            x.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[]{Integer.valueOf(ejVar.vJK.size())});
            for (int i = 0; i < ejVar.vJK.size(); i++) {
                x.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[]{ejVar.vJK.get(i)});
            }
        }
        return a(eVar, this.gJQ, this);
    }
}
