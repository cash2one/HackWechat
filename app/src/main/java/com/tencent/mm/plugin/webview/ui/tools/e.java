package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.xd;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private WebView twx;
    private Map<String, a> txH;
    private JsapiPermissionWrapper txI;
    private GeneralControlWrapper txJ;
    private final JsapiPermissionWrapper txK = new JsapiPermissionWrapper(2);
    private final GeneralControlWrapper txL = GeneralControlWrapper.vAK;
    private int[] txM;
    private int[] txN;

    public e(Activity activity, WebView webView) {
        int i;
        this.txI = (JsapiPermissionWrapper) activity.getIntent().getParcelableExtra("hardcode_jspermission");
        if (r.ido == null || r.ido.length() == 0) {
            x.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                i = bh.getInt(r.ido, 0);
                if (i < 0) {
                    x.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.txI = new JsapiPermissionWrapper(i);
                    x.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.txI);
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e.getMessage());
                this.txI = null;
            }
        }
        this.txJ = (GeneralControlWrapper) activity.getIntent().getParcelableExtra("hardcode_general_ctrl");
        if (r.idp == null || r.idp.length() == 0) {
            x.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                x.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", Integer.valueOf(bh.getInt(r.idp, 0)));
                xd xdVar = new xd();
                xdVar.wht = i;
                this.txJ = new GeneralControlWrapper(xdVar);
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", e2.getMessage());
                this.txJ = null;
            }
            x.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.txJ);
        }
        x.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.txI + ", hardcodeGenCtrl = " + this.txJ);
        this.twx = webView;
        this.txH = new HashMap();
        this.txM = activity.getIntent().getIntArrayExtra("jsapi_blacklist");
        this.txN = activity.getIntent().getIntArrayExtra("jsapi_whitelist");
        if (!(this.txM == null || this.txM.length <= 0 || this.txI == null)) {
            x.i("MicroMsg.WebViewPermission", "albie: setBlacklist jsapi(%s).", this.txM);
            this.txI.n(this.txM);
        }
        if (this.txN != null && this.txN.length > 0 && this.txI != null) {
            x.i("MicroMsg.WebViewPermission", "albie: setWhitelist jsapi(%s).", this.txN);
            this.txI.o(this.txN);
        }
    }

    public final void b(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (bh.ov(str)) {
            x.e("MicroMsg.WebViewPermission", "update fail, url is null");
            return;
        }
        String BQ = BQ(str);
        if (jsapiPermissionWrapper == null) {
            jsapiPermissionWrapper = this.txK;
        }
        if (generalControlWrapper == null) {
            generalControlWrapper = this.txL;
        }
        if (this.txM != null && this.txM.length > 0) {
            x.i("MicroMsg.WebViewPermission", "albie: update setBlacklist jsapi(%s).", this.txM);
            jsapiPermissionWrapper.n(this.txM);
        }
        if (this.txN != null && this.txN.length > 0) {
            x.i("MicroMsg.WebViewPermission", "albie: update setWhitelist jsapi(%s).", this.txN);
            jsapiPermissionWrapper.o(this.txN);
        }
        x.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + jsapiPermissionWrapper + ", genCtrl = " + generalControlWrapper + ", url = " + BQ);
        this.txH.put(BQ, new a(jsapiPermissionWrapper, generalControlWrapper));
    }

    public final boolean has(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.WebViewPermission", "has fail, url is null");
            return false;
        }
        a aVar = (a) this.txH.get(BQ(str));
        return (aVar == null || aVar.txO == this.txK || aVar.txP == this.txL) ? false : true;
    }

    public final JsapiPermissionWrapper bSs() {
        if (this.txI != null) {
            x.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.txI);
            return this.txI;
        }
        return Pj(this.twx == null ? null : this.twx.getUrl());
    }

    public final JsapiPermissionWrapper Pj(String str) {
        if (this.txI != null) {
            x.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.txI);
            return this.txI;
        } else if (bh.ov(str)) {
            x.e("MicroMsg.WebViewPermission", "getJsPerm fail, url = " + str);
            return this.txK;
        } else {
            String BQ = BQ(str);
            if (this.txH == null) {
                x.e("MicroMsg.WebViewPermission", "getJsPerm fail, permMap is null");
                return this.txK;
            }
            a aVar = (a) this.txH.get(BQ);
            return aVar == null ? this.txK : aVar.txO;
        }
    }

    public final GeneralControlWrapper bSt() {
        Object obj = null;
        if (this.txJ != null) {
            x.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.txJ);
            return this.txJ;
        }
        String url;
        if (this.twx != null) {
            url = this.twx.getUrl();
            if (!bh.ov(url)) {
                String BQ = BQ(url);
                a aVar = (a) this.txH.get(BQ);
                String str = "MicroMsg.WebViewPermission";
                StringBuilder stringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
                if (aVar != null) {
                    obj = aVar.txP;
                }
                x.i(str, stringBuilder.append(obj).append(", url = ").append(BQ).toString());
                return aVar == null ? this.txL : aVar.txP;
            }
        } else {
            url = null;
        }
        x.e("MicroMsg.WebViewPermission", "getGenCtrl fail, url = " + url);
        return this.txL;
    }

    public final void detach() {
        x.i("MicroMsg.WebViewPermission", "detach");
        this.txH.clear();
        this.txH = null;
        this.twx = null;
    }

    private static String BQ(String str) {
        int indexOf = str.indexOf("#");
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
