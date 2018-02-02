package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.common.c.g;
import java.util.LinkedList;

class e$4 implements OnClickListener {
    final /* synthetic */ e kRr;

    e$4(e eVar) {
        this.kRr = eVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        int i = 0;
        if (view.getId() == R.h.bPy || view.getId() == R.h.bPp) {
            if (this.kRr.kIK.atg()) {
                if (this.kRr.kRn != null) {
                    this.kRr.kRn.avE();
                }
            } else if (this.kRr.kIK.ath() && this.kRr.kRn != null) {
                this.kRr.kRn.avC();
            }
        } else if (view.getId() == R.h.ckd || view.getId() == R.h.bIi) {
            b.S(this.kRr.kQM, this.kRr.kRo.kQw);
        } else if (view.getId() == R.h.bWv || view.getId() == R.h.bWm) {
            if (view.getId() == R.h.bWv) {
                this.kRr.kRg = false;
            } else if (view.getId() == R.h.bWm) {
                this.kRr.kRg = true;
            }
            if (this.kRr.kQT instanceof q) {
                this.kRr.kRf.kVg = ((q) this.kRr.kQT).e(c.kXt);
            }
            j jVar = this.kRr.kRf;
            boolean z2 = this.kRr.kRg;
            jVar.awg();
            jVar.kRg = z2;
            if (jVar.inJ != null && !jVar.inJ.isShowing()) {
                jVar.inJ.showAtLocation(view.getRootView(), 17, 0, 0);
                jVar.inJ.setFocusable(true);
                jVar.inJ.setTouchable(true);
                jVar.inJ.setBackgroundDrawable(new ColorDrawable(16777215));
                jVar.inJ.setOutsideTouchable(true);
                if (jVar.kRg) {
                    jVar.kVc.setOnClickListener(jVar.inN);
                    Bitmap bitmap = jVar.kUY;
                    if (jVar.kNH != null) {
                        jVar.kUY = l.t(jVar.kNH);
                    } else {
                        jVar.kUY = null;
                    }
                    jVar.kVc.setImageBitmap(jVar.kUY);
                    jVar.kVf.add(0, bitmap);
                    jVar.awi();
                    jVar.inL.setVisibility(8);
                    jVar.kVb.setVisibility(0);
                    r0 = jVar.kIK.atC().code;
                    if (jVar.kIK.atB().vSn == null || !jVar.kIK.atB().vSn.vZD) {
                        if (!g.isNullOrEmpty(jVar.kIK.atC().vRr)) {
                            r0 = jVar.kIK.atC().vRr;
                        } else if (jVar.kIK.atv()) {
                            if (!g.isNullOrEmpty(jVar.kVg)) {
                                r0 = jVar.kVg;
                            }
                        }
                        if (!TextUtils.isEmpty(r0) || r0.length() > 40) {
                            jVar.kVd.setVisibility(8);
                        } else {
                            jVar.kVd.setText(m.wW(r0));
                            if (jVar.kIK.atq()) {
                                jVar.kVd.setVisibility(0);
                            } else {
                                jVar.kVd.setVisibility(8);
                            }
                        }
                        if (TextUtils.isEmpty(jVar.kIK.atB().liT)) {
                            jVar.kVe.setText(jVar.kIK.atB().liT);
                            jVar.kVe.setVisibility(0);
                        } else {
                            jVar.kVe.setVisibility(8);
                        }
                    }
                    r0 = "";
                    if (TextUtils.isEmpty(r0)) {
                    }
                    jVar.kVd.setVisibility(8);
                    if (TextUtils.isEmpty(jVar.kIK.atB().liT)) {
                        jVar.kVe.setVisibility(8);
                    } else {
                        jVar.kVe.setText(jVar.kIK.atB().liT);
                        jVar.kVe.setVisibility(0);
                    }
                } else {
                    jVar.inK.setOnClickListener(jVar.inN);
                    jVar.inK.setImageBitmap(jVar.inI);
                    r0 = jVar.kIK.atC().code;
                    if (jVar.kIK.atB().vSn == null || !jVar.kIK.atB().vSn.vZD) {
                        if (!g.isNullOrEmpty(jVar.kIK.atC().vRr)) {
                            r0 = jVar.kIK.atC().vRr;
                        } else if (jVar.kIK.atv()) {
                            if (!g.isNullOrEmpty(jVar.kVg)) {
                                r0 = jVar.kVg;
                            }
                        }
                        if (!TextUtils.isEmpty(r0) || r0.length() > 40) {
                            jVar.kUZ.setVisibility(8);
                        } else {
                            jVar.kUZ.setText(m.wW(r0));
                            if (jVar.kIK.atq()) {
                                jVar.kUZ.setVisibility(0);
                            } else {
                                jVar.kUZ.setVisibility(8);
                            }
                        }
                        if (TextUtils.isEmpty(jVar.kIK.atB().liT)) {
                            jVar.kVa.setText(jVar.kIK.atB().liT);
                            jVar.kVa.setVisibility(0);
                        } else {
                            jVar.kVa.setVisibility(8);
                        }
                        jVar.inL.setVisibility(0);
                        jVar.kVb.setVisibility(8);
                    }
                    r0 = "";
                    if (TextUtils.isEmpty(r0)) {
                    }
                    jVar.kUZ.setVisibility(8);
                    if (TextUtils.isEmpty(jVar.kIK.atB().liT)) {
                        jVar.kVa.setVisibility(8);
                    } else {
                        jVar.kVa.setText(jVar.kIK.atB().liT);
                        jVar.kVa.setVisibility(0);
                    }
                    jVar.inL.setVisibility(0);
                    jVar.kVb.setVisibility(8);
                }
                jVar.inJ.update();
            }
        } else if (view.getId() == R.h.bQh || view.getId() == R.h.bQd || view.getId() == R.h.bQc || view.getId() == R.h.bWC || view.getId() == R.h.bQb) {
            if (view.getId() == R.h.bQh) {
                if (this.kRr.kIK.ath()) {
                    int i2;
                    r1 = com.tencent.mm.plugin.report.service.g.pQN;
                    r5 = new Object[9];
                    r5[0] = "CardConsumedCodeUI";
                    r5[1] = Integer.valueOf(this.kRr.kIK.atB().kJO);
                    r5[2] = this.kRr.kIK.atG();
                    r5[3] = this.kRr.kIK.atF();
                    r5[4] = Integer.valueOf(0);
                    r5[5] = Integer.valueOf(this.kRr.kRo.kNT);
                    r5[6] = this.kRr.kRo.kQw;
                    if (this.kRr.kIK.atz()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    r5[7] = Integer.valueOf(i2);
                    r5[8] = "";
                    r1.h(11324, r5);
                    if (this.kRr.kRn != null) {
                        this.kRr.kRn.ed(true);
                        return;
                    }
                    return;
                }
                this.kRr.a(true, new j.b(), false);
            } else if (view.getId() != R.h.bWC || !this.kRr.kIK.atB().vSq) {
                if (!this.kRr.kIK.ath()) {
                    this.kRr.a(false, new j.b(), false);
                } else if (this.kRr.kRn != null) {
                    this.kRr.kRn.ed(false);
                }
            }
        } else if (view.getId() == R.h.bJB) {
            if (!TextUtils.isEmpty(this.kRr.kIK.atB().vRU)) {
                b.a(this.kRr.kQM, this.kRr.kIK.atB().vRU, 3);
                com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(13), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", this.kRr.kIK.atB().vRT});
            }
        } else if (view.getId() == R.h.bRJ) {
            com.tencent.mm.plugin.report.service.g.pQN.h(11582, new Object[]{"OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(this.kRr.kIK.atB().kJO), this.kRr.kIK.atG(), this.kRr.kIK.atF(), this.kRr.kRo.kQw});
            Intent intent = new Intent();
            intent.putExtra("KLabel_range_index", this.kRr.kOu);
            intent.putExtra("Klabel_name_list", this.kRr.kOv);
            intent.putExtra("Kother_user_name_list", this.kRr.kOw);
            intent.putExtra("k_sns_label_ui_title", this.kRr.kQM.getString(R.l.dPl));
            intent.putExtra("k_sns_label_ui_style", 0);
            intent.putExtra("KLabel_is_filter_private", true);
            d.b(this.kRr.kQM, "sns", ".ui.SnsLabelUI", intent, 2);
            this.kRr.kQM.jwN = this.kRr;
        } else if (view.getId() == R.h.bRU) {
            if (this.kRr.kIK.atC().vRf != null) {
                LinkedList linkedList = this.kRr.kIK.atC().vRf;
                int intValue = ((Integer) view.getTag()).intValue();
                r0 = (oq) linkedList.get(intValue);
                if (b.a(this.kRr.kIK.atF(), r0, this.kRr.kRo.kNT, this.kRr.kRo.kRu)) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(19), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", r0.title});
                } else if (r0 != null && !TextUtils.isEmpty(r0.url)) {
                    b.a(this.kRr.kQM, r0.url, 1);
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    Object[] objArr = new Object[5];
                    switch (intValue) {
                        case 0:
                            r1 = 10;
                            break;
                        case 1:
                            r1 = 11;
                            break;
                        case 2:
                            r1 = 12;
                            break;
                        case 3:
                            r1 = 16;
                            break;
                        default:
                            r1 = 10;
                            break;
                    }
                    objArr[0] = Integer.valueOf(r1);
                    objArr[1] = this.kRr.kIK.atF();
                    objArr[2] = this.kRr.kIK.atG();
                    objArr[3] = "";
                    objArr[4] = r0.title;
                    gVar.h(11941, objArr);
                    if (l.a(r0, this.kRr.kIK.atF())) {
                        r1 = this.kRr.kIK.atF();
                        r0 = r0.title;
                        l.wU(r1);
                        b.a(this.kRr.kQM, this.kRr.kIK.atB().kLa);
                    }
                }
            }
        } else if (view.getId() == R.h.bRV) {
            if (this.kRr.kIK.atC().vRf != null) {
                r0 = (oq) this.kRr.kIK.atC().vRf.get(0);
                if (b.a(this.kRr.kIK.atF(), r0, this.kRr.kRo.kNT, this.kRr.kRo.kRu)) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(19), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", r0.title});
                } else if (r0 != null && !TextUtils.isEmpty(r0.url)) {
                    b.a(this.kRr.kQM, r0.url, 1);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(10), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", r0.title});
                    if (l.a(r0, this.kRr.kIK.atF())) {
                        r1 = this.kRr.kIK.atF();
                        r0 = r0.title;
                        l.wU(r1);
                        b.a(this.kRr.kQM, this.kRr.kIK.atB().kLa);
                    }
                }
            }
        } else if (view.getId() == R.h.bSu || view.getId() == R.h.bRC) {
            if (this.kRr.kIK.atC().vRm == null) {
                return;
            }
            if (this.kRr.kIK.att()) {
                if (!this.kRr.kIK.ath()) {
                    this.kRr.a(false, new j.b(), false);
                } else if (this.kRr.kRn != null) {
                    this.kRr.kRn.ed(false);
                }
            } else if (this.kRr.kIK.atu()) {
                j.b bVar = new j.b();
                b.a(this.kRr.kQM, bVar.kJD, bVar.kJE, false, this.kRr.kIK);
            } else {
                r0 = this.kRr.kIK.atC().vRm;
                if (b.a(this.kRr.kIK.atF(), r0, this.kRr.kRo.kNT, this.kRr.kRo.kRu)) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(20), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", r0.title});
                } else if (r0 != null && !TextUtils.isEmpty(r0.url)) {
                    b.a(this.kRr.kQM, l.v(r0.url, r0.vSM), 1);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(9), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", r0.title});
                    if (l.a(r0, this.kRr.kIK.atF())) {
                        r1 = this.kRr.kIK.atF();
                        r0 = r0.title;
                        l.wU(r1);
                        b.a(this.kRr.kQM, this.kRr.kIK.atB().kLa);
                    }
                }
            }
        } else if (view.getId() == R.h.bQs || view.getId() == R.h.bPA) {
            qz qzVar = this.kRr.kIK.atB().vSa;
            r1 = com.tencent.mm.plugin.report.service.g.pQN;
            r5 = new Object[9];
            r5[0] = "CardLeftRightIntroduceView";
            r5[1] = Integer.valueOf(this.kRr.kIK.atB().kJO);
            r5[2] = this.kRr.kIK.atG();
            r5[3] = this.kRr.kIK.atF();
            r5[4] = Integer.valueOf(0);
            r5[5] = Integer.valueOf(this.kRr.kRo.kNT);
            r5[6] = this.kRr.kRo.kQw;
            if (this.kRr.kIK.atz()) {
                i = 1;
            }
            r5[7] = Integer.valueOf(i);
            r5[8] = "";
            r1.h(11324, r5);
            if (qzVar == null || TextUtils.isEmpty(qzVar.url)) {
                Intent intent2 = new Intent();
                if (this.kRr.kIK instanceof CardInfo) {
                    intent2.putExtra("key_card_info_data", (CardInfo) this.kRr.kIK);
                } else if (this.kRr.kIK instanceof ShareCardInfo) {
                    intent2.putExtra("key_card_info_data", (ShareCardInfo) this.kRr.kIK);
                }
                intent2.setClass(this.kRr.kQM, CardDetailPreference.class);
                this.kRr.kQM.startActivity(intent2);
                return;
            }
            b.a(this.kRr.kQM, qzVar.url, 1);
        } else if (view.getId() == R.h.cNX) {
            if (com.tencent.mm.plugin.card.sharecard.a.b.wn(this.kRr.kIK.atG()) > 1) {
                e eVar = this.kRr;
                if (this.kRr.kQP) {
                    z = false;
                }
                eVar.kQP = z;
                this.kRr.ava();
            }
        } else if (view.getId() == R.h.bPE) {
            if (this.kRr.kIK.atB().vRW != null && !TextUtils.isEmpty(this.kRr.kIK.atB().vRW.url)) {
                b.a(this.kRr.kQM, this.kRr.kIK.atB().vRW.url, 3);
                com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(3), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", this.kRr.kIK.atB().vRW.text});
            }
        } else if (view.getId() == R.h.bPw) {
            if (this.kRr.kIK.atB().vSd != null && !bh.ov(this.kRr.kIK.atB().vSd.url)) {
                b.a(this.kRr.kQM, this.kRr.kIK.atB().vSd.url, 1);
                com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(14), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", this.kRr.kIK.atB().vSd.text});
            }
        } else if (view.getId() == R.h.cOc || view.getId() == R.h.cOd) {
            if (this.kRr.kIK.atB().vRM <= 0) {
                return;
            }
            if (this.kRr.kIQ == null || this.kRr.kIQ.size() == 0) {
                x.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                return;
            }
            r0 = (kj) this.kRr.kIQ.get(0);
            b.a(this.kRr.kQM, r0.fzt, r0.fBc, r0.hxu);
            com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr2 = new Object[9];
            objArr2[0] = "UsedStoresView";
            objArr2[1] = Integer.valueOf(this.kRr.kIK.atB().kJO);
            objArr2[2] = this.kRr.kIK.atG();
            objArr2[3] = this.kRr.kIK.atF();
            objArr2[4] = Integer.valueOf(0);
            objArr2[5] = Integer.valueOf(this.kRr.kRo.kNT);
            objArr2[6] = this.kRr.kRo.kQw;
            if (this.kRr.kIK.atz()) {
                r1 = 1;
            } else {
                r1 = 0;
            }
            objArr2[7] = Integer.valueOf(r1);
            objArr2[8] = "";
            gVar2.h(11324, objArr2);
            com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(5), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", r0.name});
        } else if (view.getId() == R.h.cRo) {
            if (this.kRr.kIQ == null || this.kRr.kIQ.size() == 0) {
                x.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                return;
            }
            r0 = (kj) this.kRr.kIQ.get(0);
            r1 = (String) view.getTag();
            if (!TextUtils.isEmpty(r1) && r1.equals(this.kRr.kQM.getString(R.l.dNK))) {
                e.a(this.kRr);
            } else if (!TextUtils.isEmpty(r0.kLB)) {
                b.a(this.kRr.kQM, r0.kLB, 1);
                com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(4), this.kRr.kIK.atF(), this.kRr.kIK.atG(), "", r0.name});
            }
        } else if (view.getId() == R.h.cRj) {
            e.a(this.kRr);
        }
    }
}
