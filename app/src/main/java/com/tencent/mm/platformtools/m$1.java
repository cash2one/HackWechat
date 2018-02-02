package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class m$1 implements OnClickListener {
    final /* synthetic */ int hLI;
    final /* synthetic */ Runnable icA;
    final /* synthetic */ Activity icz;

    m$1(int i, Activity activity, Runnable runnable) {
        this.hLI = i;
        this.icz = activity;
        this.icA = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[]{Integer.valueOf(11438), Integer.valueOf(this.hLI)});
        g.pQN.h(11438, new Object[]{Integer.valueOf(this.hLI)});
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(true));
        m.k(true, false);
        a.Nm();
        if (this.icA != null) {
            this.icA.run();
        }
        this.icz.getSharedPreferences(ac.cfs(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
    }
}
