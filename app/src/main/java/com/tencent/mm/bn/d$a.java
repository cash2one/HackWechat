package com.tencent.mm.bn;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class d$a {
    public int hJB = 0;
    public int hitCount = 0;

    public static String as(Map<String, d$a> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map != null) {
            try {
                if (map.size() > 0) {
                    stringBuilder.append("<voiptenmin>");
                    for (Entry entry : map.entrySet()) {
                        Object key = entry.getKey();
                        d$a com_tencent_mm_bn_d_a = (d$a) entry.getValue();
                        stringBuilder.append("<" + key);
                        stringBuilder.append(" hitcount = \"");
                        stringBuilder.append(com_tencent_mm_bn_d_a.hitCount);
                        stringBuilder.append("\"");
                        stringBuilder.append(" sendcount = \"");
                        stringBuilder.append(com_tencent_mm_bn_d_a.hJB);
                        stringBuilder.append("\"");
                        stringBuilder.append("/>");
                    }
                    stringBuilder.append("</voiptenmin>");
                }
            } catch (Throwable e) {
                x.e("PostTaskTenMinutesLogicState", "exception:%s", new Object[]{bh.i(e)});
                return null;
            }
        }
        x.d("PostTaskTenMinutesLogicState", "mapToXml " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static Map<String, d$a> Tk(String str) {
        Throwable th;
        Map<String, d$a> map = null;
        x.d("PostTaskTenMinutesLogicState", "xml " + str);
        if (str == null) {
            return null;
        }
        try {
            Map y = bi.y(str, "voiptenmin");
            if (y == null || y.size() <= 0) {
                return null;
            }
            Map<String, d$a> hashMap = new HashMap();
            try {
                for (Entry entry : y.entrySet()) {
                    String str2 = (String) entry.getKey();
                    if (str2 == null) {
                        break;
                    }
                    String[] split = str2.split("\\.");
                    x.d("PostTaskTenMinutesLogicState", "key is " + str2);
                    x.d("PostTaskTenMinutesLogicState", "array is " + split.length);
                    if (str2 != null && split.length >= 4) {
                        d$a com_tencent_mm_bn_d_a;
                        x.d("PostTaskTenMinutesLogicState", "getValue is " + ((String) entry.getValue()) + "array[1] " + split[2]);
                        if (hashMap.containsKey(split[2])) {
                            com_tencent_mm_bn_d_a = (d$a) hashMap.get(split[2]);
                        } else {
                            com_tencent_mm_bn_d_a = new d$a();
                        }
                        if (str2.contains("hitcount")) {
                            com_tencent_mm_bn_d_a.hitCount = bh.getInt((String) entry.getValue(), 0);
                        } else if (str2.contains("sendcount")) {
                            com_tencent_mm_bn_d_a.hJB = bh.getInt((String) entry.getValue(), 0);
                        }
                        x.d("PostTaskTenMinutesLogicState", "hitCount " + com_tencent_mm_bn_d_a.hitCount + "sendCount " + com_tencent_mm_bn_d_a.hJB);
                        hashMap.put(split[2], com_tencent_mm_bn_d_a);
                    }
                }
                return hashMap;
            } catch (Throwable e) {
                th = e;
                map = hashMap;
            }
        } catch (Exception e2) {
            th = e2;
            x.e("PostTaskTenMinutesLogicState", "exception:%s", new Object[]{bh.i(th)});
            return map;
        }
    }
}
