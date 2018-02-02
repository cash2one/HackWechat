package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.api.b.a;
import com.tencent.mm.plugin.api.recordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.p;

public class PluginMMSight extends f implements a {
    public String name() {
        return "plugin-mmsight";
    }

    public void execute(g gVar) {
        if (gVar != null) {
            x.i("MicroMsg.PluginMMSight", "execute, process: %s", new Object[]{gVar.gOs});
        }
        b.oqZ = new a();
        MMSightRecordView.oqY = new e();
        com.tencent.mm.plugin.mmsight.api.a.oqW = new com.tencent.mm.plugin.api.a();
        pin(new p(e.class));
    }
}
