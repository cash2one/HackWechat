package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j implements c {
    private BaseAdapter kPo;
    private long kPp = 0;
    private long kPq = 0;
    private int kPr;
    private int kPs;
    private ArrayList<Integer> kPt = new ArrayList();
    private ArrayList<String> kPu = new ArrayList();
    private ArrayList<String> kPv = new ArrayList();
    protected LinkedList<CardTagTextView> kPw = new LinkedList();
    private Context mContext;

    public j(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.kPo = baseAdapter;
        this.kPr = this.mContext.getResources().getDimensionPixelSize(R.f.bvL);
        this.kPs = this.mContext.getResources().getDimensionPixelSize(R.f.bvB);
        this.kPt.clear();
        this.kPu.clear();
        this.kPv.clear();
    }

    public final void release() {
        this.mContext = null;
        this.kPo = null;
        if (this.kPq > 0) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(6);
            iDKey2.SetValue((long) ((int) (this.kPp / this.kPq)));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.pQN.a(arrayList, true);
        }
        if (this.kPt.size() == this.kPu.size() && this.kPu.size() == this.kPv.size() && this.kPt.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < this.kPt.size(); i++) {
                g.pQN.h(13220, new Object[]{this.kPv.get(i), this.kPu.get(i), this.kPt.get(i), Long.valueOf(currentTimeMillis)});
            }
        }
        this.kPt.clear();
        this.kPu.clear();
        this.kPv.clear();
        if (this.kPw != null) {
            this.kPw.clear();
        }
    }

    public final View a(int i, View view, b bVar) {
        a aVar;
        Object obj;
        StringBuilder stringBuilder;
        CharSequence wm;
        boolean nK;
        int wn;
        LayoutParams layoutParams;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = View.inflate(this.mContext, R.i.bRZ, null);
            a aVar2 = new a(this);
            aVar2.kPx = (LinearLayout) view.findViewById(R.h.bSh);
            aVar2.kPy = (TextView) view.findViewById(R.h.bRc);
            aVar2.kPz = (TextView) view.findViewById(R.h.bRd);
            aVar2.kPA = (RelativeLayout) view.findViewById(R.h.bQj);
            aVar2.kPB = (ImageView) view.findViewById(R.h.bQY);
            aVar2.kPC = (TextView) view.findViewById(R.h.bPP);
            aVar2.kPD = (TextView) view.findViewById(R.h.bRx);
            aVar2.kPH = view.findViewById(R.h.bRe);
            aVar2.kPE = (TextView) view.findViewById(R.h.subtitle);
            aVar2.kPF = (TextView) view.findViewById(R.h.bPF);
            aVar2.kPG = (TextView) view.findViewById(R.h.bRy);
            aVar2.kPI = (TextView) view.findViewById(R.h.bQl);
            aVar2.kPE.setEllipsize(TruncateAt.MIDDLE);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        b bVar2 = (b) this.kPo.getItem(i);
        int atK = bVar2.atK();
        if (com.tencent.mm.plugin.card.sharecard.a.b.nK(bVar2.atK())) {
            if (i == 0) {
                if (!TextUtils.isEmpty(bVar2.nE(atK))) {
                    obj = 1;
                    if (obj != null) {
                        aVar.kPy.setVisibility(0);
                        aVar.kPy.setText(bVar2.nE(atK));
                        if (TextUtils.isEmpty(bVar2.atJ())) {
                            aVar.kPz.setVisibility(8);
                        } else {
                            aVar.kPz.setVisibility(0);
                            aVar.kPz.setText(bVar2.atJ());
                        }
                    } else {
                        aVar.kPy.setVisibility(8);
                        aVar.kPz.setVisibility(8);
                        aVar.kPy.setText("");
                    }
                    if (bVar.atn()) {
                        aVar.kPB.setVisibility(0);
                        aVar.kPC.setVisibility(0);
                        aVar.kPx.setVisibility(0);
                        aVar.kPD.setVisibility(0);
                        aVar.kPI.setVisibility(0);
                        aVar.kPH.setVisibility(0);
                        aVar.kPE.setVisibility(0);
                        aVar.kPF.setVisibility(0);
                        aVar.kPG.setVisibility(8);
                        aVar.kPC.setText(bVar.atB().kLa);
                        if (!bVar.atk()) {
                            aVar.kPD.setText(bVar.atB().title);
                        } else if (bVar.atB().vRI == null && bVar.atB().vRI.size() == 1) {
                            aVar.kPD.setText(((oq) bVar.atB().vRI.get(0)).title);
                        } else if (bVar.atB().vRI != null && bVar.atB().vRI.size() == 2) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(((oq) bVar.atB().vRI.get(0)).title);
                            stringBuilder.append("-");
                            stringBuilder.append(((oq) bVar.atB().vRI.get(1)).title);
                            aVar.kPD.setText(stringBuilder.toString());
                        }
                        m.a(aVar.kPB, bVar.atB().kJP, this.mContext.getResources().getDimensionPixelSize(R.f.bwt), R.g.bDT, true);
                        aVar.kPC.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                        wm = com.tencent.mm.plugin.card.sharecard.a.b.wm(bVar.atG());
                        if (TextUtils.isEmpty(wm)) {
                            aVar.kPF.setText("");
                        } else {
                            aVar.kPF.setText(wm);
                        }
                        wm = com.tencent.mm.plugin.card.sharecard.a.b.ko(bVar.atG());
                        nK = com.tencent.mm.plugin.card.sharecard.a.b.nK(bVar.atK());
                        if (TextUtils.isEmpty(wm) && nK) {
                            aVar.kPE.setText(i.c(this.mContext, wm, this.mContext.getResources().getDimensionPixelOffset(R.f.bvU)));
                        } else if (TextUtils.isEmpty(bVar.atH())) {
                            aVar.kPE.setText("");
                        } else {
                            if (TextUtils.isEmpty(l.wR(bVar.atH()))) {
                                aVar.kPE.setText("");
                            } else {
                                aVar.kPE.setText(i.c(this.mContext, this.mContext.getResources().getString(R.l.dPh, new Object[]{wm}), this.mContext.getResources().getDimensionPixelOffset(R.f.bvU)));
                            }
                        }
                        wn = com.tencent.mm.plugin.card.sharecard.a.b.wn(bVar.atG());
                        if (wn > 1 || !nK) {
                            aVar.kPI.setVisibility(8);
                        } else {
                            aVar.kPI.setText("X" + wn);
                            aVar.kPI.setVisibility(0);
                        }
                        if ((bVar.atB().vSb != null || bh.cA(bVar.atB().vSb.wSN)) && !com.tencent.mm.plugin.card.sharecard.a.b.wp(bVar.atG())) {
                            aVar.kPx.setVisibility(8);
                        } else {
                            aVar.kPx.setVisibility(0);
                            for (int i2 = 0; i2 < aVar.kPx.getChildCount(); i2++) {
                                this.kPw.add((CardTagTextView) aVar.kPx.getChildAt(i2));
                            }
                            aVar.kPx.removeAllViews();
                            if (com.tencent.mm.plugin.card.sharecard.a.b.wp(bVar.atG())) {
                                View avp = avp();
                                avp.setPadding(this.kPs, this.kPr, this.kPs, this.kPr);
                                avp.setTextColor(this.mContext.getResources().getColor(R.e.btB));
                                avp.setText(this.mContext.getString(R.l.dPp));
                                avp.setTextSize(12.0f);
                                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                                layoutParams2.rightMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvz);
                                aVar.kPx.addView(avp, layoutParams2);
                            }
                            if (!(bVar.atB().vSb == null || bh.cA(bVar.atB().vSb.wSN))) {
                                Iterator it = bVar.atB().vSb.wSN.iterator();
                                while (it.hasNext()) {
                                    bna com_tencent_mm_protocal_c_bna = (bna) it.next();
                                    View avp2 = avp();
                                    avp2.setPadding(this.kPs, this.kPr, this.kPs, this.kPr);
                                    avp2.setTextColor(l.wO(com_tencent_mm_protocal_c_bna.hbM));
                                    avp2.setText(com_tencent_mm_protocal_c_bna.tag);
                                    avp2.setTextSize(12.0f);
                                    aVar.kPx.addView(avp2);
                                }
                            }
                        }
                    } else {
                        aVar.kPB.setVisibility(8);
                        aVar.kPC.setVisibility(8);
                        aVar.kPx.setVisibility(8);
                        aVar.kPD.setVisibility(8);
                        aVar.kPI.setVisibility(8);
                        aVar.kPH.setVisibility(8);
                        aVar.kPE.setVisibility(8);
                        aVar.kPF.setVisibility(8);
                        aVar.kPG.setVisibility(0);
                        aVar.kPG.setText(this.mContext.getResources().getString(R.l.dOR));
                    }
                    if (i != this.kPo.getCount() - 1 && aVar.kPA != null) {
                        layoutParams = (LayoutParams) aVar.kPA.getLayoutParams();
                        if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(R.f.bvz)) {
                            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvz);
                            aVar.kPA.setLayoutParams(layoutParams);
                        }
                    } else if (aVar.kPA != null) {
                        layoutParams = (LayoutParams) aVar.kPA.getLayoutParams();
                        if (layoutParams.bottomMargin != 0) {
                            layoutParams.bottomMargin = 0;
                            aVar.kPA.setLayoutParams(layoutParams);
                        }
                    }
                    this.kPp = (System.currentTimeMillis() - currentTimeMillis) + this.kPp;
                    this.kPq++;
                    if (!this.kPu.contains(bVar.atF())) {
                        this.kPu.add(bVar.atF());
                        this.kPv.add(bVar.atG());
                        this.kPt.add(Integer.valueOf(i));
                    }
                    return view;
                }
            } else if (atK != ((b) this.kPo.getItem(i - 1)).atK()) {
                obj = 1;
                if (obj != null) {
                    aVar.kPy.setVisibility(8);
                    aVar.kPz.setVisibility(8);
                    aVar.kPy.setText("");
                } else {
                    aVar.kPy.setVisibility(0);
                    aVar.kPy.setText(bVar2.nE(atK));
                    if (TextUtils.isEmpty(bVar2.atJ())) {
                        aVar.kPz.setVisibility(8);
                    } else {
                        aVar.kPz.setVisibility(0);
                        aVar.kPz.setText(bVar2.atJ());
                    }
                }
                if (bVar.atn()) {
                    aVar.kPB.setVisibility(8);
                    aVar.kPC.setVisibility(8);
                    aVar.kPx.setVisibility(8);
                    aVar.kPD.setVisibility(8);
                    aVar.kPI.setVisibility(8);
                    aVar.kPH.setVisibility(8);
                    aVar.kPE.setVisibility(8);
                    aVar.kPF.setVisibility(8);
                    aVar.kPG.setVisibility(0);
                    aVar.kPG.setText(this.mContext.getResources().getString(R.l.dOR));
                } else {
                    aVar.kPB.setVisibility(0);
                    aVar.kPC.setVisibility(0);
                    aVar.kPx.setVisibility(0);
                    aVar.kPD.setVisibility(0);
                    aVar.kPI.setVisibility(0);
                    aVar.kPH.setVisibility(0);
                    aVar.kPE.setVisibility(0);
                    aVar.kPF.setVisibility(0);
                    aVar.kPG.setVisibility(8);
                    aVar.kPC.setText(bVar.atB().kLa);
                    if (!bVar.atk()) {
                        aVar.kPD.setText(bVar.atB().title);
                    } else {
                        if (bVar.atB().vRI == null) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(((oq) bVar.atB().vRI.get(0)).title);
                        stringBuilder.append("-");
                        stringBuilder.append(((oq) bVar.atB().vRI.get(1)).title);
                        aVar.kPD.setText(stringBuilder.toString());
                    }
                    m.a(aVar.kPB, bVar.atB().kJP, this.mContext.getResources().getDimensionPixelSize(R.f.bwt), R.g.bDT, true);
                    aVar.kPC.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                    wm = com.tencent.mm.plugin.card.sharecard.a.b.wm(bVar.atG());
                    if (TextUtils.isEmpty(wm)) {
                        aVar.kPF.setText("");
                    } else {
                        aVar.kPF.setText(wm);
                    }
                    wm = com.tencent.mm.plugin.card.sharecard.a.b.ko(bVar.atG());
                    nK = com.tencent.mm.plugin.card.sharecard.a.b.nK(bVar.atK());
                    if (TextUtils.isEmpty(wm)) {
                    }
                    if (TextUtils.isEmpty(bVar.atH())) {
                        aVar.kPE.setText("");
                    } else {
                        if (TextUtils.isEmpty(l.wR(bVar.atH()))) {
                            aVar.kPE.setText("");
                        } else {
                            aVar.kPE.setText(i.c(this.mContext, this.mContext.getResources().getString(R.l.dPh, new Object[]{wm}), this.mContext.getResources().getDimensionPixelOffset(R.f.bvU)));
                        }
                    }
                    wn = com.tencent.mm.plugin.card.sharecard.a.b.wn(bVar.atG());
                    if (wn > 1) {
                    }
                    aVar.kPI.setVisibility(8);
                    if (bVar.atB().vSb != null) {
                    }
                    aVar.kPx.setVisibility(8);
                }
                if (i != this.kPo.getCount() - 1) {
                }
                if (aVar.kPA != null) {
                    layoutParams = (LayoutParams) aVar.kPA.getLayoutParams();
                    if (layoutParams.bottomMargin != 0) {
                        layoutParams.bottomMargin = 0;
                        aVar.kPA.setLayoutParams(layoutParams);
                    }
                }
                this.kPp = (System.currentTimeMillis() - currentTimeMillis) + this.kPp;
                this.kPq++;
                if (this.kPu.contains(bVar.atF())) {
                    this.kPu.add(bVar.atF());
                    this.kPv.add(bVar.atG());
                    this.kPt.add(Integer.valueOf(i));
                }
                return view;
            }
        }
        obj = null;
        if (obj != null) {
            aVar.kPy.setVisibility(0);
            aVar.kPy.setText(bVar2.nE(atK));
            if (TextUtils.isEmpty(bVar2.atJ())) {
                aVar.kPz.setVisibility(0);
                aVar.kPz.setText(bVar2.atJ());
            } else {
                aVar.kPz.setVisibility(8);
            }
        } else {
            aVar.kPy.setVisibility(8);
            aVar.kPz.setVisibility(8);
            aVar.kPy.setText("");
        }
        if (bVar.atn()) {
            aVar.kPB.setVisibility(0);
            aVar.kPC.setVisibility(0);
            aVar.kPx.setVisibility(0);
            aVar.kPD.setVisibility(0);
            aVar.kPI.setVisibility(0);
            aVar.kPH.setVisibility(0);
            aVar.kPE.setVisibility(0);
            aVar.kPF.setVisibility(0);
            aVar.kPG.setVisibility(8);
            aVar.kPC.setText(bVar.atB().kLa);
            if (!bVar.atk()) {
                if (bVar.atB().vRI == null) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(((oq) bVar.atB().vRI.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((oq) bVar.atB().vRI.get(1)).title);
                aVar.kPD.setText(stringBuilder.toString());
            } else {
                aVar.kPD.setText(bVar.atB().title);
            }
            m.a(aVar.kPB, bVar.atB().kJP, this.mContext.getResources().getDimensionPixelSize(R.f.bwt), R.g.bDT, true);
            aVar.kPC.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
            wm = com.tencent.mm.plugin.card.sharecard.a.b.wm(bVar.atG());
            if (TextUtils.isEmpty(wm)) {
                aVar.kPF.setText(wm);
            } else {
                aVar.kPF.setText("");
            }
            wm = com.tencent.mm.plugin.card.sharecard.a.b.ko(bVar.atG());
            nK = com.tencent.mm.plugin.card.sharecard.a.b.nK(bVar.atK());
            if (TextUtils.isEmpty(wm)) {
            }
            if (TextUtils.isEmpty(bVar.atH())) {
                if (TextUtils.isEmpty(l.wR(bVar.atH()))) {
                    aVar.kPE.setText(i.c(this.mContext, this.mContext.getResources().getString(R.l.dPh, new Object[]{wm}), this.mContext.getResources().getDimensionPixelOffset(R.f.bvU)));
                } else {
                    aVar.kPE.setText("");
                }
            } else {
                aVar.kPE.setText("");
            }
            wn = com.tencent.mm.plugin.card.sharecard.a.b.wn(bVar.atG());
            if (wn > 1) {
            }
            aVar.kPI.setVisibility(8);
            if (bVar.atB().vSb != null) {
            }
            aVar.kPx.setVisibility(8);
        } else {
            aVar.kPB.setVisibility(8);
            aVar.kPC.setVisibility(8);
            aVar.kPx.setVisibility(8);
            aVar.kPD.setVisibility(8);
            aVar.kPI.setVisibility(8);
            aVar.kPH.setVisibility(8);
            aVar.kPE.setVisibility(8);
            aVar.kPF.setVisibility(8);
            aVar.kPG.setVisibility(0);
            aVar.kPG.setText(this.mContext.getResources().getString(R.l.dOR));
        }
        if (i != this.kPo.getCount() - 1) {
        }
        if (aVar.kPA != null) {
            layoutParams = (LayoutParams) aVar.kPA.getLayoutParams();
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                aVar.kPA.setLayoutParams(layoutParams);
            }
        }
        this.kPp = (System.currentTimeMillis() - currentTimeMillis) + this.kPp;
        this.kPq++;
        if (this.kPu.contains(bVar.atF())) {
            this.kPu.add(bVar.atF());
            this.kPv.add(bVar.atG());
            this.kPt.add(Integer.valueOf(i));
        }
        return view;
    }

    public final void u(View view, int i) {
    }

    public final void v(View view, int i) {
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
    }

    private CardTagTextView avp() {
        if (this.kPw.size() == 0) {
            return new CardTagTextView(this.mContext);
        }
        return (CardTagTextView) this.kPw.removeFirst();
    }
}
