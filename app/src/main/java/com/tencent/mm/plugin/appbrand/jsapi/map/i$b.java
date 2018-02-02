package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.z.u$b;

class i$b implements SensorEventListener {
    int fzG;
    u$b iTl;
    final /* synthetic */ i jmd;
    private float jmn = 0.0f;
    private long timestamp = 200;

    public i$b(i iVar, int i, u$b com_tencent_mm_z_u_b) {
        this.jmd = iVar;
        this.fzG = i;
        this.iTl = com_tencent_mm_z_u_b;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 3) {
            long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
            float aA = r.aA(sensorEvent.values[0]);
            if (currentTimeMillis > 200 && Math.abs(aA - this.jmn) > 3.0f) {
                AppbrandMapLocationPoint appbrandMapLocationPoint = (AppbrandMapLocationPoint) this.iTl.get(this.fzG, null);
                if (appbrandMapLocationPoint != null) {
                    float f = this.jmn;
                    float f2 = (f < 0.0f || f > 45.0f || aA < 315.0f || aA >= 360.0f) ? aA : aA - 360.0f;
                    if ((f < 0.0f || f > 45.0f || aA < 315.0f || aA >= 360.0f) && f >= 315.0f && f < 360.0f && aA >= 0.0f && aA <= 45.0f) {
                        f -= 360.0f;
                    }
                    Animation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setDuration(200);
                    rotateAnimation.setFillAfter(true);
                    appbrandMapLocationPoint.jlO.startAnimation(rotateAnimation);
                }
                this.jmn = aA;
                this.timestamp = System.currentTimeMillis();
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
