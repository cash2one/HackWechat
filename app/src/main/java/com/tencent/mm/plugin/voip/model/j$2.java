package com.tencent.mm.plugin.voip.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class j$2 implements OnClickListener {
    final /* synthetic */ j smu;

    j$2(j jVar) {
        this.smu = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j.a(this.smu, j.g(this.smu).getSharedPreferences("voip_plugin_prefs", 0));
        if (Downloads.RECV_BUFFER_SIZE != j.s(this.smu)) {
            j.c(this.smu, j.s(this.smu));
            j.t(this.smu);
        }
        j.u(this.smu).post(new 1(this));
    }
}
