package com.tencent.mm.plugin.accountsync.ui;

import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ContactsSyncUI$1 implements Runnable {
    final /* synthetic */ String ile;
    final /* synthetic */ ContactsSyncUI ilf;

    ContactsSyncUI$1(ContactsSyncUI contactsSyncUI, String str) {
        this.ilf = contactsSyncUI;
        this.ile = str;
    }

    public final void run() {
        x.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts [%b], oldPermission[%s], stack[%s]", new Object[]{Boolean.valueOf(a.a(this.ilf, this.ile.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)), this.ile, bh.cgy()});
        if (a.a(this.ilf, this.ile.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)) {
            this.ilf.initView();
        }
    }

    public final String toString() {
        return super.toString() + "|checkContacts";
    }
}
