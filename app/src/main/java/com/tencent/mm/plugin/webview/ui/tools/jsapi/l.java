package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.bh;

public final class l {
    static String a(i iVar, String str) {
        if (iVar.tJH == null || !iVar.tJH.containsKey(str)) {
            return "";
        }
        return String.valueOf(iVar.tJH.get(str));
    }

    private static String tZ(String str) {
        if (bh.ov(str)) {
            return "";
        }
        try {
            return bh.ou(p.encode(str));
        } catch (Exception e) {
            return "";
        }
    }

    public static Object[] h(Object[] objArr) {
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
