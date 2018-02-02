package com.tencent.xweb.x5.sdk;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.f;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.x5.a.a.a.a.a;
import com.tencent.xweb.x5.a.a.a.a.b;
import com.tencent.xweb.x5.a.c;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.x5.g;
import com.tencent.xweb.x5.g$f;
import org.xwalk.core.Log;

public class ProxyWebViewSuperWrapper extends ProxyWebViewClientExtension implements a {
    b mXWebProxyImp;

    public void invalidate() {
    }

    public ProxyWebViewSuperWrapper(b bVar) {
        this.mXWebProxyImp = bVar;
        this.mXWebProxyImp.Asj = this;
    }

    public void onPreReadFinished() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onPreReadFinished();
        }
    }

    public void onPromptScaleSaved() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onPromptScaleSaved();
        }
    }

    public void onUrlChange(String str, String str2) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onUrlChange(str, str2);
        }
    }

    public void onHideListBox() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onHideListBox();
        }
    }

    public void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onShowListBox(strArr, iArr, iArr2, i);
        }
    }

    public void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        }
    }

    public void onTransitionToCommitted() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onTransitionToCommitted();
        }
    }

    public void showTranslateBubble(int i, String str, String str2, int i2) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_showTranslateBubble(i, str, str2, i2);
        } else {
            Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        }
    }

    public void onUploadProgressStart(int i) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onUploadProgressStart(i);
        }
    }

    public void onUploadProgressChange(int i, int i2, String str) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onUploadProgressChange(i, i2, str);
        }
    }

    public void onFlingScrollBegin(int i, int i2, int i3) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onFlingScrollBegin(i, i2, i3);
        }
    }

    public void onFlingScrollEnd() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onFlingScrollEnd();
        }
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onScrollChanged(i, i2, i3, i4);
        }
    }

    public void onSoftKeyBoardShow() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onSoftKeyBoardShow();
        }
    }

    public void onSoftKeyBoardHide(int i) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onSoftKeyBoardHide(i);
        }
    }

    public void onSetButtonStatus(boolean z, boolean z2) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onSetButtonStatus(z, z2);
        }
    }

    public void onHistoryItemChanged() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onHistoryItemChanged();
        }
    }

    public void hideAddressBar() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_hideAddressBar();
        }
    }

    public void handlePluginTag(String str, String str2, boolean z, String str3) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_handlePluginTag(str, str2, z, str3);
        }
    }

    public void onDoubleTapStart() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onDoubleTapStart();
        }
    }

    public void onPinchToZoomStart() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onPinchToZoomStart();
        }
    }

    public void onSlidingTitleOffScreen(int i, int i2) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onSlidingTitleOffScreen(i, i2);
        }
    }

    public void onMissingPluginClicked(String str, String str2, String str3, int i) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onMissingPluginClicked(str, str2, str3, i);
        }
    }

    public void onReportAdFilterInfo(int i, int i2, String str, boolean z) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onReportAdFilterInfo(i, i2, str, z);
        }
    }

    public void onReportHtmlInfo(int i, String str) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onReportHtmlInfo(i, str);
        }
    }

    public void onNativeCrashReport(int i, String str) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onNativeCrashReport(i, str);
        }
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        return this.mXWebProxyImp.onMiscCallBack(str, bundle);
    }

    public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        b bVar = this.mXWebProxyImp;
        return bVar.Asj != null ? bVar.Asj.super_onMiscCallBack(str, bundle, obj, obj2, obj3, obj4) : null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        return this.mXWebProxyImp.onInterceptTouchEvent(motionEvent, view);
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        return this.mXWebProxyImp.onTouchEvent(motionEvent, view);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        return this.mXWebProxyImp.dispatchTouchEvent(motionEvent, view);
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        return this.mXWebProxyImp.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        this.mXWebProxyImp.onScrollChanged(i, i2, i3, i4, view);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        this.mXWebProxyImp.onOverScrolled(i, i2, z, z2, view);
    }

    public void computeScroll(View view) {
        this.mXWebProxyImp.computeScroll(view);
    }

    public void onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onMetricsSavedCountReceived(str, z, j, str2, i);
        } else {
            Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        }
    }

    public boolean notifyAutoAudioPlay(String str, JsResult jsResult) {
        b bVar = this.mXWebProxyImp;
        f com_tencent_xweb_x5_g_f = new g$f(jsResult);
        if (bVar.Asj != null) {
            return bVar.Asj.super_notifyAutoAudioPlay(str, com_tencent_xweb_x5_g_f);
        }
        Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        return false;
    }

    public boolean allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            return bVar.Asj.super_allowJavaScriptOpenWindowAutomatically(str, str2);
        }
        Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        return false;
    }

    public boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            return bVar.Asj.super_notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
        }
        Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        return false;
    }

    public boolean onShowLongClickPopupMenu() {
        return this.mXWebProxyImp.onShowLongClickPopupMenu();
    }

    public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i) {
        b bVar = this.mXWebProxyImp;
        l bVar2 = new g.b(webResourceRequest);
        m a = g.a(webResourceResponse);
        if (bVar.Asj != null) {
            bVar.Asj.super_onResponseReceived(bVar2, a, i);
        } else {
            Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        }
    }

    public void didFirstVisuallyNonEmptyPaint() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_didFirstVisuallyNonEmptyPaint();
        }
    }

    public void documentAvailableInMainFrame() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_documentAvailableInMainFrame();
        }
    }

    public void onReceivedViewSource(String str) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onReceivedViewSource(str);
        }
    }

    public void onPrefetchResourceHit(boolean z) {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onPrefetchResourceHit(z);
        }
    }

    public void onReceivedSslErrorCancel() {
        b bVar = this.mXWebProxyImp;
        if (bVar.Asj != null) {
            bVar.Asj.super_onReceivedSslErrorCancel();
        }
    }

    public boolean shouldDiscardCurrentPage() {
        return this.mXWebProxyImp.shouldDiscardCurrentPage();
    }

    public void hasDiscardCurrentPage(boolean z) {
        this.mXWebProxyImp.hasDiscardCurrentPage(z);
    }

    public void super_onPreReadFinished() {
        super.onPreReadFinished();
    }

    public void super_onPromptScaleSaved() {
        super.onPromptScaleSaved();
    }

    public void super_onUrlChange(String str, String str2) {
        super.onUrlChange(str, str2);
    }

    public void super_onHideListBox() {
        super.onHideListBox();
    }

    public void super_onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i) {
        super.onShowListBox(strArr, iArr, iArr2, i);
    }

    public void super_onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        super.onShowMutilListBox(strArr, iArr, iArr2, iArr3);
    }

    public void super_onInputBoxTextChanged(IX5WebViewExtension iX5WebViewExtension, String str) {
        super.onInputBoxTextChanged(iX5WebViewExtension, str);
    }

    public void super_onTransitionToCommitted() {
        super.onTransitionToCommitted();
    }

    public void super_showTranslateBubble(int i, String str, String str2, int i2) {
        super.showTranslateBubble(i, str, str2, i2);
    }

    public void super_onUploadProgressStart(int i) {
        super.onUploadProgressStart(i);
    }

    public void super_onUploadProgressChange(int i, int i2, String str) {
        super.onUploadProgressChange(i, i2, str);
    }

    public void super_onFlingScrollBegin(int i, int i2, int i3) {
        super.onFlingScrollBegin(i, i2, i3);
    }

    public void super_onFlingScrollEnd() {
        super.onFlingScrollEnd();
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public void super_onSoftKeyBoardShow() {
        super.onSoftKeyBoardShow();
    }

    public void super_onSoftKeyBoardHide(int i) {
        super.onSoftKeyBoardHide(i);
    }

    public void super_onSetButtonStatus(boolean z, boolean z2) {
        super.onSetButtonStatus(z, z2);
    }

    public void super_onHistoryItemChanged() {
        super.onHistoryItemChanged();
    }

    public void super_hideAddressBar() {
        super.hideAddressBar();
    }

    public void super_handlePluginTag(String str, String str2, boolean z, String str3) {
        super.handlePluginTag(str, str2, z, str3);
    }

    public void super_onDoubleTapStart() {
        super.onDoubleTapStart();
    }

    public void super_onPinchToZoomStart() {
        super.onPinchToZoomStart();
    }

    public void super_onSlidingTitleOffScreen(int i, int i2) {
        super.onSlidingTitleOffScreen(i, i2);
    }

    public boolean super_preShouldOverrideUrlLoading(IX5WebViewExtension iX5WebViewExtension, String str) {
        return super.preShouldOverrideUrlLoading(iX5WebViewExtension, str);
    }

    public void super_onMissingPluginClicked(String str, String str2, String str3, int i) {
        super.onMissingPluginClicked(str, str2, str3, i);
    }

    public void super_onReportAdFilterInfo(int i, int i2, String str, boolean z) {
        super.onReportAdFilterInfo(i, i2, str, z);
    }

    public void super_onReportHtmlInfo(int i, String str) {
        super.onReportHtmlInfo(i, str);
    }

    public void super_onNativeCrashReport(int i, String str) {
        super.onNativeCrashReport(i, str);
    }

    public Object super_onMiscCallBack(String str, Bundle bundle) {
        return super.onMiscCallBack(str, bundle);
    }

    public Object super_onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        return super.onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        return super.onInterceptTouchEvent(motionEvent, view);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent, View view) {
        return super.onTouchEvent(motionEvent, view);
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent, View view) {
        return super.dispatchTouchEvent(motionEvent, view);
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4, View view) {
        super.onScrollChanged(i, i2, i3, i4, view);
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        super.onOverScrolled(i, i2, z, z2, view);
    }

    public void super_computeScroll(View view) {
        super.computeScroll(view);
    }

    public void super_onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i) {
        super.onMetricsSavedCountReceived(str, z, j, str2, i);
    }

    public boolean super_notifyAutoAudioPlay(String str, f fVar) {
        return super.notifyAutoAudioPlay(str, new c(fVar));
    }

    public boolean super_allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        return super.allowJavaScriptOpenWindowAutomatically(str, str2);
    }

    public boolean super_notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        return super.notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
    }

    public boolean super_onShowLongClickPopupMenu() {
        return super.onShowLongClickPopupMenu();
    }

    public void super_onResponseReceived(l lVar, m mVar, int i) {
        super.onResponseReceived(e.a(lVar), com.tencent.xweb.x5.a.b(mVar), i);
    }

    public void super_didFirstVisuallyNonEmptyPaint() {
        super.didFirstVisuallyNonEmptyPaint();
    }

    public void super_documentAvailableInMainFrame() {
        super.documentAvailableInMainFrame();
    }

    public void super_onReceivedViewSource(String str) {
        super.onReceivedViewSource(str);
    }

    public void super_onPrefetchResourceHit(boolean z) {
        super.onPrefetchResourceHit(z);
    }

    public void super_onReceivedSslErrorCancel() {
        super.onReceivedSslErrorCancel();
    }
}
