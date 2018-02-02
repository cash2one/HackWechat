package c.t.m.g;

import android.text.TextUtils;

public abstract class bd {
    private a a;

    public bd(String str) {
        this.a = new a(m.a(), "halley_schedule_" + m.b() + "_" + m.h() + "_" + str + ".db");
    }

    public final synchronized void a(String str, byte[] bArr) {
        if (!(TextUtils.isEmpty(str) || bArr == null)) {
            this.a.a(str, bArr);
        }
    }

    public final synchronized byte[] a(String str) {
        return this.a.a(str);
    }
}
