package com.tencent.mm.compatible.b;

import android.media.AudioRecord;

public final class c extends AudioRecord {
    public c(int i, int i2, int i3, int i4) {
        super(i, i2, i3, 2, i4);
        f.fC(hashCode());
    }

    public final void release() {
        super.release();
        f.fD(hashCode());
    }
}
