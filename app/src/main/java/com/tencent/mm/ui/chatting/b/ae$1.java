package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ak.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class ae$1 implements d {
    final /* synthetic */ ae yCJ;

    ae$1(ae aeVar) {
        this.yCJ = aeVar;
    }

    public final void m(String str, final long j) {
        x.d("MicroMsg.ChattingUI.VoiceImp", "onVoiceRemind " + str + " time " + j);
        if (s.hb(ar.getNotification().wX())) {
            h.a(this.yCJ.fhr.csq().getContext(), false, str, this.yCJ.fhr.csq().getContext().getString(R.l.eTQ), this.yCJ.fhr.csq().getContext().getString(R.l.eTN), this.yCJ.fhr.csq().getContext().getString(R.l.eTP), new OnClickListener(this) {
                final /* synthetic */ ae$1 yCL;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ar.Hg();
                    if (c.Fa().K(ar.getNotification().wX(), j)) {
                        ar.Hg();
                        int c = c.Fa().c(ar.getNotification().wX(), j, this.yCL.yCJ.fhr.csy().hKb - this.yCL.yCJ.fhr.csy().getCount());
                        if (c >= 0 && this.yCL.yCJ.fhr.csy().getCount() > c) {
                            this.yCL.yCJ.fhr.csx().post(new 1(this, c));
                        }
                    }
                }
            }, null);
        }
    }
}
