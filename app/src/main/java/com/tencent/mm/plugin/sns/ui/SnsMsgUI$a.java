package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.l.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SnsMsgUI$a extends o<i> {
    int hKb = this.kUH;
    protected f kBC;
    protected c kBD;
    protected d kBF = new 1(this);
    int kUH = 10;
    private Set<MMSlideDelView> nKM = new HashSet();
    final /* synthetic */ SnsMsgUI rDE;
    protected e rDI;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (i) obj;
        if (obj == null) {
            obj = new i();
            x.d("MicroMsg.SnsMsgUI", "new SnsComment");
        }
        obj.b(cursor);
        return obj;
    }

    public SnsMsgUI$a(SnsMsgUI snsMsgUI, Context context, i iVar) {
        this.rDE = snsMsgUI;
        super(context, iVar);
    }

    public final long getItemId(int i) {
        return ((i) getItem(i)).field_snsID;
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    public final void a(f fVar) {
        this.kBC = fVar;
    }

    public final void b(e eVar) {
        this.rDI = eVar;
    }

    public final void a(c cVar) {
        this.kBD = cVar;
    }

    public final synchronized void a(String str, l lVar) {
        super.a(str, lVar);
    }

    public final void Xy() {
        if (ae.bvA().Tq() <= 0 || SnsMsgUI.n(this.rDE)) {
            this.hKb = ae.bvA().byc();
            j bvA = ae.bvA();
            String str = j.bya() + " where isSend = 0 order by createTime desc LIMIT " + this.kUH;
            x.v("MicroMsg.SnsCommentStorage", "getCursor sql:" + str);
            setCursor(bvA.hhp.a(str, null, 0));
        } else {
            setCursor(ae.bvA().byb());
        }
        notifyDataSetChanged();
    }

    public final boolean awe() {
        return this.kUH >= this.hKb;
    }

    public final int awf() {
        if (awe()) {
            if (SnsMsgUI.g(this.rDE).getParent() != null) {
                SnsMsgUI.b(this.rDE).removeFooterView(SnsMsgUI.g(this.rDE));
            }
            return 0;
        }
        this.kUH += 10;
        if (this.kUH <= this.hKb) {
            return 10;
        }
        this.kUH = this.hKb;
        return this.hKb % 10;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence AQ;
        String str;
        Object obj;
        TextView textView;
        long j;
        com.tencent.mm.plugin.sns.storage.e eK;
        com.tencent.mm.storage.x WM;
        com.tencent.mm.ui.widget.e eVar;
        akb com_tencent_mm_protocal_c_akb;
        m mVar;
        List list;
        Object obj2;
        int i2;
        MMImageView mMImageView;
        int i3;
        i iVar = (i) getItem(i);
        if (view == null || !(view.getTag() instanceof a)) {
            View view2 = (MMSlideDelView) v.fv(this.context).inflate(g.daY, null);
            View inflate = v.fv(this.context).inflate(g.qHC, null);
            a aVar2 = new a(this);
            aVar2.rDK = (ImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qEN);
            aVar2.pjY = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qEU);
            aVar2.rDN = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qEO);
            aVar2.rDM = (ImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qES);
            aVar2.lUD = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qEV);
            aVar2.rDO = (MMImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qEQ);
            aVar2.rDL = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qEW);
            aVar2.rDO.setOnClickListener(SnsMsgUI.o(this.rDE));
            aVar2.kBM = view2.findViewById(com.tencent.mm.plugin.sns.i.f.cOC);
            aVar2.kBN = (TextView) view2.findViewById(com.tencent.mm.plugin.sns.i.f.cOD);
            aVar2.rDP = (ImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qFp);
            view2.setView(inflate);
            view2.kBC = this.kBC;
            view2.kBD = this.kBD;
            view2.kBF = this.kBF;
            view2.mAK = false;
            view2.setTag(aVar2);
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.rDO.setTag(null);
        aVar.qQJ = iVar.field_snsID;
        aVar.kBM.setTag(Integer.valueOf(iVar.roN));
        aVar.kBM.setOnClickListener(new 2(this));
        String str2 = "";
        bje com_tencent_mm_protocal_c_bje = (bje) new bje().aF(iVar.field_curActionBuf);
        String str3;
        a WO;
        m eR;
        TextView textView2;
        int i4;
        Drawable b;
        String str4;
        akb com_tencent_mm_protocal_c_akb2;
        com.tencent.mm.plugin.sns.storage.e eK2;
        com.tencent.mm.sdk.e.c iVar2;
        try {
            str3 = ((bje) new bje().aF(iVar.field_refActionBuf)).wFM;
            try {
                if (bh.ov(str3) || str3.equals(ae.bvb())) {
                    str2 = "";
                    try {
                        if (bh.ov(com_tencent_mm_protocal_c_bje.wFM)) {
                            b.a(aVar.rDK, com_tencent_mm_protocal_c_bje.wFM);
                            aVar.rDK.setOnClickListener(new 3(this, com_tencent_mm_protocal_c_bje.wFM));
                        } else {
                            x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                        }
                        WO = SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                        if (WO == null) {
                            AQ = WO.AQ();
                        } else if (bh.ov(com_tencent_mm_protocal_c_bje.wMt)) {
                            AQ = com_tencent_mm_protocal_c_bje.wMt;
                        } else {
                            AQ = com_tencent_mm_protocal_c_bje.wFM;
                        }
                        aVar.pjY.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, AQ, aVar.pjY.getTextSize()));
                        eR = ae.bvv().eR(iVar.field_snsID);
                        if (eR == null && eR.field_type == 21) {
                            aVar.pjY.setTextColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.lnI));
                        } else {
                            aVar.pjY.setTextColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btR));
                        }
                        str = com_tencent_mm_protocal_c_bje.wFM;
                        textView2 = aVar.pjY;
                        i4 = com_tencent_mm_protocal_c_bje.vHW;
                        switch (iVar.field_type) {
                            case 1:
                            case 2:
                                obj = null;
                                break;
                            case 3:
                            case 5:
                                obj = 1;
                                break;
                            case 4:
                                obj = null;
                                break;
                            case 7:
                            case 8:
                            case 13:
                            case 14:
                                obj = null;
                                break;
                            default:
                                obj = 1;
                                break;
                        }
                        if (obj != null || SnsMsgUI.q(this.rDE).equals(str)) {
                            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        } else {
                            Drawable b2;
                            switch (i4) {
                                case 18:
                                    b2 = com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qzB);
                                    break;
                                case 22:
                                case 23:
                                case 24:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                    b2 = com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qzD);
                                    break;
                                case 25:
                                    b2 = com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qzz);
                                    break;
                                case 30:
                                    b2 = com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qzA);
                                    break;
                                default:
                                    b2 = com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qzC);
                                    break;
                            }
                            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, b2, null);
                        }
                        textView = aVar.rDN;
                        j = iVar.field_snsID;
                        if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                            textView.setTextColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                            textView.setBackgroundDrawable(null);
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            textView.setText("");
                            textView.setCompoundDrawablePadding(0);
                            switch (com_tencent_mm_protocal_c_bje.ktN) {
                                case 1:
                                case 5:
                                    eR = ae.bvv().eR(iVar.field_snsID);
                                    if (eR != null || eR.field_type != 7) {
                                        b = com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qIK);
                                        if (eR == null && eR.field_type == 21) {
                                            b.setColorFilter(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyA), Mode.SRC_ATOP);
                                        } else {
                                            b.clearColorFilter();
                                        }
                                        b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                        AQ = new SpannableString(" ");
                                        AQ.setSpan(new ImageSpan(b), 0, 1, 18);
                                        textView.setText(AQ);
                                        textView.setContentDescription(this.rDE.mController.xIM.getString(com.tencent.mm.plugin.sns.i.j.qKO));
                                        break;
                                    }
                                    textView.setText(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qLy));
                                    break;
                                    break;
                                case 2:
                                case 3:
                                    str4 = com_tencent_mm_protocal_c_bje.nje;
                                    str3 = "";
                                    eK = ae.bvy().eK(iVar.field_snsID);
                                    if (com_tencent_mm_protocal_c_bje.wMB != 1) {
                                        if (eK != null) {
                                            com.tencent.mm.kernel.g.Dk();
                                            WM = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(eK.field_userName);
                                            str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLI, new Object[]{WM.AQ()});
                                        }
                                    } else if (!bh.ov(str2)) {
                                        str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLJ, new Object[]{str2});
                                    }
                                    textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, str3 + str4 + " ", textView.getTextSize()));
                                    break;
                                case 4:
                                    textView.setText(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qMy));
                                    break;
                                case 7:
                                    textView.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qIK), null, null, null);
                                    textView.setContentDescription(this.rDE.mController.xIM.getString(com.tencent.mm.plugin.sns.i.j.qKO));
                                    break;
                                case 8:
                                    str3 = "";
                                    str4 = com_tencent_mm_protocal_c_bje.nje;
                                    eK = ae.bvy().eK(iVar.field_snsID);
                                    if (com_tencent_mm_protocal_c_bje.wMB != 1) {
                                        if (eK != null) {
                                            com.tencent.mm.kernel.g.Dk();
                                            WM = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(eK.field_userName);
                                            str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLI, new Object[]{WM.AQ()});
                                        }
                                    } else if (!bh.ov(str2)) {
                                        str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLJ, new Object[]{str2});
                                    }
                                    textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, str3 + str4 + " ", textView.getTextSize()));
                                    break;
                                case 13:
                                    com_tencent_mm_protocal_c_akb2 = new akb();
                                    x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
                                    try {
                                        com_tencent_mm_protocal_c_akb2.aF(n.a(com_tencent_mm_protocal_c_bje.wMA));
                                        x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_akb2.fLR);
                                    } catch (Exception e) {
                                        x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e.getMessage());
                                    }
                                    SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                                    b = null;
                                    if (com_tencent_mm_protocal_c_akb2.fLR != 0) {
                                        SnsMsgUI.b(this.rDE, true);
                                        AQ = new SpannableString(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJB));
                                    } else {
                                        SnsMsgUI.b(this.rDE, false);
                                        AQ = new SpannableString(" " + this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJA, new Object[]{bh.t(((double) com_tencent_mm_protocal_c_akb2.fLR) / 100.0d)}));
                                        b = this.rDE.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qyT);
                                    }
                                    if (b != null) {
                                        b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                        eVar = new com.tencent.mm.ui.widget.e(b, 1);
                                        eVar.zsZ = (int) (((((float) b.getIntrinsicHeight()) - textView.getTextSize()) + ((float) com.tencent.mm.bv.a.fromDPToPix(this.rDE, 2))) / 2.0f);
                                        AQ.setSpan(eVar, 0, 1, 33);
                                    }
                                    textView.setText(AQ);
                                    break;
                                case 14:
                                    com_tencent_mm_protocal_c_akb = new akb();
                                    x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
                                    try {
                                        com_tencent_mm_protocal_c_akb.aF(n.a(com_tencent_mm_protocal_c_bje.wMA));
                                        x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_akb.fLR);
                                    } catch (Exception e2) {
                                        x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e2.getMessage());
                                    }
                                    WO = SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                                    textView.setText(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJz, new Object[]{WO.AQ(), bh.t(((double) com_tencent_mm_protocal_c_akb.fLR) / 100.0d)}));
                                    break;
                                default:
                                    break;
                            }
                        }
                        textView.setText(com.tencent.mm.plugin.sns.i.j.qLF);
                        textView.setBackgroundColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyu));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        aVar.lUD.setText(az.k(this.rDE, ((long) com_tencent_mm_protocal_c_bje.pbl) * 1000));
                        eR = null;
                        if (com_tencent_mm_protocal_c_bje.ktN != 7 || com_tencent_mm_protocal_c_bje.ktN == 8) {
                            eK2 = ae.bvy().eK(iVar.field_snsID);
                            if (eK2 != null) {
                                eR = eK2.bxX();
                            }
                            mVar = eR;
                        } else {
                            mVar = ae.bvv().eR(iVar.field_snsID);
                        }
                        aVar.rDO.setVisibility(8);
                        aVar.rDL.setVisibility(8);
                        aVar.rDP.setVisibility(8);
                        aVar.rDO.setImageBitmap(null);
                        ae.bvs().cw(aVar.rDO);
                        if (mVar == null) {
                            list = mVar.bxV().wQo.vYd;
                            if (mVar.field_type != 2) {
                                aVar.rDO.setTag(null);
                                aVar.rDL.setVisibility(0);
                                aVar.rDL.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, mVar.bxV().wQl, aVar.rDL.getTextSize()));
                            } else {
                                obj2 = null;
                                if (list.size() > 0) {
                                    i2 = mVar.field_type;
                                    mMImageView = aVar.rDO;
                                    i3 = -1;
                                    switch (i2) {
                                        case 1:
                                            i3 = com.tencent.mm.plugin.sns.i.e.byV;
                                            break;
                                        case 2:
                                            mMImageView.setImageDrawable(null);
                                            break;
                                        case 3:
                                            i3 = com.tencent.mm.plugin.sns.i.i.dvD;
                                            break;
                                        case 4:
                                            i3 = com.tencent.mm.plugin.sns.i.i.dvn;
                                            break;
                                        case 5:
                                            i3 = com.tencent.mm.plugin.sns.i.i.dvA;
                                            break;
                                        case 6:
                                            i3 = com.tencent.mm.plugin.sns.i.i.dvm;
                                            break;
                                        case 7:
                                            i3 = com.tencent.mm.plugin.sns.i.e.byV;
                                            break;
                                        case 8:
                                            mMImageView.setImageDrawable(null);
                                            break;
                                        default:
                                            i3 = com.tencent.mm.plugin.sns.i.i.dvD;
                                            break;
                                    }
                                    ae.bvs().b((aqr) list.get(0), aVar.rDO, i3, this.rDE.hashCode(), an.xyW);
                                    if (mVar.field_type != 15 || (mVar.field_type == 27 && list.size() > 0 && ((aqr) list.get(0)).ktN == 6)) {
                                        aVar.rDP.setVisibility(0);
                                        iVar2 = new i();
                                        ae.bvA().b(iVar.xjy, iVar2);
                                        aVar.rDO.setTag(iVar2);
                                        obj2 = 1;
                                    } else {
                                        ap apVar = new ap();
                                        apVar.fus = mVar.byq();
                                        apVar.index = 0;
                                        List arrayList = new ArrayList();
                                        arrayList.add(aVar.rDO);
                                        apVar.rBS = arrayList;
                                        apVar.position = i;
                                        aVar.rDO.setTag(apVar);
                                        i2 = 1;
                                    }
                                }
                                mMImageView = aVar.rDO;
                                if (obj2 == null) {
                                    i2 = 0;
                                } else {
                                    i2 = 8;
                                }
                                mMImageView.setVisibility(i2);
                            }
                        } else if (!(com_tencent_mm_protocal_c_bje.ktN == 7 || com_tencent_mm_protocal_c_bje.ktN == 8 || !p.ev(iVar.field_snsID))) {
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Di().gPJ.a(new p(iVar.field_snsID), 0);
                        }
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.SnsMsgUI", e3, "", new Object[0]);
                    }
                    obj2 = (aVar.rDO.getVisibility() != 0 || aVar.rDP.getVisibility() == 0) ? 1 : null;
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.qET).setVisibility(obj2 == null ? 0 : 8);
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.qFq).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                    return view;
                }
                a WO2 = SnsMsgUI.p(this.rDE).WO(str3);
                if (!(WO2 == null || bh.ov(WO2.AQ()))) {
                    str3 = WO2.AQ();
                }
                str2 = str3;
                if (bh.ov(com_tencent_mm_protocal_c_bje.wFM)) {
                    x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                } else {
                    b.a(aVar.rDK, com_tencent_mm_protocal_c_bje.wFM);
                    aVar.rDK.setOnClickListener(new 3(this, com_tencent_mm_protocal_c_bje.wFM));
                }
                WO = SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                if (WO == null) {
                    AQ = WO.AQ();
                } else if (bh.ov(com_tencent_mm_protocal_c_bje.wMt)) {
                    AQ = com_tencent_mm_protocal_c_bje.wFM;
                } else {
                    AQ = com_tencent_mm_protocal_c_bje.wMt;
                }
                aVar.pjY.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, AQ, aVar.pjY.getTextSize()));
                eR = ae.bvv().eR(iVar.field_snsID);
                if (eR == null) {
                }
                aVar.pjY.setTextColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btR));
                str = com_tencent_mm_protocal_c_bje.wFM;
                textView2 = aVar.pjY;
                i4 = com_tencent_mm_protocal_c_bje.vHW;
                switch (iVar.field_type) {
                    case 1:
                    case 2:
                        obj = null;
                        break;
                    case 3:
                    case 5:
                        obj = 1;
                        break;
                    case 4:
                        obj = null;
                        break;
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                        obj = null;
                        break;
                    default:
                        obj = 1;
                        break;
                }
                if (obj != null) {
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView = aVar.rDN;
                j = iVar.field_snsID;
                if ((iVar.field_commentflag & 1) <= 0) {
                }
                if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                    textView.setTextColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                    textView.setBackgroundDrawable(null);
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView.setText("");
                    textView.setCompoundDrawablePadding(0);
                    switch (com_tencent_mm_protocal_c_bje.ktN) {
                        case 1:
                        case 5:
                            eR = ae.bvv().eR(iVar.field_snsID);
                            if (eR != null) {
                                break;
                            }
                            b = com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qIK);
                            if (eR == null) {
                                break;
                            }
                            b.clearColorFilter();
                            b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                            AQ = new SpannableString(" ");
                            AQ.setSpan(new ImageSpan(b), 0, 1, 18);
                            textView.setText(AQ);
                            textView.setContentDescription(this.rDE.mController.xIM.getString(com.tencent.mm.plugin.sns.i.j.qKO));
                            break;
                        case 2:
                        case 3:
                            str4 = com_tencent_mm_protocal_c_bje.nje;
                            str3 = "";
                            eK = ae.bvy().eK(iVar.field_snsID);
                            if (com_tencent_mm_protocal_c_bje.wMB != 1) {
                                if (bh.ov(str2)) {
                                    str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLJ, new Object[]{str2});
                                }
                            } else if (eK != null) {
                                com.tencent.mm.kernel.g.Dk();
                                WM = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(eK.field_userName);
                                str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLI, new Object[]{WM.AQ()});
                            }
                            textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, str3 + str4 + " ", textView.getTextSize()));
                            break;
                        case 4:
                            textView.setText(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qMy));
                            break;
                        case 7:
                            textView.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qIK), null, null, null);
                            textView.setContentDescription(this.rDE.mController.xIM.getString(com.tencent.mm.plugin.sns.i.j.qKO));
                            break;
                        case 8:
                            str3 = "";
                            str4 = com_tencent_mm_protocal_c_bje.nje;
                            eK = ae.bvy().eK(iVar.field_snsID);
                            if (com_tencent_mm_protocal_c_bje.wMB != 1) {
                                if (bh.ov(str2)) {
                                    str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLJ, new Object[]{str2});
                                }
                            } else if (eK != null) {
                                com.tencent.mm.kernel.g.Dk();
                                WM = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(eK.field_userName);
                                str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLI, new Object[]{WM.AQ()});
                            }
                            textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, str3 + str4 + " ", textView.getTextSize()));
                            break;
                        case 13:
                            com_tencent_mm_protocal_c_akb2 = new akb();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
                            com_tencent_mm_protocal_c_akb2.aF(n.a(com_tencent_mm_protocal_c_bje.wMA));
                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_akb2.fLR);
                            SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                            b = null;
                            if (com_tencent_mm_protocal_c_akb2.fLR != 0) {
                                SnsMsgUI.b(this.rDE, false);
                                AQ = new SpannableString(" " + this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJA, new Object[]{bh.t(((double) com_tencent_mm_protocal_c_akb2.fLR) / 100.0d)}));
                                b = this.rDE.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qyT);
                            } else {
                                SnsMsgUI.b(this.rDE, true);
                                AQ = new SpannableString(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJB));
                            }
                            if (b != null) {
                                b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                eVar = new com.tencent.mm.ui.widget.e(b, 1);
                                eVar.zsZ = (int) (((((float) b.getIntrinsicHeight()) - textView.getTextSize()) + ((float) com.tencent.mm.bv.a.fromDPToPix(this.rDE, 2))) / 2.0f);
                                AQ.setSpan(eVar, 0, 1, 33);
                            }
                            textView.setText(AQ);
                            break;
                        case 14:
                            com_tencent_mm_protocal_c_akb = new akb();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
                            com_tencent_mm_protocal_c_akb.aF(n.a(com_tencent_mm_protocal_c_bje.wMA));
                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_akb.fLR);
                            WO = SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                            textView.setText(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJz, new Object[]{WO.AQ(), bh.t(((double) com_tencent_mm_protocal_c_akb.fLR) / 100.0d)}));
                            break;
                        default:
                            break;
                    }
                }
                textView.setText(com.tencent.mm.plugin.sns.i.j.qLF);
                textView.setBackgroundColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyu));
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                aVar.lUD.setText(az.k(this.rDE, ((long) com_tencent_mm_protocal_c_bje.pbl) * 1000));
                eR = null;
                if (com_tencent_mm_protocal_c_bje.ktN != 7) {
                }
                eK2 = ae.bvy().eK(iVar.field_snsID);
                if (eK2 != null) {
                    eR = eK2.bxX();
                }
                mVar = eR;
                aVar.rDO.setVisibility(8);
                aVar.rDL.setVisibility(8);
                aVar.rDP.setVisibility(8);
                aVar.rDO.setImageBitmap(null);
                ae.bvs().cw(aVar.rDO);
                if (mVar == null) {
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(new p(iVar.field_snsID), 0);
                } else {
                    list = mVar.bxV().wQo.vYd;
                    if (mVar.field_type != 2) {
                        obj2 = null;
                        if (list.size() > 0) {
                            i2 = mVar.field_type;
                            mMImageView = aVar.rDO;
                            i3 = -1;
                            switch (i2) {
                                case 1:
                                    i3 = com.tencent.mm.plugin.sns.i.e.byV;
                                    break;
                                case 2:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                case 3:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvD;
                                    break;
                                case 4:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvn;
                                    break;
                                case 5:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvA;
                                    break;
                                case 6:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvm;
                                    break;
                                case 7:
                                    i3 = com.tencent.mm.plugin.sns.i.e.byV;
                                    break;
                                case 8:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                default:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvD;
                                    break;
                            }
                            ae.bvs().b((aqr) list.get(0), aVar.rDO, i3, this.rDE.hashCode(), an.xyW);
                            if (mVar.field_type != 15) {
                            }
                            aVar.rDP.setVisibility(0);
                            iVar2 = new i();
                            ae.bvA().b(iVar.xjy, iVar2);
                            aVar.rDO.setTag(iVar2);
                            obj2 = 1;
                        }
                        mMImageView = aVar.rDO;
                        if (obj2 == null) {
                            i2 = 8;
                        } else {
                            i2 = 0;
                        }
                        mMImageView.setVisibility(i2);
                    } else {
                        aVar.rDO.setTag(null);
                        aVar.rDL.setVisibility(0);
                        aVar.rDL.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, mVar.bxV().wQl, aVar.rDL.getTextSize()));
                    }
                }
                if (aVar.rDO.getVisibility() != 0) {
                }
                if (obj2 == null) {
                }
                view.findViewById(com.tencent.mm.plugin.sns.i.f.qET).setVisibility(obj2 == null ? 0 : 8);
                if (iVar.field_isSilence != 1) {
                }
                view.findViewById(com.tencent.mm.plugin.sns.i.f.qFq).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                return view;
            } catch (Exception e4) {
                str2 = str3;
                if (bh.ov(com_tencent_mm_protocal_c_bje.wFM)) {
                    x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                } else {
                    b.a(aVar.rDK, com_tencent_mm_protocal_c_bje.wFM);
                    aVar.rDK.setOnClickListener(new 3(this, com_tencent_mm_protocal_c_bje.wFM));
                }
                WO = SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                if (WO == null) {
                    AQ = WO.AQ();
                } else if (bh.ov(com_tencent_mm_protocal_c_bje.wMt)) {
                    AQ = com_tencent_mm_protocal_c_bje.wFM;
                } else {
                    AQ = com_tencent_mm_protocal_c_bje.wMt;
                }
                aVar.pjY.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, AQ, aVar.pjY.getTextSize()));
                eR = ae.bvv().eR(iVar.field_snsID);
                if (eR == null) {
                }
                aVar.pjY.setTextColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btR));
                str = com_tencent_mm_protocal_c_bje.wFM;
                textView2 = aVar.pjY;
                i4 = com_tencent_mm_protocal_c_bje.vHW;
                switch (iVar.field_type) {
                    case 1:
                    case 2:
                        obj = null;
                        break;
                    case 3:
                    case 5:
                        obj = 1;
                        break;
                    case 4:
                        obj = null;
                        break;
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                        obj = null;
                        break;
                    default:
                        obj = 1;
                        break;
                }
                if (obj != null) {
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView = aVar.rDN;
                j = iVar.field_snsID;
                if ((iVar.field_commentflag & 1) <= 0) {
                }
                if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                    textView.setTextColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                    textView.setBackgroundDrawable(null);
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView.setText("");
                    textView.setCompoundDrawablePadding(0);
                    switch (com_tencent_mm_protocal_c_bje.ktN) {
                        case 1:
                        case 5:
                            eR = ae.bvv().eR(iVar.field_snsID);
                            if (eR != null) {
                                break;
                            }
                            b = com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qIK);
                            if (eR == null) {
                                break;
                            }
                            b.clearColorFilter();
                            b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                            AQ = new SpannableString(" ");
                            AQ.setSpan(new ImageSpan(b), 0, 1, 18);
                            textView.setText(AQ);
                            textView.setContentDescription(this.rDE.mController.xIM.getString(com.tencent.mm.plugin.sns.i.j.qKO));
                            break;
                        case 2:
                        case 3:
                            str4 = com_tencent_mm_protocal_c_bje.nje;
                            str3 = "";
                            eK = ae.bvy().eK(iVar.field_snsID);
                            if (com_tencent_mm_protocal_c_bje.wMB != 1) {
                                if (bh.ov(str2)) {
                                    str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLJ, new Object[]{str2});
                                }
                            } else if (eK != null) {
                                com.tencent.mm.kernel.g.Dk();
                                WM = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(eK.field_userName);
                                str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLI, new Object[]{WM.AQ()});
                            }
                            textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, str3 + str4 + " ", textView.getTextSize()));
                            break;
                        case 4:
                            textView.setText(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qMy));
                            break;
                        case 7:
                            textView.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qIK), null, null, null);
                            textView.setContentDescription(this.rDE.mController.xIM.getString(com.tencent.mm.plugin.sns.i.j.qKO));
                            break;
                        case 8:
                            str3 = "";
                            str4 = com_tencent_mm_protocal_c_bje.nje;
                            eK = ae.bvy().eK(iVar.field_snsID);
                            if (com_tencent_mm_protocal_c_bje.wMB != 1) {
                                if (bh.ov(str2)) {
                                    str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLJ, new Object[]{str2});
                                }
                            } else if (eK != null) {
                                com.tencent.mm.kernel.g.Dk();
                                WM = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(eK.field_userName);
                                str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLI, new Object[]{WM.AQ()});
                            }
                            textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, str3 + str4 + " ", textView.getTextSize()));
                            break;
                        case 13:
                            com_tencent_mm_protocal_c_akb2 = new akb();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
                            com_tencent_mm_protocal_c_akb2.aF(n.a(com_tencent_mm_protocal_c_bje.wMA));
                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_akb2.fLR);
                            SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                            b = null;
                            if (com_tencent_mm_protocal_c_akb2.fLR != 0) {
                                SnsMsgUI.b(this.rDE, false);
                                AQ = new SpannableString(" " + this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJA, new Object[]{bh.t(((double) com_tencent_mm_protocal_c_akb2.fLR) / 100.0d)}));
                                b = this.rDE.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qyT);
                            } else {
                                SnsMsgUI.b(this.rDE, true);
                                AQ = new SpannableString(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJB));
                            }
                            if (b != null) {
                                b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                eVar = new com.tencent.mm.ui.widget.e(b, 1);
                                eVar.zsZ = (int) (((((float) b.getIntrinsicHeight()) - textView.getTextSize()) + ((float) com.tencent.mm.bv.a.fromDPToPix(this.rDE, 2))) / 2.0f);
                                AQ.setSpan(eVar, 0, 1, 33);
                            }
                            textView.setText(AQ);
                            break;
                        case 14:
                            com_tencent_mm_protocal_c_akb = new akb();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
                            com_tencent_mm_protocal_c_akb.aF(n.a(com_tencent_mm_protocal_c_bje.wMA));
                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_akb.fLR);
                            WO = SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                            textView.setText(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJz, new Object[]{WO.AQ(), bh.t(((double) com_tencent_mm_protocal_c_akb.fLR) / 100.0d)}));
                            break;
                        default:
                            break;
                    }
                }
                textView.setText(com.tencent.mm.plugin.sns.i.j.qLF);
                textView.setBackgroundColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyu));
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                aVar.lUD.setText(az.k(this.rDE, ((long) com_tencent_mm_protocal_c_bje.pbl) * 1000));
                eR = null;
                if (com_tencent_mm_protocal_c_bje.ktN != 7) {
                }
                eK2 = ae.bvy().eK(iVar.field_snsID);
                if (eK2 != null) {
                    eR = eK2.bxX();
                }
                mVar = eR;
                aVar.rDO.setVisibility(8);
                aVar.rDL.setVisibility(8);
                aVar.rDP.setVisibility(8);
                aVar.rDO.setImageBitmap(null);
                ae.bvs().cw(aVar.rDO);
                if (mVar == null) {
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(new p(iVar.field_snsID), 0);
                } else {
                    list = mVar.bxV().wQo.vYd;
                    if (mVar.field_type != 2) {
                        obj2 = null;
                        if (list.size() > 0) {
                            i2 = mVar.field_type;
                            mMImageView = aVar.rDO;
                            i3 = -1;
                            switch (i2) {
                                case 1:
                                    i3 = com.tencent.mm.plugin.sns.i.e.byV;
                                    break;
                                case 2:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                case 3:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvD;
                                    break;
                                case 4:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvn;
                                    break;
                                case 5:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvA;
                                    break;
                                case 6:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvm;
                                    break;
                                case 7:
                                    i3 = com.tencent.mm.plugin.sns.i.e.byV;
                                    break;
                                case 8:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                default:
                                    i3 = com.tencent.mm.plugin.sns.i.i.dvD;
                                    break;
                            }
                            ae.bvs().b((aqr) list.get(0), aVar.rDO, i3, this.rDE.hashCode(), an.xyW);
                            if (mVar.field_type != 15) {
                            }
                            aVar.rDP.setVisibility(0);
                            iVar2 = new i();
                            ae.bvA().b(iVar.xjy, iVar2);
                            aVar.rDO.setTag(iVar2);
                            obj2 = 1;
                        }
                        mMImageView = aVar.rDO;
                        if (obj2 == null) {
                            i2 = 8;
                        } else {
                            i2 = 0;
                        }
                        mMImageView.setVisibility(i2);
                    } else {
                        aVar.rDO.setTag(null);
                        aVar.rDL.setVisibility(0);
                        aVar.rDL.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, mVar.bxV().wQl, aVar.rDL.getTextSize()));
                    }
                }
                if (aVar.rDO.getVisibility() != 0) {
                }
                if (obj2 == null) {
                }
                view.findViewById(com.tencent.mm.plugin.sns.i.f.qET).setVisibility(obj2 == null ? 0 : 8);
                if (iVar.field_isSilence != 1) {
                }
                view.findViewById(com.tencent.mm.plugin.sns.i.f.qFq).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                return view;
            }
        } catch (Exception e5) {
            str3 = str2;
            str2 = str3;
            if (bh.ov(com_tencent_mm_protocal_c_bje.wFM)) {
                b.a(aVar.rDK, com_tencent_mm_protocal_c_bje.wFM);
                aVar.rDK.setOnClickListener(new 3(this, com_tencent_mm_protocal_c_bje.wFM));
            } else {
                x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
            }
            WO = SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
            if (WO == null) {
                AQ = WO.AQ();
            } else if (bh.ov(com_tencent_mm_protocal_c_bje.wMt)) {
                AQ = com_tencent_mm_protocal_c_bje.wMt;
            } else {
                AQ = com_tencent_mm_protocal_c_bje.wFM;
            }
            aVar.pjY.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, AQ, aVar.pjY.getTextSize()));
            eR = ae.bvv().eR(iVar.field_snsID);
            if (eR == null) {
            }
            aVar.pjY.setTextColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btR));
            str = com_tencent_mm_protocal_c_bje.wFM;
            textView2 = aVar.pjY;
            i4 = com_tencent_mm_protocal_c_bje.vHW;
            switch (iVar.field_type) {
                case 1:
                case 2:
                    obj = null;
                    break;
                case 3:
                case 5:
                    obj = 1;
                    break;
                case 4:
                    obj = null;
                    break;
                case 7:
                case 8:
                case 13:
                case 14:
                    obj = null;
                    break;
                default:
                    obj = 1;
                    break;
            }
            if (obj != null) {
            }
            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            textView = aVar.rDN;
            j = iVar.field_snsID;
            if ((iVar.field_commentflag & 1) <= 0) {
            }
            if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                textView.setTextColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                textView.setBackgroundDrawable(null);
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView.setText("");
                textView.setCompoundDrawablePadding(0);
                switch (com_tencent_mm_protocal_c_bje.ktN) {
                    case 1:
                    case 5:
                        eR = ae.bvv().eR(iVar.field_snsID);
                        if (eR != null) {
                            break;
                        }
                        b = com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qIK);
                        if (eR == null) {
                            break;
                        }
                        b.clearColorFilter();
                        b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                        AQ = new SpannableString(" ");
                        AQ.setSpan(new ImageSpan(b), 0, 1, 18);
                        textView.setText(AQ);
                        textView.setContentDescription(this.rDE.mController.xIM.getString(com.tencent.mm.plugin.sns.i.j.qKO));
                        break;
                    case 2:
                    case 3:
                        str4 = com_tencent_mm_protocal_c_bje.nje;
                        str3 = "";
                        eK = ae.bvy().eK(iVar.field_snsID);
                        if (com_tencent_mm_protocal_c_bje.wMB != 1) {
                            if (eK != null) {
                                com.tencent.mm.kernel.g.Dk();
                                WM = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(eK.field_userName);
                                str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLI, new Object[]{WM.AQ()});
                            }
                        } else if (bh.ov(str2)) {
                            str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLJ, new Object[]{str2});
                        }
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, str3 + str4 + " ", textView.getTextSize()));
                        break;
                    case 4:
                        textView.setText(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qMy));
                        break;
                    case 7:
                        textView.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bv.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qIK), null, null, null);
                        textView.setContentDescription(this.rDE.mController.xIM.getString(com.tencent.mm.plugin.sns.i.j.qKO));
                        break;
                    case 8:
                        str3 = "";
                        str4 = com_tencent_mm_protocal_c_bje.nje;
                        eK = ae.bvy().eK(iVar.field_snsID);
                        if (com_tencent_mm_protocal_c_bje.wMB != 1) {
                            if (eK != null) {
                                com.tencent.mm.kernel.g.Dk();
                                WM = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(eK.field_userName);
                                str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLI, new Object[]{WM.AQ()});
                            }
                        } else if (bh.ov(str2)) {
                            str3 = this.context.getString(com.tencent.mm.plugin.sns.i.j.qLJ, new Object[]{str2});
                        }
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, str3 + str4 + " ", textView.getTextSize()));
                        break;
                    case 13:
                        com_tencent_mm_protocal_c_akb2 = new akb();
                        x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
                        com_tencent_mm_protocal_c_akb2.aF(n.a(com_tencent_mm_protocal_c_bje.wMA));
                        x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_akb2.fLR);
                        SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                        b = null;
                        if (com_tencent_mm_protocal_c_akb2.fLR != 0) {
                            SnsMsgUI.b(this.rDE, true);
                            AQ = new SpannableString(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJB));
                        } else {
                            SnsMsgUI.b(this.rDE, false);
                            AQ = new SpannableString(" " + this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJA, new Object[]{bh.t(((double) com_tencent_mm_protocal_c_akb2.fLR) / 100.0d)}));
                            b = this.rDE.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qyT);
                        }
                        if (b != null) {
                            b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                            eVar = new com.tencent.mm.ui.widget.e(b, 1);
                            eVar.zsZ = (int) (((((float) b.getIntrinsicHeight()) - textView.getTextSize()) + ((float) com.tencent.mm.bv.a.fromDPToPix(this.rDE, 2))) / 2.0f);
                            AQ.setSpan(eVar, 0, 1, 33);
                        }
                        textView.setText(AQ);
                        break;
                    case 14:
                        com_tencent_mm_protocal_c_akb = new akb();
                        x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
                        com_tencent_mm_protocal_c_akb.aF(n.a(com_tencent_mm_protocal_c_bje.wMA));
                        x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_akb.fLR);
                        WO = SnsMsgUI.p(this.rDE).WO(com_tencent_mm_protocal_c_bje.wFM);
                        textView.setText(this.rDE.getString(com.tencent.mm.plugin.sns.i.j.qJz, new Object[]{WO.AQ(), bh.t(((double) com_tencent_mm_protocal_c_akb.fLR) / 100.0d)}));
                        break;
                    default:
                        break;
                }
            }
            textView.setText(com.tencent.mm.plugin.sns.i.j.qLF);
            textView.setBackgroundColor(this.rDE.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyu));
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            aVar.lUD.setText(az.k(this.rDE, ((long) com_tencent_mm_protocal_c_bje.pbl) * 1000));
            eR = null;
            if (com_tencent_mm_protocal_c_bje.ktN != 7) {
            }
            eK2 = ae.bvy().eK(iVar.field_snsID);
            if (eK2 != null) {
                eR = eK2.bxX();
            }
            mVar = eR;
            aVar.rDO.setVisibility(8);
            aVar.rDL.setVisibility(8);
            aVar.rDP.setVisibility(8);
            aVar.rDO.setImageBitmap(null);
            ae.bvs().cw(aVar.rDO);
            if (mVar == null) {
                list = mVar.bxV().wQo.vYd;
                if (mVar.field_type != 2) {
                    aVar.rDO.setTag(null);
                    aVar.rDL.setVisibility(0);
                    aVar.rDL.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.rDE, mVar.bxV().wQl, aVar.rDL.getTextSize()));
                } else {
                    obj2 = null;
                    if (list.size() > 0) {
                        i2 = mVar.field_type;
                        mMImageView = aVar.rDO;
                        i3 = -1;
                        switch (i2) {
                            case 1:
                                i3 = com.tencent.mm.plugin.sns.i.e.byV;
                                break;
                            case 2:
                                mMImageView.setImageDrawable(null);
                                break;
                            case 3:
                                i3 = com.tencent.mm.plugin.sns.i.i.dvD;
                                break;
                            case 4:
                                i3 = com.tencent.mm.plugin.sns.i.i.dvn;
                                break;
                            case 5:
                                i3 = com.tencent.mm.plugin.sns.i.i.dvA;
                                break;
                            case 6:
                                i3 = com.tencent.mm.plugin.sns.i.i.dvm;
                                break;
                            case 7:
                                i3 = com.tencent.mm.plugin.sns.i.e.byV;
                                break;
                            case 8:
                                mMImageView.setImageDrawable(null);
                                break;
                            default:
                                i3 = com.tencent.mm.plugin.sns.i.i.dvD;
                                break;
                        }
                        ae.bvs().b((aqr) list.get(0), aVar.rDO, i3, this.rDE.hashCode(), an.xyW);
                        if (mVar.field_type != 15) {
                        }
                        aVar.rDP.setVisibility(0);
                        iVar2 = new i();
                        ae.bvA().b(iVar.xjy, iVar2);
                        aVar.rDO.setTag(iVar2);
                        obj2 = 1;
                    }
                    mMImageView = aVar.rDO;
                    if (obj2 == null) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    mMImageView.setVisibility(i2);
                }
            } else {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(new p(iVar.field_snsID), 0);
            }
            if (aVar.rDO.getVisibility() != 0) {
            }
            if (obj2 == null) {
            }
            view.findViewById(com.tencent.mm.plugin.sns.i.f.qET).setVisibility(obj2 == null ? 0 : 8);
            if (iVar.field_isSilence != 1) {
            }
            view.findViewById(com.tencent.mm.plugin.sns.i.f.qFq).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
            return view;
        }
    }
}
