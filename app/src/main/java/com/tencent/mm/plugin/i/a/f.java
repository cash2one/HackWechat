package com.tencent.mm.plugin.i.a;

import com.tencent.mm.a.e;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    protected final List<a> J(au auVar) {
        if (auVar == null) {
            return null;
        }
        a K = K(auVar);
        String fullPath = q.getFullPath(auVar.field_imgPath);
        long bN = (long) e.bN(fullPath);
        K.field_msgSubType = 10;
        K.field_path = vS(fullPath);
        K.field_size = bN;
        x.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[]{asP(), K});
        List<a> arrayList = new ArrayList();
        arrayList.add(K);
        return arrayList;
    }

    protected final String asP() {
        return "voice_" + hashCode();
    }
}
