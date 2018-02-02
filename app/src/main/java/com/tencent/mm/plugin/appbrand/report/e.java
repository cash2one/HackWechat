package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    private static String tZ(String str) {
        if (bh.ov(str)) {
            return "";
        }
        try {
            return bh.ou(p.encode(str));
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", new Object[]{str, e});
            return "";
        }
    }

    public static Object[] h(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return new Object[0];
        }
        Object[] objArr2 = new Object[objArr.length];
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            if (obj == null) {
                obj = "";
            } else if ((obj instanceof String) && (((String) obj).contains(",") || ((String) obj).contains("/"))) {
                obj = tZ((String) obj);
            }
            int i3 = i2 + 1;
            objArr2[i2] = String.valueOf(obj);
            i++;
            i2 = i3;
        }
        return objArr2;
    }
}
