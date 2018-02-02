package com.tencent.mm.performance.wxperformancetool;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ca.b;

class MemoryLeakActivity$2 implements OnClickListener {
    final /* synthetic */ MemoryLeakActivity ibE;
    final /* synthetic */ String ibF;

    MemoryLeakActivity$2(MemoryLeakActivity memoryLeakActivity, String str) {
        this.ibE = memoryLeakActivity;
        this.ibF = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.Yk(this.ibF);
        if (MemoryLeakActivity.b(this.ibE) != null && MemoryLeakActivity.b(this.ibE).isShowing()) {
            MemoryLeakActivity.b(this.ibE).dismiss();
        }
        this.ibE.finish();
    }
}
