package com.tencent.mm.plugin.accountsync.model;

import com.tencent.mm.g.a.jm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<jm> {
    final /* synthetic */ a ikX;

    a$1(a aVar) {
        this.ikX = aVar;
        this.xen = jm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.ContactsAutoSyncLogic ", "sync username=%s isUploading=%b", new Object[]{((jm) bVar).fAe.username, Boolean.valueOf(this.ikX.hOj)});
        this.ikX.ikU.add(r7.fAe.username);
        if (!this.ikX.hOj) {
            this.ikX.ikW.removeMessages(0);
            this.ikX.ikW.sendEmptyMessageDelayed(0, 10000);
        }
        return false;
    }
}
