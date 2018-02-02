package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public LinkedList<a> hOg = new LinkedList();
    public String iconUrl;
    public int lkw;
    public int pSo;
    public int pSp;
    public String pSq;
    public boolean pSr;
    public String title;
    public int type = 1;

    public static LinkedList<a> l(Map<String, String> map, String str) {
        LinkedList<a> linkedList = new LinkedList();
        Object obj = null;
        int i = 0;
        while (i < 1000) {
            Object obj2;
            a aVar = new a();
            String str2 = str + ".actionlist" + (i > 0 ? Integer.valueOf(i) : "");
            if (!bh.ov((String) map.get(str2 + ".$type"))) {
                aVar.type = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
            }
            aVar.title = bh.ou((String) map.get(str2 + ".$title"));
            aVar.iconUrl = bh.ou((String) map.get(str2 + ".$iconurl"));
            aVar.lkw = bh.getInt((String) map.get(str2 + ".$iconwidth"), 34);
            aVar.pSo = bh.getInt((String) map.get(str2 + ".$iconheight"), 34);
            aVar.pSq = bh.ou((String) map.get(str2 + ".$referkey"));
            aVar.pSp = bh.getInt((String) map.get(str2 + ".$listshowtype"), 0);
            boolean z = false;
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            while (i2 < 1000) {
                String str3 = str2 + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                if (!bh.ov((String) map.get(str3 + ".$type"))) {
                    boolean z2;
                    obj = null;
                    a m = m(map, str3);
                    if (m != null) {
                        linkedList2.add(m);
                        if (!k.a(m)) {
                            z2 = true;
                            i2++;
                            z = z2;
                        }
                    }
                    z2 = z;
                    i2++;
                    z = z2;
                } else if (obj != null) {
                    return linkedList;
                } else {
                    obj2 = 1;
                    aVar.hOg = linkedList2;
                    aVar.pSr = z;
                    linkedList.add(aVar);
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            aVar.pSr = z;
            linkedList.add(aVar);
            i++;
            obj = obj2;
        }
        return linkedList;
    }

    public static a m(Map<String, String> map, String str) {
        int i = bh.getInt((String) map.get(str + ".$type"), 0);
        a aVar = new a(i);
        aVar.type = i;
        aVar.pSx = bh.ou((String) map.get(str + ".statid"));
        aVar.name = bh.ou((String) map.get(str + ".name"));
        aVar.desc = bh.ou((String) map.get(str + ".desc"));
        aVar.hef = bh.ou((String) map.get(str + ".digest"));
        aVar.showType = bh.getInt((String) map.get(str + ".showtype"), 0);
        aVar.pSs = bh.ou((String) map.get(str + ".image"));
        aVar.aAM = bh.ou((String) map.get(str + ".$key"));
        aVar.iconUrl = bh.ou((String) map.get(str + ".iconurl"));
        if (i == 1) {
            aVar.hOf = bh.ou((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 2) {
            aVar.username = bh.ou((String) map.get(str + ".username"));
            aVar.fpL = bh.ou((String) map.get(str + ".nickname"));
            aVar.pSB = bh.ou((String) map.get(str + ".strbeforefollow"));
            aVar.pSC = bh.ou((String) map.get(str + ".strafterfollow"));
            return aVar;
        } else if (i == 3) {
            aVar.thumburl = bh.ou((String) map.get(str + ".thumburl"));
            aVar.hOf = bh.ou((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 4) {
            aVar.thumburl = bh.ou((String) map.get(str + ".thumburl"));
            aVar.username = bh.ou((String) map.get(str + ".username"));
            aVar.fpL = bh.ou((String) map.get(str + ".nickname"));
            return aVar;
        } else {
            if (i == 5) {
                aVar.pSu = bh.ou((String) map.get(str + ".wifiurl"));
                aVar.pSv = bh.ou((String) map.get(str + ".wapurl"));
                aVar.pSw = bh.ou((String) map.get(str + ".weburl"));
                if (bh.ov(aVar.pSu) && bh.ov(aVar.pSv) && bh.ov(aVar.pSw)) {
                    return null;
                }
            } else if (i != 6) {
                if (i == 7) {
                    aVar.thumburl = bh.ou((String) map.get(str + ".thumburl"));
                    aVar.pSt = bh.ou((String) map.get(str + ".playurl"));
                    return aVar;
                } else if (i == 9) {
                    aVar.pSy = bh.ou((String) map.get(str + ".productid"));
                    return aVar;
                } else if (i == 8) {
                    aVar.pSz = bh.ou((String) map.get(str + ".cardext"));
                    aVar.pSA = bh.ou((String) map.get(str + ".cardid"));
                    return aVar;
                } else if (i == 10) {
                    aVar.pSy = bh.ou((String) map.get(str + ".id"));
                    return aVar;
                } else if (i == 12) {
                    aVar.thumburl = bh.ou((String) map.get(str + ".image"));
                    aVar.hOf = bh.ou((String) map.get(str + ".link"));
                    return aVar;
                } else if (i == 22) {
                    aVar.content = bh.ou((String) map.get(str + ".content"));
                    aVar.hOf = bh.ou((String) map.get(str + ".link"));
                    aVar.fpL = bh.ou((String) map.get(str + ".nickname"));
                    aVar.thumburl = bh.ou((String) map.get(str + ".image"));
                    return aVar;
                } else if (i == 21) {
                    aVar.pSq = bh.ou((String) map.get(str + ".referkey"));
                    return aVar;
                } else {
                    aVar.hOf = bh.ou((String) map.get(str + ".link"));
                }
            }
            return aVar;
        }
    }
}
