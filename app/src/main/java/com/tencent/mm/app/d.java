package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.ae.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.i;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.z.bv;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.Assert;

public final class d implements ServiceConnection {
    private static boolean feM = false;
    private static Object lock = new Object();
    private ReentrantLock feN = new ReentrantLock();
    private boolean feO = false;
    private IBinder feP = null;
    private Runnable feQ = new 5(this);

    static /* synthetic */ void a(d dVar) {
        try {
            dVar.feN.lock();
            dVar.feO = false;
            dVar.feP = null;
            g.Dh();
            if (!a.Cx() || a.Cs()) {
                g.Dk();
                g.Di().gPJ.Kp();
                g.Dk();
                g.Di().gPJ.reset();
                return;
            }
            g.Dk();
            g.Di().gPJ.Ko();
            dVar.am(ac.getContext());
        } finally {
            dVar.feN.unlock();
        }
    }

    static /* synthetic */ void a(d dVar, IBinder iBinder) {
        com.tencent.mm.blink.a.ec("onServiceConnected");
        synchronized (lock) {
            x.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
            ag.K(dVar.feQ);
            feM = false;
        }
        if (iBinder == null) {
            Assert.assertTrue("WorkerProfile onServiceConnected binder == null", false);
            b.z("WorkerProfile onServiceConnected binder == null", "it will result in accInfo being null");
        }
        try {
            dVar.feN.lock();
            dVar.feO = false;
            dVar.feP = iBinder;
            e pVar = new p(f.a.B(iBinder));
            try {
                pVar.hnm.a(new 2(dVar));
            } catch (Throwable e) {
                x.e("MicroMsg.RDispatcher", "exception:%s", bh.i(e));
            }
            try {
                pVar.hnm.a(new 3(dVar));
            } catch (Throwable e2) {
                x.e("MicroMsg.RDispatcher", "exception:%s", bh.i(e2));
            }
            g.Dk();
            com.tencent.mm.kernel.b Di = g.Di();
            x.w("MMKernel.CoreNetwork", "setting up remote dispatcher " + pVar);
            Di.gPI.b(pVar);
            pVar.a(new h.a(Di) {
                final /* synthetic */ b gPN;

                {
                    this.gPN = r1;
                }

                public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
                    x.i("MMKernel.CoreNetwork", "callback, kv:%s", str);
                    b.a(i, i2, z, str);
                }
            });
            try {
                i Ky = pVar.Ky();
                if (Ky != null) {
                    Ky.c(Di.gPL);
                }
            } catch (Throwable e22) {
                x.e("MMKernel.CoreNetwork", "exception:%s", bh.i(e22));
            }
            pVar.a(new ab.a(Di) {
                final /* synthetic */ b gPN;
                private byte[] gPQ;

                {
                    this.gPN = r1;
                }

                public final byte[] CI() {
                    if (!g.Dh().Cy()) {
                        return null;
                    }
                    com.tencent.mm.protocal.aa.a aVar = new com.tencent.mm.protocal.aa.a();
                    g.Dk();
                    g.Dh();
                    aVar.uin = a.Cg();
                    g.Dk();
                    aVar.hFw = bh.VD((String) g.Dj().CU().get(8195, null));
                    aVar.netType = com.tencent.mm.protocal.a.getNetType(ac.getContext());
                    aVar.vBs = com.tencent.mm.protocal.a.cdq();
                    try {
                        byte[] Hq = aVar.Hq();
                        this.gPQ = aVar.gPQ;
                        return Hq;
                    } catch (Throwable e) {
                        x.e("MMKernel.CoreNetwork", "exception:%s", bh.i(e));
                        return null;
                    }
                }

                public final int C(byte[] bArr) {
                    int i = 0;
                    com.tencent.mm.protocal.aa.b bVar = new com.tencent.mm.protocal.aa.b();
                    try {
                        bVar.E(bArr);
                        return (int) bVar.vBW;
                    } catch (Throwable e) {
                        x.e("MMKernel.CoreNetwork", "exception:%s", bh.i(e));
                        return i;
                    }
                }

                public final byte[] CJ() {
                    return this.gPQ;
                }
            });
            c Kx = pVar.Kx();
            if (Kx == null) {
                x.f("MMKernel.CoreNetwork", "accInfo is null, it would assert before!!!");
                Di.gPJ.reset();
                Di.gPJ.Kp();
            } else {
                String str;
                b.a(new com.tencent.mm.sdk.a.a(Di) {
                    final /* synthetic */ b gPN;

                    {
                        this.gPN = r1;
                    }

                    public final void fI(String str) {
                        x.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", str);
                        g.Dk();
                        if (g.Dl() != null) {
                            g.Dk();
                            bv Dl = g.Dl();
                            Dl.bgH = true;
                            for (com.tencent.mm.z.bv.a aVar : Dl.hhW) {
                                if (aVar != null) {
                                    aVar.If();
                                }
                            }
                            Dl.bgH = false;
                        }
                        g.Dk();
                        if (g.Dj() != null) {
                            g.Dk();
                            g.Dj().eb(str);
                        }
                    }
                });
                g.Dk();
                s sVar = g.Dj().gQd;
                Assert.assertTrue("setAutoAuth, getSysCfg() is null, stack = " + bh.cgy(), sVar != null);
                int Dl = sVar.Dl(47);
                String str2 = (String) sVar.get(2);
                String str3 = (String) sVar.get(3);
                String str4 = (String) sVar.get(25);
                String str5 = (String) sVar.get(24);
                n.a fl = n.fl((String) sVar.get(6), (String) sVar.get(7));
                x.d("MMKernel.CoreNetwork", "dkidc host[s:%s l:%s] builtin[s:%s l:%s] ports[%s] timeout[%s] mmtls[%d]", str5, str4, str2, str3, str, r6, Integer.valueOf(Dl));
                Assert.assertTrue("setAutoAuth, autoAuth is null, stack = " + bh.cgy(), true);
                pVar.a(false, str2, str3, fl.vBw, fl.vBx, fl.vBy, fl.vBz, str5, str4);
                pVar.bH((Dl & 1) == 0);
                g.Dk();
                g.Dh();
                Assert.assertTrue("setAutoAuth, accInfo is null, stack = " + bh.cgy(), Kx != null);
                if (g.Dh().Cy() && g.Dh().gPy) {
                    Di.gPJ.d(pVar);
                    com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a(Di) {
                        final /* synthetic */ b gPN;

                        {
                            this.gPN = r1;
                        }

                        public final e CK() {
                            try {
                                return this.gPN.gPJ.hmV;
                            } catch (Throwable th) {
                                x.e("MMKernel.CoreNetwork", "%s", bh.i(th));
                                return null;
                            }
                        }
                    });
                    x.i("MMKernel.CoreNetwork", "setAutoAuth differrent accStg uin[%d], accInfo uin[%d], acc init[%b]", Integer.valueOf(a.Cg()), Integer.valueOf(Kx.Cg()), Boolean.valueOf(g.Dh().Cy()));
                    if (a.Cg() != Kx.Cg()) {
                        x.w("MMKernel.CoreNetwork", "update acc info with acc stg: uin =" + Kx.Cg());
                        str = "setAutoAuth, getConfigStg() is null, stack = " + bh.cgy();
                        g.Dk();
                        Assert.assertTrue(str, g.Dj().CU() != null);
                        g.Dk();
                        String str6 = (String) g.Dj().CU().get(2, null);
                        Kx.v(new byte[0], a.Cg());
                        Kx.setUsername(str6);
                    }
                } else {
                    x.w("MMKernel.CoreNetwork", "need to clear acc info and maybe stop networking accHasReady():%b isInitializedNotifyAllDone:%b", Boolean.valueOf(g.Dh().Cy()), Boolean.valueOf(g.Dh().gPy));
                    com.tencent.mm.plugin.report.d.pPH.a(148, g.Dh().Cy() ? 44 : 43, 1, false);
                    Kx.reset();
                    pVar.reset();
                    Di.gPJ.d(pVar);
                    com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a(Di) {
                        final /* synthetic */ b gPN;

                        {
                            this.gPN = r1;
                        }

                        public final e CK() {
                            try {
                                return this.gPN.gPJ.hmV;
                            } catch (Throwable th) {
                                x.e("MMKernel.CoreNetwork", "%s", bh.i(th));
                                return null;
                            }
                        }
                    });
                    if (a.Cg() != Kx.Cg()) {
                        com.tencent.mm.plugin.report.d.pPH.a(148, 45, 1, false);
                        x.w("MMKernel.CoreNetwork", "summerauth update acc info with acc stg: old acc uin=%d, acc stg uin=%d, acc init %b %b", Integer.valueOf(Kx.Cg()), Integer.valueOf(a.Cg()), Boolean.valueOf(g.Dh().Cy()), Boolean.valueOf(g.Dh().gPy));
                        Kx.eE(a.Cg());
                    } else {
                        x.i("MMKernel.CoreNetwork", "acc info uin same with acc stg", Integer.valueOf(Kx.Cg()), Integer.valueOf(a.Cg()));
                    }
                }
            }
            if (com.tencent.mm.z.a.EP()) {
                try {
                    g.Dk();
                    if (g.Dh().gPn != null) {
                        g.Dk();
                        if (g.Di().gPJ.hmV != null) {
                            g.Dk();
                            com.tencent.mm.z.a aVar = g.Dh().gPn;
                            g.Dk();
                            c Kx2 = g.Di().gPJ.hmV.Kx();
                            long Wp = bh.Wp();
                            if (Kx2 == null) {
                                x.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  accinfo == null");
                                com.tencent.mm.plugin.report.d.pPH.a(226, 6, 1, false);
                            } else {
                                x.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush islogin:%b cache:%s", Boolean.valueOf(Kx2.Kt()), Integer.valueOf(aVar.EO()));
                                if (Kx2.Kt()) {
                                    if (aVar.EO() > 0) {
                                        com.tencent.mm.plugin.report.d.pPH.a(226, 7, 1, false);
                                        x.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  something Error! islogin && isCacheValid . Clean Cache Now !");
                                        aVar.hev = null;
                                    } else {
                                        x.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush Here, DANGER! . HERE means worker just init , try set from push now!");
                                        com.tencent.mm.plugin.report.d.pPH.a(226, 8, 1, false);
                                    }
                                    aVar.hev = Kx2.Kw();
                                    com.tencent.mm.plugin.report.d.pPH.a(226, aVar.EO() > 0 ? 9 : 10, 1, false);
                                } else if (aVar.EO() <= 0) {
                                    com.tencent.mm.plugin.report.d.pPH.a(226, 11, 1, false);
                                    x.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", aVar.toString());
                                } else {
                                    int G = Kx2.G(aVar.hev);
                                    x.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s time:%s  cache:%s", Integer.valueOf(G), Long.valueOf(bh.bz(Wp)), Integer.valueOf(aVar.EO()));
                                    if (G != 0) {
                                        x.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", Integer.valueOf(G));
                                        aVar.hev = null;
                                    } else {
                                        aVar.hew = 0;
                                    }
                                    com.tencent.mm.plugin.report.d.pPH.a(226, (long) (G + 20), 1, false);
                                }
                            }
                        }
                    }
                    r4 = new Object[2];
                    g.Dk();
                    r4[0] = g.Dh().gPn;
                    g.Dk();
                    r4[1] = g.Di().gPJ.hmV;
                    x.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", r4);
                } catch (Throwable th) {
                    x.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", bh.i(th));
                }
            }
            if (g.Dh().Cy()) {
                g.Dk();
                if (g.Di().gPJ != null) {
                    g.Dk();
                    if (g.Di().gPJ.hmV != null) {
                        g.Dk();
                        g.Di().gPJ.hmV.bF(true);
                    }
                }
            }
            com.tencent.mm.blink.a.ec("onServiceConnected done");
        } finally {
            dVar.feN.unlock();
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
        com.tencent.mm.blink.b.wo().f(new 1(this, componentName, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
        com.tencent.mm.blink.b.wo().f(new 4(this, componentName));
    }

    public final void am(Context context) {
        boolean z = false;
        com.tencent.mm.blink.a.ec("bindCore");
        try {
            this.feN.lock();
            if (this.feP != null && this.feP.isBinderAlive()) {
                z = true;
            }
            x.i("MicroMsg.CoreServiceConnection", "enter bindCore, isBinding: %b, binderAlive: %b", Boolean.valueOf(this.feO), Boolean.valueOf(z));
            if (this.feO || z) {
                x.w("MicroMsg.CoreServiceConnection", "bindCore reenter, isBinding: %b, binderAlive: %b, return directly.", Boolean.valueOf(this.feO), Boolean.valueOf(z));
                return;
            }
            this.feN.unlock();
            if (com.tencent.mm.booter.b.q(context, "noop")) {
                Intent intent = new Intent(context, CoreService.class);
                x.i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
                if (context.bindService(intent, this, 1)) {
                    try {
                        this.feN.lock();
                        this.feO = true;
                        synchronized (lock) {
                            if (!feM) {
                                feM = true;
                                x.i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                ag.h(this.feQ, 10000);
                            }
                        }
                        return;
                    } finally {
                        this.feN.unlock();
                    }
                } else {
                    x.e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                    return;
                }
            }
            x.i("MicroMsg.CoreServiceConnection", "ensureServiceInstance return false");
        } finally {
            this.feN.unlock();
        }
    }

    private static int co(String str) {
        Throwable th;
        Throwable th2;
        int i = -1;
        BufferedReader bufferedReader = null;
        for (File file : new File("/proc").listFiles()) {
            BufferedReader bufferedReader2;
            try {
                i = bh.getInt(file.getName(), -1);
                try {
                    File file2 = new File(file, "cmdline");
                    if (file2.canRead()) {
                        bufferedReader2 = new BufferedReader(new FileReader(file2));
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null && readLine.startsWith(str)) {
                                if (readLine.length() == str.length()) {
                                    x.i("MicroMsg.CoreServiceConnection", "found process [%s] with pid [%d]", str, Integer.valueOf(i));
                                    try {
                                        bufferedReader2.close();
                                        break;
                                    } catch (Throwable th3) {
                                    }
                                } else {
                                    char charAt = readLine.charAt(str.length());
                                    if (charAt <= ' ' || charAt >= '') {
                                        x.i("MicroMsg.CoreServiceConnection", "found process [%s] with pid [%d]", str, Integer.valueOf(i));
                                        try {
                                            bufferedReader2.close();
                                            break;
                                        } catch (Throwable th4) {
                                        }
                                    }
                                }
                            }
                            try {
                                bufferedReader2.close();
                            } catch (Throwable th5) {
                            }
                            bufferedReader = null;
                        } catch (Throwable th6) {
                            th2 = th6;
                        }
                    } else if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th7) {
                        }
                        bufferedReader = null;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    x.printErrStackTrace("MicroMsg.CoreServiceConnection", th, "read cmdline.", new Object[0]);
                    x.cfk();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        bufferedReader = null;
                    }
                }
            } catch (Throwable th9) {
                x.printErrStackTrace("MicroMsg.CoreServiceConnection", th9, "", new Object[0]);
            }
        }
        return i;
        throw th2;
        if (bufferedReader2 != null) {
            try {
                bufferedReader2.close();
            } catch (Throwable th10) {
            }
        }
        throw th2;
    }
}
