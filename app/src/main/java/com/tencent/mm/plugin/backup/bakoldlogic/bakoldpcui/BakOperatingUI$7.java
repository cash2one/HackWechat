package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.sdk.platformtools.x;

class BakOperatingUI$7 implements OnClickListener {
    final /* synthetic */ BakOperatingUI krW;

    BakOperatingUI$7(BakOperatingUI bakOperatingUI) {
        this.krW = bakOperatingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e aqm = a.aql().aqm();
        if (aqm.kqZ == 1) {
            aqm.kqV.resume();
        } else if (aqm.kqZ == 6) {
            aqm.kqW.resume();
        } else {
            x.e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", new Object[]{Integer.valueOf(aqm.kqZ)});
        }
    }
}
