package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.sdk.platformtools.x;

final class b$b implements Runnable {
    final /* synthetic */ b kwS;
    private long kwW = 0;
    private long kwX = 0;

    public b$b(b bVar, long j, long j2) {
        this.kwS = bVar;
        this.kwW = j;
        this.kwX = j2;
    }

    public final void run() {
        b bVar = this.kwS;
        d dVar = new d(this.kwW, bVar.tI, bVar);
        String valueOf = String.valueOf(dVar.mSessionId);
        x.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", Integer.valueOf(dVar.hashCode()), Long.valueOf(r2), valueOf);
        d dVar2 = (d) bVar.kwL.remove(valueOf);
        if (dVar2 != null) {
            dVar2.close();
        }
        bVar.kwL.put(valueOf, dVar);
        long j = dVar.mSessionId;
        if (this.kwS.kwK != null) {
            this.kwS.kwK.b(j, this.kwW, this.kwX);
        }
    }
}
