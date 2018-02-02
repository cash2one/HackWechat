package com.tencent.mm.plugin.webview.stub;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.bc.g;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelstat.a.b.1;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.webview.fts.k;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.plugin.webview.model.y$a;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aff;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.atr;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.protocal.c.bgp;
import com.tencent.mm.protocal.c.bgq;
import com.tencent.mm.protocal.c.xd;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.protocal.c.xh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.R$styleable;

public class WebViewStubService extends Service implements e {
    private List<WebViewStubCallbackWrapper> fvF = new ArrayList();
    private c gLY = new 2(this);
    private af handler;
    private n mEF;
    private Map<String, Integer> mXU;
    private o tvA;
    private com.tencent.mm.plugin.webview.model.c.a tvB;
    private Set<Integer> tvC = new HashSet();
    private int tvD = -1;
    private d$a tvy = new d$a(this) {
        final /* synthetic */ WebViewStubService tvE;

        {
            this.tvE = r1;
        }

        public final void q(int i, Bundle bundle) {
            com.tencent.mm.plugin.webview.c.a bRw = f.bRw();
            Map hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.get(str));
            }
            switch (i) {
                case 1:
                    bRw.V(hashMap);
                    return;
                default:
                    x.w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", Integer.valueOf(i));
                    return;
            }
        }

        public final void h(int i, Bundle bundle) {
            e bRy = f.bRy();
            switch (i) {
                case 1:
                    bRy.tmi.remove(Integer.valueOf(bundle.getInt("webview_id")));
                    com.tencent.mm.plugin.webview.fts.e.e eVar = bRy.tmo;
                    if (!(!eVar.tmI) || bh.ov(eVar.fDj)) {
                        x.v("MicroMsg.FTS.FTSWebViewLogic", "can not report %s", eVar.fDj);
                    } else {
                        x.v("MicroMsg.FTS.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", Boolean.valueOf(eVar.tmI), eVar.fDj, Boolean.valueOf(eVar.foh), Boolean.valueOf(eVar.tmJ), Integer.valueOf(eVar.mPx));
                        g.a(eVar.scene, eVar.fDj, eVar.tmJ, eVar.foh, eVar.mPx);
                        eVar.tmI = true;
                    }
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "activity destroy %d", Integer.valueOf(r4));
                    return;
                case 3:
                    if (bRy.mMa != null) {
                        ((m) com.tencent.mm.kernel.g.k(m.class)).cancelSearchTask(bRy.mMa);
                    }
                    com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
                    gVar.fDj = bundle.getString("query");
                    gVar.mLW = bundle.getInt("count");
                    gVar.mLZ = bRy.phA;
                    bRy.mMa = ((m) com.tencent.mm.kernel.g.k(m.class)).search(8, gVar);
                    bRy.mMa.mLn = Integer.valueOf(bundle.getInt("webview_id"));
                    d dVar = new d();
                    dVar.scene = bundle.getInt("scene");
                    dVar.fod = bundle.getString("query");
                    dVar.tjP = 1;
                    dVar.fDl = bundle.getInt("webview_id");
                    if (bRy.tml != null) {
                        ar.CG().c(bRy.tml);
                    }
                    bRy.tml = new k(dVar);
                    ar.CG().a(1161, bRy);
                    ar.CG().a(bRy.tml, 0);
                    return;
                case 5:
                    ((m) com.tencent.mm.kernel.g.k(m.class)).deleteSOSHistory(bundle.getString("history"));
                    return;
                default:
                    return;
            }
        }

        public final Bundle o(int i, Bundle bundle) {
            f.bRy();
            return com.tencent.mm.plugin.webview.fts.e.o(i, bundle);
        }

        public final String gu(String str) {
            ar.Hg();
            return com.tencent.mm.z.c.EY().WO(str).AP();
        }

        public final boolean gE(String str) {
            return s.gE(str);
        }

        public final boolean hn(String str) {
            return s.hn(str);
        }

        public final boolean gF(String str) {
            boolean Hj = ar.Hj();
            x.i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = " + Hj);
            if (Hj) {
                return s.gF(str);
            }
            return false;
        }

        public final boolean ze() {
            return com.tencent.mm.compatible.util.f.ze();
        }

        public final boolean aOD() {
            return ar.Hj();
        }

        @Deprecated
        public final void a(int i, Bundle bundle, int i2) {
            x.i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", Integer.valueOf(i), Integer.valueOf(i2));
            this.tvE.handler.post(new 1(this, i, bundle, i2));
        }

        public final b R(Bundle bundle) {
            boolean a;
            Object aVar = new a();
            long j = bundle.getLong("msg_id", Long.MIN_VALUE);
            String string = bundle.getString("sns_local_id");
            int i = bundle.getInt("news_svr_id", 0);
            String string2 = bundle.getString("news_svr_tweetid");
            b cfVar = new cf();
            if (Long.MIN_VALUE != j) {
                cfVar.fqp.fqt = bundle.getInt("message_index", 0);
                a = com.tencent.mm.pluginsdk.model.f.a(cfVar, j);
            } else if (!bh.ov(string)) {
                b qnVar = new qn();
                qnVar.fIc.fIf = string;
                qnVar.fIc.fIg = cfVar;
                qnVar.fIc.url = bundle.getString("rawUrl");
                qnVar.fIc.fIe = true;
                com.tencent.mm.sdk.b.a.xef.m(qnVar);
                a = qnVar.fId.fpW;
            } else if (i != 0) {
                b mhVar = new mh();
                mhVar.fEe.opType = 3;
                mhVar.fEe.fEg = cfVar;
                mhVar.fEe.fEh = i;
                mhVar.fEe.fEi = string2;
                com.tencent.mm.sdk.b.a.xef.m(mhVar);
                a = mhVar.fEf.fpW;
            } else {
                aVar.mXH = true;
                return aVar;
            }
            if (a) {
                string = bh.ou(bundle.getString("prePublishId"));
                String hz = u.hz(string);
                u.b t = u.GK().t(hz, true);
                t.o("sendAppMsgScene", Integer.valueOf(2));
                t.o("preChatName", bundle.getString("preChatName"));
                t.o("preMsgIndex", Integer.valueOf(bundle.getInt("preMsgIndex")));
                t.o("prePublishId", string);
                t.o("preUsername", bundle.getString("preUsername"));
                t.o("getA8KeyScene", bundle.getString("getA8KeyScene"));
                t.o("referUrl", bundle.getString("referUrl"));
                Bundle bundle2 = bundle.getBundle("jsapiargs");
                if (bundle2 != null) {
                    t.o("adExtStr", bundle2.getString("key_snsad_statextstr"));
                }
                cfVar.fqp.fqu = hz;
                com.tencent.mm.sdk.b.a.xef.m(cfVar);
            } else {
                if (cfVar.fqp.fqv == 0) {
                    cfVar.fqp.fqv = R.l.efp;
                }
                com.tencent.mm.sdk.b.a.xef.m(cfVar);
            }
            aVar.ret = cfVar.fqq.ret;
            return aVar;
        }

        public final String OM(String str) {
            return com.tencent.mm.ad.b.iW(str);
        }

        public final boolean isSDCardAvailable() {
            ar.Hg();
            return com.tencent.mm.z.c.isSDCardAvailable();
        }

        public final int ek(int i, int i2) {
            ar.Hg();
            return bh.a((Integer) com.tencent.mm.z.c.CU().get(i, null), i2);
        }

        public final void el(int i, int i2) {
            this.tvE.handler.post(new 3(this, i, i2));
        }

        public final String aN(int i, String str) {
            ar.Hg();
            return bh.az((String) com.tencent.mm.z.c.CU().get(i, null), str);
        }

        public final boolean r(int i, Bundle bundle) {
            x.i("MicroMsg.WebViewStubService", "doScene, type = %d", Integer.valueOf(i));
            com.tencent.mm.ae.k lVar;
            switch (i) {
                case 233:
                    if (aOD()) {
                        String string = bundle.getString("geta8key_data_req_url");
                        if (!bh.ov(bundle.getString("k_share_url"))) {
                            ak.eL(string, bundle.getString("k_share_url"));
                        }
                        lVar = !bh.ov(string) ? new l(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getInt("geta8key_session_id", 0), bundle.getString("geta8key_data_appid"), bundle.getString("key_function_id"), bundle.getInt("key_wallet_region", 0), bundle.getByteArray("k_a8key_cookie")) : new l(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0));
                        lVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        return ar.CG().a(lVar, 0);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 666:
                    if (aOD()) {
                        return WebViewStubService.Q(bundle);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 673:
                    if (aOD()) {
                        com.tencent.mm.ae.k jVar = new j(bundle.getString("reading_mode_data_url"), bundle.getString("reading_mode_data_useragent"), bundle.getInt("reading_mode_data_width"), bundle.getInt("reading_mode_data_height"));
                        jVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        return ar.CG().a(jVar, 0);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 1254:
                    if (aOD()) {
                        com.tencent.mm.ae.k rVar = new r(bundle.getString("oauth_url"), bundle.getString("biz_username"), bundle.getInt("scene"));
                        rVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        return ar.CG().a(rVar, 0);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 1373:
                    if (aOD()) {
                        String string2 = bundle.getString("oauth_url");
                        int i2 = bundle.getInt("opt");
                        LinkedList linkedList = new LinkedList(bundle.getStringArrayList("scopes"));
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i3 = 0; i3 < linkedList.size(); i3++) {
                            stringBuilder.append((String) linkedList.get(i3)).append(",");
                        }
                        x.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
                        lVar = new com.tencent.mm.plugin.webview.model.s(string2, i2, linkedList);
                        lVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        return ar.CG().a(lVar, 0);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 2836:
                    if (aOD()) {
                        return WebViewStubService.a(this.tvE, bundle);
                    }
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                default:
                    x.e("MicroMsg.WebViewStubService", "doScene fail, invalid type = %d", Integer.valueOf(i));
                    return false;
            }
        }

        public final boolean LU() {
            return com.tencent.mm.ag.f.LU();
        }

        public final List<String> LT() {
            List<String> LT = com.tencent.mm.ag.f.LT();
            List<String> linkedList = new LinkedList();
            for (String str : LT) {
                if (!com.tencent.mm.ag.f.jV(str)) {
                    linkedList.add(str);
                }
            }
            return linkedList;
        }

        public final void f(int i, List<String> list) {
            com.tencent.mm.plugin.report.service.g.pQN.d(i, list);
        }

        public final boolean a(String str, boolean z, Bundle bundle) {
            return com.tencent.mm.pluginsdk.q.a.vcy.a(this.tvE, str, z, bundle);
        }

        public final String ON(String str) {
            if (com.tencent.mm.pluginsdk.q.a.vcz != null) {
                return com.tencent.mm.pluginsdk.q.a.vcz.o(this.tvE, str);
            }
            return null;
        }

        public final void cx(String str, int i) {
            new Bundle().putInt("webview_binder_id", i);
            WebViewStubService.a(this.tvE, 5, null, i);
        }

        public final void aP(String str, boolean z) {
            com.tencent.mm.pluginsdk.q.a.vcy.a(this.tvE, str, z);
        }

        public final boolean Gz() {
            return q.Gz();
        }

        public final void i(String str, boolean z, int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Be = h.Be(i);
            if (!bh.ov(str)) {
                x.i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", str);
                Be.maM = false;
                Be.mWj.add(str);
                if (z) {
                    Be.tHr.add(str);
                }
            }
        }

        public final Bundle As(int i) {
            return h.Be(i).bUv();
        }

        public final boolean At(int i) {
            boolean z = h.Be(i).maM;
            if (z) {
                x.w("MicroMsg.WebViewStubService", "isBusy, doingFunction = " + h.Be(i).tHw);
            }
            return z;
        }

        public final void E(String str, String str2, int i) {
            h.Be(i).bUv().putString(str, str2);
        }

        public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
            boolean OL = WebViewStubService.OL(str2);
            x.i("MicroMsg.WebViewStubService", "handleMsg, function = " + str2 + ", doInActivity = " + OL);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            if (OL) {
                WebViewStubService.a(this.tvE, str, str2, str3, jsapiPermissionWrapper, bundle2, i);
                return true;
            }
            i iVar = new i();
            iVar.type = str;
            iVar.tJI = str2;
            iVar.tJG = str3;
            iVar.pox = i.aa(bundle2);
            e eVar = null;
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.tvE.fvF) {
                e eVar2;
                if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i) {
                    eVar2 = eVar;
                } else {
                    eVar2 = webViewStubCallbackWrapper.tyk;
                }
                eVar = eVar2;
            }
            h.Be(i).a(this.tvE, eVar);
            OL = h.Be(i).a(iVar, jsapiPermissionWrapper);
            x.i("MicroMsg.WebViewStubService", "handleRet = " + OL);
            return OL;
        }

        public final void a(String str, Bundle bundle, int i) {
            Bundle bundle2 = new Bundle();
            Parcelable jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            bundle2.putParcelable("proxyui_perm_key", jsapiPermissionWrapper);
            bundle2.putString("proxyui_username_key", str);
            bundle2.putInt("webview_binder_id", i);
            WebViewStubService.a(this.tvE, 4, bundle2, i);
        }

        public final void OO(String str) {
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, false);
            if (aZ != null && bh.ov(aZ.field_openId)) {
                x.i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = " + str);
                b gyVar = new gy();
                gyVar.fxg.appId = str;
                com.tencent.mm.sdk.b.a.xef.m(gyVar);
            }
        }

        public final String OP(String str) {
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, false);
            return aZ == null ? null : aZ.field_packageName;
        }

        public final boolean cG(String str) {
            return com.tencent.mm.pluginsdk.q.a.vcz.cG(str);
        }

        public final void ab(int i, int i2, int i3) {
            Bundle bundle = new Bundle();
            bundle.putInt("proxyui_expired_errtype", i);
            bundle.putInt("proxyui_expired_errcode", i2);
            WebViewStubService.a(this.tvE, 6, bundle, i3);
        }

        public final boolean OQ(String str) {
            return com.tencent.mm.bm.d.OQ(str);
        }

        public final void Au(int i) {
            x.i("MicroMsg.WebViewStubService", "removeCallback, id = %d", Integer.valueOf(i));
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.tvE.fvF) {
                if (webViewStubCallbackWrapper.id == i) {
                    this.tvE.fvF.remove(webViewStubCallbackWrapper);
                    return;
                }
            }
        }

        public final void a(e eVar, int i) {
            x.i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", Integer.valueOf(eVar.hashCode()), Integer.valueOf(i));
            this.tvE.fvF.add(new WebViewStubCallbackWrapper(eVar, i));
            h.Be(i);
        }

        public final String[] bRQ() {
            String F = com.tencent.mm.k.g.zZ().F("WebViewConfig", "removeJavascriptInterface");
            return bh.ov(F) ? null : F.split(";");
        }

        public final boolean S(Bundle bundle) {
            b caVar = new ca();
            caVar.fqi.fqk = bundle.getLong("fav_local_id", -1);
            com.tencent.mm.sdk.b.a.xef.m(caVar);
            x.i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", Long.valueOf(caVar.fqi.fqk), Boolean.valueOf(caVar.fqj.fpW));
            return caVar.fqj.fpW;
        }

        public final String bRR() {
            ar.Hg();
            return (String) com.tencent.mm.z.c.CU().get(-1535680990, null);
        }

        public final String BP(String str) {
            return ak.BP(str);
        }

        public final String bRS() {
            return w.d(this.tvE.getSharedPreferences(ac.cfs(), 0));
        }

        public final String OR(String str) {
            boolean Hj = ar.Hj();
            x.i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = " + Hj);
            if (Hj) {
                return com.tencent.mm.k.g.zY().getValue(str);
            }
            return (String) new 4(this, str).b(this.tvE.handler);
        }

        public final void OS(final String str) {
            boolean Hj = ar.Hj();
            x.i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = " + Hj);
            bc anonymousClass5 = new bc<Void>(this) {
                final /* synthetic */ AnonymousClass1 tvH;

                protected final /* synthetic */ Object run() {
                    if (ar.Hj()) {
                        ar.Hg();
                        com.tencent.mm.l.a WO = com.tencent.mm.z.c.EY().WO(str);
                        if (WO == null || ((int) WO.gJd) <= 0) {
                            com.tencent.mm.z.ak.a.hfL.a(str, "", null);
                        } else {
                            x.v("MicroMsg.WebViewStubService", "triggerGetContact, already exist, no need to getcontact");
                        }
                    }
                    return null;
                }
            };
            if (Hj) {
                anonymousClass5.b(null);
            } else {
                anonymousClass5.b(this.tvE.handler);
            }
        }

        public final String cy(String str, int i) {
            switch (i) {
                case 1:
                    return ai.Os(str);
                case 2:
                    WebViewJSSDKFileItem Oo = f.bRB().Oo(str);
                    if (Oo != null) {
                        x.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", Oo.jip);
                        return Oo.iLu;
                    }
                    x.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", str);
                    return null;
                default:
                    return null;
            }
        }

        public final int OT(String str) {
            b cfVar = new cf();
            com.tencent.mm.pluginsdk.model.f.a(cfVar, 1, str);
            com.tencent.mm.sdk.b.a.xef.m(cfVar);
            return cfVar.fqq.ret;
        }

        public final void favEditTag() {
            b fvVar = new fv();
            fvVar.fvq.type = 35;
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
        }

        public final boolean r(long j, String str) {
            if (j == Long.MIN_VALUE && str == null) {
                return false;
            }
            b dhVar = new dh();
            if (j != Long.MIN_VALUE) {
                dhVar.frQ.fqm = j;
            }
            if (str != null) {
                dhVar.frQ.frH = str;
            }
            com.tencent.mm.sdk.b.a.xef.m(dhVar);
            if (dhVar.frR.frp) {
                return true;
            }
            if (ar.Hj() && j != Long.MIN_VALUE) {
                ar.Hg();
                com.tencent.mm.g.b.cf dH = com.tencent.mm.z.c.Fa().dH(j);
                if (dH.getType() == 49) {
                    boolean eV = s.eV(dH.field_talker);
                    String str2 = dH.field_content;
                    int i = dH.field_isSend;
                    if (eV && str2 != null && i == 0) {
                        str2 = ba.hQ(str2);
                    }
                    com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str2);
                    if (fT.type == 3) {
                        return com.tencent.mm.pluginsdk.model.app.g.m(ac.getContext(), 16);
                    }
                    if (fT.type == 4) {
                        return com.tencent.mm.pluginsdk.model.app.g.m(ac.getContext(), 8);
                    }
                }
            }
            return false;
        }

        public final void OU(String str) {
            if (p.UR(str)) {
                EmojiInfo yc;
                EmojiInfo yc2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(com.tencent.mm.a.g.bV(str));
                if (yc2 == null || !yc2.cks()) {
                    yc = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yd(str));
                } else {
                    yc = yc2;
                }
                int bN = yc == null ? 0 : com.tencent.mm.a.e.bN(yc.ckB());
                if (yc != null) {
                    str = yc.ckB();
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                int i;
                if ((com.tencent.mm.sdk.platformtools.d.decodeFile(str, options) == null || options.outHeight <= com.tencent.mm.k.b.zE()) && options.outWidth <= com.tencent.mm.k.b.zE()) {
                    i = 0;
                } else {
                    i = true;
                }
                if (bN > com.tencent.mm.k.b.zF() || r0 != 0) {
                    com.tencent.mm.ui.base.h.a(ac.getContext(), this.tvE.getString(R.l.dZJ), "", this.tvE.getString(R.l.epk), null);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", yc == null ? "" : yc.Nr());
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                com.tencent.mm.plugin.webview.a.a.ifs.l(intent, this.tvE);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", str);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.plugin.webview.a.a.ifs.l(intent2, this.tvE);
        }

        public final String getLanguage() {
            return w.eL(ac.getContext());
        }

        public final String bRT() {
            b hmVar = new hm();
            com.tencent.mm.sdk.b.a.xef.m(hmVar);
            return hmVar.fxP.url;
        }

        public final Map bRU() {
            com.tencent.mm.k.d fQ = com.tencent.mm.k.g.zZ().fQ(1);
            return fQ == null ? null : fQ.gIg;
        }

        public final String eO(String str, String str2) {
            return "";
        }

        public final int bRV() {
            com.tencent.mm.kernel.g.Dh();
            return com.tencent.mm.kernel.a.Cg();
        }

        public final int bRW() {
            ar.Hg();
            return bh.e((Integer) com.tencent.mm.z.c.CU().get(12304, null));
        }

        public final void bRX() {
            Intent intent = new Intent();
            ar.Hg();
            String str = (String) com.tencent.mm.z.c.CU().get(2, null);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("sns_userName", str);
            intent.addFlags(67108864);
            ar.Hg();
            int a = bh.a((Integer) com.tencent.mm.z.c.CU().get(68389, null), 0);
            ar.Hg();
            com.tencent.mm.z.c.CU().set(68389, Integer.valueOf(a + 1));
            intent.setClassName(ac.getContext(), "com.tencent.mm.plugin.sns.ui.SnsUserUI");
            this.tvE.startActivity(intent);
        }

        public final void bRY() {
            if (((q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) && com.tencent.mm.bm.d.OQ("sns")) {
                Intent intent = new Intent();
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.addFlags(67108864);
                intent.setClassName(ac.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                this.tvE.startActivity(intent);
            }
        }

        public final void Aq(int i) {
            Iterator it;
            String str;
            if (this.tvE.fvF.size() == 0) {
                b ffVar = new ff();
                ffVar.fuq.fut = 2;
                com.tencent.mm.sdk.b.a.xef.m(ffVar);
                ffVar = new ez();
                ffVar.ftT.op = 2;
                com.tencent.mm.sdk.b.a.xef.m(ffVar);
                ffVar = new fc();
                ffVar.fua.op = 2;
                com.tencent.mm.sdk.b.a.xef.m(ffVar);
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Be = h.Be(i);
            x.d("MicroMsg.MsgHandler", "onWebViewUIDestroy");
            if (Be.bUB()) {
                WebViewJSSDKFileItem Oo = f.bRB().Oo(Be.tHW);
                if (Oo != null) {
                    ag.y(new g$68(Be, Oo));
                }
            }
            Entry entry;
            String str2;
            b daVar;
            if ((Be.bSd() == 8 || Be.bSd() == -1) && Be.aRr() != 27) {
                if (Be.bSd() == 8) {
                    if (Be.tHu == null || Be.tHu.isEmpty()) {
                        x.i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
                    } else {
                        it = Be.tHu.entrySet().iterator();
                        if (it != null) {
                            while (it.hasNext()) {
                                entry = (Entry) it.next();
                                str2 = (String) entry.getKey();
                                str = (String) entry.getValue();
                                x.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                                daVar = new da();
                                daVar.frs.fru = str2;
                                daVar.frs.ffq = str;
                                com.tencent.mm.sdk.b.a.xef.m(daVar);
                                if (!daVar.frt.frp) {
                                    try {
                                        daVar = new cy();
                                        daVar.frl.fro = false;
                                        daVar.frl.frn = str2;
                                        daVar.frl.ffq = str;
                                        com.tencent.mm.sdk.b.a.xef.m(daVar);
                                        x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                    } catch (Throwable e) {
                                        x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                        x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                                    }
                                }
                            }
                        }
                        Be.tHu.clear();
                    }
                }
            } else if ((Be.tHv == null || Be.tHv.isEmpty()) && (Be.tHu == null || Be.tHu.isEmpty())) {
                x.i("MicroMsg.MsgHandler", "No exdevice connection, just return");
            } else {
                if (!(Be.tHv == null || Be.tHv.isEmpty())) {
                    for (Entry entry2 : Be.tHv.entrySet()) {
                        x.i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", (String) entry2.getKey(), (String) entry2.getValue());
                        try {
                            daVar = new cz();
                            daVar.frq.fro = false;
                            daVar.frq.frn = str2;
                            daVar.frq.ffq = str;
                            com.tencent.mm.sdk.b.a.xef.m(daVar);
                            x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        } catch (Throwable e2) {
                            x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                            x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                        }
                    }
                    Be.tHv.clear();
                }
                if (!(Be.tHu == null || Be.tHu.isEmpty())) {
                    boolean z;
                    b daVar2;
                    Iterator it2 = Be.tHu.entrySet().iterator();
                    str = Be.bUA();
                    if (!bh.ov(str)) {
                        com.tencent.mm.ag.d jS = com.tencent.mm.ag.f.jS(str);
                        if (jS != null) {
                            com.tencent.mm.ag.d.b bI = jS.bI(false);
                            if (!(bI == null || bI.Ly() == null || !bI.Ly().LH())) {
                                z = true;
                                x.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", Boolean.valueOf(z));
                                if (it2 != null) {
                                    while (it2.hasNext()) {
                                        entry2 = (Entry) it2.next();
                                        str2 = (String) entry2.getKey();
                                        str = (String) entry2.getValue();
                                        x.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                                        if (z) {
                                            daVar2 = new da();
                                            daVar2.frs.fru = str2;
                                            daVar2.frs.ffq = str;
                                            com.tencent.mm.sdk.b.a.xef.m(daVar2);
                                            if (daVar2.frt.frp) {
                                            }
                                        }
                                        try {
                                            daVar2 = new cy();
                                            daVar2.frl.fro = false;
                                            daVar2.frl.frn = str2;
                                            daVar2.frl.ffq = str;
                                            com.tencent.mm.sdk.b.a.xef.m(daVar2);
                                            x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                        } catch (Throwable e22) {
                                            x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                            x.printErrStackTrace("MicroMsg.MsgHandler", e22, "", new Object[0]);
                                        }
                                    }
                                }
                                Be.tHu.clear();
                            }
                        }
                    }
                    z = false;
                    x.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", Boolean.valueOf(z));
                    if (it2 != null) {
                        while (it2.hasNext()) {
                            entry2 = (Entry) it2.next();
                            str2 = (String) entry2.getKey();
                            str = (String) entry2.getValue();
                            x.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                            if (z) {
                                daVar2 = new da();
                                daVar2.frs.fru = str2;
                                daVar2.frs.ffq = str;
                                com.tencent.mm.sdk.b.a.xef.m(daVar2);
                                if (daVar2.frt.frp) {
                                }
                            }
                            daVar2 = new cy();
                            daVar2.frl.fro = false;
                            daVar2.frl.frn = str2;
                            daVar2.frl.ffq = str;
                            com.tencent.mm.sdk.b.a.xef.m(daVar2);
                            x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        }
                    }
                    Be.tHu.clear();
                }
            }
            com.tencent.mm.plugin.webview.model.e bQA = e$a.trZ;
            if (bh.cA(bQA.trW)) {
                x.d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
            } else if (ar.Hj()) {
                List list;
                bQA.trT = com.tencent.mm.k.g.zY().getInt("MMUxAdLog2GSendSize", 20480);
                bQA.trU = com.tencent.mm.k.g.zY().getInt("MMUxAdLog3GSendSize", 30720);
                bQA.trV = com.tencent.mm.k.g.zY().getInt("MMUxAdLogWifiSendSize", 51200);
                x.d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", Integer.valueOf(bQA.trT), Integer.valueOf(bQA.trU), Integer.valueOf(bQA.trV));
                Collection<ano> collection = bQA.trW;
                if (bh.cA(collection)) {
                    x.d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
                    list = null;
                } else {
                    ano com_tencent_mm_protocal_c_ano;
                    int i2;
                    x.d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    x.d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.setLength(0);
                    stringBuilder.append("{ ");
                    for (ano com_tencent_mm_protocal_c_ano2 : collection) {
                        stringBuilder.append(com_tencent_mm_protocal_c_ano2.wuu).append(", ");
                    }
                    stringBuilder.append(" }");
                    x.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                    if (bh.bA(bQA.trY) >= 100 || bQA.trX <= 0) {
                        bQA.trY = SystemClock.elapsedRealtime();
                        int i3;
                        if (an.isWifi(ac.getContext())) {
                            i3 = bQA.trV;
                            bQA.trX = i3;
                            i2 = i3;
                        } else if (an.is3G(ac.getContext()) || an.is4G(ac.getContext())) {
                            i3 = bQA.trU;
                            bQA.trX = i3;
                            i2 = i3;
                        } else {
                            an.is2G(ac.getContext());
                            i3 = bQA.trT;
                            bQA.trX = i3;
                            i2 = i3;
                        }
                    } else {
                        i2 = bQA.trX;
                    }
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(collection);
                    List<List> linkedList2 = new LinkedList();
                    LinkedList linkedList3 = null;
                    int i4 = 0;
                    while (linkedList.size() > 0) {
                        if (i4 <= 0) {
                            linkedList3 = new LinkedList();
                            com_tencent_mm_protocal_c_ano2 = (ano) linkedList.remove();
                            i4 += com_tencent_mm_protocal_c_ano2.wuv.oz.length;
                            linkedList3.add(com_tencent_mm_protocal_c_ano2);
                            linkedList2.add(linkedList3);
                        } else if (((ano) linkedList.peek()).wuv.oz.length + i4 >= i2) {
                            i4 = 0;
                        } else {
                            com_tencent_mm_protocal_c_ano2 = (ano) linkedList.remove();
                            i4 += com_tencent_mm_protocal_c_ano2.wuv.oz.length;
                            linkedList3.add(com_tencent_mm_protocal_c_ano2);
                        }
                    }
                    x.d("MicroMsg.WebView.JsLogHelper", "split result: ");
                    for (List<ano> list2 : linkedList2) {
                        stringBuilder.setLength(0);
                        stringBuilder.append("{ ");
                        for (ano com_tencent_mm_protocal_c_ano22 : list2) {
                            stringBuilder.append(com_tencent_mm_protocal_c_ano22.wuu).append(", ");
                        }
                        stringBuilder.append(" }");
                        x.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                        x.d("MicroMsg.WebView.JsLogHelper", "---------------------------");
                    }
                    x.d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    list = linkedList2;
                }
                if (bh.cA(r0)) {
                    x.d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
                } else {
                    for (List list3 : r0) {
                        if (!bh.cA(list3)) {
                            x.d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
                            ar.CG().a(new com.tencent.mm.plugin.webview.model.p(list3), 0);
                        }
                    }
                    bQA.trW.clear();
                }
            } else {
                x.i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
            }
            if (Be.tHs != null) {
                Be.tHs.setClassLoader(Be.getClass().getClassLoader());
            }
            if (Be.tHs != null) {
                Parcelable parcelable = Be.tHs.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                    snsAdClick.Ss();
                    b niVar = new ni();
                    niVar.fFq.fFr = 1;
                    niVar.fFq.fFe = snsAdClick;
                    com.tencent.mm.sdk.b.a.xef.m(niVar);
                }
            }
            if (Be.tHs != null) {
                com.tencent.mm.modelsns.b m = com.tencent.mm.modelsns.b.m(Be.tHs);
                if (m != null) {
                    m.update();
                    m.Sx();
                }
            }
            for (String str3 : Be.tHV.keySet()) {
                if (!bh.ov(str3)) {
                    f.bRA();
                    com.tencent.mm.plugin.webview.model.ac.qh(str3);
                    g$b com_tencent_mm_plugin_webview_ui_tools_jsapi_g_b = (g$b) Be.tHV.get(str3);
                    if (com_tencent_mm_plugin_webview_ui_tools_jsapi_g_b != null) {
                        if (com_tencent_mm_plugin_webview_ui_tools_jsapi_g_b.tJC != null) {
                            f.bRA().a(com_tencent_mm_plugin_webview_ui_tools_jsapi_g_b.tJC);
                        }
                        if (com_tencent_mm_plugin_webview_ui_tools_jsapi_g_b.tHp != null) {
                            Be.a(com_tencent_mm_plugin_webview_ui_tools_jsapi_g_b.tHp, "uploadVideo:cancel", null, false);
                        }
                    }
                }
            }
            Be.tHV.clear();
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : com.tencent.mm.pluginsdk.ui.tools.r.ccP()) {
                x.i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + aVar.getName());
                aVar.bTo();
            }
            com.tencent.mm.pluginsdk.ui.tools.r.clear();
            com.tencent.mm.sdk.b.a.xef.c(Be.qsg);
            com.tencent.mm.sdk.b.a.xef.c(Be.tHU);
            com.tencent.mm.sdk.b.a.xef.c(Be.tIf);
            if (ar.Hj()) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN, Boolean.valueOf(false));
            }
            Editor edit = ac.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            Be.tHq = null;
            Be.tHT = null;
            Be.b(Be.tHp, new int[0]);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.tHz = null;
            if (com.tencent.mm.plugin.webview.ui.tools.jsapi.g.tHA != -1) {
                Be.tHp = Be.Ba(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.tHA).tHp;
                Be.tHp = null;
                Be.fBH = Be.Ba(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.tHA).fBH;
                Be.fBH = null;
            }
            Be.tHx = null;
            Be.tIb.clear();
            com.tencent.mm.plugin.webview.modelcache.q bRp = q$a.tue;
            List list4 = Be.tHX;
            if (!(com.tencent.mm.compatible.d.w.yV() == 0 || !ar.Hj() || bh.cA(list4))) {
                bRp.Dm().F(new q$5(bRp, list4));
            }
            q$a.tue.Aq(Be.fDl);
        }

        public final void cz(String str, int i) {
            Bundle bundle = new Bundle();
            bundle.putString("proxyui_phone", str);
            WebViewStubService.a(this.tvE, 8, bundle, i);
        }

        public final boolean bRZ() {
            return q.Gf();
        }

        public final void c(String str, int[] iArr) {
            if (this.tvE.mXU == null) {
                this.tvE.mXU = new HashMap();
                com.tencent.mm.sdk.b.a.xef.b(this.tvE.gLY);
            }
            b mpVar = new mp();
            mpVar.fEA.filePath = str;
            if (iArr != null && iArr.length > 0) {
                mpVar.fEA.fEB = new HashSet();
                for (int valueOf : iArr) {
                    mpVar.fEA.fEB.add(Integer.valueOf(valueOf));
                }
            }
            com.tencent.mm.sdk.b.a.xef.m(mpVar);
            this.tvE.mXU.put(str, Integer.valueOf(1));
        }

        public final void OV(String str) {
            if (this.tvE.mXU == null || !this.tvE.mXU.containsKey(str)) {
                x.e("MicroMsg.WebViewStubService", "%s is not recognizing", str);
                return;
            }
            b akVar = new com.tencent.mm.g.a.ak();
            akVar.fow.filePath = str;
            com.tencent.mm.sdk.b.a.xef.m(akVar);
            this.tvE.mXU.remove(str);
        }

        public final void g(String str, String str2, String str3, int i, int i2) {
            if (str != null) {
                Intent intent = new Intent();
                intent.setClass(ac.getContext(), WebviewScanImageActivity.class);
                intent.setFlags(872415232);
                intent.putExtra("key_string_for_scan", str);
                intent.putExtra("key_string_for_url", str2);
                intent.putExtra("key_string_for_image_url", str3);
                intent.putExtra("key_codetype_for_scan", i);
                intent.putExtra("key_codeversion_for_scan", i2);
                ac.getContext().startActivity(intent);
            }
        }

        public final String OW(String str) {
            String str2 = "";
            com.tencent.mm.pluginsdk.d.Rh(str);
            return str2;
        }

        public final boolean bSa() {
            if (AnonymousClass1.ok("EnableWebviewScanQRCode") == 1) {
                return true;
            }
            return false;
        }

        private static int ok(String str) {
            int i = 1;
            try {
                i = bh.getInt(com.tencent.mm.k.g.zY().getValue(str), 1);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: " + str);
            }
            return i;
        }

        public final void Av(int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Be = h.Be(i);
            Context context = this.tvE;
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : com.tencent.mm.pluginsdk.ui.tools.r.ccP()) {
                x.i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + aVar.getName());
                aVar.dP(context);
            }
            Be.tHC = false;
            if (Be.tHs != null) {
                Parcelable parcelable = Be.tHs.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    ((SnsAdClick) parcelable).Ss();
                }
            }
        }

        public final void Aw(int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Be = h.Be(i);
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : com.tencent.mm.pluginsdk.ui.tools.r.ccP()) {
                x.i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + aVar.getName());
                aVar.bTp();
            }
            if (Be.tHs != null) {
                Parcelable parcelable = Be.tHs.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    ((SnsAdClick) parcelable).hOC = bh.Wq();
                }
            }
        }

        public final Bundle e(int i, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            String ou;
            String string;
            Bundle bundle3;
            FileDownloadTaskInfo bY;
            int i2;
            Bundle bundle4;
            com.tencent.mm.storage.c cVar;
            int i3;
            int i4;
            b gmVar;
            Map chI;
            b gnVar;
            switch (i) {
                case 14:
                    if (bundle == null) {
                        return null;
                    }
                    ou = bh.ou(bundle.getString("task_url"));
                    x.i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", ou, bundle.getString("task_name"));
                    if (bh.ov(ou)) {
                        x.e("MicroMsg.WebViewStubService", "download url is null or nil");
                        return null;
                    }
                    com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
                    aVar.xL(ou);
                    aVar.xN(string);
                    aVar.ep(true);
                    aVar.ox(1);
                    x.i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", Long.valueOf(com.tencent.mm.plugin.downloader.model.f.aAd().a(aVar.lsE)));
                    bundle3 = new Bundle();
                    bundle3.putLong("download_id", r2);
                    return bundle3;
                case 15:
                    bY = com.tencent.mm.plugin.downloader.model.f.aAd().bY(bundle.getLong("download_id", 0));
                    String str = "MicroMsg.WebViewStubService";
                    String str2 = "query download task info, info == null ? %b task state = %d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(bY == null);
                    if (bY == null) {
                        i2 = 0;
                    } else {
                        i2 = bY.status;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    x.i(str, str2, objArr);
                    i2 = 0;
                    if (bY != null) {
                        i2 = bY.status;
                    }
                    x.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(r2), Integer.valueOf(i2));
                    bundle4 = new Bundle();
                    bundle4.putInt("download_state", i2);
                    return bundle4;
                case 16:
                    x.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(bundle.getLong("download_id", 0)), Integer.valueOf(com.tencent.mm.plugin.downloader.model.f.aAd().bX(bundle.getLong("download_id", 0))));
                    bundle4 = new Bundle();
                    bundle4.putBoolean("cancel_result", com.tencent.mm.plugin.downloader.model.f.aAd().bX(bundle.getLong("download_id", 0)) > 0);
                    return bundle4;
                case 17:
                    bY = com.tencent.mm.plugin.downloader.model.f.aAd().bY(bundle.getLong("download_id"));
                    bundle3 = new Bundle();
                    if (bY == null) {
                        x.e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
                        bundle3.putBoolean("install_result", false);
                        return bundle3;
                    } else if (bY.status != 3) {
                        x.e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + bY.status);
                        bundle3.putBoolean("install_result", false);
                        return bundle3;
                    } else if (com.tencent.mm.a.e.bO(bY.path)) {
                        bundle3.putBoolean("install_result", com.tencent.mm.pluginsdk.model.app.q.e(this.tvE, Uri.fromFile(new File(bY.path))));
                        return bundle3;
                    } else {
                        x.e("MicroMsg.WebViewStubService", "file not exists : %s", bY.path);
                        bundle3.putBoolean("install_result", false);
                        return bundle3;
                    }
                case 19:
                    bundle3 = new Bundle();
                    bundle3.putBoolean("webview_video_proxy_init", ah.bQR().hasInit);
                    return bundle3;
                case 23:
                    boolean Hj = ar.Hj();
                    bc 7 = new 7(this);
                    if (Hj) {
                        ou = (String) 7.b(null);
                    } else {
                        ou = (String) 7.b(this.tvE.handler);
                    }
                    bundle4 = new Bundle();
                    bundle4.putString("config_info_username", ou);
                    return bundle4;
                case 24:
                    bundle4 = new Bundle();
                    cVar = null;
                    try {
                        cVar = com.tencent.mm.z.c.c.IF().fn(com.tencent.mm.plugin.webview.modeltools.b.tul);
                    } catch (AssertionFailedError e) {
                        x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
                    } catch (com.tencent.mm.z.b e2) {
                        x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
                    }
                    if (cVar == null || !cVar.isValid()) {
                        x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", cVar);
                        return bundle4;
                    }
                    Map chI2 = cVar.chI();
                    long j = bh.getLong((String) chI2.get("interval"), 0);
                    long Wo = bh.Wo();
                    ar.Hg();
                    x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", Long.valueOf(bh.c((Long) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, null))), Long.valueOf(Wo), Long.valueOf(j));
                    if (bh.c((Long) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, null)) >= Wo) {
                        x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
                        return bundle4;
                    }
                    j += Wo;
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(j));
                    i3 = bh.getInt((String) chI2.get("urlCount"), 0);
                    ArrayList arrayList = new ArrayList(i3);
                    for (i2 = 0; i2 < i3; i2++) {
                        arrayList.add(chI2.get(String.format("url%d", new Object[]{Integer.valueOf(i2)})));
                    }
                    bundle4.putStringArrayList("cookies_cleanup_url_list", arrayList);
                    return bundle4;
                case 26:
                    bundle3 = new Bundle(1);
                    bundle3.putBoolean("webview_resource_cache_inWhiteList", false);
                    return bundle3;
                case 31:
                    if (!ar.Hj()) {
                        return null;
                    }
                    cVar = com.tencent.mm.z.c.c.IF().fn("100036");
                    if (cVar.isValid()) {
                        Map chI3 = cVar.chI();
                        bundle4 = new Bundle();
                        i2 = bh.getInt((String) chI3.get("controlFlag"), 0);
                        bundle4.putInt("webview_ad_intercept_control_flag", i2);
                        if (i2 == 0) {
                            x.i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
                            return bundle4;
                        }
                        int i5 = bh.getInt((String) chI3.get("blackListCount"), 0);
                        ArrayList arrayList2 = new ArrayList();
                        for (i4 = 0; i4 < i5; i4++) {
                            ou = (String) chI3.get("blackList" + (i4 + 1));
                            if (!(bh.ov(ou) || arrayList2.contains(ou))) {
                                x.i("MicroMsg.WebViewStubService", "add black list domin = %s", ou);
                                arrayList2.add(ou);
                            }
                        }
                        i5 = bh.getInt((String) chI3.get("whiteListCount"), 0);
                        ArrayList arrayList3 = new ArrayList();
                        for (i4 = 0; i4 < i5; i4++) {
                            ou = (String) chI3.get("whiteList" + (i4 + 1));
                            if (!(bh.ov(ou) || arrayList3.contains(ou))) {
                                x.i("MicroMsg.WebViewStubService", "add white list domin = %s", ou);
                                arrayList3.add(ou);
                            }
                        }
                        bundle4.putStringArrayList("webview_ad_intercept_blacklist_domins", arrayList2);
                        bundle4.putStringArrayList("webview_ad_intercept_whitelist_domins", arrayList3);
                        return bundle4;
                    }
                    x.d("MicroMsg.WebViewStubService", "test is valid");
                    return null;
                case 50:
                    if (bundle == null) {
                        return null;
                    }
                    string = bundle.getString(SlookAirButtonFrequentContactAdapter.DATA);
                    if (string == null) {
                        return null;
                    }
                    bundle3 = new Bundle();
                    bundle3.putInt("key_biz_type", com.tencent.mm.ag.f.jS(string).field_type);
                    return bundle3;
                case 51:
                    try {
                        if (Looper.myLooper() == null) {
                            Looper.prepare();
                        }
                        com.tencent.mm.modelgeo.c.OP().b(new com.tencent.mm.modelgeo.a.a(this) {
                            final /* synthetic */ AnonymousClass1 tvH;

                            {
                                this.tvH = r1;
                            }

                            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                                x.i("MicroMsg.WebViewStubService", "onGetLocation %b %f|%f", Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2));
                                com.tencent.mm.modelgeo.c.OP().c(this);
                                return false;
                            }
                        });
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.WebViewStubService", e3, "", new Object[0]);
                    }
                    return null;
                case R$styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                    if (bundle == null) {
                        return null;
                    }
                    ou = bundle.getString("enterprise_action");
                    bundle4 = new Bundle();
                    if (ou.equals("enterprise_has_connector")) {
                        String str3 = "enterprise_has_connector";
                        y.Mf();
                        bundle4.putBoolean(str3, com.tencent.mm.ag.e.LK().size() > 0);
                    } else if (ou.equals("enterprise_connectors")) {
                        y.Mf();
                        Collection LK = com.tencent.mm.ag.e.LK();
                        if (LK != null) {
                            bundle4.putStringArrayList("enterprise_connectors", new ArrayList(LK));
                        }
                    }
                    return bundle4;
                case R$styleable.AppCompatTheme_listPopupWindowStyle /*75*/:
                    ah bQR = ah.bQR();
                    if (bQR.hasInit) {
                        bQR.fBH = null;
                        ah.tsE = null;
                        bQR.hasInit = false;
                    }
                    return null;
                case R$styleable.AppCompatTheme_textAppearanceListItem /*76*/:
                    if (bundle == null) {
                        return Bundle.EMPTY;
                    }
                    bundle3 = new Bundle();
                    bundle3.putString("appId", h.Be(bundle.getInt("webview_binder_id")).qE(bh.ou(bundle.getString("rawUrl"))));
                    return bundle3;
                case 78:
                    bundle2.putBoolean("isOpenForFaceBook", q.Gr());
                    break;
                case 80:
                    if (bundle != null) {
                        ou = bundle.getString("KAppId");
                        string = bundle.getString("shortcut_user_name");
                        i3 = bundle.getInt("webviewui_binder_id");
                        if (!bh.ov(ou) && !bh.ov(string)) {
                            WebViewStubService.a(this.tvE, 10, bundle, i3);
                            break;
                        }
                        return null;
                    }
                    return null;
                    break;
                case 82:
                    if (bundle == null) {
                        return null;
                    }
                    ou = bundle.getString("key_last_page");
                    string = bundle.getString("key_last_page_title");
                    i4 = bundle.getInt("key_keep_top_scene", 0);
                    com.tencent.mm.bh.c cVar2 = com.tencent.mm.bh.c.hZo;
                    com.tencent.mm.bh.c.f(ou, string, i4);
                    return new Bundle();
                case 83:
                    this.tvE.tvD = bundle.getInt("screen_orientation", -1);
                    break;
                case R$styleable.AppCompatTheme_colorSwitchThumbNormal /*89*/:
                    bundle3 = new Bundle();
                    com.tencent.mm.bh.c cVar3 = com.tencent.mm.bh.c.hZo;
                    bundle3.putBoolean("key_is_webview_keep_top", com.tencent.mm.bh.c.Vb());
                    return bundle3;
                case 91:
                    if (bundle != null) {
                        i2 = bundle.getInt("game_sourceScene");
                        gmVar = new gm();
                        gmVar.fwC.actionCode = 5;
                        gmVar.fwC.scene = i2;
                        com.tencent.mm.sdk.b.a.xef.m(gmVar);
                        break;
                    }
                    return null;
                case 92:
                    if (bundle != null) {
                        ou = bundle.getString("game_hv_menu_appid");
                        if (!bh.ov(ou)) {
                            gmVar = new gn();
                            gmVar.fwD.pK = 3;
                            gmVar.fwD.fwF = ou;
                            com.tencent.mm.sdk.b.a.xef.m(gmVar);
                            bundle2.putString("game_hv_menu_pbcache", gmVar.fwE.result);
                            break;
                        }
                        return null;
                    }
                    return null;
                case 93:
                    bundle3 = new Bundle();
                    bundle3.putBoolean("is_oauth_native", false);
                    if (!com.tencent.mm.kernel.g.Dh().Cy()) {
                        x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative account not ready");
                        return bundle3;
                    } else if (com.tencent.mm.kernel.g.Dk().gQE.gQX) {
                        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100272");
                        if (fn.isValid()) {
                            chI = fn.chI();
                            if (chI == null) {
                                x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative args == null");
                                return bundle3;
                            } else if (chI.containsKey("isUseNative") && "1".equals(chI.get("isUseNative"))) {
                                bundle3.putBoolean("is_oauth_native", true);
                                return bundle3;
                            } else {
                                x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative not contain the isUseNative key or the value is not 1");
                                return bundle3;
                            }
                        }
                        x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative item.isValid is false");
                        return bundle3;
                    } else {
                        x.i("MicroMsg.OauthAuthorizeLogic", "kernel has not startup done");
                        return bundle3;
                    }
                case 94:
                    return y$a.bQK();
                case 96:
                    if (bundle == null) {
                        return null;
                    }
                    Set<String> keySet = bundle.keySet();
                    if (keySet == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String ou2 : keySet) {
                            jSONObject.put(ou2, bundle.get(ou2));
                        }
                        gnVar = new gn();
                        gnVar.fwD.pK = 4;
                        gnVar.fwD.fwF = jSONObject.toString();
                        com.tencent.mm.sdk.b.a.xef.m(gnVar);
                        break;
                    } catch (JSONException e4) {
                        return null;
                    }
                case 98:
                    cVar = com.tencent.mm.z.c.c.IF().fn("100376");
                    if (!cVar.isValid()) {
                        x.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
                        return null;
                    } else if ("true".equals(cVar.chI().get("enabled"))) {
                        return new Bundle();
                    } else {
                        return null;
                    }
                case 129:
                    i3 = bundle.getInt("webview_instance_id");
                    e eVar = null;
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.tvE.fvF) {
                        e eVar2;
                        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i3) {
                            eVar2 = eVar;
                        } else {
                            eVar2 = webViewStubCallbackWrapper.tyk;
                        }
                        eVar = eVar2;
                    }
                    h.Be(i3).a(this.tvE, eVar);
                    Map hashMap = new HashMap();
                    hashMap.put("scene", Integer.valueOf(bundle.getInt("scene")));
                    hashMap.put("webview_instance_id", Integer.valueOf(i3));
                    f.bRy().ac(hashMap);
                    break;
                case 131:
                    chI = new HashMap();
                    chI.put("logString", bundle.getString("logString"));
                    com.tencent.mm.plugin.webview.fts.e bRy = f.bRy();
                    Object r = com.tencent.mm.plugin.webview.fts.f.r(chI, "logString");
                    Map hashMap2 = new HashMap();
                    if (!r.contains("h5version=")) {
                        hashMap2.put("h5version", Integer.valueOf(com.tencent.mm.plugin.aj.a.g.zN(0)));
                    }
                    if (hashMap2.keySet().size() > 0) {
                        r = r.length() > 0 ? r + "&" + com.tencent.mm.bc.b.s(hashMap2) : com.tencent.mm.bc.b.s(hashMap2);
                    }
                    chI.put("logString", r);
                    bRy.ae(chI);
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX /*141*/:
                    gnVar = new hh();
                    com.tencent.mm.sdk.b.a.xef.m(gnVar);
                    Parcelable gameSettingParams = new GameSettingParams();
                    gameSettingParams.fxA = gnVar.fxz.fxA;
                    gameSettingParams.fxB = gnVar.fxz.fxB;
                    bundle2.putParcelable("game_setting_params", gameSettingParams);
                    break;
                case 250:
                    if (bundle != null) {
                        if (bundle != null) {
                            try {
                                com.tencent.mm.sdk.f.e.post(new 1(bundle), "web_call_rpt");
                                break;
                            } catch (Throwable e32) {
                                x.printErrStackTrace("MicroMsg.WebViewStubService", e32, "webview call back mm error", new Object[0]);
                                break;
                            }
                        }
                    }
                    return null;
                    break;
                case 251:
                    if (bundle != null) {
                        com.tencent.mm.modelstat.f.SU().q(WebViewUI.class.getName(), bundle.getLong("key_activity_browse_time", 0));
                        break;
                    }
                    return null;
                case 4006:
                    bundle3 = new Bundle();
                    string = ac.cfu().getString("nfc_open_url", null);
                    x.i("MicroMsg.WebViewStubService", "nfc url=" + bh.ou(string));
                    if (!(bh.ov(string) || bh.ov(string.trim()))) {
                        bundle3.putString("debugConfig", string);
                    }
                    ar.Hg();
                    bundle3.putString("config", String.valueOf(com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, null)));
                    return bundle3;
                case 10001:
                    StringBuilder stringBuilder = new StringBuilder("kwid_");
                    com.tencent.mm.kernel.g.Dh();
                    com.tencent.mm.modelappbrand.b.hjy = stringBuilder.append(com.tencent.mm.kernel.a.Cg()).append("_").append(bh.Wp()).toString();
                    x.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchKeywordId : %s", com.tencent.mm.modelappbrand.b.hjy);
                    break;
                case 100000:
                    cVar = com.tencent.mm.z.c.c.IF().fn("100248");
                    if (cVar.isValid()) {
                        if (bh.getInt((String) cVar.chI().get("isForceSync"), 0) == 1) {
                            x.d("MicroMsg.ConfigListDecoder", "host list = %s", com.tencent.mm.k.g.zZ().F("WebViewConfig", "forceSyncA8KeyHostPath"));
                            bundle2.putString("force_geta8key_host_path", ou2);
                            break;
                        }
                    }
                    x.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
                    return null;
                    break;
                default:
                    x.e("MicroMsg.WebViewStubService", "unknown action = %d", Integer.valueOf(i));
                    break;
            }
            return bundle2;
        }

        public final boolean bSb() {
            if (!ar.Hi() || ar.Cs()) {
                return true;
            }
            return false;
        }

        public final void aa(Intent intent) {
            Intent intent2 = new Intent(this.tvE, WebViewStubProxyUI.class);
            intent2.putExtra("proxyui_action_code_key", 9);
            intent2.putExtra("proxyui_next_intent_key", intent);
            intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.tvE.startActivity(intent2);
        }

        public final void y(int i, String str, String str2) {
            WebViewJSSDKFileItem x = WebViewJSSDKFileItem.x(i, str, str2);
            x.iLz = false;
            f.bRB().b(x);
            f.bRA().b(null, x.fus, null);
        }

        public final List<String> bSc() {
            f.bRv();
            com.tencent.mm.plugin.webview.modeltools.i bRC = f.bRC();
            long Wo = bh.Wo();
            x.d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = " + Wo);
            boolean fx = bRC.fx("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < " + Wo);
            x.i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", Boolean.valueOf(fx));
            Cursor a = bRC.gJP.a(bRC.getTableName(), new String[]{"host"}, null, null, null, null, null, 2);
            Collection hashSet = new HashSet();
            if (a == null || !a.moveToFirst()) {
                if (a != null) {
                    a.close();
                }
                return new ArrayList(hashSet);
            }
            do {
                String string = a.getString(0);
                if (!bh.ov(string)) {
                    hashSet.add(string);
                    x.d("MicroMsg.WebViewStorage", "webview hijack gethost = " + string);
                }
            } while (a.moveToNext());
            if (a != null) {
                a.close();
            }
            return new ArrayList(hashSet);
        }

        public final int bSd() {
            return com.tencent.mm.pluginsdk.wallet.i.bSd();
        }

        public final boolean bSe() {
            if (AnonymousClass1.ok("WebViewDownLoadFileSwitch") == 1) {
                return true;
            }
            return false;
        }

        public final String[] bSf() {
            String F = com.tencent.mm.k.g.zZ().F("AsyncCheckUrl", "UrlHost");
            return !bh.ov(F) ? F.split(";") : null;
        }
    };
    private int tvz = 0;

    private static class a extends com.tencent.mm.plugin.webview.stub.b.a {
        public boolean fnI;
        public boolean mXH;
        public int ret;
        public int type;

        private a() {
        }

        public final boolean bRJ() {
            return this.mXH;
        }

        public final boolean getResult() {
            return this.fnI;
        }

        public final int getRet() {
            return this.ret;
        }

        public final int getType() {
            return this.type;
        }
    }

    static /* synthetic */ boolean OL(String str) {
        if (str == null) {
            x.e("MicroMsg.WebViewStubService", "doInActivity fail, function null");
        } else {
            com.tencent.mm.protocal.c.g Tm = com.tencent.mm.protocal.c.Tm(str);
            if (Tm == null) {
                x.e("MicroMsg.WebViewStubService", "doInActivity fail, func null, %s", str);
            } else if (Tm.cdt()) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean Q(Bundle bundle) {
        com.tencent.mm.ae.k aaVar = new aa(bundle.getString("emoji_store_jump_url"));
        aaVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
        return ar.CG().a(aaVar, 0);
    }

    static /* synthetic */ void a(WebViewStubService webViewStubService, int i, Bundle bundle, int i2) {
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.fvF) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.id != i2) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper != null && webViewStubCallbackWrapper.tyk != null) {
            Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
            intent.putExtras(bundle);
            intent.putExtra("proxyui_action_code_key", i);
            intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
            intent.putExtra("webview_binder_id", i2);
            intent.putExtra("screen_orientation", webViewStubService.tvD);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.tyk, new 7(webViewStubService, intent));
        }
    }

    static /* synthetic */ void a(WebViewStubService webViewStubService, String str, String str2, String str3, JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle, int i) {
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.fvF) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.id != i) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper != null && webViewStubCallbackWrapper.tyk != null) {
            Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
            intent.putExtras(bundle);
            intent.putExtra("proxyui_action_code_key", 1);
            intent.putExtra("proxyui_type_key", str);
            intent.putExtra("proxyui_function_key", str2);
            intent.putExtra("proxyui_callback_key", str3);
            intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
            intent.putExtra("proxyui_perm_key", jsapiPermissionWrapper);
            intent.putExtra("webview_binder_id", i);
            intent.putExtra("screen_orientation", webViewStubService.tvD);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.tyk, new 6(webViewStubService, intent));
        }
    }

    static /* synthetic */ boolean a(WebViewStubService webViewStubService, Bundle bundle) {
        String string = bundle.getString("service_click_tid");
        x.i("MicroMsg.WebViewStubService", "doServiceClick tid = %s, stime = %d, etime = %d", string, Long.valueOf(bundle.getLong("service_click_stime", 0)), Long.valueOf(bundle.getLong("service_click_etime", 0)));
        if (string == null || string.length() == 0) {
            x.e("MicroMsg.WebViewStubService", "doServiceClick fail, tid is null");
            return false;
        }
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bgp();
        aVar.hmk = new bgq();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/service_click";
        aVar.hmi = 2836;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        bgp com_tencent_mm_protocal_c_bgp = (bgp) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bgp.mFx = string;
        com_tencent_mm_protocal_c_bgp.wKT = r4;
        com_tencent_mm_protocal_c_bgp.wKU = r6;
        com.tencent.mm.ae.u.a(JZ, new 8(webViewStubService));
        return true;
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
        this.handler = new af();
        this.tvA = new o(this) {
            final /* synthetic */ WebViewStubService tvE;

            {
                this.tvE = r1;
            }

            public final void onTaskStarted(long j, String str) {
            }

            public final void c(long j, String str, boolean z) {
                x.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.tvE.fvF) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.e.a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
                        bundle.putCharSequence("download_manager_appid", ce != null ? ce.field_appId : "");
                        webViewStubCallbackWrapper.tyk.n(1002, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + e.getMessage());
                }
            }

            public final void c(long j, int i, boolean z) {
                x.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.tvE.fvF) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.e.a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
                        bundle.putCharSequence("download_manager_appid", ce != null ? ce.field_appId : "");
                        bundle.putInt("download_manager_errcode", i);
                        webViewStubCallbackWrapper.tyk.n(1003, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + e.getMessage());
                }
            }

            public final void onTaskRemoved(long j) {
                x.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.tvE.fvF) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.e.a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
                        bundle.putCharSequence("download_manager_appid", ce != null ? ce.field_appId : "");
                        webViewStubCallbackWrapper.tyk.n(1008, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                }
            }

            public final void onTaskPaused(long j) {
            }

            public final void ck(long j) {
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.tvE.fvF) {
                        com.tencent.mm.plugin.downloader.e.a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
                        if (ce == null || ce.field_totalSize == 0) {
                            x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = " + j);
                            return;
                        }
                        int i = (int) ((((double) ce.field_downloadedSize) / ((double) ce.field_totalSize)) * 100.0d);
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        bundle.putInt("download_manager_progress", i);
                        bundle.putString("download_manager_appid", ce.field_appId);
                        webViewStubCallbackWrapper.tyk.n(1007, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + e.getMessage());
                }
            }

            public final void k(long j, String str) {
            }
        };
        com.tencent.mm.plugin.downloader.model.f.aAd();
        com.tencent.mm.plugin.downloader.model.c.a(this.tvA);
        this.tvB = new com.tencent.mm.plugin.webview.model.c.a(this) {
            final /* synthetic */ WebViewStubService tvE;

            {
                this.tvE = r1;
            }

            public final void a(boolean z, int i, int i2, String str, String str2) {
                Bundle bundle;
                x.i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2);
                if (z) {
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_local_id", str);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.tvE.fvF) {
                            webViewStubCallbackWrapper.tyk.n(2011, bundle);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e.getMessage());
                    }
                }
                switch (i) {
                    case 1:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.tvE.fvF) {
                                    webViewStubCallbackWrapper2.tyk.n(2003, bundle);
                                }
                                return;
                            } catch (Exception e2) {
                                x.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e2.getMessage());
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.tvE.fvF) {
                                webViewStubCallbackWrapper22.tyk.n(TXLiveConstants.PLAY_EVT_PLAY_BEGIN, bundle);
                            }
                            return;
                        } catch (Exception e22) {
                            x.e("MicroMsg.WebViewStubService", "notify download image failed :%s", e22.getMessage());
                            return;
                        }
                    case 2:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.tvE.fvF) {
                                    webViewStubCallbackWrapper222.tyk.n(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, bundle);
                                }
                                return;
                            } catch (Exception e222) {
                                x.e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", e222.getMessage());
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : this.tvE.fvF) {
                                webViewStubCallbackWrapper2222.tyk.n(TXLiveConstants.PLAY_EVT_PLAY_END, bundle);
                            }
                            return;
                        } catch (Exception e2222) {
                            x.e("MicroMsg.WebViewStubService", "notify download voice failed :%s", e2222.getMessage());
                            return;
                        }
                    case 4:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22222 : this.tvE.fvF) {
                                    webViewStubCallbackWrapper22222.tyk.n(2010, bundle);
                                }
                                return;
                            } catch (Exception e22222) {
                                x.e("MicroMsg.WebViewStubService", "notify upload video failed :%s", e22222.getMessage());
                                return;
                            }
                        }
                        return;
                    default:
                        x.e("MicroMsg.WebViewStubService", "unsupport media type : %d", Integer.valueOf(i));
                        return;
                }
            }
        };
        this.mEF = new com.tencent.mm.network.n.a(this) {
            private final byte[] gym = new byte[0];
            final /* synthetic */ WebViewStubService tvE;

            {
                this.tvE = r2;
            }

            public final void eq(int i) {
                synchronized (this.gym) {
                    try {
                        String bQV = com.tencent.mm.pluginsdk.ui.tools.s.bQV();
                        Bundle bundle = new Bundle();
                        bundle.putString("webview_network_type", bQV);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.tvE.fvF) {
                            webViewStubCallbackWrapper.tyk.n(90, bundle);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewStubService", "notify network change failed :%s", e.getMessage());
                    }
                }
            }
        };
        ar.a(this.mEF);
        if (ar.Hj()) {
            f.bRA().a(this.tvB);
        }
    }

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
        return this.tvy;
    }

    public boolean onUnbind(Intent intent) {
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
        h.detach();
        ak.clear();
        q$a.tue.release(false);
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.f.aAd();
        com.tencent.mm.plugin.downloader.model.c.b(this.tvA);
        if (ar.Hj()) {
            f.bRA().b(this.tvB);
        }
        ar.b(this.mEF);
        this.mEF = null;
        this.tvA = null;
        this.fvF.clear();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        int type = kVar.getType();
        x.i("MicroMsg.WebViewStubService", "onSceneEnd :[%d], errCode = %d, errType = %d, errMsg = %s", Integer.valueOf(type), Integer.valueOf(i2), Integer.valueOf(i), str);
        String a;
        Bundle bundle;
        if (type == 106) {
            ar.CG().b(106, (e) this);
            if (i == 0 && i2 == 0) {
                bem So = ((com.tencent.mm.modelsimple.ac) kVar).So();
                a = com.tencent.mm.platformtools.n.a(So.vYI);
                com.tencent.mm.ad.n.Jz().f(a, com.tencent.mm.platformtools.n.a(So.vHb));
                Intent intent = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.c.a(intent, So, 30);
                if (bh.ou(a).length() > 0) {
                    ar.Hg();
                    com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(a);
                    if (!(WO == null || com.tencent.mm.l.a.fZ(WO.field_type))) {
                        intent.putExtra("Contact_IsLBSFriend", true);
                    }
                    if ((So.wvf & 8) > 0) {
                        com.tencent.mm.plugin.report.service.g.pQN.k(10298, a + ",30");
                    }
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    com.tencent.mm.plugin.webview.a.a.ifs.d(intent, this);
                    bundle = new Bundle();
                    bundle.putString("search_contact_result_user", a);
                    try {
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.fvF) {
                            c bVar = new b();
                            bVar.type = type;
                            bVar.errType = i;
                            bVar.errCode = i2;
                            bVar.fnL = str;
                            bVar.msB = bundle;
                            bVar.msB.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper.id);
                            webViewStubCallbackWrapper.tyk.a(bVar);
                        }
                        return;
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewStubService", "onSceneEnd searchcontact fail, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            }
            x.e("MicroMsg.WebViewStubService", "onSceneEnd, sendcard errType = " + i + ", errCode = " + i2);
        } else if (type == 233) {
            l lVar = (l) kVar;
            bundle = new Bundle();
            byte[] RH = lVar.RH();
            if (RH == null || RH.length <= 0) {
                x.e("MicroMsg.WebViewStubService", "getA8Key controlBytes is null");
            }
            a = "geta8key_result_jsapi_perm_control_bytes";
            if (RH == null) {
                RH = null;
            }
            bundle.putByteArray(a, RH);
            xd xdVar = ((xh) lVar.gJQ.hmh.hmo).whN;
            bundle.putInt("geta8key_result_general_ctrl_b1", xdVar == null ? 0 : xdVar.wht);
            bundle.putInt("geta8key_result_reason", ((xg) lVar.gJQ.hmg.hmo).whD);
            bundle.putString("geta8key_result_req_url", lVar.RF());
            bundle.putString("geta8key_result_full_url", lVar.RE());
            bundle.putString("geta8key_result_title", lVar.getTitle());
            bundle.putInt("geta8key_result_action_code", lVar.RG());
            bundle.putString("geta8key_result_content", lVar.we());
            bundle.putString("geta8key_result_head_img", ((xh) lVar.gJQ.hmh.hmo).whW);
            bundle.putString("geta8key_result_wording", ((xh) lVar.gJQ.hmh.hmo).nGK);
            bundle.putLong("geta8key_result_deep_link_bit_set", lVar.RK());
            bundle.putString("geta8key_data_username", ((xh) lVar.gJQ.hmh.hmo).ksU);
            bundle.putByteArray("geta8key_result_cookie", lVar.RN());
            x.d("MicroMsg.WebViewStubService", "getA8KeyCookie:%s", bh.by(lVar.RN()));
            List<akj> RL = lVar.RL();
            if (!bh.cA(RL)) {
                akj com_tencent_mm_protocal_c_akj;
                Object obj;
                for (akj com_tencent_mm_protocal_c_akj2 : RL) {
                    if (com_tencent_mm_protocal_c_akj2 != null && !bh.ov(com_tencent_mm_protocal_c_akj2.vNj)) {
                        if (bh.ov(com_tencent_mm_protocal_c_akj2.pQt)) {
                            x.e("MicroMsg.WebViewStubService", "http header has null value");
                            obj = 1;
                            break;
                        }
                    }
                    x.e("MicroMsg.WebViewStubService", "http header has null value");
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj == null) {
                    String[] strArr = new String[RL.size()];
                    String[] strArr2 = new String[RL.size()];
                    for (r3 = 0; r3 < RL.size(); r3++) {
                        com_tencent_mm_protocal_c_akj2 = (akj) RL.get(r3);
                        x.i("MicroMsg.WebViewStubService", "http header index = %d, key = %s, value = %s", Integer.valueOf(r3), com_tencent_mm_protocal_c_akj2.vNj, com_tencent_mm_protocal_c_akj2.pQt);
                        strArr[r3] = r9;
                        strArr2[r3] = r2;
                    }
                    bundle.putStringArray("geta8key_result_http_header_key_list", strArr);
                    bundle.putStringArray("geta8key_result_http_header_value_list", strArr2);
                }
            }
            bundle.putSerializable("geta8key_result_scope_list", lVar.RJ());
            x.i("MicroMsg.WebViewStubService", "geta8key onscened: share url:[%s], full url:[%s], req url:[%s], has scopeList:[%s]", lVar.RI(), lVar.RE(), lVar.RF(), Boolean.valueOf(true));
            if (bh.ov(lVar.RI())) {
                x.e("MicroMsg.WebViewStubService", "null shareUrl, full url:[%s], req url:[%s]", lVar.RE(), lVar.RF());
            } else {
                ak.eL(lVar.RE(), lVar.RI());
            }
            try {
                if (lVar.tag != null) {
                    r3 = ((Integer) lVar.tag).intValue();
                } else {
                    r3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.fvF) {
                    if (r3 == 0 || r3 == webViewStubCallbackWrapper2.id) {
                        r6 = new b();
                        r6.type = type;
                        r6.errType = i;
                        r6.errCode = i2;
                        r6.fnL = str;
                        r6.msB = bundle;
                        r6.msB.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2.id);
                        webViewStubCallbackWrapper2.tyk.a(r6);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "geta8key hashcode not equal, this one = %d, that = %d", Integer.valueOf(r3), Integer.valueOf(webViewStubCallbackWrapper2.id));
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e2));
            }
        } else if (type == 673) {
            j jVar = (j) kVar;
            bundle = new Bundle();
            a = "reading_mode_result_url";
            if (jVar.gJQ == null) {
                r2 = null;
            } else {
                r2 = ((aff) jVar.gJQ.hmh.hmo).URL;
            }
            bundle.putString(a, r2);
            try {
                if (jVar.tag != null) {
                    r3 = ((Integer) jVar.tag).intValue();
                } else {
                    r3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.fvF) {
                    if (r3 == 0 || r3 == webViewStubCallbackWrapper22.id) {
                        r6 = new b();
                        r6.type = type;
                        r6.errType = i;
                        r6.errCode = i2;
                        r6.fnL = str;
                        r6.msB = bundle;
                        r6.msB.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper22.id);
                        webViewStubCallbackWrapper22.tyk.a(r6);
                    } else {
                        x.d("MicroMsg.WebViewStubService", " get readingmodeinfo, hashcode not equal, this one = %d, that = %d", Integer.valueOf(r3), Integer.valueOf(webViewStubCallbackWrapper22.id));
                    }
                }
            } catch (Throwable e22) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e22));
            }
        } else if (type == 666) {
            aa aaVar = (aa) kVar;
            bundle = new Bundle();
            bundle.putString("emoji_stroe_product_id", aaVar.Sm().vIR);
            if (i == 0 && i2 == 0) {
                r2 = bundle.getString("emoji_stroe_product_id");
                x.i("MicroMsg.WebViewStubService", "[cpan] onsceneend url:%s", r2);
                if (!bh.ov(r2)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("extra_id", r2);
                    intent2.putExtra("preceding_scence", 12);
                    intent2.putExtra("download_entrance_scene", 12);
                    com.tencent.mm.bm.d.b(this, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                }
            }
            try {
                if (aaVar.tag != null) {
                    r3 = ((Integer) aaVar.tag).intValue();
                } else {
                    r3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.fvF) {
                    if (r3 == 0 || r3 == webViewStubCallbackWrapper222.id) {
                        r6 = new b();
                        r6.type = type;
                        r6.errType = i;
                        r6.errCode = i2;
                        r6.fnL = str;
                        r6.msB = bundle;
                        r6.msB.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper222.id);
                        webViewStubCallbackWrapper222.tyk.a(r6);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "jumpEmojiDetail, hashcode not equal, this one = %d, that = %d", Integer.valueOf(r3), Integer.valueOf(webViewStubCallbackWrapper222.id));
                    }
                }
            } catch (Exception e3) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_JumpEmotionDetail fail, ex = " + e3.getMessage());
            }
        } else if (type == 1254) {
            try {
                int intValue;
                r rVar = (r) kVar;
                if (rVar.tag != null) {
                    intValue = ((Integer) rVar.tag).intValue();
                } else {
                    intValue = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper3 : this.fvF) {
                    if (intValue == 0 || intValue == webViewStubCallbackWrapper3.id) {
                        c bVar2 = new b();
                        bVar2.type = type;
                        bVar2.errType = i;
                        bVar2.errCode = i2;
                        bVar2.fnL = str;
                        Bundle bundle2 = new Bundle();
                        if (i != 0 || i2 != 0) {
                            r2 = bundle2;
                        } else if (kVar instanceof r) {
                            atr com_tencent_mm_protocal_c_atr = (atr) ((r) kVar).gJQ.hmh.hmo;
                            bundle2.putString("oauth_url", ((r) kVar).tsi);
                            bundle2.putSerializable("scope_list", com.tencent.mm.plugin.webview.model.y.ar(com_tencent_mm_protocal_c_atr.wBJ));
                            bundle2.putString("appname", com_tencent_mm_protocal_c_atr.hcp);
                            bundle2.putString("appicon_url", com_tencent_mm_protocal_c_atr.wBK);
                            bundle2.putString("redirect_url", com_tencent_mm_protocal_c_atr.vUP);
                            bundle2.putBoolean("is_recent_has_auth", com_tencent_mm_protocal_c_atr.wBL);
                            bundle2.putBoolean("is_silence_auth", com_tencent_mm_protocal_c_atr.wBM);
                            bundle2.putBoolean("is_call_server_when_confirm", com_tencent_mm_protocal_c_atr.wBN);
                            r2 = bundle2;
                        } else {
                            r2 = bundle2;
                        }
                        bVar2.msB = r2;
                        bVar2.msB.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper3.id);
                        webViewStubCallbackWrapper3.tyk.a(bVar2);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "authorize, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue), Integer.valueOf(webViewStubCallbackWrapper3.id));
                    }
                }
            } catch (Throwable e222) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeReq fail, ex = " + Log.getStackTraceString(e222));
            }
        } else if (type == 1373) {
            try {
                int intValue2;
                com.tencent.mm.plugin.webview.model.s sVar = (com.tencent.mm.plugin.webview.model.s) kVar;
                if (sVar.tag != null) {
                    intValue2 = ((Integer) sVar.tag).intValue();
                } else {
                    intValue2 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper4 : this.fvF) {
                    if (intValue2 == 0 || intValue2 == webViewStubCallbackWrapper4.id) {
                        c bVar3 = new b();
                        bVar3.type = type;
                        bVar3.errType = i;
                        bVar3.errCode = i2;
                        bVar3.fnL = str;
                        bundle = new Bundle();
                        if (i != 0 || i2 != 0) {
                            r2 = bundle;
                        } else if (kVar instanceof com.tencent.mm.plugin.webview.model.s) {
                            bundle.putString("redirect_url", ((atp) ((com.tencent.mm.plugin.webview.model.s) kVar).gJQ.hmh.hmo).vUP);
                            r2 = bundle;
                        } else {
                            r2 = bundle;
                        }
                        bVar3.msB = r2;
                        bVar3.msB.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper4.id);
                        webViewStubCallbackWrapper4.tyk.a(bVar3);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "authorizeconfirm, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue2), Integer.valueOf(webViewStubCallbackWrapper4.id));
                    }
                }
            } catch (Throwable e2222) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeConfirmReq fail, ex = " + Log.getStackTraceString(e2222));
            }
        }
    }
}
