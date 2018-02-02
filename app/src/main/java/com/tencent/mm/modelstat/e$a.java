package com.tencent.mm.modelstat;

import android.hardware.SensorEvent;

class e$a {
    public int accuracy = 0;
    public float[] values;

    public e$a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            this.accuracy = sensorEvent.accuracy;
            this.values = new float[sensorEvent.values.length];
            System.arraycopy(sensorEvent.values, 0, this.values, 0, sensorEvent.values.length);
        }
    }
}
