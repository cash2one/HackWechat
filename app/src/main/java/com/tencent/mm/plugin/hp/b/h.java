package com.tencent.mm.plugin.hp.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Map;

public final class h implements a {
    public final void a(d.a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar.ngq == 10002) {
            String a = n.a(bwVar.vGZ);
            if (bh.ov(a)) {
                x.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
                return;
            }
            Map y = bi.y(a, "sysmsg");
            if (y != null && y.size() > 0) {
                a = (String) y.get(".sysmsg.$type");
                if (!bh.ov(a) && a.equalsIgnoreCase("checktinkerupdate")) {
                    int i;
                    int VI = bh.VI((String) y.get(".sysmsg.tinkerboots.ignorenetwork"));
                    String az = bh.az((String) y.get(".sysmsg.tinkerboots.xmlkey"), "");
                    x.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", Integer.valueOf(VI), az);
                    com.tinkerboots.sdk.a gi = com.tinkerboots.sdk.a.cJn().gi(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) com.tencent.mm.kernel.a.CA()) & 4294967295L));
                    String str = TencentLocation.NETWORK_PROVIDER;
                    if (an.isWifi(ac.getContext()) || VI == 1) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    gi.gi(str, String.valueOf(i));
                    if (!bh.ov(az)) {
                        com.tinkerboots.sdk.a.cJn().gi("xmlkey", az);
                    }
                    com.tinkerboots.sdk.a.cJn().oe(true);
                }
            }
        }
    }
}
