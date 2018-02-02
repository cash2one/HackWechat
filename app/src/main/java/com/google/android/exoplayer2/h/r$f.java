package com.google.android.exoplayer2.h;

import java.io.IOException;

public final class r$f extends IOException {
    public r$f(Throwable th) {
        super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
    }
}
