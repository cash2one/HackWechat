package com.tencent.smtt.utils;

import android.widget.Toast;
import com.tencent.smtt.utils.e.1;

class e$1$3 implements Runnable {
    final /* synthetic */ 1 Aaw;

    e$1$3(1 1) {
        this.Aaw = 1;
    }

    public final void run() {
        Toast.makeText(this.Aaw.val$context, "下载失败，请检查网络", 0).show();
    }
}
