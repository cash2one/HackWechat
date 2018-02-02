package com.tencent.mm.lan_cs;

public final class Client {
    public static a gUn;

    public static class C2Java {
        public static void onRecv(String str, int i, byte[] bArr) {
            if (Client.gUn != null) {
                Client.gUn.onRecv(str, i, bArr);
            }
        }

        public static void onDisconnect(String str, int i) {
            if (Client.gUn != null) {
                Client.gUn.En();
            }
        }
    }

    public static class Java2C {
        public static native void disconnect();

        public static native int send(String str, int i, byte[] bArr);
    }

    public interface a {
        void En();

        void onRecv(String str, int i, byte[] bArr);
    }
}
