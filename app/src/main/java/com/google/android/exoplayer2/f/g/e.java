package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.f.a;

final class e extends a {
    public final long endTime;
    public final long startTime;

    public e(CharSequence charSequence) {
        this(charSequence, (byte) 0);
    }

    private e(CharSequence charSequence, byte b) {
        this(0, 0, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public e(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.startTime = j;
        this.endTime = j2;
    }
}
