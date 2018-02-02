package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.c.b;
import java.util.Map;

class d$1 implements b {
    final /* synthetic */ d bbE;

    d$1(d dVar) {
        this.bbE = dVar;
    }

    public final void g(Map<String, Object> map) {
        Object obj = map.get("event");
        if (obj != null) {
            d.a(this.bbE, obj.toString());
        }
    }
}
