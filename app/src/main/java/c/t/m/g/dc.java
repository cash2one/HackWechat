package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

final class dc implements SensorEventListener {
    private static volatile dc e;
    final SensorManager a;
    final boolean b;
    boolean c;
    double d;

    public static dc a(Context context) {
        if (e == null) {
            e = new dc(context);
        }
        return e;
    }

    private dc(Context context) {
        this.a = (SensorManager) context.getSystemService("sensor");
        this.b = this.a != null;
    }

    public final double a() {
        if (!this.c) {
            return Double.NaN;
        }
        double d;
        synchronized (this) {
            d = this.d;
        }
        return d;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 11) {
                float[] fArr = new float[16];
                float[] fArr2 = new float[3];
                SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
                SensorManager.getOrientation(fArr, fArr2);
                double d = (double) fArr2[0];
                synchronized (this) {
                    this.d = (d * 180.0d) / 3.1415926d;
                }
            }
        } catch (Throwable th) {
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
