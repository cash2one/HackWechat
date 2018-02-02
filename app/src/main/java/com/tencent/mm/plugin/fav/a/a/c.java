package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class c {
    public static void a(Map<String, String> map, vr vrVar) {
        if (map == null || vrVar == null) {
            x.w("MicroMsg.FavTagParser", "maps is null or item is null");
            return;
        }
        vrVar.wfj.clear();
        int i = 0;
        while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            String str = (String) map.get(".favitem.taglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            vrVar.wfj.add(str);
            i++;
        }
        if (!vrVar.wfj.isEmpty()) {
            x.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[]{vrVar.wfj});
        }
        vrVar.wfi.clear();
        i = 0;
        while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str = (String) map.get(".favitem.recommendtaglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            vrVar.wfi.add(str);
            i++;
        }
        if (!vrVar.wfi.isEmpty()) {
            x.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[]{vrVar.wfi});
        }
    }

    public static String a(vr vrVar) {
        int i = 0;
        if (vrVar == null || (vrVar.wfj.isEmpty() && vrVar.wfi.isEmpty())) {
            x.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
            return "";
        }
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        int size = vrVar.wfj.size();
        stringBuffer.append("<taglist count='").append(size).append("'>");
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(bh.VG((String) vrVar.wfj.get(i2))).append("</tag>");
        }
        stringBuffer.append("</taglist>");
        i2 = vrVar.wfi.size();
        stringBuffer.append("<recommendtaglist count='").append(i2).append("'>");
        while (i < i2) {
            stringBuffer.append("<tag>").append(bh.VG((String) vrVar.wfi.get(i))).append("</tag>");
            i++;
        }
        stringBuffer.append("</recommendtaglist>");
        return stringBuffer.toString();
    }
}
