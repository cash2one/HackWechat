package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class MMCallBackScrollView$1 extends af {
    final /* synthetic */ MMCallBackScrollView pmC;

    MMCallBackScrollView$1(MMCallBackScrollView mMCallBackScrollView) {
        this.pmC = mMCallBackScrollView;
    }

    public final void handleMessage(Message message) {
        int scrollY = this.pmC.getScrollY();
        if (scrollY == MMCallBackScrollView.a(this.pmC)) {
            MMCallBackScrollView.a(this.pmC, 0);
            return;
        }
        MMCallBackScrollView.b(this.pmC, scrollY);
        MMCallBackScrollView.b(this.pmC).sendMessageDelayed(MMCallBackScrollView.b(this.pmC).obtainMessage(), 5);
        MMCallBackScrollView.a(this.pmC, 1);
    }
}
