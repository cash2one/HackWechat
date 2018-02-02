package com.tencent.mm.plugin.label.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class ContactLabelEditUI$1 extends af {
    final /* synthetic */ ContactLabelEditUI nOY;

    ContactLabelEditUI$1(ContactLabelEditUI contactLabelEditUI, Looper looper) {
        this.nOY = contactLabelEditUI;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 6001:
                ContactLabelEditUI.a(this.nOY);
                return;
            case 6002:
                a.ift.um();
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", Integer.valueOf(message.what));
                return;
        }
    }
}
