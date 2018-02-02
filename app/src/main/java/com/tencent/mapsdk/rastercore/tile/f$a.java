package com.tencent.mapsdk.rastercore.tile;

class f$a implements Runnable {
    private boolean a = true;
    private int b = 60000;
    private /* synthetic */ f c;

    public f$a(f fVar, int i) {
        this.c = fVar;
    }

    public final void a(boolean z) {
        this.a = false;
    }

    public final void run() {
        f.a(this.c).a(false, false);
        if (this.a) {
            f.b(this.c).postDelayed(this, (long) this.b);
        }
    }
}
