package com.tencent.mm.plugin.accountsync.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.accountsync.ui.ContactsSyncUI.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ContactsSyncUI$a$2 implements OnClickListener {
    final /* synthetic */ a ili;
    final /* synthetic */ String ilj;
    final /* synthetic */ Context val$context;

    ContactsSyncUI$a$2(a aVar, Context context, String str) {
        this.ili = aVar;
        this.val$context = context;
        this.ilj = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(true));
        this.ili.ilf.getSharedPreferences(ac.cfs(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
        this.ili.H(this.val$context, this.ilj);
        if (this.val$context instanceof Activity) {
            ((Activity) this.val$context).finish();
        }
    }
}
