package com.tencent.map.geolocation.internal;

class TencentLogImpl$1 implements Runnable {
    final /* synthetic */ TencentLogImpl this$0;

    TencentLogImpl$1(TencentLogImpl tencentLogImpl) {
        this.this$0 = tencentLogImpl;
    }

    public void run() {
        if (TencentLogImpl.access$100(this.this$0)) {
            TencentLogImpl.access$202(this.this$0, false);
            TencentLogImpl.access$300(this.this$0).removeCallbacksAndMessages(null);
            TencentLogImpl.access$400(this.this$0).quit();
        }
    }
}
