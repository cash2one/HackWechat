package c.t.m.g;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class af {
    private static v i = new v("direct_ip_black_list");
    URL a;
    int b;
    public String c;
    private boolean d;
    private boolean e;
    private int f;
    private String g;
    private s h;

    public af(URL url, String str, s sVar) {
        boolean z = false;
        this.d = v.a("direct_access_use_schedule", 0, 1, 1) == 1;
        if (v.a("direct_https_use_sche", 0, 1, 1) == 1) {
            z = true;
        }
        this.e = z;
        this.f = v.a("direct_access_domain_try_times", 1, 8, 2);
        this.c = "";
        this.a = url;
        this.g = str;
        this.h = sVar;
    }

    private List<n> a() {
        int i = 0;
        List arrayList = new ArrayList();
        r rVar = null;
        if (this.h != null) {
            rVar = this.h.a(this.a.getHost());
        }
        if (rVar != null) {
            Collection collection = rVar.c;
            this.c = rVar.b;
            this.b = rVar.d;
            if (collection != null && collection.size() > 0) {
                arrayList.addAll(collection);
            }
        }
        n nVar = new n(this.g, -1);
        List<n> arrayList2 = new ArrayList();
        if (arrayList.size() == 0) {
            while (i < this.f) {
                arrayList2.add(nVar);
                i++;
            }
            nVar.c = 5;
            return arrayList2;
        }
        List<n> list;
        if (this.c == null || !this.c.contains("bott")) {
            a(arrayList, (List) arrayList2);
            arrayList2.add(nVar);
            nVar.c = 6;
        } else {
            arrayList2.add(nVar);
            nVar.c = 7;
            a(arrayList, (List) arrayList2);
        }
        if (arrayList2.size() <= 1) {
            arrayList2 = new ArrayList();
            while (i < this.f) {
                arrayList2.add(nVar);
                i++;
            }
            nVar.c = 9;
            list = arrayList2;
        } else {
            list = arrayList2;
        }
        return list;
    }

    public static void a(n nVar) {
        i.a(nVar);
    }

    private static void a(List<n> list, List<n> list2) {
        try {
            List<n> b = i.b();
            for (n nVar : list) {
                Object obj;
                for (n a : b) {
                    if (nVar.a(a)) {
                        obj = 1;
                        continue;
                        break;
                    }
                }
                obj = null;
                continue;
                if (obj == null) {
                    list2.add(nVar);
                    return;
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void b(n nVar) {
        i.b(nVar);
    }

    public final List<n> a(boolean z, boolean z2) {
        List<n> arrayList;
        int i = 0;
        n nVar = new n(this.g, -1);
        try {
            arrayList = new ArrayList();
            if (!z) {
                arrayList.add(nVar);
                nVar.c = 1;
                return arrayList;
            } else if (!p.i() && this.d && (!z2 || this.e)) {
                return a();
            } else {
                int i2;
                for (i2 = 0; i2 < this.f; i2++) {
                    arrayList.add(nVar);
                }
                i2 = p.i() ? 2 : !this.d ? 3 : 4;
                nVar.c = i2;
                return arrayList;
            }
        } catch (Exception e) {
            arrayList = new ArrayList();
            while (i < this.f) {
                arrayList.add(nVar);
                i++;
            }
            nVar.c = 8;
            return arrayList;
        }
    }
}
