package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast;

class JsApiLaunchMiniProgram$2 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiLaunchMiniProgram job;
    final /* synthetic */ String joc;
    final /* synthetic */ int jod;

    JsApiLaunchMiniProgram$2(JsApiLaunchMiniProgram jsApiLaunchMiniProgram, String str, int i, j jVar, int i2) {
        this.job = jsApiLaunchMiniProgram;
        this.joc = str;
        this.jod = i;
        this.iZy = jVar;
        this.gOK = i2;
    }

    public final void aY(Object obj) {
        if (obj instanceof LaunchBroadCast) {
            LaunchBroadCast launchBroadCast = (LaunchBroadCast) obj;
            if (this.joc.equals(launchBroadCast.appId) && this.jod == launchBroadCast.iKd) {
                MMToClientEvent.b(this);
                this.iZy.E(this.gOK, this.job.e(launchBroadCast.fJW ? "ok" : "fail", null));
            }
        }
    }
}
