package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;

public final class am {
    private static final Map<String, String> qXm = new HashMap();

    public static String r(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        String str3;
        boolean equals = Looper.getMainLooper().equals(Looper.myLooper());
        if (equals && qXm.containsKey(str + str2)) {
            str3 = (String) qXm.get(str + str2);
            if (!bh.ov(str3)) {
                return str3;
            }
        }
        str3 = g.s(str2.getBytes());
        StringBuffer stringBuffer = new StringBuffer(str);
        if (str3.length() > 0) {
            stringBuffer.append(str3.charAt(0));
            stringBuffer.append("/");
        }
        if (str3.length() >= 2) {
            stringBuffer.append(str3.charAt(1));
            stringBuffer.append("/");
        }
        if (equals) {
            qXm.put(str + str2, stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public static synchronized void release() {
        synchronized (am.class) {
            qXm.clear();
        }
    }
}
