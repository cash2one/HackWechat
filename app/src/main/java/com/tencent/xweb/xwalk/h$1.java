package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.ValueCallback;
import com.tencent.xweb.j;
import com.tencent.xweb.util.e;
import com.tencent.xweb.xwalk.e.a;
import com.tencent.xweb.xwalk.e.b;
import com.tencent.xweb.xwalk.e.c;
import com.tencent.xweb.xwalk.e.d;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkUIClient.InitiateBy;
import org.xwalk.core.XWalkUIClient.JavascriptMessageType;
import org.xwalk.core.XWalkUIClient.LoadStatus;
import org.xwalk.core.XWalkView;

class h$1 extends j {
    String Atm = null;
    final /* synthetic */ h Atn;

    h$1(h hVar, XWalkView xWalkView) {
        this.Atn = hVar;
        super(xWalkView);
    }

    public final void onPageLoadStarted(XWalkView xWalkView, String str) {
        Log.i("XWWebView", "onPageLoadStarted: url = " + str);
        this.Atn.iTV.b(this.Atn.Arl, str, this.Atn.Atc.getFavicon());
        this.Atm = null;
        if (!(this.Atn.Atk == null || str == null || str.equals(this.Atn.Atk) || e.acr(str) == e.acr(this.Atn.Atk))) {
            if (e.acr(this.Atn.Atk) == 1 && e.acr(str) == 2) {
                this.Atn.type = 1;
            } else if (e.acr(this.Atn.Atk) == 2 && e.acr(str) == 1) {
                this.Atn.type = 2;
            }
        }
        this.Atn.Atk = str;
        this.Atn.Arr = System.currentTimeMillis();
        if (str == null) {
            str = "";
        }
        e.dM(str, this.Atn.type);
    }

    public final void onPageLoadStopped(XWalkView xWalkView, String str, LoadStatus loadStatus) {
        if (this.Atm == null || !this.Atm.equals(str)) {
            this.Atm = str;
            Log.i("XWWebView", "onPageFinished: url = " + str + " status = " + loadStatus);
            this.Atn.iTV.a(this.Atn.Arl, str);
            LoadStatus loadStatus2 = LoadStatus.FAILED;
            e.j(str, System.currentTimeMillis() - this.Atn.Arr, this.Atn.type);
            this.Atn.Arr = System.currentTimeMillis();
            return;
        }
        Log.i("XWWebView", "abandoned onPageFinished: url = " + str + " status = " + loadStatus);
    }

    public final void onReceivedTitle(XWalkView xWalkView, String str) {
        Log.i("XWWebView", "onReceivedTitle: " + str);
        super.onReceivedTitle(xWalkView, str);
        this.Atn.jFi.d(null, str);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        Log.i("XWWebView", "onShowCustomView");
        this.Atn.Ath.setVisibility(4);
        this.Atn.jFi.onShowCustomView(view, new a(customViewCallback));
    }

    public final void onHideCustomView() {
        Log.i("XWWebView", "onHideCustomView");
        this.Atn.Ath.setVisibility(0);
        this.Atn.jFi.onHideCustomView();
    }

    public final View getVideoLoadingProgressView() {
        Log.i("XWWebView", "getVideoLoadingProgressView");
        return this.Atn.jFi.getVideoLoadingProgressView();
    }

    public final boolean onJsAlert(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        Log.i("XWWebView", "onJsAlert");
        return this.Atn.jFi.a(this.Atn.Arl, str, str2, new c(xWalkJavascriptResult));
    }

    public final boolean onJsConfirm(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        Log.i("XWWebView", "onJsConfirm");
        return this.Atn.jFi.b(this.Atn.Arl, str, str2, new c(xWalkJavascriptResult));
    }

    public final boolean onJsPrompt(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        Log.i("XWWebView", "onJsPrompt");
        return this.Atn.jFi.a(this.Atn.Arl, str, str2, str3, new d(xWalkJavascriptResult));
    }

    public final void onGeolocationPermissionsShowPrompt(String str, XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
        this.Atn.jFi.onGeolocationPermissionsShowPrompt(str, new b(xWalkGeolocationPermissionsCallback));
    }

    public final void onGeolocationPermissionsHidePrompt() {
    }

    public final boolean onConsoleMessage(XWalkView xWalkView, String str, int i, String str2, ConsoleMessageType consoleMessageType) {
        Log.i("XWWebView", "onConsoleMessage " + str);
        j jVar = this.Atn.jFi;
        MessageLevel messageLevel = MessageLevel.DEBUG;
        switch (e$1.AsV[consoleMessageType.ordinal()]) {
            case 1:
                messageLevel = MessageLevel.DEBUG;
                break;
            case 2:
                messageLevel = MessageLevel.ERROR;
                break;
            case 3:
                messageLevel = MessageLevel.LOG;
                break;
            case 4:
                messageLevel = MessageLevel.TIP;
                break;
            case 5:
                messageLevel = MessageLevel.WARNING;
                break;
        }
        return jVar.onConsoleMessage(new ConsoleMessage(str, str2, i, messageLevel));
    }

    public final void openFileChooser(XWalkView xWalkView, ValueCallback<Uri> valueCallback, String str, String str2) {
        Log.i("XWWebView", "openFileChooser with three param");
        this.Atn.jFi.openFileChooser(valueCallback, str, str2);
    }

    public final boolean onCreateWindowRequested(XWalkView xWalkView, InitiateBy initiateBy, ValueCallback<XWalkView> valueCallback) {
        return super.onCreateWindowRequested(xWalkView, initiateBy, valueCallback);
    }

    public final void onIconAvailable(XWalkView xWalkView, String str, Message message) {
        super.onIconAvailable(xWalkView, str, message);
    }

    public final void onReceivedIcon(XWalkView xWalkView, String str, Bitmap bitmap) {
        super.onReceivedIcon(xWalkView, str, bitmap);
    }

    public final void onRequestFocus(XWalkView xWalkView) {
        super.onRequestFocus(xWalkView);
    }

    public final void onJavascriptCloseWindow(XWalkView xWalkView) {
        super.onJavascriptCloseWindow(xWalkView);
    }

    public final boolean onJavascriptModalDialog(XWalkView xWalkView, JavascriptMessageType javascriptMessageType, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        return super.onJavascriptModalDialog(xWalkView, javascriptMessageType, str, str2, str3, xWalkJavascriptResult);
    }

    public final void onFullscreenToggled(XWalkView xWalkView, boolean z) {
        super.onFullscreenToggled(xWalkView, z);
    }

    public final void onScaleChanged(XWalkView xWalkView, float f, float f2) {
        this.Atn.iTV.blg();
    }

    public final boolean shouldOverrideKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(xWalkView, keyEvent);
    }

    public final void onUnhandledKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
        super.onUnhandledKeyEvent(xWalkView, keyEvent);
    }

    public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, i, customViewCallback);
    }
}
