package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class Int16Array extends TypedArray {
    public Int16Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int16Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }

    public short get(int i) {
        return this.buffer.asShortBuffer().get(i);
    }

    public int length() {
        return this.buffer.asShortBuffer().limit();
    }

    public void put(int i, short s) {
        this.buffer.asShortBuffer().put(i, s);
    }

    public int getType() {
        return 13;
    }
}
