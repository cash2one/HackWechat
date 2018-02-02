package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.location.model.h;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.g;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.protocal.c.adz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import com.tencent.mm.z.ar;

public final class c extends b implements e {
    private static int nXb = 11;
    private static int nXc = 12;
    private static int nXd = 13;
    private static int nXe = 14;
    private a gyF = new 9(this);
    private String hJy = "";
    private double lat = -85.0d;
    private double lng = -1000.0d;
    private String nQO = "";
    private int nQP = 1;
    private h nWA = null;
    private f nWB = null;
    private View nWC;
    private ImageButton nWD;
    ActionBarSearchView nWE;
    private TextView nWF;
    private com.tencent.mm.plugin.location.ui.e nWG;
    private g nWH;
    private double nWI = -85.0d;
    private double nWJ = -1000.0d;
    private boolean nWK = false;
    private int nWL = 0;
    private RelativeLayout nWM;
    private int nWN;
    private int nWO;
    private int nWP;
    private boolean nWQ = true;
    private boolean nWR = false;
    private boolean nWS = false;
    private FrameLayout nWT;
    private float nWU;
    private float nWV;
    private int nWW = 0;
    private long nWX = -1;
    private long nWY = -1;
    private long nWZ = -1;
    FrameLayout nWg;
    private View nWi;
    protected PoiHeaderView nWr;
    private PickPoi nWs;
    private MMLoadMoreListView nWt;
    private MMLoadMoreListView nWu;
    private View nWv;
    private e nWw;
    private e nWx;
    private View nWy;
    private ImageButton nWz;
    private int nXa = -1;
    private boolean nXf = false;
    private TextView titleView;

    static /* synthetic */ void f(c cVar) {
        int i = 1;
        x.i("MicroMsg.MMPoiMapUI", "loadingmore");
        if (cVar.nWA != null) {
            x.i("MicroMsg.MMPoiMapUI", "scene is doing");
            return;
        }
        byte[] bArr;
        if (cVar.nWK) {
            if (cVar.nWx.buffer == null) {
                x.i("MicroMsg.MMPoiMapUI", "buffer is null");
                return;
            }
            bArr = cVar.nWx.buffer;
        } else if (cVar.nWw.buffer == null) {
            x.i("MicroMsg.MMPoiMapUI", "buffer is null");
            return;
        } else {
            bArr = cVar.nWw.buffer;
        }
        int i2 = cVar.nWL == 0 ? 0 : 1;
        double d = cVar.lat;
        double d2 = cVar.lng;
        if (cVar.nWK) {
            i = 0;
        }
        cVar.nWA = new h(bArr, d, d2, i2, i, (double) cVar.nWV, (double) cVar.nWU, cVar.nQO, cVar.hJy);
        ar.CG().a(cVar.nWA, 0);
        cVar.nWW++;
    }

    static /* synthetic */ void p(c cVar) {
        int i = cVar.nWw.nXs;
        Intent intent = new Intent();
        Parcelable locationIntent = new LocationIntent();
        if (i >= 0 && i < cVar.nWw.getCount()) {
            f rS = cVar.nWw.rS(i);
            locationIntent.lat = rS.bhC;
            locationIntent.lng = rS.bhD;
            locationIntent.hxN = rS.nXI;
            locationIntent.nTe = rS.mName;
            locationIntent.label = rS.nXy;
            locationIntent.nQB = rS.nXz;
            locationIntent.vcU = rS.type;
            locationIntent.fzv = cVar.nTp.getZoomLevel();
            switch (cVar.type) {
                case 0:
                    i = nXb;
                    int i2 = cVar.nWw.nXs;
                    if (cVar.nXf) {
                        i = nXd;
                    }
                    cVar.i(i, i2, false);
                    break;
            }
            intent.putExtra("KLocationIntent", locationIntent);
            cVar.activity.setResult(-1, intent);
            cVar.activity.finish();
        }
    }

    static /* synthetic */ void u(c cVar) {
        cVar.nWK = true;
        cVar.nWu.cpq();
        cVar.nWu.ybX = new MMLoadMoreListView.a(cVar) {
            final /* synthetic */ c nXi;

            {
                this.nXi = r1;
            }

            public final void axW() {
                c.f(this.nXi);
            }
        };
        cVar.nWu.setOnItemClickListener(new 5(cVar));
        cVar.nWu.setOnTouchListener(new 6(cVar));
        cVar.nWt.setVisibility(8);
        cVar.nWu.setVisibility(0);
        cVar.nWu.setAdapter(cVar.nWx);
        cVar.nWu.cpq();
        cVar.findViewById(R.h.coo).setVisibility(8);
        cVar.nWE.setVisibility(0);
        cVar.nWE.zgt = new 7(cVar);
        new af().post(new 8(cVar));
    }

    public c(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(457, this);
        this.nXa = (int) (System.currentTimeMillis() / 1000);
        this.titleView = (TextView) findViewById(R.h.cvZ);
        this.titleView.setText(getString(R.l.etj));
        this.nWM = (RelativeLayout) findViewById(R.h.ctT);
        this.nWt = (MMLoadMoreListView) this.activity.findViewById(R.h.cDb);
        this.nWu = (MMLoadMoreListView) this.activity.findViewById(R.h.cJL);
        this.nWv = this.activity.findViewById(R.h.cJS);
        this.nWF = (TextView) findViewById(R.h.cJE);
        this.nWz = (ImageButton) findViewById(R.h.ctL);
        this.nWz.setContentDescription(getString(R.l.esX));
        this.nWr = (PoiHeaderView) findViewById(R.h.cDa);
        this.nTp.setBuiltInZoomControls(false);
        this.nWg = (FrameLayout) findViewById(R.h.bYV);
        this.nWG = new com.tencent.mm.plugin.location.ui.e(this.activity, R.g.bEI, this.nTp);
        this.nWH = new g(this.activity, this.nTp);
        this.nWs = new PickPoi(this.activity);
        PickPoi pickPoi = this.nWs;
        ((ImageView) pickPoi.nSz).setImageResource(R.g.bDs);
        this.nWg.addView(this.nWs);
        this.nWy = findViewById(R.h.ctl);
        this.nWi = this.activity.findViewById(R.h.cSj);
        this.nWC = (LinearLayout) this.activity.findViewById(R.h.cSl);
        this.nWC.setVisibility(0);
        switch (this.type) {
            case 0:
                ((TextView) findViewById(R.h.bIK)).setText(R.l.eti);
                break;
            case 3:
                ((TextView) findViewById(R.h.bIK)).setText(R.l.dFQ);
                break;
            case 8:
                ((TextView) findViewById(R.h.bIK)).setText(R.l.dFl);
                break;
        }
        this.nWD = (ImageButton) findViewById(R.h.cSs);
        this.nWD.setContentDescription(getString(R.l.eIW));
        this.nWE = (ActionBarSearchView) findViewById(R.h.cKf);
        gs(false);
        this.nWw = new e(this.activity);
        this.nWx = new e(this.activity);
        this.nWx.nXt = true;
        this.nWs.nXp = this.nWw;
        this.nWt.setAdapter(this.nWw);
        this.nWt.setOnTouchListener(new 1(this));
        ar.Hg();
        String str = (String) com.tencent.mm.z.c.CU().get(w.a.xqm, "");
        if (!bh.ov(str) && (this.nWI == -85.0d || this.nWJ == -1000.0d)) {
            String[] split = str.split(",");
            x.i("MicroMsg.MMPoiMapUI", "lastlocationinfo " + str);
            if (split.length == 2) {
                this.nTp.getIController().setCenter((double) ((float) ((((double) bh.VI(split[0])) * 1.0d) / 1000000.0d)), (double) ((float) ((((double) bh.VI(split[1])) * 1.0d) / 1000000.0d)));
            }
        }
        this.nWt.ybX = new 10(this);
        this.nWz.setOnClickListener(new 11(this));
        this.nWi.setOnClickListener(new 12(this));
        this.nWC.setOnClickListener(new 13(this));
        this.nWt.setOnItemClickListener(new 14(this));
        this.nWD.setOnClickListener(new 16(this));
        this.nWE.setHint(getString(R.l.etf));
        this.nWE.no(false);
        this.nWE.zgr = new 17(this);
        this.nWE.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ c nXi;

            {
                this.nXi = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                x.d("MicroMsg.MMPoiMapUI", "keyboard action");
                if (3 == i) {
                    this.nXi.fC(false);
                }
                return false;
            }
        });
        this.nWE.zgq = new 3(this);
        this.nWT = (FrameLayout) findViewById(R.h.cuW);
        this.nWN = b.b(this.activity, 280.0f);
        this.nWO = b.b(this.activity, 150.0f);
        int eB = com.tencent.mm.bv.a.eB(this.activity);
        int identifier = ac.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            identifier = ac.getResources().getDimensionPixelSize(identifier);
        } else {
            identifier = 0;
        }
        eB = ((eB - this.nWO) - identifier) - com.tencent.mm.bv.a.aa(this.activity, R.f.buG);
        if (eB > com.tencent.mm.bv.a.aa(this.activity, R.f.bxV)) {
            x.i("MicroMsg.MMPoiMapUI", "reset listview height: %s, statusBar: %s, actionBar: %s", new Object[]{Integer.valueOf(eB), Integer.valueOf(identifier), Integer.valueOf(r3)});
            LayoutParams layoutParams = this.nWM.getLayoutParams();
            layoutParams.height = eB;
            this.nWM.setLayoutParams(layoutParams);
        }
    }

    public final d aWu() {
        return (d) this.activity.findViewById(R.h.cks);
    }

    private void c(boolean z, long j) {
        a aVar;
        a aVar2;
        this.nWQ = false;
        if (z) {
            aVar = new a(this, (float) (-(aWw() - this.nWO)));
            aVar2 = new a(this, (float) ((-(aWw() - this.nWO)) / 2));
        } else {
            aVar = new a(this, (float) (this.nWN - aWw()));
            aVar2 = new a(this, (float) ((this.nWN - aWw()) / 2));
        }
        AnimationListener 15 = new 15(this, z);
        aVar.setDuration(200);
        aVar = aVar.aWB();
        aVar.setAnimationListener(15);
        aVar.co(this.nWM).co(this.nWz).anF();
        aVar2.setDuration(200);
        aVar2.aWB().co(this.nWT).anF();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        x.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent");
        if (this.nWK) {
            a(null);
            i(nXe, this.nWx.nXs, true);
            return false;
        }
        i(nXc, this.nWw.nXs, false);
        this.activity.finish();
        return true;
    }

    private void a(f fVar) {
        this.hJy = "";
        this.nWK = false;
        this.nWv.setVisibility(8);
        this.nWu.setVisibility(8);
        this.nWE.setVisibility(8);
        this.nWE.ZR("");
        this.nWF.setVisibility(8);
        this.nWt.setVisibility(0);
        this.nWt.setAdapter(this.nWw);
        this.nWw.notifyDataSetChanged();
        findViewById(R.h.coo).setVisibility(0);
        aWs();
        if (fVar != null) {
            this.nTp.getIController().setCenter(fVar.bhC, fVar.bhD);
            this.lat = fVar.bhC;
            this.lng = fVar.bhD;
            PickPoi pickPoi = this.nWs;
            pickPoi.k(this.lat, this.lng);
            pickPoi.nXo = false;
            fC(false);
        }
    }

    public final void aWv() {
        PickPoi pickPoi = this.nWs;
        pickPoi.nSz.clearAnimation();
        pickPoi.nSz.startAnimation(pickPoi.nSy);
        this.lat = ((double) this.nTp.getMapCenterX()) / 1000000.0d;
        this.lng = ((double) this.nTp.getMapCenterY()) / 1000000.0d;
        this.nWs.k(this.lat, this.lng);
        this.nWz.setBackgroundResource(R.g.bDu);
        if (this.nWS) {
            c(false, 200);
        }
        fC(false);
        this.nXf = false;
        this.nWw.nXf = false;
    }

    private void fC(boolean z) {
        if (this.nWH != null) {
            this.nWH.remove();
        }
        this.nQO = ((int) (this.lat * 1000000.0d)) + "_" + ((int) (this.lng * 1000000.0d)) + "_" + this.hJy;
        if (this.nQO.equals(this.nWw.aAM)) {
            x.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[]{this.nQO});
            return;
        }
        byte[] bArr = null;
        Object obj = 1;
        if (!this.nWK) {
            this.nWt.cpq();
            this.nWw.clean();
            this.nWw.DP(this.nQO);
            this.nWw.notifyDataSetChanged();
            bArr = this.nWw.buffer;
            this.nWy.setVisibility(0);
            gs(false);
            if (this.nWs.nXo) {
                this.nWw.b(this.nWs.nXn);
            }
        } else if (this.nQP > 0 && z) {
            this.nWu.cpq();
            e eVar = this.nWx;
            eVar.buffer = null;
            eVar.kMn = false;
            eVar.aAM = "";
            this.nWx.DP(this.nQO);
            this.nWx.muF = this.hJy;
            bArr = this.nWx.buffer;
        } else if (z) {
            obj = null;
        } else {
            this.nWu.cpq();
            this.nWx.clean();
            this.nWx.DP(this.nQO);
            this.nWx.muF = this.hJy;
            bArr = this.nWx.buffer;
            this.nWx.notifyDataSetChanged();
        }
        if (obj != null) {
            this.nWA = new h(bArr, this.lat, this.lng, this.nWL == 0 ? 0 : 1, this.nWK ? 0 : 1, (double) this.nWV, (double) this.nWU, this.nQO, this.hJy);
            ar.CG().a(this.nWA, 0);
            this.nWW++;
            if (this.nWZ == -1) {
                this.nWZ = System.currentTimeMillis();
                return;
            }
            return;
        }
        x.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[]{Integer.valueOf(this.nQP)});
    }

    private void i(int i, int i2, boolean z) {
        String str;
        Object obj;
        Object obj2;
        if (this.nWI == -85.0d || this.nWJ == -1000.0d) {
            str = "null/null";
        } else {
            str = String.format("%f/%f", new Object[]{Double.valueOf(this.nWI), Double.valueOf(this.nWJ)});
        }
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5;
        if (z) {
            if (this.nWx.nXs < this.nWx.getCount()) {
                str2 = this.nWx.rS(this.nWx.nXs).nXJ;
                str5 = this.nWx.rS(this.nWx.nXs).nXz;
                str3 = str2;
            }
            str5 = str3;
            str3 = str2;
        } else {
            if (this.nWw.nXs < this.nWw.getCount()) {
                str2 = this.nWw.rS(this.nWw.nXs).nXJ;
                obj = this.nWw.rS(this.nWw.nXs).nXz;
                str3 = str2;
            }
            str5 = str3;
            str3 = str2;
        }
        if (i2 == 0 && bh.ov(r1) && this.nWw.getCount() > 1) {
            x.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str3 = this.nWw.rS(1).nXJ;
        }
        if (this.nWw.getCount() <= 0 || z) {
            str2 = str4;
        } else {
            x.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[]{Integer.valueOf(i2)});
            obj2 = this.nWw.rS(0).hKZ;
        }
        if (i2 == 0 && !z && this.nWw.getCount() > 0) {
            int i3 = this.nWw.rS(0).nXK;
            if (i3 >= 0) {
                x.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[]{Integer.valueOf(i3)});
                i2 = i3;
            }
        }
        x.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.nWZ), Long.valueOf(this.nWY), Long.valueOf(this.nWX), Integer.valueOf(this.nWW), str, Integer.valueOf(this.nXa), str3, obj2});
        com.tencent.mm.plugin.report.service.g.pQN.h(11135, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.nWZ), Long.valueOf(this.nWY), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.nWX), Integer.valueOf(this.nWW), str, obj, Integer.valueOf(this.nXa), str3, q.yE(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), obj2});
    }

    public final void onResume() {
        super.onResume();
        com.tencent.mm.modelgeo.c.OP().b(this.gyF, true);
        com.tencent.mm.plugin.location.ui.e eVar = this.nWG;
        eVar.nSU.b(eVar.gyF, true);
    }

    public final int getLayoutId() {
        return R.i.dpl;
    }

    public final void onPause() {
        super.onPause();
        com.tencent.mm.modelgeo.c.OP().c(this.gyF);
        com.tencent.mm.plugin.location.ui.e eVar = this.nWG;
        eVar.nSU.c(eVar.gyF);
    }

    private void gs(boolean z) {
        x.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[]{Boolean.valueOf(z)});
        this.nWC.setEnabled(z);
        findViewById(R.h.bIK).setEnabled(z);
        this.nWD.setEnabled(z);
    }

    public final void onDestroy() {
        super.onDestroy();
        ar.CG().b(457, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 457 && i == 0 && i2 == 0) {
            this.nWA = null;
            h hVar = (h) kVar;
            if (hVar.nQO.equals(this.nQO)) {
                x.i("MicroMsg.MMPoiMapUI", "isend " + hVar.kMn + "searchId: " + hVar.iRN);
                if (this.nWX == -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.nWY = currentTimeMillis;
                    this.nWX = currentTimeMillis;
                } else {
                    this.nWY = System.currentTimeMillis();
                }
                this.nQP = hVar.nQP;
                if (this.nWK) {
                    this.nWv.setVisibility(8);
                    if (this.nWx.getCount() == 0 && hVar.list != null && hVar.list.size() == 0) {
                        this.nWF.setVisibility(0);
                        this.nWu.cpq();
                        return;
                    }
                    x.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[]{Boolean.valueOf(hVar.isFirst())});
                    if (hVar.isFirst()) {
                        this.nWx.nXr.clear();
                    }
                    this.nWx.a(hVar.list, hVar.nQN, hVar.kMn, hVar.nQO);
                    if (this.nWx.kMn) {
                        this.nWu.cpq();
                        return;
                    }
                    this.nWu.cpp();
                    this.nWu.cpr();
                    return;
                }
                if (this.nWr != null) {
                    adz com_tencent_mm_protocal_c_adz = (adz) hVar.gJQ.hmh.hmo;
                    PoiHeaderView poiHeaderView = this.nWr;
                    CharSequence charSequence = com_tencent_mm_protocal_c_adz.weY;
                    String str2 = com_tencent_mm_protocal_c_adz.wlX;
                    String str3 = com_tencent_mm_protocal_c_adz.nfX;
                    ar.Hg();
                    String Fi = com.tencent.mm.z.c.Fi();
                    x.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[]{str2, str3});
                    poiHeaderView.nTk = str3;
                    poiHeaderView.nTl = "";
                    if (bh.ov(charSequence) || bh.ov(str2)) {
                        poiHeaderView.setVisibility(8);
                        poiHeaderView.lbS.setVisibility(8);
                        poiHeaderView.nTm.setVisibility(8);
                    } else {
                        poiHeaderView.setVisibility(0);
                        poiHeaderView.lbS.setVisibility(0);
                        poiHeaderView.nTm.setVisibility(0);
                        poiHeaderView.lbS.setText(charSequence);
                        SimpleImageView simpleImageView = poiHeaderView.nTm;
                        simpleImageView.imagePath = Fi;
                        simpleImageView.url = str2;
                        simpleImageView.nUr = 0;
                        simpleImageView.mvv = 0;
                        if (str2 == null || str2.length() == 0) {
                            simpleImageView.setVisibility(8);
                        } else if (str2.startsWith("http")) {
                            r0 = BitmapFactory.decodeFile(simpleImageView.imagePath + com.tencent.mm.a.g.s(str2.getBytes()));
                            if (r0 != null) {
                                if (simpleImageView.nUr > 0 && simpleImageView.mvv > 0) {
                                    r0 = com.tencent.mm.sdk.platformtools.d.a(r0, simpleImageView.nUr, simpleImageView.mvv, true, false);
                                }
                                simpleImageView.setImageBitmap(r0);
                            } else {
                                com.tencent.mm.sdk.f.e.post(new SimpleImageView.a(str2, simpleImageView.handler), "SimpleImageView_download");
                            }
                        } else if (com.tencent.mm.a.e.bO(str2)) {
                            r0 = (simpleImageView.nUr <= 0 || simpleImageView.mvv <= 0) ? com.tencent.mm.sdk.platformtools.d.UN(str2) : com.tencent.mm.sdk.platformtools.d.d(str2, simpleImageView.nUr, simpleImageView.mvv, true);
                            if (r0 == null) {
                                simpleImageView.setVisibility(8);
                            } else {
                                simpleImageView.setImageBitmap(r0);
                            }
                        } else {
                            simpleImageView.setVisibility(8);
                        }
                    }
                }
                this.nWy.setVisibility(8);
                gs(true);
                if (this.nWB != null) {
                    for (f fVar : hVar.list) {
                        if (fVar.nXy != null && fVar.mName != null && fVar.nXy.equals(this.nWB.nXy) && fVar.mName.equals(this.nWB.mName)) {
                            hVar.list.remove(fVar);
                            break;
                        }
                    }
                    this.nWw.b(this.nWB);
                    this.nWB = null;
                    this.nXf = true;
                    this.nWw.nXf = true;
                }
                this.nWw.a(hVar.list, hVar.nQN, hVar.kMn, hVar.nQO);
                this.nWw.nXs = 0;
                this.nWw.notifyDataSetChanged();
                if (this.nWw.kMn) {
                    this.nWt.cpq();
                    return;
                }
                this.nWt.cpp();
                this.nWt.cpr();
                return;
            }
            x.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.nQO + " " + hVar.nQO);
        }
    }

    public final void rR(int i) {
        ((FrameLayout.LayoutParams) this.nWM.getLayoutParams()).topMargin = i;
        ((FrameLayout.LayoutParams) this.nWz.getLayoutParams()).topMargin = i - b.b(this.activity, 65.0f);
        int i2 = (i - this.nWP) / 2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nWT.getLayoutParams();
        if (i == this.nWO) {
            layoutParams.topMargin = b.b(this.activity, -65.0f);
        } else if (i == this.nWN) {
            layoutParams.topMargin = 0;
        } else {
            layoutParams.topMargin = i2 + layoutParams.topMargin;
        }
        this.nWT.requestLayout();
        this.nWP = i;
        this.nWM.requestLayout();
        this.nWz.requestLayout();
    }

    public final int aWw() {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nWM.getLayoutParams();
        this.nWP = marginLayoutParams.topMargin;
        return marginLayoutParams.topMargin;
    }
}
