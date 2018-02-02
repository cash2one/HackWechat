package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.g.a.sb;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class i extends c<sb> {
    public i() {
        this.xen = sb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        List list = ((sb) bVar).fJN.fJO;
        if (list == null || list.size() <= 0) {
            x.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty mass send top config package");
        } else {
            byte[] a = n.a(((avi) list.get(0)).vHV);
            if (!(a == null || a.length == 0)) {
                String str = new String(a);
                x.i("MicroMsg.UpdateMassSendPlaceTopListener", "MassSendTopConfXml:" + str);
                h.aYE().Ef(str);
            }
        }
        return false;
    }
}
