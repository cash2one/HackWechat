package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class UInt16Array extends TypedArray {
    public UInt16Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt16Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }

    public int get(int i) {
        return 65535 & this.buffer.asShortBuffer().get(i);
    }

    public int length() {
        return this.buffer.asShortBuffer().limit();
    }

    public void put(int i, int i2) {
        this.buffer.asShortBuffer().put(i, (short) (65535 & i2));
    }

    public int getType() {
        return 14;
    }
}
