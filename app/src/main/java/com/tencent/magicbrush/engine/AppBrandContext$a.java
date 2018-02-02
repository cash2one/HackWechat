package com.tencent.magicbrush.engine;

import java.util.TimerTask;

public class AppBrandContext$a extends TimerTask {
    public int bnv;
    public boolean bnw;
    final /* synthetic */ AppBrandContext bnx;

    public AppBrandContext$a(AppBrandContext appBrandContext, int i, boolean z) {
        this.bnx = appBrandContext;
        this.bnv = i;
        this.bnw = z;
    }

    public final void run() {
        if (!AppBrandContext.b(this.bnx)) {
            AppBrandContext.d(this.bnx).post(new 1(this));
        } else if (!this.bnw) {
            AppBrandContext.c(this.bnx).add(Integer.valueOf(this.bnv));
        }
    }
}
