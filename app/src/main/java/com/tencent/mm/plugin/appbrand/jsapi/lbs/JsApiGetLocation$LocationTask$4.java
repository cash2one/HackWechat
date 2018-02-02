package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.jsapi.lbs.JsApiGetLocation.LocationTask;

class JsApiGetLocation$LocationTask$4 implements Runnable {
    final /* synthetic */ LocationTask jkB;

    JsApiGetLocation$LocationTask$4(LocationTask locationTask) {
        this.jkB = locationTask;
    }

    public final void run() {
        LocationTask.j(this.jkB);
    }
}
