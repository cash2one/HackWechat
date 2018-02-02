package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.hardware.SensorManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.k.b.b;
import com.tencent.mm.plugin.appbrand.q.f.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class b$b$1 implements a {
    final /* synthetic */ j iZy;
    final /* synthetic */ b jqx;

    b$b$1(b bVar, j jVar) {
        this.jqx = bVar;
        this.iZy = jVar;
    }

    public final boolean g(Object... objArr) {
        x.v("MicroMsg.JsApiEnableCompass", "onAction.");
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, b.a(this.jqx), b.b(this.jqx));
        SensorManager.getOrientation(fArr2, fArr);
        Map hashMap = new HashMap();
        float toDegrees = (float) Math.toDegrees((double) fArr[0]);
        if (toDegrees < 0.0f) {
            toDegrees += 360.0f;
        }
        hashMap.put(TencentLocation.EXTRA_DIRECTION, Float.valueOf(toDegrees));
        this.jqx.jqw.v(hashMap);
        return c.agI().a(this.jqx.jqw, this.iZy);
    }
}
