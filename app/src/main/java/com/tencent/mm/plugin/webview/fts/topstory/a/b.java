package com.tencent.mm.plugin.webview.fts.topstory.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.topstory.a.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class b {
    public static long seo;
    public static long tnA = 0;
    public static boolean tnB = false;
    public static int tnC = 0;
    public static boolean tnD = false;
    public static boolean tnE = false;
    public static int tnr;
    public static int tns;
    public static HashMap<String, c> tnt = new HashMap();
    public static List<c> tnu = new ArrayList();
    public static d tnv;
    public static a tnw;
    public static c tnx;
    public static String tny;
    public static String tnz;

    public static void init(Context context) {
        tnr = context.getResources().getDimensionPixelSize(R.f.bxo);
        tns = context.getResources().getDimensionPixelSize(R.f.bxp);
        tnu = new ArrayList();
        tnA = 0;
        tnB = false;
        tnC = 0;
    }

    public static void reset() {
        tnv = null;
        tnx = null;
        seo = -1;
        tny = null;
        tnz = null;
        tnA = 0;
        tnB = false;
        tnC = 0;
        tnu.clear();
        tnt.clear();
    }

    public static void d(d dVar) {
        tnv = dVar;
    }

    public static void a(ArrayList<String> arrayList, c cVar, String str, String str2) {
        String str3;
        x.i("MicroMsg.WebSearch.TopStoryVideoListConfig", "setFirstVideoInfo, urls: %s, videoInfo: %s, expand: %s, searchId: %s", arrayList, cVar, str, str2);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                str3 = (String) it.next();
                if (!bh.ov(str3)) {
                    break;
                }
            }
        }
        str3 = null;
        cVar.videoUrl = str3;
        tnx = cVar;
        cVar.timestamp = bh.Wq();
        seo = tnx.seC;
        tny = str;
        tnz = str2;
        tnt.put(tnx.sey, tnx);
    }

    public static void h(List<c> list, boolean z) {
        if (list != null && list.size() > 0) {
            if (z) {
                tnu.clear();
                tnt.clear();
            }
            tnu.addAll(list);
            for (c cVar : list) {
                tnt.put(cVar.sey, cVar);
            }
        }
    }

    public static int bPn() {
        if (tnu != null) {
            return tnu.size();
        }
        return 0;
    }

    public static boolean bPo() {
        return an.isWifi(ac.getContext());
    }

    public static void a(boolean z, long j, int i) {
        x.i("MicroMsg.WebSearch.TopStoryVideoListConfig", "setPreFetchAndReportInfo, isNeedPreFetch: %s, reportThresholdInMin: %s, maxReportVideoCount", Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i));
        tnB = z;
        tnA = 60000 * j;
        tnC = i;
    }

    public static String NZ(String str) {
        int i;
        int size = tnu.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(((c) tnu.get(i2)).videoUrl)) {
                i = i2;
                break;
            }
        }
        i = -1;
        if (i < 0 || i + 1 >= size) {
            return null;
        }
        return ((c) tnu.get(i + 1)).videoUrl;
    }
}
