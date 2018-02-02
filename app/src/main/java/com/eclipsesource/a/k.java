package com.eclipsesource.a;

import java.io.Writer;

public final class k extends l {
    private final char[] acb;

    k(char[] cArr) {
        this.acb = cArr;
    }

    protected final i a(Writer writer) {
        return new a(writer, this.acb, (byte) 0);
    }
}
