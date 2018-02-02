package c.t.m.g;

import c.t.m.g.x.a;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class y {
    private static String a = "info.3g.qq.com";

    public static boolean a() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean[] zArr = new boolean[]{false};
        a.a().a.execute(new z(zArr, countDownLatch));
        try {
            countDownLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return zArr[0];
    }

    private static boolean a(String str) {
        Socket socket;
        Throwable th;
        boolean z = false;
        try {
            socket = new Socket();
            try {
                socket.connect(new InetSocketAddress(str, 80), 5000);
                if (socket.isConnected()) {
                    z = true;
                }
                try {
                    socket.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            socket = null;
            if (socket != null) {
                socket.close();
            }
            throw th;
        }
        return z;
    }

    public static boolean b() {
        return a(a);
    }

    static /* synthetic */ boolean c() {
        return Runtime.getRuntime().exec(new StringBuilder("ping -c 1 -w 5 ").append(a).toString()).waitFor() == 0;
    }
}
