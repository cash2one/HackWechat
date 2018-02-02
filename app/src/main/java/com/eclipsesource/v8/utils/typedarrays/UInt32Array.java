package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class UInt32Array extends TypedArray {
    public UInt32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }

    public long get(int i) {
        return (long) (this.buffer.asIntBuffer().get(i) & -1);
    }

    public int length() {
        return this.buffer.asIntBuffer().limit();
    }

    public void put(int i, long j) {
        this.buffer.asIntBuffer().put(i, (int) (-1 & j));
    }

    public int getType() {
        return 15;
    }
}
