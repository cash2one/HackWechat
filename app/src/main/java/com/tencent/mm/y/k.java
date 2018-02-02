package com.tencent.mm.y;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.y.g.a;
import java.util.Map;

public final class k {
    public int hdZ;
    public int hea;

    public static final k fX(String str) {
        k kVar = new k();
        a I = a.I(str, null);
        if (I != null) {
            Map map = I.hdK;
            if (map != null) {
                kVar.hdZ = bh.getInt((String) map.get(".msg.appmsg.xmlfulllen"), 0);
                kVar.hea = bh.getInt((String) map.get(".msg.appmsg.realinnertype"), 0);
            }
        }
        return kVar;
    }
}
