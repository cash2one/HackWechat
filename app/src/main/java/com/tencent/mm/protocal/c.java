package com.tencent.mm.protocal;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiAdDataReport;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.mm.plugin.appbrand.jsapi.ae;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bi;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ad;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ar;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ba;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {
    private static Map<String, g> vAn = null;

    public static class af extends g {
        public af() {
            super("clearLocalData", "clearLocalData", 181, false);
        }
    }

    public static class al extends g {
        public al() {
            super("configWXDeviceWiFi", "configWXDeviceWiFi", 126, true);
        }
    }

    public static class ao extends g {
        public ao() {
            super("connectWXDevice", "connectWXDevice", 123, true);
        }
    }

    public static class bb extends g {
        public bb() {
            super("enableFullScreen", "enableFullScreen", 196, false);
        }
    }

    public static class bd extends g {
        public bd() {
            super("enterEnterpriseChat", "enterEnterpriseChat", 223, false);
        }
    }

    private static final class bf extends g {
        bf() {
            super("requestWxFacePictureVerifyUnionVideo", "requestWxFacePictureVerifyUnionVideo", 264, true);
        }
    }

    private static final class bg extends g {
        bg() {
            super("forceUpdateWxaAttr", "forceUpdateWxaAttr", 257, false);
        }
    }

    private static final class bo extends g {
        bo() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p.NAME, 299, false);
        }
    }

    public static class bp extends g {
        public bp() {
            super("mmsf0001", "mmsf0001", -2, false);
        }
    }

    public static class bv extends g {
        public bv() {
            super("getH5TransactionRequest", "getH5TransactionRequest", 138, true);
        }
    }

    public static class bw extends g {
        public bw() {
            super("getInstallState", "get_install_state", 25, false);
        }
    }

    private static final class by extends g {
        by() {
            super(r.NAME, r.NAME, -2, false);
        }
    }

    public static class cj extends g {
        public cj() {
            super("getSearchDisplayNameList", "getSearchDisplayNameList", 10000, false);
        }
    }

    public static class cl extends g {
        public cl() {
            super("getSearchGuideData", "", 10000, false);
        }
    }

    public static class cn extends g {
        public cn() {
            super("getSearchImageList", "", 10000, false);
        }
    }

    public static class cp extends g {
        public cp() {
            super("getSearchSuggestionData", "", 10000, false);
        }
    }

    public static class cx extends g {
        public cx() {
            super("getWXDeviceInfos", "getWXDeviceInfos", 119, true);
        }
    }

    public static class cy extends g {
        public cy() {
            super("getWXDeviceTicket", "getWXDeviceTicket", 125, true);
        }
    }

    public static class da extends g {
        public da() {
            super("hideAllNonBaseMenuItem", "hideAllNonBaseMenuItem", 93, false);
        }
    }

    public static class db extends g {
        public db() {
            super(u.NAME, u.NAME, 85, false);
        }
    }

    public static class dd extends g {
        public dd() {
            super(v.NAME, "", 14, false);
        }
    }

    public static class dt extends g {
        public dt() {
            super("getWebPayCheckoutCounterRequst", "getWebPayCheckoutCounterRequst", JsApiOperateBackgroundAudio.CTRL_INDEX, true);
        }
    }

    private static final class dv extends g {
        dv() {
            super("login", "login", 231, true);
        }
    }

    public static class dx extends g {
        public dx() {
            super("musicPlay", "playMusic", 69, false);
        }
    }

    public static class dy extends g {
        public dy() {
            super("timelineCheckIn", "timeline_check_in", 64, false);
        }
    }

    public static class ec extends g {
        public ec() {
            super("nfcCheckState", "nfcCheckState", 155, true);
        }
    }

    public static class ed extends g {
        public ed() {
            super("nfcConnect", "nfcConnect", b.CTRL_INDEX, false);
        }
    }

    private static final class ei extends g {
        ei() {
            super("openWCPayCardList", "openWCPayCardList", 310, true);
        }
    }

    private static final class el extends g {
        el() {
            super(ab.NAME, ab.NAME, 256, false);
        }
    }

    public static class f extends g {
        public f() {
            super("scanCover", "scanCover", com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX, true);
        }
    }

    private static final class fa extends g {
        fa() {
            super("openLuckyMoneyHistory", "openLuckyMoneyHistory", 258, true);
        }
    }

    public static class fc extends g {
        public fc() {
            super("openMyDeviceProfile", "openMyDeviceProfile", com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, false);
        }
    }

    public static class fd extends g {
        public fd() {
            super("openNewPage", "openNewPage", HardCoderJNI.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    private static final class fe extends g {
        fe() {
            super(ap.NAME, ap.NAME, 305, true);
        }
    }

    public static class fl extends g {
        public fl() {
            super("openSpecificView", "specific_view", 48, true);
        }
    }

    public static class fm extends g {
        public fm() {
            super("openUrlByExtBrowser", "open_url_by_ext_browser", 55, false);
        }
    }

    public static class fs extends g {
        public fs() {
            super("openWXDeviceLib", "openWXDeviceLib", 117, false);
        }
    }

    public static class fv extends g {
        public fv() {
            super(GameJsApiOperateGameCenterMsg.NAME, GameJsApiOperateGameCenterMsg.NAME, GameJsApiOperateGameCenterMsg.CTRL_BYTE, false);
        }
    }

    public static class gg extends g {
        public gg() {
            super("queryDownloadTask", "query_download_task", 40, false);
        }
    }

    public static class gi extends g {
        public gi() {
            super("realtimeReport", "realtimeReport", 171, false);
        }
    }

    public static class gk extends g {
        public gk() {
            super("reloadSearchWAWidgetData", "", 10000, false);
        }
    }

    public static class gm extends g {
        public gm() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.c.NAME, "", 10000, false);
        }
    }

    private static final class gu extends g {
        gu() {
            super("requestWxFaceVerifyInternal", "requestWxFaceVerifyInternal", com.tencent.mm.plugin.appbrand.jsapi.f.i.CTRL_INDEX, true);
        }
    }

    private static final class gv extends g {
        gv() {
            super("requestWxVoicePrintVerifyInternal", "requestWxVoicePrintVerifyInternal", JsApiSetAudioState.CTRL_INDEX, true);
        }
    }

    public static class h extends g {
        public h() {
            super("addContact", "add_contact", 5, true);
        }
    }

    public static class ha extends g {
        public ha() {
            super("searchDataHasResult", "", 10000, false);
        }
    }

    public static class hq extends g {
        public hq() {
            super(ar.NAME, ar.NAME, 218, false);
        }
    }

    public static class hu extends g {
        public hu() {
            super("setFreeWifiOwner", "setFreeWifiOwner", com.tencent.mm.plugin.appbrand.jsapi.y.CTRL_INDEX, false);
        }
    }

    public static class hv extends g {
        public hv() {
            super("setGameDebugConfig", "setGameDebugConfig", 1111111, false);
        }
    }

    public static class hx extends g {
        public hx() {
            super("setNavigationBarButtons", "setNavigationBarButtons", JsApiChooseWeChatContact.CTRL_INDEX, false);
        }
    }

    public static class i extends g {
        public i() {
            super("addCustomMenuItems", "addCustomMenuItems", 164, false);
        }
    }

    public static class ia extends g {
        public ia() {
            super(av.NAME, av.NAME, 113, false);
        }
    }

    public static class if extends g {
        public if() {
            super("setStatusBarStyle", "setStatusBarStyle", com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, false);
        }
    }

    public static class ii extends g {
        public ii() {
            super("shareQZone", "shareQZone", 132, true);
        }
    }

    public static class ja extends g {
        public ja() {
            super("startTempSession", "startTempSession", FileUtils.S_IWUSR, true);
        }
    }

    public static class ji extends g {
        public ji() {
            super("selectWalletCurrency", "selectWalletCurrency", 201, true);
        }
    }

    private static final class jj extends g {
        jj() {
            super("tapSearchWAWidgetView", "tapSearchWAWidgetView", 10000, true);
        }
    }

    public static class jp extends g {
        public jp() {
            super(d.NAME, "", 10000, false);
        }
    }

    public static class js extends g {
        public js() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd.CTRL_BYTE, true);
        }
    }

    public static class k extends g {
        public k() {
            super("addDownloadTaskStraight", "add_download_task_straight", 269, true);
        }
    }

    public static class kd extends g {
        public kd() {
            super("videoProxyStopPlay", "videoProxyStopPlay", 158, false);
        }
    }

    public static class kf extends g {
        public kf() {
            super("videoProxyPreload", "videoProxyPreload", 172, false);
        }
    }

    public static class kh extends g {
        public kh() {
            super("reportWeAppSearchRealtime", "", 10000, false);
        }
    }

    public static class kr extends g {
        public kr() {
            super("jumpWSRecVideoList", "", com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, true);
        }
    }

    public static class ks extends g {
        public ks() {
            super("menu:setfont", "", 129, false);
        }
    }

    public static class kt extends g {
        public kt() {
            super("menu:share:appmessage", "", 89, false);
        }
    }

    public static class kx extends g {
        public kx() {
            super("menu:share:weiboApp", "", 109, false);
        }
    }

    public static final class kz {
        public static Set<String> vAr;
    }

    public static class p extends g {
        public p() {
            super(e.NAME, e.NAME, 111, true);
        }
    }

    private static final class q extends g {
        q() {
            super("bindEmail", "bindEmail", 306, true);
        }
    }

    public static class y extends g {
        public y() {
            super("chooseImage", "chooseImage", 104, true);
        }
    }

    public static g Tm(String str) {
        if (vAn == null || vAn.size() <= 0) {
            Map hashMap = new HashMap(FileUtils.S_IWUSR);
            vAn = hashMap;
            hashMap.put("log", new du());
            vAn.put(w.NAME, new df());
            vAn.put("profile", new gf());
            vAn.put("shareWeibo", new kg());
            vAn.put("shareTimeline", new jk());
            vAn.put(JsApiAdDataReport.NAME, new m());
            vAn.put("streamingVideoPlay", new jh());
            vAn.put("addContact", new h());
            vAn.put(GameJsApiSendAppMessage.NAME, new hg());
            vAn.put("scanQRCode", new gz());
            vAn.put(v.NAME, new dd());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bb.NAME, new ip());
            vAn.put("getNetworkType", new cb());
            vAn.put(m.NAME, new ai());
            vAn.put("getInstallState", new bw());
            vAn.put("setFontSizeCallback", new ht());
            vAn.put("jumpToInstallUrl", new dk());
            vAn.put("launchApp", new dq());
            vAn.put(o.NAME, new bm());
            vAn.put("editAddress", new az());
            vAn.put("getHeadingAndPitch", new bt());
            vAn.put("sendEmail", new hk());
            vAn.put("addDownloadTask", new j());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f.NAME, new r());
            vAn.put("pauseDownloadTask", new fy());
            vAn.put("resumeDownloadTask", new gx());
            vAn.put("queryDownloadTask", new gg());
            vAn.put("installDownloadTask", new di());
            vAn.put("getLatestAddress", new ce());
            vAn.put("openSpecificView", new fl());
            vAn.put("jumpWCMall", new dm());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.y.NAME, new dp());
            vAn.put(JsApiWriteCommData.NAME, new kn());
            vAn.put("openUrlByExtBrowser", new fm());
            vAn.put("geoLocation", new bj());
            vAn.put("getBrandWCPayBindCardRequest", new bl());
            vAn.put("openProductView", new ff());
            vAn.put("openProductViewWithPid", new fg());
            vAn.put("jumpToBizProfile", new dl());
            vAn.put("openTimelineCheckInList", new ea());
            vAn.put(com.tencent.mm.plugin.appbrand.jsapi.lbs.e.NAME, new dz());
            vAn.put("timelineCheckIn", new dy());
            vAn.put("getBrandWCPayCreateCreditCardRequest", new fr());
            vAn.put("chooseCard", new w());
            vAn.put("chooseInvoice", new z());
            vAn.put("sendServiceAppMessage", new hl());
            vAn.put("musicPlay", new dx());
            vAn.put("mmsf0001", new bp());
            vAn.put("connectToWiFi", new an());
            vAn.put("getTransferMoneyRequest", new ct());
            vAn.put("openWCPaySpecificView", new fo());
            vAn.put(as.NAME, new hr());
            vAn.put("batchAddCard", new o());
            vAn.put(ak.NAME, new ge());
            vAn.put(JsApiStartRecordVoice.NAME, new ix());
            vAn.put(JsApiStopRecordVoice.NAME, new je());
            vAn.put(JsApiStartPlayVoice.NAME, new ga());
            vAn.put(JsApiPausePlayVoice.NAME, new fz());
            vAn.put(JsApiStopPlayVoice.NAME, new jg());
            vAn.put("uploadVoice", new ju());
            vAn.put("downloadVoice", new aw());
            vAn.put("chooseImage", new y());
            vAn.put("uploadImage", new jr());
            vAn.put("downloadImage", new av());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd.NAME, new js());
            vAn.put(u.NAME, new db());
            vAn.put(ba.NAME, new in());
            vAn.put("hideAllNonBaseMenuItem", new da());
            vAn.put("showAllNonBaseMenuItem", new ik());
            vAn.put(g.NAME, new v());
            vAn.put("translateVoice", new jl());
            vAn.put("shareQQ", new ih());
            vAn.put("shareWeiboApp", new ij());
            vAn.put("shareQZone", new ii());
            vAn.put("connectToFreeWifi", new am());
            vAn.put("getSendC2CMessageRequest", new cq());
            vAn.put(e.NAME, new p());
            vAn.put("configWXDeviceWiFi", new al());
            vAn.put("getCurrentSSID", new bn());
            vAn.put("setPageOwner", new hz());
            vAn.put("getWechatVerifyTicket", new cv());
            vAn.put("openWXDeviceLib", new fs());
            vAn.put("startScanWXDevice", new iy());
            vAn.put("stopScanWXDevice", new jf());
            vAn.put("connectWXDevice", new ao());
            vAn.put("disconnectWXDevice", new au());
            vAn.put("getWXDeviceTicket", new cy());
            vAn.put("getWXDeviceInfos", new cx());
            vAn.put("sendDataToWXDevice", new hh());
            vAn.put("closeWXDeviceLib", new ak());
            vAn.put("setSendDataDirection", new id());
            vAn.put("verifyWCPayPassword", new jw());
            vAn.put("getPaymentOrderRequest", new cd());
            vAn.put("openGameDetail", new ev());
            vAn.put(ac.NAME, new eu());
            vAn.put("setGameDebugConfig", new hv());
            vAn.put("startTempSession", new ja());
            vAn.put("getH5PrepayRequest", new bu());
            vAn.put("getH5TransactionRequest", new bv());
            vAn.put("menu:share:timeline", new kw());
            vAn.put("menu:share:appmessage", new kt());
            vAn.put("menu:share:qq", new ku());
            vAn.put("menu:share:weiboApp", new kx());
            vAn.put("menu:setfont", new ks());
            vAn.put("menu:share:weibo", new kx());
            vAn.put("menu:share:QZone", new kv());
            vAn.put("getRecevieBizHongBaoRequest", new e());
            vAn.put(a.NAME, new dh());
            vAn.put(d.NAME, new jp());
            vAn.put(com.tencent.mm.plugin.appbrand.jsapi.video.c.NAME, new gm());
            vAn.put(com.tencent.mm.plugin.appbrand.jsapi.video.b.NAME, new fw());
            vAn.put("deleteSearchHistory", new ar());
            vAn.put("getSearchHistory", new cm());
            vAn.put("getSearchData", new ci());
            vAn.put("getPoiInfo", new bs());
            vAn.put("updateReddotTimeStamps", new jn());
            vAn.put("getTeachSearchData", new cs());
            vAn.put("getSearchGuideData", new cl());
            vAn.put("getSearchAvatarList", new ch());
            vAn.put("getSearchSnsImageList", new co());
            vAn.put("getSearchImageList", new cn());
            vAn.put("getSearchDisplayNameList", new cj());
            vAn.put("startSearchItemDetailPage", new iz());
            vAn.put("reportSearchStatistics", new gs());
            vAn.put("reportSearchRealTimeStatistics", new gr());
            vAn.put("searchDataHasResult", new ha());
            vAn.put("openEmotionPage", new bh());
            vAn.put("getSearchSuggestionData", new cp());
            vAn.put("setSearchInputWord", new ic());
            vAn.put("setSnsObjectXmlDescList", new ie());
            vAn.put("clickSnsMusicPlayButton", new ah());
            vAn.put(ah.NAME, new fq());
            vAn.put("reportWeAppSearchRealtime", new kh());
            vAn.put("doSearchOperation", new ay());
            vAn.put("insertSearchWAWidgetView", new dg());
            vAn.put("removeSearchWAWidgetView", new gl());
            vAn.put("updateSearchWAWidgetView", new jo());
            vAn.put("showSearchActionSheet", new iq());
            vAn.put("cancelSearchActionSheet", new s());
            vAn.put("uxSearchOpLog", new jv());
            vAn.put("jumpToWXWallet", new dn());
            vAn.put("scanCover", new f());
            vAn.put("reportActionInfo", new gn());
            vAn.put("openMyDeviceProfile", new fc());
            vAn.put("selectPedometerSource", new hd());
            vAn.put("nfcIsConnect", new eg());
            vAn.put("nfcConnect", new ed());
            vAn.put("nfcTransceive", new eh());
            vAn.put("nfcBatchTransceive", new eb());
            vAn.put("nfcGetId", new ee());
            vAn.put("nfcGetInfo", new ef());
            vAn.put("startMonitoringBeacons", new iv());
            vAn.put("stopMonitoringBeacons", new jc());
            vAn.put("nfcCheckState", new ec());
            vAn.put("videoProxyInit", new jz());
            vAn.put("videoProxyStartPlay", new kc());
            vAn.put("videoProxyStopPlay", new kd());
            vAn.put("videoProxySetPlayerState", new ka());
            vAn.put("videoProxySetRemainTime", new kb());
            vAn.put("videoProxyPreload", new kf());
            vAn.put("getWebPayCheckoutCounterRequst", new dt());
            vAn.put("addCustomMenuItems", new i());
            vAn.put(GameJsApiOperateGameCenterMsg.NAME, new fv());
            vAn.put("openEnterpriseChat", new es());
            vAn.put("enterEnterpriseChat", new bd());
            vAn.put("openEnterpriseContact", new et());
            vAn.put("selectEnterpriseContact", new hc());
            vAn.put("getEnterpriseChat", new bq());
            vAn.put("reportIDKey", new gp());
            vAn.put("quicklyAddBrandContact", new gh());
            vAn.put("consumedShareCard", new ap());
            vAn.put("cache", new jy());
            vAn.put("publicCache", new ke());
            vAn.put("kvReport", new do());
            vAn.put("realtimeReport", new gi());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af.NAME, new fn());
            vAn.put("setFreeWifiOwner", new hu());
            vAn.put("selectSingleContact", new he());
            vAn.put("sendAppMessageToSpecifiedContact", new hf());
            vAn.put("setLocalData", new hw());
            vAn.put("getLocalData", new bx());
            vAn.put("clearLocalData", new af());
            vAn.put(az.NAME, new im());
            vAn.put(bc.NAME, new is());
            vAn.put(n.NAME, new as());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.NAME, new ad());
            vAn.put("setNavigationBarButtons", new hx());
            vAn.put("enableFullScreen", new bb());
            vAn.put(bi.NAME, new io());
            vAn.put(ae.NAME, new dc());
            vAn.put("enablePullDownRefresh", new bc());
            vAn.put(bk.NAME, new iw());
            vAn.put(bl.NAME, new jd());
            vAn.put("disablePullDownRefresh", new at());
            vAn.put(av.NAME, new ia());
            vAn.put("setStatusBarStyle", new if());
            vAn.put("deleteAccountSuccess", new aq());
            vAn.put("chooseVideo", new ac());
            vAn.put("uploadVideo", new jt());
            vAn.put("openMapNavigateMenu", new fb());
            vAn.put("setNavigationBarColor", new hy());
            vAn.put("getWCPayRealnameVerify", new cu());
            vAn.put("openDesignerEmojiView", new em());
            vAn.put("openDesignerProfile", new eo());
            vAn.put("openEmoticonTopicList", new er());
            vAn.put("openDesignerEmojiViewLocal", new en());
            vAn.put("openDesignerProfileLocal", new ep());
            vAn.put("openEmotionDetailViewLocal", new d());
            vAn.put("openNewPage", new fd());
            vAn.put("getSearchEmotionData", new ck());
            vAn.put("openEmotionUrl", new ba());
            vAn.put("WNNativeCallbackOnClick", new kl());
            vAn.put("WNNativeCallbackOnLongClick", new km());
            vAn.put("WNNativeCallbackOnCaretChange", new kk());
            vAn.put("WNNativeCallbackInitData", new kj());
            vAn.put("WNNativeAsyncCallback", new ki());
            vAn.put("WNNativeCallbackOnBecomeEditing", new kp());
            vAn.put("WNNativeCallbackOnBecomeEdited", new kq());
            vAn.put("changePayActivityView", new t());
            vAn.put("selectWalletCurrency", new ji());
            vAn.put("scanLicence", new gy());
            vAn.put(JsApiOperateMusicPlayer.NAME, new b());
            vAn.put(JsApiGetMusicPlayerState.NAME, new a());
            vAn.put("clearWebviewCache", new ag());
            vAn.put("requireSoterBiometricAuthentication", new it());
            vAn.put("getSupportSoter", new iu());
            vAn.put("unbindBankCard", new jm());
            vAn.put(ar.NAME, new hq());
            vAn.put("sendEnterpriseChat", new hi());
            vAn.put("doExposePreparation", new ax());
            vAn.put("getMsgProofItems", new ca());
            vAn.put("openSecurityView", new fk());
            vAn.put("startVoipCall", new jb());
            vAn.put(com.tencent.mm.plugin.appbrand.jsapi.u.NAME, new aa());
            vAn.put(GameJsApiGetOpenDeviceId.NAME, new cc());
            vAn.put("getRouteUrl", new cg());
            vAn.put("idCardRealnameVerify", new de());
            vAn.put("uploadIdCardSuccess", new ky());
            vAn.put(com.tencent.mm.plugin.appbrand.jsapi.h.d.NAME, new il());
            vAn.put("openLuckyMoneyDetailView", new ez());
            vAn.put("resendRemittanceMsg", new gw());
            vAn.put(GameJsApiGetGameCommInfo.NAME, new br());
            vAn.put(ad.NAME, new ew());
            vAn.put("chooseIdCard", new x());
            vAn.put("getLocalImgData", new c());
            vAn.put(ag.NAME, new fp());
            vAn.put(an.NAME, new gj());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.al.NAME, new gd());
            vAn.put("uploadEncryptMediaFile", new jq());
            vAn.put("chooseMedia", new ab());
            vAn.put("requestWxFacePictureVerify", new be());
            vAn.put(ab.NAME, new el());
            vAn.put("forceUpdateWxaAttr", new bg());
            vAn.put("openLuckyMoneyHistory", new fa());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.NAME, new hj());
            vAn.put(t.NAME, new cw());
            vAn.put(r.NAME, new by());
            vAn.put("openGameWebView", new ey());
            vAn.put(GameJsApiLaunchApplication.NAME, new dr());
            vAn.put("showSearchOfBizHistory", new ir());
            vAn.put("login", new dv());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME, new n());
            vAn.put("requestWxFacePictureVerifyUnionVideo", new bf());
            vAn.put("checkIsSupportFaceDetect", new u());
            vAn.put(JsApiOperateBackgroundAudio.NAME, new fu());
            vAn.put(JsApiSetBackgroundAudioState.NAME, new hp());
            vAn.put(JsApiGetBackgroundAudioState.NAME, new bk());
            vAn.put("addDownloadTaskStraight", new k());
            vAn.put(aw.NAME, new ib());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME, new l());
            vAn.put(ax.NAME, new ig());
            vAn.put(ai.NAME, new dw());
            vAn.put("openADCanvas", new ek());
            vAn.put("openSearchCanvas", new fh());
            vAn.put("opVoteAdData", new fx());
            vAn.put("requestWxFaceRegisterInternal", new gt());
            vAn.put("requestWxFaceVerifyInternal", new gu());
            vAn.put("launchMiniProgram", new ds());
            vAn.put("reportMiniProgramPageData", new gq());
            vAn.put("selectContact", new hb());
            vAn.put("openSearchWAWidgetLogView", new fi());
            vAn.put("reloadSearchWAWidgetData", new gk());
            vAn.put("closeWindowAndGoNext", new aj());
            vAn.put("requestWxVoicePrintVerifyInternal", new gv());
            vAn.put("openBizChat", new ej());
            vAn.put("handleWCPayWalletBuffer", new cz());
            vAn.put("tapSearchWAWidgetView", new jj());
            vAn.put("getMatchContactList", new bz());
            vAn.put("openSearchWebView", new fj());
            vAn.put("openWXSearchPage", new ft());
            vAn.put("viewTypeChange", new jx());
            vAn.put("invokeMiniProgramAPI", new dj());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae.NAME, new ex());
            vAn.put(at.NAME, new hs());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p.NAME, new bo());
            vAn.put(l.NAME, new ae());
            vAn.put("openECard", new eq());
            vAn.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao.NAME, new go());
            vAn.put("setWCPayPassword", new ho());
            vAn.put("openWCPayCardList", new ei());
            vAn.put("bindEmail", new q());
            vAn.put(ap.NAME, new fe());
            vAn.put("bindEmail", new q());
            vAn.put("doGoToRecVideoList", new cf());
            vAn.put("jumpWSRecVideoList", new kr());
            vAn.put("recordHistory", new bi());
            List<g> linkedList = new LinkedList();
            linkedList.add(new gc());
            linkedList.add(new gb());
            for (g gVar : linkedList) {
                vAn.put(gVar.getName(), gVar);
            }
            vAn.put(com.tencent.mm.plugin.appbrand.jsapi.ad.NAME, new cr());
            vAn.put("serviceClick", new hn());
            vAn.put(com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME, new ko());
            vAn.put("sendSingleAppMessage", new hm());
        }
        return (g) vAn.get(str);
    }
}
