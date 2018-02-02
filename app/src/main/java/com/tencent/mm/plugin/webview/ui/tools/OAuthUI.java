package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2$Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth$Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.WebView;

public class OAuthUI extends WebViewUI {
    private String appId;
    private boolean ogm = false;
    private boolean twI = true;
    private SendAuth$Req twJ;
    private c twK;
    private ak twL;

    static /* synthetic */ void a(OAuthUI oAuthUI, String str) {
        String OP;
        String bRS;
        Exception e;
        Resp resp;
        Bundle bundle;
        MMessageActV2$Args mMessageActV2$Args;
        String str2 = null;
        x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, url = " + str);
        if (!bh.ov(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                oAuthUI.ptK.loadUrl(str);
                return;
            }
            x.i("MicroMsg.OAuthUI", "check schema as appId:" + oAuthUI.appId);
            try {
                OP = oAuthUI.juQ.OP(oAuthUI.appId);
                try {
                    bRS = oAuthUI.juQ.bRS();
                    try {
                        str2 = oAuthUI.juQ.aN(274436, null);
                    } catch (Exception e2) {
                        e = e2;
                        x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
                        if (!bh.ov(OP)) {
                            x.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                            oAuthUI.ptK.loadUrl(str);
                        } else if (!str.toLowerCase().startsWith("http")) {
                            x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                            oAuthUI.ptK.loadUrl(str);
                        } else if (oAuthUI.ogm) {
                            oAuthUI.ogm = true;
                            resp = new Resp();
                            resp.transaction = oAuthUI.twJ.transaction;
                            resp.lang = bRS;
                            resp.country = str2;
                            str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                            x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                            if (!bh.ov(str2)) {
                                resp.errCode = -1;
                            } else if (str2.toLowerCase().equals("authdeny")) {
                                resp.errCode = 0;
                                resp.code = str2;
                            } else {
                                resp.errCode = -4;
                            }
                            resp.state = parse.getQueryParameter("state");
                            resp.errStr = parse.getQueryParameter("reason");
                            resp.url = str;
                            x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                            bundle = new Bundle();
                            resp.toBundle(bundle);
                            p.ae(bundle);
                            mMessageActV2$Args = new MMessageActV2$Args();
                            mMessageActV2$Args.targetPkgName = OP;
                            mMessageActV2$Args.bundle = bundle;
                            MMessageActV2.send(oAuthUI, mMessageActV2$Args);
                            oAuthUI.finish();
                        } else {
                            x.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    bRS = str2;
                    x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
                    if (!bh.ov(OP)) {
                        x.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                        oAuthUI.ptK.loadUrl(str);
                    } else if (!str.toLowerCase().startsWith("http")) {
                        x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                        oAuthUI.ptK.loadUrl(str);
                    } else if (oAuthUI.ogm) {
                        oAuthUI.ogm = true;
                        resp = new Resp();
                        resp.transaction = oAuthUI.twJ.transaction;
                        resp.lang = bRS;
                        resp.country = str2;
                        str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                        x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                        if (!bh.ov(str2)) {
                            resp.errCode = -1;
                        } else if (str2.toLowerCase().equals("authdeny")) {
                            resp.errCode = 0;
                            resp.code = str2;
                        } else {
                            resp.errCode = -4;
                        }
                        resp.state = parse.getQueryParameter("state");
                        resp.errStr = parse.getQueryParameter("reason");
                        resp.url = str;
                        x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                        bundle = new Bundle();
                        resp.toBundle(bundle);
                        p.ae(bundle);
                        mMessageActV2$Args = new MMessageActV2$Args();
                        mMessageActV2$Args.targetPkgName = OP;
                        mMessageActV2$Args.bundle = bundle;
                        MMessageActV2.send(oAuthUI, mMessageActV2$Args);
                        oAuthUI.finish();
                    } else {
                        x.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                    }
                }
            } catch (Exception e32) {
                e = e32;
                OP = str2;
                bRS = str2;
                x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
                if (!bh.ov(OP)) {
                    x.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                    oAuthUI.ptK.loadUrl(str);
                } else if (!str.toLowerCase().startsWith("http")) {
                    x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                    oAuthUI.ptK.loadUrl(str);
                } else if (oAuthUI.ogm) {
                    oAuthUI.ogm = true;
                    resp = new Resp();
                    resp.transaction = oAuthUI.twJ.transaction;
                    resp.lang = bRS;
                    resp.country = str2;
                    str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                    x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                    if (!bh.ov(str2)) {
                        resp.errCode = -1;
                    } else if (str2.toLowerCase().equals("authdeny")) {
                        resp.errCode = 0;
                        resp.code = str2;
                    } else {
                        resp.errCode = -4;
                    }
                    resp.state = parse.getQueryParameter("state");
                    resp.errStr = parse.getQueryParameter("reason");
                    resp.url = str;
                    x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                    bundle = new Bundle();
                    resp.toBundle(bundle);
                    p.ae(bundle);
                    mMessageActV2$Args = new MMessageActV2$Args();
                    mMessageActV2$Args.targetPkgName = OP;
                    mMessageActV2$Args.bundle = bundle;
                    MMessageActV2.send(oAuthUI, mMessageActV2$Args);
                    oAuthUI.finish();
                } else {
                    x.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                }
            }
            if (!bh.ov(OP)) {
                x.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                oAuthUI.ptK.loadUrl(str);
            } else if (!str.toLowerCase().startsWith("http")) {
                x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                oAuthUI.ptK.loadUrl(str);
            } else if (oAuthUI.ogm) {
                x.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
            } else {
                oAuthUI.ogm = true;
                resp = new Resp();
                resp.transaction = oAuthUI.twJ.transaction;
                resp.lang = bRS;
                resp.country = str2;
                str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                if (!bh.ov(str2)) {
                    resp.errCode = -1;
                } else if (str2.toLowerCase().equals("authdeny")) {
                    resp.errCode = -4;
                } else {
                    resp.errCode = 0;
                    resp.code = str2;
                }
                resp.state = parse.getQueryParameter("state");
                resp.errStr = parse.getQueryParameter("reason");
                resp.url = str;
                x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                bundle = new Bundle();
                resp.toBundle(bundle);
                p.ae(bundle);
                mMessageActV2$Args = new MMessageActV2$Args();
                mMessageActV2$Args.targetPkgName = OP;
                mMessageActV2$Args.bundle = bundle;
                MMessageActV2.send(oAuthUI, mMessageActV2$Args);
                oAuthUI.finish();
            }
        }
    }

    static /* synthetic */ void a(OAuthUI oAuthUI, String str, String str2, String str3) {
        View inflate = ((ViewStub) oAuthUI.findViewById(R.h.cyC)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(R.l.eXA));
        oAuthUI.setMMSubTitle(oAuthUI.getString(R.l.eIt));
        oAuthUI.removeOptionMenu(1);
        ImageView imageView = (ImageView) oAuthUI.findViewById(R.h.coi);
        TextView textView = (TextView) oAuthUI.findViewById(R.h.cZI);
        ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) oAuthUI.findViewById(R.h.cts);
        threeDotsLoadingView.cze();
        a aVar = new a();
        aVar.hDZ = 10.0f;
        aVar.hDP = R.k.dzf;
        com.tencent.mm.aq.a.a.PH().a(str, imageView, aVar.PK());
        if (bh.ov(str2)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str2);
        }
        oAuthUI.twL = new ak(new 8(oAuthUI, str3, inflate, threeDotsLoadingView), false);
        oAuthUI.twL.J(1000, 1000);
    }

    static /* synthetic */ void b(OAuthUI oAuthUI, String str) {
        ((ViewStub) oAuthUI.findViewById(R.h.cyD)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(R.l.eXA));
        oAuthUI.setMMSubTitle(oAuthUI.getString(R.l.eIt));
        oAuthUI.removeOptionMenu(1);
        TextView textView = (TextView) oAuthUI.findViewById(R.h.cZI);
        if (bh.ov(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
    }

    protected void onResume() {
        super.onResume();
        WebView.enablePlatformNotifications();
    }

    protected void onPause() {
        super.onPause();
        WebView.disablePlatformNotifications();
    }

    protected final int getLayoutId() {
        return R.i.dud;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.trN != null) {
            this.trN.bRa().fIG = "weixin://mark/oauth";
        }
    }

    protected final void akN() {
        boolean aOD;
        super.akN();
        try {
            aOD = this.juQ.aOD();
        } catch (Exception e) {
            x.w("MicroMsg.OAuthUI", "hasSetUin, ex = " + e.getMessage());
            aOD = false;
        }
        if (aOD) {
            this.ptK.setWebChromeClient(new 2(this));
            this.ptK.setWebViewClient(new i(this) {
                final /* synthetic */ OAuthUI twM;

                {
                    this.twM = r1;
                }

                public final boolean OZ(String str) {
                    x.i("MicroMsg.OAuthUI", "mmShouldOverrideUrlLoading, url = " + str);
                    if (!(str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe"))) {
                        OAuthUI.a(this.twM, str);
                    }
                    return true;
                }
            });
            this.ptK.setDownloadListener(new DownloadListener(this) {
                final /* synthetic */ OAuthUI twM;

                {
                    this.twM = r1;
                }

                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    this.twM.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            });
            this.ptK.cyV();
            setBackBtn(new 5(this));
            addTextOptionMenu(1, getString(R.l.dGw), new 6(this));
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (bh.ov(string)) {
                x.f("MicroMsg.OAuthUI", "content is null");
                return;
            }
            this.appId = Uri.parse(string).getQueryParameter("appid");
            x.i("MicroMsg.OAuthUI", "initView, appId = " + this.appId);
            try {
                this.juQ.OO(this.appId);
            } catch (Exception e2) {
                x.w("MicroMsg.OAuthUI", "checkGetAppSetting, ex = " + e2.getMessage());
            }
            this.twJ = new SendAuth$Req(extras);
            try {
                this.tze.bTl();
            } catch (Exception e22) {
                x.w("MicroMsg.OAuthUI", "AC_ADD_SCENE_END, ex = " + e22.getMessage());
            }
            bSk();
            return;
        }
        x.e("MicroMsg.OAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.l.dCh, 1).show();
        setBackBtn(new 1(this));
        enableOptionMenu(false);
    }

    protected void onStop() {
        this.ptK.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        try {
            this.tze.bTm();
        } catch (Exception e) {
            x.w("MicroMsg.OAuthUI", "AC_REMOVE_SCENE_END, ex = " + e.getMessage());
        }
        if (this.twL != null) {
            this.twL.TG();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.twI && i == 4 && this.ptK.canGoBack()) {
            this.ptK.goBack();
            return true;
        } else if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        } else {
            bSi();
            finish();
            return true;
        }
    }

    private void bSi() {
        String OP;
        String bRS;
        Exception exception;
        Resp resp;
        Bundle bundle;
        MMessageActV2$Args mMessageActV2$Args;
        String str = null;
        x.i("MicroMsg.OAuthUI", "callbackResultCancel, appId = " + this.appId);
        if (this.ogm) {
            x.e("MicroMsg.OAuthUI", "has callback, ignore this callback");
            return;
        }
        this.ogm = true;
        try {
            OP = this.juQ.OP(this.appId);
            try {
                bRS = this.juQ.bRS();
            } catch (Exception e) {
                exception = e;
                bRS = str;
                x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
                if (bh.ov(OP)) {
                    x.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
                    return;
                }
                resp = new Resp();
                resp.transaction = this.twJ.transaction;
                resp.errCode = -2;
                resp.lang = bRS;
                resp.country = str;
                bundle = new Bundle();
                resp.toBundle(bundle);
                p.ae(bundle);
                mMessageActV2$Args = new MMessageActV2$Args();
                mMessageActV2$Args.targetPkgName = OP;
                mMessageActV2$Args.bundle = bundle;
                MMessageActV2.send(this, mMessageActV2$Args);
            }
            try {
                str = this.juQ.aN(274436, null);
            } catch (Exception e2) {
                exception = e2;
                x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
                if (bh.ov(OP)) {
                    x.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
                    return;
                }
                resp = new Resp();
                resp.transaction = this.twJ.transaction;
                resp.errCode = -2;
                resp.lang = bRS;
                resp.country = str;
                bundle = new Bundle();
                resp.toBundle(bundle);
                p.ae(bundle);
                mMessageActV2$Args = new MMessageActV2$Args();
                mMessageActV2$Args.targetPkgName = OP;
                mMessageActV2$Args.bundle = bundle;
                MMessageActV2.send(this, mMessageActV2$Args);
            }
        } catch (Exception e3) {
            exception = e3;
            OP = str;
            bRS = str;
            x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
            if (bh.ov(OP)) {
                resp = new Resp();
                resp.transaction = this.twJ.transaction;
                resp.errCode = -2;
                resp.lang = bRS;
                resp.country = str;
                bundle = new Bundle();
                resp.toBundle(bundle);
                p.ae(bundle);
                mMessageActV2$Args = new MMessageActV2$Args();
                mMessageActV2$Args.targetPkgName = OP;
                mMessageActV2$Args.bundle = bundle;
                MMessageActV2.send(this, mMessageActV2$Args);
            }
            x.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
            return;
        }
        if (bh.ov(OP)) {
            x.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
            return;
        }
        resp = new Resp();
        resp.transaction = this.twJ.transaction;
        resp.errCode = -2;
        resp.lang = bRS;
        resp.country = str;
        bundle = new Bundle();
        resp.toBundle(bundle);
        p.ae(bundle);
        mMessageActV2$Args = new MMessageActV2$Args();
        mMessageActV2$Args.targetPkgName = OP;
        mMessageActV2$Args.bundle = bundle;
        MMessageActV2.send(this, mMessageActV2$Args);
    }

    protected final boolean bSj() {
        return true;
    }

    protected final void initView() {
        super.initView();
        this.ptK.getSettings().setJavaScriptEnabled(true);
        this.ptK.setVerticalScrollBarEnabled(false);
    }

    private void bSk() {
        w.d(getSharedPreferences(ac.cfs(), 0));
        this.twK = c.a(this, this.appId, this.twJ, new 7(this), this.juQ);
    }

    public final void b(c cVar) {
        Exception e;
        Object obj;
        c.a aVar;
        boolean z;
        c.a aVar2;
        c cVar2;
        if (this.twK != null) {
            c cVar3 = this.twK;
            if (cVar3.twD) {
                String string;
                int i = -1;
                int i2 = -1;
                String str = null;
                String str2 = null;
                int i3 = -1;
                try {
                    i = cVar.bRK();
                    i2 = cVar.bRL();
                    cVar.KM();
                    str = cVar.getData().getString("geta8key_result_full_url");
                    str2 = cVar.getData().getString("geta8key_result_head_img");
                    string = cVar.getData().getString("geta8key_result_wording");
                    try {
                        i3 = cVar.getData().getInt("geta8key_result_action_code", -1);
                    } catch (Exception e2) {
                        e = e2;
                        x.e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + e.getMessage());
                        x.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
                        if (cVar3.mIl != null) {
                            cVar3.mIl.dismiss();
                        }
                        cVar3.twC = false;
                        cVar3.hkO.TG();
                        if (i2 == 0) {
                        }
                        if (i == 4) {
                        }
                        if (i != 1) {
                        }
                        x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + i);
                        obj = null;
                        if (obj == null) {
                            aVar = cVar3.twE;
                            if (i2 == -1) {
                                z = false;
                                aVar2 = aVar;
                                cVar2 = cVar3;
                            } else {
                                z = true;
                                aVar2 = aVar;
                                cVar2 = cVar3;
                            }
                        } else {
                            str = null;
                            z = true;
                            aVar2 = cVar3.twE;
                            cVar2 = cVar3;
                        }
                        aVar2.a(cVar2, str, z);
                        return;
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    string = null;
                    e = exception;
                    x.e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + e.getMessage());
                    x.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
                    if (cVar3.mIl != null) {
                        cVar3.mIl.dismiss();
                    }
                    cVar3.twC = false;
                    cVar3.hkO.TG();
                    if (i2 == 0) {
                    }
                    if (i == 4) {
                    }
                    if (i != 1) {
                    }
                    x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + i);
                    obj = null;
                    if (obj == null) {
                        str = null;
                        z = true;
                        aVar2 = cVar3.twE;
                        cVar2 = cVar3;
                    } else {
                        aVar = cVar3.twE;
                        if (i2 == -1) {
                            z = true;
                            aVar2 = aVar;
                            cVar2 = cVar3;
                        } else {
                            z = false;
                            aVar2 = aVar;
                            cVar2 = cVar3;
                        }
                    }
                    aVar2.a(cVar2, str, z);
                    return;
                }
                x.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
                if (cVar3.mIl != null) {
                    cVar3.mIl.dismiss();
                }
                cVar3.twC = false;
                cVar3.hkO.TG();
                if ((i2 == 0 || i != 0) && i2 != -2033) {
                    if (i == 4 || i2 != -100) {
                        if (i != 1 || i == 2 || i == 7 || i == 8) {
                            x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + i);
                            obj = null;
                        } else if (an.isConnected(cVar3.twF)) {
                            obj = 1;
                        } else {
                            x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, not connected");
                            obj = null;
                        }
                        if (obj == null) {
                            str = null;
                            z = true;
                            aVar2 = cVar3.twE;
                            cVar2 = cVar3;
                        } else {
                            aVar = cVar3.twE;
                            if (i2 == -1) {
                                z = true;
                                aVar2 = aVar;
                                cVar2 = cVar3;
                            } else {
                                z = false;
                                aVar2 = aVar;
                                cVar2 = cVar3;
                            }
                        }
                        aVar2.a(cVar2, str, z);
                        return;
                    }
                    cVar3.twF.J(true, true);
                    try {
                        cVar3.juQ.ab(i, i2, cVar3.hashCode());
                        return;
                    } catch (Exception e4) {
                        x.w("MicroMsg.OAuthSession", "accountExpired, ex = " + e4.getMessage());
                        return;
                    }
                } else if (i3 == 27) {
                    cVar3.twD = false;
                    cVar3.twE.c(i2 == 0, str, str2, string);
                    return;
                } else {
                    cVar3.twE.a(cVar3, str, false);
                    return;
                }
            }
            x.w("MicroMsg.OAuthSession", "onScenEnd, not listening");
        }
    }
}
