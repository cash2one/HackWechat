package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.r.5;
import com.tencent.mm.plugin.appbrand.config.r.a;

class r$5$1 implements a<WxaAttributes> {
    final /* synthetic */ 5 iPf;

    r$5$1(5 5) {
        this.iPf = 5;
    }

    public final /* bridge */ /* synthetic */ String aZ(Object obj) {
        return ((WxaAttributes) obj).field_syncVersion;
    }

    public final /* synthetic */ Object rb(String str) {
        return f.Zh().e(str, new String[0]);
    }

    public final String getUsername() {
        return this.iPf.gIT;
    }

    public final l ra(String str) {
        return new l(str, null);
    }
}
