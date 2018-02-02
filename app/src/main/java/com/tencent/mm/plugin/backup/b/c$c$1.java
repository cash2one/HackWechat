package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b;
import com.tencent.mm.plugin.backup.b.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

class c$c$1 implements Runnable {
    final /* synthetic */ c kjY;

    c$c$1(c cVar) {
        this.kjY = cVar;
    }

    public final void run() {
        while (!this.kjY.kjv.kjn) {
            ad adVar = null;
            try {
                adVar = this.kjY.kjU.poll(500, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
            }
            x.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[]{Integer.valueOf(this.kjY.kjU.size()), adVar});
            if (adVar != null) {
                if (adVar == this.kjY.kjV) {
                    this.kjY.kjV.open();
                    return;
                }
                b bVar = (b) adVar;
                bVar.iQP = true;
                bVar.TAG = "MicroMsg.BackupPackAndSend.tag" + (bVar.iQP ? "S." : "W.") + bVar.kiO + "." + bVar.bgo;
                while (!this.kjY.kjv.kjn) {
                    Runnable runnable = null;
                    try {
                        runnable = (Runnable) bVar.kjz.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e2) {
                    }
                    if (runnable != null) {
                        long Wp = bh.Wp();
                        runnable.run();
                        String str = "MicroMsg.BackupPackAndSend.TagQueueSucker";
                        String str2 = "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s,%s]";
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(bVar.kjz.size());
                        long j = this.kjY.kjA.kjw.get();
                        String str3 = "[%s,%s,%s]";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = Long.valueOf(j);
                        objArr2[1] = Integer.valueOf(j >= 8388608 ? 1 : 0);
                        objArr2[2] = Integer.valueOf(j >= 16777216 ? 1 : 0);
                        objArr[1] = String.format(str3, objArr2);
                        objArr[2] = Long.valueOf(bh.bz(Wp));
                        objArr[3] = runnable;
                        objArr[4] = bVar;
                        objArr[5] = this.kjY.kjW;
                        objArr[6] = this.kjY.kjW != null ? Integer.valueOf(this.kjY.kjW.kjz.size()) : "null";
                        x.d(str, str2, objArr);
                        if (!bVar.iQP) {
                            break;
                        }
                    }
                }
                System.gc();
            }
        }
    }
}
