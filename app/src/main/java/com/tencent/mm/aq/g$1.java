package com.tencent.mm.aq;

import android.graphics.Bitmap;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements b<String, Bitmap> {
    final /* synthetic */ g hAJ;

    g$1(g gVar) {
        this.hAJ = gVar;
    }

    public final /* synthetic */ void m(Object obj, Object obj2) {
        String str = (String) obj;
        Bitmap bitmap = (Bitmap) obj2;
        if (bitmap != null && !bitmap.isRecycled()) {
            x.i("MicroMsg.ImgInfoStorage", "[preRemoveCallback] key:%s bitmap:%s", new Object[]{str, bitmap.toString()});
            bitmap.recycle();
        }
    }
}
