package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.z.q;
import java.io.IOException;

public final class e extends c {
    protected final void send() {
        int size = ((h) g.h(h.class)).aZi().aZp().size();
        byd com_tencent_mm_protocal_c_byd = new byd();
        com_tencent_mm_protocal_c_byd.nkn = a.bOt().thJ.NH(q.FS()).id;
        com_tencent_mm_protocal_c_byd.fon = ac.getContext().getString(R.l.app_name);
        com_tencent_mm_protocal_c_byd.nje = ac.getContext().getString(R.l.eyu, new Object[]{Integer.valueOf(size)});
        try {
            a.bOt();
            r.a(20005, com_tencent_mm_protocal_c_byd.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearFailMsgCreateTask";
    }
}
