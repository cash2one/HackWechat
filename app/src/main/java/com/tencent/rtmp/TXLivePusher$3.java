package com.tencent.rtmp;

import android.os.Bundle;

class TXLivePusher$3 implements Runnable {
    final /* synthetic */ TXLivePusher this$0;
    final /* synthetic */ int val$event;
    final /* synthetic */ Bundle val$param;

    TXLivePusher$3(TXLivePusher tXLivePusher, Bundle bundle, int i) {
        this.this$0 = tXLivePusher;
        this.val$param = bundle;
        this.val$event = i;
    }

    public void run() {
        if (TXLivePusher.access$200(this.this$0) != null) {
            TXLivePusher.access$200(this.this$0).setLogText(null, this.val$param, this.val$event);
        }
    }
}
