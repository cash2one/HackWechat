package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.q;

public class SnsUploadConfigView extends LinearLayout implements e, a, b {
    private static String ffw = "com.tencent.mm";
    private Context context;
    private ProgressDialog nMb = null;
    boolean rFQ = false;
    private boolean rLA = false;
    aoy rLB = new aoy();
    com.tencent.mm.ui.i.a rLC = new com.tencent.mm.ui.i.a();
    ImageView rLs;
    ImageView rLt;
    ImageView rLu;
    private boolean rLv = false;
    boolean rLw = false;
    boolean rLx = false;
    private boolean rLy = false;
    private boolean rLz = true;

    static /* synthetic */ void k(SnsUploadConfigView snsUploadConfigView) {
        x.e("MicroMsg.SnsUploadConfigView", "dealWithRefreshTokenFail");
        if (snsUploadConfigView.rLw) {
            String string = snsUploadConfigView.getContext().getString(j.dGO);
            h.a(snsUploadConfigView.getContext(), snsUploadConfigView.getContext().getString(j.eel), string, new 3(snsUploadConfigView), null);
        }
        snsUploadConfigView.rLw = false;
        snsUploadConfigView.iM(false);
    }

    public SnsUploadConfigView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.context = context;
        View inflate = v.fv(context).inflate(g.qIh, this, true);
        this.rLs = (ImageView) inflate.findViewById(f.qFr);
        this.rLt = (ImageView) inflate.findViewById(f.qFt);
        this.rLu = (ImageView) inflate.findViewById(f.qFs);
        if (!com.tencent.mm.ar.b.PR()) {
            this.rLu.setVisibility(8);
        }
        if (!com.tencent.mm.ar.b.PT()) {
            this.rLt.setVisibility(8);
        }
        if (!q.Gr()) {
            this.rLs.setVisibility(8);
        }
        this.rLu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView rLD;

            public final void onClick(View view) {
                if (this.rLD.rLy || !this.rLD.rFQ) {
                    this.rLD.rLy = !this.rLD.rLy;
                    this.rLD.bCa();
                    return;
                }
                h.h(context, j.qMn, j.dGO);
            }
        });
        this.rLs.setOnClickListener(new 7(this));
        this.rLt.setOnClickListener(new 8(this));
    }

    public final void bBZ() {
        this.rLv = false;
        this.rLw = false;
        this.rLx = false;
        this.rLy = false;
        this.rLu.setImageResource(i.qJk);
        this.rLs.setImageResource(i.qJe);
        this.rLt.setImageResource(i.qJo);
    }

    final void bCa() {
        if (this.rLy) {
            boolean z;
            com.tencent.mm.kernel.g.Dk();
            int e = bh.e((Integer) com.tencent.mm.kernel.g.Dj().CU().get(9, null));
            if (e == 0) {
                h.a(getContext(), j.eNU, j.dGO, new 9(this), new 10(this));
            } else if (e != 0) {
                z = true;
                if (z) {
                    this.rLy = false;
                    return;
                } else {
                    this.rLu.setImageResource(i.qJl);
                    return;
                }
            }
            z = false;
            if (z) {
                this.rLu.setImageResource(i.qJl);
                return;
            } else {
                this.rLy = false;
                return;
            }
        }
        this.rLu.setImageResource(i.qJk);
    }

    final void iM(boolean z) {
        if (this.rLw) {
            boolean z2;
            if (q.Gt()) {
                z2 = true;
            } else {
                h.a(getContext(), j.eLp, j.dGO, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView rLD;

                    {
                        this.rLD = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        d.a(this.rLD.getContext(), ".ui.account.FacebookAuthUI", new Intent().putExtra("shake_music", true));
                    }
                }, new 12(this));
                z2 = false;
            }
            if (z2) {
                if (!(z || this.rLA || !q.Gt())) {
                    com.tencent.mm.sdk.b.b fqVar = new fq();
                    fqVar.fqI = new 2(this, fqVar);
                    com.tencent.mm.sdk.b.a.xef.a(fqVar, Looper.myLooper());
                }
                this.rLs.setImageResource(i.qJf);
                return;
            }
            this.rLw = false;
            return;
        }
        this.rLs.setImageResource(i.qJe);
    }

    final void bCb() {
        if (this.rLx) {
            boolean z;
            if (this.rLC.cyv()) {
                z = true;
            } else {
                h.a(getContext(), j.eNE, j.dGO, new 13(this), new 14(this));
                z = false;
            }
            if (z) {
                this.rLt.setImageResource(i.qJp);
                return;
            } else {
                this.rLx = false;
                return;
            }
        }
        this.rLt.setImageResource(i.qJo);
    }

    public final int bCc() {
        if (this.rFQ) {
            return 1;
        }
        return 0;
    }

    public final void iN(boolean z) {
        this.rFQ = z;
        if (z) {
            bBZ();
        }
    }

    public final int bCd() {
        int i = 0;
        if (this.rLv) {
            i = 1;
        }
        if (this.rLw) {
            i |= 2;
        }
        if (this.rLx) {
            i |= 8;
        }
        if (this.rLy) {
            return i | 4;
        }
        return i;
    }

    private void rF(int i) {
        h.a(getContext(), i, j.dGO, new 4(this), new 5(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || kVar == null) {
        }
    }

    public final void a(c cVar) {
        if (this.nMb != null) {
            this.nMb.cancel();
        }
        switch (6.nMz[cVar.ordinal()]) {
            case 1:
                this.rLx = true;
                rF(j.eRB);
                break;
            case 2:
                this.rLx = false;
                break;
            case 3:
                this.rLx = false;
                rF(j.eRA);
                break;
        }
        bCb();
    }

    public final void b(c cVar) {
        switch (6.nMz[cVar.ordinal()]) {
            case 3:
                this.rLx = false;
                break;
        }
        bCb();
    }
}
