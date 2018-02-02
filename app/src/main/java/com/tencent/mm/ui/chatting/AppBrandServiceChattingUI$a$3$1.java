package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.3;

class AppBrandServiceChattingUI$a$3$1 implements Runnable {
    final /* synthetic */ 3 ypX;

    AppBrandServiceChattingUI$a$3$1(3 3) {
        this.ypX = 3;
    }

    public final void run() {
        if (a.e(this.ypX.ypW)) {
            x.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.Visible", new Object[]{Boolean.valueOf(a.e(this.ypX.ypW))});
            this.ypX.ypW.Fz(0);
            return;
        }
        x.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.GONE", new Object[]{Boolean.valueOf(a.e(this.ypX.ypW))});
        this.ypX.ypW.Fz(8);
    }
}
