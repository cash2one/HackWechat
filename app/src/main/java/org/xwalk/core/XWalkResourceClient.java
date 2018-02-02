package org.xwalk.core;

import android.net.http.SslError;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkResourceClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkResourceClient.class.desiredAssertionStatus());
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_OK = 0;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod createXWalkWebResourceResponseStringStringInputStreamMethod = new ReflectMethod(null, "createXWalkWebResourceResponse", new Class[0]);
    private ReflectMethod createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod = new ReflectMethod(null, "createXWalkWebResourceResponse", new Class[0]);
    private ReflectMethod doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod = new ReflectMethod(null, "doUpdateVisitedHistory", new Class[0]);
    private ReflectMethod onDocumentLoadedInFrameXWalkViewInternallongMethod = new ReflectMethod(null, "onDocumentLoadedInFrame", new Class[0]);
    private ReflectMethod onLoadFinishedXWalkViewInternalStringMethod = new ReflectMethod(null, "onLoadFinished", new Class[0]);
    private ReflectMethod onLoadStartedXWalkViewInternalStringMethod = new ReflectMethod(null, "onLoadStarted", new Class[0]);
    private ReflectMethod onProgressChangedXWalkViewInternalintMethod = new ReflectMethod(null, "onProgressChanged", new Class[0]);
    private ReflectMethod onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod = new ReflectMethod(null, "onReceivedClientCertRequest", new Class[0]);
    private ReflectMethod onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod = new ReflectMethod(null, "onReceivedHttpAuthRequest", new Class[0]);
    private ReflectMethod onReceivedLoadErrorXWalkViewInternalintStringStringMethod = new ReflectMethod(null, "onReceivedLoadError", new Class[0]);
    private ReflectMethod onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod = new ReflectMethod(null, "onReceivedResponseHeaders", new Class[0]);
    private ReflectMethod onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod = new ReflectMethod(null, "onReceivedSslError", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod shouldInterceptLoadRequestXWalkViewInternalStringMethod = new ReflectMethod(null, "shouldInterceptLoadRequest", new Class[0]);
    private ReflectMethod shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod = new ReflectMethod(null, "shouldInterceptLoadRequest", new Class[0]);
    private ReflectMethod shouldOverrideUrlLoadingXWalkViewInternalStringMethod = new ReflectMethod(null, "shouldOverrideUrlLoading", new Class[0]);

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkResourceClient(XWalkView xWalkView) {
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList();
        this.constructorParams.add(xWalkView);
        reflectionInit();
    }

    public void onDocumentLoadedInFrame(XWalkView xWalkView, long j) {
        try {
            this.onDocumentLoadedInFrameXWalkViewInternallongMethod.invoke(new Object[]{xWalkView.getBridge(), Long.valueOf(j)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onLoadStarted(XWalkView xWalkView, String str) {
        try {
            this.onLoadStartedXWalkViewInternalStringMethod.invoke(new Object[]{xWalkView.getBridge(), str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onLoadFinished(XWalkView xWalkView, String str) {
        try {
            this.onLoadFinishedXWalkViewInternalStringMethod.invoke(new Object[]{xWalkView.getBridge(), str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onProgressChanged(XWalkView xWalkView, int i) {
        try {
            this.onProgressChangedXWalkViewInternalintMethod.invoke(new Object[]{xWalkView.getBridge(), Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public WebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, String str) {
        try {
            return (WebResourceResponse) this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.invoke(new Object[]{xWalkView.getBridge(), str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest) {
        try {
            return (XWalkWebResourceResponse) this.coreWrapper.getWrapperObject(this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.invoke(new Object[]{xWalkView.getBridge(), ((XWalkWebResourceRequestHandler) xWalkWebResourceRequest).getBridge()}));
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void onReceivedLoadError(XWalkView xWalkView, int i, String str, String str2) {
        try {
            this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.invoke(new Object[]{xWalkView.getBridge(), Integer.valueOf(i), str, str2});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str) {
        try {
            return ((Boolean) this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.invoke(new Object[]{xWalkView.getBridge(), str})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void onReceivedSslError(XWalkView xWalkView, ValueCallback<Boolean> valueCallback, SslError sslError) {
        try {
            this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.invoke(new Object[]{xWalkView.getBridge(), valueCallback, sslError});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onReceivedClientCertRequest(XWalkView xWalkView, ClientCertRequest clientCertRequest) {
        try {
            this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.invoke(new Object[]{xWalkView.getBridge(), ((ClientCertRequestHandler) clientCertRequest).getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onReceivedResponseHeaders(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
        try {
            this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.invoke(new Object[]{xWalkView.getBridge(), ((XWalkWebResourceRequestHandler) xWalkWebResourceRequest).getBridge(), xWalkWebResourceResponse.getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void doUpdateVisitedHistory(XWalkView xWalkView, String str, boolean z) {
        try {
            this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.invoke(new Object[]{xWalkView.getBridge(), str, Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onReceivedHttpAuthRequest(XWalkView xWalkView, XWalkHttpAuthHandler xWalkHttpAuthHandler, String str, String str2) {
        try {
            this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.invoke(new Object[]{xWalkView.getBridge(), xWalkHttpAuthHandler.getBridge(), str, str2});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public XWalkWebResourceResponse createXWalkWebResourceResponse(String str, String str2, InputStream inputStream) {
        try {
            return (XWalkWebResourceResponse) this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamMethod.invoke(new Object[]{str, str2, inputStream}));
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public XWalkWebResourceResponse createXWalkWebResourceResponse(String str, String str2, InputStream inputStream, int i, String str3, Map<String, String> map) {
        try {
            return (XWalkWebResourceResponse) this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.invoke(new Object[]{str, str2, inputStream, Integer.valueOf(i), str3, map}));
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
        int size = this.constructorTypes.size();
        Class[] clsArr = new Class[(size + 1)];
        for (int i = 0; i < size; i++) {
            Object obj = this.constructorTypes.get(i);
            if (obj instanceof String) {
                clsArr[i] = this.coreWrapper.getBridgeClass((String) obj);
                this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
            } else if (obj instanceof Class) {
                clsArr[i] = (Class) obj;
            } else if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkResourceClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.onDocumentLoadedInFrameXWalkViewInternallongMethod.init(this.bridge, null, "onDocumentLoadedInFrameSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE});
            this.onLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadStartedSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class});
            this.onLoadFinishedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadFinishedSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class});
            this.onProgressChangedXWalkViewInternalintMethod.init(this.bridge, null, "onProgressChangedSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE});
            this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class});
            this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge")});
            this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.init(this.bridge, null, "onReceivedLoadErrorSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE, String.class, String.class});
            this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.init(this.bridge, null, "shouldOverrideUrlLoadingSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class});
            this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.init(this.bridge, null, "onReceivedSslErrorSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, SslError.class});
            this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.init(this.bridge, null, "onReceivedClientCertRequestSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("ClientCertRequestHandlerBridge")});
            this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.init(this.bridge, null, "onReceivedResponseHeadersSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceResponseBridge")});
            this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.init(this.bridge, null, "doUpdateVisitedHistorySuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Boolean.TYPE});
            this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.init(this.bridge, null, "onReceivedHttpAuthRequestSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkHttpAuthHandlerBridge"), String.class, String.class});
            this.createXWalkWebResourceResponseStringStringInputStreamMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", new Class[]{String.class, String.class, InputStream.class});
            this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", new Class[]{String.class, String.class, InputStream.class, Integer.TYPE, String.class, Map.class});
        } catch (UnsupportedOperationException e) {
        }
    }
}
