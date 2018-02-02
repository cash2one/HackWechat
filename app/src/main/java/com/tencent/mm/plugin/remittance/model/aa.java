package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class aa {
    public static void Is(String str) {
        if (!bh.ov(str)) {
            String bnB = bnB();
            x.d("Micromsg.RemittanceLogic", "cur friendsListStr=" + bnB);
            StringBuilder stringBuilder = new StringBuilder();
            if (!bh.ov(bnB)) {
                String[] split = bnB.split(",");
                if (split != null) {
                    int i = 0;
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (!str.equals(split[i2])) {
                            stringBuilder.append(split[i2]);
                            stringBuilder.append(",");
                            i++;
                            if (i >= 4) {
                                break;
                            }
                        }
                    }
                }
            }
            stringBuilder.insert(0, ",");
            stringBuilder.insert(0, str);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            x.d("Micromsg.RemittanceLogic", "new friendsListStr=" + stringBuilder.toString());
            g.Dk();
            g.Dj().CU().set(327733, stringBuilder.toString());
            g.Dk();
            g.Dj().CU().lH(true);
        }
    }

    public static String bnB() {
        g.Dk();
        return bh.ou((String) g.Dj().CU().get(327733, null));
    }
}
