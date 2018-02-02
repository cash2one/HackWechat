package com.tencent.mm.plugin.radar.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.i;

final class RadarMemberView$m implements OnClickListener {
    final /* synthetic */ RadarMemberView pyq;

    RadarMemberView$m(RadarMemberView radarMemberView) {
        this.pyq = radarMemberView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (RadarMemberView.g(this.pyq) != null) {
            i g = RadarMemberView.g(this.pyq);
            if (g != null) {
                g.dismiss();
            }
            RadarMemberView.h(this.pyq);
        }
        RadarMemberView.i(this.pyq);
    }
}
