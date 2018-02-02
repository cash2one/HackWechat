package com.tencent.mm.plugin.voip_cs.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class VoipCSMainUI$10 extends a {
    final /* synthetic */ VoipCSMainUI sxP;

    VoipCSMainUI$10(VoipCSMainUI voipCSMainUI) {
        this.sxP = voipCSMainUI;
    }

    public final void eq(int i) {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from " + i);
        if (b.bIT().swV != 2) {
            return;
        }
        if (i == 4 || i == 6) {
            d bIT = b.bIT();
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = b.bIS().nEG;
            if (bIT.sko == 0) {
                bIT.sko = com_tencent_mm_plugin_voip_model_v2protocal.sob;
            }
            int netType = com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext());
            if (netType != bIT.sko) {
                x.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + bIT.sko + " to " + netType);
                try {
                    byte[] bArr = new byte[4];
                    bArr[0] = (byte) netType;
                    int appCmd = com_tencent_mm_plugin_voip_model_v2protocal.setAppCmd(301, bArr, 4);
                    if (appCmd < 0) {
                        x.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + com_tencent_mm_plugin_voip_model_v2protocal.nDF + ", roomkey=" + com_tencent_mm_plugin_voip_model_v2protocal.nDy + "]");
                    }
                    brt com_tencent_mm_protocal_c_brt = new brt();
                    com_tencent_mm_protocal_c_brt.wTq = 3;
                    com_tencent_mm_protocal_c_brt.wTr = new com.tencent.mm.bq.b(bArr, 0, 1);
                    com_tencent_mm_plugin_voip_model_v2protocal.SendRUDP(com_tencent_mm_protocal_c_brt.toByteArray(), com_tencent_mm_protocal_c_brt.toByteArray().length);
                } catch (Exception e) {
                    x.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
                }
                bIT.sko = netType;
            }
            e bIT2 = b.bIT();
            x.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + b.bIS().nEG.sod + "roomkey:" + b.bIS().nEG.nDy);
            ar.CG().a(g.CTRL_INDEX, bIT2);
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = b.bIS().nEG;
            ar.CG().a(new com.tencent.mm.plugin.voip_cs.b.c.d(com_tencent_mm_plugin_voip_model_v2protocal2.sod, com_tencent_mm_plugin_voip_model_v2protocal2.nDy), 0);
        }
    }
}
