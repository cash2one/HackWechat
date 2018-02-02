package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;
import com.tencent.xweb.j.a;
import java.util.LinkedList;
import java.util.List;

class WebViewUI$16 extends j {
    private Dialog mZK = null;
    public volatile boolean maM = false;
    final /* synthetic */ WebViewUI tAv;
    private final List<String> tBg = new LinkedList();

    WebViewUI$16(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void a(WebView webView, int i) {
        if (i < 100) {
            WebViewUI.d(this.tAv, false);
        } else if (i >= 100) {
            WebViewUI.d(this.tAv, true);
        }
    }

    public final void d(WebView webView, String str) {
        x.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[]{str, WebViewUI.F(this.tAv)});
        super.d(webView, str);
        if (this.tAv.tyn) {
            x.i("MicroMsg.WebViewUI", "fixed title, ignore received title: " + str);
        } else if (str == null) {
            x.e("MicroMsg.WebViewUI", "null title");
        } else if (WebViewUI.r(this.tAv) && !bh.ou(WebViewUI.F(this.tAv)).equals(str) && !p.uz(str)) {
            this.tAv.setMMTitle(str);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        x.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
        try {
            if (WebViewUI.G(this.tAv) != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            WebViewUI.a(this.tAv, false);
            WebViewUI.a(this.tAv, view);
            WebViewUI.a(this.tAv, customViewCallback);
            if (this.tAv.ptK.isXWalkKernel()) {
                this.tAv.tyu.addView(view, 0);
                WebViewUI.e(this.tAv, true);
                this.tAv.fullScreenNoTitleBar(true);
                this.tAv.setStatusBarColor(0);
                if (this.tAv.nmo != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.tAv.nmo.getLayoutParams();
                    marginLayoutParams.topMargin = 0;
                    this.tAv.nmo.setLayoutParams(marginLayoutParams);
                    return;
                }
                return;
            }
            this.tAv.ptK.setVisibility(8);
            this.tAv.tyu.addView(view);
            this.tAv.setTitleVisibility(4);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "onShowCustomView error " + e.getMessage());
        }
    }

    public final void onHideCustomView() {
        x.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
        if (WebViewUI.G(this.tAv) != null) {
            try {
                WebViewUI.a(this.tAv, false);
                if (this.tAv.ptK.isXWalkKernel()) {
                    WebViewUI.e(this.tAv, false);
                    this.tAv.fullScreenNoTitleBar(false);
                    this.tAv.setStatusBarColor(this.tAv.getResources().getColor(R.e.btS));
                    if (this.tAv.nmo != null) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.tAv.nmo.getLayoutParams();
                        int bSz = this.tAv.jNd + this.tAv.bSz();
                        if (bSz != marginLayoutParams.topMargin) {
                            marginLayoutParams.topMargin = bSz;
                            this.tAv.nmo.setLayoutParams(marginLayoutParams);
                        }
                    }
                } else {
                    this.tAv.ptK.setVisibility(0);
                    this.tAv.setTitleVisibility(0);
                }
                if (this.tAv.tyu != null) {
                    this.tAv.tyu.removeView(WebViewUI.G(this.tAv));
                }
                WebViewUI.a(this.tAv, null);
                if (WebViewUI.H(this.tAv) != null) {
                    WebViewUI.H(this.tAv).onCustomViewHidden();
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "onHideCustomView error " + e.getMessage());
            }
        }
    }

    public final View getVideoLoadingProgressView() {
        if (WebViewUI.I(this.tAv) == null) {
            WebViewUI.a(this.tAv, new ProgressBar(this.tAv));
            WebViewUI.I(this.tAv).setIndeterminate(true);
        }
        return WebViewUI.I(this.tAv);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        x.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[]{str});
        h.a(this.tAv, false, this.tAv.getString(R.l.eYn, new Object[]{str}), this.tAv.getString(R.l.eYo), this.tAv.getString(R.l.dFU), this.tAv.getString(R.l.dEn), new 1(this, callback, str), new 4(this, callback, str));
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        WebViewUI.K(this.tAv).a(this.tAv, this.tAv.juR, valueCallback, null, str, str2);
    }

    public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, a aVar) {
        if (aVar.getMode() != 0) {
            return false;
        }
        if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
            x.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
            return true;
        }
        String str = aVar.getAcceptTypes()[0];
        String str2 = "*";
        if (aVar.isCaptureEnabled()) {
            if ("image/*".equalsIgnoreCase(str)) {
                str2 = "camera";
            } else if ("video/*".equalsIgnoreCase(str)) {
                str2 = "camcorder";
            }
        }
        WebViewUI.K(this.tAv).a(this.tAv, this.tAv.juR, null, valueCallback, str, str2);
        return true;
    }

    public final boolean b(WebView webView, String str, String str2, f fVar) {
        x.d("MicroMsg.WebViewUI", "onJsConfirm");
        PBool pBool = new PBool();
        pBool.value = false;
        if (this.tAv.isFinishing() || this.tAv.xIq) {
            x.d("MicroMsg.WebViewUI", "onJsConfirm finish");
            fVar.cancel();
            return true;
        }
        WebViewUI.L(this.tAv);
        if (WebViewUI.M(this.tAv) > 2) {
            this.mZK = h.a(this.tAv, str2, "", this.tAv.getString(R.l.eYi), this.tAv.getString(R.l.dFU), new 5(this, str, fVar), new 6(this, pBool, fVar), R.e.brB);
        } else {
            this.mZK = h.a(this.tAv.mController.xIM, false, str2, "", this.tAv.getString(R.l.dFU), this.tAv.getString(R.l.dEn), new 7(this, pBool, fVar), new 8(this, fVar));
        }
        if (this.mZK == null) {
            return super.b(webView, str, str2, fVar);
        }
        this.mZK.setOnDismissListener(new 9(this, pBool, fVar));
        this.mZK.setCancelable(false);
        this.mZK.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        return super.a(webView, str, str2, str3, eVar);
    }

    public final boolean a(WebView webView, String str, String str2, final f fVar) {
        x.d("MicroMsg.WebViewUI", "onJsAlert");
        final PBool pBool = new PBool();
        pBool.value = false;
        if (this.tAv.isFinishing() || this.tAv.xIq) {
            x.d("MicroMsg.WebViewUI", "onJsAlert finish");
            fVar.cancel();
            return true;
        }
        i a;
        WebViewUI.L(this.tAv);
        if (WebViewUI.M(this.tAv) > 2) {
            a = h.a(this.tAv, str2, "", this.tAv.getString(R.l.eYi), this.tAv.getString(R.l.dFU), new 10(this, str, fVar), new 11(this, pBool, fVar), R.e.btd);
        } else {
            a = h.a(this.tAv, str2, "", this.tAv.getString(R.l.dFU), new 2(this, pBool, fVar));
        }
        if (a == null) {
            return super.a(webView, str, str2, fVar);
        }
        a.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ WebViewUI$16 tBh;

            public final void onDismiss(DialogInterface dialogInterface) {
                x.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
                if (!pBool.value) {
                    fVar.cancel();
                }
            }
        });
        a.setCanceledOnTouchOutside(false);
        a.mg(false);
        return true;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage != null ? consoleMessage.message() : null;
        x.i("MicroMsg.WebViewUI", "onConsoleMessage : %s", new Object[]{message});
        if (bh.ov(message) || WebViewUI.N(this.tAv) == null || !message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
            return false;
        }
        x.d("MicroMsg.WebViewUI", "whiteScreenEnd");
        this.tAv.tyG = true;
        return true;
    }
}
