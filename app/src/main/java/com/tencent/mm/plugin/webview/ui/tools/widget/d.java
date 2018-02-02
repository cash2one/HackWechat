package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;

public class d extends j {
    private Activity fAF;
    private int mZs = 0;

    public d(MMWebViewWithJsApi mMWebViewWithJsApi) {
        this.fAF = (Activity) mMWebViewWithJsApi.getContext();
    }

    public void d(WebView webView, String str) {
        super.d(webView, str);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        h.a(this.fAF, false, this.fAF.getString(R.l.eYn, new Object[]{str}), this.fAF.getString(R.l.eYo), this.fAF.getString(R.l.dFU), this.fAF.getString(R.l.dEn), new 1(this, callback, str), new 2(this, callback, str));
    }

    public final boolean a(WebView webView, String str, String str2, final f fVar) {
        i a;
        this.mZs++;
        if (this.mZs > 2) {
            a = h.a(this.fAF, str2, "", this.fAF.getString(R.l.eYi), this.fAF.getString(R.l.dFU), new OnClickListener(this) {
                final /* synthetic */ d tKb;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.tKb.onClose();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ d tKb;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.confirm();
                }
            }, R.e.btd);
        } else {
            a = h.a(this.fAF, str2, "", this.fAF.getString(R.l.dFU), new 5(this, fVar));
        }
        if (a == null) {
            return super.a(webView, str, str2, fVar);
        }
        a.setCanceledOnTouchOutside(false);
        a.mg(false);
        return true;
    }

    public final boolean b(WebView webView, String str, String str2, f fVar) {
        i a;
        this.mZs++;
        if (this.mZs > 2) {
            a = h.a(this.fAF, str2, "", this.fAF.getString(R.l.eYi), this.fAF.getString(R.l.dFU), new 6(this, fVar), new 7(this, fVar), R.e.brB);
        } else {
            a = h.a(this.fAF, false, str2, "", this.fAF.getString(R.l.dFU), this.fAF.getString(R.l.dEn), new 8(this, fVar), new 9(this, fVar));
        }
        if (a == null) {
            return super.b(webView, str, str2, fVar);
        }
        a.setCancelable(false);
        a.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        return super.a(webView, str, str2, str3, eVar);
    }

    public void onClose() {
        this.fAF.finish();
    }
}
