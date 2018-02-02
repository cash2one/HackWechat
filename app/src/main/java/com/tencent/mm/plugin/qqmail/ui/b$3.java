package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class b$3 implements OnClickListener {
    final /* synthetic */ b pst;
    final /* synthetic */ y psu;
    final /* synthetic */ LinearLayout psv;

    b$3(b bVar, y yVar, LinearLayout linearLayout) {
        this.pst = bVar;
        this.psu = yVar;
        this.psv = linearLayout;
    }

    public final void onClick(View view) {
        h.a(this.pst.psk, R.l.eAi, R.l.dGO, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ b$3 psw;

            {
                this.psw = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.psw.psu.state == 0 || this.psw.psu.state == 1) {
                    b bVar = this.psw.pst;
                    y yVar = this.psw.psu;
                    if (bVar.mode == 5) {
                        w.bks().cancel(yVar.ppZ);
                    } else if (bVar.mode == 6) {
                        o oVar = (o) bVar.psn.get(yVar.path);
                        if (oVar != null) {
                            ar.CG().c(oVar);
                        }
                        bVar.pso.remove(yVar.path);
                        bVar.psp.remove(yVar.path);
                    }
                }
                this.psw.pst.psm.remove(this.psw.psu.path);
                this.psw.pst.psn.remove(this.psw.psu.path);
                this.psw.pst.pso.remove(this.psw.psu.path);
                this.psw.pst.psp.remove(this.psw.psu.path);
                this.psw.pst.psl.removeView(this.psw.psv);
                this.psw.pst.bkR();
            }
        }, null);
    }
}
