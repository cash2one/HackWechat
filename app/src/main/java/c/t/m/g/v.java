package c.t.m.g;

import android.text.TextUtils;
import c.t.m.g.al.b;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;

public final class v {
    public static String a;
    private final int b = a("black_list_refresh_gap", 60000, Downloads.MAX_RETYR_AFTER, 3600000);
    private String c = "";
    private List<n> d = new ArrayList();
    private List<n> e = new ArrayList();
    private List<a> f = new ArrayList();

    public v(String str) {
        this.c = str;
        cb.a(str, "");
        ab.a().a(new w(this), true, (long) this.b);
    }

    private synchronized void c() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (a aVar : this.f) {
                stringBuilder.append(aVar.a.a()).append("-").append(aVar.b).append(";");
            }
            cb.a(this.c, stringBuilder.toString());
        } catch (Throwable th) {
            cb.a(this.c, "");
        }
        return;
    }

    final synchronized void a() {
        synchronized (this) {
            try {
                this.e.clear();
                this.f.clear();
                Object b = cb.b(this.c, "");
                if (!TextUtils.isEmpty(b)) {
                    int a = a("black_list_outofdate", 60000, Downloads.MAX_RETYR_AFTER, 7200000);
                    for (String split : b.split(";")) {
                        String[] split2 = split.split("-");
                        String str = split2[0];
                        long parseLong = Long.parseLong(split2[1]);
                        if (System.currentTimeMillis() - parseLong < ((long) a)) {
                            split2 = str.split(":");
                            n nVar = new n(split2[0], Integer.parseInt(split2[1]));
                            a aVar = new a(nVar, parseLong);
                            this.e.add(nVar);
                            this.f.add(aVar);
                        }
                    }
                    c();
                }
            } catch (Throwable th) {
                cb.a(this.c, "");
            }
        }
    }

    public final synchronized void a(n nVar) {
        Object obj;
        for (n a : this.d) {
            if (nVar.a(a)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.e.add(nVar);
            this.f.add(new a(nVar, System.currentTimeMillis()));
            c();
        } else {
            this.d.add(nVar);
        }
    }

    public final synchronized List<n> b() {
        List<n> arrayList;
        arrayList = new ArrayList();
        for (n nVar : this.e) {
            arrayList.add(new n(nVar.a, nVar.b));
        }
        return arrayList;
    }

    public final synchronized void b(n nVar) {
        for (Object obj : this.d) {
            if (nVar.a((n) obj)) {
                break;
            }
        }
        Object obj2 = null;
        if (obj2 != null) {
            this.d.remove(obj2);
        }
    }

    public static int a(String str, int i, int i2, int i3) {
        int parseInt;
        try {
            String a = a(str, m.b());
            if (TextUtils.isEmpty(a)) {
                a = a(str, 0);
            }
            parseInt = Integer.parseInt(a);
        } catch (Throwable th) {
            parseInt = i3;
        }
        return cg.a(parseInt, i, i2, i3);
    }

    private static String a(String str, int i) {
        return ((bv) bx.c().a.get("settings")).a(str, i, m.e(), m.a, be.a().a(p.b()), cb.a(p.g()));
    }

    public static boolean a(String str, boolean z, Map<String, String> map) {
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        try {
            al d = at.d();
            String a = at.a(str, z, map);
            try {
                if (d.i.getAndIncrement() > d.j) {
                    d.i.decrementAndGet();
                } else {
                    new b(d, a).a(false);
                }
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
        }
        return true;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[256];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.finish();
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }
}
