package org.xwalk.core;

import java.util.ArrayList;

public class XWalkNavigationItem {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
    private ReflectMethod getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
    private ReflectMethod getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
    private ReflectMethod postWrapperMethod;

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkNavigationItem(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public String getUrl() {
        try {
            return (String) this.getUrlMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public String getOriginalUrl() {
        try {
            return (String) this.getOriginalUrlMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public String getTitle() {
        try {
            return (String) this.getTitleMethod.invoke(new Object[0]);
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
        this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
        this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
        this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
    }
}
