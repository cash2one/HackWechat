package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ae.e;
import com.tencent.mm.bc.m;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.webview.fts.a.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.protocal.c.bnb;
import com.tencent.mm.protocal.c.bro;
import com.tencent.mm.protocal.c.bzr;
import com.tencent.mm.protocal.c.cbo;
import com.tencent.mm.protocal.c.ii;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements e {
    public a mMa;
    private k phA = new 2(this);
    public bzr tke;
    public int tlN = 0;
    public bzr tlO;
    com.tencent.mm.plugin.webview.fts.a.c tlP = new b();
    public a tlQ = new a(this, (byte) 0);
    public b tlR = new b(this, (byte) 0);

    static /* synthetic */ boolean zX(int i) {
        return i == 201;
    }

    public c() {
        x.d("MicroMsg.FTS.FTSWebSearchLogic", "create FTSWebSearchLogic");
    }

    public final boolean W(Map<String, Object> map) {
        JSONArray jSONArray;
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "getSearchData: %s", new Object[]{map.toString()});
        int c = f.c(map, "scene", 3);
        d dVar = new d();
        dVar.fod = f.r(map, "query");
        dVar.offset = f.c(map, "offset", 0);
        dVar.hKY = f.c(map, DownloadSettingTable$Columns.TYPE, 0);
        dVar.scene = c;
        dVar.tjS = f.r(map, "sugId");
        dVar.tjU = f.c(map, "sugType", 0);
        dVar.tjT = f.r(map, "prefixSug");
        dVar.tkf = f.r(map, "poiInfo");
        dVar.tjP = f.t(map, "isHomePage") ? 1 : 0;
        dVar.lEK = f.r(map, "searchId");
        if (map.containsKey("sessionId")) {
            dVar.fqu = f.r(map, "sessionId");
        }
        dVar.tjR = f.c(map, "sceneActionType", 1);
        dVar.tjW = f.c(map, "displayPattern", 2);
        dVar.tjX = f.c(map, "sugPosition", 0);
        dVar.tjY = f.r(map, "sugBuffer");
        dVar.hKZ = f.r(map, "requestId");
        dVar.fqu = f.r(map, "sessionId");
        dVar.tjs = f.r(map, "subSessionId");
        dVar.tkg = f.r(map, "tagId");
        String r = f.r(map, "extReqParams");
        if (!bh.ov(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (c = 0; c < jSONArray.length(); c++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(c);
                    or orVar = new or();
                    orVar.aAM = jSONObject.optString("key", "");
                    orVar.vXx = (long) jSONObject.optInt("uintValue", 0);
                    orVar.vXy = jSONObject.optString("textValue", "");
                    dVar.tka.add(orVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e, "commKvJSONArray", new Object[0]);
            }
        }
        r = f.r(map, "matchUser");
        if (!bh.ov(r)) {
            try {
                JSONObject jSONObject2 = new JSONObject(r);
                bro com_tencent_mm_protocal_c_bro = new bro();
                com_tencent_mm_protocal_c_bro.ksU = jSONObject2.optString("userName");
                com_tencent_mm_protocal_c_bro.wTn = jSONObject2.optString("matchWord");
                if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_bro.ksU)) {
                    dVar.tjQ.add(com_tencent_mm_protocal_c_bro);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        r = f.r(map, "prefixQuery");
        if (!bh.ov(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (c = 0; c < jSONArray.length(); c++) {
                    dVar.tjV.add(jSONArray.getString(c));
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e22, "prefixQueryJSONArray", new Object[0]);
            }
        }
        r = f.r(map, "tagInfo");
        if (!bh.ov(r)) {
            try {
                jSONObject2 = new JSONObject(r);
                dVar.tjZ = new bnb();
                dVar.tjZ.wQa = jSONObject2.optString("tagText");
                dVar.tjZ.wPZ = jSONObject2.optInt("tagType");
                dVar.tjZ.wQb = jSONObject2.optString("tagExtValue");
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        r = f.r(map, "numConditions");
        if (!bh.ov(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (c = 0; c < jSONArray.length(); c++) {
                    jSONObject = jSONArray.optJSONObject(c);
                    atl com_tencent_mm_protocal_c_atl = new atl();
                    com_tencent_mm_protocal_c_atl.wBz = jSONObject.optLong("from");
                    com_tencent_mm_protocal_c_atl.wBA = jSONObject.optLong("to");
                    com_tencent_mm_protocal_c_atl.wBy = jSONObject.optInt("field");
                    dVar.tkb.add(com_tencent_mm_protocal_c_atl);
                }
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        dVar.fDl = bh.o(map.get("webview_instance_id"), -1);
        dVar.ael = w.eL(ac.getContext());
        dVar.mLr = f.c(map, "subType", 0);
        if (m.Rj()) {
            dVar.tkc = f.c(map, "isWeAppMore", 0);
            if (dVar.tkc == 1) {
                dVar.tkd = new cbo();
                com.tencent.mm.sdk.b.b hwVar = new hw();
                com.tencent.mm.sdk.b.a.xef.m(hwVar);
                dVar.tkd.xaB = hwVar.fyo.fyp;
                dVar.tkd.xaD = com.tencent.mm.modelappbrand.b.hjy;
                dVar.tkd.xaC = f.c(map, "subType", 0);
                dVar.tkd.wRC = com.tencent.mm.modelappbrand.b.hjx;
                dVar.tkd.xaF = dVar.tjX;
                ar.Hg();
                Object obj = com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xtG, null);
                if (obj != null && (obj instanceof String)) {
                    dVar.tkd.xaE = (String) obj;
                }
            }
        }
        if (this.tlN == 1) {
            dVar.tke = this.tke;
        } else {
            dVar.tke = null;
        }
        if (dVar.scene == 33 && this.tlO != null) {
            if (dVar.tke == null) {
                dVar.tke = new bzr();
            }
            if (dVar.tke.wZo == null) {
                dVar.tke.wZo = new ii();
            }
            if (this.tlO.wZo != null) {
                dVar.tke.wZo.vOC = this.tlO.wZo.vOC;
                x.i("MicroMsg.FTS.FTSWebSearchLogic", "websearch from url [%s]", new Object[]{this.tlO.wZo.vOC});
            }
            this.tlO = null;
        }
        if (dVar.hKY == 262144 && this.tlO != null && this.tlO.wZo.vOz == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("isRefresh", 1);
            bundle.putString("widgetId", f.r(map, "widgetId"));
            dVar.tkh = bundle;
            dVar.tke = this.tlO;
            this.tlO = null;
        }
        a aVar = this.tlQ;
        if (aVar.tlX != null) {
            aVar.tlX.kpn = true;
        }
        aVar.tlX = new a(aVar, (byte) 0);
        aVar.tlX.hjF = dVar;
        aVar.tlW.execute(aVar.tlX);
        h.Be(dVar.fDl).c(dVar.hKY, dVar.fod, map);
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        String str2 = "MicroMsg.FTS.FTSWebSearchLogic";
        String str3 = "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(kVar != null ? kVar.getType() : 0);
        x.v(str2, str3, objArr);
        if (kVar instanceof com.tencent.mm.plugin.aj.a.a) {
            ar.CG().b(kVar.getType(), this);
            com.tencent.mm.plugin.aj.a.a aVar = (com.tencent.mm.plugin.aj.a.a) kVar;
            if (i == 0 && i2 == 0) {
                String Jc = aVar.Jc();
                cv(Jc, aVar.tjL);
                int Jd = aVar.Jd();
                x.i("MicroMsg.FTS.FTSWebSearchLogic", "callback %s", new Object[]{aVar.tjM});
                h.Be(aVar.tjL).a(Jc, aVar.bOO(), aVar.tjN, aVar.tjO);
                if (Jd > 0) {
                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "updateCode %d, need update", new Object[]{Integer.valueOf(Jd)});
                    com.tencent.mm.pluginsdk.i.a.b.b.c.bZm();
                    com.tencent.mm.pluginsdk.i.a.b.b.BH(27);
                    return;
                }
                return;
            }
            x.i("MicroMsg.FTS.FTSWebSearchLogic", "net scene fail %s", new Object[]{aVar.tjM});
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException e) {
            }
            h.Be(aVar.tjL).a(jSONObject.toString(), true, aVar.tjN, aVar.tjO);
        } else if (kVar instanceof com.tencent.mm.plugin.aj.a.b) {
            ar.CG().b(kVar.getType(), this);
            com.tencent.mm.plugin.aj.a.b bVar = (com.tencent.mm.plugin.aj.a.b) kVar;
            if (i == 0 && i2 == 0) {
                h.Be(bVar.tjL).PD(bVar.Jc());
                return;
            }
            x.i("MicroMsg.FTS.FTSWebSearchLogic", "net scene fail %s", new Object[]{bVar.iRL});
            h.Be(bVar.tjL).PD("{}");
        }
    }

    private static void cv(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null && jSONObject.optInt(DownloadSettingTable$Columns.TYPE) == 262144) {
                            x.i("MicroMsg.FTS.FTSWebSearchLogic", "reportRecvWidget found widget");
                            JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                            if (jSONArray2 != null) {
                                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                    jSONObject = jSONArray2.getJSONObject(i3);
                                    if (jSONObject != null) {
                                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "reportRecvWidget found widget appid %s", new Object[]{jSONObject.optString("appID")});
                                        g Be = h.Be(i);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("appid", r0);
                                        try {
                                            if (Be.fBH != null) {
                                                Be.fBH.n(com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, bundle);
                                            }
                                        } catch (RemoteException e) {
                                            x.w("MicroMsg.MsgHandler", "onRecvWidget exception" + e.getMessage());
                                        }
                                    }
                                }
                                continue;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                x.e("MicroMsg.FTS.FTSWebSearchLogic", "", new Object[]{e2});
            }
        }
    }

    public final boolean X(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "getSuggestionData %s", new Object[]{map});
        d dVar = new d();
        dVar.fod = f.r(map, "query");
        try {
            dVar.fod = URLDecoder.decode(dVar.fod, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        dVar.hKY = f.c(map, DownloadSettingTable$Columns.TYPE, 0);
        dVar.scene = f.c(map, "scene", 3);
        dVar.tjP = f.t(map, "isHomePage") ? 1 : 0;
        dVar.fDl = bh.o(map.get("webview_instance_id"), -1);
        dVar.tjV.add(f.r(map, "prefixQuery"));
        int c = f.c(map, "requestType", 0);
        dVar.mLr = f.c(map, "subtype", 0);
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "getSearchData, webviewID = %d", new Object[]{Integer.valueOf(dVar.fDl)});
        if (m.Rj()) {
            dVar.tkc = f.c(map, "isWeAppMore", 0);
            if (dVar.tkc == 1) {
                dVar.tkd = new cbo();
                com.tencent.mm.sdk.b.b hwVar = new hw();
                com.tencent.mm.sdk.b.a.xef.m(hwVar);
                dVar.tkd.xaB = hwVar.fyo.fyp;
                dVar.tkd.xaD = com.tencent.mm.modelappbrand.b.hjy;
                dVar.tkd.xaC = f.c(map, "subType", 0);
                dVar.tkd.wRC = com.tencent.mm.modelappbrand.b.hjx;
                ar.Hg();
                Object obj = com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xtG, null);
                if (obj != null && (obj instanceof String)) {
                    dVar.tkd.xaE = (String) obj;
                }
            }
        }
        switch (c) {
            case 0:
                b bVar = this.tlR;
                if (bVar.tlZ != null) {
                    ar.CG().b(bVar.tlZ.getType(), bVar.tlU);
                    ar.CG().c(bVar.tlZ);
                    bVar.tlZ = null;
                }
                if (bVar.tlZ == null) {
                    com.tencent.mm.plugin.aj.a.b nVar = !m.Rj() ? zX(dVar.scene) ? new n(dVar.fod, dVar.scene, dVar.fDl) : new k(dVar) : new k(dVar);
                    bVar.tlZ = nVar;
                    ar.CG().a(bVar.tlZ.getType(), bVar.tlU);
                    ar.CG().a(bVar.tlZ, 0);
                    break;
                }
                break;
            case 1:
                String str = dVar.fod;
                int i = dVar.hKY;
                int i2 = dVar.fDl;
                if (!bh.ov(str)) {
                    int[] iArr;
                    if (this.mMa != null) {
                        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).cancelSearchTask(this.mMa);
                        this.mMa = null;
                    }
                    switch (i) {
                        case 8:
                            iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
                            break;
                        default:
                            iArr = null;
                            break;
                    }
                    if (iArr != null) {
                        com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
                        gVar.mLR = 16;
                        gVar.fDj = str;
                        gVar.mLU = iArr;
                        gVar.mLW = 5;
                        gVar.mLY = com.tencent.mm.plugin.fts.a.c.b.mMz;
                        gVar.mLX = new HashSet();
                        gVar.mLZ = this.phA;
                        this.mMa = ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).search(2, gVar);
                        this.mMa.mLn = Integer.valueOf(i2);
                        break;
                    }
                }
                break;
            case 2:
                h.Be(dVar.fDl).PD(com.tencent.mm.bc.c.QW());
                break;
        }
        return false;
    }
}
