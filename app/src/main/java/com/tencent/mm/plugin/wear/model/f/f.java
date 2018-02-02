package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.byh;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public final class f extends c {
    private String fpL;
    private int type;
    private String username;

    public f(String str, String str2, int i) {
        this.username = str;
        this.fpL = str2;
        this.type = i;
    }

    protected final void send() {
        com.tencent.mm.plugin.wear.model.f NH = a.bOt().thJ.NH(this.username);
        byh com_tencent_mm_protocal_c_byh = new byh();
        if (this.type == 1) {
            byg com_tencent_mm_protocal_c_byg = new byg();
            com_tencent_mm_protocal_c_byg.nkn = NH.id;
            com_tencent_mm_protocal_c_byg.ksU = this.username;
            com_tencent_mm_protocal_c_byg.kub = this.fpL;
            com_tencent_mm_protocal_c_byg.nje = ac.getContext().getString(R.l.eyW);
            Bitmap a = b.a(this.username, false, -1);
            if (a != null) {
                com_tencent_mm_protocal_c_byg.wYy = new com.tencent.mm.bq.b(h.M(a));
            }
            com_tencent_mm_protocal_c_byh.ksP.add(com_tencent_mm_protocal_c_byg);
        }
        try {
            a.bOt();
            r.a(20006, com_tencent_mm_protocal_c_byh.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearFriendCreateTask";
    }
}
