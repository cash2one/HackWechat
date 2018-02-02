package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.b.ab;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.luckymoney.particles.a.a;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private View Lr;
    private long kCY = 0;
    private boolean lAx = false;
    private View lBB;
    private ImageView lVz;
    private TextView lkn;
    private TextView lmo;
    private SoundPool nYQ;
    private b oao = new b(this) {
        final /* synthetic */ LuckyMoneyDetailUI ohM;

        {
            this.ohM = r1;
        }

        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            switch (random.nextInt(8)) {
                case 0:
                    if (this.ohM.ohH == null) {
                        this.ohM.ohH = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.ohM.getResources(), e.ucT), 28, 28, false);
                    }
                    return new a(this.ohM.ohH);
                case 1:
                    if (this.ohM.ohI == null) {
                        this.ohM.ohI = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.ohM.getResources(), e.ucU), 28, 28, false);
                    }
                    return new a(this.ohM.ohI);
                case 2:
                    if (this.ohM.ohJ == null) {
                        this.ohM.ohJ = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.ohM.getResources(), e.ucV), 28, 28, false);
                    }
                    return new a(this.ohM.ohJ);
                case 3:
                    if (this.ohM.ohC == null) {
                        this.ohM.ohC = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.ohM.getResources(), e.ucO), 28, 28, false);
                    }
                    return new a(this.ohM.ohC);
                case 4:
                    if (this.ohM.ohD == null) {
                        this.ohM.ohD = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.ohM.getResources(), e.ucP), 28, 28, false);
                    }
                    return new a(this.ohM.ohD);
                case 5:
                    if (this.ohM.ohE == null) {
                        this.ohM.ohE = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.ohM.getResources(), e.ucQ), 28, 28, false);
                    }
                    return new a(this.ohM.ohE);
                case 6:
                    if (this.ohM.ohF == null) {
                        this.ohM.ohF = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.ohM.getResources(), e.ucR), 28, 28, false);
                    }
                    return new a(this.ohM.ohF);
                case 7:
                    if (this.ohM.ohG == null) {
                        this.ohM.ohG = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.ohM.getResources(), e.ucS), 28, 28, false);
                    }
                    return new a(this.ohM.ohG);
                default:
                    return null;
            }
        }
    };
    private int ocg = -1;
    private View ogA;
    private boolean ogC = true;
    private int ogD;
    private String ogE;
    private String ogF;
    private String ogG;
    private String ogH;
    private List<m> ogJ = new LinkedList();
    private Map<String, Integer> ogK = new HashMap();
    private i ogL;
    private String ogM = "";
    private boolean ogN = false;
    OnScrollListener ogO = new 1(this);
    private ListView ogr;
    private ImageView ogs;
    private TextView ogt;
    private TextView ogu;
    private View ogv;
    private TextView ogw;
    private LuckyMoneyWishFooter ogx;
    private View ogy;
    private ImageView ogz;
    private int[] ohA;
    private ViewGroup ohB;
    private Bitmap ohC;
    private Bitmap ohD;
    private Bitmap ohE;
    private Bitmap ohF;
    private Bitmap ohG;
    private Bitmap ohH;
    private Bitmap ohI;
    private Bitmap ohJ;
    private final int ohK = 750;
    private final int ohL = 240;
    private ImageView oht;
    private ImageView ohu;
    private View ohv;
    private ImageView ohw;
    private TextView ohx;
    private View ohy;
    private RelativeLayout ohz;
    private int wn = 0;

    static /* synthetic */ void w(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = luckyMoneyDetailUI.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            x.i("MicroMsg.LuckyMoneyDetailUI", "hy: screen  width: %d, scale : %f, fixedHeight: %d", new Object[]{Integer.valueOf(displayMetrics.widthPixels), Double.valueOf(((double) displayMetrics.widthPixels) / 750.0d), Integer.valueOf((int) (240.0d * (((double) displayMetrics.widthPixels) / 750.0d)))});
            luckyMoneyDetailUI.ohz.setLayoutParams(new LayoutParams(luckyMoneyDetailUI.ohz.getLayoutParams().width, r1));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.ogE = getIntent().getStringExtra("key_sendid");
        this.ogG = getIntent().getStringExtra("key_native_url");
        this.ogD = getIntent().getIntExtra("key_jump_from", 2);
        x.i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + bh.ou(this.ogE) + ", nativeurl=" + bh.ou(this.ogG) + ", jumpFrom=" + this.ogD);
        if (this.ogD == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (byteArrayExtra != null) {
                    com.tencent.mm.plugin.luckymoney.b.e eVar = (com.tencent.mm.plugin.luckymoney.b.e) new com.tencent.mm.plugin.luckymoney.b.e().aF(byteArrayExtra);
                    if (eVar != null) {
                        a(eVar);
                        if (getIntent().getBooleanExtra("play_sound", false)) {
                            k.H(this, a$i.uJH);
                        }
                        addTextOptionMenu(0, getString(a$i.uJM), new 13(this));
                    }
                }
            } catch (Exception e) {
                x.w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bh.ov(this.ogE) && !bh.ov(this.ogG)) {
            try {
                this.ogE = Uri.parse(this.ogG).getQueryParameter("sendid");
            } catch (Exception e2) {
            }
        }
        if (bh.ov(this.ogE)) {
            x.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
        } else {
            aXA();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
            k.H(this, a$i.uJH);
        }
        addTextOptionMenu(0, getString(a$i.uJM), new 13(this));
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        TextView textView = (TextView) findViewById(f.bIK);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(c.uaS));
        }
        return onCreatePanelMenu;
    }

    protected void onResume() {
        super.onResume();
        this.kCY = bh.Wo();
    }

    protected void onPause() {
        super.onPause();
        d.f("LuckyMoneyDetailUI", this.kCY, bh.Wo());
    }

    protected final void initView() {
        setMMTitle(a$i.uJO);
        setBackBtn(new 14(this));
        this.ogr = (ListView) findViewById(f.uns);
        this.ogL = new i(this.mController.xIM);
        this.Lr = LayoutInflater.from(this).inflate(a$g.uCp, null);
        this.ogr.addHeaderView(this.Lr);
        this.ogr.setAdapter(this.ogL);
        this.Lr.setOnClickListener(new 15(this));
        this.ogr.setOnScrollListener(this.ogO);
        this.ogr.setOnItemClickListener(new 16(this));
        this.lBB = LayoutInflater.from(this).inflate(a$g.uCo, null);
        this.ogs = (ImageView) this.Lr.findViewById(f.unu);
        this.ogt = (TextView) this.Lr.findViewById(f.unx);
        this.oht = (ImageView) this.Lr.findViewById(f.unf);
        this.ogu = (TextView) this.Lr.findViewById(f.unz);
        this.ogv = this.Lr.findViewById(f.umY);
        this.ogw = (TextView) this.Lr.findViewById(f.umX);
        this.ogy = this.Lr.findViewById(f.unh);
        this.lmo = (TextView) this.Lr.findViewById(f.unv);
        this.ogz = (ImageView) this.Lr.findViewById(f.ung);
        this.lkn = (TextView) this.Lr.findViewById(f.unb);
        this.ohu = (ImageView) this.Lr.findViewById(f.unw);
        this.ogA = this.Lr.findViewById(f.unq);
        this.ohv = this.Lr.findViewById(f.una);
        this.ohw = (ImageView) this.Lr.findViewById(f.umZ);
        this.ohx = (TextView) this.Lr.findViewById(f.uni);
        this.ohy = findViewById(f.unj);
        this.ohz = (RelativeLayout) this.Lr.findViewById(f.una);
        this.lVz = (ImageView) this.Lr.findViewById(f.umZ);
        this.ogx = (LuckyMoneyWishFooter) findViewById(f.uny);
        this.ohB = (ViewGroup) findViewById(f.unD);
        this.ogx.a(new 17(this));
        this.ogx.a(new 18(this));
        this.ogx.post(new 19(this));
        this.ogx.xGO = new KeyboardLinearLayout.a(this) {
            final /* synthetic */ LuckyMoneyDetailUI ohM;

            {
                this.ohM = r1;
            }

            public final void qI(int i) {
                if (i == -2 && this.ohM.ogx.oky) {
                    this.ohM.ogx.oky = false;
                }
            }
        };
        this.ogL.okd = new 3(this);
        this.ogx.aXR();
        this.ohx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI ohM;

            {
                this.ohM = r1;
            }

            public final void onClick(View view) {
                this.ohM.ogx.setVisibility(0);
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.ogx.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.ogx.setVisibility(8);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof v) {
            if (i == 0 && i2 == 0) {
                v vVar = (v) kVar;
                com.tencent.mm.plugin.luckymoney.b.e eVar = vVar.ocQ;
                this.ogM = vVar.odd;
                a(eVar);
                return true;
            }
            h.bu(this, str);
            return true;
        } else if (kVar instanceof ab) {
            if (i == 0 && i2 == 0) {
                h.bu(this, getString(a$i.epb));
                this.ogL.okc = false;
                aXB();
                ab abVar = (ab) kVar;
                if (this.ogJ != null) {
                    for (int i3 = 0; i3 < this.ogJ.size(); i3++) {
                        m mVar = (m) this.ogJ.get(i3);
                        if (mVar.obV.equalsIgnoreCase(abVar.obV)) {
                            mVar.ocF = abVar.obN;
                            this.ogL.notifyDataSetChanged();
                            break;
                        }
                    }
                    if (this.ohx.getVisibility() == 0) {
                        this.ohx.setVisibility(8);
                        this.lkn.setVisibility(0);
                        this.ohy.setVisibility(8);
                        this.ogL.bd(this.ogJ);
                    }
                }
                return true;
            }
            h.bu(this, str);
            return true;
        } else if (!(kVar instanceof ag)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.snackbar.a.h(this, getString(a$i.epb));
                return true;
            }
            h.bu(this, str);
            return true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bh.ov(stringExtra)) {
                        if (this.ogH != null && this.ogH.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            x.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            l(new ag(stringExtra.replaceAll(",", "|"), this.ogE, "v1.0"));
                            break;
                        }
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void finish() {
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            boolean b = realnameGuideHelper.b(this, bundle, new 5(this));
            getIntent().removeExtra("key_realname_guide_helper");
            if (!b) {
                super.finish();
                return;
            }
            return;
        }
        super.finish();
    }

    protected final int getLayoutId() {
        return a$g.uCq;
    }

    private void aXA() {
        this.lAx = true;
        if (this.wn <= 0 || this.ogJ.size() <= 0 || this.ogJ.get(this.ogJ.size() - 1) == null) {
            this.ogM = "";
            l(new v(this.ogE, 11, this.wn, this.ogG, "v1.0", this.ogM));
            return;
        }
        l(new v(this.ogE, this.wn, this.ogG, bh.getLong(((m) this.ogJ.get(this.ogJ.size() - 1)).ocr, 0), "v1.0", this.ogM));
    }

    private void a(final com.tencent.mm.plugin.luckymoney.b.e eVar) {
        if (eVar != null) {
            this.ogC = eVar.obY == 1;
            if (this.wn == 0) {
                this.ogF = eVar.obV;
                Object obj = (eVar == null || eVar.obK != 0 || eVar.och == null || eVar.och.size() <= 0 || !((m) eVar.och.get(0)).obV.equals(this.ogF) || eVar.obW == 1) ? null : 1;
                if (obj != null) {
                    this.ogL.okc = false;
                    this.ohx.setVisibility(0);
                    this.ohy.setVisibility(0);
                    this.lkn.setVisibility(8);
                } else {
                    this.lkn.setVisibility(0);
                    this.ogL.okb = this.ogF;
                }
                this.ogL.oke = eVar.ocg;
                if (eVar != null) {
                    Context context = this.mController.xIM;
                    if (eVar.ocg == 2) {
                        this.ogs.setImageResource(e.ucM);
                        if (eVar.resourceId != 0) {
                            x.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + eVar.resourceId);
                            com.tencent.mm.sdk.b.b hfVar = new hf();
                            hfVar.fxt.fxv = eVar.resourceId;
                            hfVar.fqI = new 8(this, hfVar, eVar);
                            com.tencent.mm.sdk.b.a.xef.a(hfVar, Looper.myLooper());
                        } else {
                            n.a(this.ogs, eVar.obP, eVar.ocj);
                        }
                    } else {
                        n.a(this.ogs, eVar.obP, eVar.ocj);
                    }
                    n.a(context, this.ogt, eVar.obO);
                    n.a(context, this.ogu, eVar.obN);
                    if (eVar.obK == 1) {
                        this.oht.setVisibility(0);
                        this.oht.setImageResource(e.ucY);
                    } else if (eVar.obK == 2) {
                        if (!s.gE(eVar.ocj)) {
                            com.tencent.mm.ad.h hVar = new com.tencent.mm.ad.h();
                            hVar.username = eVar.ocj;
                            com.tencent.mm.ad.n.JQ().a(hVar);
                        }
                        this.oht.setVisibility(0);
                        this.oht.setImageResource(e.ucW);
                    } else {
                        this.oht.setVisibility(8);
                    }
                    if (!bh.ov(eVar.oce)) {
                        n.d(this.ohu, eVar.oce, e.uda);
                        this.ohu.setScaleType(ScaleType.FIT_XY);
                    }
                    if (bh.ov(eVar.ocf)) {
                        x.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
                        this.ohz.setVisibility(8);
                    } else {
                        x.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[]{eVar.ocf});
                        this.ohz.setVisibility(4);
                        n.h(this.lVz, eVar.ocf);
                        com.tencent.mm.sdk.platformtools.ag.h(new 9(this), 500);
                    }
                    if (eVar.fLE != 2 || this.ogD == 3) {
                        this.ogv.setVisibility(8);
                    } else {
                        this.ogw.setText(com.tencent.mm.wallet_core.ui.e.t(((double) eVar.fLR) / 100.0d));
                        if (eVar.obW != 1) {
                            this.ogL.okc = true;
                        } else {
                            this.ogL.okc = false;
                        }
                        this.ogv.setVisibility(0);
                    }
                    if (bh.ov(eVar.nZh)) {
                        x.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                        this.ogy.setVisibility(8);
                    } else {
                        this.ogy.setVisibility(0);
                        this.lmo.setText(eVar.nZh);
                        if (eVar.nZf == 1) {
                            if (TextUtils.isEmpty(eVar.nZg) || eVar.nZg.startsWith("weixin://wxpay")) {
                                this.ogz.setVisibility(8);
                            } else {
                                this.ogz.setVisibility(0);
                            }
                            this.lmo.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ LuckyMoneyDetailUI ohM;

                                public final void onClick(View view) {
                                    if (TextUtils.isEmpty(eVar.nZg)) {
                                        com.tencent.mm.wallet_core.ui.e.HF(12);
                                        com.tencent.mm.pluginsdk.wallet.h.Y(this.ohM.mController.xIM, 1);
                                        g.pQN.h(13184, new Object[]{Integer.valueOf(0), ""});
                                        x.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
                                        return;
                                    }
                                    x.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + eVar.nZg);
                                    if (eVar.nZg.startsWith("weixin://wxpay")) {
                                        com.tencent.mm.wallet_core.ui.e.HF(12);
                                        com.tencent.mm.pluginsdk.wallet.h.Y(this.ohM.mController.xIM, 1);
                                        g.pQN.h(13184, new Object[]{Integer.valueOf(0), eVar.nZg});
                                        return;
                                    }
                                    com.tencent.mm.wallet_core.ui.e.HF(7);
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", eVar.nZg);
                                    com.tencent.mm.bm.d.b(this.ohM.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                                    g.pQN.h(13184, new Object[]{Integer.valueOf(1), eVar.nZg});
                                }
                            });
                        } else {
                            x.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                            this.lmo.setTextColor(getResources().getColor(c.uaX));
                        }
                    }
                    if (bh.ov(eVar.obZ)) {
                        this.lkn.setText(null);
                    } else {
                        this.lkn.setText(eVar.obZ);
                    }
                }
                if (eVar != null) {
                    ViewGroup viewGroup;
                    List list = eVar.occ;
                    if (list != null && list.size() > 0) {
                        View findViewById = this.Lr.findViewById(f.unn);
                        View findViewById2 = this.Lr.findViewById(f.uno);
                        View findViewById3 = this.Lr.findViewById(f.unp);
                        viewGroup = (ViewGroup) this.Lr.findViewById(f.unk);
                        ViewGroup viewGroup2 = (ViewGroup) this.Lr.findViewById(f.unl);
                        ViewGroup viewGroup3 = (ViewGroup) this.Lr.findViewById(f.unm);
                        View findViewById4 = this.Lr.findViewById(f.unc);
                        View findViewById5 = this.Lr.findViewById(f.und);
                        g.c cVar = new g.c();
                        cVar.textColor = getResources().getColor(c.uaT);
                        if (list.size() > 0) {
                            g.a(this, viewGroup, (ah) list.get(0), cVar);
                            findViewById.setVisibility(0);
                        }
                        if (list.size() > 1) {
                            g.a(this, viewGroup2, (ah) list.get(1), cVar);
                            findViewById2.setVisibility(0);
                        }
                        if (list.size() > 2) {
                            g.a(this, viewGroup3, (ah) list.get(2), cVar);
                            findViewById3.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                            findViewById4.setVisibility(0);
                        }
                        if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                            findViewById5.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                            this.ogA.requestLayout();
                            this.ogA.setVisibility(0);
                        }
                    }
                    viewGroup = (ViewGroup) this.lBB.findViewById(f.une);
                    g.c cVar2 = new g.c();
                    cVar2.textColor = getResources().getColor(c.uaT);
                    cVar2.textSize = getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.bvU);
                    g.a(this, viewGroup, eVar.ocd, cVar2);
                }
                g.pQN.h(11701, new Object[]{Integer.valueOf(sd(eVar.ocg)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
            }
            if (eVar != null) {
                Object obj2 = ((eVar.fLD == 3 || eVar.fLD == 2) && eVar.obX == 1 && !this.ogC && eVar.oca == 1) ? 1 : null;
                Object obj3 = (eVar.ocb == null || eVar.ocb.gEx != 1 || bh.ov(eVar.ocb.obv)) ? null : 1;
                TextView textView = (TextView) this.lBB.findViewById(f.unt);
                if (obj2 == null && obj3 == null) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new 11(this, eVar));
                    if (obj3 != null) {
                        this.ogH = eVar.ocb.obv;
                        textView.setText(eVar.ocb.obw);
                    }
                    g.pQN.h(11701, new Object[]{Integer.valueOf(sd(eVar.ocg)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                    textView.setVisibility(0);
                }
                this.ocg = eVar.ocg;
                ((TextView) this.lBB.findViewById(f.unr)).setVisibility(8);
                if (!this.ogN) {
                    this.ogr.addFooterView(this.lBB);
                    this.ogN = true;
                }
            }
            List list2 = eVar.och;
            if (list2 != null) {
                for (int i = 0; i < list2.size(); i++) {
                    m mVar = (m) list2.get(i);
                    if (!this.ogK.containsKey(mVar.obV)) {
                        this.ogJ.add(list2.get(i));
                        this.ogK.put(mVar.obV, Integer.valueOf(1));
                    }
                }
                this.wn += list2.size();
                this.lAx = false;
                if (this.ohx.getVisibility() != 0) {
                    this.lkn.setVisibility(0);
                    this.ogL.bd(this.ogJ);
                }
            }
            if (eVar.obK == 2 && !bh.ov(eVar.obM)) {
                this.nYQ = new SoundPool(2, 3, 0);
                this.ohA = new int[2];
                try {
                    this.ohA[0] = this.nYQ.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
                    this.ohA[1] = this.nYQ.load(getResources().getAssets().openFd("whistle.m4a"), 0);
                } catch (IOException e) {
                    x.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + e.getMessage());
                }
                this.nYQ.setOnLoadCompleteListener(new OnLoadCompleteListener(this) {
                    final /* synthetic */ LuckyMoneyDetailUI ohM;

                    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                        if (i2 != 0) {
                            return;
                        }
                        if (i == this.ohM.ohA[0]) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                        } else if (i == this.ohM.ohA[1] && eVar.fLR >= 19000) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                        }
                    }
                });
                this.Lr.postDelayed(new Runnable(this) {
                    final /* synthetic */ LuckyMoneyDetailUI ohM;

                    {
                        this.ohM = r1;
                    }

                    public final void run() {
                        ViewGroup t = this.ohM.ohB;
                        b u = this.ohM.oao;
                        com.tencent.mm.plugin.luckymoney.particles.a aVar = new com.tencent.mm.plugin.luckymoney.particles.a(t);
                        com.tencent.mm.plugin.luckymoney.particles.c ak = new com.tencent.mm.plugin.luckymoney.particles.c(t.getContext(), u, new com.tencent.mm.plugin.luckymoney.particles.d(-100, t.getHeight() / 2), t).y(600.0f, 150.0f).z(-1000.0f, 250.0f).aj(-200.0f).ak(1500.0f);
                        ak.oeB = 600.0f;
                        ak.oeC = 300.0f;
                        ak = ak.aXk();
                        ak.oef = com.tencent.mm.plugin.luckymoney.particles.e.aXo();
                        aVar.odT = ak.aXl().aXm();
                        aVar.y(100, 400);
                        t = this.ohM.ohB;
                        u = this.ohM.oao;
                        aVar = new com.tencent.mm.plugin.luckymoney.particles.a(t);
                        ak = new com.tencent.mm.plugin.luckymoney.particles.c(t.getContext(), u, new com.tencent.mm.plugin.luckymoney.particles.d(t.getWidth() + 100, t.getHeight() / 2), t).y(-600.0f, 150.0f).z(-1000.0f, 250.0f).aj(200.0f).ak(1500.0f);
                        ak.oeB = 600.0f;
                        ak.oeC = 300.0f;
                        ak = ak.aXk();
                        ak.oef = com.tencent.mm.plugin.luckymoney.particles.e.aXo();
                        aVar.odT = ak.aXl().aXm();
                        aVar.y(100, 400);
                    }
                }, 300);
            }
            y yVar = new y();
            yVar.field_mNativeUrl = this.ogG;
            yVar.field_hbType = eVar.obK;
            yVar.field_receiveAmount = eVar.fLR;
            yVar.field_receiveTime = System.currentTimeMillis();
            yVar.field_hbStatus = eVar.fLD;
            yVar.field_receiveStatus = eVar.fLE;
            if (yVar.field_receiveAmount > 0) {
                o.bLn().a(yVar);
            }
        }
    }

    private void aXB() {
        if (this.ogx != null && this.ogx.getVisibility() != 8) {
            this.ogx.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.ogx != null) {
            this.ogx.aXS();
        }
        if (this.nYQ != null) {
            this.nYQ.release();
            for (int unload : this.ohA) {
                this.nYQ.unload(unload);
            }
        }
    }

    private static int sd(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
