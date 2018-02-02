package com.tencent.mm.plugin.backup.c;

import android.os.PowerManager;
import com.tencent.mm.sdk.platformtools.ac;

class b$2 implements Runnable {
    final /* synthetic */ b kkP;

    b$2(b bVar) {
        this.kkP = bVar;
    }

    public final void run() {
        try {
            if (b.a(this.kkP) == null) {
                b.a(this.kkP, ((PowerManager) ac.getContext().getSystemService("power")).newWakeLock(26, "BackupMove Lock"));
            }
            if (!b.a(this.kkP).isHeld()) {
                b.a(this.kkP).acquire();
            }
        } catch (Throwable th) {
        }
    }
}
