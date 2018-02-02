package com.tencent.mm.plugin.sns;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.sns.a.a;
import com.tencent.mm.plugin.sns.a.a.d;
import com.tencent.mm.plugin.sns.a.a.e;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.p;

public class PluginSns extends f implements b {
    l qyl = new l();
    a qym = new a();
    o qyn = new o();
    a qyo = new a();

    public void dependency() {
        dependsOn(c.class);
    }

    public void configure(g gVar) {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.a(i.class, this.qyl);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sns.b.c.class, this.qyo);
        a aVar = this.qyo;
        aVar.a(new e());
        aVar.a(new d());
        aVar.a(new com.tencent.mm.plugin.sns.a.a.b());
        aVar.a(new com.tencent.mm.plugin.sns.a.a.c());
        if (gVar.DS()) {
            x.i("MicroMsg.PluginSns", "PluginSns configure");
            pin(new p(ae.class));
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sns.b.a.class, this.qym);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.a(m.class, this.qyn);
        }
    }

    public void execute(g gVar) {
        com.tencent.mm.bm.c.Tb("sns");
    }

    public String getAccSnsPath() {
        return com.tencent.mm.kernel.g.Dj().gQi + "sns/";
    }

    public String getAccSnsTmpPath() {
        return com.tencent.mm.kernel.g.Dj().gQi + "sns/temp/";
    }
}
