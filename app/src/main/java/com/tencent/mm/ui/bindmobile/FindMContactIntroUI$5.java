package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class FindMContactIntroUI$5 implements OnClickListener {
    final /* synthetic */ FindMContactIntroUI ymj;

    FindMContactIntroUI$5(FindMContactIntroUI findMContactIntroUI) {
        this.ymj = findMContactIntroUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(true));
        b.oH("R200_100");
        Intent intent = new Intent();
        intent.putExtra("mobile_input_purpose", 4);
        intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(this.ymj));
        intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(this.ymj));
        intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(this.ymj));
        a.ifs.a(this.ymj, intent);
        b.oH("R300_300_phone");
        b.b(false, ar.CB() + "," + this.ymj.getClass().getName() + ",R300_200_phone," + ar.fH("R300_200_phone") + ",2");
    }
}
