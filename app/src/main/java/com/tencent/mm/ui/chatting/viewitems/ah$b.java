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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.b.ab;
import com.tencent.mm.ui.chatting.viewitems.ah.d;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

public final class ah$b extends b {
    private SpannableStringBuilder vlQ = new SpannableStringBuilder();
    private CharacterStyle vlT = new ForegroundColorSpan(-5066062);
    private int vlW = 3;
    private ChattingUI$a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 34) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.dee);
        view.setTag(new d().t(view, false));
        return view;
    }

    public final void a(a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        this.yqa = chattingUI$a;
        a aVar2 = (d) aVar;
        aVar2.yNF.xXq = false;
        boolean z = chattingUI$a.ypn;
        a(chattingUI$a.ysf, auVar.field_msgId);
        d.a(aVar2, auVar, i, chattingUI$a, false, s(chattingUI$a));
        CharSequence v;
        if (ah.b(auVar, chattingUI$a)) {
            v = chattingUI$a.yvJ.v(auVar.field_msgId, auVar.field_imgPath);
            if (bh.ov(v)) {
                aVar2.yNL.setVisibility(0);
                aVar2.yNG.setVisibility(8);
            } else {
                aVar2.yNH.setText(v);
                aVar2.yNH.setMinWidth(com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 80));
                aVar2.yNH.setMaxWidth(com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 259));
                aVar2.yNG.setVisibility(0);
                aVar2.yNH.setVisibility(0);
                aVar2.yNK.setVisibility(8);
                aVar2.mX(true);
                aVar2.yNG.setMinimumWidth(aVar2.yNC - com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 5));
            }
        } else {
            if (chattingUI$a.yvJ.gg(auVar.field_msgId)) {
                CharSequence v2 = chattingUI$a.yvJ.v(auVar.field_msgId, auVar.field_imgPath);
                d.a gf = chattingUI$a.yvJ.gf(auVar.field_msgId);
                aVar2.yNH.setMinWidth(com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 80));
                aVar2.yNH.setMaxWidth(com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 259));
                if (!bh.ov(v2)) {
                    if (gf == d.a.yNV) {
                        this.vlQ.clear();
                        MMTextView mMTextView = aVar2.yNH;
                        SpannableStringBuilder spannableStringBuilder = this.vlQ;
                        if (spannableStringBuilder == null || v2 == null || v2.length() == 0) {
                            v = spannableStringBuilder;
                        } else {
                            int length;
                            int i2;
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
                        aVar2.yNH.setText(v2);
                    }
                    aVar2.yNH.setVisibility(0);
                    aVar2.yNG.setVisibility(0);
                    aVar2.yNK.setVisibility(8);
                    aVar2.yNG.setMinimumWidth(aVar2.yNC - com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 5));
                    if (gf == d.a.yNW) {
                        aVar2.mX(true);
                    } else {
                        aVar2.mX(false);
                    }
                } else if (gf != d.a.yNT) {
                    aVar2.yNG.setVisibility(0);
                    aVar2.yNG.setMinimumWidth(aVar2.yNC - com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 5));
                    aVar2.yNK.setVisibility(0);
                    aVar2.yNH.setVisibility(8);
                } else {
                    aVar2.yNL.setVisibility(0);
                }
            }
            aVar2.yNG.setVisibility(8);
            aVar2.yNK.setVisibility(8);
        }
        if (cvy()) {
            if (aVar2.yNP != null) {
                aVar2.yNP.setVisibility(8);
            }
            if (aVar2.yJk != null) {
                aVar2.yJk.setVisibility(8);
            }
            if (auVar.field_status == 1 || auVar.field_status == 5) {
                aVar2.yNQ.setBackgroundResource(R.g.bBu);
                auVar.xze = true;
            } else {
                aVar2.yNQ.setBackgroundResource(R.g.bBt);
                if (aVar2.yJk != null && a(chattingUI$a.ysf, auVar.field_msgId)) {
                    if (auVar.xze) {
                        Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                        alphaAnimation.setDuration(300);
                        aVar2.yNQ.startAnimation(alphaAnimation);
                        auVar.xze = false;
                    }
                    aVar2.yJk.setVisibility(0);
                }
            }
        } else if (aVar2.yNP != null) {
            aVar2.yNP.setVisibility(0);
            if (auVar.field_status >= 2) {
                aVar2.yNP.setVisibility(8);
            }
        }
        a(i, aVar2, auVar, chattingUI$a.ysf.hlJ, chattingUI$a.ypn, chattingUI$a);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ar.Hg();
        if (!c.isSDCardAvailable()) {
            return true;
        }
        ah.c cVar = (ah.c) view.getTag();
        int i = cVar.position;
        if (cVar.kTK == 1) {
            int i2;
            boolean z;
            n nVar = new n(auVar.field_content);
            if (!((nVar.time == 0 && auVar.field_isSend == 0) || (auVar.field_status == 1 && auVar.field_isSend == 1))) {
                if (this.yqa.yqp.kCV) {
                    contextMenu.add(i, 120, 0, R.l.dQa);
                } else {
                    contextMenu.add(i, 119, 0, R.l.dPZ);
                }
            }
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dSI));
            }
            if (com.tencent.mm.bm.d.OQ("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
            }
            if (!auVar.ciV() && auVar.ciW() && ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
            }
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
                z = true;
            } else {
                z = false;
            }
            if (!((nVar.time == 0 && auVar.field_isSend == 0) || ((auVar.field_status == 1 && auVar.field_isSend == 1) || this.yqa.csV()))) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRJ));
            }
            if (z || !w.cfe() || i2 == -1) {
                return true;
            }
            contextMenu.add(i, 121, 0, i2);
            return true;
        } else if (cVar.kTK != 2) {
            return true;
        } else {
            contextMenu.add(i, j.CTRL_INDEX, 0, view.getContext().getString(R.l.dRE));
            contextMenu.add(i, 142, 0, view.getContext().getString(R.l.eEC));
            if (com.tencent.mm.bm.d.OQ("favorite")) {
                contextMenu.add(i, 143, 0, view.getContext().getString(R.l.eAd));
            }
            return false;
        }
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
                    h.a(chattingUI$a.getContext(), chattingUI$a.getContext().getString(R.l.eTW), "", new 1(this, chattingUI$a, auVar));
                } else {
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
                        vkVar.Ui(q.FS());
                        vkVar.Uj(auVar.field_talker);
                        com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    }
                } else {
                    x.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
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
