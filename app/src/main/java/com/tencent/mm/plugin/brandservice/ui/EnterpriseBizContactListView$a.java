package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.bmp;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;

class EnterpriseBizContactListView$a implements e {
    public String kGs;
    i kGt;
    WeakReference<EnterpriseBizContactListView> kGu;
    r tipDialog;

    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ String gIx;
        final /* synthetic */ EnterpriseBizContactListView$a kGv;
        final /* synthetic */ Context val$context;

        AnonymousClass3(EnterpriseBizContactListView$a enterpriseBizContactListView$a, String str, Context context) {
            this.kGv = enterpriseBizContactListView$a;
            this.gIx = str;
            this.val$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            k cVar = new c(this.gIx, true);
            ar.CG().a(1394, this.kGv);
            ar.CG().a(cVar, 0);
            EnterpriseBizContactListView$a enterpriseBizContactListView$a = this.kGv;
            Context context = this.val$context;
            this.val$context.getString(R.l.dGO);
            enterpriseBizContactListView$a.tipDialog = h.a(context, this.val$context.getString(R.l.dHc), true, new 1(this, cVar));
        }
    }

    public EnterpriseBizContactListView$a(EnterpriseBizContactListView enterpriseBizContactListView) {
        this.kGu = new WeakReference(enterpriseBizContactListView);
    }

    protected final void finalize() {
        ar.CG().b(1394, this);
        super.finalize();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0 && kVar.getType() == 1394) {
            bmp bjq = ((c) kVar).bjq();
            bmq bjp = ((c) kVar).bjp();
            if (bjp == null || bjp.vNw == null || bjp.vNw.ret != 0) {
                if (bjp == null || bjp.vNw == null) {
                    x.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(kVar.getType())});
                    return;
                }
                x.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(bjp.vNw.ret)});
            } else if (bjq.wPS) {
                com.tencent.mm.sdk.e.c jS = f.jS(bjq.vNq);
                jS.field_brandFlag |= 1;
                a com_tencent_mm_protocal_c_ari = new ari();
                com_tencent_mm_protocal_c_ari.hvH = jS.field_brandFlag;
                com_tencent_mm_protocal_c_ari.ksU = bjq.vNq;
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, com_tencent_mm_protocal_c_ari));
                y.Mf().c(jS, new String[0]);
                ar.Hg();
                com.tencent.mm.z.c.Fd().WX(jS.field_username);
                ar.Hg();
                if (com.tencent.mm.z.c.Fd().Xi(jS.field_enterpriseFather) <= 0) {
                    ar.Hg();
                    com.tencent.mm.z.c.Fd().WX(jS.field_enterpriseFather);
                } else {
                    ar.Hg();
                    com.tencent.mm.z.c.Fc().Wt(jS.field_enterpriseFather);
                }
                EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) this.kGu.get();
                if (enterpriseBizContactListView != null) {
                    enterpriseBizContactListView.refresh();
                }
            }
        }
    }
}
