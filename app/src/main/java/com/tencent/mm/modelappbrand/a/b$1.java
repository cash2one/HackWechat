package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.a.b.k.2;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ String hjS;
    final /* synthetic */ h hjT;
    final /* synthetic */ k hjU;
    final /* synthetic */ b hjV;
    final /* synthetic */ String val$url;

    b$1(b bVar, String str, h hVar, String str2, k kVar) {
        this.hjV = bVar;
        this.hjS = str;
        this.hjT = hVar;
        this.val$url = str2;
        this.hjU = kVar;
    }

    public final void run() {
        Bitmap iC = this.hjV.iC(this.hjS);
        if (iC != null) {
            this.hjT.j(iC);
            x.d("MicroMsg.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", new Object[]{this.val$url, iC});
            return;
        }
        String Jt = this.hjU.Jt();
        b.a(this.hjV).put(this.hjT, Jt);
        b.b(this.hjV).put(Jt, this.hjT);
        this.hjT.Jm();
        k kVar = this.hjU;
        b.d(kVar.hke).i(new 2(kVar));
    }
}
