package com.tencent.c.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.concurrent.atomic.AtomicBoolean;

class g$a implements SensorEventListener {
    long zTS = 0;
    final AtomicBoolean zUd = new AtomicBoolean(false);
    int zUe = 0;
    long zUf = 0;
    final /* synthetic */ g zUg;

    g$a(g gVar) {
        this.zUg = gVar;
    }

    public final long cDD() {
        long j;
        synchronized (this.zUd) {
            j = this.zTS;
        }
        return j;
    }

    public final long cDE() {
        long j;
        synchronized (this.zUd) {
            j = this.zUf;
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSensorChanged(SensorEvent sensorEvent) {
        synchronized (this.zUd) {
            if (!this.zUd.get()) {
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
