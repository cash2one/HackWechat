package com.tencent.mm.performance.wxperformancetool;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MemoryLeakActivity$3 implements OnClickListener {
    final /* synthetic */ MemoryLeakActivity ibE;

    MemoryLeakActivity$3(MemoryLeakActivity memoryLeakActivity) {
        this.ibE = memoryLeakActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (MemoryLeakActivity.b(this.ibE) != null && MemoryLeakActivity.b(this.ibE).isShowing()) {
            MemoryLeakActivity.b(this.ibE).dismiss();
        }
        this.ibE.finish();
    }
}
