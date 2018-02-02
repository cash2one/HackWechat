package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.a;
import java.util.Iterator;

class a$2 implements Runnable {
    final /* synthetic */ a kpJ;

    public a$2(a aVar) {
        this.kpJ = aVar;
    }

    public final void run() {
        Iterator it = this.kpJ.kpH.iterator();
        while (it.hasNext()) {
            a$a com_tencent_mm_plugin_backup_g_a_a = (a$a) it.next();
            if (com_tencent_mm_plugin_backup_g_a_a.type == 2 && com_tencent_mm_plugin_backup_g_a_a.obj != null && (com_tencent_mm_plugin_backup_g_a_a.obj instanceof String)) {
                String str = (String) com_tencent_mm_plugin_backup_g_a_a.obj;
                x.d("MicroMsg.BackupRecoverDelayData", "getContact:" + str);
                a.hfL.Q(str, "");
            } else if (com_tencent_mm_plugin_backup_g_a_a.type == 1 && com_tencent_mm_plugin_backup_g_a_a.obj != null && (com_tencent_mm_plugin_backup_g_a_a.obj instanceof String)) {
                an.bim().RD((String) com_tencent_mm_plugin_backup_g_a_a.obj);
            }
        }
        this.kpJ.kpH.clear();
    }
}
