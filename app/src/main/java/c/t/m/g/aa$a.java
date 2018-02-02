package c.t.m.g;

final class aa$a {
    public String a;
    public boolean b = true;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    private String[] h;

    public aa$a(String str, int i, String str2, String str3, String str4, String str5) {
        this.a = str;
        String[] split = str.split("-");
        if (split.length < 5) {
            this.h = new String[]{"all", "all", "all", "all", "all"};
            for (int i2 = 0; i2 < split.length; i2++) {
                this.h[i2] = split[i2];
            }
        } else {
            this.h = split;
        }
        this.c = a(0, String.valueOf(i));
        this.d = a(1, str2);
        this.e = a(2, str3);
        this.f = a(3, str4);
        this.g = a(4, str5);
        this.h = null;
    }

    private boolean a(int i, String str) {
        if (this.h.length < i + 1) {
            return false;
        }
        boolean equals = this.h[i].equals(str);
        if (equals || this.h[i].equals("all")) {
            return equals;
        }
        this.b = false;
        return equals;
    }
}
