package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;

enum c$a {
    ;

    public static c a(String str, p pVar, e eVar) {
        if ("digit".equalsIgnoreCase(str) || "idcard".equalsIgnoreCase(str) || "number".equalsIgnoreCase(str)) {
            return new d(str, pVar, eVar);
        }
        return null;
    }
}
