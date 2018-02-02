package c.t.m.g;

public final class ch {
    private static a a = null;

    public static void a(a aVar) {
        a = aVar;
    }

    private static boolean a() {
        return a != null;
    }

    public static final void a(String str, String str2) {
        if (a()) {
            a.onLog(3, str, str2);
        }
    }

    public static final void b(String str, String str2) {
        if (a()) {
            a.onLog(6, str, str2);
        }
    }

    public static final void a(String str, String str2, Throwable th) {
        if (a()) {
            a.onLog(6, str, str2, th);
        }
    }
}
