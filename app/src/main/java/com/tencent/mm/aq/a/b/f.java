package com.tencent.mm.aq.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mm.aq.a.c.m;
import com.tencent.mm.aq.a.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.Map.Entry;

public final class f implements m {
    private a<String, Bitmap> hEf = new a(50);
    private a<String, Bitmap> hEg = new a(10);

    public final Bitmap iG(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return this.hEf.get(str) == null ? (Bitmap) this.hEg.get(str) : (Bitmap) this.hEf.get(str);
    }

    public final void c(String str, Bitmap bitmap) {
        if (bh.ov(str)) {
            x.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            x.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
        } else {
            long j;
            if (bitmap == null || !(bitmap instanceof Bitmap)) {
                j = 0;
            } else {
                Bitmap bitmap2 = bitmap;
                if (VERSION.SDK_INT >= 12) {
                    j = (long) bitmap2.getByteCount();
                } else {
                    j = (long) (bitmap2.getHeight() * bitmap2.getRowBytes());
                }
            }
            x.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", new Object[]{str, Long.valueOf(j), bh.bx(j)});
            if (j > 524288) {
                this.hEg.put(str, bitmap);
            } else {
                this.hEf.put(str, bitmap);
            }
        }
    }

    public final void clear() {
        synchronized (this) {
            Map snapshot;
            Bitmap bitmap;
            if (this.hEf != null) {
                snapshot = this.hEf.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value : snapshot.entrySet()) {
                        bitmap = (Bitmap) value.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            x.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", new Object[]{bitmap.toString()});
                        }
                    }
                }
                this.hEf.clear();
            }
            if (this.hEg != null) {
                snapshot = this.hEg.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value2 : snapshot.entrySet()) {
                        bitmap = (Bitmap) value2.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            x.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", new Object[]{bitmap.toString()});
                        }
                    }
                }
                this.hEg.clear();
            }
        }
    }
}
