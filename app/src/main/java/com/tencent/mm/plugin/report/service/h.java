package com.tencent.mm.plugin.report.service;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcLogic.BaseInfo;
import com.tencent.mars.smc.SmcLogic.ICallBack;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.c.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class h implements ICallBack {
    public static IKVReportNotify pRc = null;

    public final void onReportDataReady(byte[] bArr, byte[] bArr2, int i) {
        try {
            if (pRc != null && bArr2 != null && bArr2.length > 0) {
                pRc.onReportKVDataReady(bArr, bArr2, i);
            }
        } catch (Exception e) {
            x.e("KVReportJni", e.getMessage());
        }
    }

    public final boolean onRequestGetStrategy(byte[] bArr, int i) {
        try {
            synchronized (this) {
                if (com.tencent.mm.plugin.report.b.h.isRunning()) {
                    x.i("KVReportJni", "already running");
                    return false;
                }
                g.Di().gPJ.a(new com.tencent.mm.plugin.report.b.h(), 0);
                return true;
            }
        } catch (Exception e) {
            x.e("KVReportJni", "onRequestGetStrategy error: " + e.getMessage());
            return false;
        }
    }

    public final boolean OnSelfMonitorOpLogReady(byte[] bArr) {
        g.Dh();
        if (a.Cx()) {
            try {
                k kVar = new k();
                kVar.aF(bArr);
                com.tencent.mm.bq.a toMMSelfMonitor = SmcProtoBufUtil.toMMSelfMonitor(kVar);
                if (toMMSelfMonitor.wsb <= 0) {
                    x.e("KVReportJni", "error selfmonitor count");
                    return true;
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EX().b(new e.a(202, toMMSelfMonitor));
                return true;
            } catch (Exception e) {
                x.e("KVReportJni", e.getMessage());
                return false;
            }
        }
        x.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
        return false;
    }

    public final int getSingleReportBufSizeB() {
        return 20480;
    }

    public final BaseInfo getKVCommReqBaseInfo() {
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.deviceModel = Build.MODEL + Build.CPU_ABI;
        baseInfo.deviceBrand = Build.BRAND;
        baseInfo.osName = "android-" + Build.MANUFACTURER;
        baseInfo.osVersion = VERSION.SDK_INT;
        baseInfo.languageVer = w.cfi();
        return baseInfo;
    }

    public final String getKVCommPath() {
        return AppLogic.getAppFilePath() + "/kvcomm/";
    }

    public static void Iy(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.SmcCallBack", "msg content is null");
            return;
        }
        x.i("MicroMsg.SmcCallBack", "receive msg: " + str);
        Map y = f.y(str, "sysmsg");
        if (y == null || y.size() == 0) {
            x.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + str);
            return;
        }
        String str2 = (String) y.get(".sysmsg.$type");
        if (bh.ov(str2) || !str2.equalsIgnoreCase("getkvidkeystg")) {
            x.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + str);
            return;
        }
        long j = bh.getLong((String) y.get(".sysmsg.getkvidkeystg.generalversion"), -1);
        long j2 = bh.getLong((String) y.get(".sysmsg.getkvidkeystg.specialversion"), -1);
        long j3 = bh.getLong((String) y.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1);
        long j4 = bh.getLong((String) y.get(".sysmsg.getkvidkeystg.timeinterval"), -1);
        long j5 = bh.getLong((String) y.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1);
        long j6 = bh.getLong((String) y.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1);
        long j7 = bh.getLong((String) y.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1);
        if (j == -1 || j2 == -1 || j3 == -1 || j4 == -1 || -1 == j5 || -1 == j6 || -1 == j7) {
            x.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + str);
            return;
        }
        x.i("MicroMsg.SmcCallBack", "plugin msg version:" + j + ", " + j2 + ", " + j3);
        SmcLogic.OnPluginMsg(j5, j6, j7, j, j2, j4);
    }
}
