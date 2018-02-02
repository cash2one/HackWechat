package com.tencent.mm.plugin.bbom;

import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.bc;

public final class h implements k {
    private String kvB = null;

    public h(String str) {
        this.kvB = str;
    }

    public final void a(ara com_tencent_mm_protocal_c_ara, au auVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append("<strangerantispamticket ticket=\"" + this.kvB + "\"></strangerantispamticket>");
        stringBuilder.append(bh.ou(bc.HC()));
        String str = (bh.ov(com_tencent_mm_protocal_c_ara.vHc) || !com_tencent_mm_protocal_c_ara.vHc.startsWith("<msgsource>")) ? "<msgsource></msgsource>" : com_tencent_mm_protocal_c_ara.vHc;
        com_tencent_mm_protocal_c_ara.vHc = str;
        com_tencent_mm_protocal_c_ara.vHc = com_tencent_mm_protocal_c_ara.vHc.replace("<msgsource>", stringBuilder.toString());
    }
}
