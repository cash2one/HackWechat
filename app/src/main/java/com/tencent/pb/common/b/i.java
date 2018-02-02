package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;
import java.lang.ref.WeakReference;

public final class i implements c {
    private WeakReference<c> zMI;

    public i(c cVar) {
        this.zMI = new WeakReference(cVar);
    }

    public final void p(int i, byte[] bArr) {
        if (this.zMI == null || this.zMI.get() == null) {
            c.m("OnRespForLongAIDLImpl fail", "callback is null, errCode=" + i);
            return;
        }
        ((c) this.zMI.get()).p(i, bArr);
    }
}
