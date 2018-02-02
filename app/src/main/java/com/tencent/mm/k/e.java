package com.tencent.mm.k;

import com.tencent.mm.g.a.ck;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {
    private HashMap<String, String> gIi = new HashMap();
    public boolean gIj = false;

    public final synchronized String getValue(String str) {
        if (!this.gIj) {
            x.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            ks();
        }
        x.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", str.trim(), this.gIi.get(str));
        return (String) this.gIi.get(str);
    }

    public final int getInt(String str, int i) {
        try {
            i = Integer.parseInt(getValue(str));
        } catch (Exception e) {
            x.e("MicroMsg.DynamicConfig", "parseInt failed, val: " + str);
        }
        return i;
    }

    public final synchronized List<String> eQ(String str) {
        List<String> arrayList;
        if (!this.gIj) {
            x.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            ks();
        }
        arrayList = new ArrayList();
        if (!bh.ov(str)) {
            for (String str2 : this.gIi.keySet()) {
                if (str2.matches(str)) {
                    arrayList.add(this.gIi.get(str2));
                }
            }
        }
        x.d("MicroMsg.DynamicConfig", "searchValues, entry:%s, size:%d", str, Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    @Deprecated
    public final synchronized void put(String str, String str2) {
        if (!(str == null || str2 == null)) {
            x.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", str.trim(), str2);
            this.gIi.put(str, str2);
        }
    }

    public synchronized void ks() {
        g.Dk();
        if (g.Dj() != null) {
            g.Dk();
            if (g.Dj().CU() != null) {
                this.gIj = true;
                g.Dk();
                l((String) g.Dj().CU().get(278529, null), false);
            }
        }
        g.Dk();
        if (g.Dj() != null) {
            g.Dk();
            if (g.Dj().CU() != null) {
                this.gIj = true;
                g.Dk();
                l((String) g.Dj().CU().get(278530, null), true);
            }
        }
    }

    public final synchronized void a(String str, Map<String, String> map, boolean z) {
        if (!bh.ov(str)) {
            x.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", Boolean.valueOf(z), com.tencent.mm.a.g.bV(str));
            if (z) {
                g.Dk();
                g.Dj().CU().set(278530, str);
            } else {
                g.Dk();
                g.Dj().CU().set(278529, str);
                g.Dk();
                g.Dj().CU().set(278530, "");
            }
            if (map != null) {
                a(map, z);
            } else {
                l(str, z);
            }
            a.xef.m(new ck());
        }
    }

    public final void l(String str, boolean z) {
        a(bi.y(str, "sysmsg"), z);
    }

    private void a(Map<String, String> map, boolean z) {
        if (map != null) {
            if (!z) {
                this.gIi.clear();
            }
            int i = 0;
            while (i < 10000) {
                String str;
                if (z) {
                    str = ".sysmsg.dynacfg_split.Item" + (i == 0 ? "" : Integer.valueOf(i));
                } else {
                    str = ".sysmsg.dynacfg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                }
                String str2 = str + ".$key";
                str = (String) map.get(str);
                str2 = (String) map.get(str2);
                if (str2 == null || bh.ov(str2.trim())) {
                    break;
                }
                this.gIi.put(str2.trim(), str != null ? str : "");
                x.d("MicroMsg.DynamicConfig", "put %s %s", str2.trim(), str);
                i++;
            }
            x.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", this.gIi.toString());
        }
    }
}
