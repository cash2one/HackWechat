package com.tencent.mm.plugin.i.a;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    protected final List<a> J(au auVar) {
        if (auVar == null) {
            return null;
        }
        o.TU();
        String nt = s.nt(auVar.field_imgPath);
        long bN = (long) com.tencent.mm.a.e.bN(nt);
        a K = K(auVar);
        K.field_msgSubType = 1;
        K.field_path = vS(nt);
        K.field_size = bN;
        o.TU();
        nt = s.nu(auVar.field_imgPath);
        bN = (long) com.tencent.mm.a.e.bN(nt);
        a K2 = K(auVar);
        K2.field_msgSubType = 2;
        K2.field_path = vS(nt);
        K2.field_size = bN;
        x.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[]{asP(), K, K2});
        List<a> arrayList = new ArrayList();
        arrayList.add(K);
        arrayList.add(K2);
        return arrayList;
    }

    protected final String asP() {
        return "video_" + hashCode();
    }
}
