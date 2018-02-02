package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.g.a.td;
import com.tencent.mm.g.a.te;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.chatting.f;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.Date;
import java.util.LinkedList;

public final class g extends b {
    int jRy = -1;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ g yHJ;
        final /* synthetic */ boolean yHb = true;

        AnonymousClass1(g gVar, boolean z) {
            this.yHJ = gVar;
        }

        public final void run() {
            Object linkedList = new LinkedList();
            ar.Hg();
            Cursor bG = c.Fa().bG(this.yHJ.jRw, this.yHJ.jRy);
            if (bG == null) {
                x.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
                return;
            }
            q hD;
            if (s.eV(this.yHJ.jRw)) {
                ar.Hg();
                hD = c.Fh().hD(this.yHJ.jRw);
            } else {
                hD = null;
            }
            long j = 0;
            while (bG.moveToNext()) {
                try {
                    long b;
                    cf auVar = new au();
                    auVar.b(bG);
                    String str = auVar.field_content;
                    if (str != null) {
                        a I = a.I(str, auVar.field_reserved);
                        if (g.lG(bh.VI(I.hcG)) || g.lG(auVar.getType())) {
                            Object obj;
                            String g = b.g(auVar, s.eV(this.yHJ.jRw));
                            af WO = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO(g);
                            String str2 = "";
                            if (hD != null) {
                                str2 = hD.gu(g);
                            }
                            a aVar;
                            if (g.lG(auVar.getType())) {
                                aVar = new a(this.yHJ, auVar.field_createTime, auVar.getType(), I.hce, auVar.field_msgId, WO.field_username, WO.AP(), WO.field_conRemark, str2);
                                b teVar = new te();
                                teVar.fLF.fEs = I.hcg;
                                com.tencent.mm.sdk.b.a.xef.m(teVar);
                                boolean z = auVar.field_isSend == 1 ? teVar.fLG.fLH : !teVar.fLG.fLH;
                                if (teVar.fLG.status == -2) {
                                    z = false;
                                }
                                if (z) {
                                    int i;
                                    int i2 = teVar.fLG.status;
                                    if (i2 <= 0) {
                                        i2 = I.hcd;
                                    }
                                    aVar.fpL = this.yHJ.mContext.getResources().getString(R.l.eQk, new Object[]{aVar.fpL});
                                    switch (i2) {
                                        case 1:
                                        case 7:
                                            i = -352966;
                                            break;
                                        case 3:
                                            i = -470621;
                                            break;
                                        case 4:
                                            i = -470621;
                                            break;
                                        case 5:
                                            i = -470621;
                                            break;
                                        case 6:
                                            i = -470621;
                                            break;
                                        default:
                                            i = -352966;
                                            break;
                                    }
                                    aVar.yHM = i;
                                    aVar.desc = g.a(this.yHJ, this.yHJ.mContext, auVar, I, z, i2);
                                    Context context = this.yHJ.mContext;
                                    if (I != null && context != null) {
                                        switch (i2) {
                                            case 1:
                                            case 7:
                                                i = R.k.dxf;
                                                break;
                                            case 3:
                                                i = R.k.dxg;
                                                break;
                                            case 4:
                                                i = R.k.dxh;
                                                break;
                                            case 5:
                                                i = R.k.dxg;
                                                break;
                                            case 6:
                                                i = R.k.dxe;
                                                break;
                                            default:
                                                i = R.k.dxf;
                                                break;
                                        }
                                    }
                                    i = R.k.dxf;
                                    aVar.iconRes = i;
                                    obj = aVar;
                                } else {
                                    x.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! pass this msg:%s", new Object[]{Long.valueOf(auVar.field_msgId)});
                                }
                            } else {
                                aVar = new a(this.yHJ, auVar.field_createTime, auVar.getType(), I.hcB, auVar.field_msgId, WO.field_username, WO.AP(), WO.field_conRemark, str2);
                                aVar.yHL = bh.VI(I.hcG);
                                a aVar2;
                                if (aVar.yHL == bh.VI("1001")) {
                                    aVar.fpL = this.yHJ.mContext.getResources().getString(R.l.eQi, new Object[]{aVar.fpL});
                                    aVar.desc = f.b(I, auVar.field_isSend == 1);
                                    aVar.yHM = f.d(I, auVar.field_isSend == 1);
                                    aVar.iconRes = f.a(I, auVar.field_isSend == 1);
                                    aVar2 = aVar;
                                } else {
                                    b tdVar = new td();
                                    tdVar.fLA.fLC = I.hcH;
                                    com.tencent.mm.sdk.b.a.xef.m(tdVar);
                                    aVar.fpL = this.yHJ.mContext.getResources().getString(R.l.eQj, new Object[]{aVar.fpL});
                                    aVar.desc = f.a(tdVar.fLB.fLD, tdVar.fLB.fLE, auVar.field_isSend == 1, I);
                                    int identifier = this.yHJ.mContext.getResources().getIdentifier(((com.tencent.mm.y.c) I.r(com.tencent.mm.y.c.class)).haV, "drawable", ac.getPackageName());
                                    aVar.iconRes = f.r(tdVar.fLB.fLD, tdVar.fLB.fLE, auVar.field_isSend == 1);
                                    if (aVar.iconRes <= 0) {
                                        aVar.iconRes = identifier;
                                    }
                                    aVar2 = aVar;
                                }
                            }
                            b = com.tencent.mm.ui.gridviewheaders.a.cxk().b(new Date(auVar.field_createTime));
                            if (j != b) {
                                linkedList.add(new com.tencent.mm.ui.chatting.a.b.c(auVar.field_createTime));
                            }
                            linkedList.add(obj);
                            j = b;
                        }
                    }
                    b = j;
                    j = b;
                } finally {
                    bG.close();
                }
            }
            this.yHJ.jRt.addAll(linkedList);
            this.yHJ.yHi = this.yHJ.jRt;
            linkedList.clear();
            ag.y(new 1(this));
        }
    }

    static /* synthetic */ String a(g gVar, Context context, au auVar, a aVar, boolean z, int i) {
        if (aVar == null || context == null) {
            return "";
        }
        switch (i) {
            case 1:
            case 7:
                ar.Hg();
                com.tencent.mm.l.a WN = c.EY().WN(auVar.field_talker);
                String AQ = WN != null ? WN.AQ() : auVar.field_talker;
                if (!z) {
                    return gVar.mContext.getString(R.l.dRn);
                }
                if (!bh.ov(aVar.hdn)) {
                    return aVar.hdn;
                }
                if (auVar.field_isSend != 1) {
                    return gVar.mContext.getString(R.l.dRs);
                }
                return gVar.mContext.getString(R.l.dRr, new Object[]{AQ});
            case 3:
                if (z) {
                    return bh.ov(aVar.hdn) ? ac.getContext().getString(R.l.dRm) : ac.getContext().getString(R.l.dRm) + "-" + aVar.hdn;
                } else {
                    return ac.getContext().getString(R.l.dRn);
                }
            case 4:
                if (z) {
                    return bh.ov(aVar.hdn) ? ac.getContext().getString(R.l.dRu) : ac.getContext().getString(R.l.dRu) + "-" + aVar.hdn;
                } else {
                    return ac.getContext().getString(R.l.dRt);
                }
            case 5:
                if (z) {
                    return bh.ov(aVar.hdn) ? ac.getContext().getString(R.l.dRp) : ac.getContext().getString(R.l.dRp) + "-" + aVar.hdn;
                } else {
                    return ac.getContext().getString(R.l.dRq);
                }
            case 6:
                return context.getResources().getString(R.l.dRo);
            default:
                return aVar.description;
        }
    }

    public g(Context context) {
        super(context);
    }

    public final int getType() {
        return 5;
    }

    public static boolean lG(int i) {
        return bh.VI("1001") == i || bh.VI("1002") == i || 419430449 == i;
    }

    public final void cur() {
        this.yHf.cuv();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dm().F(new AnonymousClass1(this, true));
    }

    public final String WW() {
        return this.mContext.getString(R.l.eIB);
    }

    public final String cuu() {
        return this.mContext.getString(R.l.eIB);
    }

    public final e cus() {
        return new 2(this);
    }

    public final t l(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dib, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) FD(i);
        if (bh.ov(aVar2.desc)) {
            bVar.iir.setVisibility(8);
        } else {
            bVar.iir.setVisibility(0);
            bVar.iir.setText(bh.az(aVar2.desc, ""));
        }
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 6);
        bVar.jCP.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        bVar.jCP.setImageResource(aVar2.iconRes);
        bVar.jCP.setBackgroundColor(aVar2.yHM);
    }
}
