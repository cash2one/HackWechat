package com.tencent.mm.plugin.accountsync.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.accountsync.ui.ContactsSyncUI.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ContactsSyncUI$a$3 implements OnClickListener {
    final /* synthetic */ a ili;
    final /* synthetic */ Context val$context;

    ContactsSyncUI$a$3(a aVar, Context context) {
        this.ili = aVar;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(false));
        this.ili.ilf.getSharedPreferences(ac.cfs(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
        if (this.val$context instanceof Activity) {
            ((Activity) this.val$context).finish();
        }
    }
}
