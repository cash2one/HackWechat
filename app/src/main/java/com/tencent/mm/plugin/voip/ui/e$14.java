package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class e$14 implements OnClickListener {
    final /* synthetic */ e srL;

    e$14(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
        if (an.isWifi(this.srL.getActivity()) || (l.bHl() && !an.is2G(this.srL.getActivity()))) {
            e.e(this.srL);
        } else {
            h.a(this.srL.getActivity(), R.l.eVC, R.l.eVD, new 1(this), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ e$14 srO;

                {
                    this.srO = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    e.d(this.srO.srL);
                }
            });
        }
    }
}
