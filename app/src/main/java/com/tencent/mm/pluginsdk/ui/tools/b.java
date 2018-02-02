package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;

public final class b {
    public static boolean SK(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
            return false;
        }
        t CU = g.Dj().CU();
        if (CU == null) {
            x.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a((byte) 0);
        aVar.IC((String) CU.get(69121, null));
        if (!aVar.qjF.contains(str)) {
            aVar.qjF.add(str);
        }
        CU.set(69121, aVar.ccu());
        return true;
    }

    public static boolean SL(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
            return false;
        }
        t CU = g.Dj().CU();
        if (CU == null) {
            x.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a((byte) 0);
        aVar.IC((String) CU.get(69121, null));
        if (aVar.qjF.contains(str)) {
            aVar.qjF.remove(str);
        }
        CU.set(69121, aVar.ccu());
        return true;
    }
}
