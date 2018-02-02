package com.tencent.mm.plugin.radar.ui;

import android.os.Message;
import android.view.View;
import b.c.b.e;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.sdk.platformtools.af;

public final class RadarMemberView$d extends af {
    final /* synthetic */ RadarMemberView pyq;

    RadarMemberView$d(RadarMemberView radarMemberView) {
        this.pyq = radarMemberView;
    }

    public final void handleMessage(Message message) {
        e.i(message, "msg");
        int i = message.what;
        RadarMemberView$a radarMemberView$a = RadarMemberView.pyp;
        if (i == RadarMemberView.blH()) {
            RadarMemberView radarMemberView = this.pyq;
            bao com_tencent_mm_protocal_c_bao = this.pyq.pxx;
            RadarMemberView.a(radarMemberView, this.pyq.pxy);
            return;
        }
        i = message.what;
        radarMemberView$a = RadarMemberView.pyp;
        if (i == RadarMemberView.blI()) {
            this.pyq.setVisibility(4);
            RadarMemberView.j(this.pyq);
            View k = RadarMemberView.k(this.pyq);
            if (k != null) {
                k.setVisibility(0);
            }
            RadarMemberView$b a = RadarMemberView.a(this.pyq);
            if (a != null) {
                a.b(this.pyq.pxx, this.pyq.pxy);
            }
        }
    }
}
