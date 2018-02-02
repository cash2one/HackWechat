package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.d;

public final class o extends e<Bitmap, b> {
    public static o han = new o();

    public static class b implements Comparable {
        private String hao;
        public int height;
        public int width;

        public b(int i, int i2) {
            this.width = i;
            this.height = i2;
            this.hao = String.format("SightBitmapSize: [%s, %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }

        public final int compareTo(Object obj) {
            if (obj == null) {
                return 0;
            }
            if (!(obj instanceof b)) {
                return 0;
            }
            if (this.width == ((b) obj).width && this.height == ((b) obj).height) {
                return 0;
            }
            if (this.height * this.width > ((b) obj).width * ((b) obj).height) {
                return 1;
            }
            return -1;
        }

        public final String toString() {
            return this.hao;
        }
    }

    public final /* synthetic */ void aM(Object obj) {
        g((Bitmap) obj);
    }

    protected final /* synthetic */ long aN(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            return 0;
        }
        return (long) (d.fN(19) ? bitmap.getByteCount() : bitmap.getAllocationByteCount());
    }

    protected final /* synthetic */ Comparable aO(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        return new b(bitmap.getWidth(), bitmap.getHeight());
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new a((b) comparable);
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return b((b) comparable);
    }

    private o() {
    }

    public final synchronized Bitmap a(b bVar) {
        Bitmap bitmap;
        bitmap = (Bitmap) super.a(bVar);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = b(bVar);
        }
        return bitmap;
    }

    public final synchronized void g(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                super.aM(bitmap);
            }
        }
    }

    private static Bitmap b(b bVar) {
        return Bitmap.createBitmap(bVar.width, bVar.height, k.gZZ);
    }

    protected final long Eq() {
        return 1228800;
    }

    protected final long Er() {
        return 307200;
    }
}
