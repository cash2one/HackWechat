package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements com.tencent.mm.sdk.platformtools.SensorController.a {
    public SensorController kCP = new SensorController(ac.getContext());
    public ay kCT = new ay(ac.getContext());
    public long kCU = -1;
    private boolean kCZ = false;
    public a nED = null;

    public interface a {
        void fX(boolean z);
    }

    public final void dT(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + z + "  hasSkip:" + this.kCZ + " tick:" + bh.bA(this.kCU) + "  lt:" + this.kCU);
        if (this.kCZ) {
            if (z) {
                z2 = false;
            }
            this.kCZ = z2;
        } else if (z || this.kCU == -1 || bh.bA(this.kCU) <= 400) {
            this.kCZ = false;
            x.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[]{Boolean.valueOf(z)});
            new ak(new 2(this, z), false).J(50, 50);
        } else {
            this.kCZ = true;
        }
    }
}
