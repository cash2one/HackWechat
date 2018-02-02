package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.m;
import com.tencent.mm.bh.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.game.gamewebview.b.a.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements b, b {
    private static final int tGJ = (com.tencent.mm.compatible.util.d.fN(19) ? 200 : 20);
    public com.tencent.mm.plugin.webview.stub.d juQ;
    public MMWebView tGK;
    private final List<String> tGL = new LinkedList();
    private final LinkedList<i> tGM = new LinkedList();
    private af tGN = null;
    Map<String, Object> tGO;
    public Map<String, Object> tGP;
    public boolean tGQ = false;
    private e tGR;
    public boolean tGS = false;
    public String tGT = "";
    private Set<a> tGU;
    private final List<String> tGV = new LinkedList();
    volatile String tGW = null;
    volatile int tGX = 0;
    private JSONObject tGY = new JSONObject();
    private JSONArray tGZ = new JSONArray();
    private List<String> tHa = new LinkedList();
    private ak tHb = new ak(new 26(this), false);
    public long tHc = 0;
    public int tvn;

    class AnonymousClass36 implements Runnable {
        final /* synthetic */ String iXg;
        final /* synthetic */ d tHd;

        public AnonymousClass36(d dVar, String str) {
            this.tHd = dVar;
            this.iXg = str;
        }

        public final void run() {
            try {
                this.tHd.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iXg + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onGetPoiInfoReturn fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass58 implements Runnable {
        final /* synthetic */ String iXg;
        final /* synthetic */ d tHd;

        public AnonymousClass58(d dVar, String str) {
            this.tHd = dVar;
            this.iXg = str;
        }

        public final void run() {
            try {
                this.tHd.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iXg + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass60 implements Runnable {
        final /* synthetic */ String iXg;
        final /* synthetic */ d tHd;

        public AnonymousClass60(d dVar, String str) {
            this.tHd = dVar;
            this.iXg = str;
        }

        public final void run() {
            try {
                this.tHd.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iXg + ")", null);
            } catch (Exception e) {
            }
        }
    }

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String iXg;
        final /* synthetic */ d tHd;

        public AnonymousClass6(d dVar, String str) {
            this.tHd = dVar;
            this.iXg = str;
        }

        public final void run() {
            try {
                this.tHd.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iXg + ")", null);
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange, %s", new Object[]{e.getMessage()});
            }
        }
    }

    static /* synthetic */ Map C(String[] strArr) {
        int length = strArr == null ? 0 : strArr.length;
        if (length == 0) {
            return null;
        }
        Map hashMap = new HashMap();
        for (int i = 0; i < length; i++) {
            if (hashMap.keySet().contains(strArr[i])) {
                hashMap.put(strArr[i], Integer.valueOf(((Integer) hashMap.get(strArr[i])).intValue() + 1));
            } else {
                hashMap.put(strArr[i], Integer.valueOf(1));
            }
        }
        return hashMap;
    }

    static /* synthetic */ void c(d dVar) {
        if (dVar.tGL.size() <= 0) {
            x.i("MicroMsg.JsApiHandler", "dealMsgQueue fail, resultValueList is empty");
            return;
        }
        x.i("MicroMsg.JsApiHandler", "dealMsgQueue, pre msgList = " + dVar.tGM.size());
        Collection c = i$a.c((String) dVar.tGL.remove(0), dVar.tGS, dVar.tGT);
        if (!bh.cA(c)) {
            dVar.tGM.addAll(c);
            x.i("MicroMsg.JsApiHandler", "now msg list size : %d", new Object[]{Integer.valueOf(dVar.tGM.size())});
        }
        x.i("MicroMsg.JsApiHandler", "dealMsgQueue, post msgList = " + dVar.tGM.size());
        dVar.bUp();
        if (dVar.tGN != null) {
            dVar.tGN.post(new 63(dVar));
        }
    }

    static /* synthetic */ void l(d dVar) {
        do {
        } while (dVar.bUq());
    }

    public d(MMWebView mMWebView, e eVar, Map<String, Object> map, com.tencent.mm.plugin.webview.stub.d dVar, int i) {
        this.tGK = mMWebView;
        this.tGR = eVar;
        this.tGN = new 1(this, Looper.getMainLooper());
        this.juQ = dVar;
        this.tGO = map;
        this.tvn = i;
    }

    public final void bUm() {
        this.tGS = true;
        this.tGT = bh.Dg(16);
        x.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s", new Object[]{this.tGT});
    }

    public final void aQ(String str, boolean z) {
        try {
            this.juQ.i(str, z, this.tvn);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = " + e);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        if (this.tGN != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            this.tGN.sendMessage(obtain);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(final String str) {
        if (str != null) {
            this.tGN.post(new Runnable(this) {
                final /* synthetic */ d tHd;

                public final void run() {
                    Map C = d.C(str.split(","));
                    String a = this.tHd.PG("hosts");
                    if (!d.p(a, C)) {
                        x.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
                    } else if (this.tHd.juQ != null && this.tHd.tGK != null) {
                        try {
                            this.tHd.juQ.y(0, this.tHd.tGK.getUrl(), a);
                        } catch (RemoteException e) {
                            x.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[]{e.getMessage()});
                        }
                    }
                }
            });
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(final String str) {
        if (str != null) {
            this.tGN.post(new Runnable(this) {
                final /* synthetic */ d tHd;

                public final void run() {
                    String a = this.tHd.PG("html");
                    if (!d.eS(a, str)) {
                        x.e("MicroMsg.JsApiHandler", "failed to write Html file");
                    } else if (this.tHd.juQ != null && this.tHd.tGK != null) {
                        try {
                            this.tHd.juQ.y(1, this.tHd.tGK.getUrl(), a);
                        } catch (RemoteException e) {
                            x.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[]{e.getMessage()});
                        }
                    }
                }
            });
        }
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://dispatch_message/");
    }

    public final boolean BU(final String str) {
        this.tGK.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback<String>(this) {
            final /* synthetic */ d tHd;

            public final /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
                x.i("MicroMsg.JsApiHandler", "handle url %s, re %s", new Object[]{str, str});
            }
        });
        return true;
    }

    public final void al(Map<String, Object> map) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onPreloadWebViewInit success, ready");
            String str = "MicroMsg.JsApiHandler";
            String str2 = "onPreloadWebViewInit,params %s";
            Object[] objArr = new Object[1];
            objArr[0] = map == null ? "" : map.toString();
            x.i(str, str2, objArr);
            ag.y(new 44(this, i$a.a("onUiInit", (Map) map, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, not ready");
    }

    public final void bUn() {
        this.tGQ = true;
        if (this.tGU != null) {
            for (a aVar : this.tGU) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.tGU == null) {
            this.tGU = new HashSet();
        }
        this.tGU.add(aVar);
    }

    public final void bUo() {
        x.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[]{Boolean.valueOf(this.tGQ)});
        if (this.tGK != null && this.tGQ) {
            MMWebView mMWebView = this.tGK;
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            String str = "sys:attach_runOn3rd_apis";
            Map hashMap = new HashMap();
            JsapiPermissionWrapper bSs = this.tGR.bSs();
            Collection linkedList = new LinkedList();
            if (bSs != null) {
                if (bSs.gn(88)) {
                    linkedList.add("menu:share:timeline");
                }
                if (bSs.gn(89)) {
                    linkedList.add("menu:share:appmessage");
                }
                if (bSs.gn(94)) {
                    linkedList.add("menu:share:qq");
                }
                if (bSs.gn(109)) {
                    linkedList.add("menu:share:weiboApp");
                }
                if (bSs.gn(c.CTRL_INDEX)) {
                    linkedList.add("menu:share:QZone");
                }
                if (bSs.gn(219)) {
                    linkedList.add("sys:record");
                }
                linkedList.add("onVoiceRecordEnd");
                linkedList.add("onVoicePlayBegin");
                linkedList.add("onVoicePlayEnd");
                linkedList.add("onLocalImageUploadProgress");
                linkedList.add("onImageDownloadProgress");
                linkedList.add("onVoiceUploadProgress");
                linkedList.add("onVoiceDownloadProgress");
                linkedList.add("onVideoUploadProgress");
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.e.NAME);
                linkedList.add("menu:setfont");
                linkedList.add("menu:share:weibo");
                linkedList.add("menu:share:email");
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.c.NAME);
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.b.NAME);
                linkedList.add("hdOnDeviceStateChanged");
                linkedList.add("activity:state_change");
                linkedList.add("onWXDeviceBluetoothStateChange");
                linkedList.add("onWXDeviceLanStateChange");
                linkedList.add("onWXDeviceBindStateChange");
                linkedList.add("onReceiveDataFromWXDevice");
                linkedList.add("onScanWXDeviceResult");
                linkedList.add("onWXDeviceStateChange");
                linkedList.add("onNfcTouch");
                linkedList.add("onBeaconMonitoring");
                linkedList.add("onBeaconsInRange");
                linkedList.add("menu:custom");
                linkedList.add("onSearchWAWidgetOpenApp");
                linkedList.add("onSearchDataReady");
                linkedList.add("onGetPoiInfoReturn");
                linkedList.add("onSearchHistoryReady");
                linkedList.add("onSearchWAWidgetOnTapCallback");
                linkedList.add("onSearchImageListReady");
                linkedList.add("onTeachSearchDataReady");
                linkedList.add("onSearchGuideDataReady");
                linkedList.add("onSearchInputChange");
                linkedList.add("onSearchInputConfirm");
                linkedList.add("onSearchSuggestionDataReady");
                linkedList.add("onMusicStatusChanged");
                linkedList.add("switchToTabSearch");
                linkedList.add("onVideoPlayerCallback");
                linkedList.add("onSelectContact");
                linkedList.add("onSearchWAWidgetAttrChanged");
                linkedList.add("onSearchWAWidgetReloadData");
                linkedList.add("onSearchWAWidgetReloadDataFinish");
                linkedList.add("onSearchWAWidgetStateChange");
                linkedList.add("onSearchWAWidgetDataPush");
                linkedList.add("onPullDownRefresh");
                linkedList.add("onPageStateChange");
                linkedList.add("onGetKeyboardHeight");
                linkedList.add("onGetSmiley");
                linkedList.add("onAddShortcutStatus");
                linkedList.add("onFocusSearchInput");
                linkedList.add("onGetA8KeyUrl");
                linkedList.add("deleteAccountSuccess");
                linkedList.add("onGetMsgProofItems");
                linkedList.add("WNJSHandlerInsert");
                linkedList.add("WNJSHandlerMultiInsert");
                linkedList.add("WNJSHandlerExportData");
                linkedList.add("WNJSHandlerHeaderAndFooterChange");
                linkedList.add("WNJSHandlerEditableChange");
                linkedList.add("WNJSHandlerEditingChange");
                linkedList.add("WNJSHandlerSaveSelectionRange");
                linkedList.add("WNJSHandlerLoadSelectionRange");
                linkedList.add(a.NAME);
                linkedList.add("showLoading");
                linkedList.add("getSearchEmotionDataCallBack");
                linkedList.add("onNavigationBarRightButtonClick");
                linkedList.add("onSearchActionSheetClick");
                linkedList.add("onGetMatchContactList");
                linkedList.add("onUiInit");
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME);
                linkedList.add("onBackgroundAudioStateChange");
                linkedList.add("onArticleReadingBtnClicked");
                if (!bh.cA(null)) {
                    linkedList.addAll(null);
                }
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            mMWebView.evaluateJavascript(stringBuilder.append(i$a.a(str, hashMap, this.tGS, this.tGT)).append(")").toString(), new 55(this));
        }
    }

    private void bUp() {
        do {
        } while (bUq());
    }

    private boolean bUq() {
        if (bh.cA(this.tGM)) {
            x.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
            return false;
        }
        boolean At;
        try {
            At = this.juQ.At(this.tvn);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "isBusy, ex = " + e.getMessage());
            At = false;
        }
        if (At) {
            x.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
            return false;
        } else if (this.tGM.size() == 0) {
            x.w("MicroMsg.JsApiHandler", "msgList size is 0.");
            return false;
        } else {
            i iVar = (i) this.tGM.remove(0);
            if (iVar == null) {
                x.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
                return true;
            } else if (iVar.tJI == null || iVar.pox == null || iVar.type == null || this.tGK == null) {
                x.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + iVar.tJI + ", params = " + iVar.pox + ", type = " + iVar.type + ", wv = " + this.tGK);
                return true;
            } else {
                if (!(this.tGP == null || this.tGP.get("srcUsername") == null || bh.ov(this.tGP.get("srcUsername").toString()))) {
                    iVar.pox.put("src_username", this.tGP.get("srcUsername").toString());
                }
                if (!(this.tGP == null || this.tGP.get("srcDisplayname") == null || bh.ov(this.tGP.get("srcDisplayname").toString()))) {
                    iVar.pox.put("src_displayname", this.tGP.get("srcDisplayname").toString());
                }
                if (!(this.tGP == null || this.tGP.get("KTemplateId") == null || bh.ov(this.tGP.get("KTemplateId").toString()))) {
                    iVar.pox.put("tempalate_id", this.tGP.get("KTemplateId").toString());
                }
                if (this.tGP != null) {
                    iVar.pox.put("message_id", this.tGP.get("message_id"));
                    iVar.pox.put("message_index", this.tGP.get("message_index"));
                    iVar.pox.put("webview_scene", this.tGP.get("scene"));
                    iVar.pox.put("pay_channel", this.tGP.get("pay_channel"));
                    iVar.pox.put("pay_scene", this.tGP.get("pay_scene"));
                    iVar.pox.put("stastic_scene", this.tGP.get("stastic_scene"));
                    iVar.pox.put("open_from_scene", this.tGP.get("from_scence"));
                    Bundle bundle = new Bundle();
                    bundle.putString("__jsapi_fw_ext_info_key_current_url", this.tGK.getUrl());
                    iVar.pox.put("__jsapi_fw_ext_info", bundle);
                }
                if (!(iVar.tJI.equals("shareWeibo") || iVar.tJI.equals("openUrlByExtBrowser") || iVar.tJI.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af.NAME) || iVar.tJI.equals(ab.NAME) || iVar.tJI.equals("openGameWebView") || iVar.tJI.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME) || iVar.tJI.equals(ax.NAME) || iVar.tJI.equals(ae.NAME))) {
                    iVar.pox.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.tGK.getUrl());
                    x.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl" + this.tGK.getUrl());
                }
                if (iVar.tJI.equalsIgnoreCase("openDesignerEmojiView") || iVar.tJI.equalsIgnoreCase("openEmotionDetailViewLocal") || iVar.tJI.equalsIgnoreCase("openDesignerEmojiView") || iVar.tJI.equalsIgnoreCase("openDesignerEmojiViewLocal") || iVar.tJI.equalsIgnoreCase("openDesignerEmojiView") || iVar.tJI.equalsIgnoreCase("openDesignerProfile") || iVar.tJI.equalsIgnoreCase("openDesignerProfileLocal") || iVar.tJI.equalsIgnoreCase("getSearchEmotionData")) {
                    iVar.pox.put("searchID", Long.valueOf(bUt()));
                    x.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[]{Long.valueOf(bUt())});
                }
                try {
                    JsapiPermissionWrapper bSs = this.tGR.bSs();
                    Bundle bundle2 = new Bundle();
                    if (bSs != null) {
                        bSs.toBundle(bundle2);
                    }
                    At = this.juQ.a(iVar.type, iVar.tJI, iVar.tJG, bundle2, i.ap(iVar.pox), this.tvn);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    x.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + e2.getMessage());
                    At = false;
                }
                x.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[]{iVar.tJI, Boolean.valueOf(At)});
                if (At) {
                    return false;
                }
                return true;
            }
        }
    }

    public final void detach() {
        this.tGQ = false;
        this.tGM.clear();
        this.tGL.clear();
        this.tGN = null;
    }

    public final void keep_setReturnValue(String str, String str2) {
        x.i("MicroMsg.JsApiHandler", "setResultValue, scene = " + str + ", resultValue = " + str2);
        x.i("MicroMsg.JsApiHandler", "edw setResultValue = threadId = " + Thread.currentThread().getId() + ", threadName = " + Thread.currentThread().getName());
        if (this.tGN != null) {
            Message obtain = Message.obtain();
            obtain.obj = str2;
            if (str.equals("SCENE_FETCHQUEUE")) {
                obtain.what = 1;
            } else if (str.equals("SCENE_HANDLEMSGFROMWX")) {
                obtain.what = 2;
            }
            this.tGN.sendMessage(obtain);
        }
    }

    public final void bUr() {
        if (this.tGQ) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "friend");
            this.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("menu:share:appmessage", hashMap, this.tGS, this.tGT) + ")", null);
            try {
                this.juQ.E("scene", "friend", this.tvn);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onSendToFriend fail, not ready");
    }

    public final void f(Bundle bundle, String str) {
        if (!this.tGQ || bundle == null) {
            x.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
            return;
        }
        long j = bundle.getLong("download_manager_downloadid");
        String string = bundle.getString("download_manager_appid", "");
        int i = bundle.getInt("download_manager_errcode");
        x.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + j + ", state = " + str + ", errCode = " + i);
        Map hashMap = new HashMap();
        hashMap.put("appid", string);
        hashMap.put("download_id", Long.valueOf(j));
        hashMap.put("err_code", Integer.valueOf(i));
        hashMap.put("state", str);
        ag.y(new 64(this, i$a.a(com.tencent.mm.plugin.game.gamewebview.b.a.c.NAME, hashMap, this.tGS, this.tGT)));
    }

    public final void g(String str, long j, int i) {
        if (this.tGQ) {
            Map hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("download_id", Long.valueOf(j));
            hashMap.put("progress", Integer.valueOf(i));
            ag.y(new 65(this, i$a.a(com.tencent.mm.plugin.game.gamewebview.b.a.b.NAME, hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
    }

    public final void cC(String str, int i) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[]{str, Integer.valueOf(i)});
            if (bh.ov(str)) {
                x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("deviceId", str);
            if (i == 2) {
                hashMap.put("state", "connected");
            } else if (i == 1) {
                hashMap.put("state", "connecting");
            } else {
                hashMap.put("state", "disconnected");
            }
            ag.y(new 2(this, i$a.a("onWXDeviceStateChange", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
    }

    public final void am(Map<String, Object> map) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
            final String a = i$a.a("onVoicePlayEnd", (Map) map, this.tGS, this.tGT);
            ag.y(new Runnable(this) {
                final /* synthetic */ d tHd;

                public final void run() {
                    try {
                        this.tHd.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
    }

    public final void an(Map<String, Object> map) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
            x.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[]{i$a.a("onVoiceRecordEnd", (Map) map, this.tGS, this.tGT)});
            ag.y(new 9(this, r0));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
    }

    public final void cD(String str, int i) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ag.y(new 11(this, i$a.a("onImageUploadProgress", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
    }

    public final void cE(String str, int i) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ag.y(new 13(this, i$a.a("onImageDownloadProgress", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
    }

    public final void cF(String str, int i) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ag.y(new 14(this, i$a.a("onVoiceUploadProgress", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
    }

    public final void cG(String str, int i) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ag.y(new 15(this, i$a.a("onVoiceDownloadProgress", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
    }

    public final void cH(String str, int i) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ag.y(new 16(this, i$a.a("onVideoUploadProgress", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
    }

    public final void PC(String str) {
        try {
            Bundle bundle = new Bundle();
            JsapiPermissionWrapper bSs = this.tGR.bSs();
            if (bSs != null) {
                bSs.toBundle(bundle);
            }
            this.juQ.a(str, bundle, this.tvn);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "doProfile, ex = " + e.getMessage());
        }
    }

    public final void AZ(int i) {
        Map hashMap = new HashMap();
        hashMap.put("height", Integer.valueOf(com.tencent.mm.bv.a.ad(ac.getContext(), i)));
        ag.y(new 20(this, i$a.a("onGetKeyboardHeight", hashMap, this.tGS, this.tGT)));
    }

    public final void kA(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("success", Boolean.valueOf(z));
        ag.y(new 22(this, i$a.a("onAddShortcutStatus", hashMap, this.tGS, this.tGT)));
    }

    public final void o(final String str, final Map<String, String> map) {
        x.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[]{str});
        if (!bh.ov(str)) {
            this.tGW = str;
            if (map == null || map.size() == 0) {
                this.tGX = 0;
            } else {
                this.tGX = 1;
            }
            final String cI = cI(str, this.tGX);
            ag.y(new Runnable(this) {
                final /* synthetic */ d tHd;

                public final void run() {
                    try {
                        if (!(map == null || map.size() == 0)) {
                            com.tencent.xweb.c.iO(ac.getContext());
                            com.tencent.xweb.b cIj = com.tencent.xweb.b.cIj();
                            for (String str : map.keySet()) {
                                cIj.setCookie(bh.VZ(str), str + "=" + ((String) map.get(str)));
                            }
                            cIj.setCookie(bh.VZ(str), "httponly");
                            com.tencent.xweb.c.cIl();
                            com.tencent.xweb.c.sync();
                            x.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[]{cIj.getCookie(bh.VZ(str))});
                        }
                        this.tHd.tGK.evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[]{str}), null);
                        this.tHd.tGK.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                        if (this.tHd.tGQ) {
                            this.tHd.tGK.evaluateJavascript(cI, null);
                            this.tHd.tGW = null;
                            this.tHd.tGX = 0;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
        }
    }

    final String cI(String str, int i) {
        Map hashMap = new HashMap(2);
        hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
        hashMap.put("set_cookie", Integer.valueOf(i));
        return PE(i$a.a("onGetA8KeyUrl", hashMap, this.tGS, this.tGT));
    }

    public final synchronized void a(String str, int i, int i2, double d, double d2, float f) {
        if (this.tHb.cfK()) {
            this.tHb.J(1000, 1000);
        }
        JSONObject jSONObject = new JSONObject();
        int i3 = 0;
        if (d > 0.0d && d < 0.5d) {
            i3 = 1;
        }
        try {
            if (!this.tHa.contains(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2))) {
                this.tHa.add(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2));
                jSONObject.put("uuid", String.valueOf(str));
                jSONObject.put("major", String.valueOf(i));
                jSONObject.put("minor", String.valueOf(i2));
                jSONObject.put("accuracy", String.valueOf(d));
                jSONObject.put("rssi", String.valueOf(d2));
                jSONObject.put("heading", String.valueOf(f));
                jSONObject.put("proximity", String.valueOf(i3));
                this.tGZ.put(jSONObject);
                this.tGY.put("beacons", this.tGZ);
                this.tGY.put("err_msg", "onBeaconsInRange:ok");
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", new Object[]{e.getMessage()});
        }
        i$a.a("onBeaconsInRange", this.tGY, this.tGS, this.tGT);
    }

    public final void a(String str, String str2, Map<String, Object> map, boolean z) {
        if (!bh.ov(str)) {
            if (str2 == null || str2.length() == 0 || str == null) {
                x.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = " + str2);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("err_msg", str2);
                if (map != null && map.size() > 0) {
                    x.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + map.size());
                    hashMap.putAll(map);
                }
                String a = i$a.a("callback", str, hashMap, null, this.tGS, this.tGT);
                x.i("MicroMsg.JsApiHandler", "doCallback, ret = " + str2 + ", cb = " + a);
                if (!(a == null || this.tGK == null)) {
                    ag.y(new 28(this, a));
                }
            }
        }
        if (z) {
            bRP();
        }
    }

    public final void bRP() {
        if (this.tGN != null) {
            this.tGN.post(new 27(this));
        }
    }

    public final void bRO() {
        if (this.tGM != null) {
            this.tGM.clear();
        }
    }

    public final void ao(Map<String, Object> map) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
            ag.y(new 29(this, i$a.a("onSelectContact", (Map) map, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
    }

    public final void b(String str, boolean z, String str2) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("json", str);
            hashMap.put("newQuery", Boolean.valueOf(z));
            hashMap.put("requestId", str2);
            ag.y(new 35(this, i$a.a("onSearchDataReady", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
    }

    public final void a(String str, boolean z, String str2, String str3) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
            Map hashMap = new HashMap();
            hashMap.put("eventId", str);
            hashMap.put("widgetId", str3);
            hashMap.put("hitTest", Boolean.valueOf(z));
            hashMap.put("err_msg", str2);
            ag.y(new 38(this, i$a.a("onSearchWAWidgetOnTapCallback", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
    }

    public final void cJ(String str, int i) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("state", Integer.valueOf(i));
            ag.y(new 42(this, i$a.a("onSearchWAWidgetStateChange", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
    }

    public final void a(String str, String str2, JSONArray jSONArray) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[]{str, str2, jSONArray.toString()});
            Map hashMap = new HashMap();
            hashMap.put("query", str);
            hashMap.put("custom", str2);
            hashMap.put("tagList", jSONArray);
            hashMap.put("isCancelButtonClick", Integer.valueOf(0));
            ag.y(new 45(this, i$a.a("onSearchInputChange", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
    }

    public final void b(String str, String str2, JSONArray jSONArray) {
        Map hashMap = new HashMap();
        hashMap.put("query", str);
        hashMap.put("custom", str2);
        hashMap.put("tagList", jSONArray);
        a("onSearchInputChange", hashMap, null);
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, Map<String, Object> map, Map<String, Object> map2) {
        JSONObject jSONObject = new JSONObject();
        if (map2 != null) {
            for (Entry entry : map2.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                    } catch (Throwable e) {
                        Throwable th = e;
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                        } catch (JSONException e2) {
                            try {
                                jSONObject.put((String) entry.getKey(), entry.getValue());
                            } catch (JSONException e3) {
                                x.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                            }
                        }
                    }
                }
            }
        }
        try {
            for (Entry entry2 : map.entrySet()) {
                jSONObject.put((String) entry2.getKey(), entry2.getValue());
            }
        } catch (Throwable e4) {
            x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
        }
        try {
            jSONObject.put("scene", str);
            jSONObject.put(DownloadSettingTable$Columns.TYPE, str2);
            jSONObject.put("isSug", str3);
            jSONObject.put("isLocalSug", str4);
            jSONObject.put("sessionId", str5);
        } catch (Throwable e42) {
            x.printErrStackTrace("MicroMsg.JsApiHandler", e42, "", new Object[0]);
        }
        a("switchToTabSearch", null, jSONObject);
        return true;
    }

    public final void a(String str, Map<String, Object> map, JSONObject jSONObject) {
        if (!this.tGQ || (map == null && jSONObject == null)) {
            x.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[]{str});
            return;
        }
        String a;
        String str2 = "MicroMsg.JsApiHandler";
        String str3 = "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = map == null ? "" : map.toString();
        objArr[2] = jSONObject == null ? "" : jSONObject.toString();
        x.i(str2, str3, objArr);
        if (map != null) {
            a = i$a.a(str, (Map) map, this.tGS, this.tGT);
        } else {
            a = i$a.a(str, jSONObject, this.tGS, this.tGT);
        }
        ag.y(new 46(this, a, str));
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, JSONArray jSONArray, String str8, int i, Map<String, Object> map) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "switchToTabSearch success, ready %s %s %s %s %s", new Object[]{str, str2, str3, str4, str5});
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                        } catch (Throwable e) {
                            Throwable th = e;
                            try {
                                jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                            } catch (JSONException e2) {
                                try {
                                    jSONObject.put((String) entry.getKey(), entry.getValue());
                                } catch (JSONException e3) {
                                    x.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                                }
                            }
                        }
                    }
                }
            }
            try {
                jSONObject.put(DownloadSettingTable$Columns.TYPE, str);
                jSONObject.put("isMostSearchBiz", str2);
                jSONObject.put("isSug", str3);
                jSONObject.put("isLocalSug", str5);
                jSONObject.put("scene", str4);
                jSONObject.put("query", str6);
                jSONObject.put("custom", str7);
                jSONObject.put("tagList", jSONArray);
                jSONObject.put("isBackButtonClick", 0);
                jSONObject.put("sugId", str8);
                jSONObject.put("sugClickType", i);
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            final String a = i$a.a("switchToTabSearch", jSONObject, this.tGS, this.tGT);
            ag.y(new Runnable(this) {
                final /* synthetic */ d tHd;

                public final void run() {
                    try {
                        this.tHd.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return true;
        }
        x.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, not ready");
        return false;
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i, Map<String, Object> map) {
        String str3 = "";
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[]{str, str2, jSONArray.toString()});
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                        } catch (Throwable e) {
                            Throwable th = e;
                            try {
                                jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                            } catch (JSONException e2) {
                                try {
                                    jSONObject.put((String) entry.getKey(), entry.getValue());
                                } catch (JSONException e3) {
                                    x.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                                }
                            }
                        }
                    }
                }
            }
            try {
                jSONObject.put("query", str);
                jSONObject.put("custom", str2);
                jSONObject.put("tagList", jSONArray);
                jSONObject.put("isBackButtonClick", i);
                jSONObject.put("sugId", str3);
                jSONObject.put("sugClickType", 0);
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            ag.y(new 48(this, i$a.a("onSearchInputConfirm", jSONObject, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
    }

    public final void PD(String str) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("json", str);
            ag.y(new 49(this, i$a.a("onSearchSuggestionDataReady", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
    }

    public final void aO(int i, String str) {
        if (this.tGQ) {
            Map hashMap = new HashMap();
            hashMap.put("ret", Integer.valueOf(i));
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
            ag.y(new 50(this, i$a.a("onSearchImageListReady", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
    }

    public final void g(int i, String str, int i2) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("requestType", Integer.valueOf(i));
            hashMap.put("json", str);
            hashMap.put("isCacheData", Integer.valueOf(i2));
            ag.y(new 51(this, i$a.a("onTeachSearchDataReady", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
    }

    public final void cK(String str, int i) {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
            Map hashMap = new HashMap();
            hashMap.put("snsid", str);
            hashMap.put(DownloadInfo.STATUS, Integer.valueOf(i));
            ag.y(new 53(this, i$a.a("onMusicStatusChanged", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
    }

    public static String PE(String str) {
        return String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[]{bh.ou(str)});
    }

    public final void kB(boolean z) {
        x.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[]{Boolean.valueOf(this.tGQ)});
        if (this.tGK != null && this.juQ != null && this.tGQ) {
            if (z) {
                this.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:get_html_content", new HashMap(), this.tGS, this.tGT) + ")", null);
                return;
            }
            List bSc;
            try {
                bSc = this.juQ.bSc();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                bSc = null;
            }
            Uri parse = Uri.parse(this.tGK.getUrl());
            if (parse != null) {
                x.d("MicroMsg.JsApiHandler", "wv hijack url host" + parse.getHost());
            }
            if (bSc != null && parse != null && bSc.contains(parse.getHost())) {
                this.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:get_html_content", new HashMap(), this.tGS, this.tGT) + ")", null);
            }
        }
    }

    public final void bUs() {
        if (this.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
            Map hashMap = new HashMap();
            hashMap.put("needShow", Boolean.valueOf(true));
            ag.y(new 57(this, i$a.a("showLoading", hashMap, this.tGS, this.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
    }

    public final void PF(String str) {
        if (!bh.ov(str)) {
            Map hashMap = new HashMap();
            hashMap.put(DownloadInfo.NETTYPE, str);
            ag.y(new 59(this, i$a.a(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME, hashMap, this.tGS, this.tGT)));
        }
    }

    public final long bUt() {
        x.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[]{Long.valueOf(this.tHc)});
        return this.tHc;
    }

    private String PG(String str) {
        String url = this.tGK.getUrl();
        try {
            x.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[]{url, str, com.tencent.mm.compatible.util.e.gHx + m.bX(url + str)});
            return com.tencent.mm.compatible.util.e.gHx + m.bX(url + str);
        } catch (Throwable e) {
            x.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is " + url);
            x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
            return null;
        }
    }

    private static boolean p(String str, Map<String, Integer> map) {
        Throwable e;
        OutputStream bufferedOutputStream;
        if (bh.ov(str) || map == null) {
            x.w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                x.e("MicroMsg.JsApiHandler", "creating file failed, filePath is " + str);
                x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                for (String str2 : map.keySet()) {
                    bufferedOutputStream.write((((Integer) map.get(str2)).intValue() + " " + str2).getBytes());
                    bufferedOutputStream.write(13);
                    bufferedOutputStream.write(10);
                }
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                }
                x.d("MicroMsg.JsApiHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e3) {
                e22 = e3;
                outputStream = bufferedOutputStream;
                try {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                    x.w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e222) {
                            x.printErrStackTrace("MicroMsg.JsApiHandler", e222, "", new Object[0]);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e222 = th;
                    bufferedOutputStream = outputStream;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
                        }
                    }
                    throw e222;
                }
            } catch (Throwable th2) {
                e222 = th2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw e222;
            }
        } catch (Exception e5) {
            e222 = e5;
            x.printErrStackTrace("MicroMsg.JsApiHandler", e222, "", new Object[0]);
            x.w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
                outputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            e222 = th3;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw e222;
        }
    }

    private static boolean eS(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            x.w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                Throwable e2;
                x.e("MicroMsg.JsApiHandler", "creating file failed, filePath is " + str);
                x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                outputStream = new FileOutputStream(str);
                outputStream.write(str2.getBytes());
                outputStream.write(13);
                outputStream.write(10);
                outputStream.flush();
                try {
                    outputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e3, "", new Object[0]);
                }
                x.d("MicroMsg.JsApiHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e4) {
                e2 = e4;
                outputStream = bufferedOutputStream;
                try {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    x.w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                        return false;
                    }
                    try {
                        outputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.JsApiHandler", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                outputStream = bufferedOutputStream;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e22;
            }
        } catch (Exception e5) {
            e22 = e5;
            x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
            x.w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
                return false;
            }
            outputStream.close();
            return false;
        }
    }
}
