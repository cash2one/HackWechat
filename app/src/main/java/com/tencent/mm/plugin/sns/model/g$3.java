package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.sns.model.ak.a;
import com.tencent.mm.plugin.sns.model.ak.b;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class g$3 implements a {
    final /* synthetic */ g qTk;

    g$3(g gVar) {
        this.qTk = gVar;
    }

    public final boolean bI(Object obj) {
        String str = (String) obj;
        if (!g.a(this.qTk, str)) {
            return false;
        }
        ak a = g.a(this.qTk);
        try {
            Bitmap bitmap;
            Object obj2 = ((b) a.qWZ.get(str)).obj;
            if (obj2 instanceof Bitmap) {
                bitmap = (Bitmap) obj2;
            } else {
                WeakReference weakReference = (WeakReference) ((b) a.qWZ.get(str)).obj;
                bitmap = weakReference != null ? (Bitmap) weakReference.get() : null;
            }
            if (!(bitmap == null || bitmap.isRecycled())) {
                x.d("MicroMsg.SnsLRUMap", "remove key:" + str);
                bitmap.recycle();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsLRUMap", e, "", new Object[0]);
            x.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
        }
        x.d("MicroMsg.SnsLRUMap", "internalMap " + a.qWZ.size() + " bfSize :" + a.qWZ.size() + " o == null " + (a.qWZ.remove(str) != null));
        x.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.a(this.qTk).qWZ.size() + " listPaitSize:" + g.b(this.qTk).size());
        return true;
    }
}
