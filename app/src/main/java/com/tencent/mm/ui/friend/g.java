package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public final class g implements e {
    private Context context;
    private ProgressDialog kVi;
    String vmW = "";
    a zdu;
    private boolean zdv = true;

    public g(Context context, a aVar) {
        this.context = context;
        this.zdu = aVar;
        this.zdv = true;
    }

    public g(Context context, a aVar, byte b) {
        this.context = context;
        this.zdu = aVar;
        this.zdv = false;
    }

    public final void q(int[] iArr) {
        ar.CG().a(116, this);
        k aeVar = new ae(iArr);
        ar.CG().a(aeVar, 0);
        if (this.zdv) {
            Context context = this.context;
            this.context.getString(R.l.epY);
            this.kVi = h.a(context, this.context.getString(R.l.epW), true, new 1(this, aeVar));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 116) {
            if (this.kVi != null) {
                this.kVi.dismiss();
                this.kVi = null;
            }
            ar.CG().b(116, this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
                if (this.zdv) {
                    h.a(this.context, R.l.epV, R.l.dGO, new OnClickListener(this) {
                        final /* synthetic */ g zdx;

                        {
                            this.zdx = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.zdx.zdu.o(true, this.zdx.vmW);
                        }
                    });
                    return;
                } else {
                    this.zdu.o(true, this.vmW);
                    return;
                }
            }
            x.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
            this.zdu.o(false, this.vmW);
        }
    }
}
