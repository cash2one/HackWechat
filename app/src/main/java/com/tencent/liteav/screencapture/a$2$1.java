package com.tencent.liteav.screencapture;

import android.os.Build.VERSION;
import com.tencent.liteav.screencapture.a.2;

class a$2$1 implements Runnable {
    final /* synthetic */ 2 a;

    a$2$1(2 2) {
        this.a = 2;
    }

    public void run() {
        if (this.a.a != null) {
            this.a.a.removeCallbacksAndMessages(null);
        }
        if (this.a.b == null) {
            return;
        }
        if (VERSION.SDK_INT >= 18) {
            this.a.b.quitSafely();
        } else {
            this.a.b.quit();
        }
    }
}
