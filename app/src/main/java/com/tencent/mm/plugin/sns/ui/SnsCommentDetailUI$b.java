package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.v;
import java.util.LinkedList;

class SnsCommentDetailUI$b extends BaseAdapter {
    Activity activity;
    String frH;
    public LinkedList<bjk> rAV;
    LinkedList<bjk> rAW;
    final /* synthetic */ SnsCommentDetailUI rAr;

    public SnsCommentDetailUI$b(SnsCommentDetailUI snsCommentDetailUI, LinkedList<bjk> linkedList, LinkedList<bjk> linkedList2, Activity activity, String str) {
        this.rAr = snsCommentDetailUI;
        this.rAV = linkedList;
        this.rAW = linkedList2;
        this.activity = activity;
        this.frH = str;
    }

    public final int getCount() {
        int i = 0;
        if (this.rAW.size() > 0) {
            if (this.rAV != null) {
                i = this.rAV.size();
            }
            return i + 1;
        } else if (this.rAV != null) {
            return this.rAV.size();
        } else {
            return 0;
        }
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence AQ;
        x WM;
        int length;
        String str;
        int i2;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (this.rAW.size() > 0) {
            if (i == 0) {
                return SnsCommentDetailUI.G(this.rAr);
            }
            i--;
        }
        bjk com_tencent_mm_protocal_c_bjk = (bjk) this.rAV.get(i);
        if (view == null || !(view.getTag() instanceof a)) {
            view = v.fv(this.activity).inflate(i$g.qHj, null);
            view.setOnTouchListener(SnsCommentDetailUI.H(this.rAr));
            a aVar2 = new a(this);
            aVar2.iip = (ImageView) view.findViewById(f.qAy);
            aVar2.iip.setOnClickListener(SnsCommentDetailUI.I(this.rAr));
            aVar2.pjY = (TextView) view.findViewById(f.qAH);
            aVar2.pjY.setOnTouchListener(new ab());
            aVar2.pjY.setOnClickListener(new 2(this));
            aVar2.lUD = (TextView) view.findViewById(f.qAK);
            aVar2.inu = (TextView) view.findViewById(f.qAB);
            aVar2.rAY = (SnsTranslateResultView) view.findViewById(f.qFD);
            aVar2.rAY.setVisibility(8);
            if (SnsCommentDetailUI.y(this.rAr) == 11) {
                view.findViewById(f.qBI).setBackgroundResource(e.qyZ);
                aVar = aVar2;
            } else {
                aVar = aVar2;
            }
        } else {
            aVar = (a) view.getTag();
        }
        aVar.rAZ = com_tencent_mm_protocal_c_bjk;
        aVar.userName = com_tencent_mm_protocal_c_bjk.vIy;
        int i3 = SnsCommentDetailUI.y(this.rAr) == 11 ? 3 : 2;
        int i4 = SnsCommentDetailUI.y(this.rAr) == 11 ? 3 : 2;
        g.Dk();
        x WM2 = ((h) g.h(h.class)).EY().WM(aVar.userName);
        if (i == 0 && this.rAW.isEmpty()) {
            if (SnsCommentDetailUI.y(this.rAr) == 11) {
                view.setBackgroundResource(e.qza);
            } else {
                view.setBackgroundResource(e.qzL);
            }
        } else if (SnsCommentDetailUI.y(this.rAr) == 11) {
            view.setBackgroundResource(e.qzN);
        } else {
            view.setBackgroundResource(e.qzM);
        }
        if (i == 0) {
            view.findViewById(f.qEk).setVisibility(0);
            view.findViewById(f.qEl).setVisibility(8);
            if (SnsCommentDetailUI.y(this.rAr) == 11) {
                ((ImageView) view.findViewById(f.qEk)).setImageResource(i.qIO);
            }
        } else {
            view.findViewById(f.qEk).setVisibility(4);
            view.findViewById(f.qEl).setVisibility(0);
        }
        b.b(aVar.iip, com_tencent_mm_protocal_c_bjk.vIy, true);
        aVar.iip.setTag(com_tencent_mm_protocal_c_bjk.vIy);
        if (WM2 != null) {
            AQ = WM2.AQ();
        } else {
            Object obj = com_tencent_mm_protocal_c_bjk.wvW != null ? com_tencent_mm_protocal_c_bjk.wvW : com_tencent_mm_protocal_c_bjk.vIy;
        }
        m Ll = com.tencent.mm.plugin.sns.storage.h.Ll(SnsCommentDetailUI.n(this.rAr));
        aVar.inu.setText(com_tencent_mm_protocal_c_bjk.nje + " ");
        String charSequence3 = aVar.inu.getText().toString();
        if (Ll != null) {
            g.Dk();
            WM = ((h) g.h(h.class)).EY().WM(Ll.field_userName);
        } else {
            WM = null;
        }
        if (com_tencent_mm_protocal_c_bjk.wMB == 1) {
            if (WM != null) {
                String AQ2 = WM.AQ();
                length = this.rAr.getString(j.qKi).length();
                str = this.rAr.getString(j.qKi) + AQ2 + this.rAr.getString(j.qKg) + charSequence3;
                i2 = length;
                length = 0;
                charSequence = AQ2;
                charSequence2 = null;
            }
            str = charSequence3;
            i2 = 0;
            length = 0;
            charSequence = null;
            charSequence2 = null;
        } else {
            if (!bh.ov(com_tencent_mm_protocal_c_bjk.wMQ)) {
                WM = SnsCommentDetailUI.J(this.rAr).WO(com_tencent_mm_protocal_c_bjk.wMQ);
                str = WM == null ? com_tencent_mm_protocal_c_bjk.wMQ : WM.AQ();
                int length2 = this.rAr.getString(j.qLZ).length();
                String str2 = this.rAr.getString(j.qLZ) + str + this.rAr.getString(j.qKg) + charSequence3;
                i2 = 0;
                length = length2;
                charSequence = null;
                Object obj2 = str;
                str = str2;
            }
            str = charSequence3;
            i2 = 0;
            length = 0;
            charSequence = null;
            charSequence2 = null;
        }
        aVar.pjY.setText(AQ, BufferType.SPANNABLE);
        com.tencent.mm.pluginsdk.ui.d.i.f(aVar.pjY, i3);
        CharSequence jVar = new com.tencent.mm.pluginsdk.ui.d.j(aVar.pjY.getText());
        jVar.a(new n(com_tencent_mm_protocal_c_bjk.vIy, SnsCommentDetailUI.K(this.rAr), i3), AQ, 0, 33);
        aVar.pjY.setText(jVar, BufferType.SPANNABLE);
        aVar.lUD.setText(az.l(this.activity, ((long) com_tencent_mm_protocal_c_bjk.pbl) * 1000));
        Object jVar2 = new com.tencent.mm.pluginsdk.ui.d.j(str);
        if (charSequence != null) {
            jVar2.a(new n(Ll.field_userName, SnsCommentDetailUI.K(this.rAr), i4), charSequence, i2, 33);
        } else if (charSequence2 != null) {
            jVar2.a(new n(com_tencent_mm_protocal_c_bjk.wMQ, SnsCommentDetailUI.K(this.rAr), i4), charSequence2, length, 33);
        }
        aVar.inu.setText(jVar2, BufferType.SPANNABLE);
        aVar.inu.setVisibility(0);
        com.tencent.mm.pluginsdk.ui.d.i.f(aVar.inu, 2);
        SnsCommentDetailUI.L(this.rAr).a(view, SnsCommentDetailUI.x(this.rAr).rPC, SnsCommentDetailUI.x(this.rAr).rPp);
        str = ao.eb(SnsCommentDetailUI.n(this.rAr), String.valueOf(com_tencent_mm_protocal_c_bjk.wMw != 0 ? (long) com_tencent_mm_protocal_c_bjk.wMw : com_tencent_mm_protocal_c_bjk.wMz));
        if (ao.cc(str, 4) && aVar.rAY != null) {
            ao.b Kr = ao.Kr(str);
            if (Kr != null) {
                aVar.rAY.setVisibility(0);
                if (!Kr.hik) {
                    aVar.rAY.xP(2);
                } else if (Kr.hlj) {
                    aVar.rAY.setVisibility(8);
                } else {
                    aVar.rAY.a(Kr, 2, Kr.result, Kr.hqd, Kr.qXB);
                }
            } else {
                aVar.rAY.setVisibility(8);
            }
        }
        view.setClickable(true);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SnsCommentDetailUI", "position " + com_tencent_mm_protocal_c_bjk.vIy + " self " + SnsCommentDetailUI.M(this.rAr) + " commentid " + com_tencent_mm_protocal_c_bjk.wMw + " snsid " + SnsCommentDetailUI.n(this.rAr));
        if (SnsCommentDetailUI.M(this.rAr).equals(com_tencent_mm_protocal_c_bjk.vIy)) {
            aVar.aAy = com_tencent_mm_protocal_c_bjk;
        } else {
            aVar.aAy = new Object[]{Integer.valueOf(i), com_tencent_mm_protocal_c_bjk, com_tencent_mm_protocal_c_bjk.vIy, AQ};
        }
        m mVar = new m(SnsCommentDetailUI.n(this.rAr), com_tencent_mm_protocal_c_bjk, com_tencent_mm_protocal_c_bjk.vIy, com_tencent_mm_protocal_c_bjk.nje, aVar.inu, 2);
        mVar.tag = aVar;
        view.setTag(mVar);
        view.setOnClickListener(SnsCommentDetailUI.N(this.rAr));
        return view;
    }
}
