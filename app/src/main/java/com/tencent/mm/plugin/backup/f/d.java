package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ae.e;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends b {
    private e hnN;
    private z kpb = new z();
    public aa kpc = new aa();

    public d(String str, long j, long j2, String str2, String str3, LinkedList<String> linkedList, e eVar) {
        x.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(linkedList.size())});
        this.kpb.ksM = str;
        this.kpb.ktY = j;
        this.kpb.ktZ = j2;
        this.kpb.kua = str2;
        this.kpb.kub = str3;
        this.kpb.ktE = linkedList;
        this.hnN = eVar;
    }

    public final boolean apQ() {
        boolean apR = super.apR();
        if (!apR) {
            this.hnN.a(1, -2, "doScene failed", this);
        }
        return apR;
    }

    public final int getType() {
        return 15;
    }

    public final a apH() {
        return this.kpc;
    }

    public final a apI() {
        return this.kpb;
    }

    public final void mL(int i) {
        x.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
        f(0, 0, "success");
        this.hnN.a(0, 0, "", this);
    }
}
