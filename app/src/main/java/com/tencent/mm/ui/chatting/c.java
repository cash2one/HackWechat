package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.n;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;

public final class c implements OnClickListener, e, t {
    private ProgressDialog iln;
    private a yqd;

    static /* synthetic */ void a(c cVar, k kVar) {
        ar.CG().a(kVar, 0);
        Context thisActivity = cVar.yqd.thisActivity();
        cVar.yqd.getString(R.l.dGO);
        cVar.iln = h.a(thisActivity, cVar.yqd.getString(R.l.dHc), true, new 4(cVar, kVar));
    }

    public c(a aVar) {
        this.yqd = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        boolean z2 = false;
        if (view.getTag() == null) {
            x.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
        } else if (view.getTag() instanceof com.tencent.mm.ui.chatting.viewitems.ar) {
            com.tencent.mm.ui.chatting.viewitems.ar arVar = (com.tencent.mm.ui.chatting.viewitems.ar) view.getTag();
            if (arVar == null) {
                x.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
                return;
            }
            r1 = arVar.fEt.appId;
            if (bh.ov(r1)) {
                x.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
            } else if (g.aZ(r1, false) == null) {
                x.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = " + r1);
            } else {
                z2 = true;
            }
            if (z2) {
                int i;
                String hP;
                an.aRi().a(2, this);
                if (this.yqd.ysk) {
                    i = 2;
                } else {
                    i = 1;
                }
                r1 = this.yqd.crz();
                if (s.eV(r1)) {
                    hP = ba.hP(arVar.fEJ.field_content);
                } else {
                    hP = r1;
                }
                com.tencent.mm.y.g.a aVar = arVar.fEt;
                h.a(this.yqd.thisActivity(), this.yqd.getString(R.l.dFC), this.yqd.getString(R.l.dFD), this.yqd.getString(R.l.dCc), this.yqd.getString(R.l.eCQ), new 2(this, aVar, hP, i), new 3(this, aVar, hP, i));
            }
        } else if (view.getTag() instanceof n) {
            n nVar = (n) view.getTag();
            if (nVar == null) {
                x.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
            } else if (nVar == null || bh.ov(nVar.hcc) || nVar.fEJ == null) {
                String str = "MicroMsg.AppSpamClickListener";
                r1 = "wrong args, tag is null ? ";
                Object[] objArr = new Object[1];
                if (nVar != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.e(str, r1, objArr);
            } else {
                String[] strArr = new String[]{this.yqd.thisActivity().getString(R.l.eRa), this.yqd.thisActivity().getString(R.l.eRb), this.yqd.thisActivity().getString(R.l.dEn)};
                h.a(this.yqd.thisActivity(), null, strArr, null, true, new 1(this, nVar));
            }
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        x.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + i + ", errCode = " + i2);
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        an.aRi().b(2, this);
        if (i == 0 && i2 == 0) {
            h.bu(this.yqd.thisActivity(), this.yqd.getString(R.l.emR));
        } else if (!com.tencent.mm.ui.t.a.a(this.yqd.thisActivity(), i, i2, str, 4)) {
            Toast.makeText(this.yqd.thisActivity(), this.yqd.getString(R.l.emq, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        ar.CG().b(1030, (e) this);
        if (i == 0 && i2 == 0) {
            h.bu(this.yqd.thisActivity(), this.yqd.getString(R.l.emR));
            return;
        }
        Toast.makeText(this.yqd.thisActivity(), this.yqd.getString(R.l.eRc, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }
}
