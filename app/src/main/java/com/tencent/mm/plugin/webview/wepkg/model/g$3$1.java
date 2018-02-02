package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.webview.wepkg.model.g.3;
import com.tencent.mm.plugin.webview.wepkg.model.g.b;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

class g$3$1 implements Runnable {
    final /* synthetic */ 3 tNj;

    g$3$1(3 3) {
        this.tNj = 3;
    }

    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rootDir", this.tNj.tNg);
            Map hashMap = new HashMap();
            g.a(this.tNj.tNh, hashMap);
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : hashMap.entrySet()) {
                if (((List) entry.getValue()).size() != 0) {
                    JSONArray jSONArray2;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("pkgId", entry.getKey());
                    WepkgVersion Qi = h.Qi((String) entry.getKey());
                    if (Qi != null) {
                        jSONObject2.put("controlInfo", Qi.bVk());
                    }
                    List<WepkgPreloadFile> Ql = h.Ql((String) entry.getKey());
                    if (!bh.cA(Ql)) {
                        jSONArray2 = new JSONArray();
                        for (WepkgPreloadFile bVk : Ql) {
                            jSONArray2.put(bVk.bVk());
                        }
                        jSONObject2.put("preloadFilesInfo", jSONArray2);
                    }
                    jSONArray2 = new JSONArray();
                    for (b bVar : (List) entry.getValue()) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("version", bVar.version);
                        if (!bh.ov(bVar.rqL)) {
                            File file = new File(bVar.rqL);
                            if (file.exists() && file.isFile()) {
                                jSONObject3.put("md5", g.i(file));
                                jSONObject3.put("size", file.length());
                                bxs com_tencent_mm_protocal_c_bxs = new e(file).tMP;
                                if (com_tencent_mm_protocal_c_bxs != null) {
                                    jSONObject3.put("charset", com_tencent_mm_protocal_c_bxs.wYs);
                                    jSONObject3.put("desc", com_tencent_mm_protocal_c_bxs.nfe);
                                    if (com_tencent_mm_protocal_c_bxs.wYr != null) {
                                        JSONArray jSONArray3 = new JSONArray();
                                        Iterator it = com_tencent_mm_protocal_c_bxs.wYr.iterator();
                                        while (it.hasNext()) {
                                            vy vyVar = (vy) it.next();
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("rid", vyVar.wgp);
                                            jSONObject4.put("offset", vyVar.wgq);
                                            jSONObject4.put("size", vyVar.ktH);
                                            jSONObject4.put("mimeType", vyVar.wgr);
                                            jSONArray3.put(jSONObject4);
                                        }
                                        jSONObject3.put("resList", jSONArray3);
                                    }
                                }
                            }
                        }
                        List<String> list = bVar.tNl;
                        if (!bh.cA(list)) {
                            JSONArray jSONArray4 = new JSONArray();
                            for (String put : list) {
                                jSONArray4.put(put);
                            }
                            jSONObject3.put("preloadFiles", jSONArray4);
                        }
                        jSONArray2.put(jSONObject3);
                    }
                    jSONObject2.put("versionList", jSONArray2);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("pkgList", jSONArray);
            if (this.tNj.tNi != null) {
                this.tNj.tNi.G(jSONObject);
            }
        } catch (Exception e) {
            if (this.tNj.tNi != null) {
                this.tNj.tNi.G(null);
            }
        }
    }
}
