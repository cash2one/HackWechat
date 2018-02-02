package com.tencent.mm.ui.bindgooglecontact;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class BindGoogleContactIntroUI$2 implements OnClickListener {
    final /* synthetic */ BindGoogleContactIntroUI ykv;

    BindGoogleContactIntroUI$2(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        this.ykv = bindGoogleContactIntroUI;
    }

    public final void onClick(View view) {
        h.a(this.ykv.mController.xIM, true, this.ykv.getString(R.l.eRD), "", this.ykv.getString(R.l.eRC), this.ykv.getString(R.l.dEn), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ BindGoogleContactIntroUI$2 ykw;

            {
                this.ykw = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                BindGoogleContactIntroUI.b(this.ykw.ykv);
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ BindGoogleContactIntroUI$2 ykw;

            {
                this.ykw = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
