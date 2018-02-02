package com.tencent.mm.plugin.i.a;

import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    protected final List<a> J(au auVar) {
        String str = null;
        if (auVar == null) {
            return null;
        }
        g$a fT;
        String VH = bh.VH(auVar.field_content);
        if (VH != null) {
            fT = g$a.fT(VH);
        } else {
            fT = null;
        }
        if (fT == null) {
            x.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
            return null;
        }
        a K = K(auVar);
        com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(fT.fny);
        long j = 0;
        if (Rz != null) {
            str = Rz.field_fileFullPath;
            j = (long) e.bN(str);
        }
        K.field_msgSubType = 30;
        K.field_path = vS(str);
        K.field_size = j;
        VH = o.Pw().B(auVar.field_imgPath, true);
        long bN = (long) e.bN(VH);
        a K2 = K(auVar);
        K2.field_msgSubType = 31;
        K2.field_path = vS(VH);
        K2.field_size = bN;
        x.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[]{asP(), K, K2});
        List<a> arrayList = new ArrayList();
        arrayList.add(K);
        arrayList.add(K2);
        return arrayList;
    }

    protected final String asP() {
        return "AppMsgImg_" + hashCode();
    }
}
