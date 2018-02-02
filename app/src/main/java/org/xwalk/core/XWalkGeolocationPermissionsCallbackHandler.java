package org.xwalk.core;

import java.util.ArrayList;

public class XWalkGeolocationPermissionsCallbackHandler implements XWalkGeolocationPermissionsCallback {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod invokeStringbooleanbooleanMethod = new ReflectMethod(null, "invoke", new Class[0]);
    private ReflectMethod postWrapperMethod;

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkGeolocationPermissionsCallbackHandler(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public void invoke(String str, boolean z, boolean z2) {
        try {
            this.invokeStringbooleanbooleanMethod.invoke(new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)});
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
        this.invokeStringbooleanbooleanMethod.init(this.bridge, null, "invokeSuper", new Class[]{String.class, Boolean.TYPE, Boolean.TYPE});
    }
}
