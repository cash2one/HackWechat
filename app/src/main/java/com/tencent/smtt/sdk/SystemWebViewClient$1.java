package com.tencent.smtt.sdk;

class SystemWebViewClient$1 implements Runnable {
    final /* synthetic */ SystemWebViewClient this$0;

    SystemWebViewClient$1(SystemWebViewClient systemWebViewClient) {
        this.this$0 = systemWebViewClient;
    }

    public void run() {
        SystemWebViewClient.a(this.this$0).getContext();
        if (p.gH(SystemWebViewClient.a(this.this$0).getContext())) {
            p.gI(SystemWebViewClient.a(this.this$0).getContext());
        }
    }
}
