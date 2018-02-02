package com.tencent.mm.plugin.messenger;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

public class PluginMessenger extends f implements c, com.tencent.mm.plugin.messenger.a.c {
    a oof = new a();
    private a oog = new a();
    private b ooh = new 1(this);
    private e.a ooi = new 2(this);
    private e.a ooj = new e.a(this) {
        final /* synthetic */ PluginMessenger oom;

        {
            this.oom = r1;
        }

        public final String g(Map<String, String> map, String str) {
            if (map == null) {
                return null;
            }
            return bh.ou((String) map.get(str + ".title"));
        }
    };
    private e.a ook = new 4(this);
    private e.a ool = new 5(this);

    public void installed() {
        alias(com.tencent.mm.plugin.messenger.a.c.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }

    public void configure(g gVar) {
        if (gVar.DS()) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.a.b.class, this.oof);
            com.tencent.mm.kernel.g.a(e.class, this.oog);
        }
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            pin(com.tencent.mm.plugin.ad.a.bnl());
        }
    }

    public String toString() {
        return "plugin-messenger";
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("sysmsgtemplate", this.oog.opj);
        ((e) com.tencent.mm.kernel.g.h(e.class)).a("link_plain", this.ooh);
        ((e) com.tencent.mm.kernel.g.h(e.class)).a("link_plain", this.ooi);
        ((e) com.tencent.mm.kernel.g.h(e.class)).a("link_revoke", this.ooj);
        ((e) com.tencent.mm.kernel.g.h(e.class)).a("link_revoke_qrcode", this.ook);
        ((e) com.tencent.mm.kernel.g.h(e.class)).a("link_profile", this.ool);
    }

    public void onAccountRelease() {
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("sysmsgtemplate", this.oog.opj);
        ((e) com.tencent.mm.kernel.g.h(e.class)).Eo("link_plain");
        ((e) com.tencent.mm.kernel.g.h(e.class)).Ep("link_plain");
        ((e) com.tencent.mm.kernel.g.h(e.class)).Ep("link_revoke");
        ((e) com.tencent.mm.kernel.g.h(e.class)).Ep("link_revoke_qrcode");
        ((e) com.tencent.mm.kernel.g.h(e.class)).Ep("link_profile");
    }
}
