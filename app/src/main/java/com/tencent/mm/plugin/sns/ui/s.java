package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ac;
import com.tencent.mm.z.q;

public final class s extends LinearLayout implements v {
    private Context context;
    private boolean fuf = false;
    int fug;
    private String fus = "";
    private String gze = "";
    private int kTK = 0;
    b rsL = new b(this);
    private m rsM = null;
    a rsN;
    private OnTouchListener rsO = bh.cgx();
    private boolean rsP = true;

    public final void setVisibility(int i) {
        boolean z = false;
        if (this.kTK == 2 || this.kTK == 3) {
            super.setVisibility(i);
            if (i != 8) {
                z = true;
            }
            this.rsP = z;
        } else if (this.rsM != null && !this.rsM.byp()) {
        } else {
            if (i == 8) {
                this.rsL.rsS.setVisibility(8);
                this.rsP = false;
            } else if (i == 0) {
                this.rsL.rsS.setVisibility(0);
                this.rsP = true;
            }
        }
    }

    public s(final Context context, int i, boolean z) {
        super(context);
        this.kTK = i;
        this.fuf = z;
        this.context = context;
        if (this.kTK != -1) {
            this.gze = q.FS();
            View inflate = LayoutInflater.from(context).inflate(g.qHn, this, true);
            this.rsL.rsS = (LinearLayout) inflate.findViewById(f.qFE);
            this.rsL.rtc = (LinearLayout) inflate.findViewById(f.qGe);
            this.rsL.rsV = (LinearLayout) inflate.findViewById(f.qCG);
            this.rsL.rsV.setOnTouchListener(this.rsO);
            this.rsL.rsW = (ImageView) inflate.findViewById(f.qCv);
            this.rsL.rsX = (LinearLayout) inflate.findViewById(f.qBG);
            this.rsL.rsX.setOnTouchListener(this.rsO);
            this.rsL.rsY = (LinearLayout) inflate.findViewById(f.qBM);
            this.rsL.rta = (TextView) inflate.findViewById(f.qEf);
            this.rsL.rtb = (TextView) inflate.findViewById(f.qEg);
            this.rsL.rsZ = (TextView) inflate.findViewById(f.qCl);
            this.rsL.rsT = (TextView) inflate.findViewById(f.qDr);
            this.rsL.rsU = (LinearLayout) inflate.findViewById(f.qDs);
            this.rsL.iXX = (TextView) inflate.findViewById(f.qEq);
            this.rsL.iXX.setTextSize(1, (this.rsL.iXX.getTextSize() * ac.eu(context)) / a.getDensity(this.rsL.iXX.getContext()));
            this.rsL.rtg = (LinearLayout) inflate.findViewById(f.qCy);
            ((LinearLayout) inflate.findViewById(f.qCy)).getBackground().setAlpha(50);
            this.rsL.ihQ = (ImageView) inflate.findViewById(f.qBt);
            this.rsL.rtd = (ImageView) inflate.findViewById(f.qCP);
            this.rsL.rte = (ImageView) inflate.findViewById(f.qCc);
            this.rsL.rtf = (LinearLayout) inflate.findViewById(f.qBP);
            this.rsL.rth = (TextView) inflate.findViewById(f.qBQ);
            if (this.kTK == 2) {
                this.rsL.rtc.setVisibility(8);
                this.rsL.rtf.setVisibility(8);
                this.rsL.rsU.setVisibility(0);
            } else if (this.kTK == 3) {
                this.rsL.rtc.setVisibility(8);
                this.rsL.rsU.setVisibility(8);
                this.rsL.rtf.setVisibility(0);
            } else {
                this.rsL.rtc.setVisibility(0);
                this.rsL.rsU.setVisibility(8);
                this.rsL.rtf.setVisibility(8);
            }
            this.rsL.rsV.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ s rsQ;

                {
                    this.rsQ = r1;
                }

                public final void onClick(View view) {
                    if (this.rsQ.rsM != null) {
                        if (this.rsQ.rsM.field_likeFlag == 0) {
                            if (this.rsQ.rsM.byp()) {
                                al.a.a(this.rsQ.rsM, 1, "", "", this.rsQ.fug);
                            } else {
                                al.a.a(this.rsQ.rsM.field_userName, 5, "", this.rsQ.rsM, this.rsQ.fug);
                            }
                            this.rsQ.rsM.field_likeFlag = 1;
                            ae.bvv().z(this.rsQ.rsM);
                        } else {
                            this.rsQ.rsM.field_likeFlag = 0;
                            ae.bvv().z(this.rsQ.rsM);
                            al.a.Kq(this.rsQ.rsM.bxW());
                            this.rsQ.rsM = ae.bvv().eR(this.rsQ.rsM.field_snsId);
                        }
                        String eq = this.rsQ.rsM.field_snsId == 0 ? "" : i.eq(this.rsQ.rsM.field_snsId);
                        com.tencent.mm.plugin.report.service.g.pQN.h(11989, new Object[]{Integer.valueOf(1), eq, Integer.valueOf(0)});
                        new af().postDelayed(new 1(this), 500);
                    }
                }
            });
            this.rsL.rsX.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ s rsQ;

                public final void onClick(View view) {
                    x.d("MicroMsg.GalleryFooter", "comment cmd");
                    if (this.rsQ.rsM != null) {
                        int i = this.rsQ.rsM.roJ;
                        Intent intent = new Intent();
                        intent.putExtra("sns_comment_localId", i);
                        intent.putExtra("sns_source", this.rsQ.fug);
                        intent.setClass(context, SnsCommentUI.class);
                        String eq = this.rsQ.rsM.field_snsId == 0 ? "" : i.eq(this.rsQ.rsM.field_snsId);
                        com.tencent.mm.plugin.report.service.g.pQN.h(11989, new Object[]{Integer.valueOf(2), eq, Integer.valueOf(0)});
                        context.startActivity(intent);
                    }
                }
            });
            this.rsL.rsY.setOnClickListener(new 3(this, context));
            this.rsL.rsT.setOnClickListener(new 4(this));
            this.rsL.rth.setOnClickListener(new 5(this));
        }
    }

    public final void refresh() {
        if (this.kTK != -1) {
            this.rsM = ae.bvv().Lm(this.fus);
            if (!bh.ov(this.fus) && this.rsM != null) {
                this.rsL.rte.setVisibility(8);
                if (ai.J(this.rsM.field_localPrivate, this.fuf)) {
                    this.rsL.rsX.setVisibility(8);
                    this.rsL.rsV.setVisibility(8);
                } else if (this.rsM.byp()) {
                    if (this.rsP) {
                        this.rsL.rsS.setVisibility(0);
                    }
                    this.rsL.rsY.setVisibility(0);
                    this.rsL.rsX.setVisibility(0);
                    this.rsL.rsV.setVisibility(0);
                    this.rsL.rtc.setVisibility(0);
                } else {
                    this.rsL.rtg.setVisibility(0);
                    this.rsL.rtc.setVisibility(0);
                    this.rsL.rsS.setVisibility(8);
                    this.rsL.rsY.setVisibility(8);
                    this.rsL.rsX.setVisibility(8);
                    this.rsL.rsV.setVisibility(8);
                }
                bjv n = ai.n(this.rsM);
                if (n != null) {
                    if (this.rsM.byp()) {
                        int i = n.wNb;
                        if (i > 0) {
                            this.rsL.rtb.setText(String.valueOf(i));
                            this.rsL.rtb.setVisibility(0);
                        } else {
                            this.rsL.rtb.setVisibility(8);
                        }
                        int i2 = n.wMY;
                        if (i2 > 0) {
                            this.rsL.rta.setText(String.valueOf(i2));
                            this.rsL.rta.setVisibility(0);
                        } else {
                            this.rsL.rta.setVisibility(8);
                        }
                        x.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + i2);
                        if (this.rsM.field_likeFlag == 1) {
                            this.rsL.rsZ.setText(getResources().getString(j.qKV));
                            this.rsL.rsW.setImageResource(com.tencent.mm.plugin.sns.i.i.qIG);
                        } else {
                            this.rsL.rsZ.setText(getResources().getString(j.qKW));
                            this.rsL.rsW.setImageResource(com.tencent.mm.plugin.sns.i.i.qIH);
                        }
                    }
                    if (this.gze.equals(this.rsM.field_userName) || !this.fuf) {
                        this.rsL.ihQ.setVisibility(8);
                    } else {
                        this.rsL.ihQ.setVisibility(0);
                        b.a(this.rsL.ihQ, this.rsM.field_userName);
                    }
                }
                if (this.rsM.bxV() == null) {
                    this.rsL.iXX.setVisibility(8);
                    return;
                }
                String str = this.rsM.bxV().wQl;
                if (str == null || str.equals("")) {
                    this.rsL.iXX.setText("");
                    this.rsL.iXX.setVisibility(8);
                } else {
                    this.rsL.iXX.setText(com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), str + " ", this.rsL.iXX.getTextSize()));
                    this.rsL.iXX.setVisibility(0);
                }
                if (ai.J(this.rsM.field_localPrivate, this.fuf)) {
                    this.rsL.rtd.setVisibility(0);
                    this.rsL.iXX.setVisibility(0);
                } else {
                    this.rsL.rtd.setVisibility(8);
                }
                if (this.fuf && this.rsM.bys()) {
                    this.rsL.rsY.setVisibility(0);
                    this.rsL.iXX.setVisibility(0);
                    this.rsL.rte.setVisibility(0);
                }
            }
        }
    }

    public final void LO(String str) {
        this.fus = str;
        refresh();
    }
}
