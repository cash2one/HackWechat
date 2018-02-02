package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class m$2 implements OnClickListener {
    final /* synthetic */ Runnable icA;
    final /* synthetic */ Activity icz;

    m$2(Runnable runnable, Activity activity) {
        this.icA = runnable;
        this.icz = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(false));
        m.k(false, false);
        if (this.icA != null) {
            this.icA.run();
        }
        this.icz.getSharedPreferences(ac.cfs(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
    }
}
