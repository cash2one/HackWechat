package c.t.m.g;

import android.text.TextUtils;

public final class n {
    public String a = "";
    public int b = -1;
    public int c = -1;

    public n(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final String a() {
        return this.a + ":" + this.b;
    }

    public final boolean a(n nVar) {
        return nVar != null && this.a.equals(nVar.a) && this.b == nVar.b;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split(":");
        if (split.length != 2) {
            return false;
        }
        this.a = split[0];
        if (!cg.d(this.a)) {
            return false;
        }
        try {
            this.b = Integer.parseInt(split[1]);
            return this.b >= 0 && this.b <= 65535;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public final boolean b() {
        return this.b == -1;
    }

    public final String toString() {
        return a();
    }
}
