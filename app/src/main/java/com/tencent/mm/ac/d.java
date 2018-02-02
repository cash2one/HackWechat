package com.tencent.mm.ac;

import java.io.Closeable;

public interface d extends Closeable {
    int Jy();

    long getSize();

    boolean isOpen();

    void open();

    int readAt(long j, byte[] bArr, int i, int i2);
}
