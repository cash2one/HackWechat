package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements b<String, Bitmap> {
    final /* synthetic */ e yEz;

    e$2(e eVar) {
        this.yEz = eVar;
    }

    public final /* synthetic */ void m(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        x.i("MicroMsg.ImageGalleryLazyLoader", "preRemoveCallback %s", new Object[]{(String) obj});
        if (bitmap != null && !bitmap.isRecycled() && this.yEz.mTF.indexOfKey(bitmap.hashCode()) < 0) {
            if (e.a(this.yEz).contains(Integer.valueOf(bitmap.hashCode()))) {
                e.a(this.yEz).remove(Integer.valueOf(bitmap.hashCode()));
                return;
            }
            x.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", new Object[]{bitmap.toString()});
            bitmap.recycle();
        }
    }
}
