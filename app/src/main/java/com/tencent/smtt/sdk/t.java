package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.b;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.s;
import com.tencent.smtt.utils.u;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class t {
    private static t zXH = null;
    private static final Lock zXM = new ReentrantLock();
    private static final Lock zXN = new ReentrantLock();
    private static FileLock zXP = null;
    public static ThreadLocal<Integer> zXQ = new ThreadLocal<Integer>() {
        public final /* synthetic */ Object initialValue() {
            return Integer.valueOf(0);
        }
    };
    private static Handler zXR = null;
    private static final Long[][] zXS;
    static boolean zXT = false;
    private static boolean zXU = false;
    private int zXI = 0;
    private FileLock zXJ;
    private FileOutputStream zXK;
    private boolean zXL = false;
    private boolean zXO = false;

    static {
        r0 = new Long[7][];
        r0[0] = new Long[]{Long.valueOf(25413), Long.valueOf(11460320)};
        r0[1] = new Long[]{Long.valueOf(25436), Long.valueOf(12009376)};
        r0[2] = new Long[]{Long.valueOf(25437), Long.valueOf(11489180)};
        r0[3] = new Long[]{Long.valueOf(25438), Long.valueOf(11489180)};
        r0[4] = new Long[]{Long.valueOf(25439), Long.valueOf(12013472)};
        r0[5] = new Long[]{Long.valueOf(25440), Long.valueOf(11489180)};
        r0[6] = new Long[]{Long.valueOf(25442), Long.valueOf(11489180)};
        zXS = r0;
    }

    private t() {
        if (zXR == null) {
            zXR = new Handler(this, r.cEE().getLooper()) {
                final /* synthetic */ t zXV;

                public final void handleMessage(Message message) {
                    QbSdk.setTBSInstallingStatus(true);
                    Object[] objArr;
                    switch (message.what) {
                        case 1:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                            objArr = (Object[]) message.obj;
                            this.zXV.t((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                            break;
                        case 2:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                            objArr = (Object[]) message.obj;
                            t.a(this.zXV, (Context) objArr[0], (Context) objArr[1], ((Integer) objArr[2]).intValue());
                            break;
                        case 3:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                            objArr = (Object[]) message.obj;
                            this.zXV.f((Context) objArr[0], (Bundle) objArr[1]);
                            break;
                    }
                    QbSdk.setTBSInstallingStatus(false);
                    super.handleMessage(message);
                }
            };
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(t tVar, Context context, Context context2, int i) {
        Properties properties;
        BufferedInputStream bufferedInputStream;
        Properties properties2;
        File[] listFiles;
        String Q;
        Editor edit;
        Throwable th;
        boolean z = true;
        o.gG(context).HV(-524);
        if (!tVar.gO(context2)) {
            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is " + i);
            if ((VERSION.SDK_INT >= 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
                TbsLog.e("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
                o.gG(context).HV(-525);
            } else if (tVar.hm(context2)) {
                boolean tryLock = zXN.tryLock();
                TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread #1 locked is " + tryLock);
                if (tryLock) {
                    zXM.lock();
                    try {
                        int abg = n.gF(context2).abg("copy_core_ver");
                        int abf = n.gF(context2).abf("copy_status");
                        if (abg == i) {
                            QbSdk.zWf.lz(220);
                            o.gG(context).HV(-528);
                            zXM.unlock();
                            zXN.unlock();
                        } else {
                            int gY = tVar.gY(context2);
                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=" + gY);
                            if (gY == i) {
                                QbSdk.zWf.lz(220);
                                o.gG(context).HV(-528);
                                TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have same version is " + gY);
                                zXM.unlock();
                                zXN.unlock();
                            } else {
                                int abg2 = n.gF(context2).abg("install_core_ver");
                                if ((abg2 > 0 && i > abg2) || (abg > 0 && i > abg)) {
                                    he(context2);
                                }
                                if (abf == 3 && gY > 0 && (i > gY || i == 88888888)) {
                                    abf = -1;
                                    he(context2);
                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- update TBS.....", true);
                                }
                                if (f.hS(context2)) {
                                    if (abf > 0) {
                                        if (x.hq(context2) || o.gG(context2).zXm.getInt("tbs_downloaddecouplecore", 0) != 1 || i == gX(context2)) {
                                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have copied is " + gX(context2));
                                            zXM.unlock();
                                            zXN.unlock();
                                        }
                                    }
                                    if (abf == 0) {
                                        abf = n.gF(context2).abg("copy_retry_num");
                                        if (abf > 10) {
                                            v.hn(context2).bc(h.CTRL_INDEX, "exceed copy retry num!");
                                            o.gG(context).HV(-530);
                                            zXM.unlock();
                                            zXN.unlock();
                                        } else {
                                            n.gF(context2).dH("copy_retry_num", abf + 1);
                                        }
                                    }
                                    File hg = hg(context);
                                    File hf = !x.hq(context2) ? o.gG(context2).zXm.getInt("tbs_downloaddecouplecore", 0) == 1 ? hf(context2) : hl(context2) : hl(context2);
                                    if (hg == null || hf == null) {
                                        if (hg == null) {
                                            v.hn(context2).bc(c.CTRL_INDEX, "src-dir is null when copying tbs core!");
                                            o.gG(context).HV(-535);
                                        }
                                        if (hf == null) {
                                            v.hn(context2).bc(JsApiCheckIsSupportFaceDetect.CTRL_INDEX, "dst-dir is null when copying tbs core!");
                                            o.gG(context).HV(-536);
                                        }
                                    } else {
                                        n.gF(context2).fE(i, 0);
                                        s sVar = new s();
                                        sVar.Abr = new s$b(sVar, hg);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        o.gG(context).HV(-551);
                                        boolean j = f.j(hg, hf);
                                        if (o.gG(context2).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
                                            x.hp(context2);
                                        }
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread time=" + (System.currentTimeMillis() - currentTimeMillis));
                                        if (j) {
                                            sVar.Abs = new s$b(sVar, hg);
                                            tryLock = (sVar.Abs == null || sVar.Abr == null) ? false : sVar.Abs.iFr.size() == sVar.Abr.iFr.size() && s.a(sVar.Abr, sVar.Abs);
                                            if (tryLock) {
                                                String property;
                                                BufferedInputStream bufferedInputStream2 = null;
                                                try {
                                                    File file = new File(hf, "1");
                                                    properties = new Properties();
                                                    if (file.exists()) {
                                                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                                                        try {
                                                            properties.load(bufferedInputStream);
                                                            j = true;
                                                        } catch (Exception e) {
                                                            if (bufferedInputStream != null) {
                                                                try {
                                                                    bufferedInputStream.close();
                                                                } catch (IOException e2) {
                                                                }
                                                            }
                                                            properties2 = properties;
                                                            j = true;
                                                            if (j) {
                                                                listFiles = hf.listFiles();
                                                                o.gG(context).HV(-552);
                                                                while (abf < listFiles.length) {
                                                                    Q = a.Q(r7);
                                                                    property = properties2.getProperty(r7.getName(), "");
                                                                    if (!property.equals("")) {
                                                                    }
                                                                    TbsLog.e("TbsInstaller", "md5_check_failure for (" + r7.getName() + ") targetMd5:" + property + ", realMd5:" + Q);
                                                                    z = false;
                                                                }
                                                            }
                                                            TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z);
                                                            if (j) {
                                                            }
                                                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                                            y(context2, true);
                                                            hg = l.gD(context);
                                                            l.a(new File(hg, p.gK(context2) ? "x5.oversea.tbs.org" : "x5.tbs.org"), context2);
                                                            n.gF(context2).fE(i, 1);
                                                            if (tVar.zXO) {
                                                                v.hn(context2).bc(220, "success");
                                                            } else {
                                                                v.hn(context2).bc(220, "continueInstallWithout core success");
                                                            }
                                                            o.gG(context).HV(-533);
                                                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i);
                                                            try {
                                                                edit = (VERSION.SDK_INT < 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                                                edit.putInt("tbs_preload_x5_counter", 0);
                                                                edit.putInt("tbs_preload_x5_recorder", 0);
                                                                edit.putInt("tbs_preload_x5_version", i);
                                                                edit.commit();
                                                            } catch (Throwable th2) {
                                                                TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#2 exception:" + Log.getStackTraceString(th2));
                                                            }
                                                            u.ib(context2);
                                                            zXM.unlock();
                                                            zXN.unlock();
                                                            tVar.cEI();
                                                            return;
                                                        } catch (Throwable th3) {
                                                            th2 = th3;
                                                            bufferedInputStream2 = bufferedInputStream;
                                                            if (bufferedInputStream2 != null) {
                                                                try {
                                                                    bufferedInputStream2.close();
                                                                } catch (IOException e3) {
                                                                }
                                                            }
                                                            throw th2;
                                                        }
                                                    } else {
                                                        bufferedInputStream = null;
                                                        j = false;
                                                    }
                                                    if (bufferedInputStream != null) {
                                                        try {
                                                            bufferedInputStream.close();
                                                        } catch (IOException e4) {
                                                        }
                                                    }
                                                    properties2 = properties;
                                                } catch (Exception e5) {
                                                    properties = null;
                                                    bufferedInputStream = null;
                                                    if (bufferedInputStream != null) {
                                                        bufferedInputStream.close();
                                                    }
                                                    properties2 = properties;
                                                    j = true;
                                                    if (j) {
                                                        listFiles = hf.listFiles();
                                                        o.gG(context).HV(-552);
                                                        while (abf < listFiles.length) {
                                                            Q = a.Q(r7);
                                                            property = properties2.getProperty(r7.getName(), "");
                                                            if (property.equals("")) {
                                                            }
                                                            TbsLog.e("TbsInstaller", "md5_check_failure for (" + r7.getName() + ") targetMd5:" + property + ", realMd5:" + Q);
                                                            z = false;
                                                        }
                                                    }
                                                    TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z);
                                                    if (j) {
                                                    }
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                                    y(context2, true);
                                                    hg = l.gD(context);
                                                    if (p.gK(context2)) {
                                                    }
                                                    l.a(new File(hg, p.gK(context2) ? "x5.oversea.tbs.org" : "x5.tbs.org"), context2);
                                                    n.gF(context2).fE(i, 1);
                                                    if (tVar.zXO) {
                                                        v.hn(context2).bc(220, "success");
                                                    } else {
                                                        v.hn(context2).bc(220, "continueInstallWithout core success");
                                                    }
                                                    o.gG(context).HV(-533);
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i);
                                                    if (VERSION.SDK_INT < 11) {
                                                    }
                                                    edit = (VERSION.SDK_INT < 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                                    edit.putInt("tbs_preload_x5_counter", 0);
                                                    edit.putInt("tbs_preload_x5_recorder", 0);
                                                    edit.putInt("tbs_preload_x5_version", i);
                                                    edit.commit();
                                                    u.ib(context2);
                                                    zXM.unlock();
                                                    zXN.unlock();
                                                    tVar.cEI();
                                                    return;
                                                } catch (Throwable th4) {
                                                    th2 = th4;
                                                    if (bufferedInputStream2 != null) {
                                                        bufferedInputStream2.close();
                                                    }
                                                    throw th2;
                                                }
                                                if (j) {
                                                    listFiles = hf.listFiles();
                                                    o.gG(context).HV(-552);
                                                    for (File file2 : listFiles) {
                                                        if (!("1".equals(file2.getName()) || file2.getName().endsWith(".dex") || "tbs.conf".equals(file2.getName()) || file2.isDirectory() || file2.getName().endsWith(".prof"))) {
                                                            Q = a.Q(file2);
                                                            property = properties2.getProperty(file2.getName(), "");
                                                            if (property.equals("") || !Q.equals(property)) {
                                                                TbsLog.e("TbsInstaller", "md5_check_failure for (" + file2.getName() + ") targetMd5:" + property + ", realMd5:" + Q);
                                                                z = false;
                                                                break;
                                                            }
                                                            TbsLog.i("TbsInstaller", "md5_check_success for (" + file2.getName() + ")");
                                                        }
                                                    }
                                                }
                                                TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z);
                                                if (j || z) {
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                                    y(context2, true);
                                                    hg = l.gD(context);
                                                    if (hg != null && hg.exists()) {
                                                        if (p.gK(context2)) {
                                                        }
                                                        l.a(new File(hg, p.gK(context2) ? "x5.oversea.tbs.org" : "x5.tbs.org"), context2);
                                                    }
                                                    n.gF(context2).fE(i, 1);
                                                    if (tVar.zXO) {
                                                        v.hn(context2).bc(220, "continueInstallWithout core success");
                                                    } else {
                                                        v.hn(context2).bc(220, "success");
                                                    }
                                                    o.gG(context).HV(-533);
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i);
                                                    if (VERSION.SDK_INT < 11) {
                                                    }
                                                    edit = (VERSION.SDK_INT < 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                                    edit.putInt("tbs_preload_x5_counter", 0);
                                                    edit.putInt("tbs_preload_x5_recorder", 0);
                                                    edit.putInt("tbs_preload_x5_version", i);
                                                    edit.commit();
                                                    u.ib(context2);
                                                } else {
                                                    TbsLog.e("TbsInstaller", "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!");
                                                    f.e(hf, true);
                                                    v.hn(context2).bc(c.CTRL_INDEX, "TbsCopy-Verify md5 fail after copying tbs core!");
                                                    o.gG(context).HV(-532);
                                                    zXM.unlock();
                                                    zXN.unlock();
                                                }
                                            } else {
                                                TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread copy-verify fail!");
                                                f.e(hf, true);
                                                v.hn(context2).bc(c.CTRL_INDEX, "TbsCopy-Verify fail after copying tbs core!");
                                                o.gG(context).HV(-531);
                                                zXM.unlock();
                                                zXN.unlock();
                                            }
                                        } else {
                                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread fail!");
                                            n.gF(context2).fE(i, 2);
                                            f.e(hf, false);
                                            o.gG(context).HV(-534);
                                            v.hn(context2).bc(b.CTRL_INDEX, "copy fail!");
                                        }
                                    }
                                    zXM.unlock();
                                    zXN.unlock();
                                } else {
                                    long cFH = u.cFH();
                                    long cEl = o.gG(context2).cEl();
                                    o.gG(context).HV(-529);
                                    v.hn(context2).bc(i.CTRL_INDEX, "rom is not enough when copying tbs core! curAvailROM=" + cFH + ",minReqRom=" + cEl);
                                    zXM.unlock();
                                    zXN.unlock();
                                }
                            }
                        }
                    } catch (Exception e6) {
                        v.hn(context2).bc(bp.CTRL_INDEX, e6.toString());
                        o.gG(context).HV(-537);
                        zXM.unlock();
                        zXN.unlock();
                    } catch (Throwable th5) {
                        zXM.unlock();
                        zXN.unlock();
                        tVar.cEI();
                    }
                    tVar.cEI();
                    return;
                }
                tVar.cEI();
                o.gG(context).HV(-538);
            } else {
                o.gG(context).HV(-526);
            }
        }
    }

    private synchronized boolean a(final Context context, Context context2) {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (!zXU) {
            zXU = true;
            new Thread(this, null) {
                final /* synthetic */ t zXV;

                public final void run() {
                    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
                    try {
                        File file = null == null ? new File(x.cEQ()) : t.hg(null);
                        File hg = t.hg(context);
                        int i = VERSION.SDK_INT;
                        if (i != 19 && i < 21) {
                            f.a(file, hg, new 1(this));
                        }
                        f.a(file, hg, new 2(this));
                        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
                    } catch (Exception e) {
                    }
                }
            }.start();
        }
        return true;
    }

    private boolean a(Context context, File file) {
        try {
            File[] listFiles = file.listFiles(new 5(this));
            int length = listFiles.length;
            if (VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase("com.tencent.tbs")) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i = 0; i < length; i++) {
                TbsLog.i("TbsInstaller", "jarFile: " + listFiles[i].getAbsolutePath());
                DexClassLoader dexClassLoader = new DexClassLoader(listFiles[i].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (Exception e2) {
            v.hn(context).bc(com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX, e2.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(Context context, File file, boolean z) {
        boolean z2 = true;
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs start");
        if (f.U(file)) {
            File dir;
            try {
                dir = context.getDir("tbs", 0);
                File file2 = z ? new File(dir, "core_share_decouple") : new File(dir, "core_unzip_tmp");
                if (file2.exists() && o.gG(context).zXm.getInt("tbs_downloaddecouplecore", 0) != 1) {
                    f.T(file2);
                }
            } catch (Throwable th) {
                TbsLog.e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th));
            }
            File hk = z ? hk(context) : hj(context);
            if (hk == null) {
                v.hn(context).bc(g.CTRL_INDEX, "tmp unzip dir is null!");
                o.gG(context).HV(-521);
                return false;
            }
            boolean i;
            try {
                f.S(hk);
                if (z) {
                    f.e(hk, true);
                }
                i = f.i(file, hk);
                if (z) {
                    String[] list = hk.list();
                    for (String file3 : list) {
                        File file4 = new File(hk, file3);
                        if (file4.getName().endsWith(".dex")) {
                            file4.delete();
                        }
                    }
                    new File(hi(context), "x5.tbs").delete();
                }
                if (i) {
                    y(context, true);
                    if (z) {
                        dir = hf(context);
                        f.e(dir, true);
                        hk.renameTo(dir);
                        x.hp(context);
                    }
                } else {
                    f.T(hk);
                    o.gG(context).HV(-522);
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + hk.exists());
                }
                TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                return i;
            } catch (Throwable th2) {
                o.gG(context).HV(-523);
                v.hn(context).c(com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, th2);
                if (hk != null) {
                }
                i = false;
                f.T(hk);
                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + hk.exists());
                String str = "TbsInstaller";
                String str2 = "TbsInstaller-unzipTbs done";
            } catch (Throwable th22) {
                o.gG(context).HV(-523);
                v.hn(context).c(207, th22);
                if (hk == null || !hk.exists()) {
                    z2 = false;
                }
                if (z2 && hk != null) {
                    f.T(hk);
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + hk.exists());
                }
            } catch (Throwable th222) {
                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th222));
            }
        } else {
            v.hn(context).bc(d.CTRL_INDEX, "apk is invalid!");
            o.gG(context).HV(-520);
            return false;
        }
        TbsLog.i(str, str2);
        return false;
        str = "TbsInstaller";
        str2 = "TbsInstaller-unzipTbs done";
        TbsLog.i(str, str2);
        return false;
    }

    static int abi(String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        if (str != null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                File file = new File(new File(str), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property != null) {
                            i = Integer.parseInt(property);
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } else if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Exception e) {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } else if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Exception e4) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return i;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        }
        return i;
    }

    private Context aq(Context context, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i);
        if (i <= 0) {
            return null;
        }
        String[] cER = x.cER();
        int i2 = 0;
        while (i2 < 4) {
            if (!context.getPackageName().equalsIgnoreCase(cER[i2]) && bJ(context, cER[i2])) {
                Context bK = bK(context, cER[i2]);
                if (bK == null) {
                    continue;
                } else if (gS(bK)) {
                    int gY = gY(bK);
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + gY);
                    if (gY != 0 && gY == i) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + cER[i2]);
                        return bK;
                    }
                } else {
                    TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + cER[i2] + " illegal signature go on next");
                }
            }
            i2++;
        }
        return null;
    }

    private boolean b(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            DexClassLoader dexClassLoader = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Object abb = g.abb(file3.getAbsolutePath());
            if (TextUtils.isEmpty(abb)) {
                v.hn(context).bc(com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, "can not find oat command");
                return false;
            }
            for (File file4 : file.listFiles(new 6(this))) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                StringBuilder append = new StringBuilder("/system/bin/dex2oat ").append(abb.replaceAll("tbs_sdk_extension_dex", substring)).append(" --dex-location=");
                cEF();
                Runtime.getRuntime().exec(append.append(hg(context)).append(File.separator).append(substring).append(".jar").toString()).waitFor();
            }
            return true;
        } catch (Throwable e) {
            v.hn(context).c(com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, e);
            return false;
        }
    }

    private static boolean bI(Context context, String str) {
        File file = new File(context.getDir("tbs", 0), str);
        return file.exists() && new File(file, "tbs.conf").exists();
    }

    private static boolean bJ(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static Context bK(Context context, String str) {
        try {
            return context.createPackageContext(str, 2);
        } catch (Exception e) {
            return null;
        }
    }

    static synchronized t cEF() {
        t tVar;
        synchronized (t.class) {
            if (zXH == null) {
                synchronized (t.class) {
                    if (zXH == null) {
                        zXH = new t();
                    }
                }
            }
            tVar = zXH;
        }
        return tVar;
    }

    private synchronized boolean cEG() {
        return false;
    }

    private static void cEH() {
        boolean z = true;
        try {
            z = o.cEi().cEo();
        } catch (Throwable th) {
        }
        if (z && zXP != null) {
            f.a(zXP);
        }
    }

    private synchronized void cEI() {
        int i = this.zXI;
        this.zXI = i - 1;
        if (i > 1 || !this.zXL) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
        } else {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
            f.a(this.zXJ, this.zXK);
            this.zXL = false;
        }
    }

    public static void gN(Context context) {
        if (!gP(context)) {
            if (bI(context, "core_unzip_tmp")) {
                m.cEf().a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
            } else if (bI(context, "core_share_backup_tmp")) {
                m.cEf().a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
            } else if (bI(context, "core_copy_tmp")) {
                m.cEf().a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
            }
        }
    }

    private static boolean gP(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf").exists();
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean gQ(Context context) {
        try {
            File file = new File(f.ar(context, 4), "x5.tbs.decouple");
            cEF();
            File hk = hk(context);
            f.S(hk);
            f.e(hk, true);
            f.i(file, hk);
            String[] list = hk.list();
            for (String file2 : list) {
                File file3 = new File(hk, file2);
                if (file3.getName().endsWith(".dex")) {
                    file3.delete();
                }
            }
            cEF();
            y(context, true);
            file = hf(context);
            f.e(file, true);
            hk.renameTo(file);
            x.hp(context);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean gR(Context context) {
        boolean z = false;
        TbsLog.i("TbsInstaller", new StringBuilder("TbsInstaller-doTbsDexOpt start - dirMode: 0").toString());
        try {
            if (o.gG(context).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
                return true;
            }
            boolean z2;
            boolean z3;
            File hj = hj(context);
            try {
                String property = System.getProperty("java.vm.version");
                z2 = property != null && property.startsWith("2");
                z3 = z2;
            } catch (Throwable th) {
                v.hn(context).c(com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, th);
                z3 = false;
            }
            z2 = VERSION.SDK_INT == 23;
            boolean z4 = o.gG(context).zXm.getBoolean("tbs_stop_preoat", false);
            if (z3 && z2 && !z4) {
                z = true;
            }
            return (z && b(context, hj)) ? true : a(context, hj);
        } catch (Exception e) {
            v.hn(context).bc(com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX, e.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return true;
        }
    }

    static boolean gS(Context context) {
        if (x.cEQ() != null) {
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            return context.getPackageName().equals("com.tencent.mtt") ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.tencent.mm") ? signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499") : context.getPackageName().equals("com.tencent.mobileqq") ? signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049") : context.getPackageName().equals("com.tencent.tbs") ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.qzone") ? signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677") : !context.getPackageName().equals("com.tencent.qqpimsecure") || signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        } catch (Exception e) {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    private static boolean gT(Context context) {
        boolean cEo;
        try {
            cEo = o.cEi().cEo();
        } catch (Throwable th) {
            cEo = true;
        }
        if (cEo) {
            zXP = f.hU(context);
        } else {
            zXP = af.cFg().hC(context);
        }
        return zXP != null;
    }

    private void gU(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (gT(context)) {
            try {
                hb(context);
                TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
                File hj = hj(context);
                File hg = hg(context);
                if (!(hj == null || hg == null)) {
                    hj.renameTo(hg);
                    y(context, false);
                }
                if (!x.hq(context)) {
                    x.ho(context);
                }
                n.gF(context).dH("dexopt_retry_num", 0);
                n.gF(context).dH("unzip_retry_num", 0);
                n.gF(context).dH("unlzma_status", 0);
                n.gF(context).dH("incrupdate_retry_num", 0);
                n.gF(context).fF(0, 3);
                n.gF(context).fW("install_apk_path", "");
                n.gF(context).dH("incrupdate_status", -1);
                if (!x.hq(context)) {
                    int i = o.gG(context).zXm.getInt("tbs_decouplecoreversion", 0);
                    if (i > 0) {
                        cEF();
                        if (i != gX(context) && i == cEF().gY(context)) {
                            hc(context);
                        }
                    }
                    StringBuilder append = new StringBuilder("TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is ").append(i).append(" getTbsCoreShareDecoupleCoreVersion is ");
                    cEF();
                    TbsLog.i("TbsInstaller", append.append(gX(context)).append(" getTbsCoreInstalledVerInNolock is ").append(cEF().gY(context)).toString());
                }
                if (x.hq(context)) {
                    x.c(context, ha(context), true);
                }
                zXQ.set(Integer.valueOf(0));
            } catch (Throwable th) {
                v.hn(context).bc(219, "exception when renameing from unzip:" + th.toString());
                TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
            }
            cEH();
            return;
        }
        TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
    }

    private void gV(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (gT(context)) {
            try {
                hb(context);
                TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
                File hl = hl(context);
                File hg = hg(context);
                if (!(hl == null || hg == null)) {
                    hl.renameTo(hg);
                    y(context, false);
                }
                x.ho(context);
                n.gF(context).fE(0, 3);
                if (!x.hq(context)) {
                    int i = o.gG(context).zXm.getInt("tbs_decouplecoreversion", 0);
                    if (i > 0) {
                        cEF();
                        if (i != gX(context) && i == cEF().gY(context)) {
                            hc(context);
                        }
                    }
                    StringBuilder append = new StringBuilder("TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is ").append(i).append(" getTbsCoreShareDecoupleCoreVersion is ");
                    cEF();
                    TbsLog.i("TbsInstaller", append.append(gX(context)).append(" getTbsCoreInstalledVerInNolock is ").append(cEF().gY(context)).toString());
                }
                zXQ.set(Integer.valueOf(0));
            } catch (Exception e) {
                v.hn(context).bc(219, "exception when renameing from copy:" + e.toString());
            }
            cEH();
            return;
        }
        TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
    }

    static int gW(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File hj = hj(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--getTmpTbsCoreVersionUnzipDir  tbsShareDir is " + hj);
            File file = new File(hj, "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return i;
                    }
                    i = Integer.parseInt(property);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return i;
                } catch (Exception e) {
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e3) {
                }
            }
            return i;
        } catch (Exception e4) {
            bufferedInputStream = bufferedInputStream2;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    static int gX(Context context) {
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File file = new File(hf(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        return i;
                    }
                    i = Integer.parseInt(property);
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    return i;
                } catch (Exception e) {
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                }
            }
            return i;
        } catch (Exception e4) {
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    private void hb(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        f.e(hg(context), false);
    }

    private static void hd(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File hj = hj(context);
        if (hj != null) {
            f.e(hj, false);
        }
        n.gF(context).fF(0, 5);
        n.gF(context).dH("incrupdate_status", -1);
        QbSdk.bG(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    static void he(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        n.gF(context).dH("dexopt_retry_num", 0);
        n.gF(context).dH("unzip_retry_num", 0);
        n.gF(context).dH("unlzma_status", 0);
        n.gF(context).dH("incrupdate_retry_num", 0);
        if (o.gG(context).zXm.getInt("tbs_downloaddecouplecore", 0) != 1) {
            n.gF(context).fF(0, -1);
            n.gF(context).fW("install_apk_path", "");
            n.gF(context).dH("copy_retry_num", 0);
            n.gF(context).dH("incrupdate_status", -1);
            n.gF(context).fE(0, -1);
            f.e(hj(context), true);
            f.e(hl(context), true);
        }
    }

    static File hf(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_share_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File hg(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File hh(Context context) {
        File file = new File(context.getDir("tbs", 0), "share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File hi(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_private");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File hj(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private static File hk(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private static File hl(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_copy_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private synchronized boolean hm(Context context) {
        boolean z = true;
        synchronized (this) {
            this.zXI++;
            if (this.zXL) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            } else {
                this.zXK = f.c(context, true, "tbslock.txt");
                if (this.zXK != null) {
                    this.zXJ = f.a(this.zXK);
                    if (this.zXJ == null) {
                        z = false;
                    } else {
                        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
                        this.zXL = true;
                    }
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    static void s(Context context, String str, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object obj = new Object[]{context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        zXR.sendMessage(message);
    }

    @TargetApi(11)
    private void t(Context context, String str, int i) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Throwable th2;
        o.gG(context).HV(-501);
        if (gO(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            o.gG(context).HV(-502);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if ((VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            o.gG(context).HV(-503);
        } else if (!f.hS(context)) {
            long cFH = u.cFH();
            long cEl = o.gG(context).cEl();
            o.gG(context).HV(-504);
            v.hn(context).bc(i.CTRL_INDEX, "rom is not enough when installing tbs core! curAvailROM=" + cFH + ",minReqRom=" + cEl);
        } else if (hm(context)) {
            boolean tryLock = zXN.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + tryLock);
            if (tryLock) {
                o.gG(context).HV(-507);
                zXM.lock();
                try {
                    Object obj;
                    int i2;
                    int abg = n.gF(context).abg("copy_core_ver");
                    int abg2 = n.gF(context).abg("install_core_ver");
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + abg);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + abg2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i);
                    if ((abg2 > 0 && i > abg2) || (abg > 0 && i > abg)) {
                        he(context);
                    }
                    abg2 = n.gF(context).abf("install_status");
                    int gY = gY(context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + abg2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + gY);
                    if (abg2 < 0 || abg2 >= 2) {
                        if (abg2 == 3 && gY > 0 && (i > gY || i == 88888888)) {
                            abg2 = -1;
                            he(context);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                        }
                        obj = null;
                        i2 = abg2;
                    } else {
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                        obj = 1;
                        i2 = abg2;
                    }
                    o.gG(context).HV(-508);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + i2);
                    abg = 0;
                    if (i2 <= 0) {
                        String stringValue;
                        TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                        o.gG(context).HV(-509);
                        if (obj != null) {
                            abg = n.gF(context).abg("unzip_retry_num");
                            if (abg > 10) {
                                v.hn(context).bc(201, "exceed unzip retry num!");
                                hd(context);
                                o.gG(context).HV(-510);
                                zXM.unlock();
                                zXN.unlock();
                                cEI();
                                return;
                            }
                            n.gF(context).dH("unzip_retry_num", abg + 1);
                        }
                        if (str == null) {
                            stringValue = n.gF(context).getStringValue("install_apk_path");
                            if (stringValue == null) {
                                v.hn(context).bc(202, "apk path is null!");
                                o.gG(context).HV(-511);
                                zXM.unlock();
                                zXN.unlock();
                                cEI();
                                return;
                            }
                        }
                        stringValue = str;
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + stringValue);
                        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(stringValue, 0);
                        gY = packageArchiveInfo != null ? packageArchiveInfo.versionCode : 0;
                        if (gY == 0) {
                            o.gG(context).HV(-512);
                            v.hn(context).bc(203, "apk version is 0!");
                            zXM.unlock();
                            zXN.unlock();
                            cEI();
                            return;
                        }
                        n.gF(context).fW("install_apk_path", stringValue);
                        n.gF(context).fF(gY, 0);
                        o.gG(context).HV(-548);
                        if (o.gG(context).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
                            if (!a(context, new File(stringValue), true)) {
                                v.hn(context).a(207, "unzipTbsApk failed", v.a.TYPE_INSTALL_DECOUPLE);
                                zXM.unlock();
                                zXN.unlock();
                                cEI();
                                return;
                            }
                        } else if (!a(context, new File(stringValue), false)) {
                            v.hn(context).bc(207, "unzipTbsApk failed");
                            zXM.unlock();
                            zXN.unlock();
                            cEI();
                            return;
                        }
                        if (obj != null) {
                            abg = n.gF(context).abf("unlzma_status");
                            if (abg > 5) {
                                v.hn(context).bc(223, "exceed unlzma retry num!");
                                o.gG(context).HV(-553);
                                hd(context);
                                l.gE(context);
                                o.gG(context).zXl.put("tbs_needdownload", Boolean.valueOf(true));
                                o.gG(context).zXl.put("request_full_package", Boolean.valueOf(true));
                                o.gG(context).commit();
                                zXM.unlock();
                                zXN.unlock();
                                cEI();
                                return;
                            }
                            n.gF(context).dH("unlzma_status", abg + 1);
                        }
                        TbsLog.i("TbsInstaller", "unlzma begin");
                        int i3 = o.cEi().zXm.getInt("tbs_responsecode", 0);
                        if (gY(context) != 0) {
                            Object b = QbSdk.b(context, "can_unlzma", null);
                            tryLock = (b == null || !(b instanceof Boolean)) ? false : ((Boolean) b).booleanValue();
                            if (tryLock) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("responseCode", i3);
                                if (o.gG(context).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
                                    bundle.putString("unzip_temp_path", hf(context).getAbsolutePath());
                                } else {
                                    bundle.putString("unzip_temp_path", hj(context).getAbsolutePath());
                                }
                                b = QbSdk.b(context, "unlzma", bundle);
                                if (b == null) {
                                    TbsLog.i("TbsInstaller", "unlzma return null");
                                    v.hn(context).bc(222, "unlzma is null");
                                    b = null;
                                } else if (b instanceof Boolean) {
                                    if (((Boolean) b).booleanValue()) {
                                        b = 1;
                                        TbsLog.i("TbsInstaller", "unlzma success");
                                    } else {
                                        TbsLog.i("TbsInstaller", "unlzma return false");
                                        v.hn(context).bc(222, "unlzma return false");
                                        b = null;
                                    }
                                } else if (b instanceof Bundle) {
                                    b = 1;
                                } else {
                                    if (b instanceof Throwable) {
                                        TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) b));
                                        v.hn(context).c(222, (Throwable) b);
                                    }
                                    b = null;
                                }
                                if (b == null) {
                                    zXM.unlock();
                                    zXN.unlock();
                                    cEI();
                                    return;
                                }
                            }
                        }
                        TbsLog.i("TbsInstaller", "unlzma finished");
                        n.gF(context).fF(gY, 1);
                        abg = gY;
                    } else if (o.gG(context).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
                        String stringValue2;
                        if (str == null) {
                            stringValue2 = n.gF(context).getStringValue("install_apk_path");
                            if (stringValue2 == null) {
                                v.hn(context).bc(202, "apk path is null!");
                                o.gG(context).HV(-511);
                                zXM.unlock();
                                zXN.unlock();
                                cEI();
                                return;
                            }
                        }
                        stringValue2 = str;
                        a(context, new File(stringValue2), true);
                    }
                    if (i2 < 2) {
                        if (obj != null) {
                            abg2 = n.gF(context).abg("dexopt_retry_num");
                            if (abg2 > 10) {
                                v.hn(context).bc(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, "exceed dexopt retry num!");
                                o.gG(context).HV(-514);
                                hd(context);
                                zXM.unlock();
                                zXN.unlock();
                                cEI();
                                return;
                            }
                            n.gF(context).dH("dexopt_retry_num", abg2 + 1);
                        }
                        o.gG(context).HV(-549);
                        if (gR(context)) {
                            n.gF(context).fF(abg, 2);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i);
                            o.gG(context).HV(-516);
                            Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                            edit.putInt("tbs_preload_x5_counter", 0);
                            edit.putInt("tbs_preload_x5_recorder", 0);
                            edit.putInt("tbs_preload_x5_version", i);
                            edit.commit();
                            o.gG(context).HV(-517);
                            if (i == 88888888) {
                                new File(str).delete();
                                TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
                                File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
                                if (file.canRead()) {
                                    File file2 = new File(file, "tbs.conf");
                                    Properties properties = new Properties();
                                    BufferedOutputStream bufferedOutputStream2 = null;
                                    BufferedInputStream bufferedInputStream2;
                                    try {
                                        bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
                                        try {
                                            properties.load(bufferedInputStream2);
                                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (bufferedOutputStream2 != null) {
                                                try {
                                                    bufferedOutputStream2.close();
                                                } catch (IOException e) {
                                                }
                                            }
                                            if (bufferedInputStream2 != null) {
                                                try {
                                                    bufferedInputStream2.close();
                                                } catch (IOException e2) {
                                                }
                                            }
                                            throw th;
                                        }
                                        try {
                                            properties.setProperty("tbs_local_installation", "true");
                                            properties.store(bufferedOutputStream, null);
                                            TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e3) {
                                            }
                                            try {
                                                bufferedInputStream2.close();
                                            } catch (IOException e4) {
                                            }
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            th = th2;
                                            if (bufferedOutputStream2 != null) {
                                                bufferedOutputStream2.close();
                                            }
                                            if (bufferedInputStream2 != null) {
                                                bufferedInputStream2.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        bufferedInputStream2 = null;
                                        th = th2;
                                        if (bufferedOutputStream2 != null) {
                                            bufferedOutputStream2.close();
                                        }
                                        if (bufferedInputStream2 != null) {
                                            bufferedInputStream2.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            if (this.zXO) {
                                if (n.gF(context).abf("incrupdate_status") != 1) {
                                }
                                v.hn(context).bc(n.gF(context).abf("incrupdate_status") != 1 ? 221 : 200, "continueInstallWithout core success");
                            } else {
                                if (n.gF(context).abf("incrupdate_status") != 1) {
                                }
                                v.hn(context).bc(n.gF(context).abf("incrupdate_status") != 1 ? 221 : 200, "success");
                            }
                        } else {
                            o.gG(context).HV(-515);
                            zXM.unlock();
                            zXN.unlock();
                            cEI();
                            return;
                        }
                    } else if (i2 == 2) {
                        QbSdk.zWf.lz(200);
                    }
                } catch (Throwable th6) {
                    zXM.unlock();
                    zXN.unlock();
                    cEI();
                }
                zXM.unlock();
                zXN.unlock();
                cEI();
                return;
            }
            o.gG(context).HV(-519);
            cEI();
        } else {
            o.gG(context).HV(-505);
        }
    }

    private synchronized boolean u(Context context, boolean z) {
        Throwable th;
        boolean z2 = false;
        boolean z3 = true;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
            try {
                if (hm(context)) {
                    boolean tryLock = zXM.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + tryLock);
                    if (tryLock) {
                        int abf = n.gF(context).abf("copy_status");
                        int b = b(false, context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + abf);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + b);
                        if (abf == 1) {
                            if (b == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                                gV(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                gV(context);
                            }
                            zXM.unlock();
                            z2 = z3;
                        }
                        z3 = false;
                        try {
                            zXM.unlock();
                            z2 = z3;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            z2 = z3;
                            th = th3;
                            v.hn(context).bc(bp.CTRL_INDEX, th.toString());
                            QbSdk.bG(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                            return z2;
                        }
                    }
                    cEI();
                }
            } catch (Throwable th4) {
                th = th4;
                v.hn(context).bc(bp.CTRL_INDEX, th.toString());
                QbSdk.bG(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                return z2;
            }
        }
        return z2;
    }

    private synchronized boolean v(Context context, boolean z) {
        Object obj;
        boolean z2 = true;
        boolean z3 = false;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
            try {
                if (hm(context)) {
                    boolean tryLock = zXM.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + tryLock);
                    if (tryLock) {
                        int abf = n.gF(context).abf("install_status");
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + abf);
                        int b = b(false, context);
                        if (abf == 2) {
                            if (b == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                                gU(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                gU(context);
                            }
                            zXM.unlock();
                            z3 = z2;
                        }
                        z2 = false;
                        try {
                            zXM.unlock();
                            z3 = z2;
                        } catch (Exception e) {
                            Exception exception = e;
                            z3 = z2;
                            Exception exception2 = exception;
                            QbSdk.bG(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + obj);
                            return z3;
                        }
                    }
                    cEI();
                }
            } catch (Exception e2) {
                obj = e2;
                QbSdk.bG(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + obj);
                return z3;
            } catch (Throwable th) {
                zXM.unlock();
            }
        }
        return z3;
    }

    static void y(Context context, boolean z) {
        if (context == null) {
            v.hn(context).bc(225, "setTmpFolderCoreToRead context is null");
            return;
        }
        try {
            File file = new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
            if (!z) {
                f.T(file);
            } else if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            v.hn(context).bc(225, "setTmpFolderCoreToRead Exception message is " + e.getMessage() + " Exception cause is " + e.getCause());
        }
    }

    final boolean ap(Context context, int i) {
        if (p.gK(context)) {
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (aq(context, i) != null) {
            Object obj = new Object[]{aq(context, i), context, Integer.valueOf(i)};
            Message message = new Message();
            message.what = 2;
            message.obj = obj;
            zXR.sendMessage(message);
            return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        return false;
    }

    public final int b(boolean z, Context context) {
        if (z || ((Integer) zXQ.get()).intValue() <= 0) {
            zXQ.set(Integer.valueOf(gY(context)));
        }
        return ((Integer) zXQ.get()).intValue();
    }

    public final String bL(Context context, String str) {
        Throwable th;
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            BufferedInputStream bufferedInputStream = null;
            try {
                File file = new File(hg(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        str2 = properties.getProperty(str);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Exception e) {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } else if (str2 != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Exception e4) {
                bufferedInputStream = str2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return str2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedInputStream = str2;
                th = th4;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        }
        return str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void f(Context context, Bundle bundle) {
        Throwable e;
        Bundle bundle2;
        int i;
        String string;
        if (gO(context)) {
            o.gG(context).HV(-539);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle != null && context != null) {
            if (!f.hS(context)) {
                v.hn(context).bc(i.CTRL_INDEX, "rom is not enough when patching tbs core! curAvailROM=" + u.cFH() + ",minReqRom=" + o.gG(context).cEl());
                o.gG(context).HV(-540);
            } else if (hm(context)) {
                boolean tryLock = zXN.tryLock();
                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=" + tryLock);
                if (tryLock) {
                    Bundle bundle3 = null;
                    try {
                        QbSdk.setTBSInstallingStatus(true);
                        if (gY(context) <= 0 || n.gF(context).abf("incrupdate_status") == 1) {
                            QbSdk.setTBSInstallingStatus(false);
                            zXN.unlock();
                            cEI();
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                            QbSdk.setTBSInstallingStatus(false);
                            return;
                        }
                        int abg;
                        String string2;
                        int i2 = o.gG(context).zXm.getInt("tbs_responsecode", 0);
                        tryLock = i2 == 1 || i2 == 2 || i2 == 4;
                        if (!(tryLock || i2 == 0)) {
                            abg = n.gF(context).abg("incrupdate_retry_num");
                            if (abg > 5) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                                Object string3 = bundle.getString("old_apk_location");
                                Object string4 = bundle.getString("new_apk_location");
                                Object string5 = bundle.getString("diff_file_location");
                                if (!TextUtils.isEmpty(string3)) {
                                    f.T(new File(string3));
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    f.T(new File(string4));
                                }
                                if (!TextUtils.isEmpty(string5)) {
                                    f.T(new File(string5));
                                }
                                o.gG(context).zXl.put("tbs_needdownload", Boolean.valueOf(true));
                                o.gG(context).commit();
                                v.hn(context).bc(224, "incrUpdate exceed retry max num");
                                zXN.unlock();
                                cEI();
                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                            n.gF(context).dH("incrupdate_retry_num", abg + 1);
                            File hi = hi(context);
                            if (hi != null && new File(hi, "x5.tbs").exists()) {
                                o.gG(context).HV(-550);
                                bundle3 = QbSdk.e(context, bundle);
                                abg = bundle3 == null ? 1 : bundle3.getInt("patch_result");
                                zXN.unlock();
                                cEI();
                                if (abg == 0) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                    n.gF(context).dH("incrupdate_retry_num", 0);
                                    o.gG(context).HV(-544);
                                    n.gF(context).fF(0, -1);
                                    n.gF(context).dH("incrupdate_status", 1);
                                    string2 = bundle3.getString("apk_path");
                                    l.a(new File(string2), context);
                                    t(context, string2, bundle3.getInt("tbs_core_ver"));
                                } else if (abg != 2) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                } else {
                                    o.gG(context).HV(-546);
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                    o.gG(context).zXl.put("tbs_needdownload", Boolean.valueOf(true));
                                    o.gG(context).commit();
                                    v.hn(context).bc(e.CTRL_INDEX, "incrUpdate fail! patch ret=" + abg);
                                }
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                        }
                        abg = 2;
                        zXN.unlock();
                        cEI();
                        if (abg == 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                            n.gF(context).dH("incrupdate_retry_num", 0);
                            o.gG(context).HV(-544);
                            n.gF(context).fF(0, -1);
                            n.gF(context).dH("incrupdate_status", 1);
                            string2 = bundle3.getString("apk_path");
                            l.a(new File(string2), context);
                            t(context, string2, bundle3.getInt("tbs_core_ver"));
                        } else if (abg != 2) {
                            o.gG(context).HV(-546);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                            o.gG(context).zXl.put("tbs_needdownload", Boolean.valueOf(true));
                            o.gG(context).commit();
                            v.hn(context).bc(e.CTRL_INDEX, "incrUpdate fail! patch ret=" + abg);
                        } else {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        return;
                    } catch (Throwable e2) {
                        TbsLog.i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e2));
                        o.gG(context).HV(-543);
                        v.hn(context).bc(218, e2.toString());
                        zXN.unlock();
                        cEI();
                        o.gG(context).HV(-546);
                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                        o.gG(context).zXl.put("tbs_needdownload", Boolean.valueOf(true));
                        o.gG(context).commit();
                        v.hn(context).bc(e.CTRL_INDEX, "incrUpdate fail! patch ret=" + 1);
                    } catch (Throwable th) {
                        e2 = th;
                        bundle2 = bundle3;
                        i = 1;
                        zXN.unlock();
                        cEI();
                        if (i != 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                            n.gF(context).dH("incrupdate_retry_num", 0);
                            o.gG(context).HV(-544);
                            n.gF(context).fF(0, -1);
                            n.gF(context).dH("incrupdate_status", 1);
                            string = bundle2.getString("apk_path");
                            l.a(new File(string), context);
                            t(context, string, bundle2.getInt("tbs_core_ver"));
                        } else if (i == 2) {
                            o.gG(context).HV(-546);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                            o.gG(context).zXl.put("tbs_needdownload", Boolean.valueOf(true));
                            o.gG(context).commit();
                            v.hn(context).bc(e.CTRL_INDEX, "incrUpdate fail! patch ret=" + i);
                        } else {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        throw e2;
                    }
                }
                o.gG(context).HV(-547);
                cEI();
            } else {
                o.gG(context).HV(-541);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean gO(Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        Throwable th;
        int i = 1;
        File file = new File(hg(context), "tbs.conf");
        if (!file.exists()) {
            return false;
        }
        boolean z;
        Properties properties = new Properties();
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            boolean booleanValue;
            try {
                properties.load(bufferedInputStream);
                booleanValue = Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                z = booleanValue ? System.currentTimeMillis() - file.lastModified() > 259200000 : false;
                TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is:" + booleanValue + " expired=" + z);
                if (z) {
                    i = 0;
                }
                z = booleanValue & i;
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
        return z;
    }

    final int gY(Context context) {
        String str;
        Exception e;
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File file = new File(hg(context), "tbs.conf");
            String property;
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e2) {
                                str = "TbsInstaller";
                                property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString();
                                TbsLog.i(str, property);
                                return i;
                            }
                        }
                        return i;
                    }
                    i = Integer.parseInt(property);
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e22) {
                            str = "TbsInstaller";
                            property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22.toString();
                            TbsLog.i(str, property);
                            return i;
                        }
                    }
                    return i;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e222) {
                                str = "TbsInstaller";
                                property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e222.toString();
                                TbsLog.i(str, property);
                                return i;
                            }
                        }
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e2222) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2222.toString());
                            }
                        }
                        throw th;
                    }
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e22222) {
                    str = "TbsInstaller";
                    property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22222.toString();
                    TbsLog.i(str, property);
                    return i;
                }
            }
            return i;
        } catch (Exception e4) {
            e = e4;
            bufferedInputStream2 = bufferedInputStream;
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    final boolean gZ(Context context) {
        return new File(hg(context), "tbs.conf").exists();
    }

    final int ha(Context context) {
        Exception e;
        Throwable th;
        if (!hm(context)) {
            return -1;
        }
        boolean tryLock = zXM.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer locked=" + tryLock);
        if (tryLock) {
            BufferedInputStream bufferedInputStream = null;
            BufferedInputStream bufferedInputStream2;
            try {
                File file = new File(hg(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream2);
                        bufferedInputStream2.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e2) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e2.toString());
                                }
                            }
                            zXM.unlock();
                            cEI();
                            return 0;
                        }
                        zXQ.set(Integer.valueOf(Integer.parseInt(property)));
                        int intValue = ((Integer) zXQ.get()).intValue();
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e3) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e3.toString());
                            }
                        }
                        zXM.unlock();
                        cEI();
                        return intValue;
                    } catch (Exception e4) {
                        e = e4;
                        try {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e22) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e22.toString());
                                }
                            }
                            zXM.unlock();
                            cEI();
                            return 0;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e32) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e32.toString());
                                }
                            }
                            zXM.unlock();
                            cEI();
                            throw th;
                        }
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e222) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e222.toString());
                    }
                }
                zXM.unlock();
                cEI();
                return 0;
            } catch (Exception e5) {
                e = e5;
                bufferedInputStream2 = bufferedInputStream;
                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                zXM.unlock();
                cEI();
                return 0;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                zXM.unlock();
                cEI();
                throw th;
            }
        }
        cEI();
        return 0;
    }

    public final boolean hc(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        File hg = hg(context);
        File hf = hf(context);
        try {
            f.e(hf, true);
            f.a(hg, hf, new FileFilter(this) {
                final /* synthetic */ t zXV;

                {
                    this.zXV = r1;
                }

                public final boolean accept(File file) {
                    return !file.getName().endsWith(".dex");
                }
            });
            x.hp(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    final void w(Context context, boolean z) {
        boolean z2 = false;
        if (z) {
            this.zXO = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentThreadName=");
        int name = Thread.currentThread().getName();
        String stringBuilder2 = stringBuilder.append(name).toString();
        TbsLog.i("TbsInstaller", stringBuilder2);
        if (hm(context)) {
            int abf;
            int abg;
            int tryLock = zXM.tryLock();
            if (tryLock != 0) {
                try {
                    abf = n.gF(context).abf("install_status");
                    name = n.gF(context).abg("install_core_ver");
                    stringBuilder2 = n.gF(context).getStringValue("install_apk_path");
                    abg = n.gF(context).abg("copy_core_ver");
                    tryLock = n.gF(context).abf("copy_status");
                } finally {
                    z2 = zXM;
                    z2.unlock();
                }
            } else {
                tryLock = -1;
                stringBuilder2 = null;
                name = 0;
                abf = -1;
                abg = 0;
            }
            cEI();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + abf);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + name);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + stringBuilder2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + abg);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + tryLock);
            if (x.hq(context)) {
                abg = x.cEW();
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
                if (abg > 0) {
                    int gY = gY(context);
                    if (gY == abg) {
                        return;
                    }
                    if (x.cEQ() != null) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                        a(context, null);
                        return;
                    } else if (gY <= 0) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                        QbSdk.bG(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            int i = o.gG(context).zXm.getInt("tbs_responsecode", z2);
            boolean z3 = (i == 1 || i == 2 || i == 4) ? true : z2;
            if (!(z3 || i == 0)) {
                new Bundle().putInt("operation", 10001);
                if (context != null) {
                    Object obj = new Object[]{context, r4};
                    Message message = new Message();
                    message.what = 3;
                    message.obj = obj;
                    zXR.sendMessage(message);
                }
            }
            if (abf >= 0 && abf < 2) {
                s(context, stringBuilder2, name);
            }
            if (tryLock == 0) {
                ap(context, abg);
            }
        }
    }

    final void x(Context context, boolean z) {
        if (!QbSdk.zVK) {
            if (VERSION.SDK_INT < 8) {
                TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
                return;
            }
            try {
                if (!x.hq(context)) {
                    File hk = hk(context);
                    if (hk != null && hk.exists()) {
                        f.e(hk, false);
                        new File(hi(context), "x5.tbs").delete();
                    }
                }
            } catch (Throwable th) {
            }
            if (!gP(context)) {
                return;
            }
            if (bI(context, "core_unzip_tmp") && v(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
                return;
            }
            if (bI(context, "core_share_backup_tmp")) {
                cEG();
            }
            if (bI(context, "core_copy_tmp") && u(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
            } else {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
            }
        }
    }
}
