package com.tencent.mm.plugin.accountsync.model;

import android.os.Message;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends af {
    final /* synthetic */ a ikX;

    a$2(a aVar) {
        this.ikX = aVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.ikX.hOj = true;
                if (!a.a(this.ikX.huW)) {
                    this.ikX.hOj = false;
                }
                x.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[]{Boolean.valueOf(r0)});
                return;
            default:
                return;
        }
    }
}
