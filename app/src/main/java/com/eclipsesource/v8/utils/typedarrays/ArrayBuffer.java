package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class ArrayBuffer {
    private ByteBuffer byteBuffer;

    public ArrayBuffer(int i) {
        this.byteBuffer = ByteBuffer.allocateDirect(i);
    }

    public ArrayBuffer(byte[] bArr) {
        this.byteBuffer = ByteBuffer.allocateDirect(bArr.length);
        this.byteBuffer.put(bArr, 0, bArr.length);
    }

    public ArrayBuffer(ByteBuffer byteBuffer) {
        this.byteBuffer = validateByteBuffer(byteBuffer);
    }

    private ByteBuffer validateByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            return byteBuffer;
        }
        throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public byte getByte(int i) {
        return this.byteBuffer.get(i);
    }

    public short getUnsignedByte(int i) {
        return (short) (this.byteBuffer.get(i) & 255);
    }

    public void put(int i, byte b) {
        this.byteBuffer.put(i, b);
    }

    public int limit() {
        return this.byteBuffer.limit();
    }

    public String toString() {
        return "[object ArrayBuffer]";
    }
}
