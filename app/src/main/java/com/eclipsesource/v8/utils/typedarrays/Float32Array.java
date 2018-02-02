package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class Float32Array extends TypedArray {
    public Float32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Float32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }

    public float get(int i) {
        return this.buffer.asFloatBuffer().get(i);
    }

    public int length() {
        return this.buffer.asFloatBuffer().limit();
    }

    public void put(int i, float f) {
        this.buffer.asFloatBuffer().put(i, f);
    }

    public int getType() {
        return 16;
    }
}
