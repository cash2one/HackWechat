package com.tencent.mm.pluginsdk.k;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c {
    private SensorManager viA;
    private a viB;

    public c(Context context) {
        this.viA = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean bZL() {
        return this.viB != null;
    }

    public final void bZM() {
        if (this.viB != null) {
            a.reset();
        }
    }

    public final void a(a aVar) {
        aPV();
        if (bZO()) {
            this.viB = aVar;
            this.viA.registerListener(this.viB, this.viA.getDefaultSensor(1), 1);
            return;
        }
        x.e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
    }

    public final void aPV() {
        if (this.viB != null) {
            this.viB.onRelease();
            this.viA.unregisterListener(this.viB, this.viA.getDefaultSensor(1));
            this.viB = null;
        }
    }

    public final boolean bZN() {
        return bZO();
    }

    private boolean bZO() {
        if (this.viA == null) {
            x.e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
            return false;
        }
        List sensorList = this.viA.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        return true;
    }
}
