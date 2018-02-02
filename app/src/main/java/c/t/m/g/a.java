package c.t.m.g;

import android.os.SystemClock;

public final class a {
    private static volatile boolean a = false;

    public static d a(b bVar) {
        if (!a) {
            b(bVar);
        }
        return g.a();
    }

    private static synchronized void b(b bVar) {
        boolean z = true;
        synchronized (a.class) {
            if (!a) {
                System.currentTimeMillis();
                SystemClock.elapsedRealtime();
                if (bVar == null) {
                    throw new c("initParam null");
                }
                String packageName = bVar.a.getPackageName();
                String a = cb.a(bVar.a);
                int a2 = bVar.c ? bVar.b : cb.a(bVar.a, packageName);
                if (a2 <= 0) {
                    throw new c("appid illegal:" + a2);
                }
                if (!bVar.c) {
                    c.t.m.g.cb.a a3 = cb.a(a2, bVar.a, packageName, "com.tencent.halley.common.platform.service.PlatformService");
                    if (a3 == null) {
                        throw new c("need set PlatformService in manifest for halley");
                    }
                    if (!(a3.d == null || a3.a == null)) {
                        if (a3.d.equals(a3.a)) {
                            z = false;
                        }
                        m.g = z;
                    }
                    if (a3.c) {
                        throw new c("need set PlatformService exported to false");
                    } else if (a3.b) {
                        c.t.m.g.cb.a a4 = cb.a(a2, bVar.a, packageName, "com.tencent.halley.common.platform.service.ActivateService");
                        if (a4 != null) {
                            if (!a4.c) {
                                throw new c("need set ActivateService exported to true");
                            } else if (a4.e == null) {
                                throw new c("need set security_version for ActivateService");
                            } else if (a4.e.getInt("security_version") <= 0) {
                                throw new c("need set valid security_version for ActivateService");
                            }
                        }
                    } else {
                        throw new c("need set PlatformService enabled to true");
                    }
                }
                m.a(a2, bVar, a);
                v.a = bVar.f;
                Object c = bx.c();
                if (m.f()) {
                    c.b = bw.c();
                }
                c.b.a(c);
                c.b.d();
                a = true;
                SystemClock.elapsedRealtime();
            }
        }
    }
}
