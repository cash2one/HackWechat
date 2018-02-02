package com.tencent.mm.plugin.backup.c;

class b$3 implements Runnable {
    final /* synthetic */ b kkP;

    b$3(b bVar) {
        this.kkP = bVar;
    }

    public final void run() {
        try {
            if (b.a(this.kkP) != null && b.a(this.kkP).isHeld()) {
                b.a(this.kkP).release();
            }
        } catch (Throwable th) {
        }
    }
}
