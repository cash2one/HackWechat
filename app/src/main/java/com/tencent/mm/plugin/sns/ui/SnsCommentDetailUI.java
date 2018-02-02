package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.b$e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.7;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.s;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsCommentDetailUI extends MMActivity implements e, a, b {
    public static int rzS = 34;
    private l contextMenuHelper;
    private String fzW;
    private String gze;
    private c jeX = new 6(this);
    private boolean jmH = false;
    private int kTK;
    private int ktJ = 0;
    private int mScreenHeight;
    private int mScreenWidth;
    private ClipboardManager mxl;
    private OnClickListener npY = new OnClickListener(this) {
        final /* synthetic */ SnsCommentDetailUI rAr;

        {
            this.rAr = r1;
        }

        public final void onClick(View view) {
            x.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.a(this.rAr, view);
        }
    };
    private String oLg = "";
    private LinearLayout qSj;
    private af rAa = new af();
    private c rAb = new 1(this);
    private c rAc = new 12(this);
    private c rAd = new 23(this);
    private c rAe = new 34(this);
    private c rAf = new c(this);
    private OnClickListener rAg = new 40(this);
    private OnClickListener rAh = new 41(this);
    private c rAi = new 5(this);
    private c rAj = new 7(this);
    boolean rAk = false;
    private LinearLayout rAl = null;
    private boolean rAm = false;
    PhotosContent rAn = null;
    int rAo = 0;
    public ak.b.a rAp = new 19(this);
    private bf rAq = null;
    private c rrE;
    private com.tencent.mm.plugin.sns.f.b rrF;
    private r rrH = null;
    private boolean rru;
    private boolean rrv = false;
    private SnsCommentFooter rrw;
    private ao rry;
    private OnTouchListener rsO = bh.cgx();
    private ScaleAnimation rzA;
    LinearLayout rzB;
    LinearLayout rzC;
    private LinkedList<bjk> rzD;
    private int rzE = -1;
    private boolean rzF = false;
    private ar rzG;
    private String rzH;
    private ar rzI;
    private int rzJ = 0;
    private ImageView rzK;
    private k rzL;
    private boolean rzM = false;
    private long rzN = 0;
    private bg rzO;
    private boolean rzP = false;
    private int rzQ;
    private int rzR = 103;
    public int rzT = i.CTRL_INDEX;
    private g rzU;
    private com.tencent.mm.plugin.sns.ui.b.b rzV;
    private SnsTranslateResultView rzW;
    private boolean rzX = false;
    private Dialog rzY = null;
    private boolean rzZ = false;
    private long rzq = 0;
    private long rzr = 0;
    private View rzs;
    private TextView rzt;
    private LinearLayout rzu;
    private SnsDetailLuckyHeader rzv;
    private ListView rzw;
    private View rzx;
    private b rzy;
    private ScaleAnimation rzz;

    static /* synthetic */ int a(SnsCommentDetailUI snsCommentDetailUI, bnp com_tencent_mm_protocal_c_bnp, m mVar) {
        if (com_tencent_mm_protocal_c_bnp.wQo.vYc != 27 || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() < 2) {
            return 0;
        }
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = mVar.field_likeFlag == 1 ? 1 : 0;
        if (snsCommentDetailUI.rzU != null && ((aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(i5)).ktN == 6) {
            snsCommentDetailUI.rzU.p(mVar.field_snsId, mVar.field_likeFlag == 1);
        }
        if (mVar.field_likeFlag == 1) {
            i = 0;
            i2 = 1;
        } else {
            i = 1;
            i2 = 0;
        }
        aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(i2);
        aqr com_tencent_mm_protocal_c_aqr2 = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(i);
        View findViewById = snsCommentDetailUI.rzs.findViewById(f.qFP);
        View a = snsCommentDetailUI.a(com_tencent_mm_protocal_c_aqr, i2, false);
        View a2 = snsCommentDetailUI.a(com_tencent_mm_protocal_c_aqr2, i, true);
        int[] iArr = new int[2];
        findViewById.getLocationOnScreen(iArr);
        findViewById.setPivotY((float) ((snsCommentDetailUI.mScreenHeight / 2) - iArr[1]));
        findViewById.setCameraDistance(8000.0f);
        float width = ((float) findViewById.getWidth()) / 2.0f;
        float height = ((float) findViewById.getHeight()) / 2.0f;
        if (mVar.field_likeFlag == 1) {
            i3 = -90;
            i4 = 90;
        } else {
            i3 = 90;
            i4 = -90;
        }
        Animation aVar = new com.tencent.mm.plugin.sns.ui.widget.a(findViewById.getContext(), 0.0f, (float) i4, width, height, true);
        aVar.setDuration(187);
        aVar.setInterpolator(new AccelerateInterpolator());
        aVar.setFillAfter(true);
        aVar.setAnimationListener(new 39(snsCommentDetailUI, a2, a, i, findViewById, i3, width, height));
        findViewById.startAnimation(aVar);
        snsCommentDetailUI.rrv = true;
        return 374;
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, int i, int i2, gl glVar) {
        if (i2 == -1) {
            m iI = snsCommentDetailUI.iI(false);
            if (iI != null) {
                bnp bxV = iI.bxV();
                if (bxV.wQo.vYc == 1 && bxV.wQo.vYd.size() == 4 && i > 1) {
                    i++;
                }
                if (snsCommentDetailUI.rAn != null) {
                    TagImageView tagImageView = (TagImageView) snsCommentDetailUI.rAn.findViewById(ar.rDU[i]);
                    if (tagImageView != null) {
                        int[] iArr = new int[2];
                        tagImageView.getLocationInWindow(iArr);
                        glVar.fwz.foL = iArr[0];
                        glVar.fwz.foM = iArr[1];
                        glVar.fwz.foN = tagImageView.getWidth();
                        glVar.fwz.foO = tagImageView.getHeight();
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, View view) {
        a aVar = view.getTag() instanceof m ? (a) ((m) view.getTag()).tag : null;
        if (aVar == null) {
            return;
        }
        if (aVar.aAy instanceof bjk) {
            if (snsCommentDetailUI.rzF) {
                snsCommentDetailUI.iH(false);
            }
            final bjk com_tencent_mm_protocal_c_bjk = (bjk) aVar.aAy;
            final CharSequence charSequence = aVar.inu.getText().toString();
            Context context = snsCommentDetailUI.mController.xIM;
            String[] strArr = new String[]{snsCommentDetailUI.mController.xIM.getString(j.dEs), snsCommentDetailUI.mController.xIM.getString(j.dEw)};
            snsCommentDetailUI.mController.xIM.getString(j.dEn);
            h.a(context, null, strArr, new h.c(snsCommentDetailUI) {
                final /* synthetic */ SnsCommentDetailUI rAr;

                public final void jl(int i) {
                    switch (i) {
                        case 0:
                            this.rAr.mxl.setText(charSequence);
                            h.bu(this.rAr.mController.xIM, this.rAr.mController.xIM.getString(j.dEt));
                            String fL = bh.fL(u.LF(this.rAr.fzW));
                            if (com_tencent_mm_protocal_c_bjk != null && charSequence != null && fL != null) {
                                int i2 = com.tencent.mm.plugin.secinforeport.a.a.qff;
                                com.tencent.mm.plugin.secinforeport.a.a.d(4, fL + ":" + com_tencent_mm_protocal_c_bjk.wMw, bh.Vy(charSequence.toString()));
                                return;
                            }
                            return;
                        case 1:
                            int i3;
                            String str = "MicroMsg.SnsCommentDetailUI";
                            StringBuilder append = new StringBuilder("del snsId:").append(this.rAr.fzW).append(" commentId:");
                            if (com_tencent_mm_protocal_c_bjk != null) {
                                i3 = com_tencent_mm_protocal_c_bjk.wMw;
                            } else {
                                i3 = 0;
                            }
                            x.e(str, append.append(i3).toString());
                            k qVar = new q(u.LF(this.rAr.fzW), u.Jv(this.rAr.fzW) ? 4 : 6, com_tencent_mm_protocal_c_bjk);
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Di().gPJ.a(qVar, 0);
                            SnsCommentDetailUI snsCommentDetailUI = this.rAr;
                            Context context = this.rAr;
                            this.rAr.getString(j.dGO);
                            snsCommentDetailUI.rrH = h.a(context, this.rAr.getString(j.qKt), true, new 1(this, qVar));
                            return;
                        default:
                            return;
                    }
                }
            });
        } else if (aVar.aAy instanceof Object[]) {
            final Object[] objArr = (Object[]) aVar.aAy;
            SnsCommentFooter snsCommentFooter = snsCommentDetailUI.rrw;
            boolean z = !(snsCommentFooter.qTX == null || snsCommentFooter.qTX.vIy == null || !snsCommentFooter.qTX.vIy.equals((String) objArr[2])) || snsCommentFooter.bAJ();
            if (z) {
                snsCommentDetailUI.rrw.a(snsCommentDetailUI.getString(j.qLZ) + objArr[3], (bjk) objArr[1]);
                snsCommentDetailUI.rrw.iJ(true);
                int intValue = ((Integer) objArr[0]).intValue();
                if (ai.n(com.tencent.mm.plugin.sns.storage.h.Lm(snsCommentDetailUI.rzH)).wNa.size() > 0) {
                    intValue++;
                    if (intValue > snsCommentDetailUI.rzy.getCount()) {
                        intValue = snsCommentDetailUI.rzy.getCount() - 1;
                    }
                }
                snsCommentDetailUI.rAf.Dy = intValue;
                snsCommentDetailUI.rAf.kVD = view.getHeight();
                snsCommentDetailUI.bzf();
                return;
            }
            String[] strArr2 = new String[]{snsCommentDetailUI.getString(j.qLZ) + objArr[3]};
            snsCommentDetailUI.getString(j.dEn);
            h.a(snsCommentDetailUI, null, strArr2, new h.c(snsCommentDetailUI) {
                final /* synthetic */ SnsCommentDetailUI rAr;

                public final void jl(int i) {
                    switch (i) {
                        case 0:
                            this.rAr.rrw.a(this.rAr.getString(j.qLZ) + objArr[3], (bjk) objArr[1]);
                            this.rAr.rrw.iJ(true);
                            int intValue = ((Integer) objArr[0]).intValue();
                            if (ai.n(com.tencent.mm.plugin.sns.storage.h.Lm(this.rAr.rzH)).wNa.size() > 0) {
                                intValue++;
                                if (intValue > this.rAr.rzy.getCount()) {
                                    intValue = this.rAr.rzy.getCount() - 1;
                                }
                            }
                            this.rAr.rAf.Dy = intValue;
                            this.rAr.rAf.run();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ao.ca(str, 4);
        if (snsCommentDetailUI.rzy != null) {
            snsCommentDetailUI.rzy.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str, bjk com_tencent_mm_protocal_c_bjk, int i) {
        if (str != null && !str.trim().equals("") && u.LH(snsCommentDetailUI.fzW)) {
            m Ll = com.tencent.mm.plugin.sns.storage.h.Ll(snsCommentDetailUI.fzW);
            bjk a = al.a.a(Ll, Ll.xl(32) ? 8 : 2, str, com_tencent_mm_protocal_c_bjk, true, i);
            if (ai.m(Ll) != null) {
                b bVar = snsCommentDetailUI.rzy;
                bVar.rAV.add(a);
                bVar.notifyDataSetChanged();
                new com.tencent.mm.sdk.platformtools.af().postDelayed(new 1(bVar), 60);
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str, String str2, String str3) {
        m iI = snsCommentDetailUI.iI(false);
        if (iI != null && iI.bxW().equals(str)) {
            if (bh.ov(str2)) {
                snsCommentDetailUI.rzW.setVisibility(8);
            } else {
                ao.ca(str, 4);
                ao.b Kr = ao.Kr(str);
                snsCommentDetailUI.rzW.setVisibility(0);
                snsCommentDetailUI.rzW.a(Kr, 1, str2, str3, Kr.qXB);
            }
            snsCommentDetailUI.rzt.setTag(new as(snsCommentDetailUI.fzW, iI.byq(), true, false, 2));
        }
    }

    static /* synthetic */ void b(SnsCommentDetailUI snsCommentDetailUI, String str) {
        if (snsCommentDetailUI.iI(false).bxW().equals(str)) {
            snsCommentDetailUI.rzW.setVisibility(0);
            snsCommentDetailUI.rzW.xP(1);
        }
    }

    static /* synthetic */ void c(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ao.ca(str, 4);
        if (snsCommentDetailUI.rzy != null) {
            snsCommentDetailUI.rzy.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void d(SnsCommentDetailUI snsCommentDetailUI, String str) {
        m iI = snsCommentDetailUI.iI(false);
        if (iI.bxW().equals(str)) {
            ao.cb(str, 4);
            snsCommentDetailUI.rzW.setVisibility(8);
            snsCommentDetailUI.rzt.setTag(new as(snsCommentDetailUI.fzW, iI.byq(), true, false, 2));
        }
    }

    static /* synthetic */ void e(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ao.cb(str, 4);
        if (snsCommentDetailUI.rzy != null) {
            snsCommentDetailUI.rzy.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void s(SnsCommentDetailUI snsCommentDetailUI) {
        if (snsCommentDetailUI.rrw != null) {
            snsCommentDetailUI.rrw.iJ(false);
            if (snsCommentDetailUI.rrw.bAJ()) {
                snsCommentDetailUI.rrw.bAP();
            } else {
                snsCommentDetailUI.rrw.state = 0;
            }
        }
    }

    static /* synthetic */ void u(SnsCommentDetailUI snsCommentDetailUI) {
        int i;
        int count = snsCommentDetailUI.rzy.getCount() - 1;
        bjk bAQ = snsCommentDetailUI.rrw.bAQ();
        long j = bAQ.wMw != 0 ? (long) bAQ.wMw : bAQ.wMz;
        if (bAQ != null) {
            i = 0;
            while (i < snsCommentDetailUI.rzy.rAV.size()) {
                bjk com_tencent_mm_protocal_c_bjk = (bjk) snsCommentDetailUI.rzy.rAV.get(i);
                if ((com_tencent_mm_protocal_c_bjk.wMw != 0 ? (long) com_tencent_mm_protocal_c_bjk.wMw : com_tencent_mm_protocal_c_bjk.wMz) == j) {
                    break;
                }
                i++;
            }
        }
        i = count;
        snsCommentDetailUI.rAf.kVD = snsCommentDetailUI.bAB();
        if (ai.m(com.tencent.mm.plugin.sns.storage.h.Ll(snsCommentDetailUI.fzW)).wNa.size() > 0) {
            i++;
            if (i > snsCommentDetailUI.rzy.getCount()) {
                i = snsCommentDetailUI.rzy.getCount() - 1;
            }
        }
        snsCommentDetailUI.rAf.Dy = i;
        snsCommentDetailUI.bzf();
    }

    static /* synthetic */ void v(SnsCommentDetailUI snsCommentDetailUI) {
        int i = 1;
        if (u.LH(snsCommentDetailUI.fzW)) {
            m Ll = com.tencent.mm.plugin.sns.storage.h.Ll(snsCommentDetailUI.fzW);
            if (Ll.field_likeFlag == 0) {
                Ll.field_likeFlag = 1;
                com.tencent.mm.plugin.sns.storage.h.a(Ll.bxW(), Ll);
                if (Ll.xl(32)) {
                    i = 7;
                }
                al.a.a(Ll, i, "");
                snsCommentDetailUI.rzy.notifyDataSetChanged();
            } else {
                Ll.field_likeFlag = 0;
                com.tencent.mm.plugin.sns.storage.h.a(Ll.bxW(), Ll);
                al.a.Kq(Ll.bxW());
            }
            bjv m = ai.m(com.tencent.mm.plugin.sns.storage.h.Ll(snsCommentDetailUI.fzW));
            if (m != null) {
                snsCommentDetailUI.rzD = m.wNa;
                snsCommentDetailUI.g(m.wNa, m.wNd.isEmpty());
                b bVar = snsCommentDetailUI.rzy;
                bVar.rAW = m.wNa;
                bVar.notifyDataSetChanged();
            }
        }
    }

    private static boolean f(LinkedList<bjk> linkedList, LinkedList<bjk> linkedList2) {
        if (linkedList == null || linkedList2 == null) {
            return false;
        }
        if (linkedList.size() != linkedList2.size()) {
            return false;
        }
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            if (!((bjk) linkedList.get(i)).vIy.equals(((bjk) linkedList2.get(i)).vIy)) {
                return false;
            }
        }
        return true;
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
    }

    private void iH(boolean z) {
        this.rzF = false;
        if (this.rrw.bAJ()) {
            this.rrw.bAP();
            this.rrw.LW(getString(j.qMD));
        }
        this.rrw.iJ(false);
        if (z) {
            BackwardSupportUtil.c.a(this.rzw);
        }
    }

    private m iI(boolean z) {
        m Ll;
        if (bh.ov(this.rzH)) {
            Ll = com.tencent.mm.plugin.sns.storage.h.Ll(this.fzW);
            if (Ll == null) {
                finish();
                return null;
            }
            this.rzH = Ll.byq();
            return Ll;
        }
        Ll = com.tencent.mm.plugin.sns.storage.h.Lm(this.rzH);
        if (Ll == null) {
            if (z) {
                Toast.makeText(this, j.qLG, 0).show();
            }
            finish();
            return null;
        }
        this.fzW = Ll.bxW();
        return Ll;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        com.tencent.mm.pluginsdk.e.h(this);
        super.onCreate(bundle);
        ae.bvl().a(5, "@__weixintimtline", this);
        this.mxl = (ClipboardManager) getSystemService("clipboard");
        this.rzq = System.currentTimeMillis();
        this.contextMenuHelper = new l(this);
        this.rzO = new bg(this, new 2(this), 1, this.rAa);
        this.rzV = new 3(this, this, this.rAa);
        FrameLayout frameLayout = (FrameLayout) findViewById(f.qFL);
        this.rrF = new com.tencent.mm.plugin.sns.f.b(this, this.rzV, frameLayout);
        this.rrE = new c(this, this.rzV, frameLayout, this.rrF);
        this.rzV.aUG();
        this.fzW = bh.az(getIntent().getStringExtra("INTENT_SNSID"), "");
        if (bh.ov(this.fzW)) {
            this.fzW = u.ab("sns_table_", getIntent().getLongExtra("INTENT_SNSID", 0));
        }
        this.rzH = bh.az(getIntent().getStringExtra("INTENT_SNS_LOCAL_ID"), "");
        if (bh.ov(this.rzH)) {
            int intExtra = getIntent().getIntExtra("INTENT_SNS_LOCAL_ID", -1);
            if (intExtra != -1) {
                this.rzH = u.ab("sns_table_", (long) intExtra);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_SNS_TIMELINEOBJECT");
        if (byteArrayExtra != null) {
            bnp com_tencent_mm_protocal_c_bnp = new bnp();
            try {
                com_tencent_mm_protocal_c_bnp.aF(byteArrayExtra);
                if (ae.bvv().eR(new BigInteger(com_tencent_mm_protocal_c_bnp.nGJ).longValue()) == null) {
                    x.i("MicroMsg.SnsCommentDetailUI", "info is null, can insert to sns info");
                    com.tencent.mm.sdk.e.c mVar = new m();
                    mVar.field_snsId = new BigInteger(com_tencent_mm_protocal_c_bnp.nGJ).longValue();
                    try {
                        mVar.field_content = com_tencent_mm_protocal_c_bnp.toByteArray();
                    } catch (Exception e) {
                    }
                    mVar.field_createTime = com_tencent_mm_protocal_c_bnp.pbl;
                    mVar.field_userName = com_tencent_mm_protocal_c_bnp.ksU;
                    mVar.field_type = com_tencent_mm_protocal_c_bnp.wQo.vYc;
                    mVar.byn();
                    bjv com_tencent_mm_protocal_c_bjv = new bjv();
                    com_tencent_mm_protocal_c_bjv.wMW = new bdn();
                    try {
                        mVar.field_attrBuf = com_tencent_mm_protocal_c_bjv.toByteArray();
                    } catch (IOException e2) {
                    }
                    ae.bvv().b(mVar);
                    x.i("MicroMsg.FTS.SnsComment", "insert sns obj use time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } else {
                    x.i("MicroMsg.SnsCommentDetailUI", "info is not null, can not insert to sns info");
                }
            } catch (IOException e3) {
            }
        }
        m iI = iI(true);
        x.i("MicroMsg.SnsCommentDetailUI", "onCreate()  snsId : " + this.fzW + " localSnsId: " + this.rzH);
        if (iI != null) {
            x.i("MicroMsg.SnsCommentDetailUI", "commentdetail %s", bh.az(iI.field_userName, ""));
        }
        if (u.LH(this.fzW)) {
            if (!u.Jv(this.fzW)) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(new com.tencent.mm.plugin.sns.model.l(u.LF(this.fzW), 0, iI.bxT().rek), 0);
            } else if (iI == null) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(new p(u.LF(this.fzW)), 0);
            } else if (!s.gD(iI.field_userName)) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(new p(u.LF(this.fzW)), 0);
            }
        }
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a((int) i.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(218, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(682, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a((int) JsApiCheckIsSupportFaceDetect.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(683, (e) this);
        this.rzI = ae.bvj();
        this.rry = new ao(this);
        this.rzG = new ar(this.mController.xIM);
        this.rzL = new k(this, 1, this.rAa);
        if (iI != null) {
            this.kTK = av.d(iI.bxV());
        }
        if (iI != null && iI.xl(32)) {
            this.rzU = new g(2);
            av.d(iI.bxV());
        }
        initView();
        if (iI != null && iI.xl(32)) {
            this.rzU.a(0, iI.byq(), iI.byz(), iI.bym(), this.rzs, iI.field_snsId, this.rAq, ai.m(iI), this.kTK, 2);
        }
        if (this.rzs != null) {
            com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) this.rzs.findViewById(f.image);
            if (iI.bxV().wQo != null && iI.bxV().wQo.vYc == 15 && (aVar instanceof SightPlayImageView)) {
                z = ((SightPlayImageView) aVar).quA.bsK();
            }
            com.tencent.mm.plugin.sns.a.b.j.a(iI, true, z);
        }
        if (this.rzw != null) {
            this.rzw.setOnTouchListener(new 4(this));
            com.tencent.mm.sdk.b.a.xef.b(this.jeX);
            com.tencent.mm.sdk.b.a.xef.b(this.rAb);
            com.tencent.mm.sdk.b.a.xef.b(this.rAc);
            com.tencent.mm.sdk.b.a.xef.b(this.rAd);
            com.tencent.mm.sdk.b.a.xef.b(this.rAe);
            com.tencent.mm.sdk.b.a.xef.b(this.rAi);
            com.tencent.mm.sdk.b.a.xef.b(this.rAj);
            com.tencent.mm.pluginsdk.e.i(this);
        }
    }

    public void onDestroy() {
        ae.bvl().a(this, 5);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b((int) i.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(218, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b((int) JsApiCheckIsSupportFaceDetect.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(683, (e) this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(682, (e) this);
        ae.bvs().K(this);
        com.tencent.mm.sdk.b.a.xef.c(this.jeX);
        if (this.rzL != null) {
            this.rzL.activity = null;
        }
        ab.bzE();
        if (this.rrw != null) {
            this.rrw.aXS();
        }
        m iI = iI(false);
        if (!(this.rzU == null || iI == null || !iI.xl(32))) {
            this.rzU.t(0, iI.byq(), iI.byz());
            com.tencent.mm.plugin.sns.storage.a bxT = iI.bxT();
            String str = bxT == null ? "" : bxT.qZM;
            com.tencent.mm.plugin.sns.a.b.i bvp;
            Object[] objArr;
            if (iI.bwE()) {
                bvp = ae.bvp();
                objArr = new Object[1];
                objArr[0] = com.tencent.mm.plugin.sns.a.b.f.a(iI.field_snsId, new Object[]{com.tencent.mm.plugin.sns.data.i.eq(iI.field_snsId), str, Long.valueOf(this.rzq), Long.valueOf(System.currentTimeMillis())});
                bvp.h(14652, objArr);
            } else {
                bvp = ae.bvp();
                objArr = new Object[1];
                objArr[0] = com.tencent.mm.plugin.sns.a.b.f.a(iI.field_snsId, new Object[]{com.tencent.mm.plugin.sns.data.i.eq(iI.field_snsId), str, Long.valueOf(this.rzq), Long.valueOf(System.currentTimeMillis())});
                bvp.h(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT, objArr);
            }
            com.tencent.mm.modelsns.b iv = com.tencent.mm.modelsns.b.iv(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
            iv.mB(com.tencent.mm.plugin.sns.data.i.eq(iI.field_snsId)).mB(str).mB(this.rzq).mB(System.currentTimeMillis());
            iv.Sx();
        }
        this.rzV.aBM();
        com.tencent.mm.sdk.b.a.xef.c(this.rAb);
        com.tencent.mm.sdk.b.a.xef.c(this.rAc);
        com.tencent.mm.sdk.b.a.xef.c(this.rAd);
        com.tencent.mm.sdk.b.a.xef.c(this.rAe);
        com.tencent.mm.sdk.b.a.xef.c(this.rAi);
        com.tencent.mm.sdk.b.a.xef.c(this.rAj);
        super.onDestroy();
    }

    public void onResume() {
        ae.bvq().a(this);
        if (this.rrw != null) {
            SnsCommentFooter snsCommentFooter = this.rrw;
            if (u.LH(this.fzW)) {
                if (snsCommentFooter.rBd != null) {
                    snsCommentFooter.rBd.setEnabled(true);
                }
                if (snsCommentFooter.rBc != null) {
                    snsCommentFooter.rBc.setEnabled(true);
                }
            } else {
                if (snsCommentFooter.rBd != null) {
                    snsCommentFooter.rBd.setEnabled(false);
                }
                if (snsCommentFooter.rBc != null) {
                    snsCommentFooter.rBc.setEnabled(false);
                }
            }
        }
        com.tencent.mm.sdk.b.b rtVar = new rt();
        rtVar.fJy.fJz = 0;
        rtVar.fJy.fJA = 1;
        rtVar.fJy.fJB = 0;
        rtVar.fJy.type = 0;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
        if (this.rzU != null) {
            this.rzU.onResume();
        }
        m iI = iI(false);
        if (iI != null && iI.xl(32) && iI.bwy()) {
            B(iI);
        }
        super.onResume();
    }

    public void onPause() {
        ae.bvq().b(this);
        super.onPause();
        this.rrw.okx.onPause();
        new rt().fJy.type = 1;
        if (this.rzU != null) {
            this.rzU.onPause();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qHh;
    }

    protected final void initView() {
        setMMTitle(j.qKq);
        17 17 = new 17(this);
        setBackBtn(new 18(this));
        this.gze = com.tencent.mm.z.q.FS();
        if (ae.bve()) {
            finish();
        }
        m iI = iI(true);
        if (iI == null) {
            x.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.fzW);
            finish();
            return;
        }
        boolean z;
        x.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.fzW + "localId " + this.rzH + "  username:" + iI.field_userName);
        if (!u.LH(this.fzW) && iI.bys()) {
            aqs byi = iI.byi();
            findViewById(f.qFh).setVisibility(0);
            TextView textView = (TextView) findViewById(f.qDa);
            switch (byi.wyj) {
                case 201:
                    if (bh.ov(byi.wyr)) {
                        textView.setText(j.qLS);
                    } else {
                        textView.setText(byi.wyr);
                    }
                    findViewById(f.qFi).setVisibility(8);
                    z = false;
                    break;
                case i.CTRL_INDEX /*210*/:
                    if (bh.ov(byi.wyr)) {
                        textView.setText(j.qLU);
                    } else {
                        textView.setText(byi.wyr);
                    }
                    findViewById(f.qFi).setVisibility(8);
                    z = false;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                    if (bh.ov(byi.wyr)) {
                        textView.setText(j.qLT);
                    } else {
                        textView.setText(byi.wyr);
                    }
                    findViewById(f.qFi).setVisibility(8);
                    z = true;
                    break;
                default:
                    if (bh.ov(byi.wyr)) {
                        textView.setText(j.qLV);
                    } else {
                        textView.setText(byi.wyr);
                    }
                    findViewById(f.qFi).setVisibility(0);
                    z = true;
                    break;
            }
        }
        findViewById(f.qFh).setVisibility(8);
        z = false;
        if (z) {
            findViewById(f.qFh).setOnClickListener(new 8(this, iI));
        }
        this.rzw = (ListView) findViewById(f.qAF);
        this.rzw.post(new 9(this));
        this.rzw.setOnScrollListener(new 10(this));
        this.rzs = v.fv(this.mController.xIM).inflate(com.tencent.mm.plugin.sns.i.g.qHi, null);
        this.rzs.setOnClickListener(this.rAh);
        this.rzw.addHeaderView(this.rzs);
        z = bAD();
        if (z) {
            m iI2 = iI(false);
            if (iI2 != null) {
                this.kTK = av.d(iI2.bxV());
            }
            if (this.kTK == 11 && com.tencent.mm.z.q.FS().equals(iI.field_userName)) {
                this.rzv = new SnsDetailLuckyHeader(this);
                this.rzv.setLayoutParams(new LayoutParams(-1, -2));
                this.rzv.setOnClickListener(this.rAh);
            }
            this.rzu = new LinearLayout(this.mController.xIM);
            this.rzu.setLayoutParams(new LayoutParams(-1, -2));
            this.rzu.setOnClickListener(this.rAh);
            BackwardSupportUtil.b.b((Context) this, 2.0f);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 1);
            LinearLayout linearLayout = new LinearLayout(this.mController.xIM);
            linearLayout.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qzO);
            linearLayout.setLayoutParams(layoutParams);
            this.qSj = linearLayout;
            if ((iI.field_localPrivate & 1) != 0) {
                findViewById(f.qBF).setVisibility(8);
                View textView2 = new TextView(this);
                textView2.setLayoutParams(new LayoutParams(-1, -2));
                textView2.setText(getString(j.qKw));
                textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                textView2.setGravity(17);
                textView2.setPadding(0, BackwardSupportUtil.b.b((Context) this, 7.0f), 0, 0);
                this.rzw.addFooterView(textView2);
            }
            if (this.rzv != null) {
                this.rzX = true;
                this.rzw.addHeaderView(this.rzv);
            }
            bjv m = ai.m(iI);
            if (m == null) {
                this.rzu.setVisibility(8);
                this.rzy = new b(this, new LinkedList(), new LinkedList(), this, iI.byq());
            } else {
                this.rzD = m.wNa;
                g(m.wNa, m.wNd.isEmpty());
                if (this.rzv != null) {
                    this.rzv.a(iI, this.rzV);
                }
                this.rzy = new b(this, m.wNd, m.wNa, this, iI.byq());
            }
            this.rzw.addHeaderView(this.rzu);
            this.rzw.setAdapter(this.rzy);
            this.rrw = (SnsCommentFooter) findViewById(f.qBF);
            this.rrw.rBi = new 11(this, iI);
            this.rrw.rBj = new 13(this);
            iI2 = iI(true);
            if (!(iI2 == null || iI2.byp())) {
                this.rrw.setVisibility(8);
            }
            this.rrw.bAK();
            this.rrw.bAO();
            this.rrw.a(new 14(this, iI));
            SnsCommentFooter snsCommentFooter = this.rrw;
            SnsCommentFooter.b 15 = new 15(this);
            int i = iI.field_likeFlag;
            snsCommentFooter.rBc.setVisibility(0);
            snsCommentFooter.rBc.setOnClickListener(new 7(snsCommentFooter, 15));
            this.rrw.bAR();
            this.rzM = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
            if (this.rzM) {
                this.rzN = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0);
                if (!(this.rzN == 0 || this.rzy.rAV == null)) {
                    int i2 = 0;
                    while (i2 < this.rzy.rAV.size()) {
                        bjk com_tencent_mm_protocal_c_bjk = (bjk) this.rzy.rAV.get(i2);
                        if ((com_tencent_mm_protocal_c_bjk.wMw != 0 ? (long) com_tencent_mm_protocal_c_bjk.wMw : com_tencent_mm_protocal_c_bjk.wMz) == this.rzN) {
                            int i3;
                            this.rzw.setSelection(i2);
                            com.tencent.mm.l.a WO = this.rzI.WO(com_tencent_mm_protocal_c_bjk.vIy);
                            String AQ = WO != null ? WO.AQ() : com_tencent_mm_protocal_c_bjk.wvW != null ? com_tencent_mm_protocal_c_bjk.wvW : com_tencent_mm_protocal_c_bjk.vIy;
                            this.rrw.a(getString(j.qLZ) + AQ, com_tencent_mm_protocal_c_bjk);
                            if (m.wNa.size() > 0) {
                                i3 = i2 + 1;
                                if (i3 > this.rzy.getCount()) {
                                    i3 = this.rzy.getCount() - 1;
                                }
                            } else {
                                i3 = i2;
                            }
                            this.rAf.Dy = i3;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            if (this.rzM) {
                new com.tencent.mm.sdk.platformtools.af().postDelayed(new 16(this), 100);
            }
            this.rzW = (SnsTranslateResultView) this.rzs.findViewById(f.qFD);
            this.rzW.az(((TextView) this.rzs.findViewById(f.caS)).getTextSize());
            this.rzW.pYa.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qzK);
            this.rzW.pYa.setTag(new as(this.fzW, iI.byq(), false, true, 2));
            this.contextMenuHelper.a(this.rzW.pYa, this.rzV.rPs, this.rzV.rPp);
            if (ao.cc(this.fzW, 4)) {
                ao.b Kr = ao.Kr(this.fzW);
                if (Kr == null || !Kr.hik) {
                    this.rzW.setVisibility(8);
                    return;
                }
                this.rzW.setVisibility(0);
                this.rzW.a(null, 1, Kr.result, Kr.hqd, false);
                return;
            }
            this.rzW.setVisibility(8);
            return;
        }
        x.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader " + z);
        finish();
    }

    private int bAB() {
        if (this.rzw == null || this.rzw.getChildCount() <= 1) {
            return 0;
        }
        View childAt = this.rzw.getChildAt(0);
        if (childAt != null) {
            return childAt.getHeight();
        }
        return 0;
    }

    private LinearLayout xA(int i) {
        if (this.rAl == null) {
            this.rAl = (LinearLayout) v.fv(this).inflate(i, null);
            return this.rAl;
        }
        this.rAk = true;
        return this.rAl;
    }

    private static boolean bAC() {
        return (al.a.bvV() & 1) <= 0;
    }

    private void B(m mVar) {
        int i = 0;
        if (mVar != null && mVar.bwy()) {
            int i2 = com.tencent.mm.plugin.sns.i.e.qzJ;
            int parseColor = Color.parseColor("#cdcdcd");
            int parseColor2 = Color.parseColor("#ffffff");
            Button button = (Button) this.rzs.findViewById(f.qBz);
            Button button2 = (Button) this.rzs.findViewById(f.qBA);
            if (button != null && button2 != null) {
                button.setOnClickListener(this.rzV.rPS);
                button2.setOnClickListener(this.rzV.rPT);
                if (mVar.bxR().bwA()) {
                    int en = u.en(mVar.bxR().rfn.rfs, mVar.byA());
                    if (en > 0 && en <= 2) {
                        if (en == 1) {
                            button2.setBackgroundColor(parseColor2);
                            button2.setTextColor(parseColor);
                            button2.setText(mVar.bxR().rfn.wU(1));
                            button.setBackgroundResource(i2);
                            button.setTextColor(WebView.NIGHT_MODE_COLOR);
                            button.setText(mVar.bxR().rfn.wT(0));
                        } else if (en == 2) {
                            button.setBackgroundColor(parseColor2);
                            button.setTextColor(parseColor);
                            button.setText(mVar.bxR().rfn.wU(0));
                            button2.setBackgroundResource(i2);
                            button2.setTextColor(WebView.NIGHT_MODE_COLOR);
                            button2.setText(mVar.bxR().rfn.wT(1));
                        }
                        if (i != 0) {
                            button.setTextColor(WebView.NIGHT_MODE_COLOR);
                            button.setBackgroundResource(i2);
                            button2.setTextColor(WebView.NIGHT_MODE_COLOR);
                            button2.setBackgroundResource(i2);
                            button.setText(mVar.bxR().bwu());
                            button2.setText(mVar.bxR().bwv());
                        }
                    }
                }
                i = 1;
                if (i != 0) {
                    button.setTextColor(WebView.NIGHT_MODE_COLOR);
                    button.setBackgroundResource(i2);
                    button2.setTextColor(WebView.NIGHT_MODE_COLOR);
                    button2.setBackgroundResource(i2);
                    button.setText(mVar.bxR().bwu());
                    button2.setText(mVar.bxR().bwv());
                }
            }
        }
    }

    final boolean bAD() {
        m iI = iI(true);
        if (iI == null) {
            return false;
        }
        x.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.rzs.toString());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        cmQ().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        this.mScreenWidth = this.mScreenHeight < this.mScreenWidth ? this.mScreenHeight : this.mScreenWidth;
        this.rzQ = ae.bvD();
        bnp bxV = iI.bxV();
        this.kTK = av.d(bxV);
        ImageView imageView = (ImageView) this.rzs.findViewById(f.qAx);
        if (imageView == null || iI == null) {
            x.e("MicroMsg.SnsCommentDetailUI", "unknow error ? " + (imageView == null) + " " + (iI == null));
            return false;
        }
        ((MaskImageButton) imageView).zlH = iI.byq();
        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, iI.getUserName(), true);
        imageView.setTag(iI.getUserName());
        imageView.setOnClickListener(this.rzV.rPq);
        TextView textView = (TextView) this.rzs.findViewById(f.cAn);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.storage.x WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(iI.getUserName());
        x.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + iI.getUserName() + " " + iI.bxW() + " " + iI.byj());
        if (WO == null) {
            return false;
        }
        String str;
        int i;
        CharSequence jVar;
        String str2;
        View findViewById;
        com.tencent.mm.plugin.sns.storage.a bxT;
        ViewStub viewStub;
        TagImageView tagImageView;
        List linkedList;
        com.tencent.mm.plugin.sns.storage.b bxR;
        int i2;
        aqt com_tencent_mm_protocal_c_aqt;
        float a;
        float a2;
        float fromDPToPix;
        int i3;
        aqt com_tencent_mm_protocal_c_aqt2;
        ar arVar;
        PhotosContent photosContent;
        String byq;
        int hashCode;
        int i4;
        CharSequence charSequence;
        CharSequence charSequence2;
        AsyncTextView asyncTextView;
        AsyncTextView asyncTextView2;
        com.tencent.mm.plugin.sns.storage.a bxT2;
        Iterator it;
        String str3;
        com.tencent.mm.l.a WN;
        CharSequence jVar2;
        TextPaint paint;
        bjv m;
        Iterator it2;
        Object obj;
        bjk com_tencent_mm_protocal_c_bjk;
        Object obj2;
        StringBuilder append;
        ImageButton imageButton;
        m iI2;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView2;
        TextView textView3;
        if (WO.AO() == 0) {
            x.i("MicroMsg.SnsCommentDetailUI", "getContact %s", iI.getUserName());
            ak.a.GQ().a(iI.getUserName(), "", this.rAp);
        }
        String az = bh.az(WO == null ? iI.getUserName() : WO.AQ(), "");
        if (iI.kf() && bh.ov(az)) {
            com.tencent.mm.plugin.sns.storage.b bxR2 = iI.bxR();
            if (!(bxR2 == null || bh.ov(bxR2.fpL))) {
                LinearLayout linearLayout;
                ViewGroup.LayoutParams layoutParams;
                str = bxR2.fpL;
                str.length();
                i = this.kTK != 11 ? 3 : 2;
                jVar = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, (CharSequence) str));
                jVar.f(new n(new com.tencent.mm.plugin.sns.data.a(iI.kf(), WO.getUsername(), iI.byq(), 2), this.rzL, i), str);
                textView.setOnTouchListener(new ab());
                textView.setText(jVar, BufferType.SPANNABLE);
                ((TextView) this.rzs.findViewById(f.qGa)).setText("");
                this.rAq = new bf(this.rzs);
                if (iI.kf()) {
                    this.rAq.setVisibility(8);
                } else {
                    this.rAq.q(Long.valueOf(iI.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.rAq, 0, this.rzH, iI.field_snsId, iI.byz()));
                    this.rAq.a(iI.bxR(), iI.bxT());
                    this.rAq.a(this.rzV.rPz, this.rzV.rPO);
                    this.rAq.setVisibility(0);
                }
                str2 = bxV.wQl;
                this.rzt = (TextView) this.rzs.findViewById(f.caS);
                this.rzt.setTag(new as(this.fzW, iI.byq(), true, false, 2));
                this.contextMenuHelper.a(this.rzt, this.rzV.rPs, this.rzV.rPp);
                findViewById = this.rzs.findViewById(f.qBy);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                findViewById = this.rzs.findViewById(f.qBB);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                if (iI.kf() || iI.bxR() == null || iI.bxR().rfi != 1 || this.kTK == 12) {
                    az = str2;
                } else {
                    bxT = iI.bxT();
                    if (!(bxT == null || !bxT.bwr() || iI.byE())) {
                        findViewById.setVisibility(0);
                    }
                    this.rzt.setVisibility(8);
                    this.rzt = (TextView) this.rzs.findViewById(f.qBV);
                    this.rzt.setClickable(false);
                    this.rzt.setLongClickable(false);
                    linearLayout = (LinearLayout) this.rzs.findViewById(f.qCr);
                    linearLayout.setBackground(cmQ().getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qzH));
                    layoutParams = new LinearLayout.LayoutParams(((((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12), -2);
                    layoutParams.setMargins(0, com.tencent.mm.bv.a.fromDPToPix(cmQ(), 5), 0, 0);
                    linearLayout.setLayoutParams(layoutParams);
                    TextView textView4 = (TextView) this.rzs.findViewById(f.qBR);
                    textView4.setClickable(false);
                    textView4.setLongClickable(false);
                    if (bh.ov(iI.bxR().rfj)) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setText(iI.bxR().rfj + " ");
                        com.tencent.mm.pluginsdk.ui.d.i.f(textView4, 2);
                        textView4.setVisibility(0);
                    }
                    if (bh.ov(iI.bxR().rfk)) {
                        az = bxV.wQl;
                    } else {
                        az = iI.bxR().rfk;
                    }
                    this.contextMenuHelper.a(linearLayout, this.rzV.rPG, this.rzV.rPp);
                    if (iI.bxR().bwz() || iI.bxR().bwA()) {
                        this.rzs.findViewById(f.qBy).setVisibility(0);
                        B(iI);
                    }
                }
                if (az != null || az.equals("")) {
                    this.rzt.setVisibility(8);
                } else {
                    this.rzt.setText(az + " ");
                    com.tencent.mm.pluginsdk.ui.d.i.f(this.rzt, 2);
                    this.rzt.setVisibility(0);
                }
                av.e(bxV);
                viewStub = (ViewStub) this.rzs.findViewById(f.qCq);
                if (!this.rAm) {
                    if (this.kTK == 2) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qIb);
                    } else if (this.kTK == 3) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qHY);
                    } else if (this.kTK == 4) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qHZ);
                    } else if (this.kTK == 5) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qIa);
                    } else if (this.kTK != 6) {
                        if (this.kTK != 1 || this.kTK == 0) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qHA);
                        } else if (this.kTK == 9) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qEK);
                        } else if (this.kTK == 11) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qHq);
                        } else if (this.kTK == 12) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qIe);
                        }
                    }
                    if (this.kTK != 2 || this.kTK == 3 || this.kTK == 4 || this.kTK == 5) {
                        this.rAn = (PhotosContent) viewStub.inflate();
                    } else if (this.kTK == 9) {
                        viewStub.inflate();
                    } else if (this.kTK == 11) {
                        this.rAn = (PhotosContent) viewStub.inflate();
                    } else if (this.kTK == 12) {
                        viewStub.inflate();
                    } else {
                        viewStub.setVisibility(8);
                    }
                    this.rAm = true;
                }
                if (this.kTK != 6) {
                    LinearLayout.LayoutParams layoutParams2;
                    if (this.kTK != 2 || this.kTK == 3 || this.kTK == 4 || this.kTK == 5) {
                        if (this.rAn == null) {
                            this.rAn.bzX();
                            for (i = 0; i < ar.rDQ[this.kTK]; i++) {
                                tagImageView = (TagImageView) this.rAn.findViewById(ar.rDU[i]);
                                this.rAn.a(tagImageView);
                                tagImageView.setOnClickListener(this.rzV.rtw);
                                this.contextMenuHelper.a(tagImageView, this.rzV.rPD, this.rzV.rPp);
                            }
                            this.rAn.xx(this.rzQ);
                            linkedList = new LinkedList();
                            if (iI.kf() && this.kTK == 2) {
                                bxR = iI.bxR();
                                if (bxR == null && bxR.rfi == 1) {
                                    aqr com_tencent_mm_protocal_c_aqr;
                                    i = ((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth();
                                    if (bxV.wQo == null || bxV.wQo.vYd.size() <= 0) {
                                        com_tencent_mm_protocal_c_aqr = null;
                                    } else {
                                        com_tencent_mm_protocal_c_aqr = (aqr) bxV.wQo.vYd.get(0);
                                    }
                                    i = (((i - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 20);
                                    i2 = (int) ((com_tencent_mm_protocal_c_aqr.wxH.wyv * ((float) i)) / com_tencent_mm_protocal_c_aqr.wxH.wyu);
                                    com_tencent_mm_protocal_c_aqt = new aqt();
                                    com_tencent_mm_protocal_c_aqt.wyu = (float) i;
                                    com_tencent_mm_protocal_c_aqt.wyv = (float) i2;
                                    com_tencent_mm_protocal_c_aqt.wyw = com_tencent_mm_protocal_c_aqt.wyu * com_tencent_mm_protocal_c_aqt.wyv;
                                    linkedList.add(com_tencent_mm_protocal_c_aqt);
                                    layoutParams2 = (LinearLayout.LayoutParams) this.rAn.getLayoutParams();
                                    layoutParams2.leftMargin = com.tencent.mm.bv.a.fromDPToPix(cmQ(), 10);
                                    layoutParams2.rightMargin = com.tencent.mm.bv.a.fromDPToPix(cmQ(), 10);
                                    this.rAn.setLayoutParams(layoutParams2);
                                    this.rzs.findViewById(f.qCr).setTag(this.rAn.xy(0));
                                    this.rzs.findViewById(f.qCr).setOnClickListener(this.rzV.rPU);
                                    for (i = 0; i < ar.rDQ[this.kTK]; i++) {
                                        this.contextMenuHelper.a((TagImageView) this.rAn.findViewById(ar.rDU[i]), this.rzV.rPG, this.rzV.rPp);
                                    }
                                    this.rzs.findViewById(f.qBz).setTag(this.rAn.xy(0));
                                    this.rzs.findViewById(f.qBA).setTag(this.rAn.xy(0));
                                } else if (bxR != null && bxR.reY > 0.0f && bxR.reZ > 0.0f) {
                                    a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR.reY, 1, bxR.rfa, bxR.rfb);
                                    a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR.reZ, 1, bxR.rfa, bxR.rfb);
                                    if (bxR.reX == 0) {
                                        i2 = ((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth();
                                        if (a < ((float) (((i2 - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)))) {
                                            fromDPToPix = (float) (((i2 - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12));
                                            a = (float) ((int) ((bxR.reZ * fromDPToPix) / bxR.reY));
                                        } else {
                                            fromDPToPix = a;
                                            a = a2;
                                        }
                                        com_tencent_mm_protocal_c_aqt = new aqt();
                                        com_tencent_mm_protocal_c_aqt.wyu = fromDPToPix;
                                        com_tencent_mm_protocal_c_aqt.wyv = a;
                                        com_tencent_mm_protocal_c_aqt.wyw = com_tencent_mm_protocal_c_aqt.wyu * com_tencent_mm_protocal_c_aqt.wyv;
                                        linkedList.add(com_tencent_mm_protocal_c_aqt);
                                    } else if (bxR.reX == 1) {
                                        i2 = (((((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12);
                                        i3 = (int) ((((float) i2) * bxR.reZ) / bxR.reY);
                                        com_tencent_mm_protocal_c_aqt2 = new aqt();
                                        if (i2 > 0) {
                                            a = (float) i2;
                                        }
                                        com_tencent_mm_protocal_c_aqt2.wyu = a;
                                        if (i3 > 0) {
                                            a2 = (float) i3;
                                        }
                                        com_tencent_mm_protocal_c_aqt2.wyv = a2;
                                        com_tencent_mm_protocal_c_aqt2.wyw = com_tencent_mm_protocal_c_aqt2.wyu * com_tencent_mm_protocal_c_aqt2.wyv;
                                        linkedList.add(com_tencent_mm_protocal_c_aqt2);
                                    } else if (bxR.reX == 2) {
                                        i2 = ((((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12);
                                        i3 = (int) ((((float) i2) * bxR.reZ) / bxR.reY);
                                        com_tencent_mm_protocal_c_aqt2 = new aqt();
                                        if (i2 > 0) {
                                            a = (float) i2;
                                        }
                                        com_tencent_mm_protocal_c_aqt2.wyu = a;
                                        if (i3 > 0) {
                                            a2 = (float) i3;
                                        }
                                        com_tencent_mm_protocal_c_aqt2.wyv = a2;
                                        com_tencent_mm_protocal_c_aqt2.wyw = com_tencent_mm_protocal_c_aqt2.wyu * com_tencent_mm_protocal_c_aqt2.wyv;
                                        linkedList.add(com_tencent_mm_protocal_c_aqt2);
                                    }
                                }
                                if (!bh.ov(bxR.rfd)) {
                                    d.a("adId", bxR.rfd, false, 41, 0, new 20(this, this.rAn, bxR, this.rAn.xy(0)));
                                }
                            }
                            this.rzs.addOnAttachStateChangeListener(new 21(this, bxV, iI, linkedList));
                            arVar = this.rzG;
                            photosContent = this.rAn;
                            byq = iI.byq();
                            hashCode = hashCode();
                            i4 = this.kTK;
                            iI.xl(32);
                            arVar.a(photosContent, bxV, byq, hashCode, i4, -1, false, an.xyX, linkedList);
                        } else {
                            x.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.kTK + ",stub is " + viewStub.toString());
                        }
                    } else if (this.kTK == 11) {
                        this.rAn.bzX();
                        tagImageView = (TagImageView) this.rAn.findViewById(f.qAT);
                        this.rAn.a(tagImageView);
                        tagImageView.setOnClickListener(this.rzV.rtw);
                        az = iI.byq();
                        List arrayList = new ArrayList();
                        arrayList.add(tagImageView);
                        r7 = new ap();
                        r7.fus = az;
                        r7.index = 0;
                        r7.rBS = arrayList;
                        r7.rzb = true;
                        if (tagImageView != null) {
                            tagImageView.setTag(r7);
                        }
                        textView = (TextView) this.rzs.findViewById(f.qCn);
                        if (com.tencent.mm.z.q.FS().equals(bxV.ksU)) {
                            textView.setVisibility(8);
                        } else {
                            bjv n = ai.n(iI);
                            if (n.wNo == null || n.wNo.wNQ == 0) {
                                textView.setVisibility(8);
                            } else {
                                textView.setText(getString(j.qJC, new Object[]{Integer.valueOf(n.wNo.wNQ)}));
                                textView.setVisibility(0);
                            }
                        }
                        aqs byi = iI.byi();
                        if (byi == null) {
                            x.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + iI.byq());
                        } else if (com.tencent.mm.z.q.FS().equals(bxV.ksU)) {
                            arVar = this.rzG;
                            photosContent = this.rAn;
                            byq = iI.byq();
                            hashCode = hashCode();
                            i4 = this.kTK;
                            iI.xl(32);
                            arVar.a(photosContent, bxV, byq, hashCode, i4, -1, false, an.xyX, true);
                        } else if (com.tencent.mm.plugin.sns.lucky.a.m.h(iI)) {
                            arVar = this.rzG;
                            photosContent = this.rAn;
                            byq = iI.byq();
                            hashCode = hashCode();
                            i4 = this.kTK;
                            iI.xl(32);
                            arVar.a(photosContent, bxV, byq, hashCode, i4, -1, false, an.xyX, false);
                        } else if (byi.fLD == 0) {
                            arVar = this.rzG;
                            photosContent = this.rAn;
                            byq = iI.byq();
                            hashCode = hashCode();
                            i4 = this.kTK;
                            iI.xl(32);
                            arVar.a(photosContent, bxV, byq, hashCode, i4, -1, false, an.xyX, true);
                        } else {
                            x.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + byi.fLD);
                        }
                    } else if (this.kTK == 9) {
                        this.rzZ = true;
                        ak akVar = new ak();
                        View view = this.rzs;
                        r13 = view.findViewById(f.bTD);
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(f.image);
                        akVar.rxh = r13;
                        akVar.rkR = (ImageView) view.findViewById(f.cPl);
                        akVar.rxi = (MMPinProgressBtn) view.findViewById(f.progress);
                        akVar.rkU = (TextView) view.findViewById(f.qCb);
                        akVar.rxj = (TextView) view.findViewById(f.qCa);
                        akVar.qvN = aVar;
                        akVar.a(bxV, 0, iI.byq(), iI.kf());
                        akVar.rkU.setVisibility(8);
                        akVar.qvN.bH(akVar);
                        r13.setTag(akVar);
                        akVar.rxh.setOnClickListener(this.rzV.rPM);
                        if (iI.bwy()) {
                            this.contextMenuHelper.a(r13, this.rzV.rPG, this.rzV.rPp);
                        } else {
                            this.contextMenuHelper.a(r13, this.rzV.rPF, this.rzV.rPp);
                        }
                        Pair a3 = com.tencent.mm.modelsns.e.a(bxV, akVar.qvN.bsF(), iI.kf());
                        if (iI.kf()) {
                            com.tencent.mm.plugin.sns.storage.b bxR3 = iI.bxR();
                            if (bxR3 != null && bxR3.rfi == 1) {
                                if (bxV.wQo == null || bxV.wQo.vYd.size() <= 0) {
                                    r6 = null;
                                } else {
                                    r6 = (aqr) bxV.wQo.vYd.get(0);
                                }
                                if (r6 != null) {
                                    i2 = (((((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 20);
                                    a3 = Pair.create(Integer.valueOf(i2), Integer.valueOf((int) ((((float) i2) * r6.wxH.wyv) / r6.wxH.wyu)));
                                }
                                layoutParams2 = (LinearLayout.LayoutParams) akVar.rxh.getLayoutParams();
                                layoutParams2.leftMargin = com.tencent.mm.bv.a.fromDPToPix(cmQ(), 10);
                                layoutParams2.rightMargin = com.tencent.mm.bv.a.fromDPToPix(cmQ(), 10);
                                akVar.rxh.setLayoutParams(layoutParams2);
                                this.rzs.findViewById(f.qCr).setTag(akVar);
                                this.rzs.findViewById(f.qCr).setOnClickListener(this.rzV.rPU);
                                this.rzs.findViewById(f.qBz).setTag(akVar);
                                this.rzs.findViewById(f.qBA).setTag(akVar);
                            } else if (bxR3 != null && bxR3.reY > 0.0f && bxR3.reZ > 0.0f) {
                                float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR3.reY, 1, bxR3.rfa, bxR3.rfb);
                                a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR3.reZ, 1, bxR3.rfa, bxR3.rfb);
                                if (bxR3.reX == 0) {
                                    i2 = ((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth();
                                    if (a4 >= ((float) (((i2 - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)))) {
                                        a = (float) (((i2 - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12));
                                        fromDPToPix = (float) ((int) ((bxR3.reZ * a) / bxR3.reY));
                                    } else {
                                        fromDPToPix = a2;
                                        a = a4;
                                    }
                                    a3 = Pair.create(Integer.valueOf((int) a), Integer.valueOf((int) fromDPToPix));
                                } else if (bxR3.reX == 1) {
                                    i2 = (((((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12);
                                    a3 = Pair.create(Integer.valueOf(i2), Integer.valueOf((int) ((((float) i2) * bxR3.reZ) / bxR3.reY)));
                                } else if (bxR3.reX == 2) {
                                    i2 = ((((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12);
                                    a3 = Pair.create(Integer.valueOf(i2), Integer.valueOf((int) ((((float) i2) * bxR3.reZ) / bxR3.reY)));
                                }
                            }
                        }
                        if (a3 != null) {
                            aVar.dt(((Integer) a3.first).intValue(), ((Integer) a3.second).intValue());
                            layoutParams = akVar.rxj.getLayoutParams();
                            layoutParams.width = ((Integer) a3.first).intValue();
                            layoutParams.height = ((Integer) a3.second).intValue();
                            akVar.rxj.setLayoutParams(layoutParams);
                        }
                        if (bxV.wQo == null || bxV.wQo.vYd.size() <= 0) {
                            r6 = null;
                        } else {
                            r6 = (aqr) bxV.wQo.vYd.get(0);
                        }
                        if (iI.kf()) {
                            akVar.qvN.a(new 22(this, iI));
                            if (!this.rzU.ej(iI.field_snsId)) {
                                akVar.qvN.a(new 24(this, iI, akVar));
                            }
                        }
                        if (bxV.wQo != null && bxV.wQo.vYd.size() > 0) {
                            ae.bvs();
                            if (com.tencent.mm.plugin.sns.model.g.t(r6)) {
                                if (ae.bvs().u(r6)) {
                                    akVar.rkR.setVisibility(0);
                                    akVar.rxi.setVisibility(8);
                                    akVar.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this, com.tencent.mm.plugin.sns.i.i.dAI));
                                } else if (ae.bvs().v(r6)) {
                                    akVar.rkR.setVisibility(8);
                                    akVar.rxi.setVisibility(8);
                                } else if (!iI.kf() || ae.bvs().l(iI) > 5) {
                                    ae.bvs().y(r6);
                                    akVar.rkR.setVisibility(0);
                                    akVar.rxi.setVisibility(8);
                                    akVar.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this, com.tencent.mm.plugin.sns.i.i.dAI));
                                } else {
                                    akVar.rkR.setVisibility(8);
                                    akVar.rxi.setVisibility(8);
                                }
                                if (akVar.qvN.bsG()) {
                                    x.d("MicroMsg.SnsCommentDetailUI", "play video error " + r6.nGJ + " " + r6.nfX + " " + r6.wxE);
                                    ae.bvs().y(r6);
                                    akVar.rkR.setVisibility(0);
                                    akVar.rxi.setVisibility(8);
                                    akVar.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this, com.tencent.mm.plugin.sns.i.i.dAI));
                                }
                            } else if (ae.bvs().w(r6)) {
                                akVar.rkR.setVisibility(8);
                                akVar.rxi.setVisibility(0);
                                akVar.rxi.cyN();
                            } else if (iI.kf() && ae.bvs().l(iI) == 5) {
                                ae.bvs().A(r6);
                                akVar.rkR.setVisibility(8);
                                akVar.rxi.setVisibility(0);
                                akVar.rxi.cyN();
                            } else {
                                ae.bvs().y(r6);
                                akVar.rkR.setVisibility(0);
                                akVar.rxi.setVisibility(8);
                                akVar.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this, com.tencent.mm.plugin.sns.i.i.dAI));
                            }
                            aVar.bH(akVar);
                            ae.bvs().a(iI, r6, aVar, hashCode(), 0, an.xyX, iI.kf());
                            r13.setTag(akVar);
                            if (this.rzU != null) {
                                boolean z = iI.kf() ? ae.bvs().l(iI) == 5 : ae.bvs().k(iI) == 5;
                                this.rzU.o(iI.field_snsId, z);
                            }
                        }
                    } else if (this.kTK == 0) {
                        linearLayout = (LinearLayout) this.rzs.findViewById(f.qEL);
                        View xA = xA(com.tencent.mm.plugin.sns.i.g.qHz);
                        if (!this.rAk) {
                            linearLayout.removeView(this.rAn);
                            linearLayout.addView(xA, 3);
                            if (xA.getLayoutParams() != null) {
                                r4 = new LinearLayout.LayoutParams(xA.getLayoutParams());
                            } else {
                                r4 = new LinearLayout.LayoutParams(-1, -2);
                            }
                            r4.setMargins(r4.leftMargin, com.tencent.mm.bv.a.fromDPToPix(this, 12), r4.rightMargin, r4.bottomMargin);
                            xA.setLayoutParams(r4);
                        }
                        if (bxV.wQo.vYd.isEmpty()) {
                            xA.setVisibility(8);
                        } else {
                            r5 = (aqr) bxV.wQo.vYd.get(0);
                            r6 = (MMImageView) xA.findViewById(f.qCp);
                            ae.bvs().b(r5, r6, com.tencent.mm.plugin.sns.i.i.dvn, hashCode(), an.xyX);
                            this.rzK = (ImageView) xA.findViewById(f.state);
                            this.rzK.setOnTouchListener(this.rsO);
                            this.oLg = bxV.nGJ;
                            bAF();
                            r6.setTag(new r(bxV, this.rzH, getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false)));
                            r6.setOnClickListener(this.rzO.rMB);
                            CharSequence charSequence3 = r5.nfe;
                            if (!bh.ov(charSequence3)) {
                                ((TextView) xA.findViewById(f.qDj)).setText(charSequence3);
                            }
                            charSequence = r5.fon;
                            if (!bh.ov(charSequence)) {
                                ((TextView) xA.findViewById(f.qFN)).setText(new SpannableString(charSequence), BufferType.SPANNABLE);
                            }
                            xA.setTag(new r(bxV, this.rzH));
                            this.contextMenuHelper.a(xA, this.rzV.rPE, this.rzV.rPp);
                            xA.setOnClickListener(this.rzO.rFh);
                            com.tencent.mm.plugin.sns.data.i.b(r6, this);
                        }
                    } else if (this.kTK == 12) {
                        MaskImageView maskImageView;
                        int width = ((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 82);
                        View findViewById2 = this.rzs.findViewById(f.qFP);
                        layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
                        layoutParams2.topMargin = com.tencent.mm.bv.a.fromDPToPix(cmQ(), 10);
                        layoutParams2.bottomMargin = 0;
                        layoutParams2.width = width;
                        layoutParams2.height = width;
                        if (findViewById2.getParent() instanceof ViewGroup) {
                            ((ViewGroup) findViewById2.getParent()).setClipChildren(false);
                            ((ViewGroup) findViewById2.getParent()).setClipToPadding(false);
                        }
                        int[] iArr = new int[]{f.qFQ, f.qFR};
                        int i5 = f.qFS;
                        for (i = 0; i < 2; i++) {
                            maskImageView = (MaskImageView) findViewById2.findViewById(iArr[i]);
                            maskImageView.setVisibility(8);
                            maskImageView.setOnTouchListener(new 25(this));
                        }
                        View findViewById3 = findViewById2.findViewById(i5);
                        findViewById3.setBackground(null);
                        findViewById3.setVisibility(8);
                        ((ViewGroup) findViewById3).setClipChildren(false);
                        ak akVar2 = new ak();
                        akVar2.rxh = findViewById3;
                        akVar2.rxg = akVar2.rxh;
                        akVar2.qvN = (com.tencent.mm.plugin.sight.decode.a.a) akVar2.rxh.findViewById(f.image);
                        akVar2.rkR = (ImageView) akVar2.rxh.findViewById(f.cPl);
                        akVar2.rxi = (MMPinProgressBtn) akVar2.rxh.findViewById(f.progress);
                        akVar2.rxj = (TextView) akVar2.rxh.findViewById(f.qCa);
                        akVar2.rkU = (TextView) akVar2.rxh.findViewById(f.qCb);
                        akVar2.rxh.setTag(akVar2);
                        akVar2.rxh.setOnClickListener(null);
                        ((SightPlayImageView) akVar2.qvN).btb();
                        ((SightPlayImageView) akVar2.qvN).a(QImageView.a.zwh);
                        akVar2.qvN.dt(width, width);
                        findViewById2.setLayerType(2, null);
                        if (iI.bxV().wQo.vYd.size() >= 2) {
                            int i6;
                            if (iI.field_likeFlag == 1) {
                                i6 = 1;
                            } else {
                                i6 = 0;
                            }
                            int i7 = 0;
                            while (i7 < 2) {
                                r6 = (aqr) iI.bxV().wQo.vYd.get(i7);
                                maskImageView = (MaskImageView) findViewById2.findViewById(iArr[i7]);
                                ViewGroup.LayoutParams layoutParams3 = maskImageView.getLayoutParams();
                                r7 = new ap();
                                r7.fus = this.rzH;
                                r7.index = i7;
                                r7.rzb = false;
                                r7.rxk = true;
                                r7.position = 0;
                                maskImageView.setTag(r7);
                                ae.bvs().a(r6, maskImageView, hashCode(), an.ciS().Dp(bxV.pbl));
                                maskImageView.a(QImageView.a.zwh);
                                layoutParams3.width = width;
                                layoutParams3.height = width;
                                if (i6 == i7 && r6.ktN == 2) {
                                    maskImageView.setVisibility(0);
                                    maskImageView.setOnClickListener(new 26(this, i6, iI));
                                } else {
                                    maskImageView.setOnClickListener(null);
                                }
                                if (r6.ktN == 6 && i6 == i7) {
                                    boolean z2;
                                    if (i6 > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    long j = iI.field_snsId;
                                    this.rzZ = true;
                                    r4 = findViewById3.getLayoutParams();
                                    r4.width = width;
                                    r4.height = width;
                                    findViewById3.setVisibility(0);
                                    ae.bvs().a(iI, r6, akVar2.qvN, -1, hashCode(), 0, an.xyX, iI.kf(), true);
                                    akVar2.rxk = true;
                                    akVar2.rxl = i7;
                                    akVar2.rxf = bxV;
                                    akVar2.position = 0;
                                    akVar2.frH = this.rzH;
                                    akVar2.rxh.setOnClickListener(new 27(this, z2, iI));
                                    akVar2.qvN.a(new 28(this, j, z2));
                                    if (this.rzU.ej(((long) i7) + j)) {
                                        this.rzU.b(j, bh.Wq(), z2);
                                    } else {
                                        akVar2.qvN.a(new 29(this, j, z2, i7, akVar2));
                                    }
                                    akVar2.a(bxV, 0, this.rzH, iI.kf());
                                    akVar2.rkU.setVisibility(8);
                                    com.tencent.mm.plugin.sns.model.g bvs = ae.bvs();
                                    long nanoTime = System.nanoTime() - System.nanoTime();
                                    x.i("MicroMsg.SnsCommentDetailUI", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(r6)), Long.valueOf(nanoTime));
                                    if (com.tencent.mm.plugin.sns.model.g.t(r6)) {
                                        if (bvs.u(r6)) {
                                            akVar2.rkR.setVisibility(0);
                                            akVar2.rxi.setVisibility(8);
                                            akVar2.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this, com.tencent.mm.plugin.sns.i.i.dAI));
                                            akVar2.rkR.setContentDescription(getString(j.qJJ));
                                        } else if (bvs.v(r6)) {
                                            akVar2.rkR.setVisibility(8);
                                            akVar2.rxi.setVisibility(8);
                                        } else if (!iI.kf() || bvs.l(iI) > 5) {
                                            bvs.y(r6);
                                            akVar2.rkR.setVisibility(0);
                                            akVar2.rxi.setVisibility(8);
                                            akVar2.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this, com.tencent.mm.plugin.sns.i.i.dAI));
                                            akVar2.rkR.setContentDescription(getString(j.qJJ));
                                        } else {
                                            akVar2.rkR.setVisibility(8);
                                            akVar2.rxi.setVisibility(8);
                                        }
                                        if (akVar2.qvN.bsG()) {
                                            x.d("MicroMsg.SnsCommentDetailUI", "play video error " + r6.nGJ + " " + r6.nfX + " " + r6.wxE + " 0");
                                            bvs.y(r6);
                                            akVar2.rkR.setVisibility(0);
                                            akVar2.rxi.setVisibility(8);
                                            akVar2.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this, com.tencent.mm.plugin.sns.i.i.dAI));
                                            akVar2.rkR.setContentDescription(getString(j.qJJ));
                                        }
                                    } else if (bvs.w(r6)) {
                                        akVar2.rkR.setVisibility(8);
                                        akVar2.rxi.setVisibility(0);
                                        akVar2.rxi.cyN();
                                    } else if (iI.kf() && bvs.l(iI) == 5) {
                                        bvs.A(r6);
                                        akVar2.rkR.setVisibility(8);
                                        akVar2.rxi.setVisibility(0);
                                        akVar2.rxi.cyN();
                                    } else if (bvs.x(r6)) {
                                        akVar2.rxi.setVisibility(8);
                                        akVar2.rkR.setImageResource(com.tencent.mm.plugin.sns.i.e.bGf);
                                        akVar2.rkR.setVisibility(0);
                                    } else {
                                        bvs.y(r6);
                                        akVar2.rkR.setVisibility(0);
                                        akVar2.rxi.setVisibility(8);
                                        akVar2.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this, com.tencent.mm.plugin.sns.i.i.dAI));
                                        akVar2.rkR.setContentDescription(getString(j.qJJ));
                                        if (!iI.kf() && bvs.k(iI) == 4) {
                                            akVar2.rkU.setVisibility(0);
                                        } else if (iI.kf() && bvs.l(iI) == 4) {
                                            akVar2.rkU.setVisibility(0);
                                        }
                                    }
                                    boolean z3 = iI.kf() ? ae.bvs().l(iI) == 5 : ae.bvs().k(iI) == 5;
                                    this.rzU.a(j, z3, 1, z2);
                                }
                                i7++;
                            }
                            xB(i6);
                        }
                    } else {
                        Object obj3;
                        Object obj4;
                        Object obj5;
                        linearLayout = (LinearLayout) this.rzs.findViewById(f.qEL);
                        r13 = xA(com.tencent.mm.plugin.sns.i.g.qHy);
                        r6 = (MMImageView) r13.findViewById(f.qCp);
                        if (!this.rAk) {
                            linearLayout.removeView(this.rAn);
                            linearLayout.addView(r13, 3);
                            if (r13.getLayoutParams() != null) {
                                r4 = new LinearLayout.LayoutParams(r13.getLayoutParams());
                            } else {
                                r4 = new LinearLayout.LayoutParams(-1, -2);
                            }
                            r4.setMargins(r4.leftMargin, com.tencent.mm.bv.a.fromDPToPix(this, 12), r4.rightMargin, r4.bottomMargin);
                            r13.setLayoutParams(r4);
                        }
                        Object obj6 = null;
                        if (iI.kf()) {
                            if (iI.bxR().rfi == 2) {
                                obj6 = 1;
                                r13.setTag(iI);
                                r13.setTag(f.qCJ, r6);
                                r13.setOnClickListener(this.rzV.rPX);
                            }
                            obj3 = null;
                            obj4 = obj6;
                        } else {
                            if (bxV.wQo.vYc == 9) {
                                if (bxV.wQo.vYd.size() > 0) {
                                    r13.setTag(new r(bxV, this.rzH));
                                    r13.setOnClickListener(this.rzO.rMv);
                                    obj3 = null;
                                    obj4 = null;
                                }
                            } else if (bxV.wQo.vYc == 10) {
                                if (bxV.wQo.vYd.size() > 0) {
                                    r13.setTag(new r(bxV, this.rzH));
                                    r13.setOnClickListener(this.rzO.rMx);
                                    obj3 = null;
                                    obj4 = null;
                                }
                            } else if (bxV.wQo.vYc == 17) {
                                if (bxV.wQo.vYd.size() > 0) {
                                    r13.setTag(new r(bxV, this.rzH));
                                    r13.setOnClickListener(this.rzO.rMy);
                                    obj3 = null;
                                    obj4 = null;
                                }
                            } else if (bxV.wQo.vYc == 22) {
                                if (bxV.wQo.vYd.size() > 0) {
                                    r13.setTag(new r(bxV, this.rzH));
                                    r13.setOnClickListener(this.rzO.rMz);
                                    obj3 = null;
                                    obj4 = null;
                                }
                            } else if (bxV.wQo.vYc == 23) {
                                if (bxV.wQo.vYd.size() > 0) {
                                    r13.setTag(new r(bxV, this.rzH));
                                    r13.setOnClickListener(this.rzO.rMA);
                                    obj3 = null;
                                    obj4 = null;
                                }
                            } else if (bxV.wQo.vYc == 14) {
                                if (bxV.wQo.vYd.size() > 0) {
                                    r13.setTag(new r(bxV, this.rzH));
                                    r13.setOnClickListener(this.rzO.rMw);
                                    obj3 = null;
                                    obj4 = null;
                                }
                            } else if (bxV.wQo.vYc == 12) {
                                if (bxV.wQo.vYd.size() > 0) {
                                    r13.setTag(new r(bxV, this.rzH));
                                    r13.setOnClickListener(this.rzO.rME);
                                    obj3 = null;
                                    obj4 = null;
                                }
                            } else if (bxV.wQo.vYc == 13) {
                                if (bxV.wQo.vYd.size() > 0) {
                                    r13.setTag(new r(bxV, this.rzH));
                                    r13.setOnClickListener(this.rzO.rMF);
                                    obj3 = null;
                                    obj4 = null;
                                }
                            } else if (bxV.wQo.vYc == 15) {
                                if (bxV.wQo.vYd.size() > 0) {
                                    r13.setTag(new r(bxV, this.rzH));
                                    r13.setOnClickListener(this.rzV.rPN);
                                    obj3 = null;
                                    obj4 = null;
                                }
                            } else if (bxV.wQo.vYc == 26) {
                                r13.setTag(new r(bxV, this.rzH));
                                r13.setOnClickListener(this.rzO.rMG);
                                obj3 = null;
                                obj4 = null;
                            } else {
                                r13.setTag(new r(bxV, this.rzH));
                                r13.setOnClickListener(this.rzO.rFh);
                                if ((bxV.hbg & 1) > 0) {
                                    int i8 = 1;
                                    obj4 = null;
                                }
                            }
                            obj3 = null;
                            obj4 = null;
                        }
                        if (obj4 != null) {
                            this.contextMenuHelper.a(r13, this.rzV.rPH, this.rzV.rPp);
                        } else {
                            this.contextMenuHelper.a(r13, this.rzV.rPE, this.rzV.rPp);
                        }
                        String Mc = bAC() ? av.Mc(bxV.wQo.nfX) : "";
                        String str4 = bxV.wQo.fon;
                        if (obj4 != null) {
                            charSequence2 = bxV.wQo.nfe;
                        } else {
                            obj5 = Mc;
                        }
                        r13.findViewById(f.state).setVisibility(8);
                        if (!bxV.wQo.vYd.isEmpty()) {
                            r6.setVisibility(0);
                            r5 = (aqr) bxV.wQo.vYd.get(0);
                            if (bxV.wQo.vYc == 15) {
                                ((ImageView) r13.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.bDS);
                                ((ImageView) r13.findViewById(f.state)).setVisibility(0);
                                ae.bvs().b(r5, r6, com.tencent.mm.plugin.sns.i.i.dvA, hashCode(), an.ciO().Dp(bxV.pbl));
                                Mc = str4;
                            } else if (bxV.wQo.vYc == 5) {
                                str4 = av.Mc(r5.nfX);
                                str2 = r5.fon;
                                r13.findViewById(f.state).setVisibility(0);
                                ae.bvs().b(r5, r6, com.tencent.mm.plugin.sns.i.i.dvA, hashCode(), an.xyX);
                                Mc = str2;
                                obj5 = str4;
                            } else if (bxV.wQo.vYc == 18) {
                                r13.findViewById(f.state).setVisibility(0);
                                ((ImageView) r13.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.bHg);
                                r6.setVisibility(0);
                                ae.bvs().b(r5, r6, com.tencent.mm.plugin.sns.i.i.dvA, hashCode(), an.xyX);
                                Mc = str4;
                            } else {
                                ae.bvs().b(r5, r6, hashCode(), an.xyX);
                                Mc = str4;
                            }
                        } else if (bxV.wQo.vYc == 18) {
                            ((ImageView) r13.findViewById(f.state)).setVisibility(0);
                            ((ImageView) r13.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.bHg);
                            r6.setVisibility(0);
                            ae.bvs().a(r6, -1, com.tencent.mm.plugin.sns.i.i.dvA, hashCode());
                            Mc = str4;
                        } else if (bxV.wQo.vYc == 26) {
                            r6.setVisibility(0);
                            ae.bvs().a(r6, -1, com.tencent.mm.plugin.sns.i.i.qIP, hashCode());
                            Mc = str4;
                        } else {
                            r6.setVisibility(0);
                            ae.bvs().a(r6, -1, com.tencent.mm.plugin.sns.i.i.dvD, hashCode());
                            Mc = str4;
                        }
                        com.tencent.mm.plugin.sns.data.i.b(r6, this);
                        if (bxV.wQo.vYc == 15) {
                            charSequence2 = "";
                            charSequence = getString(j.qKN);
                        } else {
                            obj4 = Mc;
                        }
                        if (bh.ov(charSequence2)) {
                            r13.findViewById(f.qDj).setVisibility(8);
                        } else {
                            r13.findViewById(f.qDj).setVisibility(0);
                            ((TextView) r13.findViewById(f.qDj)).setText(charSequence2);
                        }
                        textView = (TextView) r13.findViewById(f.qFN);
                        if (bh.ov(charSequence)) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                            if (obj3 != null) {
                                textView.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence, cmQ(), textView));
                            } else {
                                textView.setText(charSequence);
                            }
                        }
                    }
                }
                textView = (TextView) this.rzs.findViewById(f.qAw);
                if (iI.kf()) {
                    charSequence = bxV.wQm != null ? null : bxV.wQm.hvv;
                    jVar = bxV.wQm != null ? null : bxV.wQm.nTe;
                    textView.setTag(iI.byq());
                    if (bh.ov(charSequence) || !bh.ov(jVar)) {
                        textView.setVisibility(0);
                        if (bh.ov(jVar)) {
                            textView.setTextColor(-11048043);
                            textView.setClickable(true);
                            if (iI.field_snsId == 0 || bh.ov(charSequence)) {
                                textView.setText(jVar);
                            } else {
                                textView.setText(charSequence + "·" + jVar);
                            }
                        } else {
                            textView.setText(charSequence);
                            textView.setClickable(false);
                            textView.setTextColor(-9211021);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    bxT = iI.bxT();
                    if (bxT != null) {
                        jVar = bxT.rdT;
                        az = bxT.rdU;
                        textView.setTag(iI.byq());
                        if (!bh.ov(jVar)) {
                            if (bh.ov(az)) {
                                textView.setVisibility(0);
                                if (!bh.ov(jVar)) {
                                    textView.setTextColor(-11048043);
                                    textView.setClickable(true);
                                    textView.setText(jVar);
                                }
                            } else {
                                textView.setVisibility(0);
                            }
                            textView.setText(jVar);
                            textView.setClickable(false);
                            textView.setTextColor(-9211021);
                        }
                    }
                    textView.setVisibility(8);
                }
                textView.setOnClickListener(this.rzV.rPL);
                ((TextView) this.rzs.findViewById(f.qBl)).setText(az.l(cmQ(), ((long) iI.byj()) * 1000));
                asyncTextView = (AsyncTextView) this.rzs.findViewById(f.qAv);
                asyncTextView.setOnClickListener(this.rzV.rPP);
                asyncTextView.setVisibility(8);
                asyncTextView2 = (AsyncTextView) this.rzs.findViewById(f.qAu);
                asyncTextView2.setOnClickListener(new 30(this, iI, WO));
                asyncTextView2.setVisibility(8);
                if (iI.kf()) {
                    bxT2 = iI.bxT();
                    asyncTextView.setTag(iI.byq());
                    if (bxT2.rdV != com.tencent.mm.plugin.sns.storage.a.rdH) {
                        if (bh.ov(bxT2.rdW)) {
                            asyncTextView.setText(bxT2.rdW);
                            asyncTextView.setVisibility(0);
                        } else {
                            asyncTextView.setVisibility(8);
                        }
                    } else if (bxT2.rdV == com.tencent.mm.plugin.sns.storage.a.rdI) {
                        if (!bh.ov(bxT2.rdW)) {
                            byq = "";
                            it = bxT2.rdY.iterator();
                            while (it.hasNext()) {
                                str3 = (String) it.next();
                                WN = this.rzI.WN(str3);
                                if (WN == null) {
                                    str2 = WN.AQ();
                                    if (bh.ov(str2)) {
                                        byq = byq + str2;
                                    } else {
                                        byq = byq + str3;
                                    }
                                } else {
                                    byq = byq + str3;
                                }
                                if (bxT2.rdY.getLast() != str3) {
                                    byq = byq + ",";
                                }
                            }
                            jVar = String.format(bxT2.rdW, new Object[]{byq});
                            asyncTextView.getTextSize();
                            jVar2 = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d((Context) this, jVar, 1));
                            jVar2.f(null, jVar);
                            paint = asyncTextView.getPaint();
                            if (com.tencent.mm.bv.a.ad(this, (int) Layout.getDesiredWidth(jVar2, 0, jVar2.length(), paint)) > this.rzT) {
                                while (byq.length() > 1) {
                                    byq = byq.substring(0, byq.length() - 2);
                                    jVar2 = String.format(bxT2.rdW, new Object[]{byq + "..."});
                                    asyncTextView.getTextSize();
                                    charSequence2 = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d((Context) this, jVar2, 1));
                                    charSequence2.f(null, jVar2);
                                    i4 = com.tencent.mm.bv.a.ad(this, (int) Layout.getDesiredWidth(charSequence2, 0, charSequence2.length(), paint));
                                    asyncTextView.setText(charSequence2, BufferType.SPANNABLE);
                                    asyncTextView.setVisibility(0);
                                    if (i4 <= this.rzT) {
                                        break;
                                    }
                                }
                            }
                            asyncTextView.setText(jVar2, BufferType.SPANNABLE);
                            asyncTextView.setVisibility(0);
                        } else {
                            asyncTextView.setVisibility(8);
                        }
                    }
                    if (asyncTextView.getVisibility() != 8 && bh.ov(bxT2.rdX)) {
                        asyncTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyG));
                        asyncTextView.setOnClickListener(null);
                    }
                    if (iI.bxV().wQo.vYe != 4) {
                        asyncTextView2.setTag(iI.byq());
                        asyncTextView2.setVisibility(0);
                        asyncTextView2.setText(String.format("%s%s%s", new Object[]{cmQ().getResources().getString(j.qJY), str, cmQ().getResources().getString(j.qJZ)}));
                    } else {
                        asyncTextView2.setVisibility(8);
                    }
                }
                textView = (TextView) this.rzs.findViewById(f.qAO);
                textView.setOnTouchListener(new ab());
                az = com.tencent.mm.plugin.sns.c.a.ift.l(this, bxV.wQn.nGJ);
                if (bxV.wQo.vYc == 26) {
                    az = getString(j.eeE);
                }
                av.a(bxV, this);
                if (com.tencent.mm.plugin.sns.c.a.ift.cz(az)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    jVar = new SpannableString(getString(j.qKp) + az);
                    jVar.setSpan(new a(this), 0, jVar.length(), 33);
                    textView.setText(jVar, BufferType.SPANNABLE);
                    if (bxV.wQn == null || !com.tencent.mm.pluginsdk.model.app.g.RB(bxV.wQn.nGJ)) {
                        textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyG));
                        textView.setOnTouchListener(null);
                    }
                    textView.setTag(bxV);
                }
                textView = (TextView) this.rzs.findViewById(f.qAN);
                if (iI.getUserName().equals(this.gze)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setTag(iI.byq() + ";" + iI.bxW());
                    textView.setOnClickListener(new 31(this));
                }
                textView = (TextView) this.rzs.findViewById(f.qGk);
                m = ai.m(iI);
                if (m != null) {
                    textView.setVisibility(8);
                } else {
                    if (m.wNg.size() > 0) {
                        if (this.gze.equals(m.vIy)) {
                            textView.setVisibility(8);
                            it2 = m.wNg.iterator();
                            while (it2.hasNext()) {
                                if (this.gze.equals(((bjk) it2.next()).vIy)) {
                                    textView.setVisibility(0);
                                    charSequence = getString(j.qMy);
                                    textView.setVisibility(0);
                                    textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, charSequence, textView.getTextSize()));
                                    break;
                                }
                            }
                        }
                        textView.setVisibility(0);
                        it = m.wNg.iterator();
                        byq = "";
                        obj = null;
                        while (it.hasNext()) {
                            com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                            if (obj != null) {
                                str3 = byq + "  ";
                                obj2 = 1;
                            } else {
                                Object obj7 = obj;
                                str3 = byq + ",  ";
                                obj2 = obj7;
                            }
                            if (com_tencent_mm_protocal_c_bjk.wvW == null) {
                                append = new StringBuilder().append(str3);
                                az = com_tencent_mm_protocal_c_bjk.wvW;
                            } else {
                                WN = this.rzI.WO(com_tencent_mm_protocal_c_bjk.vIy);
                                append = new StringBuilder().append(str3);
                                az = WN != null ? com_tencent_mm_protocal_c_bjk.vIy : WN.AQ();
                            }
                            obj = obj2;
                            byq = append.append(az).toString();
                        }
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, getString(j.qMx, new Object[]{byq}), textView.getTextSize()));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (m != null || this.gze == null || !this.gze.equals(m.vIy) || ((m.wzw != 3 || m.wNl == null) && (m.wzw != 5 || m.wym == null))) {
                        this.rzs.findViewById(f.qAP).setVisibility(8);
                    } else {
                        this.rzs.findViewById(f.qAP).setVisibility(0);
                        this.rzs.findViewById(f.qAP).setTag(Integer.valueOf(iI.roJ));
                        this.rzs.findViewById(f.qAP).setOnClickListener(new 32(this));
                    }
                }
                this.rzz = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.rzz.setDuration(150);
                this.rzA = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.rzA.setDuration(150);
                if (this.rzx == null) {
                    this.rzx = this.rzs.findViewById(f.qAz);
                    this.rzx.setVisibility(8);
                }
                this.rzB = (LinearLayout) this.rzs.findViewById(f.qAE);
                this.rzB.setOnClickListener(new 33(this, iI));
                this.rzB.setOnTouchListener(this.rsO);
                this.rzC = (LinearLayout) this.rzs.findViewById(f.qBd);
                this.rzC.setOnClickListener(new 35(this, iI, bxV));
                this.rzC.setOnTouchListener(this.rsO);
                imageButton = (ImageButton) this.rzs.findViewById(f.qBm);
                iI2 = iI(true);
                if (!(iI2 == null || (iI2.byl() & 1) == 0)) {
                    imageButton.setVisibility(8);
                }
                if (!(iI2 == null || iI2.byp())) {
                    imageButton.setVisibility(8);
                }
                imageView2 = (ImageView) this.rzC.findViewById(f.qBc);
                imageView3 = (ImageView) this.rzB.findViewById(f.qAD);
                textView2 = (TextView) this.rzC.findViewById(f.qBe);
                textView3 = (TextView) this.rzB.findViewById(f.qAL);
                if (this.kTK == 11) {
                    this.rzs.findViewById(f.qAz).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qzc);
                    imageButton.setImageResource(com.tencent.mm.plugin.sns.i.e.qzk);
                    imageView2.setImageResource(com.tencent.mm.plugin.sns.i.e.qzl);
                    imageView3.setImageResource(com.tencent.mm.plugin.sns.i.e.qzm);
                    textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyz));
                    textView3.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyz));
                    this.rzC.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qzn);
                    this.rzB.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qzo);
                }
                imageButton.setOnClickListener(new 36(this, iI, textView2, textView3, imageView2, imageView3));
                return true;
            }
        }
        str = az;
        str.length();
        if (this.kTK != 11) {
        }
        jVar = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, (CharSequence) str));
        jVar.f(new n(new com.tencent.mm.plugin.sns.data.a(iI.kf(), WO.getUsername(), iI.byq(), 2), this.rzL, i), str);
        textView.setOnTouchListener(new ab());
        textView.setText(jVar, BufferType.SPANNABLE);
        ((TextView) this.rzs.findViewById(f.qGa)).setText("");
        this.rAq = new bf(this.rzs);
        if (iI.kf()) {
            this.rAq.setVisibility(8);
        } else {
            this.rAq.q(Long.valueOf(iI.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.rAq, 0, this.rzH, iI.field_snsId, iI.byz()));
            this.rAq.a(iI.bxR(), iI.bxT());
            this.rAq.a(this.rzV.rPz, this.rzV.rPO);
            this.rAq.setVisibility(0);
        }
        str2 = bxV.wQl;
        this.rzt = (TextView) this.rzs.findViewById(f.caS);
        this.rzt.setTag(new as(this.fzW, iI.byq(), true, false, 2));
        this.contextMenuHelper.a(this.rzt, this.rzV.rPs, this.rzV.rPp);
        findViewById = this.rzs.findViewById(f.qBy);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        findViewById = this.rzs.findViewById(f.qBB);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (iI.kf()) {
        }
        az = str2;
        if (az != null) {
        }
        this.rzt.setVisibility(8);
        av.e(bxV);
        viewStub = (ViewStub) this.rzs.findViewById(f.qCq);
        if (this.rAm) {
            if (this.kTK == 2) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qIb);
            } else if (this.kTK == 3) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qHY);
            } else if (this.kTK == 4) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qHZ);
            } else if (this.kTK == 5) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qIa);
            } else if (this.kTK != 6) {
                if (this.kTK != 1) {
                }
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qHA);
            }
            if (this.kTK != 2) {
            }
            this.rAn = (PhotosContent) viewStub.inflate();
            this.rAm = true;
        }
        if (this.kTK != 6) {
            if (this.kTK != 2) {
            }
            if (this.rAn == null) {
                x.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.kTK + ",stub is " + viewStub.toString());
            } else {
                this.rAn.bzX();
                for (i = 0; i < ar.rDQ[this.kTK]; i++) {
                    tagImageView = (TagImageView) this.rAn.findViewById(ar.rDU[i]);
                    this.rAn.a(tagImageView);
                    tagImageView.setOnClickListener(this.rzV.rtw);
                    this.contextMenuHelper.a(tagImageView, this.rzV.rPD, this.rzV.rPp);
                }
                this.rAn.xx(this.rzQ);
                linkedList = new LinkedList();
                bxR = iI.bxR();
                if (bxR == null) {
                }
                a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR.reY, 1, bxR.rfa, bxR.rfb);
                a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR.reZ, 1, bxR.rfa, bxR.rfb);
                if (bxR.reX == 0) {
                    i2 = ((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth();
                    if (a < ((float) (((i2 - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)))) {
                        fromDPToPix = a;
                        a = a2;
                    } else {
                        fromDPToPix = (float) (((i2 - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12));
                        a = (float) ((int) ((bxR.reZ * fromDPToPix) / bxR.reY));
                    }
                    com_tencent_mm_protocal_c_aqt = new aqt();
                    com_tencent_mm_protocal_c_aqt.wyu = fromDPToPix;
                    com_tencent_mm_protocal_c_aqt.wyv = a;
                    com_tencent_mm_protocal_c_aqt.wyw = com_tencent_mm_protocal_c_aqt.wyu * com_tencent_mm_protocal_c_aqt.wyv;
                    linkedList.add(com_tencent_mm_protocal_c_aqt);
                } else if (bxR.reX == 1) {
                    i2 = (((((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12);
                    i3 = (int) ((((float) i2) * bxR.reZ) / bxR.reY);
                    com_tencent_mm_protocal_c_aqt2 = new aqt();
                    if (i2 > 0) {
                        a = (float) i2;
                    }
                    com_tencent_mm_protocal_c_aqt2.wyu = a;
                    if (i3 > 0) {
                        a2 = (float) i3;
                    }
                    com_tencent_mm_protocal_c_aqt2.wyv = a2;
                    com_tencent_mm_protocal_c_aqt2.wyw = com_tencent_mm_protocal_c_aqt2.wyu * com_tencent_mm_protocal_c_aqt2.wyv;
                    linkedList.add(com_tencent_mm_protocal_c_aqt2);
                } else if (bxR.reX == 2) {
                    i2 = ((((WindowManager) cmQ().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 50)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12)) - com.tencent.mm.bv.a.fromDPToPix(cmQ(), 12);
                    i3 = (int) ((((float) i2) * bxR.reZ) / bxR.reY);
                    com_tencent_mm_protocal_c_aqt2 = new aqt();
                    if (i2 > 0) {
                        a = (float) i2;
                    }
                    com_tencent_mm_protocal_c_aqt2.wyu = a;
                    if (i3 > 0) {
                        a2 = (float) i3;
                    }
                    com_tencent_mm_protocal_c_aqt2.wyv = a2;
                    com_tencent_mm_protocal_c_aqt2.wyw = com_tencent_mm_protocal_c_aqt2.wyu * com_tencent_mm_protocal_c_aqt2.wyv;
                    linkedList.add(com_tencent_mm_protocal_c_aqt2);
                }
                if (bh.ov(bxR.rfd)) {
                    d.a("adId", bxR.rfd, false, 41, 0, new 20(this, this.rAn, bxR, this.rAn.xy(0)));
                }
                this.rzs.addOnAttachStateChangeListener(new 21(this, bxV, iI, linkedList));
                arVar = this.rzG;
                photosContent = this.rAn;
                byq = iI.byq();
                hashCode = hashCode();
                i4 = this.kTK;
                iI.xl(32);
                arVar.a(photosContent, bxV, byq, hashCode, i4, -1, false, an.xyX, linkedList);
            }
        }
        textView = (TextView) this.rzs.findViewById(f.qAw);
        if (iI.kf()) {
            if (bxV.wQm != null) {
            }
            if (bxV.wQm != null) {
            }
            textView.setTag(iI.byq());
            if (bh.ov(charSequence)) {
            }
            textView.setVisibility(0);
            if (bh.ov(jVar)) {
                textView.setText(charSequence);
                textView.setClickable(false);
                textView.setTextColor(-9211021);
            } else {
                textView.setTextColor(-11048043);
                textView.setClickable(true);
                if (iI.field_snsId == 0) {
                }
                textView.setText(jVar);
            }
        } else {
            bxT = iI.bxT();
            if (bxT != null) {
                jVar = bxT.rdT;
                az = bxT.rdU;
                textView.setTag(iI.byq());
                if (bh.ov(jVar)) {
                    if (bh.ov(az)) {
                        textView.setVisibility(0);
                        if (bh.ov(jVar)) {
                            textView.setTextColor(-11048043);
                            textView.setClickable(true);
                            textView.setText(jVar);
                        }
                    } else {
                        textView.setVisibility(0);
                    }
                    textView.setText(jVar);
                    textView.setClickable(false);
                    textView.setTextColor(-9211021);
                }
            }
            textView.setVisibility(8);
        }
        textView.setOnClickListener(this.rzV.rPL);
        ((TextView) this.rzs.findViewById(f.qBl)).setText(az.l(cmQ(), ((long) iI.byj()) * 1000));
        asyncTextView = (AsyncTextView) this.rzs.findViewById(f.qAv);
        asyncTextView.setOnClickListener(this.rzV.rPP);
        asyncTextView.setVisibility(8);
        asyncTextView2 = (AsyncTextView) this.rzs.findViewById(f.qAu);
        asyncTextView2.setOnClickListener(new 30(this, iI, WO));
        asyncTextView2.setVisibility(8);
        if (iI.kf()) {
            bxT2 = iI.bxT();
            asyncTextView.setTag(iI.byq());
            if (bxT2.rdV != com.tencent.mm.plugin.sns.storage.a.rdH) {
                if (bxT2.rdV == com.tencent.mm.plugin.sns.storage.a.rdI) {
                    if (!bh.ov(bxT2.rdW)) {
                        byq = "";
                        it = bxT2.rdY.iterator();
                        while (it.hasNext()) {
                            str3 = (String) it.next();
                            WN = this.rzI.WN(str3);
                            if (WN == null) {
                                byq = byq + str3;
                            } else {
                                str2 = WN.AQ();
                                if (bh.ov(str2)) {
                                    byq = byq + str3;
                                } else {
                                    byq = byq + str2;
                                }
                            }
                            if (bxT2.rdY.getLast() != str3) {
                                byq = byq + ",";
                            }
                        }
                        jVar = String.format(bxT2.rdW, new Object[]{byq});
                        asyncTextView.getTextSize();
                        jVar2 = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d((Context) this, jVar, 1));
                        jVar2.f(null, jVar);
                        paint = asyncTextView.getPaint();
                        if (com.tencent.mm.bv.a.ad(this, (int) Layout.getDesiredWidth(jVar2, 0, jVar2.length(), paint)) > this.rzT) {
                            while (byq.length() > 1) {
                                byq = byq.substring(0, byq.length() - 2);
                                jVar2 = String.format(bxT2.rdW, new Object[]{byq + "..."});
                                asyncTextView.getTextSize();
                                charSequence2 = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d((Context) this, jVar2, 1));
                                charSequence2.f(null, jVar2);
                                i4 = com.tencent.mm.bv.a.ad(this, (int) Layout.getDesiredWidth(charSequence2, 0, charSequence2.length(), paint));
                                asyncTextView.setText(charSequence2, BufferType.SPANNABLE);
                                asyncTextView.setVisibility(0);
                                if (i4 <= this.rzT) {
                                    break;
                                }
                            }
                        }
                        asyncTextView.setText(jVar2, BufferType.SPANNABLE);
                        asyncTextView.setVisibility(0);
                    } else {
                        asyncTextView.setVisibility(8);
                    }
                }
            } else if (bh.ov(bxT2.rdW)) {
                asyncTextView.setVisibility(8);
            } else {
                asyncTextView.setText(bxT2.rdW);
                asyncTextView.setVisibility(0);
            }
            asyncTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyG));
            asyncTextView.setOnClickListener(null);
            if (iI.bxV().wQo.vYe != 4) {
                asyncTextView2.setVisibility(8);
            } else {
                asyncTextView2.setTag(iI.byq());
                asyncTextView2.setVisibility(0);
                asyncTextView2.setText(String.format("%s%s%s", new Object[]{cmQ().getResources().getString(j.qJY), str, cmQ().getResources().getString(j.qJZ)}));
            }
        }
        textView = (TextView) this.rzs.findViewById(f.qAO);
        textView.setOnTouchListener(new ab());
        az = com.tencent.mm.plugin.sns.c.a.ift.l(this, bxV.wQn.nGJ);
        if (bxV.wQo.vYc == 26) {
            az = getString(j.eeE);
        }
        av.a(bxV, this);
        if (com.tencent.mm.plugin.sns.c.a.ift.cz(az)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            jVar = new SpannableString(getString(j.qKp) + az);
            jVar.setSpan(new a(this), 0, jVar.length(), 33);
            textView.setText(jVar, BufferType.SPANNABLE);
            textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyG));
            textView.setOnTouchListener(null);
            textView.setTag(bxV);
        }
        textView = (TextView) this.rzs.findViewById(f.qAN);
        if (iI.getUserName().equals(this.gze)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setTag(iI.byq() + ";" + iI.bxW());
            textView.setOnClickListener(new 31(this));
        }
        textView = (TextView) this.rzs.findViewById(f.qGk);
        m = ai.m(iI);
        if (m != null) {
            if (m.wNg.size() > 0) {
                textView.setVisibility(8);
            } else if (this.gze.equals(m.vIy)) {
                textView.setVisibility(8);
                it2 = m.wNg.iterator();
                while (it2.hasNext()) {
                    if (this.gze.equals(((bjk) it2.next()).vIy)) {
                        textView.setVisibility(0);
                        charSequence = getString(j.qMy);
                        textView.setVisibility(0);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, charSequence, textView.getTextSize()));
                        break;
                    }
                }
            } else {
                textView.setVisibility(0);
                it = m.wNg.iterator();
                byq = "";
                obj = null;
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                    if (obj != null) {
                        Object obj72 = obj;
                        str3 = byq + ",  ";
                        obj2 = obj72;
                    } else {
                        str3 = byq + "  ";
                        obj2 = 1;
                    }
                    if (com_tencent_mm_protocal_c_bjk.wvW == null) {
                        WN = this.rzI.WO(com_tencent_mm_protocal_c_bjk.vIy);
                        append = new StringBuilder().append(str3);
                        if (WN != null) {
                        }
                    } else {
                        append = new StringBuilder().append(str3);
                        az = com_tencent_mm_protocal_c_bjk.wvW;
                    }
                    obj = obj2;
                    byq = append.append(az).toString();
                }
                textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, getString(j.qMx, new Object[]{byq}), textView.getTextSize()));
            }
            if (m != null) {
            }
            this.rzs.findViewById(f.qAP).setVisibility(8);
        } else {
            textView.setVisibility(8);
        }
        this.rzz = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rzz.setDuration(150);
        this.rzA = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rzA.setDuration(150);
        if (this.rzx == null) {
            this.rzx = this.rzs.findViewById(f.qAz);
            this.rzx.setVisibility(8);
        }
        this.rzB = (LinearLayout) this.rzs.findViewById(f.qAE);
        this.rzB.setOnClickListener(new 33(this, iI));
        this.rzB.setOnTouchListener(this.rsO);
        this.rzC = (LinearLayout) this.rzs.findViewById(f.qBd);
        this.rzC.setOnClickListener(new 35(this, iI, bxV));
        this.rzC.setOnTouchListener(this.rsO);
        imageButton = (ImageButton) this.rzs.findViewById(f.qBm);
        iI2 = iI(true);
        imageButton.setVisibility(8);
        imageButton.setVisibility(8);
        imageView2 = (ImageView) this.rzC.findViewById(f.qBc);
        imageView3 = (ImageView) this.rzB.findViewById(f.qAD);
        textView2 = (TextView) this.rzC.findViewById(f.qBe);
        textView3 = (TextView) this.rzB.findViewById(f.qAL);
        if (this.kTK == 11) {
            this.rzs.findViewById(f.qAz).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qzc);
            imageButton.setImageResource(com.tencent.mm.plugin.sns.i.e.qzk);
            imageView2.setImageResource(com.tencent.mm.plugin.sns.i.e.qzl);
            imageView3.setImageResource(com.tencent.mm.plugin.sns.i.e.qzm);
            textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyz));
            textView3.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qyz));
            this.rzC.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qzn);
            this.rzB.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qzo);
        }
        imageButton.setOnClickListener(new 36(this, iI, textView2, textView3, imageView2, imageView3));
        return true;
    }

    private void bAE() {
        if (this.rzx != null && this.rzx.getVisibility() != 8) {
            this.rzx.startAnimation(this.rzA);
            this.rzA.setAnimationListener(new 37(this));
        }
    }

    private void bzf() {
        if (this.mController.xJg == 1 || this.rrw.bAN()) {
            this.rAf.run();
        } else {
            this.rru = true;
        }
    }

    private void bAF() {
        if (this.rzK != null) {
            this.rzK.setPressed(false);
            if (bg.IF(this.oLg)) {
                this.rzK.setImageResource(com.tencent.mm.plugin.sns.i.e.bDR);
            } else {
                this.rzK.setImageResource(com.tencent.mm.plugin.sns.i.e.bDS);
            }
        }
    }

    private View a(aqr com_tencent_mm_protocal_c_aqr, int i, boolean z) {
        int[] iArr = new int[]{f.qFQ, f.qFR};
        int i2 = f.qFS;
        if (z) {
            return this.rzs.findViewById(iArr[i]);
        }
        if (com_tencent_mm_protocal_c_aqr.ktN == 6) {
            return this.rzs.findViewById(i2);
        }
        if (com_tencent_mm_protocal_c_aqr.ktN == 2) {
            return this.rzs.findViewById(iArr[i]);
        }
        return null;
    }

    private void xB(int i) {
        View findViewById = this.rzs.findViewById(f.qFJ);
        View findViewById2 = this.rzs.findViewById(f.qFI);
        if (findViewById != null && findViewById2 != null) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            ((TextView) this.rzs.findViewById(f.qFV)).setText(null);
            ((TextView) this.rzs.findViewById(f.qFW)).setText(null);
            ((TextView) this.rzs.findViewById(f.qFT)).setText(null);
            ((TextView) this.rzs.findViewById(f.qFU)).setText(null);
            r1 = new int[3][];
            r1[0] = new int[]{f.qFW, f.qFU};
            r1[1] = new int[]{f.qFV, f.qFT};
            r1[2] = new int[]{f.qFV, f.qFU};
            com.tencent.mm.plugin.sns.storage.b bxR = com.tencent.mm.plugin.sns.storage.h.Ll(this.fzW).bxR();
            if (bxR.rfl != null && bxR.rfl.rfr != null && bxR.rfl.rfr.size() >= 2) {
                b$e com_tencent_mm_plugin_sns_storage_b_e = (b$e) bxR.rfl.rfr.get(i);
                if (com_tencent_mm_plugin_sns_storage_b_e.rfx >= 0 && com_tencent_mm_plugin_sns_storage_b_e.rfx < 3) {
                    int[] iArr = r1[com_tencent_mm_plugin_sns_storage_b_e.rfx];
                    TextView textView = (TextView) this.rzs.findViewById(iArr[0]);
                    TextView textView2 = (TextView) this.rzs.findViewById(iArr[1]);
                    if (bh.ov(com_tencent_mm_plugin_sns_storage_b_e.title)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        textView.setText(com_tencent_mm_plugin_sns_storage_b_e.title);
                    }
                    if (bh.ov(com_tencent_mm_plugin_sns_storage_b_e.desc)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setVisibility(0);
                        textView2.setText(com_tencent_mm_plugin_sns_storage_b_e.desc);
                    }
                    ((View) textView.getParent()).setVisibility(0);
                    ((View) textView2.getParent()).setVisibility(0);
                }
            }
        }
    }

    private boolean g(List<bjk> list, boolean z) {
        int b = BackwardSupportUtil.b.b((Context) this, 32.0f);
        int b2 = BackwardSupportUtil.b.b((Context) this, 6.0f);
        int b3 = BackwardSupportUtil.b.b((Context) this, 10.0f);
        int b4 = BackwardSupportUtil.b.b((Context) this, 17.0f);
        if (this.rzu == null) {
            return false;
        }
        int i;
        x.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", Integer.valueOf(((WindowManager) this.mController.xIM.getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ)));
        float f = ((float) i) - (f * 2.0f);
        if (list.size() <= 0) {
            if (this.rzu.getParent() != null) {
                this.rzu.setVisibility(8);
            }
            this.rzu.removeAllViews();
            this.rzu.setVisibility(8);
            this.qSj.setVisibility(8);
            return false;
        }
        this.rzu.getParent();
        this.rzu.removeAllViews();
        this.rzu.setVisibility(0);
        if (this.kTK != 11) {
            this.rzu.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qyY);
        } else if (this.rzX) {
            m iI = iI(false);
            if (iI == null) {
                this.rzu.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qza);
            } else if (this.gze.equals(iI.field_userName)) {
                this.rzu.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qzb);
            } else {
                this.rzu.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qza);
            }
        } else {
            this.rzu.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qza);
        }
        this.rzu.setPadding(0, b2, 0, b2);
        View imageView = new ImageView(this.mController.xIM);
        if (this.kTK == 11) {
            imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.qIL);
        } else {
            imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.qIK);
        }
        imageView.setPadding(b3, b4, b3, 0);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(false);
        imageView.setFocusable(false);
        this.rzu.addView(imageView);
        b3 = com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, rzS);
        i = ((int) (f - ((float) b3))) / (b2 + b);
        if (((int) (f - ((float) b3))) % (b2 + b) > b) {
            i++;
        }
        x.d("MicroMsg.SnsCommentDetailUI", "guess size %d", Integer.valueOf(i));
        View iVar = new i(this.mController.xIM);
        iVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        iVar.rrq = i;
        for (b3 = 0; b3 < list.size(); b3++) {
            bjk com_tencent_mm_protocal_c_bjk = (bjk) list.get(b3);
            View touchImageView = new TouchImageView(this.mController.xIM);
            touchImageView.setScaleType(ScaleType.FIT_XY);
            touchImageView.setImageResource(com.tencent.mm.plugin.sns.i.e.qze);
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b, b);
            layoutParams2.setMargins(0, b2, b2, 0);
            touchImageView.setLayoutParams(layoutParams2);
            touchImageView.setTag(com_tencent_mm_protocal_c_bjk.vIy);
            com.tencent.mm.pluginsdk.ui.a.b.b(touchImageView, com_tencent_mm_protocal_c_bjk.vIy, true);
            touchImageView.setOnClickListener(this.rAg);
            iVar.addView(touchImageView);
        }
        this.rzu.addView(iVar);
        this.qSj.setVisibility(z ? 8 : 0);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m Ll = com.tencent.mm.plugin.sns.storage.h.Ll(this.fzW);
        bjv m = ai.m(Ll);
        g(m.wNa, m.wNd.isEmpty());
        if (this.rzv != null) {
            this.rzv.a(Ll, this.rzV);
        }
        if (this.rAn != null) {
            this.rzQ = ae.bvD();
            this.rAn.xx(this.rzQ);
        }
    }

    public final void JT(String str) {
    }

    public final void aE(String str, boolean z) {
    }

    public final void bun() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:" + i);
        if (i == 15) {
            if (this.rzV != null && this.rzV.rPp != null) {
                this.rzV.rPp.onActivityResult(i, i2, intent);
            }
        } else if (i == 16) {
            x.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
            com.tencent.mm.sdk.b.b gjVar = new gj();
            gjVar.fww.scene = 1;
            com.tencent.mm.sdk.b.a.xef.m(gjVar);
        } else if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 218 && this.rrH != null) {
            this.rrH.dismiss();
        }
        if (i == 0 && i2 == 0) {
            m Ll = com.tencent.mm.plugin.sns.storage.h.Ll(this.fzW);
            if (Ll == null) {
                x.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.fzW);
                finish();
                return;
            }
            x.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.fzW + "  username:" + Ll.field_userName);
            if (this.rzs == null) {
                x.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
                finish();
                return;
            }
            bAD();
            bjv m = ai.m(Ll);
            x.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + m.wNa.size() + " " + m.wNd.size());
            if (m != null) {
                if (!f(this.rzD, m.wNa)) {
                    g(m.wNa, m.wNd.isEmpty());
                    this.rzD = m.wNa;
                }
                if (this.rzv != null) {
                    this.rzv.a(Ll, this.rzV);
                }
                b bVar = this.rzy;
                LinkedList linkedList = m.wNd;
                LinkedList linkedList2 = m.wNa;
                bVar.rAV = linkedList;
                bVar.rAW = linkedList2;
                this.rzy.notifyDataSetChanged();
            }
        }
    }

    public final void aF(String str, boolean z) {
    }

    public final void onKeyboardStateChanged() {
        if (this.mController.xJg == 2) {
            x.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
            this.rzF = false;
            if (this.rrw.oky) {
                this.rrw.oky = false;
            } else if (this.rrw.bAJ()) {
                this.rrw.bAP();
                this.rrw.LW(getString(j.qMD));
            }
            if (this.rzZ) {
                bAD();
            }
        } else if (this.mController.xJg == 1) {
            bAE();
            this.rru = false;
            this.rAf.run();
        }
    }
}
