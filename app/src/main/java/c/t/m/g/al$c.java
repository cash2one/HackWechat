package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.al.a;
import c.t.m.g.al.d;
import java.util.ArrayList;
import java.util.List;

final class al$c extends a {
    private d a;
    private /* synthetic */ al b;

    public al$c(al alVar, d dVar) {
        this.b = alVar;
        super(alVar, (byte) 0);
        this.a = dVar;
    }

    public final void run() {
        int i = 0;
        super.run();
        this.b.g = false;
        int i2;
        if (this.a.d) {
            this.b.b.addAndGet(this.a.f);
            if (!this.a.b) {
                int size = this.a.e.size();
                List arrayList = new ArrayList();
                for (i2 = 0; i2 < size; i2++) {
                    arrayList.add(Long.valueOf(((au.a) this.a.e.get(i2)).a));
                }
                au.a(this.b.c()).a(arrayList);
                if (this.b.h) {
                    this.b.h = false;
                    this.b.a(true, this.a.c);
                    return;
                }
            }
            if (!this.a.a) {
                SystemClock.sleep(20);
                this.b.a(this.a.b, this.a.c);
            }
        } else if (this.a.c && this.a.b) {
            i2 = this.a.e.size();
            while (i < i2) {
                au.a(this.b.c()).b(((au.a) this.a.e.get(i)).b);
                i++;
            }
        }
    }
}
