package com.d.a.a;

import android.os.Handler;
import com.d.a.a.d.a;

abstract class c extends d {
    private boolean bgG;

    abstract void rS();

    abstract void rT();

    c() {
    }

    synchronized void a(Handler handler, a aVar) {
        this.bgG = false;
        super.a(handler, aVar);
    }

    final synchronized void aw(boolean z) {
        if ((this.bgG ^ z) != 0) {
            this.bgG = z;
            if (this.bgG) {
                rS();
            } else {
                rT();
            }
        }
    }
}
