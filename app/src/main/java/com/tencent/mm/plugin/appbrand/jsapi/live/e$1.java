package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class e$1 implements ITXSnapshotListener {
    final /* synthetic */ p jdJ;
    final /* synthetic */ f jiC;
    final /* synthetic */ e jlf;

    e$1(e eVar, f fVar, p pVar) {
        this.jlf = eVar;
        this.jiC = fVar;
        this.jdJ = pVar;
    }

    public final void onSnapshot(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            x.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: bitmap nil");
            this.jiC.sj(this.jlf.e("fail", null));
            return;
        }
        String str = e.gHu + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            Object obj;
            d.a(bitmap, 90, CompressFormat.JPEG, str, true);
            AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.jdJ.mAppId, str, true);
            if (attach != null) {
                obj = attach.fus;
                str = attach.hhZ;
            } else {
                String str2 = str;
            }
            x.i("MicroMsg.JsApiOperateLivePusher", "onSnapshot: actualPath:%s path:%s", new Object[]{str, obj});
            Map hashMap = new HashMap();
            hashMap.put("tempImagePath", obj);
            hashMap.put("width", Integer.valueOf(width));
            hashMap.put("height", Integer.valueOf(height));
            this.jiC.sj(this.jlf.e("ok", hashMap));
        } catch (IOException e) {
            x.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: exception %s", new Object[]{e.getMessage()});
            this.jiC.sj(this.jlf.e("fail", null));
        }
    }
}
