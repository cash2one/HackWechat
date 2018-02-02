package com.tencent.mm.plugin.aj;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import com.tencent.mm.plugin.game.gamewebview.b.a.c;
import com.tencent.mm.plugin.game.gamewebview.b.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e implements a {
    String TAG = "MicroMsg.WebViewPreLoadMgr";
    private ag hOa;
    private boolean jJr = false;
    private HashSet<Object> jJt = new HashSet();
    int tjB;
    boolean tjC;
    List<c> tjD = new LinkedList();
    long tjE;

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ e tjF;
        final /* synthetic */ String val$url;

        AnonymousClass7(e eVar, String str) {
            this.tjF = eVar;
            this.val$url = str;
        }

        public final void run() {
            e eVar = this.tjF;
            String str = this.val$url;
            try {
                x.i(eVar.TAG, "preLoadWebView cached webview size %d", Integer.valueOf(eVar.tjD.size()));
                if (eVar.tjD.size() <= 0) {
                    eVar.tjE = System.currentTimeMillis();
                    WebView cn = com.tencent.mm.ui.widget.MMWebView.a.cn(new MutableContextWrapper(ac.getContext()));
                    eVar.tjC = false;
                    x.i(eVar.TAG, "preload %s", cn.toString());
                    cn.zvC = true;
                    cn.tGT = bh.Dg(16);
                    cn.getSettings().setJavaScriptEnabled(true);
                    cn.getSettings().setPluginsEnabled(true);
                    cn.getSettings().cIw();
                    cn.getSettings().setBuiltInZoomControls(false);
                    cn.getSettings().setUseWideViewPort(true);
                    cn.getSettings().setLoadWithOverviewMode(true);
                    cn.getSettings().cIr();
                    cn.getSettings().cIq();
                    cn.getSettings().setGeolocationEnabled(true);
                    cn.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    cn.getSettings().cIy();
                    cn.getSettings().cIu();
                    cn.getSettings().setAppCachePath(cn.getContext().getDir("webviewcache", 0).getAbsolutePath());
                    cn.getSettings().cIt();
                    cn.getSettings().cIv();
                    cn.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.gZJ + "databases/");
                    b.cIj().cIk();
                    b.cIj().b(cn);
                    cn.getSettings().setUserAgentString(f.aL(cn.getContext(), cn.getSettings().getUserAgentString()));
                    b bVar = new b();
                    cn.addJavascriptInterface(bVar, "__wx");
                    cn.loadUrl(str);
                    cn.setWebViewClient(new 2(eVar, cn));
                    Uri parse = Uri.parse(str);
                    eVar.tjD.add(new c(cn, parse.getQueryParameter("sessionId"), parse.getQueryParameter("subSessionId"), bVar));
                    g.pQN.h(15005, Integer.valueOf(eVar.tjB), Integer.valueOf(1), Integer.valueOf(0));
                }
            } catch (Throwable e) {
                x.printErrStackTrace(eVar.TAG, e, "", new Object[0]);
            }
            this.tjF.done();
        }
    }

    public static class a {
        static String e(String str, String str2, Map<String, Object> map) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("__msg_type", str);
                if (str.equals("event")) {
                    jSONObject.put("__event_id", str2);
                }
                jSONObject.put("__params", U(map));
                return jSONObject.toString();
            } catch (Exception e) {
                x.e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + e.getMessage());
                return null;
            }
        }

        private static JSONObject U(Map<String, Object> map) {
            if (map == null || map.size() == 0) {
                return new JSONObject();
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str : map.keySet()) {
                    if (str != null) {
                        jSONObject.put(str, map.get(str));
                    }
                }
                return jSONObject;
            } catch (Exception e) {
                x.e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + e.getMessage());
                return null;
            }
        }
    }

    public e(int i) {
        this.tjB = i;
        this.TAG += "_" + i;
        this.hOa = new ag();
    }

    public final void NR(String str) {
        if (!ac.cfy()) {
            x.w(this.TAG, "preload please call from tools proc");
        } else if (!ac.cfy()) {
            x.w(this.TAG, "preload please call from tools proc");
        } else if (!ag.isMainThread()) {
            x.w(this.TAG, "preload please call from main thread");
        } else if (!this.jJr) {
            this.jJr = true;
            x.i(this.TAG, "preloading");
            this.hOa.F(new 1(this, str));
        }
    }

    final boolean a(MMWebView mMWebView) {
        String convertStreamToString;
        x.i(this.TAG, "begin jsapi init,wv %s", mMWebView.toString());
        try {
            convertStreamToString = bh.convertStreamToString(mMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "", new Object[0]);
            convertStreamToString = null;
        }
        if (convertStreamToString == null) {
            x.e(this.TAG, "loadJavaScript fail, jsContent is null");
            return false;
        } else if (mMWebView == null) {
            x.e(this.TAG, "loadJavaScript, viewWV is null");
            return false;
        } else {
            mMWebView.evaluateJavascript("javascript:" + convertStreamToString, new 3(this, mMWebView));
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            Map hashMap = new HashMap();
            hashMap.put("webview_type", "1");
            hashMap.put("init_url", mMWebView.getUrl());
            hashMap.put("init_font_size", "1");
            String str = mMWebView.tGT;
            mMWebView.evaluateJavascript(stringBuilder.append(a.e("event", "sys:init", hashMap)).append(")").toString(), new 4(this, mMWebView));
            stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            String str2 = mMWebView.tGT;
            mMWebView.evaluateJavascript(stringBuilder.append(a.e("event", "sys:bridged", null)).append(")").toString(), new 5(this, mMWebView));
            stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            convertStreamToString = "sys:attach_runOn3rd_apis";
            hashMap = new HashMap();
            Collection linkedList = new LinkedList();
            linkedList.add("menu:share:timeline");
            linkedList.add("menu:share:appmessage");
            linkedList.add("menu:share:weiboApp");
            linkedList.add("menu:share:QZone");
            linkedList.add("menu:share:qq");
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
            linkedList.add(c.NAME);
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
            linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
            linkedList.add("showLoading");
            linkedList.add("getSearchEmotionDataCallBack");
            linkedList.add("onNavigationBarRightButtonClick");
            linkedList.add("onSearchActionSheetClick");
            linkedList.add("onGetMatchContactList");
            linkedList.add("onUiInit");
            linkedList.add(d.NAME);
            linkedList.add("onBackgroundAudioStateChange");
            if (!bh.cA(null)) {
                linkedList.addAll(null);
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            String str3 = mMWebView.tGT;
            mMWebView.evaluateJavascript(stringBuilder.append(a.e("event", convertStreamToString, hashMap)).append(")").toString(), new 6(this, mMWebView));
            x.i(this.TAG, "jsapi init done");
            return true;
        }
    }

    public final Object dL(Context context) {
        if (ac.cfy()) {
            x.i(this.TAG, "getWebView cached webview size %d", Integer.valueOf(this.tjD.size()));
            if (this.tjD.size() <= 0) {
                return null;
            }
            if (this.tjC) {
                c cVar = (c) this.tjD.get(0);
                if (cVar == null) {
                    this.tjD.remove(0);
                    return null;
                }
                MMWebView mMWebView = (MMWebView) cVar.tjr;
                if (mMWebView.getContext() instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) mMWebView.getContext()).setBaseContext(context);
                }
                this.tjD.remove(cVar);
                this.tjC = false;
                return cVar;
            }
            x.i(this.TAG, "preload unfinished");
            return null;
        }
        x.w(this.TAG, "getWebView please call from tools proc");
        return null;
    }

    final synchronized void done() {
        x.i(this.TAG, "preInit finished");
        this.jJr = false;
        Iterator it = this.jJt.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.jJt.clear();
    }
}
