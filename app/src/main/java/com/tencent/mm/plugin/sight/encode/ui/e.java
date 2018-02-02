package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import com.tencent.mm.pluginsdk.k.a;
import com.tencent.mm.sdk.platformtools.x;

final class e implements SensorEventListener {
    private static int orU = Integer.MAX_VALUE;
    Camera gEB = null;
    private Context mContext = null;
    boolean orQ = false;
    boolean orS = false;
    private int orT = 0;
    private float orX = 0.0f;
    private float orY = 0.0f;
    private float orZ = 0.0f;
    private boolean osv = false;
    a qxu = a.bZJ();
    private PreviewCallback qxv = null;
    a qxw = new a(Looper.getMainLooper());

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.orX - f) > 3.0f || Math.abs(this.orY - f2) > 3.0f || Math.abs(this.orZ - f3) > 3.0f) {
            x.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", new Object[]{Float.valueOf(3.0f)});
            a.f(this.gEB);
            this.orX = f;
            this.orY = f2;
            this.orZ = f3;
        }
    }
}
