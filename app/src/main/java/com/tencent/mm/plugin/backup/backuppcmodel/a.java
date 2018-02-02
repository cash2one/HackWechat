package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.backup.a.f.b;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements com.tencent.mm.plugin.backup.b.b.a {
    public long kkC;
    private LinkedList<b> kkD = null;
    private LinkedList<b> kkE = null;
    private LinkedList<b> kkF = null;
    public boolean kkG = false;
    com.tencent.mm.plugin.backup.b.b klB;
    public boolean knu = false;
    public com.tencent.mm.plugin.backup.b.b.a knv;
    private Object lock = new Object();

    private static long y(LinkedList<b> linkedList) {
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((b) linkedList.get(0)).kiQ;
            Iterator it = linkedList.iterator();
            j = j2;
            while (it.hasNext()) {
                b bVar = (b) it.next();
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

    public final LinkedList<b> aoM() {
        if (this.kkD == null) {
            this.kkD = new LinkedList();
        }
        return this.kkD;
    }

    public final LinkedList<b> aoN() {
        if (this.kkE == null) {
            this.kkE = new LinkedList();
        }
        return this.kkE;
    }

    public final void a(int i, long j, long j2, LinkedList<b> linkedList) {
        if (i == 0) {
            this.kkE = new LinkedList(linkedList);
            return;
        }
        if (this.kkE == null) {
            this.kkE = new LinkedList();
        } else {
            this.kkE.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (d.aqe().aqf().Fa().o(bVar.kiP, j, j2) > 0) {
                this.kkE.add(bVar);
            }
        }
    }

    public final void z(LinkedList<b> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            this.kkF = new LinkedList();
            return;
        }
        this.kkF = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
        this.kkF.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
    }

    private LinkedList<b> aoO() {
        if (this.kkF == null) {
            this.kkF = new LinkedList();
        }
        return this.kkF;
    }

    public final void dH(boolean z) {
        x.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[]{Boolean.valueOf(z)});
        this.knu = z;
        d.aqe().aqh();
        e.post(new 1(this), "BackupPcChooseServer.calculateToChoose");
    }

    public final void v(LinkedList<b> linkedList) {
        String str = "MicroMsg.BackupPcChooseServer";
        String str2 = "onCalcuConvFinish, conv size[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        x.i(str, str2, objArr);
        this.kkG = true;
        if (linkedList == null || linkedList.size() == 0) {
            if (this.knv != null) {
                this.knv.v(linkedList);
            }
            if (this.knu) {
                e apu = b.aps().apu();
                e.knX = true;
                apu.klC.aoz();
                b.aps().aoS().stop();
                b.aps().aol().kiJ = -23;
                b.aps().apu().mK(-23);
                return;
            }
            return;
        }
        this.kkD = new LinkedList(linkedList);
        this.kkC = y(this.kkD);
        b.aps();
        SharedPreferences aoq = com.tencent.mm.plugin.backup.a.d.aoq();
        a(aoq.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), aoq.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0), aoq.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0), aoM());
        x.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(aoN().size())});
        if (this.knu) {
            z(aoN());
            b.aps().apu().A(g.u(aoO()));
            b.aps().apu().bI((long) aoO().size());
        }
        if (this.knv != null) {
            this.knv.v(aoN());
        }
    }

    public final void aoP() {
        this.kkD = null;
        this.kkF = null;
        this.kkE = null;
        this.kkG = false;
    }

    public final void cancel() {
        x.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[]{bh.cgy()});
        synchronized (this.lock) {
            if (this.klB != null) {
                this.klB.cancel();
                this.klB = null;
            }
            this.kkG = false;
        }
    }
}
