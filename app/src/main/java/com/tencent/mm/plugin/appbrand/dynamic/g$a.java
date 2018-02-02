package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.f.d;
import java.util.Collection;

final class g$a implements a {
    private g$a() {
    }

    public final void a(Bundle bundle, c cVar) {
        Collection<c> values = d.acE().iRX.values();
        if (values != null && !values.isEmpty()) {
            com.tencent.mm.u.b.c dVar = new d();
            String str = dVar.name;
            String jSONObject = dVar.sN().toString();
            for (c cVar2 : values) {
                if (cVar2 != null) {
                    cVar2.aY(str, jSONObject);
                }
            }
        }
    }
}
