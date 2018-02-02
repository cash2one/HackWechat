package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements Runnable {
    final /* synthetic */ f kpk;

    f$1(f fVar) {
        this.kpk = fVar;
    }

    public final void run() {
        while (!f.a(this.kpk).booleanValue()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            if (f.a(this.kpk).booleanValue()) {
                x.i("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                return;
            }
            long bz = bh.bz(f.b(this.kpk));
            x.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", new Object[]{Integer.valueOf(f.c(this.kpk)), Long.valueOf(f.b(this.kpk)), Long.valueOf(bz), Boolean.valueOf(f.d(this.kpk))});
            if (f.d(this.kpk)) {
                if (bz >= ((long) f.kpe) && f.c(this.kpk) != 1) {
                    x.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", new Object[]{Long.valueOf(f.b(this.kpk)), Long.valueOf(bz)});
                    f.a(this.kpk, 1);
                    f.e(this.kpk).mF(1);
                }
            } else if (bz < ((long) f.kpd)) {
                f.a(this.kpk, 0);
                f.e(this.kpk).mF(0);
            } else {
                x.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[]{Long.valueOf(f.b(this.kpk)), Long.valueOf(bz)});
                this.kpk.aqa();
                this.kpk.apZ();
                f.f(this.kpk);
            }
        }
    }
}
