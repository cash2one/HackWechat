package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.ClipboardManager;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.b.ab;
import com.tencent.mm.ui.chatting.viewitems.ah.d;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public final class ah$a extends b {
    private SpannableStringBuilder vlQ = new SpannableStringBuilder();
    private CharacterStyle vlT = new ForegroundColorSpan(-5066062);
    private int vlW = 3;
    private ChattingUI$a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 34) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddB);
        view.setTag(new d().t(view, true));
        return view;
    }

    protected final boolean r(ChattingUI$a chattingUI$a) {
        return chattingUI$a.ypn;
    }

    public final void a(a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        int i2;
        this.yqa = chattingUI$a;
        d dVar = (d) aVar;
        dVar.yNF.xXq = true;
        boolean z = chattingUI$a.ypn;
        a(chattingUI$a.ysf, auVar.field_msgId);
        d.a(dVar, auVar, i, chattingUI$a, true, s(chattingUI$a));
        CharSequence v;
        if (ah.b(auVar, chattingUI$a)) {
            v = chattingUI$a.yvJ.v(auVar.field_msgId, auVar.field_imgPath);
            if (bh.ov(v)) {
                dVar.yNL.setVisibility(0);
                dVar.yNG.setVisibility(8);
            } else {
                dVar.yNH.setText(v);
                dVar.yNH.setMinWidth(com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 80));
                dVar.yNH.setMaxWidth(com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 259));
                dVar.yNG.setVisibility(0);
                dVar.yNH.setVisibility(0);
                dVar.yNK.setVisibility(8);
                dVar.mX(true);
                dVar.yNG.setMinimumWidth(dVar.yNC - com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 5));
            }
        } else if (chattingUI$a.yvJ.gg(auVar.field_msgId)) {
            CharSequence v2 = chattingUI$a.yvJ.v(auVar.field_msgId, auVar.field_imgPath);
            d.a gf = chattingUI$a.yvJ.gf(auVar.field_msgId);
            if (!bh.ov(v2)) {
                if (gf == d.a.yNV) {
                    this.vlQ.clear();
                    MMTextView mMTextView = dVar.yNH;
                    SpannableStringBuilder spannableStringBuilder = this.vlQ;
                    if (spannableStringBuilder == null || v2 == null || v2.length() == 0) {
                        v = spannableStringBuilder;
                    } else {
                        int length;
                        if (v2.length() < this.vlW) {
                            length = v2.length();
                            i2 = 0;
                        } else {
                            length = v2.length();
                            i2 = length - this.vlW;
                        }
                        spannableStringBuilder.append(v2).setSpan(this.vlT, i2, length, 33);
                        Object obj = spannableStringBuilder;
                    }
                    mMTextView.setText(v);
                } else {
                    dVar.yNH.setText(v2);
                }
                dVar.yNH.setVisibility(0);
                dVar.yNG.setVisibility(0);
                dVar.yNK.setVisibility(8);
                dVar.yNG.setMinimumWidth(dVar.yNC - com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 5));
                if (gf == d.a.yNW) {
                    dVar.mX(true);
                } else {
                    dVar.mX(false);
                }
            } else if (gf != d.a.yNT) {
                dVar.yNG.setVisibility(0);
                dVar.yNG.setMinimumWidth(dVar.yNC - com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 5));
                dVar.yNH.setVisibility(8);
                dVar.yNK.setVisibility(0);
            } else {
                dVar.yNL.setVisibility(0);
                dVar.yNG.setVisibility(8);
                dVar.yNK.setVisibility(8);
            }
            dVar.yNH.setMinWidth(com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 80));
            dVar.yNH.setMaxWidth(com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 259));
        } else {
            dVar.yNG.setVisibility(8);
            dVar.yNK.setVisibility(8);
        }
        n nVar = new n(auVar.field_content);
        if (nVar.time == 0) {
            dVar.yIz.setVisibility(8);
        } else {
            obj = ((chattingUI$a.ysf.ysR == null || chattingUI$a.ysf.ysR.yqm != auVar.field_msgId) && !q.C(auVar)) ? null : 1;
            dVar.yIz.setVisibility(obj != null ? 8 : 0);
            i2 = (int) q.bv(nVar.time);
            if (obj == null) {
                dVar.yNE.setContentDescription(String.format(chattingUI$a.getContext().getString(R.l.eTy), new Object[]{Integer.valueOf(i2)}));
            } else {
                com.tencent.mm.ui.a.a cnI = com.tencent.mm.ui.a.a.a.cnI();
                View view = dVar.yNE;
                chattingUI$a.gu(chattingUI$a.ysf.talker);
                cnI.H(view, i2);
            }
        }
        String str2 = auVar.gjD;
        if (str2 == null || str2.length() == 0) {
            dVar.yIW.setVisibility(8);
            return;
        }
        dVar.yIW.setVisibility(0);
        b(chattingUI$a, dVar.yIW, ar.Zx(str2));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            ah.c cVar = (ah.c) view.getTag();
            int i = cVar.position;
            if (cVar.kTK == 1) {
                if (!((new n(auVar.field_content).time == 0 && auVar.field_isSend == 0) || (auVar.field_status == 1 && auVar.field_isSend == 1))) {
                    int i2;
                    ar.Hg();
                    Boolean bool = (Boolean) c.CU().get(26, null);
                    if (bool == null) {
                        bool = Boolean.valueOf(false);
                    }
                    if (bool.booleanValue()) {
                        contextMenu.add(i, 120, 0, R.l.dQa);
                    } else {
                        contextMenu.add(i, 119, 0, R.l.dPZ);
                    }
                    ar.Hg();
                    x WO = c.EY().WO(auVar.field_talker);
                    Object obj = (s.gR(auVar.field_talker) || s.hn(auVar.field_talker) || WO == null || WO.cia()) ? null : 1;
                    if (com.tencent.mm.bm.d.OQ("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
                    }
                    if (obj != null) {
                        if (!((y.Mf().hr(2) > 0 ? 1 : null) == null || this.yqa.csV())) {
                            contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRD));
                        }
                    }
                    Object obj2 = null;
                    if (ah.b(auVar, this.yqa)) {
                        if (bh.ov(this.yqa.yvJ.v(auVar.field_msgId, auVar.field_imgPath))) {
                            i2 = R.l.dRY;
                        } else {
                            i2 = R.l.dRW;
                        }
                    } else if (this.yqa.yvJ.gg(auVar.field_msgId)) {
                        i2 = R.l.dRU;
                    } else {
                        i2 = R.l.dRY;
                    }
                    if (s.gF(auVar.field_talker) && w.cfe() && i2 != -1) {
                        contextMenu.add(i, 121, 0, i2);
                        obj2 = 1;
                    }
                    if (!this.yqa.csV()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRJ));
                    }
                    if (obj2 == null && w.cfe() && i2 != -1) {
                        contextMenu.add(i, 121, 0, i2);
                    }
                }
                return true;
            } else if (cVar.kTK == 2) {
                contextMenu.add(i, j.CTRL_INDEX, 0, view.getContext().getString(R.l.dRE));
                contextMenu.add(i, 142, 0, view.getContext().getString(R.l.eEC));
                if (com.tencent.mm.bm.d.OQ("favorite")) {
                    contextMenu.add(i, 143, 0, view.getContext().getString(R.l.eAd));
                }
                return false;
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
        String v;
        switch (menuItem.getItemId()) {
            case 119:
                chattingUI$a.yqp.mQ(true);
                return true;
            case 120:
                chattingUI$a.yqp.mQ(false);
                return true;
            case 121:
                ah.d(chattingUI$a, auVar);
                ab abVar = chattingUI$a.yvJ;
                if (ab.cub()) {
                    h.a(chattingUI$a.getContext(), chattingUI$a.getContext().getString(R.l.eTW), "", new 1(this, auVar, chattingUI$a));
                } else {
                    q.E(auVar);
                    chattingUI$a.yvJ.e(auVar, true);
                }
                b.hPA.x(auVar);
                return true;
            case j.CTRL_INDEX /*141*/:
                ClipboardManager clipboardManager = (ClipboardManager) chattingUI$a.getContext().getSystemService("clipboard");
                CharSequence v2 = chattingUI$a.yvJ.v(auVar.field_msgId, auVar.field_imgPath);
                if (!bh.ov(v2)) {
                    clipboardManager.setText(v2);
                }
                ah.e(8, auVar);
                break;
            case 142:
                Intent intent = new Intent(chattingUI$a.getContext(), MsgRetransmitUI.class);
                v = chattingUI$a.yvJ.v(auVar.field_msgId, auVar.field_imgPath);
                if (auVar.ciZ()) {
                    intent.putExtra("Retr_Msg_content", v);
                    intent.putExtra("Retr_Msg_Type", 6);
                } else {
                    intent.putExtra("Retr_Msg_content", v);
                    intent.putExtra("Retr_Msg_Type", 4);
                }
                chattingUI$a.startActivity(intent);
                ah.e(9, auVar);
                break;
            case 143:
                v = chattingUI$a.yvJ.v(auVar.field_msgId, auVar.field_imgPath);
                com.tencent.mm.sdk.b.b cfVar = new cf();
                f.a(cfVar, v, 1);
                cfVar.fqp.pL = chattingUI$a;
                cfVar.fqp.fqw = 43;
                if (cfVar.fqp.fqr != null) {
                    vk vkVar = cfVar.fqp.fqr.weS;
                    if (vkVar != null) {
                        vkVar.Ui(auVar.field_talker);
                        vkVar.Uj(com.tencent.mm.z.q.FS());
                        com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
                }
                ah.e(10, auVar);
                break;
        }
        return false;
    }

    public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
        ar arVar = (ar) view.getTag();
        b.hPA.w(arVar.fEJ);
        ah.a(chattingUI$a, arVar);
        return true;
    }
}
