package com.google.android.gms.wearable;

import com.google.android.gms.wearable.WearableListenerService.a;
import com.google.android.gms.wearable.internal.NodeParcelable;

class WearableListenerService$a$4 implements Runnable {
    final /* synthetic */ a bdL;
    final /* synthetic */ NodeParcelable bdN;

    WearableListenerService$a$4(a aVar, NodeParcelable nodeParcelable) {
        this.bdL = aVar;
        this.bdN = nodeParcelable;
    }

    public final void run() {
        this.bdL.bdJ.b(this.bdN);
    }
}
