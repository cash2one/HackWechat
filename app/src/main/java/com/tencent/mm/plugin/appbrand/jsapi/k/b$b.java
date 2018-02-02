package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.k.b.a;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.x;

abstract class b$b extends b implements SensorEventListener {
    private f jqp;
    boolean jqt;
    private float[] jqu = new float[3];
    private float[] jqv = new float[3];
    a jqw = new a();

    b$b(j jVar) {
        this.jqw.a(jVar);
        this.jqp = new f((long) c.agK(), new 1(this, jVar));
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.jqt) {
            if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                x.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
                return;
            }
            if (sensorEvent.sensor.getType() == 2) {
                this.jqv = sensorEvent.values;
            } else if (sensorEvent.sensor.getType() == 1) {
                this.jqu = sensorEvent.values;
            } else {
                return;
            }
            boolean i = this.jqp.i(new Object[0]);
            x.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[]{Boolean.valueOf(i)});
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
