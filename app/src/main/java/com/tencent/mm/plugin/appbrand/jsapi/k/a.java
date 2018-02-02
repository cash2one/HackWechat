package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 92;
    public static final String NAME = "enableAccelerometer";
    private Handler mHandler = new Handler(c.Dm().oAt.getLooper());

    private static abstract class b extends com.tencent.mm.plugin.appbrand.c.b implements SensorEventListener {
        private f jqp;
        a jqq = new a();

        b(j jVar) {
            this.jqq.a(jVar);
            this.jqp = new f((long) c.agK(), new 1(this, jVar));
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                if (fArr == null || fArr.length < 3) {
                    x.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
                    return;
                }
                boolean i = this.jqp.i(new Object[]{fArr});
                x.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[]{Boolean.valueOf(i)});
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            SensorManager sensorManager = (SensorManager) jVar.getContext().getSystemService("sensor");
            if (sensorManager == null) {
                x.i("MicroMsg.JsApiEnableAccelerometer", "getSystemService(SENSOR_SERVICE) failed.");
                jVar.E(i, e("fail", null));
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                x.i("MicroMsg.JsApiEnableAccelerometer", "get Accelerometer sensor failed.");
                jVar.E(i, e("fail", null));
                return;
            }
            boolean z2;
            String e;
            String str = "JsApi#SensorAccelerometer" + jVar.hashCode();
            com.tencent.mm.z.u.b t;
            if (z) {
                com.tencent.mm.z.u.b hx = u.GK().hx(str);
                if (hx == null) {
                    t = u.GK().t(str, true);
                } else {
                    t = hx;
                }
                if (((b) t.get("sensor_event_listener", null)) != null) {
                    x.w("MicroMsg.JsApiEnableAccelerometer", "register failed, sensorEventListener has already registered.");
                    jVar.E(i, e("fail, has enable, should stop pre operation", null));
                    return;
                }
                Object 1 = new 1(this, jVar, jVar, sensorManager);
                com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, 1);
                t.o("sensor_event_listener", 1);
                z = sensorManager.registerListener(1, defaultSensor, 3, this.mHandler);
                if (!z) {
                    sensorManager.unregisterListener(1);
                    com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, 1);
                    t.recycle();
                    u.GK().hy(str);
                }
                x.i("MicroMsg.JsApiEnableAccelerometer", "register accelerometer sensor finished(s : %s, r : %s).", new Object[]{str, Boolean.valueOf(z)});
                z2 = z;
            } else {
                t = u.GK().hy(str);
                if (t == null) {
                    x.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, keyValueSet do not exist.");
                    jVar.E(i, e("fail", null));
                    return;
                }
                b bVar = (b) t.get("sensor_event_listener", null);
                if (bVar == null) {
                    x.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, listener do not exist.");
                    jVar.E(i, e("fail", null));
                    return;
                }
                sensorManager.unregisterListener(bVar);
                com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, bVar);
                t.recycle();
                x.i("MicroMsg.JsApiEnableAccelerometer", "unregister accelerometer sensor finished(s : %s).", new Object[]{str});
                z2 = true;
            }
            if (z2) {
                e = e("ok", null);
            } else {
                e = e("fail", null);
            }
            jVar.E(i, e);
        } catch (JSONException e2) {
            x.i("MicroMsg.JsApiEnableAccelerometer", "json data do not contains parameter enable.");
            jVar.E(i, e("fail", null));
        }
    }
}
