package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class PropertiesArray implements Releasable {
    private V8Array v8Array;

    PropertiesArray(V8Array v8Array) {
        this.v8Array = v8Array.twin();
    }

    public PropertyMirror getProperty(int i) {
        V8Object object = this.v8Array.getObject(i);
        try {
            PropertyMirror propertyMirror = new PropertyMirror(object);
            return propertyMirror;
        } finally {
            object.release();
        }
    }

    public void release() {
        if (!this.v8Array.isReleased()) {
            this.v8Array.release();
        }
    }

    public int length() {
        return this.v8Array.length();
    }
}
