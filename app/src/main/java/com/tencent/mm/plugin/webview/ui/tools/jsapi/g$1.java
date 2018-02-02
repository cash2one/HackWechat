package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiAdDataReport;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.lbs.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ad;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.al;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ar;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ba;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bb;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.y;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.bsb;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class g$1 extends c {
    final /* synthetic */ i tIg;
    final /* synthetic */ JsapiPermissionWrapper tIh;
    final /* synthetic */ g tIi;
    final /* synthetic */ g tIj;

    g$1(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper, g gVar2) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.tIh = jsapiPermissionWrapper;
        this.tIi = gVar2;
    }

    public final void a(a aVar, String str, LinkedList<bsb> linkedList, int i, int i2) {
        boolean z = false;
        this.tIg.bUN().put("baseErrorCode", Integer.valueOf(i));
        this.tIg.bUN().put("jsapiErrorCode", Integer.valueOf(i2));
        if (this.tIj.PJ(this.tIg.tJI)) {
            x.i("MicroMsg.MsgHandler", "current jsapi(%s) invoked is came from menu event.(original retCode : %s)", new Object[]{this.tIg.tJI, aVar});
            aVar = a.tGC;
        }
        x.i("MicroMsg.MsgHandler", "onJSVerifyEnd, put webviewID = %d", new Object[]{Integer.valueOf(g.a(this.tIj))});
        this.tIg.pox.put("webview_instance_id", Integer.valueOf(g.a(this.tIj)));
        if (aVar != a.tGC) {
            if (aVar == a.tGF) {
                x.e("MicroMsg.MsgHandler", "handleMsg access denied %s", new Object[]{this.tIi.getName()});
                if (this.tIg.tJI.equalsIgnoreCase(o.NAME)) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(157, 1, 1, false);
                }
                g.a(this.tIj, this.tIg, "system:access_denied", null);
            } else if (aVar == a.tGE) {
                g.a(this.tIj, this.tIg, this.tIi.cdr() + ":" + str, null);
            } else if (bh.ov(this.tIi.cdr())) {
                this.tIj.maM = false;
                kz(false);
                g.d(this.tIj, this.tIg, false);
                return;
            } else if (bh.ov(str)) {
                g.a(this.tIj, this.tIg, this.tIi.cdr() + ":fail", null);
            } else {
                g.a(this.tIj, this.tIg, this.tIi.cdr() + ":fail_" + str, null);
            }
            kz(true);
        } else if (this.tIg.tJI.equals(GameJsApiSendAppMessage.NAME)) {
            kz(g.a(this.tIj, this.tIg, this.tIh));
            z = true;
        } else if (this.tIg.tJI.equals("profile")) {
            kz(g.b(this.tIj, this.tIg, this.tIh));
            z = true;
        } else if (this.tIg.tJI.equals("shareWeibo")) {
            kz(g.a(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("shareTimeline")) {
            kz(g.c(this.tIj, this.tIg, this.tIh));
            z = true;
        } else if (this.tIg.tJI.equals(JsApiAdDataReport.NAME)) {
            kz(g.b(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("streamingVideoPlay")) {
            kz(g.c(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("addContact")) {
            kz(g.d(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(w.NAME)) {
            kz(g.e(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("log")) {
            kz(g.f(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(v.NAME)) {
            kz(g.b(this.tIj));
            z = true;
        } else if (this.tIg.tJI.equals(bb.NAME)) {
            kz(g.c(this.tIj));
            z = true;
        } else if (this.tIg.tJI.equals("getNetworkType")) {
            kz(g.g(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(m.NAME)) {
            kz(g.h(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("getInstallState")) {
            kz(g.i(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("scanQRCode")) {
            kz(g.j(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("setFontSizeCallback")) {
            kz(g.k(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("jumpToInstallUrl")) {
            kz(g.l(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(o.NAME)) {
            kz(g.m(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("editAddress")) {
            kz(g.n(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getLatestAddress")) {
            kz(g.d(this.tIj));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getHeadingAndPitch")) {
            kz(g.o(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("sendEmail")) {
            kz(g.p(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("addDownloadTask")) {
            kz(g.q(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(f.NAME)) {
            kz(g.r(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("pauseDownloadTask")) {
            kz(g.s(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("resumeDownloadTask")) {
            kz(g.d(this.tIj, this.tIg, this.tIh));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("queryDownloadTask")) {
            kz(g.t(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("installDownloadTask")) {
            kz(g.u(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openSpecificView")) {
            kz(g.v(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(y.NAME)) {
            kz(g.w(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("jumpWCMall")) {
            kz(g.x(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(JsApiWriteCommData.NAME)) {
            kz(g.y(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openUrlByExtBrowser")) {
            kz(g.z(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openProductView")) {
            kz(g.A(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openProductViewWithPid")) {
            kz(g.B(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getBrandWCPayBindCardRequest")) {
            kz(g.C(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("geoLocation")) {
            kz(g.D(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("jumpToBizProfile")) {
            kz(g.E(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openTimelineCheckInList")) {
            kz(g.F(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(e.NAME)) {
            kz(g.G(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("timelineCheckIn")) {
            kz(g.H(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getBrandWCPayCreateCreditCardRequest")) {
            kz(g.I(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("sendServiceAppMessage")) {
            kz(g.J(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("mmsf0001")) {
            kz(g.K(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("musicPlay")) {
            kz(g.L(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("connectToWiFi")) {
            kz(g.M(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getTransferMoneyRequest")) {
            kz(g.N(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openWCPaySpecificView")) {
            kz(g.O(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("chooseCard")) {
            kz(g.P(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("chooseInvoice")) {
            kz(g.Q(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("batchAddCard")) {
            kz(g.R(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(as.NAME)) {
            kz(g.S(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(ak.NAME)) {
            kz(g.e(this.tIj, this.tIg, this.tIh));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(JsApiStartRecordVoice.NAME)) {
            kz(g.T(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(JsApiStopRecordVoice.NAME)) {
            kz(g.U(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(JsApiStartPlayVoice.NAME)) {
            kz(g.V(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(JsApiPausePlayVoice.NAME)) {
            kz(g.W(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(JsApiStopPlayVoice.NAME)) {
            kz(g.X(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("uploadVoice")) {
            kz(g.Y(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("downloadVoice")) {
            kz(g.Z(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("chooseImage")) {
            kz(g.aa(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("uploadImage")) {
            kz(g.ab(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("downloadImage")) {
            kz(g.ac(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(u.NAME)) {
            kz(g.ad(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(ba.NAME)) {
            kz(g.ae(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("hideAllNonBaseMenuItem")) {
            kz(g.af(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("showAllNonBaseMenuItem")) {
            kz(g.ag(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.g.NAME)) {
            kz(g.ah(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("translateVoice")) {
            kz(g.ai(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("shareQQ")) {
            kz(g.aj(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("shareWeiboApp")) {
            kz(g.ak(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("configWXDeviceWiFi")) {
            kz(g.al(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getCurrentSSID")) {
            kz(g.am(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getPaymentOrderRequest")) {
            kz(g.an(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("verifyWCPayPassword")) {
            kz(g.ao(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("startMonitoringBeacons")) {
            g.e(this.tIj);
            kz(g.a(this.tIj, this.tIg, new int[0]));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("stopMonitoringBeacons")) {
            g.e(this.tIj);
            kz(g.b(this.tIj, this.tIg, new int[0]));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getSendC2CMessageRequest")) {
            kz(g.ap(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.e.NAME)) {
            kz(g.aq(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("connectToFreeWifi")) {
            kz(g.ar(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setFreeWifiOwner")) {
            kz(g.as(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setPageOwner")) {
            kz(g.at(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getWechatVerifyTicket")) {
            kz(g.au(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openWXDeviceLib")) {
            kz(g.av(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("closeWXDeviceLib")) {
            kz(g.aw(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("startScanWXDevice")) {
            kz(g.ax(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("stopScanWXDevice")) {
            kz(g.ay(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("connectWXDevice")) {
            kz(g.az(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("disconnectWXDevice")) {
            kz(g.aA(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getWXDeviceTicket")) {
            kz(g.aB(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getWXDeviceInfos")) {
            kz(g.aC(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("sendDataToWXDevice")) {
            kz(g.aD(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setSendDataDirection")) {
            kz(g.aE(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openGameDetail")) {
            kz(g.aF(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(ac.NAME)) {
            kz(g.aG(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setGameDebugConfig")) {
            kz(g.aH(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("shareQZone")) {
            kz(g.aj(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("startTempSession")) {
            kz(g.aI(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getRecevieBizHongBaoRequest")) {
            kz(g.aJ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openMyDeviceProfile")) {
            kz(g.aK(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("selectPedometerSource")) {
            kz(this.tIj.an(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getH5PrepayRequest")) {
            kz(g.aL(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getH5TransactionRequest")) {
            kz(g.aM(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("jumpToWXWallet")) {
            kz(g.aN(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("scanCover")) {
            kz(g.aO(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("nfcIsConnect")) {
            kz(g.aP(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("nfcConnect")) {
            kz(g.aQ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("nfcTransceive")) {
            kz(g.aR(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("nfcBatchTransceive")) {
            kz(g.aS(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("nfcGetId")) {
            kz(g.aT(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("nfcGetInfo")) {
            kz(g.aU(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("nfcCheckState")) {
            kz(g.aV(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("videoProxyInit")) {
            kz(g.aW(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("videoProxyStartPlay")) {
            kz(g.aX(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("videoProxyStopPlay")) {
            kz(g.aY(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("videoProxySetPlayerState")) {
            kz(g.aZ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("videoProxySetRemainTime")) {
            kz(g.ba(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getSearchData")) {
            kz(g.bb(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getPoiInfo")) {
            kz(g.bc(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("updateReddotTimeStamps")) {
            kz(g.bd(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("reloadSearchWAWidgetData")) {
            kz(g.f(this.tIj, this.tIg, this.tIh));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("insertSearchWAWidgetView")) {
            kz(g.be(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("removeSearchWAWidgetView")) {
            kz(g.bf(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("updateSearchWAWidgetView")) {
            kz(g.bg(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getTeachSearchData")) {
            kz(g.bh(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getSearchGuideData")) {
            kz(g.bi(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getSearchAvatarList")) {
            kz(g.bj(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getSearchSnsImageList")) {
            kz(g.bk(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getSearchImageList")) {
            kz(g.bl(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getSearchDisplayNameList")) {
            kz(g.bm(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("startSearchItemDetailPage")) {
            kz(g.bn(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("reportSearchStatistics")) {
            kz(g.bo(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("reportSearchRealTimeStatistics")) {
            kz(g.bp(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("searchDataHasResult")) {
            kz(g.bq(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getSearchSuggestionData")) {
            kz(g.br(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openEmotionPage")) {
            kz(g.bs(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setSearchInputWord")) {
            kz(g.bt(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(ah.NAME)) {
            kz(g.bu(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("reportWeAppSearchRealtime")) {
            kz(g.bv(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("doSearchOperation")) {
            kz(g.bw(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(GameJsApiOperateGameCenterMsg.NAME)) {
            kz(g.bx(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getWebPayCheckoutCounterRequst")) {
            kz(g.by(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setSnsObjectXmlDescList")) {
            kz(g.bz(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("clickSnsMusicPlayButton")) {
            kz(g.bA(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("addCustomMenuItems")) {
            kz(g.bB(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openEnterpriseChat")) {
            kz(g.bC(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openEnterpriseContact")) {
            kz(g.bD(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("selectEnterpriseContact")) {
            kz(g.bE(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("sendEnterpriseChat")) {
            kz(g.bF(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("enterEnterpriseChat")) {
            kz(g.bG(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getEnterpriseChat")) {
            kz(g.bH(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("reportActionInfo")) {
            kz(g.bI(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("showSearchOfBizHistory")) {
            kz(g.bJ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("cache")) {
            kz(g.bK(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("publicCache")) {
            kz(g.bL(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("changePayActivityView")) {
            kz(g.bM(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("scanLicence")) {
            kz(g.bN(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(ag.NAME)) {
            kz(g.bO(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openECard")) {
            kz(g.bP(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("preloadMiniProgramEnv")) {
            kz(g.bQ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("preloadMiniProgramContacts")) {
            kz(g.bR(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("enablePullDownRefresh")) {
            kz(this.tIj.bw(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(bk.NAME)) {
            kz(this.tIj.bx(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(bl.NAME)) {
            kz(this.tIj.by(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("disablePullDownRefresh")) {
            kz(this.tIj.bUH());
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(n.NAME)) {
            kz(this.tIj.bB(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(k.NAME)) {
            kz(this.tIj.bC(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(az.NAME)) {
            kz(this.tIj.bz(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(bc.NAME)) {
            kz(this.tIj.bA(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openMapNavigateMenu")) {
            kz(this.tIj.bF(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setNavigationBarButtons")) {
            kz(g.bS(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("enableFullScreen")) {
            kz(g.bT(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("reportMiniProgramPageData")) {
            kz(g.bU(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(av.NAME)) {
            kz(g.bV(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setStatusBarStyle")) {
            kz(g.bW(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("forceUpdateWxaAttr")) {
            kz(g.bX(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("launchMiniProgram")) {
            kz(g.bY(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("reportIDKey")) {
            kz(g.bZ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("quicklyAddBrandContact")) {
            kz(g.ca(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("consumedShareCard")) {
            kz(g.cb(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("kvReport")) {
            kz(this.tIj.bo(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("realtimeReport")) {
            kz(this.tIj.bE(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(af.NAME)) {
            kz(g.cc(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("videoProxyPreload")) {
            kz(g.cd(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getLocalData")) {
            kz(g.ce(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setLocalData")) {
            kz(g.cf(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("clearLocalData")) {
            kz(g.cg(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("selectSingleContact")) {
            kz(g.ch(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("sendAppMessageToSpecifiedContact")) {
            kz(g.ci(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("deleteAccountSuccess")) {
            kz(g.f(this.tIj));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("chooseVideo")) {
            kz(g.cj(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("uploadVideo")) {
            kz(g.ck(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("setNavigationBarColor")) {
            kz(g.cl(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openDesignerEmojiView")) {
            kz(g.a(this.tIj, this.tIg, false));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openDesignerProfile")) {
            kz(g.b(this.tIj, this.tIg, false));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openEmoticonTopicList")) {
            kz(g.cm(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openDesignerEmojiViewLocal")) {
            kz(g.a(this.tIj, this.tIg, true));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openDesignerProfileLocal")) {
            kz(g.b(this.tIj, this.tIg, true));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openEmotionDetailViewLocal")) {
            kz(g.cn(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openNewPage")) {
            kz(g.co(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getSearchEmotionData")) {
            kz(g.cp(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openEmotionUrl")) {
            kz(g.cq(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("getWCPayRealnameVerify")) {
            kz(this.tIj.aM(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("selectWalletCurrency")) {
            kz(this.tIj.bUF());
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(JsApiOperateMusicPlayer.NAME)) {
            kz(g.cr(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase(JsApiGetMusicPlayerState.NAME)) {
            kz(g.cs(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("clearWebviewCache")) {
            kz(g.ct(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("requireSoterBiometricAuthentication")) {
            kz(g.cu(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("getSupportSoter")) {
            kz(g.cv(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("unbindBankCard")) {
            kz(g.cw(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(ar.NAME)) {
            kz(this.tIj.bD(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("doExposePreparation")) {
            kz(g.cx(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("getMsgProofItems")) {
            kz(g.cy(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(bd.NAME)) {
            kz(g.cz(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("openSecurityView")) {
            kz(g.cA(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("startVoipCall")) {
            kz(g.cB(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(GameJsApiGetOpenDeviceId.NAME)) {
            kz(g.cC(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("getRouteUrl")) {
            kz(g.cD(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("idCardRealnameVerify")) {
            kz(this.tIj.aO(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("uploadIdCardSuccess")) {
            kz(this.tIj.aP(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(GameJsApiGetGameCommInfo.NAME)) {
            kz(this.tIj.aQ(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(ad.NAME)) {
            kz(this.tIj.bUG());
            z = true;
        } else if (this.tIg.tJI.equals("chooseIdCard")) {
            kz(this.tIj.aR(this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(d.NAME)) {
            kz(g.cE(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("openLuckyMoneyDetailView")) {
            kz(g.cF(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("resendRemittanceMsg")) {
            kz(g.cG(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("getLocalImgData")) {
            kz(g.cH(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(an.NAME)) {
            kz(g.cI(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(al.NAME)) {
            kz(g.cJ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("uploadEncryptMediaFile")) {
            kz(g.cK(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(ab.NAME)) {
            kz(g.cL(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("chooseMedia")) {
            kz(g.cM(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("openLuckyMoneyHistory")) {
            kz(g.cN(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("requestWxFacePictureVerify")) {
            kz(g.c(this.tIj, this.tIg, false));
            z = true;
        } else if (this.tIg.tJI.equals(t.NAME)) {
            kz(g.cO(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(r.NAME)) {
            kz(g.cP(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("openGameWebView")) {
            kz(g.cQ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(GameJsApiLaunchApplication.NAME)) {
            kz(g.cR(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("login") || this.tIg.tJI.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME)) {
            kz(g.cS(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("requestWxFacePictureVerifyUnionVideo")) {
            kz(g.c(this.tIj, this.tIg, true));
            z = true;
        } else if (this.tIg.tJI.equals("checkIsSupportFaceDetect")) {
            kz(g.cT(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(JsApiOperateBackgroundAudio.NAME)) {
            kz(g.cU(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(JsApiSetBackgroundAudioState.NAME)) {
            kz(g.g(this.tIj, this.tIg, this.tIh));
            z = true;
        } else if (this.tIg.tJI.equals(JsApiGetBackgroundAudioState.NAME)) {
            kz(g.cV(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("addDownloadTaskStraight")) {
            kz(g.h(this.tIj, this.tIg, this.tIh));
            z = true;
        } else if (this.tIg.tJI.equals(aw.NAME)) {
            kz(g.cW(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME)) {
            kz(g.cX(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(ax.NAME)) {
            kz(g.cY(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("requestWxFaceRegisterInternal")) {
            kz(g.cZ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("requestWxFaceVerifyInternal")) {
            kz(g.da(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("openADCanvas")) {
            kz(g.a(this.tIj, this.tIg, 0));
            z = true;
        } else if (this.tIg.tJI.equals("openSearchCanvas")) {
            kz(g.a(this.tIj, this.tIg, 1));
            z = true;
        } else if (this.tIg.tJI.equals("opVoteAdData")) {
            kz(g.db(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("selectContact")) {
            kz(g.dc(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(ai.NAME)) {
            kz(g.dd(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("setWCPayPassword")) {
            kz(g.de(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(com.tencent.mm.plugin.appbrand.jsapi.u.NAME)) {
            kz(g.df(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("showSearchActionSheet")) {
            kz(g.dg(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("cancelSearchActionSheet")) {
            kz(g.dh(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("uxSearchOpLog")) {
            kz(g.di(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("openSearchWAWidgetLogView")) {
            kz(g.dj(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("openBizChat")) {
            kz(g.dk(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("tapSearchWAWidgetView")) {
            kz(g.dl(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("getMatchContactList")) {
            kz(g.dm(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("openSearchWebView")) {
            kz(g.dn(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equalsIgnoreCase("openWXSearchPage")) {
            kz(g.do(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("viewTypeChange")) {
            kz(g.dp(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(ae.NAME)) {
            kz(g.dq(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("requestWxVoicePrintVerifyInternal")) {
            kz(g.dr(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("closeWindowAndGoNext")) {
            kz(g.i(this.tIj, this.tIg, this.tIh));
            z = true;
        } else if (this.tIg.tJI.equals("invokeMiniProgramAPI")) {
            kz(g.ds(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(at.NAME)) {
            kz(g.dt(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(p.NAME)) {
            kz(g.du(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(l.NAME)) {
            kz(g.dv(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("handleWCPayWalletBuffer")) {
            kz(g.dw(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(ao.NAME)) {
            kz(g.dx(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(com.tencent.mm.plugin.appbrand.jsapi.video.a.NAME)) {
            kz(g.dy(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(com.tencent.mm.plugin.appbrand.jsapi.video.d.NAME)) {
            kz(g.dz(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(com.tencent.mm.plugin.appbrand.jsapi.video.c.NAME)) {
            kz(g.dA(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(b.NAME)) {
            kz(g.dB(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("getSearchHistory")) {
            kz(g.g(this.tIj));
            z = true;
        } else if (this.tIg.tJI.equals("deleteSearchHistory")) {
            kz(g.dC(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("doGoToRecVideoList") || this.tIg.tJI.equals("jumpWSRecVideoList")) {
            kz(g.dD(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("recordHistory")) {
            kz(g.dE(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(com.tencent.mm.plugin.appbrand.jsapi.ad.NAME)) {
            z = true;
        } else if (this.tIg.tJI.equals(ap.NAME)) {
            kz(g.dF(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("openWCPayCardList")) {
            kz(g.dG(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("bindEmail")) {
            kz(g.h(this.tIj));
            z = true;
        } else if (this.tIg.tJI.equals(com.tencent.mm.plugin.appbrand.jsapi.ad.NAME)) {
            kz(g.dH(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("serviceClick")) {
            kz(g.dI(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals(com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME)) {
            kz(g.dJ(this.tIj, this.tIg));
            z = true;
        } else if (this.tIg.tJI.equals("sendSingleAppMessage")) {
            kz(g.dK(this.tIj, this.tIg));
            z = true;
        } else {
            x.e("MicroMsg.MsgHandler", "unknown function = " + this.tIg.tJI);
            g.a(this.tIj, this.tIg, "system:function_not_exist", null);
            kz(true);
        }
        Object obj = this.tIg.bUN().get("Internal@AsyncReport");
        if (!(obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue())) {
            g.d(this.tIj, this.tIg, z);
        }
        if (!z) {
            g.b(this.tIj, this.tIg, aVar.getCode());
        }
    }

    public final boolean bUl() {
        return this.tGH;
    }
}
