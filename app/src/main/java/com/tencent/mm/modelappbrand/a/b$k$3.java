package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.sdk.platformtools.x;

class b$k$3 implements Runnable {
    final /* synthetic */ k hkn;
    final /* synthetic */ Bitmap hko;

    b$k$3(k kVar, Bitmap bitmap) {
        this.hkn = kVar;
        this.hko = bitmap;
    }

    public final void run() {
        k kVar = this.hkn;
        Bitmap bitmap = this.hko;
        if (bitmap == null || bitmap.isRecycled()) {
            x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", new Object[]{bitmap});
            h hVar = (h) kVar.hke.hjM.remove(kVar.Jt());
            if (hVar != null) {
                hVar.Jn();
                kVar.hke.hjL.remove(hVar);
                return;
            }
            return;
        }
        x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", new Object[]{bitmap});
        kVar.j(bitmap);
    }
}
