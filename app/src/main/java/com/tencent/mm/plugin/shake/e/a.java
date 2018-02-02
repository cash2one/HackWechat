package com.tencent.mm.plugin.shake.e;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a {
    public LinkedList<a> hOg = new LinkedList();

    public static class a {
        public String niP;
        public String qsL;
        public List<String> qsM = new ArrayList();
        public String qsN = "";
        public String qsO = "";
        public String title;
        public int type;

        public a(int i) {
            this.type = i;
        }
    }

    public static LinkedList<a> l(Map<String, String> map, String str) {
        LinkedList<a> linkedList = new LinkedList();
        int i = 0;
        Object obj = null;
        while (i < 1000) {
            Object obj2;
            a aVar = new a();
            String str2 = str + ".actionlist" + (i > 0 ? Integer.valueOf(i) : "");
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            while (i2 < 1000) {
                String str3 = str2 + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                if (!bh.ov((String) map.get(str3 + ".type"))) {
                    try {
                        int intValue = Integer.valueOf((String) map.get(str3 + ".type")).intValue();
                        obj2 = null;
                        if (intValue == 2) {
                            a aVar2 = new a(intValue);
                            aVar2.qsL = bh.ou((String) map.get(str3 + ".comment.id"));
                            aVar2.title = bh.ou((String) map.get(str3 + ".comment.title"));
                            obj2 = aVar2;
                        } else if (intValue == 3) {
                            obj2 = a(map, intValue, str3);
                        } else if (intValue == 4) {
                            obj2 = a(map, intValue, str3);
                        } else if (intValue == 5) {
                            obj2 = a(map, intValue, str3);
                        } else if (intValue == 6) {
                            obj2 = a(map, intValue, str3);
                        }
                        if (obj2 != null) {
                            linkedList2.add(obj2);
                        }
                        i2++;
                        obj = null;
                    } catch (Exception e) {
                        new StringBuilder("Exception in parseActionList: ").append(e.getMessage());
                        if (obj != null) {
                            return linkedList;
                        }
                        aVar.hOg = linkedList2;
                        int i3 = 1;
                    }
                } else if (obj != null) {
                    return linkedList;
                } else {
                    aVar.hOg = linkedList2;
                    obj2 = 1;
                    linkedList.add(aVar);
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            linkedList.add(aVar);
            i++;
            obj = obj2;
        }
        return linkedList;
    }

    private static a a(Map<String, String> map, int i, String str) {
        a aVar = new a(i);
        aVar.title = bh.ou((String) map.get(str + ".title"));
        aVar.niP = bh.ou((String) map.get(str + ".summary"));
        String str2 = str + ".thumburl";
        int i2 = 0;
        while (i2 < 100) {
            String str3 = (String) map.get(str2 + (i2 > 0 ? Integer.valueOf(i2) : ""));
            if (bh.ov(str3)) {
                break;
            }
            aVar.qsM.add(str3);
            i2++;
        }
        switch (i) {
            case 3:
                aVar.qsL = bh.ou((String) map.get(str + ".h5url.link"));
                aVar.qsN = bh.ou((String) map.get(str + ".h5url.title"));
                aVar.qsO = bh.ou((String) map.get(str + ".h5url.username"));
                break;
            case 4:
                aVar.qsL = bh.ou((String) map.get(str + ".bizprofile.username"));
                aVar.qsN = bh.ou((String) map.get(str + ".bizprofile.showchat"));
                break;
            case 5:
                aVar.qsL = bh.ou((String) map.get(str + ".nativepay.wx_pay_url"));
                break;
            case 6:
                aVar.qsL = bh.ou((String) map.get(str + ".product.product_id"));
                break;
        }
        return aVar;
    }
}
