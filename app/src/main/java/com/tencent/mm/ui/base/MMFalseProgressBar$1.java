package com.tencent.mm.ui.base;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class MMFalseProgressBar$1 extends af {
    final /* synthetic */ MMFalseProgressBar yag;

    MMFalseProgressBar$1(MMFalseProgressBar mMFalseProgressBar, Looper looper) {
        this.yag = mMFalseProgressBar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                MMFalseProgressBar.a(this.yag);
                return;
            case 1001:
                MMFalseProgressBar.b(this.yag);
                return;
            case 1002:
                MMFalseProgressBar.c(this.yag);
                return;
            case 1003:
                MMFalseProgressBar.d(this.yag);
                return;
            default:
                return;
        }
    }
}
