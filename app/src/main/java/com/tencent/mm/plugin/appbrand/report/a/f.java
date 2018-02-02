package com.tencent.mm.plugin.appbrand.report.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.ak;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.ax;
import com.tencent.mm.plugin.appbrand.jsapi.ay;
import com.tencent.mm.plugin.appbrand.jsapi.e.f$b;
import com.tencent.mm.plugin.appbrand.jsapi.f.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.appbrand.jsapi.map.n;
import com.tencent.mm.plugin.appbrand.jsapi.storage.i;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    private static final Set<String> jHM = new HashSet();
    private static final String[] jHN = new String[]{com.tencent.mm.plugin.appbrand.jsapi.map.a.NAME, com.tencent.mm.plugin.appbrand.jsapi.map.b.NAME, c.NAME, d.NAME, JsApiCreateAudioInstance.NAME, com.tencent.mm.plugin.appbrand.jsapi.f.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.f.d.NAME, JsApiDestroyInstanceAudio.NAME, v.NAME, com.tencent.mm.plugin.appbrand.jsapi.c.b.NAME, JsApiGetAudioState.NAME, "getCurrentRoute", e.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.f.NAME, ad.NAME, "hideToast", j.NAME, "onAccelerometerChange", "onCompassChange", f$b.NAME, "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", "onTouchEnd", "onTouchMove", "onTouchStart", "onVideoTimeUpdate", JsApiOperateAudio.NAME, h.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.h.NAME, "reportIDKey", com.tencent.mm.plugin.appbrand.jsapi.j.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.j.d.NAME, JsApiSetAudioState.NAME, i.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.j.NAME, "showModal", "showToast", "syncAudioEvent", com.tencent.mm.plugin.appbrand.jsapi.c.f.NAME, n.NAME};
    private static final Set<String> jHO = new HashSet(Arrays.asList(jHN));
    private static final ThreadPoolExecutor jHP = new 2(TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
        public final Thread newThread(Runnable runnable) {
            Thread d = com.tencent.mm.sdk.f.e.d(runnable, "AppBrandJsApiInvokeReportWorkerThread", 1);
            if (d.isDaemon()) {
                d.setDaemon(false);
            }
            return d;
        }
    });
    private static final b jHQ = new b();
    private static final Pattern jHR = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");

    private static final class a implements Runnable {
        String appId;
        String fnq;
        String fwv;
        String jHS;
        int jHT;
        long jHU;
        String jfl;

        private a() {
        }

        public final void run() {
            AppBrandStatObject oT = com.tencent.mm.plugin.appbrand.a.oT(this.appId);
            if (oT == null) {
                x.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "statObject is Null!");
            } else if (!f.jHO.contains(this.jHS)) {
                String str = "";
                if (!(bh.ov(this.jfl) || bh.ov(this.jHS))) {
                    try {
                        com.tencent.mm.v.c fz = g.fz(this.jfl);
                        if (fz.has(SlookSmartClipMetaTag.TAG_TYPE_URL) && (this.jHS.equals(ao.NAME) || this.jHS.equals(ax.NAME) || this.jHS.equals(ak.NAME) || this.jHS.equals("request") || this.jHS.equals("connectSocket") || this.jHS.equals("uploadFile") || this.jHS.equals("downloadFile"))) {
                            str = fz.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        } else if (this.jHS.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME)) {
                            try {
                                com.tencent.mm.v.a fA = g.fA(fz.optString("scope"));
                                LinkedList linkedList = new LinkedList();
                                for (int i = 0; i < fA.length(); i++) {
                                    linkedList.add(fA.optString(i));
                                }
                                str = linkedList.toString();
                            } catch (Exception e) {
                                x.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "Exception %s", new Object[]{e.getMessage()});
                                return;
                            }
                        } else if (this.jHS.equals(com.tencent.mm.plugin.appbrand.jsapi.share.c.NAME)) {
                            try {
                                str = URLEncoder.encode(bh.ou(fz.toString()), "UTF-8");
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "", new Object[0]);
                            }
                        } else if (this.jHS.equals(com.tencent.mm.plugin.appbrand.jsapi.g.e.NAME)) {
                            str = fz.optString("package");
                        } else if (this.jHS.equals(ay.NAME)) {
                            str = com.tencent.mm.plugin.appbrand.i.pl(this.appId).irI;
                        } else if (this.jHS.equals(ai.NAME)) {
                            str = fz.optString("phoneNumber");
                        } else if (this.jHS.equals("chooseVideo")) {
                            str = fz.optString("maxDuration");
                        } else if (this.jHS.equals(com.tencent.mm.plugin.appbrand.jsapi.n.h.NAME)) {
                            str = fz.optString("src");
                            try {
                                str = URLEncoder.encode(fz.optString("src"), "UTF-8");
                            } catch (Exception e3) {
                                x.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e3.toString());
                            }
                        }
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e22, "get keyParam error!", new Object[0]);
                    }
                }
                String str2 = "";
                if (!bh.ov(this.fnq) && this.fnq.contains(".html")) {
                    str2 = this.fnq.substring(0, this.fnq.lastIndexOf(".html") + 5);
                }
                String str3 = "";
                try {
                    str3 = URLEncoder.encode(bh.ou(str2), "UTF-8");
                } catch (Throwable e4) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e4, "encode page path error!", new Object[0]);
                }
                String str4 = "";
                try {
                    str4 = URLEncoder.encode(bh.ou(str), "UTF-8");
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e5, "encode keyParam path error!", new Object[0]);
                }
                String ou = bh.ou(this.jHS);
                int ud = f.ud(f.uc(this.fwv));
                String ou2 = bh.ou(oT.fnp);
                String ce = com.tencent.mm.plugin.appbrand.report.a.ce(ac.getContext());
                if (oT.scene == 0) {
                    oT.scene = 1000;
                }
                AppBrandSysConfig oS = com.tencent.mm.plugin.appbrand.a.oS(this.appId);
                if (oS != null) {
                    int i2 = oS.iOI.iGL;
                    int i3 = oS.iOI.iGK + 1;
                    int tX = com.tencent.mm.plugin.appbrand.report.a.tX(this.appId);
                    x.d("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d", new Object[]{Integer.valueOf(oT.scene), ou2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str2, ce, ou, str, Integer.valueOf(ud), Integer.valueOf(this.jHT), Integer.valueOf(0), Long.valueOf(this.jHU), Integer.valueOf(0), r8, Integer.valueOf(oT.jHc), Integer.valueOf(tX)});
                    Object[] objArr = new Object[]{Integer.valueOf(oT.scene), ou2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str3, ce, ou, str4, Integer.valueOf(ud), Integer.valueOf(this.jHT), Integer.valueOf(0), Long.valueOf(this.jHU), Integer.valueOf(0), r8, Integer.valueOf(oT.jHc), Integer.valueOf(oT.fIs), oT.fIt, Integer.valueOf(tX)};
                    com.tencent.mm.plugin.report.service.g.pQN.h(13542, objArr);
                    if (f.jHM.contains(ou)) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(15007, objArr);
                    }
                }
            }
        }
    }

    private static final class b implements android.support.v4.e.i.a<a> {
        private final Queue<a> jHV;

        private b() {
            this.jHV = new ConcurrentLinkedQueue();
        }

        public final /* synthetic */ Object bG() {
            return ajZ();
        }

        public final /* synthetic */ boolean j(Object obj) {
            return a((a) obj);
        }

        public final a ajZ() {
            a aVar = (a) this.jHV.poll();
            return aVar == null ? new a() : aVar;
        }

        public final boolean a(a aVar) {
            return this.jHV.offer(aVar);
        }
    }

    static /* synthetic */ String uc(String str) {
        if (!bh.ov(str)) {
            Matcher matcher = jHR.matcher(str);
            if (matcher.matches()) {
                return bh.ou(matcher.group(1));
            }
        }
        return "";
    }

    static /* synthetic */ int ud(String str) {
        return (bh.ov(str) || str.startsWith("ok") || !str.startsWith("fail")) ? 1 : 2;
    }

    public static void ajV() {
    }

    static {
        InputStream open;
        try {
            open = ac.getContext().getAssets().open("15007_api_list.txt");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "open read 15007_api_list.txt", new Object[0]);
            open = null;
        }
        if (open != null) {
            Closeable inputStreamReader = new InputStreamReader(open);
            Closeable bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bh.ov(readLine)) {
                        jHM.add(readLine);
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "readLine()", new Object[0]);
                } finally {
                    bh.d(bufferedReader);
                    bh.d(inputStreamReader);
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, int i, long j, String str5) {
        if (!bh.ov(str)) {
            Runnable ajZ = jHQ.ajZ();
            ajZ.appId = str;
            ajZ.fnq = str2;
            ajZ.jHS = str3;
            ajZ.jfl = str4;
            ajZ.jHT = i;
            ajZ.jHU = j;
            ajZ.fwv = str5;
            jHP.submit(ajZ);
        }
    }
}
