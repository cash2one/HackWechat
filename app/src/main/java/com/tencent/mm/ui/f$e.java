package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f$e.b;
import com.tencent.mm.ui.f$e.c;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

class f$e {
    final /* synthetic */ f xED;
    b xEH;
    private c xEI;
    LinkedList<Integer> xEJ;
    int xEK;

    static /* synthetic */ void a(f$e com_tencent_mm_ui_f_e) {
        int cmg;
        synchronized (com_tencent_mm_ui_f_e) {
            cmg = com_tencent_mm_ui_f_e.cmg();
            com_tencent_mm_ui_f_e.xEJ.clear();
        }
        a aVar = new a(com_tencent_mm_ui_f_e, cmg);
        if (aVar.xEL == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            f.c cVar = new f.c(aVar.xEM.xED, aVar.xEM.xED.clX());
            cmg = cVar.getCount();
            x.i(aVar.xEM.xED.TAG, "newcursor fillCursor last : %d  count %d ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(cmg)});
            b bVar = aVar.xEM.xEH;
            Message obtain = Message.obtain();
            obtain.obj = cVar;
            obtain.what = 2;
            bVar.sendMessage(obtain);
            return;
        }
        aVar.xEM.xEH.sendEmptyMessage(1);
    }

    public f$e(f fVar) {
        this.xED = fVar;
        cmd();
    }

    private void cmd() {
        this.xEH = new b(this, Looper.getMainLooper());
        this.xEI = new c(this, ar.Dm().oAt.getLooper());
    }

    private void cme() {
        c cVar = this.xEI;
        cVar.removeMessages(cVar.xER);
        cVar.removeMessages(cVar.xES);
        b bVar = this.xEH;
        bVar.xEN = true;
        bVar.removeMessages(1);
        bVar.removeMessages(2);
        this.xEJ.clear();
        this.xEK = 0;
    }

    public final synchronized void cmf() {
        x.i(this.xED.TAG, "newcursor resetQueue ");
        cme();
        cmd();
    }

    public final synchronized void quit() {
        x.i(this.xED.TAG, "newcursor quit ");
        cme();
    }

    final int cmg() {
        if (this.xEJ.size() > 1) {
            return 2;
        }
        if (this.xEJ.size() == 1) {
            return ((Integer) this.xEJ.get(0)).intValue();
        }
        return 0;
    }

    public final synchronized boolean cmh() {
        return this.xEK != 0;
    }

    final synchronized void cmi() {
        this.xEI.lastUpdateTime = System.currentTimeMillis();
    }

    final synchronized int cmj() {
        return this.xEK;
    }

    final synchronized void DL(int i) {
        if (!this.xEJ.contains(Integer.valueOf(i))) {
            this.xEJ.add(Integer.valueOf(i));
        }
        this.xEK = cmg();
        c cVar = this.xEI;
        cVar.sendEmptyMessage(cVar.xES);
    }
}
