package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.b$b;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b$b {
    public b kkA;
    public b$b kkB;
    public long kkC;
    private LinkedList<f.b> kkD = null;
    private LinkedList<f.b> kkE = null;
    public LinkedList<f.b> kkF = null;
    public boolean kkG = false;
    boolean kkH = false;
    private Object lock = new Object();

    public final LinkedList<f.b> aoM() {
        if (this.kkD == null) {
            this.kkD = new LinkedList();
        }
        return this.kkD;
    }

    private static long y(LinkedList<f.b> linkedList) {
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((f.b) linkedList.get(0)).kiQ;
            Iterator it = linkedList.iterator();
            j = j2;
            while (it.hasNext()) {
                f.b bVar = (f.b) it.next();
                if (j > bVar.kiQ) {
                    j2 = bVar.kiQ;
                } else {
                    j2 = j;
                }
                j = j2;
            }
        }
        return j;
    }

    public final LinkedList<f.b> aoN() {
        if (this.kkE == null) {
            this.kkE = new LinkedList();
        }
        return this.kkE;
    }

    public final void a(int i, long j, long j2, LinkedList<f.b> linkedList) {
        if (i == 0) {
            this.kkE = new LinkedList(linkedList);
            return;
        }
        this.kkE = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f.b bVar = (f.b) it.next();
            if (d.aqe().aqf().Fa().o(bVar.kiP, j, j2) > 0) {
                this.kkE.add(bVar);
            }
        }
    }

    public final LinkedList<f.b> aoO() {
        if (this.kkF == null) {
            this.kkF = new LinkedList();
        }
        return this.kkF;
    }

    public final void aoP() {
        this.kkD = null;
        this.kkF = null;
        this.kkE = null;
        this.kkH = false;
        this.kkG = false;
    }

    public final void cancel() {
        synchronized (this.lock) {
            if (this.kkA != null) {
                this.kkA.cancel();
                this.kkA = null;
            }
        }
    }

    public final void aoQ() {
        b.aoR();
        SharedPreferences aoq = b.aoq();
        a(aoq.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), aoq.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0), aoq.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0), aoM());
    }

    public final void v(LinkedList<f.b> linkedList) {
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
        this.kkG = true;
        this.kkD = new LinkedList(linkedList);
        this.kkC = y(this.kkD);
        aoQ();
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(aoM().size()), Integer.valueOf(aoN().size()));
        if (this.kkB != null) {
            this.kkB.v(aoN());
        }
    }

    public final void a(LinkedList<f.b> linkedList, f.b bVar, int i) {
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
        this.kkD = linkedList;
        if (this.kkE != null) {
            Iterator it = this.kkE.iterator();
            while (it.hasNext()) {
                f.b bVar2 = (f.b) it.next();
                if (bVar2.kiP.equals(bVar.kiP)) {
                    bVar2.kiS = bVar.kiS;
                    bVar2.kiT = bVar.kiT;
                    break;
                }
            }
        }
        if (b.aoR().aoT().klF) {
            x.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.aoR().aol().F(13, i, linkedList.size());
            b.aoR().aoT().mz(13);
        }
        if (this.kkB != null) {
            this.kkB.a(aoN(), bVar, i);
        }
    }

    public final void w(LinkedList<f.b> linkedList) {
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
        this.kkH = true;
        this.kkD = (LinkedList) linkedList.clone();
        aoQ();
        if (b.aoR().aoT().klF) {
            x.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.aoR().aoT().apg();
        } else if (this.kkB != null) {
            this.kkB.w(linkedList);
        }
    }
}
