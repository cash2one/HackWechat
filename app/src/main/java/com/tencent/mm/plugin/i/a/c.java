package com.tencent.mm.plugin.i.a;

import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    protected final List<a> J(au auVar) {
        long j = 0;
        String str = null;
        if (auVar == null) {
            return null;
        }
        g.a fT;
        String VH = bh.VH(auVar.field_content);
        if (VH != null) {
            fT = g.a.fT(VH);
        } else {
            fT = null;
        }
        if (fT == null) {
            x.e("MicroMsg.AppMsgMsgHandler", "content is null");
            return null;
        }
        int i;
        a K = a.K(auVar);
        b Rz;
        switch (fT.type) {
            case 2:
                Rz = an.aqd().Rz(fT.fny);
                if (Rz != null) {
                    str = Rz.field_fileFullPath;
                    j = (long) e.bN(str);
                }
                K.field_msgSubType = 30;
                K.field_path = vS(str);
                K.field_size = j;
                i = 31;
                break;
            case 6:
                Rz = an.aqd().Rz(fT.fny);
                if (Rz != null) {
                    str = Rz.field_fileFullPath;
                    j = (long) e.bN(str);
                }
                K.field_msgSubType = 34;
                K.field_path = vS(str);
                K.field_size = j;
                i = 35;
                break;
            case 7:
                Rz = an.aqd().Rz(fT.fny);
                if (Rz != null) {
                    str = Rz.field_fileFullPath;
                    j = (long) e.bN(str);
                }
                K.field_msgSubType = 32;
                K.field_path = vS(str);
                K.field_size = j;
                i = 33;
                break;
            default:
                return null;
        }
        String B = o.Pw().B(auVar.field_imgPath, true);
        long bN = (long) e.bN(B);
        a K2 = a.K(auVar);
        K2.field_msgSubType = i;
        K2.field_path = vS(B);
        K2.field_size = bN;
        x.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[]{asP(), K, K2});
        List<a> arrayList = new ArrayList();
        arrayList.add(K);
        arrayList.add(K2);
        return arrayList;
    }

    protected final String asP() {
        return "AppMsg_" + hashCode();
    }
}
