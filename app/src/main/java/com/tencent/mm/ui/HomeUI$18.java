package com.tencent.mm.ui;

import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.bq.b;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.Map;

class HomeUI$18 implements m {
    final /* synthetic */ HomeUI xGv;

    HomeUI$18(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void b(String str, Map<String, String> map, a aVar) {
        if (t.ou(str).equals("showprivacypolicy") && map != null) {
            String str2 = (String) map.get(".sysmsg.showprivacypolicy.device_id");
            String str3 = (String) map.get(".sysmsg.showprivacypolicy.guidance_content");
            String str4 = (String) map.get(".sysmsg.showprivacypolicy.doublecheck_content");
            b bc = b.bc(q.yF().getBytes());
            bc.CD(16);
            x.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, guide:%s, doubleCheck:%s", new Object[]{str2, Base64.encodeToString(bc.toByteArray(), 2), str3, str4});
            if (t.ov(str2) || str2.equals(r2)) {
                if (t.ov(str3)) {
                    str3 = ac.getResources().getString(R.l.esT);
                }
                h.a(HomeUI.d(this.xGv), str3, "", ac.getResources().getString(R.l.dFw), false, new 1(this, str4));
                return;
            }
            x.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
        }
    }
}
