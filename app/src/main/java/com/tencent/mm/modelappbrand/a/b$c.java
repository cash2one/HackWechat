package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

public final class b$c implements i {
    final f<String, Reference<Bitmap>> hjX = new 1(this, 31457280);

    public final Bitmap iG(String str) {
        if (bh.ov(str)) {
            return null;
        }
        Reference reference = (Reference) this.hjX.get(str);
        if (reference == null) {
            return null;
        }
        Bitmap bitmap = (Bitmap) reference.get();
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        this.hjX.remove(str);
        return null;
    }

    public final void c(String str, Bitmap bitmap) {
        if (!bh.ov(str) && bitmap != null) {
            x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", new Object[]{str, bitmap});
            this.hjX.put(str, new SoftReference(bitmap));
        }
    }

    public final void g(Bitmap bitmap) {
        x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", new Object[]{bitmap});
        if (bitmap != null) {
            bitmap.isRecycled();
        }
    }
}
