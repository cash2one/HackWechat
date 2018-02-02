package com.tencent.mm.plugin.dbbackup;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class d$5 implements b {
    final /* synthetic */ b lpY;
    final /* synthetic */ d lqk;
    int lqs = 0;
    final /* synthetic */ File lqt;
    final /* synthetic */ WakerLock lqu;

    d$5(d dVar, File file, b bVar, WakerLock wakerLock) {
        this.lqk = dVar;
        this.lqt = file;
        this.lpY = bVar;
        this.lqu = wakerLock;
    }

    public final void ou(int i) {
        while (true) {
            if (this.lqs > 0) {
                x.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", new Object[]{Integer.valueOf(this.lqs), Integer.valueOf(i)});
            }
            if (i == 0) {
                this.lqt.delete();
                g.pQN.a(181, 29, 1, true);
                if (this.lpY != null) {
                    this.lpY.ou(i);
                }
                this.lqu.unLock();
                return;
            } else if (i == -2) {
                this.lqt.delete();
                g.pQN.a(181, 3, 1, true);
                if (this.lpY != null) {
                    this.lpY.ou(i);
                }
                this.lqu.unLock();
                return;
            } else {
                int i2 = this.lqs + 1;
                this.lqs = i2;
                switch (i2) {
                    case 1:
                        x.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", new Object[]{Integer.valueOf(this.lqs)});
                        i = this.lqk.b(null, this);
                        break;
                    case 2:
                        x.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", new Object[]{Integer.valueOf(this.lqs)});
                        i = this.lqk.a(null, this);
                        break;
                    case 3:
                        x.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", new Object[]{Integer.valueOf(this.lqs)});
                        i = this.lqk.a(this);
                        break;
                    default:
                        this.lqt.delete();
                        g.pQN.a(181, 30, 1, true);
                        if (this.lpY != null) {
                            this.lpY.ou(i);
                        }
                        this.lqu.unLock();
                        return;
                }
                if (i == 0) {
                    return;
                }
            }
        }
    }
}
