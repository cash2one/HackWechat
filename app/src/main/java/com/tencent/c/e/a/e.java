package com.tencent.c.e.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.c.e.a.a.b;
import com.tencent.c.e.a.a.d;
import com.tencent.c.e.a.a.f;
import com.tencent.c.e.a.a.g;
import com.tencent.c.e.a.a.h;
import com.tencent.c.e.a.a.k;
import com.tencent.c.e.a.b.a;
import com.tencent.c.e.a.b.c;
import com.tencent.c.f.j;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private static final j<e> zTE = new j<e>() {
        protected final /* synthetic */ Object cCT() {
            return new e();
        }
    };
    private boolean Vx;
    private final Handler mHandler;
    private g zTF;
    private final List<k> zTG;
    private d zTH;
    private b zTI;
    private d zTJ;
    private final Runnable zTK;
    private final a zTL;

    static /* synthetic */ boolean a(a aVar, a aVar2) {
        if (aVar2.requestType == 0) {
            com.tencent.c.e.a.b.d cDw = aVar.cDw();
            if (cDw != null && cDw.errorCode == 0) {
                return true;
            }
        }
        c cDx = aVar.cDx();
        if (cDx != null && cDx.errCode == 0) {
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean a(c cVar, a aVar) {
        if (aVar.requestType == 0) {
            if (cVar.a("userIdentify", "reportWup", aVar).errorCode == 0) {
                return true;
            }
        } else if (cVar.b("sensorReport", "sensorInsightReportWup", aVar).errCode == 0) {
            return true;
        }
        return false;
    }

    public static e cDy() {
        return (e) zTE.get();
    }

    private e() {
        this.Vx = false;
        this.zTG = new ArrayList();
        this.zTK = new 2(this);
        this.zTL = new a(this, (byte) 0);
        HandlerThread handlerThread = new HandlerThread("TuringMMCore");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    public final synchronized boolean a(d dVar) {
        boolean z = true;
        synchronized (this) {
            Context context = dVar.context;
            if (context == null) {
                z = false;
            } else {
                h cDF = h.cDF();
                if (!cDF.mInit) {
                    cDF.init(context);
                }
                if (this.Vx) {
                    vo();
                }
                this.zTH = dVar;
                this.Vx = true;
                if (this.zTF == null) {
                    this.zTF = new g(context);
                }
                if (this.zTF != null) {
                    g gVar = this.zTF;
                    synchronized (gVar.zUa) {
                        gVar.zUa.clear();
                    }
                }
                synchronized (this.zTG) {
                    this.zTG.clear();
                }
                this.mHandler.postDelayed(this.zTK, dVar.xfZ);
            }
        }
        return z;
    }

    public final synchronized boolean vo() {
        boolean z = false;
        synchronized (this) {
            if (this.Vx) {
                this.Vx = false;
                if (this.zTH != null) {
                    this.mHandler.removeCallbacks(this.zTK);
                    this.mHandler.removeCallbacks(this.zTL);
                    if (this.zTF != null) {
                        this.zTF.cDB();
                        if (((int) (this.zTF.zUc.cDE() / f.zTV)) >= 3) {
                            final SparseArray cDC = this.zTF.cDC();
                            if (cDC.size() != 0) {
                                final List arrayList;
                                synchronized (this.zTG) {
                                    arrayList = new ArrayList(this.zTG);
                                }
                                if (arrayList.size() >= 3) {
                                    final int i = this.zTH.zTC;
                                    final int i2 = this.zTH.action;
                                    final int i3 = this.zTH.requestType;
                                    this.mHandler.post(new com.tencent.c.e.a.a.c(this) {
                                        final /* synthetic */ e zTM;

                                        public final void cDz() {
                                            Closeable closeable;
                                            Throwable th;
                                            try {
                                                a a;
                                                synchronized (this.zTM) {
                                                    a = b.a(i, i2, this.zTM.zTH.context, i3, cDC, arrayList);
                                                }
                                                h cDF = h.cDF();
                                                int i = i;
                                                int i2 = i2;
                                                byte[] j = com.tencent.c.f.c.j(com.tencent.c.f.b.q(a.toByteArray()), com.tencent.c.f.c.cDI());
                                                if (j != null) {
                                                    File dir = cDF.mContext.getDir("turingmm", 0);
                                                    Object obj = dir == null ? "" : dir.getAbsolutePath() + File.separator + h.fD(i, i2) + "_" + System.currentTimeMillis();
                                                    if (!TextUtils.isEmpty(obj)) {
                                                        Closeable closeable2 = null;
                                                        try {
                                                            Closeable bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(obj));
                                                            try {
                                                                bufferedOutputStream.write(j);
                                                                bufferedOutputStream.flush();
                                                                com.tencent.c.f.f.b(bufferedOutputStream);
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                closeable2 = bufferedOutputStream;
                                                                com.tencent.c.f.f.b(closeable2);
                                                                throw th;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            com.tencent.c.f.f.b(closeable2);
                                                            throw th;
                                                        }
                                                        obj = cDF.fC(i, i2);
                                                        if (TextUtils.isEmpty(obj)) {
                                                            new File(obj).delete();
                                                        }
                                                    }
                                                }
                                                if (this.zTM.zTI == null) {
                                                    this.zTM.zTI;
                                                }
                                            } catch (IllegalArgumentException e) {
                                            }
                                        }

                                        public final void cDA() {
                                            if (this.zTM.zTJ != null) {
                                                this.zTM.zTJ;
                                            }
                                        }
                                    });
                                    z = true;
                                }
                            }
                        }
                    } else {
                        z = true;
                    }
                }
            } else {
                z = true;
            }
        }
        return z;
    }

    public final synchronized void a(Context context, final String str, final com.tencent.c.e.a.a.e eVar) {
        h cDF = h.cDF();
        if (!cDF.mInit) {
            cDF.init(context);
        }
        this.mHandler.post(new com.tencent.c.e.a.a.c(this) {
            final /* synthetic */ e zTM;

            public final void cDz() {
                Map cDG = h.cDF().cDG();
                Map hashMap = new HashMap();
                if (cDG.size() != 0) {
                    h$a c = h.c(cDG, 0);
                    if (c != null) {
                        hashMap.put(c.zUh, c.zUi);
                    }
                    c = h.c(cDG, 1);
                    if (c != null) {
                        hashMap.put(c.zUh, c.zUi);
                    }
                    h$a c2 = h.c(cDG, 2);
                    if (c2 != null) {
                        hashMap.put(c2.zUh, c2.zUi);
                    }
                }
                if (hashMap.size() == 0) {
                    eVar.Yn();
                    return;
                }
                for (a aVar : hashMap.keySet()) {
                    aVar.zUp = System.currentTimeMillis();
                    aVar.zUq = str;
                    boolean a = eVar instanceof a ? e.a((a) eVar, aVar) : eVar instanceof c ? e.a((c) eVar, aVar) : false;
                    if (a) {
                        for (String file : (List) hashMap.get(aVar)) {
                            try {
                                new File(file).delete();
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
            }

            public final void cDA() {
                if (this.zTM.zTJ != null) {
                    this.zTM.zTJ;
                }
            }
        });
    }
}
