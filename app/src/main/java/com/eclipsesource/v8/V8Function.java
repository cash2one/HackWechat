package com.eclipsesource.v8;

public class V8Function extends V8Object {
    public V8Function(V8 v8, JavaCallback javaCallback) {
        super(v8, javaCallback);
    }

    protected V8Function(V8 v8) {
        this(v8, null);
    }

    protected V8Value createTwin() {
        return new V8Function(this.v8);
    }

    protected void initialize(long j, Object obj) {
        if (obj == null) {
            super.initialize(j, null);
            return;
        }
        JavaCallback javaCallback = (JavaCallback) obj;
        long[] initNewV8Function = this.v8.initNewV8Function(j);
        this.v8.createAndRegisterMethodDescriptor(javaCallback, initNewV8Function[1]);
        this.released = false;
        addObjectReference(initNewV8Function[0]);
    }

    public V8Function twin() {
        return (V8Function) super.twin();
    }

    public Object call(V8Object v8Object, V8Array v8Array) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Object);
        this.v8.checkRuntime(v8Array);
        if (v8Object == null) {
            v8Object = this.v8;
        }
        return this.v8.executeFunction(this.v8.getV8RuntimePtr(), v8Object.isUndefined() ? this.v8.getHandle() : v8Object.getHandle(), this.objectHandle, v8Array == null ? 0 : v8Array.getHandle());
    }
}
