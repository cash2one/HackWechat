package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import com.tencent.mm.a.f.b;

class d$1 implements b<String, Bitmap> {
    final /* synthetic */ d mTI;

    d$1(d dVar) {
        this.mTI = dVar;
    }

    public final /* synthetic */ void m(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        if (bitmap != null && !bitmap.isRecycled() && this.mTI.mTF.indexOfKey(bitmap.hashCode()) < 0) {
            bitmap.recycle();
        }
    }
}
