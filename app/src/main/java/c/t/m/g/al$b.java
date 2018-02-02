package c.t.m.g;

import android.text.TextUtils;
import c.t.m.g.al.a;

public final class al$b extends a {
    private String a;
    private boolean b = true;
    private /* synthetic */ al c;

    public al$b(al alVar, String str) {
        this.c = alVar;
        super(alVar, (byte) 0);
        this.a = str;
    }

    public final void run() {
        super.run();
        this.c.i.decrementAndGet();
        if (!TextUtils.isEmpty(this.a)) {
            StringBuilder stringBuilder = new StringBuilder(this.a);
            int a = v.a("report_new_record_num", 1, 50, 10);
            if (au.a(this.c.c()).b(stringBuilder.toString()) != -1 && this.c.e.incrementAndGet() >= a) {
                this.c.a(false, this.b);
            }
        }
    }
}
