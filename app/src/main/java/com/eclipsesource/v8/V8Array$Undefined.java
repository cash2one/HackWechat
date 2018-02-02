package com.eclipsesource.v8;

class V8Array$Undefined extends V8Array {
    public boolean isUndefined() {
        return true;
    }

    public boolean isReleased() {
        return false;
    }

    public void release() {
    }

    public V8Array$Undefined twin() {
        return (V8Array$Undefined) super.twin();
    }

    public String toString() {
        return "undefined";
    }

    public boolean equals(Object obj) {
        if ((obj instanceof V8Object) && ((V8Object) obj).isUndefined()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 919;
    }

    public V8 getRuntime() {
        throw new UnsupportedOperationException();
    }

    public V8Object add(String str, boolean z) {
        throw new UnsupportedOperationException();
    }

    public V8Object add(String str, double d) {
        throw new UnsupportedOperationException();
    }

    public V8Object add(String str, int i) {
        throw new UnsupportedOperationException();
    }

    public V8Object add(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public V8Object add(String str, V8Value v8Value) {
        throw new UnsupportedOperationException();
    }

    public V8Object addUndefined(String str) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(String str) {
        throw new UnsupportedOperationException();
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public V8Array getArray(String str) {
        throw new UnsupportedOperationException();
    }

    public boolean getBoolean(String str) {
        throw new UnsupportedOperationException();
    }

    public double getDouble(String str) {
        throw new UnsupportedOperationException();
    }

    public int getInteger(String str) {
        throw new UnsupportedOperationException();
    }

    public String[] getKeys() {
        throw new UnsupportedOperationException();
    }

    public V8Object getObject(String str) {
        throw new UnsupportedOperationException();
    }

    public String getString(String str) {
        throw new UnsupportedOperationException();
    }

    public int getType(String str) {
        throw new UnsupportedOperationException();
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        throw new UnsupportedOperationException();
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        throw new UnsupportedOperationException();
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
        throw new UnsupportedOperationException();
    }

    public V8Object setPrototype(V8Object v8Object) {
        throw new UnsupportedOperationException();
    }

    public Object get(int i) {
        throw new UnsupportedOperationException();
    }

    public V8Array getArray(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean getBoolean(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean[] getBooleans(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public byte[] getBytes(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public int getBytes(int i, int i2, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public byte getByte(int i) {
        throw new UnsupportedOperationException();
    }

    public int getBooleans(int i, int i2, boolean[] zArr) {
        throw new UnsupportedOperationException();
    }

    public double getDouble(int i) {
        throw new UnsupportedOperationException();
    }

    public double[] getDoubles(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public int getDoubles(int i, int i2, double[] dArr) {
        throw new UnsupportedOperationException();
    }

    public int getInteger(int i) {
        throw new UnsupportedOperationException();
    }

    public int[] getIntegers(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public int getIntegers(int i, int i2, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    public V8Object getObject(int i) {
        throw new UnsupportedOperationException();
    }

    public String getString(int i) {
        throw new UnsupportedOperationException();
    }

    public String[] getStrings(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public int getStrings(int i, int i2, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    public int getType() {
        throw new UnsupportedOperationException();
    }

    public int getType(int i) {
        throw new UnsupportedOperationException();
    }

    public int getType(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public int length() {
        throw new UnsupportedOperationException();
    }

    public V8Array push(boolean z) {
        throw new UnsupportedOperationException();
    }

    public V8Array push(double d) {
        throw new UnsupportedOperationException();
    }

    public V8Array push(int i) {
        throw new UnsupportedOperationException();
    }

    public V8Array push(String str) {
        throw new UnsupportedOperationException();
    }

    public V8Array push(V8Value v8Value) {
        throw new UnsupportedOperationException();
    }

    public V8Array pushUndefined() {
        throw new UnsupportedOperationException();
    }
}
