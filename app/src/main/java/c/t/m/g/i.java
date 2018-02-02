package c.t.m.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class i implements e {
    public String a;
    public byte[] b;
    public Map<String, String> c;
    public boolean d = true;
    public int e = -1;
    public String f = "";
    public volatile boolean g = false;
    public int h = 0;
    public boolean i = true;
    CountDownLatch j = new CountDownLatch(1);
    public volatile boolean k = false;
    public long l;
    private aj m;

    public i(String str, byte[] bArr) {
        this.a = str;
        this.b = bArr;
        this.f = cg.d();
    }

    public final String a() {
        return this.f;
    }

    public final synchronized void a(aj ajVar) {
        this.m = ajVar;
    }

    public final void a(String str, String str2) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.c.put(str, str2);
        }
    }

    public final void b() {
        this.h = 15000;
    }

    public final boolean c() {
        try {
            return this.j.await((long) this.h, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return true;
        }
    }

    public final synchronized aj d() {
        return this.m;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url:" + this.a);
        stringBuilder.append(",body:" + cg.b(this.b));
        stringBuilder.append(",isGet:false");
        stringBuilder.append(",timeout:" + this.e);
        stringBuilder.append(",tag:" + null);
        stringBuilder.append(",httpCallback:" + null);
        stringBuilder.append(",testMode:0");
        stringBuilder.append(",httpCallback:" + null);
        stringBuilder.append(",testMode:0");
        stringBuilder.append(",followRedirects:" + this.d);
        stringBuilder.append(",isAbort:" + this.g);
        stringBuilder.append(",headers:" + this.c);
        return stringBuilder.toString();
    }
}
