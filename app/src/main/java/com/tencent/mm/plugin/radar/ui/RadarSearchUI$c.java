package com.tencent.mm.plugin.radar.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class RadarSearchUI$c implements OnClickListener {
    final /* synthetic */ RadarSearchUI pyy;

    RadarSearchUI$c(RadarSearchUI radarSearchUI) {
        this.pyy = radarSearchUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RadarSearchUI.a(this.pyy);
        this.pyy.finish();
    }
}
