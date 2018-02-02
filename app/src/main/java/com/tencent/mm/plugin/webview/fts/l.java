package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bc.m;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.protocal.c.bnb;
import com.tencent.mm.protocal.c.bro;
import com.tencent.mm.protocal.c.cbo;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.d;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l implements e {
    public static final long tmO = ((long) (d.clS() + 500));
    private static l tmW = new l();
    private ag rmZ = new ag("RecommendLogic_worker");
    private Set<String> tmP;
    public a tmQ = new a(this, (byte) 0);
    public volatile boolean tmR;
    private volatile boolean tmS;
    public volatile CountDownLatch tmT;
    private volatile com.tencent.mm.plugin.aj.a.d tmU;
    public long tmV;
    public volatile boolean tmX;
    public c tmY = new c<ms>(this) {
        final /* synthetic */ l tmZ;

        {
            this.tmZ = r2;
            this.xen = ms.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.tmZ.bPl();
            return false;
        }
    };

    static /* synthetic */ boolean Aa(int i) {
        return i == 201;
    }

    static /* synthetic */ boolean Ab(int i) {
        return i == 21;
    }

    public l() {
        x.d("RecommendLogic", "create RecommendLogic");
        x.d("RecommendLogic", "create RecommendLogic, duplicate for patch fix");
        this.tmY.ceO();
        this.tmP = new HashSet();
        this.tmP.add(DownloadInfo.NETTYPE);
        this.tmP.add("time_zone_min");
        this.tmP.add("currentPage");
        this.tmP.add("is_prefetch");
        this.tmP.add(TencentLocation.EXTRA_DIRECTION);
        this.tmP.add("seq");
        this.tmP.add("client_exposed_info");
        this.tmP.add("requestId");
        this.tmP.add("recType");
        bPl();
    }

    public static l bPk() {
        return tmW;
    }

    private boolean g(Set<String> set) {
        return set == null || this.tmP.containsAll(set);
    }

    public final boolean W(Map<String, Object> map) {
        boolean z = true;
        x.i("RecommendLogic", "getSearchData: %s", new Object[]{map.toString()});
        h.Be(bh.o(map.get("webview_instance_id"), -1)).c(f.c(map, DownloadSettingTable$Columns.TYPE, 0), f.r(map, "query"), map);
        if (this.tmR) {
            this.tmR = false;
            int o = bh.o(map.get("webview_instance_id"), -1);
            if (this.tmU != null) {
                this.tmU.fDl = o;
            }
            if (g(aj(map))) {
                if (this.tmT != null) {
                    this.tmT.countDown();
                }
                if (this.tmU != null) {
                    x.i("RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[]{Integer.valueOf(this.tmU.fDl), this.tmU});
                }
            } else {
                x.e("RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
                this.tmS = true;
                if (this.tmT != null) {
                    this.tmT.countDown();
                }
                z = false;
            }
        } else {
            if (this.tmT != null) {
                this.tmT.countDown();
            }
            z = false;
        }
        if (!z) {
            this.tmQ.b(ak(map));
        }
        return false;
    }

    private static Set<String> aj(Map<String, Object> map) {
        Throwable e;
        String r = f.r(map, "extReqParams");
        if (bh.ov(r)) {
            return Collections.emptySet();
        }
        Set<String> hashSet;
        try {
            hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(r);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    or orVar = new or();
                    hashSet.add(jSONObject.optString("key", ""));
                }
                return hashSet;
            } catch (Exception e2) {
                e = e2;
                x.printErrStackTrace("RecommendLogic", e, "", new Object[0]);
                return hashSet;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            hashSet = null;
            e = th;
            x.printErrStackTrace("RecommendLogic", e, "", new Object[0]);
            return hashSet;
        }
    }

    private static com.tencent.mm.plugin.aj.a.d ak(Map<String, Object> map) {
        JSONArray jSONArray;
        int i;
        com.tencent.mm.plugin.aj.a.d dVar = new com.tencent.mm.plugin.aj.a.d();
        dVar.fod = f.r(map, "query");
        dVar.offset = f.c(map, "offset", 0);
        dVar.hKY = f.c(map, DownloadSettingTable$Columns.TYPE, 0);
        dVar.scene = f.c(map, "scene", 3);
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
                for (i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    or orVar = new or();
                    orVar.aAM = jSONObject.optString("key", "");
                    orVar.vXx = (long) jSONObject.optInt("uintValue", 0);
                    orVar.vXy = jSONObject.optString("textValue", "");
                    dVar.tka.add(orVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("RecommendLogic", e, "commKvJSONArray", new Object[0]);
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
                x.printErrStackTrace("RecommendLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        r = f.r(map, "prefixQuery");
        if (!bh.ov(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (i = 0; i < jSONArray.length(); i++) {
                    dVar.tjV.add(jSONArray.getString(i));
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("RecommendLogic", e22, "prefixQueryJSONArray", new Object[0]);
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
                x.printErrStackTrace("RecommendLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        r = f.r(map, "numConditions");
        if (!bh.ov(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.optJSONObject(i);
                    atl com_tencent_mm_protocal_c_atl = new atl();
                    com_tencent_mm_protocal_c_atl.wBz = jSONObject.optLong("from");
                    com_tencent_mm_protocal_c_atl.wBA = jSONObject.optLong("to");
                    com_tencent_mm_protocal_c_atl.wBy = jSONObject.optInt("field");
                    dVar.tkb.add(com_tencent_mm_protocal_c_atl);
                }
            } catch (Throwable e2222) {
                x.printErrStackTrace("RecommendLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        dVar.fDl = bh.o(map.get("webview_instance_id"), -1);
        dVar.ael = w.eL(ac.getContext());
        dVar.mLr = f.c(map, "subType", 0);
        if (m.Rj()) {
            dVar.tkc = f.c(map, "isWeAppMore", 0);
            if (dVar.tkc == 1) {
                dVar.tkd = new cbo();
                b hwVar = new hw();
                a.xef.m(hwVar);
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
        return dVar;
    }

    public final boolean ap(LinkedList<or> linkedList) {
        Set hashSet = new HashSet();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hashSet.add(((or) it.next()).aAM);
        }
        return this.tmP.equals(hashSet);
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "RecommendLogic";
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
                int Jd = aVar.Jd();
                x.i("RecommendLogic", "callback %s", new Object[]{aVar.tjM});
                b(aVar.tjL, Jc, aVar.bOO(), aVar.tjN);
                if (Jd > 0) {
                    x.i("RecommendLogic", "updateCode %d, need update", new Object[]{Integer.valueOf(Jd)});
                    com.tencent.mm.pluginsdk.i.a.b.b.c.bZm();
                    com.tencent.mm.pluginsdk.i.a.b.b.BH(27);
                    return;
                }
                return;
            }
            x.i("RecommendLogic", "net scene fail %s", new Object[]{aVar.tjM});
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException e) {
            }
            b(aVar.tjL, jSONObject.toString(), aVar.bOO(), aVar.tjN);
        }
    }

    private void b(int i, String str, boolean z, String str2) {
        final int i2 = i;
        final String str3 = str2;
        final String str4 = str;
        final boolean z2 = z;
        this.rmZ.F(new Runnable(this) {
            final /* synthetic */ l tmZ;

            public final void run() {
                if (this.tmZ.tmT != null) {
                    x.i("RecommendLogic", "waiting for countdown, %d", new Object[]{Long.valueOf(this.tmZ.tmT.getCount())});
                    try {
                        this.tmZ.tmT.await();
                    } catch (Throwable e) {
                        x.printErrStackTrace("RecommendLogic", e, "", new Object[0]);
                    }
                } else {
                    x.i("RecommendLogic", "count down latch null");
                }
                int i = i2;
                if (this.tmZ.tmU != null) {
                    i = this.tmZ.tmU.fDl;
                    if (this.tmZ.tmU.tki && this.tmZ.tmS) {
                        x.w("RecommendLogic", "ingore pre get data");
                        return;
                    }
                }
                x.i("RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[]{Integer.valueOf(i), str3, this.tmZ.tmU});
                h.Be(i).a(str4, z2, str3, null);
            }
        });
    }

    public static void start() {
        try {
            Looper.prepare();
        } catch (Exception e) {
        }
    }

    public final void bPl() {
        Object bOU = g.bOU();
        x.i("RecommendLogic", "config commKV %s", new Object[]{bOU});
        if (TextUtils.isEmpty(bOU)) {
            this.tmX = true;
        } else {
            this.tmX = g(new HashSet(Arrays.asList(bOU.split(","))));
        }
    }
}
