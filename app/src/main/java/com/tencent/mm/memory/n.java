package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class n implements i {
    private static ConcurrentHashMap<Bitmap, Integer> hah = new ConcurrentHashMap();
    private boolean DEBUG = false;
    public Bitmap bitmap = null;
    private af hae = new af(Looper.getMainLooper());
    private boolean haf = false;
    private AtomicInteger hag = new AtomicInteger();
    private boolean hai = true;
    private Runnable haj = new 1(this);
    private int hak = 0;
    private int hal = 0;

    private n(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.hag.set(1);
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "bitmap " + bitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bh.cgy().toString());
        }
        this.haf = false;
        getAllocationByteCount();
    }

    public static n i(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new n(bitmap);
    }

    public final Bitmap EC() {
        this.hai = false;
        return this.bitmap;
    }

    public final void Ey() {
        this.hag.incrementAndGet();
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.hag + " bitmap:" + this.bitmap + " " + this + " " + bh.cgy().toString());
        }
    }

    public final void Ez() {
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.hag + " bitmap:" + this.bitmap + " " + this + " " + bh.cgy().toString());
        }
        if (this.hag.get() > 0) {
            this.hag.decrementAndGet();
            if (this.hag.get() >= 0) {
                this.hae.removeCallbacks(this.haj);
                this.hae.postDelayed(this.haj, 500);
            }
        }
    }

    public final Bitmap ED() {
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bh.cgy().toString());
        }
        return this.bitmap;
    }

    public final boolean isRecycled() {
        return this.haf || this.bitmap == null || this.bitmap.isRecycled();
    }

    public final boolean EE() {
        this.hag.decrementAndGet();
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.haf + " isMutable:" + this.hai + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hag + bh.cgy().toString());
        }
        EF();
        return true;
    }

    private boolean EF() {
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.haf + " isMutable:" + this.hai + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hag + bh.cgy().toString());
        }
        if (this.haf || this.hag.get() > 0) {
            return false;
        }
        this.haf = true;
        if (this.DEBUG) {
            hah.remove(this.bitmap);
        }
        if (!this.hai) {
            return true;
        }
        l.EA().h(this.bitmap);
        return true;
    }

    public final int getAllocationByteCount() {
        if (d.fN(19)) {
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                x.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.hak + " " + toString());
                return this.hak;
            }
            this.hak = this.bitmap.getByteCount();
            return this.hak;
        } else if (this.bitmap == null || this.bitmap.isRecycled()) {
            x.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.hal + " " + toString());
            return this.hal;
        } else {
            this.hal = this.bitmap.getAllocationByteCount();
            return this.hal;
        }
    }

    public final String toString() {
        if (!this.DEBUG) {
            return super.toString();
        }
        String str = super.toString() + " code: " + hashCode() + " attachCount: " + this.hag;
        if (this.bitmap != null) {
            return str + this.bitmap;
        }
        return str;
    }

    protected final void finalize() {
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
        }
    }

    public final String EG() {
        return this + " " + this.bitmap;
    }
}
