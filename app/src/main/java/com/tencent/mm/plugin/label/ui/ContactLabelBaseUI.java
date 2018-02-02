package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class ContactLabelBaseUI extends MMActivity {
    private ProgressDialog ltM;

    protected int getLayoutId() {
        return 0;
    }

    public final void Ds(String str) {
        getString(R.l.dGO);
        this.ltM = h.a((Context) this, str, true, new OnCancelListener(this) {
            final /* synthetic */ ContactLabelBaseUI nOH;

            {
                this.nOH = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().cancel(636);
            }
        });
    }

    public final void aUZ() {
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
    }

    public final void yE(String str) {
        h.a((Context) this, str, "", new OnClickListener(this) {
            final /* synthetic */ ContactLabelBaseUI nOH;

            {
                this.nOH = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
