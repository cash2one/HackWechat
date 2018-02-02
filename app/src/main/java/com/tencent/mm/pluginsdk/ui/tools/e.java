package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements r$a {
    public static e vwY = null;
    public boolean hasInit = false;
    private SensorEventListener tHR;
    private float[] vwU = new float[3];
    int vwV = -10000;
    int vwW = -10000;
    private SensorManager vwX;

    public final int ccw() {
        x.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.vwV);
        return this.vwV;
    }

    public final int getPitch() {
        x.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.vwW);
        return this.vwW;
    }

    public final void ep(Context context) {
        x.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
        if (context == null) {
            x.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
            return;
        }
        if (this.vwX == null) {
            this.vwX = (SensorManager) context.getSystemService("sensor");
        }
        if (this.tHR == null) {
            this.tHR = new 1(this);
        }
        boolean registerListener = this.vwX.registerListener(this.tHR, this.vwX.getDefaultSensor(3), 3);
        this.hasInit = true;
        x.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[]{Boolean.valueOf(registerListener)});
    }

    private void ccx() {
        x.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
        if (!(this.vwX == null || this.tHR == null)) {
            x.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
            this.vwX.unregisterListener(this.tHR);
            this.vwX = null;
            this.tHR = null;
        }
        this.hasInit = false;
    }

    public final String getName() {
        return "HeadingPitchSensorMgr";
    }

    public final void bTo() {
        vwY = null;
        ccx();
    }

    public final void dP(Context context) {
        ep(context);
    }

    public final void bTp() {
        ccx();
    }
}
