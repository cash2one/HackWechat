package com.tencent.mm.booter;

import com.tencent.mm.booter.NotifyReceiver.NotifyService;

class NotifyReceiver$NotifyService$2 implements Runnable {
    final /* synthetic */ NotifyService gyw;

    NotifyReceiver$NotifyService$2(NotifyService notifyService) {
        this.gyw = notifyService;
    }

    public final void run() {
        this.gyw.stopForeground(true);
    }
}
