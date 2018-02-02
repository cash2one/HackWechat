package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a implements l {
    public final b a(String str, Map<String, String> map, com.tencent.mm.ae.d.a aVar) {
        x.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", new Object[]{str, map.toString()});
        int i = -1;
        switch (str.hashCode()) {
            case -1938535405:
                if (str.equals("resendfavitem")) {
                    i = 1;
                    break;
                }
                break;
            case -1648140403:
                if (str.equals("uploadfavitem")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                com.tencent.mm.sdk.b.b fvVar = new fv();
                fvVar.fvq.type = 38;
                fvVar.fvq.fvz = (String) map.get(".sysmsg.favids");
                com.tencent.mm.sdk.b.a.xef.a(fvVar, Looper.getMainLooper());
                g.pE(1);
                break;
            case 1:
                com.tencent.mm.sdk.b.b fvVar2 = new fv();
                fvVar2.fvq.type = 39;
                fvVar2.fvq.fvz = (String) map.get(".sysmsg.favitem.favid");
                fvVar2.fvq.fvA = (String) map.get(".sysmsg.favitem.dataidlist");
                com.tencent.mm.sdk.b.a.xef.a(fvVar2, Looper.getMainLooper());
                g.pE(0);
                break;
        }
        return null;
    }
}
