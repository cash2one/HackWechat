package com.tencent.mm.plugin.backup.backuppcmodel;

class b$2 implements Runnable {
    final /* synthetic */ b knC;

    b$2(b bVar) {
        this.knC = bVar;
    }

    public final void run() {
        try {
            if (b.a(this.knC) != null && b.a(this.knC).isHeld()) {
                b.a(this.knC).release();
            }
        } catch (Throwable th) {
        }
    }
}
