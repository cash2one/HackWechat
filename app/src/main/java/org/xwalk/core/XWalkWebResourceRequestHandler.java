package org.xwalk.core;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceRequestHandler implements XWalkWebResourceRequest {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getMethodMethod = new ReflectMethod(null, "getMethod", new Class[0]);
    private ReflectMethod getRequestHeadersMethod = new ReflectMethod(null, "getRequestHeaders", new Class[0]);
    private ReflectMethod getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
    private ReflectMethod hasGestureMethod = new ReflectMethod(null, "hasGesture", new Class[0]);
    private ReflectMethod isForMainFrameMethod = new ReflectMethod(null, "isForMainFrame", new Class[0]);
    private ReflectMethod postWrapperMethod;

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkWebResourceRequestHandler(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public Uri getUrl() {
        try {
            return (Uri) this.getUrlMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public boolean isForMainFrame() {
        try {
            return ((Boolean) this.isForMainFrameMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean hasGesture() {
        try {
            return ((Boolean) this.hasGestureMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public String getMethod() {
        try {
            return (String) this.getMethodMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public Map<String, String> getRequestHeaders() {
        try {
            return (Map) this.getRequestHeadersMethod.invoke(new Object[0]);
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
        this.isForMainFrameMethod.init(this.bridge, null, "isForMainFrameSuper", new Class[0]);
        this.hasGestureMethod.init(this.bridge, null, "hasGestureSuper", new Class[0]);
        this.getMethodMethod.init(this.bridge, null, "getMethodSuper", new Class[0]);
        this.getRequestHeadersMethod.init(this.bridge, null, "getRequestHeadersSuper", new Class[0]);
    }
}
