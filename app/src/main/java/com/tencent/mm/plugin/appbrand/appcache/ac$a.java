package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class ac$a implements Closeable {
    private final k iFR;
    private final Map<z, o> iFS;

    private ac$a(k kVar) {
        this.iFS = new HashMap();
        this.iFR = kVar;
    }

    final Collection<o> aaj() {
        Collection<o> values;
        synchronized (this.iFS) {
            values = this.iFS.values();
        }
        return values;
    }

    final o pJ(String str) {
        z pB = this.iFR.pB(str);
        if (pB == null) {
            return null;
        }
        o oVar;
        synchronized (this.iFS) {
            oVar = (o) this.iFS.get(pB);
            if (oVar == null) {
                Map map = this.iFS;
                oVar = new o(pB);
                map.put(pB, oVar);
            }
        }
        return oVar;
    }

    public final void close() {
        synchronized (this.iFS) {
            this.iFS.clear();
        }
        this.iFR.close();
    }
}
