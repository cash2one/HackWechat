package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.camera.h.1;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class h$1$1 implements c {
    final /* synthetic */ 1 jiA;

    h$1$1(1 1) {
        this.jiA = 1;
    }

    public final void b(int i, String str, String str2, int i2, int i3) {
        if (i == 0) {
            Map hashMap = new HashMap();
            hashMap.put("tempImagePath", str);
            hashMap.put("width", Integer.valueOf(i2));
            hashMap.put("height", Integer.valueOf(i3));
            this.jiA.iZy.E(this.jiA.gOK, this.jiA.jiz.e("ok", hashMap));
            return;
        }
        this.jiA.iZy.E(this.jiA.gOK, this.jiA.jiz.e("fail:" + str2, null));
    }

    public final void I(int i, String str) {
        if (i == 0) {
            this.jiA.iZy.E(this.jiA.gOK, this.jiA.jiz.e("ok", null));
        } else {
            this.jiA.iZy.E(this.jiA.gOK, this.jiA.jiz.e("fail:" + str, null));
        }
    }

    public final void c(int i, String str, String str2, String str3) {
        x.d("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s", new Object[]{Integer.valueOf(i), str2, str3});
        if (i == 0) {
            Map hashMap = new HashMap();
            hashMap.put("tempThumbPath", str2);
            hashMap.put("tempVideoPath", str3);
            this.jiA.iZy.E(this.jiA.gOK, this.jiA.jiz.e("ok", hashMap));
            return;
        }
        this.jiA.iZy.E(this.jiA.gOK, this.jiA.jiz.e("fail:" + str, null));
    }
}
