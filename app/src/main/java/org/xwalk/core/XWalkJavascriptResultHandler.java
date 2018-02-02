package org.xwalk.core;

import java.util.ArrayList;

public class XWalkJavascriptResultHandler implements XWalkJavascriptResult {
    private Object bridge;
    private ReflectMethod cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    private ReflectMethod confirmMethod = new ReflectMethod(null, "confirm", new Class[0]);
    private ReflectMethod confirmWithResultStringMethod = new ReflectMethod(null, "confirmWithResult", new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkJavascriptResultHandler(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public void confirm() {
        try {
            this.confirmMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void confirmWithResult(String str) {
        try {
            this.confirmWithResultStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void cancel() {
        try {
            this.cancelMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    void reflectionInit() {
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            return;
        }
        this.confirmMethod.init(this.bridge, null, "confirmSuper", new Class[0]);
        this.confirmWithResultStringMethod.init(this.bridge, null, "confirmWithResultSuper", new Class[]{String.class});
        this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
    }
}
