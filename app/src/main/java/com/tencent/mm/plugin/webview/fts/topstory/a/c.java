package com.tencent.mm.plugin.webview.fts.topstory.a;

import android.webkit.URLUtil;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.webview.fts.h;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c implements e {
    a tnF;
    boolean tnG;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ c tnH;
        final /* synthetic */ com.tencent.mm.plugin.topstory.a.a.c tnI;

        AnonymousClass4(c cVar, com.tencent.mm.plugin.topstory.a.a.c cVar2) {
            this.tnH = cVar;
            this.tnI = cVar2;
        }

        public final void run() {
            if (this.tnH.tnF != null) {
                this.tnH.tnF.a(this.tnI);
            }
        }
    }

    public final void a(int i, a aVar, d dVar, boolean z, a aVar2) {
        or orVar;
        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "fetch, offset: %s, relevantVideoInfo: %s, modelParams: %s, fetchCallback: %s", Integer.valueOf(i), aVar, dVar, aVar2);
        this.tnF = aVar2;
        this.tnG = z;
        d dVar2 = new d();
        dVar2.offset = i;
        dVar2.tjP = dVar.tjP;
        dVar2.scene = dVar.scene;
        dVar2.tjR = dVar.tjR;
        dVar2.tjW = dVar.tjW;
        dVar2.fod = dVar.fod;
        dVar2.lEK = dVar.lEK;
        dVar2.tka = new LinkedList();
        if (!bh.ov(aVar.sek)) {
            orVar = new or();
            orVar.aAM = "relevant_vid";
            orVar.vXy = aVar.sek;
            dVar2.tka.add(orVar);
        }
        if (!bh.ov(aVar.sel)) {
            orVar = new or();
            orVar.aAM = "relevant_expand";
            orVar.vXy = aVar.sel;
            dVar2.tka.add(orVar);
        }
        if (!bh.ov(aVar.sem)) {
            orVar = new or();
            orVar.aAM = "relevant_pre_searchid";
            orVar.vXy = aVar.sem;
            dVar2.tka.add(orVar);
        }
        if (!bh.ov(aVar.sen)) {
            orVar = new or();
            orVar.aAM = "relevant_shared_openid";
            orVar.vXy = aVar.sen;
            dVar2.tka.add(orVar);
        }
        if (aVar.seo >= 0) {
            orVar = new or();
            orVar.aAM = "rec_category";
            orVar.vXx = aVar.seo;
            dVar2.tka.add(orVar);
        }
        or orVar2 = new or();
        orVar2.aAM = "is_prefetch";
        orVar2.vXx = b.tnB ? 1 : 0;
        dVar2.tka.add(orVar2);
        String bPp = d.bPp();
        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "clientExposeReportString: %s", bPp);
        if (!bh.ov(bPp)) {
            or orVar3 = new or();
            orVar3.aAM = "client_exposed_info";
            orVar3.vXy = bPp;
            dVar2.tka.add(orVar3);
        }
        orVar = new or();
        orVar.aAM = DownloadInfo.NETTYPE;
        if (an.isWifi(ac.getContext())) {
            orVar.vXy = "wifi";
        } else if (an.is4G(ac.getContext())) {
            orVar.vXy = "4g";
        } else {
            orVar.vXy = "3g";
        }
        dVar2.tka.add(orVar);
        ar.CG().a(new h(dVar2), 0);
        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "doFetchPage: %s", r0);
        g.pQN.h(791, 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), kVar);
        if (kVar.getType() == 1943) {
            h hVar = (h) kVar;
            if (i == 0 && i2 == 0) {
                try {
                    final JSONObject jSONObject = new JSONObject(hVar.Jc());
                    com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                        final /* synthetic */ c tnH;

                        public final void run() {
                            c cVar = this.tnH;
                            JSONObject jSONObject = jSONObject;
                            JSONObject optJSONObject = jSONObject.optJSONObject("client_conf");
                            if (!(optJSONObject == null || optJSONObject == null)) {
                                b.a(optJSONObject.optInt("enable_prefetch", 0) == 1, (long) optJSONObject.optInt("max_report_exposed_cnt", 0), optJSONObject.optInt("max_report_exposed_cnt", 0));
                            }
                            if (b.tnv != null) {
                                String optString = jSONObject.optString("searchID");
                                x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "fetch response searchid: %s", optString);
                                if (!bh.ov(optString)) {
                                    b.tnv.lEK = optString;
                                }
                            }
                            JSONArray optJSONArray = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                            ArrayList arrayList = new ArrayList();
                            if (optJSONArray == null || optJSONArray.length() <= 0) {
                                g.pQN.h(791, 1);
                                cVar.Oa(jSONObject.optString("nomoreText"));
                                return;
                            }
                            int i = 0;
                            while (i < optJSONArray.length()) {
                                try {
                                    optJSONObject = (JSONObject) optJSONArray.get(i);
                                    optJSONObject.optInt("count");
                                    long optLong = optJSONObject.optLong("resultType");
                                    long optLong2 = optJSONObject.optLong(DownloadSettingTable$Columns.TYPE);
                                    String optString2 = optJSONObject.optString("expand");
                                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                        long Wq = bh.Wq();
                                        int i2 = 0;
                                        while (i2 < optJSONArray2.length()) {
                                            optJSONObject = (JSONObject) optJSONArray2.get(i2);
                                            String optString3 = optJSONObject.optString("videoApi");
                                            String optString4 = optJSONObject.optString("videoId");
                                            String optString5 = optJSONObject.optString("videoPlatform");
                                            String optString6 = optJSONObject.optString("docID");
                                            int optInt = optJSONObject.optInt("mediaDuration", 0);
                                            if (!(bh.ov(optString3) || bh.ov(optString4))) {
                                                x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "videoid: %s, videoApi: %s, videoPlatform: %s, videoDuration: %s", optString4, optString3, optString5, Integer.valueOf(optInt));
                                                com.tencent.mm.plugin.topstory.a.a.c cVar2 = new com.tencent.mm.plugin.topstory.a.a.c();
                                                cVar2.sey = optString4;
                                                cVar2.sew = "http://shp.qpic.cn/qqvideo_ori/0/" + optString4 + String.format("_%s_%s/0", new Object[]{Integer.valueOf(496), Integer.valueOf(280)});
                                                c.a(cVar2, optString3, optString5);
                                                cVar2.videoUrl = cVar2.seN.size() > 0 ? (String) cVar2.seN.get(0) : null;
                                                if (bh.ov(cVar2.videoUrl)) {
                                                    g.pQN.h(791, 11);
                                                }
                                                cVar2.sex = optInt;
                                                cVar2.title = optJSONObject.optString("title");
                                                cVar2.lOY = optJSONObject.optString("shareTitle");
                                                cVar2.rfu = optJSONObject.optString("shareDesc");
                                                cVar2.sez = optJSONObject.optString("shareImgUrl");
                                                cVar2.seA = optJSONObject.optString("shareString");
                                                cVar2.seB = optJSONObject.optString("shareStringUrl");
                                                cVar2.bhd = optJSONObject.optString("source");
                                                cVar2.pes = optJSONObject.optString("sourceUrl");
                                                cVar2.hbo = 496;
                                                cVar2.hbn = 280;
                                                cVar2.lOX = optJSONObject.optString("shareUrl");
                                                cVar2.seC = optJSONObject.optLong("relevant_category", -1);
                                                cVar2.seD = optJSONObject.optString("shareOpenId");
                                                cVar2.seE = optJSONObject.optString("expand");
                                                cVar2.seF = optJSONObject.optString("strPlayCount");
                                                cVar2.seG = optJSONObject.optString("titleUrl");
                                                cVar2.seH = optJSONObject.optInt("itemType");
                                                cVar2.seJ = optJSONObject.optString("bizIcon");
                                                cVar2.timestamp = Wq;
                                                cVar2.fpa = false;
                                                cVar2.seK = optString6;
                                                cVar2.seL = optLong;
                                                cVar2.foe = optLong2;
                                                cVar2.seI = optString2;
                                                if (i == 0 && i2 == 0 && cVar.tnG) {
                                                    x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "callbackFirstVideo: %s", cVar2);
                                                    ag.y(new AnonymousClass4(cVar, cVar2));
                                                } else if (!(bh.ov(cVar2.videoUrl) || bh.ov(cVar2.sew))) {
                                                    x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "title: %s, thumbnailUrl: %s, videoUrl: %s, ", cVar2.title, cVar2.videoUrl, cVar2.sew);
                                                    arrayList.add(cVar2);
                                                }
                                            }
                                            i2++;
                                        }
                                    }
                                    i++;
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "parseAndRequestVideoList error: %s", e.getMessage());
                                    g.pQN.h(791, 3);
                                    cVar.Oa(null);
                                    return;
                                }
                            }
                            ag.y(new 2(cVar, arrayList));
                        }
                    }, "FtsRecommendVideoListFetcher_parseAndRequestVideoList");
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "parse recommend json failed: %s", e.getMessage());
                    return;
                }
            }
            x.e("MicroMsg.WebSearch.TopStoryVideoListFetcher", "fetch page failed!, response json: %s", hVar.Jc());
            g.pQN.h(791, 2);
            Oa(null);
        }
    }

    static void a(com.tencent.mm.plugin.topstory.a.a.c cVar, String str, String str2) {
        v oh;
        InputStream inputStream;
        u uVar;
        Throwable e;
        InputStream inputStream2;
        u uVar2;
        String str3 = null;
        StringBuilder stringBuilder = new StringBuilder("");
        cVar.seN = new ArrayList();
        try {
            if (URLUtil.isHttpsUrl(str)) {
                oh = b.oh(str);
                try {
                    oh.VD();
                    oh.VB();
                    oh.VC();
                    inputStream = oh.iaw.getInputStream();
                    uVar = null;
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = null;
                    try {
                        x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "getVideoUrlByVideoApi error: %s", e.getMessage());
                        if (uVar2 != null) {
                            uVar2.aBw.disconnect();
                        }
                        if (oh != null) {
                            oh.iaw.disconnect();
                        }
                        if (inputStream2 == null) {
                            com.tencent.mm.a.e.c(inputStream2);
                        }
                    } catch (Throwable th) {
                        e = th;
                        inputStream = inputStream2;
                        uVar = uVar2;
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (oh != null) {
                            oh.iaw.disconnect();
                        }
                        if (inputStream != null) {
                            com.tencent.mm.a.e.c(inputStream);
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    uVar = null;
                    inputStream = null;
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (oh != null) {
                        oh.iaw.disconnect();
                    }
                    if (inputStream != null) {
                        com.tencent.mm.a.e.c(inputStream);
                    }
                    throw e;
                }
            }
            u a = b.a(str, null);
            try {
                a.setUseCaches(true);
                a.setConnectTimeout(3000);
                a.setReadTimeout(3000);
                inputStream = a.getInputStream();
                uVar = a;
                oh = null;
            } catch (Exception e3) {
                e = e3;
                inputStream2 = null;
                u uVar3 = a;
                oh = null;
                uVar2 = uVar3;
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "getVideoUrlByVideoApi error: %s", e.getMessage());
                if (uVar2 != null) {
                    uVar2.aBw.disconnect();
                }
                if (oh != null) {
                    oh.iaw.disconnect();
                }
                if (inputStream2 == null) {
                    com.tencent.mm.a.e.c(inputStream2);
                }
            } catch (Throwable th3) {
                e = th3;
                uVar = a;
                inputStream = null;
                oh = null;
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (oh != null) {
                    oh.iaw.disconnect();
                }
                if (inputStream != null) {
                    com.tencent.mm.a.e.c(inputStream);
                }
                throw e;
            }
            try {
                String readLine;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                }
                x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "videoApi json: %s", stringBuilder);
                JSONObject jSONObject = new JSONObject(stringBuilder.toString().substring(13));
                JSONObject optJSONObject = jSONObject.optJSONObject("fl");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("fi");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        cVar.seM = optJSONArray.getJSONObject(0).optLong("fs");
                    }
                }
                optJSONObject = jSONObject.optJSONObject("vl");
                if (optJSONObject != null) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("vi");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        String str4 = null;
                        readLine = null;
                        for (int i = 0; i < optJSONArray2.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                            if (jSONObject2 != null) {
                                readLine = jSONObject2.optString("fn");
                                str4 = jSONObject2.optString("fvkey");
                                jSONObject2 = jSONObject2.optJSONObject("ul");
                                if (jSONObject2 != null) {
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("ui");
                                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                        jSONObject2 = optJSONArray3.getJSONObject(0);
                                        if (jSONObject2 != null) {
                                            str3 = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                        }
                                    }
                                }
                            }
                            if (!(bh.ov(str3) || bh.ov(str4) || bh.ov(readLine))) {
                                Object obj = str3 + readLine + "?vkey=" + str4;
                                if (!bh.ov(str2)) {
                                    obj = obj + "&platform=" + str2;
                                }
                                cVar.seN.add(obj);
                            }
                        }
                    }
                }
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (oh != null) {
                    oh.iaw.disconnect();
                }
                if (inputStream != null) {
                    com.tencent.mm.a.e.c(inputStream);
                }
            } catch (Exception e4) {
                e = e4;
                uVar2 = uVar;
                inputStream2 = inputStream;
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "getVideoUrlByVideoApi error: %s", e.getMessage());
                if (uVar2 != null) {
                    uVar2.aBw.disconnect();
                }
                if (oh != null) {
                    oh.iaw.disconnect();
                }
                if (inputStream2 == null) {
                    com.tencent.mm.a.e.c(inputStream2);
                }
            } catch (Throwable th4) {
                e = th4;
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (oh != null) {
                    oh.iaw.disconnect();
                }
                if (inputStream != null) {
                    com.tencent.mm.a.e.c(inputStream);
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            oh = null;
            inputStream2 = null;
            x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "getVideoUrlByVideoApi error: %s", e.getMessage());
            if (uVar2 != null) {
                uVar2.aBw.disconnect();
            }
            if (oh != null) {
                oh.iaw.disconnect();
            }
            if (inputStream2 == null) {
                com.tencent.mm.a.e.c(inputStream2);
            }
        } catch (Throwable th5) {
            e = th5;
            oh = null;
            uVar = null;
            inputStream = null;
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (oh != null) {
                oh.iaw.disconnect();
            }
            if (inputStream != null) {
                com.tencent.mm.a.e.c(inputStream);
            }
            throw e;
        }
    }

    final void Oa(final String str) {
        x.e("MicroMsg.WebSearch.TopStoryVideoListFetcher", "callbackToFailed, msg: %s", str);
        ag.y(new Runnable(this) {
            final /* synthetic */ c tnH;

            public final void run() {
                if (this.tnH.tnF != null) {
                    this.tnH.tnF.Ob(str);
                }
            }
        });
    }
}
