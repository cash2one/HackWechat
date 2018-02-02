package com.tencent.mm.plugin.game.gamewebview.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;
import com.tencent.xweb.j.a;

class d$34 extends j {
    final /* synthetic */ d mZC;
    private Dialog mZK = null;

    d$34(d dVar) {
        this.mZC = dVar;
    }

    public final void a(WebView webView, int i) {
    }

    public final void d(WebView webView, String str) {
        x.i("MicroMsg.GameWebPageView", "onReceivedTitle, title = %s", new Object[]{str});
        if (!bh.ou(d.r(this.mZC)).equals(str) && !d.uz(str)) {
            d.e(this.mZC).xv(str);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        x.i("MicroMsg.GameWebPageView", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
        try {
            if (d.u(this.mZC) != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            d.a(this.mZC, view);
            d.a(this.mZC, customViewCallback);
            d.n(this.mZC).setVisibility(8);
            d.v(this.mZC).addView(view);
            d.e(this.mZC).setVisibility(8);
        } catch (Exception e) {
            x.e("MicroMsg.GameWebPageView", "onShowCustomView error " + e.getMessage());
        }
    }

    public final void onHideCustomView() {
        x.i("MicroMsg.GameWebPageView", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
        if (d.u(this.mZC) != null) {
            try {
                d.n(this.mZC).setVisibility(0);
                if (d.v(this.mZC) != null) {
                    d.v(this.mZC).removeView(d.u(this.mZC));
                }
                d.a(this.mZC, null);
                if (d.w(this.mZC) != null) {
                    d.w(this.mZC).onCustomViewHidden();
                }
                d.e(this.mZC).setVisibility(0);
            } catch (Exception e) {
                x.e("MicroMsg.GameWebPageView", "onHideCustomView error " + e.getMessage());
            }
        }
    }

    public final View getVideoLoadingProgressView() {
        if (d.x(this.mZC) == null) {
            d.a(this.mZC, new ProgressBar(d.t(this.mZC)));
            d.x(this.mZC).setIndeterminate(true);
        }
        return d.x(this.mZC);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        x.i("MicroMsg.GameWebPageView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[]{str});
        h.a(d.t(this.mZC), false, d.t(this.mZC).getString(R.l.eYn, new Object[]{str}), d.t(this.mZC).getString(R.l.eYo), d.t(this.mZC).getString(R.l.dFU), d.t(this.mZC).getString(R.l.dEn), new 1(this, callback, str), new 3(this, callback, str));
    }

    public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, a aVar) {
        if (aVar.getMode() != 0) {
            return false;
        }
        if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
            x.i("MicroMsg.GameWebPageView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
            return true;
        }
        d.z(this.mZC).a(d.t(this.mZC), d.y(this.mZC), null, valueCallback, aVar.getAcceptTypes()[0], "*");
        return true;
    }

    public final boolean b(WebView webView, String str, String str2, f fVar) {
        d.a(this.mZC, fVar);
        if (d.A(this.mZC)) {
            fVar.cancel();
            return true;
        }
        d.B(this.mZC);
        if (d.C(this.mZC) > 2) {
            this.mZK = h.a(d.t(this.mZC), str2, "", d.t(this.mZC).getString(R.l.eYi), d.t(this.mZC).getString(R.l.dFU), new 4(this, fVar), new 5(this, fVar), R.e.brB);
        } else {
            this.mZK = h.a(d.t(this.mZC), false, str2, "", d.t(this.mZC).getString(R.l.dFU), d.t(this.mZC).getString(R.l.dEn), new 6(this, fVar), new 7(this, fVar));
        }
        if (this.mZK == null) {
            return super.b(webView, str, str2, fVar);
        }
        this.mZK.setCancelable(false);
        this.mZK.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        return super.a(webView, str, str2, str3, eVar);
    }

    public final boolean a(WebView webView, String str, String str2, final f fVar) {
        x.d("MicroMsg.GameWebPageView", "onJsAlert, mHasDestroy = %b", new Object[]{Boolean.valueOf(d.A(this.mZC))});
        d.a(this.mZC, fVar);
        if (d.A(this.mZC)) {
            fVar.cancel();
            return true;
        }
        d.B(this.mZC);
        if (d.C(this.mZC) > 2) {
            this.mZK = h.a(d.t(this.mZC), str2, "", d.t(this.mZC).getString(R.l.eYi), d.t(this.mZC).getString(R.l.dFU), new 8(this, fVar), new 9(this, fVar), R.e.brB);
        } else {
            this.mZK = h.a(d.t(this.mZC), false, str2, "", d.t(this.mZC).getString(R.l.dFU), d.t(this.mZC).getString(R.l.dEn), new 10(this, fVar), new OnClickListener(this) {
                final /* synthetic */ d$34 mZN;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.cancel();
                }
            });
        }
        if (this.mZK == null) {
            return super.a(webView, str, str2, fVar);
        }
        this.mZK.setCancelable(false);
        this.mZK.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage != null ? consoleMessage.message() : null;
        x.i("MicroMsg.GameWebPageView", "onConsoleMessage : %s", new Object[]{message});
        if (!bh.ov(message)) {
            if (message.equalsIgnoreCase("weixin://preInjectJSBridge/start")) {
                x.i("MicroMsg.GameWebPageView", "now inject js library");
                return true;
            } else if (message.equalsIgnoreCase("weixin://preInjectJSBridge/fail")) {
                return true;
            } else {
                if (message.equalsIgnoreCase("weixin://preInjectJSBridge/ok")) {
                    x.d("MicroMsg.GameWebPageView", "preInjectJSBridge ok");
                    return true;
                } else if (message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
                    x.d("MicroMsg.GameWebPageView", "whiteScreenEnd");
                    d.D(this.mZC);
                    return true;
                }
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
