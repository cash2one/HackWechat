package com.tencent.mm.modelsimple;

import com.tencent.mm.modelsimple.ab.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;

public final class ab$b {
    public String desc;
    public LinkedList<a> hOg;
    public String title;

    public static LinkedList<a> f(Map<String, String> map, String str) {
        LinkedList<a> linkedList = new LinkedList();
        int i = 0;
        while (i < 1000) {
            String str2 = str + ".action" + (i > 0 ? Integer.valueOf(i) : "");
            try {
                int intValue = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
                a aVar = new a();
                if (intValue != 5) {
                    return linkedList;
                }
                aVar.haH = bh.ou((String) map.get(str2 + ".iconurl"));
                aVar.desc = bh.ou((String) map.get(str2 + ".desc"));
                aVar.hOf = bh.ou((String) map.get(str2 + ".link"));
                if (bh.ov(aVar.haH) && bh.ov(aVar.desc) && bh.ov(aVar.hOf)) {
                    return linkedList;
                }
                linkedList.add(aVar);
                i++;
            } catch (Exception e) {
                x.w("MicroMsg.NetSceneScanStreetView", "parseVendorsFromXml() " + e.getMessage());
                return linkedList;
            }
        }
        return linkedList;
    }
}
