package org.xwalk.core;

import java.util.ArrayList;

public class CustomViewCallbackHandler implements CustomViewCallback {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod onCustomViewHiddenMethod = new ReflectMethod(null, "onCustomViewHidden", new Class[0]);
    private ReflectMethod postWrapperMethod;

    protected Object getBridge() {
        return this.bridge;
    }

    public CustomViewCallbackHandler(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public void onCustomViewHidden() {
        try {
            this.onCustomViewHiddenMethod.invoke(new Object[0]);
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
        } else {
            this.onCustomViewHiddenMethod.init(this.bridge, null, "onCustomViewHiddenSuper", new Class[0]);
        }
    }
}
