package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class f$3 implements a {
    final /* synthetic */ p jfB;
    final /* synthetic */ AppBrandCameraView jix;
    final /* synthetic */ f jiy;

    f$3(f fVar, p pVar, AppBrandCameraView appBrandCameraView) {
        this.jiy = fVar;
        this.jfB = pVar;
        this.jix = appBrandCameraView;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Map hashMap;
        String jSONObject;
        f a;
        if (i == 16) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                hashMap = new HashMap();
                hashMap.put("cameraId", Integer.valueOf(this.jix.jib));
                jSONObject = new JSONObject(hashMap).toString();
                a = new d().a(this.jfB);
                a.mData = jSONObject;
                a.afs();
                a$a.jhZ.jhW = false;
                return;
            }
            a$a.jhZ.jhW = true;
            this.jiy.a(this.jfB, this.jix);
        } else if (i != 18) {
        } else {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                hashMap = new HashMap();
                hashMap.put("cameraId", Integer.valueOf(this.jix.jib));
                jSONObject = new JSONObject(hashMap).toString();
                a = new d().a(this.jfB);
                a.mData = jSONObject;
                a.afs();
                a$a.jhZ.jhX = false;
                return;
            }
            a$a.jhZ.jhX = true;
            this.jiy.a(this.jfB, this.jix);
        }
    }
}
