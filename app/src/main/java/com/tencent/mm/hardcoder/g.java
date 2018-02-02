package com.tencent.mm.hardcoder;

import android.os.Build;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g implements com.tencent.mm.hardcoder.f.a {
    public static int gLo = -1;
    public static int gLp = -1;
    final Map<Integer, a> gLm = new TreeMap();
    private int gLn = 0;

    public static class a {
        public final Map<Long, Integer> gLs = new TreeMap();
    }

    public final void initialize() {
        this.gLm.clear();
        try {
            String str = Build.MODEL;
            if (str != null) {
                Iterator keys;
                x.i("MicroMsg.PowerConsumption", "[oneliang] device model:%s", str);
                str = str.toUpperCase();
                InputStream open = ac.getContext().getAssets().open("hardcoder/power.json");
                final StringBuilder stringBuilder = new StringBuilder();
                f.a(open, new com.tencent.mm.hardcoder.f.a(this) {
                    final /* synthetic */ g gLr;

                    public final boolean fd(String str) {
                        stringBuilder.append(str);
                        return true;
                    }
                });
                JSONObject jSONObject = new JSONObject(stringBuilder.toString());
                if (jSONObject.has(str)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                    keys = jSONObject2.keys();
                    int i = 0;
                    while (keys.hasNext()) {
                        keys.next();
                        i++;
                    }
                    int i2 = 0;
                    while (i2 < i && jSONObject2.has("cluster" + i2)) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("cluster" + i2);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            fd(jSONArray.getString(i3));
                        }
                        this.gLn = this.gLm.size();
                        switch (i2) {
                            case 0:
                                gLo = this.gLn - 1;
                                break;
                            case 1:
                                gLp = this.gLn - 1;
                                break;
                            default:
                                break;
                        }
                        i2++;
                    }
                }
                x.i("MicroMsg.PowerConsumption", "[oneliang] cluster0:%s,cluster1:%s", Integer.valueOf(gLo), Integer.valueOf(gLp));
                for (Entry entry : this.gLm.entrySet()) {
                    x.i("MicroMsg.PowerConsumption", "config cpu:" + entry.getKey());
                    for (Entry entry2 : ((a) entry2.getValue()).gLs.entrySet()) {
                        x.i("MicroMsg.PowerConsumption", entry2.getKey() + "," + entry2.getValue());
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.PowerConsumption", "initialize exception:" + e.getMessage());
        }
    }

    public final boolean fd(String str) {
        String[] split = str.trim().split(",");
        if (split.length > 0) {
            long j = bh.getLong(split[0], 0);
            for (int i = 1; i < split.length; i++) {
                a aVar;
                Integer valueOf = Integer.valueOf((this.gLn + i) - 1);
                if (this.gLm.containsKey(valueOf)) {
                    aVar = (a) this.gLm.get(valueOf);
                } else {
                    aVar = new a();
                    this.gLm.put(valueOf, aVar);
                }
                aVar.gLs.put(Long.valueOf(j), Integer.valueOf(bh.getInt(split[i], 0)));
            }
        }
        return true;
    }
}
