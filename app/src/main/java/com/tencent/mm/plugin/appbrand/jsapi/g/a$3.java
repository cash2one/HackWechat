package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity.a;

class a$3 implements a {
    final /* synthetic */ b$a joY;
    final /* synthetic */ a joZ;

    a$3(a aVar, b$a com_tencent_mm_plugin_appbrand_jsapi_g_b_a) {
        this.joZ = aVar;
        this.joY = com_tencent_mm_plugin_appbrand_jsapi_g_b_a;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.joZ.hashCode() & 65535)) {
            if (i2 == -1) {
                if (this.joY != null) {
                    this.joY.a(1, null, null);
                }
            } else if (this.joY != null) {
                this.joY.a(2, null, null);
            }
        }
    }
}
