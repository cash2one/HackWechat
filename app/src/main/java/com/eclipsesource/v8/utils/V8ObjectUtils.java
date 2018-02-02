package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8TypedArray;
import com.eclipsesource.v8.V8Value;
import com.eclipsesource.v8.utils.typedarrays.ArrayBuffer;
import com.eclipsesource.v8.utils.typedarrays.Float32Array;
import com.eclipsesource.v8.utils.typedarrays.Float64Array;
import com.eclipsesource.v8.utils.typedarrays.Int16Array;
import com.eclipsesource.v8.utils.typedarrays.Int32Array;
import com.eclipsesource.v8.utils.typedarrays.Int8Array;
import com.eclipsesource.v8.utils.typedarrays.TypedArray;
import com.eclipsesource.v8.utils.typedarrays.UInt16Array;
import com.eclipsesource.v8.utils.typedarrays.UInt32Array;
import com.eclipsesource.v8.utils.typedarrays.UInt8Array;
import com.eclipsesource.v8.utils.typedarrays.UInt8ClampedArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class V8ObjectUtils {
    private static final TypeAdapter DEFAULT_TYPE_ADAPTER = new DefaultTypeAdapter();
    private static final Object IGNORE = new Object();

    static class ListWrapper {
        private List<? extends Object> list;

        public ListWrapper(List<? extends Object> list) {
            this.list = list;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ListWrapper) && ((ListWrapper) obj).list == this.list) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return System.identityHashCode(this.list);
        }
    }

    public static void pushValue(com.eclipsesource.v8.V8 r3, com.eclipsesource.v8.V8Array r4, java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Incorrect nodes count for selectOther: B:11:0x0039 in [B:7:0x002f, B:11:0x0039, B:10:0x003a]
	at jadx.core.utils.BlockUtils.selectOther(BlockUtils.java:53)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:64)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = new java.util.Hashtable;
        r0.<init>();
        pushValue(r3, r4, r5, r0);	 Catch:{ all -> 0x0020 }
        r0 = r0.values();
        r1 = r0.iterator();
    L_0x0010:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x003a;
    L_0x0016:
        r0 = r1.next();
        r0 = (com.eclipsesource.v8.V8Value) r0;
        r0.release();
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        r0 = r0.values();
        r2 = r0.iterator();
    L_0x0029:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0039;
    L_0x002f:
        r0 = r2.next();
        r0 = (com.eclipsesource.v8.V8Value) r0;
        r0.release();
        goto L_0x0029;
    L_0x0039:
        throw r1;
    L_0x003a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.pushValue(com.eclipsesource.v8.V8, com.eclipsesource.v8.V8Array, java.lang.Object):void");
    }

    public static Object getValue(Object obj) {
        return getValue(obj, DEFAULT_TYPE_ADAPTER);
    }

    public static Object getValue(Object obj, TypeAdapter typeAdapter) {
        V8Map v8Map = new V8Map();
        try {
            if (obj instanceof V8Value) {
                obj = getValue(obj, ((V8Value) obj).getV8Type(), v8Map, typeAdapter);
            } else {
                v8Map.release();
            }
            return obj;
        } finally {
            v8Map.release();
        }
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object) {
        return toMap(v8Object, DEFAULT_TYPE_ADAPTER);
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object, TypeAdapter typeAdapter) {
        V8Map v8Map = new V8Map();
        try {
            Map<String, ? super Object> toMap = toMap(v8Object, v8Map, typeAdapter);
            return toMap;
        } finally {
            v8Map.release();
        }
    }

    public static List<? super Object> toList(V8Array v8Array) {
        return toList(v8Array, DEFAULT_TYPE_ADAPTER);
    }

    public static List<? super Object> toList(V8Array v8Array, TypeAdapter typeAdapter) {
        V8Map v8Map = new V8Map();
        try {
            List<? super Object> toList = toList(v8Array, v8Map, typeAdapter);
            return toList;
        } finally {
            v8Map.release();
        }
    }

    public static Object getTypedArray(V8Array v8Array, int i, Object obj) {
        int length = v8Array.length();
        if (i == 1) {
            obj = (int[]) obj;
            if (obj == null || obj.length < length) {
                obj = new int[length];
            }
            v8Array.getIntegers(0, length, obj);
        } else if (i == 2) {
            obj = (double[]) obj;
            if (obj == null || obj.length < length) {
                obj = new double[length];
            }
            v8Array.getDoubles(0, length, obj);
        } else if (i == 3) {
            obj = (boolean[]) obj;
            if (obj == null || obj.length < length) {
                obj = new boolean[length];
            }
            v8Array.getBooleans(0, length, obj);
        } else if (i == 4) {
            obj = (String[]) obj;
            if (obj == null || obj.length < length) {
                obj = new String[length];
            }
            v8Array.getStrings(0, length, obj);
        } else if (i == 9) {
            obj = (byte[]) obj;
            if (obj == null || obj.length < length) {
                obj = new byte[length];
            }
            v8Array.getBytes(0, length, obj);
        } else {
            throw new RuntimeException("Unsupported bulk load type: " + i);
        }
        return obj;
    }

    public static Object getTypedArray(V8Array v8Array, int i) {
        int length = v8Array.length();
        if (i == 1) {
            return v8Array.getIntegers(0, length);
        }
        if (i == 2) {
            return v8Array.getDoubles(0, length);
        }
        if (i == 3) {
            return v8Array.getBooleans(0, length);
        }
        if (i == 4) {
            return v8Array.getStrings(0, length);
        }
        throw new RuntimeException("Unsupported bulk load type: " + i);
    }

    public static V8Object toV8Object(V8 v8, Map<String, ? extends Object> map) {
        Map hashtable = new Hashtable();
        try {
            V8Object twin = toV8Object(v8, map, hashtable).twin();
            for (V8Value release : hashtable.values()) {
                release.release();
            }
            return twin;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (V8Value release2 : hashtable.values()) {
                release2.release();
            }
        }
    }

    public static V8Array toV8Array(V8 v8, List<? extends Object> list) {
        Map hashtable = new Hashtable();
        try {
            V8Array twin = toV8Array(v8, list, hashtable).twin();
            for (V8Value release : hashtable.values()) {
                release.release();
            }
            return twin;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (V8Value release2 : hashtable.values()) {
                release2.release();
            }
        }
    }

    public static Object getV8Result(V8 v8, Object obj) {
        if (obj == null) {
            return null;
        }
        Map hashtable = new Hashtable();
        try {
            Object v8Result = getV8Result(v8, obj, hashtable);
            if (v8Result instanceof V8Object) {
                V8Object twin = ((V8Object) v8Result).twin();
                for (V8Value release : hashtable.values()) {
                    release.release();
                }
                return twin;
            }
            for (V8Value release2 : hashtable.values()) {
                release2.release();
            }
            return v8Result;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (V8Value release3 : hashtable.values()) {
                release3.release();
            }
        }
    }

    public static Object getValue(V8Array v8Array, int i) {
        Object obj;
        Throwable th;
        V8Map v8Map = new V8Map();
        try {
            obj = v8Array.get(i);
            try {
                Object value = getValue(obj, v8Array.getType(i), v8Map, DEFAULT_TYPE_ADAPTER);
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                return value;
            } catch (Throwable th2) {
                th = th2;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            obj = null;
            th = th4;
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            throw th;
        }
    }

    public static Object getValue(V8Array v8Array, int i, TypeAdapter typeAdapter) {
        Object obj;
        Throwable th;
        V8Map v8Map = new V8Map();
        try {
            obj = v8Array.get(i);
            try {
                Object value = getValue(obj, v8Array.getType(i), v8Map, typeAdapter);
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                return value;
            } catch (Throwable th2) {
                th = th2;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            obj = null;
            th = th4;
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            throw th;
        }
    }

    public static Object getValue(V8Object v8Object, String str) {
        return getValue(v8Object, str, DEFAULT_TYPE_ADAPTER);
    }

    public static Object getValue(V8Object v8Object, String str, TypeAdapter typeAdapter) {
        Object obj;
        Throwable th;
        V8Map v8Map = new V8Map();
        try {
            obj = v8Object.get(str);
            try {
                Object value = getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                return value;
            } catch (Throwable th2) {
                th = th2;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            obj = null;
            th = th4;
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            throw th;
        }
    }

    private static Map<String, ? super Object> toMap(V8Object v8Object, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        Throwable th;
        if (v8Object == null) {
            return Collections.emptyMap();
        }
        if (v8Map.containsKey(v8Object)) {
            return (Map) v8Map.get(v8Object);
        }
        Map<String, ? super Object> v8PropertyMap = new V8PropertyMap();
        v8Map.put(v8Object, v8PropertyMap);
        String[] keys = v8Object.getKeys();
        int length = keys.length;
        int i = 0;
        while (i < length) {
            Object obj;
            String str = keys[i];
            try {
                obj = v8Object.get(str);
                try {
                    Object value = getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
                    if (value != IGNORE) {
                        v8PropertyMap.put(str, value);
                    }
                    if (obj instanceof Releasable) {
                        ((Releasable) obj).release();
                    }
                    i++;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = null;
            }
        }
        return v8PropertyMap;
        if (obj instanceof Releasable) {
            ((Releasable) obj).release();
        }
        throw th;
    }

    private static List<? super Object> toList(V8Array v8Array, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        Object obj;
        Throwable th;
        if (v8Array == null) {
            return Collections.emptyList();
        }
        if (v8Map.containsKey(v8Array)) {
            return (List) v8Map.get(v8Array);
        }
        List<? super Object> arrayList = new ArrayList();
        v8Map.put(v8Array, arrayList);
        int i = 0;
        while (i < v8Array.length()) {
            try {
                obj = v8Array.get(i);
                try {
                    Object value = getValue(obj, v8Array.getType(i), v8Map, typeAdapter);
                    if (value != IGNORE) {
                        arrayList.add(value);
                    }
                    if (obj instanceof Releasable) {
                        ((Releasable) obj).release();
                    }
                    i++;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = null;
            }
        }
        return arrayList;
        if (obj instanceof Releasable) {
            ((Releasable) obj).release();
        }
        throw th;
    }

    private static V8Object toV8Object(V8 v8, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        if (map2.containsKey(map)) {
            return (V8Object) map2.get(map);
        }
        V8Object v8Object = new V8Object(v8);
        map2.put(map, v8Object);
        try {
            for (Entry entry : map.entrySet()) {
                setValue(v8, v8Object, (String) entry.getKey(), entry.getValue(), map2);
            }
            return v8Object;
        } catch (IllegalStateException e) {
            v8Object.release();
            throw e;
        }
    }

    private static V8Array toV8Array(V8 v8, List<? extends Object> list, Map<Object, V8Value> map) {
        if (map.containsKey(new ListWrapper(list))) {
            return (V8Array) map.get(new ListWrapper(list));
        }
        V8Array v8Array = new V8Array(v8);
        map.put(new ListWrapper(list), v8Array);
        int i = 0;
        while (i < list.size()) {
            try {
                pushValue(v8, v8Array, list.get(i), map);
                i++;
            } catch (IllegalStateException e) {
                v8Array.release();
                throw e;
            }
        }
        return v8Array;
    }

    private static V8ArrayBuffer toV8ArrayBuffer(V8 v8, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        if (map.containsKey(arrayBuffer)) {
            return (V8ArrayBuffer) map.get(arrayBuffer);
        }
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(v8, arrayBuffer.getByteBuffer());
        map.put(arrayBuffer, v8ArrayBuffer);
        return v8ArrayBuffer;
    }

    private static V8TypedArray toV8TypedArray(V8 v8, TypedArray typedArray, Map<Object, V8Value> map) {
        if (map.containsKey(typedArray)) {
            return (V8TypedArray) map.get(typedArray);
        }
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(v8, typedArray.getByteBuffer());
        try {
            V8TypedArray v8TypedArray = new V8TypedArray(v8, v8ArrayBuffer, typedArray.getType(), 0, typedArray.length());
            map.put(typedArray, v8TypedArray);
            return v8TypedArray;
        } finally {
            v8ArrayBuffer.release();
        }
    }

    private static Object getV8Result(V8 v8, Object obj, Map<Object, V8Value> map) {
        if (map.containsKey(obj)) {
            return map.get(obj);
        }
        if (obj instanceof Map) {
            return toV8Object(v8, (Map) obj, map);
        }
        if (obj instanceof List) {
            return toV8Array(v8, (List) obj, map);
        }
        if (obj instanceof TypedArray) {
            return toV8TypedArray(v8, (TypedArray) obj, map);
        }
        if (obj instanceof ArrayBuffer) {
            return toV8ArrayBuffer(v8, (ArrayBuffer) obj, map);
        }
        return obj;
    }

    private static void pushValue(V8 v8, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Array.pushUndefined();
        } else if (obj instanceof Integer) {
            v8Array.push(obj);
        } else if (obj instanceof Long) {
            v8Array.push(new Double((double) ((Long) obj).longValue()));
        } else if (obj instanceof Double) {
            v8Array.push(obj);
        } else if (obj instanceof Float) {
            v8Array.push(obj);
        } else if (obj instanceof String) {
            v8Array.push((String) obj);
        } else if (obj instanceof Boolean) {
            v8Array.push(obj);
        } else if (obj instanceof V8Object) {
            v8Array.push((V8Object) obj);
        } else if (obj instanceof TypedArray) {
            v8Array.push(toV8TypedArray(v8, (TypedArray) obj, map));
        } else if (obj instanceof ArrayBuffer) {
            v8Array.push(toV8ArrayBuffer(v8, (ArrayBuffer) obj, map));
        } else if (obj instanceof Map) {
            v8Array.push(toV8Object(v8, (Map) obj, map));
        } else if (obj instanceof List) {
            v8Array.push(toV8Array(v8, (List) obj, map));
        } else {
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }

    private static void setValue(V8 v8, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Object.addUndefined(str);
        } else if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            v8Object.add(str, (double) ((Long) obj).longValue());
        } else if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Float) {
            v8Object.add(str, (double) ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            v8Object.add(str, (String) obj);
        } else if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof V8Object) {
            v8Object.add(str, (V8Object) obj);
        } else if (obj instanceof TypedArray) {
            v8Object.add(str, toV8TypedArray(v8, (TypedArray) obj, map));
        } else if (obj instanceof ArrayBuffer) {
            v8Object.add(str, toV8ArrayBuffer(v8, (ArrayBuffer) obj, map));
        } else if (obj instanceof Map) {
            v8Object.add(str, toV8Object(v8, (Map) obj, map));
        } else if (obj instanceof List) {
            v8Object.add(str, toV8Array(v8, (List) obj, map));
        } else {
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }

    private static Object getValue(Object obj, int i, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        Object adapt = typeAdapter.adapt(i, obj);
        if (TypeAdapter.DEFAULT != adapt) {
            return adapt;
        }
        switch (i) {
            case 0:
                return null;
            case 1:
            case 2:
            case 3:
            case 4:
                return obj;
            case 5:
                return toList((V8Array) obj, v8Map, typeAdapter);
            case 6:
                return toMap((V8Object) obj, v8Map, typeAdapter);
            case 7:
                return IGNORE;
            case 8:
                return toTypedArray((V8Array) obj);
            case 10:
                return new ArrayBuffer(((V8ArrayBuffer) obj).getBackingStore());
            case 99:
                return V8.getUndefined();
            default:
                throw new IllegalStateException("Cannot convert type " + V8Value.getStringRepresentation(i));
        }
    }

    private static Object toTypedArray(V8Array v8Array) {
        int type = v8Array.getType();
        ByteBuffer byteBuffer = ((V8TypedArray) v8Array).getByteBuffer();
        switch (type) {
            case 1:
                return new Int32Array(byteBuffer);
            case 2:
                return new Float64Array(byteBuffer);
            case 9:
                return new Int8Array(byteBuffer);
            case 11:
                return new UInt8Array(byteBuffer);
            case 12:
                return new UInt8ClampedArray(byteBuffer);
            case 13:
                return new Int16Array(byteBuffer);
            case 14:
                return new UInt16Array(byteBuffer);
            case 15:
                return new UInt32Array(byteBuffer);
            case 16:
                return new Float32Array(byteBuffer);
            default:
                throw new IllegalStateException("Known Typed Array type: " + V8Value.getStringRepresentation(type));
        }
    }

    private V8ObjectUtils() {
    }
}
