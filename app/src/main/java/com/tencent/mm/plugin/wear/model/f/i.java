package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.byt;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;

public final class i extends c {
    private boolean tb = true;
    private ArrayList<Integer> tjd;

    public i(ArrayList<Integer> arrayList) {
        this.tjd = arrayList;
    }

    public final String getName() {
        return "WearCancelNotificationTask";
    }

    protected final void send() {
        x.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[]{this.tjd});
        byt com_tencent_mm_protocal_c_byt = new byt();
        if (this.tjd != null) {
            com_tencent_mm_protocal_c_byt.wYQ.addAll(this.tjd);
        }
        com_tencent_mm_protocal_c_byt.wYR = this.tb;
        try {
            a.bOt();
            r.a(20004, com_tencent_mm_protocal_c_byt.toByteArray(), false);
        } catch (IOException e) {
        }
    }
}
