package com.tencent.mm.aj;

import android.os.Process;
import com.tencent.mm.aj.c.b;
import com.tencent.mm.aj.c.c;
import com.tencent.mm.aj.c.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bu;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class a {
    private static boolean ahf = false;
    private static final c huq = new c();
    private static boolean hur = true;
    private static long hus = 0;
    private static long hut = 0;
    private static Thread thread = null;

    public static final void bK(boolean z) {
        boolean z2 = !ac.getContext().getSharedPreferences("system_config_prefs", 4).getBoolean("msg_delay_close_detect", false);
        hur = z2;
        if (z2) {
            ahf = z;
            if (z) {
                x.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
                if (thread != null) {
                    thread.interrupt();
                }
                thread = null;
                huq.clear();
                hus = bu.Ie();
                return;
            }
            x.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
            if (thread == null) {
                Thread b = e.b(huq, "ProcessDetector_" + Process.myPid());
                thread = b;
                b.start();
                huq.huK = true;
            }
            hut = bu.Ie();
        }
    }

    public static boolean bb(long j) {
        if (hus <= 0 || hut <= 0 || j <= 0) {
            return false;
        }
        if (hus >= hut) {
            if (j < hus) {
                return false;
            }
            return true;
        } else if (j >= hut) {
            return false;
        } else {
            return true;
        }
    }

    public static void hx(int i) {
        if (hur && !ahf) {
            c cVar = huq;
            cVar.huE.huM.add(new com.tencent.mm.aj.c.a(bu.Ie(), System.currentTimeMillis(), i));
        }
    }

    public static void hy(int i) {
        if (hur && !ahf) {
            c cVar = huq;
            cVar.huE.huN.add(new com.tencent.mm.aj.c.a(bu.Ie(), System.currentTimeMillis(), i));
        }
    }

    public static void a(long j, long j2, long j3, long j4, long j5) {
        if (hur) {
            c cVar = huq;
            x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]delayed msg[%s]", new c(Process.myPid(), j, j2, j3, j4, j5).toString());
            cVar.huE.huO.add(r0);
        }
    }

    public static void hz(int i) {
        huq.huC = i;
    }

    public static List<a> Nf() {
        if (!ac.cfw()) {
            return null;
        }
        b bVar;
        b bVar2;
        a a;
        String str = huq.huI;
        String str2 = str + "/mm";
        String str3 = str + "/push";
        try {
            bVar = (b) b.h(new FileInputStream(str2));
        } catch (Exception e) {
            x.e("MicroMsg.ActiveDetector", "%s,read exception:" + e.getMessage(), str2);
            bVar = null;
        }
        try {
            bVar2 = (b) b.h(new FileInputStream(str3));
        } catch (Exception e2) {
            x.e("MicroMsg.ActiveDetector", "%s,read exception:" + e2.getMessage(), str3);
            bVar2 = null;
        }
        List<a> arrayList = new ArrayList();
        if (bVar != null) {
            for (d a2 : bVar.huL) {
                a = a(a2, 0);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            for (com.tencent.mm.aj.c.a a3 : bVar.huN) {
                a = a(a3, 3);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            for (c cVar : bVar.huO) {
                Object obj;
                if (cVar == null) {
                    obj = null;
                } else {
                    a aVar = new a();
                    aVar.pid = cVar.pid;
                    aVar.huu = cVar.huu;
                    aVar.startTime = cVar.huP;
                    aVar.endTime = cVar.huP;
                    aVar.type = 4;
                    aVar.huz = cVar.huz;
                    aVar.huA = cVar.huA;
                    aVar.huB = cVar.huB;
                    a = aVar;
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
        }
        if (bVar2 != null) {
            for (d a22 : bVar2.huL) {
                a = a(a22, 1);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            for (com.tencent.mm.aj.c.a a32 : bVar2.huM) {
                a = a(a32, 2);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    static String bc(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j));
    }

    private static a a(d dVar, int i) {
        if (dVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.huu = dVar.huQ;
        aVar.startTime = dVar.startTime;
        aVar.endTime = dVar.endTime;
        aVar.type = i;
        aVar.pid = dVar.pid;
        aVar.huw = dVar.huw;
        if (i != 1) {
            return aVar;
        }
        aVar.huv = dVar.huv;
        aVar.hux = dVar.hux;
        return aVar;
    }

    private static a a(com.tencent.mm.aj.c.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.huu = aVar.huu;
        aVar2.startTime = aVar.time;
        aVar2.endTime = aVar.time;
        aVar2.type = i;
        aVar2.huy = aVar.type;
        return aVar2;
    }
}
