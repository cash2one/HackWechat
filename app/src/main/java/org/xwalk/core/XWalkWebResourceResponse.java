package org.xwalk.core;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceResponse {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getDataMethod = new ReflectMethod(null, "getData", new Class[0]);
    private ReflectMethod getEncodingMethod = new ReflectMethod(null, "getEncoding", new Class[0]);
    private ReflectMethod getMimeTypeMethod = new ReflectMethod(null, "getMimeType", new Class[0]);
    private ReflectMethod getReasonPhraseMethod = new ReflectMethod(null, "getReasonPhrase", new Class[0]);
    private ReflectMethod getResponseHeadersMethod = new ReflectMethod(null, "getResponseHeaders", new Class[0]);
    private ReflectMethod getStatusCodeMethod = new ReflectMethod(null, "getStatusCode", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod setDataInputStreamMethod = new ReflectMethod(null, "setData", new Class[0]);
    private ReflectMethod setEncodingStringMethod = new ReflectMethod(null, "setEncoding", new Class[0]);
    private ReflectMethod setMimeTypeStringMethod = new ReflectMethod(null, "setMimeType", new Class[0]);
    private ReflectMethod setResponseHeadersMapMethod = new ReflectMethod(null, "setResponseHeaders", new Class[0]);
    private ReflectMethod setStatusCodeAndReasonPhraseintStringMethod = new ReflectMethod(null, "setStatusCodeAndReasonPhrase", new Class[0]);

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkWebResourceResponse(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public void setMimeType(String str) {
        try {
            this.setMimeTypeStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public String getMimeType() {
        try {
            return (String) this.getMimeTypeMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setEncoding(String str) {
        try {
            this.setEncodingStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public String getEncoding() {
        try {
            return (String) this.getEncodingMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setData(InputStream inputStream) {
        try {
            this.setDataInputStreamMethod.invoke(new Object[]{inputStream});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public InputStream getData() {
        try {
            return (InputStream) this.getDataMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setStatusCodeAndReasonPhrase(int i, String str) {
        try {
            this.setStatusCodeAndReasonPhraseintStringMethod.invoke(new Object[]{Integer.valueOf(i), str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public int getStatusCode() {
        try {
            return ((Integer) this.getStatusCodeMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public String getReasonPhrase() {
        try {
            return (String) this.getReasonPhraseMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setResponseHeaders(Map<String, String> map) {
        try {
            this.setResponseHeadersMapMethod.invoke(new Object[]{map});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public Map<String, String> getResponseHeaders() {
        try {
            return (Map) this.getResponseHeadersMethod.invoke(new Object[0]);
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
        this.setMimeTypeStringMethod.init(this.bridge, null, "setMimeTypeSuper", new Class[]{String.class});
        this.getMimeTypeMethod.init(this.bridge, null, "getMimeTypeSuper", new Class[0]);
        this.setEncodingStringMethod.init(this.bridge, null, "setEncodingSuper", new Class[]{String.class});
        this.getEncodingMethod.init(this.bridge, null, "getEncodingSuper", new Class[0]);
        this.setDataInputStreamMethod.init(this.bridge, null, "setDataSuper", new Class[]{InputStream.class});
        this.getDataMethod.init(this.bridge, null, "getDataSuper", new Class[0]);
        this.setStatusCodeAndReasonPhraseintStringMethod.init(this.bridge, null, "setStatusCodeAndReasonPhraseSuper", new Class[]{Integer.TYPE, String.class});
        this.getStatusCodeMethod.init(this.bridge, null, "getStatusCodeSuper", new Class[0]);
        this.getReasonPhraseMethod.init(this.bridge, null, "getReasonPhraseSuper", new Class[0]);
        this.setResponseHeadersMapMethod.init(this.bridge, null, "setResponseHeadersSuper", new Class[]{Map.class});
        this.getResponseHeadersMethod.init(this.bridge, null, "getResponseHeadersSuper", new Class[0]);
    }
}
