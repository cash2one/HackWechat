package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.2;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.3;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class NormalUserFooterPreference$a$14 implements OnClickListener {
    final /* synthetic */ a pkC;

    NormalUserFooterPreference$a$14(a aVar) {
        this.pkC = aVar;
    }

    public final void onClick(View view) {
        a aVar = this.pkC;
        b soVar = new so();
        com.tencent.mm.sdk.b.a.xef.m(soVar);
        if (!NormalUserFooterPreference.a(aVar.pkA).field_username.equals(soVar.fKm.talker) && (soVar.fKm.fKo || soVar.fKm.fKp)) {
            Toast.makeText(NormalUserFooterPreference.b(aVar.pkA).mController.xIM, soVar.fKm.fKn ? R.l.dNq : R.l.dNr, 0).show();
            x.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
        } else if (!com.tencent.mm.p.a.aU(NormalUserFooterPreference.b(aVar.pkA))) {
            soVar = new ri();
            soVar.fJc.fJe = true;
            com.tencent.mm.sdk.b.a.xef.m(soVar);
            String str = soVar.fJd.fJg;
            if (bh.ov(str)) {
                aVar.bjG();
                return;
            }
            x.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: " + str);
            h.a(NormalUserFooterPreference.b(aVar.pkA), NormalUserFooterPreference.b(aVar.pkA).getString(R.l.eQx), "", NormalUserFooterPreference.b(aVar.pkA).getString(R.l.dFU), NormalUserFooterPreference.b(aVar.pkA).getString(R.l.dEn), new 2(aVar), new 3(aVar));
        }
    }
}
