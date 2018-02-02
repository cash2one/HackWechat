package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class i {
    public static boolean bpK() {
        c fn = com.tencent.mm.z.c.c.IF().fn("100027");
        if (fn.isValid()) {
            Map chI = fn.chI();
            if (chI == null) {
                x.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
                return false;
            } else if (chI.containsKey("showEntrance") && "1".equals(chI.get("showEntrance"))) {
                return true;
            } else {
                x.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
                return false;
            }
        }
        x.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
        return false;
    }
}
