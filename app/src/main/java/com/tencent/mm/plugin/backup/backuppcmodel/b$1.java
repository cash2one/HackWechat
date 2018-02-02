package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.PowerManager;
import com.tencent.mm.sdk.platformtools.ac;

class b$1 implements Runnable {
    final /* synthetic */ b knC;

    b$1(b bVar) {
        this.knC = bVar;
    }

    public final void run() {
        try {
            if (b.a(this.knC) == null) {
                b.a(this.knC, ((PowerManager) ac.getContext().getSystemService("power")).newWakeLock(26, "BackupPc Lock"));
            }
            if (!b.a(this.knC).isHeld()) {
                b.a(this.knC).acquire();
            }
        } catch (Throwable th) {
        }
    }
}
