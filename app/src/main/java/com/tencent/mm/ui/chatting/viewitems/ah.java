package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.DoubleClickRelativeLayout;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.z.ar;

public final class ah {

    protected static class c extends ar {
        int kTK = 1;

        c(au auVar, boolean z, int i) {
            super(auVar, z, i, null, (byte) 0);
        }
    }

    public static final class d extends a {
        TextView yIW;
        ImageView yJk;
        TextView yMh;
        int yNC;
        TextView yND;
        TextView yNE;
        AnimImageView yNF;
        DoubleClickRelativeLayout yNG;
        MMTextView yNH;
        TextView yNI;
        LinearLayout yNJ;
        ProgressBar yNK;
        FrameLayout yNL;
        FrameLayout yNM;
        ImageView yNN;
        AnimImageView yNO;
        ProgressBar yNP;
        TextView yNQ;
        Animation yNR;

        public final a t(View view, boolean z) {
            super.ds(view);
            this.ldK = (TextView) view.findViewById(R.h.bVf);
            this.qhg = (TextView) view.findViewById(R.h.bVk);
            this.yNE = (TextView) view.findViewById(R.h.bVr);
            this.mSc = (CheckBox) view.findViewById(R.h.bTC);
            this.jWc = view.findViewById(R.h.bUC);
            this.yIz = (ImageView) view.findViewById(R.h.bVb);
            this.yMh = (TextView) view.findViewById(R.h.bTH);
            this.yNL = (FrameLayout) view.findViewById(R.h.bVs);
            this.yNG = (DoubleClickRelativeLayout) view.findViewById(R.h.bVv);
            this.yNH = (MMTextView) view.findViewById(R.h.bVw);
            this.yNK = (ProgressBar) view.findViewById(R.h.bVx);
            this.yNI = (TextView) view.findViewById(R.h.bVt);
            this.yNJ = (LinearLayout) view.findViewById(R.h.bVu);
            this.yND = (TextView) view.findViewById(R.h.bVp);
            this.yNF = (AnimImageView) view.findViewById(R.h.bVo);
            this.yNF.setType(1);
            if (z) {
                this.yNF.xXq = true;
                this.yIW = (TextView) view.findViewById(R.h.bSZ);
                this.yNO = (AnimImageView) view.findViewById(R.h.bVq);
                this.yNO.xXq = true;
                this.yNO.setType(0);
            } else {
                this.yNM = (FrameLayout) view.findViewById(R.h.bVy);
                this.yNN = (ImageView) view.findViewById(R.h.bVz);
                this.yNP = (ProgressBar) view.findViewById(R.h.bVA);
                this.psA = (ProgressBar) view.findViewById(R.h.cTZ);
                this.yNQ = (TextView) view.findViewById(R.h.bVB);
                this.yNF.xXq = false;
                this.yJk = (ImageView) view.findViewById(R.h.bVd);
            }
            return this;
        }

        public static void a(d dVar, au auVar, int i, ChattingUI.a aVar, boolean z, OnLongClickListener onLongClickListener) {
            if (dVar != null) {
                String str;
                n nVar = new n(auVar.field_content);
                float bv = q.bv(nVar.time);
                if (aVar.ysf.ysR == null || auVar.field_msgId != aVar.ysf.ysR.yqm) {
                    dVar.yNF.setVisibility(8);
                    dVar.yNF.bnk();
                } else {
                    dVar.yNF.setVisibility(0);
                    dVar.yNF.coI();
                }
                if (auVar.field_isSend == 0) {
                    if (nVar.time == 0) {
                        a(dVar, 8, 0, true, auVar.cjC());
                        dVar.yNO.bnk();
                        dVar.yNO.setVisibility(8);
                        dVar.yIz.setVisibility(8);
                        bv = 0.0f;
                        dVar.yNC = com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), nr(0));
                        dVar.yNE.setWidth(dVar.yNC);
                        dVar.yMh.setText(aVar.getString(R.l.ejo, new Object[]{Integer.valueOf(0)}));
                        dVar.yNF.setWidth(com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), nr(0)));
                    } else if (nVar.time == -1) {
                        a(dVar, 8, 0, true, auVar.cjC());
                        dVar.yNO.bnk();
                        dVar.yNO.setVisibility(8);
                        dVar.yNC = 80;
                        dVar.yNE.setWidth(80);
                        dVar.yMh.setVisibility(8);
                        dVar.yNF.setWidth(com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), nr((int) bv)));
                    } else {
                        a(dVar, 8, 0, true, auVar.cjC());
                        dVar.yNO.bnk();
                        dVar.yNO.setVisibility(8);
                        dVar.yMh.setVisibility(0);
                        dVar.yNC = com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), nr((int) bv));
                        dVar.yNE.setWidth(dVar.yNC);
                        dVar.yMh.setText(aVar.getString(R.l.ejo, new Object[]{Integer.valueOf((int) bv)}));
                        dVar.yNF.setWidth(com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), nr((int) bv)));
                    }
                }
                if (1 == auVar.field_isSend) {
                    if (auVar.field_status == 1) {
                        a(dVar, 0, 8, false, auVar.cjC());
                        dVar.yNM.setVisibility(8);
                        dVar.cvC();
                    } else if (nVar.time == -1) {
                        a(dVar, 8, 0, false, auVar.cjC());
                        dVar.yNE.setWidth(80);
                        dVar.yNC = 80;
                        dVar.yMh.setVisibility(8);
                        dVar.yNM.setVisibility(8);
                        dVar.yNF.setWidth(com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), nr((int) bv)));
                        dVar.cvC();
                    } else if (auVar.field_status == 7) {
                        a(dVar, 8, 8, false, auVar.cjC());
                        dVar.yMh.setVisibility(8);
                        dVar.yNM.setVisibility(0);
                        dVar.cvC();
                        if (dVar.yNN != null) {
                            dVar.yNR = AnimationUtils.loadAnimation(dVar.mUL.getContext(), R.a.bqJ);
                            dVar.yNN.startAnimation(dVar.yNR);
                        }
                    } else {
                        a(dVar, 8, 0, false, auVar.cjC());
                        dVar.yNM.setVisibility(8);
                        dVar.yMh.setVisibility(0);
                        dVar.cvC();
                        if (nVar.time == 0) {
                            bv = 0.0f;
                        }
                        dVar.yNC = com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), nr((int) bv));
                        dVar.yNE.setWidth(dVar.yNC);
                        dVar.yMh.setText(aVar.getString(R.l.ejo, new Object[]{Integer.valueOf((int) bv)}));
                        dVar.yNF.setWidth(com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), nr((int) bv)));
                    }
                }
                if (aVar.ysf.pAU != null) {
                    dVar.yMh.setTextColor(aVar.ysf.pAU.vjx);
                    if (aVar.ysf.pAU.vjy) {
                        dVar.yMh.setShadowLayer(2.0f, 1.2f, 1.2f, aVar.ysf.pAU.vjz);
                    } else {
                        dVar.yMh.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    }
                    if (aVar.ysf.pAU.vjA) {
                        dVar.yMh.setBackgroundResource(R.g.bBs);
                    } else {
                        dVar.yMh.setBackgroundColor(0);
                    }
                }
                dVar.yNE.setTag(new c(auVar, aVar.ypn, i));
                dVar.yNE.setOnClickListener(dVar.yIB.t(aVar));
                dVar.yNE.setOnLongClickListener(onLongClickListener);
                dVar.yNE.setOnTouchListener(aVar.ysf.ysV);
                c cVar = new c(auVar, aVar.ypn, i);
                cVar.kTK = 2;
                if (bh.ov(aVar.yvJ.v(auVar.field_msgId, auVar.field_imgPath))) {
                    dVar.yNG.setClickable(false);
                    dVar.yNG.setLongClickable(false);
                } else {
                    dVar.yNG.setTag(cVar);
                    dVar.yNG.setOnTouchListener(aVar.ysf.ysV);
                    dVar.yNG.yxa = new 1(aVar, auVar, dVar);
                    dVar.yNG.setOnLongClickListener(onLongClickListener);
                }
                if ((auVar.gjE & 1) == 1) {
                    dVar.yND.setVisibility(0);
                    if (auVar.field_isSend == 0) {
                        dVar.yNF.setBackgroundResource(R.g.bAX);
                    } else {
                        dVar.yNQ.setBackgroundResource(R.g.bBv);
                        dVar.yNF.setBackgroundResource(R.g.bBv);
                    }
                } else {
                    dVar.yND.setVisibility(8);
                    if (auVar.field_isSend == 0) {
                        dVar.yNF.setBackgroundResource(R.g.bAR);
                    } else {
                        dVar.yNQ.setBackgroundResource(R.g.bBt);
                        dVar.yNF.setBackgroundResource(R.g.bBt);
                    }
                }
                if (z) {
                    str = aVar.ysf.talker;
                } else {
                    str = aVar.ysf.hlJ;
                }
                com.tencent.mm.ui.a.a cnI = com.tencent.mm.ui.a.a.a.cnI();
                View view = dVar.yNE;
                int i2 = (int) bv;
                aVar.gu(str);
                cnI.H(view, i2);
                dVar.yMh.setContentDescription(" ");
            }
        }

        private void cvC() {
            if (this.yNR != null) {
                this.yNR.cancel();
                this.yNR = null;
            }
        }

        private static void a(d dVar, int i, int i2, boolean z, boolean z2) {
            dVar.yIz.setVisibility(i2);
            dVar.yMh.setVisibility(i2);
            if (z) {
                dVar.yNO.setVisibility(i);
                dVar.yIW.setVisibility(i2);
            } else {
                dVar.yNQ.setVisibility(i);
            }
            if (i2 != 0) {
                dVar.yNL.setVisibility(8);
                dVar.yNG.setVisibility(8);
                dVar.yNK.setVisibility(8);
                dVar.mX(false);
            } else if (z2) {
                dVar.yNL.setVisibility(0);
                dVar.yNG.setVisibility(0);
                dVar.yNK.setVisibility(0);
                dVar.mX(false);
            } else {
                dVar.yNL.setVisibility(0);
                dVar.yNG.setVisibility(8);
                dVar.yNK.setVisibility(8);
                dVar.mX(false);
            }
        }

        private static int nr(int i) {
            if (i <= 2) {
                return 80;
            }
            if (i < 10) {
                return ((i - 2) * 9) + 80;
            }
            if (i < 60) {
                return (((i / 10) + 7) * 9) + 80;
            }
            return com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX;
        }

        final void mX(boolean z) {
            Context context = ac.getContext();
            if (context != null) {
                if (z) {
                    this.yNH.setPadding(com.tencent.mm.bv.a.fromDPToPix(context, 10), com.tencent.mm.bv.a.fromDPToPix(context, 8), com.tencent.mm.bv.a.fromDPToPix(context, 10), com.tencent.mm.bv.a.fromDPToPix(context, 4));
                    this.yNJ.setVisibility(0);
                    return;
                }
                this.yNH.setPadding(com.tencent.mm.bv.a.fromDPToPix(context, 10), com.tencent.mm.bv.a.fromDPToPix(context, 8), com.tencent.mm.bv.a.fromDPToPix(context, 10), com.tencent.mm.bv.a.fromDPToPix(context, 8));
                this.yNJ.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void e(int i, au auVar) {
        x.i("MicroMsg.ChattingItemVoice", "alvinluo reportTransformTextLongClick type: %d, msgId: %d", new Object[]{Integer.valueOf(i), Long.valueOf(auVar.field_msgId)});
        b fiVar = new fi();
        fiVar.fuz.fuA = 2;
        fiVar.fuz.scene = i;
        fiVar.fuz.fileName = auVar.field_imgPath;
        com.tencent.mm.sdk.b.a.xef.m(fiVar);
    }

    public static void a(ChattingUI.a aVar, ar arVar) {
        int i = 0;
        if (com.tencent.mm.p.a.aW(aVar.getContext()) || com.tencent.mm.p.a.aU(aVar.getContext())) {
            x.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
            return;
        }
        ar.Hg();
        if (!com.tencent.mm.z.c.isSDCardAvailable()) {
            u.fI(aVar.getContext());
        } else if (arVar != null && arVar.fEJ != null) {
            n nVar = new n(arVar.fEJ.field_content);
            if (t.ov(arVar.fEJ.field_content) || nVar.time == 0) {
                Toast.makeText(aVar.getContext(), R.l.dQL, 0).show();
            } else if (aVar.ysf != null && aVar.ysf.ysR != null) {
                cf cfVar = arVar.fEJ;
                if (aVar.ysf.ysR.yqm != cfVar.field_msgId) {
                    if (aVar.yvJ.gj(cfVar.field_msgId)) {
                        i = 7;
                    } else if (aVar.yvJ.gg(cfVar.field_msgId)) {
                        i = 6;
                    }
                    if (i != 0) {
                        b fiVar = new fi();
                        fiVar.fuz.fuA = 1;
                        fiVar.fuz.scene = i;
                        fiVar.fuz.fileName = cfVar.field_imgPath;
                        com.tencent.mm.sdk.b.a.xef.m(fiVar);
                    }
                }
                com.tencent.mm.ui.chatting.d dVar = aVar.ysf.ysR;
                int i2 = arVar.position;
                cf cfVar2 = arVar.fEJ;
                if (cfVar2 != null && cfVar2.ciW()) {
                    n nVar2 = new n(cfVar2.field_content);
                    if (nVar2.time != 0 || cfVar2.field_isSend != 0) {
                        if (cfVar2.field_status != 1 || cfVar2.field_isSend != 1) {
                            if (cfVar2.field_isSend != 0 || nVar2.time != -1) {
                                dVar.crc();
                                ar.Hg();
                                Boolean bool = (Boolean) com.tencent.mm.z.c.CU().get(4115, null);
                                if (bool == null || !bool.booleanValue()) {
                                    ar.Hg();
                                    com.tencent.mm.z.c.CU().set(4115, Boolean.valueOf(true));
                                    dVar.cri();
                                    dVar.yqq = u.a(dVar.yqo.thisActivity(), dVar.yqo.getString(R.l.dSj), 4000);
                                }
                                if (dVar.mql.isPlaying() && cfVar2.field_msgId == dVar.yqm) {
                                    dVar.yqw = true;
                                    dVar.crh();
                                    return;
                                }
                                dVar.ah(cfVar2);
                                if (cfVar2.field_isSend == 0 && !q.C(cfVar2)) {
                                    dVar.Fo(i2 + 1);
                                }
                                dVar.bdr();
                            }
                        }
                    }
                }
            }
        }
    }
}
