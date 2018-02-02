package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.WearableListenerService.a;

class WearableListenerService$a$1 implements Runnable {
    final /* synthetic */ DataHolder bdK;
    final /* synthetic */ a bdL;

    WearableListenerService$a$1(a aVar, DataHolder dataHolder) {
        this.bdL = aVar;
        this.bdK = dataHolder;
    }

    public final void run() {
        e eVar = new e(this.bdK);
        try {
            this.bdL.bdJ.a(eVar);
        } finally {
            eVar.release();
        }
    }
}
