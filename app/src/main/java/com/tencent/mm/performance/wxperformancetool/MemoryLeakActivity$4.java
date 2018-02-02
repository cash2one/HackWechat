package com.tencent.mm.performance.wxperformancetool;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class MemoryLeakActivity$4 implements OnDismissListener {
    final /* synthetic */ MemoryLeakActivity ibE;

    MemoryLeakActivity$4(MemoryLeakActivity memoryLeakActivity) {
        this.ibE = memoryLeakActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.ibE.finish();
    }
}
