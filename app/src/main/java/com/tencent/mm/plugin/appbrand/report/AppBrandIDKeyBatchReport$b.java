package com.tencent.mm.plugin.appbrand.report;

import android.os.Build;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.protocal.c.bci;
import com.tencent.mm.protocal.c.cav;
import com.tencent.mm.protocal.c.caw;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

final class AppBrandIDKeyBatchReport$b {
    private static final ReentrantReadWriteLock jGW = new ReentrantReadWriteLock();
    private static volatile ak jGX = null;
    private static volatile int jGY;
    private static volatile ak jhS = null;

    static /* synthetic */ void c(cba com_tencent_mm_protocal_c_cba) {
        if (com_tencent_mm_protocal_c_cba != null) {
            c.Dm().F(new 4(com_tencent_mm_protocal_c_cba));
        }
    }

    static /* synthetic */ void d(cba com_tencent_mm_protocal_c_cba) {
        jGW.writeLock().lock();
        try {
            byte[] toByteArray = com_tencent_mm_protocal_c_cba.toByteArray();
            File file = new File(AppBrandIDKeyBatchReport.ajH());
            if (!file.exists()) {
                file.mkdir();
            }
            file = new File(AppBrandIDKeyBatchReport.ajI());
            if (!file.exists()) {
                file.createNewFile();
            }
            int length = toByteArray.length;
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DataOutputStream(byteArrayOutputStream).writeInt(length);
            e.d(AppBrandIDKeyBatchReport.ajI(), byteArrayOutputStream.toByteArray());
            e.d(AppBrandIDKeyBatchReport.ajI(), toByteArray);
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandIDKeyBatchReport", "appendToFile exception:%s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "", new Object[0]);
        } finally {
            jGW.writeLock().unlock();
        }
    }

    static /* synthetic */ void hc(int i) {
        int i2 = 60000;
        if (i > 0) {
            i2 = 60000 * i;
        }
        ajJ();
        ak akVar = new ak(new 2(), true);
        jhS = akVar;
        long j = (long) i2;
        akVar.J(j, j);
    }

    static /* synthetic */ void uj() {
        boolean z;
        final LinkedList ajK = ajK();
        if (bh.cA(ajK)) {
            z = false;
        } else {
            a aVar = new a();
            aVar.hmj = new cav();
            aVar.hmk = new caw();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
            aVar.hmi = HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION;
            aVar.hml = 0;
            aVar.hmm = 0;
            b JZ = aVar.JZ();
            bci com_tencent_mm_protocal_c_bci = new bci();
            com_tencent_mm_protocal_c_bci.ktz = Build.MANUFACTURER;
            com_tencent_mm_protocal_c_bci.wIy = 2;
            com_tencent_mm_protocal_c_bci.vOf = d.vAt;
            com_tencent_mm_protocal_c_bci.vOg = d.vAs;
            com_tencent_mm_protocal_c_bci.qxG = ac.getResources().getDisplayMetrics().widthPixels;
            com_tencent_mm_protocal_c_bci.wIz = ac.getResources().getDisplayMetrics().heightPixels;
            com_tencent_mm_protocal_c_bci.vOh = d.vAv;
            com_tencent_mm_protocal_c_bci.vOi = d.vAw;
            com_tencent_mm_protocal_c_bci.wIA = ac.getResources().getConfiguration().locale.getLanguage();
            ((cav) JZ.hmg.hmo).xaf = com_tencent_mm_protocal_c_bci;
            ((cav) JZ.hmg.hmo).xae = ajK;
            u.a(JZ, new u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (i == 0 && i2 == 0) {
                        AppBrandIDKeyBatchReport$b.jGY = ((caw) bVar.hmh.hmo).xag;
                        AppBrandIDKeyBatchReport$b.hc(AppBrandIDKeyBatchReport$b.jGY);
                    } else {
                        Iterator it = ajK.iterator();
                        while (it.hasNext()) {
                            AppBrandIDKeyBatchReport$b.d((cba) it.next());
                        }
                    }
                    return 0;
                }
            }, true);
            z = true;
        }
        if (z) {
            int i = jGY;
            i = i <= 0 ? 300000 : (i + 5) * 60000;
            if (jGX != null) {
                jGX.TG();
                jGX = null;
            }
            ak akVar = new ak(new 1(), false);
            jGX = akVar;
            long j = (long) i;
            akVar.J(j, j);
        }
    }

    private static void ajJ() {
        if (jhS != null) {
            jhS.TG();
            jhS = null;
        }
    }

    private static LinkedList<cba> ajK() {
        ReadLock readLock = null;
        jGW.readLock().lock();
        try {
            File file = new File(AppBrandIDKeyBatchReport.ajI());
            if (file.exists()) {
                LinkedList<cba> linkedList = new LinkedList();
                long length = file.length();
                int i = 0;
                while (true) {
                    byte[] d = e.d(AppBrandIDKeyBatchReport.ajI(), i, 4);
                    if (d != null) {
                        int readInt = new DataInputStream(new ByteArrayInputStream(d)).readInt();
                        d = e.d(AppBrandIDKeyBatchReport.ajI(), i + 4, readInt);
                        if (bh.bw(d)) {
                            break;
                        }
                        linkedList.add((cba) new cba().aF(d));
                        int i2 = (readInt + 4) + i;
                        if (((long) i2) >= length) {
                            break;
                        }
                        i = i2;
                    } else {
                        x.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
                        jGW.readLock().unlock();
                        ajL();
                        return null;
                    }
                }
                jGW.readLock().unlock();
                ajL();
                return linkedList;
            }
            x.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
            return readLock;
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "readReportData()", new Object[0]);
            return readLock;
        } finally {
            readLock = jGW.readLock();
            readLock.unlock();
            ajL();
        }
    }

    private static void ajL() {
        jGW.writeLock().lock();
        try {
            com.tencent.mm.loader.stub.b.deleteFile(AppBrandIDKeyBatchReport.ajI());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "removeFile()", new Object[0]);
        }
        jGW.writeLock().unlock();
    }
}
