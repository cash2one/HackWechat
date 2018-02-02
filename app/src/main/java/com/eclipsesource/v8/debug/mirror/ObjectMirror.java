package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class ObjectMirror extends ValueMirror {
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY_NAMES = "propertyNames";

    public String toString() {
        return this.v8Object.toString();
    }

    ObjectMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isObject() {
        return true;
    }

    public String[] getPropertyNames(PropertyKind propertyKind, int i) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTY_NAMES, v8Array);
            String[] strArr = new String[v8Array2.length()];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                strArr[i2] = v8Array2.getString(i2);
            }
            return strArr;
        } finally {
            v8Array.release();
            if (v8Array2 != null) {
                v8Array2.release();
            }
        }
    }

    public PropertiesArray getProperties(PropertyKind propertyKind, int i) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTIES, v8Array);
            PropertiesArray propertiesArray = new PropertiesArray(v8Array2);
            return propertiesArray;
        } finally {
            v8Array.release();
            if (!(v8Array2 == null || v8Array2.isReleased())) {
                v8Array2.release();
            }
        }
    }
}
