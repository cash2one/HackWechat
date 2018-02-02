package com.tencent.mm.bn;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private static final Map<Integer, Integer> vzV = new HashMap();

    public static void run() {
        ar.Hg();
        if ((bh.by(bh.a((Long) c.CU().get(66819, null), 0)) * 1000 > 1800000 ? 1 : null) != null) {
            Ti("");
        }
    }

    public static void CC(int i) {
        vzV.put(Integer.valueOf(i), Integer.valueOf(bh.e((Integer) vzV.get(Integer.valueOf(i))) + 1));
    }

    public static String ccX() {
        String str = "[a=" + (ar.Hg() == null ? "0" : "1") + " ";
        if (ar.Hg() == null) {
            return str;
        }
        StringBuilder append = new StringBuilder().append(str).append("c=");
        ar.Hg();
        return append.append(c.CU() == null ? "0" : "1").append(" ").toString() + "u=" + (ar.Hj() ? "1" : "0") + "]";
    }

    public static void Ti(String str) {
        String str2 = str + ccX();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : vzV.entrySet()) {
            if (!(entry == null || entry.getKey() == null || entry.getValue() == null || ((Integer) entry.getValue()).intValue() == 0)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append(entry.getValue());
                stringBuilder.append(',');
            }
        }
        vzV.clear();
        if (stringBuilder.length() > 0) {
            x.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
            bo.r(10, stringBuilder.toString());
        }
        x.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :" + (str2 + ccX()));
        try {
            ar.Hg();
            c.CU().set(66819, Long.valueOf(bh.Wo()));
        } catch (Exception e) {
            x.e("MicroMsg.PostTaskFMessageCardStat", "e:" + e.getMessage());
        }
    }
}
