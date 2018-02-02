package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.support.v4.b.a;
import com.tencent.mm.a.f;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.Reference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class b$c$1 extends f<String, Reference<Bitmap>> {
    private final Map<Reference<Bitmap>, Integer> hjY = new ConcurrentHashMap();
    final /* synthetic */ c hjZ;

    b$c$1(c cVar, int i) {
        this.hjZ = cVar;
        super(31457280);
    }

    protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        String str = (String) obj;
        Reference reference = (Reference) obj2;
        Reference reference2 = (Reference) obj3;
        String str2 = "MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache";
        String str3 = "entryRemoved, curSize %d KB, maxSize %d KB, oldBmp %s, newBmp %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.hjZ.hjX.size() / 10);
        objArr[1] = Integer.valueOf(this.hjZ.hjX.maxSize() / 10);
        objArr[2] = reference == null ? "null-ref" : reference.get();
        objArr[3] = reference2 == null ? "null-ref" : reference2.get();
        x.d(str2, str3, objArr);
        super.entryRemoved(z, str, reference, reference2);
        Bitmap bitmap = reference == null ? null : (Bitmap) reference.get();
        if (bitmap != (reference2 == null ? null : (Bitmap) reference2.get())) {
            this.hjZ.g(bitmap);
        }
        this.hjY.remove(reference);
    }

    protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
        Reference reference = (Reference) obj2;
        if (reference == null) {
            return 0;
        }
        Integer num = (Integer) this.hjY.get(reference);
        if (num != null && num.intValue() >= 0) {
            return num.intValue();
        }
        Bitmap bitmap = (Bitmap) reference.get();
        int b = (bitmap == null || bitmap.isRecycled()) ? 0 : a.b(bitmap);
        this.hjY.put(reference, Integer.valueOf(b));
        return b;
    }

    public final void clear() {
        x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
        super.clear();
        this.hjY.clear();
    }

    public final void a(f.a<String, Reference<Bitmap>> aVar) {
        x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear(OnClearListener)");
        super.a(aVar);
        this.hjY.clear();
    }
}
