package com.google.android.exoplayer2.i;

import android.os.Trace;

public final class r {
    public static void beginSection(String str) {
        if (t.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (t.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
