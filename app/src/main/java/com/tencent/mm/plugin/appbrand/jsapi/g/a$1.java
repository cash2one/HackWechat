package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class a$1 implements a {
    final /* synthetic */ b.a joY;
    final /* synthetic */ a joZ;

    a$1(a aVar, b.a aVar2) {
        this.joZ = aVar;
        this.joY = aVar2;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.joZ.hashCode() & 65535)) {
            if (i2 == -1) {
                if (this.joY != null) {
                    this.joY.a(1, null, null);
                }
            } else if (i2 == 5) {
                int intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                x.e("MicroMsg.AppBrandJsApiPayService", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), bh.ou(intent.getStringExtra("key_jsapi_pay_err_msg"))});
                if (this.joY != null) {
                    this.joY.a(2, r1, null);
                }
            } else if (this.joY != null) {
                this.joY.a(3, null, null);
            }
        }
    }
}
