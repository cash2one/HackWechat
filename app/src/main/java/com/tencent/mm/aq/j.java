package com.tencent.mm.aq;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.e;

final class j implements e {
    private f<String, Bitmap> hBi = new f(5);

    j() {
    }

    public final void n(Object obj, Object obj2) {
        this.hBi.l((String) obj, (Bitmap) obj2);
    }

    public final Object get(Object obj) {
        return this.hBi.get((String) obj);
    }

    public final Object remove(Object obj) {
        this.hBi.remove((String) obj);
        return null;
    }
}
