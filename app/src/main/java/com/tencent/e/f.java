package com.tencent.e;

import com.tencent.e.b.a;
import com.tencent.e.b.b;
import com.tencent.e.b.c;
import com.tencent.e.b.d;
import java.util.HashMap;

public final class f {
    private static f Amy;
    HashMap<String, Object> AmA = new HashMap();
    private Object AmB = new Object();
    Object AmC = new Object();
    private a AmD = new a(this);
    private HashMap<String, g> Amz = new HashMap();

    static f cHs() {
        if (Amy == null) {
            synchronized (f.class) {
                if (Amy == null) {
                    Amy = new f();
                }
            }
        }
        return Amy;
    }

    public static Object abQ(String str) {
        return cHs().abR(str);
    }

    public static b a(d dVar) {
        return cHs().b(dVar);
    }

    private Object abR(String str) {
        if (str == null) {
            throw new h("TpfServiceCenter|getService|service name should not be null");
        }
        Object obj;
        synchronized (this.AmC) {
            obj = this.AmA.get(str);
        }
        if (obj == null) {
            g gVar;
            synchronized (this.AmB) {
                gVar = (g) this.Amz.get(str);
            }
            if (gVar != null) {
                if (gVar.AmH.AmT) {
                    return c(gVar);
                }
                Object obj2;
                if (4 == gVar.mState) {
                    try {
                        a(gVar);
                    } catch (c e) {
                        com.tencent.pb.common.c.c.m("service", new Object[]{e});
                        return null;
                    }
                }
                synchronized (this.AmC) {
                    obj2 = this.AmA.get(str);
                }
                return obj2;
            }
        }
        return obj;
    }

    private b b(d dVar) {
        Object obj = 1;
        if (dVar == null || dVar.AmR == null) {
            return null;
        }
        String str = dVar.AmR;
        this.AmD.ge("install_", str);
        try {
            b bVar;
            Object obj2;
            synchronized (this.AmB) {
                bVar = (g) this.Amz.get(str);
                if (bVar == null) {
                    bVar = new g(this, dVar);
                    bVar.mState = 2;
                    com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] installed!"});
                    this.Amz.put(str, bVar);
                    obj2 = 1;
                } else {
                    com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] had been installed!"});
                    obj2 = null;
                }
            }
            if (obj2 != null) {
                if (dVar.AmQ == null) {
                    obj = null;
                }
                if (obj != null) {
                    bVar.mState = 4;
                    com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] resolved!"});
                } else {
                    throw new c("resolve service [" + str + "] failed.");
                }
            }
            this.AmD.gf("install_", str);
            return bVar;
        } catch (Throwable th) {
            this.AmD.gf("install_", str);
        }
    }

    final boolean a(g gVar) {
        boolean z = false;
        d dVar = gVar.AmH;
        String str = dVar.AmR;
        this.AmD.ge("service_", str);
        try {
            if (gVar.mState == 32) {
                z = true;
            } else if (gVar.mState == 4) {
                gVar.mState = 8;
                com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] starting..."});
                if (dVar.AmS != null) {
                    P(dVar.AmS);
                }
                if (b(gVar)) {
                    gVar.mState = 32;
                    com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] active..."});
                    z = true;
                }
            }
            this.AmD.gf("service_", str);
            if (z) {
                return true;
            }
            throw new c("startService [" + str + "] failed");
        } catch (Throwable th) {
            this.AmD.gf("service_", str);
        }
    }

    private boolean P(String[] strArr) {
        if (strArr != null) {
            for (Object obj : strArr) {
                if (obj != null) {
                    g gVar;
                    synchronized (this.AmB) {
                        gVar = (g) this.Amz.get(obj);
                    }
                    if (gVar == null) {
                        return false;
                    }
                    a(gVar);
                    if (gVar.mState != 32) {
                        return false;
                    }
                    gVar.mReferenceCount++;
                    com.tencent.pb.common.c.c.d("reference_count", new Object[]{"addReferenceCount|", gVar.AmH.AmR, "|refcount=", Integer.valueOf(gVar.mReferenceCount)});
                }
            }
        }
        return true;
    }

    private static boolean b(g gVar) {
        if (!gVar.AmH.AmT) {
            try {
                b bVar = (b) Class.forName(gVar.AmH.AmQ).newInstance();
                gVar.AmI = bVar;
                a aVar = new a(gVar);
                gVar.AmJ = aVar;
                bVar.a(aVar);
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.m("service", new Object[]{e});
            }
        }
        return false;
    }

    private static Object c(g gVar) {
        try {
            c cVar = (c) Class.forName(gVar.AmH.AmQ).newInstance();
            gVar.AmJ = new a(gVar);
            gVar.mState = 32;
            return cVar.cHp();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("service", new Object[]{e});
            return null;
        }
    }
}
