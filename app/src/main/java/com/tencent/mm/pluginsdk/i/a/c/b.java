package com.tencent.mm.pluginsdk.i.a.c;

import java.io.IOException;

public final class b extends IOException {
    private final long fMk;
    private final long vhu;

    public b() {
        this(0, 0);
    }

    public b(long j, long j2) {
        super(String.format("contentLength: %d, requestRange:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        this.fMk = j;
        this.vhu = j2;
    }

    public final String toString() {
        return "FileSizeOutOfRangeException{contentLength=" + this.fMk + ", requestRange=" + this.vhu + '}';
    }
}
