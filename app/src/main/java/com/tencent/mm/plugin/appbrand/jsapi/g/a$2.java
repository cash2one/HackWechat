package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class a$2 implements a {
    final /* synthetic */ b.a joY;
    final /* synthetic */ a joZ;

    a$2(a aVar, b.a aVar2) {
        this.joZ = aVar;
        this.joY = aVar2;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.joZ.hashCode() & 65535)) {
            if (i2 == -1) {
                Map hashMap = new HashMap();
                String az = bh.az(intent.getStringExtra("token"), "");
                String az2 = bh.az(intent.getStringExtra("bind_serial"), "");
                hashMap.put("token", az);
                hashMap.put("bindSerial", az2);
                if (this.joY != null) {
                    this.joY.a(1, null, hashMap);
                }
            } else if (this.joY != null) {
                this.joY.a(2, null, null);
            }
        }
    }
}
