package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.plugin.g.a.b.b.3;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class b$3$2 implements Runnable {
    final /* synthetic */ 3 kwV;

    b$3$2(3 3) {
        this.kwV = 3;
    }

    public final void run() {
        if (!this.kwV.kwS.kwP.isEmpty()) {
            Iterator it = this.kwV.kwS.kwP.iterator();
            while (it.hasNext()) {
                x.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", (Long) it.next());
                if (this.kwV.kwS.kwK != null) {
                    this.kwV.kwS.kwK.g(r0.longValue(), false);
                }
            }
            this.kwV.kwS.kwP.clear();
        }
    }
}
