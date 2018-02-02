package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.bm.d;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import java.util.Map;

@a(7)
public class UIEntryStub extends Activity {
    private Intent fzg;
    private int kuP;
    private boolean kuQ;
    private String uC;

    static /* synthetic */ void a(UIEntryStub uIEntryStub, Bundle bundle) {
        boolean z = false;
        uIEntryStub.uC = bundle.getString(ConstantsAPI.APP_PACKAGE);
        uIEntryStub.kuP = bundle.getInt(ConstantsAPI.SDK_VERSION);
        String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        x.d("MicroMsg.UIEntryStub", "handleWXAppMessage, appId = " + queryParameter);
        if (g.cA(queryParameter)) {
            j jVar = q$a.vcu;
            if (jVar != null) {
                jVar.o(uIEntryStub, queryParameter, uIEntryStub.uC);
            }
        }
        int i = bundle.getInt("_wxapi_command_type");
        x.i("MicroMsg.UIEntryStub", "handle wxapp message: " + uIEntryStub.uC + ", sdkver=" + uIEntryStub.kuP + ", cmd=" + i);
        switch (i) {
            case 1:
                if (ar.Hj() && !ar.Cs()) {
                    c fn = com.tencent.mm.z.c.c.IF().fn("100273");
                    if (fn.isValid()) {
                        Map chI = fn.chI();
                        if (chI == null) {
                            x.i("MicroMsg.UIEntryStub", "isSDKOauthNative args == null");
                        } else if (chI.containsKey("isUseNative") && "1".equals(chI.get("isUseNative"))) {
                            z = true;
                        } else {
                            x.i("MicroMsg.UIEntryStub", "isSDKOauthNative not contain the isUseNative key or the value is not 1");
                        }
                    } else {
                        x.i("MicroMsg.UIEntryStub", "isSDKOauthNative item.isValid is false");
                    }
                    if (!z) {
                        Intent putExtras = new Intent().putExtras(bundle);
                        putExtras.putExtra("mode", 1);
                        putExtras.putExtra("forceHideShare", true);
                        putExtras.putExtra("neverGetA8Key", true);
                        putExtras.putExtra("geta8key_scene", 6);
                        putExtras.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                        putExtras.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                        d.b(uIEntryStub, "webview", ".ui.tools.OAuthUI", putExtras);
                        break;
                    }
                    d.b(uIEntryStub, "webview", ".ui.tools.SDKOAuthUI", new Intent().putExtras(bundle));
                    break;
                }
                x.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                break;
                break;
            case 2:
                SendMessageToWX$Req sendMessageToWX$Req = new SendMessageToWX$Req(bundle);
                if (sendMessageToWX$Req.message != null && sendMessageToWX$Req.message.getType() == 2) {
                    WXImageObject wXImageObject = (WXImageObject) sendMessageToWX$Req.message.mediaObject;
                    if (!(wXImageObject == null || wXImageObject.checkArgs())) {
                        x.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, WXImageObject checkArgs fail, maybe use deprecated field imageUrl");
                        ReportUtil.a(uIEntryStub, ReportUtil.b(uIEntryStub.getIntent().getExtras(), -5));
                        uIEntryStub.finish();
                        return;
                    }
                }
                if (sendMessageToWX$Req.message.getType() != 38 || sendMessageToWX$Req.scene == 1) {
                    if (sendMessageToWX$Req.scene == 1) {
                        x.i("MicroMsg.UIEntryStub", "sendMessageToWx, req.scene = send to timeline");
                        if (sendMessageToWX$Req.message.getType() == 8) {
                            x.e("MicroMsg.UIEntryStub", "sendMessageToWx fail, emoji does not support WXSceneTimeline");
                            ReportUtil.a(uIEntryStub, ReportUtil.b(uIEntryStub.getIntent().getExtras(), -5));
                        } else {
                            new d(uIEntryStub, queryParameter, sendMessageToWX$Req.openId, new 2(uIEntryStub, bundle, sendMessageToWX$Req)).aqV();
                            return;
                        }
                    }
                    Parcelable b = ReportUtil.b(bundle, -2);
                    Intent intent = new Intent(uIEntryStub, SelectConversationUI.class);
                    intent.putExtra("Select_Report_Args", b);
                    intent.putExtra("Select_Conv_NextStep", new Intent(uIEntryStub, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("SendAppMessageWrapper_Scene", sendMessageToWX$Req.scene).putExtra("animation_pop_in", true));
                    intent.putExtra("Select_App_Id", queryParameter);
                    intent.putExtra("Select_Open_Id", sendMessageToWX$Req.openId);
                    intent.putExtra("Select_Conv_Type", 3);
                    if (sendMessageToWX$Req.message.getType() == 36) {
                        intent.putExtra("mutil_select_is_ret", !((WXMiniProgramObject) sendMessageToWX$Req.message.mediaObject).withShareTicket);
                    } else {
                        intent.putExtra("mutil_select_is_ret", true);
                    }
                    if (!ar.Hj() || ar.Cs()) {
                        x.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    } else {
                        uIEntryStub.startActivity(intent);
                    }
                    uIEntryStub.finish();
                    return;
                }
                x.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, video file object only supported share to timeline");
                ReportUtil.a(uIEntryStub, ReportUtil.b(uIEntryStub.getIntent().getExtras(), -5));
                uIEntryStub.finish();
                return;
            case 3:
                if (ar.Hj() && !ar.Cs()) {
                    am.ah(bundle);
                    break;
                } else {
                    x.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
                break;
            case 4:
                if (ar.Hj() && !ar.Cs()) {
                    an.ah(bundle);
                    break;
                } else {
                    x.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
        }
        uIEntryStub.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NotifyReceiver.wG();
        this.kuQ = false;
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.fzg = intent;
        x.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", new Object[]{Boolean.valueOf(this.kuQ)});
        this.kuQ = false;
    }

    public void onResume() {
        super.onResume();
        if (this.fzg == null) {
            this.fzg = getIntent();
        }
        ar.CG().a(new bd(new 1(this)), 0);
    }
}
