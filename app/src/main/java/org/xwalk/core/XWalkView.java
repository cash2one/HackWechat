package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.extension.XWalkExternalExtensionManagerImpl;

public class XWalkView extends AbsoluteLayout {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkView.class.desiredAssertionStatus());
    private static final String ANIMATABLE = "animatable";
    public static final int RELOAD_IGNORE_CACHE = 1;
    public static final int RELOAD_NORMAL = 0;
    public static final String SURFACE_VIEW = "SurfaceView";
    public static final String TEXTURE_VIEW = "TextureView";
    private static final String XWALK_ATTRS_NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private ReflectMethod addJavascriptInterfaceObjectStringMethod;
    private Object bridge;
    private ReflectMethod canZoomInMethod;
    private ReflectMethod canZoomOutMethod;
    private ReflectMethod captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod;
    private ReflectMethod clearCacheForSingleFileStringMethod;
    private ReflectMethod clearCachebooleanMethod;
    private ReflectMethod clearClientCertPreferencesRunnableMethod;
    private ReflectMethod clearFormDataMethod;
    private ReflectMethod clearMatchesMethod;
    private ReflectMethod clearSslPreferencesMethod;
    private ReflectMethod computeHorizontalScrollOffsetMethod;
    private ReflectMethod computeHorizontalScrollRangeMethod;
    private ReflectMethod computeVerticalScrollExtentMethod;
    private ReflectMethod computeVerticalScrollOffsetMethod;
    private ReflectMethod computeVerticalScrollRangeMethod;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod evaluateJavascriptStringValueCallbackMethod;
    private ReflectMethod findAllAsyncStringMethod;
    private ReflectMethod findNextbooleanMethod;
    private ReflectMethod getAPIVersionMethod;
    private ReflectMethod getCertificateMethod;
    private ReflectMethod getCompositingSurfaceTypeMethod;
    private ReflectMethod getContentHeightMethod;
    private ReflectMethod getExtensionManagerMethod;
    private ReflectMethod getFaviconMethod;
    private ReflectMethod getHitTestResultMethod;
    private ReflectMethod getNavigationHistoryMethod;
    private ReflectMethod getOriginalUrlMethod;
    private ReflectMethod getRemoteDebuggingUrlMethod;
    private ReflectMethod getScalenMethod;
    private ReflectMethod getSettingsMethod;
    private ReflectMethod getTitleMethod;
    private ReflectMethod getUrlMethod;
    private ReflectMethod getUserAgentStringMethod;
    private ReflectMethod getXWalkContentViewMethod;
    private ReflectMethod getXWalkVersionMethod;
    private ReflectMethod hasEnteredFullscreenMethod;
    private ReflectMethod leaveFullscreenMethod;
    private ReflectMethod loadAppFromManifestStringStringMethod;
    private ReflectMethod loadDataStringStringStringMethod;
    private ReflectMethod loadDataWithBaseURLStringStringStringStringStringMethod;
    private ReflectMethod loadStringStringMapMethod;
    private ReflectMethod loadStringStringMethod;
    private ReflectMethod loadUrlStringMapMethod;
    private ReflectMethod loadUrlStringMethod;
    private String mAnimatable;
    private OverScrolledListener mOverScrolledListener;
    private ScrollChangedListener mScrollChangedListener;
    private ReflectMethod onActivityResultintintIntentMethod;
    private ReflectMethod onCreateInputConnectionEditorInfoMethod;
    private ReflectMethod onDestroyMethod;
    private ReflectMethod onHideMethod;
    private ReflectMethod onNewIntentIntentMethod;
    private ReflectMethod onShowMethod;
    private ReflectMethod onTouchEventMotionEventMethod;
    private ReflectMethod pauseTimersMethod;
    private ReflectMethod postWrapperMethod;
    private ReflectMethod reloadintMethod;
    private ReflectMethod removeJavascriptInterfaceStringMethod;
    private ReflectMethod restoreStateBundleMethod;
    private ReflectMethod resumeTimersMethod;
    private ReflectMethod saveStateBundleMethod;
    private ReflectMethod scrollByintintMethod;
    private ReflectMethod scrollTointintMethod;
    private ReflectMethod setAcceptLanguagesStringMethod;
    private ReflectMethod setBackgroundColorintMethod;
    private ReflectMethod setDownloadListenerXWalkDownloadListenerInternalMethod;
    private ReflectMethod setFindListenerXWalkFindListenerInternalMethod;
    private ReflectMethod setInitialScaleintMethod;
    private ReflectMethod setNetworkAvailablebooleanMethod;
    private ReflectMethod setOnTouchListenerOnTouchListenerMethod;
    private ReflectMethod setOriginAccessWhitelistStringStringArrayMethod;
    private ReflectMethod setResourceClientXWalkResourceClientInternalMethod;
    private ReflectMethod setSurfaceViewVisibilityintMethod;
    private ReflectMethod setUIClientXWalkUIClientInternalMethod;
    private ReflectMethod setUserAgentStringStringMethod;
    private ReflectMethod setXWalkViewInternalVisibilityintMethod;
    private ReflectMethod setZOrderOnTopbooleanMethod;
    private ReflectMethod startActivityForResultIntentintBundleMethod;
    private ReflectMethod stopLoadingMethod;
    private ReflectMethod zoomByfloatMethod;
    private ReflectMethod zoomInMethod;
    private ReflectMethod zoomOutMethod;

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkView(Context context) {
        super(context, null);
        this.getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
        this.loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
        this.loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
        this.loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
        this.reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
        this.stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
        this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
        this.getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
        this.getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
        this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
        this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
        this.getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
        this.removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
        this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
        this.clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
        this.clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
        this.hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
        this.leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
        this.pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
        this.resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
        this.onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
        this.onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
        this.onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
        this.startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
        this.onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
        this.onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
        this.saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
        this.restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
        this.getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
        this.getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
        this.setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
        this.setBackgroundColorintMethod = new ReflectMethod(null, "setBackgroundColor", new Class[0]);
        this.setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
        this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
        this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
        this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
        this.getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
        this.setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
        this.getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
        this.zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
        this.getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
        this.zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
        this.zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
        this.canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
        this.canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
        this.setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
        this.getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
        this.setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
        this.clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
        this.setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
        this.setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
        this.setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
        this.onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
        this.setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
        this.scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
        this.scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
        this.computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
        this.computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
        this.computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
        this.computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
        this.computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
        this.getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
        this.clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
        this.clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
        this.getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
        this.findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
        this.findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
        this.clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
        this.getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
        View surfaceView = new SurfaceView(context);
        surfaceView.setLayoutParams(new LayoutParams(0, 0));
        addView(surfaceView);
        this.constructorTypes = new ArrayList();
        this.constructorTypes.add(Context.class);
        this.constructorParams = new ArrayList();
        this.constructorParams.add(context);
        this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextConstructor", new Class[0]);
        reflectionInit();
    }

    public void postXWalkViewInternalContextConstructor() {
        addView((FrameLayout) this.bridge, new FrameLayout.LayoutParams(-1, -1));
        removeViewAt(0);
        XWalkExternalExtensionManagerImpl xWalkExternalExtensionManagerImpl = new XWalkExternalExtensionManagerImpl(this);
    }

    public XWalkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
        this.loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
        this.loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
        this.loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
        this.reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
        this.stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
        this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
        this.getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
        this.getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
        this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
        this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
        this.getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
        this.removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
        this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
        this.clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
        this.clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
        this.hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
        this.leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
        this.pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
        this.resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
        this.onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
        this.onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
        this.onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
        this.startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
        this.onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
        this.onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
        this.saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
        this.restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
        this.getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
        this.getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
        this.setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
        this.setBackgroundColorintMethod = new ReflectMethod(null, "setBackgroundColor", new Class[0]);
        this.setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
        this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
        this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
        this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
        this.getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
        this.setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
        this.getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
        this.zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
        this.getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
        this.zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
        this.zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
        this.canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
        this.canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
        this.setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
        this.getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
        this.setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
        this.clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
        this.setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
        this.setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
        this.setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
        this.onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
        this.setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
        this.scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
        this.scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
        this.computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
        this.computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
        this.computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
        this.computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
        this.computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
        this.getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
        this.clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
        this.clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
        this.getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
        this.findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
        this.findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
        this.clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
        this.getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
        if (!isInEditMode()) {
            if (attributeSet != null) {
                this.mAnimatable = attributeSet.getAttributeValue(XWALK_ATTRS_NAMESPACE, ANIMATABLE);
            }
            View surfaceView = new SurfaceView(context);
            surfaceView.setLayoutParams(new LayoutParams(0, 0));
            addView(surfaceView);
            this.constructorTypes = new ArrayList();
            this.constructorTypes.add(Context.class);
            this.constructorTypes.add(AttributeSet.class);
            this.constructorParams = new ArrayList();
            this.constructorParams.add(context);
            this.constructorParams.add(attributeSet);
            this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextAttributeSetConstructor", new Class[0]);
            reflectionInit();
        }
    }

    public void postXWalkViewInternalContextAttributeSetConstructor() {
        addView((FrameLayout) this.bridge, new FrameLayout.LayoutParams(-1, -1));
        removeViewAt(0);
        XWalkExternalExtensionManagerImpl xWalkExternalExtensionManagerImpl = new XWalkExternalExtensionManagerImpl(this);
    }

    @Deprecated
    public XWalkView(Context context, Activity activity) {
        super(context, null);
        this.getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
        this.loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
        this.loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
        this.loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
        this.reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
        this.stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
        this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
        this.getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
        this.getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
        this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
        this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
        this.getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
        this.removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
        this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
        this.clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
        this.clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
        this.hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
        this.leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
        this.pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
        this.resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
        this.onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
        this.onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
        this.onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
        this.startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
        this.onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
        this.onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
        this.saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
        this.restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
        this.getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
        this.getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
        this.setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
        this.setBackgroundColorintMethod = new ReflectMethod(null, "setBackgroundColor", new Class[0]);
        this.setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
        this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
        this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
        this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
        this.getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
        this.setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
        this.getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
        this.zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
        this.getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
        this.zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
        this.zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
        this.canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
        this.canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
        this.setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
        this.getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
        this.setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
        this.clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
        this.setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
        this.setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
        this.setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
        this.onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
        this.setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
        this.scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
        this.scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
        this.computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
        this.computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
        this.computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
        this.computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
        this.computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
        this.getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
        this.clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
        this.clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
        this.getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
        this.findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
        this.findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
        this.clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
        this.getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
        View surfaceView = new SurfaceView(context);
        surfaceView.setLayoutParams(new LayoutParams(0, 0));
        addView(surfaceView);
        this.constructorTypes = new ArrayList();
        this.constructorTypes.add(Context.class);
        this.constructorTypes.add(Activity.class);
        this.constructorParams = new ArrayList();
        this.constructorParams.add(context);
        this.constructorParams.add(activity);
        this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextActivityConstructor", new Class[0]);
        reflectionInit();
    }

    public ViewGroup getXWalkContentView() {
        try {
            return (ViewGroup) this.getXWalkContentViewMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setFocusable(boolean z) {
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusable(false);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusable(false);
    }

    public void setFocusableInTouchMode(boolean z) {
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusableInTouchMode(false);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusableInTouchMode(false);
    }

    public void postXWalkViewInternalContextActivityConstructor() {
        addView((FrameLayout) this.bridge, new FrameLayout.LayoutParams(-1, -1));
        removeViewAt(0);
        XWalkExternalExtensionManagerImpl xWalkExternalExtensionManagerImpl = new XWalkExternalExtensionManagerImpl(this);
    }

    @Deprecated
    public void load(String str, String str2) {
        try {
            this.loadStringStringMethod.invoke(new Object[]{str, str2});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    @Deprecated
    public void load(String str, String str2, Map<String, String> map) {
        try {
            this.loadStringStringMapMethod.invoke(new Object[]{str, str2, map});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void loadData(String str, String str2, String str3) {
        try {
            this.loadDataStringStringStringMethod.invoke(new Object[]{str, str2, str3});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        try {
            this.loadDataWithBaseURLStringStringStringStringStringMethod.invoke(new Object[]{str, str2, str3, str4, str5});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void loadUrl(String str) {
        try {
            this.loadUrlStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        try {
            this.loadUrlStringMapMethod.invoke(new Object[]{str, map});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void loadAppFromManifest(String str, String str2) {
        try {
            this.loadAppFromManifestStringStringMethod.invoke(new Object[]{str, str2});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void reload(int i) {
        try {
            this.reloadintMethod.invoke(new Object[]{Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void stopLoading() {
        try {
            this.stopLoadingMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
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

    public XWalkHitTestResult getHitTestResult() {
        try {
            return (XWalkHitTestResult) this.coreWrapper.getWrapperObject(this.getHitTestResultMethod.invoke(new Object[0]));
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public int getContentHeight() {
        try {
            return ((Integer) this.getContentHeightMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
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

    public XWalkNavigationHistory getNavigationHistory() {
        try {
            return (XWalkNavigationHistory) this.coreWrapper.getWrapperObject(this.getNavigationHistoryMethod.invoke(new Object[0]));
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        try {
            this.addJavascriptInterfaceObjectStringMethod.invoke(new Object[]{obj, str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                this.addJavascriptInterfaceObjectStringMethod.setArguments(new Object[]{obj, str});
                XWalkCoreWrapper.reserveReflectMethod(this.addJavascriptInterfaceObjectStringMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void removeJavascriptInterface(String str) {
        try {
            this.removeJavascriptInterfaceStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                this.removeJavascriptInterfaceStringMethod.setArguments(new Object[]{str});
                XWalkCoreWrapper.reserveReflectMethod(this.removeJavascriptInterfaceStringMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        try {
            this.evaluateJavascriptStringValueCallbackMethod.invoke(new Object[]{str, valueCallback});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void clearCache(boolean z) {
        try {
            this.clearCachebooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void clearCacheForSingleFile(String str) {
        try {
            this.clearCacheForSingleFileStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean hasEnteredFullscreen() {
        try {
            return ((Boolean) this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void leaveFullscreen() {
        try {
            this.leaveFullscreenMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void pauseTimers() {
        try {
            this.pauseTimersMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void resumeTimers() {
        try {
            this.resumeTimersMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onHide() {
        try {
            this.onHideMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onShow() {
        try {
            this.onShowMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onDestroy() {
        try {
            this.onDestroyMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        try {
            this.startActivityForResultIntentintBundleMethod.invoke(new Object[]{intent, Integer.valueOf(i), bundle});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.onActivityResultintintIntentMethod.invoke(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean onNewIntent(Intent intent) {
        try {
            return ((Boolean) this.onNewIntentIntentMethod.invoke(new Object[]{intent})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean saveState(Bundle bundle) {
        try {
            return ((Boolean) this.saveStateBundleMethod.invoke(new Object[]{bundle})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean restoreState(Bundle bundle) {
        try {
            return ((Boolean) this.restoreStateBundleMethod.invoke(new Object[]{bundle})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public String getAPIVersion() {
        try {
            return (String) this.getAPIVersionMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public String getXWalkVersion() {
        try {
            return (String) this.getXWalkVersionMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setUIClient(XWalkUIClient xWalkUIClient) {
        try {
            this.setUIClientXWalkUIClientInternalMethod.invoke(new Object[]{xWalkUIClient.getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                this.setUIClientXWalkUIClientInternalMethod.setArguments(new Object[]{new ReflectMethod(xWalkUIClient, "getBridge", new Class[0])});
                XWalkCoreWrapper.reserveReflectMethod(this.setUIClientXWalkUIClientInternalMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setResourceClient(XWalkResourceClient xWalkResourceClient) {
        try {
            this.setResourceClientXWalkResourceClientInternalMethod.invoke(new Object[]{xWalkResourceClient.getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                this.setResourceClientXWalkResourceClientInternalMethod.setArguments(new Object[]{new ReflectMethod(xWalkResourceClient, "getBridge", new Class[0])});
                XWalkCoreWrapper.reserveReflectMethod(this.setResourceClientXWalkResourceClientInternalMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setBackgroundColor(int i) {
        try {
            this.setBackgroundColorintMethod.invoke(new Object[]{Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setOriginAccessWhitelist(String str, String[] strArr) {
        try {
            this.setOriginAccessWhitelistStringStringArrayMethod.invoke(new Object[]{str, strArr});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setLayerType(int i, Paint paint) {
    }

    public void setUserAgentString(String str) {
        try {
            this.setUserAgentStringStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public String getUserAgentString() {
        try {
            return (String) this.getUserAgentStringMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setAcceptLanguages(String str) {
        try {
            this.setAcceptLanguagesStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void captureBitmapAsync(XWalkGetBitmapCallback xWalkGetBitmapCallback) {
        try {
            this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.invoke(new Object[]{xWalkGetBitmapCallback.getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public XWalkSettings getSettings() {
        try {
            return (XWalkSettings) this.coreWrapper.getWrapperObject(this.getSettingsMethod.invoke(new Object[0]));
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setNetworkAvailable(boolean z) {
        try {
            this.setNetworkAvailablebooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public Uri getRemoteDebuggingUrl() {
        try {
            return (Uri) this.getRemoteDebuggingUrlMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public boolean zoomIn() {
        try {
            return ((Boolean) this.zoomInMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public float getScale() {
        try {
            return ((Float) this.getScalenMethod.invoke(new Object[0])).floatValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 1.0f;
        }
    }

    public boolean zoomOut() {
        try {
            return ((Boolean) this.zoomOutMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void zoomBy(float f) {
        try {
            this.zoomByfloatMethod.invoke(new Object[]{Float.valueOf(f)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean canZoomIn() {
        try {
            return ((Boolean) this.canZoomInMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean canZoomOut() {
        try {
            return ((Boolean) this.canZoomOutMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        try {
            return (InputConnection) this.onCreateInputConnectionEditorInfoMethod.invoke(new Object[]{editorInfo});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setInitialScale(int i) {
        try {
            this.setInitialScaleintMethod.invoke(new Object[]{Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public Bitmap getFavicon() {
        try {
            return (Bitmap) this.getFaviconMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setZOrderOnTop(boolean z) {
        try {
            this.setZOrderOnTopbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void clearFormData() {
        try {
            this.clearFormDataMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setVisibility(int i) {
        if (i == 4) {
            i = 8;
        }
        super.setVisibility(i);
        setXWalkViewInternalVisibility(i);
        setSurfaceViewVisibility(i);
    }

    public void setSurfaceViewVisibility(int i) {
        try {
            this.setSurfaceViewVisibilityintMethod.invoke(new Object[]{Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                this.setSurfaceViewVisibilityintMethod.setArguments(new Object[]{Integer.valueOf(i)});
                XWalkCoreWrapper.reserveReflectMethod(this.setSurfaceViewVisibilityintMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setXWalkViewInternalVisibility(int i) {
        try {
            this.setXWalkViewInternalVisibilityintMethod.invoke(new Object[]{Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                this.setXWalkViewInternalVisibilityintMethod.setArguments(new Object[]{Integer.valueOf(i)});
                XWalkCoreWrapper.reserveReflectMethod(this.setXWalkViewInternalVisibilityintMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setDownloadListener(XWalkDownloadListener xWalkDownloadListener) {
        try {
            this.setDownloadListenerXWalkDownloadListenerInternalMethod.invoke(new Object[]{xWalkDownloadListener.getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                this.setDownloadListenerXWalkDownloadListenerInternalMethod.setArguments(new Object[]{new ReflectMethod(xWalkDownloadListener, "getBridge", new Class[0])});
                XWalkCoreWrapper.reserveReflectMethod(this.setDownloadListenerXWalkDownloadListenerInternalMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    private boolean performLongClickDelegate() {
        return performLongClick();
    }

    private boolean onTouchEventDelegate(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return ((Boolean) this.onTouchEventMotionEventMethod.invoke(new Object[]{motionEvent})).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setCustomOnScrollChangedListener(ScrollChangedListener scrollChangedListener) {
        this.mScrollChangedListener = scrollChangedListener;
    }

    public void onScrollChangedDelegate(int i, int i2, int i3, int i4) {
        onScrollChanged(i, i2, i3, i4);
        if (this.mScrollChangedListener != null) {
            this.mScrollChangedListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    private void onFocusChangedDelegate(boolean z, int i, Rect rect) {
        onFocusChanged(z, i, rect);
    }

    public void setCustomOnOverScrolledListener(OverScrolledListener overScrolledListener) {
        this.mOverScrolledListener = overScrolledListener;
    }

    private void onOverScrolledDelegate(int i, int i2, boolean z, boolean z2) {
        onOverScrolled(i, i2, z, z2);
    }

    private void onOverscrollRefresh(boolean z) {
        if (this.mOverScrolledListener != null) {
            this.mOverScrolledListener.onOverScrolled(z);
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        try {
            this.setOnTouchListenerOnTouchListenerMethod.invoke(new Object[]{onTouchListener});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void scrollTo(int i, int i2) {
        try {
            this.scrollTointintMethod.invoke(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void scrollBy(int i, int i2) {
        try {
            this.scrollByintintMethod.invoke(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public int computeHorizontalScrollRange() {
        try {
            return ((Integer) this.computeHorizontalScrollRangeMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public int computeHorizontalScrollOffset() {
        try {
            return ((Integer) this.computeHorizontalScrollOffsetMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public int computeVerticalScrollRange() {
        try {
            return ((Integer) this.computeVerticalScrollRangeMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public int computeVerticalScrollOffset() {
        try {
            return ((Integer) this.computeVerticalScrollOffsetMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public int computeVerticalScrollExtent() {
        try {
            return ((Integer) this.computeVerticalScrollExtentMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public XWalkExternalExtensionManager getExtensionManager() {
        try {
            return (XWalkExternalExtensionManager) this.coreWrapper.getWrapperObject(this.getExtensionManagerMethod.invoke(new Object[0]));
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void clearSslPreferences() {
        try {
            this.clearSslPreferencesMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void clearClientCertPreferences(Runnable runnable) {
        try {
            this.clearClientCertPreferencesRunnableMethod.invoke(new Object[]{runnable});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public SslCertificate getCertificate() {
        try {
            return (SslCertificate) this.getCertificateMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setFindListener(XWalkFindListener xWalkFindListener) {
        try {
            this.setFindListenerXWalkFindListenerInternalMethod.invoke(new Object[]{xWalkFindListener.getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                this.setFindListenerXWalkFindListenerInternalMethod.setArguments(new Object[]{new ReflectMethod(xWalkFindListener, "getBridge", new Class[0])});
                XWalkCoreWrapper.reserveReflectMethod(this.setFindListenerXWalkFindListenerInternalMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void findAllAsync(String str) {
        try {
            this.findAllAsyncStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void findNext(boolean z) {
        try {
            this.findNextbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void clearMatches() {
        try {
            this.clearMatchesMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public String getCompositingSurfaceType() {
        try {
            return (String) this.getCompositingSurfaceTypeMethod.invoke(new Object[0]);
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
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkViewBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.loadStringStringMethod.init(this.bridge, null, "loadSuper", new Class[]{String.class, String.class});
            this.loadStringStringMapMethod.init(this.bridge, null, "loadSuper", new Class[]{String.class, String.class, Map.class});
            this.loadDataStringStringStringMethod.init(this.bridge, null, "loadDataSuper", new Class[]{String.class, String.class, String.class});
            this.loadDataWithBaseURLStringStringStringStringStringMethod.init(this.bridge, null, "loadDataWithBaseURLSuper", new Class[]{String.class, String.class, String.class, String.class, String.class});
            this.loadUrlStringMethod.init(this.bridge, null, "loadUrlSuper", new Class[]{String.class});
            this.loadUrlStringMapMethod.init(this.bridge, null, "loadUrlSuper", new Class[]{String.class, Map.class});
            this.loadAppFromManifestStringStringMethod.init(this.bridge, null, "loadAppFromManifestSuper", new Class[]{String.class, String.class});
            this.reloadintMethod.init(this.bridge, null, "reloadSuper", new Class[]{Integer.TYPE});
            this.stopLoadingMethod.init(this.bridge, null, "stopLoadingSuper", new Class[0]);
            this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
            this.getHitTestResultMethod.init(this.bridge, null, "getHitTestResultSuper", new Class[0]);
            this.getContentHeightMethod.init(this.bridge, null, "getContentHeightSuper", new Class[0]);
            this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
            this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
            this.getNavigationHistoryMethod.init(this.bridge, null, "getNavigationHistorySuper", new Class[0]);
            this.addJavascriptInterfaceObjectStringMethod.init(this.bridge, null, "addJavascriptInterfaceSuper", new Class[]{Object.class, String.class});
            this.removeJavascriptInterfaceStringMethod.init(this.bridge, null, "removeJavascriptInterfaceSuper", new Class[]{String.class});
            this.evaluateJavascriptStringValueCallbackMethod.init(this.bridge, null, "evaluateJavascriptSuper", new Class[]{String.class, ValueCallback.class});
            this.clearCachebooleanMethod.init(this.bridge, null, "clearCacheSuper", new Class[]{Boolean.TYPE});
            this.clearCacheForSingleFileStringMethod.init(this.bridge, null, "clearCacheForSingleFileSuper", new Class[]{String.class});
            this.hasEnteredFullscreenMethod.init(this.bridge, null, "hasEnteredFullscreenSuper", new Class[0]);
            this.leaveFullscreenMethod.init(this.bridge, null, "leaveFullscreenSuper", new Class[0]);
            this.pauseTimersMethod.init(this.bridge, null, "pauseTimersSuper", new Class[0]);
            this.resumeTimersMethod.init(this.bridge, null, "resumeTimersSuper", new Class[0]);
            this.onHideMethod.init(this.bridge, null, "onHideSuper", new Class[0]);
            this.onShowMethod.init(this.bridge, null, "onShowSuper", new Class[0]);
            this.onDestroyMethod.init(this.bridge, null, "onDestroySuper", new Class[0]);
            this.startActivityForResultIntentintBundleMethod.init(this.bridge, null, "startActivityForResultSuper", new Class[]{Intent.class, Integer.TYPE, Bundle.class});
            this.onActivityResultintintIntentMethod.init(this.bridge, null, "onActivityResultSuper", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class});
            this.onNewIntentIntentMethod.init(this.bridge, null, "onNewIntentSuper", new Class[]{Intent.class});
            this.saveStateBundleMethod.init(this.bridge, null, "saveStateSuper", new Class[]{Bundle.class});
            this.restoreStateBundleMethod.init(this.bridge, null, "restoreStateSuper", new Class[]{Bundle.class});
            this.getAPIVersionMethod.init(this.bridge, null, "getAPIVersionSuper", new Class[0]);
            this.getXWalkVersionMethod.init(this.bridge, null, "getXWalkVersionSuper", new Class[0]);
            this.setUIClientXWalkUIClientInternalMethod.init(this.bridge, null, "setUIClientSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkUIClientBridge")});
            this.setResourceClientXWalkResourceClientInternalMethod.init(this.bridge, null, "setResourceClientSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkResourceClientBridge")});
            this.setBackgroundColorintMethod.init(this.bridge, null, "setBackgroundColorSuper", new Class[]{Integer.TYPE});
            this.setOriginAccessWhitelistStringStringArrayMethod.init(this.bridge, null, "setOriginAccessWhitelistSuper", new Class[]{String.class, String[].class});
            this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", new Class[]{String.class});
            this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
            this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", new Class[]{String.class});
            this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.init(this.bridge, null, "captureBitmapAsyncSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkGetBitmapCallbackBridge")});
            this.getSettingsMethod.init(this.bridge, null, "getSettingsSuper", new Class[0]);
            this.setNetworkAvailablebooleanMethod.init(this.bridge, null, "setNetworkAvailableSuper", new Class[]{Boolean.TYPE});
            this.getRemoteDebuggingUrlMethod.init(this.bridge, null, "getRemoteDebuggingUrlSuper", new Class[0]);
            this.getScalenMethod.init(this.bridge, null, "getScaleSuper", new Class[0]);
            this.zoomInMethod.init(this.bridge, null, "zoomInSuper", new Class[0]);
            this.zoomOutMethod.init(this.bridge, null, "zoomOutSuper", new Class[0]);
            this.zoomByfloatMethod.init(this.bridge, null, "zoomBySuper", new Class[]{Float.TYPE});
            this.canZoomInMethod.init(this.bridge, null, "canZoomInSuper", new Class[0]);
            this.canZoomOutMethod.init(this.bridge, null, "canZoomOutSuper", new Class[0]);
            this.onCreateInputConnectionEditorInfoMethod.init(this.bridge, null, "onCreateInputConnectionSuper", new Class[]{EditorInfo.class});
            this.setInitialScaleintMethod.init(this.bridge, null, "setInitialScaleSuper", new Class[]{Integer.TYPE});
            this.getFaviconMethod.init(this.bridge, null, "getFaviconSuper", new Class[0]);
            this.setZOrderOnTopbooleanMethod.init(this.bridge, null, "setZOrderOnTopSuper", new Class[]{Boolean.TYPE});
            this.clearFormDataMethod.init(this.bridge, null, "clearFormDataSuper", new Class[0]);
            this.setSurfaceViewVisibilityintMethod.init(this.bridge, null, "setSurfaceViewVisibilitySuper", new Class[]{Integer.TYPE});
            this.setXWalkViewInternalVisibilityintMethod.init(this.bridge, null, "setXWalkViewInternalVisibilitySuper", new Class[]{Integer.TYPE});
            this.setDownloadListenerXWalkDownloadListenerInternalMethod.init(this.bridge, null, "setDownloadListenerSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkDownloadListenerBridge")});
            this.onTouchEventMotionEventMethod.init(this.bridge, null, "onTouchEventSuper", new Class[]{MotionEvent.class});
            this.setOnTouchListenerOnTouchListenerMethod.init(this.bridge, null, "setOnTouchListenerSuper", new Class[]{OnTouchListener.class});
            this.scrollTointintMethod.init(this.bridge, null, "scrollToSuper", new Class[]{Integer.TYPE, Integer.TYPE});
            this.scrollByintintMethod.init(this.bridge, null, "scrollBySuper", new Class[]{Integer.TYPE, Integer.TYPE});
            this.computeHorizontalScrollRangeMethod.init(this.bridge, null, "computeHorizontalScrollRangeSuper", new Class[0]);
            this.computeHorizontalScrollOffsetMethod.init(this.bridge, null, "computeHorizontalScrollOffsetSuper", new Class[0]);
            this.computeVerticalScrollRangeMethod.init(this.bridge, null, "computeVerticalScrollRangeSuper", new Class[0]);
            this.computeVerticalScrollOffsetMethod.init(this.bridge, null, "computeVerticalScrollOffsetSuper", new Class[0]);
            this.computeVerticalScrollExtentMethod.init(this.bridge, null, "computeVerticalScrollExtentSuper", new Class[0]);
            this.getExtensionManagerMethod.init(this.bridge, null, "getExtensionManagerSuper", new Class[0]);
            this.clearSslPreferencesMethod.init(this.bridge, null, "clearSslPreferencesSuper", new Class[0]);
            this.clearClientCertPreferencesRunnableMethod.init(this.bridge, null, "clearClientCertPreferencesSuper", new Class[]{Runnable.class});
            this.getCertificateMethod.init(this.bridge, null, "getCertificateSuper", new Class[0]);
            this.setFindListenerXWalkFindListenerInternalMethod.init(this.bridge, null, "setFindListenerSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkFindListenerBridge")});
            this.findAllAsyncStringMethod.init(this.bridge, null, "findAllAsyncSuper", new Class[]{String.class});
            this.findNextbooleanMethod.init(this.bridge, null, "findNextSuper", new Class[]{Boolean.TYPE});
            this.clearMatchesMethod.init(this.bridge, null, "clearMatchesSuper", new Class[0]);
            this.getCompositingSurfaceTypeMethod.init(this.bridge, null, "getCompositingSurfaceTypeSuper", new Class[0]);
            this.getXWalkContentViewMethod.init(this.bridge, null, "getXWalkContentViewSuper", new Class[0]);
        } catch (UnsupportedOperationException e) {
        }
    }
}
