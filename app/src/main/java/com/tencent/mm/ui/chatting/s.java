package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ac.a;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class s implements ac {
    public static as ytO = new as(5, "MicroMsg.ChattingMoreBtnBarHelper");
    private x fAh;
    private l jni;
    public p lcZ;
    Animation qvq;
    private boolean ypn;
    ChattingUI$a yrW;
    public q yrX;
    private ChatFooter yrY;
    public boolean ysa = false;
    public ChattingFooterMoreBtnBar ytP;
    public u ytQ;
    private ChatFooterCustom ytR;
    private boolean ytS = true;
    public boolean ytm = false;

    public s(ChattingUI$a chattingUI$a, ChattingFooterMoreBtnBar chattingFooterMoreBtnBar, q qVar, ChatFooter chatFooter, ChatFooterCustom chatFooterCustom, x xVar, boolean z) {
        this.yrW = chattingUI$a;
        this.ytP = chattingFooterMoreBtnBar;
        this.yrY = chatFooter;
        this.ytR = chatFooterCustom;
        this.yrX = qVar;
        b(xVar, z);
        this.qvq = AnimationUtils.loadAnimation(chattingUI$a.getContext(), R.a.bqo);
        if (this.ysa) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        } else {
            this.lcZ = new p(true, true);
            this.lcZ.zms = new 9(this);
        }
        this.ytP.c(3, new 2(this));
        this.ytP.c(2, new OnClickListener(this) {
            final /* synthetic */ s ytT;

            {
                this.ytT = r1;
            }

            public final void onClick(View view) {
                if (this.ytT.yrX.ytp.size() == 0) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                } else {
                    l.a(this.ytT.yrW, this.ytT.crQ(), this.ytT.ypn, this.ytT, this.ytT.fAh);
                }
            }
        });
        this.ytP.c(1, new OnClickListener(this) {
            final /* synthetic */ s ytT;

            {
                this.ytT = r1;
            }

            public final void onClick(View view) {
                if (this.ytT.yrX.ytp.size() == 0) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                    return;
                }
                List e = this.ytT.crQ();
                if (i.de(e)) {
                    h.a(this.ytT.yrW.getContext(), this.ytT.yrW.getContext().getString(R.l.dXy), "", this.ytT.yrW.getContext().getString(R.l.dBP), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 ytV;

                        {
                            this.ytV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i.df(e)) {
                    h.a(this.ytT.yrW.getContext(), this.ytT.yrW.getContext().getString(R.l.dXz), "", this.ytT.yrW.getContext().getString(R.l.dBP), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 ytV;

                        {
                            this.ytV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i.dd(e)) {
                    h.a(this.ytT.yrW.getContext(), this.ytT.yrW.getContext().getString(R.l.dXA), "", new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 ytV;

                        {
                            this.ytV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, null);
                } else if (m.a(this.ytT.yrW, e, this.ytT.fAh)) {
                    this.ytT.crR();
                }
            }
        });
        this.ytP.c(0, new OnClickListener(this) {
            final /* synthetic */ s ytT;

            {
                this.ytT = r1;
            }

            public final void onClick(View view) {
                if (this.ytT.yrX.ytp.size() == 0) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                } else if ((!com.tencent.mm.z.s.gF(this.ytT.fAh.field_username) || f.eE(this.ytT.fAh.field_username)) && !com.tencent.mm.z.s.ho(this.ytT.fAh.field_username)) {
                    this.ytT.jni.b(view, new 1(this), new 2(this));
                } else {
                    this.ytT.ytS = true;
                    j.a(this.ytT.yrW.getContext(), this.ytT.crQ(), this.ytT.ypn, this.ytT.fAh.field_username, this.ytT);
                }
            }
        });
        this.ytP.c(4, new 6(this));
        this.yrX.ytA = new 1(this);
        this.jni = new l(this.yrW.getContext());
    }

    public final void b(x xVar, boolean z) {
        this.fAh = xVar;
        this.ypn = z;
    }

    private List<au> crQ() {
        List<au> linkedList = new LinkedList();
        for (Long longValue : this.yrX.ytp) {
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[]{Long.valueOf(longValue.longValue())});
            ar.Hg();
            linkedList.add(c.Fa().dH(r4));
        }
        Collections.sort(linkedList, new 7(this));
        return linkedList;
    }

    public final void aw(au auVar) {
        this.yrW.addSearchMenu(true, this.lcZ);
        this.ytP.startAnimation(this.qvq);
        this.ytP.setVisibility(0);
        this.ytm = true;
        this.yrW.yvY.ctV();
        q qVar = this.yrX;
        qVar.ytm = true;
        qVar.notifyDataSetChanged();
        qVar.crP();
        this.yrX.crO();
        this.yrX.fW(auVar.field_msgId);
        this.ytP.Fu(this.yrX.ytp.size());
        this.yrW.ywg.ctD();
        this.yrW.hideVKB();
        this.yrW.csN();
        this.yrW.ywe.ctN();
        g.pQN.h(10811, new Object[]{Integer.valueOf(1)});
    }

    public final void crR() {
        this.yrW.addSearchMenu(false, this.lcZ);
        this.ytP.setVisibility(8);
        q qVar = this.yrX;
        qVar.ytm = false;
        qVar.notifyDataSetChanged();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingListAdapter", "enable ClickListener");
        qVar.ysV = qVar.ysW;
        qVar.ysY = qVar.ysZ;
        qVar.yta = qVar.ytb;
        qVar.ytc = qVar.ytd;
        qVar.ysg.ywd.ctj();
        this.yrW.yvY.ctV();
        this.ytm = false;
        this.yrW.csN();
        this.yrW.ywg.ctE();
        this.yrW.ywe.ctN();
        this.yrW.hideVKB();
        j.crr();
    }

    public final void a(a aVar) {
    }

    public final void crS() {
        if (this.lcZ != null) {
            this.lcZ.cxX();
        }
    }

    public final void crT() {
        crR();
    }

    public final void b(a aVar) {
        crR();
    }

    public final boolean crU() {
        return this.ytS;
    }
}
