package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public static Bitmap ay(byte[] bArr) {
        if (bh.bw(bArr)) {
            return null;
        }
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        long nativeInitWxAMDecoder = MMWXGFJNI.nativeInitWxAMDecoder();
        if (nativeInitWxAMDecoder == 0) {
            x.w("MicroMsg.GIF.MMWXGFUtil", "Cpan init wxam decoder failed.");
        }
        if (MMWXGFJNI.nativeDecodeBufferHeader(nativeInitWxAMDecoder, bArr, bArr.length) != 0) {
            x.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(MMWXGFJNI.nativeDecodeBufferHeader(nativeInitWxAMDecoder, bArr, bArr.length)));
        }
        if (MMWXGFJNI.nativeGetOption(nativeInitWxAMDecoder, bArr, bArr.length, iArr) != 0) {
            x.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF get option failed. result:%d", Integer.valueOf(MMWXGFJNI.nativeGetOption(nativeInitWxAMDecoder, bArr, bArr.length, iArr)));
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr[1], iArr[2], Config.ARGB_8888);
        MMWXGFJNI.nativeDecodeBufferFrame(nativeInitWxAMDecoder, null, 0, createBitmap, iArr2);
        MMWXGFJNI.nativeUninit(nativeInitWxAMDecoder);
        return createBitmap;
    }
}
