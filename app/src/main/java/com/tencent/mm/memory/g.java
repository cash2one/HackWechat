package com.tencent.mm.memory;

import java.util.Arrays;

public final class g extends a<byte[]> {
    public static final g gZX = new g();

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

    protected final /* bridge */ /* synthetic */ Comparable b(Comparable comparable) {
        return (Integer) comparable;
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new f(((Integer) comparable).intValue());
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return new byte[((Integer) comparable).intValue()];
    }

    private g() {
    }

    public final synchronized void D(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        super.aM(bArr);
    }

    protected final long Eq() {
        return 5242880;
    }

    protected final long Er() {
        return 1048576;
    }
}
