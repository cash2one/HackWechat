package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import android.view.View.OnClickListener;
import b.c.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;

final class RadarMemberView$h implements OnClickListener {
    final /* synthetic */ RadarMemberView pyq;

    RadarMemberView$h(RadarMemberView radarMemberView) {
        this.pyq = radarMemberView;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(View view) {
        CharSequence vS;
        Object obj;
        String str = null;
        String str2 = "";
        if (RadarMemberView.c(this.pyq) != null) {
            x c = RadarMemberView.c(this.pyq);
            String vS2;
            if (c == null || !c.AC()) {
                bf EZ;
                a h = g.h(h.class);
                e.h(h, "service(IMessengerStorage::class.java)");
                com.tencent.mm.plugin.messenger.foundation.a.a.g EZ2 = ((h) h).EZ();
                c = RadarMemberView.c(this.pyq);
                bf EZ3 = EZ2.EZ(c != null ? c.getUsername() : null);
                if (EZ3 != null) {
                    vS = EZ3.vS();
                    if (vS == null || b.f.a.X(vS)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                c = RadarMemberView.c(this.pyq);
                if (c != null) {
                    vS2 = c.vS();
                } else {
                    vS2 = null;
                }
                vS = vS2;
                obj = (vS == null || b.f.a.X(vS)) ? 1 : null;
                if (obj == null) {
                    h = g.h(h.class);
                    e.h(h, "service(IMessengerStorage::class.java)");
                    EZ2 = ((h) h).EZ();
                    c = RadarMemberView.c(this.pyq);
                    if (c != null) {
                        vS2 = c.vS();
                    } else {
                        vS2 = null;
                    }
                    EZ = EZ2.EZ(vS2);
                    if (EZ != null) {
                        str2 = EZ.vO();
                    }
                }
                EZ = EZ3;
                if (EZ != null) {
                    str2 = EZ.vO();
                }
            } else {
                c = RadarMemberView.c(this.pyq);
                if (c != null) {
                    vS2 = c.vO();
                } else {
                    vS2 = null;
                }
                str2 = vS2;
            }
        }
        vS = str2;
        if (vS == null || b.f.a.X(vS)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (!(obj == null || this.pyq.pxx == null)) {
            bao com_tencent_mm_protocal_c_bao = this.pyq.pxx;
            if (com_tencent_mm_protocal_c_bao != null) {
                str = com_tencent_mm_protocal_c_bao.kub;
            }
            str2 = str;
        }
        RadarMemberView radarMemberView = this.pyq;
        if (str2 == null) {
            str2 = "";
        }
        RadarMemberView.a(radarMemberView, str2);
    }
}
