package com.tencent.mm.plugin.appbrand;

import android.widget.FrameLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.ui.m;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f<_ActivityContext extends MMActivity & m> implements o {
    FrameLayout iqD;
    private _ActivityContext iqt;
    public LinkedList<e> irp = new LinkedList();
    HashMap<String, e> irq = new HashMap();
    private c irr;

    public f(_ActivityContext _ActivityContext, c cVar, FrameLayout frameLayout) {
        this.iqt = _ActivityContext;
        this.iqD = frameLayout;
        this.irr = cVar;
    }

    public final void a(e eVar, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig != null && appBrandStatObject != null) {
            if (eVar == null) {
                Iterator it = this.irp.iterator();
                while (it.hasNext()) {
                    e eVar2 = (e) it.next();
                    eVar2.iqD.setVisibility(8);
                    this.irq.put(eVar2.mAppId, eVar2);
                    eVar2.iqO.iGV.jz(12);
                }
                this.irp.clear();
            }
            if (pg(appBrandInitConfig.appId) == null) {
                b(eVar, appBrandInitConfig, appBrandStatObject);
            } else {
                this.iqt.runOnUiThread(new 2(this, eVar, appBrandInitConfig, appBrandStatObject));
            }
        }
    }

    final void b(e eVar, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (ag.isMainThread()) {
            e eVar2;
            if (appBrandInitConfig.Yz()) {
                x.i("MicroMsg.AppBrandRuntimeContainer", "cleanup by game, ugly");
                cleanup();
            } else {
                Iterator it = this.irp.iterator();
                while (it.hasNext()) {
                    eVar2 = (e) it.next();
                    if (eVar2.Yz()) {
                        break;
                    }
                }
                for (e eVar22 : this.irq.values()) {
                    if (eVar22.Yz()) {
                        break;
                    }
                }
                eVar22 = null;
                d(eVar22);
            }
            if (eVar != null) {
                eVar.onPause();
            }
            eVar22 = new e(this.iqt, this);
            eVar22.a(appBrandInitConfig, appBrandStatObject);
            eVar22.iqv = eVar;
            eVar22.Yt();
            this.irp.push(eVar22);
            this.iqD.addView(eVar22.iqD);
            if (eVar != null) {
                com.tencent.mm.plugin.appbrand.ui.f.a(eVar22, eVar, null);
                return;
            }
            return;
        }
        this.iqt.runOnUiThread(new 1(this, eVar, appBrandInitConfig, appBrandStatObject));
    }

    public final void close() {
        if (YI() != null && YI().iqx != null && YI().iqx.iOk && YI().gSX) {
            ((d) g.h(d.class)).cj(this.iqt);
            YI().iqx.iOk = false;
        }
        if (((m) this.iqt).akR()) {
            this.iqt.moveTaskToBack(true);
        } else {
            this.iqt.finish();
        }
    }

    public final void finish() {
        this.iqt.finish();
    }

    public final e YI() {
        return (e) this.irp.peek();
    }

    public final e b(e eVar) {
        int indexOf = this.irp.indexOf(eVar);
        int size = this.irp.size() - 1;
        if (indexOf == -1 || indexOf >= size) {
            return null;
        }
        return (e) this.irp.get(indexOf + 1);
    }

    public final int YJ() {
        return this.irp.size();
    }

    public final boolean c(e eVar) {
        return this.irp.contains(eVar);
    }

    final e pg(String str) {
        Iterator it = this.irp.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.mAppId.equals(str)) {
                return eVar;
            }
        }
        return (e) this.irq.get(str);
    }

    public final void d(e eVar) {
        this.iqt.runOnUiThread(new 4(this, eVar));
    }

    public final void cleanup() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.irp);
        linkedList.addAll(this.irq.values());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            d((e) it.next());
        }
        x.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    }

    public final c YK() {
        return this.irr;
    }
}
