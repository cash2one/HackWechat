package com.tencent.mm.plugin.webview.fts;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ad.n;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements a {
    public c qRk = new c<pw>(this) {
        final /* synthetic */ d tmh;

        {
            this.tmh = r2;
            this.xen = pw.class.getName().hashCode();
        }

        private boolean a(pw pwVar) {
            if ((pwVar instanceof pw) && pwVar.fHB.fpr == 2) {
                x.i("MicroMsg.FTS.FTSWebViewImageLogic", "Download callback %s", new Object[]{pwVar.fHB.mediaId});
                if (this.tmh.tmb.containsKey(pwVar.fHB.mediaId)) {
                    synchronized (this.tmh.tmb) {
                        int intValue = ((Integer) this.tmh.tme.get(pwVar.fHB.mediaId)).intValue();
                        HashSet hashSet = (HashSet) this.tmh.tmb.get(pwVar.fHB.mediaId);
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            String str2 = "weixin://fts/sns?path=" + pwVar.fHB.path;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, str);
                                jSONObject.put("src", str2);
                            } catch (JSONException e) {
                            }
                            jSONArray.put(jSONObject);
                        }
                        h.Be(intValue).aO(0, jSONArray.toString());
                        this.tmh.tmb.remove(pwVar.fHB.mediaId);
                        this.tmh.tme.remove(pwVar.fHB.mediaId);
                    }
                }
            }
            return false;
        }
    };
    private volatile HashMap<String, HashSet<String>> tma = new HashMap();
    volatile HashMap<String, HashSet<String>> tmb = new HashMap();
    volatile HashMap<String, HashSet<String>> tmc = new HashMap();
    private volatile HashMap<String, Integer> tmd = new HashMap();
    volatile HashMap<String, Integer> tme = new HashMap();
    volatile HashMap<String, Integer> tmf = new HashMap();
    public c<fp> tmg = new 1(this);

    public d() {
        this.qRk.ceO();
        this.tmg.ceO();
        n.JQ().c(this);
    }

    public final boolean Y(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchAvatarList");
        String r = f.r(map, SlookAirButtonFrequentContactAdapter.DATA);
        int o = bh.o(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(r);
            JSONArray jSONArray2 = new JSONArray();
            Object obj = null;
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.ID);
                String optString2 = jSONObject.optString("userName");
                int optInt = jSONObject.optInt(DownloadSettingTable$Columns.TYPE);
                Object optString3 = jSONObject.optString("imageUrl");
                String optString4 = jSONObject.optString("bigImageUrl");
                switch (optInt) {
                    case 1:
                    case 4:
                    case 64:
                        break;
                    case 32:
                        com.tencent.mm.ad.h hVar = new com.tencent.mm.ad.h();
                        hVar.username = optString2;
                        hVar.hly = optString4;
                        hVar.hlx = optString3;
                        hVar.fDt = -1;
                        hVar.fWe = 3;
                        hVar.bA(true);
                        n.JQ().a(hVar);
                        break;
                }
                n.Jz();
                r = com.tencent.mm.ad.d.x(optString2, false);
                if (FileOp.bO(r)) {
                    x.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file exist %s", new Object[]{r});
                    optString3 = "weixin://fts/avatar?path=" + r;
                } else {
                    x.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file not exist %s", new Object[]{r});
                    this.tmd.put(optString2, Integer.valueOf(o));
                    HashSet hashSet = (HashSet) this.tma.get(optString2);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(optString);
                    this.tma.put(optString2, hashSet);
                    b.bZV().cm(optString2);
                    optString3 = obj;
                }
                if (optString3 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, optString);
                    jSONObject2.put("src", optString3);
                    jSONArray2.put(jSONObject2);
                    optString3 = null;
                }
                i++;
                obj = optString3;
            }
            if (jSONArray2.length() > 0) {
                h.Be(o).aO(0, jSONArray2.toString());
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewImageLogic", e, "", new Object[0]);
            h.Be(o).aO(-1, "");
        }
        return false;
    }

    public final boolean Z(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchSnsImageList");
        String r = f.r(map, SlookAirButtonFrequentContactAdapter.DATA);
        int o = bh.o(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(r);
            JSONArray jSONArray2 = new JSONArray();
            Object obj = null;
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                String string2 = jSONObject.getString("objectXmlDesc");
                int i2 = jSONObject.getInt("index");
                bnp mG = ((m) g.h(m.class)).mG(string2);
                if (mG.wQo.vYd.size() > i2) {
                    aqr com_tencent_mm_protocal_c_aqr = (aqr) mG.wQo.vYd.get(i2);
                    com.tencent.mm.sdk.b.b pwVar = new pw();
                    pwVar.fHB.fpr = 3;
                    pwVar.fHB.mediaId = com_tencent_mm_protocal_c_aqr.nGJ;
                    com.tencent.mm.sdk.b.a.xef.m(pwVar);
                    x.i("MicroMsg.FTS.FTSWebViewImageLogic", "generatePath: %s", new Object[]{pwVar.fHB.path});
                    if (FileOp.bO(pwVar.fHB.path)) {
                        obj2 = "weixin://fts/sns?path=" + pwVar.fHB.path;
                    } else {
                        synchronized (this.tmb) {
                            HashSet hashSet;
                            if (this.tmb.containsKey(com_tencent_mm_protocal_c_aqr.nGJ)) {
                                hashSet = (HashSet) this.tmb.get(com_tencent_mm_protocal_c_aqr.nGJ);
                            } else {
                                hashSet = new HashSet();
                            }
                            hashSet.add(string);
                            this.tmb.put(com_tencent_mm_protocal_c_aqr.nGJ, hashSet);
                            this.tme.put(com_tencent_mm_protocal_c_aqr.nGJ, Integer.valueOf(o));
                        }
                        pwVar = new pw();
                        pwVar.fHB.fpr = 1;
                        pwVar.fHB.fHC = com_tencent_mm_protocal_c_aqr;
                        com.tencent.mm.sdk.b.a.xef.m(pwVar);
                        obj2 = obj;
                    }
                    if (obj2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, string);
                        jSONObject2.put("src", obj2);
                        jSONArray2.put(jSONObject2);
                        obj2 = null;
                    }
                } else {
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
            if (jSONArray2.length() > 0) {
                h.Be(o).aO(0, jSONArray2.toString());
            }
        } catch (JSONException e) {
        }
        return false;
    }

    public final boolean aa(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchImageList");
        int c = f.c(map, "requestType", 0);
        String r = f.r(map, SlookAirButtonFrequentContactAdapter.DATA);
        int o = bh.o(map.get("webview_instance_id"), -1);
        boolean isWifi = an.isWifi(ac.getContext());
        switch (c) {
            case 1:
                try {
                    JSONArray jSONArray = new JSONArray(r);
                    JSONArray jSONArray2 = new JSONArray();
                    int i = 0;
                    Object obj = null;
                    while (i < jSONArray.length()) {
                        Object obj2;
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        int optInt = jSONObject.optInt("emojiType");
                        String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.ID);
                        if (optInt == 2) {
                            com.tencent.mm.sdk.b.b fpVar = new fp();
                            fpVar.fuV.fpr = 3;
                            fpVar.fuV.fqR = jSONObject.optString("md5");
                            fpVar.fuV.fuX = jSONObject.optString("designerId");
                            fpVar.fuV.aeskey = jSONObject.optString("aesKey");
                            fpVar.fuV.fuY = jSONObject.optString("encryptUrl");
                            fpVar.fuV.fqV = jSONObject.optString("productID");
                            fpVar.fuV.name = jSONObject.optString("express");
                            fpVar.fuV.thumbUrl = jSONObject.optString("imageUrl");
                            com.tencent.mm.sdk.b.a.xef.m(fpVar);
                            if (FileOp.bO(fpVar.fuW.path)) {
                                obj2 = "weixin://fts/emoji?path=" + fpVar.fuW.path;
                                x.i("MicroMsg.FTS.FTSWebViewImageLogic", "path=%s", new Object[]{fpVar.fuW.path});
                            } else if (isWifi) {
                                synchronized (this.tmc) {
                                    HashSet hashSet;
                                    if (this.tmc.containsKey(fpVar.fuV.fqR)) {
                                        hashSet = (HashSet) this.tmc.get(fpVar.fuV.fqR);
                                    } else {
                                        hashSet = new HashSet();
                                    }
                                    hashSet.add(optString);
                                    this.tmc.put(fpVar.fuV.fqR, hashSet);
                                    this.tmf.put(fpVar.fuV.fqR, Integer.valueOf(o));
                                }
                                fpVar.fuV.fpr = 1;
                                com.tencent.mm.sdk.b.a.xef.m(fpVar);
                                obj2 = obj;
                            } else {
                                obj2 = jSONObject.optString("imageUrl");
                            }
                            if (obj2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, optString);
                                jSONObject2.put("src", obj2);
                                jSONArray2.put(jSONObject2);
                                obj2 = null;
                            }
                        } else if (optInt == 4) {
                            r9 = new JSONObject();
                            r9.put(SlookAirButtonFrequentContactAdapter.ID, optString);
                            if (isWifi) {
                                r9.put("src", jSONObject.optString("raw"));
                            } else {
                                r9.put("src", jSONObject.optString("imageUrl"));
                            }
                            jSONArray2.put(r9);
                            obj2 = obj;
                        } else {
                            r9 = new JSONObject();
                            r9.put(SlookAirButtonFrequentContactAdapter.ID, optString);
                            r9.put("src", jSONObject.optString("imageUrl"));
                            jSONArray2.put(r9);
                            obj2 = obj;
                        }
                        i++;
                        obj = obj2;
                    }
                    if (jSONArray2.length() > 0) {
                        h.Be(o).aO(0, jSONArray2.toString());
                        break;
                    }
                } catch (Exception e) {
                    break;
                }
                break;
            default:
                try {
                    JSONArray jSONArray3 = new JSONArray(r);
                    JSONArray jSONArray4 = new JSONArray();
                    for (c = 0; c < jSONArray3.length(); c++) {
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(c);
                        JSONObject jSONObject4 = new JSONObject();
                        String string = jSONObject3.getString(SlookAirButtonFrequentContactAdapter.ID);
                        String string2 = jSONObject3.getString("imageUrl");
                        jSONObject4.put(SlookAirButtonFrequentContactAdapter.ID, string);
                        jSONObject4.put("src", string2);
                        jSONArray4.put(jSONObject4);
                    }
                    h.Be(o).aO(0, jSONArray4.toString());
                    break;
                } catch (JSONException e2) {
                    break;
                }
        }
        return false;
    }

    public final void a(String str, l lVar) {
        if (lVar != null && lVar.obj != null) {
            synchronized (this.tma) {
                x.i("MicroMsg.FTS.FTSWebViewImageLogic", "event %s，eventData %s", new Object[]{str, lVar.toString()});
                String obj = lVar.obj.toString();
                if (this.tma.containsKey(obj) && this.tmd.containsKey(obj)) {
                    x.i("MicroMsg.FTS.FTSWebViewImageLogic", "notify avatar changed %s", new Object[]{obj});
                    int intValue = ((Integer) this.tmd.get(obj)).intValue();
                    HashSet hashSet = (HashSet) this.tma.get(obj);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        n.Jz();
                        String str3 = "weixin://fts/avatar?path=" + com.tencent.mm.ad.d.x(obj, false);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, str2);
                            jSONObject.put("src", str3);
                        } catch (JSONException e) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    h.Be(intValue).aO(0, jSONArray.toString());
                    this.tma.remove(obj);
                    this.tmd.remove(obj);
                }
            }
        }
    }
}
