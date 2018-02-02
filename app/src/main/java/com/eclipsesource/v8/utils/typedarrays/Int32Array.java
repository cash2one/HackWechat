package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class Int32Array extends TypedArray {
    public Int32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }

    public int get(int i) {
        return this.buffer.asIntBuffer().get(i);
    }

    public int length() {
        return this.buffer.asIntBuffer().limit();
    }

    public void put(int i, int i2) {
        this.buffer.asIntBuffer().put(i, i2);
    }

    public int getType() {
        return 1;
    }
}
