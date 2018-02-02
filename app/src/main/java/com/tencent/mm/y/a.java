package com.tencent.mm.y;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

public class a extends d {
    public String haA;
    public int haB;
    public boolean haz;

    public final d EJ() {
        d aVar = new a();
        aVar.haz = this.haz;
        aVar.haA = this.haA;
        aVar.haB = this.haB;
        return aVar;
    }

    public final void a(StringBuilder stringBuilder, g$a com_tencent_mm_y_g_a, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
        stringBuilder.append("<weappinfo>");
        if (!bh.ov(com_tencent_mm_y_g_a.hdw)) {
            stringBuilder.append("<pagepath>" + g$a.fU(com_tencent_mm_y_g_a.hdw) + "</pagepath>");
        }
        stringBuilder.append("<username>" + bh.VG(com_tencent_mm_y_g_a.hdx) + "</username>");
        stringBuilder.append("<appid>" + bh.VG(com_tencent_mm_y_g_a.hdy) + "</appid>");
        if (com_tencent_mm_y_g_a.hdF != 0) {
            stringBuilder.append("<version>" + com_tencent_mm_y_g_a.hdF + "</version>");
        }
        if (com_tencent_mm_y_g_a.hdz != 0) {
            stringBuilder.append("<type>" + com_tencent_mm_y_g_a.hdz + "</type>");
        }
        if (!bh.ov(com_tencent_mm_y_g_a.hdG)) {
            stringBuilder.append("<weappiconurl>" + g$a.fU(com_tencent_mm_y_g_a.hdG) + "</weappiconurl>");
        }
        if (!bh.ov(com_tencent_mm_y_g_a.hdC)) {
            stringBuilder.append("<shareId>" + g$a.fU(com_tencent_mm_y_g_a.hdC) + "</shareId>");
        }
        if (com_tencent_mm_y_g_a.hdE == 1 || com_tencent_mm_y_g_a.hdE == 2) {
            stringBuilder.append("<pkginfo>");
            stringBuilder.append("<type>");
            stringBuilder.append(com_tencent_mm_y_g_a.hdE);
            stringBuilder.append("</type>");
            stringBuilder.append("<md5>");
            stringBuilder.append(com_tencent_mm_y_g_a.hdA);
            stringBuilder.append("</md5>");
            stringBuilder.append("</pkginfo>");
        }
        if (!bh.ov(com_tencent_mm_y_g_a.hdD)) {
            stringBuilder.append("<sharekey>" + g$a.fU(com_tencent_mm_y_g_a.hdD) + "</sharekey>");
        }
        if (this.haz) {
            stringBuilder.append("<wadynamicpageinfo>");
            stringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
            stringBuilder.append("<cacheKey>");
            stringBuilder.append(g$a.fU(this.haA));
            stringBuilder.append("</cacheKey>");
            stringBuilder.append("</wadynamicpageinfo>");
        }
        stringBuilder.append("<appservicetype>" + this.haB + "</appservicetype>");
        stringBuilder.append("</weappinfo>");
    }

    public final void a(Map<String, String> map, g$a com_tencent_mm_y_g_a) {
        boolean z;
        if (bh.getInt((String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.haz = z;
        this.haA = (String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey");
        this.haB = bh.getInt((String) map.get(".msg.appmsg.weappinfo.appservicetype"), this.haB);
    }
}
