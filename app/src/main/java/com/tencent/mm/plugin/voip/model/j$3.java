package com.tencent.mm.plugin.voip.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class j$3 implements OnClickListener {
    final /* synthetic */ j smu;
    final /* synthetic */ CheckBox smw;

    j$3(j jVar, CheckBox checkBox) {
        this.smu = jVar;
        this.smw = checkBox;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.smw != null) {
            j.g(this.smu).getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", this.smw.isChecked()).commit();
        }
        if (Downloads.RECV_BUFFER_SIZE != j.s(this.smu)) {
            j.c(this.smu, j.s(this.smu));
            j.t(this.smu);
        }
        j.u(this.smu).post(new 1(this));
    }
}
