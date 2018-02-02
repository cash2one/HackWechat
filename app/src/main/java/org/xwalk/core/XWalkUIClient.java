package org.xwalk.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import java.util.ArrayList;

public class XWalkUIClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkUIClient.class.desiredAssertionStatus());
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod enumConsoleMessageTypeClassValueOfMethod = new ReflectMethod();
    private ReflectMethod enumInitiateByClassValueOfMethod = new ReflectMethod();
    private ReflectMethod enumJavascriptMessageTypeClassValueOfMethod = new ReflectMethod();
    private ReflectMethod enumLoadStatusClassValueOfMethod = new ReflectMethod();
    private ReflectMethod getVideoLoadingProgressViewMethod = new ReflectMethod(null, "getVideoLoadingProgressView", new Class[0]);
    private ReflectMethod onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod = new ReflectMethod(null, "onConsoleMessage", new Class[0]);
    private ReflectMethod onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod = new ReflectMethod(null, "onCreateWindowRequested", new Class[0]);
    private ReflectMethod onFullscreenToggledXWalkViewInternalbooleanMethod = new ReflectMethod(null, "onFullscreenToggled", new Class[0]);
    private ReflectMethod onGeolocationPermissionsHidePromptMethod = new ReflectMethod(null, "onGeolocationPermissionsHidePrompt", new Class[0]);
    private ReflectMethod onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod = new ReflectMethod(null, "onGeolocationPermissionsShowPrompt", new Class[0]);
    private ReflectMethod onHideCustomViewMethod = new ReflectMethod(null, "onHideCustomView", new Class[0]);
    private ReflectMethod onIconAvailableXWalkViewInternalStringMessageMethod = new ReflectMethod(null, "onIconAvailable", new Class[0]);
    private ReflectMethod onJavascriptCloseWindowXWalkViewInternalMethod = new ReflectMethod(null, "onJavascriptCloseWindow", new Class[0]);
    private ReflectMethod onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJavascriptModalDialog", new Class[0]);
    private ReflectMethod onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJsAlert", new Class[0]);
    private ReflectMethod onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJsConfirm", new Class[0]);
    private ReflectMethod onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJsPrompt", new Class[0]);
    private ReflectMethod onPageLoadStartedXWalkViewInternalStringMethod = new ReflectMethod(null, "onPageLoadStarted", new Class[0]);
    private ReflectMethod onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod = new ReflectMethod(null, "onPageLoadStopped", new Class[0]);
    private ReflectMethod onReceivedIconXWalkViewInternalStringBitmapMethod = new ReflectMethod(null, "onReceivedIcon", new Class[0]);
    private ReflectMethod onReceivedTitleXWalkViewInternalStringMethod = new ReflectMethod(null, "onReceivedTitle", new Class[0]);
    private ReflectMethod onRequestFocusXWalkViewInternalMethod = new ReflectMethod(null, "onRequestFocus", new Class[0]);
    private ReflectMethod onScaleChangedXWalkViewInternalfloatfloatMethod = new ReflectMethod(null, "onScaleChanged", new Class[0]);
    private ReflectMethod onShowCustomViewViewCustomViewCallbackInternalMethod = new ReflectMethod(null, "onShowCustomView", new Class[0]);
    private ReflectMethod onShowCustomViewViewintCustomViewCallbackInternalMethod = new ReflectMethod(null, "onShowCustomView", new Class[0]);
    private ReflectMethod onUnhandledKeyEventXWalkViewInternalKeyEventMethod = new ReflectMethod(null, "onUnhandledKeyEvent", new Class[0]);
    private ReflectMethod openFileChooserXWalkViewInternalValueCallbackStringStringMethod = new ReflectMethod(null, "openFileChooser", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod shouldOverrideKeyEventXWalkViewInternalKeyEventMethod = new ReflectMethod(null, "shouldOverrideKeyEvent", new Class[0]);

    public enum LoadStatus {
        FINISHED,
        FAILED,
        CANCELLED
    }

    private Object ConvertJavascriptMessageType(JavascriptMessageType javascriptMessageType) {
        return this.enumJavascriptMessageTypeClassValueOfMethod.invoke(new Object[]{javascriptMessageType.toString()});
    }

    private Object ConvertConsoleMessageType(ConsoleMessageType consoleMessageType) {
        return this.enumConsoleMessageTypeClassValueOfMethod.invoke(new Object[]{consoleMessageType.toString()});
    }

    private Object ConvertInitiateBy(InitiateBy initiateBy) {
        return this.enumInitiateByClassValueOfMethod.invoke(new Object[]{initiateBy.toString()});
    }

    private Object ConvertLoadStatus(LoadStatus loadStatus) {
        return this.enumLoadStatusClassValueOfMethod.invoke(new Object[]{loadStatus.toString()});
    }

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkUIClient(XWalkView xWalkView) {
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList();
        this.constructorParams.add(xWalkView);
        reflectionInit();
    }

    public boolean onCreateWindowRequested(XWalkView xWalkView, InitiateBy initiateBy, ValueCallback<XWalkView> valueCallback) {
        try {
            return ((Boolean) this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.invoke(new Object[]{xWalkView.getBridge(), ConvertInitiateBy(initiateBy), valueCallback})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void onIconAvailable(XWalkView xWalkView, String str, Message message) {
        try {
            this.onIconAvailableXWalkViewInternalStringMessageMethod.invoke(new Object[]{xWalkView.getBridge(), str, message});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onReceivedIcon(XWalkView xWalkView, String str, Bitmap bitmap) {
        try {
            this.onReceivedIconXWalkViewInternalStringBitmapMethod.invoke(new Object[]{xWalkView.getBridge(), str, bitmap});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onRequestFocus(XWalkView xWalkView) {
        try {
            this.onRequestFocusXWalkViewInternalMethod.invoke(new Object[]{xWalkView.getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onJavascriptCloseWindow(XWalkView xWalkView) {
        try {
            this.onJavascriptCloseWindowXWalkViewInternalMethod.invoke(new Object[]{xWalkView.getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean onJavascriptModalDialog(XWalkView xWalkView, JavascriptMessageType javascriptMessageType, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        try {
            return ((Boolean) this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[]{xWalkView.getBridge(), ConvertJavascriptMessageType(javascriptMessageType), str, str2, str3, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge()})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void onFullscreenToggled(XWalkView xWalkView, boolean z) {
        try {
            this.onFullscreenToggledXWalkViewInternalbooleanMethod.invoke(new Object[]{xWalkView.getBridge(), Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void openFileChooser(XWalkView xWalkView, ValueCallback<Uri> valueCallback, String str, String str2) {
        try {
            this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(new Object[]{xWalkView.getBridge(), valueCallback, str, str2});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onScaleChanged(XWalkView xWalkView, float f, float f2) {
        try {
            this.onScaleChangedXWalkViewInternalfloatfloatMethod.invoke(new Object[]{xWalkView.getBridge(), Float.valueOf(f), Float.valueOf(f2)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean shouldOverrideKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
        try {
            return ((Boolean) this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.invoke(new Object[]{xWalkView.getBridge(), keyEvent})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void onUnhandledKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
        try {
            this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.invoke(new Object[]{xWalkView.getBridge(), keyEvent});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean onConsoleMessage(XWalkView xWalkView, String str, int i, String str2, ConsoleMessageType consoleMessageType) {
        try {
            return ((Boolean) this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.invoke(new Object[]{xWalkView.getBridge(), str, Integer.valueOf(i), str2, ConvertConsoleMessageType(consoleMessageType)})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void onReceivedTitle(XWalkView xWalkView, String str) {
        try {
            this.onReceivedTitleXWalkViewInternalStringMethod.invoke(new Object[]{xWalkView.getBridge(), str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onPageLoadStarted(XWalkView xWalkView, String str) {
        try {
            this.onPageLoadStartedXWalkViewInternalStringMethod.invoke(new Object[]{xWalkView.getBridge(), str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onPageLoadStopped(XWalkView xWalkView, String str, LoadStatus loadStatus) {
        try {
            this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.invoke(new Object[]{xWalkView.getBridge(), str, ConvertLoadStatus(loadStatus)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean onJsAlert(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        try {
            return ((Boolean) this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[]{xWalkView.getBridge(), str, str2, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge()})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean onJsConfirm(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        try {
            return ((Boolean) this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[]{xWalkView.getBridge(), str, str2, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge()})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean onJsPrompt(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        try {
            return ((Boolean) this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[]{xWalkView.getBridge(), str, str2, str3, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge()})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        try {
            this.onShowCustomViewViewCustomViewCallbackInternalMethod.invoke(new Object[]{view, ((CustomViewCallbackHandler) customViewCallback).getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        try {
            this.onShowCustomViewViewintCustomViewCallbackInternalMethod.invoke(new Object[]{view, Integer.valueOf(i), ((CustomViewCallbackHandler) customViewCallback).getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onHideCustomView() {
        try {
            this.onHideCustomViewMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onGeolocationPermissionsShowPrompt(String str, XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
        try {
            this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.invoke(new Object[]{str, ((XWalkGeolocationPermissionsCallbackHandler) xWalkGeolocationPermissionsCallback).getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        try {
            this.onGeolocationPermissionsHidePromptMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public View getVideoLoadingProgressView() {
        try {
            return (View) this.getVideoLoadingProgressViewMethod.invoke(new Object[0]);
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
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkUIClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.enumJavascriptMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), "valueOf", new Class[]{String.class});
            this.enumConsoleMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType"), "valueOf", new Class[]{String.class});
            this.enumInitiateByClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), "valueOf", new Class[]{String.class});
            this.enumLoadStatusClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal"), "valueOf", new Class[]{String.class});
            this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.init(this.bridge, null, "onCreateWindowRequestedSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), ValueCallback.class});
            this.onIconAvailableXWalkViewInternalStringMessageMethod.init(this.bridge, null, "onIconAvailableSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Message.class});
            this.onReceivedIconXWalkViewInternalStringBitmapMethod.init(this.bridge, null, "onReceivedIconSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Bitmap.class});
            this.onRequestFocusXWalkViewInternalMethod.init(this.bridge, null, "onRequestFocusSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge")});
            this.onJavascriptCloseWindowXWalkViewInternalMethod.init(this.bridge, null, "onJavascriptCloseWindowSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge")});
            this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJavascriptModalDialogSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge")});
            this.onFullscreenToggledXWalkViewInternalbooleanMethod.init(this.bridge, null, "onFullscreenToggledSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), Boolean.TYPE});
            this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.init(this.bridge, null, "openFileChooserSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, String.class, String.class});
            this.onScaleChangedXWalkViewInternalfloatfloatMethod.init(this.bridge, null, "onScaleChangedSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), Float.TYPE, Float.TYPE});
            this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "shouldOverrideKeyEventSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class});
            this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "onUnhandledKeyEventSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class});
            this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.init(this.bridge, null, "onConsoleMessageSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Integer.TYPE, String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType")});
            this.onReceivedTitleXWalkViewInternalStringMethod.init(this.bridge, null, "onReceivedTitleSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class});
            this.onPageLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onPageLoadStartedSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class});
            this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.init(this.bridge, null, "onPageLoadStoppedSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal")});
            this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsAlertSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge")});
            this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsConfirmSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge")});
            this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsPromptSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge")});
            this.onShowCustomViewViewCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", new Class[]{View.class, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge")});
            this.onShowCustomViewViewintCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", new Class[]{View.class, Integer.TYPE, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge")});
            this.onHideCustomViewMethod.init(this.bridge, null, "onHideCustomViewSuper", new Class[0]);
            this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.init(this.bridge, null, "onGeolocationPermissionsShowPromptSuper", new Class[]{String.class, this.coreWrapper.getBridgeClass("XWalkGeolocationPermissionsCallbackHandlerBridge")});
            this.onGeolocationPermissionsHidePromptMethod.init(this.bridge, null, "onGeolocationPermissionsHidePromptSuper", new Class[0]);
            this.getVideoLoadingProgressViewMethod.init(this.bridge, null, "getVideoLoadingProgressView", new Class[0]);
        } catch (UnsupportedOperationException e) {
        }
    }
}
