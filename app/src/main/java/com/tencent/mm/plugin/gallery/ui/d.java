package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class d {
    private as hqc = new as(1, "album-image-gallery-lazy-loader");
    SparseArray<WeakReference<MultiTouchImageView>> mTA = new SparseArray();
    HashMap<String, Integer> mTB = new HashMap();
    SparseArray<String> mTC = new SparseArray();
    SparseArray<Bitmap> mTD = new SparseArray();
    protected f<String, Bitmap> mTE = new f(5, new 1(this));
    protected SparseIntArray mTF = new SparseIntArray();
    c mTG;
    boolean mTH = false;
    LinkedList<String> tj = new LinkedList();
    private int yi = 0;

    public d(c cVar) {
        this.mTG = cVar;
    }

    final void aOt() {
        this.mTE.a(new 2(this));
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

    final boolean aOu() {
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
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) ((WeakReference) this.mTA.get(i)).get();
            String str = (String) this.mTC.get(i);
            if (!(bitmap == null || multiTouchImageView == null)) {
                int hashCode = bitmap.hashCode();
                int indexOfValue = this.mTF.indexOfValue(i);
                if (indexOfValue >= 0) {
                    this.mTF.removeAt(indexOfValue);
                }
                this.mTF.put(hashCode, i);
            }
            this.mTG.mTj.remove(str);
            if (!(bitmap == null || multiTouchImageView == null)) {
                c.a(multiTouchImageView, bitmap);
            }
            qz(i);
        }
    }

    final void aOv() {
        if (!this.mTH && this.tj.size() != 0) {
            String str = (String) this.tj.removeLast();
            if (this.mTB.containsKey(str)) {
                this.mTH = true;
                this.hqc.c(new 3(this, str));
            }
        }
    }
}
