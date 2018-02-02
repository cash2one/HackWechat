package com.tencent.mm.pluginsdk.ui.tools;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements SensorEventListener {
    final /* synthetic */ e vwZ;

    e$1(e eVar) {
        this.vwZ = eVar;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 3) {
            e.a(this.vwZ)[0] = sensorEvent.values[0];
            e.a(this.vwZ)[1] = sensorEvent.values[1];
            e.a(this.vwZ)[2] = sensorEvent.values[2];
            if (this.vwZ.vwV == -10000) {
                this.vwZ.vwV = (int) e.a(this.vwZ)[0];
            } else if (e.a(this.vwZ)[0] - ((float) this.vwZ.vwV) > 300.0f || e.a(this.vwZ)[0] - ((float) this.vwZ.vwV) < -300.0f) {
                this.vwZ.vwV = (int) e.a(this.vwZ)[0];
            } else {
                this.vwZ.vwV = (int) ((((double) this.vwZ.vwV) * 0.6d) + (((double) e.a(this.vwZ)[0]) * 0.4d));
            }
            if (this.vwZ.vwV == 0) {
                this.vwZ.vwV = 1;
            }
            if (this.vwZ.vwV == 365) {
                this.vwZ.vwV = 364;
            }
            if (this.vwZ.vwW == -10000) {
                this.vwZ.vwW = (int) e.a(this.vwZ)[1];
            } else if (e.a(this.vwZ)[1] < -68.0f) {
                int i = (int) (-68.0d + (((double) (e.a(this.vwZ)[1] + 68.0f)) / 1.5d));
                if (i < -89) {
                    i = -89;
                }
                this.vwZ.vwW = i;
            } else if (e.a(this.vwZ)[1] > 89.0f) {
                this.vwZ.vwW = 89;
            } else {
                this.vwZ.vwW = (int) ((((double) this.vwZ.vwW) * 0.6d) + (((double) e.a(this.vwZ)[1]) * 0.4d));
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
        x.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
    }
}
