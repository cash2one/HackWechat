package c.t.m.g;

import java.io.Serializable;
import java.util.Map;

public final class av implements Serializable {
    long a;
    String b;
    String c;
    private String d;
    private Map<String, String> e;

    public final synchronized String a() {
        return this.d;
    }

    public final synchronized void a(String str) {
        this.d = str;
    }

    public final synchronized void a(Map<String, String> map) {
        this.e = map;
    }

    public final synchronized Map<String, String> b() {
        return this.e;
    }
}
