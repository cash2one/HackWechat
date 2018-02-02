package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class ScanCameraLightDetector implements SensorEventListener {
    public static final ScanCameraLightDetector qaA = new ScanCameraLightDetector();
    public SensorManager hRa;
    public af handler;
    public long qaB = -1;
    public Sensor qaC;
    public boolean qaD = false;
    private float qaE = -1.0f;
    public HandlerThread qaF;

    private static native int calcLumNative(byte[] bArr, int i, int i2);

    static /* synthetic */ boolean r(byte[] bArr, int i, int i2) {
        if (!bh.bw(bArr) && bArr.length > i * i2) {
            x.i("MicroMsg.ScanCameraLightDetector", "lum light: %s", new Object[]{Integer.valueOf(calcLumNative(bArr, i, i2))});
            if (calcLumNative(bArr, i, i2) < 50) {
                return true;
            }
        }
        return false;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length > 0) {
            this.qaE = fArr[0];
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        x.d("MicroMsg.ScanCameraLightDetector", "onAccuracyChanged");
    }
}
