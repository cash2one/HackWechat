package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends b {
    private i kpq = new i();
    public j kpr = new j();

    public h(LinkedList<String> linkedList, long j, long j2) {
        x.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[]{Integer.valueOf(linkedList.size()), Long.valueOf(j), Long.valueOf(j2)});
        this.kpq.ksQ = linkedList;
        this.kpq.ksR = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            it.next();
            this.kpq.ksR.add(Long.valueOf(j));
            this.kpq.ksR.add(Long.valueOf(j2));
        }
    }

    public final int getType() {
        return 11;
    }

    public final a apH() {
        return this.kpr;
    }

    public final a apI() {
        return this.kpq;
    }

    public final void mL(int i) {
        if (this.kpr.ksQ == null || this.kpr.ksR == null || this.kpr.ksQ.isEmpty() || this.kpr.ksQ.size() * 2 != this.kpr.ksR.size()) {
            if (!(this.kpr.ksQ == null || this.kpr.ksR == null)) {
                x.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[]{Integer.valueOf(this.kpr.ksQ.size()), Integer.valueOf(this.kpr.ksR.size())});
            }
            f(4, -1, "BackupRequestSession failed");
            return;
        }
        x.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[]{Integer.valueOf(this.kpr.ksQ.size()), this.kpr.ksQ.toString()});
        x.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[]{this.kpr.ksR.toString()});
        f(0, 0, "BackupRequestSession success");
    }
}
