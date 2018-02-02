package c.t.m.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class aj {
    public int a;
    public String b;
    public int c = 0;
    public byte[] d;
    private Map<String, String> e;

    public aj(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public final String a(String str) {
        if (!(this.e == null || TextUtils.isEmpty(str))) {
            String str2 = (String) this.e.get(str.toLowerCase());
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return "";
    }

    public final void a(Map<String, String> map) {
        this.e = new HashMap();
        if (map.size() > 0) {
            for (String str : map.keySet()) {
                this.e.put(str.toLowerCase(), map.get(str));
            }
        }
    }

    public final String toString() {
        return "errorCode:" + this.a + ",errorInfo:" + this.b + ",httpStatus:" + this.c + ",headers:" + this.e + ",body:" + (this.d != null ? Integer.valueOf(this.d.length) : "null");
    }
}
