package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 94;
    public static final String NAME = "enableCompass";
    SensorManager bgR;
    private Handler mHandler = new Handler(c.Dm().oAt.getLooper());

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            if (this.bgR == null) {
                this.bgR = (SensorManager) jVar.getContext().getSystemService("sensor");
            }
            if (this.bgR == null) {
                x.i("MicroMsg.JsApiEnableCompass", "getSystemService(SENSOR_SERVICE) failed.");
                jVar.E(i, e("fail", null));
                return;
            }
            Sensor defaultSensor = this.bgR.getDefaultSensor(2);
            Sensor defaultSensor2 = this.bgR.getDefaultSensor(1);
            if (defaultSensor == null || defaultSensor2 == null) {
                x.i("MicroMsg.JsApiEnableCompass", "get compass or accelerometer sensor failed.");
                jVar.E(i, e("fail", null));
                return;
            }
            boolean z2;
            String e;
            String str = "JsApi#SensorMagneticField" + jVar.hashCode();
            com.tencent.mm.z.u.b t;
            if (z) {
                com.tencent.mm.z.u.b hx = u.GK().hx(str);
                if (hx == null) {
                    t = u.GK().t(str, true);
                } else {
                    t = hx;
                }
                if (((b) t.get("sensor_event_listener", null)) != null) {
                    x.w("MicroMsg.JsApiEnableCompass", "register failed, sensorEventListener has already registered.");
                    jVar.E(i, e("fail, has enable, should stop pre operation", null));
                    return;
                }
                com.tencent.mm.plugin.appbrand.c.b 1 = new 1(this, jVar, jVar);
                com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, 1);
                t.o("sensor_event_listener", 1);
                z2 = this.bgR.registerListener(1, defaultSensor, 3, this.mHandler) && this.bgR.registerListener(1, defaultSensor2, 3, this.mHandler);
                if (!z2) {
                    this.bgR.unregisterListener(1);
                    1.jqt = true;
                    com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, 1);
                    t.recycle();
                    u.GK().hy(str);
                }
                x.i("MicroMsg.JsApiEnableCompass", "register compass sensor finished(s : %s, r : %s).", new Object[]{str, Boolean.valueOf(z2)});
            } else {
                t = u.GK().hy(str);
                if (t == null) {
                    x.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, keyValueSet do not exist.");
                    jVar.E(i, e("fail", null));
                    return;
                }
                b bVar = (b) t.get("sensor_event_listener", null);
                if (bVar == null) {
                    x.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, listener do not exist.");
                    jVar.E(i, e("fail", null));
                    return;
                }
                this.bgR.unregisterListener(bVar);
                com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, bVar);
                bVar.jqt = true;
                t.recycle();
                x.i("MicroMsg.JsApiEnableCompass", "unregister compass sensor finished(%s).", new Object[]{str});
                z2 = true;
            }
            if (z2) {
                e = e("ok", null);
            } else {
                e = e("fail", null);
            }
            jVar.E(i, e);
        } catch (JSONException e2) {
            x.i("MicroMsg.JsApiEnableCompass", "json data do not contains parameter enable.");
            jVar.E(i, e("fail", null));
        }
    }
}
