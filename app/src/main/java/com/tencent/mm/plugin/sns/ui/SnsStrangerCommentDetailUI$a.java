package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bv.a;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.q;

class SnsStrangerCommentDetailUI$a extends o<i> {
    private Activity fAF;
    private OnClickListener rAg = new 1(this);
    final /* synthetic */ SnsStrangerCommentDetailUI rGV;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (i) obj;
        if (obj == null) {
            obj = new i();
        }
        obj.b(cursor);
        return obj;
    }

    public SnsStrangerCommentDetailUI$a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, Activity activity) {
        this.rGV = snsStrangerCommentDetailUI;
        super(activity, new i());
        this.fAF = activity;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this);
            view = View.inflate(this.fAF, i$g.qHU, null);
            aVar2.iip = (ImageView) view.findViewById(f.qEh);
            aVar2.inu = (TextView) view.findViewById(f.qEi);
            aVar2.pjY = (TextView) view.findViewById(f.qEm);
            aVar2.pXZ = (TextView) view.findViewById(f.qEn);
            aVar2.lUD = (TextView) view.findViewById(f.qEo);
            aVar2.rGY = (ImageView) view.findViewById(f.qEj);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        i iVar = (i) getItem(i);
        try {
            Object obj;
            bje com_tencent_mm_protocal_c_bje = (bje) new bje().aF(iVar.field_curActionBuf);
            b.b(aVar.iip, com_tencent_mm_protocal_c_bje.wFM, true);
            aVar.iip.setTag(com_tencent_mm_protocal_c_bje.wFM);
            aVar.iip.setOnClickListener(this.rAg);
            if (com_tencent_mm_protocal_c_bje.wMt != null) {
                obj = com_tencent_mm_protocal_c_bje.wMt;
            } else {
                obj = ((i) this.xIg).field_talker;
            }
            aVar.pjY.setTag(com_tencent_mm_protocal_c_bje.wFM);
            CharSequence b = com.tencent.mm.pluginsdk.ui.d.i.b(this.fAF, obj, aVar.pjY.getTextSize());
            b.setSpan(new 2(this, com_tencent_mm_protocal_c_bje.wFM), 0, obj.length(), 33);
            aVar.pjY.setText(b, BufferType.SPANNABLE);
            aVar.pjY.setOnTouchListener(new ab());
            if (iVar.field_type == 3) {
                aVar.inu.setVisibility(0);
                aVar.rGY.setVisibility(8);
                x.v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + com_tencent_mm_protocal_c_bje.vHW + "  time:" + com_tencent_mm_protocal_c_bje.pbl + " timeFormatted:" + az.k(this.fAF, ((long) com_tencent_mm_protocal_c_bje.pbl) * 1000));
                aVar.inu.setText(com_tencent_mm_protocal_c_bje.nje + " ");
                com.tencent.mm.pluginsdk.ui.d.i.f(aVar.inu, 2);
                aVar.inu.setVisibility(0);
            } else {
                aVar.inu.setVisibility(8);
                aVar.rGY.setVisibility(0);
            }
            if (!q.FS().equals(com_tencent_mm_protocal_c_bje.wFM)) {
                aVar.pXZ.setVisibility(0);
                TextView textView = aVar.pXZ;
                switch (com_tencent_mm_protocal_c_bje.vHW) {
                    case 18:
                        textView.setText(this.rGV.getString(j.qKQ));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, a.b(this.fAF, e.qzB), null);
                        break;
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        textView.setText(this.rGV.getString(j.qKS));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, a.b(this.fAF, e.qzD), null);
                        break;
                    case 25:
                        textView.setText(this.rGV.getString(j.qKP));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, a.b(this.fAF, e.qzz), null);
                        break;
                    case 30:
                        textView.setText(this.rGV.getString(j.qKR));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, a.b(this.fAF, e.qzA), null);
                        break;
                    default:
                        textView.setText(this.rGV.getString(j.qKT));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, a.b(this.fAF, e.qzC), null);
                        break;
                }
            }
            aVar.pXZ.setVisibility(8);
            aVar.lUD.setText(az.k(this.fAF, ((long) com_tencent_mm_protocal_c_bje.pbl) * 1000));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsStrangerCommentDetailUI", e, "", new Object[0]);
        }
        return view;
    }

    public final void Xy() {
        com.tencent.mm.plugin.sns.storage.j bvA = ae.bvA();
        String l = SnsStrangerCommentDetailUI.l(this.rGV);
        l = com.tencent.mm.plugin.sns.storage.j.bya() + " where talker = " + h.fe(l) + " and  snsID = " + SnsStrangerCommentDetailUI.m(this.rGV) + " and ( type = 3 or type = 5" + " )";
        x.v("MicroMsg.SnsCommentStorage", "comment sql:" + l);
        setCursor(bvA.hhp.a(l, null, 0));
    }

    protected final void Xz() {
        Xy();
    }
}
