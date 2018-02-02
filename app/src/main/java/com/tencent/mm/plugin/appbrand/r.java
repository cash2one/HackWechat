package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.1;
import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.p.g;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class r implements p {
    private final Set<String> iCH = new HashSet();
    private final g<String, a> iCI = new g();
    final e irF;

    static /* synthetic */ void a(r rVar, String str, c cVar) {
        synchronized (rVar.iCH) {
            rVar.iCH.remove(str);
        }
        Set<a> bh = rVar.iCI.bh(str);
        if (bh == null) {
            x.e("MicroMsg.AppBrand.RuntimeModularizingHelper", "markLoadingFinished %s, result %s, get null callbackSet, maybe canceled by user before", new Object[]{str, cVar.name()});
            return;
        }
        for (a a : bh) {
            a.a(cVar);
        }
    }

    r(e eVar) {
        this.irF = eVar;
    }

    public final boolean YV() {
        return true;
    }

    public final void a(String str, a aVar) {
        h hVar = new h();
        ModulePkgInfo pu = bh.ov(str) ? this.irF.iqx.iOI : pu(str);
        hVar.jRK = pu;
        Object obj = (bh.ov(pu.iEa) || !e.bO(pu.iEa)) ? null : 1;
        if (obj != null) {
            aVar.a(c.isg);
            return;
        }
        String str2 = ((ModulePkgInfo) hVar.jRK).name;
        g gVar = this.iCI;
        if (!(str2 == null || aVar == null)) {
            Set bg = gVar.bg(str2);
            synchronized (bg) {
                bg.add(aVar);
            }
        }
        synchronized (this.iCH) {
            boolean contains = this.iCH.contains(str2);
            if (!contains) {
                this.iCH.add(str2);
            }
        }
        if (!contains) {
            h hVar2 = new h();
            ag.y(new 1(this, str2, hVar2));
            RuntimeLoadModuleTask 2 = new 2(this, this.irF.mAppId, this.irF.iqx.iOI.iGK, this.irF.iqx.iOI.iGL, (String) this.irF.iqx.iOI.iGP.get(str2), str2, hVar2);
            XIPCInvoker.a("com.tencent.mm", 2.jyy, RuntimeLoadModuleTask.a.class, new 1(2));
        }
    }

    public final String pt(String str) {
        return pu(str).name;
    }

    private ModulePkgInfo pu(String str) {
        ModulePkgInfo modulePkgInfo = this.irF.iqx.iOI;
        if (bh.ov(str)) {
            return modulePkgInfo;
        }
        String py = com.tencent.mm.plugin.appbrand.appcache.a.py(str);
        Iterator it = modulePkgInfo.iGO.iterator();
        while (it.hasNext()) {
            ModulePkgInfo modulePkgInfo2 = (ModulePkgInfo) it.next();
            if (py.startsWith(modulePkgInfo2.name)) {
                return modulePkgInfo2;
            }
        }
        return modulePkgInfo;
    }
}
