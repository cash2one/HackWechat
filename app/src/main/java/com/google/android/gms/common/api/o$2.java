package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.api.c.b;

class o$2 implements b {
    final /* synthetic */ o aLH;

    o$2(o oVar) {
        this.aLH = oVar;
    }

    public final void dh(int i) {
        this.aLH.aKJ.lock();
        try {
            this.aLH.aLA.dh(i);
        } finally {
            this.aLH.aKJ.unlock();
        }
    }

    public final void e(Bundle bundle) {
        this.aLH.aKJ.lock();
        try {
            this.aLH.aLA.e(bundle);
        } finally {
            this.aLH.aKJ.unlock();
        }
    }
}
