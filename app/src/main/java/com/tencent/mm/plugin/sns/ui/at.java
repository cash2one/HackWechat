package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.uo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public final class at extends BaseAdapter {
    private String country;
    private Activity fAF;
    boolean fuf = false;
    List<m> list = new ArrayList();
    String maQ = "";
    private String nQA = "";
    private an rEW;
    Map<Integer, Integer> rEX = new HashMap();
    private f rEY;
    boolean rEZ = false;
    au rFa;
    private c rFb;
    int rFc = Integer.MAX_VALUE;
    int rFd = 0;
    private long rFe = 0;
    private long rFf = 0;
    int rFg = 0;
    protected OnClickListener rFh = new 6(this);
    Map<Integer, Integer> rqp = new HashMap();
    Map<Integer, Integer> rqq = new HashMap();
    int rqr = 0;
    int rqs = 0;
    String rwz = "";
    private ar rzI = null;
    private String userName = "";

    public final void eW(long j) {
        if (0 == this.rFe) {
            this.rFe = j;
            this.rFf = 0;
        }
    }

    public at(Activity activity, f fVar, String str, c cVar) {
        this.userName = str;
        this.fAF = activity;
        this.rEY = fVar;
        this.rFb = cVar;
        this.rzI = ae.bvj();
        String d = w.d(this.fAF.getSharedPreferences(ac.cfs(), 0));
        x.d("MicroMsg.SnsphotoAdapter", "filterLan temp " + d);
        if (!(d.equals("zh_CN") || d.equals("en") || d.equals("zh_TW"))) {
            d = d.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.nQA = d;
        this.country = w.d(this.fAF.getSharedPreferences(ac.cfs(), 0));
        g.Dk();
        if (this.userName.equals((String) g.Dj().CU().get(2, null))) {
            this.fuf = true;
        }
        x.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
        if (this.fuf) {
            this.rEW = an.ciQ();
        } else {
            g.Dk();
            af WO = ((h) g.h(h.class)).EY().WO(str);
            if (WO == null || !a.fZ(WO.field_type)) {
                this.rEW = an.ciR();
            } else {
                this.rEW = an.ciP();
            }
        }
        this.rFa = new au(new 1(this, cVar), str, this.fuf);
        eX(0);
        iK(false);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        x.i("MicroMsg.SnsphotoAdapter", "position " + itemViewType);
        d dVar;
        int i2;
        m mVar;
        int i3;
        bnp bxV;
        CharSequence charSequence;
        a aVar;
        a aVar2;
        if (itemViewType == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                dVar = new d(this);
                view = v.fv(this.fAF).inflate(i.g.qHH, null);
                dVar.rFm = (TextView) view.findViewById(f.qEp);
                dVar.rFl = (TextView) view.findViewById(f.qEM);
                dVar.rFv = (MaskImageView) view.findViewById(f.qCs);
                dVar.rFw = (QFadeImageView) view.findViewById(f.qFH);
                dVar.rFx = (MaskImageView) view.findViewById(f.qCt);
                dVar.rFy = (MaskImageView) view.findViewById(f.qCu);
                dVar.riU = (TextView) view.findViewById(f.caP);
                dVar.rFz = (TextView) view.findViewById(f.qGl);
                dVar.rFA = (TextView) view.findViewById(f.qGm);
                dVar.rFB = (TextView) view.findViewById(f.qGn);
                dVar.rFC = (TextView) view.findViewById(f.qCw);
                dVar.rFD = view.findViewById(f.qBU);
                dVar.rFp = (TextView) view.findViewById(f.daa);
                dVar.rFn = (LinearLayout) view.findViewById(f.qCI);
                dVar.rFo = (ImageView) view.findViewById(f.qCQ);
                dVar.rqG = (LinearLayout) view.findViewById(f.qCK);
                dVar.rqH = view.findViewById(f.qCH);
                dVar.rFw.setOnClickListener(this.rEY.rqx);
                dVar.rFv.setOnClickListener(this.rEY.rqx);
                dVar.rFx.setOnClickListener(this.rEY.rqy);
                dVar.rFy.setOnClickListener(this.rEY.rqz);
                dVar.rFE = (TextView) view.findViewById(f.qGf);
                dVar.rFF = (TextView) view.findViewById(f.qGg);
                dVar.rFG = (TextView) view.findViewById(f.qGh);
                dVar.rFH = (TextView) view.findViewById(f.qFX);
                dVar.rFI = (TextView) view.findViewById(f.qFY);
                dVar.rFJ = (TextView) view.findViewById(f.qFZ);
                dVar.rFK = (MaskLinearLayout) view.findViewById(f.qEJ);
                dVar.rFK.b(dVar.rFv);
                dVar.rFq = (LinearLayout) view.findViewById(f.qCf);
                dVar.rFr = (TextView) view.findViewById(f.qEZ);
                dVar.rFr.setOnClickListener(new 3(this));
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            ae.bvs().cu(dVar.rFv);
            ae.bvs().cu(dVar.rFx);
            ae.bvs().cu(dVar.rFy);
            i2 = -1;
            if (this.rqp.get(Integer.valueOf(i)) != null) {
                i2 = ((Integer) this.rqp.get(Integer.valueOf(i))).intValue();
            }
            dVar.init();
            dVar.rFK.fqP = false;
            dVar.rFK.setBackgroundResource(0);
            dVar.rFK.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            dVar.rFK.setClickable(false);
            dVar.rFv.fqP = true;
            dVar.rFv.setClickable(true);
            dVar.rFK.setOnClickListener(null);
            if (i2 >= this.rqs || i2 == -1) {
                view.setLayoutParams(new LayoutParams(-1, 1));
                view.setVisibility(8);
            } else {
                if (i2 - 1 >= 0) {
                    mVar = (m) getItem(i2 - 1);
                    i3 = mVar.field_head;
                    ai.J(mVar.field_localPrivate, this.fuf);
                } else {
                    i3 = -1;
                }
                view.setLayoutParams(new LayoutParams(-1, -2));
                view.setVisibility(0);
                int intValue = this.rqq.get(Integer.valueOf(i)) != null ? ((Integer) this.rqq.get(Integer.valueOf(i))).intValue() : 1;
                m mVar2 = (m) getItem(i2);
                bxV = mVar2.bxV();
                if ((this.fuf && i == 0) || r4 == -1 || mVar2.field_head != r4) {
                    a(dVar.rFl, dVar.rFm, (long) mVar2.field_createTime);
                    if (bxV.wQm != null) {
                        charSequence = bxV.wQm.hvv;
                        if (!(charSequence == null || charSequence.equals(""))) {
                            dVar.rFp.setText(charSequence);
                            dVar.rFp.setVisibility(0);
                        }
                    }
                    dVar.rqH.setVisibility(0);
                }
                if (this.rFf != 0 && mVar2.field_snsId == this.rFf) {
                    dVar.rFq.setVisibility(0);
                } else if (this.rFf != 0 || this.rFe == 0 || mVar2.field_snsId > this.rFe) {
                    dVar.rFq.setVisibility(8);
                } else {
                    dVar.rFq.setVisibility(0);
                    this.rFf = mVar2.field_snsId;
                }
                dVar.rFn.setVisibility(0);
                if (this.fuf && i == 0) {
                    dVar.rFw.setVisibility(0);
                    dVar.rFw.setContentDescription(this.fAF.getString(j.qMs));
                    dVar.rFv.setVisibility(8);
                    dVar.riU.setText(this.rqr == 1 ? this.fAF.getString(j.qMJ) : "");
                    dVar.riU.setVisibility(0);
                    dVar.rFD.setVisibility(0);
                    dVar.rFC.setVisibility(8);
                    ae.bvs().a(dVar.rFw, c.gUw, e.qzR, this.fAF.hashCode());
                    aVar = new a();
                    aVar.qQY = -1;
                    aVar.position = -1;
                    dVar.rFw.setTag(aVar);
                } else {
                    if (intValue > 0) {
                        a(i2, dVar.rFv, dVar.rFz, dVar.rFC, dVar.rFE, dVar.rFH, 1, dVar, i);
                    }
                    if (intValue >= 2) {
                        a(i2 + 1, dVar.rFx, dVar.rFA, dVar.rFC, dVar.rFF, dVar.rFI, 2, dVar, i);
                    }
                    if (intValue >= 3) {
                        a(i2 + 2, dVar.rFy, dVar.rFB, dVar.rFC, dVar.rFG, dVar.rFJ, 3, dVar, i);
                    }
                    if (intValue == 1) {
                        mVar = (m) getItem(i2);
                        if (!bh.ov(mVar.bxV().wQl) && mVar.field_type == 1) {
                            dVar.rFK.setDescendantFocusability(393216);
                            dVar.rFK.setClickable(true);
                            dVar.rFv.setClickable(false);
                            dVar.rFv.fqP = false;
                            dVar.rFK.setOnClickListener(this.rEY.rqx);
                            dVar.rFK.fqP = true;
                            itemViewType = mVar2.roJ;
                            aVar2 = new a();
                            aVar2.qQY = itemViewType;
                            if (this.rEX.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.rEX.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.rFK.setTag(aVar2);
                        }
                    }
                    view.setDrawingCacheEnabled(false);
                }
            }
        } else {
            if (itemViewType == 2) {
                e eVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof e)) {
                    e eVar2 = new e(this);
                    view = v.fv(this.fAF).inflate(i.g.qHR, null);
                    eVar2.rFm = (TextView) view.findViewById(f.qEp);
                    eVar2.rFl = (TextView) view.findViewById(f.qEM);
                    eVar2.rFv = (MaskImageView) view.findViewById(f.qCs);
                    eVar2.rFp = (TextView) view.findViewById(f.daa);
                    eVar2.rFn = (LinearLayout) view.findViewById(f.qCI);
                    eVar2.rFo = (ImageView) view.findViewById(f.qCQ);
                    eVar2.rqG = (LinearLayout) view.findViewById(f.qCK);
                    eVar2.rqH = view.findViewById(f.qCH);
                    eVar2.rFv.setOnClickListener(this.rEY.rFN);
                    eVar2.rFE = (TextView) view.findViewById(f.qGf);
                    eVar2.rFK = (MaskLinearLayout) view.findViewById(f.qEJ);
                    eVar2.rFK.b(eVar2.rFv);
                    eVar2.riU = (TextView) view.findViewById(f.caP);
                    eVar2.rFD = view.findViewById(f.qBU);
                    eVar2.rFq = (LinearLayout) view.findViewById(f.qCf);
                    eVar2.rFr = (TextView) view.findViewById(f.qEZ);
                    eVar2.rFr.setOnClickListener(new 2(this));
                    view.setTag(eVar2);
                    eVar = eVar2;
                } else {
                    eVar = (e) view.getTag();
                }
                ae.bvs().cu(eVar.rFv);
                int intValue2 = this.rqp.get(Integer.valueOf(i)) != null ? ((Integer) this.rqp.get(Integer.valueOf(i))).intValue() : -1;
                eVar.init();
                eVar.rFK.fqP = false;
                eVar.rFK.setBackgroundResource(0);
                eVar.rFK.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                eVar.rFK.setClickable(false);
                eVar.rFv.fqP = true;
                eVar.rFv.setClickable(true);
                eVar.rFK.setOnClickListener(null);
                if (intValue2 >= this.rqs || intValue2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (intValue2 - 1 >= 0) {
                        mVar = (m) getItem(intValue2 - 1);
                        i2 = mVar.field_head;
                        ai.J(mVar.field_localPrivate, this.fuf);
                    } else {
                        i2 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.rqq.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.rqq.get(Integer.valueOf(i))).intValue();
                    }
                    m mVar3 = (m) getItem(intValue2);
                    bnp bxV2 = mVar3.bxV();
                    if ((this.fuf && i == 0) || r3 == -1 || mVar3.field_head != r3) {
                        a(eVar.rFl, eVar.rFm, (long) mVar3.field_createTime);
                        if (bxV2.wQm != null) {
                            charSequence = bxV2.wQm.hvv;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                eVar.rFp.setText(charSequence);
                                eVar.rFp.setVisibility(0);
                            }
                        }
                        eVar.rqH.setVisibility(0);
                    }
                    if (this.rFf != 0 && mVar3.field_snsId == this.rFf) {
                        eVar.rFq.setVisibility(0);
                    } else if (this.rFf != 0 || this.rFe == 0 || mVar3.field_snsId > this.rFe) {
                        eVar.rFq.setVisibility(8);
                    } else {
                        eVar.rFq.setVisibility(0);
                        this.rFf = mVar3.field_snsId;
                    }
                    eVar.rFn.setVisibility(0);
                    ai.n(mVar3);
                    an anVar = new an(this.rEW.tag);
                    anVar.time = mVar3.field_createTime;
                    eVar.rFv.setVisibility(0);
                    ae.bvs().a(bxV2.wQo.vYd, eVar.rFv, this.fAF.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qTu, anVar);
                    if (ai.J(mVar3.field_localPrivate, this.fuf)) {
                        eVar.rFE.setVisibility(0);
                        eVar.rFE.setBackgroundResource(e.qzy);
                        a WO = this.rzI.WO(mVar3.field_userName);
                        if (WO != null) {
                            WO.AQ();
                        }
                    }
                    charSequence = ((m) getItem(intValue2)).bxV().wQl;
                    if (!(charSequence == null || charSequence.equals(""))) {
                        eVar.rFD.setVisibility(0);
                        eVar.riU.setVisibility(0);
                        eVar.riU.setText(charSequence);
                        eVar.riU.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fAF, charSequence, eVar.riU.getTextSize()));
                    }
                    eVar.rFK.setDescendantFocusability(393216);
                    eVar.rFK.setClickable(true);
                    eVar.rFv.setClickable(false);
                    eVar.rFv.fqP = false;
                    eVar.rFK.setOnClickListener(this.rEY.rFN);
                    eVar.rFK.fqP = true;
                    itemViewType = mVar3.roJ;
                    aVar2 = new a();
                    aVar2.qQY = itemViewType;
                    if (this.rEX.get(Integer.valueOf(i)) != null) {
                        aVar2.position = ((Integer) this.rEX.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar2.position = 0;
                    }
                    eVar.rFK.setTag(aVar2);
                }
            } else if (itemViewType == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                    dVar = new d(this);
                    view = v.fv(this.fAF).inflate(i.g.qHH, null);
                    dVar.rFm = (TextView) view.findViewById(f.qEp);
                    dVar.rFl = (TextView) view.findViewById(f.qEM);
                    dVar.rFv = (MaskImageView) view.findViewById(f.qCs);
                    dVar.rFw = (QFadeImageView) view.findViewById(f.qFH);
                    dVar.rFx = (MaskImageView) view.findViewById(f.qCt);
                    dVar.rFy = (MaskImageView) view.findViewById(f.qCu);
                    dVar.riU = (TextView) view.findViewById(f.caP);
                    dVar.rFz = (TextView) view.findViewById(f.qGl);
                    dVar.rFA = (TextView) view.findViewById(f.qGm);
                    dVar.rFB = (TextView) view.findViewById(f.qGn);
                    dVar.rFC = (TextView) view.findViewById(f.qCw);
                    dVar.rFD = view.findViewById(f.qBU);
                    dVar.rFp = (TextView) view.findViewById(f.daa);
                    dVar.rFn = (LinearLayout) view.findViewById(f.qCI);
                    dVar.rFo = (ImageView) view.findViewById(f.qCQ);
                    dVar.rqG = (LinearLayout) view.findViewById(f.qCK);
                    dVar.rqH = view.findViewById(f.qCH);
                    dVar.rFw.setOnClickListener(this.rEY.rFM);
                    dVar.rFv.setOnClickListener(this.rEY.rFM);
                    dVar.rFE = (TextView) view.findViewById(f.qGf);
                    dVar.rFF = (TextView) view.findViewById(f.qGg);
                    dVar.rFG = (TextView) view.findViewById(f.qGh);
                    dVar.rFH = (TextView) view.findViewById(f.qFX);
                    dVar.rFI = (TextView) view.findViewById(f.qFY);
                    dVar.rFJ = (TextView) view.findViewById(f.qFZ);
                    dVar.rFK = (MaskLinearLayout) view.findViewById(f.qEJ);
                    dVar.rFK.b(dVar.rFv);
                    dVar.rFq = (LinearLayout) view.findViewById(f.qCf);
                    dVar.rFr = (TextView) view.findViewById(f.qEZ);
                    dVar.rFr.setOnClickListener(new 5(this));
                    view.setTag(dVar);
                } else {
                    dVar = (d) view.getTag();
                }
                ae.bvs().cu(dVar.rFv);
                ae.bvs().cu(dVar.rFx);
                ae.bvs().cu(dVar.rFy);
                i2 = -1;
                if (this.rqp.get(Integer.valueOf(i)) != null) {
                    i2 = ((Integer) this.rqp.get(Integer.valueOf(i))).intValue();
                }
                dVar.init();
                dVar.rFK.fqP = false;
                dVar.rFK.setBackgroundResource(0);
                dVar.rFK.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                dVar.rFK.setClickable(false);
                dVar.rFv.fqP = true;
                dVar.rFv.setClickable(true);
                dVar.rFK.setOnClickListener(null);
                if (i2 >= this.rqs || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (i2 - 1 >= 0) {
                        mVar = (m) getItem(i2 - 1);
                        i3 = mVar.field_head;
                        ai.J(mVar.field_localPrivate, this.fuf);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    m mVar4 = (m) getItem(i2);
                    bxV = mVar4.bxV();
                    if ((this.fuf && i == 0) || r4 == -1 || mVar4.field_head != r4) {
                        a(dVar.rFl, dVar.rFm, (long) mVar4.field_createTime);
                        if (bxV.wQm != null) {
                            charSequence = bxV.wQm.hvv;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                dVar.rFp.setText(charSequence);
                                dVar.rFp.setVisibility(0);
                            }
                        }
                        dVar.rqH.setVisibility(0);
                    }
                    if (this.rFf != 0 && mVar4.field_snsId == this.rFf) {
                        dVar.rFq.setVisibility(0);
                    } else if (this.rFf != 0 || this.rFe == 0 || mVar4.field_snsId > this.rFe) {
                        dVar.rFq.setVisibility(8);
                    } else {
                        dVar.rFq.setVisibility(0);
                        this.rFf = mVar4.field_snsId;
                    }
                    dVar.rFn.setVisibility(0);
                    if (this.fuf && i == 0) {
                        dVar.rFw.setVisibility(0);
                        dVar.rFw.setContentDescription(this.fAF.getString(j.qMs));
                        dVar.rFv.setVisibility(8);
                        dVar.riU.setText(this.rqr == 1 ? this.fAF.getString(j.qMJ) : "");
                        dVar.riU.setVisibility(0);
                        dVar.rFD.setVisibility(0);
                        dVar.rFC.setVisibility(8);
                        ae.bvs().a(dVar.rFw, c.gUw, e.qzR, this.fAF.hashCode());
                        aVar = new a();
                        aVar.qQY = -1;
                        aVar.position = -1;
                        dVar.rFw.setTag(aVar);
                    } else {
                        a(i2, dVar.rFv, dVar.rFz, dVar.rFC, dVar.rFE, dVar.rFH, 1, dVar, i);
                        mVar = (m) getItem(i2);
                        if (!bh.ov(mVar.bxV().wQl) && mVar.field_type == 1) {
                            dVar.rFK.setDescendantFocusability(393216);
                            dVar.rFK.setClickable(true);
                            dVar.rFv.setClickable(false);
                            dVar.rFv.fqP = false;
                            dVar.rFK.setOnClickListener(this.rEY.rFM);
                            dVar.rFK.fqP = true;
                            itemViewType = mVar4.roJ;
                            aVar2 = new a();
                            aVar2.qQY = itemViewType;
                            if (this.rEX.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.rEX.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.rFK.setTag(aVar2);
                        }
                        view.setDrawingCacheEnabled(false);
                    }
                }
            } else {
                b bVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this);
                    view = v.fv(this.fAF).inflate(i.g.qHG, null);
                    bVar2.rFk = view.findViewById(f.bYQ);
                    bVar2.rFm = (TextView) view.findViewById(f.qEp);
                    bVar2.rFl = (TextView) view.findViewById(f.qEM);
                    bVar2.rFp = (TextView) view.findViewById(f.daa);
                    bVar2.rqH = view.findViewById(f.qCH);
                    bVar2.rFp = (TextView) view.findViewById(f.daa);
                    bVar2.rFn = (LinearLayout) view.findViewById(f.qCI);
                    bVar2.rFo = (ImageView) view.findViewById(f.qCQ);
                    bVar2.rqG = (LinearLayout) view.findViewById(f.qCK);
                    bVar2.iXX = (TextView) view.findViewById(f.caS);
                    bVar2.rFs = (TagImageView) view.findViewById(f.qCp);
                    bVar2.rrj = (ImageView) view.findViewById(f.state);
                    bVar2.ihS = (TextView) view.findViewById(f.qFN);
                    bVar2.rFt = (TextView) view.findViewById(f.qDj);
                    bVar2.rFk.setOnClickListener(this.rEY.rFL);
                    bVar2.rFu = view.findViewById(f.qCS);
                    bVar2.rFq = (LinearLayout) view.findViewById(f.qCf);
                    bVar2.rFr = (TextView) view.findViewById(f.qEZ);
                    bVar2.rFr.setOnClickListener(new 4(this));
                    view.setTag(bVar2);
                    com.tencent.mm.plugin.sns.data.i.b(bVar2.rFs, this.fAF);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                i2 = this.rqp.get(Integer.valueOf(i)) != null ? ((Integer) this.rqp.get(Integer.valueOf(i))).intValue() : -1;
                bVar.init();
                if (i2 >= this.rqs || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                    if (i2 - 1 >= 0) {
                        mVar = (m) getItem(i2 - 1);
                        i3 = mVar.field_head;
                        ai.J(mVar.field_localPrivate, this.fuf);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.rqq.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.rqq.get(Integer.valueOf(i))).intValue();
                    }
                    m mVar5 = (m) getItem(i2);
                    bnp bxV3 = mVar5.bxV();
                    if ((this.fuf && i == 0) || r4 == -1 || mVar5.field_head != r4) {
                        a(bVar.rFl, bVar.rFm, (long) mVar5.field_createTime);
                        if (bxV3.wQm != null) {
                            charSequence = bxV3.wQm.hvv;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                bVar.rFp.setText(charSequence);
                                bVar.rFp.setVisibility(0);
                            }
                        }
                        bVar.rqH.setVisibility(0);
                    }
                    if (this.rFf != 0 && mVar5.field_snsId == this.rFf) {
                        bVar.rFq.setVisibility(0);
                    } else if (this.rFf != 0 || this.rFe == 0 || mVar5.field_snsId > this.rFe) {
                        bVar.rFq.setVisibility(8);
                    } else {
                        bVar.rFq.setVisibility(0);
                        this.rFf = mVar5.field_snsId;
                    }
                    a aVar3 = new a();
                    aVar3.qQY = mVar5.roJ;
                    if (this.rEX.get(Integer.valueOf(i)) != null) {
                        aVar3.position = ((Integer) this.rEX.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar3.position = 0;
                    }
                    bVar.rFk.setTag(aVar3);
                    if (bh.ov(bxV3.wQl)) {
                        bVar.iXX.setVisibility(8);
                    } else {
                        bVar.iXX.setVisibility(0);
                        bVar.iXX.setText(bxV3.wQl);
                        bVar.iXX.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fAF, bxV3.wQl, bVar.iXX.getTextSize()));
                    }
                    bVar.rFn.setVisibility(0);
                    bVar.iXX.setSingleLine(true);
                    bVar.rFu.setVisibility(0);
                    itemViewType = bxV3.wQo.vYc;
                    an anVar2 = new an(this.rEW.tag);
                    anVar2.time = mVar5.field_createTime;
                    if (itemViewType == 2) {
                        bVar.iXX.setVisibility(0);
                        bVar.iXX.setSingleLine(false);
                        bVar.iXX.setMaxLines(2);
                        bVar.rFu.setVisibility(8);
                    } else if (itemViewType != 4) {
                        CharSequence Mc;
                        CharSequence charSequence2;
                        bVar.ihS.setTextColor(this.fAF.getResources().getColor(c.qyv));
                        if (((al.a.bvV() & 1) <= 0 ? 1 : null) != null) {
                            Mc = av.Mc(bxV3.wQo.nfX);
                        } else {
                            Object obj = "";
                        }
                        String str = bxV3.wQo.fon;
                        if (str == null || str.length() <= 40) {
                            Object obj2 = str;
                        } else {
                            charSequence2 = str.substring(0, 40) + "...";
                        }
                        if (bVar.rFs != null) {
                            bVar.rFs.setOnClickListener(null);
                        }
                        bVar.rrj.setVisibility(8);
                        if (!bxV3.wQo.vYd.isEmpty()) {
                            bVar.rFs.setVisibility(0);
                            r3 = (aqr) bxV3.wQo.vYd.get(0);
                            if (bxV3.wQo.vYc == 5) {
                                Mc = av.Mc(r3.nfX);
                                charSequence2 = r3.fon;
                                bVar.rrj.setVisibility(0);
                                ae.bvs().a(r3, bVar.rFs, i.i.dvA, this.fAF.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qTu, anVar2);
                            } else {
                                ae.bvs().a(r3, bVar.rFs, this.fAF.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qTu, anVar2);
                            }
                        } else if (bxV3.wQo.vYc != 26) {
                            bVar.rFs.setVisibility(8);
                        } else {
                            bVar.rFs.setVisibility(0);
                            bVar.rFs.setImageResource(i.i.qIP);
                        }
                        if (bh.ov(Mc)) {
                            bVar.rFt.setVisibility(8);
                        } else {
                            bVar.rFt.setVisibility(0);
                            bVar.rFt.setText(Mc);
                        }
                        if (bh.ov(charSequence2)) {
                            bVar.ihS.setVisibility(8);
                        } else {
                            if (bVar.rFt.getVisibility() == 8) {
                                bVar.ihS.setMaxLines(2);
                            } else {
                                bVar.ihS.setMaxLines(1);
                            }
                            bVar.ihS.setVisibility(0);
                            if ((bxV3.hbg & 1) > 0) {
                                bVar.ihS.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence2, this.fAF, bVar.ihS));
                            } else {
                                bVar.ihS.setText(charSequence2);
                            }
                        }
                    } else if (bxV3.wQo.vYd.isEmpty()) {
                        bVar.rFu.setVisibility(8);
                    } else {
                        bVar.rFs.setVisibility(0);
                        bVar.rrj.setVisibility(0);
                        bVar.rFu.setVisibility(0);
                        bVar.ihS.setMaxLines(1);
                        bVar.ihS.setTextColor(this.fAF.getResources().getColor(c.btR));
                        r3 = (aqr) bxV3.wQo.vYd.get(0);
                        ae.bvs().a(r3, bVar.rFs, i.i.dvn, this.fAF.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qTu, anVar2);
                        bVar.rrj.setPressed(false);
                        if (Mb(bxV3.nGJ)) {
                            bVar.rrj.setImageResource(e.bDR);
                        } else {
                            bVar.rrj.setImageResource(e.bDS);
                        }
                        bVar.rFs.setTag(bxV3);
                        bVar.rFs.setOnClickListener(this.rFh);
                        r3.qQY = mVar5.roJ;
                        bVar.rFu.setTag(bxV3);
                        charSequence = r3.nfe;
                        if (bh.ov(charSequence)) {
                            bVar.rFt.setVisibility(4);
                        } else {
                            bVar.rFt.setVisibility(0);
                            bVar.rFt.setText(charSequence);
                        }
                        charSequence = r3.fon;
                        if (bh.ov(charSequence)) {
                            bVar.ihS.setVisibility(8);
                        } else {
                            bVar.ihS.setVisibility(0);
                            bVar.ihS.setTag(aVar3);
                            bVar.ihS.setOnTouchListener(new ab());
                            bVar.ihS.setText(charSequence);
                        }
                    }
                }
            }
            view.setDrawingCacheEnabled(false);
        }
        return view;
    }

    public final int getCount() {
        return this.rqr;
    }

    private void a(TextView textView, TextView textView2, long j) {
        String str = (String) az.a(this.fAF, 1000 * j, !this.nQA.equals("en"));
        String[] split;
        if (str.indexOf(":") > 0) {
            split = str.split(":");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else if (str.indexOf("/") > 0) {
            split = str.split("/");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            split[0] = az.t(this.fAF, split[0], this.nQA);
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
    }

    public final int getItemViewType(int i) {
        if (this.fuf && i == 0) {
            x.d("MicroMsg.SnsphotoAdapter", "position isSelf " + i + " - 0");
            return 0;
        }
        int intValue;
        if (this.rqp.get(Integer.valueOf(i)) != null) {
            intValue = ((Integer) this.rqp.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        if (intValue == -1) {
            x.e("MicroMsg.SnsphotoAdapter", "unknow error " + intValue);
            return 0;
        }
        m mVar = (m) getItem(intValue);
        if (mVar.bxV().wQo.vYc == 1) {
            x.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 0");
            return 0;
        } else if (mVar.bxV().wQo.vYc != 15) {
            return mVar.bxV().wQo.vYc == 21 ? 3 : 1;
        } else {
            x.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 2");
            return 2;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }

    private void a(int i, QFadeImageView qFadeImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, int i2, d dVar, int i3) {
        CharSequence AQ;
        m mVar = (m) getItem(i);
        bnp bxV = mVar.bxV();
        bjv n = ai.n(mVar);
        Object obj = null;
        if (n != null && (((n.wzw & 2) == 2 && n.wNl != null) || ((n.wzw & 4) == 4 && n.wym != null))) {
            obj = 1;
        }
        if (!(!this.fuf || n == null || r1 == null || this.userName == null || !this.userName.equals(mVar.field_userName))) {
            textView3.setBackgroundResource(e.qzE);
            textView3.setVisibility(0);
        }
        a WO;
        if (i2 == 1) {
            if (ai.J(mVar.field_localPrivate, this.fuf)) {
                textView3.setVisibility(0);
                textView3.setBackgroundResource(e.qzy);
                WO = this.rzI.WO(mVar.field_userName);
                AQ = WO == null ? "" : WO.AQ();
                if (!(AQ.equals("") || this.userName.equals(mVar.field_userName))) {
                    textView.setVisibility(0);
                    textView.setText(AQ);
                }
            }
        } else if (ai.J(mVar.field_localPrivate, this.fuf)) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(e.qzy);
            WO = this.rzI.WO(mVar.field_userName);
            AQ = WO == null ? "" : WO.AQ();
            if (!(AQ == null || AQ.equals("") || this.userName.equals(mVar.field_userName))) {
                textView.setVisibility(0);
                textView.setText(AQ);
            }
        }
        int i4 = mVar.roJ;
        a aVar = new a();
        aVar.qQY = i4;
        if (this.rEX.get(Integer.valueOf(i3)) != null) {
            aVar.position = ((Integer) this.rEX.get(Integer.valueOf(i3))).intValue();
        } else {
            aVar.position = 0;
        }
        qFadeImageView.setTag(aVar);
        an anVar = new an(this.rEW.tag);
        anVar.time = mVar.field_createTime;
        if (bxV.wQo.vYc == 1) {
            qFadeImageView.setVisibility(0);
            ae.bvs().a(bxV.wQo.vYd, qFadeImageView, this.fAF.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qTu, anVar);
        } else if (bxV.wQo.vYc == 2) {
            textView4.setText(bh.az(bxV.wQo.nfe, ""));
            textView4.setVisibility(0);
        } else if (bxV.wQo.vYc == 21) {
            mVar.byi();
            boolean z = true;
            if (this.fuf) {
                z = true;
            } else if (com.tencent.mm.plugin.sns.lucky.a.m.a(mVar, n)) {
                z = false;
            }
            qFadeImageView.setVisibility(0);
            ae.bvs().a(bxV.wQo.vYd, qFadeImageView, this.fAF.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qTu, anVar, z);
        }
        if (mVar.bve() && mVar.bys()) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(e.qzx);
        }
        if (i2 == 1) {
            if (bxV.wQo.vYd == null || bxV.wQo.vYd.size() <= 1) {
                textView2.setVisibility(8);
            } else {
                dVar.rFD.setVisibility(0);
                textView2.setVisibility(0);
                textView2.setText(this.fAF.getResources().getQuantityString(i.h.qIu, i4, new Object[]{Integer.valueOf(bxV.wQo.vYd.size())}));
            }
            AQ = bxV.wQl;
            if (AQ != null && !AQ.equals("")) {
                dVar.rFD.setVisibility(0);
                dVar.riU.setVisibility(0);
                dVar.riU.setText(AQ);
                dVar.riU.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fAF, AQ, dVar.riU.getTextSize()));
            }
        }
    }

    private void iK(boolean z) {
        x.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.maQ);
        if (this.rFa != null) {
            this.rFa.e(this.maQ, this.rEZ, z);
        }
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void bzt() {
        iK(true);
        notifyDataSetChanged();
    }

    public final void bBr() {
        x.d("MicroMsg.SnsphotoAdapter", "i addSize ");
        eX(this.list.isEmpty() ? 0 : ((m) this.list.get(this.list.size() - 1)).field_snsId);
    }

    private void eX(long j) {
        at atVar;
        String er = com.tencent.mm.plugin.sns.data.i.er(ae.bvv().a(j, ae.bvl().Kp(this.userName), this.userName, this.fuf));
        if (this.rwz.equals("")) {
            atVar = this;
        } else if (er.compareTo(this.rwz) < 0) {
            atVar = this;
        } else {
            er = this.rwz;
            atVar = this;
        }
        atVar.maQ = er;
        uo byh = ae.bvz().Lq(this.userName).byh();
        if (byh.wcx != 0) {
            er = com.tencent.mm.plugin.sns.data.i.er(byh.wcx);
            if (this.maQ.equals("")) {
                this.maQ = er;
                return;
            }
            if (er.compareTo(this.maQ) <= 0) {
                er = this.maQ;
            }
            this.maQ = er;
        }
    }

    public final Object getItem(int i) {
        return this.list.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final ArrayList<b> dE(int i, int i2) {
        ArrayList<b> arrayList = new ArrayList();
        this.rFg = i2;
        for (int i3 = 0; i3 < this.list.size(); i3++) {
            m mVar = (m) this.list.get(i3);
            int i4 = mVar.roJ;
            if (!(mVar.bxV() == null || mVar.bxV().wQo == null || mVar.bxV().wQo.vYd.size() == 0 || (mVar.bxV().wQo.vYc != 1 && mVar.bxV().wQo.vYc != 15))) {
                if (i4 == i) {
                    this.rFg = arrayList.size();
                }
                Iterator it = mVar.bxV().wQo.vYd.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    aqr com_tencent_mm_protocal_c_aqr = (aqr) it.next();
                    b bVar = new b();
                    bVar.fHC = com_tencent_mm_protocal_c_aqr;
                    bVar.raG = u.ac("sns_table_", (long) i4);
                    bVar.hzW = mVar.field_createTime;
                    int i6 = i5 + 1;
                    bVar.raH = i5;
                    arrayList.add(bVar);
                    i5 = i6;
                }
            }
        }
        return arrayList;
    }

    protected static boolean Mb(String str) {
        asv Qs = com.tencent.mm.av.b.Qs();
        if (Qs != null && com.tencent.mm.av.b.d(Qs) && str.equals(Qs.vVZ) && com.tencent.mm.av.b.Qq()) {
            return true;
        }
        return false;
    }
}
