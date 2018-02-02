package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class m implements v {
    public final void nK(String str) {
        final r nr = o.TU().nr(str);
        if (nr != null) {
            o.TU();
            final String nt = s.nt(str);
            aqc com_tencent_mm_protocal_c_aqc = nr.hVR;
            VideoTransPara MV = d.MU().MV();
            if (com_tencent_mm_protocal_c_aqc != null) {
                x.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", Integer.valueOf(com_tencent_mm_protocal_c_aqc.wwQ), str, nt);
                if (com_tencent_mm_protocal_c_aqc.wwQ > 1) {
                    t.ny(str);
                    return;
                }
            }
            boolean a = l.a(nt, MV, com_tencent_mm_protocal_c_aqc, new d(this) {
                final /* synthetic */ m ota;

                public final boolean aZb() {
                    x.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", nt);
                    nr.hlp = s.nv(nt);
                    nr.fDt = 32;
                    o.TU().b(nr);
                    return true;
                }
            });
            if (com_tencent_mm_protocal_c_aqc != null) {
                x.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", str, Boolean.valueOf(a));
                com_tencent_mm_protocal_c_aqc.wwT = !a;
                nr.hVR = com_tencent_mm_protocal_c_aqc;
                nr.fDt = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                o.TU().b(nr);
            }
            if (a) {
                if (com_tencent_mm_protocal_c_aqc != null) {
                    com_tencent_mm_protocal_c_aqc.wwQ++;
                    nr.hVR = com_tencent_mm_protocal_c_aqc;
                }
                nr.fDt = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                o.TU().b(nr);
                c.sF(nr.hVI);
                if (l.b(nt, MV, com_tencent_mm_protocal_c_aqc, new d(this) {
                    final /* synthetic */ m ota;

                    public final boolean aZb() {
                        c.sG(nr.hVI);
                        x.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", nt);
                        nr.hlp = s.nv(nt);
                        nr.fDt = 32;
                        o.TU().b(nr);
                        return true;
                    }
                }) < 0) {
                    x.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
                    g.pQN.a(440, 45, 1, false);
                    t.ny(str);
                } else if (com_tencent_mm_protocal_c_aqc != null) {
                    com_tencent_mm_protocal_c_aqc.wwT = true;
                    nr.hVR = com_tencent_mm_protocal_c_aqc;
                    nr.fDt = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                    o.TU().b(nr);
                }
            }
        }
    }
}
