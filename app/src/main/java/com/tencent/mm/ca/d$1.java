package com.tencent.mm.ca;

import android.os.Debug;
import android.os.Process;
import com.tencent.mm.a.p;
import com.tencent.mm.ca.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

class d$1 implements Runnable {
    final /* synthetic */ a xDj;
    final /* synthetic */ d xDk;

    d$1(d dVar, a aVar) {
        this.xDk = dVar;
        this.xDj = aVar;
    }

    public final void run() {
        try {
            Debug.stopMethodTracing();
            String str = this.xDj.savePath;
            int i = this.xDj.xDm;
            if (this.xDj.savePath == null) {
                d.b(this.xDk);
                return;
            }
            File file = new File(str);
            File file2 = new File(str.substring(0, str.lastIndexOf(46)) + ".snapshot");
            long currentTimeMillis = System.currentTimeMillis();
            file.renameTo(file2);
            file.delete();
            x.i("MicroMsg.TraceDebugManager", "TRACE xorEn last :" + (System.currentTimeMillis() - currentTimeMillis));
            Process.setThreadPriority(10);
            if (this.xDj.fJn == 6) {
                Collection arrayList = new ArrayList();
                arrayList.add(file2);
                try {
                    p.a(arrayList, new File(file2.getAbsolutePath() + ".zip"));
                    d.hae.sendEmptyMessage(1);
                    d.b(this.xDk);
                    return;
                } catch (Throwable e) {
                    x.e("MicroMsg.TraceDebugManager", "exception:%s", new Object[]{bh.i(e)});
                    x.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", new Object[]{e.getMessage()});
                    d.b(this.xDk);
                    return;
                }
            }
            if (d.a(this.xDk) == null || d.a(this.xDk).size() == 0) {
                str = d.L(file2);
                if (!bh.ov(str)) {
                    d dVar = this.xDk;
                    if (i == 1 || (i == 3 && an.isWifi(ac.getContext()))) {
                        dVar.Yl(str);
                    }
                }
            }
            d.b(this.xDk);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2));
        } catch (Throwable th) {
            d.b(this.xDk);
        }
    }
}
