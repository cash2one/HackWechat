package com.tencent.mm.plugin.mmsight.model.a;

import android.app.ActivityManager;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;

public final class j extends a<byte[]> {
    private static int mfU = 0;
    public static final j ouM = new j();

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

    private j() {
    }

    public final synchronized void D(byte[] bArr) {
        super.aM(bArr);
    }

    public final synchronized byte[] h(Integer num) {
        byte[] bArr;
        bArr = (byte[]) super.b(num);
        if (bArr == null) {
            bArr = new byte[num.intValue()];
        }
        return bArr;
    }

    protected final long Eq() {
        if (mfU <= 0) {
            mfU = ((ActivityManager) ac.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (mfU >= WXMediaMessage.TITLE_LENGTH_LIMIT) {
            return 41943040;
        }
        return 20971520;
    }

    protected final long Er() {
        return 10485760;
    }

    public final void Es() {
        super.Es();
    }
}
