package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bao;

final class RadarMemberView$e implements OnClickListener {
    final /* synthetic */ RadarMemberView pyq;
    final /* synthetic */ bao pyr;

    RadarMemberView$e(RadarMemberView radarMemberView, bao com_tencent_mm_protocal_c_bao) {
        this.pyq = radarMemberView;
        this.pyr = com_tencent_mm_protocal_c_bao;
    }

    public final void onClick(View view) {
        if (this.pyq.pxy != null && RadarMemberView.a(this.pyq) != null) {
            RadarMemberView$b a = RadarMemberView.a(this.pyq);
            if (a != null) {
                a.a(this.pyr, this.pyq.pxy);
            }
            this.pyq.dismiss();
        }
    }
}
