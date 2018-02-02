package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;

class e$5 implements Runnable {
    final /* synthetic */ long kxD;
    final /* synthetic */ e kxy;

    public e$5(e eVar, long j) {
        this.kxy = eVar;
        this.kxD = j;
    }

    public final void run() {
        f fVar = (f) this.kxy.kwL.remove(Long.valueOf(this.kxD));
        if (fVar != null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------close------, mac=%s, name=%s", new Object[]{b.cK(fVar.mSessionId), fVar.kxd.getName()});
            if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(2))) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(2)});
            }
            this.kxy.kxw.put(Long.valueOf(this.kxD), Boolean.valueOf(true));
            return;
        }
        x.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session not found! maybe ui don't handle session disconnect event correctly.");
    }
}
