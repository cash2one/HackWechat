package com.tencent.qqvideo.proxy.common;

import android.content.Context;

class ConfigStorage$1 implements Runnable {
    final /* synthetic */ ConfigStorage this$0;
    private final /* synthetic */ Context val$context;

    ConfigStorage$1(ConfigStorage configStorage, Context context) {
        this.this$0 = configStorage;
        this.val$context = context;
    }

    public void run() {
        ConfigStorage.access$0(this.this$0, this.val$context);
    }
}
