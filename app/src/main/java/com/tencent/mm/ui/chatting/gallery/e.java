package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.gallery.f.a;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class e implements android.support.v4.view.ViewPager.e {
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    private static long yEx = 0;
    private af hae = new af();
    private as hqc = new as(1, "chatting-image-gallery-lazy-loader");
    SparseArray<WeakReference<ImageView>> mTA = new SparseArray();
    HashMap<String, Integer> mTB = new HashMap();
    SparseArray<String> mTC = new SparseArray();
    SparseArray<Bitmap> mTD = new SparseArray();
    protected f<String, Bitmap> mTE = new f(5, new 2(this));
    protected SparseIntArray mTF = new SparseIntArray();
    private boolean mTH = false;
    private int mTL = -1;
    LinkedList<String> tj = new LinkedList();
    a yEv;
    protected f<Integer, Bitmap> yEw = new f(40, new 1(this));
    private LinkedList<Integer> yEy = new LinkedList();
    private int yi = 0;

    protected final void u(String str, Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            long width = ((long) bitmap.getWidth()) * ((long) bitmap.getHeight());
            if (mScreenHeight == 0 || mScreenWidth == 0) {
                mScreenWidth = ac.getContext().getResources().getDisplayMetrics().widthPixels;
                mScreenHeight = ac.getContext().getResources().getDisplayMetrics().heightPixels;
                yEx = ((long) mScreenWidth) * yEx;
            }
            if (width > yEx * 2) {
                i = 1;
                if (i == 0) {
                    x.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
                }
                this.mTE.l(str, bitmap);
                if (a.yEE.mTE.bt(str)) {
                    x.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                    try {
                        a.yEE.mTE.l(str, bitmap);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", e, "update preload cache failed", new Object[0]);
                        return;
                    }
                }
                return;
            }
        }
        i = 0;
        if (i == 0) {
            this.mTE.l(str, bitmap);
            if (a.yEE.mTE.bt(str)) {
                x.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                a.yEE.mTE.l(str, bitmap);
                return;
            }
            return;
        }
        x.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
    }

    public final void ax(Map<String, Bitmap> map) {
        for (String str : map.keySet()) {
            Bitmap bitmap = (Bitmap) map.get(str);
            if (bitmap != null) {
                this.mTE.put(str, bitmap);
                this.yEy.push(Integer.valueOf(bitmap.hashCode()));
                x.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[]{str, Integer.valueOf(bitmap.hashCode())});
            } else {
                x.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
            }
        }
    }

    public e(a aVar) {
        this.yEv = aVar;
    }

    final void aOt() {
        this.yEw.a(new 3(this));
        this.mTE.a(new f.a<String, Bitmap>(this) {
            final /* synthetic */ e yEz;

            {
                this.yEz = r1;
            }
        });
    }

    public final void af(int i) {
        int i2 = 0;
        this.yi = i;
        if (aOu()) {
            int[] iArr = new int[this.mTD.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.mTD.keyAt(i3);
            }
            while (i2 < iArr.length) {
                int i4 = iArr[i2];
                a(i4, (Bitmap) this.mTD.get(i4));
                i2++;
            }
        }
    }

    public final void ae(int i) {
        if (((d) this.yEv).yCR.yCT.adD) {
            if (this.mTL == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 != 0) {
                        if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                            break;
                        }
                        if (i + i2 <= i + 3) {
                            qA(i + i2);
                        }
                        if (i - i2 >= Math.max(i - 3, 0)) {
                            qA(i - i2);
                        }
                    } else {
                        qA(i);
                    }
                    i2++;
                }
            } else if (this.mTL > i) {
                qA(Math.max(i - 3, 0));
            } else if (this.mTL < i) {
                qA(i + 3);
            }
            this.mTL = i;
        }
    }

    private void qA(int i) {
        if (!this.yEw.bt(Integer.valueOf(i))) {
            ar.Dm().g(new 5(this, i), 300);
        }
    }

    private boolean aOu() {
        return this.yi == 0;
    }

    final void qz(int i) {
        if (this.mTC.get(i) != null) {
            String str = (String) this.mTC.get(i);
            this.mTA.remove(i);
            this.mTC.remove(i);
            this.mTB.remove(str);
            this.mTD.remove(i);
        }
    }

    private void a(int i, Bitmap bitmap) {
        if (this.mTA.get(i) != null) {
            ImageView imageView = (ImageView) ((WeakReference) this.mTA.get(i)).get();
            this.mTC.get(i);
            this.yEv.c(imageView, bitmap);
            qz(i);
        }
    }

    public final boolean b(ImageView imageView, int i) {
        x.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[]{Integer.valueOf(i)});
        Bitmap bitmap = (Bitmap) this.yEw.get(Integer.valueOf(i));
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        this.yEv.c(imageView, bitmap);
        return true;
    }

    final void aOv() {
        if (!this.mTH && this.tj.size() != 0) {
            String str = (String) this.tj.removeLast();
            if (this.mTB.containsKey(str)) {
                this.mTH = true;
                this.hqc.c(new 6(this, str));
            }
        }
    }

    public final void a(int i, float f, int i2) {
    }
}
