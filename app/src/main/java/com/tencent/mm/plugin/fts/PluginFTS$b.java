package com.tencent.mm.plugin.fts;

import android.util.Log;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;

class PluginFTS$b extends a {
    final /* synthetic */ PluginFTS mJM;

    private PluginFTS$b(PluginFTS pluginFTS) {
        this.mJM = pluginFTS;
    }

    public final boolean execute() {
        g.Dk();
        if (2 != ((Integer) g.Dj().CU().get(w.a.xvW, Integer.valueOf(0))).intValue()) {
            c.aMO();
            g.Dk();
            g.Dj().CU().a(w.a.xvW, Integer.valueOf(2));
        }
        g.Dk();
        File file = new File(g.Dj().cachePath, "IndexMicroMsg.db");
        if (file.exists()) {
            file.delete();
        }
        try {
            PluginFTS pluginFTS = this.mJM;
            g.Dk();
            PluginFTS.access$202(pluginFTS, new c(g.Dj().cachePath));
            PluginFTS.access$600(this.mJM);
            PluginFTS.access$700(this.mJM);
            PluginFTS.access$800(this.mJM);
            PluginFTS.access$900(this.mJM);
        } catch (Throwable e) {
            if (!PluginFTS.mJC) {
                x.printErrStackTrace("MicroMsg.FTS.PluginFTS", e, "Index database corruption detected", new Object[0]);
                e.qb(19);
                PluginFTS.access$300(this.mJM);
                PluginFTS.access$400(this.mJM);
                PluginFTS.access$200(this.mJM).close();
                c.aMO();
                com.tencent.mm.plugin.report.service.g.pQN.c("FTS", "InitSearchTask: " + Log.getStackTraceString(e), null);
            }
        }
        return true;
    }

    public final String getName() {
        return "InitSearchTask";
    }
}
