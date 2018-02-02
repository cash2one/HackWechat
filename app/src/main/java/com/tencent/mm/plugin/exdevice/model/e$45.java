package com.tencent.mm.plugin.exdevice.model;

import android.os.Build.VERSION;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.exdevice.model.e.38;
import com.tencent.mm.plugin.g.a.e.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class e$45 extends c<rc> {
    final /* synthetic */ e lLO;

    e$45(e eVar) {
        this.lLO = eVar;
        this.xen = rc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        e eVar = this.lLO;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
        int Km = ar.CG().Km();
        if (Km == 4 || Km == 6) {
            boolean z;
            String value = g.zY().getValue("DeviceAutoSyncClose");
            x.i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", new Object[]{value});
            if (bh.ov(value) || !value.equalsIgnoreCase("1")) {
                z = true;
            } else {
                x.i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
                z = false;
            }
            if (!z) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
                return false;
            } else if (!a.co(ac.getContext())) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                return false;
            } else if (a.arv()) {
                ad.aEr();
                if (d.aDS() == 1) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
                    return false;
                } else if (i.lMM.eI(false)) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
                    i.lMM.a(null, new 38(eVar));
                    return true;
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
                    return e.aDU();
                }
            } else {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                return false;
            }
        }
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", new Object[]{Integer.valueOf(Km)});
        return false;
    }
}
