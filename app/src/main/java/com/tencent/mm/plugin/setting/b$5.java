package com.tencent.mm.plugin.setting;

import com.tencent.mm.ae.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Map;

class b$5 implements m {
    final /* synthetic */ b qfX;

    b$5(b bVar) {
        this.qfX = bVar;
    }

    public final void b(String str, Map<String, String> map, a aVar) {
        if (map != null) {
            String str2 = (String) map.get(".sysmsg.security");
            if (!bh.ov(str2)) {
                try {
                    int i = bh.getInt(str2, 0);
                    ar.Hg();
                    c.CU().a(w.a.USERINFO_DEVICE_PROTECT_SECURITY_STATUS_INT_SYNC, Integer.valueOf(i));
                    if (i != 0) {
                        com.tencent.mm.s.c.Bq().b(w.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, true);
                    } else {
                        com.tencent.mm.s.c.Bq().b(w.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, false);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SubCoreSetting", e, "device protect security value is not number!", new Object[0]);
                }
            }
        }
    }
}
