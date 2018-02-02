package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.sns.abtest.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i$c;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.ab;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.w.a.k;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public boolean DEBUG = false;
    protected int kTK;
    protected Activity mActivity;
    protected av qZU;
    public ArrayList<b> rNB = new ArrayList();
    protected boolean rzb = false;

    class a extends n {
        final /* synthetic */ a rNC;

        a(a aVar) {
            this.rNC = aVar;
        }

        public final void onClick(View view) {
            this.rNC.qZU.rzO.rMD.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = this.rNC.mActivity.getResources().getColor(i$c.lnH);
            if (this.ozA) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    public abstract void a(c cVar, int i, ay ayVar, bnp com_tencent_mm_protocal_c_bnp, int i2, av avVar);

    public abstract void d(c cVar);

    public final void iO(boolean z) {
        this.rzb = z;
    }

    private void a(c cVar, m mVar) {
        LayoutParams layoutParams;
        if (!mVar.xl(32)) {
            if (cVar.rNI != null) {
                cVar.rNI.setVisibility(0);
            }
            cVar.rNN.setLongClickable(false);
            cVar.rNN.setOnClickListener(null);
            if (cVar.rOg != null) {
                layoutParams = (LayoutParams) cVar.rOg.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.rOg.setLayoutParams(layoutParams);
            }
            if (cVar.rOE) {
                layoutParams = (LayoutParams) cVar.rOF.rxg.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.rOF.rxg.setLayoutParams(layoutParams);
            }
            cVar.rNN.setLayoutParams(new LayoutParams(-1, -2));
            cVar.rNN.setBackgroundColor(Color.parseColor("#00ffffff"));
            if (cVar.rNK != null) {
                cVar.rNK.setVisibility(8);
            }
            if (cVar.rNJ != null) {
                cVar.rNJ.setVisibility(8);
            }
        } else if (mVar.bxR() == null || mVar.bxR().rfi != 1) {
            if (cVar.rNI != null) {
                cVar.rNI.setVisibility(0);
            }
            cVar.rNN.setLongClickable(false);
            cVar.rNN.setOnClickListener(null);
            cVar.rNN.setLayoutParams(new LayoutParams(-1, -2));
            cVar.rNN.setBackgroundColor(Color.parseColor("#00ffffff"));
            if (cVar.rOg != null) {
                layoutParams = (LayoutParams) cVar.rOg.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.rOg.setLayoutParams(layoutParams);
            }
            if (cVar.rOE) {
                layoutParams = (LayoutParams) cVar.rOF.rxg.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.rOF.rxg.setLayoutParams(layoutParams);
            }
            if (cVar.rNK != null) {
                cVar.rNK.setVisibility(8);
            }
            if (cVar.rNJ != null) {
                cVar.rNJ.setVisibility(8);
            }
        } else {
            if (cVar.rNI != null) {
                cVar.rNI.setVisibility(8);
            }
            cVar.rNN.setTag(cVar);
            cVar.rNN.setOnClickListener(this.qZU.qZo.rPU);
            cVar.rNN.setLongClickable(true);
            this.qZU.kGt.c(cVar.rNN, this.qZU.qZo.rPG, this.qZU.qZo.rPp);
            int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
            if (cVar.rOg != null) {
                layoutParams = (LayoutParams) cVar.rOg.getLayoutParams();
                layoutParams.leftMargin = com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 10);
                layoutParams.rightMargin = com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 10);
                cVar.rOg.setLayoutParams(layoutParams);
            }
            if (cVar.rOE) {
                layoutParams = (LayoutParams) cVar.rOF.rxg.getLayoutParams();
                layoutParams.leftMargin = com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 10);
                layoutParams.rightMargin = com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 10);
                cVar.rOF.rxg.setLayoutParams(layoutParams);
            }
            if (cVar.rOK.wQo.vYc == 27) {
                cVar.rNN.setLayoutParams(new LayoutParams((((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 8), -2));
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams((((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 8), -2);
            layoutParams2.setMargins(0, com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 5), 0, 0);
            cVar.rNN.setLayoutParams(layoutParams2);
            cVar.rNN.setBackgroundResource(i$e.qzH);
            if (cVar.rNK != null) {
                cVar.rNK.setVisibility(0);
            }
            if (cVar.rNJ == null) {
                return;
            }
            if (bh.ov(mVar.bxR().rfj)) {
                cVar.rNJ.setVisibility(8);
            } else {
                cVar.rNJ.setVisibility(0);
            }
        }
    }

    public final View a(Activity activity, c cVar, int i, av avVar, m mVar) {
        String str;
        this.mActivity = activity;
        this.kTK = i;
        this.qZU = avVar;
        cVar.fzW = mVar.bxW();
        switch (i) {
            case 0:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 1:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 2:
                str = "R.layout.sns_timeline_imagesline_one";
                break;
            case 3:
                str = "R.layout.sns_timeline_imagesline1";
                break;
            case 4:
                str = "R.layout.sns_timeline_imagesline2";
                break;
            case 5:
                str = "R.layout.sns_timeline_imagesline3";
                break;
            case 6:
                str = "R.layout.sns_timeline_item_photo_one3";
                break;
            case 7:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 8:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 9:
                str = "R.layout.sns_media_sight_item";
                break;
            case 10:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 11:
                str = "R.layout.sns_hb_reward_item";
                break;
            case 12:
                str = "R.layout.sns_timeline_turn_media";
                break;
            default:
                str = "R.layout.sns_media_sub_item2";
                break;
        }
        View a = com.tencent.mm.kiss.a.b.DY().a(this.mActivity, str, g.qIc);
        cVar.rOT = str;
        View findViewById = a.findViewById(f.qCq);
        if (findViewById instanceof ViewStub) {
            cVar.rNO = (ViewStub) findViewById;
        } else {
            cVar.rNO = null;
        }
        x.i("MicroMsg.BaseTimeLineItem", "create new item  " + i + "  " + a.hashCode());
        cVar.rOM = a.findViewById(f.qFy);
        cVar.kTK = i;
        cVar.iip = (MaskImageButton) a.findViewById(f.qAx);
        cVar.iip.setOnClickListener(avVar.qZo.rPq);
        cVar.iip.setOnLongClickListener(avVar.qZo.rPr);
        cVar.iip.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ a rNC;

            {
                this.rNC = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setTag(f.cSF, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                }
                return false;
            }
        });
        cVar.rNF = (AsyncTextView) a.findViewById(f.cAn);
        cVar.rNG = (ImageView) a.findViewById(f.qGa);
        cVar.rNF.setOnTouchListener(new ab());
        cVar.rNH = (ViewGroup) a.findViewById(f.qCU);
        cVar.rNI = (AsyncNormalTextView) a.findViewById(f.qBT);
        cVar.rNI.j(avVar.rHA);
        cVar.rNK = (TextView) a.findViewById(f.qBS);
        cVar.rNK.setClickable(false);
        cVar.rNK.setLongClickable(false);
        cVar.rNM = a.findViewById(f.qBB);
        cVar.rNJ = (TextView) a.findViewById(f.qBR);
        cVar.rNJ.setClickable(false);
        cVar.rNJ.setLongClickable(false);
        cVar.rOU = a.findViewById(f.qBy);
        cVar.rOV = (Button) a.findViewById(f.qBz);
        cVar.rOW = (Button) a.findViewById(f.qBA);
        cVar.rOV.setOnClickListener(avVar.qZo.rPS);
        cVar.rOW.setOnClickListener(avVar.qZo.rPT);
        cVar.rNN = (LinearLayout) a.findViewById(f.qCr);
        if (mVar.xl(32)) {
            com.tencent.mm.plugin.sns.storage.b bxR = mVar.bxR();
            if (bxR != null && bxR.reX == 1) {
                cVar.rNI.setContentWidth((((((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12));
                cVar.rNI.byX();
            } else if (bxR != null && bxR.reX == 2) {
                cVar.rNI.setContentWidth(((((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12));
                cVar.rNI.byX();
            }
        }
        cVar.rNN.setTag(cVar);
        cVar.rNN.setOnClickListener(avVar.qZo.rPU);
        avVar.kGt.c(a.findViewById(f.caS), avVar.qZo.rPs, avVar.qZo.rPp);
        avVar.kGt.c((TextView) a.findViewById(f.qBW), avVar.qZo.rPs, avVar.qZo.rPp);
        cVar.rNL = (SnsTranslateResultView) a.findViewById(f.qFD);
        cVar.rNL.setVisibility(8);
        cVar.rNL.rKM.setPadding(0, 0, (int) this.mActivity.getResources().getDimension(d.bvS), 0);
        cVar.rNL.pYa.setBackgroundResource(i$e.qzK);
        avVar.kGt.c(cVar.rNL.pYa, avVar.qZo.rPs, avVar.qZo.rPp);
        cVar.rOf = (LinearLayout) a.findViewById(f.qBG);
        cVar.rNU = (TextView) a.findViewById(f.qGk);
        cVar.lUD = (TextView) a.findViewById(f.qBl);
        cVar.rNV = (AsyncTextView) a.findViewById(f.qAv);
        cVar.rNW = (AsyncTextView) a.findViewById(f.qAu);
        cVar.rFp = (TextView) a.findViewById(f.qAw);
        cVar.qQI = new bf(a);
        cVar.qQI.a(avVar.qZo.rPz, avVar.qZo.rPO);
        cVar.rth = (TextView) a.findViewById(f.qAN);
        cVar.rth.setText(activity.getString(j.dEw));
        cVar.rth.setOnClickListener(avVar.qZo.rPt);
        cVar.rNV.setOnClickListener(avVar.qZo.rPP);
        cVar.rNW.setOnClickListener(avVar.qZo.rPQ);
        cVar.rFp.setOnClickListener(avVar.qZo.rPL);
        cVar.rNY = a.findViewById(f.qAP);
        cVar.rNY.setOnClickListener(avVar.qZo.rPy);
        cVar.rNX = (TextView) a.findViewById(f.qAO);
        cVar.rNZ = (ImageView) a.findViewById(f.qBm);
        cVar.rOi = (ViewStub) a.findViewById(f.qAJ);
        cVar.rqG = (LinearLayout) a.findViewById(f.qBh);
        cVar.rOO = (ViewStub) a.findViewById(f.qAQ);
        cVar.rOk = (ViewStub) a.findViewById(f.qFj);
        cVar.rNQ = (TextView) a.findViewById(f.qCj);
        cVar.rNQ.setOnClickListener(avVar.qZo.rPu);
        cVar.rOS = (TextView) a.findViewById(f.qCn);
        cVar.mUL = a;
        if (this.rzb) {
            c.b(a, cVar);
            com.tencent.mm.plugin.sns.abtest.a.a(a, cVar);
            ae.bvm();
            com.tencent.mm.plugin.sns.f.c.c(a, cVar);
        }
        d(cVar);
        a.setTag(cVar);
        a(cVar, mVar);
        return a;
    }

    public final void a(c cVar, int i, m mVar, bnp com_tencent_mm_protocal_c_bnp, int i2, av avVar) {
        String byq;
        String str;
        int parseColor;
        CharSequence charSequence;
        com.tencent.mm.ui.a.a cnI;
        View view;
        TextView textView;
        TextView textView2;
        String str2;
        TextView textView3;
        boolean z;
        ay ayVar = (ay) avVar.bBD().bzu().get(Integer.valueOf(i));
        a(cVar, mVar);
        this.kTK = i2;
        this.qZU = avVar;
        if (this.rzb) {
            ax.C(mVar);
        }
        if (mVar.xl(32)) {
            x.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + i.er(mVar.field_snsId) + " for susan");
        }
        cVar.rND = ayVar.rJK;
        cVar.nbi = false;
        cVar.position = i;
        cVar.fzW = ayVar.rJJ;
        cVar.frH = ayVar.rsD;
        cVar.rNE = ayVar.rJO;
        cVar.rNZ.setOnClickListener(avVar.rHz);
        cVar.rOK = com_tencent_mm_protocal_c_bnp;
        bjv com_tencent_mm_protocal_c_bjv = ayVar.qyf;
        cVar.qOc = com_tencent_mm_protocal_c_bjv;
        com.tencent.mm.plugin.sns.h.b bVar = avVar.rHp.rrt.qWT;
        if (mVar != null) {
            byq = mVar.byq();
            bVar.rdd.add(byq);
            if (mVar.xl(32)) {
                bVar.rdi.add(byq);
            }
            bVar.rdj.add(mVar.field_userName);
            switch (mVar.field_type) {
                case 1:
                    bVar.rdf.add(byq);
                    break;
                case 2:
                    bVar.rde.add(byq);
                    break;
                case 3:
                    if (!bh.ov(com_tencent_mm_protocal_c_bnp.wQp)) {
                        bVar.rdk.add(byq);
                        break;
                    } else {
                        bVar.rdl.add(byq);
                        break;
                    }
                case 4:
                    bVar.rdh.add(byq);
                    break;
                case 5:
                    bVar.rdm.add(byq);
                    break;
                case 15:
                    bVar.rdg.add(byq);
                    break;
                case 18:
                    bVar.rdn.add(byq);
                    break;
                default:
                    bVar.rdo.add(byq);
                    break;
            }
            if (i < bVar.rdb) {
                bVar.rdb = i;
                bVar.rbH = i.g(mVar);
            }
            if (i > bVar.rdc) {
                bVar.rdc = i;
                bVar.rbI = i.g(mVar);
            }
            bVar.rbN = bVar.rde.size();
            bVar.rbO = bVar.rdf.size();
            bVar.rbP = bVar.rdg.size();
            bVar.rbR = bVar.rdh.size();
            bVar.rbQ = bVar.rdi.size();
            bVar.rbS = bVar.rdm.size();
            bVar.rca = bVar.rdn.size();
            bVar.kGm = bVar.rdj.size();
            bVar.rbL = bVar.rdk.size();
            bVar.rbM = bVar.rdl.size();
            bVar.rbZ = bVar.rdo.size();
            bVar.rbv = bVar.rdd.size();
        }
        byq = ayVar.jKk;
        if (byq != null) {
            cVar.rOL = ayVar.rJI;
            if (ayVar.rJZ) {
                x.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[]{byq});
                if (com.tencent.mm.pluginsdk.ui.a.b.bZV().tJ() != null) {
                    cVar.iip.setImageBitmap(com.tencent.mm.pluginsdk.ui.a.b.bZV().tJ());
                }
                com.tencent.mm.z.ak.a.hfL.a(byq, "", new av.b(avVar.bBD(), i));
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.iip, byq);
            }
            cVar.iip.setTag(byq);
            ((MaskImageButton) cVar.iip).zlH = ayVar.rsD;
            AsyncTextView asyncTextView = cVar.rNF;
            String str3 = ayVar.rJY;
            com.tencent.mm.pluginsdk.ui.d.n.a aVar = avVar.rzL;
            boolean z2 = ayVar.rrf;
            String str4 = ayVar.rsD;
            boolean z3 = ayVar.rrf;
            asyncTextView.userName = byq;
            asyncTextView.rre = str3;
            asyncTextView.kTK = i2;
            asyncTextView.rrf = z2;
            asyncTextView.rrg = str4;
            asyncTextView.rrh = aVar;
            asyncTextView.rri = z3;
            asyncTextView.run();
        }
        cVar.rNG.setVisibility(8);
        if (ayVar.rrf) {
            cVar.qQH = true;
            cVar.nbi = ayVar.rJP;
            cVar.iTh = ayVar.rJQ;
        } else {
            cVar.qQH = false;
            cVar.iTh = "";
        }
        cVar.rNM.setVisibility(8);
        cVar.rOU.setVisibility(8);
        if (cVar == null || !mVar.xl(32) || mVar.bxR() == null || mVar.bxR().rfi != 1) {
            AsyncNormalTextView asyncNormalTextView = cVar.rNI;
            byq = ayVar.rJL;
            asyncNormalTextView.rrc = ayVar.rJM;
            asyncNormalTextView.content = byq;
            asyncNormalTextView.qZU = avVar;
            asyncNormalTextView.rrd = ayVar;
            if (bh.ov(byq)) {
                asyncNormalTextView.setVisibility(8);
            }
            cVar.rNI.c(cVar);
        } else {
            com.tencent.mm.plugin.sns.storage.a bxT = mVar.bxT();
            if (!(bxT == null || !bxT.bwr() || mVar.byE())) {
                cVar.rNM.setVisibility(0);
            }
            str = bh.ov(mVar.bxR().rfk) ? com_tencent_mm_protocal_c_bnp.wQl : mVar.bxR().rfk;
            if (bh.ov(str)) {
                cVar.rNK.setVisibility(8);
            } else {
                cVar.rNK.setText(str + " ");
                com.tencent.mm.pluginsdk.ui.d.i.f(cVar.rNK, 2);
                cVar.rNK.setVisibility(0);
            }
            str = mVar.bxR().rfj;
            if (bh.ov(str)) {
                cVar.rNJ.setVisibility(8);
            } else {
                cVar.rNJ.setText(str + " ");
                com.tencent.mm.pluginsdk.ui.d.i.f(cVar.rNJ, 2);
                cVar.rNJ.setVisibility(0);
            }
            if (mVar.bxR().bwz() || mVar.bxR().bwA()) {
                cVar.rOU.setVisibility(0);
                int i3 = i$e.qzJ;
                int parseColor2 = Color.parseColor("#cdcdcd");
                parseColor = Color.parseColor("#ffffff");
                Object obj = 1;
                if (mVar.bxR().bwA()) {
                    int en = u.en(mVar.bxR().rfn.rfs, mVar.byA());
                    if (en > 0 && en <= 2) {
                        if (en == 1) {
                            cVar.rOW.setBackgroundColor(parseColor);
                            cVar.rOW.setTextColor(parseColor2);
                            cVar.rOW.setText(mVar.bxR().rfn.wU(1));
                            cVar.rOV.setBackgroundResource(i3);
                            cVar.rOV.setTextColor(WebView.NIGHT_MODE_COLOR);
                            cVar.rOV.setText(mVar.bxR().rfn.wT(0));
                        } else if (en == 2) {
                            cVar.rOV.setBackgroundColor(parseColor);
                            cVar.rOV.setTextColor(parseColor2);
                            cVar.rOV.setText(mVar.bxR().rfn.wU(0));
                            cVar.rOW.setBackgroundResource(i3);
                            cVar.rOW.setTextColor(WebView.NIGHT_MODE_COLOR);
                            cVar.rOW.setText(mVar.bxR().rfn.wT(1));
                        }
                        obj = null;
                    }
                }
                if (obj != null) {
                    cVar.rOV.setTextColor(WebView.NIGHT_MODE_COLOR);
                    cVar.rOV.setBackgroundResource(i3);
                    cVar.rOW.setTextColor(WebView.NIGHT_MODE_COLOR);
                    cVar.rOW.setBackgroundResource(i3);
                    cVar.rOV.setText(mVar.bxR().bwu());
                    cVar.rOW.setText(mVar.bxR().bwv());
                }
            }
        }
        cVar.rNX.setOnTouchListener(new ab());
        a(cVar, i, ayVar, com_tencent_mm_protocal_c_bnp, i2, avVar);
        avVar.rHr.put(Integer.valueOf(i), new WeakReference(cVar.mUL));
        if (cVar.mUL.getBackground() == null) {
            cVar.mUL.setBackgroundResource(i$e.bBx);
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12);
            cVar.mUL.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 8));
        }
        cVar.lUD.setText(ayVar.rJR);
        cVar.rNV.setVisibility(8);
        cVar.rNW.setVisibility(8);
        if (ayVar.rrf) {
            com.tencent.mm.plugin.sns.storage.a aVar2 = ayVar.rJS;
            cVar.rNV.setTag(ayVar.rsD);
            if (ayVar.rJS.rdV == com.tencent.mm.plugin.sns.storage.a.rdH) {
                if (bh.ov(ayVar.rJV)) {
                    cVar.rNV.setVisibility(8);
                } else {
                    cVar.rNV.setText(ayVar.rJV);
                    cVar.rNV.setVisibility(0);
                }
            } else if (aVar2.rdV == com.tencent.mm.plugin.sns.storage.a.rdI) {
                if (bh.ov(ayVar.rJW)) {
                    cVar.rNV.setVisibility(8);
                } else {
                    str = ayVar.rJX;
                    CharSequence charSequence2 = ayVar.rJW;
                    Context context = this.mActivity;
                    cVar.rNV.getTextSize();
                    CharSequence jVar = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d(context, charSequence2, 1));
                    jVar.f(null, charSequence2);
                    TextPaint paint = cVar.rNV.getPaint();
                    if (com.tencent.mm.bv.a.ad(this.mActivity, (int) Layout.getDesiredWidth(jVar, 0, jVar.length(), paint)) > cVar.rzT) {
                        while (str.length() > 1) {
                            str = str.substring(0, str.length() - 2);
                            jVar = String.format(aVar2.rdW, new Object[]{str + "..."});
                            Context context2 = this.mActivity;
                            cVar.rNV.getTextSize();
                            CharSequence jVar2 = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d(context2, jVar, 1));
                            jVar2.f(null, jVar);
                            parseColor = com.tencent.mm.bv.a.ad(this.mActivity, (int) Layout.getDesiredWidth(jVar2, 0, jVar2.length(), paint));
                            cVar.rNV.setText(jVar2, BufferType.SPANNABLE);
                            cVar.rNV.setVisibility(0);
                            if (parseColor <= cVar.rzT) {
                            }
                        }
                    } else {
                        cVar.rNV.setText(jVar, BufferType.SPANNABLE);
                        cVar.rNV.setVisibility(0);
                    }
                }
            }
            if (cVar.rNV.getVisibility() != 8 && bh.ov(aVar2.rdX)) {
                cVar.rNV.setTextColor(this.mActivity.getResources().getColor(i$c.qyG));
                cVar.rNV.setOnClickListener(null);
            }
            if (mVar.bxV().wQo.vYe == 4) {
                cVar.rNW.setTag(cVar);
                cVar.rNW.setVisibility(0);
                cVar.rNW.setText(String.format("%s%s%s", new Object[]{this.mActivity.getResources().getString(j.qJY), ayVar.rJY, this.mActivity.getResources().getString(j.qJZ)}));
            } else {
                cVar.rNW.setVisibility(8);
            }
        }
        if (ayVar.rKb) {
            cVar.rOS.setText(avVar.fmM.getString(j.qJC, new Object[]{Integer.valueOf(ayVar.rKc)}));
            cVar.rOS.setVisibility(0);
        } else {
            cVar.rOS.setVisibility(8);
        }
        cVar.rFp.setTag(ayVar.rsD);
        if (bh.ov(ayVar.rKe)) {
            cVar.rFp.setVisibility(8);
        } else {
            cVar.rFp.setVisibility(0);
            cVar.rFp.setText(ayVar.rKe);
            cVar.rFp.setClickable(ayVar.rKf);
            cVar.rFp.setTextColor(ayVar.rKf ? -11048043 : -9211021);
        }
        cVar.rNX.setTextColor(this.mActivity.getResources().getColor(i$c.btR));
        if (ayVar.rKg) {
            cVar.rNX.setVisibility(0);
            charSequence = this.mActivity.getString(j.qKp) + ayVar.mAppName;
            if (charSequence.length() > 10) {
                charSequence = charSequence.substring(0, 10) + "...";
            }
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new b(this), 0, spannableString.length(), 33);
            cVar.rNX.setText(spannableString, BufferType.SPANNABLE);
            if (!(ayVar.rKi || "wx7fa037cc7dfabad5".equals(com_tencent_mm_protocal_c_bnp.wQn.nGJ))) {
                cVar.rNX.setTextColor(this.mActivity.getResources().getColor(i$c.qyG));
                cVar.rNX.setOnTouchListener(null);
            }
            cVar.rNX.setTag(com_tencent_mm_protocal_c_bnp);
        } else if (ayVar.rKh) {
            cVar.rNX.setVisibility(0);
            charSequence = new SpannableString(ayVar.rKk);
            charSequence.setSpan(new d(this), 0, charSequence.length(), 33);
            cVar.rNX.setText(charSequence, BufferType.SPANNABLE);
            cVar.rNX.setTag(new bd(ayVar.rKj, ayVar.rKk));
        } else if (ayVar.rKl) {
            cVar.rNX.setVisibility(0);
            str = this.mActivity.getString(j.qJr);
            Object obj2 = str + ayVar.mAppName;
            charSequence2 = new SpannableString(obj2);
            charSequence2.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(i$c.qyG)), 0, str.length(), 33);
            charSequence2.setSpan(new a(this), str.length(), obj2.length(), 33);
            cVar.rNX.setText(charSequence2, BufferType.SPANNABLE);
            if (!(ayVar.rKi || "wx7fa037cc7dfabad5".equals(com_tencent_mm_protocal_c_bnp.wQn.nGJ))) {
                cVar.rNX.setTextColor(this.mActivity.getResources().getColor(i$c.qyG));
                cVar.rNX.setOnTouchListener(null);
            }
            cVar.rNX.setTag(com_tencent_mm_protocal_c_bnp);
        } else {
            cVar.rNX.setVisibility(8);
        }
        if (ayVar.rKa) {
            cVar.rth.setVisibility(0);
            cVar.rth.setTag(ayVar.rsD);
        } else {
            cVar.rth.setVisibility(8);
        }
        cVar.rNZ.setTag(cVar);
        if (ayVar.rKm) {
            if (!cVar.rOo) {
                cVar.rOd = (LinearLayout) cVar.rOk.inflate();
                cVar.rOe = cVar.mUL.findViewById(f.qCZ);
                cVar.rOo = true;
                cVar.rOe.setTag(ayVar.rsD);
                cVar.rkU = (TextView) cVar.rOd.findViewById(f.qCZ);
            }
            cVar.rOk.setVisibility(0);
            cVar.rOe.setOnClickListener(avVar.qZo.rPx);
            switch (ayVar.rKn) {
                case 201:
                    cVar.rkU.setText(j.qLS);
                    cVar.rOe.setClickable(false);
                    cVar.rOe.setEnabled(false);
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX /*210*/:
                    cVar.rkU.setText(j.qLU);
                    cVar.rOe.setClickable(false);
                    cVar.rOe.setEnabled(false);
                    break;
                case h.CTRL_INDEX /*211*/:
                    cVar.rkU.setText(j.qLT);
                    cVar.rOe.setClickable(true);
                    cVar.rOe.setEnabled(true);
                    break;
                default:
                    cVar.rkU.setText(j.qLV);
                    cVar.rOe.setClickable(true);
                    cVar.rOe.setEnabled(true);
                    break;
            }
            aqs byi = mVar.byi();
            if (!(byi == null || bh.ov(byi.wyr))) {
                cVar.rkU.setText(byi.wyr);
            }
        } else if (cVar.rOo) {
            cVar.rOk.setVisibility(8);
        }
        if (ayVar.rKo) {
            cVar.rNY.setVisibility(0);
            cVar.rNY.setTag(ayVar.rsD);
        } else {
            cVar.rNY.setVisibility(8);
        }
        if (ayVar.rKp) {
            if (!bh.ov(ayVar.rKq)) {
                cVar.rNU.setVisibility(0);
                if (i2 == 7) {
                    charSequence = String.format(this.mActivity.getString(j.qMw), new Object[]{ayVar.rKq});
                } else {
                    charSequence = String.format(this.mActivity.getString(j.qMx), new Object[]{ayVar.rKq});
                }
                cVar.rNU.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.mActivity, charSequence, cVar.rNU.getTextSize()));
            } else if (ayVar.rKr) {
                cVar.rNU.setVisibility(0);
                cVar.rNU.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.mActivity, this.mActivity.getString(j.qMy).toString(), cVar.rNU.getTextSize()));
            }
            if (ayVar.rKs) {
                if (cVar.rOP == null) {
                    cVar.rOP = cVar.rOO.inflate();
                    cVar.qSh = (TextView) cVar.rOP.findViewById(f.qAR);
                    cVar.rOQ = (MaskTextView) cVar.rOP.findViewById(f.qAS);
                    cVar.rOQ.setOnTouchListener(new ab());
                }
                cVar.rOP.setVisibility(0);
                b(cVar.rOQ, ayVar.rKv, i2);
                cVar.qSh.setText(this.mActivity.getString(j.qLC, new Object[]{Integer.valueOf(ayVar.rKt), bh.t(ayVar.rKu / 100.0d)}));
                cVar.rOP.setTag(mVar);
                cVar.rOP.setOnClickListener(avVar.qZo.rPB);
            } else if (cVar.rOP != null) {
                cVar.rOP.setVisibility(8);
            }
            if ((ayVar.rKw == null && ayVar.rKw.size() != 0) || (ayVar.rKx != null && ayVar.rKx.size() != 0)) {
                if (!cVar.rOj) {
                    if (cVar.rqG == null) {
                        cVar.rqG = (LinearLayout) cVar.rOi.inflate();
                    }
                    cVar.rOb = (MaskTextView) cVar.rqG.findViewById(f.qBf);
                    cVar.rOb.setOnTouchListener(new ab());
                    cVar.rOc = (LinearLayout) cVar.mUL.findViewById(f.qAG);
                    cVar.rqG.setTag(ayVar.rJJ);
                    cVar.rOb.setTag(ayVar.rJJ);
                    cVar.rOh = cVar.rqG.findViewById(f.qBj);
                    cVar.rOR = cVar.rqG.findViewById(f.qBh);
                    cVar.rOj = true;
                }
                cVar.rqG.setVisibility(0);
                if (ayVar.rKw == null || ayVar.rKw.size() <= 0) {
                    cVar.rOb.setVisibility(8);
                } else {
                    cVar.rOb.setVisibility(0);
                    a(cVar.rOb, ayVar.rKw, i2);
                }
                if (ayVar.rKx != null) {
                    a(com_tencent_mm_protocal_c_bjv.wNd, ayVar.rKx, cVar);
                } else {
                    cVar.rOc.setVisibility(8);
                }
                if (ayVar.rKw == null || ayVar.rKw.size() == 0 || ayVar.rKx == null || ayVar.rKx.size() == 0) {
                    cVar.rOh.setVisibility(8);
                } else {
                    cVar.rOh.setVisibility(0);
                }
            } else if (cVar.rqG != null) {
                cVar.rqG.setVisibility(8);
            } else if (cVar.rOj) {
                cVar.rOi.setVisibility(8);
            }
            if (ayVar.rKy) {
                cVar.rNQ.setVisibility(8);
            } else {
                cVar.rNQ.setTag(ayVar.rsD);
                cVar.rNQ.setText(ayVar.rKz);
                cVar.rNQ.setVisibility(0);
            }
            if (ayVar.rrf) {
                cVar.qQI.setVisibility(8);
            } else {
                x.i("MicroMsg.BaseTimeLineItem", "adatag " + ayVar.rJU);
                cVar.qQI.q(Long.valueOf(ayVar.rJK), new com.tencent.mm.plugin.sns.data.b(cVar.qQI, cVar.position, ayVar.rsD, ayVar.rJK, ayVar.rJQ));
                cVar.qQI.a(ayVar.rJT, ayVar.rJS);
                cVar.qQI.setVisibility(0);
                if (cVar.rFp != null && cVar.rFp.getVisibility() == 0) {
                    if ((cVar.qQI.rMj.getVisibility() != 0 ? 1 : null) != null) {
                        LayoutParams layoutParams = (LayoutParams) cVar.rFp.getLayoutParams();
                        layoutParams.setMargins(layoutParams.leftMargin, BackwardSupportUtil.b.b(this.mActivity, 0.0f), layoutParams.rightMargin, layoutParams.bottomMargin);
                        cVar.rFp.setLayoutParams(layoutParams);
                    }
                }
            }
            if (this.rzb) {
                ae.bvm().a(this.mActivity, com_tencent_mm_protocal_c_bjv, cVar);
            }
            cVar.rNL.pYa.setTag(new as(ayVar.rJJ, ayVar.rsD, false, true, 1));
            cnI = com.tencent.mm.ui.a.a.a.cnI();
            view = cVar.mUL;
            textView = cVar.rNF;
            textView2 = cVar.lUD;
            str2 = cVar.rNI.content;
            textView3 = cVar.rNS;
            z = cVar.rOE;
            if (cnI.cnH() && cnI.tI != null && view != null && textView != null && textView2 != null) {
                com.tencent.mm.ui.a.b bVar2 = new com.tencent.mm.ui.a.b();
                bVar2.Ys(textView.getText().toString());
                bVar2.Ys(str2);
                if (textView3 != null) {
                    bVar2.Ys(textView3.getText().toString());
                }
                if (z) {
                    bVar2.Ys(cnI.tI.getString(k.gYz));
                }
                bVar2.dg(view);
                return;
            }
            return;
        }
        cVar.rNU.setVisibility(8);
        if (ayVar.rKs) {
            if (cVar.rOP == null) {
                cVar.rOP = cVar.rOO.inflate();
                cVar.qSh = (TextView) cVar.rOP.findViewById(f.qAR);
                cVar.rOQ = (MaskTextView) cVar.rOP.findViewById(f.qAS);
                cVar.rOQ.setOnTouchListener(new ab());
            }
            cVar.rOP.setVisibility(0);
            b(cVar.rOQ, ayVar.rKv, i2);
            cVar.qSh.setText(this.mActivity.getString(j.qLC, new Object[]{Integer.valueOf(ayVar.rKt), bh.t(ayVar.rKu / 100.0d)}));
            cVar.rOP.setTag(mVar);
            cVar.rOP.setOnClickListener(avVar.qZo.rPB);
        } else if (cVar.rOP != null) {
            cVar.rOP.setVisibility(8);
        }
        if (ayVar.rKw == null) {
        }
        if (cVar.rqG != null) {
            cVar.rqG.setVisibility(8);
        } else if (cVar.rOj) {
            cVar.rOi.setVisibility(8);
        }
        if (ayVar.rKy) {
            cVar.rNQ.setVisibility(8);
        } else {
            cVar.rNQ.setTag(ayVar.rsD);
            cVar.rNQ.setText(ayVar.rKz);
            cVar.rNQ.setVisibility(0);
        }
        if (ayVar.rrf) {
            cVar.qQI.setVisibility(8);
        } else {
            x.i("MicroMsg.BaseTimeLineItem", "adatag " + ayVar.rJU);
            cVar.qQI.q(Long.valueOf(ayVar.rJK), new com.tencent.mm.plugin.sns.data.b(cVar.qQI, cVar.position, ayVar.rsD, ayVar.rJK, ayVar.rJQ));
            cVar.qQI.a(ayVar.rJT, ayVar.rJS);
            cVar.qQI.setVisibility(0);
            if (cVar.qQI.rMj.getVisibility() != 0) {
            }
            if ((cVar.qQI.rMj.getVisibility() != 0 ? 1 : null) != null) {
                LayoutParams layoutParams2 = (LayoutParams) cVar.rFp.getLayoutParams();
                layoutParams2.setMargins(layoutParams2.leftMargin, BackwardSupportUtil.b.b(this.mActivity, 0.0f), layoutParams2.rightMargin, layoutParams2.bottomMargin);
                cVar.rFp.setLayoutParams(layoutParams2);
            }
        }
        if (this.rzb) {
            ae.bvm().a(this.mActivity, com_tencent_mm_protocal_c_bjv, cVar);
        }
        cVar.rNL.pYa.setTag(new as(ayVar.rJJ, ayVar.rsD, false, true, 1));
        cnI = com.tencent.mm.ui.a.a.a.cnI();
        view = cVar.mUL;
        textView = cVar.rNF;
        textView2 = cVar.lUD;
        str2 = cVar.rNI.content;
        textView3 = cVar.rNS;
        z = cVar.rOE;
        if (cnI.cnH()) {
        }
    }

    public static void e(c cVar) {
        if (cVar != null && cVar.rNL != null) {
            cVar.rNL.setVisibility(8);
        }
    }

    private boolean a(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i2 = 0;
        while (i2 < bVar.size()) {
            try {
                String str = (String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i2] = spannableStringBuilder.length();
                iArr2[i2] = iArr[i2] + str.length();
                stringBuffer.append(str);
                spannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.i.b(this.mActivity, str, maskTextView.getTextSize()));
                i2++;
            } catch (Throwable e) {
                x.e("MicroMsg.BaseTimeLineItem", "setLikedList  e:%s", new Object[]{bh.i(e)});
            }
        }
        Drawable drawable = this.mActivity.getResources().getDrawable(i == 11 ? i$e.qzf : i$e.qzq);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        e eVar = new e(drawable, 1);
        eVar.zsZ = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 2))) / 2.0f);
        spannableStringBuilder.setSpan(eVar, length, length + 1, 33);
        int i3 = i == 11 ? 3 : 2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            spannableStringBuilder.setSpan(new n((String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(0), this.qZU.rzL, i3), iArr[i2], iArr2[i2], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.nUp = stringBuffer.toString();
        return true;
    }

    private void b(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        if (bVar.size() == 0) {
            maskTextView.setVisibility(8);
            return;
        }
        maskTextView.setVisibility(0);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i2 = 0;
        while (i2 < bVar.size()) {
            try {
                String str = (String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i2] = spannableStringBuilder.length();
                iArr2[i2] = iArr[i2] + str.length();
                stringBuffer.append(str);
                spannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.i.b(this.mActivity, str, maskTextView.getTextSize()));
                i2++;
            } catch (Throwable e) {
                x.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[]{bh.i(e)});
                return;
            }
        }
        Drawable drawable = this.mActivity.getResources().getDrawable(com.tencent.mm.plugin.sns.i.i.qIM);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        e eVar = new e(drawable, 1);
        eVar.zsZ = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 2))) / 2.0f);
        spannableStringBuilder.setSpan(eVar, length, length + 1, 33);
        int i3 = i == 11 ? 3 : 2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            spannableStringBuilder.setSpan(new n((String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(0), this.qZU.rzL, i3), iArr[i2], iArr2[i2], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.nUp = stringBuffer.toString();
    }

    public final void a(c cVar, int i, m mVar) {
        c cVar2 = cVar;
        int i2 = i;
        a(cVar2, i2, (ay) this.qZU.bBD().bzu().get(Integer.valueOf(i)), mVar.bxV(), cVar.kTK, this.qZU);
    }

    private boolean a(List<bjk> list, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, c cVar) {
        int i;
        LinearLayout linearLayout = cVar.rOc;
        int childCount = linearLayout.getChildCount();
        int size = bVar.size();
        if (childCount > size) {
            for (i = size; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(size);
                linearLayout.removeViewAt(size);
                if (childAt instanceof SnsCommentPreloadTextView) {
                    this.qZU.a((SnsCommentPreloadTextView) childAt);
                }
            }
        }
        if (bVar.size() == 0) {
            linearLayout.setVisibility(8);
            return false;
        }
        ay ayVar;
        linearLayout.setVisibility(0);
        com.tencent.mm.plugin.sns.ui.x bBD = this.qZU.bBD();
        if (bBD instanceof ax) {
            ayVar = (ay) ((ax) bBD).rJv.get(cVar.position);
        } else {
            ayVar = null;
        }
        if (this.DEBUG) {
            x.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + cVar.position + " commentCount: " + size);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bVar.size(); i3++) {
            View bBz;
            Object obj;
            View view;
            Object obj2;
            View view2;
            com.tencent.mm.vending.j.a aVar = (com.tencent.mm.vending.j.a) bVar.get(i3);
            long longValue = ((Long) aVar.get(0)).longValue();
            String str = (String) aVar.get(1);
            String str2 = (String) aVar.get(2);
            String str3 = (String) aVar.get(3);
            CharSequence charSequence = (CharSequence) aVar.get(4);
            bjk com_tencent_mm_protocal_c_bjk = (bjk) list.get(i3);
            b ad = ad(cVar.fzW, longValue);
            if (ad != null && ad.hlj) {
                ao.cb(ad.id, 2);
            }
            if (i2 >= childCount) {
                if (ad == null || ad.hlj) {
                    bBz = this.qZU.bBz();
                    ((SnsCommentPreloadTextView) bBz).O(14.0f * com.tencent.mm.bv.a.eu(bBz.getContext()));
                    if (this.qZU.rHt == -1) {
                        this.qZU.rHt = this.mActivity.getResources().getColor(i$c.qyx);
                    }
                    ((SnsCommentPreloadTextView) bBz).setTextColor(this.qZU.rHt);
                    ((SnsCommentPreloadTextView) bBz).Eg();
                } else {
                    bBz = new TranslateCommentTextView(this.mActivity);
                    ((TranslateCommentTextView) bBz).rAY.ay(14.0f * com.tencent.mm.bv.a.eu(bBz.getContext()));
                    ((TranslateCommentTextView) bBz).rNa.setTextSize(1, 14.0f * com.tencent.mm.bv.a.eu(bBz.getContext()));
                }
                obj = 1;
                view = bBz;
            } else {
                view = linearLayout.getChildAt(i2);
                obj = null;
            }
            if (ad != null) {
                if (!(view instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(view);
                    bBz = new TranslateCommentTextView(this.mActivity);
                    linearLayout.addView(bBz, i2);
                    ((TranslateCommentTextView) bBz).rAY.ay(14.0f * com.tencent.mm.bv.a.eu(bBz.getContext()));
                    ((TranslateCommentTextView) bBz).rNa.setTextSize(1, 14.0f * com.tencent.mm.bv.a.eu(bBz.getContext()));
                    view = bBz;
                }
                TranslateCommentTextView translateCommentTextView = (TranslateCommentTextView) view;
                view.setOnTouchListener(null);
                a(translateCommentTextView.rNa, charSequence);
                if (!ad.hik) {
                    translateCommentTextView.rNa.setTextSize(1, 14.0f * com.tencent.mm.bv.a.eu(translateCommentTextView.getContext()));
                    translateCommentTextView.rAY.xP(2);
                    translateCommentTextView.rAY.setVisibility(0);
                    obj2 = 1;
                    view2 = view;
                } else if (ad.hlj) {
                    translateCommentTextView.rAY.setVisibility(8);
                    r2 = 1;
                    view2 = view;
                } else {
                    String str4 = ad.result;
                    String str5 = ad.hqd;
                    String charSequence2 = translateCommentTextView.rNa.getText().toString();
                    if (!bh.ov(charSequence2)) {
                        String[] strArr;
                        String[] split = charSequence2.split(":");
                        if (split.length > 2) {
                            strArr = new String[]{split[0], charSequence2.substring(r2[0].length() + 1)};
                        } else {
                            strArr = split;
                        }
                        if (strArr.length == 2) {
                            if (bh.ov(str4)) {
                                translateCommentTextView.rAY.a(ad, 2, null, str5, ad.qXA);
                            } else {
                                translateCommentTextView.rAY.a(ad, 2, strArr[0] + ": " + str4, str5, ad.qXA);
                            }
                            translateCommentTextView.rAY.setVisibility(0);
                        }
                        translateCommentTextView.rNa.setTextSize(1, 14.0f * com.tencent.mm.bv.a.eu(translateCommentTextView.getContext()));
                    }
                    r2 = 1;
                    view2 = view;
                }
            } else {
                if (obj == null && (view instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(view);
                    View bBz2 = this.qZU.bBz();
                    linearLayout.addView(bBz2, i2);
                    ((SnsCommentPreloadTextView) bBz2).O(14.0f * com.tencent.mm.bv.a.eu(bBz2.getContext()));
                    view = bBz2;
                }
                view.setOnTouchListener(new l(this.mActivity));
                a(view, charSequence);
                obj2 = null;
                view2 = view;
            }
            view2.setBackgroundResource(i$e.qzS);
            if (i2 > 0) {
                if (obj2 != null) {
                    view2.setPadding(0, com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 7));
                } else {
                    view2.setPadding(0, com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 3));
                }
            } else if (obj2 != null) {
                view2.setPadding(0, 1, 0, com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 7));
            } else {
                view2.setPadding(0, 1, 0, com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 3));
            }
            if (obj2 != null) {
                i = (int) this.mActivity.getResources().getDimension(d.bvS);
                ((TranslateCommentTextView) view2).rAY.rKM.setPadding(0, 0, i, 0);
            }
            view2.setOnLongClickListener(new 2(this, view2));
            view2.setOnClickListener(new com.tencent.mm.plugin.sns.ui.j.a(this.qZU.rHp, com_tencent_mm_protocal_c_bjk, str2, str3, cVar));
            if (ayVar != null) {
                view2.setTag(new com.tencent.mm.plugin.sns.ui.m(ayVar.rJJ, com_tencent_mm_protocal_c_bjk, str, str3, view2, 1));
            }
            if (obj != null) {
                linearLayout.addView(view2);
            }
            i2++;
        }
        return true;
    }

    private static void a(View view, CharSequence charSequence) {
        if (view instanceof SnsCommentPreloadTextView) {
            ((SnsCommentPreloadTextView) view).setText(charSequence);
        } else if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
    }

    private b ad(String str, long j) {
        if (this.rNB.size() <= 0) {
            return null;
        }
        Iterator it = this.rNB.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.id != null && bVar.id.equals(ao.eb(str, String.valueOf(j)))) {
                return bVar;
            }
        }
        return null;
    }
}
