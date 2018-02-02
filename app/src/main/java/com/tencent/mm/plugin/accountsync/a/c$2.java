package com.tencent.mm.plugin.accountsync.a;

import android.content.SharedPreferences;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.i.a.b.b;
import com.tencent.mm.pluginsdk.i.a.b.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class c$2 implements m {
    final /* synthetic */ c ikL;

    c$2(c cVar) {
        this.ikL = cVar;
    }

    public final void b(String str, Map<String, String> map, a aVar) {
        if (bh.ou(str).equals("ChangeLaunchImage") && map != null) {
            x.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", new Object[]{(String) map.get(".sysmsg.ChangeLaunchImage.BeginTime"), (String) map.get(".sysmsg.ChangeLaunchImage.EndTime"), (String) map.get(".sysmsg.ChangeLaunchImage.ResId.SubType")});
            if (!bh.G(new String[]{r0, r9, r10})) {
                g.pQN.a(723, 5, 1, false);
                int VI = bh.VI(r10);
                if (VI > 0) {
                    SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("system_config_prefs", 0);
                    sharedPreferences.edit().putLong("new_launch_image_begin_time", bh.VJ(r0)).apply();
                    sharedPreferences.edit().putInt("new_launch_image_sub_type", VI).apply();
                    sharedPreferences.edit().putLong("new_launch_image_end_time", bh.VJ(r9)).commit();
                    c.bZm();
                    c.oJ(b.ex(43, VI));
                }
            }
        }
    }
}
