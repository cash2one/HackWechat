package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;

public final class d extends b implements h {
    private Intent Ks;
    int jaT = 0;

    protected final boolean c(AppBrandInitConfig appBrandInitConfig) {
        Class cls;
        try {
            cls = Class.forName(bh.ou(this.Ks.getStringExtra("extra_launch_source_context")));
        } catch (Exception e) {
            cls = null;
        }
        if (cls == null || !AppBrandUI.class.isAssignableFrom(cls)) {
            return super.c(appBrandInitConfig);
        }
        return false;
    }

    public d(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        setBaseContext(appBrandLaunchProxyUI);
    }

    public final void w(Intent intent) {
        this.Ks = intent;
        LaunchParcel launchParcel = (LaunchParcel) intent.getParcelableExtra("extra_launch_parcel");
        if (launchParcel == null) {
            finish();
        } else {
            a(launchParcel);
        }
    }

    public final void onResume() {
        int i = this.jaT + 1;
        this.jaT = i;
        if (i > 1) {
            aik();
        }
    }

    public final void onPause() {
        aik();
    }

    protected final String aih() {
        return this.Ks.getStringExtra("extra_launch_source_context");
    }

    protected final void d(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        super.d(appBrandInitConfig, appBrandStatObject);
        Runnable 1 = new 1(this);
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            ag.y(1);
        } else {
            this.jyR.offer(1);
        }
    }

    protected final void aii() {
    }

    private void aik() {
        if (!isFinishing() && !aij()) {
            super.aii();
        }
    }
}
