package com.tencent.mm.pluginsdk.k;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import com.tencent.mm.sdk.platformtools.x;

public abstract class c$a implements SensorEventListener {
    private static int viE;
    private final float[] viC = new float[]{2.0f, 2.5f, 0.5f};
    private float[] viD = new float[3];

    public abstract void beP();

    public abstract void onRelease();

    public static void reset() {
        x.d("MicroMsg.ShakeSensorListener", "reset threadHold");
        viE = 5;
        if (Build.MODEL.equals("LG-E510")) {
            viE = 4;
        }
    }

    static {
        viE = 5;
        if (Build.MODEL.equals("LG-E510")) {
            viE = 4;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = new float[3];
        float[] fArr2 = sensorEvent.values;
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            fArr[i2] = (float) Math.round((this.viC[i2] * (fArr2[i2] - this.viD[i2])) * 0.45f);
            float abs = Math.abs(fArr[i2]);
            if (abs >= 4.0f) {
                x.v("MicroMsg.ShakeSensorListener", "result:" + abs + " THREAHOLD:" + viE);
            }
            if (viE < 9) {
                if (abs >= 14.0f) {
                    viE = 9;
                } else {
                    int i3 = (int) abs;
                    if (viE < i3 - 4) {
                        viE = i3 - 4;
                    }
                }
            }
            if (abs > ((float) viE)) {
                i = 1;
            }
            this.viD[i2] = fArr2[i2];
        }
        if (i != 0) {
            x.d("MicroMsg.ShakeSensorListener", "sensorChanged " + sensorEvent.sensor.getName() + " (" + fArr2[0] + ", " + fArr2[1] + ", " + fArr2[2] + ") diff(" + fArr[0] + " " + fArr[1] + " " + fArr[2] + ")");
            beP();
            float[] fArr3 = sensorEvent.values;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
