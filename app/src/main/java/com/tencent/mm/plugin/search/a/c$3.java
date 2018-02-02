package com.tencent.mm.plugin.search.a;

import com.tencent.mm.ae.d.a;
import com.tencent.mm.bc.k;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class c$3 implements m {
    final /* synthetic */ c qbq;

    c$3(c cVar) {
        this.qbq = cVar;
    }

    public final void b(String str, Map<String, String> map, a aVar) {
        if (map != null && str != null) {
            if (str.equals("mmsearch_reddot_new")) {
                x.i("MicroMsg.FTS.SubCoreSearch", "recv %s, %s", new Object[]{"mmsearch_reddot_new", map.toString()});
                int VI = bh.VI((String) map.get(".sysmsg.mmsearch_reddot_new.clear"));
                int VI2 = bh.VI((String) map.get(".sysmsg.mmsearch_reddot_new.msgid"));
                int VI3 = bh.VI((String) map.get(".sysmsg.mmsearch_reddot_new.discovery"));
                int VI4 = bh.VI((String) map.get(".sysmsg.mmsearch_reddot_new.entry"));
                int VI5 = bh.VI((String) map.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
                long VJ = bh.VJ((String) map.get(".sysmsg.mmsearch_reddot_new.expire_time"));
                int VI6 = bh.VI((String) map.get(".sysmsg.mmsearch_reddot_new.h5_version"));
                int VI7 = bh.VI((String) map.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
                String str2 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_text");
                String str3 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
                long VJ2 = bh.VJ((String) map.get(".sysmsg.mmsearch_reddot_new.timestamp"));
                k Re = k.Re();
                k.a aVar2 = null;
                switch (VI4) {
                    case 1:
                        aVar2 = Re.hLd;
                        break;
                    case 2:
                        aVar2 = Re.hLe;
                        break;
                }
                if (aVar2 == null) {
                    aVar2 = new k.a();
                }
                if (aVar2.timestamp < VJ2) {
                    aVar2.id = VI2;
                    aVar2.hLj = VI3;
                    aVar2.hLg = VI4;
                    aVar2.hLh = VI5;
                    aVar2.hLi = VJ;
                    aVar2.hKS = VI6;
                    aVar2.type = VI7;
                    aVar2.text = str2;
                    aVar2.fDI = str3;
                    aVar2.timestamp = VJ2;
                    aVar2.clear = VI;
                    aVar2.hHE = System.currentTimeMillis();
                } else {
                    x.i("SearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[]{Long.valueOf(VJ2), Long.valueOf(aVar2.timestamp)});
                }
                Re.save();
                com.tencent.mm.sdk.b.a.xef.m(new oo());
            }
        }
    }
}
