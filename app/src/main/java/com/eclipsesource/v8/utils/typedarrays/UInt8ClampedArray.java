package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class UInt8ClampedArray extends TypedArray {
    public UInt8ClampedArray(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt8ClampedArray(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
    }

    public short get(int i) {
        return (short) (this.buffer.get(i) & 255);
    }

    public int length() {
        return this.buffer.limit();
    }

    public void put(int i, short s) {
        if (s > (short) 255) {
            this.buffer.put(i, (byte) -1);
        } else if (s < (short) 0) {
            this.buffer.put(i, (byte) 0);
        } else {
            this.buffer.put(i, (byte) s);
        }
    }

    public int getType() {
        return 12;
    }
}
