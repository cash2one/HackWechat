package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;

class b$1 extends c<mj> {
    final /* synthetic */ b ifC;

    b$1(b bVar) {
        this.ifC = bVar;
        super(0);
        this.xen = mj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mj mjVar = (mj) bVar;
        String str = "MicroMsg.SubCoreAA";
        String str2 = "receiveAANewXmlEventListener, content==null: %s, type: %s, fromUser: %s, toUser: %s, paymsgid: %s";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(mjVar.fEm.content == null);
        objArr[1] = Integer.valueOf(mjVar.fEm.type);
        objArr[2] = mjVar.fEm.fzO;
        objArr[3] = mjVar.fEm.toUser;
        objArr[4] = mjVar.fEm.fEn;
        x.i(str, str2, objArr);
        if (mjVar.fEm.type == a.ige) {
            h.aD(mjVar.fEm.content, mjVar.fEm.toUser);
        } else if (mjVar.fEm.type == a.igf) {
            h.s(mjVar.fEm.content, mjVar.fEm.toUser, mjVar.fEm.fEn);
        } else if (mjVar.fEm.type == a.igg) {
            String str3 = mjVar.fEm.content;
            str = mjVar.fEm.toUser;
            x.i("MicroMsg.AAUtil", "insertUrgePaySysMsg, toUser: %s", new Object[]{str});
            if (!bh.ov(str3) && s.eV(str)) {
                cf auVar = new au();
                auVar.eR(0);
                auVar.dS(str);
                auVar.eQ(3);
                auVar.setContent(str3);
                auVar.aq(ba.n(str3, System.currentTimeMillis() / 1000));
                auVar.setType(10000);
                auVar.fa(auVar.field_flag | 8);
                auVar.ao(ba.i(auVar));
            }
        }
        return false;
    }
}
