package c.t.m.g;

import java.util.ArrayList;
import java.util.List;

final class al$d extends al$a {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d = false;
    public List<au$a> e;
    int f;
    private /* synthetic */ al g;

    public al$d(al alVar, boolean z, boolean z2) {
        this.g = alVar;
        super(alVar);
        this.b = z;
        this.c = z2;
    }

    public final void run() {
        List list = null;
        int i = 0;
        super.run();
        this.a = false;
        if (this.b) {
            int size = this.g.f.size();
            if (size != 0) {
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                int i2 = 0;
                for (int i3 = 0; i3 < size && i2 < 10; i3++) {
                    String str = (String) this.g.f.get(i3);
                    arrayList2.add(new au$a(0, str));
                    arrayList.add(str);
                    i2++;
                }
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.g.f.remove(arrayList.get(i4));
                }
                if (this.g.f.size() == 0) {
                    this.a = true;
                }
                list = arrayList2;
            }
            this.e = list;
        } else {
            if (!au.a(this.g.c()).a(v.a("report_clear_db_num", 1, 10000, 1000))) {
                list = au.a(this.g.c()).a();
                if (list.size() < 10) {
                    this.a = true;
                }
            }
            this.e = list;
        }
        if (this.e == null || this.e.size() == 0) {
            this.g.g = false;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < this.e.size()) {
            stringBuilder.append(((au$a) this.e.get(i)).b);
            i++;
        }
        str = stringBuilder.toString();
        if (stringBuilder.toString().contains("client_report_time")) {
            str = stringBuilder.toString().replace("client_report_time", cg.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        this.f = length;
        byte[] a = v.a(bytes);
        this.g.d.a(a, length, this.b, this, this.g.k);
    }
}
