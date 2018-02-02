package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;

class a$1 implements c {
    final /* synthetic */ String fgU;
    final /* synthetic */ MMActivity jiF;
    final /* synthetic */ a jiG;

    a$1(a aVar, MMActivity mMActivity, String str) {
        this.jiG = aVar;
        this.jiF = mMActivity;
        this.fgU = str;
    }

    public final void jl(int i) {
        Intent intent;
        switch (i) {
            case 0:
                intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                a.a(this.jiG, intent, this.jiF, this.fgU);
                this.jiF.startActivity(intent);
                this.jiF.startActivityForResult(intent, hashCode() & 65535);
                return;
            case 1:
                intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                intent.setType("vnd.android.cursor.item/person");
                a.a(this.jiG, intent, this.jiF, this.fgU);
                this.jiF.startActivityForResult(intent, hashCode() & 65535);
                return;
            default:
                return;
        }
    }
}
