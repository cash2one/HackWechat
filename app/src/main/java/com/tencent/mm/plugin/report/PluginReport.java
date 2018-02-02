package com.tencent.mm.plugin.report;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PluginReport extends f implements b, b {
    private p pPG;

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(g gVar) {
        this.pPG = new p(i.class);
        com.tencent.mm.kernel.g.a(p.class, new d(this.pPG));
        d dVar = d.pPH;
        x.i("MicroMsg.ReportService", "instance set %s", com.tencent.mm.plugin.report.service.g.pQN);
        dVar.pPI = r1;
    }

    public void execute(g gVar) {
    }

    public List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"logcat/"});
        return linkedList;
    }

    public String toString() {
        return "plugin-report";
    }
}
