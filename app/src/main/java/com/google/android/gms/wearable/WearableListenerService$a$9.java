package com.google.android.gms.wearable;

import com.google.android.gms.wearable.WearableListenerService.a;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;

class WearableListenerService$a$9 implements Runnable {
    final /* synthetic */ a bdL;
    final /* synthetic */ ChannelEventParcelable bdT;

    WearableListenerService$a$9(a aVar, ChannelEventParcelable channelEventParcelable) {
        this.bdL = aVar;
        this.bdT = channelEventParcelable;
    }

    public final void run() {
        this.bdT.a(this.bdL.bdJ);
    }
}
