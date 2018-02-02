package com.tencent.mm.plugin.radar.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class RadarSearchUI$b implements OnClickListener {
    final /* synthetic */ RadarSearchUI pyy;

    RadarSearchUI$b(RadarSearchUI radarSearchUI) {
        this.pyy = radarSearchUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pyy.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        RadarSearchUI.a(this.pyy);
        this.pyy.finish();
    }
}
