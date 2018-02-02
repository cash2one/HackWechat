package com.tencent.mm.ui.widget.celltextview.a;

import android.util.LruCache;
import com.tencent.mm.ui.widget.celltextview.c.c;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;

public final class b {
    private static b zxc;
    private static Object zxe = new Object();
    public LruCache<a, a> zxd = new LruCache(200);

    private b() {
    }

    public static b czi() {
        if (zxc == null) {
            synchronized (zxe) {
                if (zxc == null) {
                    zxc = new b();
                }
            }
        }
        return zxc;
    }

    public final void a(CharSequence charSequence, float f, float f2, ArrayList<c> arrayList, ArrayList<d> arrayList2) {
        a aVar = new a(charSequence == null ? "" : charSequence.toString(), f, f2);
        if (arrayList != null) {
            if (aVar.zwZ == null) {
                aVar.zwZ = new ArrayList(arrayList.size());
            }
            aVar.zwZ.addAll(arrayList);
        }
        aVar.am(arrayList2);
        this.zxd.put(aVar, aVar);
    }
}
