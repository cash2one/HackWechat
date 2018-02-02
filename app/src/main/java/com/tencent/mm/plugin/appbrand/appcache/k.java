package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class k implements Closeable {
    private final WxaPkgWrappingInfo iEy;
    private final Map<String, z> iEz = new HashMap();

    k(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.iEy = wxaPkgWrappingInfo;
        this.iEy.aaq();
    }

    final z pB(String str) {
        if (bh.ov(str)) {
            return null;
        }
        String str2;
        String py = a.py(str);
        if (py.startsWith("__APP__")) {
            str2 = "__APP__";
        } else {
            Iterator it = this.iEy.iGO.iterator();
            while (it.hasNext()) {
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                if (py.startsWith(modulePkgInfo.name)) {
                    str2 = modulePkgInfo.name;
                    break;
                }
            }
            str2 = null;
            if (bh.ov(str2)) {
                str2 = "__APP__";
            }
        }
        return pC(str2);
    }

    final void ZK() {
        synchronized (this.iEz) {
            pC("__APP__");
            Iterator it = this.iEy.iGO.iterator();
            while (it.hasNext()) {
                pC(((e) it.next()).name);
            }
        }
    }

    final z pC(String str) {
        z zVar;
        synchronized (this.iEz) {
            zVar = (z) this.iEz.get(str);
            if (zVar != null) {
            } else {
                String str2;
                if ("__APP__".equals(str)) {
                    str2 = this.iEy.iEa;
                } else {
                    Iterator it = this.iEy.iGO.iterator();
                    while (it.hasNext()) {
                        ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                        if (str.equals(modulePkgInfo.name)) {
                            str2 = modulePkgInfo.iEa;
                            break;
                        }
                    }
                    str2 = null;
                }
                if (bh.ov(str2)) {
                } else {
                    zVar = new z(str2);
                    this.iEz.put(str, zVar);
                }
            }
        }
        if (zVar != null) {
            zVar.ZX();
        }
        return zVar;
    }

    public final void close() {
        synchronized (this.iEz) {
            Collection<z> values = this.iEz.values();
        }
        for (z close : values) {
            close.close();
        }
    }
}
