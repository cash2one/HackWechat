package com.tencent.mm.modelsfs;

import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static boolean hLV = false;
    private long hLW = 0;
    private String hLX;
    private long hLY = 0;
    private long mNativePtr = 0;

    public a(long j) {
        this.hLX = String.valueOf(j);
        init();
    }

    public a(String str) {
        this.hLX = str;
        init();
    }

    private void init() {
        x.i("MicroMsg.EncEngine", "init  key  enckey " + this.hLX + "  hashcode " + hashCode());
        this.mNativePtr = MMIMAGEENCJNI.open(this.hLX);
        try {
            x.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
        } catch (Exception e) {
            x.e("MicroMsg.EncEngine", "exception " + e.getMessage());
        }
    }

    public final void reset() {
        x.i("MicroMsg.EncEngine", "reset " + bh.cgy());
        free();
        if (this.hLY == 0) {
            init();
            this.hLW = 0;
            return;
        }
        init();
        MMIMAGEENCJNI.seek(this.mNativePtr, this.hLY, 1);
        this.hLW = this.hLY;
    }

    public final long Ru() {
        this.hLY = this.hLW;
        return this.hLY;
    }

    public final int w(byte[] bArr, int i) {
        if (this.mNativePtr == 0) {
            x.i("MicroMsg.EncEngine", "transFor " + bh.cgy().toString());
        }
        if (hLV) {
            x.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + bArr.length);
        }
        if (hLV && this.hLW < 64) {
            x.d("MicroMsg.EncEngine", "dump before _offset " + this.hLW + "  length:" + i + " " + bh.bv(bArr) + " hashcode " + hashCode());
        }
        MMIMAGEENCJNI.transFor(this.mNativePtr, bArr, this.hLW, (long) i);
        if (hLV && this.hLW < 64) {
            x.d("MicroMsg.EncEngine", "dump after _offset " + this.hLW + "  length:" + i + " " + bh.bv(bArr) + " hashcode " + hashCode());
        }
        this.hLW += (long) i;
        return i;
    }

    public final void seek(long j) {
        this.hLW = j;
        MMIMAGEENCJNI.seek(this.mNativePtr, j, 1);
    }

    public final void free() {
        x.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
        MMIMAGEENCJNI.free(this.mNativePtr);
        this.mNativePtr = 0;
    }
}
