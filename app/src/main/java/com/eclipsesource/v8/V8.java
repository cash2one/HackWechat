package com.eclipsesource.v8;

import com.eclipsesource.v8.V8Array.Undefined;
import com.eclipsesource.v8.utils.V8Executor;
import com.eclipsesource.v8.utils.V8Map;
import com.eclipsesource.v8.utils.V8Runnable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class V8 extends V8Object {
    private static boolean initialized = false;
    private static Object invalid = new Object();
    private static Object lock = new Object();
    private static boolean nativeLibraryLoaded = false;
    private static Error nativeLoadError = null;
    private static Exception nativeLoadException = null;
    private static volatile int runtimeCounter = 0;
    private static V8Value undefined = new V8Object$Undefined();
    private static String v8Flags = null;
    private Map<String, Object> data;
    private V8Map<V8Executor> executors;
    private boolean forceTerminateExecutors;
    private Map<Long, MethodDescriptor> functionRegistry;
    private final V8Locker locker;
    private long objectReferences;
    private LinkedList<ReferenceHandler> referenceHandlers;
    private LinkedList<V8Runnable> releaseHandlers;
    private List<Releasable> resources;
    private long v8RuntimePtr;
    protected Map<Long, V8Value> v8WeakReferences;

    private native void _acquireLock(long j);

    private native void _add(long j, long j2, String str, double d);

    private native void _add(long j, long j2, String str, int i);

    private native void _add(long j, long j2, String str, String str2);

    private native void _add(long j, long j2, String str, boolean z);

    private native void _addArrayBooleanItem(long j, long j2, boolean z);

    private native void _addArrayDoubleItem(long j, long j2, double d);

    private native void _addArrayIntItem(long j, long j2, int i);

    private native void _addArrayNullItem(long j, long j2);

    private native void _addArrayObjectItem(long j, long j2, long j3);

    private native void _addArrayStringItem(long j, long j2, String str);

    private native void _addArrayUndefinedItem(long j, long j2);

    private native void _addNull(long j, long j2, String str);

    private native void _addObject(long j, long j2, String str, long j3);

    private native void _addUndefined(long j, long j2, String str);

    private native Object _arrayGet(long j, int i, long j2, int i2);

    private native boolean _arrayGetBoolean(long j, long j2, int i);

    private native int _arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr);

    private native boolean[] _arrayGetBooleans(long j, long j2, int i, int i2);

    private native byte _arrayGetByte(long j, long j2, int i);

    private native int _arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr);

    private native byte[] _arrayGetBytes(long j, long j2, int i, int i2);

    private native double _arrayGetDouble(long j, long j2, int i);

    private native int _arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr);

    private native double[] _arrayGetDoubles(long j, long j2, int i, int i2);

    private native int _arrayGetInteger(long j, long j2, int i);

    private native int _arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr);

    private native int[] _arrayGetIntegers(long j, long j2, int i, int i2);

    private native int _arrayGetSize(long j, long j2);

    private native String _arrayGetString(long j, long j2, int i);

    private native int _arrayGetStrings(long j, long j2, int i, int i2, String[] strArr);

    private native String[] _arrayGetStrings(long j, long j2, int i, int i2);

    private native boolean _contains(long j, long j2, String str);

    private native long _createIsolate(String str);

    private native void _createTwin(long j, long j2, long j3);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j, long j2, int i);

    private native boolean _equals(long j, long j2, long j3);

    private native boolean _executeBooleanFunction(long j, long j2, String str, long j3);

    private native boolean _executeBooleanScript(long j, String str, String str2, int i);

    private native double _executeDoubleFunction(long j, long j2, String str, long j3);

    private native double _executeDoubleScript(long j, String str, String str2, int i);

    private native Object _executeFunction(long j, int i, long j2, String str, long j3);

    private native Object _executeFunction(long j, long j2, long j3, long j4);

    private native int _executeIntegerFunction(long j, long j2, String str, long j3);

    private native int _executeIntegerScript(long j, String str, String str2, int i);

    private native Object _executeScript(long j, int i, String str, String str2, int i2);

    private native String _executeStringFunction(long j, long j2, String str, long j3);

    private native String _executeStringScript(long j, String str, String str2, int i);

    private native void _executeVoidFunction(long j, long j2, String str, long j3);

    private native void _executeVoidScript(long j, String str, String str2, int i);

    private native Object _get(long j, int i, long j2, String str);

    private native int _getArrayType(long j, long j2);

    private native boolean _getBoolean(long j, long j2, String str);

    private native long _getBuildID();

    private native double _getDouble(long j, long j2, String str);

    private native long _getGlobalObject(long j);

    private native int _getInteger(long j, long j2, String str);

    private native String[] _getKeys(long j, long j2);

    private native String _getString(long j, long j2, String str);

    private native int _getType(long j, long j2);

    private native int _getType(long j, long j2, int i);

    private native int _getType(long j, long j2, int i, int i2);

    private native int _getType(long j, long j2, String str);

    private static native String _getVersion();

    private native int _identityHash(long j, long j2);

    private native long _initNewV8Array(long j);

    private native long _initNewV8ArrayBuffer(long j, int i);

    private native long _initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i);

    private native long _initNewV8Float32Array(long j, long j2, int i, int i2);

    private native long _initNewV8Float64Array(long j, long j2, int i, int i2);

    private native long[] _initNewV8Function(long j);

    private native long _initNewV8Int16Array(long j, long j2, int i, int i2);

    private native long _initNewV8Int32Array(long j, long j2, int i, int i2);

    private native long _initNewV8Int8Array(long j, long j2, int i, int i2);

    private native long _initNewV8Object(long j);

    private native long _initNewV8UInt16Array(long j, long j2, int i, int i2);

    private native long _initNewV8UInt32Array(long j, long j2, int i, int i2);

    private native long _initNewV8UInt8Array(long j, long j2, int i, int i2);

    private native long _initNewV8UInt8ClampedArray(long j, long j2, int i, int i2);

    private static native boolean _isRunning(long j);

    private native boolean _isWeak(long j, long j2);

    private native void _lowMemoryNotification(long j);

    private static native boolean _pumpMessageLoop(long j);

    private native long _registerJavaMethod(long j, long j2, String str, boolean z);

    private native void _release(long j, long j2);

    private native void _releaseLock(long j);

    private native void _releaseMethodDescriptor(long j, long j2);

    private native void _releaseRuntime(long j);

    private native boolean _sameValue(long j, long j2, long j3);

    private static native void _setFlags(String str);

    private native void _setPrototype(long j, long j2, long j3);

    private native void _setWeak(long j, long j2);

    private static native void _startNodeJS(long j, String str);

    private native boolean _strictEquals(long j, long j2, long j3);

    private native void _terminateExecution(long j);

    private native String _toString(long j, long j2);

    private static synchronized void load(String str) {
        synchronized (V8.class) {
            try {
                LibraryLoader.loadLibrary(str);
                nativeLibraryLoaded = true;
            } catch (Error e) {
                nativeLoadError = e;
            } catch (Exception e2) {
                nativeLoadException = e2;
            }
        }
    }

    public static boolean isLoaded() {
        return nativeLibraryLoaded;
    }

    public static void setFlags(String str) {
        v8Flags = str;
        initialized = false;
    }

    public static V8 createV8Runtime() {
        return createV8Runtime(null, null);
    }

    public static V8 createV8Runtime(String str) {
        return createV8Runtime(str, null);
    }

    public static V8 createV8Runtime(String str, String str2) {
        if (!nativeLibraryLoaded) {
            synchronized (lock) {
                if (!nativeLibraryLoaded) {
                    load(str2);
                }
            }
        }
        checkNativeLibraryLoaded();
        if (!initialized) {
            _setFlags(v8Flags);
            initialized = true;
        }
        V8 v8 = new V8(str);
        synchronized (lock) {
            runtimeCounter++;
        }
        return v8;
    }

    public void addReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.add(0, referenceHandler);
    }

    public void addReleaseHandler(V8Runnable v8Runnable) {
        this.releaseHandlers.add(v8Runnable);
    }

    public void removeReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.remove(referenceHandler);
    }

    public void removeReleaseHandler(V8Runnable v8Runnable) {
        this.releaseHandlers.remove(v8Runnable);
    }

    public synchronized void setData(String str, Object obj) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, obj);
    }

    public Object getData(String str) {
        if (this.data == null) {
            return null;
        }
        return this.data.get(str);
    }

    private void notifyReleaseHandlers(V8 v8) {
        Iterator it = this.releaseHandlers.iterator();
        while (it.hasNext()) {
            ((V8Runnable) it.next()).run(v8);
        }
    }

    private void notifyReferenceCreated(V8Value v8Value) {
        Iterator it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            ((ReferenceHandler) it.next()).v8HandleCreated(v8Value);
        }
    }

    private void notifyReferenceDisposed(V8Value v8Value) {
        Iterator it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            ((ReferenceHandler) it.next()).v8HandleDisposed(v8Value);
        }
    }

    private static void checkNativeLibraryLoaded() {
        if (!nativeLibraryLoaded) {
            if (nativeLoadError != null) {
                throw new IllegalStateException("J2V8 native library not loaded", nativeLoadError);
            } else if (nativeLoadException != null) {
                throw new IllegalStateException("J2V8 native library not loaded", nativeLoadException);
            } else {
                throw new IllegalStateException("J2V8 native library not loaded");
            }
        }
    }

    protected V8() {
        this(null);
    }

    protected V8(String str) {
        super(null);
        this.v8WeakReferences = new HashMap();
        this.data = null;
        this.objectReferences = 0;
        this.v8RuntimePtr = 0;
        this.resources = null;
        this.executors = null;
        this.forceTerminateExecutors = false;
        this.functionRegistry = new HashMap();
        this.referenceHandlers = new LinkedList();
        this.releaseHandlers = new LinkedList();
        this.released = false;
        this.v8RuntimePtr = _createIsolate(str);
        this.locker = new V8Locker(this);
        checkThread();
        this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
    }

    public static V8Value getUndefined() {
        return undefined;
    }

    public static int getActiveRuntimes() {
        return runtimeCounter;
    }

    public long getObjectReferenceCount() {
        return this.objectReferences - ((long) this.v8WeakReferences.size());
    }

    protected long getV8RuntimePtr() {
        return this.v8RuntimePtr;
    }

    public static String getV8Version() {
        return _getVersion();
    }

    public static String getSCMRevision() {
        return "3448ede3460d11608ce2cfba25a693a618744ffa";
    }

    public void release() {
        release(true);
    }

    public void terminateExecution() {
        this.forceTerminateExecutors = true;
        terminateExecution(this.v8RuntimePtr);
    }

    public void release(boolean z) {
        if (!isReleased()) {
            checkThread();
            try {
                notifyReleaseHandlers(this);
                releaseResources();
                shutdownExecutors(this.forceTerminateExecutors);
                if (this.executors != null) {
                    this.executors.clear();
                }
                releaseNativeMethodDescriptors();
                synchronized (lock) {
                    runtimeCounter--;
                }
                _releaseRuntime(this.v8RuntimePtr);
                this.v8RuntimePtr = 0;
                this.released = true;
                if (z && getObjectReferenceCount() > 0) {
                    throw new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
                }
            } catch (Throwable th) {
                releaseResources();
                shutdownExecutors(this.forceTerminateExecutors);
                if (this.executors != null) {
                    this.executors.clear();
                }
                releaseNativeMethodDescriptors();
                synchronized (lock) {
                    runtimeCounter--;
                    _releaseRuntime(this.v8RuntimePtr);
                    this.v8RuntimePtr = 0;
                    this.released = true;
                    if (z && getObjectReferenceCount() > 0) {
                        IllegalStateException illegalStateException = new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
                    }
                }
            }
        }
    }

    private void releaseNativeMethodDescriptors() {
        for (Long longValue : this.functionRegistry.keySet()) {
            releaseMethodDescriptor(this.v8RuntimePtr, longValue.longValue());
        }
    }

    private void releaseResources() {
        if (this.resources != null) {
            for (Releasable release : this.resources) {
                release.release();
            }
            this.resources.clear();
            this.resources = null;
        }
    }

    public void registerV8Executor(V8Object v8Object, V8Executor v8Executor) {
        checkThread();
        if (this.executors == null) {
            this.executors = new V8Map();
        }
        this.executors.put(v8Object, v8Executor);
    }

    public V8Executor removeExecutor(V8Object v8Object) {
        checkThread();
        if (this.executors == null) {
            return null;
        }
        return (V8Executor) this.executors.remove(v8Object);
    }

    public V8Executor getExecutor(V8Object v8Object) {
        checkThread();
        if (this.executors == null) {
            return null;
        }
        return (V8Executor) this.executors.get(v8Object);
    }

    public void shutdownExecutors(boolean z) {
        checkThread();
        if (this.executors != null) {
            for (V8Executor v8Executor : this.executors.values()) {
                if (z) {
                    v8Executor.forceTermination();
                } else {
                    v8Executor.shutdown();
                }
            }
        }
    }

    public void registerResource(Releasable releasable) {
        checkThread();
        if (this.resources == null) {
            this.resources = new ArrayList();
        }
        this.resources.add(releasable);
    }

    public int executeIntegerScript(String str) {
        return executeIntegerScript(str, null, 0);
    }

    public int executeIntegerScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeIntegerScript(this.v8RuntimePtr, str, str2, i);
    }

    protected void createTwin(V8Value v8Value, V8Value v8Value2) {
        checkThread();
        createTwin(this.v8RuntimePtr, v8Value.getHandle(), v8Value2.getHandle());
    }

    public double executeDoubleScript(String str) {
        return executeDoubleScript(str, null, 0);
    }

    public double executeDoubleScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeDoubleScript(this.v8RuntimePtr, str, str2, i);
    }

    public String executeStringScript(String str) {
        return executeStringScript(str, null, 0);
    }

    public String executeStringScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeStringScript(this.v8RuntimePtr, str, str2, i);
    }

    public boolean executeBooleanScript(String str) {
        return executeBooleanScript(str, null, 0);
    }

    public boolean executeBooleanScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeBooleanScript(this.v8RuntimePtr, str, str2, i);
    }

    public V8Array executeArrayScript(String str) {
        return executeArrayScript(str, null, 0);
    }

    public V8Array executeArrayScript(String str, String str2, int i) {
        checkThread();
        Object executeScript = executeScript(str, str2, i);
        if (executeScript instanceof V8Array) {
            return (V8Array) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public Object executeScript(String str) {
        return executeScript(str, null, 0);
    }

    public Object executeScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, i);
    }

    public V8Object executeObjectScript(String str) {
        return executeObjectScript(str, null, 0);
    }

    public V8Object executeObjectScript(String str, String str2, int i) {
        checkThread();
        Object executeScript = executeScript(str, str2, i);
        if (executeScript instanceof V8Object) {
            return (V8Object) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public void executeVoidScript(String str) {
        executeVoidScript(str, null, 0);
    }

    public void executeVoidScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        executeVoidScript(this.v8RuntimePtr, str, str2, i);
    }

    public V8Locker getLocker() {
        return this.locker;
    }

    public long getBuildID() {
        return _getBuildID();
    }

    public void lowMemoryNotification() {
        checkThread();
        lowMemoryNotification(getV8RuntimePtr());
    }

    void checkRuntime(V8Value v8Value) {
        if (v8Value != null && !v8Value.isUndefined()) {
            V8 runtime = v8Value.getRuntime();
            if (runtime == null || runtime.isReleased() || runtime != this) {
                throw new Error("Invalid target runtime");
            }
        }
    }

    void checkThread() {
        this.locker.checkThread();
        if (isReleased()) {
            throw new Error("Runtime disposed error");
        }
    }

    static void checkScript(String str) {
        if (str == null) {
            throw new NullPointerException("Script is null");
        }
    }

    void registerCallback(Object obj, Method method, long j, String str, boolean z) {
        MethodDescriptor methodDescriptor = new MethodDescriptor(this, null);
        methodDescriptor.object = obj;
        methodDescriptor.method = method;
        methodDescriptor.includeReceiver = z;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j, str, isVoidMethod(method))), methodDescriptor);
    }

    void registerVoidCallback(JavaVoidCallback javaVoidCallback, long j, String str) {
        MethodDescriptor methodDescriptor = new MethodDescriptor(this, null);
        methodDescriptor.voidCallback = javaVoidCallback;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j, str, true)), methodDescriptor);
    }

    void registerCallback(JavaCallback javaCallback, long j, String str) {
        createAndRegisterMethodDescriptor(javaCallback, registerJavaMethod(getV8RuntimePtr(), j, str, false));
    }

    void createAndRegisterMethodDescriptor(JavaCallback javaCallback, long j) {
        MethodDescriptor methodDescriptor = new MethodDescriptor(this, null);
        methodDescriptor.callback = javaCallback;
        this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
    }

    private boolean isVoidMethod(Method method) {
        if (method.getReturnType().equals(Void.TYPE)) {
            return true;
        }
        return false;
    }

    private Object getDefaultValue(Class<?> cls) {
        if (cls.equals(V8Object.class)) {
            return new V8Object$Undefined();
        }
        if (cls.equals(V8Array.class)) {
            return new Undefined();
        }
        return invalid;
    }

    protected void disposeMethodID(long j) {
        this.functionRegistry.remove(Long.valueOf(j));
    }

    protected void weakReferenceReleased(long j) {
        V8Value v8Value = (V8Value) this.v8WeakReferences.get(Long.valueOf(j));
        if (v8Value != null) {
            this.v8WeakReferences.remove(Long.valueOf(j));
            try {
                v8Value.release();
            } catch (Exception e) {
            }
        }
    }

    protected Object callObjectJavaMethod(long j, V8Object v8Object, V8Array v8Array) {
        MethodDescriptor methodDescriptor = (MethodDescriptor) this.functionRegistry.get(Long.valueOf(j));
        if (methodDescriptor.callback != null) {
            return checkResult(methodDescriptor.callback.invoke(v8Object, v8Array));
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            Object checkResult = checkResult(methodDescriptor.method.invoke(methodDescriptor.object, args));
            releaseArguments(args, isVarArgs);
            return checkResult;
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (IllegalAccessException e2) {
            throw e2;
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (Throwable th) {
            releaseArguments(args, isVarArgs);
        }
    }

    private Object checkResult(Object obj) {
        if (obj == null) {
            return obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Boolean) || (obj instanceof String)) {
            return obj;
        }
        if (!(obj instanceof V8Value)) {
            throw new V8RuntimeException("Unknown return type: " + obj.getClass());
        } else if (!((V8Value) obj).isReleased()) {
            return obj;
        } else {
            throw new V8RuntimeException("V8Value already released");
        }
    }

    protected void callVoidJavaMethod(long j, V8Object v8Object, V8Array v8Array) {
        MethodDescriptor methodDescriptor = (MethodDescriptor) this.functionRegistry.get(Long.valueOf(j));
        if (methodDescriptor.voidCallback != null) {
            methodDescriptor.voidCallback.invoke(v8Object, v8Array);
            return;
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            methodDescriptor.method.invoke(methodDescriptor.object, args);
            releaseArguments(args, isVarArgs);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (IllegalAccessException e2) {
            throw e2;
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (Throwable th) {
            releaseArguments(args, isVarArgs);
        }
    }

    private void checkArgs(Object[] objArr) {
        for (Object obj : objArr) {
            if (obj == invalid) {
                throw new IllegalArgumentException("argument type mismatch");
            }
        }
    }

    private void releaseArguments(Object[] objArr, boolean z) {
        if (z && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Object[])) {
            for (Object obj : (Object[]) objArr[objArr.length - 1]) {
                if (obj instanceof V8Value) {
                    ((V8Value) obj).release();
                }
            }
        }
        for (Object obj2 : objArr) {
            if (obj2 instanceof V8Value) {
                ((V8Value) obj2).release();
            }
        }
    }

    private Object[] getArgs(V8Object v8Object, MethodDescriptor methodDescriptor, V8Array v8Array, boolean z) {
        int length = methodDescriptor.method.getParameterTypes().length;
        int i = z ? length - 1 : length;
        Object[] defaultValues = setDefaultValues(new Object[length], methodDescriptor.method.getParameterTypes(), v8Object, methodDescriptor.includeReceiver);
        List arrayList = new ArrayList();
        populateParamters(v8Array, i, defaultValues, arrayList, methodDescriptor.includeReceiver);
        if (z) {
            Object varArgContainer = getVarArgContainer(methodDescriptor.method.getParameterTypes(), arrayList.size());
            System.arraycopy(arrayList.toArray(), 0, varArgContainer, 0, arrayList.size());
            defaultValues[i] = varArgContainer;
        }
        return defaultValues;
    }

    private Object getVarArgContainer(Class<?>[] clsArr, int i) {
        Class cls = clsArr[clsArr.length - 1];
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return Array.newInstance(cls, i);
    }

    private void populateParamters(V8Array v8Array, int i, Object[] objArr, List<Object> list, boolean z) {
        int i2 = 0;
        if (z) {
            i2 = 1;
        }
        for (int i3 = i2; i3 < v8Array.length() + i2; i3++) {
            if (i3 >= i) {
                list.add(getArrayItem(v8Array, i3 - i2));
            } else {
                objArr[i3] = getArrayItem(v8Array, i3 - i2);
            }
        }
    }

    private Object[] setDefaultValues(Object[] objArr, Class<?>[] clsArr, V8Object v8Object, boolean z) {
        int i;
        if (z) {
            i = 1;
            objArr[0] = v8Object;
        } else {
            i = 0;
        }
        while (i < objArr.length) {
            objArr[i] = getDefaultValue(clsArr[i]);
            i++;
        }
        return objArr;
    }

    private Object getArrayItem(V8Array v8Array, int i) {
        try {
            switch (v8Array.getType(i)) {
                case 1:
                    return Integer.valueOf(v8Array.getInteger(i));
                case 2:
                    return Double.valueOf(v8Array.getDouble(i));
                case 3:
                    return Boolean.valueOf(v8Array.getBoolean(i));
                case 4:
                    return v8Array.getString(i);
                case 5:
                case 8:
                    return v8Array.getArray(i);
                case 6:
                    return v8Array.getObject(i);
                case 7:
                    return v8Array.getObject(i);
                case 10:
                    return v8Array.get(i);
                case 99:
                    return getUndefined();
            }
        } catch (V8ResultUndefined e) {
        }
        return null;
    }

    void createNodeRuntime(String str) {
        _startNodeJS(this.v8RuntimePtr, str);
    }

    boolean pumpMessageLoop() {
        return _pumpMessageLoop(this.v8RuntimePtr);
    }

    boolean isRunning() {
        return _isRunning(this.v8RuntimePtr);
    }

    protected long initNewV8Object(long j) {
        return _initNewV8Object(j);
    }

    protected void acquireLock(long j) {
        _acquireLock(j);
    }

    protected void releaseLock(long j) {
        _releaseLock(j);
    }

    protected void lowMemoryNotification(long j) {
        _lowMemoryNotification(j);
    }

    protected void createTwin(long j, long j2, long j3) {
        _createTwin(j, j2, j3);
    }

    protected int executeIntegerScript(long j, String str, String str2, int i) {
        return _executeIntegerScript(j, str, str2, i);
    }

    protected double executeDoubleScript(long j, String str, String str2, int i) {
        return _executeDoubleScript(j, str, str2, i);
    }

    protected String executeStringScript(long j, String str, String str2, int i) {
        return _executeStringScript(j, str, str2, i);
    }

    protected boolean executeBooleanScript(long j, String str, String str2, int i) {
        return _executeBooleanScript(j, str, str2, i);
    }

    protected Object executeScript(long j, int i, String str, String str2, int i2) {
        return _executeScript(j, i, str, str2, i2);
    }

    protected void executeVoidScript(long j, String str, String str2, int i) {
        _executeVoidScript(j, str, str2, i);
    }

    protected void setWeak(long j, long j2) {
        _setWeak(j, j2);
    }

    protected boolean isWeak(long j, long j2) {
        return _isWeak(j, j2);
    }

    protected void release(long j, long j2) {
        _release(j, j2);
    }

    protected boolean contains(long j, long j2, String str) {
        return _contains(j, j2, str);
    }

    protected String[] getKeys(long j, long j2) {
        return _getKeys(j, j2);
    }

    protected int getInteger(long j, long j2, String str) {
        return _getInteger(j, j2, str);
    }

    protected boolean getBoolean(long j, long j2, String str) {
        return _getBoolean(j, j2, str);
    }

    protected double getDouble(long j, long j2, String str) {
        return _getDouble(j, j2, str);
    }

    protected String getString(long j, long j2, String str) {
        return _getString(j, j2, str);
    }

    protected Object get(long j, int i, long j2, String str) {
        return _get(j, i, j2, str);
    }

    protected int executeIntegerFunction(long j, long j2, String str, long j3) {
        return _executeIntegerFunction(j, j2, str, j3);
    }

    protected double executeDoubleFunction(long j, long j2, String str, long j3) {
        return _executeDoubleFunction(j, j2, str, j3);
    }

    protected String executeStringFunction(long j, long j2, String str, long j3) {
        return _executeStringFunction(j, j2, str, j3);
    }

    protected boolean executeBooleanFunction(long j, long j2, String str, long j3) {
        return _executeBooleanFunction(j, j2, str, j3);
    }

    protected Object executeFunction(long j, int i, long j2, String str, long j3) {
        return _executeFunction(j, i, j2, str, j3);
    }

    protected Object executeFunction(long j, long j2, long j3, long j4) {
        return _executeFunction(j, j2, j3, j4);
    }

    protected void executeVoidFunction(long j, long j2, String str, long j3) {
        _executeVoidFunction(j, j2, str, j3);
    }

    protected boolean equals(long j, long j2, long j3) {
        return _equals(j, j2, j3);
    }

    protected String toString(long j, long j2) {
        return _toString(j, j2);
    }

    protected boolean strictEquals(long j, long j2, long j3) {
        return _strictEquals(j, j2, j3);
    }

    protected boolean sameValue(long j, long j2, long j3) {
        return _sameValue(j, j2, j3);
    }

    protected int identityHash(long j, long j2) {
        return _identityHash(j, j2);
    }

    protected void add(long j, long j2, String str, int i) {
        _add(j, j2, str, i);
    }

    protected void addObject(long j, long j2, String str, long j3) {
        _addObject(j, j2, str, j3);
    }

    protected void add(long j, long j2, String str, boolean z) {
        _add(j, j2, str, z);
    }

    protected void add(long j, long j2, String str, double d) {
        _add(j, j2, str, d);
    }

    protected void add(long j, long j2, String str, String str2) {
        _add(j, j2, str, str2);
    }

    protected void addUndefined(long j, long j2, String str) {
        _addUndefined(j, j2, str);
    }

    protected void addNull(long j, long j2, String str) {
        _addNull(j, j2, str);
    }

    protected long registerJavaMethod(long j, long j2, String str, boolean z) {
        return _registerJavaMethod(j, j2, str, z);
    }

    protected long initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i) {
        return _initNewV8ArrayBuffer(j, byteBuffer, i);
    }

    protected long initNewV8ArrayBuffer(long j, int i) {
        return _initNewV8ArrayBuffer(j, i);
    }

    public long initNewV8Int32Array(long j, long j2, int i, int i2) {
        return _initNewV8Int32Array(j, j2, i, i2);
    }

    public long initNewV8Float32Array(long j, long j2, int i, int i2) {
        return _initNewV8Float32Array(j, j2, i, i2);
    }

    public long initNewV8Float64Array(long j, long j2, int i, int i2) {
        return _initNewV8Float64Array(j, j2, i, i2);
    }

    public long initNewV8UInt32Array(long j, long j2, int i, int i2) {
        return _initNewV8UInt32Array(j, j2, i, i2);
    }

    public long initNewV8UInt16Array(long j, long j2, int i, int i2) {
        return _initNewV8UInt16Array(j, j2, i, i2);
    }

    public long initNewV8Int16Array(long j, long j2, int i, int i2) {
        return _initNewV8Int16Array(j, j2, i, i2);
    }

    public long initNewV8UInt8Array(long j, long j2, int i, int i2) {
        return _initNewV8UInt8Array(j, j2, i, i2);
    }

    public long initNewV8Int8Array(long j, long j2, int i, int i2) {
        return _initNewV8Int8Array(j, j2, i, i2);
    }

    public long initNewV8UInt8ClampedArray(long j, long j2, int i, int i2) {
        return _initNewV8UInt8ClampedArray(j, j2, i, i2);
    }

    protected ByteBuffer createV8ArrayBufferBackingStore(long j, long j2, int i) {
        return _createV8ArrayBufferBackingStore(j, j2, i);
    }

    protected long initNewV8Array(long j) {
        return _initNewV8Array(j);
    }

    protected long[] initNewV8Function(long j) {
        checkThread();
        return _initNewV8Function(j);
    }

    protected int arrayGetSize(long j, long j2) {
        return _arrayGetSize(j, j2);
    }

    protected int arrayGetInteger(long j, long j2, int i) {
        return _arrayGetInteger(j, j2, i);
    }

    protected boolean arrayGetBoolean(long j, long j2, int i) {
        return _arrayGetBoolean(j, j2, i);
    }

    protected byte arrayGetByte(long j, long j2, int i) {
        return _arrayGetByte(j, j2, i);
    }

    protected double arrayGetDouble(long j, long j2, int i) {
        return _arrayGetDouble(j, j2, i);
    }

    protected String arrayGetString(long j, long j2, int i) {
        return _arrayGetString(j, j2, i);
    }

    protected Object arrayGet(long j, int i, long j2, int i2) {
        return _arrayGet(j, i, j2, i2);
    }

    protected void addArrayIntItem(long j, long j2, int i) {
        _addArrayIntItem(j, j2, i);
    }

    protected void addArrayBooleanItem(long j, long j2, boolean z) {
        _addArrayBooleanItem(j, j2, z);
    }

    protected void addArrayDoubleItem(long j, long j2, double d) {
        _addArrayDoubleItem(j, j2, d);
    }

    protected void addArrayStringItem(long j, long j2, String str) {
        _addArrayStringItem(j, j2, str);
    }

    protected void addArrayObjectItem(long j, long j2, long j3) {
        _addArrayObjectItem(j, j2, j3);
    }

    protected void addArrayUndefinedItem(long j, long j2) {
        _addArrayUndefinedItem(j, j2);
    }

    protected void addArrayNullItem(long j, long j2) {
        _addArrayNullItem(j, j2);
    }

    protected int getType(long j, long j2) {
        return _getType(j, j2);
    }

    protected int getType(long j, long j2, String str) {
        return _getType(j, j2, str);
    }

    protected int getType(long j, long j2, int i) {
        return _getType(j, j2, i);
    }

    protected int getArrayType(long j, long j2) {
        return _getArrayType(j, j2);
    }

    protected int getType(long j, long j2, int i, int i2) {
        return _getType(j, j2, i, i2);
    }

    protected void setPrototype(long j, long j2, long j3) {
        _setPrototype(j, j2, j3);
    }

    protected int[] arrayGetIntegers(long j, long j2, int i, int i2) {
        return _arrayGetIntegers(j, j2, i, i2);
    }

    protected double[] arrayGetDoubles(long j, long j2, int i, int i2) {
        return _arrayGetDoubles(j, j2, i, i2);
    }

    protected boolean[] arrayGetBooleans(long j, long j2, int i, int i2) {
        return _arrayGetBooleans(j, j2, i, i2);
    }

    protected byte[] arrayGetBytes(long j, long j2, int i, int i2) {
        return _arrayGetBytes(j, j2, i, i2);
    }

    protected String[] arrayGetStrings(long j, long j2, int i, int i2) {
        return _arrayGetStrings(j, j2, i, i2);
    }

    protected int arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr) {
        return _arrayGetIntegers(j, j2, i, i2, iArr);
    }

    protected int arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr) {
        return _arrayGetDoubles(j, j2, i, i2, dArr);
    }

    protected int arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr) {
        return _arrayGetBooleans(j, j2, i, i2, zArr);
    }

    protected int arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr) {
        return _arrayGetBytes(j, j2, i, i2, bArr);
    }

    protected int arrayGetStrings(long j, long j2, int i, int i2, String[] strArr) {
        return _arrayGetStrings(j, j2, i, i2, strArr);
    }

    protected void terminateExecution(long j) {
        _terminateExecution(j);
    }

    protected void releaseMethodDescriptor(long j, long j2) {
        _releaseMethodDescriptor(j, j2);
    }

    void addObjRef(V8Value v8Value) {
        this.objectReferences++;
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceCreated(v8Value);
        }
    }

    void releaseObjRef(V8Value v8Value) {
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceDisposed(v8Value);
        }
        this.objectReferences--;
    }
}
