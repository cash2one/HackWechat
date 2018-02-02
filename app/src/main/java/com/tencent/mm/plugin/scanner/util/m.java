package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements SensorEventListener {
    public static final m qbb = new m();
    public SensorManager bgR = ((SensorManager) ac.getContext().getSystemService("sensor"));
    public Sensor qaX = this.bgR.getDefaultSensor(1);
    public float[] qaY = new float[3];
    public int qaZ;
    private long qba;

    private m() {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            x.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", new Object[]{Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2])});
            if (this.qaY[0] == 0.0f && this.qaY[1] == 0.0f && this.qaY[2] == 0.0f) {
                this.qaY[0] = fArr[0];
                this.qaY[1] = fArr[1];
                this.qaY[2] = fArr[2];
                return;
            }
            if (Math.abs(fArr[0] - this.qaY[0]) > 0.7f || Math.abs(fArr[1] - this.qaY[1]) > 0.7f || Math.abs(fArr[2] - this.qaY[2]) > 0.7f) {
                x.d("MicroMsg.ScanStableDetector", "scan unstable");
                this.qaZ = 0;
            } else {
                if (this.qaZ == 0) {
                    this.qba = System.currentTimeMillis();
                }
                this.qaZ++;
                if (this.qaZ >= 5) {
                    x.d("MicroMsg.ScanStableDetector", "scan stable");
                }
            }
            this.qaY[0] = fArr[0];
            this.qaY[1] = fArr[1];
            this.qaY[2] = fArr[2];
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void stop() {
        x.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
        if (this.bgR != null) {
            x.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
            this.bgR.unregisterListener(this);
        }
    }

    public final long bpO() {
        if (this.qaZ >= 5) {
            return this.qba;
        }
        return 0;
    }
}
