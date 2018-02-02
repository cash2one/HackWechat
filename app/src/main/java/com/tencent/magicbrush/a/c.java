package com.tencent.magicbrush.a;

public final class c {

    public static class a {
        private static d bnn = new c();

        public static void a(d dVar) {
            bnn = dVar;
        }

        public static void i(int i, String str) {
            bnn.j(i, str);
        }
    }

    private static class c implements d {
        private c() {
        }

        public final void j(int i, String str) {
            f.i("Console", str, new Object[0]);
        }
    }
}
