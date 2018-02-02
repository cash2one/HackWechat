package com.tencent.mm.lan_cs;

public final class Server {
    public static a gUo;

    public static class C2Java {
        public static void onSend(String str, int i, int i2) {
            if (Server.gUo != null) {
                Server.gUo.gH(i2);
            }
        }

        public static void onRecv(String str, int i, byte[] bArr) {
            if (Server.gUo != null) {
                Server.gUo.onRecv(str, i, bArr);
            }
        }

        public static void onConnect(String str, int i) {
            if (Server.gUo != null) {
                Server.gUo.onConnect(str, i);
            }
        }

        public static void onDisconnect(String str, int i) {
            if (Server.gUo != null) {
                Server.gUo.En();
            }
        }
    }

    public static class Java2C {
        public static native int send(String str, int i, byte[] bArr);

        private static native Object[] start();

        public static native void stop();
    }

    public interface a {
        void En();

        void gH(int i);

        void onConnect(String str, int i);

        void onRecv(String str, int i, byte[] bArr);
    }
}
