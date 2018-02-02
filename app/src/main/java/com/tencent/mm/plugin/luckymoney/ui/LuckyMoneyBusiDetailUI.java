package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.plugin.luckymoney.b.ab;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(3)
public class LuckyMoneyBusiDetailUI extends LuckyMoneyBaseUI {
    private View Lr;
    private boolean lAx = false;
    private View lBB;
    private TextView lkn;
    private TextView lmo;
    private View ogA;
    private ImageView ogB;
    private boolean ogC = true;
    private int ogD;
    private String ogE;
    private String ogF;
    private String ogG;
    private String ogH;
    private int ogI = 0;
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
    private int wn = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ogr = (ListView) findViewById(a$f.uhm);
        this.ogL = new i(this.mController.xIM);
        this.Lr = LayoutInflater.from(this).inflate(g.uCl, null);
        this.ogr.addHeaderView(this.Lr);
        this.ogr.setAdapter(this.ogL);
        this.Lr.setOnClickListener(new 7(this));
        this.ogr.setOnScrollListener(this.ogO);
        this.ogr.setOnItemClickListener(new 8(this));
        this.lBB = LayoutInflater.from(this).inflate(g.uCk, null);
        this.ogs = (ImageView) this.Lr.findViewById(a$f.ugV);
        this.ogt = (TextView) this.Lr.findViewById(a$f.uhp);
        this.ogu = (TextView) this.Lr.findViewById(a$f.uhr);
        this.ogv = this.Lr.findViewById(a$f.ugU);
        this.ogw = (TextView) this.Lr.findViewById(a$f.ugT);
        this.ogy = this.Lr.findViewById(a$f.uhc);
        this.lmo = (TextView) this.Lr.findViewById(a$f.uho);
        this.ogz = (ImageView) this.Lr.findViewById(a$f.uhd);
        this.lkn = (TextView) this.Lr.findViewById(a$f.ugY);
        this.ogA = this.Lr.findViewById(a$f.uhk);
        this.ogB = (ImageView) this.Lr.findViewById(a$f.ugS);
        ImageView imageView = (ImageView) findViewById(a$f.ugX);
        this.ogx = (LuckyMoneyWishFooter) findViewById(a$f.uhq);
        this.ogx.a(new 9(this));
        this.ogx.a(new 10(this));
        this.ogx.post(new 11(this));
        this.ogx.xGO = new 12(this);
        this.ogL.okd = new 13(this);
        i iVar = this.ogL;
        iVar.okf = new i.a(iVar);
        this.ogx.aXR();
        imageView.setOnClickListener(new 14(this));
        View findViewById = findViewById(a$f.ugW);
        if (findViewById != null) {
            Drawable background = findViewById.getBackground();
            if (background != null && (background instanceof BitmapDrawable)) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
                bitmapDrawable.mutate();
                bitmapDrawable.setTileModeX(TileMode.REPEAT);
            }
        }
        this.ogE = getIntent().getStringExtra("key_sendid");
        this.ogG = getIntent().getStringExtra("key_native_url");
        this.ogD = getIntent().getIntExtra("key_jump_from", 2);
        this.ogI = getIntent().getIntExtra("key_static_from_scene", 0);
        x.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", this.ogE, this.ogG, Integer.valueOf(this.ogD));
        if (this.ogD == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (byteArrayExtra != null) {
                    e eVar = (e) new e().aF(byteArrayExtra);
                    if (eVar != null) {
                        a(eVar);
                        if (getIntent().getBooleanExtra("play_sound", false)) {
                            k.H(this, i.uJH);
                        }
                    }
                }
            } catch (Exception e) {
                x.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bh.ov(this.ogE) && !bh.ov(this.ogG)) {
            try {
                this.ogE = Uri.parse(this.ogG).getQueryParameter("sendid");
            } catch (Exception e2) {
                x.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + e2.getLocalizedMessage());
            }
        }
        if (bh.ov(this.ogE)) {
            x.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
        } else {
            aXA();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
            k.H(this, i.uJH);
        }
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
                e eVar = vVar.ocQ;
                this.ogM = vVar.odd;
                a(eVar);
                return true;
            }
            h.bu(this, str);
            return true;
        } else if (kVar instanceof ab) {
            if (i == 0 && i2 == 0) {
                h.bu(this, getString(i.epb));
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
                }
                return true;
            }
            h.bu(this, str);
            return true;
        } else if (!(kVar instanceof ag)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                h.bu(this, getString(i.epb));
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
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
            boolean b = realnameGuideHelper.b(this, bundle, new 2(this));
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
        return g.uCm;
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(e eVar) {
        if (eVar != null) {
            this.ogC = eVar.obY == 1;
            if (this.wn == 0) {
                this.ogF = eVar.obV;
                this.ogL.okb = this.ogF;
                this.ogL.oke = eVar.ocg;
                if (eVar != null) {
                    Context context = this.mController.xIM;
                    if (eVar.ocg == 2) {
                        this.ogs.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ucM);
                        if (eVar.resourceId != 0) {
                            x.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + eVar.resourceId);
                            b hfVar = new hf();
                            hfVar.fxt.fxv = eVar.resourceId;
                            hfVar.fqI = new 3(this, hfVar, eVar);
                            com.tencent.mm.sdk.b.a.xef.a(hfVar, Looper.myLooper());
                        }
                        n.a(context, this.ogt, eVar.obO);
                        n.a(context, this.ogu, eVar.obN);
                        if (eVar.fLE == 2 || this.ogD == 3) {
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
                            this.ogy.setVisibility(0);
                            this.lmo.setText(eVar.nZh);
                            if (eVar.nZf != 1) {
                                if (!TextUtils.isEmpty(eVar.nZg) || eVar.nZg.startsWith("weixin://wxpay")) {
                                    this.ogz.setVisibility(8);
                                } else {
                                    this.ogz.setVisibility(0);
                                }
                                this.lmo.setOnClickListener(new 4(this, eVar));
                            } else {
                                x.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                                this.lmo.setTextColor(getResources().getColor(c.uaX));
                            }
                        } else {
                            x.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                            this.ogy.setVisibility(8);
                        }
                        if (bh.ov(eVar.obZ)) {
                            this.lkn.setText(eVar.obZ);
                        } else {
                            this.lkn.setText(null);
                        }
                    }
                    n.a(this.ogs, eVar.obP, eVar.ocj);
                    n.a(context, this.ogt, eVar.obO);
                    n.a(context, this.ogu, eVar.obN);
                    if (eVar.fLE == 2) {
                    }
                    this.ogv.setVisibility(8);
                    if (bh.ov(eVar.nZh)) {
                        x.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                        this.ogy.setVisibility(8);
                    } else {
                        this.ogy.setVisibility(0);
                        this.lmo.setText(eVar.nZh);
                        if (eVar.nZf != 1) {
                            x.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                            this.lmo.setTextColor(getResources().getColor(c.uaX));
                        } else {
                            if (TextUtils.isEmpty(eVar.nZg)) {
                            }
                            this.ogz.setVisibility(8);
                            this.lmo.setOnClickListener(new 4(this, eVar));
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
                        View findViewById = this.Lr.findViewById(a$f.uhh);
                        View findViewById2 = this.Lr.findViewById(a$f.uhi);
                        View findViewById3 = this.Lr.findViewById(a$f.uhj);
                        viewGroup = (ViewGroup) this.Lr.findViewById(a$f.uhe);
                        ViewGroup viewGroup2 = (ViewGroup) this.Lr.findViewById(a$f.uhf);
                        ViewGroup viewGroup3 = (ViewGroup) this.Lr.findViewById(a$f.uhg);
                        View findViewById4 = this.Lr.findViewById(a$f.ugZ);
                        View findViewById5 = this.Lr.findViewById(a$f.uha);
                        g.c cVar = new g.c();
                        cVar.textColor = getResources().getColor(c.uaR);
                        cVar.ojr = true;
                        cVar.resourceId = eVar.resourceId;
                        cVar.ojs = this.ogI;
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
                    viewGroup = (ViewGroup) this.lBB.findViewById(a$f.uhb);
                    g.c cVar2 = new g.c();
                    cVar2.textColor = getResources().getColor(c.uaR);
                    cVar2.textSize = getResources().getDimensionPixelSize(d.bvU);
                    g.a(this, viewGroup, eVar.ocd, cVar2);
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(11701, Integer.valueOf(sd(eVar.ocg)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            }
            if (eVar != null) {
                Object obj = ((eVar.fLD == 3 || eVar.fLD == 2) && eVar.obX == 1 && !this.ogC && eVar.oca == 1) ? 1 : null;
                Object obj2 = (eVar.ocb == null || eVar.ocb.gEx != 1 || bh.ov(eVar.ocb.obv)) ? null : 1;
                TextView textView = (TextView) this.lBB.findViewById(a$f.uhn);
                if (obj == null && obj2 == null) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new 5(this, eVar));
                    if (obj2 != null) {
                        this.ogH = eVar.ocb.obv;
                        textView.setText(eVar.ocb.obw);
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(11701, Integer.valueOf(sd(eVar.ocg)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                    textView.setVisibility(0);
                }
                TextView textView2 = (TextView) this.lBB.findViewById(a$f.uhl);
                if (this.ogD == 1 || this.ogD == 3 || textView.getVisibility() == 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setOnClickListener(new 6(this, eVar));
                    textView2.setVisibility(0);
                }
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
                this.ogL.bd(this.ogJ);
            }
            String str = eVar.ocf;
            String str2 = eVar.oci;
            this.ogB.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ucL);
            if (bh.ov(str)) {
                x.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
                this.ogB.setVisibility(8);
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                displayMetrics = ac.getContext().getResources().getDisplayMetrics();
                if (displayMetrics != null) {
                    int dimensionPixelSize = (int) (((float) ((displayMetrics.widthPixels - (getResources().getDimensionPixelSize(d.ubY) * 2)) - (getResources().getDimensionPixelSize(d.ubX) * 2))) * 0.75f);
                    LayoutParams layoutParams = this.ogB.getLayoutParams();
                    layoutParams.height = dimensionPixelSize;
                    this.ogB.setLayoutParams(layoutParams);
                }
                n.a(this.ogB, str, str2, false);
                this.ogB.setVisibility(0);
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(13051, Integer.valueOf(this.ogI), Integer.valueOf(1), eVar.ocf, n.bc(eVar.occ), "", "", "", "", eVar.obO, Integer.valueOf(eVar.resourceId));
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
    }

    private static int sd(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
