package org.xwalk.core;

import java.util.ArrayList;

public class XWalkHttpAuthHandler implements XWalkHttpAuth {
    private Object bridge;
    private ReflectMethod cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod isFirstAttemptMethod = new ReflectMethod(null, "isFirstAttempt", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod proceedStringStringMethod = new ReflectMethod(null, "proceed", new Class[0]);

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkHttpAuthHandler(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public void proceed(String str, String str2) {
        try {
            this.proceedStringStringMethod.invoke(str, str2);
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

    public boolean isFirstAttempt() {
        try {
            return ((Boolean) this.isFirstAttemptMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    void reflectionInit() {
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            return;
        }
        this.proceedStringStringMethod.init(this.bridge, null, "proceedSuper", String.class, String.class);
        this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
        this.isFirstAttemptMethod.init(this.bridge, null, "isFirstAttemptSuper", new Class[0]);
    }
}
