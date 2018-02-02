package com.tencent.mm.plugin.label;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c {
    public static String dc(String str, String str2) {
        x.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", new Object[]{str, str2});
        if (bh.ov(str2)) {
            return str;
        }
        if (bh.ov(str)) {
            return str2 + "\u0000";
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        if (bh.F(str.split(",")).contains(str2)) {
            return str + "\u0000";
        }
        return str + "," + str2 + "\u0000";
    }

    public static String dd(String str, String str2) {
        x.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", new Object[]{str, str2});
        if (bh.ov(str2)) {
            return str;
        }
        if (bh.ov(str)) {
            return "";
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        List F = bh.F(str.split(","));
        if (!F.contains(str2)) {
            return str;
        }
        F.remove(str2);
        return aY(F);
    }

    public static String aY(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append((String) list.get(i));
                if (i < size - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("\u0000");
        }
        return stringBuilder.toString();
    }
}
