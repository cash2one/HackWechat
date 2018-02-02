package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.jg.EType;
import com.jg.JgMethodChecked;

public class SensorController extends BroadcastReceiver implements SensorEventListener {
    private static float xhV = 4.2949673E9f;
    private static float xhX = 0.5f;
    public static boolean xie = false;
    public static double xif = -1.0d;
    private Context context;
    private SensorManager hRa;
    private float rio = -1.0f;
    private float xhW;
    private a xhY;
    private Sensor xhZ;
    private final boolean xia;
    private boolean xib = false;
    public boolean xic = false;
    private float xid = -1.0f;

    public interface a {
        void dT(boolean z);
    }

    public SensorController(Context context) {
        if (context == null) {
            this.xia = false;
            return;
        }
        boolean z;
        this.context = context;
        this.hRa = (SensorManager) context.getSystemService("sensor");
        this.xhZ = this.hRa.getDefaultSensor(8);
        if (this.xhZ != null) {
            this.rio = Math.min(10.0f, this.xhZ.getMaximumRange());
        }
        if (this.rio < 0.0f) {
            x.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", Float.valueOf(this.rio));
            this.rio = 1.0f;
        }
        if (this.xhZ != null) {
            z = true;
        } else {
            z = false;
        }
        this.xia = z;
        this.xhW = xhX + 1.0f;
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public final void a(a aVar) {
        x.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.xic + ", proximitySensor: " + this.xhZ + ", maxValue: " + this.rio);
        if (!this.xic) {
            this.xid = -1.0f;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.context.registerReceiver(this, intentFilter);
            this.hRa.registerListener(this, this.xhZ, 2);
            this.xic = true;
        }
        this.xhY = aVar;
    }

    public final void cgf() {
        x.i("MicroMsg.SensorController", "sensor callback removed");
        try {
            this.context.unregisterReceiver(this);
        } catch (Exception e) {
            x.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
        }
        this.hRa.unregisterListener(this, this.xhZ);
        this.hRa.unregisterListener(this);
        this.xic = false;
        this.xhY = null;
        this.xid = -1.0f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null && sensorEvent.sensor != null && this.xhZ != null && !this.xib) {
            float f = sensorEvent.values[0];
            double d = 3.0d;
            x.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", Float.valueOf(f), Float.valueOf(this.rio), Double.valueOf(3.0d), Double.valueOf(xif), Float.valueOf(this.xid), Float.valueOf(this.xhZ.getMaximumRange()));
            if (xif > 0.0d) {
                d = xif;
            }
            float maximumRange = (xif > 0.0d || this.rio < 0.0f) ? this.xhZ.getMaximumRange() : this.rio;
            x.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", Float.valueOf(Math.max(0.1f, (float) (((double) maximumRange) / d))), Float.valueOf(maximumRange));
            switch (sensorEvent.sensor.getType()) {
                case 8:
                    if (this.xhY != null && f != this.xid) {
                        if (f < r0) {
                            x.i("MicroMsg.SensorController", "sensor near-far event near false");
                            this.xhY.dT(false);
                        } else {
                            x.i("MicroMsg.SensorController", "sensor near-far event far true");
                            this.xhY.dT(true);
                        }
                        this.xid = f;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.HEADSET_PLUG")) {
                int intExtra = intent.getIntExtra("state", 0);
                if (intExtra == 1) {
                    this.xib = true;
                }
                if (intExtra == 0) {
                    this.xib = false;
                }
            }
        }
    }
}
