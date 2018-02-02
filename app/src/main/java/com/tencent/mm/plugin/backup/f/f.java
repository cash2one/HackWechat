package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.h.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static int kpd = 10000;
    public static int kpe = 5000;
    a klv;
    private int kpf = 0;
    private long kpg = 0;
    private long kph = 0;
    private boolean kpi = false;
    Boolean kpj = null;

    public f(a aVar) {
        this.klv = aVar;
    }

    public final void apZ() {
        this.kpg = bh.Wp();
        x.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[]{Long.valueOf(this.kpg)});
        this.kpi = false;
        if (this.kpf != 0) {
            this.kpf = 0;
            this.klv.mF(0);
        }
    }

    public final void aqa() {
        this.kph = this.kph == Long.MAX_VALUE ? 0 : this.kph + 1;
        e eVar = new e();
        eVar.kph = this.kph;
        try {
            x.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[]{Long.valueOf(eVar.kph)});
            b.F(eVar.toByteArray(), 9);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", e, "buf to BackupHeartBeatRequest err.", new Object[0]);
        }
    }
}
