package org.xwalk.core;

import java.util.ArrayList;

public class XWalkHitTestResult {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod enumtypeClassValueOfMethod = new ReflectMethod();
    private ReflectMethod getExtraMethod = new ReflectMethod(null, "getExtra", new Class[0]);
    private ReflectMethod getTypeMethod = new ReflectMethod(null, "getType", new Class[0]);
    private ReflectMethod postWrapperMethod;

    public enum type {
        UNKNOWN_TYPE,
        ANCHOR_TYPE,
        PHONE_TYPE,
        GEO_TYPE,
        EMAIL_TYPE,
        IMAGE_TYPE,
        IMAGE_ANCHOR_TYPE,
        SRC_ANCHOR_TYPE,
        SRC_IMAGE_ANCHOR_TYPE,
        EDIT_TEXT_TYPE
    }

    private Object Converttype(type org_xwalk_core_XWalkHitTestResult_type) {
        return this.enumtypeClassValueOfMethod.invoke(new Object[]{org_xwalk_core_XWalkHitTestResult_type.toString()});
    }

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkHitTestResult(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public type getType() {
        try {
            return type.valueOf(this.getTypeMethod.invoke(new Object[0]).toString());
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public String getExtra() {
        try {
            return (String) this.getExtraMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    void reflectionInit() {
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            return;
        }
        this.enumtypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkHitTestResultInternal$type"), "valueOf", new Class[]{String.class});
        this.getTypeMethod.init(this.bridge, null, "getTypeSuper", new Class[0]);
        this.getExtraMethod.init(this.bridge, null, "getExtraSuper", new Class[0]);
    }
}
