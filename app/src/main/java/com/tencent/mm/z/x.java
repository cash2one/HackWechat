package com.tencent.mm.z;

import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bc;

public final class x {
    public static aq hB(String str) {
        return new aq("@black.android", null, str, null, true, true);
    }

    public static aq hC(String str) {
        ar.Hg();
        bc EY = c.Fg().EY("@t.qq.com");
        if (EY == null) {
            return null;
        }
        return new aq("@t.qq.com", null, str, null, EY.isEnable(), EY.cjS());
    }

    public static aq P(String str, String str2) {
        aq aqVar = null;
        if (str != null && str.length() > 0) {
            ar.Hg();
            bc EY = c.Fg().EY(str);
            if (EY != null) {
                if (EY.xzV == 1) {
                    String str3 = "@domain.android";
                    String str4 = EY.name;
                    String XH = EY.xzU.XH("");
                    String str5 = "";
                    if (XH != null) {
                        str5 = str5 + XH.replace("@", "");
                    }
                    if (str2 != null) {
                        str5 = str5 + str2;
                    }
                    aqVar = new aq(str3, str4, str5, EY.xzU.XH(""), EY.isEnable(), true);
                }
            }
        }
        return aqVar;
    }
}
