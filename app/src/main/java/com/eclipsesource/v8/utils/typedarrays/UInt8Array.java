package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class UInt8Array extends TypedArray {
    public UInt8Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt8Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }

    public short get(int i) {
        return (short) (this.buffer.get(i) & 255);
    }

    public int length() {
        return this.buffer.limit();
    }

    public void put(int i, short s) {
        this.buffer.put(i, (byte) (s & 255));
    }

    public int getType() {
        return 11;
    }
}
