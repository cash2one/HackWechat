package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;

class BakOperatingUI$6 implements OnClickListener {
    final /* synthetic */ BakOperatingUI krW;

    BakOperatingUI$6(BakOperatingUI bakOperatingUI) {
        this.krW = bakOperatingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e aqm = a.aql().aqm();
        aqm.kqV.cancel();
        aqm.kqW.cancel();
        if (aqm.kqZ == 1 || aqm.krd == 2) {
            e.mS(4);
        } else if (aqm.kqZ == 6 || aqm.krd == 4 || aqm.krd == 6) {
            e.mS(7);
        }
        a.aql().aqm().krc = -1;
        c aqn = a.aql().aqn();
        aqn.kqH++;
        BakOperatingUI.b(this.krW);
        BakOperatingUI.g(this.krW);
    }
}
