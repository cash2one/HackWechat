package com.tencent.mm.plugin.scanner.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.b.af;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.a.k;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.ht;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI extends MMPreference implements e, a {
    private long fqm;
    private com.tencent.mm.modelgeo.a.a gyF = new 1(this);
    private c gyy;
    private boolean hpR = false;
    private TextView ihS;
    protected f ilB;
    protected ProgressDialog iln = null;
    private int irz;
    private com.tencent.mm.sdk.b.c jeX = new 5(this);
    private String lyH;
    private long mStartTime;
    private List<MusicPreference> oJB;
    private ImageView pVQ;
    private ImageView pVR;
    private View pVS;
    private TextView pVT;
    private ImageView pVU;
    private View pVV;
    private TextView pVW;
    private LinearLayout pVX;
    private ImageView pVY;
    private n.a pVZ;
    private View pWa;
    private int pWb = 0;
    private int pWc;
    private a pWd;
    private boolean pWe = false;
    private HashMap<String, Boolean> pWf;
    private e.a pWg;
    private String pWh;
    private boolean pWi = false;
    private String pWj;
    private boolean pWk = false;
    private boolean pWl = false;
    private boolean pWm = false;
    private com.tencent.mm.plugin.scanner.history.a.a pWn;
    private bs.a pWo = new bs.a(this) {
        final /* synthetic */ ProductUI pWr;

        {
            this.pWr = r1;
        }

        public final void a(d.a aVar) {
            String a = com.tencent.mm.platformtools.n.a(aVar.hmq.vGZ);
            x.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
            n.a a2 = this.pWr.pVZ;
            if (!(a2 == null || bh.ov(a))) {
                Map y = bi.y(a, "sysmsg");
                a = (String) y.get(".sysmsg.scanproductinfo.product.id");
                if (bh.ov(a2.field_productid) || !a2.field_productid.equals(a)) {
                    x.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + bh.ou(a) + ", target=" + a2.field_productid);
                } else {
                    List l = com.tencent.mm.plugin.scanner.a.a.l(y, ".sysmsg.scanproductinfo.product");
                    Map hashMap = new HashMap();
                    for (int i = 0; i < l.size(); i++) {
                        List list = ((com.tencent.mm.plugin.scanner.a.a) l.get(i)).hOg;
                        if (list != null) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) list.get(i2);
                                if (aVar2 != null) {
                                    hashMap.put(aVar2.aAM, aVar2);
                                }
                            }
                        }
                    }
                    x.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + hashMap.size());
                    k.b(a2.qbc, hashMap);
                }
            }
            ag.y(new 1(this));
        }
    };
    private MusicPreference.a pWp = new 4(this);
    private boolean pWq = true;

    private final class b {
        int MP = ProductUI.u(this.pWr);
        final /* synthetic */ ProductUI pWr;
        ProductScrollView pWw = ((ProductScrollView) this.pWr.findViewById(R.h.cEf));
        boolean pWx;
        private ProductScrollView.a pWy = new 1(this);

        public b(ProductUI productUI) {
            this.pWr = productUI;
        }
    }

    static /* synthetic */ void b(ProductUI productUI, n.a aVar) {
        if (aVar == null || bh.ov(aVar.field_thumburl)) {
            x.e("MicroMsg.scanner.ProductUI", "product == null || Util.isNullOrNil(product.field_thumburl)");
            return;
        }
        try {
            productUI.pVS.setBackgroundColor(Color.parseColor(aVar.field_headermask));
            if (!bh.ov(aVar.field_headermask) && aVar.field_headermask.length() == 9) {
                productUI.pWa.setBackgroundColor(Color.parseColor("#" + aVar.field_headermask.substring(3, 9)));
            }
        } catch (Exception e) {
            x.w("MicroMsg.scanner.ProductUI", "parse maskColor wrong");
        }
        x.e("MicroMsg.scanner.ProductUI", "begin to get the url " + aVar.field_thumburl);
        Bitmap a = j.a(productUI.pWd);
        if (a != null) {
            productUI.pVQ.setImageBitmap(a);
            productUI.pVQ.setBackgroundDrawable(null);
            productUI.pVQ.setBackgroundColor(-1);
            productUI.pWe = true;
            productUI.bph();
        } else {
            productUI.pVQ.setImageBitmap(null);
        }
        if (!bh.ov(aVar.field_headerbackgroundurl)) {
            a = j.a(new o(aVar.field_headerbackgroundurl));
            if (a != null && !a.isRecycled()) {
                productUI.pVR.setImageBitmap(a);
            }
        }
    }

    static /* synthetic */ void j(ProductUI productUI) {
        if (productUI.pVZ == null) {
            return;
        }
        if (!bh.ov(productUI.pVZ.field_detailurl)) {
            productUI.aA(10000, productUI.pVZ.field_detailurl);
            productUI.II(productUI.pVZ.field_detailurl);
        } else if (!bh.ov(productUI.pVZ.field_xml) && productUI.pWi) {
            productUI.aA(10001, "");
            Intent intent = new Intent();
            intent.setClass(productUI, ProductFurtherInfoUI.class);
            intent.putExtra("key_Product_xml", productUI.pVZ.field_xml);
            intent.putExtra("key_title", productUI.pWj);
            productUI.startActivity(intent);
        }
    }

    static /* synthetic */ void l(ProductUI productUI) {
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(productUI.getString(R.l.eYe));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(productUI.getString(R.l.eYd));
        linkedList2.add(Integer.valueOf(1));
        if (!productUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            linkedList.add(productUI.getString(R.l.eAd));
            linkedList2.add(Integer.valueOf(2));
        } else if (productUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true)) {
            str = productUI.getString(R.l.dEw);
            linkedList.add(productUI.getString(R.l.eeF));
            linkedList2.add(Integer.valueOf(3));
        } else {
            str = "";
        }
        if (!(productUI.pVZ == null || TextUtils.isEmpty(productUI.pVZ.field_exposeurl))) {
            linkedList.add(productUI.getString(R.l.dUR));
            linkedList2.add(Integer.valueOf(4));
        }
        h.a(productUI, "", linkedList, linkedList2, str, false, new 6(productUI));
    }

    static /* synthetic */ void p(ProductUI productUI) {
        if (productUI.pVZ == null) {
            x.w("MicroMsg.scanner.ProductUI", "do favorite, but product is null");
            return;
        }
        com.tencent.mm.sdk.b.b cfVar = new cf();
        ve veVar = new ve();
        vk vkVar = new vk();
        vd vdVar = new vd();
        vkVar.Ui(q.FS());
        vkVar.Uj(q.FS());
        vkVar.CS(8);
        vkVar.fC(bh.Wp());
        vkVar.Uo(i.vD(productUI.pVZ.field_functionType));
        vdVar.Ub(productUI.pVZ.field_title);
        vdVar.Uc(productUI.pVZ.field_subtitle);
        vdVar.CP(productUI.pVZ.field_type);
        vdVar.Ue(n.c(productUI.pVZ));
        vdVar.Ud(productUI.pVZ.field_thumburl);
        cfVar.fqp.title = productUI.pVZ.field_title;
        cfVar.fqp.desc = productUI.pVZ.field_subtitle;
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 10;
        veVar.a(vkVar);
        veVar.b(vdVar);
        cfVar.fqp.fqw = 11;
        cfVar.fqp.activity = productUI;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
    }

    static /* synthetic */ int u(ProductUI productUI) {
        TypedValue typedValue = new TypedValue();
        return productUI.getTheme().resolveAttribute(R.d.actionBarSize, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, productUI.getResources().getDisplayMetrics()) : 0;
    }

    protected final int getLayoutId() {
        return R.i.cDy;
    }

    public final int XB() {
        return R.o.fbT;
    }

    public final int asz() {
        return R.i.dpB;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = bh.Wo();
        this.irz = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
        j.b(this);
        ar.getSysCmdMsgExtension().a("scanproductinfo", this.pWo, true);
        initView();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(1063, this);
        ar.CG().a(1068, this);
    }

    protected void onPause() {
        ar.CG().b(1063, this);
        ar.CG().b(1068, this);
        super.onPause();
    }

    protected void onDestroy() {
        j.c(this);
        ar.getSysCmdMsgExtension().b("scanproductinfo", this.pWo, true);
        com.tencent.mm.sdk.b.a.xef.c(this.jeX);
        if (this.gyy != null) {
            this.gyy.c(this.gyF);
        }
        aA(10100, (bh.Wo() - this.mStartTime));
        super.onDestroy();
    }

    protected final void initView() {
        View customView;
        setMMTitle(R.l.eHY);
        this.ilB = this.yjd;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(null);
            customView = getSupportActionBar().getCustomView();
        } else {
            customView = null;
        }
        if (customView != null) {
            customView = customView.findViewById(R.h.divider);
            if (customView != null) {
                customView.setBackgroundColor(-1);
            }
        }
        setBackBtn(new 10(this));
        this.ihS = (TextView) findViewById(R.h.cDJ);
        this.pVR = (ImageView) findViewById(R.h.cDA);
        this.pVS = findViewById(R.h.cDF);
        this.pVU = (ImageView) findViewById(R.h.cDx);
        this.pWa = findViewById(R.h.cDu);
        this.pVX = (LinearLayout) findViewById(R.h.cDE);
        this.pVY = (ImageView) findViewById(R.h.cDC);
        this.pVV = findViewById(R.h.cDw);
        j(this.pWa, 0.0f);
        if (com.tencent.mm.bv.a.ey(this.mController.xIM)) {
            this.ihS.setTextSize(0, ((float) this.mController.xIM.getResources().getDimensionPixelSize(R.f.buL)) * 1.25f);
        } else {
            this.ihS.setTextSize(0, (float) com.tencent.mm.bv.a.aa(this.mController.xIM, R.f.buL));
        }
        this.pVT = (TextView) findViewById(R.h.cDv);
        this.pVW = (TextView) findViewById(R.h.cIX);
        this.pWf = new HashMap();
        this.pWg = new 11(this);
        this.pWn = new com.tencent.mm.plugin.scanner.history.a.a();
        this.pWn.field_ScanTime = System.currentTimeMillis();
        this.pWn.field_scene = this.irz;
        String stringExtra;
        String IG;
        if (this.irz == 5) {
            this.pWk = true;
            stringExtra = getIntent().getStringExtra("key_Qrcode_Url");
            IG = IG(stringExtra);
            this.pWn.field_qrcodeUrl = stringExtra;
            this.pWn.field_productId = IG;
            m(IG, stringExtra, false);
        } else if (this.irz == 4) {
            stringExtra = getIntent().getStringExtra("key_product_id");
            IG = getIntent().getStringExtra("key_Qrcode_Url");
            if (bh.ov(stringExtra)) {
                x.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
                finish();
                return;
            }
            m(stringExtra, IG, false);
        } else {
            this.pWm = getIntent().getBooleanExtra("key_is_from_barcode", false);
            this.pWk = getIntent().getBooleanExtra("key_need_add_to_history", false);
            stringExtra = getIntent().getStringExtra("key_Product_xml");
            if (bh.ov(stringExtra)) {
                stringExtra = getIntent().getStringExtra("key_Product_ID");
                if (bh.ov(stringExtra)) {
                    x.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
                    finish();
                    return;
                }
                m(stringExtra, null, false);
            } else {
                int intExtra = getIntent().getIntExtra("key_Product_funcType", 0);
                this.pVZ = i.bW(stringExtra, intExtra);
                if (this.pVZ == null) {
                    x.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
                    finish();
                    return;
                }
                this.lyH = this.pVZ.field_productid;
                this.pWh = this.pVZ.field_extinfo;
                if (!this.pWk || TextUtils.isEmpty(this.lyH)) {
                    x.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.pWk + " mProductId:" + this.lyH);
                } else {
                    this.pWn.field_xmlContent = stringExtra;
                    this.pWn.field_qrcodeUrl = this.pWh;
                    this.pWn.field_productId = this.lyH;
                    this.pWn.field_funcType = intExtra;
                    bpl();
                }
                n.a aVar = this.pVZ;
                getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
                a(aVar);
                if (intExtra != 0 || bh.ov(this.pVZ.field_productid)) {
                    bpk();
                } else {
                    m(this.pVZ.field_productid, this.pVZ.field_extinfo, true);
                }
            }
        }
        findViewById(R.h.cDH).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProductUI pWr;

            {
                this.pWr = r1;
            }

            public final void onClick(View view) {
                ProductUI.j(this.pWr);
            }
        });
        findViewById(R.h.cDy).setOnClickListener(new 13(this));
        this.pVV.setOnClickListener(new 14(this));
        b bVar = new b(this);
    }

    private void a(n.a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
            finish();
            return;
        }
        if (!bh.ov(aVar.field_thumburl)) {
            this.pWd = new a(aVar);
        }
        this.pWc = this.mController.xIM.getResources().getDimensionPixelSize(R.f.bxO);
        if (this.pVZ != null && (this.pVZ.field_type == 1 || this.pVZ.field_type == 2)) {
            this.pWc = this.mController.xIM.getResources().getDimensionPixelSize(R.f.bxP);
            LayoutParams layoutParams = this.pVR.getLayoutParams();
            layoutParams.height = this.pWc;
            this.pVR.setLayoutParams(layoutParams);
            layoutParams = this.pVS.getLayoutParams();
            layoutParams.height = this.pWc;
            this.pVX.setLayoutParams(layoutParams);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.h.cDB);
            LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
            layoutParams2.height = this.pWc;
            relativeLayout.setLayoutParams(layoutParams2);
            layoutParams = this.pVX.getLayoutParams();
            layoutParams.height = this.pWc;
            this.pVX.setLayoutParams(layoutParams);
        }
        if (bh.ov(aVar.field_introtitle) || bh.ov(aVar.field_introlink)) {
            this.pVW.setVisibility(8);
        } else {
            this.pVW.setText(aVar.field_introtitle);
            this.pVW.setOnClickListener(new 15(this, aVar));
            this.pVW.setVisibility(0);
        }
        this.pWb = this.pVZ.field_functionType;
        if (aVar.field_xmlType == 3) {
            this.ihS.setText(aVar.field_title);
            if (bh.ov(aVar.field_certification)) {
                this.pVT.setText(aVar.field_source);
                this.pVU.setVisibility(8);
                this.pVV.setOnClickListener(null);
                this.pVV.setBackgroundDrawable(null);
                this.pVV.setFocusable(false);
            } else {
                this.pVT.setText(aVar.field_certification);
                this.pVU.setVisibility(0);
            }
            if (aVar.field_type == 1 || aVar.field_type == 2) {
                this.pVQ = (ImageView) findViewById(R.h.cDD);
                findViewById(R.h.cDD).setVisibility(0);
                findViewById(R.h.cDG).setVisibility(8);
            } else {
                this.pVQ = (ImageView) findViewById(R.h.cDG);
                findViewById(R.h.cDG).setVisibility(0);
                findViewById(R.h.cDD).setVisibility(8);
            }
            if (!bh.ov(aVar.field_playurl)) {
                ImageView imageView = (ImageView) findViewById(R.h.cDz);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new 16(this, aVar));
            }
            addIconOptionMenu(0, R.g.bDI, new 2(this));
        } else if (aVar.field_xmlType == 4) {
            this.pVQ = (ImageView) findViewById(R.h.cDG);
            findViewById(R.h.cDG).setVisibility(0);
            findViewById(R.h.cDD).setVisibility(8);
            this.pVQ.setImageResource(R.k.dAv);
            this.pVQ.setBackgroundResource(R.k.dAv);
            this.ihS.setText(R.l.eHG);
            this.pVT.setText(null);
        }
        x.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
        ag.y(new 3(this, aVar));
    }

    private void bph() {
        this.fqm = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0);
        if (this.fqm > 0 && ar.Hj()) {
            ar.Hg();
            com.tencent.mm.g.b.cf dH = com.tencent.mm.z.c.Fa().dH(this.fqm);
            if (dH.field_msgId > 0) {
                dH.dT(this.pWd.Wf());
                ar.Hg();
                com.tencent.mm.z.c.Fa().a(this.fqm, dH);
            }
        }
    }

    private void b(n.a aVar) {
        if (aVar != null && aVar.qbc != null && aVar.qbc.size() != 0 && this.ilB != null) {
            this.ilB.removeAll();
            for (int i = 0; i < aVar.qbc.size(); i++) {
                com.tencent.mm.plugin.scanner.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a) aVar.qbc.get(i);
                if (!(aVar2 == null || aVar2.hOg == null || aVar2.hOg.size() == 0 || aVar2.pSp == 1 || !aVar2.pSr)) {
                    Preference preference;
                    if (i != 0) {
                        preference = new Preference(this);
                        preference.setLayoutResource(R.i.dpu);
                        this.ilB.a(preference);
                    }
                    if (!bh.ov(aVar2.title) && (aVar2.type == 6 || aVar2.type == 7)) {
                        preference = new CategoryWithTitlePreference(this);
                        preference.setTitle(aVar2.title);
                        this.ilB.a(preference);
                    }
                    int i2;
                    com.tencent.mm.plugin.scanner.a.a.a aVar3;
                    if (aVar2.type == 6) {
                        List arrayList = new ArrayList();
                        for (i2 = 0; i2 < aVar2.hOg.size(); i2++) {
                            aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.hOg.get(i2);
                            if (aVar3.type == 10) {
                                arrayList.add(aVar3);
                            }
                        }
                        if (arrayList.size() > 0) {
                            Preference hVar = new h(this);
                            hVar.setKey((i * 100));
                            hVar.pfi = arrayList;
                            this.ilB.a(hVar);
                        }
                    } else {
                        i2 = 0;
                        while (i2 < aVar2.hOg.size()) {
                            String str = ((i * 100) + i2);
                            aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.hOg.get(i2);
                            if (aVar3.type == 11) {
                                this.pWi = true;
                                this.pWj = aVar3.name;
                            }
                            if (aVar3.showType != 2) {
                                Preference musicPreference;
                                if (aVar3.showType != 1) {
                                    if (aVar3.type == 5) {
                                        musicPreference = new MusicPreference(this);
                                        musicPreference.setKey(str);
                                        musicPreference.setTitle(aVar3.name);
                                        musicPreference.pSu = aVar3.pSu;
                                        musicPreference.pSv = aVar3.pSv;
                                        musicPreference.pSw = aVar3.pSw;
                                        if (IF(String.format("%s_cd_%s", new Object[]{aVar3.pSu, str}))) {
                                            musicPreference.hH(true);
                                        } else {
                                            musicPreference.hH(false);
                                        }
                                        musicPreference.pVw = this.pWp;
                                        this.ilB.a(musicPreference);
                                        com.tencent.mm.sdk.b.a.xef.b(this.jeX);
                                        if (this.oJB == null) {
                                            this.oJB = new ArrayList();
                                        }
                                        if (this.pWq) {
                                            this.oJB.add(musicPreference);
                                        }
                                    } else if (aVar3.type == 6) {
                                        musicPreference = new e(this);
                                        musicPreference.setKey(str);
                                        musicPreference.mTitle = aVar3.name;
                                        musicPreference.setSummary(aVar3.desc);
                                        this.ilB.a(musicPreference);
                                        musicPreference.pVl = this.pWg;
                                    } else if (aVar3.type == 12) {
                                        musicPreference = new f(this);
                                        musicPreference.setKey(str);
                                        musicPreference.lAb = aVar3.thumburl;
                                        musicPreference.ilB = this.ilB;
                                        this.ilB.a(musicPreference);
                                    } else if (aVar3.type == 2) {
                                        CharSequence charSequence = IH(aVar3.username) ? aVar3.pSC : aVar3.pSB;
                                        Preference aVar4 = new a(this);
                                        aVar4.setKey(str);
                                        aVar4.setTitle(charSequence);
                                        aVar4.setSummary(aVar3.desc);
                                        aVar4.pTL = aVar3.hef;
                                        this.ilB.a(aVar4);
                                    } else if (aVar3.type == 22) {
                                        musicPreference = new d(this);
                                        musicPreference.setKey(str);
                                        if (!bh.ov(aVar3.fpL)) {
                                            musicPreference.pLS = aVar3.fpL + ":";
                                        }
                                        musicPreference.ndc = aVar3.content;
                                        musicPreference.pUZ = aVar3.thumburl;
                                        this.ilB.a(musicPreference);
                                    } else {
                                        musicPreference = new a(this);
                                        musicPreference.setKey(str);
                                        musicPreference.setTitle(aVar3.name);
                                        musicPreference.setSummary(aVar3.desc);
                                        musicPreference.pTL = aVar3.hef;
                                        musicPreference.lRA = aVar3.iconUrl;
                                        this.ilB.a(musicPreference);
                                    }
                                    if (!(i2 >= aVar2.hOg.size() - 1 || aVar3.type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.hOg.get(i2 + 1)).type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.hOg.get(i2 + 1)).showType == 1 || !a(i2, aVar2.hOg))) {
                                        this.ilB.a(new g(this));
                                    }
                                } else if (!bh.ov(aVar3.pSs)) {
                                    musicPreference = new b(this);
                                    musicPreference.setKey(str);
                                    musicPreference.lAb = aVar3.pSs;
                                    musicPreference.ilB = this.ilB;
                                    this.ilB.a(musicPreference);
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
            this.ilB.notifyDataSetChanged();
            x.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
            if (this.oJB != null) {
                this.pWq = false;
            }
        }
    }

    private static boolean a(int i, LinkedList<com.tencent.mm.plugin.scanner.a.a.a> linkedList) {
        if (linkedList != null) {
            for (int i2 = i + 1; i2 < linkedList.size(); i2++) {
                if (((com.tencent.mm.plugin.scanner.a.a.a) linkedList.get(i2)).showType != 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void bpi() {
        if (this.pVZ != null && this.pVZ.qbc != null && this.pVZ.qbc.size() != 0 && this.ilB != null) {
            for (int i = 0; i < this.pVZ.qbc.size(); i++) {
                com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.pVZ.qbc.get(i);
                if (!(aVar == null || aVar.hOg == null || aVar.hOg.size() == 0)) {
                    for (int i2 = 0; i2 < aVar.hOg.size(); i2++) {
                        if (((com.tencent.mm.plugin.scanner.a.a.a) aVar.hOg.get(i2)).type == 5) {
                            MusicPreference musicPreference = (MusicPreference) this.ilB.YN(((i * 100) + i2));
                            if (musicPreference != null) {
                                if (IF(String.format("%s_cd_%s", new Object[]{r1.pSu, r6}))) {
                                    musicPreference.hH(true);
                                } else {
                                    musicPreference.hH(false);
                                }
                            }
                        }
                    }
                }
            }
            this.ilB.notifyDataSetChanged();
        }
    }

    public final boolean a(f fVar, Preference preference) {
        x.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[]{preference.ibD});
        if (this.pVZ == null || this.pVZ.qbc == null) {
            x.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.ibD).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            x.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2)});
            if (i < 0 || i >= this.pVZ.qbc.size()) {
                x.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.pVZ.qbc.size())});
                return false;
            }
            com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.pVZ.qbc.get(i);
            if (aVar == null) {
                x.w("MicroMsg.scanner.ProductUI", "actionList == null");
                return false;
            } else if (i2 < 0 || i2 >= aVar.hOg.size()) {
                x.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(aVar.hOg.size())});
                return false;
            } else {
                com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) aVar.hOg.get(i2);
                if (aVar2 == null) {
                    x.w("MicroMsg.scanner.ProductUI", "action == null");
                    return false;
                }
                x.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[]{Integer.valueOf(aVar2.type)});
                String str = null;
                Intent intent = new Intent();
                switch (aVar2.type) {
                    case 1:
                    case 3:
                    case 22:
                        str = aVar2.hOf;
                        if (!bh.ov(aVar2.hOf)) {
                            II(aVar2.hOf);
                            break;
                        }
                        break;
                    case 2:
                    case 4:
                        str = aVar2.username;
                        if (!bh.ov(aVar2.username)) {
                            Object obj = aVar2.username;
                            Intent intent2;
                            if (!IH(obj)) {
                                if (!TextUtils.isEmpty(obj)) {
                                    intent2 = new Intent();
                                    intent2.putExtra("Contact_User", obj);
                                    intent2.putExtra("force_get_contact", true);
                                    intent2.putExtra("Contact_Scene", bpj());
                                    com.tencent.mm.plugin.scanner.b.ifs.d(intent2, this);
                                    break;
                                }
                                x.v("MicroMsg.scanner.ProductUI", "username is null");
                                break;
                            }
                            intent2 = new Intent();
                            intent2.putExtra("Chat_User", obj);
                            intent2.putExtra("finish_direct", true);
                            intent2.putExtra("add_scene", bpj());
                            com.tencent.mm.plugin.scanner.b.ifs.e(intent2, this.mController.xIM);
                            break;
                        }
                        break;
                    case 5:
                        str = aVar2.pSw;
                        intent.putExtra("rawUrl", aVar2.pSw);
                        intent.putExtra("geta8key_scene", ahG());
                        com.tencent.mm.plugin.scanner.b.ifs.j(intent, this);
                        com.tencent.mm.av.b.Qo();
                        bpi();
                        break;
                    case 6:
                    case 7:
                    case 10:
                        break;
                    case 8:
                        str = aVar2.pSy;
                        intent.putExtra("key_card_id", aVar2.pSA);
                        intent.putExtra("key_card_ext", aVar2.pSz);
                        intent.putExtra("key_from_scene", 9);
                        com.tencent.mm.bm.d.b(this, "card", ".ui.CardDetailUI", intent);
                        break;
                    case 9:
                        str = aVar2.pSy;
                        if (!bh.ov(aVar2.pSy)) {
                            intent.putExtra("key_product_id", aVar2.pSy);
                            intent.putExtra("key_product_scene", 12);
                            com.tencent.mm.bm.d.b(this, "product", ".ui.MallProductUI", intent);
                            break;
                        }
                        break;
                    case 11:
                        intent.setClass(this, ProductFurtherInfoUI.class);
                        intent.putExtra("key_Product_xml", this.pVZ.field_xml);
                        intent.putExtra("key_title", aVar2.name);
                        startActivity(intent);
                        break;
                    case 12:
                        str = aVar2.hOf;
                        if (!bh.ov(aVar2.hOf)) {
                            II(aVar2.hOf);
                            break;
                        }
                        break;
                    case 21:
                        str = aVar2.pSq;
                        intent.setClass(this, ProductPurchaseAreaUI.class);
                        intent.putExtra("key_Product_xml", this.pVZ.field_xml);
                        intent.putExtra("referkey", aVar2.pSq);
                        intent.putExtra("key_Product_funcType", this.pWb);
                        startActivity(intent);
                        break;
                    default:
                        x.d("MicroMsg.scanner.ProductUI", "Default go url:" + aVar2.hOf);
                        if (!bh.ov(aVar2.hOf)) {
                            II(aVar2.hOf);
                            break;
                        }
                        break;
                }
                ar.CG().a(new com.tencent.mm.plugin.scanner.a.h(this.pVZ.field_productid, aVar2.pSx, aVar2.type, str, aVar.hOg.size(), aVar2.showType), 0);
                return true;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean IF(String str) {
        asv Qs = com.tencent.mm.av.b.Qs();
        if (Qs != null && Qs.wAi == 5 && str.equals(Qs.vVZ) && com.tencent.mm.av.b.Qq()) {
            return true;
        }
        return false;
    }

    private void aA(int i, String str) {
        if (this.pVZ != null) {
            ar.CG().a(new com.tencent.mm.plugin.scanner.a.h(this.pVZ.field_productid, "", i, str, 0, 0), 0);
        }
    }

    public final void l(final String str, final Bitmap bitmap) {
        if (!bh.ov(str) && this.pVZ != null && bitmap != null && !bitmap.isRecycled()) {
            x.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
            ag.y(new Runnable(this) {
                final /* synthetic */ ProductUI pWr;

                public final void run() {
                    if (str.equals(this.pWr.pVZ.field_thumburl) && this.pWr.pVQ != null) {
                        x.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
                        try {
                            this.pWr.pVQ.setImageBitmap(bitmap);
                            this.pWr.pVQ.setBackgroundDrawable(null);
                            this.pWr.pVQ.setBackgroundColor(-1);
                            this.pWr.bph();
                            this.pWr.pWe = true;
                        } catch (Exception e) {
                            x.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[]{e.getLocalizedMessage()});
                        }
                    }
                    if (str.equals(this.pWr.pVZ.field_headerbackgroundurl) && this.pWr.pVR != null) {
                        this.pWr.pVR.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar == null) {
            x.w("MicroMsg.scanner.ProductUI", "scene == null");
        } else if (kVar.getType() == 1063) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.scanner.a.d dVar = (com.tencent.mm.plugin.scanner.a.d) kVar;
                hv hvVar = (dVar.gJQ == null || dVar.gJQ.hmh.hmo == null) ? null : (hv) dVar.gJQ.hmh.hmo;
                if (hvVar == null) {
                    x.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
                    return;
                } else if (hvVar.vNR != null) {
                    x.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
                    n.a bW = i.bW(hvVar.vNR, this.pWb);
                    if (this.pVZ != null && this.pVZ.field_xml != null && bW != null && bW.field_xml != null && !this.pVZ.field_xml.equals(bW.field_xml)) {
                        this.pVZ = bW;
                        a(this.pVZ);
                    } else if (!(bW == null || bW.field_xml == null)) {
                        this.pVZ = bW;
                        a(this.pVZ);
                    }
                    if (this.iln != null && this.iln.isShowing()) {
                        this.iln.dismiss();
                    }
                    bpk();
                    if (!this.pWk || this.pWl || TextUtils.isEmpty(this.lyH)) {
                        x.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.pWk + " mProductId:" + this.lyH + "  hasAddToHistory:" + this.pWl);
                        return;
                    }
                    this.pWn.field_xmlContent = hvVar.vNR;
                    this.pWn.field_funcType = this.pWb;
                    bpl();
                    return;
                } else {
                    return;
                }
            }
            x.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar.getType() == 1068 && i == 0 && i2 == 0) {
            List list = ((ht) ((com.tencent.mm.plugin.scanner.a.c) kVar).gJQ.hmh.hmo).vNQ;
            if (this.pVZ != null && k.b(this.pVZ.qbc, k.bD(list))) {
                b(this.pVZ);
            }
        }
    }

    private static String IG(String str) {
        String str2 = null;
        if (!bh.ov(str)) {
            try {
                str2 = Uri.parse(str).getQueryParameter("p");
            } catch (Exception e) {
                x.w("MicroMsg.scanner.ProductUI", str + ";" + e.getLocalizedMessage());
            }
        }
        return str2;
    }

    private void m(String str, String str2, boolean z) {
        this.lyH = str;
        this.pWh = str2;
        com.tencent.mm.ae.k dVar = new com.tencent.mm.plugin.scanner.a.d(str, this.irz, str2);
        ar.CG().a(dVar, 0);
        if (!z) {
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.eHP), new 8(this, dVar));
        }
    }

    private static boolean IH(String str) {
        ar.Hg();
        af WO = com.tencent.mm.z.c.EY().WO(str);
        if (WO == null || ((int) WO.gJd) <= 0 || !com.tencent.mm.l.a.fZ(WO.field_type)) {
            return false;
        }
        return true;
    }

    private int ahG() {
        if (this.pWb == 4) {
            return 11;
        }
        if (this.pWb == 3) {
            return 12;
        }
        return 0;
    }

    private void II(String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", i.vD(this.pWb));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        intent.putExtra("geta8key_scene", ahG());
        com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }

    private int bpj() {
        if (this.pWb == 3) {
            return 47;
        }
        return 49;
    }

    private void bpk() {
        if (this.pVZ != null) {
            x.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.pVZ.field_getaction);
            if ((this.pVZ.field_getaction & 2) > 0) {
                this.gyy = c.OP();
                if (this.gyy != null) {
                    this.gyy.b(this.gyF);
                }
            } else if ((this.pVZ.field_getaction & 1) > 0) {
                ar.CG().a(new com.tencent.mm.plugin.scanner.a.c(this.lyH, k.bC(this.pVZ.qbc), this.irz, this.pWh, 0.0d, 0.0d), 0);
            }
        }
    }

    private static void j(View view, float f) {
        Animation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void bpl() {
        if (com.tencent.mm.plugin.scanner.util.i.bpK()) {
            boolean c;
            com.tencent.mm.sdk.e.c aVar = new com.tencent.mm.plugin.scanner.history.a.a();
            aVar.field_productId = this.lyH;
            if (com.tencent.mm.plugin.scanner.c.boB().b(aVar, new String[0])) {
                c = com.tencent.mm.plugin.scanner.c.boB().c(this.pWn, new String[0]);
            } else {
                c = com.tencent.mm.plugin.scanner.c.boB().b(this.pWn);
            }
            if (c) {
                x.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
                this.pWl = true;
                return;
            }
            x.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
            return;
        }
        x.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
    }
}
