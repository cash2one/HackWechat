package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.topstory.a.a;
import com.tencent.mm.plugin.topstory.a.a.b;
import com.tencent.mm.plugin.topstory.a.a.c;
import com.tencent.mm.plugin.webview.fts.j;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static Map<String, Boolean> tnJ = new ConcurrentHashMap();
    private static Map<String, Boolean> tnK = new ConcurrentHashMap();
    private static Map<String, Long> tnL = new ConcurrentHashMap();
    private static Set<String> tnM = new HashSet();
    public static c tnN;
    public static b tnO;
    public static int tnP = 2;

    public static String bPp() {
        List list;
        if (b.tnu == null || b.tnu.size() <= 0) {
            list = null;
        } else {
            List arrayList = new ArrayList();
            for (c cVar : b.tnu) {
                if (Od(cVar.sey) && bh.bA(cVar.timestamp) <= b.tnA) {
                    arrayList.add(cVar);
                }
            }
            list = arrayList.size() > b.tnC ? arrayList.subList(arrayList.size() - b.tnC, arrayList.size()) : arrayList;
        }
        if (r0 == null || r0.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (c cVar2 : r0) {
            boolean booleanValue;
            String str = cVar2.sey;
            if (tnJ.containsKey(str)) {
                booleanValue = ((Boolean) tnJ.get(str)).booleanValue();
            } else {
                booleanValue = false;
            }
            stringBuilder.append(booleanValue ? 1 : 0);
            stringBuilder.append("_");
            stringBuilder.append(cVar2.seK);
            stringBuilder.append(";");
        }
        return stringBuilder.toString();
    }

    public static void ahl() {
        String bPq = bPq();
        if (!bh.ov(bPq)) {
            bcp com_tencent_mm_protocal_c_bcp = new bcp();
            com_tencent_mm_protocal_c_bcp.wIO = bPq;
            x.v("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "doWebSearchReport, websearch report string: %s", com_tencent_mm_protocal_c_bcp.wIO);
            ar.CG().a(new j(com_tencent_mm_protocal_c_bcp), 0);
        }
    }

    public static void ei(int i, int i2) {
        if (b.tnu != null && i >= 0 && i2 >= 0 && i2 >= i && i2 < b.tnu.size()) {
            while (i < i2) {
                c cVar = (c) b.tnu.get(i);
                if (!(tnK.containsKey(cVar.sey) || tnL.containsKey(cVar.sey))) {
                    x.v("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "mark %s show", cVar.sey);
                    tnK.put(cVar.sey, Boolean.valueOf(true));
                    tnL.put(cVar.sey, Long.valueOf(System.currentTimeMillis()));
                }
                i++;
            }
        }
    }

    public static void Oc(String str) {
        x.v("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "markVideoInfoClick, videoId: %s", str);
        tnJ.put(str, Boolean.valueOf(true));
    }

    private static boolean Od(String str) {
        if (tnK.containsKey(str)) {
            return ((Boolean) tnK.get(str)).booleanValue();
        }
        return false;
    }

    private static String bPq() {
        if (!(b.tnu == null || b.tnu.size() <= 0 || b.tnD)) {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("isexpose=1&content=");
            List<c> arrayList = new ArrayList();
            StringBuilder stringBuilder2 = new StringBuilder("");
            for (c cVar : b.tnu) {
                if (Od(cVar.sey) && tnL.containsKey(cVar.sey) && !tnM.contains(cVar.sey)) {
                    stringBuilder2.append(cVar.foe);
                    stringBuilder2.append(":");
                    stringBuilder2.append(cVar.seK);
                    stringBuilder2.append(":");
                    stringBuilder2.append(tnL.get(cVar.sey));
                    stringBuilder2.append(":");
                    stringBuilder2.append(cVar.seE);
                    stringBuilder2.append(";");
                    tnM.add(cVar.sey);
                    arrayList.add(cVar);
                }
            }
            try {
                stringBuilder.append(p.encode(stringBuilder2.toString(), ProtocolPackage.ServerEncoding));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e, "", new Object[0]);
            }
            try {
                if (arrayList.size() <= 0) {
                    return null;
                }
                stringBuilder.append("&resulttype=");
                for (c cVar2 : arrayList) {
                    stringBuilder.append(cVar2.foe);
                    stringBuilder.append(":");
                    stringBuilder.append(cVar2.seL);
                    stringBuilder.append(";");
                }
                stringBuilder.append("&expand=");
                stringBuilder2 = new StringBuilder("");
                for (c cVar22 : arrayList) {
                    stringBuilder2.append(cVar22.foe);
                    stringBuilder2.append(":");
                    stringBuilder2.append(cVar22.seI);
                    stringBuilder2.append(";");
                }
                try {
                    stringBuilder.append(p.encode(stringBuilder2.toString(), ProtocolPackage.ServerEncoding));
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e2, "", new Object[0]);
                }
                if (b.tnv != null) {
                    stringBuilder.append("&");
                    stringBuilder.append("searchid=");
                    stringBuilder.append(b.tnv.lEK);
                    stringBuilder.append("&");
                    stringBuilder.append("query=");
                    try {
                        stringBuilder.append(p.encode(bh.ov(b.tnv.fod) ? ac.getContext().getString(R.l.ekJ) : b.tnv.fod, ProtocolPackage.ServerEncoding));
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e22, "", new Object[0]);
                    }
                    stringBuilder.append("&");
                    stringBuilder.append("ishomepage=");
                    stringBuilder.append(b.tnv.tjP);
                    stringBuilder.append("&");
                    stringBuilder.append("sessionid=");
                    stringBuilder.append(g.zH(b.tnv.scene));
                    stringBuilder.append("&");
                    stringBuilder.append("scene=");
                    stringBuilder.append(b.tnv.scene);
                }
                return stringBuilder.toString();
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e222, "buildWebSearchReportString error: %s", e222.getMessage());
            }
        }
        return null;
    }

    private static String a(c cVar, int i, boolean z) {
        try {
            StringBuilder stringBuilder = new StringBuilder("");
            if (!(b.tnv == null || cVar == null)) {
                stringBuilder.append("scene=");
                stringBuilder.append(b.tnv.scene);
                stringBuilder.append("&");
                stringBuilder.append("businesstype=3");
                stringBuilder.append("&");
                stringBuilder.append("mediatype=2");
                stringBuilder.append("&");
                stringBuilder.append("docid=");
                stringBuilder.append(cVar.seK);
                stringBuilder.append("&");
                stringBuilder.append("typepos=");
                stringBuilder.append("0");
                stringBuilder.append("&");
                stringBuilder.append("docpos=");
                stringBuilder.append(i + 1);
                stringBuilder.append("&");
                stringBuilder.append("searchid=");
                stringBuilder.append(b.tnv.lEK);
                stringBuilder.append("&");
                stringBuilder.append("ishomepage=");
                stringBuilder.append(0);
                stringBuilder.append("&");
                stringBuilder.append("timestamp=");
                stringBuilder.append(System.currentTimeMillis());
                stringBuilder.append("&");
                stringBuilder.append("clicktype=");
                stringBuilder.append(z ? 1 : 2);
                stringBuilder.append("&");
                stringBuilder.append("clicksource=");
                stringBuilder.append("4");
                stringBuilder.append("&");
                stringBuilder.append("sceneactiontype=");
                stringBuilder.append(b.tnv.tjR);
                stringBuilder.append("&");
                stringBuilder.append("query=");
                try {
                    stringBuilder.append(p.encode(bh.ov(b.tnv.fod) ? ac.getContext().getString(R.l.ekJ) : b.tnv.fod, ProtocolPackage.ServerEncoding));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e, "", new Object[0]);
                }
                stringBuilder.append("&");
                stringBuilder.append("resulttype=");
                stringBuilder.append(cVar.seL);
                stringBuilder.append("&");
                stringBuilder.append("sessionid=");
                stringBuilder.append(g.zH(b.tnv.scene));
                stringBuilder.append("&");
                stringBuilder.append("expand=");
                stringBuilder.append(p.encode(cVar.seE, ProtocolPackage.ServerEncoding));
                stringBuilder.append("&");
                stringBuilder.append("title=");
                stringBuilder.append(p.encode(cVar.title, ProtocolPackage.ServerEncoding));
                stringBuilder.append("&");
                stringBuilder.append("nettype=");
                if (an.isWifi(ac.getContext())) {
                    stringBuilder.append("wifi");
                } else if (an.is4G(ac.getContext())) {
                    stringBuilder.append("4g");
                } else {
                    stringBuilder.append("3g");
                }
                stringBuilder.append("&");
                stringBuilder.append("itemtype=");
                stringBuilder.append(cVar.seH);
            }
            return stringBuilder.toString();
        } catch (Exception e2) {
            return null;
        }
    }

    public static void b(c cVar, int i, boolean z) {
        String a = a(cVar, i, z);
        if (!bh.ov(a)) {
            bcp com_tencent_mm_protocal_c_bcp = new bcp();
            com_tencent_mm_protocal_c_bcp.wIO = a;
            x.i("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "doClickVideoReport, websearch report string: %s", com_tencent_mm_protocal_c_bcp.wIO);
            ar.CG().a(new j(com_tencent_mm_protocal_c_bcp), 0);
        }
    }

    private static String a(c cVar, b bVar) {
        if (b.tnv == null || cVar == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("ismediaplay=1");
        stringBuilder.append("&");
        stringBuilder.append("searchid=");
        stringBuilder.append(b.tnv.lEK);
        stringBuilder.append("&");
        stringBuilder.append("scene=");
        stringBuilder.append(b.tnv.scene);
        stringBuilder.append("&");
        stringBuilder.append("businesstype=3");
        stringBuilder.append("&");
        stringBuilder.append("mediatype=2");
        stringBuilder.append("&");
        stringBuilder.append("docid=");
        stringBuilder.append(cVar.seK);
        stringBuilder.append("&");
        stringBuilder.append("query=");
        try {
            stringBuilder.append(p.encode(bh.ov(b.tnv.fod) ? ac.getContext().getString(R.l.ekJ) : b.tnv.fod, ProtocolPackage.ServerEncoding));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e, "", new Object[0]);
        }
        stringBuilder.append("&");
        stringBuilder.append("title=");
        try {
            stringBuilder.append(p.encode(cVar.title, ProtocolPackage.ServerEncoding));
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e2, "", new Object[0]);
        }
        stringBuilder.append("&");
        stringBuilder.append("duration=");
        stringBuilder.append(cVar.sex * 1000);
        stringBuilder.append("&");
        stringBuilder.append("mediaid=");
        stringBuilder.append(cVar.sey);
        if (bVar != null) {
            stringBuilder.append("&");
            stringBuilder.append("startplaytime=");
            stringBuilder.append(bVar.sep);
            stringBuilder.append("&");
            stringBuilder.append("endplaytime=");
            stringBuilder.append(bVar.seq);
            stringBuilder.append("&");
            stringBuilder.append("playtime=");
            stringBuilder.append(bVar.ser);
            stringBuilder.append("&");
            stringBuilder.append("autoplay=");
            stringBuilder.append(bVar.sev);
        }
        return stringBuilder.toString();
    }

    public static void bPr() {
        String bPq = bPq();
        if (!bh.ov(bPq)) {
            bcp com_tencent_mm_protocal_c_bcp = new bcp();
            com_tencent_mm_protocal_c_bcp.wIO = bPq;
            x.i("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "doWebSearchReport, websearch report string: %s", com_tencent_mm_protocal_c_bcp.wIO);
            ar.CG().a(new j(com_tencent_mm_protocal_c_bcp), 0);
        }
    }

    public static void bPs() {
        x.i("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "checkDoPlayReport: %s %s", tnN, tnO);
        if (tnN != null && tnO != null && tnO.sep > 0) {
            tnO.seq = System.currentTimeMillis();
            tnO.ser = tnO.seq - tnO.sep;
            String a = a(tnN, tnO);
            if (!bh.ov(a)) {
                bcp com_tencent_mm_protocal_c_bcp = new bcp();
                com_tencent_mm_protocal_c_bcp.wIO = a;
                x.i("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "doVideoPlayWebSearchReport, websearch report string: %s", com_tencent_mm_protocal_c_bcp.wIO);
                ar.CG().a(new j(com_tencent_mm_protocal_c_bcp), 0);
            }
            tnN = null;
            tnO = null;
        }
    }

    public static final void a(c cVar, int i, String str, int i2) {
        int i3;
        if (((a) com.tencent.mm.kernel.g.h(a.class)).aCc()) {
            i3 = 2;
        } else if (((a) com.tencent.mm.kernel.g.h(a.class)).bFn()) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        String str2 = cVar != null ? cVar.seK : "";
        x.v("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "reportKvTopStoryVideoPlayError %s", String.format("%s,%s,%s,%s,%s", new Object[]{str2, Integer.valueOf(i), str, Integer.valueOf(i3), Integer.valueOf(i2)}));
        com.tencent.mm.plugin.report.d.pPH.k(15248, str2);
    }

    public static void Ac(int i) {
        switch (i) {
            case -21020:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkK);
                break;
            case -21009:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkJ);
                break;
            case -10012:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkH);
                break;
            case -10004:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkI);
                break;
            case -1010:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkE);
                break;
            case -1007:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkF);
                break;
            case -1004:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkG);
                break;
            case ap.CTRL_INDEX /*403*/:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkM);
                break;
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkL);
                break;
            case 405:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkQ);
                break;
            case 416:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkP);
                break;
            case 502:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkO);
                break;
            case 503:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkN);
                break;
            default:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkR);
                break;
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(791, 7);
    }
}
