package com.tencent.mm.modelstat;

import android.util.Pair;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.modelstat.c.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class c$a {
    Map<String, Boolean> hQf = new HashMap();
    long hQg;
    long hQh;
    List<c> hQp = new ArrayList();

    static class a extends Exception {
        a(String str) {
            super(str);
        }

        a(Throwable th) {
            super(th);
        }
    }

    private c$a() {
    }

    public final String toString() {
        return "Config{nextUpdateInterval=" + this.hQg + ", samplePeriod=" + this.hQh + ", eventList=" + this.hQp + '}';
    }

    static c$a mK(String str) {
        c$a com_tencent_mm_modelstat_c_a = new c$a();
        try {
            Map y = bi.y(str, "eventSampleConf");
            if (y == null) {
                x.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", new Object[]{str});
                throw new a("reportConfigMap is null");
            }
            com_tencent_mm_modelstat_c_a.hQg = bh.getLong((String) y.get(".eventSampleConf.nextUpdateInterval"), 0);
            if (com_tencent_mm_modelstat_c_a.hQg <= 0 || com_tencent_mm_modelstat_c_a.hQg > 432000) {
                com_tencent_mm_modelstat_c_a.hQg = 432000;
            }
            com_tencent_mm_modelstat_c_a.hQh = bh.getLong((String) y.get(".eventSampleConf.samplePeriod"), 0);
            int i = 0;
            while (true) {
                c cVar = new c((byte) 0);
                String str2 = ".eventSampleConf.events.event" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                int i2 = i + 1;
                cVar.id = bh.getInt((String) y.get(str2 + SlookAirButtonFrequentContactAdapter.ID), 0);
                if (cVar.id > 0) {
                    String str3;
                    int i3;
                    String str4;
                    cVar.hQs = bh.getLong((String) y.get(str2 + "expireTime"), 0);
                    cVar.name = (String) y.get(str2 + "name");
                    cVar.hQt = bh.getFloat((String) y.get(str2 + "rate"), 0.0f);
                    cVar.hQu = bh.getInt((String) y.get(str2 + "logId"), 0);
                    cVar.hQv = (String) y.get(str2 + "pages.$type");
                    ArrayList arrayList = new ArrayList();
                    i = 0;
                    while (true) {
                        str3 = str2 + "pages.page" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                        i3 = i + 1;
                        str4 = (String) y.get(str3 + "$id");
                        if (str4 == null) {
                            break;
                        }
                        boolean equals = ((String) y.get(str3 + "$action")).equals("true");
                        arrayList.add(new Pair(str4, Boolean.valueOf(equals)));
                        com_tencent_mm_modelstat_c_a.hQf.put(str4, Boolean.valueOf(equals));
                        i = i3;
                    }
                    cVar.hQw = arrayList;
                    arrayList = new ArrayList();
                    i = 0;
                    while (true) {
                        str3 = str2 + "specialPVPages.pageItem" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                        i3 = i + 1;
                        str4 = (String) y.get(str3 + "$prePage");
                        if (str4 == null) {
                            break;
                        }
                        arrayList.add(new Pair(str4, (String) y.get(str3 + "$page")));
                        i = i3;
                    }
                    cVar.hQx = arrayList;
                    com_tencent_mm_modelstat_c_a.hQp.add(cVar);
                    x.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", new Object[]{cVar});
                    i = i2;
                } else {
                    x.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", new Object[]{com_tencent_mm_modelstat_c_a});
                    return com_tencent_mm_modelstat_c_a;
                }
            }
        } catch (Throwable e) {
            throw new a(e);
        }
    }
}
