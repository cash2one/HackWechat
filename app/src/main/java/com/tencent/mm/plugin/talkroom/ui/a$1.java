package com.tencent.mm.plugin.talkroom.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class a$1 extends af {
    final /* synthetic */ a scu;

    a$1(a aVar) {
        this.scu = aVar;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        a.a(this.scu).dismiss();
    }
}
