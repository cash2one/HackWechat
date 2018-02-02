package com.google.android.gms.wearable;

import com.google.android.gms.wearable.WearableListenerService.a;
import com.google.android.gms.wearable.internal.MessageEventParcelable;

class WearableListenerService$a$2 implements Runnable {
    final /* synthetic */ a bdL;
    final /* synthetic */ MessageEventParcelable bdM;

    WearableListenerService$a$2(a aVar, MessageEventParcelable messageEventParcelable) {
        this.bdL = aVar;
        this.bdM = messageEventParcelable;
    }

    public final void run() {
        this.bdL.bdJ.a(this.bdM);
    }
}
