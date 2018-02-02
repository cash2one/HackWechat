package com.tencent.mm.plugin.facedetect.model;

import android.app.ActivityManager;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a<byte[]> {
    public static final c mfT = new c();
    private static int mfU = 0;

    public final /* synthetic */ void aM(Object obj) {
        D((byte[]) obj);
    }

    protected final /* bridge */ /* synthetic */ long aN(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    protected final /* synthetic */ Comparable aO(Object obj) {
        byte[] bArr = (byte[]) obj;
        return (bArr == null || bArr.length <= 0) ? Integer.valueOf(0) : Integer.valueOf(bArr.length);
    }

    public final /* synthetic */ Object b(Integer num) {
        return h(num);
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new f(((Integer) comparable).intValue());
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return new byte[((Integer) comparable).intValue()];
    }

    public static void ct(int i, int i2) {
        x.i("MicroMsg.FaceByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(5)});
        long Wq = bh.Wq();
        for (int i3 = 0; i3 < 5; i3++) {
            mfT.D(new byte[(((i * i2) * 3) / 2)]);
        }
        x.i("MicroMsg.FaceByteArrayPool", "preloadCameraData used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
    }

    private c() {
    }

    public final synchronized void D(byte[] bArr) {
        super.aM(bArr);
    }

    public final synchronized byte[] h(Integer num) {
        byte[] bArr;
        bArr = (byte[]) super.b(num);
        if (bArr == null) {
            x.v("MicroMsg.FaceByteArrayPool", "hy: getExactSize no data");
            bArr = new byte[num.intValue()];
        } else {
            x.v("MicroMsg.FaceByteArrayPool", "hy: got exactSize data");
        }
        return bArr;
    }

    protected final long Eq() {
        if (mfU <= 0) {
            mfU = ((ActivityManager) ac.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (mfU >= WXMediaMessage.TITLE_LENGTH_LIMIT) {
            return 20971520;
        }
        return 10485760;
    }

    protected final long Er() {
        return 20971520;
    }

    public final void Es() {
        super.Es();
    }
}
