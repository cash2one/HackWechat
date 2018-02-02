package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.aj;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.k.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.11;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.13;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.3;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.4;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.5;
import com.tencent.mm.plugin.wenote.model.nativenote.c.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.c;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.1;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.12;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.2;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.6;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.7;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.8;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.9;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class NoteEditorUI extends BaseFavDetailReportUI implements e, a, g.a, a {
    private static final long mtK = ((long) b.zG());
    private View Iv = null;
    OnGlobalLayoutListener OE = new OnGlobalLayoutListener(this) {
        final /* synthetic */ NoteEditorUI tXd;

        {
            this.tXd = r1;
        }

        public final void onGlobalLayout() {
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - this.tXd.tWQ)});
            ag Dm = ar.Dm();
            Runnable 1 = new 1(this);
            if (this.tXd.tUp == 1) {
                currentTimeMillis = 100;
            } else {
                currentTimeMillis = 0;
            }
            Dm.g(1, currentTimeMillis);
            this.tXd.Va.getViewTreeObserver().removeGlobalOnLayoutListener(this.tXd.OE);
        }
    };
    private RecyclerView Va;
    private long fqm = -1;
    private af hae;
    private long hzP = -1;
    private float iQM = 0.0f;
    private float iQN = 0.0f;
    private ProgressDialog iln = null;
    private String lLW = "";
    private r lTm = null;
    private int mTL = 0;
    private String mld;
    protected com.tencent.mm.ui.snackbar.b.b nah = new com.tencent.mm.ui.snackbar.b.b(this) {
        final /* synthetic */ NoteEditorUI tXd;

        {
            this.tXd = r1;
        }

        public final void aPO() {
            com.tencent.mm.sdk.b.b fvVar = new fv();
            fvVar.fvq.type = 35;
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
        }
    };
    private boolean tQy = false;
    private int tUp;
    private boolean tWA = false;
    private String tWB = "";
    private com.tencent.mm.plugin.wenote.ui.nativenote.a.a tWC;
    private boolean tWD = false;
    private boolean tWE = false;
    private a tWF;
    private uq tWG;
    private boolean tWH = false;
    private final Object tWI = new Object();
    private LinearLayout tWJ = null;
    private String tWK = "";
    private int tWL = 0;
    private int tWM = 0;
    private int tWN = 0;
    private String[] tWO = null;
    private boolean tWP = true;
    private long tWQ = 0;
    private boolean tWR = false;
    private String tWS;
    private boolean tWT = false;
    private boolean tWU = false;
    private boolean tWV = false;
    private boolean tWW = true;
    private int tWX = 0;
    private k tWY = null;
    OnTouchListener tWZ = new 35(this);
    private com.tencent.mm.plugin.wenote.model.nativenote.manager.k tWs;
    private c tWt;
    private LinearLayout tWu;
    private c tWv = null;
    private RelativeLayout tWw = null;
    private g tWx = null;
    private boolean tWy = false;
    private boolean tWz = false;
    private boolean tXa = false;
    private int tXb = -1;
    private boolean tXc = false;

    static /* synthetic */ void a(NoteEditorUI noteEditorUI, n nVar) {
        if (noteEditorUI.c(h.bWJ().bWK())) {
            nVar.f(6, noteEditorUI.getString(R.l.eXF));
        } else {
            nVar.f(5, noteEditorUI.getString(R.l.eXH));
        }
    }

    static /* synthetic */ void b(NoteEditorUI noteEditorUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 15);
        intent.putExtra("need_result", true);
        String QQ = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().QQ(noteEditorUI.getString(R.l.eXI));
        intent.putExtra("fav_note_xml", str);
        intent.putExtra("Ksnsupload_title", QQ);
        intent.putExtra("Ksnsupload_link", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008");
        intent.putExtra("fav_note_link_description", "note description");
        intent.putExtra("Ksnsupload_imgbuf", com.tencent.mm.a.e.e(noteEditorUI.mld, 0, -1));
        d.b(noteEditorUI, "sns", ".ui.SnsUploadUI", intent, 4354);
    }

    public void onCreate(Bundle bundle) {
        this.tUp = getIntent().getIntExtra("note_open_from_scene", 2);
        this.fqm = getIntent().getLongExtra("note_msgid", -1);
        this.tWU = getIntent().getBooleanExtra("record_show_share", false);
        this.hzP = getIntent().getLongExtra("note_fav_localid", -1);
        this.lLW = getIntent().getStringExtra("note_link_sns_localid");
        this.tQy = getIntent().getBooleanExtra("edit_status", false);
        this.tWK = getIntent().getStringExtra("fav_note_xml");
        this.tWM = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
        this.tWN = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
        this.mld = getIntent().getStringExtra("fav_note_thumbpath");
        this.tWP = getIntent().getBooleanExtra("show_share", true);
        this.tWS = getIntent().getStringExtra("fav_note_link_sns_xml");
        String stringExtra = getIntent().getStringExtra("fav_note_link_source_info");
        this.tWV = getIntent().getBooleanExtra("fav_note_out_of_date", false);
        if (!bh.ov(stringExtra)) {
            this.tWO = stringExtra.split(";");
        }
        if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
            this.tWR = true;
        }
        com.tencent.mm.plugin.wenote.model.d.tQA = false;
        if (this.tWO == null && this.hzP > 0) {
            com.tencent.mm.sdk.b.b fvVar = new fv();
            fvVar.fvq.type = 30;
            fvVar.fvq.fvx = 3;
            fvVar.fvq.fqk = this.hzP;
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
            this.tWO = bh.ov(fvVar.fvr.path) ? null : fvVar.fvr.path.split(";");
        }
        if (this.tWO == null || this.tWO.length >= 3) {
            View inflate;
            this.hae = new af();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c bWp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp();
            bWp.jRt = new ArrayList();
            bWp.tSE = this;
            bWp.tSF = new uq();
            bWp.tSG = 0;
            bWp.tSH = 0;
            bWp.tSI = 0;
            x.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
            com.tencent.mm.pluginsdk.e.h(this);
            super.onCreate(bundle);
            df(this.hzP);
            x.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
            com.tencent.mm.plugin.wenote.model.a.b hVar = new com.tencent.mm.plugin.wenote.model.a.h();
            hVar.content = "";
            hVar.tRt = true;
            hVar.tRz = false;
            if (this.tQy) {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(hVar);
                this.tWR = true;
            }
            this.Iv = this.mController.contentView;
            this.Iv.getRootView().setBackgroundColor(-1);
            this.Va = (RecyclerView) findViewById(R.h.cZF);
            this.tWu = (LinearLayout) this.Iv.findViewById(R.h.cdf);
            this.tWu.setVisibility(8);
            this.tWJ = (LinearLayout) this.tWu.findViewById(R.h.cBj);
            this.tWJ.setVisibility(8);
            this.tWw = (RelativeLayout) findViewById(R.h.cZw);
            this.tWw.setOnClickListener(new 1(this));
            this.tWx = new g(this, this.tWw);
            this.tWx.tTi = this;
            this.tWC = new com.tencent.mm.plugin.wenote.ui.nativenote.a.a(this);
            this.tWC.tXO = j.aT(this)[1];
            this.Va.a(this.tWC);
            this.Va.Ub = true;
            this.tWF = new a(this);
            this.Va.a(this.tWF);
            this.tWs = new com.tencent.mm.plugin.wenote.model.nativenote.manager.k(this);
            this.tWs.fqk = this.hzP;
            this.tWs.tUp = this.tUp;
            this.tWs.tUq = this.tWR;
            this.tWt = new c(this.tWs);
            this.Va.a(this.tWt);
            if (this.tUp == 2) {
                this.Va.setOnTouchListener(this.tWZ);
            }
            this.Va.Ur.UV = 0;
            this.Va.Ur.UY = 0;
            this.Va.Ur.UX = 0;
            this.Va.Ur.UW = 120;
            ((aj) this.Va.Ur).XL = false;
            this.tWX = com.tencent.mm.bv.a.fromDPToPix(this, 48);
            if (this.tWW) {
                x.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
                boolean z = this.tUp == 2 && this.tWR;
                int color = getResources().getColor(R.e.btw);
                com.tencent.mm.plugin.wenote.model.nativenote.c.e bXf = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf();
                x.i("NoteSelectManager", "onInit start");
                if (this == null || this == null) {
                    x.e("NoteSelectManager", "context or listener is null");
                } else {
                    bXf.tUP = z;
                    bXf.tUS = 14;
                    bXf.tUT = 32;
                    bXf.tUU = com.tencent.mm.bv.a.fromDPToPix(this, 21) - bXf.tUT;
                    bXf.tUV = com.tencent.mm.bv.a.fromDPToPix(this, 40) + (bXf.tUT * 2);
                    bXf.tUW = com.tencent.mm.bv.a.fromDPToPix(this, 240) + (bXf.tUT * 2);
                    bXf.tUQ = com.tencent.mm.bv.a.fromDPToPix(this, 22);
                    bXf.tUR = com.tencent.mm.bv.a.fromDPToPix(this, 1);
                    bXf.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
                    bXf.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
                    bXf.tVa = new int[]{-1, -1};
                    bXf.tVb = new int[]{-1, -1};
                    bXf.tVc = new int[]{-1, -1};
                    bXf.tVd = new int[]{-1, -1};
                    View aVar = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, bXf.tUQ, bXf.tUR, color, bXf);
                    bXf.tVe = new PopupWindow(aVar, aVar.bCH(), aVar.btt(), false);
                    bXf.tVe.setClippingEnabled(false);
                    bXf.tVe.setAnimationStyle(R.m.eZb);
                    bXf.tUY = (aVar.lee + aVar.tUy) + 1;
                    bXf.tUZ = com.tencent.mm.bv.a.fromDPToPix(this, 6);
                    View aVar2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, bXf.tUQ, bXf.tUR, color, bXf);
                    bXf.tVf = new PopupWindow(aVar2, aVar2.bCH(), aVar.btt(), false);
                    bXf.tVf.setClippingEnabled(false);
                    bXf.tVf.setAnimationStyle(R.m.eZa);
                    aVar2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, bXf.tUQ, bXf.tUR, color, bXf);
                    bXf.tVg = new PopupWindow(aVar2, aVar2.bCH(), aVar.btt(), false);
                    bXf.tVg.setClippingEnabled(false);
                    bXf.tVg.setAnimationStyle(R.m.eZc);
                    inflate = LayoutInflater.from(this).inflate(R.i.dph, null);
                    inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    bXf.tVh = new PopupWindow(inflate, -2, -2, false);
                    bXf.tVh.setBackgroundDrawable(getResources().getDrawable(R.g.bGy));
                    bXf.tVh.setClippingEnabled(false);
                    bXf.tVh.setAnimationStyle(R.m.eZd);
                    bXf.tVn = (TextView) inflate.findViewById(R.h.cAG);
                    bXf.tVo = (TextView) inflate.findViewById(R.h.cBc);
                    bXf.tVp = (TextView) inflate.findViewById(R.h.cAZ);
                    bXf.tVq = (TextView) inflate.findViewById(R.h.cAY);
                    bXf.tVr = (TextView) inflate.findViewById(R.h.cAO);
                    bXf.tVs = (TextView) inflate.findViewById(R.h.cAN);
                    bXf.tVt = (TextView) inflate.findViewById(R.h.cAM);
                    bXf.tVu = (TextView) inflate.findViewById(R.h.cAU);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXf.tVn, bXf.tUS);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXf.tVo, bXf.tUS);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXf.tVp, bXf.tUS);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXf.tVq, bXf.tUS);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXf.tVr, bXf.tUS);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXf.tVs, bXf.tUS);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXf.tVt, bXf.tUS);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.e(bXf.tVu, bXf.tUS);
                    bXf.tVn.setOnClickListener(new e$10(bXf));
                    bXf.tVo.setOnClickListener(new 11(bXf));
                    bXf.tVp.setOnClickListener(new e$12(bXf));
                    bXf.tVq.setOnClickListener(new 13(bXf));
                    bXf.tVr.setOnClickListener(new e$2(bXf));
                    bXf.tVs.setOnClickListener(new 3(bXf));
                    bXf.tVt.setOnClickListener(new 4(bXf));
                    bXf.tVu.setOnClickListener(new 5(bXf));
                    bXf.tUX = aVar.lee;
                    bXf.tVi = this;
                    bXf.tVj = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
                    bXf.tVk = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
                    bXf.mHandler = new af();
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
                    x.i("NoteSelectManager", "onInit end");
                }
                this.tWY = new k(this) {
                    final /* synthetic */ NoteEditorUI tXd;

                    {
                        this.tXd = r1;
                    }

                    public final void e(RecyclerView recyclerView, int i) {
                        super.e(recyclerView, i);
                        switch (i) {
                            case 0:
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().kN(com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXm());
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().kM(com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXk());
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().g(false, 50);
                                return;
                            case 1:
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXn();
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXl();
                                return;
                            default:
                                return;
                        }
                    }

                    public final void c(RecyclerView recyclerView, int i, int i2) {
                        super.c(recyclerView, i, i2);
                        if (i2 > 30) {
                            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXn();
                            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXl();
                        }
                        com.tencent.mm.plugin.wenote.model.nativenote.c.d bXh = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXh();
                        if ((this.tXd.tWE || (this.tXd.tWu != null && this.tXd.tWu.getVisibility() == 0)) && bXh.bXe() == 2 && f.g(recyclerView, bXh.hlq) == null) {
                            this.tXd.bWe();
                        }
                    }
                };
                this.Va.a(this.tWY);
            }
            if (this.lTm != null) {
                this.lTm.dismiss();
                this.lTm = null;
            }
            if (!(this.tQy || this.tWV)) {
                this.lTm = com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.eYu), true, new 12(this));
            }
            if (this.tWV) {
                x.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
                com.tencent.mm.ui.base.h.b(this.mController.xIM, this.mController.xIM.getString(R.l.eyl), null, true);
            }
            if (this.tWP) {
                addIconOptionMenu(1, R.l.eRi, R.g.bDI, new 23(this));
            }
            setMMTitle(getString(R.l.egX));
            lV(true);
            setBackBtn(new 30(this), R.g.byy);
            com.tencent.mm.pluginsdk.e.i(this);
            if (this.tQy) {
                f(true, 300);
                P(1, 0);
            }
            if (this.tUp == 2 && this.tWR) {
                this.tWv = new c();
                c cVar = this.tWv;
                inflate = this.tWu;
                cVar.ioh = inflate;
                com.tencent.mm.plugin.wenote.model.nativenote.manager.k.bWZ().tUk = cVar;
                cVar.tXu = (LinearLayout) inflate.findViewById(R.h.cBj);
                cVar.tXt = (ImageButton) inflate.findViewById(R.h.cZD);
                cVar.tXv = (ImageButton) inflate.findViewById(R.h.cZz);
                cVar.tXw = (ImageButton) inflate.findViewById(R.h.cZB);
                cVar.tXx = (ImageButton) inflate.findViewById(R.h.cZA);
                cVar.tXy = (ImageButton) inflate.findViewById(R.h.cZC);
                cVar.tXz = (LinearLayout) cVar.tXu.findViewById(R.h.cZJ);
                cVar.tXA = (LinearLayout) cVar.tXu.findViewById(R.h.cZM);
                cVar.tXB = (LinearLayout) cVar.tXu.findViewById(R.h.cZK);
                cVar.tXC = (LinearLayout) cVar.tXu.findViewById(R.h.cZL);
                cVar.tXD = (LinearLayout) cVar.tXu.findViewById(R.h.cxk);
                cVar.tXt.setOnClickListener(new 1(cVar, this));
                cVar.tXx.setOnClickListener(new 6(cVar, this));
                cVar.tXy.setOnClickListener(new 7(cVar, this, this));
                cVar.tXv.setOnClickListener(new 8(cVar, this));
                cVar.tXw.setOnClickListener(new 9(cVar, this));
                cVar.tXD.setOnClickListener(new c$10(cVar, this));
                cVar.tXz.setOnClickListener(new c.11(cVar, this));
                cVar.tXA.setOnClickListener(new 12(cVar, this));
                cVar.tXB.setOnClickListener(new c.13(cVar, this));
                cVar.tXC.setOnClickListener(new 2(cVar, this));
                getWindow().setSoftInputMode(18);
            } else {
                this.tWu.setVisibility(8);
            }
            this.Va.getViewTreeObserver().addOnGlobalLayoutListener(this.OE);
            this.tWQ = System.currentTimeMillis();
            x.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[]{Long.valueOf(this.tWQ)});
            ar.CG().a(921, this);
        }
    }

    private boolean c(p pVar) {
        if (pVar == null) {
            return false;
        }
        if (pVar.tRS != (this.tUp == 1)) {
            return false;
        }
        if ((this.tUp == 1 && pVar.tRU == this.fqm) || (this.tUp == 2 && pVar.tRT == this.hzP)) {
            return true;
        }
        return false;
    }

    public void onBackPressed() {
        if (bXE()) {
            goBack();
            super.onBackPressed();
        }
    }

    protected final int getLayoutId() {
        return R.i.dpe;
    }

    public final void bWb() {
        com.tencent.mm.ui.base.h.b(this.mController.xIM, getString(R.l.eyo), null, true);
    }

    private boolean bXE() {
        if (this.tWv == null || !this.tWv.tXE) {
            return true;
        }
        bWb();
        return false;
    }

    private void goBack() {
        if (this.tUp == 2 && this.tWs.tUq) {
            if (!(this.tWz || this.tQy)) {
                com.tencent.mm.sdk.b.b fvVar = new fv();
                fvVar.fvq.type = 19;
                fvVar.fvq.fqk = this.hzP;
                fvVar.fvq.fvx = -1;
                com.tencent.mm.sdk.b.a.xef.m(fvVar);
                if (!(!fvVar.fvr.fvI)) {
                    this.tWz = true;
                    this.tWA = true;
                } else {
                    return;
                }
            }
            bXF();
            finish();
        }
    }

    public final void bXF() {
        this.tWv.a(this);
        final String bWw = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWw();
        String QT = com.tencent.mm.plugin.wenote.b.b.QT(Pattern.compile("<object[^>]*>", 2).matcher(bWw).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#"));
        if (!(bh.ov(QT) || QT.length() == 0)) {
            QT = Pattern.compile("\\s*|\t|\r|\n").matcher(QT).replaceAll("");
        }
        if ((bh.ov(QT) ? 1 : null) != null) {
            com.tencent.mm.sdk.b.b fvVar = new fv();
            fvVar.fvq.type = 12;
            fvVar.fvq.fqk = this.hzP;
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
        } else if (this.tQy) {
            x.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ NoteEditorUI tXd;

                public final void run() {
                    this.tXd.aX(bWw, true);
                }
            });
        } else if (this.tWz) {
            x.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ NoteEditorUI tXd;

                public final void run() {
                    this.tXd.aX(bWw, false);
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tWW) {
            if (this.Va != null) {
                RecyclerView recyclerView = this.Va;
                k kVar = this.tWY;
                if (recyclerView.UD != null) {
                    recyclerView.UD.remove(kVar);
                }
            }
            com.tencent.mm.plugin.wenote.model.nativenote.c.e bXf = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf();
            x.i("NoteSelectManager", "onDestroy");
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = false;
            if (bXf.tVl != null) {
                bXf.tVl.TG();
            }
            if (bXf.tVm != null) {
                bXf.tVm.TG();
            }
            if (bXf.tVe != null) {
                bXf.tVe.dismiss();
            }
            if (bXf.tVf != null) {
                bXf.tVf.dismiss();
            }
            if (bXf.tVg != null) {
                bXf.tVg.dismiss();
            }
            if (bXf.tVh != null) {
                bXf.tVh.dismiss();
            }
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.tUO = null;
        }
        ar.CG().b(921, this);
        if (this.tWs != null) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.k kVar2 = this.tWs;
            kVar2.tUs.TG();
            kVar2.tUi = -1;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.k.tUd = null;
        }
        if (com.tencent.mm.plugin.wenote.model.c.bVN().tQn != null) {
            com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQt.clear();
            com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQs.clear();
            com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQr.clear();
        }
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a bXQ = com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bXQ();
        bXQ.stopPlay();
        bXQ.kCP = null;
        bXQ.kCT = null;
        bXQ.gxL.clear();
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.tYP = null;
        if (com.tencent.mm.plugin.wenote.model.k.bVR() != null) {
            com.tencent.mm.plugin.wenote.model.k.destroy();
        }
    }

    public final void bWk() {
        if (this.tWv != null) {
            this.tWv.a(null);
        }
    }

    public final void Bm(int i) {
        Handler handler = getWindow().getDecorView().getHandler();
        if (handler != null) {
            handler.postDelayed(new 2(this, i), 0);
        }
    }

    public final void Bo(int i) {
        try {
            this.tWt.bl(i);
        } catch (Exception e) {
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public final void Bn(int i) {
        try {
            this.tWt.bk(i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public final void en(int i, int i2) {
        try {
            this.tWt.W(i, i2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void eo(int i, int i2) {
        try {
            this.tWt.U(i, i2);
        } catch (Exception e) {
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void bXG() {
        try {
            this.tWt.UR.notifyChanged();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            x.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
        }
    }

    public final void kG(boolean z) {
        x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[]{Boolean.valueOf(z)});
        if (this.tWy || com.tencent.mm.plugin.wenote.model.c.bVN().tQn == null) {
            boolean z2;
            String str = "MicroMsg.Note.NoteEditorUI";
            String str2 = "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.tWy);
            if (com.tencent.mm.plugin.wenote.model.c.bVN().tQn == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            x.e(str, str2, objArr);
            return;
        }
        v vVar;
        if (this.tUp != 1) {
            x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
            if (com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQq == null) {
                x.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
                return;
            }
            vVar = (v) com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQr.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQq.field_localId));
        } else {
            x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
            if (com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQp == null) {
                x.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
                return;
            }
            vVar = (v) com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQr.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQp.fqm));
        }
        if (vVar != null && !this.tQy) {
            this.tWH = vVar.tSj;
            if (vVar.tSj) {
                l(vVar.tSi, false);
                return;
            }
            this.tWy = true;
            l(vVar.tSi, true);
        }
    }

    public final synchronized void l(Object obj, final boolean z) {
        x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData,canDismissLoadingDialog:%B", new Object[]{Boolean.valueOf(z)});
        synchronized (this.tWI) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWq();
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList == null) {
            } else {
                x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData start");
                if (this.tUp == 2 && !this.tWR) {
                    l lVar = com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQp;
                    if (lVar == null) {
                    } else {
                        com.tencent.mm.plugin.wenote.model.a.b dVar = new com.tencent.mm.plugin.wenote.model.a.d(lVar.tRM);
                        dVar.tRt = false;
                        dVar.tRz = false;
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(dVar);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.wenote.model.a.n nVar = (com.tencent.mm.plugin.wenote.model.a.n) it.next();
                    switch (nVar.type) {
                        case -3:
                        case -2:
                            break;
                        case -1:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a((com.tencent.mm.plugin.wenote.model.a.g) nVar);
                            break;
                        case 1:
                            com.tencent.mm.plugin.wenote.model.a.h hVar = (com.tencent.mm.plugin.wenote.model.a.h) nVar;
                            if (bh.ov(hVar.content)) {
                                hVar.content = "";
                            }
                            hVar.content = hVar.content.replaceAll("<font", "<wx-font").replaceAll("<div", "<wx-div").replaceAll("<p", "<wx-p").replaceAll("</font>", "</wx-font>").replaceAll("<ul>", "<wx-ul>").replaceAll("</ul>", "</wx-ul>").replaceAll("<ol>", "<wx-ol>").replaceAll("</ol>", "</wx-ol>").replaceAll("<li>", "<wx-li>").replaceAll("</li>", "</wx-li>").replaceAll("<b>", "<wx-b>").replaceAll("</b>", "</wx-b>").replaceAll("</div>", "</wx-div>").replaceAll("</p>", "</wx-p>");
                            if (hVar.content.length() > 100) {
                                com.tencent.mm.plugin.wenote.model.nativenote.a.a.QN(hVar.content);
                            } else {
                                Object obj2;
                                String str = hVar.content;
                                String str2 = "<br/>";
                                int length = str2.length();
                                if (bh.ov(str) || str.length() < length) {
                                    obj2 = null;
                                } else {
                                    int i = 0;
                                    while (i < str.length()) {
                                        int i2 = i + length;
                                        if (i2 > str.length()) {
                                            obj2 = null;
                                        } else if (str2.equalsIgnoreCase(str.substring(i, i2))) {
                                            i = i2;
                                        } else {
                                            obj2 = null;
                                        }
                                    }
                                    i = 1;
                                }
                                if (obj2 != null) {
                                    hVar.content = hVar.content.substring(0, hVar.content.length() - 5);
                                }
                            }
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(hVar);
                            break;
                        case 2:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a((com.tencent.mm.plugin.wenote.model.a.e) nVar);
                            break;
                        case 3:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a((com.tencent.mm.plugin.wenote.model.a.f) nVar);
                            break;
                        case 4:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a((com.tencent.mm.plugin.wenote.model.a.k) nVar);
                            break;
                        case 5:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a((com.tencent.mm.plugin.wenote.model.a.c) nVar);
                            break;
                        case 6:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a((com.tencent.mm.plugin.wenote.model.a.j) nVar);
                            break;
                        default:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a((i) nVar);
                            break;
                    }
                }
                x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData finish");
                if (!z) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c bWp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp();
                    synchronized (bWp) {
                        bWp.tSJ = true;
                    }
                }
                ag.y(new Runnable(this) {
                    final /* synthetic */ NoteEditorUI tXd;

                    public final void run() {
                        synchronized (this.tXd.tWI) {
                            this.tXd.bXG();
                            this.tXd.tWy = true;
                            x.i("MicroMsg.Note.NoteEditorUI", "postToMainThread,isInitDataList = true,canDismissLoadingDialog :%B,mHasFreshedDataByHtml:%B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.tXd.tWH)});
                            if (this.tXd.lTm != null && z) {
                                this.tXd.lTm.dismiss();
                            }
                        }
                    }
                });
                if (this.tWM > 0 || this.tWN != 0) {
                    this.hae.postDelayed(new 4(this), 100);
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWv();
            }
        }
    }

    public final RecyclerView bXH() {
        return this.Va;
    }

    public final Context bXI() {
        return this.mController.xIM;
    }

    public final a bXJ() {
        return this;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.tXb = i;
        if (i2 != -1) {
            this.tXa = false;
            return;
        }
        int i3;
        this.tXa = true;
        final String stringExtra;
        String str;
        Context context;
        com.tencent.mm.plugin.wenote.model.a.b fVar;
        String stringExtra2;
        Dialog a;
        com.tencent.mm.sdk.b.b fvVar;
        switch (i) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                final String stringExtra3 = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bh.ov(stringExtra)) {
                    ar.Hg();
                    final cf dH = com.tencent.mm.z.c.Fa().dH(this.fqm);
                    if (dH.field_msgId == this.fqm) {
                        final Dialog a2 = com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.efz), false, null);
                        ar.Dm().F(new Runnable(this) {
                            final /* synthetic */ NoteEditorUI tXd;

                            public final void run() {
                                com.tencent.mm.sdk.b.b mtVar = new mt();
                                mtVar.fEE.type = 4;
                                mtVar.fEE.fEJ = dH;
                                mtVar.fEE.toUser = stringExtra;
                                mtVar.fEE.fvw = stringExtra3;
                                com.tencent.mm.sdk.b.a.xef.m(mtVar);
                                ag.y(new 1(this));
                            }

                            public final String toString() {
                                return super.toString() + "|onActivityResult";
                            }
                        });
                        i3 = 2;
                        break;
                    }
                    x.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
                    return;
                }
                x.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                return;
            case 4097:
                x.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
                if (intent.getParcelableExtra("key_req_result") == null) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    x.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14547, new Object[]{Integer.valueOf(i3)});
                    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().eq(0, stringArrayListExtra.size())) {
                        bVZ();
                        i3 = 0;
                        break;
                    }
                    Context context2 = this.mController.xIM;
                    getString(R.l.dGO);
                    this.iln = com.tencent.mm.ui.base.h.a(context2, getString(R.l.dHc), true, new 8(this));
                    ar.Dm().F(new 9(this, stringArrayListExtra));
                }
                stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                String stringExtra4 = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                if (!bh.ov(stringExtra4) && stringArrayListExtra == null) {
                    stringArrayListExtra = new ArrayList();
                    stringArrayListExtra.add(stringExtra4);
                }
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14547, new Object[]{Integer.valueOf(i3)});
                    if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().eq(0, stringArrayListExtra.size())) {
                        str = (String) stringArrayListExtra.get(0);
                        com.tencent.mm.plugin.sight.base.a Js = com.tencent.mm.plugin.sight.base.d.Js(str);
                        if (Js != null) {
                            long bsA = (long) Js.bsA();
                            com.tencent.mm.plugin.wenote.model.a.j jVar = new com.tencent.mm.plugin.wenote.model.a.j();
                            jVar.tRQ = true;
                            jVar.fvC = "";
                            jVar.fCa = "";
                            jVar.duration = bsA;
                            jVar.type = 6;
                            jVar.tRP = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWv();
                            jVar.tRF = com.tencent.mm.a.e.bQ(str);
                            jVar.mvG = com.tencent.mm.plugin.wenote.model.f.QI(jVar.toString());
                            this.tWG = new uq();
                            this.tWG.TD(jVar.mvG);
                            this.tWG.TA(jVar.tRF);
                            stringExtra4 = com.tencent.mm.plugin.wenote.model.f.i(this.tWG);
                            stringExtra = com.tencent.mm.plugin.wenote.model.f.o(this.tWG);
                            if (!bh.ov(str)) {
                                x.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", new Object[]{str});
                                List arrayList = new ArrayList();
                                arrayList.add(str);
                                Runnable dVar = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(arrayList, stringExtra4, stringExtra, jVar, new 14(this));
                                context = this.mController.xIM;
                                getString(R.l.dGO);
                                this.iln = com.tencent.mm.ui.base.h.a(context, getString(R.l.dHc), true, new 15(this, dVar, jVar));
                                com.tencent.mm.sdk.f.e.post(dVar, "NoteEditor_importVideo");
                                i3 = 0;
                                break;
                            }
                            x.e("MicroMsg.Note.NoteEditorUI", "video is null");
                            i3 = 0;
                            break;
                        }
                        x.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[]{bh.ou(str)});
                        i3 = 0;
                        break;
                    }
                    bVZ();
                    i3 = 0;
                    break;
                }
                x.i("MicroMsg.Note.NoteEditorUI", "no video selected");
                i3 = 0;
                break;
                break;
            case 4098:
                com.tencent.mm.plugin.report.service.g.pQN.h(14547, new Object[]{Integer.valueOf(4)});
                if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().eq(0, 1)) {
                    fVar = new com.tencent.mm.plugin.wenote.model.a.f();
                    fVar.lat = (double) ((float) intent.getDoubleExtra("kwebmap_slat", 0.0d));
                    fVar.lng = (double) ((float) intent.getDoubleExtra("kwebmap_lng", 0.0d));
                    fVar.tSd = (double) intent.getIntExtra("kwebmap_scale", 0);
                    fVar.hxu = bh.az(intent.getStringExtra("Kwebmap_locaion"), "");
                    fVar.nTe = intent.getStringExtra("kPoiName");
                    fVar.tRP = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWv();
                    fVar.type = 3;
                    fVar.tRQ = true;
                    fVar.fCa = "";
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(fVar, this.tWs.bXc(), false, false, false);
                    i3 = 0;
                    break;
                }
                bVZ();
                i3 = 0;
                break;
            case 4099:
                com.tencent.mm.plugin.report.service.g.pQN.h(14547, new Object[]{Integer.valueOf(5)});
                str = intent.getStringExtra("choosed_file_path");
                if (!bh.ov(str)) {
                    File file = new File(str);
                    if (file.exists()) {
                        if (file.length() < mtK) {
                            if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().eq(0, 1)) {
                                if (this.iln != null) {
                                    this.iln.dismiss();
                                    this.iln = null;
                                }
                                context = this.mController.xIM;
                                getString(R.l.dGO);
                                this.iln = com.tencent.mm.ui.base.h.a(context, getString(R.l.dHc), true, new 10(this));
                                fVar = new com.tencent.mm.plugin.wenote.model.a.c();
                                fVar.title = file.getName();
                                fVar.content = com.tencent.mm.plugin.wenote.model.f.ah((float) com.tencent.mm.a.e.bN(str));
                                fVar.tRN = com.tencent.mm.plugin.wenote.model.h.QM(com.tencent.mm.a.e.bQ(str));
                                fVar.tRP = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWv();
                                fVar.type = 5;
                                fVar.tRQ = true;
                                fVar.tRF = com.tencent.mm.a.e.bQ(str);
                                fVar.mvG = com.tencent.mm.plugin.wenote.model.f.QI(fVar.toString());
                                this.tWG = new uq();
                                this.tWG.TD(fVar.mvG);
                                this.tWG.TA(fVar.tRF);
                                fVar.fCa = com.tencent.mm.plugin.wenote.model.f.o(this.tWG);
                                FileOp.x(str, fVar.fCa);
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(fVar, this.tWs.bXc(), false, true, false);
                                i3 = 2;
                                break;
                            }
                            bVZ();
                            i3 = 2;
                            break;
                        }
                        i3 = 3;
                        break;
                    }
                    i3 = 1;
                    break;
                }
                i3 = 1;
                break;
            case 4101:
                stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                str = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bh.ov(stringExtra2)) {
                    a = com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.efz), false, null);
                    fvVar = new fv();
                    fvVar.fvq.type = 13;
                    fvVar.fvq.context = this.mController.xIM;
                    fvVar.fvq.toUser = stringExtra2;
                    fvVar.fvq.fvw = str;
                    fvVar.fvq.fqk = this.hzP;
                    fvVar.fvq.fvv = new 7(this, a);
                    com.tencent.mm.sdk.b.a.xef.m(fvVar);
                    i3 = 2;
                    break;
                }
                x.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                return;
            case 4354:
                this.hae.post(new 11(this));
                i3 = 2;
                break;
            case 4355:
                stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                str = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bh.ov(stringExtra2)) {
                    a = com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.efz), false, null);
                    fvVar = new fv();
                    fvVar.fvq.type = 13;
                    fvVar.fvq.context = this.mController.xIM;
                    fvVar.fvq.toUser = stringExtra2;
                    fvVar.fvq.fvw = str;
                    fvVar.fvq.fqk = this.hzP;
                    fvVar.fvq.fqr = com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQz;
                    fvVar.fvq.fvv = new 13(this, a);
                    com.tencent.mm.sdk.b.a.xef.m(fvVar);
                    break;
                }
                x.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                return;
        }
        i3 = 2;
        if (i3 == 0) {
            return;
        }
        if (1 == i3) {
            com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(R.l.efg));
        } else if (3 == i3) {
            Toast.makeText(this.mController.xIM, getString(R.l.egO), 1).show();
        }
    }

    public final void aX(String str, boolean z) {
        x.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlstr:%s,isInsert:%B", new Object[]{str, Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.b fvVar;
        if (z || !str.equals(this.tWB)) {
            ve QP = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().QP(str);
            if (QP == null) {
                x.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
                return;
            }
            com.tencent.mm.sdk.b.b fvVar2;
            if (z) {
                fvVar2 = new fv();
                fvVar2.fvq.type = 19;
                fvVar2.fvq.fqr = QP;
                fvVar2.fvq.title = str;
                fvVar2.fvq.fqk = this.hzP;
                fvVar2.fvq.desc = "fav_add_new_note";
                com.tencent.mm.sdk.b.a.xef.m(fvVar2);
            } else {
                fvVar2 = new fv();
                fvVar2.fvq.type = 19;
                fvVar2.fvq.fqr = QP;
                fvVar2.fvq.title = str;
                fvVar2.fvq.fqk = this.hzP;
                fvVar2.fvq.desc = "";
                if (this.tWA) {
                    fvVar2.fvq.fvx = -2;
                }
                com.tencent.mm.sdk.b.a.xef.m(fvVar2);
            }
            x.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
            if (z) {
                boolean z2;
                fvVar = new fv();
                fvVar.fvq.type = 30;
                fvVar.fvq.fvx = 6;
                fvVar.fvq.fqk = this.hzP;
                com.tencent.mm.sdk.b.a.xef.m(fvVar);
                if (fvVar.fvr.ret == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    this.tQy = false;
                    this.tWz = true;
                }
            }
            this.tWB = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWw();
        } else if (!this.tWT && this.tWs.tUm > 0 && !bh.ov(this.tWs.tUn) && this.tWs.tUo > 0) {
            fvVar = new fv();
            fvVar.fvq.type = 19;
            fvVar.fvq.fvx = -3;
            fvVar.fvq.fqk = this.hzP;
            Intent intent = new Intent();
            intent.putExtra("fav_note_item_status", this.tWs.tUm);
            intent.putExtra("fav_note_xml", this.tWs.tUn);
            intent.putExtra("fav_note_item_updatetime", this.tWs.tUo);
            fvVar.fvq.fvt = intent;
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.tUp == 2) {
            switch (this.tXb) {
                case -1:
                    if (this.tXc) {
                        f(true, 100);
                        P(1, 0);
                        break;
                    }
                    break;
                case 4097:
                    if (!this.tXa) {
                        f(true, 100);
                        P(1, 0);
                        break;
                    }
                    break;
                case 4098:
                case 4099:
                    f(true, 100);
                    P(1, 0);
                    break;
            }
        }
        this.tXb = -1;
        this.tXa = false;
    }

    protected void onPause() {
        super.onPause();
        if (this.tWv != null) {
            this.tWv.a(this);
        }
        if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bXQ().aIA()) {
            com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bXQ().stopPlay();
        }
        this.tXc = this.tWE;
        f(false, 0);
        p bWK = h.bWJ().bWK();
        if (c(bWK)) {
            bWK.tRW = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().QQ(getString(R.l.eXI));
            bWK.tRY = this.mTL;
            bWK.tRZ = this.tWL;
            h.bWJ().a(bWK);
        }
    }

    public void onDrag() {
        super.onDrag();
        if (this.tWW) {
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXn();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXl();
        }
    }

    public void onCancel() {
        super.onCancel();
        if (this.tWW) {
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().kN(false);
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().kM(false);
        }
    }

    public final void bWc() {
        com.tencent.mm.ui.base.h.a(this, getString(R.l.eyj), "", getString(R.l.eyi), getString(R.l.eyh), new 17(this), null);
    }

    public final void bWd() {
        Toast.makeText(this.mController.xIM, getString(R.l.eym), 0).show();
    }

    public final int bWf() {
        if (this.tWE) {
            return j.aN(this);
        }
        return 0;
    }

    public final int bWg() {
        int i = 0;
        if (this.tWu != null && this.tWu.getVisibility() == 0) {
            i = this.tWX + 0;
        }
        if (this.tWJ == null || this.tWJ.getVisibility() != 0) {
            return i;
        }
        return i + this.tWX;
    }

    public final boolean bWh() {
        return (this.tWs == null || this.tWs.bWY() == null) ? false : true;
    }

    public final RecyclerView bWi() {
        return this.Va;
    }

    public final void bWe() {
        if (this.tUp == 2 && this.tWs.tUq) {
            int bWr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWr();
            com.tencent.mm.plugin.wenote.model.a.b Bt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(bWr);
            if (Bt != null) {
                Bt.tRt = false;
                Bt.tRz = false;
                Bm(bWr);
            }
            this.hae.post(new Runnable(this) {
                final /* synthetic */ NoteEditorUI tXd;

                {
                    this.tXd = r1;
                }

                public final void run() {
                    WXRTEditText bWY = this.tXd.tWs.bWY();
                    if (bWY != null) {
                        bWY.clearFocus();
                    }
                }
            });
            f(false, 0);
            P(0, 0);
        }
    }

    public final void a(WXRTEditText wXRTEditText, boolean z, int i) {
        if (this.tUp == 2 && this.tWs.tUq) {
            ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a) this.Va.TV).tXP = z;
            if (this.tWD) {
                ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a) this.Va.TV).tXP = false;
            }
            if (z) {
                if (!(this.tQy || this.tWz)) {
                    this.tWB = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWw();
                    this.tWz = true;
                }
                if (wXRTEditText == null || wXRTEditText.tTw != 1) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().X(i, false);
                    return;
                } else {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().X(i, true);
                    return;
                }
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().W(-1, false);
        }
    }

    public final void bWj() {
        if (!this.tQy && !this.tWz) {
            this.tWB = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWw();
            this.tWz = true;
        }
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        this.tWE = this.mController.xJg == 1;
        if (this.tWE) {
            P(1, 0);
        }
        if (this.tWW) {
            this.hae.postDelayed(new Runnable(this) {
                final /* synthetic */ NoteEditorUI tXd;

                {
                    this.tXd = r1;
                }

                public final void run() {
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().kN(com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXm());
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().kM(com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXk());
                }
            }, 200);
        }
    }

    public final void f(boolean z, long j) {
        if (this.tUp == 2 && this.tWs.tUq) {
            this.hae.postDelayed(new 20(this, z), j);
        }
    }

    public final void P(int i, long j) {
        if (this.tUp == 2 && this.tWs.tUq) {
            this.hae.postDelayed(new 21(this, i), j);
        }
    }

    public final void bVX() {
        if (!this.tWv.tXE) {
            bWe();
            this.hae.postDelayed(new 22(this, this.mController.xIM), 400);
        }
    }

    public final void a(WXRTEditText wXRTEditText) {
        if (wXRTEditText != null) {
            boolean z;
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.jMd == null || com.tencent.mm.plugin.wenote.model.nativenote.manager.f.jMd.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                ArrayList bWE = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bWE();
                if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().ab(bWE)) {
                    bVZ();
                    return;
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(bWE, wXRTEditText, true, true, true, false, false);
                int bWO = wXRTEditText.bWO();
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().er(bWO, (bWE.size() + bWO) + 1);
                bWe();
                if (this.tWW) {
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXj();
                }
            }
        }
    }

    public final void bWI() {
        int dU = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dU(this.mController.xIM);
        if (dU == 2) {
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dT(this)) {
                bVZ();
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWq();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.f.aaS();
            com.tencent.mm.plugin.wenote.model.a.b hVar = new com.tencent.mm.plugin.wenote.model.a.h();
            hVar.content = "";
            hVar.tRt = false;
            hVar.tRz = false;
            hVar.tRv = 0;
            hVar.tRB = true;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(hVar);
            bXG();
        } else if (dU == 3) {
            ArrayList bWE = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bWE();
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().ab(bWE)) {
                bVZ();
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWq();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(bWE, null, false, true, false, false, false);
            bWe();
        }
    }

    public final void bWF() {
        com.tencent.mm.plugin.wenote.model.a.b hVar = new com.tencent.mm.plugin.wenote.model.a.h();
        hVar.content = "";
        hVar.tRt = true;
        hVar.tRz = false;
        hVar.tRv = 0;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWq();
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(hVar);
        bXG();
        f(true, 50);
        P(1, 0);
    }

    public final void bWG() {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(this.mController.xIM, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWx());
    }

    public final void bWH() {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(this.mController.xIM, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWx());
        bWF();
    }

    public final void ep(int i, int i2) {
        this.tWD = Math.abs(i2 - i) > 0;
    }

    public final void Bp(int i) {
        if (i >= 0 && i < com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().size()) {
            this.hae.post(new 24(this, i));
        }
    }

    public final void bVY() {
        this.hae.post(new 25(this));
    }

    public final void bVZ() {
        if (this.tQy || this.tWz) {
            bWe();
            if (this.tWW) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXf().bXj();
            }
            this.hae.postDelayed(new 26(this), 100);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.Note.NoteEditorUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    bWa();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void bWa() {
        com.tencent.mm.ui.base.h.a(this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 27(this), new 28(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar.getType() == 921) {
            if (kVar instanceof com.tencent.mm.plugin.wenote.model.b) {
                com.tencent.mm.plugin.wenote.model.b bVar = (com.tencent.mm.plugin.wenote.model.b) kVar;
                if (bVar.tQf == 1) {
                    com.tencent.mm.plugin.report.service.g gVar;
                    Object[] objArr;
                    if (i2 == 0) {
                        x.i("MicroMsg.Note.NoteEditorUI", "genlong pic , allow");
                        RecyclerView.a fm = this.Va.fm();
                        if (fm != null) {
                            int itemCount = fm.getItemCount();
                            int i3;
                            if (itemCount <= 0) {
                                aER();
                                Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eyn), 1).show();
                                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                objArr = new Object[5];
                                objArr[0] = Integer.valueOf(0);
                                objArr[1] = Integer.valueOf(0);
                                objArr[2] = Integer.valueOf(0);
                                objArr[3] = Integer.valueOf(1);
                                if (this.tWR) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                objArr[4] = Integer.valueOf(i3);
                                gVar.h(14811, objArr);
                            } else {
                                int i4;
                                int width;
                                Bitmap bitmap;
                                z zVar = new z(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);
                                i3 = 0;
                                for (i4 = 0; i4 < itemCount; i4++) {
                                    t d = fm.d(this.Va, fm.getItemViewType(i4));
                                    fm.a(d, i4);
                                    d.VU.measure(MeasureSpec.makeMeasureSpec(this.Va.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
                                    d.VU.layout(0, 0, d.VU.getMeasuredWidth(), d.VU.getMeasuredHeight());
                                    width = d.VU.getWidth();
                                    int height = d.VU.getHeight();
                                    if (width > 0 && height > 0) {
                                        try {
                                            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                                            try {
                                                d.VU.draw(new Canvas(createBitmap));
                                                zVar.put(String.valueOf(i4), createBitmap);
                                                i3 += d.VU.getMeasuredHeight();
                                            } catch (Throwable e) {
                                                x.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
                                                x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
                                                aER();
                                                Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eyn), 1).show();
                                                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                                objArr = new Object[5];
                                                objArr[0] = Integer.valueOf(0);
                                                objArr[1] = Integer.valueOf(0);
                                                objArr[2] = Integer.valueOf(0);
                                                objArr[3] = Integer.valueOf(1);
                                                objArr[4] = Integer.valueOf(this.tWR ? 1 : 0);
                                                gVar.h(14811, objArr);
                                            } catch (Throwable th) {
                                                x.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
                                                aER();
                                                Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eyn), 1).show();
                                                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                                objArr = new Object[5];
                                                objArr[0] = Integer.valueOf(0);
                                                objArr[1] = Integer.valueOf(0);
                                                objArr[2] = Integer.valueOf(0);
                                                objArr[3] = Integer.valueOf(2);
                                                if (this.tWR) {
                                                    i3 = 1;
                                                } else {
                                                    i3 = 0;
                                                }
                                                objArr[4] = Integer.valueOf(i3);
                                                gVar.h(14811, objArr);
                                            }
                                        } catch (Exception e2) {
                                            x.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
                                            aER();
                                            Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eyn), 1).show();
                                            gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                            objArr = new Object[5];
                                            objArr[0] = Integer.valueOf(0);
                                            objArr[1] = Integer.valueOf(0);
                                            objArr[2] = Integer.valueOf(0);
                                            objArr[3] = Integer.valueOf(2);
                                            if (this.tWR) {
                                                i3 = 1;
                                            } else {
                                                i3 = 0;
                                            }
                                            objArr[4] = Integer.valueOf(i3);
                                            gVar.h(14811, objArr);
                                        } catch (Throwable th2) {
                                            for (width = 0; width < i4; width++) {
                                                bitmap = (Bitmap) zVar.get(String.valueOf(width));
                                                if (!(bitmap == null || bitmap.isRecycled())) {
                                                    bitmap.recycle();
                                                }
                                            }
                                            aER();
                                            Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eyn), 1).show();
                                        }
                                    }
                                }
                                try {
                                    width = com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 14);
                                    Bitmap createBitmap2 = Bitmap.createBitmap(this.Va.getMeasuredWidth() + 0, i3 + width, Config.ARGB_8888);
                                    Canvas canvas = new Canvas(createBitmap2);
                                    canvas.drawColor(-1);
                                    width = com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 8);
                                    i4 = 0;
                                    while (i4 < itemCount) {
                                        bitmap = (Bitmap) zVar.get(String.valueOf(i4));
                                        if (bitmap != null) {
                                            canvas.drawBitmap(bitmap, 0.0f, (float) width, null);
                                            width += bitmap.getHeight();
                                            if (!bitmap.isRecycled()) {
                                                bitmap.recycle();
                                            }
                                        }
                                        i4++;
                                        width = width;
                                    }
                                    if (this.lTm != null && this.lTm.isShowing()) {
                                        aER();
                                        Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.dXO, new Object[]{com.tencent.mm.platformtools.d.Wc()}), 1).show();
                                        ar.Dm().F(new 29(this, createBitmap2));
                                    } else if (!(createBitmap2 == null || createBitmap2.isRecycled())) {
                                        createBitmap2.recycle();
                                    }
                                } catch (Throwable e3) {
                                    x.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
                                    x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e3, "", new Object[0]);
                                    aER();
                                    Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eyn), 1).show();
                                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                    objArr = new Object[5];
                                    objArr[0] = Integer.valueOf(0);
                                    objArr[1] = Integer.valueOf(0);
                                    objArr[2] = Integer.valueOf(0);
                                    objArr[3] = Integer.valueOf(1);
                                    objArr[4] = Integer.valueOf(this.tWR ? 1 : 0);
                                    gVar.h(14811, objArr);
                                } catch (Throwable th3) {
                                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                    objArr = new Object[5];
                                    objArr[0] = Integer.valueOf(0);
                                    objArr[1] = Integer.valueOf(0);
                                    objArr[2] = Integer.valueOf(0);
                                    objArr[3] = Integer.valueOf(2);
                                    objArr[4] = Integer.valueOf(this.tWR ? 1 : 0);
                                    gVar.h(14811, objArr);
                                    x.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
                                    aER();
                                    Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eyn), 1).show();
                                    for (width = 0; width < itemCount; width++) {
                                        bitmap = (Bitmap) zVar.get(String.valueOf(width));
                                        if (!(bitmap == null || bitmap.isRecycled())) {
                                            bitmap.recycle();
                                        }
                                    }
                                }
                            }
                        } else {
                            gVar = com.tencent.mm.plugin.report.service.g.pQN;
                            objArr = new Object[5];
                            objArr[0] = Integer.valueOf(0);
                            objArr[1] = Integer.valueOf(0);
                            objArr[2] = Integer.valueOf(0);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = Integer.valueOf(this.tWR ? 1 : 0);
                            gVar.h(14811, objArr);
                            aER();
                            Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eyn), 1).show();
                        }
                    } else {
                        gVar = com.tencent.mm.plugin.report.service.g.pQN;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(0);
                        objArr[1] = Integer.valueOf(0);
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(4);
                        objArr[4] = Integer.valueOf(this.tWR ? 1 : 0);
                        gVar.h(14811, objArr);
                        x.e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
                        aER();
                        Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eyn), 1).show();
                    }
                    this.tWs.tUp = bVar.tQj;
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().V(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().size() - 1, false);
                }
            }
        }
    }

    private void aER() {
        if (this.lTm != null) {
            this.lTm.dismiss();
            this.lTm = null;
        }
    }

    protected final String i(com.tencent.mm.plugin.fav.a.f fVar) {
        if (fVar != null) {
            try {
                return fVar.field_datatotalsize;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "getInfoLength [%s]", new Object[]{e.toString()});
            }
        }
        return super.i(fVar);
    }
}
