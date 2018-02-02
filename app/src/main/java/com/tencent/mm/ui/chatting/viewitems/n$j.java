package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.aq.q;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.viewitems.n.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.i;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.Serializable;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

public class n$j extends b {
    private static int pBd = 0;
    private static int pBe = 0;
    private static int yLa = 0;
    private static int yLb;
    private static int yLc;
    private static int yLd;
    private boolean yLe = false;
    private int yLf = 0;
    private long yLg = 0;
    private boolean yLh = false;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == 285212721) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view == null || view.getTag() == null) {
            view = new p(layoutInflater, R.i.ddd);
            n$c com_tencent_mm_ui_chatting_viewitems_n_c = new n$c();
            com_tencent_mm_ui_chatting_viewitems_n_c.ldK = (TextView) view.findViewById(R.h.bVf);
            com_tencent_mm_ui_chatting_viewitems_n_c.yIx = view.findViewById(R.h.bUh);
            com_tencent_mm_ui_chatting_viewitems_n_c.yKM = (LinearLayout) view.findViewById(R.h.bTJ);
            com_tencent_mm_ui_chatting_viewitems_n_c.mSc = (CheckBox) view.findViewById(R.h.bTC);
            com_tencent_mm_ui_chatting_viewitems_n_c.jWc = view.findViewById(R.h.bUC);
            com_tencent_mm_ui_chatting_viewitems_n_c.yIW = (TextView) view.findViewById(R.h.bSZ);
            view.setTag(com_tencent_mm_ui_chatting_viewitems_n_c);
        }
        fQ(layoutInflater.getContext());
        return view;
    }

    private static void fQ(Context context) {
        if (pBd == 0) {
            pBd = context.getResources().getDimensionPixelSize(R.f.bvS);
            yLa = context.getResources().getDimensionPixelSize(R.f.bvB);
            pBe = context.getResources().getDimensionPixelSize(R.f.bvv);
            yLd = context.getResources().getDimensionPixelSize(R.f.bwQ);
            yLc = context.getResources().getDimensionPixelSize(R.f.bwP);
            yLb = context.getResources().getDimensionPixelSize(R.f.bwO);
        }
    }

    protected final boolean cvx() {
        return false;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        this.yqa = aVar2;
        fQ(aVar2.getContext());
        final n$c com_tencent_mm_ui_chatting_viewitems_n_c = (n$c) aVar;
        for (n$a com_tencent_mm_ui_chatting_viewitems_n_a : com_tencent_mm_ui_chatting_viewitems_n_c.pBs) {
            if (com_tencent_mm_ui_chatting_viewitems_n_c.pBs.indexOf(com_tencent_mm_ui_chatting_viewitems_n_a) != com_tencent_mm_ui_chatting_viewitems_n_c.pBs.size() - 1) {
                aj.K(com_tencent_mm_ui_chatting_viewitems_n_a.pBg, 1);
            } else {
                aj.K(com_tencent_mm_ui_chatting_viewitems_n_a.pBg, 2);
            }
            com_tencent_mm_ui_chatting_viewitems_n_c.yKM.removeView(com_tencent_mm_ui_chatting_viewitems_n_a.pBg);
        }
        com_tencent_mm_ui_chatting_viewitems_n_c.pBs.clear();
        l vL = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(auVar.field_content);
        String str2 = vL.gjD;
        if (str2 == null || str2.length() == 0) {
            com_tencent_mm_ui_chatting_viewitems_n_c.yIW.setVisibility(8);
        } else {
            com_tencent_mm_ui_chatting_viewitems_n_c.yIW.setVisibility(0);
            b(aVar2, com_tencent_mm_ui_chatting_viewitems_n_c.yIW, ar.Zx(str2));
        }
        List list = vL.hdX;
        int size = list.size();
        if (size == 0) {
            com_tencent_mm_ui_chatting_viewitems_n_c.yKM.setVisibility(8);
            a(com_tencent_mm_ui_chatting_viewitems_n_c, -1, 0);
            return;
        }
        int size2;
        com_tencent_mm_ui_chatting_viewitems_n_c.yKM.setVisibility(0);
        a(com_tencent_mm_ui_chatting_viewitems_n_c, ((m) list.get(0)).type, size);
        LayoutInflater layoutInflater = aVar2.getLayoutInflater();
        for (size2 = com_tencent_mm_ui_chatting_viewitems_n_c.pBs.size() + 2; size2 < size; size2++) {
            View FB = aj.FB(1);
            if (FB == null) {
                FB = layoutInflater.inflate(R.i.dde, null);
            }
            com_tencent_mm_ui_chatting_viewitems_n_c.dA(FB);
        }
        if (size > 1) {
            FB = aj.FB(2);
            if (FB == null) {
                FB = layoutInflater.inflate(R.i.ddf, null);
            }
            com_tencent_mm_ui_chatting_viewitems_n_c.dA(FB);
            this.yLe = true;
        } else {
            this.yLe = false;
        }
        for (size2 = 0; size2 < com_tencent_mm_ui_chatting_viewitems_n_c.pBs.size(); size2++) {
            ((n$a) com_tencent_mm_ui_chatting_viewitems_n_c.pBs.get(size2)).pBg.setVisibility(8);
        }
        m mVar = (m) list.get(0);
        CharSequence Gk;
        if (mVar.type == 5) {
            boolean z;
            if (t.ov(mVar.title)) {
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.jpW.setVisibility(8);
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.jpW.setText(mVar.title);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.jpW.setVisibility(0);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.jpW.setTextColor(this.yqa.getContext().getResources().getColor(R.e.bta));
            }
            if (size == 1) {
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.yKL.setBackgroundResource(R.g.bzy);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.yKV.setBackgroundResource(R.g.bBq);
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.yKL.setBackgroundResource(R.g.bzB);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.yKV.setBackgroundResource(R.g.bBr);
            }
            Gk = Gk(mVar.heh);
            if (TextUtils.isEmpty(Gk)) {
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.lUD.setVisibility(8);
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.lUD.setVisibility(0);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.lUD.setText(Gk);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKO.lUD.setTextColor(this.yqa.getContext().getResources().getColor(R.e.bta));
            }
            a(com_tencent_mm_ui_chatting_viewitems_n_c, mVar, auVar, i, vL);
            com_tencent_mm_ui_chatting_viewitems_n_c.yKO.yKL.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_n_c.yKO.jMv.setImageResource(R.k.dxF);
            String str3 = mVar.hed;
            ImageView imageView = com_tencent_mm_ui_chatting_viewitems_n_c.yKO.pBi;
            int type = auVar.getType();
            if (size > 1) {
                z = true;
            } else {
                z = false;
            }
            a(str3, imageView, type, z, yLd, new c(this) {
                final /* synthetic */ n$j yLl;

                public final void onFinish() {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKO.yKL.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKO.jpW.setTextColor(this.yLl.yqa.getContext().getResources().getColor(R.e.white));
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKO.lUD.setTextColor(this.yLl.yqa.getContext().getResources().getColor(R.e.white));
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKO.jMv.setImageResource(R.k.dxE);
                }
            });
        } else {
            l lVar;
            au auVar2;
            m mVar2;
            n$c com_tencent_mm_ui_chatting_viewitems_n_c2;
            n$j com_tencent_mm_ui_chatting_viewitems_n_j;
            int i2;
            if (mVar.type == 8) {
                com_tencent_mm_ui_chatting_viewitems_n_c.yKP.jpW.setText(mVar.het);
                if (size == 1) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKP.yKL.setBackgroundResource(R.g.bzz);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKP.yKV.setBackgroundResource(R.g.bBq);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKP.yKW.setBackgroundResource(R.g.bzt);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKP.yKL.setBackgroundResource(R.g.bzC);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKP.yKV.setBackgroundResource(R.g.bBr);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKP.yKW.setBackgroundResource(R.g.bzv);
                }
                com_tencent_mm_ui_chatting_viewitems_n_c.yKP.yKL.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKP.yKW.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKP.jpW.setTextColor(this.yqa.getContext().getResources().getColor(R.e.bta));
                com_tencent_mm_ui_chatting_viewitems_n_c.yKP.jMv.setBackgroundResource(R.k.dxC);
                a(mVar.hed, com_tencent_mm_ui_chatting_viewitems_n_c.yKP.pBi, auVar.getType(), size > 1, yLd, new 5(this, com_tencent_mm_ui_chatting_viewitems_n_c));
                lVar = vL;
                auVar2 = auVar;
                mVar2 = mVar;
                com_tencent_mm_ui_chatting_viewitems_n_c2 = com_tencent_mm_ui_chatting_viewitems_n_c;
                com_tencent_mm_ui_chatting_viewitems_n_j = this;
                i2 = i;
            } else if (mVar.type == 7) {
                if (t.ov(mVar.title)) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.jpW.setVisibility(8);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.jpW.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.jpW.setText(mVar.title);
                }
                if (size > 1) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.pBg.setBackgroundResource(R.g.bBl);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.pBg.setBackgroundResource(R.g.bBm);
                }
                Gk = Gk(mVar.heh);
                if (TextUtils.isEmpty(Gk)) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.nou.setVisibility(4);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.nou.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.nou.setText(Gk);
                }
                Drawable drawable = com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.yKK.getDrawable();
                if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                    ((AnimationDrawable) drawable).stop();
                }
                if ((auVar.field_msgId + "_0").equals(com_tencent_mm_ui_chatting_viewitems_n_c.yIA)) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.yKK.setImageResource(R.g.bBh);
                    if (com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.yKK.getDrawable() instanceof AnimationDrawable) {
                        ((AnimationDrawable) com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.yKK.getDrawable()).start();
                    }
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.yKK.setImageResource(R.g.bBg);
                }
                a(com_tencent_mm_ui_chatting_viewitems_n_c.yKQ.yKK, auVar, 0, mVar.hed);
                lVar = vL;
                auVar2 = auVar;
                mVar2 = mVar;
                com_tencent_mm_ui_chatting_viewitems_n_c2 = com_tencent_mm_ui_chatting_viewitems_n_c;
                com_tencent_mm_ui_chatting_viewitems_n_j = this;
                i2 = i;
            } else if (mVar.type == 6) {
                mVar2 = (m) list.get(0);
                if (t.ov(mVar2.title)) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.jpW.setVisibility(8);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.jpW.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.jpW.setText(mVar2.title);
                }
                if (size > 1) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.pBg.setBackgroundResource(R.g.bBl);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.pBg.setBackgroundResource(R.g.bBm);
                }
                if (TextUtils.isEmpty(mVar2.her)) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.yKT.setVisibility(8);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.yKT.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.yKT.setText(mVar2.her);
                }
                if (mVar2.hes == 2) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.yKU.setImageResource(R.k.dxy);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.yKU.setImageResource(R.k.dxD);
                }
                a(com_tencent_mm_ui_chatting_viewitems_n_c.yKR.yKK, auVar, 0, mVar2.hed);
                a(com_tencent_mm_ui_chatting_viewitems_n_c, mVar2, auVar, i, vL);
                if ((auVar.field_msgId + "_0").equals(com_tencent_mm_ui_chatting_viewitems_n_c.yIA)) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.yKK.setImageResource(R.k.dxz);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKR.yKK.setImageResource(R.k.dxA);
                }
                com_tencent_mm_ui_chatting_viewitems_n_c.yKR.yKL.setVisibility(8);
                a(mVar2.hed, com_tencent_mm_ui_chatting_viewitems_n_c.yKR.pBi, auVar.getType(), yLc, yLc, "@S", new 4(this, com_tencent_mm_ui_chatting_viewitems_n_c, auVar));
            } else if (mVar.type == 10) {
                if (t.ov(mVar.title)) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKS.jpW.setVisibility(8);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKS.jpW.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKS.jpW.setText(mVar.title);
                }
                if (size > 1) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKS.pBg.setBackgroundResource(R.g.bBl);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKS.yKZ.setVisibility(8);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKS.jpW.setTextSize(1, 18.0f * com.tencent.mm.bv.a.eu(this.yqa.getContext()));
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKS.pBg.setBackgroundResource(R.g.bBm);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKS.yKZ.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKS.jpW.setTextSize(1, 15.0f * com.tencent.mm.bv.a.eu(this.yqa.getContext()));
                }
                a(com_tencent_mm_ui_chatting_viewitems_n_c, mVar, auVar, i, vL);
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_c.yKN.jpW.setVisibility(size > 1 ? 8 : 0);
                TextView textView = com_tencent_mm_ui_chatting_viewitems_n_c.yKN.pBC;
                int i3 = (size > 1 || t.ov(mVar.hef)) ? 8 : 0;
                textView.setVisibility(i3);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKY.setVisibility(size > 1 ? 0 : 8);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKW.setVisibility(8);
                if (size == 1) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKV.setBackgroundResource(R.g.bBq);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.xPF.setVisibility(0);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.xPF.setVisibility(t.ov(mVar.hed) ? 0 : 8);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKV.setBackgroundResource(R.g.bBr);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKY.setTextColor(this.yqa.getContext().getResources().getColor(R.e.bta));
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKY.setBackgroundResource(R.g.bDJ);
                }
                if (t.ov(mVar.hed)) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKX.setVisibility(8);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.jpW.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.pBC.setVisibility(t.ov(mVar.hef) ? 8 : 0);
                    if (size == 1) {
                        com_tencent_mm_ui_chatting_viewitems_n_c.yKN.xPF.setBackgroundResource(R.g.bBm);
                    } else {
                        com_tencent_mm_ui_chatting_viewitems_n_c.yKN.xPF.setBackgroundResource(R.g.bBl);
                    }
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.xPF.setPadding(pBe, pBe, pBe, pBe);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKV.setVisibility(8);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKX.setVisibility(0);
                    a(mVar.hed, com_tencent_mm_ui_chatting_viewitems_n_c.yKN.pBi, auVar.getType(), true, yLd, new 2(this, size, com_tencent_mm_ui_chatting_viewitems_n_c));
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.xPF.setBackgroundResource(R.g.bBi);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.xPF.setPadding(pBe, yLa, pBe, pBe);
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKV.setVisibility(0);
                }
                com_tencent_mm_ui_chatting_viewitems_n_c.yKN.pBC.setText(mVar.hef);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKN.jpW.setText(mVar.title);
                com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKY.setText(mVar.title);
                if (!(mVar.heg == 0 || mVar.heg == 1)) {
                    com_tencent_mm_ui_chatting_viewitems_n_c.yKN.yKY.setVisibility(4);
                }
                lVar = vL;
                auVar2 = auVar;
                mVar2 = mVar;
                com_tencent_mm_ui_chatting_viewitems_n_c2 = com_tencent_mm_ui_chatting_viewitems_n_c;
                com_tencent_mm_ui_chatting_viewitems_n_j = this;
                i2 = i;
            }
            com_tencent_mm_ui_chatting_viewitems_n_j.a(com_tencent_mm_ui_chatting_viewitems_n_c2, mVar2, auVar2, i2, lVar);
        }
        int i4 = 1;
        while (i4 < size) {
            ar arVar;
            m mVar3 = (m) list.get(i4);
            n$a com_tencent_mm_ui_chatting_viewitems_n_a2 = (n$a) com_tencent_mm_ui_chatting_viewitems_n_c.pBs.get(i4 - 1);
            i3 = mVar.type;
            if (i4 != 1 || (i3 != 5 && i3 != 8 && i3 != 0)) {
                com_tencent_mm_ui_chatting_viewitems_n_a2.yKI.setVisibility(0);
                LayoutParams layoutParams;
                if (i4 > 1) {
                    m mVar4 = (m) list.get(i4 - 1);
                    m mVar5 = (m) list.get(i4);
                    if ((mVar4.type == 7 || mVar4.type == 5 || mVar4.type == 6 || !t.ov(mVar4.hed)) && (mVar5.type == 7 || mVar5.type == 5 || mVar5.type == 6 || !t.ov(mVar5.hed))) {
                        layoutParams = (LayoutParams) com_tencent_mm_ui_chatting_viewitems_n_a2.yKI.getLayoutParams();
                        layoutParams.rightMargin = yLb;
                        com_tencent_mm_ui_chatting_viewitems_n_a2.yKI.setLayoutParams(layoutParams);
                    } else {
                        layoutParams = (LayoutParams) com_tencent_mm_ui_chatting_viewitems_n_a2.yKI.getLayoutParams();
                        layoutParams.rightMargin = pBe;
                        com_tencent_mm_ui_chatting_viewitems_n_a2.yKI.setLayoutParams(layoutParams);
                    }
                } else {
                    layoutParams = (LayoutParams) com_tencent_mm_ui_chatting_viewitems_n_a2.yKI.getLayoutParams();
                    layoutParams.rightMargin = pBe;
                    com_tencent_mm_ui_chatting_viewitems_n_a2.yKI.setLayoutParams(layoutParams);
                }
            } else if (i3 == 0 && t.ov(((m) list.get(i4)).hed)) {
                com_tencent_mm_ui_chatting_viewitems_n_a2.yKI.setVisibility(0);
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_a2.yKI.setVisibility(8);
            }
            if (i4 == 1) {
                if (i4 == size - 1) {
                    com_tencent_mm_ui_chatting_viewitems_n_a2.lWw.setPadding(0, pBe, 0, pBe);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_a2.lWw.setPadding(0, pBe, 0, pBd);
                }
            } else if (i4 == size - 1) {
                com_tencent_mm_ui_chatting_viewitems_n_a2.lWw.setPadding(0, pBd, 0, pBe);
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_a2.lWw.setPadding(0, pBd, 0, pBd);
            }
            a(com_tencent_mm_ui_chatting_viewitems_n_c, com_tencent_mm_ui_chatting_viewitems_n_a2, mVar3, auVar, i4, false);
            com_tencent_mm_ui_chatting_viewitems_n_a2.jpW.setText(mVar3.title);
            com_tencent_mm_ui_chatting_viewitems_n_a2.jpW.setTextColor(aVar2.getResources().getColor(R.e.black));
            if (mVar3.heg == 0 || mVar3.heg == 1) {
                com_tencent_mm_ui_chatting_viewitems_n_a2.pBh.setVisibility(0);
                com_tencent_mm_ui_chatting_viewitems_n_a2.jpW.setTextColor(aVar2.getResources().getColor(R.e.black));
                if (mVar3.type == 7) {
                    a(R.g.bBf, com_tencent_mm_ui_chatting_viewitems_n_a2.pBi, yLc, yLc);
                } else if (!t.ov(mVar3.hed)) {
                    a(mVar3.hed, com_tencent_mm_ui_chatting_viewitems_n_a2.pBi, auVar.getType(), yLc, yLc, "@S", new 1(this, com_tencent_mm_ui_chatting_viewitems_n_c, com_tencent_mm_ui_chatting_viewitems_n_a2, mVar3, auVar, i4));
                } else if (mVar3.type == 5 || mVar3.type == 6) {
                    a(R.g.bBf, com_tencent_mm_ui_chatting_viewitems_n_a2.pBi, yLc, yLc);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_a2.pBh.setVisibility(8);
                }
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_a2.pBh.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_n_a2.jpW.setTextColor(aVar2.getResources().getColor(R.e.bsO));
            }
            if (t.ov(mVar3.hef) || mVar3.type != 3) {
                com_tencent_mm_ui_chatting_viewitems_n_a2.yKJ.setVisibility(8);
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_a2.yKJ.setText(mVar3.hef);
                com_tencent_mm_ui_chatting_viewitems_n_a2.yKJ.setVisibility(0);
            }
            com_tencent_mm_ui_chatting_viewitems_n_a2.pBg.setVisibility(0);
            Object Zh = aVar2.ywd.Zh(mVar3.url);
            if (TextUtils.isEmpty(Zh)) {
                arVar = new ar(auVar, false, i, mVar3.url, this.yLe, aVar2.csX(), vL.fGz, vL.fGA);
                a(arVar, mVar3, auVar);
                com_tencent_mm_ui_chatting_viewitems_n_a2.pBg.setOnClickListener(w(aVar2));
            } else {
                x.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[]{Zh});
                arVar = new ar(auVar, false, i, mVar3.url, this.yLe, aVar2.csX(), vL.fGz, vL.fGA, mVar3.title, Zh, null, false, true);
                com_tencent_mm_ui_chatting_viewitems_n_a2.pBg.setOnClickListener(x(aVar2));
            }
            arVar.ttf = auVar.field_msgSvrId;
            arVar.ttg = i4;
            com_tencent_mm_ui_chatting_viewitems_n_a2.pBg.setTag(arVar);
            if (i.fV(mVar3.hei)) {
                a(mVar3, com_tencent_mm_ui_chatting_viewitems_n_a2.pBg);
            }
            com_tencent_mm_ui_chatting_viewitems_n_a2.pBg.setOnLongClickListener(s(aVar2));
            com_tencent_mm_ui_chatting_viewitems_n_a2.pBg.setOnTouchListener(aVar2.ysf.ysV);
            i4++;
        }
    }

    private void a(n$c com_tencent_mm_ui_chatting_viewitems_n_c, m mVar, au auVar, int i, l lVar) {
        ar arVar;
        Object Zh = this.yqa.ywd.Zh(mVar.url);
        if (TextUtils.isEmpty(Zh)) {
            arVar = new ar(auVar, false, i, mVar.url, false, this.yqa.csX(), lVar.fGz, lVar.fGA, mVar.title);
            a(arVar, mVar, auVar);
            com_tencent_mm_ui_chatting_viewitems_n_c.yKM.setOnClickListener(w(this.yqa));
        } else {
            x.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[]{Zh});
            arVar = new ar(auVar, false, i, mVar.url, false, this.yqa.csX(), lVar.fGz, lVar.fGA, mVar.title, Zh, null, false, false);
            com_tencent_mm_ui_chatting_viewitems_n_c.yKM.setOnClickListener(x(this.yqa));
        }
        arVar.ttf = auVar.field_msgSvrId;
        arVar.ttg = 0;
        com_tencent_mm_ui_chatting_viewitems_n_c.yKM.setTag(arVar);
        if (i.fV(mVar.hei)) {
            a(mVar, com_tencent_mm_ui_chatting_viewitems_n_c.yKM);
        }
        com_tencent_mm_ui_chatting_viewitems_n_c.yKM.setOnLongClickListener(s(this.yqa));
        com_tencent_mm_ui_chatting_viewitems_n_c.yKM.setOnTouchListener(this.yqa.ysf.ysV);
    }

    private void a(n$c com_tencent_mm_ui_chatting_viewitems_n_c, n$a com_tencent_mm_ui_chatting_viewitems_n_a, m mVar, au auVar, int i, boolean z) {
        if (mVar.type == 5) {
            com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setVisibility(0);
            if (z) {
                com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setImageResource(R.k.dxG);
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setImageResource(R.k.dxH);
            }
            com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setOnClickListener(new 6(this, com_tencent_mm_ui_chatting_viewitems_n_a));
        } else if (mVar.type == 6) {
            com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setVisibility(0);
            if (z) {
                if ((auVar.field_msgId + "_" + i).equals(com_tencent_mm_ui_chatting_viewitems_n_c.yIA)) {
                    com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setImageResource(R.g.bBd);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setImageResource(R.g.bBe);
                }
            } else if ((auVar.field_msgId + "_" + i).equals(com_tencent_mm_ui_chatting_viewitems_n_c.yIA)) {
                com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setImageResource(R.k.dxz);
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setImageResource(R.k.dxA);
            }
            a(com_tencent_mm_ui_chatting_viewitems_n_a.yKK, auVar, i, mVar.hed);
        } else if (mVar.type == 7) {
            com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setVisibility(0);
            Drawable drawable = com_tencent_mm_ui_chatting_viewitems_n_a.yKK.getDrawable();
            if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                ((AnimationDrawable) drawable).stop();
            }
            if ((auVar.field_msgId + "_" + i).equals(com_tencent_mm_ui_chatting_viewitems_n_c.yIA)) {
                com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setImageResource(R.g.bBh);
                if (com_tencent_mm_ui_chatting_viewitems_n_a.yKK.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) com_tencent_mm_ui_chatting_viewitems_n_a.yKK.getDrawable()).start();
                }
            } else {
                com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setImageResource(R.g.bBg);
            }
            a(com_tencent_mm_ui_chatting_viewitems_n_a.yKK, auVar, i, mVar.hed);
        } else {
            com_tencent_mm_ui_chatting_viewitems_n_a.yKK.setVisibility(8);
        }
    }

    private void a(ImageView imageView, au auVar, int i, String str) {
        c$f com_tencent_mm_ui_chatting_viewitems_c_f = new c$f();
        com_tencent_mm_ui_chatting_viewitems_c_f.fqm = auVar.field_msgId;
        com_tencent_mm_ui_chatting_viewitems_c_f.yJJ = i;
        com_tencent_mm_ui_chatting_viewitems_c_f.fCs = auVar.field_content;
        com_tencent_mm_ui_chatting_viewitems_c_f.fzs = str;
        imageView.setTag(com_tencent_mm_ui_chatting_viewitems_c_f);
        imageView.setOnClickListener(this.yqa.ysf.yta);
    }

    private static void a(View view, b bVar, boolean z) {
        if (z) {
            if (bVar.pBg == null) {
                bVar.dz(view);
            }
            if (bVar.pBg != null) {
                bVar.pBg.setVisibility(0);
            }
        } else if (bVar.pBg != null) {
            bVar.pBg.setVisibility(8);
        }
    }

    private static void a(n$c com_tencent_mm_ui_chatting_viewitems_n_c, int i, int i2) {
        boolean z;
        boolean z2 = true;
        boolean z3 = i == 5;
        a(com_tencent_mm_ui_chatting_viewitems_n_c.yKM, com_tencent_mm_ui_chatting_viewitems_n_c.yKO, z3);
        if (z3) {
            z = true;
        } else {
            z = false;
        }
        if (i == 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(com_tencent_mm_ui_chatting_viewitems_n_c.yKM, com_tencent_mm_ui_chatting_viewitems_n_c.yKP, z3);
        if (z3) {
            z = true;
        }
        if (i == 7) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(com_tencent_mm_ui_chatting_viewitems_n_c.yKM, com_tencent_mm_ui_chatting_viewitems_n_c.yKQ, z3);
        if (z3) {
            z = true;
        }
        if (i == 6) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(com_tencent_mm_ui_chatting_viewitems_n_c.yKM, com_tencent_mm_ui_chatting_viewitems_n_c.yKR, z3);
        if (z3) {
            z = true;
        }
        if (i == 10) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(com_tencent_mm_ui_chatting_viewitems_n_c.yKM, com_tencent_mm_ui_chatting_viewitems_n_c.yKS, z3);
        if (z3) {
            z3 = true;
        } else {
            z3 = z;
        }
        View view = com_tencent_mm_ui_chatting_viewitems_n_c.yKM;
        b bVar = com_tencent_mm_ui_chatting_viewitems_n_c.yKN;
        if (z3 || i2 <= 0) {
            z2 = false;
        }
        a(view, bVar, z2);
    }

    private static String Gk(int i) {
        if (i <= 0 || ((long) i) >= 86400) {
            return null;
        }
        String str;
        if (((long) i) < 3600) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        return simpleDateFormat.format(Long.valueOf(((long) i) * 1000));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ar arVar = (ar) view.getTag();
        if (arVar == null) {
            return false;
        }
        this.yLf = arVar.ttg;
        int i = arVar.position;
        l vL = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(auVar.field_content);
        if (vL == null) {
            x.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
            return false;
        }
        this.yLh = false;
        if (this.yLf >= 0 && this.yLf < vL.hdX.size() && i.fV(((m) vL.hdX.get(this.yLf)).hei)) {
            this.yLh = true;
        }
        if (!(this.yqa.csV() || com.tencent.mm.ui.chatting.i.ar(auVar))) {
            contextMenu.add(i, 111, 0, view.getContext().getString(R.l.eEC));
        }
        if (d.OQ("favorite") && !this.yLh) {
            contextMenu.add(i, 125, 0, view.getContext().getString(R.l.eAd));
        }
        return true;
    }

    private void a(ar arVar, m mVar, au auVar) {
        int i;
        Bundle bundle = new Bundle();
        switch (com.tencent.mm.z.t.N(a(this.yqa, auVar), this.yqa.crz())) {
            case 1:
                i = 3;
                break;
            case 2:
                i = 2;
                break;
            case 6:
            case 7:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        bundle.putString("share_report_pre_msg_url", mVar.url);
        bundle.putString("share_report_pre_msg_title", mVar.title);
        bundle.putString("share_report_pre_msg_desc", mVar.hef);
        bundle.putString("share_report_pre_msg_icon_url", mVar.hed);
        bundle.putString("share_report_pre_msg_appid", "");
        bundle.putInt("share_report_from_scene", i);
        if (i == 5) {
            bundle.putString("share_report_biz_username", this.yqa.crz());
        }
        arVar.yOK = bundle;
    }

    private static void a(String str, ImageView imageView, int i, int i2, int i3, String str2, c cVar) {
        String lw;
        if (q.PE()) {
            lw = q.lw(str);
        } else {
            lw = str;
        }
        com.tencent.mm.aq.a.a PA = o.PA();
        c.a aVar = new c.a();
        aVar.hDT = R.e.brS;
        aVar.hDA = true;
        aVar = aVar.bc(i2, i3);
        aVar.hDq = new b();
        aVar.hDC = com.tencent.mm.pluginsdk.model.t.v(lw, i, str2);
        PA.a(lw, imageView, aVar.PK(), null, new a(0, 0, 0, cVar));
    }

    private static void a(String str, ImageView imageView, int i, int i2) {
        com.tencent.mm.aq.a.a PA = o.PA();
        c.a aVar = new c.a();
        aVar.hDy = true;
        aVar.hDP = R.e.brS;
        aVar = aVar.bc(i, i2);
        aVar.hDF = 4;
        PA.a(str, imageView, aVar.PK(), null, new a());
    }

    private static void a(String str, ImageView imageView, int i, boolean z, int i2, c cVar) {
        String lw;
        if (q.PE()) {
            lw = q.lw(str);
        } else {
            lw = str;
        }
        int i3 = z ? R.g.bzu : R.g.bzs;
        int i4 = z ? R.g.bzA : R.g.bzx;
        int eA = com.tencent.mm.bv.a.eA(imageView.getContext()) - ((int) (com.tencent.mm.bv.a.getDensity(imageView.getContext()) * 32.0f));
        com.tencent.mm.aq.a.a PA = o.PA();
        c.a aVar = new c.a();
        aVar.hDT = i4;
        aVar.hDA = true;
        aVar.hDV = String.valueOf(i3);
        c.a bc = aVar.bc(eA, i2);
        bc.hDq = new b();
        bc.hDC = com.tencent.mm.pluginsdk.model.t.v(lw, i, "@T");
        PA.a(lw, imageView, bc.PK(), null, new a(i3, eA, i2, cVar));
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        this.yLg = t.Wo();
        String a;
        u.b t;
        String a2;
        switch (menuItem.getItemId()) {
            case 111:
                String hz;
                if (this.yLh) {
                    if (!this.yLh) {
                        x.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
                        break;
                    }
                    l vL = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(auVar.field_content);
                    if (vL != null) {
                        if (this.yLf >= 0 && this.yLf < vL.hdX.size()) {
                            m mVar = (m) vL.hdX.get(this.yLf);
                            a = com.tencent.mm.y.g.a.a(k.a(auVar.field_talker, mVar), null, null);
                            if (!t.ov(a)) {
                                Serializable hashMap = new HashMap();
                                hashMap.put("desc", mVar.hef);
                                hashMap.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(2));
                                hashMap.put("title", mVar.title);
                                hashMap.put("app_id", mVar.hem);
                                hashMap.put("pkg_type", Integer.valueOf(mVar.hel));
                                hashMap.put("pkg_version", Integer.valueOf(mVar.hek));
                                hashMap.put("img_url", mVar.hen);
                                hashMap.put("is_dynamic", Boolean.valueOf(false));
                                hashMap.put("cache_key", "");
                                hashMap.put("path", mVar.hej);
                                Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                                intent.putExtra("appbrand_params", hashMap);
                                intent.putExtra("Retr_Msg_content", a);
                                intent.putExtra("Retr_Msg_Type", 2);
                                intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.yLf);
                                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                                intent.putExtra("Retr_MsgFromScene", 3);
                                a = auVar.field_talker;
                                hz = u.hz(auVar.field_msgSvrId);
                                intent.putExtra("reportSessionId", hz);
                                t = u.GK().t(hz, true);
                                t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                                t.o("preUsername", a);
                                t.o("preChatName", a);
                                t.o("preMsgIndex", Integer.valueOf(this.yLf));
                                t.o("sendAppMsgScene", Integer.valueOf(1));
                                aVar.startActivity(intent);
                                break;
                            }
                        }
                    }
                    x.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg reader is null");
                    break;
                }
                a2 = a(auVar, aVar.getContext(), this.yLf);
                if (!t.ov(a2)) {
                    Intent intent2 = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                    intent2.putExtra("Retr_Msg_content", a2);
                    intent2.putExtra("Retr_Msg_Type", 2);
                    intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.yLf);
                    intent2.putExtra("Retr_Msg_Id", auVar.field_msgId);
                    intent2.putExtra("Retr_MsgFromScene", 1);
                    a2 = auVar.field_talker;
                    hz = u.hz(auVar.field_msgSvrId);
                    intent2.putExtra("reportSessionId", hz);
                    t = u.GK().t(hz, true);
                    t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                    t.o("preUsername", a2);
                    t.o("preChatName", a2);
                    t.o("preMsgIndex", Integer.valueOf(this.yLf));
                    t.o("sendAppMsgScene", Integer.valueOf(1));
                    aVar.startActivity(intent2);
                    break;
                }
                break;
            case 114:
                a2 = a(auVar, aVar.getContext(), 0);
                if (!t.ov(a2)) {
                    ah.c(auVar, a2, aVar.getContext());
                    break;
                }
                break;
            case 125:
                a2 = auVar.field_talker;
                a = u.hz(auVar.field_msgSvrId);
                t = u.GK().t(a, true);
                t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                t.o("preUsername", a2);
                t.o("preChatName", a2);
                t.o("preMsgIndex", Integer.valueOf(this.yLf));
                t.o("sendAppMsgScene", Integer.valueOf(1));
                cf cfVar = new cf();
                cfVar.fqp.fqt = this.yLf;
                cfVar.fqp.fqu = a;
                cfVar.fqp.pL = aVar;
                cfVar.fqp.fqw = 40;
                f.a(cfVar, auVar);
                com.tencent.mm.sdk.b.a.xef.m(cfVar);
                if (cfVar.fqq.ret == 0) {
                    com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(a(auVar, aVar.getContext(), this.yLf));
                    if (auVar.aNc()) {
                        com.tencent.mm.modelstat.b.hPA.b(auVar, fT != null ? fT.type : 0);
                    } else {
                        com.tencent.mm.modelstat.b.hPA.u(auVar);
                    }
                    if (!(fT == null || fT.type != 5 || fT.url == null)) {
                        x.d("MicroMsg.ChattingItemBizFrom", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), fT.url, Long.valueOf(this.yLg), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1)});
                        a2 = "";
                        try {
                            a2 = URLEncoder.encode(fT.url, "UTF-8");
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ChattingItemBizFrom", e, "", new Object[0]);
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.h(13378, new Object[]{a2, Long.valueOf(this.yLg), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1)});
                        break;
                    }
                }
                break;
        }
        return false;
    }

    private static String a(au auVar, Context context, int i) {
        if (context == null) {
            x.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
            return null;
        } else if (auVar == null) {
            x.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
            return null;
        } else {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                try {
                    l vL = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(auVar.field_content);
                    List list = vL.hdX;
                    if (list != null && list.size() > 0 && i < list.size()) {
                        m mVar = (m) list.get(i);
                        com.tencent.mm.y.g.a aVar = new com.tencent.mm.y.g.a();
                        aVar.title = mVar.title;
                        aVar.description = mVar.hef;
                        aVar.action = "view";
                        aVar.type = 5;
                        aVar.url = mVar.url;
                        aVar.fGz = vL.fGz;
                        aVar.fGA = vL.fGA;
                        aVar.gjD = vL.gjD;
                        aVar.thumburl = mVar.hed;
                        if (t.ov(aVar.thumburl)) {
                            h jm = n.JQ().jm(auVar.field_talker);
                            if (jm != null) {
                                aVar.thumburl = jm.JG();
                            }
                        }
                        return com.tencent.mm.y.g.a.a(aVar, null, null);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChattingItemBizFrom", e, "", new Object[0]);
                    x.e("MicroMsg.ChattingItemBizFrom", "retransmit app msg error : %s", new Object[]{e.getLocalizedMessage()});
                }
                return null;
            }
            com.tencent.mm.ui.base.u.fI(context);
            return null;
        }
    }

    public final boolean b(View view, a aVar, au auVar) {
        return false;
    }

    private void a(m mVar, View view) {
        if (view != null && mVar != null) {
            view.setOnClickListener(new 7(this, mVar));
        }
    }
}
