package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;

public final class a {
    public static JSONArray kr(int i) {
        if (i <= 0) {
            return new JSONArray();
        }
        Collection arrayList = new ArrayList(3);
        if ((i & 1) == 1) {
            arrayList.add("fingerPrint");
        }
        if ((i & 8) == 8) {
            arrayList.add("facial");
        }
        if ((i & 2) == 2) {
            arrayList.add("speech");
        }
        x.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: final string is: %s", new Object[]{arrayList.toString()});
        return new JSONArray(arrayList);
    }

    public static String g(JSONArray jSONArray) {
        String str = "MicroMsg.AppBrandSoterTranslateUtil";
        String str2 = "hy: translating string array: %s";
        Object[] objArr = new Object[1];
        objArr[0] = jSONArray == null ? null : jSONArray.toString();
        x.i(str, str2, objArr);
        if (jSONArray == null || jSONArray.length() == 0) {
            return "0x00";
        }
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                i = (byte) (i | sk(jSONArray.getString(i2)));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandSoterTranslateUtil", e, "hy: json error in translate", new Object[0]);
            }
        }
        x.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", new Object[]{"0x" + Integer.toHexString(i)});
        return "0x" + Integer.toHexString(i);
    }

    public static int sk(String str) {
        if ("fingerPrint".equals(str)) {
            return 1;
        }
        if ("facial".equals(str)) {
            return 8;
        }
        if ("speech".equals(str)) {
            return 2;
        }
        x.e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
        return 0;
    }
}
