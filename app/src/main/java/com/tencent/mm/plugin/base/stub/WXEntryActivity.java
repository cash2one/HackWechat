package com.tencent.mm.plugin.base.stub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.boo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.u;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXEntryActivity extends AutoLoginActivity implements e {
    private String appId;
    private String authority;
    private String content;
    private ProgressDialog iln;
    private int kuP;
    private String uC;
    private Uri uri;

    public void onCreate(Bundle bundle) {
        t.b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
        setBackBtn(new 1(this));
    }

    private boolean A(Intent intent) {
        this.kuP = t.a(intent, ConstantsAPI.SDK_VERSION, 0);
        this.content = t.j(intent, ConstantsAPI.CONTENT);
        if (this.content == null) {
            return false;
        }
        this.uri = Uri.parse(this.content);
        this.authority = this.uri.getAuthority();
        try {
            this.appId = this.uri.getQueryParameter("appid");
            this.uC = t.j(intent, ConstantsAPI.APP_PACKAGE);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.WXEntryActivity", "init: %s", new Object[]{e.toString()});
            return false;
        }
    }

    protected final boolean z(Intent intent) {
        if (A(intent)) {
            if (!ar.Hj() || ar.Cs()) {
                x.w("MicroMsg.WXEntryActivity", "preLogin not login, save the appid : %s", new Object[]{this.appId});
                p.RL(this.appId);
            }
            if (!mZ(this.kuP)) {
                x.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + this.kuP);
                finish();
                return false;
            } else if (this.uri == null) {
                x.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                finish();
                return false;
            } else {
                x.i("MicroMsg.WXEntryActivity", "preLogin, appId = " + this.appId);
                if (com.tencent.mm.platformtools.t.ov(this.appId)) {
                    x.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                    finish();
                    return false;
                }
                x.i("MicroMsg.WXEntryActivity", "preLogin, pkg = " + this.uC);
                if (com.tencent.mm.platformtools.t.ov(this.uC)) {
                    x.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                    finish();
                    return false;
                } else if (checkSumConsistent(t.k(intent, ConstantsAPI.CHECK_SUM), q(this.content, this.kuP, this.uC))) {
                    return true;
                } else {
                    x.e("MicroMsg.WXEntryActivity", "checksum fail");
                    finish();
                    return false;
                }
            }
        }
        x.e("MicroMsg.WXEntryActivity", "Init failed");
        finish();
        return false;
    }

    protected final void a(a aVar, Intent intent) {
        x.d("MicroMsg.WXEntryActivity", "postLogin, loginResult = " + aVar);
        A(intent);
        switch (4.kuV[aVar.ordinal()]) {
            case 1:
                if (getIntent() == null || getIntent().getExtras() == null) {
                    x.e("MicroMsg.WXEntryActivity", "checkCanShare fail, invalid intent/extras");
                    finish();
                    return;
                }
                x.i("MicroMsg.WXEntryActivity", "checkCanShare, cmd = %d", new Object[]{Integer.valueOf(t.h(getIntent().getExtras(), "_wxapi_command_type"))});
                if (t.h(getIntent().getExtras(), "_wxapi_command_type") == 1) {
                    x.i("MicroMsg.WXEntryActivity", "it is auth, just dealrequest");
                    h(null);
                    finish();
                    return;
                }
                SendMessageToWX$Req sendMessageToWX$Req = new SendMessageToWX$Req(getIntent().getExtras());
                WXMediaMessage wXMediaMessage = sendMessageToWX$Req.message;
                if (wXMediaMessage == null) {
                    x.e("MicroMsg.WXEntryActivity", "wxmsg is null, how could it be?, directly deal request");
                    h(null);
                    finish();
                    return;
                }
                String format;
                if (wXMediaMessage.getType() == 36) {
                    sendMessageToWX$Req.scene = 0;
                }
                int i = sendMessageToWX$Req.scene == 2 ? 3 : sendMessageToWX$Req.scene == 1 ? 2 : sendMessageToWX$Req.scene == 0 ? 1 : 0;
                if (wXMediaMessage.getType() == 1) {
                    WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), vI(wXTextObject.text), "", wXMediaMessage.getType()});
                } else if (wXMediaMessage.getType() == 5) {
                    WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), vI(wXMediaMessage.description), vI(wXWebpageObject.webpageUrl), wXMediaMessage.getType()});
                } else if (wXMediaMessage.getType() == 36) {
                    ((b) g.h(b.class)).a(((WXMiniProgramObject) wXMediaMessage.mediaObject).userName, null);
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&appbrandusername=%s&appbrandpath=%s", new Object[]{this.appId, Integer.valueOf(i), vI(wXMediaMessage.description), vI(r0.webpageUrl), wXMediaMessage.getType(), r0.userName, vI(r0.path)});
                } else {
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), vI(wXMediaMessage.description), "", wXMediaMessage.getType()});
                }
                this.iln = h.a(this.mController.xIM, getString(R.l.dHc), true, new 2(this));
                ar.CG().a(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
                ar.CG().a(new ak(format, 1, new LinkedList()), 0);
                return;
            case 2:
                ara();
                x.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            case 3:
                ReportUtil.a(this, ReportUtil.b(t.ah(getIntent()), -1));
                finish();
                x.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            default:
                x.e("MicroMsg.WXEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        finish();
    }

    private static String vI(String str) {
        if (com.tencent.mm.platformtools.t.ov(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str);
        } catch (Exception e) {
            x.e("MicroMsg.WXEntryActivity", "urlEncode fail, str = %s, ex = %s", new Object[]{str, e.getMessage()});
            return str;
        }
    }

    private boolean h(k kVar) {
        Intent intent = getIntent();
        x.i("MicroMsg.WXEntryActivity", "dealRequest, cmd = %d, authority = %s", new Object[]{Integer.valueOf(t.h(getIntent().getExtras(), "_wxapi_command_type")), this.authority});
        if (!"sendreq".equals(this.authority) && !"sendresp".equals(this.authority)) {
            x.e("MicroMsg.WXEntryActivity", "unknown authority, should never reached, authority=" + this.authority);
            return false;
        } else if (ar.Hj()) {
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(this.appId, true);
            if (aZ == null) {
                x.w("MicroMsg.WXEntryActivity", "app not reg, do nothing");
                return false;
            } else if (p.b(this, aZ, this.uC)) {
                SendMessageToWX$Req sendMessageToWX$Req = new SendMessageToWX$Req(intent.getExtras());
                if (sendMessageToWX$Req.scene == 2) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
                    intent2.putExtras(intent.getExtras());
                    if (sendMessageToWX$Req.message != null && sendMessageToWX$Req.message.getType() == 5) {
                        x.d("MicroMsg.WXEntryActivity", "report(11954), appId : %s", new Object[]{aZ.field_appId});
                        String hz = u.hz("app_" + aZ.field_appId);
                        u.GK().t(hz, true).o("prePublishId", "app_" + aZ.field_appId);
                        intent2.putExtra("reportSessionId", hz);
                    }
                    d.b(this, "favorite", ".ui.FavOpenApiEntry", intent2);
                    return true;
                }
                if (!(kVar == null || sendMessageToWX$Req.message == null || sendMessageToWX$Req.message.getType() != 7)) {
                    boo Sq = ((ak) kVar).Sq();
                    if (!(Sq == null || Sq.wQY == null || com.tencent.mm.platformtools.t.ov(Sq.wQY.url))) {
                        x.i("MicroMsg.WXEntryActivity", "change appextend to Webpage,url :%s", new Object[]{Sq.wQY.url});
                        sendMessageToWX$Req.message.mediaObject = new WXWebpageObject(Sq.wQY.url);
                        Bundle bundle = new Bundle();
                        sendMessageToWX$Req.toBundle(bundle);
                        intent.putExtras(bundle);
                    }
                }
                startActivity(new Intent(this, UIEntryStub.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864).putExtras(intent.getExtras()));
                return true;
            } else {
                x.e("MicroMsg.WXEntryActivity", "send fail, check app fail, force to get app info from server again : %s", new Object[]{this.appId});
                an.bim().RD(this.appId);
                arb();
                a(this, aZ, this.uC, r3);
                return false;
            }
        } else {
            x.w("MicroMsg.WXEntryActivity", "accHasReady not ready, do nothing");
            return false;
        }
    }

    protected final int getLayoutId() {
        return R.i.dro;
    }

    private static boolean mZ(int i) {
        return i >= Build.MIN_SDK_INT;
    }

    private static byte[] q(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return com.tencent.mm.a.g.s(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }

    private static boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            x.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            x.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, length is different");
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WXEntryActivity", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ar.CG().b(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        if (i == 0 && i2 == 0) {
            int i3;
            ak akVar = (ak) kVar;
            if (akVar.Sq() != null) {
                i3 = akVar.Sq().version;
            } else {
                i3 = 0;
            }
            x.i("MicroMsg.WXEntryActivity", "server appversion = %d", new Object[]{Integer.valueOf(i3)});
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(this.appId, false);
            if (aZ == null) {
                x.e("MicroMsg.WXEntryActivity", "null appinfo");
                com.tencent.mm.plugin.y.a.a.a.bis().Hh(this.appId);
            } else {
                x.i("MicroMsg.WXEntryActivity", "local appversion = %d", new Object[]{Integer.valueOf(aZ.field_appVersion)});
                if (aZ.field_appVersion < i3) {
                    com.tencent.mm.plugin.y.a.a.a.bis().Hh(this.appId);
                }
            }
            h(kVar);
            finish();
        } else if (com.tencent.mm.ui.t.a.a(this, i, i2, null, 4)) {
            x.i("MicroMsg.WXEntryActivity", "mm error processor process this errcode");
            finish();
        } else if (com.tencent.mm.kernel.a.Cs()) {
            x.w("MicroMsg.WXEntryActivity", "account is hold, do finish");
            finish();
        } else {
            findViewById(R.h.cJk).setVisibility(0);
            setMMTitle(R.l.ePl);
            TextView textView = (TextView) findViewById(R.h.cNP);
            if (!com.tencent.mm.platformtools.t.ov(str)) {
                if (str.startsWith("autoauth_errmsg_")) {
                    str = str.substring(16);
                }
                if (str.startsWith("<e>")) {
                    Map y = bi.y(str, "e");
                    if (!(y == null || com.tencent.mm.platformtools.t.ov((String) y.get(".e.Content")))) {
                        str = (String) y.get(".e.Content");
                    }
                }
                textView.setText(getString(R.l.ePm, new Object[]{str}));
            }
            Button button = (Button) findViewById(R.h.bLU);
            String l = com.tencent.mm.pluginsdk.model.app.g.l(this, this.appId);
            x.i("MicroMsg.WXEntryActivity", "appName = %s", new Object[]{l});
            if (com.tencent.mm.platformtools.t.ov(l)) {
                button.setText(R.l.ePj);
            } else {
                button.setText(getString(R.l.ePj) + l);
            }
            button.setOnClickListener(new 3(this));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0 || keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        x.i("MicroMsg.WXEntryActivity", "user click back button");
        goBack();
        return true;
    }

    private void goBack() {
        View findViewById = findViewById(R.h.cJk);
        if (findViewById == null || findViewById.getVisibility() == 8) {
            ara();
        } else {
            arb();
        }
    }

    private void ara() {
        ReportUtil.a(this, ReportUtil.b(t.ah(getIntent()), -2));
        finish();
    }

    private void arb() {
        ReportUtil.a(this, ReportUtil.b(t.ah(getIntent()), -6));
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
    }
}
