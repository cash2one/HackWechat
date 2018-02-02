package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a$b {
    private List<a> rem = new ArrayList();
    public Map<String, List<a>> ren = new HashMap();

    public final List<a> bws() {
        Object obj;
        String eL = w.eL(ac.getContext());
        if ("zh_CN".equals(eL) || "zh_TW".equals(eL) || "zh_HK".equals(eL)) {
            String str = eL;
        } else {
            obj = "en";
        }
        if (!this.ren.containsKey(obj)) {
            List arrayList = new ArrayList();
            for (a aVar : this.rem) {
                if ("zh_CN".equals(obj) && !bh.ov(aVar.rep)) {
                    arrayList.add(aVar);
                } else if (("zh_TW".equals(obj) || "zh_HK".equals(obj)) && !bh.ov(aVar.req)) {
                    arrayList.add(aVar);
                } else if ("en".equals(obj) && !bh.ov(aVar.rer)) {
                    arrayList.add(aVar);
                }
            }
            this.ren.put(obj, arrayList);
        }
        return (List) this.ren.get(obj);
    }

    public a$b(Map<String, String> map, String str) {
        String str2 = str + ".dislikeInfo.ReasonList";
        int i = 0;
        while (true) {
            String str3;
            String str4 = str2 + ".Reason";
            if (i > 0) {
                str3 = str4 + i;
            } else {
                str3 = str4;
            }
            if (map.get(str3 + ".ReasonId") != null) {
                this.rem.add(new a(bh.az((String) map.get(str3 + ".Wording.zh"), ""), bh.az((String) map.get(str3 + ".Wording.tw"), ""), bh.az((String) map.get(str3 + ".Wording.en"), ""), bh.VI((String) map.get(str3 + ".ReasonId"))));
                i++;
            } else {
                return;
            }
        }
    }
}
