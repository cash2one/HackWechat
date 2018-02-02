package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public class e implements OnCreateContextMenuListener, com.tencent.mm.plugin.appbrand.jsapi.n.c.b {
    private String juH;
    MMWebViewWithJsApi juN;
    private b juO;
    private a juP;
    private d juQ;
    private com.tencent.mm.plugin.webview.ui.tools.e juR;
    private l juS;
    private String juT;
    int juU;
    int juV;
    g juW;
    com.tencent.xweb.WebView.a juX;
    com.tencent.xweb.WebView.a juY;
    private final c juZ = new c();
    private final c.c jva;
    private com.tencent.mm.plugin.webview.ui.tools.widget.g jvb = new 1(this);
    private g.c jvc = new g.c(this) {
        final /* synthetic */ e jvd;

        {
            this.jvd = r1;
        }

        public final void sT(String str) {
            try {
                if (this.jvd.juQ != null) {
                    this.jvd.juQ.c(str, new int[]{5});
                    return;
                }
                x.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
            } catch (RemoteException e) {
                x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
            }
        }
    };

    private class a extends com.tencent.mm.plugin.webview.ui.tools.widget.d {
        final /* synthetic */ e jvd;

        a(e eVar, MMWebViewWithJsApi mMWebViewWithJsApi) {
            this.jvd = eVar;
            super(mMWebViewWithJsApi);
        }

        public final void d(WebView webView, String str) {
            super.d(webView, str);
            this.jvd.jva.sQ(str);
        }

        protected final void onClose() {
            this.jvd.jva.ahA();
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            a(valueCallback, null, str, str2);
        }

        public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, com.tencent.xweb.j.a aVar) {
            if (aVar.getMode() != 0) {
                return false;
            }
            if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                x.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
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
            a(null, valueCallback, str, str2);
            return true;
        }

        private void a(ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
            if (this.jvd.juN.getContext() instanceof MMActivity) {
                MMActivity mMActivity = (MMActivity) this.jvd.juN.getContext();
                mMActivity.jwN = new 1(this, mMActivity);
                this.jvd.juZ.a(mMActivity, this.jvd.juR, valueCallback, valueCallback2, str, str2);
            }
        }
    }

    private class b extends com.tencent.mm.plugin.webview.ui.tools.widget.e {
        final /* synthetic */ e jvd;

        b(e eVar, MMWebView mMWebView) {
            this.jvd = eVar;
            super(mMWebView);
        }

        protected final com.tencent.mm.plugin.webview.ui.tools.widget.g ahF() {
            return this.jvd.jvb;
        }

        protected final void a(d dVar, com.tencent.mm.plugin.webview.ui.tools.e eVar) {
            this.jvd.juQ = dVar;
            this.jvd.juR = eVar;
            try {
                Bundle bundle = new Bundle();
                bundle.putString("key_webview_container_env", "miniProgram");
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("jsapiargs", bundle);
                dVar.a(20, bundle2, this.juE.hashCode());
            } catch (RemoteException e) {
                x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + e.getMessage());
            }
        }

        protected final void a(WebView webView, String str, Bitmap bitmap) {
            this.jvd.juH = str;
            this.jvd.jva.ahz();
        }

        protected final void e(WebView webView, String str) {
            this.jvd.juH = str;
            this.jvd.jva.sR(str);
        }

        protected final int ahG() {
            return 49;
        }

        protected final void e(Bundle bundle, String str) {
            super.e(bundle, str);
            bundle.putString("geta8key_data_appid", this.jvd.jva.getAppId());
        }
    }

    static /* synthetic */ void c(e eVar, String str) {
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
            intent.putExtra("Retr_Msg_Type", 4);
        }
        com.tencent.mm.bm.d.a(eVar.juN.getContext(), ".ui.transmit.MsgRetransmitUI", intent);
    }

    static /* synthetic */ void d(e eVar, String str) {
        try {
            if (eVar.juQ.OT(str) == 0) {
                Toast.makeText(eVar.juN.getContext(), eVar.juN.getContext().getString(R.l.efV), 0).show();
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "favoriteUrl fail, ex = " + e.getMessage());
        }
    }

    public e(c.c cVar) {
        this.jva = cVar;
        this.juN = (MMWebViewWithJsApi) cVar.ahy();
        this.juO = new b(this, this.juN);
        this.juP = new a(this, this.juN);
        this.juN.setWebViewClient(this.juO);
        this.juN.setWebChromeClient(this.juP);
        this.juN.tKw = true;
        this.juS = new l(this.juN.getContext());
        this.juS.a(this.juN, this, null);
        this.juS.e(new 2(this));
    }

    public final void cleanup() {
        this.juO.cleanup();
        this.juN.destroy();
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.juQ.isSDCardAvailable();
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            return true;
        }
        if (this.juR == null) {
            return true;
        }
        contextMenu.setHeaderTitle(R.l.eYq);
        try {
            isSDCardAvailable = this.juQ.aOD();
        } catch (Exception e2) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", new Object[]{e2.getMessage()});
            isSDCardAvailable = false;
        }
        x.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[]{Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.juR.bSt().cdD()), Boolean.valueOf(this.juR.bSt().cdE())});
        if (isSDCardAvailable && r3) {
            contextMenu.add(0, 0, 0, this.juN.getContext().getString(R.l.eBK)).setOnMenuItemClickListener(new 3(this, str));
        }
        contextMenu.add(0, 0, 0, this.juN.getContext().getString(R.l.eHg)).setOnMenuItemClickListener(new 4(this, str));
        if (isSDCardAvailable && r4) {
            contextMenu.add(0, 0, 0, this.juN.getContext().getString(R.l.eAd)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ e jvd;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        boolean isSDCardAvailable = this.jvd.juQ.isSDCardAvailable();
                        String replaceAll = str.replaceAll("tp=webp", "");
                        s.a(this.jvd.juN.getContext(), replaceAll, com.tencent.xweb.b.cIj().getCookie(replaceAll), isSDCardAvailable, new com.tencent.mm.pluginsdk.ui.tools.s.b(this) {
                            final /* synthetic */ AnonymousClass5 jvj;

                            {
                                this.jvj = r1;
                            }

                            public final void sS(String str) {
                                e.d(this.jvj.jvd, str);
                            }
                        });
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        if (this.juT == null) {
            return false;
        }
        CharSequence string;
        String str2 = this.juT;
        if (com.tencent.mm.plugin.scanner.a.az(this.juU, this.juT)) {
            string = this.juN.getContext().getString(R.l.eCr);
        } else {
            string = this.juN.getContext().getString(R.l.eCq);
        }
        contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new 6(this, str2, str));
        this.juT = null;
        return true;
    }

    private void a(ContextMenu contextMenu, com.tencent.xweb.WebView.a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.juR.bSt().cdB()) {
            this.juY = aVar;
            this.juW = new g();
            this.juW.a(this.juN, this.jvc);
        }
    }

    private void b(ContextMenu contextMenu, com.tencent.xweb.WebView.a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.juR.bSt().cdB()) {
            this.juX = aVar;
            this.juW = new g();
            this.juW.a(this.juN, this.jvc);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        com.tencent.xweb.WebView.a hitTestResult;
        if (view instanceof android.webkit.WebView) {
            hitTestResult = this.juN.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                }
            }
        } else if (view instanceof MMWebView) {
            hitTestResult = ((MMWebView) view).getHitTestResult();
            if (hitTestResult == null) {
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                a(contextMenu, hitTestResult);
            }
        }
    }
}
