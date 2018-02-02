package org.xwalk.core;

import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Map;

public class WebViewExtension {
    static final /* synthetic */ boolean $assertionsDisabled = (!WebViewExtension.class.desiredAssertionStatus());
    public static final String EXTENSION_ADD_FILTER_RESOURCES = "AddFilterResources";
    private static final String TAG = "XWalkLib.WebViewExtension";
    private static WebViewExtensionInterface mWebViewExtensionInterface;
    private static WebViewExtensionListener mWebViewExtensionListener;
    private static WebViewExtension sInstance;
    private ReflectMethod SetExtensionMethod = new ReflectMethod(null, "SetExtension", new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList();
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    protected Object getBridge() {
        return this.bridge;
    }

    private static WebViewExtension getInstance() {
        if (sInstance == null) {
            sInstance = new WebViewExtension();
        }
        return sInstance;
    }

    public WebViewExtension() {
        reflectionInit();
    }

    public static void SetExtension(WebViewExtensionListener webViewExtensionListener) {
        Log.i(TAG, "SetExtension WebViewExtensionInterface");
        mWebViewExtensionListener = webViewExtensionListener;
        try {
            updateExtension(true);
        } catch (Exception e) {
            Log.i(TAG, "SetExtension refelction not ready, updateExtension when available:" + e.getMessage());
        }
    }

    public static void updateExtension(boolean z) {
        if (mWebViewExtensionListener == null) {
            return;
        }
        if (z || mWebViewExtensionInterface == null) {
            getInstance();
            Log.i(TAG, "updateExtension");
            mWebViewExtensionInterface = new 1();
            getInstance().SetExtensionMethod.invoke(new Object[]{mWebViewExtensionInterface.getBridge()});
        }
    }

    public static boolean addFilterResources(Resources resources, Map<Long, Integer> map) {
        return invokeExtensionMethod(EXTENSION_ADD_FILTER_RESOURCES, resources, map);
    }

    public static boolean invokeExtensionMethod(String str, Object... objArr) {
        if (mWebViewExtensionListener != null) {
            mWebViewExtensionListener.onMiscCallBack(str, objArr);
            return true;
        }
        Log.e(TAG, "InvokeExtensionMethod interface is null,method:" + str);
        return false;
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
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("WebViewExtensionBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.SetExtensionMethod.init(this.bridge, null, "SetExtensionSuper", new Class[]{this.coreWrapper.getBridgeClass("WebViewExtensionInterfaceBridge")});
        } catch (UnsupportedOperationException e) {
        }
    }
}
