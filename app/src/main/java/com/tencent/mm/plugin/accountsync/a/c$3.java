package com.tencent.mm.plugin.accountsync.a;

import android.content.SharedPreferences;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class c$3 extends c<bc> {
    final /* synthetic */ c ikL;

    c$3(c cVar) {
        this.ikL = cVar;
        this.xen = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("system_config_prefs", 0);
        int i = sharedPreferences.getInt("new_launch_image_sub_type", 0);
        if (bcVar.fpl.fpm == 43 && i > 0 && i == bcVar.fpl.fpn) {
            String str = bcVar.fpl.filePath;
            g.pQN.a(723, 6, 1, false);
            sharedPreferences.edit().putInt("new_launch_image_res_version", bcVar.fpl.fpo).commit();
            x.i("MicroMsg.SubCoreAccountSync", "filePath: %s", new Object[]{str});
            c.oJ(str);
        }
        return false;
    }
}
