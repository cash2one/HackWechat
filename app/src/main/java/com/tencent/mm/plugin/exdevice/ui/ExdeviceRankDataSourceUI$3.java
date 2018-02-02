package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.b;
import com.tencent.mm.protocal.c.brs;
import java.util.List;

class ExdeviceRankDataSourceUI$3 implements Runnable {
    final /* synthetic */ ExdeviceRankDataSourceUI lWI;
    final /* synthetic */ List lWJ;

    ExdeviceRankDataSourceUI$3(ExdeviceRankDataSourceUI exdeviceRankDataSourceUI, List list) {
        this.lWI = exdeviceRankDataSourceUI;
        this.lWJ = list;
    }

    public final void run() {
        b b = ExdeviceRankDataSourceUI.b(this.lWI);
        List<brs> list = this.lWJ;
        b.lWM.clear();
        if (!(list == null || list.size() == 0)) {
            for (brs com_tencent_mm_protocal_c_brs : list) {
                if (com_tencent_mm_protocal_c_brs != null) {
                    b.lWM.add(ExdeviceRankDataSourceUI.a(com_tencent_mm_protocal_c_brs));
                }
            }
        }
        ExdeviceRankDataSourceUI.b(this.lWI).notifyDataSetChanged();
    }
}
