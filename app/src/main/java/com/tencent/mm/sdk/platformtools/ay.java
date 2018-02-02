package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import java.util.List;

public final class ay {
    private SensorManager viA;
    private a xig;

    static class a implements SensorListener {
        private Runnable fqI;
        private float[] viD = new float[]{0.0f, 0.0f, 0.0f};

        public a(Runnable runnable) {
            this.fqI = runnable;
        }

        public final void onAccuracyChanged(int i, int i2) {
        }

        public final void onSensorChanged(int i, float[] fArr) {
            Object obj = null;
            float[] fArr2 = new float[3];
            int i2 = 0;
            while (i2 < 3) {
                fArr2[i2] = Math.abs(fArr[i2] - this.viD[i2]);
                if (this.viD[i2] != 0.0f && fArr2[i2] > 1.0f) {
                    obj = 1;
                    x.d("MicroMsg.ShakeManager", "isONShake:" + fArr2[i2]);
                }
                this.viD[i2] = fArr[i2];
                i2++;
            }
            if (obj != null) {
                this.fqI.run();
            }
        }
    }

    public ay(Context context) {
        this.viA = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean O(Runnable runnable) {
        if (this.viA == null) {
            return false;
        }
        List sensorList = this.viA.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        this.xig = new a(runnable);
        this.viA.registerListener(this.xig, 2, 3);
        return true;
    }

    public final void cgg() {
        if (this.viA != null && this.xig != null) {
            this.viA.unregisterListener(this.xig, 2);
        }
    }
}
