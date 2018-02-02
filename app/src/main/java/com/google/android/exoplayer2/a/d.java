package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface d {
    public static final ByteBuffer afA = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void b(ByteBuffer byteBuffer);

    void flush();

    void iA();

    ByteBuffer iB();

    boolean isActive();

    boolean it();

    int iy();

    int iz();

    boolean r(int i, int i2, int i3);

    void reset();
}
