package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.rp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ao$1 extends c<rp> {
    ao$1() {
        this.xen = rp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 1;
        rp rpVar = (rp) bVar;
        if (rpVar instanceof rp) {
            String str = rpVar.fJv.id;
            int i2 = rpVar.fJv.type;
            ao$a cd = ao.cd(str, i2);
            if (cd != null) {
                String str2 = rpVar.fJv.fJw;
                cd.qXz = str2;
                cd.fHV = rpVar.fJv.fHV;
                String str3 = "MicroMsg.SnsTranslateManager";
                String str4 = "finish translate, id:%s, type: %d, success: %b";
                Object[] objArr = new Object[3];
                objArr[0] = cd.id;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Boolean.valueOf(!bh.ov(str2));
                x.i(str3, str4, objArr);
                switch (i2) {
                    case 2:
                        break;
                    case 3:
                        i = 2;
                        break;
                    default:
                        i = -1;
                        break;
                }
                if (i != -1) {
                    ao.e(str, i, cd.qXz, cd.fHV);
                    ao.asA().remove(cd);
                }
            }
        }
        return false;
    }
}
