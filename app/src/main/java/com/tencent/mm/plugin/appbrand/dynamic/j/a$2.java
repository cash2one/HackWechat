package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.i;

class a$2 implements i<Bundle> {
    final /* synthetic */ a$e iUP;

    public a$2(a$e com_tencent_mm_plugin_appbrand_dynamic_j_a_e) {
        this.iUP = com_tencent_mm_plugin_appbrand_dynamic_j_a_e;
    }

    public final /* synthetic */ void as(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.iUP != null) {
            this.iUP.Q(bundle.getString("appId"), bundle.getBoolean("result"));
        }
    }
}
