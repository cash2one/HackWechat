package c.t.m.g;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class be {
    private static be b = new be();
    public Map<String, String> a = new bf();

    private be() {
        a(cb.b("HalleyOperInfo_" + m.b(), ""), false);
    }

    public static be a() {
        return b;
    }

    public static String a(int i) {
        return i == 1 ? "cm" : i == 3 ? "ct" : i == 2 ? "uni" : "";
    }

    public final String a(String str) {
        if (cg.a(str) || "unknown".equals(str)) {
            return "";
        }
        synchronized (this.a) {
            String str2 = (String) this.a.get(str);
            if (cg.a(str2)) {
                return "";
            }
            return str2;
        }
    }

    public final void a(String str, boolean z) {
        try {
            if (!cg.a(str)) {
                synchronized (this.a) {
                    this.a.clear();
                    String[] split = str.split("h;l");
                    if (split != null) {
                        for (String split2 : split) {
                            String[] split3 = split2.split("h,l");
                            if (split3.length == 2) {
                                this.a.put(split3[0], split3[1]);
                            }
                        }
                    }
                }
                if (z) {
                    cb.a("HalleyOperInfo_" + m.b(), str);
                }
            }
        } catch (Exception e) {
        }
    }

    public final String b() {
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (this.a) {
            List arrayList = new ArrayList(this.a.keySet());
            List arrayList2 = new ArrayList(this.a.values());
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList2.get(i);
                stringBuilder.append((String) arrayList.get(i)).append("h,l").append(str).append("h;l");
            }
        }
        return stringBuilder.toString();
    }
}
