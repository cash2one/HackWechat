package com.tencent.mm.plugin.scanner.util;

import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.x;
import f.a;

public final class c extends a {
    public final byte[] fFw;
    public int height;
    public int left;
    final int pZL;
    final int pZM;
    public int top;
    public int width;

    public c(byte[] bArr, int i, int i2, Rect rect) {
        int i3 = 0;
        super(rect.width(), rect.height());
        x.v("MicroMsg.scanner.PlanarYUVLuminanceSource", "init yuvData.len: %d,  dataW: %d, dataH: %d, left: %d, top: %d, width: %d, height: %d ", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
        this.fFw = bArr;
        this.pZL = i;
        this.pZM = i2;
        int i4 = (rect.left < 0 || rect.left >= i) ? 0 : rect.left;
        this.left = i4;
        if (rect.top >= 0 && rect.top < i2) {
            i3 = rect.top;
        }
        this.top = i3;
        this.width = this.left + rect.width() > i ? i - this.left : rect.width();
        this.height = this.top + rect.height() > i2 ? i2 - this.top : rect.height();
        if (this.left + this.width > i || this.top + this.height > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
    }

    public final byte[] l(int i, byte[] bArr) {
        if (i < 0 || i >= this.height) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        if (bArr == null || bArr.length < this.width) {
            bArr = new byte[this.width];
        }
        System.arraycopy(this.fFw, ((this.top + i) * this.pZL) + this.left, bArr, 0, this.width);
        return bArr;
    }

    public static void bpw() {
        l bpN = l.bpN();
        if (bpN.qaV != null) {
            bpN.qaV = null;
        }
        if (bpN.qaW != null) {
            bpN.qaW = null;
        }
        System.gc();
    }

    public final byte[] bpx() {
        if (this.width == this.pZL && this.height == this.pZM) {
            return this.fFw;
        }
        try {
            int i = this.width * this.height;
            l bpN = l.bpN();
            if (bpN.qaV == null) {
                bpN.qaV = new byte[i];
            } else if (bpN.qaV.length != i) {
                bpN.qaV = null;
                bpN.qaV = new byte[i];
            }
            byte[] bArr = bpN.qaV;
            int i2 = (this.top * this.pZL) + this.left;
            if (this.width == this.pZL) {
                System.arraycopy(this.fFw, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.fFw;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.pZL;
            }
            return bArr;
        } catch (Exception e) {
            x.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.fFw.length + " dataWidth:" + this.pZL + " dataHeight:" + this.pZM + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }

    public final byte[] bpy() {
        if (this.width == this.pZL && this.height == this.pZM) {
            return this.fFw;
        }
        try {
            int i = this.width * this.height;
            byte[] bArr = new byte[i];
            int i2 = (this.top * this.pZL) + this.left;
            if (this.width == this.pZL) {
                System.arraycopy(this.fFw, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.fFw;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.pZL;
            }
            return bArr;
        } catch (Exception e) {
            x.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.fFw.length + " dataWidth:" + this.pZL + " dataHeight:" + this.pZM + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }
}
