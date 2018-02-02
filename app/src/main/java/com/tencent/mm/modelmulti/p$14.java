package com.tencent.mm.modelmulti;

import com.tencent.mm.modelmulti.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class p$14 implements Runnable {
    final /* synthetic */ p hGP;
    final /* synthetic */ c hHb;
    final Map<String, Integer> hHc = this.hHd;
    final /* synthetic */ Map hHd;
    final /* synthetic */ a hHe;
    final /* synthetic */ File hHf;

    p$14(p pVar, Map map, a aVar, File file, c cVar) {
        this.hGP = pVar;
        this.hHd = map;
        this.hHe = aVar;
        this.hHf = file;
        this.hHb = cVar;
    }

    public final void run() {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan start fileScanResult[%s], subDirMap[%d]", new Object[]{this.hHe, Integer.valueOf(this.hHd.size())});
        long currentTimeMillis = System.currentTimeMillis();
        p.a(this.hGP, this.hHf, this.hHe, this.hHc);
        if (this.hHd.size() > 0) {
            Iterator it = this.hHd.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.hHe.hEU.add(new c$b((String) entry.getKey(), ((Integer) entry.getValue()).intValue()));
            }
        }
        this.hHe.hET = System.currentTimeMillis() - currentTimeMillis;
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan end takes[%d], emptySubDir[%d], fileScanResult[%s], tid[%d]", new Object[]{Long.valueOf(this.hHe.hET), Integer.valueOf(this.hHd.values().size()), this.hHe, Long.valueOf(Thread.currentThread().getId())});
        this.hHb.a(0, this.hHe);
    }
}
