package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.hardware.SensorManager;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;

class a$1 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ SensorManager jmj;
    final /* synthetic */ a jqo;

    a$1(a aVar, j jVar, j jVar2, SensorManager sensorManager) {
        this.jqo = aVar;
        this.iZy = jVar2;
        this.jmj = sensorManager;
        super(jVar);
    }

    public final void onDestroy() {
        c.b(this.iZy.mAppId, this);
        this.jmj.unregisterListener(this);
    }
}
