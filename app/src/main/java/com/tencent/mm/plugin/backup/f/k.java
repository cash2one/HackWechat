package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;

public final class k extends b {
    private af kpE = new af();
    private ag kpF = new ag();
    private a kpG;

    public k(String str, HashMap<Long, a> hashMap, a aVar) {
        this.kpG = aVar;
        this.kpE.ksM = str;
        x.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[]{str});
        this.kpE.kuj = new LinkedList();
        this.kpE.kuk = new LinkedList();
        this.kpE.kul = new LinkedList();
        for (Long l : hashMap.keySet()) {
            a aVar2 = (a) hashMap.get(l);
            this.kpE.kuj.add(Long.valueOf(aVar2.knc));
            this.kpE.kuk.add(aVar2.knd);
            this.kpE.kul.add(aVar2.fqR);
        }
    }

    public final int getType() {
        return 13;
    }

    public final com.tencent.mm.bq.a apH() {
        return this.kpF;
    }

    public final com.tencent.mm.bq.a apI() {
        return this.kpE;
    }

    public final void mL(int i) {
        x.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
        f(0, 0, "success");
        this.kpG.x(this.kpF.kuj);
    }
}
