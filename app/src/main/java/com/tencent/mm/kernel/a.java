package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mm.a.g;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.v;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.g.a.bx;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ao;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.as;
import com.tencent.mm.z.by;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    private static boolean gPh = true;
    private static boolean gPi = false;
    static b gPk = new b();
    private static String gPl = "NoResetUinStack";
    private static String gPm = null;
    private static int gPv = -1;
    private Map<String, Integer> gPA = new HashMap();
    private c gPf;
    private v gPg;
    byte[] gPj = new byte[0];
    public com.tencent.mm.z.a gPn;
    public e.c gPo;
    public int gPp;
    public boolean gPq = false;
    private boolean gPr = false;
    public int gPs = 0;
    public int gPt;
    public List<ao> gPu = new LinkedList();
    long gPw;
    private volatile int gPx = a.gPC;
    public volatile boolean gPy = false;
    private String gPz = "";

    private enum a {
        ;

        static {
            gPC = 1;
            gPD = 2;
            gPE = new int[]{gPC, gPD};
        }
    }

    static final class b {
        private static boolean gPH = true;
        private boolean gPF = false;
        private s gPG;
        private int uin = 0;

        b() {
        }

        private synchronized int Cg() {
            if (!this.gPF) {
                CD();
                this.gPF = true;
            }
            return this.uin;
        }

        public final synchronized void a(s sVar) {
            this.gPG = sVar;
        }

        private synchronized void eE(int i) {
            x.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", o.getString(this.uin), o.getString(i), Integer.valueOf(h.aJ(i, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bh.cgy());
            Assert.assertNotNull(this.gPG);
            a(this.gPG, i);
            this.uin = i;
        }

        private synchronized void CD() {
            int i = 0;
            synchronized (this) {
                Assert.assertNotNull(this.gPG);
                s sVar = this.gPG;
                if (sVar == null) {
                    x.w("MMKernel.CoreAccount", "summer read detault uin exception sysCfg is null!");
                } else {
                    Integer num = (Integer) sVar.get(1);
                    if (num == null) {
                        if (sVar.xmA) {
                            d.pPH.a(148, 40, 1, false);
                        }
                        Integer valueOf = Integer.valueOf(ac.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0));
                        if (valueOf != null) {
                            x.i("MMKernel.CoreAccount", "summer read detault uin[%d], bakUin[%d] sysCfg.isOpenException[%b]", num, valueOf, Boolean.valueOf(sVar.xmA));
                            if (gPH) {
                                x.w("MMKernel.CoreAccount", "summer read detault uin exception backup uin[%d], stack[%s]", valueOf, bh.cgy());
                                d.pPH.h(11911, Integer.valueOf(bh.e(valueOf)));
                                gPH = false;
                            }
                            a(sVar, valueOf.intValue());
                            num = valueOf;
                        }
                    }
                    x.i("MMKernel.CoreAccount", "summer getDefaultUin uin[%d]", Integer.valueOf(bh.e(num)));
                    i = bh.e(num);
                }
                this.uin = i;
            }
        }

        private static void a(s sVar, int i) {
            x.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", Integer.valueOf(i), bh.cgy());
            ac.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("default_uin", i).commit();
            sVar.set(1, Integer.valueOf(i));
        }
    }

    public a(c cVar) {
        Assert.assertNotNull(gPk);
        g.Dk();
        gPh = bh.e((Integer) g.Dj().gQd.get(17)) != 0;
        com.tencent.mm.protocal.i.c.a.vAV = new as(702);
        this.gPf = cVar;
    }

    public static int Cg() {
        return gPk.Cg();
    }

    public static String Ch() {
        return new o(gPk.Cg()).toString();
    }

    public static String Ci() {
        return gPm;
    }

    public static String fF(String str) {
        gPm = str;
        return str;
    }

    public static String Cj() {
        return gPl;
    }

    public static void fG(String str) {
        gPl = str;
    }

    static boolean gz(int i) {
        return i != 0;
    }

    protected static void Ck() {
        gPk.eE(0);
    }

    protected static void Cl() {
        gPk.eE(0);
    }

    private void Cm() {
        this.gPx = a.gPC;
        this.gPy = false;
        x.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putBoolean("isLogin", false).commit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        x.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", Integer.valueOf(gPk.Cg()), gPl, simpleDateFormat.format(new Date()));
    }

    final void Cn() {
        x.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", o.getString(gPk.Cg()), Thread.currentThread().getName(), bh.cgy());
        if (Cy()) {
            this.gPf.onAccountRelease();
            g.Dk();
            g.Dj().eb(null);
            Cm();
            g.Dk();
            g.Dj().gQr.clear();
            return;
        }
        x.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", bh.cgy().toString(), gPl);
    }

    final void bv(boolean z) {
        int cfD;
        if (!z) {
            boolean z2 = HardCoderJNI.hcBootEnable;
            int i = HardCoderJNI.hcBootDelay;
            int i2 = HardCoderJNI.hcBootCPU;
            int i3 = HardCoderJNI.hcBootIO;
            if (HardCoderJNI.hcBootThr) {
                cfD = g.Dm().cfD();
            } else {
                cfD = 0;
            }
            this.gPp = HardCoderJNI.startPerformance(z2, i, i2, i3, cfD, HardCoderJNI.hcBootTimeout, 101, HardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
            x.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", Integer.valueOf(this.gPp), bh.cgy());
        }
        x.i("MMKernel.CoreAccount", "UserStatusChange: clear");
        synchronized (this.gPu) {
            this.gPu.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int a = gPk.Cg();
        x.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", o.getString(a), Integer.valueOf(h.aJ(a, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bh.cgy());
        if ((a != 0 ? 1 : null) == null) {
            x.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
        } else {
            boolean z3;
            long currentTimeMillis2;
            o.getString(a);
            g.Dk();
            e Dj = g.Dj();
            Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ a gPB;

                {
                    this.gPB = r1;
                }

                public final void run() {
                    this.gPB.gPx = a.gPD;
                }
            };
            ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putBoolean("isLogin", true).commit();
            String s = g.s(("mm" + a).getBytes());
            Dj.gQi = Dj.gQh + s + "/";
            Dj.cachePath = w.gZK + s + "/";
            File file = new File(Dj.cachePath);
            x.i("MMKernel.CoreStorage", "dkacc cachePath:" + Dj.cachePath + " accPath:" + Dj.gQi);
            if (file.exists()) {
                z3 = false;
            } else {
                x.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", o.getString(a), Dj.cachePath, Dj.gQi);
                file.mkdirs();
                if (!Dj.cachePath.equalsIgnoreCase(Dj.gQi)) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    new File(Dj.gQi).renameTo(new File(e.bnF + (s + "temp" + System.currentTimeMillis())));
                    x.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - currentTimeMillis2), s);
                }
                z3 = true;
            }
            Dj.gQq = new by(Dj.cachePath, z3);
            Dj.CP();
            s = Dj.cachePath + "MicroMsg.db";
            String str = Dj.cachePath + "EnMicroMsg.db";
            String str2 = Dj.cachePath + "EnMicroMsg2.db";
            Dj.eb(null);
            Dj.fK(str);
            Dj.gQj = new com.tencent.mm.by.h(new com.tencent.mm.by.h.a(Dj) {
                final /* synthetic */ e gQy;

                {
                    this.gQy = r1;
                }

                public final void Db() {
                    if (this.gQy.gQl != null) {
                        x.i("MMKernel.CoreStorage", "summer preCloseCallback userConfigStg: " + this.gQy.gQl);
                        this.gQy.gQl.lH(true);
                    }
                    this.gQy.gQf.Db();
                }

                public final void Dc() {
                    this.gQy.gQf.Dc();
                }

                public final void Dd() {
                    this.gQy.gQf.Dd();
                }
            });
            if (Dj.gQj.a(s, str, str2, (long) a, q.yE(), e.Bn(), true)) {
                String str3 = Dj.gQj.xBq;
                if (!bh.ov(str3)) {
                    x.e("MMKernel.CoreStorage", "dbinit failed :" + str3);
                    com.tencent.mm.sdk.a.b.z("init db Failed: [ " + str3 + "]", "DBinit");
                }
                com.tencent.mm.by.h hVar = Dj.gQj;
                if (hVar.xBn != null ? hVar.xBn.xAP : false) {
                    Dj.gQp = true;
                }
                Dj.gQl = new t(Dj.gQj);
                Dj.gQn = new bi(Dj.gQj);
                Dj.gQj.xBp = new com.tencent.mm.by.h.e(Dj) {
                    final /* synthetic */ e gQy;

                    {
                        this.gQy = r1;
                    }

                    public final void De() {
                        if (this.gQy.gQn != null) {
                            this.gQy.gQn.hhp.fx("TablesVersion", "delete * from TablesVersion");
                        } else {
                            x.e("MMKernel.CoreStorage", "tablesVersionStorage is null");
                        }
                    }
                };
                Dj.gQo = Dj.gQn.cjX();
                Dj.gQk = new com.tencent.mm.by.h(Dj.gQg);
                if (Dj.gQk.a(s, str, str2, (long) a, q.yE(), new HashMap(), true)) {
                    Dj.gQm = new be(Dj.gQl);
                    Dj.gQm.c(new com.tencent.mm.sdk.e.j.a(Dj) {
                        final /* synthetic */ e gQy;

                        {
                            this.gQy = r1;
                        }

                        public final void a(String str, l lVar) {
                            q.eI(str);
                        }
                    });
                    Dj.gQm.cjT();
                    anonymousClass1.run();
                    if (z3) {
                        currentTimeMillis2 = ((Long) Dj.gQl.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                        int intValue = ((Integer) Dj.gQl.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                        if (currentTimeMillis2 > 0) {
                            x.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", Long.valueOf(currentTimeMillis2));
                        } else {
                            Dj.gQl.a(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                        }
                        if (intValue > 0) {
                            x.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", Integer.valueOf(intValue));
                        } else {
                            Dj.gQl.a(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(com.tencent.mm.protocal.d.vAz));
                        }
                        x.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", (Long) Dj.gQl.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0)), (Integer) Dj.gQl.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0)), Integer.valueOf(com.tencent.mm.protocal.d.vAz));
                    }
                    if (!z) {
                        Object obj;
                        g.Dk();
                        x.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", bh.ou((String) g.Dj().CU().get(2, null)));
                        if (bh.ou((String) g.Dj().CU().get(2, null)).length() <= 0) {
                            x.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + gPk.Cg());
                            Cm();
                            gPk.eE(0);
                            gPl = bh.cgy().toString();
                            ag.y(new Runnable(this) {
                                final /* synthetic */ a gPB;

                                {
                                    this.gPB = r1;
                                }

                                public final void run() {
                                    g.Dk().releaseAll();
                                }
                            });
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            d.pPH.a(598, 21, 1, true);
                            x.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
                        }
                    }
                    com.tencent.mm.sdk.b.a.xef.m(new bx());
                    g.Dk();
                    e Dj2 = g.Dj();
                    e.c cVar = new e.c();
                    cfD = bh.e((Integer) Dj2.gQl.get(14, null));
                    int i4 = com.tencent.mm.protocal.d.vAz;
                    boolean z4 = i4 == cfD ? false : (i4 <= 570425344 || cfD > 570425344) ? i4 > 570556456 && cfD <= 570556456 : true;
                    if (z4) {
                        Dj2.gQl.set(8197, "");
                        Dj2.gQl.set(15, Integer.valueOf(0));
                    }
                    z2 = cfD != i4;
                    if (cfD > 620822536 || cfD == i4) {
                        Dj2.gQl.set(274480, Boolean.valueOf(false));
                        x.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
                    } else {
                        Dj2.gQl.set(274480, Boolean.valueOf(true));
                        x.i("MMKernel.CoreStorage", "[initialize] need init emoji");
                    }
                    if (cfD != 0 && cfD < 637599744) {
                        Dj2.gQl.set(348162, Boolean.valueOf(true));
                    }
                    if ((cfD != i4 ? 1 : null) != null) {
                        x.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(cfD) + " to " + Integer.toHexString(i4) + ", init=" + z4);
                        if (((Integer) Dj2.gQd.get(37, Integer.valueOf(0))).intValue() == 0) {
                            Dj2.gQd.set(37, Integer.valueOf(cfD));
                        }
                        Dj2.gQl.set(30, Boolean.valueOf(false));
                        Dj2.gQl.set(-2046825377, Boolean.valueOf(false));
                        Dj2.gQl.set(-2046825369, Boolean.valueOf(false));
                        Dj2.gQl.set(54, Boolean.valueOf(false));
                        Dj2.gQl.set(-2046825368, Boolean.valueOf(false));
                        Dj2.gQl.set(-2046825366, Boolean.valueOf(true));
                        Dj2.gQl.set(62, Boolean.valueOf(true));
                        ac.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
                        if ((cfD & -256) == (i4 & -256)) {
                            ae.Vc("show_whatsnew");
                        }
                    }
                    cVar.gQA = z2;
                    cVar.gQB = cfD;
                    this.gPo = cVar;
                    x.i("MMKernel.CoreAccount", "check is update :%b ", Boolean.valueOf(cVar.gQA));
                    this.gPr = true;
                    if (!this.gPq) {
                        Co();
                        g.Dh().Cz();
                    }
                    aq.hfP.S("last_login_uin", o.getString(a));
                    d.pPH.eE(a);
                    s = "MMKernel.CoreAccount";
                    str = "SmcLogic.setUin, class loader %s, %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(getClass().getClassLoader() == null ? -1 : getClass().getClassLoader().hashCode());
                    objArr[1] = Integer.valueOf(Thread.currentThread().getContextClassLoader() == null ? -1 : Thread.currentThread().getContextClassLoader().hashCode());
                    x.i(s, str, objArr);
                    this.gPn = new com.tencent.mm.z.a();
                    x.i("MMKernel.CoreAccount", "setAccUin done :%s", o.getString(a));
                    g.Dk();
                    if (g.Di().gPJ != null) {
                        g.Dk();
                        if (g.Di().gPJ.hmV != null) {
                            g.Dk();
                            g.Di().gPJ.hmV.bF(true);
                            g.Dk();
                            com.tencent.mm.network.c Kx = g.Di().gPJ.hmV.Kx();
                            if (!(a == 0 || Kx == null || a == Kx.Cg())) {
                                x.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", Integer.valueOf(Kx.Cg()), Integer.valueOf(a));
                                d.pPH.a(148, 46, 1, false);
                                Kx.eE(a);
                            }
                        }
                    }
                } else {
                    throw new com.tencent.mm.z.b((byte) 0);
                }
            }
            throw new SQLiteException("main db init failed");
        }
        x.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        x.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
    }

    public final void Co() {
        if (this.gPr) {
            this.gPr = false;
            x.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", Long.valueOf(Thread.currentThread().getId()), bh.cgy());
            long currentTimeMillis = System.currentTimeMillis();
            this.gPf.onAccountInitialized(this.gPo);
            x.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Cp();
            return;
        }
        x.i("MMKernel.CoreAccount", "no need do account initialized notify.");
    }

    public final void Cp() {
        if (Cy() && com.tencent.mm.kernel.a.c.Dt().gRt) {
            x.i("MMKernel.CoreAccount", "Flush client version.");
            g.Dj().gQl.set(14, Integer.valueOf(com.tencent.mm.protocal.d.vAz));
        }
    }

    public final synchronized v Cq() {
        if (this.gPg == null) {
            this.gPg = new v();
        }
        return this.gPg;
    }

    public static boolean Cr() {
        return gPi;
    }

    public static void bw(boolean z) {
        gPi = z;
    }

    public static boolean Cs() {
        if (gPh) {
            String string;
            String str = "MMKernel.CoreAccount";
            String str2 = "account holded :%s init:%b";
            Object[] objArr = new Object[2];
            g.Dk();
            if (g.Dh() != null) {
                g.Dk();
                g.Dh();
                string = o.getString(gPk.Cg());
            } else {
                string = "-1";
            }
            objArr[0] = string;
            objArr[1] = Boolean.valueOf(g.Dh().Cy());
            x.w(str, str2, objArr);
        }
        return gPh;
    }

    public static void hold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " HOLD ACCOUNT! uin:%s stack:%s init:%b";
        Object[] objArr = new Object[3];
        g.Dk();
        if (g.Dh() != null) {
            g.Dk();
            g.Dh();
            string = o.getString(gPk.Cg());
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = bh.cgy();
        objArr[2] = Boolean.valueOf(g.Dh().Cy());
        x.w(str, str2, objArr);
        gPh = true;
        g.Dk();
        g.Dj().gQd.set(17, Integer.valueOf(1));
    }

    public static void unhold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " UN HOLD ACCOUNT! uin:%s init:%b";
        Object[] objArr = new Object[2];
        g.Dk();
        if (g.Dh() != null) {
            g.Dk();
            g.Dh();
            string = o.getString(gPk.Cg());
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = Boolean.valueOf(g.Dh().Cy());
        x.w(str, str2, objArr);
        gPh = false;
        g.Dk();
        g.Dj().gQd.set(17, Integer.valueOf(0));
    }

    public final void Ct() {
        if (!Cy()) {
            throw new com.tencent.mm.z.b();
        }
    }

    public final void Cu() {
        new af(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ a gPB;

            {
                this.gPB = r1;
            }

            public final void run() {
                ao[] aoVarArr = new ao[this.gPB.gPu.size()];
                this.gPB.gPu.toArray(aoVarArr);
                for (ao GX : aoVarArr) {
                    GX.GX();
                }
            }
        });
    }

    public final void aT(int i, int i2) {
        int i3 = (this.gPs == i && this.gPt == i2) ? 0 : 1;
        x.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.gPt), Integer.valueOf(this.gPs));
        if (i3 != 0) {
            this.gPs = i;
            this.gPt = i2;
            new af(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ a gPB;

                {
                    this.gPB = r1;
                }

                public final void run() {
                    this.gPB.Cu();
                }
            });
        }
    }

    public static void gA(int i) {
        if (gPv == -1 || gPv != i) {
            gPv = i;
            Cw().edit().putInt("notification.user.state", i).commit();
            x.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", Integer.valueOf(i));
        }
    }

    public static int Cv() {
        return Cw().getInt("notification.user.state", 0);
    }

    public static SharedPreferences Cw() {
        return ac.getContext().getSharedPreferences("notify_key_pref_settings", 4);
    }

    public static boolean gB(int i) {
        return (i & 1) != 0;
    }

    public final void release() {
        synchronized (this.gPj) {
            Cn();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize() {
        if (!Cy()) {
            synchronized (this.gPj) {
                if (Cy()) {
                    return;
                }
                if (gPk.Cg() != 0) {
                    this.gPw = SystemClock.elapsedRealtime();
                    x.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", Integer.valueOf(r0), bh.cgy());
                    bv(false);
                }
            }
        }
    }

    public static boolean Cx() {
        return gPk.Cg() != 0;
    }

    public final boolean Cy() {
        return this.gPx == a.gPD;
    }

    public final void Cz() {
        x.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", Boolean.valueOf(this.gPy), bh.cgy());
        this.gPy = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        x.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", Long.valueOf(this.gPw), Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime - this.gPw), bh.cgy());
        com.tencent.mm.sdk.b.a.xef.m(new bw());
    }

    public static int CA() {
        return Integer.valueOf(ac.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0)).intValue();
    }

    public static String CB() {
        g.Dk();
        if (bh.ov(g.Dh().gPz)) {
            CC();
        }
        g.Dk();
        return g.Dh().gPz;
    }

    public static void CC() {
        g.Dk();
        g.Dh().gPz = q.yF() + "_" + System.currentTimeMillis();
        g.Dk();
        g.Dh().gPA.clear();
    }

    public static int fH(String str) {
        int i;
        g.Dk();
        if (g.Dh().gPA.get(str) == null) {
            i = 0;
        } else {
            g.Dk();
            i = ((Integer) g.Dh().gPA.get(str)).intValue();
        }
        int Wo = (int) bh.Wo();
        if (i == 0) {
            g.Dk();
            g.Dh().gPA.put(str, Integer.valueOf(Wo));
            return i;
        }
        i = Wo - i;
        g.Dk();
        g.Dh().gPA.put(str, Integer.valueOf(Wo));
        return i < 0 ? 0 : i;
    }
}
