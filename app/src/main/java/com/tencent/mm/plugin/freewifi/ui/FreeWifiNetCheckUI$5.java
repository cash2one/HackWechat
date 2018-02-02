package com.tencent.mm.plugin.freewifi.ui;

import android.net.wifi.ScanResult;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.h.a;
import com.tencent.mm.protocal.c.bdx;
import com.tencent.mm.protocal.c.cn;
import java.util.LinkedList;
import java.util.List;

class FreeWifiNetCheckUI$5 implements a {
    final /* synthetic */ String mEN;
    final /* synthetic */ FreeWifiNetCheckUI mIe;

    FreeWifiNetCheckUI$5(FreeWifiNetCheckUI freeWifiNetCheckUI, String str) {
        this.mIe = freeWifiNetCheckUI;
        this.mEN = str;
    }

    public final void aQ(List<ScanResult> list) {
        if (list == null || list.size() == 0) {
            this.mIe.finish();
            FreeWifiNetCheckUI.c(this.mIe);
            return;
        }
        bdx com_tencent_mm_protocal_c_bdx = new bdx();
        com_tencent_mm_protocal_c_bdx.wJM = new LinkedList();
        for (ScanResult scanResult : list) {
            if (scanResult != null) {
                cn cnVar = new cn();
                cnVar.mac = scanResult.BSSID;
                cnVar.vHB = scanResult.level;
                cnVar.ssid = scanResult.SSID;
                com_tencent_mm_protocal_c_bdx.wJM.add(cnVar);
            }
        }
        k.a aLe = k.aLe();
        aLe.mCu = m.D(FreeWifiNetCheckUI.b(this.mIe));
        aLe.mCw = b.mCO.mDi;
        aLe.mCx = b.mCO.name;
        aLe.fCR = 9;
        aLe.aLg().aLf();
        new com.tencent.mm.plugin.freewifi.d.k(this.mEN, com_tencent_mm_protocal_c_bdx, 9, m.D(this.mIe.getIntent())).b(new 1(this));
    }
}
