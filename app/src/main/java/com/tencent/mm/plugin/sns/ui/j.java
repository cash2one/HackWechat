package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.f.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

public final class j {
    public static List<l> rrC = new LinkedList();
    private Context context;
    String gze;
    ClipboardManager mxl;
    protected ListView nKG;
    public av qZU;
    FrameLayout qZp;
    private String rrA = "";
    private boolean rrB = false;
    bh rrD;
    c rrE;
    b rrF;
    public com.tencent.mm.plugin.sns.ui.b.b rrG;
    r rrH = null;
    c rrI = new 2(this);
    OnLongClickListener rrJ = new 5(this);
    public g rrs;
    public at rrt;
    boolean rru;
    boolean rrv = false;
    SnsCommentFooter rrw;
    bi rrx;
    ao rry;
    private boolean rrz = false;

    public class a implements OnClickListener {
        private String gBL;
        private bjk qTX;
        final /* synthetic */ j rrK;
        private CharSequence rrR = "";
        private com.tencent.mm.plugin.sns.ui.a.a.c rrb;

        public a(j jVar, bjk com_tencent_mm_protocal_c_bjk, String str, CharSequence charSequence, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
            this.rrK = jVar;
            this.gBL = str;
            this.qTX = com_tencent_mm_protocal_c_bjk;
            this.rrb = cVar;
            this.rrR = charSequence;
        }

        public final void onClick(View view) {
            int i = 0;
            if (u.LH(this.rrb.fzW)) {
                this.rrb.rOa = view;
                if (this.qTX == null || this.qTX.vIy == null || !this.qTX.vIy.equals(this.rrK.gze)) {
                    m mVar = new m();
                    m xt = this.rrK.qZU.xt(this.rrb.position);
                    if (!xt.bve()) {
                        if (com.tencent.mm.plugin.sns.lucky.a.m.h(xt)) {
                            com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(742);
                            bjv n = ai.n(xt);
                            com.tencent.mm.modelsns.b ix = iu.mB(i.g(xt)).ix(xt.field_type).bU(xt.xl(32)).mB(xt.byA()).mB(this.qTX.wMw == 0 ? this.qTX.wMz : this.qTX.wMw).mB(this.qTX.vIy).ix(n == null ? 0 : n.wMY);
                            if (n != null) {
                                i = n.wNb;
                            }
                            ix.ix(i);
                            iu.Sx();
                            this.rrK.a(this.rrb, xt, this.rrK.context.getString(com.tencent.mm.plugin.sns.i.j.qLZ) + this.gBL, this.qTX);
                            return;
                        }
                        com.tencent.mm.plugin.sns.lucky.ui.a.e(this.rrb.rOg.getContext(), this.rrb.rOg.xy(0));
                        return;
                    }
                    return;
                }
                if (this.rrK.rrx.rMQ) {
                    this.rrK.bze();
                    this.rrK.rrx.rMQ = false;
                }
                com.tencent.mm.ui.widget.i iVar = new com.tencent.mm.ui.widget.i(this.rrK.context);
                OnCreateContextMenuListener 1 = new 1(this);
                p$d 2 = new 2(this);
                int[] iArr = new int[2];
                if (view.getTag(f.cSF) instanceof int[]) {
                    iArr = (int[]) view.getTag(f.cSF);
                }
                iVar.a(view, 1, 2, iArr[0], iArr[1]);
            }
        }
    }

    public j(Context context, int i, String str, int i2) {
        this.context = context;
        this.gze = q.FS();
        this.rrt = new at();
        this.rrt.qWT = new com.tencent.mm.plugin.sns.h.b(i, str, i2);
        this.rrG = new 1(this, (Activity) context, this.rrt);
        this.rrG.aUG();
        com.tencent.mm.sdk.b.a.xef.b(this.rrI);
    }

    private void bzd() {
        if (!this.rrz) {
            this.rrz = true;
            this.rrw.bAK();
            this.rrw.a(new 3(this));
            SnsCommentFooter snsCommentFooter = this.rrw;
            com.tencent.mm.ui.widget.MMEditText.a 4 = new 4(this);
            if (snsCommentFooter.okv != null) {
                snsCommentFooter.okv.ztP = 4;
            }
        }
    }

    final void bze() {
        if (this.rrz) {
            if (this.rrw.getVisibility() != 8) {
                this.rrw.setVisibility(8);
            }
            av avVar = this.qZU;
            if (avVar.rHs != null) {
                avVar.rHs.setVisibility(8);
            }
            avVar.rHs = null;
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, m mVar, bjk com_tencent_mm_protocal_c_bjk) {
        String str = cVar.fzW + "@";
        this.rrA = str;
        x.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.rrA + " " + cVar.fzW + " position:" + cVar.position);
        bzd();
        com.tencent.mm.kernel.g.Dk();
        String AQ = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(mVar.field_userName).AQ();
        this.rrw.setTag(mVar);
        this.rrw.setVisibility(0);
        this.rrw.b(AQ, com_tencent_mm_protocal_c_bjk);
        this.rrw.i(rrC, str);
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.context, 8);
        if (cVar.rOa != null) {
            fromDPToPix += cVar.rOc.getHeight() - cVar.rOa.getBottom();
            x.i("MicroMsg.BaseTimeLine", "comment item bottom = " + cVar.rOa.getBottom());
        } else {
            fromDPToPix = 0;
        }
        this.rrx.position = cVar.position;
        this.rrx.rMN = cVar.mUL.getHeight() - fromDPToPix;
        cVar.rOa = null;
        this.rrx.rMO = cVar.mUL.getTop();
        this.rrx.rzE = this.nKG.getBottom();
        x.e("MicroMsg.BaseTimeLine", "originalTop:" + this.rrx.rMO);
        bzf();
    }

    private void bzf() {
        if (!(this.context instanceof MMActivity) || ((MMActivity) this.context).mController.xJg == 1) {
            this.rrx.bCl();
        } else {
            this.rru = true;
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, m mVar, String str, bjk com_tencent_mm_protocal_c_bjk) {
        int i = 0;
        String str2 = cVar.fzW + str;
        this.rrA = str2;
        x.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.rrA + " " + cVar.fzW + " position:" + cVar.position);
        bzd();
        this.rrw.setTag(mVar);
        this.rrw.setVisibility(0);
        this.rrw.a(str, com_tencent_mm_protocal_c_bjk);
        this.rrw.i(rrC, str2);
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.context, 8);
        if (cVar.rOa != null) {
            i = (cVar.rOc.getHeight() - cVar.rOa.getBottom()) + fromDPToPix;
            x.i("MicroMsg.BaseTimeLine", "comment item bottom = " + cVar.rOa.getBottom());
        }
        this.rrx.position = cVar.position;
        this.rrx.rMN = cVar.mUL.getHeight() - i;
        cVar.rOa = null;
        this.rrx.rMO = cVar.mUL.getTop();
        this.rrx.rzE = this.nKG.getBottom();
        x.e("MicroMsg.BaseTimeLine", "originalTop:" + this.rrx.rMO);
        bzf();
    }
}
