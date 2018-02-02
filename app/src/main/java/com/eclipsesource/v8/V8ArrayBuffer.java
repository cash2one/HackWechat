package com.eclipsesource.v8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class V8ArrayBuffer extends V8Value {
    private ByteBuffer byteBuffer;

    public V8ArrayBuffer(V8 v8, int i) {
        super(v8);
        initialize(v8.getV8RuntimePtr(), Integer.valueOf(i));
        this.byteBuffer = v8.createV8ArrayBufferBackingStore(v8.getV8RuntimePtr(), this.objectHandle, i);
        this.byteBuffer.order(ByteOrder.nativeOrder());
    }

    public V8ArrayBuffer(V8 v8, ByteBuffer byteBuffer) {
        super(v8);
        if (byteBuffer.isDirect()) {
            initialize(v8.getV8RuntimePtr(), byteBuffer);
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.nativeOrder());
            return;
        }
        throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }

    protected void initialize(long j, Object obj) {
        this.v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), byteBuffer, byteBuffer.limit());
        } else {
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), ((Integer) obj).intValue());
        }
        this.released = false;
        addObjectReference(this.objectHandle);
    }

    protected V8Value createTwin() {
        return new V8ArrayBuffer(this.v8, this.byteBuffer);
    }

    public V8ArrayBuffer twin() {
        return (V8ArrayBuffer) super.twin();
    }

    public ByteBuffer getBackingStore() {
        this.v8.checkReleased();
        this.v8.checkThread();
        return this.byteBuffer;
    }
}
