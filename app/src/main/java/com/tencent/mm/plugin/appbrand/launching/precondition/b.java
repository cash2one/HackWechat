package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.Queue;

abstract class b extends MutableContextWrapper {
    final Queue<Runnable> jyR = new LinkedList();
    private ag jyS;

    protected abstract String aih();

    static /* synthetic */ void a(b bVar, AppBrandInitConfig appBrandInitConfig) {
        String aih = bVar.aih();
        if (!bh.ov(aih)) {
            boolean z = aih.contains("WebView") || k.td(aih).contains(":tools");
            appBrandInitConfig.iNS = z;
        }
    }

    public b() {
        super(ac.getContext());
    }

    public final void setBaseContext(Context context) {
        super.setBaseContext(context);
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            while (!this.jyR.isEmpty()) {
                ((Runnable) this.jyR.poll()).run();
            }
        }
    }

    private void q(Runnable runnable) {
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            runnable.run();
        } else {
            this.jyR.offer(runnable);
        }
    }

    protected void aii() {
        q(new 1(this));
    }

    protected final void finish() {
        d(null, null);
    }

    protected void d(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig != null) {
            k.a(getBaseContext(), appBrandInitConfig, appBrandStatObject);
        }
        aii();
        if (this.jyS != null) {
            this.jyS.F(new 4(this));
        }
    }

    protected final boolean isFinishing() {
        return (getBaseContext() instanceof AppBrandLaunchProxyUI) && ((AppBrandLaunchProxyUI) getBaseContext()).isFinishing();
    }

    protected final boolean aij() {
        return (getBaseContext() instanceof AppBrandLaunchProxyUI) && ((AppBrandLaunchProxyUI) getBaseContext()).isDestroyed();
    }

    protected boolean c(AppBrandInitConfig appBrandInitConfig) {
        boolean z;
        if (appBrandInitConfig.iNS || d.un(appBrandInitConfig.appId) || appBrandInitConfig.Yz()) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    protected final void a(LaunchParcel launchParcel) {
        ag agVar = new ag("AppBrandLaunchProxyUI-PrepareThread");
        this.jyS = agVar;
        agVar.F(new 3(this, launchParcel));
    }
}
