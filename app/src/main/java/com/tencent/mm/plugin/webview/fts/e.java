package com.tencent.mm.plugin.webview.fts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.av.b;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.js;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.webview.fts.a.d;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.apx;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e implements com.tencent.mm.ae.e {
    public c jeX = new c<js>(this) {
        final /* synthetic */ e tms;

        {
            this.tms = r2;
            this.xen = js.class.getName().hashCode();
        }

        private boolean a(js jsVar) {
            asv com_tencent_mm_protocal_c_asv = jsVar.fAz.fAv;
            if (com_tencent_mm_protocal_c_asv != null && b.d(com_tencent_mm_protocal_c_asv)) {
                switch (jsVar.fAz.action) {
                    case 0:
                    case 1:
                        for (Integer intValue : this.tms.tmi) {
                            h.Be(intValue.intValue()).cK(com_tencent_mm_protocal_c_asv.vVZ, 1);
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                        for (Integer intValue2 : this.tms.tmi) {
                            h.Be(intValue2.intValue()).cK(com_tencent_mm_protocal_c_asv.vVZ, 0);
                        }
                        break;
                }
            }
            return false;
        }
    };
    private long jzh;
    public com.tencent.mm.plugin.fts.a.a.a mMa;
    public k phA = new 4(this);
    public Set<Integer> tmi;
    public k tmj = new k(this) {
        final /* synthetic */ e tms;

        {
            this.tms = r1;
        }

        public final void b(com.tencent.mm.plugin.fts.a.a.h hVar) {
            x.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", new Object[]{Integer.valueOf(hVar.bjW), Integer.valueOf(((f) hVar.mJc).tmK)});
            if (hVar.bjW == 0) {
                ArrayList arrayList = new ArrayList();
                for (j jVar : hVar.mMc) {
                    arrayList.add(jVar.content);
                }
                ag.y(new 1(this, r0, hVar, arrayList));
            }
        }
    };
    private HashMap<String, b> tmk;
    public k tml;
    public com.tencent.mm.bc.h tmm;
    private Map<Integer, g> tmn = new HashMap();
    public e tmo = new e(this);
    public List<asv> tmp;
    private com.tencent.mm.plugin.webview.fts.a.c tmq;
    d tmr;

    private class a implements Runnable {
        public String data;
        public boolean tmA;
        final /* synthetic */ e tms;

        private a(e eVar) {
            this.tms = eVar;
        }

        public final void run() {
            Object arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.data);
                for (int i = 0; i < jSONArray.length(); i++) {
                    bnp mG = ((m) g.h(m.class)).mG(jSONArray.getString(i));
                    com.tencent.mm.av.a.a aVar = (com.tencent.mm.av.a.a) g.h(com.tencent.mm.av.a.a.class);
                    ar.Hg();
                    asv a = aVar.a(com.tencent.mm.z.c.FC(), mG, 9);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                if (!this.tmA || this.tms.tmp == null) {
                    this.tms.tmp = arrayList;
                } else {
                    this.tms.tmp.addAll(arrayList);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
            }
        }
    }

    public e() {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "create FTSWebViewLogic");
        this.tmk = new HashMap();
        this.tmi = Collections.synchronizedSet(new HashSet());
        com.tencent.mm.sdk.b.a.xef.b(this.jeX);
    }

    public static Bundle o(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 2:
                try {
                    String string = bundle.getString("key");
                    bundle2.putString("result", com.tencent.mm.plugin.aj.a.h.NT(string).toString());
                    if ("educationTab".equals(string)) {
                        JSONObject NT = com.tencent.mm.plugin.aj.a.h.NT("discoverSearchGuide");
                        if (NT.optJSONArray("items").length() > 0) {
                            bundle2.putString("result_1", NT.toString());
                            break;
                        }
                    }
                } catch (Exception e) {
                    break;
                }
                break;
            case 4:
                Map b = com.tencent.mm.bc.b.b(bundle.getInt("scene"), bundle.getBoolean("isHomePage"), bundle.getInt(DownloadSettingTable$Columns.TYPE));
                bundle2.putString(DownloadSettingTable$Columns.TYPE, (String) b.get(DownloadSettingTable$Columns.TYPE));
                bundle2.putString("isMostSearchBiz", (String) b.get("isMostSearchBiz"));
                bundle2.putString("isLocalSug", (String) b.get("isLocalSug"));
                bundle2.putString("isSug", (String) b.get("isSug"));
                bundle2.putString("scene", (String) b.get("scene"));
                break;
            case 6:
                try {
                    bundle2.putString("result", com.tencent.mm.plugin.aj.a.h.NU(bundle.getString("key")));
                    break;
                } catch (Exception e2) {
                    break;
                }
            case 7:
                bundle2.putString(SlookAirButtonFrequentContactAdapter.DATA, f.bRy().bPf());
                break;
        }
        return bundle2;
    }

    public final boolean ab(Map<String, Object> map) {
        String r;
        int c;
        switch (f.c(map, "action", 0)) {
            case 1:
                if (com.tencent.mm.bc.c.hKD == null) {
                    com.tencent.mm.bc.c.QU();
                }
                com.tencent.mm.bc.c.hKD.ksP.clear();
                SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("fts_history_search_sp", 0);
                try {
                    sharedPreferences.edit().putString(com.tencent.mm.bc.c.QV(), Base64.encodeToString(com.tencent.mm.bc.c.hKD.toByteArray(), 0)).apply();
                    x.i("MicroMsg.FTS.FTSHistorySearchLogic", "addHistory pbListString %s", new Object[]{r});
                    break;
                } catch (IOException e) {
                    break;
                }
            case 2:
                int c2 = f.c(map, DownloadSettingTable$Columns.TYPE, 0);
                c = f.c(map, "scene", 0);
                if (System.currentTimeMillis() - this.jzh > 1000) {
                    this.jzh = System.currentTimeMillis();
                    if (!com.tencent.mm.plugin.aj.a.g.zM(0)) {
                        x.e("MicroMsg.FTS.FTSWebViewLogic", "fts h5 template not avail");
                        break;
                    }
                    com.tencent.mm.bc.g.b(c2, c, com.tencent.mm.plugin.aj.a.h.NU("searchID"));
                    Intent QM = com.tencent.mm.bc.b.QM();
                    QM.putExtra("ftsneedkeyboard", true);
                    QM.putExtra("ftsbizscene", c);
                    QM.putExtra("ftsType", c2);
                    QM.putExtra("rawUrl", com.tencent.mm.bc.b.r(com.tencent.mm.bc.b.b(c, true, c2)));
                    QM.putExtra("key_load_js_without_delay", true);
                    com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QM);
                    break;
                }
                break;
            case 3:
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g Be = h.Be(f.c(map, "webview_instance_id", -1));
                c = f.c(map, "scene", 0);
                r = f.r(map, "query");
                if (c == 20 && !bh.ov(r)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fts_key_new_query", r);
                    try {
                        if (Be.fBH != null) {
                            Be.fBH.n(com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX, bundle);
                            break;
                        }
                    } catch (Exception e2) {
                        x.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + e2.getMessage());
                        break;
                    }
                }
                x.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", new Object[]{Integer.valueOf(c), r});
                break;
                break;
        }
        return false;
    }

    public final String bPf() {
        String n = n(20, 0, true);
        if (this.tmk.get(n) == null) {
            b bVar = new b(this, (byte) 0);
            bVar.eg(20, 0);
            this.tmk.put(n, bVar);
        }
        b bVar2 = (b) this.tmk.get(n);
        n = bVar2.isAvailable() ? bVar2.fwM : "";
        return bh.ov(n) ? "" : n;
    }

    public final boolean ac(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData: %s", new Object[]{map});
        int c = f.c(map, "scene", 0);
        int c2 = f.c(map, DownloadSettingTable$Columns.TYPE, 0);
        int c3 = f.c(map, "requestType", 0);
        int o = bh.o(map.get("webview_instance_id"), -1);
        String str = (String) map.get("requestId");
        boolean t = f.t(map, "ignoreCache");
        String n;
        if (c3 == 0) {
            b bVar;
            n = n(c, c2, true);
            if (this.tmk.get(n) == null) {
                bVar = new b(this, (byte) 0);
                bVar.eg(c, c2);
                this.tmk.put(n, bVar);
            }
            bVar = (b) this.tmk.get(n);
            if (!(bh.ov(bVar.fwM) || t)) {
                x.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d, cache %s", new Object[]{Integer.valueOf(o), bVar.fwM});
                if (!(bVar.scene == 20 && bVar.type == 0 && (bVar.hMl || !bVar.isAvailable()))) {
                    h.Be(o).c(c3, bVar.fwM, 1, str);
                }
            }
            if (!bVar.isAvailable() || t) {
                ar.CG().a(1048, this);
                x.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[]{Integer.valueOf(o)});
                this.tmm = new com.tencent.mm.bc.h(c, c2, com.tencent.mm.plugin.aj.a.g.zN(0), o, w.eL(ac.getContext()), com.tencent.mm.plugin.aj.a.h.NT("discoverSearchEntry").optLong("guideParam"), str);
                ar.CG().a(this.tmm, 0);
            } else {
                x.i("MicroMsg.FTS.FTSWebViewLogic", "hit the cache: %d %d %d %d, data %s", new Object[]{Integer.valueOf(bVar.scene), Long.valueOf(bVar.tmB), Long.valueOf(bVar.tmC), Integer.valueOf(bVar.type), bVar.fwM});
                if (bVar.scene == 20 && bVar.type == 0) {
                    com.tencent.mm.bc.g.a(bVar.scene, 0, bVar.lEK, bVar.type, 2, bVar.bPh(), 1);
                } else {
                    com.tencent.mm.bc.g.a(bVar.scene, 0, bVar.lEK, bVar.type, 1, "", 0);
                }
                return false;
            }
        }
        asq QX = com.tencent.mm.bc.d.QX();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (c = QX.ksP.size() - 1; c >= 0; c--) {
                JSONObject jSONObject3 = new JSONObject();
                asp com_tencent_mm_protocal_c_asp = (asp) QX.ksP.get(c);
                if (s.gE(com_tencent_mm_protocal_c_asp.vIy)) {
                    com.tencent.mm.ag.d jS = com.tencent.mm.ag.f.jS(com_tencent_mm_protocal_c_asp.vIy);
                    if (jS != null) {
                        jSONObject3.put("avatarUrl", jS.field_brandIconURL);
                        jSONObject3.put("userName", jS.field_username);
                        jSONObject3.put("nickName", r.gu(jS.field_username));
                        jSONArray2.put(jSONObject3);
                    }
                }
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put(DownloadSettingTable$Columns.TYPE, 5);
            jSONObject2.put("title", "");
            jSONArray.put(jSONObject2);
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
            x.d("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[]{jSONObject.toString()});
            h.Be(o).c(1, n, 1, str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "gen mostSearchBizContactList error", new Object[0]);
        }
        return false;
    }

    public final boolean ad(Map<String, Object> map) {
        g zY;
        int i = 1;
        int o = bh.o(map.get("webview_instance_id"), -1);
        if (this.tmn.get(Integer.valueOf(201)) == null) {
            zY = g.zY(201);
            if (zY != null) {
                this.tmn.put(Integer.valueOf(201), zY);
            }
        }
        zY = (g) this.tmn.get(Integer.valueOf(201));
        if (zY != null) {
            h.Be(o).T(zY.fwM, 1, zY.bPi() ? 1 : 0);
            i = zY.bPi();
        }
        if (i != 0) {
            ar.CG().a(1866, this);
            com.tencent.mm.ae.k gVar = new g();
            if (map != null) {
                gVar.fDl = f.c(map, "webview_instance_id", -1);
            }
            ar.CG().a(gVar, 0);
        }
        return false;
    }

    public final boolean a(Map<String, Object> map, com.tencent.mm.plugin.webview.ui.tools.jsapi.g gVar) {
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        Bundle bundle;
        int c;
        String r;
        Intent intent;
        Object obj;
        int c2;
        Map a;
        String zH;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "openSearchWebView %s", new Object[]{map.toString()});
        int VI = bh.VI((String) map.get("actionType"));
        int c3 = f.c(map, DownloadSettingTable$Columns.TYPE, 0);
        String str5 = (String) map.get("extParams");
        String str6 = (String) map.get("jumpTo");
        String str7 = (String) map.get("navBarColor");
        String str8 = (String) map.get("nativeConfig");
        if (!TextUtils.isEmpty(str8)) {
            try {
                JSONObject jSONObject = new JSONObject(str8);
                if (jSONObject.has("title")) {
                    str8 = jSONObject.optString("title");
                } else {
                    str8 = null;
                }
                str = str8;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
            }
            i = 0;
            if (!bh.ov(str7)) {
                try {
                    i = Color.parseColor(str7);
                } catch (IllegalArgumentException e2) {
                    x.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e2.getMessage());
                    return true;
                }
            }
            str2 = (String) map.get("statusBarStyle");
            str3 = (String) map.get("tagId");
            str4 = (String) map.get("sessionId");
            switch (VI) {
                case 1:
                    switch (c3) {
                        case 1:
                            a(af(map), false);
                            break;
                        case 8:
                            f.r(map, "snsid");
                            str6 = f.r(map, "objectXmlDesc");
                            str7 = f.r(map, "userName");
                            boolean t = f.t(map, "fromMusicItem");
                            f.bRy();
                            o(str6, str7, t);
                            break;
                        case 32:
                            a(ag(map));
                            break;
                        default:
                            str6 = f.r(map, "jumpUrl");
                            x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{str6});
                            bundle = null;
                            if (gVar != null) {
                                bundle = gVar.bUI();
                            }
                            if (!bh.ov(str6)) {
                                f.bRy();
                                a(str6, bundle, i, str2, "", 0);
                                break;
                            }
                            break;
                    }
                case 2:
                    str6 = f.r(map, "jumpUrl");
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{str6});
                    bundle = null;
                    if (gVar != null) {
                        bundle = gVar.bUI();
                    }
                    if (!bh.ov(str6)) {
                        f.bRy();
                        a(str6, bundle, i, str2, "", 0);
                        break;
                    }
                    break;
                case 3:
                    str7 = f.r(map, "query");
                    c = f.c(map, "scene", 0);
                    r = f.r(map, "searchId");
                    intent = new Intent();
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("key_load_js_without_delay", true);
                    intent.putExtra("ftsQuery", str7);
                    intent.putExtra("ftsType", c3);
                    intent.putExtra("customize_status_bar_color", i);
                    intent.putExtra("status_bar_style", str2);
                    intent.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str6));
                    if (str != null) {
                        intent.putExtra("title", str);
                    }
                    if (com.tencent.mm.bc.m.Rj()) {
                        obj = f.c(map, "isWeAppMore", 0) != 1 ? 1 : null;
                        c2 = f.c(map, "tabPageType", 0);
                        if (obj == null) {
                            a = com.tencent.mm.bc.b.a(c, false, c3, str5);
                            a.put("query", str7);
                            a.put("searchId", r);
                            if (!TextUtils.isEmpty(str4)) {
                                a.put("sessionId", str4);
                                intent.putExtra("sessionId", str4);
                            }
                            zH = com.tencent.mm.plugin.aj.a.g.zH(c);
                            a.put("subSessionId", zH);
                            intent.putExtra("subSessionId", zH);
                            intent.putExtra("rawUrl", com.tencent.mm.bc.b.c(c, a));
                            intent.putExtra("ftsQuery", str7);
                            intent.putExtra("customize_status_bar_color", i);
                            intent.putExtra("status_bar_style", str2);
                            intent.putExtra("tabId", str3);
                            if (c2 == 1) {
                                if (c != 20 || c == 22 || c == 33) {
                                    obj = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                                } else {
                                    obj = ".ui.tools.fts.FTSSearchTabWebViewUI";
                                }
                                if (!TextUtils.isEmpty(obj)) {
                                    com.tencent.mm.bm.d.b(ac.getContext(), "webview", obj, intent);
                                    break;
                                }
                            }
                            intent.putExtra("ftscaneditable", false);
                            com.tencent.mm.bc.b.a(ac.getContext(), str7, intent, str, str5, r, str4, zH);
                            return false;
                        }
                        a = com.tencent.mm.bc.m.a(c, false, c3, str5);
                        a.put("query", str7);
                        a.put("searchId", r);
                        a.put("subType", String.valueOf(f.c(map, "subType", 0)));
                        a.put("isWeAppMore", String.valueOf(f.c(map, "isWeAppMore", 0)));
                        str7 = com.tencent.mm.modelappbrand.b.IU();
                        a.put("sessionId", str7);
                        intent.putExtra("key_session_id", str7);
                        intent.putExtra("rawUrl", com.tencent.mm.bc.m.r(a));
                        intent.putExtra("ftsbizscene", c);
                        intent.putExtra("customize_status_bar_color", i);
                        intent.putExtra("status_bar_style", str2);
                        if (c != 20 || c == 22) {
                            str6 = ".ui.AppBrandSOSUI";
                        } else {
                            str6 = ".ui.AppBrandSearchUI";
                        }
                        com.tencent.mm.bm.d.b(ac.getContext(), "appbrand", str6, intent);
                        break;
                    }
                    a = com.tencent.mm.bc.b.bj(c, c3);
                    a.put("query", str7);
                    a.put("searchId", r);
                    intent.putExtra("rawUrl", com.tencent.mm.bc.b.c(c, a));
                    if (c != 20 || c == 22 || c == 33) {
                        str6 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str6 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bm.d.b(ac.getContext(), "webview", str6, intent);
                    break;
                    break;
                case 4:
                    com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.fts.FtsBrowseHistoryUI", new Intent());
                    break;
            }
            return false;
        }
        str = null;
        i = 0;
        if (bh.ov(str7)) {
            i = Color.parseColor(str7);
        }
        str2 = (String) map.get("statusBarStyle");
        str3 = (String) map.get("tagId");
        str4 = (String) map.get("sessionId");
        switch (VI) {
            case 1:
                switch (c3) {
                    case 1:
                        a(af(map), false);
                        break;
                    case 8:
                        f.r(map, "snsid");
                        str6 = f.r(map, "objectXmlDesc");
                        str7 = f.r(map, "userName");
                        boolean t2 = f.t(map, "fromMusicItem");
                        f.bRy();
                        o(str6, str7, t2);
                        break;
                    case 32:
                        a(ag(map));
                        break;
                    default:
                        str6 = f.r(map, "jumpUrl");
                        x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{str6});
                        bundle = null;
                        if (gVar != null) {
                            bundle = gVar.bUI();
                        }
                        if (bh.ov(str6)) {
                            f.bRy();
                            a(str6, bundle, i, str2, "", 0);
                            break;
                        }
                        break;
                }
            case 2:
                str6 = f.r(map, "jumpUrl");
                x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{str6});
                bundle = null;
                if (gVar != null) {
                    bundle = gVar.bUI();
                }
                if (bh.ov(str6)) {
                    f.bRy();
                    a(str6, bundle, i, str2, "", 0);
                    break;
                }
                break;
            case 3:
                str7 = f.r(map, "query");
                c = f.c(map, "scene", 0);
                r = f.r(map, "searchId");
                intent = new Intent();
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsQuery", str7);
                intent.putExtra("ftsType", c3);
                intent.putExtra("customize_status_bar_color", i);
                intent.putExtra("status_bar_style", str2);
                intent.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str6));
                if (str != null) {
                    intent.putExtra("title", str);
                }
                if (com.tencent.mm.bc.m.Rj()) {
                    a = com.tencent.mm.bc.b.bj(c, c3);
                    a.put("query", str7);
                    a.put("searchId", r);
                    intent.putExtra("rawUrl", com.tencent.mm.bc.b.c(c, a));
                    if (c != 20) {
                        break;
                    }
                    str6 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    com.tencent.mm.bm.d.b(ac.getContext(), "webview", str6, intent);
                    break;
                }
                if (f.c(map, "isWeAppMore", 0) != 1) {
                }
                c2 = f.c(map, "tabPageType", 0);
                if (obj == null) {
                    a = com.tencent.mm.bc.m.a(c, false, c3, str5);
                    a.put("query", str7);
                    a.put("searchId", r);
                    a.put("subType", String.valueOf(f.c(map, "subType", 0)));
                    a.put("isWeAppMore", String.valueOf(f.c(map, "isWeAppMore", 0)));
                    str7 = com.tencent.mm.modelappbrand.b.IU();
                    a.put("sessionId", str7);
                    intent.putExtra("key_session_id", str7);
                    intent.putExtra("rawUrl", com.tencent.mm.bc.m.r(a));
                    intent.putExtra("ftsbizscene", c);
                    intent.putExtra("customize_status_bar_color", i);
                    intent.putExtra("status_bar_style", str2);
                    if (c != 20) {
                        break;
                    }
                    str6 = ".ui.AppBrandSOSUI";
                    com.tencent.mm.bm.d.b(ac.getContext(), "appbrand", str6, intent);
                    break;
                }
                a = com.tencent.mm.bc.b.a(c, false, c3, str5);
                a.put("query", str7);
                a.put("searchId", r);
                if (TextUtils.isEmpty(str4)) {
                    a.put("sessionId", str4);
                    intent.putExtra("sessionId", str4);
                }
                zH = com.tencent.mm.plugin.aj.a.g.zH(c);
                a.put("subSessionId", zH);
                intent.putExtra("subSessionId", zH);
                intent.putExtra("rawUrl", com.tencent.mm.bc.b.c(c, a));
                intent.putExtra("ftsQuery", str7);
                intent.putExtra("customize_status_bar_color", i);
                intent.putExtra("status_bar_style", str2);
                intent.putExtra("tabId", str3);
                if (c2 == 1) {
                    if (c != 20) {
                        break;
                    }
                    obj = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    if (TextUtils.isEmpty(obj)) {
                        com.tencent.mm.bm.d.b(ac.getContext(), "webview", obj, intent);
                        break;
                    }
                }
                intent.putExtra("ftscaneditable", false);
                com.tencent.mm.bc.b.a(ac.getContext(), str7, intent, str, str5, r, str4, zH);
                return false;
                break;
            case 4:
                com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.fts.FtsBrowseHistoryUI", new Intent());
                break;
        }
        return false;
    }

    public final boolean a(Map<String, Object> map, com.tencent.mm.plugin.webview.ui.tools.jsapi.g gVar, String str) {
        this.tmo.tmJ = true;
        boolean t = f.t(map, "isTeachPage");
        boolean t2 = f.t(map, "isMoreButton");
        Object obj = f.c(map, "isFeedBack", 0) == 1 ? 1 : null;
        Object obj2 = f.c(map, "isWeAppMore", 0) == 1 ? 1 : null;
        String r = f.r(map, "sessionId");
        String str2 = (String) map.get("navBarColor");
        int i = 0;
        if (!bh.ov(str2)) {
            try {
                i = Color.parseColor(str2);
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e.getMessage());
                return true;
            }
        }
        String str3 = (String) map.get("statusBarStyle");
        String r2;
        Bundle bundle;
        if (obj == null) {
            int c = f.c(map, DownloadSettingTable$Columns.TYPE, 0);
            int c2 = f.c(map, "opType", 0);
            if (c2 <= 0) {
                if (!t2) {
                    str2 = (String) map.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[]{Integer.valueOf(c), str2});
                    switch (c) {
                        case 1:
                            a(af(map), false);
                            break;
                        case 8:
                            f.r(map, "snsid");
                            str2 = f.r(map, "objectXmlDesc");
                            r2 = f.r(map, "userName");
                            boolean t3 = f.t(map, "fromMusicItem");
                            f.bRy();
                            o(str2, r2, t3);
                            break;
                        case 32:
                            a(ag(map));
                            break;
                        default:
                            str2 = f.r(map, "jumpUrl");
                            x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[]{str2, f.r(map, "publishId"), Integer.valueOf(f.c(map, "payScene", 0))});
                            Bundle bundle2 = null;
                            if (gVar != null) {
                                bundle2 = gVar.bUI();
                            }
                            if (!bh.ov(str2)) {
                                f.bRy();
                                a(str2, bundle2, i, str3, r4, r5);
                                break;
                            }
                            break;
                    }
                }
                str2 = f.r(map, "query");
                i = f.c(map, "scene", 0);
                str3 = f.r(map, "searchId");
                Intent intent = new Intent();
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsQuery", str2);
                intent.putExtra("ftsType", c);
                intent.putExtra("sessionId", r);
                Map bj;
                if (!com.tencent.mm.bc.m.Rj()) {
                    bj = com.tencent.mm.bc.b.bj(i, c);
                    try {
                        bj.put("query", p.encode(str2, "UTF-8"));
                    } catch (Exception e2) {
                        bj.put("query", str2);
                    }
                    bj.put("searchId", str3);
                    bj.put("sessionId", r);
                    str2 = com.tencent.mm.plugin.aj.a.g.zH(bh.VI((String) bj.get("scene")));
                    bj.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", r);
                    intent.putExtra("rawUrl", com.tencent.mm.bc.b.c(i, bj));
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bm.d.b(ac.getContext(), "webview", str2, intent);
                } else if (obj2 != null) {
                    bj = com.tencent.mm.bc.m.a(i, false, c, str);
                    try {
                        bj.put("query", p.encode(str2, "UTF-8"));
                    } catch (Exception e3) {
                        bj.put("query", str2);
                    }
                    bj.put("searchId", str3);
                    bj.put("subType", String.valueOf(f.c(map, "subType", 0)));
                    bj.put("isWeAppMore", String.valueOf(f.c(map, "isWeAppMore", 0)));
                    bj.put("sessionId", r);
                    str3 = com.tencent.mm.modelappbrand.b.IU();
                    bj.put("sessionId", str3);
                    str2 = com.tencent.mm.plugin.aj.a.g.zH(bh.VI((String) bj.get("scene")));
                    bj.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", str3);
                    intent.putExtra("rawUrl", com.tencent.mm.bc.m.r(bj));
                    intent.putExtra("ftsbizscene", i);
                    if (i == 20 || i == 22 || i == 24) {
                        str2 = ".ui.AppBrandSOSUI";
                    } else {
                        str2 = ".ui.AppBrandSearchUI";
                    }
                    com.tencent.mm.bm.d.b(ac.getContext(), "appbrand", str2, intent);
                } else {
                    bj = com.tencent.mm.bc.b.a(i, false, c, str);
                    try {
                        bj.put("query", p.encode(str2, "UTF-8"));
                    } catch (Exception e4) {
                        bj.put("query", str2);
                    }
                    bj.put("searchId", str3);
                    bj.put("sessionId", r);
                    str2 = com.tencent.mm.plugin.aj.a.g.zH(bh.VI((String) bj.get("scene")));
                    bj.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("rawUrl", com.tencent.mm.bc.b.c(i, bj));
                    intent.putExtra("key_session_id", r);
                    intent.putExtra("searchId", str3);
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bm.d.b(ac.getContext(), "webview", str2, intent);
                }
            } else {
                switch (c2) {
                    case 2:
                        a(af(map), t);
                        break;
                    case 3:
                        c af = af(map);
                        if (!s.gE(af.username)) {
                            a(af, t);
                            break;
                        }
                        com.tencent.mm.bc.d.lT(af.username);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Chat_User", af.username);
                        intent2.putExtra("finish_direct", true);
                        intent2.putExtra("key_temp_session_show_type", 0);
                        com.tencent.mm.bm.d.a(ac.getContext(), ".ui.chatting.ChattingUI", intent2);
                        break;
                    case 4:
                        r2 = f.r(map, "jumpUrl");
                        bundle = null;
                        if (gVar != null) {
                            bundle = gVar.bUI();
                        }
                        f.bRy();
                        e(r2, bundle);
                        break;
                    default:
                        break;
                }
            }
        }
        r2 = f.r(map, "jumpUrl");
        bundle = null;
        if (gVar != null) {
            bundle = gVar.bUI();
        }
        f.bRy();
        e(r2, bundle);
        return false;
    }

    public final boolean ae(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[]{map.toString()});
        bcp com_tencent_mm_protocal_c_bcp = new bcp();
        com_tencent_mm_protocal_c_bcp.wIO = f.r(map, "logString");
        ar.CG().a(1134, this);
        ar.CG().a(new j(com_tencent_mm_protocal_c_bcp), 0);
        return false;
    }

    private static void e(String str, Bundle bundle) {
        a(str, bundle, 0, "", "", 0);
    }

    private static void a(String str, Bundle bundle, int i, String str2, String str3, int i2) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("convertActivityFromTranslucent", false);
        intent.putExtra("customize_status_bar_color", i);
        intent.putExtra("status_bar_style", str2);
        if (!bh.ov(str3)) {
            intent.putExtra("prePublishId", str3);
            intent.putExtra("KPublisherId", str3);
        } else if (!(bundle == null || bh.ov(str))) {
            String str4 = bundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.a.g.s(str.getBytes());
            intent.putExtra("prePublishId", str4);
            intent.putExtra("KPublisherId", str4);
        }
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    private static void o(String str, String str2, boolean z) {
        bnp mG = ((m) g.h(m.class)).mG(str);
        Intent intent = new Intent();
        intent.putExtra("INTENT_TALKER", str2);
        intent.putExtra("INTENT_SNSID", new BigInteger(mG.nGJ).longValue());
        intent.putExtra("SNS_FROM_MUSIC_ITEM", z);
        try {
            intent.putExtra("INTENT_SNS_TIMELINEOBJECT", mG.toByteArray());
        } catch (IOException e) {
        }
        com.tencent.mm.bm.d.b(ac.getContext(), "sns", ".ui.SnsCommentDetailUI", intent);
    }

    private static void a(d dVar) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", dVar.username);
        intent.putExtra("Contact_Nick", dVar.fpL);
        intent.putExtra("Contact_Alias", dVar.gfN);
        intent.putExtra("Contact_Sex", dVar.fWf);
        intent.putExtra("Contact_Scene", dVar.scene);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(dVar.country, dVar.fWp, dVar.fWq));
        intent.putExtra("Contact_Signature", dVar.signature);
        intent.putExtra("Contact_KSnsIFlag", dVar.tmH);
        intent.putExtra("Contact_full_Mobile_MD5", dVar.fDj);
        com.tencent.mm.bm.d.b(ac.getContext(), "profile", ".ui.ContactInfoUI", intent);
    }

    private static void a(c cVar, boolean z) {
        int i;
        if (cVar.tjR == 2) {
            i = 89;
        } else if (z) {
            i = 85;
        } else if (cVar.scene != 3 && cVar.scene != 16) {
            i = 39;
        } else if (cVar.tmF) {
            i = 88;
        } else {
            i = 87;
        }
        com.tencent.mm.bc.d.lT(cVar.username);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", cVar.username);
        intent.putExtra("Contact_Nick", cVar.fpL);
        intent.putExtra("Contact_BrandIconURL", cVar.phJ);
        intent.putExtra("Contact_Signature", cVar.signature);
        intent.putExtra("Contact_VUser_Info_Flag", cVar.tmE);
        intent.putExtra("Contact_Scene", i);
        if (cVar.piM != null) {
            try {
                intent.putExtra("Contact_customInfo", cVar.piM.toByteArray());
            } catch (IOException e) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("Contact_Ext_Args_Search_Id", cVar.iRN);
        bundle.putString("Contact_Ext_Args_Query_String", cVar.fDj);
        bundle.putInt("Contact_Scene", i);
        bundle.putInt("Contact_Ext_Args_Index", cVar.position);
        bundle.putString("Contact_Ext_Extra_Params", cVar.tmG);
        intent.putExtra("Contact_Ext_Args", bundle);
        com.tencent.mm.bm.d.b(ac.getContext(), "profile", ".ui.ContactInfoUI", intent);
    }

    public static int c(Map<String, Object> map, Map<String, Object> map2) {
        try {
            JSONArray jSONArray = new JSONArray(f.r(map, SlookAirButtonFrequentContactAdapter.DATA));
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object string;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has(SlookAirButtonFrequentContactAdapter.ID)) {
                    string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                } else {
                    String str = "";
                }
                String string2 = jSONObject.has("userName") ? jSONObject.getString("userName") : "";
                String gu = r.gu(string2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, string);
                jSONObject2.put("userName", string2);
                jSONObject2.put("displayName", gu);
                jSONArray2.put(jSONObject2);
            }
            map2.put("ret", Integer.valueOf(0));
            map2.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray2.toString());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        return 0;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        String n;
        int i3;
        String Fn;
        File file;
        byte[] bArr;
        if (kVar instanceof com.tencent.mm.bc.h) {
            ar.CG().b(1048, this);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.bc.h hVar = (com.tencent.mm.bc.h) kVar;
                b bVar = new b(this, (byte) 0);
                bVar.scene = hVar.scene;
                bVar.tmB = (long) hVar.hKX.wwL;
                bVar.fwM = hVar.hKX.vOe;
                bVar.tmC = System.currentTimeMillis() / 1000;
                bVar.lEK = hVar.hKX.wwM;
                bVar.type = hVar.hKY;
                n = n(bVar.scene, bVar.type, true);
                x.i("MicroMsg.FTS.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[]{bVar.fwM});
                if (!bh.ov(bVar.fwM)) {
                    h.Be(hVar.fDl).c(0, bVar.fwM, 0, hVar.hKZ);
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[]{bVar.fwM});
                }
                this.tmk.put(n, bVar);
                if (bVar.tmB == 0) {
                    i3 = bVar.scene;
                    int i4 = bVar.type;
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "delete biz cache %d %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                    ar.Hg();
                    Fn = com.tencent.mm.z.c.Fn();
                    file = new File(Fn, n(i3, i4, true));
                    if (file.exists()) {
                        file.delete();
                    }
                    file = new File(Fn, n(i3, i4, false));
                    if (file.exists()) {
                        file.delete();
                    }
                } else {
                    apx com_tencent_mm_protocal_c_apx = new apx();
                    com_tencent_mm_protocal_c_apx.scene = bVar.scene;
                    com_tencent_mm_protocal_c_apx.vOe = bVar.fwM;
                    com_tencent_mm_protocal_c_apx.wwE = bVar.tmB;
                    com_tencent_mm_protocal_c_apx.wwF = bVar.tmC;
                    com_tencent_mm_protocal_c_apx.vPs = bVar.lEK;
                    com_tencent_mm_protocal_c_apx.ktN = bVar.type;
                    bArr = null;
                    try {
                        bArr = com_tencent_mm_protocal_c_apx.toByteArray();
                    } catch (IOException e) {
                    }
                    if (bArr != null) {
                        ar.Hg();
                        file = new File(com.tencent.mm.z.c.Fn(), n(bVar.scene, bVar.type, true));
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr, bArr.length);
                        x.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(bArr.length)});
                    } else {
                        x.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile fail");
                    }
                }
                if (bVar.scene == 20 && bVar.type == 0) {
                    com.tencent.mm.bc.g.a(bVar.scene, 1, bVar.lEK, bVar.type, 2, bVar.bPh(), 1);
                    return;
                } else {
                    com.tencent.mm.bc.g.a(bVar.scene, 1, bVar.lEK, bVar.type, 1, "", 0);
                    return;
                }
            }
            x.e("MicroMsg.FTS.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar instanceof j) {
            ar.CG().b(1134, this);
        } else if (kVar instanceof k) {
            ar.CG().b(1161, this);
            if (i == 0 && i2 == 0) {
                n = this.tml.Jc();
                ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(n);
                    JSONArray optJSONArray = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    Fn = jSONObject.optString("suggestionID", "");
                    jSONObject = null;
                    int i5 = 0;
                    while (i5 < optJSONArray.length()) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                        if (optJSONObject.optInt(DownloadSettingTable$Columns.TYPE) != 1) {
                            optJSONObject = jSONObject;
                        }
                        i5++;
                        jSONObject = optJSONObject;
                    }
                    if (jSONObject != null) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("items");
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            String optString = optJSONArray2.optJSONObject(i3).optString("word");
                            if (!bh.ov(optString)) {
                                arrayList.add(optString);
                            }
                        }
                    }
                    n = Fn;
                } catch (Exception e2) {
                    n = "";
                }
                ag.y(new 2(this, n, arrayList));
            }
        } else if (kVar instanceof g) {
            ar.CG().b(1866, this);
            if (i == 0 && i2 == 0) {
                g gVar = (g) kVar;
                if (gVar.fDl != -1) {
                    h.Be(gVar.fDl).T(((bxi) gVar.gJQ.hmh.hmo).fwM, 0, 0);
                }
                g gVar2 = new g((bxi) gVar.gJQ.hmh.hmo);
                apy com_tencent_mm_protocal_c_apy = new apy();
                com_tencent_mm_protocal_c_apy.rYW = gVar2.scene;
                com_tencent_mm_protocal_c_apy.vOe = gVar2.fwM;
                com_tencent_mm_protocal_c_apy.wwG = gVar2.suO;
                com_tencent_mm_protocal_c_apy.wwF = gVar2.tmC;
                bArr = null;
                try {
                    bArr = com_tencent_mm_protocal_c_apy.toByteArray();
                } catch (IOException e3) {
                }
                if (bArr != null) {
                    ar.Hg();
                    file = new File(com.tencent.mm.z.c.Fn(), g.zZ(gVar2.scene));
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr, bArr.length);
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", new Object[]{Integer.valueOf(gVar2.scene)});
                } else {
                    x.w("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", new Object[]{Integer.valueOf(gVar2.scene)});
                }
                this.tmn.put(Integer.valueOf(gVar2.scene), gVar2);
            }
        }
    }

    private c af(Map<String, Object> map) {
        c cVar = new c(this, (byte) 0);
        cVar.username = f.r(map, "userName");
        cVar.fpL = f.r(map, "nickName");
        cVar.phJ = f.r(map, "headHDImgUrl");
        cVar.tmE = f.c(map, "verifyFlag", 0);
        cVar.signature = f.r(map, "signature");
        cVar.scene = f.c(map, "scene", 0);
        cVar.tjR = f.c(map, "sceneActionType", 1);
        cVar.piM = new pq();
        cVar.piM.hvH = f.c(map, "brandFlag", 0);
        cVar.piM.hvK = f.r(map, "iconUrl");
        cVar.piM.hvJ = f.r(map, "brandInfo");
        cVar.piM.hvI = f.r(map, "externalInfo");
        cVar.iRN = f.r(map, "searchId");
        cVar.fDj = f.r(map, "query");
        cVar.position = f.c(map, "position", 0);
        cVar.tmF = f.t(map, "isCurrentDetailPage");
        cVar.tmG = f.r(map, "extraParams");
        return cVar;
    }

    private d ag(Map<String, Object> map) {
        int i = 3;
        d dVar = new d(this, (byte) 0);
        dVar.username = f.r(map, "userName");
        dVar.fpL = f.r(map, "nickName");
        dVar.gfN = f.r(map, "alias");
        dVar.signature = f.r(map, "signature");
        dVar.fWf = f.c(map, "sex", 0);
        dVar.country = f.r(map, "country");
        dVar.fWq = f.r(map, "city");
        dVar.fWp = f.r(map, "province");
        dVar.tmH = f.c(map, "snsFlag", 0);
        String r = f.r(map, "query");
        if (bh.ov(r)) {
            dVar.scene = 3;
        } else {
            if (Character.isDigit(r.charAt(0))) {
                i = 15;
            }
            dVar.scene = i;
            if (dVar.scene == 15) {
                if ("mobile".equals(f.r(map, "matchType"))) {
                    dVar.fDj = r;
                } else {
                    dVar.scene = 1;
                }
            }
        }
        return dVar;
    }

    static String n(int i, int i2, boolean z) {
        String str = "FTS_BizCacheObj" + i + "-" + i2;
        String str2 = str + "-" + w.eL(ac.getContext());
        if (z) {
            return str2;
        }
        ar.Hg();
        if (new File(com.tencent.mm.z.c.Fn(), str2).exists()) {
            return str2;
        }
        return str;
    }

    public static boolean ah(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "setSearchInputWord %s", new Object[]{map});
        String r = f.r(map, "word");
        boolean t = f.t(map, "isInputChange");
        String r2 = f.r(map, "custom");
        String r3 = f.r(map, "tagList");
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Be = h.Be(bh.o(map.get("webview_instance_id"), -1));
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_new_query", r);
        bundle.putString("fts_key_custom_query", r2);
        bundle.putBoolean("fts_key_need_keyboard", t);
        bundle.putString("fts_key_tag_list", r3);
        try {
            if (Be.fBH != null) {
                Be.fBH.n(122, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + e.getMessage());
        }
        return false;
    }

    public final boolean ai(Map<String, Object> map) {
        String str = (String) map.get("query");
        String str2 = (String) map.get("sortedContacts");
        int VI = bh.VI((String) map.get("offset"));
        int VI2 = bh.VI((String) map.get("count"));
        int o = bh.o(map.get("webview_instance_id"), -1);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        List arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        if (this.tmq == null) {
            this.tmq = new com.tencent.mm.plugin.webview.fts.a.b();
        }
        com.tencent.mm.plugin.webview.fts.a.a dVar = new d(str, arrayList);
        if (this.tmr == null || !this.tmr.equals(dVar)) {
            this.tmr = dVar;
            this.tmq.a(dVar, new 5(this, VI, VI2, o));
        } else if (this.tmr.foh) {
            a(this.tmr, VI, VI2, o);
        }
        return false;
    }

    static void a(d dVar, int i, int i2, int i3) {
        JSONObject eh = dVar.eh(i, i2);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Be = h.Be(i3);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", eh.toString());
        try {
            if (Be.fBH != null) {
                Be.fBH.n(137, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
        }
    }
}
