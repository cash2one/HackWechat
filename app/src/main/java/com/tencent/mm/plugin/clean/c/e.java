package com.tencent.mm.plugin.clean.c;

import android.os.Looper;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.ArrayList;

public final class e extends Thread implements com.tencent.mm.plugin.clean.c.a.a.a {
    private long endTime = 0;
    private af hae = new af(Looper.getMainLooper());
    private boolean isStop;
    private h lfA;
    private ArrayList<a> lfB;
    private int lfC = 0;
    private b lfi;
    private int lfk = 0;
    private int lfl = 0;
    private long startTime = 0;

    class a extends com.tencent.mm.plugin.clean.c.a.a {
        final /* synthetic */ e lfD;
        private a lfE;

        public a(e eVar, a aVar) {
            this.lfD = eVar;
            super(eVar);
            this.lfE = aVar;
        }

        public final void execute() {
            ar.Hg();
            cf dH = c.Fa().dH(this.lfE.fpG);
            if (dH.field_msgId != 0) {
                dH.cjt();
                ar.Hg();
                c.Fa().a(this.lfE.fpG, dH);
            }
            File file = new File(this.lfE.filePath);
            this.lfD.lfC = (int) (((long) this.lfD.lfC) + file.length());
            file.delete();
        }
    }

    public e(b bVar, h hVar, ArrayList<a> arrayList) {
        this.lfi = bVar;
        this.lfA = hVar;
        this.lfB = arrayList;
    }

    public final void run() {
        this.startTime = System.currentTimeMillis();
        this.lfk = this.lfB.size();
        x.d("MicroMsg.DeleteFileController", "totalTaskCount=%d", new Object[]{Integer.valueOf(this.lfk)});
        if (this.lfk == 0) {
            ayb();
            return;
        }
        int i = 0;
        while (!this.isStop && i < this.lfB.size()) {
            x.d("MicroMsg.DeleteFileController", "while loop index=%d | filePath=%s", new Object[]{Integer.valueOf(i), ((a) this.lfB.get(i)).filePath});
            com.tencent.mm.plugin.clean.c.a.a aVar = new a(this, r0);
            while (!this.lfi.b(aVar)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            x.d("MicroMsg.DeleteFileController", "Start task： filePath＝%s", new Object[]{r0.filePath});
            i++;
        }
    }

    private void ayb() {
        this.endTime = System.currentTimeMillis();
        x.i("MicroMsg.DeleteFileController", "totalUserTime:%d", new Object[]{Long.valueOf(this.endTime - this.startTime)});
        if (this.lfA != null && !this.isStop) {
            this.hae.post(new 2(this));
        }
    }

    public final void ayt() {
        x.i("MicroMsg.DeleteFileController", "stop analyseController");
        this.isStop = true;
        interrupt();
    }

    public final void a(com.tencent.mm.plugin.clean.c.a.a aVar) {
        interrupt();
        this.lfl++;
        if (!(this.lfA == null || this.isStop)) {
            this.hae.post(new 1(this));
        }
        if (this.lfl == this.lfk) {
            ayb();
        }
    }
}
