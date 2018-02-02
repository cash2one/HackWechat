package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Vector;

public final class b {
    k<b, String> hkZ = new 1(this);
    public Vector<b> hla = new Vector();
    f<String, a> mQA = new f(100, new 3(this));
    d mQB;
    private final b mQC = new b(this) {
        final /* synthetic */ b mQD;

        {
            this.mQD = r1;
        }

        public final void Bs(String str) {
            x.i("MicroMsg.GalleryCache", "now listener size : " + this.mQD.hla.size());
            for (int size = this.mQD.hla.size() - 1; size >= 0; size--) {
                b bVar;
                try {
                    bVar = (b) this.mQD.hla.get(size);
                } catch (Exception e) {
                    x.e("MicroMsg.GalleryCache", "get wathcer failed:[%s]", new Object[]{e.toString()});
                    bVar = null;
                }
                if (bVar == null) {
                    x.d("MicroMsg.GalleryCache", "get listener is null");
                } else {
                    bVar.Bs(str);
                }
            }
        }
    };

    private class a {
        Bitmap bitmap;
        final /* synthetic */ b mQD;
        private int type;

        public a(b bVar, Bitmap bitmap, int i) {
            this.mQD = bVar;
            this.bitmap = bitmap;
            this.type = i;
        }
    }

    public interface b {
        void Bs(String str);
    }

    public b() {
        d dVar = new d(new File(e.bnF + "/diskcache"));
        dVar.mQU = ac.getContext().getSharedPreferences(ac.cfs(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
        dVar.aNM();
        dVar.qj(-1);
        this.mQB = dVar;
        this.hkZ.a(this.mQC, null);
    }

    public final Bitmap getBitmap(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.GalleryCache", "null filepath");
            return null;
        } else if (this.mQA == null) {
            x.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
            return null;
        } else {
            if (this.mQA.bt(str)) {
                a aVar = (a) this.mQA.get(str);
                if (aVar == null) {
                    x.d("MicroMsg.GalleryCache", "weakreference is null");
                    this.mQA.remove(str);
                    return null;
                }
                Bitmap bitmap = aVar.bitmap;
                if (bitmap == null) {
                    this.mQA.remove(str);
                    x.i("MicroMsg.GalleryCache", "get bitmap is null");
                } else if (bitmap.isRecycled()) {
                    x.i("MicroMsg.GalleryCache", "cahce bitmap has recycled");
                    this.mQA.remove(str);
                    return null;
                } else {
                    x.i("MicroMsg.GalleryCache", "get cached bitmap:" + str);
                    return bitmap;
                }
            }
            return null;
        }
    }
}
