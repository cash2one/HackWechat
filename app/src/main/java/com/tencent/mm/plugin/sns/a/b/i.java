package com.tencent.mm.plugin.sns.a.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class i implements e {
    public static int qPA = 60;
    public static int qPB = 1800;
    public static int qPC = 43200;
    public static int qPx = 20480;
    public static int qPy = 30720;
    public static int qPz = 51200;
    private long qPD = 0;
    private bjt qPE = new bjt();
    private boolean qPF = false;
    private long qPG = 0;
    private int qPH = 0;
    private int qPw = 0;
    private Random random = new Random(System.currentTimeMillis());

    static /* synthetic */ void d(i iVar) {
        if (iVar.qPE.vGC.size() > 0) {
            x.i("MicroMsg.SnsLogMgr", "trigerSave " + iVar.qPE.vGC.size());
            ae.bvo().a(iVar.qPE);
            iVar.qPE.vGC.clear();
        }
    }

    static /* synthetic */ void e(i iVar) {
        int i;
        String str;
        int i2;
        if (bh.bA(iVar.qPG) >= 100 || iVar.qPH <= 0) {
            iVar.qPH = qPx;
            if (an.isWifi(ac.getContext())) {
                iVar.qPH = qPz;
            }
            if (an.is3G(ac.getContext()) || an.is4G(ac.getContext())) {
                iVar.qPH = qPy;
            }
            if (an.is2G(ac.getContext())) {
                iVar.qPH = qPx;
            }
            iVar.qPG = SystemClock.elapsedRealtime();
            i = iVar.qPH;
        } else {
            i = iVar.qPH;
        }
        List linkedList = new LinkedList();
        bjt dA = ae.bvo().dA(i, iVar.qPw);
        ano com_tencent_mm_protocal_c_ano;
        if (dA.vGC.size() == 0) {
            str = "read from memery";
            i2 = 0;
            while (iVar.qPE.vGC.size() > 0) {
                com_tencent_mm_protocal_c_ano = (ano) iVar.qPE.vGC.remove();
                if (com_tencent_mm_protocal_c_ano.wuv.oz.length + i2 >= i) {
                    break;
                }
                i2 += com_tencent_mm_protocal_c_ano.wuv.oz.length;
                linkedList.add(com_tencent_mm_protocal_c_ano);
            }
        } else {
            str = "read from db";
            i2 = 0;
            while (dA.vGC.size() > 0) {
                com_tencent_mm_protocal_c_ano = (ano) dA.vGC.remove();
                linkedList.add(com_tencent_mm_protocal_c_ano);
                i2 = com_tencent_mm_protocal_c_ano.wuv.oz.length + i2;
            }
        }
        String str2 = str;
        if (linkedList.size() == 0) {
            x.i("MicroMsg.SnsLogMgr", "nothing for report");
            return;
        }
        x.i("MicroMsg.SnsLogMgr", "size " + i2 + " " + linkedList.size() + " " + i + " logItemList.LogList.size  " + iVar.qPE.vGC.size() + " label:  " + str2);
        k eVar = new e(linkedList);
        g.Dk();
        g.Di().gPJ.a(eVar, 0);
    }

    public final void h(int i, Object... objArr) {
        ae.bvi().post(new 1(this, i, objArr));
        if (!this.qPF) {
            this.qPF = true;
            ae.bvi().postDelayed(new 2(this), 2000);
        }
    }

    public final void bub() {
        if (ae.qVo) {
            g.Dk();
            int intValue = ((Integer) g.Dj().CU().get(a.BUSINESS_SNS_ADLOG_CNTTIME_INT, Integer.valueOf(0))).intValue();
            g.Dk();
            int intValue2 = ((Integer) g.Dj().CU().get(a.BUSINESS_SNS_ADLOG_FREQUENCY_INT, Integer.valueOf(-1))).intValue();
            if (intValue2 > qPC || intValue2 < 0) {
                intValue2 = this.random.nextInt((qPB - qPA) + 1) + qPA;
            }
            if ((System.currentTimeMillis() / 1000) - ((long) intValue) > ((long) intValue2)) {
                intValue2 = 1;
            } else {
                intValue2 = 0;
            }
            if (intValue2 == 0) {
                buc();
                x.d("MicroMsg.SnsLogMgr", "pass report ");
                return;
            }
            p bvo = ae.bvo();
            String str = "select rowid from SnsReportKv order by rowid desc  limit 1";
            x.i("MicroMsg.SnsKvReportStg", " getLast " + str);
            Cursor a = bvo.hhp.a(str, null, 2);
            if (a.moveToFirst()) {
                intValue2 = a.getInt(0);
            } else {
                intValue2 = 0;
            }
            a.close();
            this.qPw = intValue2;
            bud();
            buc();
        }
    }

    private void buc() {
        ae.bvi().post(new 3(this));
    }

    private void bud() {
        ae.bvi().post(new 4(this));
    }

    public static String l(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            x.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = objArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[length]));
        return stringBuilder.toString();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 1802 && (kVar instanceof e)) {
            e eVar = (e) kVar;
            if (i == 0 && i2 == 0) {
                g.Dk();
                g.Dj().CU().a(a.BUSINESS_SNS_ADLOG_CNTTIME_INT, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                bud();
                return;
            }
            List<ano> list = eVar.jNH;
            p bvo = ae.bvo();
            bjt com_tencent_mm_protocal_c_bjt = new bjt();
            for (ano add : list) {
                com_tencent_mm_protocal_c_bjt.vGC.add(add);
            }
            bvo.a(com_tencent_mm_protocal_c_bjt);
        }
    }
}
