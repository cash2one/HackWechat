package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.d.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c extends b {
    private h nGy;

    public final int[] aTJ() {
        return new int[]{824};
    }

    public final void onStop() {
        if (this.nGy != null) {
            ar.CG().c(this.nGy);
        }
    }

    public final int LC() {
        return 5;
    }

    public final void aTK() {
    }

    public final void onDestroy() {
    }

    public final void b(com.tencent.mm.plugin.ipcall.a.a.c cVar) {
        if (this.nCP != null) {
            this.nGy = new h(this.nCP.nDx, this.nCP.nDy, this.nCP.nDz);
            ar.CG().a(this.nGy, 0);
        }
    }

    public final int aTL() {
        return SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH;
    }

    public final void aTM() {
        x.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    }

    public final void aTN() {
        x.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
    }
}
