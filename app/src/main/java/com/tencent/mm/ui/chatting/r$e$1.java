package com.tencent.mm.ui.chatting;

import android.os.Message;
import android.view.View;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.chatting.r.e;

class r$e$1 extends af {
    final /* synthetic */ e ytK;

    r$e$1(e eVar) {
        this.ytK = eVar;
    }

    public final void handleMessage(Message message) {
        View view = (View) message.obj;
        if (this.ytK.twe != view.getScrollY()) {
            this.ytK.rZp = true;
            this.ytK.handler.sendMessageDelayed(this.ytK.handler.obtainMessage(0, view), 5);
            this.ytK.twe = view.getScrollY();
            return;
        }
        this.ytK.rZp = false;
    }
}
