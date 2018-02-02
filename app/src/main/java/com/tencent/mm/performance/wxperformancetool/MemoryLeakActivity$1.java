package com.tencent.mm.performance.wxperformancetool;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import java.lang.ref.WeakReference;

class MemoryLeakActivity$1 extends af {
    final /* synthetic */ MemoryLeakActivity ibE;

    MemoryLeakActivity$1(MemoryLeakActivity memoryLeakActivity) {
        this.ibE = memoryLeakActivity;
    }

    public final void handleMessage(Message message) {
        if (((WeakReference) a.ibG.get(MemoryLeakActivity.a(this.ibE))).get() == null) {
            this.ibE.finish();
        } else {
            MemoryLeakActivity.b(this.ibE).show();
        }
    }
}
