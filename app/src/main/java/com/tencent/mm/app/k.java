package com.tencent.mm.app;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;

public final class k {
    public static k ffB;
    public boolean ffC;
    public af ffD = new 1(this, Looper.getMainLooper());

    public static k tX() {
        if (ffB == null) {
            ffB = new k();
        }
        return ffB;
    }
}
