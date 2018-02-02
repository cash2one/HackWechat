package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.d;

public final class f implements com.tencent.mm.modelappbrand.a.b.f {
    public static final f hkr = new f();

    public final Bitmap k(Bitmap bitmap) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return bitmap;
        }
        return d.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
    }

    public final String Jo() {
        return "WxaIcon";
    }
}
