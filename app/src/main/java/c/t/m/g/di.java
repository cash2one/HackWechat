package c.t.m.g;

import android.os.SystemClock;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public final class di {
    final LinkedBlockingQueue<a> a = new LinkedBlockingQueue(3);
    final cr b;
    long c;
    long d;
    long e;
    long f;
    volatile boolean g;
    boolean h;

    di(cr crVar) {
        this.b = crVar;
    }

    public final void a(String str, dp dpVar, int i) {
        try {
            byte[] a = j.a(str.getBytes("GBK"));
            a aVar = new a(1, a, a(a, i), dpVar);
            aVar.b = str;
            a(aVar);
        } catch (Throwable th) {
        }
    }

    final boolean a(a aVar) {
        boolean offer;
        SystemClock.elapsedRealtime();
        if (a.a(aVar) != null) {
            offer = this.a.offer(aVar);
        } else {
            offer = false;
        }
        if (!offer) {
            this.a.clear();
            this.a.offer(aVar);
            String str = "Location";
            if (a.b(aVar) == 2) {
                str = "List";
            } else if (a.b(aVar) == 3) {
                str = "Wifis";
            } else if (a.b(aVar) == 4) {
                str = "EventTrack";
            }
            new StringBuilder("post").append(str).append("Request: failed to add request,because the queue has full,so we delete the first");
        }
        return offer;
    }

    final void b(a aVar) {
        Object obj;
        a.d(aVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (a.b((a) it.next()) == a.b(aVar)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (a.e(aVar) > 0 && r0 == null) {
            new StringBuilder("retryIfNeed: times=").append(a.e(aVar));
            this.a.offer(aVar);
        }
    }

    private static String a(byte[] bArr, int i) {
        if (!(TencentLogImpl.isDebugEnabled() || bArr == null)) {
            try {
                if (e.o(bArr, 1) >= 0) {
                    return db.a(i, 1);
                }
            } catch (UnsatisfiedLinkError e) {
                return null;
            }
        }
        return db.a(i, 0);
    }
}
