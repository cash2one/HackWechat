package com.eclipsesource.v8;

import java.io.File;
import java.io.PrintWriter;

public class NodeJS {
    private static final String GLOBAL = "global";
    private static final String NEXT_TICK = "nextTick";
    private static final String NODE = "node";
    private static final String PROCESS = "process";
    private static final String STARTUP_CALLBACK = "__run";
    private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
    private static final String STARTUP_SCRIPT_NAME = "startup";
    private static final String TMP_JS_EXT = ".js.tmp";
    private static final String VERSIONS = "versions";
    private String nodeVersion = null;
    private V8Function require;
    private V8 v8;

    public static NodeJS createNodeJS() {
        return createNodeJS(null);
    }

    public String getNodeVersion() {
        Releasable object;
        Throwable th;
        Releasable releasable = null;
        if (this.nodeVersion != null) {
            return this.nodeVersion;
        }
        try {
            object = this.v8.getObject(PROCESS);
            try {
                releasable = object.getObject(VERSIONS);
                this.nodeVersion = releasable.getString(NODE);
                safeRelease(object);
                safeRelease(releasable);
                return this.nodeVersion;
            } catch (Throwable th2) {
                th = th2;
                safeRelease(object);
                safeRelease(releasable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            object = null;
            safeRelease(object);
            safeRelease(releasable);
            throw th;
        }
    }

    public static NodeJS createNodeJS(File file) {
        V8 createV8Runtime = V8.createV8Runtime(GLOBAL);
        NodeJS nodeJS = new NodeJS(createV8Runtime);
        createV8Runtime.registerJavaMethod(new 1(nodeJS), STARTUP_CALLBACK);
        File createTemporaryScriptFile;
        try {
            createTemporaryScriptFile = createTemporaryScriptFile(STARTUP_SCRIPT, STARTUP_SCRIPT_NAME);
            createV8Runtime.createNodeRuntime(createTemporaryScriptFile.getAbsolutePath());
            createTemporaryScriptFile.delete();
            if (file != null) {
                nodeJS.exec(file);
            }
            return nodeJS;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            createTemporaryScriptFile.delete();
        }
    }

    public V8 getRuntime() {
        return this.v8;
    }

    public boolean handleMessage() {
        this.v8.checkThread();
        return this.v8.pumpMessageLoop();
    }

    public void release() {
        this.v8.checkThread();
        if (!this.require.isReleased()) {
            this.require.release();
        }
        if (!this.v8.isReleased()) {
            this.v8.release();
        }
    }

    public boolean isRunning() {
        this.v8.checkThread();
        return this.v8.isRunning();
    }

    public V8Object require(File file) {
        this.v8.checkThread();
        V8Array v8Array = new V8Array(this.v8);
        try {
            v8Array.push(file.getAbsolutePath());
            V8Object v8Object = (V8Object) this.require.call(null, v8Array);
            return v8Object;
        } finally {
            v8Array.release();
        }
    }

    public void exec(File file) {
        Throwable th;
        Releasable releasable = null;
        Releasable createScriptExecutionCallback = createScriptExecutionCallback(file);
        Releasable v8Array;
        try {
            Releasable object = this.v8.getObject(PROCESS);
            try {
                v8Array = new V8Array(this.v8);
            } catch (Throwable th2) {
                th = th2;
                v8Array = null;
                releasable = object;
                safeRelease(releasable);
                safeRelease(v8Array);
                safeRelease(createScriptExecutionCallback);
                throw th;
            }
            try {
                v8Array.push(createScriptExecutionCallback);
                object.executeObjectFunction(NEXT_TICK, v8Array);
                safeRelease(object);
                safeRelease(v8Array);
                safeRelease(createScriptExecutionCallback);
            } catch (Throwable th3) {
                th = th3;
                releasable = object;
                safeRelease(releasable);
                safeRelease(v8Array);
                safeRelease(createScriptExecutionCallback);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            v8Array = null;
            safeRelease(releasable);
            safeRelease(v8Array);
            safeRelease(createScriptExecutionCallback);
            throw th;
        }
    }

    private V8Function createScriptExecutionCallback(File file) {
        return new V8Function(this.v8, new 2(this, file));
    }

    private void safeRelease(Releasable releasable) {
        if (releasable != null) {
            releasable.release();
        }
    }

    private NodeJS(V8 v8) {
        this.v8 = v8;
    }

    private void init(V8Function v8Function) {
        this.require = v8Function;
    }

    private static File createTemporaryScriptFile(String str, String str2) {
        File createTempFile = File.createTempFile(str2, TMP_JS_EXT);
        PrintWriter printWriter = new PrintWriter(createTempFile, "UTF-8");
        try {
            printWriter.print(str);
            return createTempFile;
        } finally {
            printWriter.close();
        }
    }
}
