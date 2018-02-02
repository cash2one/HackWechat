package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.st;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.collect.b.b;
import com.tencent.mm.plugin.collect.b.d;
import com.tencent.mm.plugin.collect.b.d.a;
import com.tencent.mm.plugin.collect.b.t;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.asa;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class CollectMainUI extends WalletPreferenceUI implements a, av.a {
    private static int lmL;
    private static int lnc = -1;
    private static int lnd = -1;
    private static int lne = -1;
    private static int lnf = -1;
    private int fKy;
    private f jKn = null;
    protected ScrollView lkr = null;
    private long llS;
    private Bitmap lmA = null;
    protected String lmB = null;
    protected String lmC = null;
    protected String lmD = null;
    private String lmE = null;
    private List<a> lmF = new LinkedList();
    private double lmG;
    private String lmH = null;
    private String lmI = null;
    protected boolean lmJ = false;
    private long lmK;
    private View lmM;
    private b lmN = new b(this, (byte) 0);
    private SpannableStringBuilder lmO;
    private SpannableStringBuilder lmP;
    private com.tencent.mm.plugin.collect.b.f lmQ;
    private int lmR = 0;
    private String lmS;
    private String lmT;
    private String lmU;
    protected CdnImageView lmV;
    protected TextView lmW;
    protected TextView lmX;
    protected ImageView lmY;
    protected ViewGroup lmZ;
    private Vibrator lmg;
    private ImageView lmh = null;
    private TextView lmi = null;
    private WalletTextView lmj = null;
    private TextView lmk = null;
    private TextView lml = null;
    private TextView lmm = null;
    private View lmn = null;
    private TextView lmo = null;
    private Dialog lmp = null;
    private View lmq = null;
    private View lmr = null;
    private boolean lms = false;
    private View lmt = null;
    private ImageView lmu;
    private TextView lmv;
    private TextView lmw;
    private TextView lmx;
    protected TextView lmy;
    private RelativeLayout lmz;
    protected View lna;
    private j.a lnb = new 11(this);

    static /* synthetic */ void a(CollectMainUI collectMainUI, aqz com_tencent_mm_protocal_c_aqz) {
        if (com_tencent_mm_protocal_c_aqz == null || bh.ov(com_tencent_mm_protocal_c_aqz.fyY)) {
            x.i("MicroMsg.CollectMainUI", "empty item return");
            return;
        }
        g.Dk();
        String str = (String) g.Dj().CU().get(w.a.xwt, "");
        if (bh.ov(str)) {
            collectMainUI.lmV.setVisibility(8);
        } else {
            collectMainUI.lmV.setUrl(str);
            collectMainUI.lmV.setVisibility(0);
        }
        collectMainUI.lmW.setText(com_tencent_mm_protocal_c_aqz.fyY);
        if (bh.ov(com_tencent_mm_protocal_c_aqz.wyS)) {
            collectMainUI.lmX.setVisibility(4);
        } else {
            collectMainUI.lmX.setText(com_tencent_mm_protocal_c_aqz.wyS);
            collectMainUI.lmX.setVisibility(0);
        }
        if (com_tencent_mm_protocal_c_aqz.wyT == 1) {
            collectMainUI.lmY.setVisibility(0);
        } else {
            collectMainUI.lmY.setVisibility(8);
        }
        if (com_tencent_mm_protocal_c_aqz.type == 1) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(1), com_tencent_mm_protocal_c_aqz.fyY, "", "", "", Integer.valueOf(1)});
            if (com_tencent_mm_protocal_c_aqz.wyT == 1) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14526, new Object[]{Integer.valueOf(3), Integer.valueOf(1), com_tencent_mm_protocal_c_aqz.fyY, "", "", "", Integer.valueOf(1)});
            }
        } else if (com_tencent_mm_protocal_c_aqz.type == 2) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(2), com_tencent_mm_protocal_c_aqz.fyY, "", "", com_tencent_mm_protocal_c_aqz.url, Integer.valueOf(1)});
            if (com_tencent_mm_protocal_c_aqz.wyT == 1) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14526, new Object[]{Integer.valueOf(3), Integer.valueOf(2), com_tencent_mm_protocal_c_aqz.fyY, "", "", com_tencent_mm_protocal_c_aqz.url, Integer.valueOf(1)});
            }
        } else if (com_tencent_mm_protocal_c_aqz.type == 3) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(3), com_tencent_mm_protocal_c_aqz.fyY, com_tencent_mm_protocal_c_aqz.wyQ, com_tencent_mm_protocal_c_aqz.wyR, "", Integer.valueOf(1)});
            if (com_tencent_mm_protocal_c_aqz.wyT == 1) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14526, new Object[]{Integer.valueOf(3), Integer.valueOf(3), com_tencent_mm_protocal_c_aqz.fyY, com_tencent_mm_protocal_c_aqz.wyQ, com_tencent_mm_protocal_c_aqz.wyR, "", Integer.valueOf(1)});
            }
        }
        collectMainUI.lmZ.setOnClickListener(new 9(collectMainUI, com_tencent_mm_protocal_c_aqz));
    }

    static /* synthetic */ void b(CollectMainUI collectMainUI) {
        boolean z = false;
        if (collectMainUI.lmA == null || collectMainUI.lmA.isRecycled()) {
            x.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
            Toast.makeText(collectMainUI.mController.xIM, collectMainUI.getString(i.uIS), 1).show();
        } else {
            Context context = collectMainUI;
            Bitmap a = b.a(context, collectMainUI.lmB, q.FS(), collectMainUI.lmR, collectMainUI.lmU, false, BackwardSupportUtil.b.b(collectMainUI, 197.0f), collectMainUI.lnb);
            if (!(a == null || a.isRecycled())) {
                int i;
                if (collectMainUI.lmJ) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11343, new Object[]{Integer.valueOf(1), Integer.valueOf((int) Math.round(collectMainUI.lmG * 100.0d))});
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11343, new Object[]{Integer.valueOf(0)});
                }
                if (collectMainUI.lms) {
                    i = 0;
                } else {
                    collectMainUI.lkr = (ScrollView) ((ViewStub) collectMainUI.findViewById(com.tencent.mm.plugin.wxpay.a.f.uiL)).inflate();
                    collectMainUI.azr();
                    collectMainUI.lms = true;
                    i = 250;
                }
                collectMainUI.lkr.setVisibility(4);
                ((ImageView) collectMainUI.lkr.findViewById(com.tencent.mm.plugin.wxpay.a.f.uiG)).setImageBitmap(collectMainUI.lmA);
                TextView textView = (TextView) collectMainUI.lkr.findViewById(com.tencent.mm.plugin.wxpay.a.f.uiI);
                TextView textView2 = (TextView) collectMainUI.lkr.findViewById(com.tencent.mm.plugin.wxpay.a.f.uiJ);
                LinearLayout linearLayout = (LinearLayout) collectMainUI.lkr.findViewById(com.tencent.mm.plugin.wxpay.a.f.uiW);
                LinearLayout linearLayout2 = (LinearLayout) collectMainUI.lkr.findViewById(com.tencent.mm.plugin.wxpay.a.f.uiF);
                TextView textView3 = (TextView) collectMainUI.lkr.findViewById(com.tencent.mm.plugin.wxpay.a.f.uiC);
                TextView textView4 = (TextView) collectMainUI.lkr.findViewById(com.tencent.mm.plugin.wxpay.a.f.uiD);
                TextView textView5 = (TextView) collectMainUI.lkr.findViewById(com.tencent.mm.plugin.wxpay.a.f.uiE);
                CharSequence dC = e.dC(e.gu(q.FS()), 10);
                if (!bh.ov(collectMainUI.azp())) {
                    dC = dC + collectMainUI.getString(i.uIN, new Object[]{r11});
                }
                if (collectMainUI.lmR != 1) {
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(collectMainUI, dC, textView.getTextSize()));
                } else if (bh.ov(collectMainUI.lmT)) {
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(collectMainUI, dC, textView.getTextSize()));
                } else {
                    textView.setText(collectMainUI.lmT);
                    textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(collectMainUI, dC, textView2.getTextSize()));
                    textView2.setVisibility(0);
                }
                if (collectMainUI.lmJ) {
                    if (bh.ov(collectMainUI.lmI)) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setText(collectMainUI.lmI);
                        textView4.setVisibility(0);
                    }
                    textView3.setText(collectMainUI.azq());
                    textView5.setText(e.t(collectMainUI.lmG));
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout2.setVisibility(8);
                }
                ag.h(new 5(collectMainUI, linearLayout), (long) i);
                z = true;
            }
            if (!z) {
                Toast.makeText(collectMainUI.mController.xIM, collectMainUI.getString(i.uIS), 1).show();
            }
        }
        collectMainUI.yjd.notifyDataSetChanged();
    }

    static /* synthetic */ void u(CollectMainUI collectMainUI) {
        collectMainUI.llS &= -32769;
        g.Dk();
        g.Dj().CU().set(147457, Long.valueOf(collectMainUI.llS));
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_asa = new asa();
        com_tencent_mm_protocal_c_asa.pQk = 2;
        ((h) g.h(h.class)).EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(c.CTRL_INDEX, com_tencent_mm_protocal_c_asa));
        com.tencent.mm.plugin.collect.a.a.ayE().ayI();
    }

    static /* synthetic */ void v(CollectMainUI collectMainUI) {
        collectMainUI.llS |= 32768;
        g.Dk();
        g.Dj().CU().set(147457, Long.valueOf(collectMainUI.llS));
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_asa = new asa();
        com_tencent_mm_protocal_c_asa.pQk = 1;
        ((h) g.h(h.class)).EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(c.CTRL_INDEX, com_tencent_mm_protocal_c_asa));
        com.tencent.mm.plugin.collect.a.a.ayE().ayH();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uaw)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(com.tencent.mm.plugin.wxpay.a.f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsL));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.white));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uax));
        }
        g.Dk();
        this.fKy = ((Integer) g.Dj().CU().get(w.a.xrD, Integer.valueOf(0))).intValue();
        this.llS = q.FX();
        int intExtra = getIntent().getIntExtra("key_from_scene", 1);
        com.tencent.mm.plugin.report.service.g.pQN.h(14021, new Object[]{Integer.valueOf(2), Integer.valueOf(intExtra)});
        g.Dk();
        boolean equals = ((String) g.Dj().CU().get(327731, "0")).equals("0");
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bqB, com.tencent.mm.plugin.wxpay.a.a.bqA);
        if (equals) {
            com.tencent.mm.ui.base.h.a(this.mController.xIM, q.Gf() ? i.uID : i.uIC, i.uIE, new 1(this));
            g.Dk();
            g.Dj().CU().set(327731, "1");
            g.Dk();
            g.Dj().CU().lH(true);
        }
        com.tencent.mm.plugin.collect.a.a.ayE();
        d ayF = com.tencent.mm.plugin.collect.a.a.ayF();
        if (!ayF.kIv.contains(this)) {
            ayF.kIv.add(this);
        }
        initView();
        azo();
        amg();
        this.lmg = (Vibrator) getSystemService("vibrator");
        this.lmK = bh.Wo();
        if (lnc < 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            lnc = (displayMetrics.widthPixels / 2) - BackwardSupportUtil.b.b(this.mController.xIM, 20.0f);
            lnd = BackwardSupportUtil.b.b(this.mController.xIM, 60.0f);
            lne = BackwardSupportUtil.b.b(this.mController.xIM, 40.0f);
            lnf = BackwardSupportUtil.b.b(this.mController.xIM, 70.0f);
        }
        azt();
        p.ft(16, 0);
    }

    protected void onDestroy() {
        if (this.lmh != null) {
            this.lmh.setImageBitmap(null);
        }
        Bitmap bitmap = this.lmA;
        if (!(bitmap == null || bitmap.isRecycled())) {
            x.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[]{bitmap});
            bitmap.recycle();
        }
        if (this.lmp != null) {
            this.lmp.dismiss();
        }
        com.tencent.mm.plugin.collect.a.a.ayE();
        com.tencent.mm.plugin.collect.a.a.ayF().kIv.remove(this);
        this.lmg.cancel();
        if (this.lmQ != null) {
            com.tencent.mm.ae.e eVar = this.lmQ;
            for (Entry entry : eVar.gKa.entrySet()) {
                x.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
                g.Dk();
                g.Di().gPJ.c((k) entry.getKey());
            }
            eVar.gKa.clear();
            g.Dk();
            g.Di().gPJ.b(1588, eVar);
        }
        j.c(this.lnb);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.uMa);
        setBackBtn(new 12(this));
        this.jKn = this.yjd;
        this.lmn = findViewById(com.tencent.mm.plugin.wxpay.a.f.uiy);
        this.lna = findViewById(com.tencent.mm.plugin.wxpay.a.f.uiz);
        this.lmj = (WalletTextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiq);
        this.lmi = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uip);
        this.lmk = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uir);
        this.lml = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uix);
        this.lmy = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.ufy);
        this.lmq = (RelativeLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiw);
        this.lmr = findViewById(com.tencent.mm.plugin.wxpay.a.f.uiu);
        this.lmM = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uBA, null, false);
        this.lmm = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiH);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(i.uiH));
        spannableStringBuilder.setSpan(new l(new 13(this)), 0, spannableStringBuilder.length(), 18);
        this.lmm.setText(spannableStringBuilder);
        this.lmm.setClickable(true);
        this.lmm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.l(this));
        this.nKG.addFooterView(this.lmM, null, false);
        this.nKG.setFooterDividersEnabled(false);
        this.lmh = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uit);
        this.lmo = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiM);
        this.lmx = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiX);
        this.lmx.setClickable(true);
        this.lmx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.l(this));
        this.lmO = new SpannableStringBuilder(getString(i.uIF));
        this.lmP = new SpannableStringBuilder(getString(i.uIG));
        l lVar = new l(new 14(this));
        l lVar2 = new l(new 15(this));
        this.lmO.setSpan(lVar, 0, this.lmO.length(), 18);
        if (com.tencent.mm.ui.a.a.a.cnI().cnH()) {
            this.lmx.setOnClickListener(new 16(this, lVar, lVar2));
        }
        this.lmP.setSpan(lVar2, 0, this.lmP.length(), 18);
        this.lmx.setText(this.lmO);
        this.lmz = (RelativeLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiN);
        this.lmh.setOnLongClickListener(new 17(this));
        this.lmt = findViewById(com.tencent.mm.plugin.wxpay.a.f.uiA);
        this.lmu = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiP);
        this.lmv = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiR);
        this.lmw = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiQ);
        this.lmV = (CdnImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uhO);
        this.lmW = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uhR);
        this.lmX = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uhS);
        this.lmY = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uhQ);
        this.lmZ = (ViewGroup) findViewById(com.tencent.mm.plugin.wxpay.a.f.uhP);
        this.lmq.postDelayed(new 18(this), 300);
        com.tencent.mm.sdk.b.b stVar = new st();
        stVar.fKA.fKC = "8";
        stVar.fqI = new 2(this, stVar);
        com.tencent.mm.sdk.b.a.xef.m(stVar);
    }

    protected final void amg() {
        if (bh.ov(this.lmB)) {
            x.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
            return;
        }
        if (this.lmR == 1) {
            if (!bh.ov(this.lmS)) {
                this.lmo.setText(this.lmS);
            }
            if (!bh.ov(this.lmT)) {
                TextView textView = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uiv);
                textView.setText(this.lmT);
                textView.setVisibility(0);
            }
        }
        azs();
        azu();
        au bLf = com.tencent.mm.plugin.wallet_core.model.i.bLf();
        int i = this.lmJ ? 33 : 32;
        if (bLf != null) {
            com.tencent.mm.plugin.report.service.g.pQN.h(13447, new Object[]{Integer.valueOf(i), bLf.vFP, bLf.vFQ, this.lmB, Double.valueOf(this.lmG), Long.valueOf(bh.Wo()), Long.valueOf(bLf.vFO), bLf.vFR, bLf.vFS});
        }
    }

    protected void azs() {
        this.lmh.setImageBitmap(null);
        if (this.lmJ) {
            if (bh.ov(this.lmE)) {
                x.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
                return;
            }
            this.lmA = xu(this.lmE);
        } else if (bh.ov(this.lmB)) {
            x.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
            return;
        } else {
            this.lmA = xu(this.lmB);
        }
        if (this.lmA == null || this.lmA.isRecycled()) {
            x.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bh.ou(this.lmE));
        } else {
            this.lmh.setImageBitmap(this.lmA);
        }
        if (this.lmJ) {
            this.lmj.mPrefix = azq();
            this.lmj.setText(e.t(this.lmG));
            this.lmj.setVisibility(0);
            if (bh.ov(this.lmI)) {
                this.lmi.setVisibility(8);
            } else {
                this.lmi.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.mController.xIM, this.lmI, this.lmi.getTextSize()));
                this.lmi.setVisibility(0);
            }
            findViewById(com.tencent.mm.plugin.wxpay.a.f.uis).setVisibility(0);
            return;
        }
        this.lmk.setVisibility(8);
        this.lmj.setVisibility(8);
        this.lmi.setVisibility(8);
        findViewById(com.tencent.mm.plugin.wxpay.a.f.uis).setVisibility(8);
    }

    private void azt() {
        getWindow().getDecorView().post(new Runnable(this) {
            final /* synthetic */ CollectMainUI lnh;

            {
                this.lnh = r1;
            }

            public final void run() {
                int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.lnh.mController.xIM, 37);
                ViewGroup.LayoutParams layoutParams = this.lnh.lmM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fromDPToPix;
                    this.lnh.lmM.setLayoutParams(layoutParams);
                    this.lnh.lmM.requestLayout();
                }
            }
        });
    }

    private void azu() {
        double d;
        if (this.lmF == null || this.lmF.size() <= 0) {
            d = 0.0d;
        } else {
            this.lmq.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ucA);
            this.jKn.removeAll();
            d = 0.0d;
            for (int i = 0; i < this.lmF.size(); i++) {
                Preference cVar;
                a aVar = (a) this.lmF.get(i);
                String valueOf = String.valueOf(i);
                if (i == this.lmF.size() - 1) {
                    cVar = new c(this, com.tencent.mm.plugin.wxpay.a.g.uBC);
                } else {
                    cVar = new c(this);
                }
                cVar.setKey(valueOf);
                valueOf = aVar.gBL;
                if (bh.ov(valueOf) && !bh.ov(aVar.username)) {
                    valueOf = e.gu(aVar.username);
                }
                cVar.mTitle = valueOf;
                cVar.gAb = aVar.username;
                if (aVar.status == 0) {
                    cVar.setSummary(i.uIL);
                } else if (aVar.status == 1) {
                    if (aVar.kSa) {
                        d += aVar.ljg;
                        cVar.setSummary(e.d(aVar.ljg, aVar.fpP));
                    } else {
                        cVar.setSummary(i.uIK);
                    }
                    this.jKn.a(cVar);
                } else if (aVar.status == 2) {
                    cVar.setSummary(i.uIJ);
                }
                this.jKn.a(cVar);
            }
            this.jKn.notifyDataSetChanged();
            this.lml.setText(e.d(d, ((a) this.lmF.get(0)).fpP));
            this.lml.setVisibility(0);
        }
        if (this.lmF == null || this.lmF.size() <= 0) {
            this.lml.setVisibility(8);
            this.lmn.setVisibility(8);
            this.lmr.setVisibility(8);
            return;
        }
        this.lmZ.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ucB);
        this.lmn.setVisibility(0);
        if (d > 0.0d && this.lmF.size() > 0) {
            this.lna.setVisibility(0);
            this.lmr.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uBz;
    }

    public final int XB() {
        return com.tencent.mm.plugin.wxpay.a.l.vap;
    }

    public final int asz() {
        return com.tencent.mm.plugin.wxpay.a.g.uBB;
    }

    public boolean g(int i, int i2, String str, k kVar) {
        return false;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    private Bitmap xu(String str) {
        return b.a(this, str, q.FS(), this.lmR, this.lmU, true, BackwardSupportUtil.b.b(this, 197.0f), this.lnb);
    }

    public final void b(t tVar) {
        Object obj = null;
        x.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
        if (((this.fKy == 1 || this.fKy == 0) && tVar.msgType == 9) || (this.fKy == 8 && tVar.msgType == 26)) {
            if (this.lmg != null) {
                this.lmg.vibrate(50);
            }
            if (((long) tVar.cRJ) < this.lmK) {
                x.d("MicroMsg.CollectMainUI", "Recieve but time out ");
                return;
            }
            Object obj2;
            int i = 0;
            while (i < this.lmF.size()) {
                if (tVar.status == 0 && bh.ou(tVar.username).equals(((a) this.lmF.get(i)).username) && ((a) this.lmF.get(i)).status == 2) {
                    this.lmF.remove(i);
                    this.lmF.add(i, new a(this, tVar));
                    obj2 = 1;
                    break;
                } else if (tVar.fuI.equals(((a) this.lmF.get(i)).fuI)) {
                    x.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + tVar.fuI);
                    if (((a) this.lmF.get(i)).status == 0) {
                        ((a) this.lmF.get(i)).status = tVar.status;
                        ((a) this.lmF.get(i)).ljg = tVar.ljg;
                        ((a) this.lmF.get(i)).fpP = tVar.fpP;
                        if (tVar.status == 1) {
                            a aVar = (a) this.lmF.get(i);
                            this.lmN.lnr.add(aVar);
                        }
                    }
                    int i2 = 1;
                } else {
                    i++;
                }
            }
            obj2 = null;
            if (obj2 == null) {
                for (i = 0; i < this.lmF.size(); i++) {
                    if (tVar.cRJ > ((t) this.lmF.get(i)).cRJ) {
                        this.lmF.add(i, new a(this, tVar));
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    this.lmF.add(new a(this, tVar));
                }
            }
            ag.y(new 4(this));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                if (i2 != -1 || intent == null) {
                    this.lmJ = false;
                } else {
                    this.lmE = intent.getStringExtra("ftf_pay_url");
                    this.lmG = intent.getDoubleExtra("ftf_fixed_fee", 0.0d);
                    this.lmH = intent.getStringExtra("ftf_fixed_fee_type");
                    this.lmI = intent.getStringExtra("ftf_fixed_desc");
                    this.lmD = intent.getStringExtra("key_currency_unit");
                    this.lmx.setText(this.lmP);
                    this.lmJ = true;
                }
                amg();
                azt();
                return;
            case 4097:
                this.llS = q.FX();
                return;
            default:
                return;
        }
    }

    protected void onResume() {
        super.onResume();
        av.a(this);
    }

    protected void onPause() {
        super.onPause();
        av.a(null);
    }

    public final void alG() {
        x.i("MicroMsg.CollectMainUI", "do screen shot");
        com.tencent.mm.plugin.report.service.g.pQN.h(13944, new Object[]{Integer.valueOf(9)});
        com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(i.uIQ), "", getString(i.uIP), getString(i.dEn), false, new OnClickListener(this) {
            final /* synthetic */ CollectMainUI lnh;

            {
                this.lnh = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                CollectMainUI.b(this.lnh);
                com.tencent.mm.plugin.report.service.g.pQN.h(13944, new Object[]{Integer.valueOf(10)});
            }
        }, new OnClickListener(this) {
            final /* synthetic */ CollectMainUI lnh;

            {
                this.lnh = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public void finish() {
        super.finish();
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bqz, com.tencent.mm.plugin.wxpay.a.a.bqC);
    }

    protected void azo() {
        this.lmQ = new com.tencent.mm.plugin.collect.b.f();
        com.tencent.mm.ae.e eVar = this.lmQ;
        g.Dk();
        g.Di().gPJ.a(1588, eVar);
        com.tencent.mm.plugin.collect.b.f fVar = this.lmQ;
        com.tencent.mm.plugin.collect.b.f.a anonymousClass8 = new com.tencent.mm.plugin.collect.b.f.a(this) {
            final /* synthetic */ CollectMainUI lnh;

            {
                this.lnh = r1;
            }

            public final void ca(String str, String str2) {
                x.i("MicroMsg.CollectMainUI", "get cache: %s, %s", new Object[]{str, str2});
                this.lnh.lmB = str;
                this.lnh.lmC = str2;
                aqz q = CollectMainUI.azv();
                List r = CollectMainUI.azw();
                CollectMainUI.a(this.lnh, q);
                this.lnh.az(r);
                if (this.lnh.fKy == 1) {
                    CollectMainUI collectMainUI = this.lnh;
                    g.Dk();
                    collectMainUI.lmR = ((Integer) g.Dj().CU().get(w.a.xxa, Integer.valueOf(-1))).intValue();
                    collectMainUI = this.lnh;
                    g.Dk();
                    collectMainUI.lmU = (String) g.Dj().CU().get(w.a.xxb, "");
                }
            }

            public final void a(boolean z, la laVar) {
                x.i("MicroMsg.CollectMainUI", "get from cgi: %s", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    this.lnh.lmB = laVar.url;
                    this.lnh.lmC = laVar.sKt;
                    this.lnh.lmR = laVar.pLj;
                    this.lnh.lmT = laVar.pLk;
                    this.lnh.lmU = laVar.pLl;
                    this.lnh.lmS = laVar.vTP;
                    CollectMainUI.a(this.lnh, laVar.vTM);
                    this.lnh.az(laVar.vTL);
                    g.Dk();
                    g.Dj().CU().a(w.a.xxa, Integer.valueOf(this.lnh.lmR));
                    g.Dk();
                    g.Dj().CU().a(w.a.xxb, this.lnh.lmU);
                    this.lnh.amg();
                }
            }
        };
        g.Dk();
        String str = (String) g.Dj().CU().get(w.a.xwq, "");
        g.Dk();
        String str2 = (String) g.Dj().CU().get(w.a.xwr, "");
        if (bh.ov(str)) {
            x.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
            str = o.bLq().bLP();
        }
        anonymousClass8.ca(str, str2);
        k lVar = new com.tencent.mm.plugin.collect.b.l();
        fVar.gKa.put(lVar, anonymousClass8);
        g.Dk();
        g.Di().gPJ.a(lVar, 0);
    }

    private static aqz azv() {
        try {
            g.Dk();
            return F(new JSONObject((String) g.Dj().CU().get(w.a.xws, "")));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
            return null;
        }
    }

    private static List<aqz> azw() {
        List<aqz> arrayList = new ArrayList();
        try {
            g.Dk();
            String str = (String) g.Dj().CU().get(w.a.xwu, "");
            if (!bh.ov(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(F(jSONArray.getJSONObject(i)));
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
        }
        return arrayList;
    }

    private static aqz F(JSONObject jSONObject) {
        aqz com_tencent_mm_protocal_c_aqz = new aqz();
        com_tencent_mm_protocal_c_aqz.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE, -1);
        com_tencent_mm_protocal_c_aqz.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
        com_tencent_mm_protocal_c_aqz.fyY = jSONObject.optString("wording", "");
        com_tencent_mm_protocal_c_aqz.wyQ = jSONObject.optString("waapp_username", "");
        com_tencent_mm_protocal_c_aqz.wyR = jSONObject.optString("waapp_path", "");
        return com_tencent_mm_protocal_c_aqz;
    }

    protected String azp() {
        if (bh.ov(this.lmC)) {
            this.lmC = o.bLq().azp();
            this.lmC = e.aaA(this.lmC);
        }
        return this.lmC;
    }

    protected String azq() {
        return e.aax(this.lmH);
    }

    protected final void az(List<aqz> list) {
        if (list != null) {
            for (aqz com_tencent_mm_protocal_c_aqz : list) {
                if (com_tencent_mm_protocal_c_aqz.type == 1) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(1), com_tencent_mm_protocal_c_aqz.fyY, "", "", "", Integer.valueOf(1)});
                } else if (com_tencent_mm_protocal_c_aqz.type == 2) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(2), com_tencent_mm_protocal_c_aqz.fyY, "", "", com_tencent_mm_protocal_c_aqz.url, Integer.valueOf(1)});
                } else if (com_tencent_mm_protocal_c_aqz.type == 3) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(3), com_tencent_mm_protocal_c_aqz.fyY, com_tencent_mm_protocal_c_aqz.wyQ, com_tencent_mm_protocal_c_aqz.wyR, "", Integer.valueOf(1)});
                }
            }
        }
        this.lmz.setOnClickListener(new 10(this, list));
    }

    protected void azr() {
    }
}
