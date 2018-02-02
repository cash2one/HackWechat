package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.HashMap;
import java.util.Map;

public final class g extends af<g> {
    public final Map<String, Object> aFb = new HashMap();

    public static String aX(String str) {
        w.aM(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        w.h(str, "Name can not be empty or \"&\"");
        return str;
    }

    public final /* synthetic */ void a(af afVar) {
        g gVar = (g) afVar;
        w.ag(gVar);
        gVar.aFb.putAll(this.aFb);
    }

    public final String toString() {
        return af.n(this.aFb, 0);
    }
}
