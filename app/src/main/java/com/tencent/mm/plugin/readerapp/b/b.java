package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bf;
import com.tencent.mm.z.q;

public final class b {
    public static boolean a(cf cfVar, bf bfVar, int i) {
        if (cfVar == null || bfVar == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
            if (cfVar != null) {
                cfVar.fqp.fqv = R.l.efh;
            }
            return false;
        }
        String v;
        ve veVar = new ve();
        vk vkVar = new vk();
        uq uqVar = new uq();
        vkVar.Ui("newsapp");
        vkVar.Uj(q.FS());
        vkVar.Uj(q.FS());
        vkVar.CS(1);
        vkVar.fC(bfVar.hhh);
        vkVar.Um(bfVar.hhm);
        vkVar.Up(bfVar.getUrl());
        vkVar.Uq("newsapp");
        uqVar.TI(String.valueOf(bfVar.hhm));
        if (i == 0) {
            v = t.v(bfVar.HL(), bfVar.type, "@T");
        } else {
            v = t.v(bfVar.HL(), bfVar.type, "@S");
        }
        if (FileOp.bO(v)) {
            uqVar.TF(v);
        } else {
            uqVar.lt(true);
            uqVar.Tz(bfVar.HL());
            vt vtVar = new vt();
            vtVar.Uy(bfVar.HL());
            veVar.b(vtVar);
        }
        uqVar.CJ(5);
        uqVar.Tq(bfVar.getTitle());
        uqVar.Tr(bfVar.HM());
        uqVar.ls(true);
        veVar.a(vkVar);
        veVar.weU.add(uqVar);
        cfVar.fqp.desc = bfVar.getTitle();
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 5;
        return true;
    }
}
