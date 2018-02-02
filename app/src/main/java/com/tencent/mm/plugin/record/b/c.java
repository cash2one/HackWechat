package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.LinkedList;
import java.util.List;

public abstract class c<T extends b> {
    private boolean pFa = false;
    final int pFb = 3;
    private final int pFc = 300000;
    private SparseArray<a> pFd = new SparseArray();
    private LinkedList<T> pFe = new LinkedList();
    private long pFf = 0;

    private final class a {
        int ics;
        final /* synthetic */ c pFg;
        long pFh;

        private a(c cVar) {
            this.pFg = cVar;
            this.pFh = SystemClock.elapsedRealtime();
            this.ics = this.pFg.pFb;
        }
    }

    protected abstract void a(T t);

    protected abstract List<T> bmP();

    static /* synthetic */ void a(c cVar) {
        if (!cVar.pFa || System.currentTimeMillis() - cVar.pFf >= 60000) {
            a aVar;
            b bVar;
            cVar.pFf = System.currentTimeMillis();
            if (cVar.pFe.isEmpty()) {
                for (b bVar2 : cVar.bmP()) {
                    aVar = (a) cVar.pFd.get(bVar2.bmL());
                    if (aVar == null) {
                        cVar.pFd.put(bVar2.bmL(), new a());
                    } else if (aVar.ics >= 0 || SystemClock.elapsedRealtime() - aVar.pFh >= ((long) cVar.pFc)) {
                        if (aVar.ics < 0) {
                            aVar.ics = cVar.pFb;
                        }
                    }
                    x.d("MicroMsg.RecordMsgBaseService", "do add job from db, localId %d", new Object[]{Integer.valueOf(bVar2.bmL())});
                    if (!cVar.pFe.contains(bVar2)) {
                        cVar.pFe.add(bVar2);
                    }
                }
                x.i("MicroMsg.RecordMsgBaseService", "jobs list size is 0, new jobs list size[%d]", new Object[]{Integer.valueOf(cVar.pFe.size())});
            }
            if (cVar.pFe.isEmpty()) {
                x.i("MicroMsg.RecordMsgBaseService", "try to do job, but job list size is empty, return");
                cVar.finish();
                return;
            }
            byte b;
            bVar2 = (b) cVar.pFe.removeFirst();
            aVar = (a) cVar.pFd.get(bVar2.bmL());
            if (aVar == null) {
                aVar = new a();
                cVar.pFd.put(bVar2.bmL(), aVar);
            }
            aVar.ics--;
            if (aVar.ics < 0) {
                if (((long) cVar.pFc) > SystemClock.elapsedRealtime() - aVar.pFh) {
                    b = (byte) 0;
                    if (b == (byte) 0) {
                        cVar.a(bVar2);
                        cVar.pFa = true;
                        return;
                    }
                    cVar.run();
                    return;
                }
                aVar.ics = cVar.pFb - 1;
            }
            aVar.pFh = SystemClock.elapsedRealtime();
            boolean z = true;
            if (b == (byte) 0) {
                cVar.run();
                return;
            }
            cVar.a(bVar2);
            cVar.pFa = true;
            return;
        }
        x.d("MicroMsg.RecordMsgBaseService", "is working, return");
    }

    public final void run() {
        ar.Dm().F(new 1(this));
    }

    protected final void bmQ() {
        this.pFa = false;
        run();
    }

    final void finish() {
        this.pFe.clear();
        this.pFd.clear();
        this.pFa = false;
    }
}
