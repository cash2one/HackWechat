package com.tencent.mm.ipcinvoker;

public final class g {
    public static void fi(String str) {
        if (!fk(str)) {
            n.post(new 2(str));
        }
    }

    public static void fj(final String str) {
        if (!fk(str)) {
            n.post(new Runnable() {
                public final void run() {
                    b.Bs().fg(str);
                }
            });
        }
    }

    public static boolean fk(String str) {
        return (e.fh(str) || b.Bs().gMl.get(str) == null) ? false : true;
    }
}
