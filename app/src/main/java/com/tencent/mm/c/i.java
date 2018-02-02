package com.tencent.mm.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class i {
    public String feh;
    private Map<String, a> fei = new HashMap();
    public int versionCode;

    public i(String str, int i) {
        if (str == null) {
            this.feh = "http://dldir1.qq.com/weixin/android/";
        } else {
            this.feh = str;
        }
        this.versionCode = i;
    }

    public final void a(a aVar) {
        this.fei.put(aVar.fej, aVar);
    }

    public final a ci(String str) {
        return (a) this.fei.get(str);
    }

    public final String tr() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[]{this.feh, Integer.valueOf(this.fei.size()), Integer.valueOf(this.versionCode)}));
        for (Entry value : this.fei.entrySet()) {
            a aVar = (a) value.getValue();
            stringBuilder.append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[]{aVar.fej, aVar.fek, aVar.fel, aVar.url, Integer.valueOf(aVar.size)}));
        }
        stringBuilder.append("</patchupdate>");
        return stringBuilder.toString();
    }

    public static i cj(String str) {
        Map y = f.y(str, "patchupdate");
        if (y == null) {
            return null;
        }
        i iVar = new i((String) y.get(".patchupdate.$base"), j.ck((String) y.get(".patchupdate.$versioncode")));
        int ck = j.ck((String) y.get(".patchupdate.$count"));
        int i = 0;
        while (i < ck) {
            Object obj;
            String str2 = ".patchupdate.item" + (i > 0 ? Integer.valueOf(i) : "");
            a aVar = new a((String) y.get(new StringBuilder(String.valueOf(str2)).append(".$old").toString()), (String) y.get(new StringBuilder(String.valueOf(str2)).append(".$new").toString()), (String) y.get(new StringBuilder(String.valueOf(str2)).append(".$patch").toString()), (String) y.get(new StringBuilder(String.valueOf(str2)).append(".$url").toString()), j.ck((String) y.get(new StringBuilder(String.valueOf(str2)).append(".$size").toString())));
            if (aVar.fej == null || aVar.fek == null || aVar.fel == null || aVar.url == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                iVar.fei.put(aVar.fej, aVar);
            }
            i++;
        }
        return iVar;
    }
}
