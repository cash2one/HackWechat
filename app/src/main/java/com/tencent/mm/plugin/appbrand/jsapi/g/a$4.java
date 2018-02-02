package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity.a;

class a$4 implements a {
    final /* synthetic */ b.a joY;
    final /* synthetic */ a joZ;

    a$4(a aVar, b.a aVar2) {
        this.joZ = aVar;
        this.joY = aVar2;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.joZ.hashCode() & 65535)) {
            if (i2 == -1) {
                if (this.joY != null) {
                    this.joY.a(1, null, null);
                }
            } else if (i2 == 2) {
                if (this.joY != null) {
                    this.joY.a(2, intent != null ? intent.getStringExtra("key_result_errmsg") : "", null);
                }
            } else if (this.joY != null) {
                this.joY.a(3, null, null);
            }
        }
    }
}
