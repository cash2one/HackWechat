package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.e;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

@a(7)
public class WebViewStubProxyUI extends MMActivity {
    private e fBH = null;
    private ak fhK = new ak(new 7(this), true);
    private int msE = 0;
    public boolean tvl = false;
    private boolean tvm = false;
    private int tvn;
    private final e tvo = new 5(this);
    private OnDismissListener tvp = new OnDismissListener(this) {
        final /* synthetic */ WebViewStubProxyUI tvs;

        {
            this.tvs = r1;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (!this.tvs.isFinishing()) {
                this.tvs.finish();
            }
        }
    };
    private ak tvq = new ak(new ak.a(this) {
        final /* synthetic */ WebViewStubProxyUI tvs;

        {
            this.tvs = r1;
        }

        public final boolean uF() {
            if (!this.tvs.isFinishing()) {
                this.tvs.finish();
            }
            return false;
        }
    }, true);

    static /* synthetic */ boolean OJ(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(":");
        return split.length > 0 && split[0].equals("startMonitoringBeacons");
    }

    static /* synthetic */ int d(WebViewStubProxyUI webViewStubProxyUI) {
        int i = webViewStubProxyUI.msE + 1;
        webViewStubProxyUI.msE = i;
        return i;
    }

    static /* synthetic */ void e(WebViewStubProxyUI webViewStubProxyUI) {
        Intent intent = webViewStubProxyUI.getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        x.i("MicroMsg.WebViewStubProxyUI", "onCreate, dealAfterWindowTokenInited = " + intExtra);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        switch (intExtra) {
            case 1:
                i iVar = new i();
                iVar.type = intent.getStringExtra("proxyui_type_key");
                iVar.tJI = intent.getStringExtra("proxyui_function_key");
                iVar.tJG = intent.getStringExtra("proxyui_callback_key");
                iVar.pox = i.aa(intent.getExtras());
                jsapiPermissionWrapper = (JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key");
                if (jsapiPermissionWrapper == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                h.Be(webViewStubProxyUI.tvn).a((Context) webViewStubProxyUI, webViewStubProxyUI.tvo, webViewStubProxyUI.fBH);
                if (!h.Be(webViewStubProxyUI.tvn).a(iVar, jsapiPermissionWrapper)) {
                    try {
                        webViewStubProxyUI.tvo.a(null, null, null, true);
                        return;
                    } catch (Exception e) {
                        x.w("MicroMsg.WebViewStubProxyUI", "onHandleEnd, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            case 4:
                if (((JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key")) == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                h.Be(webViewStubProxyUI.tvn).a((Context) webViewStubProxyUI, webViewStubProxyUI.tvo);
                if (!h.Be(webViewStubProxyUI.tvn).PK(intent.getStringExtra("proxyui_username_key"))) {
                    x.w("MicroMsg.WebViewStubProxyUI", "doProfile fail, finish");
                    webViewStubProxyUI.finish();
                    return;
                }
                return;
            default:
                x.e("MicroMsg.WebViewStubProxyUI", "dealAfterWindowTokenInited unknown actionCode = " + intExtra);
                webViewStubProxyUI.finish();
                return;
        }
    }

    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.fM(21)) {
            getWindow().setStatusBarColor(0);
        }
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = (WebViewStubCallbackWrapper) getIntent().getParcelableExtra("webview_stub_callbacker_key");
        if (webViewStubCallbackWrapper != null) {
            this.fBH = webViewStubCallbackWrapper.tyk;
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        this.tvn = intent.getIntExtra("webview_binder_id", 0);
        x.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d", new Object[]{Integer.valueOf(intExtra), Integer.valueOf(this.tvn)});
        if ("startMonitoringBeacons".equals(intent.getStringExtra("proxyui_function_key"))) {
            this.tvl = true;
        }
        String stringExtra;
        switch (intExtra) {
            case 1:
                if (!this.tvm) {
                    this.fhK.J(100, 100);
                }
                if (this.tvl) {
                    this.tvq.J(5000, 5000);
                    return;
                }
                return;
            case 2:
                final b sfVar = new sf();
                sfVar.fqI = new Runnable(this) {
                    final /* synthetic */ WebViewStubProxyUI tvs;

                    public final void run() {
                        if (sfVar.fJV.fJW) {
                            if (this.tvs.fBH != null) {
                                try {
                                    this.tvs.fBH.n(1001, null);
                                } catch (RemoteException e) {
                                    x.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + e.getMessage());
                                }
                            }
                            this.tvs.finish();
                            e eVar = q.a.vcr;
                            if (eVar != null) {
                                eVar.ar(this.tvs);
                                return;
                            }
                            return;
                        }
                        this.tvs.finish();
                    }
                };
                sfVar.fJU.context = this;
                sfVar.fJU.type = intent.getIntExtra("update_type_key", 0);
                if (sfVar.fJU.type <= 0) {
                    x.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + sfVar.fJU.type);
                    finish();
                    return;
                }
                com.tencent.mm.sdk.b.a.xef.a(sfVar, Looper.myLooper());
                return;
            case 3:
                Dialog a;
                ar.Hg();
                bc EY = c.Fg().EY("@t.qq.com");
                if (!com.tencent.mm.z.q.Gz()) {
                    a = com.tencent.mm.ui.base.h.a((Context) this, R.l.dVC, R.l.dGO, new OnClickListener(this) {
                        final /* synthetic */ WebViewStubProxyUI tvs;

                        {
                            this.tvs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.webview.a.a.ifs.h(new Intent(), this.tvs);
                        }
                    }, null);
                } else if (EY == null || bh.ov(EY.name)) {
                    a = com.tencent.mm.ui.base.h.h(this, R.l.eND, R.l.dGO);
                } else {
                    ar.CG().a(new ad(getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0), bh.ou(getIntent().getStringExtra("shortUrl"))), 0);
                    try {
                        this.fBH.Ar(0);
                        a = null;
                    } catch (Exception e) {
                        x.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + e.getMessage());
                        a = null;
                    }
                }
                if (a == null) {
                    finish();
                    return;
                } else {
                    a.setOnDismissListener(this.tvp);
                    return;
                }
            case 4:
                this.fhK.J(100, 100);
                return;
            case 5:
                if (q.a.vcz != null) {
                    q.a.vcz.a(this, intent.getStringExtra("proxyui_handle_event_url"), this.tvp);
                    return;
                }
                return;
            case 6:
                int intExtra2 = getIntent().getIntExtra("proxyui_expired_errtype", 0);
                int intExtra3 = getIntent().getIntExtra("proxyui_expired_errcode", 0);
                if (intExtra2 == 0 && intExtra3 == 0) {
                    x.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
                    return;
                }
                b cVar = new com.tencent.mm.g.a.c();
                cVar.fmL.fmM = this;
                cVar.fmL.errType = intExtra2;
                cVar.fmL.errCode = intExtra3;
                com.tencent.mm.sdk.b.a.xef.m(cVar);
                return;
            case 8:
                stringExtra = getIntent().getStringExtra("proxyui_phone");
                if (bh.ov(stringExtra)) {
                    x.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
                    finish();
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fromScene", 3);
                k.a(this, stringExtra, this.tvp, bundle2);
                return;
            case 9:
                intent = (Intent) getIntent().getExtras().getParcelable("proxyui_next_intent_key");
                intent.setFlags(603979776);
                com.tencent.mm.bm.d.a(this, "accountsync", "com.tencent.mm.ui.account.SimpleLoginUI", null, intent);
                finish();
                return;
            case 10:
                stringExtra = getIntent().getStringExtra("KAppId");
                String stringExtra2 = getIntent().getStringExtra("shortcut_user_name");
                if (!bh.ov(stringExtra) && !bh.ov(stringExtra2)) {
                    getString(R.l.dGO);
                    r a2 = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dHc), true, new OnCancelListener(this) {
                        final /* synthetic */ WebViewStubProxyUI tvs;

                        {
                            this.tvs = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            x.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                            this.tvs.finish();
                        }
                    });
                    a2.show();
                    com.tencent.mm.plugin.base.model.d.a(ac.getContext(), stringExtra2, stringExtra, new 4(this, a2));
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getForceOrientation() {
        return getIntent().getIntExtra("screen_orientation", -1);
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.tvl) {
            this.fBH = null;
        }
        x.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 113:
            case 115:
            case 116:
            case 117:
            case 118:
                if (iArr[0] == 0) {
                    h.Be(this.tvn).b(i, -1, null);
                    return;
                } else {
                    h.Be(this.tvn).b(i, 0, null);
                    return;
                }
            default:
                return;
        }
    }
}
