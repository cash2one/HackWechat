package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.bef;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

public final class SDKOAuthUI extends MMActivity implements e {
    private r jmO;
    private String mAppId;
    private Req txb;
    private ak txc;
    private a txd;
    private boolean txe;

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, String str, String str2, String str3, LinkedList linkedList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append((String) linkedList.get(i)).append(",");
        }
        x.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[]{stringBuilder.toString()});
        if (sDKOAuthUI.txc != null) {
            sDKOAuthUI.txc.TG();
            sDKOAuthUI.txc.J(3000, 3000);
        } else {
            sDKOAuthUI.txc = new ak(new 5(sDKOAuthUI), false);
            sDKOAuthUI.txc.J(3000, 3000);
        }
        ar.CG().a(new u(1, str, str2, str3, linkedList), 0);
    }

    static /* synthetic */ void b(SDKOAuthUI sDKOAuthUI, String str) {
        String Ph = Ph(sDKOAuthUI.mAppId);
        if (bh.ov(Ph)) {
            x.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
            return;
        }
        Resp resp = new Resp();
        resp.transaction = sDKOAuthUI.txb.transaction;
        resp.errCode = -1;
        resp.errStr = str;
        resp.lang = sDKOAuthUI.bSp();
        resp.country = getCountry();
        sDKOAuthUI.a(Ph, resp);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.eXA));
        setMMSubTitle(getString(R.l.eIt));
        setBackBtn(new 1(this));
        if (ar.Hj()) {
            this.txe = false;
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (bh.ov(string)) {
                x.e("MicroMsg.SdkOAuthUI", "init content is nil");
                return;
            }
            this.mAppId = Uri.parse(string).getQueryParameter("appid");
            string = this.mAppId;
            f aZ = g.aZ(string, false);
            if (aZ != null && bh.ov(aZ.field_openId)) {
                x.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[]{string});
                b gyVar = new gy();
                gyVar.fxg.appId = string;
                a.xef.m(gyVar);
            }
            this.txb = new Req(extras);
            string = this.mAppId;
            String str = this.txb.scope;
            String str2 = this.txb.state;
            String Ph = Ph(this.mAppId);
            x.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s", new Object[]{string});
            bSn();
            ar.CG().a(new t(string, str, str2, Ph, bh.ov(Ph) ? null : com.tencent.mm.a.g.s(p.aX(this, Ph)[0].toByteArray())), 0);
            return;
        }
        x.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.l.dCh, 1).show();
    }

    protected final void onResume() {
        super.onResume();
        ar.CG().a(1346, this);
        ar.CG().a(1388, this);
    }

    protected final void onPause() {
        super.onPause();
        ar.CG().b(1388, this);
        ar.CG().b(1346, this);
    }

    protected final void onDestroy() {
        super.onDestroy();
        if (this.jmO != null) {
            this.jmO.dismiss();
        }
        if (this.txc != null) {
            this.txc.TG();
        }
    }

    protected final int getLayoutId() {
        return R.i.drn;
    }

    public final void onSwipeBack() {
        super.onSwipeBack();
        bSm();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bSm();
        finish();
        return true;
    }

    private void Pf(String str) {
        String str2 = null;
        x.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback url : %s", new Object[]{str});
        String Ph = Ph(this.mAppId);
        if (bh.ov(Ph)) {
            x.e("MicroMsg.SdkOAuthUI", "dealWithLoginCallback pkg nil");
            return;
        }
        Uri uri;
        Resp resp = new Resp();
        resp.transaction = this.txb.transaction;
        resp.lang = bSp();
        resp.country = getCountry();
        if (bh.ov(str)) {
            uri = null;
        } else {
            uri = Uri.parse(str);
        }
        if (uri != null) {
            str2 = uri.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            resp.state = uri.getQueryParameter("state");
            resp.errStr = uri.getQueryParameter("reason");
        }
        if (bh.ov(str2)) {
            resp.errCode = -1;
        } else if (str2.toLowerCase().equals("authdeny")) {
            resp.errCode = -4;
        } else {
            resp.errCode = 0;
            resp.code = str2;
        }
        resp.url = str;
        x.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[]{Ph, resp.code, Integer.valueOf(resp.errCode), resp.state});
        a(Ph, resp);
        finish();
    }

    private void bSm() {
        x.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
        if (this.txb != null) {
            LinkedList linkedList;
            String Ph = Ph(this.mAppId);
            String str = this.mAppId;
            String str2 = this.txb.state;
            if (this.txd == null) {
                linkedList = null;
            } else {
                linkedList = this.txd.bSq();
            }
            ar.CG().a(new u(2, str, str2, Ph, linkedList), 0);
            Resp resp = new Resp();
            resp.transaction = this.txb.transaction;
            resp.errCode = -2;
            resp.lang = bSp();
            resp.country = getCountry();
            a(Ph, resp);
        }
    }

    private void a(String str, Resp resp) {
        if (this.txe) {
            x.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
        } else if (!bh.ov(str)) {
            this.txe = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            Args args = new Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
        }
    }

    private void Pg(String str) {
        h.a((Context) this, str, getString(R.l.eXq), new 3(this, str));
    }

    private void bSn() {
        if (this.jmO == null || this.jmO.isShowing()) {
            this.jmO = h.a((Context) this, getString(R.l.ezF), true, new 4(this));
        } else {
            this.jmO.show();
        }
    }

    private void bSo() {
        if (this.jmO != null) {
            this.jmO.dismiss();
        }
    }

    private boolean AC(int i) {
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            x.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = " + i);
            return false;
        } else if (an.isConnected(this)) {
            return true;
        } else {
            x.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
            return false;
        }
    }

    private String bSp() {
        return w.d(getSharedPreferences(ac.cfs(), 0));
    }

    private static String getCountry() {
        ar.Hg();
        return bh.az((String) c.CU().get(274436, null), null);
    }

    private static String Ph(String str) {
        f aZ = g.aZ(str, false);
        if (aZ != null) {
            return aZ.field_packageName;
        }
        x.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[]{str});
        return null;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof t) {
            x.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            bSo();
            if (i == 0 && i2 == 0) {
                beh com_tencent_mm_protocal_c_beh = (beh) ((t) kVar).gJQ.hmh.hmo;
                if (com_tencent_mm_protocal_c_beh.wBL || com_tencent_mm_protocal_c_beh.wBM) {
                    x.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
                    Pf(com_tencent_mm_protocal_c_beh.vUP);
                    return;
                }
                ImageView imageView = (ImageView) findViewById(R.h.bKz);
                TextView textView = (TextView) findViewById(R.h.bKE);
                ListView listView = (ListView) findViewById(R.h.bLt);
                Button button = (Button) findViewById(R.h.cuj);
                c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                com_tencent_mm_aq_a_a_c_a.hDP = R.k.dzf;
                o.PA().a(com_tencent_mm_protocal_c_beh.wBK, imageView, com_tencent_mm_aq_a_a_c_a.PK());
                textView.setText(com_tencent_mm_protocal_c_beh.hcp);
                this.txd = new a(this, com_tencent_mm_protocal_c_beh.wBJ);
                listView.setAdapter(this.txd);
                button.setOnClickListener(new 2(this, com_tencent_mm_protocal_c_beh));
                findViewById(R.h.cIu).setVisibility(0);
            } else if (AC(i)) {
                Pg(str);
            } else {
                Pg(getString(R.l.eXr));
            }
        } else if (kVar instanceof u) {
            x.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (this.txc != null) {
                this.txc.TG();
            }
            bSo();
            if (i == 0 && i2 == 0) {
                Pf(((bef) ((u) kVar).gJQ.hmh.hmo).vUP);
            } else if (AC(i)) {
                Pg(str);
            } else {
                Pg(getString(R.l.eXr));
            }
        }
    }
}
