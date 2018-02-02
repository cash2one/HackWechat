package com.tencent.mm.ag;

import android.graphics.Bitmap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m$a {
    List<a> hpZ = new ArrayList();
    Map<String, Integer> hqa = new HashMap();
    Map<String, WeakReference<Bitmap>> hqb = new HashMap();
    as hqc = null;

    public final void a(a aVar) {
        this.hpZ.add(aVar);
    }

    public final void b(a aVar) {
        this.hpZ.remove(aVar);
    }

    public final void LZ() {
        this.hpZ.clear();
    }

    public static String kh(String str) {
        if (g.Dh().Cy()) {
            return ((o) g.h(o.class)).Fv() + "/brand_" + com.tencent.mm.a.g.s(str.getBytes());
        }
        return "";
    }

    final void f(String str, Bitmap bitmap) {
        Bitmap bitmap2 = this.hqb.containsKey(str) ? (Bitmap) ((WeakReference) this.hqb.get(str)).get() : null;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            try {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, FileUtils.S_IWUSR, FileUtils.S_IWUSR, true);
                bitmap2 = d.a(bitmap2, true, (float) (bitmap2.getWidth() >> 1));
            } catch (OutOfMemoryError e) {
                bitmap2 = bitmap;
            }
            this.hqb.remove(str);
            this.hqb.put(str, new WeakReference(bitmap2));
        }
        if (bitmap2 != bitmap) {
            x.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[]{bitmap.toString()});
            bitmap.recycle();
        }
    }
}
