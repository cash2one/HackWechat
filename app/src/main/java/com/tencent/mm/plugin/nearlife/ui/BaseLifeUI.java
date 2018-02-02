package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseLifeUI extends MMActivity implements e {
    boolean gyB = false;
    protected String hKZ = "";
    boolean hnr = false;
    protected boolean hxP = true;
    protected String iRN = "";
    private p lcZ;
    private int nQP = 1;
    MMLoadMoreListView nWt;
    public int nXa = -1;
    boolean nXt = false;
    private boolean oOO = false;
    private String oPH = "";
    private View oPU;
    private NearLifeErrorContent oPV;
    private a oPW;
    private a oPX;
    private View oPY;
    private TextView oPZ;
    private TextView oQa;
    private c oQb = c.OP();
    private com.tencent.mm.plugin.nearlife.b.c oQc;
    private int oQd;
    private List<aog> oQe;
    protected aog oQf = null;
    protected float oQg = 0.0f;
    protected float oQh = 0.0f;
    protected int oQi = 0;
    protected float oQj = 0.0f;
    protected long oQk = -1;
    protected long oQl = -1;
    protected long oQm = -1;
    protected int oQn = 0;
    protected boolean oQo = false;
    protected int oQp = -1;
    protected boolean oQq = false;
    private OnClickListener oQr = new 1(this);
    private OnClickListener oQs = new 2(this);
    private a oQt = new 7(this);
    int sceneType = 0;

    public abstract a bff();

    public abstract a bfg();

    public abstract void l(double d, double d2);

    static /* synthetic */ void a(BaseLifeUI baseLifeUI) {
        if (baseLifeUI.oQd != -1 || baseLifeUI.oQc != null) {
            x.i("MicroMsg.BaseLifeUI", "is loading, please wait");
        } else if (baseLifeUI.gY(true)) {
            baseLifeUI.nWt.cpr();
        }
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, a aVar) {
        if (baseLifeUI.oQf == null) {
            x.e("MicroMsg.BaseLifeUI", "location is null");
            return;
        }
        Map hashMap = new HashMap();
        baseLifeUI.oQe.clear();
        if (aVar.oPS && baseLifeUI.oQf != null) {
            baseLifeUI.oQe.add(baseLifeUI.oQf);
            hashMap.put(new LatLongData(baseLifeUI.oQf.vQu, baseLifeUI.oQf.vQt), Integer.valueOf(1));
        }
        Iterator it = aVar.oPN.iterator();
        while (it.hasNext()) {
            LatLongData latLongData = (LatLongData) it.next();
            if (!hashMap.containsKey(latLongData)) {
                aog com_tencent_mm_protocal_c_aog = new aog();
                com_tencent_mm_protocal_c_aog.wct = "";
                com_tencent_mm_protocal_c_aog.wcu = 0;
                com_tencent_mm_protocal_c_aog.vQu = latLongData.fzt;
                com_tencent_mm_protocal_c_aog.vQt = latLongData.hBL;
                com_tencent_mm_protocal_c_aog.wcs = "";
                com_tencent_mm_protocal_c_aog.wcr = 0;
                baseLifeUI.oQe.add(com_tencent_mm_protocal_c_aog);
                hashMap.put(latLongData, Integer.valueOf(1));
            }
        }
        baseLifeUI.oQc = null;
        baseLifeUI.oQd = -1;
        x.i("MicroMsg.BaseLifeUI", "list size:" + baseLifeUI.oQe.size() + " show curpos: " + aVar.oPS);
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, String str) {
        x.d("MicroMsg.BaseLifeUI", "do auto query");
        baseLifeUI.tT(8);
        if (baseLifeUI.nQP <= 0) {
            x.i("MicroMsg.BaseLifeUI", "block by autoQueryInterval: %d", new Object[]{Integer.valueOf(baseLifeUI.nQP)});
            return;
        }
        aog com_tencent_mm_protocal_c_aog;
        if (baseLifeUI.oQc != null) {
            ar.CG().c(baseLifeUI.oQc);
            baseLifeUI.oQc = null;
        }
        if (baseLifeUI.oQe.size() > 0) {
            com_tencent_mm_protocal_c_aog = (aog) baseLifeUI.oQe.get(0);
        } else {
            x.i("MicroMsg.BaseLifeUI", "empty lbslist");
            com_tencent_mm_protocal_c_aog = new aog();
        }
        baseLifeUI.oQd = 0;
        baseLifeUI.oPX.GA(str);
        baseLifeUI.oQc = new com.tencent.mm.plugin.nearlife.b.c(1, baseLifeUI.sceneType, com_tencent_mm_protocal_c_aog.vQt, com_tencent_mm_protocal_c_aog.vQu, com_tencent_mm_protocal_c_aog.wcr, com_tencent_mm_protocal_c_aog.wcu, com_tencent_mm_protocal_c_aog.wcs, com_tencent_mm_protocal_c_aog.wct, null, baseLifeUI.nXt ? baseLifeUI.oPX.bfd() : "", baseLifeUI.nXa, false);
        ar.CG().a(baseLifeUI.oQc, 0);
    }

    static /* synthetic */ void b(BaseLifeUI baseLifeUI, String str) {
        if (!bh.ov(str)) {
            if (baseLifeUI.oQc == null || !str.equals(baseLifeUI.oQc.oPG)) {
                baseLifeUI.tT(8);
                if (baseLifeUI.oQc != null) {
                    ar.CG().c(baseLifeUI.oQc);
                }
                if (baseLifeUI.oQf != null) {
                    baseLifeUI.oPX.bfc();
                    baseLifeUI.oPX.GA(str);
                    baseLifeUI.gY(false);
                    baseLifeUI.nWt.cpr();
                }
            }
        }
    }

    static /* synthetic */ boolean d(float f, float f2, float f3, float f4) {
        return r.d((double) f, (double) f2, (double) f3, (double) f4) > 1000.0d;
    }

    public void bfh() {
        x.d("MicroMsg.BaseLifeUI", "init header");
        this.oPY = View.inflate(this, R.i.dfl, null);
        this.oPZ = (TextView) this.oPY.findViewById(R.h.cTe);
        this.oQa = (TextView) this.oPY.findViewById(R.h.cTd);
        this.oPY.setOnClickListener(this.oQs);
        this.oPU = View.inflate(this, R.i.dpr, null);
        this.nWt.addFooterView(this.oPU);
        this.oPU.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nXa = (int) (System.currentTimeMillis() / 1000);
        com.tencent.mm.plugin.nearlife.b.c.clear();
        ar.CG().a(603, this);
        this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
        this.hKZ = getIntent().getStringExtra("request_id");
        this.oQe = new ArrayList();
        initView();
        this.nWt.cpr();
        if (this.oQb != null) {
            this.oQb.b(this.oQt);
        }
        this.hnr = false;
    }

    public final void initView() {
        this.nWt = (MMLoadMoreListView) findViewById(R.h.cyK);
        MMLoadMoreListView mMLoadMoreListView = this.nWt;
        mMLoadMoreListView.ybZ.setText(getString(R.l.ewW));
        this.oPV = (NearLifeErrorContent) findViewById(R.h.cyJ);
        bfh();
        this.oPW = bff();
        this.oPX = bfg();
        this.nWt.setAdapter(this.oPW);
        this.oPV.inm = this.nWt;
        this.oPW.notifyDataSetChanged();
        setBackBtn(new 3(this));
        AnonymousClass4 anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ BaseLifeUI oQu;

            {
                this.oQu = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.oQu.nWt);
            }
        };
        this.lcZ = new p(true, true);
        this.lcZ.zms = new b(this) {
            final /* synthetic */ BaseLifeUI oQu;

            {
                this.oQu = r1;
            }

            public final void Xt() {
                x.d("MicroMsg.BaseLifeUI", "click clear");
                if (this.oQu.oQc != null) {
                    ar.CG().c(this.oQu.oQc);
                    this.oQu.oQc = null;
                }
                this.oQu.oPX.bfc();
                this.oQu.tT(8);
            }

            public final void Xu() {
            }

            public final void oL(String str) {
                x.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[]{str});
                if (bh.ov(str)) {
                    Xt();
                } else {
                    BaseLifeUI.a(this.oQu, str);
                }
            }

            public final void Xr() {
                x.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
                this.oQu.nXt = false;
                this.oQu.nWt.setAdapter(this.oQu.oPW);
                this.oQu.oPW.notifyDataSetChanged();
                this.oQu.oPV.tU(this.oQu.oPW.oPT);
                if (!(this.oQu.oPW.bfe() || this.oQu.oPU == null)) {
                    this.oQu.oPU.setVisibility(0);
                }
                this.oQu.nWt.setOnTouchListener(null);
                this.oQu.tT(8);
                BaseLifeUI.a(this.oQu, this.oQu.oPW);
            }

            public final void Xs() {
                x.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
                this.oQu.oQo = true;
                this.oQu.lcZ.setHint(this.oQu.getString(R.l.ewV));
                this.oQu.nXt = true;
                this.oQu.oPX.bfc();
                this.oQu.nWt.setAdapter(this.oQu.oPX);
                this.oQu.oPX.notifyDataSetChanged();
                this.oQu.nWt.cpq();
                this.oQu.oPV.tU(this.oQu.oPX.oPT);
                if (this.oQu.oPU != null) {
                    this.oQu.oPU.setVisibility(8);
                }
                this.oQu.nWt.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ AnonymousClass5 oQv;

                    {
                        this.oQv = r1;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        this.oQv.oQu.aWs();
                        return false;
                    }
                });
                BaseLifeUI.a(this.oQu, this.oQu.oPX);
            }

            public final boolean oK(String str) {
                x.d("MicroMsg.BaseLifeUI", "search key click");
                BaseLifeUI.b(this.oQu, str);
                return false;
            }
        };
        this.nWt.ybX = new MMLoadMoreListView.a(this) {
            final /* synthetic */ BaseLifeUI oQu;

            {
                this.oQu = r1;
            }

            public final void axW() {
                BaseLifeUI.a(this.oQu);
            }
        };
        this.nWt.cpp();
    }

    protected void onResume() {
        super.onResume();
        this.oPW.notifyDataSetChanged();
        this.oQb.a(this.oQt, true);
    }

    protected void onDestroy() {
        ar.CG().b(603, this);
        super.onDestroy();
        if (this.oQb != null) {
            this.oQb.c(this.oQt);
        }
    }

    protected void onPause() {
        super.onPause();
        this.oQb.c(this.oQt);
    }

    protected int getLayoutId() {
        return R.i.doH;
    }

    private boolean gY(boolean z) {
        while (this.oQc == null) {
            if (this.oQe.size() - 1 <= this.oQd) {
                this.oQd = -1;
                x.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
                return false;
            }
            int b;
            this.oQd++;
            aog com_tencent_mm_protocal_c_aog = (aog) this.oQe.get(this.oQd);
            if (this.oQd == 0) {
                this.oQn++;
            }
            if (this.nXt) {
                b = this.oPX.b(new LatLongData(com_tencent_mm_protocal_c_aog.vQu, com_tencent_mm_protocal_c_aog.vQt));
                continue;
            } else {
                b = this.oPW.b(new LatLongData(com_tencent_mm_protocal_c_aog.vQu, com_tencent_mm_protocal_c_aog.vQt));
                continue;
            }
            if (b > 0) {
                bdn a;
                if (this.nXt) {
                    a = this.oPX.a(new LatLongData(com_tencent_mm_protocal_c_aog.vQu, com_tencent_mm_protocal_c_aog.vQt));
                } else {
                    a = this.oPW.a(new LatLongData(com_tencent_mm_protocal_c_aog.vQu, com_tencent_mm_protocal_c_aog.vQt));
                }
                int i = this.nXt ? 1 : 0;
                if (com.tencent.mm.plugin.nearlife.b.c.tQ(i)) {
                    if (-1 == this.oQk) {
                        this.oQk = System.currentTimeMillis();
                    }
                    this.oQc = new com.tencent.mm.plugin.nearlife.b.c(i, this.sceneType, com_tencent_mm_protocal_c_aog.vQt, com_tencent_mm_protocal_c_aog.vQu, com_tencent_mm_protocal_c_aog.wcr, com_tencent_mm_protocal_c_aog.wcu, com_tencent_mm_protocal_c_aog.wcs, com_tencent_mm_protocal_c_aog.wct, a, this.nXt ? this.oPX.bfd() : "", this.nXa, z);
                    ar.CG().a(this.oQc, 0);
                    x.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[]{Integer.valueOf(this.oQd), Float.valueOf(com_tencent_mm_protocal_c_aog.vQu), Float.valueOf(com_tencent_mm_protocal_c_aog.vQt)});
                    return true;
                }
                this.oQd = -1;
                return false;
            }
        }
        x.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 603) {
            this.nWt.cpq();
            com.tencent.mm.plugin.nearlife.b.c cVar = (com.tencent.mm.plugin.nearlife.b.c) kVar;
            if (!bh.ov(cVar.oPH)) {
                this.oPH = cVar.oPH;
                LogoImageView logoImageView = (LogoImageView) this.oPU.findViewById(R.h.cEl);
                String str2 = this.oPH;
                ar.Hg();
                logoImageView.imagePath = com.tencent.mm.z.c.Fj();
                logoImageView.url = str2;
                logoImageView.nUr = 0;
                logoImageView.mvv = 0;
                if (str2 == null || str2.length() == 0) {
                    logoImageView.setVisibility(8);
                } else if (str2.startsWith("http")) {
                    r2 = BitmapFactory.decodeFile(logoImageView.imagePath + g.s(str2.getBytes()));
                    if (r2 != null) {
                        if (logoImageView.nUr > 0 && logoImageView.mvv > 0) {
                            r2 = d.a(r2, logoImageView.nUr, logoImageView.mvv, true, false);
                        }
                        logoImageView.setImageBitmap(r2);
                    } else {
                        com.tencent.mm.sdk.f.e.post(new LogoImageView.a(str2, logoImageView.handler), "LogoImageView_download");
                    }
                } else if (com.tencent.mm.a.e.bO(str2)) {
                    r2 = (logoImageView.nUr <= 0 || logoImageView.mvv <= 0) ? d.UN(str2) : d.d(str2, logoImageView.nUr, logoImageView.mvv, true);
                    if (r2 == null) {
                        logoImageView.setVisibility(8);
                    } else {
                        logoImageView.setImageBitmap(r2);
                    }
                } else {
                    logoImageView.setVisibility(8);
                }
            }
            this.iRN = cVar.iRN;
            this.nQP = cVar.nQP;
            com.tencent.mm.plugin.nearlife.b.c.tR(((com.tencent.mm.plugin.nearlife.b.c) kVar).fut);
            if (this.oQc == null) {
                x.d("MicroMsg.BaseLifeUI", "scene is null");
                return;
            }
            x.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[]{Integer.valueOf(this.oQd), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(r1)});
            boolean z = i2 == 0 || i2 == 101;
            a aVar;
            if (i == 0 || z) {
                if (-1 == this.oQl) {
                    this.oQl = System.currentTimeMillis();
                }
                this.oQm = System.currentTimeMillis();
                List list = cVar.oPI;
                aog com_tencent_mm_protocal_c_aog = (aog) this.oQe.get(this.oQd);
                LatLongData latLongData = new LatLongData(com_tencent_mm_protocal_c_aog.vQu, com_tencent_mm_protocal_c_aog.vQt);
                if (this.nXt && !this.oQc.oPJ) {
                    this.oPX.bfc();
                }
                if (this.nXt) {
                    this.oPX.a(latLongData, cVar.bfb(), cVar.bfa());
                } else {
                    this.oPW.a(latLongData, cVar.bfb(), cVar.bfa());
                }
                if (list == null || list.size() == 0) {
                    aVar = this.nXt ? this.oPX : this.oPW;
                    if (this.oQe.size() - 1 == this.oQd) {
                        if (aVar.getCount() == 0) {
                            this.oPV.tU(aVar.oPT);
                        }
                        this.nWt.cpq();
                        if (!(aVar.bfe() || i2 == 101)) {
                            bfi();
                        }
                    }
                } else {
                    aVar = this.nXt ? this.oPX : this.oPW;
                    z = this.oQc.oPJ;
                    this.nWt.setVisibility(0);
                    aVar.oPT = 0;
                    this.oPV.tU(this.oPX.oPT);
                    aVar.a(latLongData, list);
                    aVar.notifyDataSetChanged();
                    if (this.oQe.size() - 1 == this.oQd && !aVar.bfe()) {
                        this.nWt.cpq();
                        bfi();
                    }
                }
                if (!(this.oPW.bfe() || this.oPU == null || this.nXt)) {
                    this.oPU.setVisibility(0);
                }
                if (this.oPU != null && !this.nXt) {
                    this.oPU.setVisibility(0);
                } else if (this.oPU != null) {
                    this.oPU.setVisibility(8);
                }
            } else {
                x.d("MicroMsg.BaseLifeUI", "error");
                if (this.nXt) {
                    aVar = this.oPX;
                } else {
                    aVar = this.oPW;
                }
                if (this.oQe.size() - 1 == this.oQd && aVar.getCount() == 0) {
                    aVar.oPT = 1;
                    this.oPV.tU(aVar.oPT);
                }
            }
            this.oQc = null;
            gY(false);
        }
    }

    private void bfi() {
        if (this.nXt) {
            int i;
            try {
                x.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[]{Integer.valueOf(Integer.valueOf(com.tencent.mm.k.g.zY().getValue("POICreateForbiden")).intValue())});
                if (Integer.valueOf(com.tencent.mm.k.g.zY().getValue("POICreateForbiden")).intValue() == 1) {
                    return;
                }
            } catch (Exception e) {
            }
            a aVar = this.oPX;
            String trim = this.oPX.bfd().trim();
            Iterator it = aVar.oPL.iterator();
            while (it.hasNext()) {
                if (trim.equals(((com.tencent.mm.plugin.nearlife.b.a) it.next()).fon.trim())) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                this.oPZ.setText(String.format(getResources().getString(R.l.exV), new Object[]{this.oPX.bfd()}));
                tT(0);
                return;
            }
            tT(8);
            return;
        }
        x.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 1:
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    protected final void a(int i, boolean z, String str) {
        int i2;
        String str2;
        Object obj;
        if (str != null && str.startsWith("mm_")) {
            str = "";
        }
        String str3 = "";
        String str4 = "";
        if (i >= 0) {
            i2 = z ? 3 : 1;
            if (this.oQq) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(z ? 5 : 4);
                gVar.h(11139, objArr);
            }
            if (z) {
                str2 = this.oPX.tS(i).nXJ;
                if (this.oPX.getCount() > 0) {
                    str3 = this.oPX.tS(1).hKZ;
                    obj = str2;
                }
                str3 = str4;
                str4 = str2;
            } else {
                str2 = this.oPW.tS(i).nXJ;
                if (this.oPW.getCount() > 0) {
                    str3 = this.oPW.tS(1).hKZ;
                    str4 = str2;
                }
                str3 = str4;
                str4 = str2;
            }
            if (bh.ov(str3)) {
                str3 = this.hKZ;
            }
        } else {
            i2 = this.oQo ? 4 : 2;
            String str5 = str4;
            str4 = str3;
            str3 = str5;
        }
        if (this.oQf == null) {
            str2 = "null/null";
        } else {
            str2 = String.format("%f/%f", new Object[]{Float.valueOf(this.oQf.vQu), Float.valueOf(this.oQf.vQt)});
        }
        x.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[]{Integer.valueOf(i + 1), str, Integer.valueOf(i), obj, str3});
        com.tencent.mm.plugin.report.service.g.pQN.h(11135, new Object[]{Integer.valueOf(i2), Integer.valueOf(i + 1), Long.valueOf(this.oQk), Long.valueOf(this.oQm), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.oQl), Integer.valueOf(this.oQn), str2, str, Integer.valueOf(this.nXa), obj, q.yE(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str3});
    }

    private void tT(int i) {
        this.nWt.removeFooterView(this.oPU);
        this.nWt.removeFooterView(this.oPY);
        MMLoadMoreListView mMLoadMoreListView = this.nWt;
        mMLoadMoreListView.removeFooterView(mMLoadMoreListView.lBB);
        this.oPY.setVisibility(i);
        this.oPZ.setVisibility(i);
        this.oQa.setVisibility(i);
        if (i == 0) {
            this.nWt.addFooterView(this.oPY);
            return;
        }
        mMLoadMoreListView = this.nWt;
        if (mMLoadMoreListView.lBB == null) {
            mMLoadMoreListView.cpo();
        }
        try {
            mMLoadMoreListView.removeFooterView(mMLoadMoreListView.lBB);
            mMLoadMoreListView.addFooterView(mMLoadMoreListView.lBB);
        } catch (Exception e) {
        }
        this.nWt.addFooterView(this.oPU);
    }
}
