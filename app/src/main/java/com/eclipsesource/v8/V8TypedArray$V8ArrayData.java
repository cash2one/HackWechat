package com.eclipsesource.v8;

class V8TypedArray$V8ArrayData {
    private V8ArrayBuffer buffer;
    private int offset;
    private int size;
    private int type;

    public V8TypedArray$V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
        this.buffer = v8ArrayBuffer;
        this.offset = i;
        this.size = i2;
        this.type = i3;
    }
}
