package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.g$a;
import java.util.Map;

public final class c {
    public static a Jo(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        Map y = bi.y(str, "tv");
        if (y == null) {
            return null;
        }
        a aVar = new a();
        aVar.field_id = bh.ou((String) y.get(str2 + ".tv.id"));
        aVar.field_topic = bh.ou((String) y.get(str2 + ".tv.topic"));
        aVar.field_title = bh.ou((String) y.get(str2 + ".tv.title"));
        aVar.field_subtitle = bh.ou((String) y.get(str2 + ".tv.subtitle"));
        aVar.field_thumburl = bh.ou((String) y.get(str2 + ".tv.thumburl"));
        aVar.field_shareurl = bh.ou((String) y.get(str2 + ".tv.shareurl"));
        aVar.field_playurl = bh.ou((String) y.get(str2 + ".tv.playurl"));
        aVar.field_playstatid = bh.ou((String) y.get(str2 + ".tv.playurl$statid"));
        aVar.field_source = bh.ou((String) y.get(str2 + ".tv.source"));
        aVar.qbc = a.l(y, str2 + ".tv");
        aVar.field_xml = str;
        return aVar;
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("<tv>");
        if (!bh.ov(aVar.field_id)) {
            stringBuilder.append("<id>" + bh.VG(aVar.field_id) + "</id>");
        }
        stringBuilder.append("<title>" + bh.VG(aVar.field_title) + "</title>");
        stringBuilder.append("<subtitle>" + bh.VG(aVar.field_subtitle) + "</subtitle>");
        stringBuilder.append("<topic>" + bh.VG(aVar.field_topic) + "</topic>");
        stringBuilder.append("<thumburl>" + bh.VG(aVar.field_thumburl) + "</thumburl>");
        stringBuilder.append("<shareurl>" + bh.VG(aVar.field_shareurl) + "</shareurl>");
        if (bh.ov(aVar.field_playstatid)) {
            stringBuilder.append("<playurl>" + bh.VG(aVar.field_playurl) + "</playurl>");
        } else {
            stringBuilder.append("<playurl statid=\"" + aVar.field_playstatid + "\">" + bh.VG(aVar.field_playurl) + "</playurl>");
        }
        stringBuilder.append("<source>" + bh.VG(aVar.field_source) + "</source>");
        stringBuilder.append("</tv>");
        return stringBuilder.toString();
    }

    public static String a(Context context, a aVar) {
        g$a com_tencent_mm_y_g_a = new g$a();
        com_tencent_mm_y_g_a.title = aVar.field_title;
        if (bh.ov(aVar.field_topic)) {
            com_tencent_mm_y_g_a.description = aVar.field_subtitle;
        } else {
            com_tencent_mm_y_g_a.description = aVar.field_topic;
        }
        com_tencent_mm_y_g_a.type = 20;
        com_tencent_mm_y_g_a.url = aVar.field_shareurl;
        com_tencent_mm_y_g_a.action = "";
        if (k.brA()) {
            com_tencent_mm_y_g_a.appName = context.getString(R.l.eIo);
            com_tencent_mm_y_g_a.appId = "wxaf060266bfa9a35c";
        }
        com_tencent_mm_y_g_a.thumburl = aVar.field_thumburl;
        com_tencent_mm_y_g_a.hbA = b(aVar);
        return g$a.a(com_tencent_mm_y_g_a, null, null);
    }
}
