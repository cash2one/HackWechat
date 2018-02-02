package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import java.util.ArrayList;
import java.util.List;

public class DebugHandler implements Releasable {
    private static final String CHANGE_BREAK_POINT_CONDITION = "changeBreakPointCondition";
    private static final String CLEAR_BREAK_POINT = "clearBreakPoint";
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String DISABLE_ALL_BREAK_POINTS = "disableAllBreakPoints";
    private static final String DISABLE_SCRIPT_BREAK_POINT = "disableScriptBreakPoint";
    private static final String ENABLE_SCRIPT_BREAK_POINT = "enableScriptBreakPoint";
    private static final String FIND_SCRIPT_BREAK_POINT = "findScriptBreakPoint";
    private static final String NUMBER = "number";
    private static final String SCRIPT_BREAK_POINTS = "scriptBreakPoints";
    private static final String SET_BREAK_POINT = "setBreakPoint";
    private static final String SET_LISTENER = "setListener";
    private static final String SET_SCRIPT_BREAK_POINT_BY_NAME = "setScriptBreakPointByName";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private List<BreakHandler> breakHandlers = new ArrayList();
    private V8Object debugObject;
    private V8 runtime;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent = new int[DebugEvent.values().length];

        static {
            try {
                $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[DebugEvent.Break.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[DebugEvent.BeforeCompile.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[DebugEvent.AfterCompile.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[DebugEvent.Exception.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public DebugHandler(V8 v8) {
        this.runtime = v8;
        setupDebugObject(v8);
        setupBreakpointHandler();
    }

    public void addBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.add(breakHandler);
    }

    public void removeBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.remove(breakHandler);
    }

    public int setBreakpoint(V8Function v8Function) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push((V8Value) v8Function);
        try {
            int executeIntegerFunction = this.debugObject.executeIntegerFunction(SET_BREAK_POINT, v8Array);
            return executeIntegerFunction;
        } finally {
            v8Array.release();
        }
    }

    public int setScriptBreakpoint(String str, int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        v8Array.push(i);
        try {
            int executeIntegerFunction = this.debugObject.executeIntegerFunction(SET_SCRIPT_BREAK_POINT_BY_NAME, v8Array);
            return executeIntegerFunction;
        } finally {
            v8Array.release();
        }
    }

    public void enableScriptBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(ENABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void disableScriptBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(DISABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void clearBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(CLEAR_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void disableAllBreakPoints() {
        this.debugObject.executeVoidFunction(DISABLE_ALL_BREAK_POINTS, null);
    }

    public int getScriptBreakPointCount() {
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        try {
            int length = executeArrayFunction.length();
            return length;
        } finally {
            executeArrayFunction.release();
        }
    }

    public int[] getScriptBreakPointIDs() {
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        int[] iArr = new int[executeArrayFunction.length()];
        int i = 0;
        while (i < executeArrayFunction.length()) {
            V8Object object = executeArrayFunction.getObject(i);
            try {
                iArr[i] = object.executeIntegerFunction(NUMBER, null);
                object.release();
                i++;
            } catch (Throwable th) {
                executeArrayFunction.release();
            }
        }
        executeArrayFunction.release();
        return iArr;
    }

    public ScriptBreakPoint getScriptBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        v8Array.push(false);
        V8Object v8Object = null;
        try {
            v8Object = this.debugObject.executeObjectFunction(FIND_SCRIPT_BREAK_POINT, v8Array);
            ScriptBreakPoint scriptBreakPoint = new ScriptBreakPoint(v8Object);
            return scriptBreakPoint;
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
        }
    }

    public void changeBreakPointCondition(int i, String str) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        v8Array.push(str);
        try {
            this.debugObject.executeVoidFunction(CHANGE_BREAK_POINT_CONDITION, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void release() {
        this.debugObject.release();
    }

    private void setupDebugObject(V8 v8) {
        V8Object object = v8.getObject(DEBUG_OBJECT_NAME);
        try {
            this.debugObject = object.getObject(V8_DEBUG_OBJECT);
        } finally {
            object.release();
        }
    }

    private void setupBreakpointHandler() {
        Throwable th;
        V8Value v8Value;
        Throwable th2;
        V8Array v8Array;
        V8Object v8Object = null;
        this.debugObject.registerJavaMethod(new BreakpointHandler(this, v8Object), DEBUG_BREAK_HANDLER);
        try {
            V8Array push;
            V8Value v8Value2 = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
            try {
                push = new V8Array(this.runtime).push(v8Value2);
            } catch (Throwable th3) {
                th = th3;
                V8Object v8Object2 = v8Object;
                v8Value = v8Value2;
                th2 = th;
                r2.release();
                v8Array.release();
                throw th2;
            }
            try {
                this.debugObject.executeFunction(SET_LISTENER, push);
                if (!(v8Value2 == null || v8Value2.isReleased())) {
                    v8Value2.release();
                }
                if (push != null && !push.isReleased()) {
                    push.release();
                }
            } catch (Throwable th32) {
                th = th32;
                v8Array = push;
                v8Value = v8Value2;
                th2 = th;
                if (!(r2 == null || r2.isReleased())) {
                    r2.release();
                }
                if (!(v8Array == null || v8Array.isReleased())) {
                    v8Array.release();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            v8Array = v8Object;
            r2.release();
            v8Array.release();
            throw th2;
        }
    }
}
