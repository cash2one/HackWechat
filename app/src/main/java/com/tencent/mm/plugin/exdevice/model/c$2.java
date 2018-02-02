package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements Runnable {
    final /* synthetic */ ae lKA;
    final /* synthetic */ c lKz;

    c$2(c cVar, ae aeVar) {
        this.lKz = cVar;
        this.lKA = aeVar;
    }

    public final void run() {
        boolean z = true;
        Object obj = this.lKz;
        ae aeVar = this.lKA;
        if (obj.lKw == null) {
            x.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
            if (obj.lKx != null) {
                x.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
                obj.lKx.aDR();
                new ak(Looper.getMainLooper(), new c$1(obj), true).J(100, 100);
            } else {
                x.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
            }
            z = false;
        }
        if (z) {
            aeVar.a(obj.lKw, obj);
        } else {
            obj.lKy.add(aeVar);
        }
    }
}
