package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;

public class i extends a implements e {
    private boolean fBV = true;
    protected long fqm = -1;
    private boolean kog = false;
    public d mfB = new d(this.activity);
    private long nVh = 0;
    boolean nYA = false;
    private Runnable nYB;
    private a$a nYC = new 4(this);
    private String nYx = "";
    n nYy;
    g nYz;

    public i(Activity activity) {
        super(activity);
        ar.CG().a(424, this);
    }

    public boolean aWt() {
        if (this.nYz == null || !this.nYz.isShowing()) {
            aWL();
            this.nYz.bUk();
        } else {
            this.nYz.bxh();
        }
        return true;
    }

    final void aWL() {
        this.nYz = new g(this.activity, g.ztp, false);
        this.nYz.rKC = new 1(this);
        this.nYz.rKD = new 2(this);
    }

    void aWr() {
        this.nVU.nWl.setEnabled(true);
        this.nVU.nWg.setVisibility(8);
        c(this.nVS);
        this.nVU.nTd.getIController().setZoom(this.zoom);
        this.nVU.nWj.setEnabled(true);
        this.fBV = this.activity.getIntent().getBooleanExtra("kShowshare", true);
        if (this.fBV) {
            this.nVU.nWj.setVisibility(0);
        } else {
            this.nVU.nWj.setVisibility(8);
        }
        this.nYx = this.activity.getIntent().getStringExtra("soso_street_view_url");
        if (!bh.ov(this.nYx) && (w.cfg() || w.cff())) {
            this.nYA = true;
        } else if (w.cfg() || w.cff()) {
            this.nYA = false;
            try {
                bea com_tencent_mm_protocal_c_bea = (bea) new ab((float) this.nVS.nQy, (float) this.nVS.nQx, this.fqm).gJQ.hmg.hmo;
                ab abVar = new ab(com_tencent_mm_protocal_c_bea);
                ar.CG().a(new ab(com_tencent_mm_protocal_c_bea), 0);
            } catch (Exception e) {
                x.e("MicroMsg.ViewMapUI", e.toString());
            }
        }
        this.nVU.nWj.setOnClickListener(new 3(this));
        this.nYy = new n(this.nVU.nTd, this.activity);
        n nVar = this.nYy;
        if (nVar.nVH != null) {
            nVar.nVH.setOnClickListener(new n$1(nVar));
            nVar.nVI.setVisibility(0);
        }
        a(this.nYy);
        this.nYy.b(this.nVS);
        this.nYy.DN("");
        if (!com.tencent.mm.plugin.location.model.e.h(this.nVS.nQx, this.nVS.nQy)) {
            x.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[]{Double.valueOf(this.nVS.nQx), Double.valueOf(this.nVS.nQy)});
            nVar = this.nYy;
            nVar.nTb = false;
            nVar.nTc.setVisibility(8);
        }
        if (2 == this.type) {
            x.i("MicroMsg.ViewMapUI", "location id %s", new Object[]{this.nVS.nQw});
            if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                aWo();
            }
            if (!bh.ov(this.nVS.nQz)) {
                this.nVU.nWh.setVisibility(0);
            }
        }
        this.nVW.put(this.nVS.nQw, this.nYy);
        if (this.nVS.aVl()) {
            if (!(this.nTe == null || this.nTe.equals(""))) {
                this.nYy.nTe = this.nTe;
            }
            this.nYy.setText(this.nYy.nSB + this.nVS.nQz);
        } else if (com.tencent.mm.plugin.location.model.e.h(this.nVS.nQx, this.nVS.nQy)) {
            this.nVX.a(this.nVS.nQx, this.nVS.nQy, this.nWe, this.nVS.nQw);
        }
        this.nVU.nWm = this.nYy.nVL;
        this.nVU.nWm.setOnClickListener(new 5(this));
        this.nVU.nWm.setVisibility(0);
    }

    protected void aWH() {
    }

    protected void aWF() {
    }

    protected final void aWM() {
        if (this.nYA) {
            r.a(new com.tencent.mm.pluginsdk.ui.tools.e());
            Intent intent = new Intent();
            intent.putExtra("show_bottom", false);
            intent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("rawUrl", this.nYx);
            intent.putExtra("title", R.l.eHB);
            intent.putExtra("webview_bg_color_rsID", R.e.black);
            com.tencent.mm.bm.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.nWd != null) {
            this.nWd.b(this.nYC, true);
        }
    }

    public void onPause() {
        x.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.nWd != null) {
            this.nWd.c(this.nYC);
        }
        super.onPause();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        double doubleExtra = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0d);
        x.i("MicroMsg.ViewMapUI", "start dslat " + doubleExtra + " " + doubleExtra2);
        this.zoom = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
        if (this.zoom <= 0) {
            this.zoom = 15;
        }
        this.nTe = this.activity.getIntent().getStringExtra("kPoiName");
        String stringExtra = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
        x.d("MicroMsg.ViewMapUI", "view " + doubleExtra + " " + doubleExtra2);
        LocationInfo locationInfo = this.nVS;
        locationInfo.nQx = doubleExtra;
        locationInfo.nQy = doubleExtra2;
        locationInfo.nQz = stringExtra;
        locationInfo.zoom = this.zoom;
        locationInfo.fDu = this.nTe;
        this.fqm = this.activity.getIntent().getLongExtra("kMsgId", -1);
        this.nRR = this.activity.getIntent().getStringExtra("map_talker_name");
        initView();
    }

    protected void aWq() {
        Intent intent = new Intent();
        intent.putExtra("kopenGmapNums", this.nVR.nSG);
        intent.putExtra("kopenOthersNums", this.nVR.nSH);
        intent.putExtra("kopenreportType", this.nVR.hJq);
        intent.putExtra("kRemark", aWp());
        intent.putExtra("soso_street_view_url", this.nYx);
        this.activity.setResult(-1, intent);
    }

    protected final void aWN() {
        x.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[]{Double.valueOf(this.nVS.nQx), Double.valueOf(this.nVS.nQy)});
        Intent intent = new Intent();
        intent.putExtra("kfavorite", true);
        intent.putExtra("kopenGmapNums", this.nVR.nSG);
        intent.putExtra("kopenOthersNums", this.nVR.nSH);
        intent.putExtra("kopenreportType", this.nVR.hJq);
        intent.putExtra("kRemark", aWp());
        intent.putExtra("kwebmap_slat", this.nVS.nQx);
        intent.putExtra("kwebmap_lng", this.nVS.nQy);
        intent.putExtra("Kwebmap_locaion", this.nVS.nQz);
        intent.putExtra("kPoiName", this.nTe);
        this.activity.setResult(-1, intent);
        this.activity.getIntent().getIntExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        this.activity.getIntent().getIntExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        this.activity.finish();
    }

    protected final void aWO() {
        com.tencent.mm.plugin.report.service.g.pQN.h(12809, new Object[]{Integer.valueOf(3), ""});
        x.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[]{Double.valueOf(this.nVS.nQx), Double.valueOf(this.nVS.nQy), Double.valueOf(this.nVT.nQx), Double.valueOf(this.nVT.nQy)});
        if (this.nVT.aVk()) {
            aWH();
            return;
        }
        this.nVY = true;
        if (this.handler != null) {
            if (this.nYB != null) {
                this.handler.removeCallbacks(this.nYB);
            }
            this.nYB = new 6(this);
            this.handler.postDelayed(this.nYB, 10000);
            Context context = this.activity;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.enA), true, new 7(this));
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4098:
            case 4099:
                com.tencent.mm.plugin.location.ui.d dVar = this.nVR;
                Intent intent2;
                switch (i) {
                    case 4098:
                        Bundle bundleExtra;
                        ArrayList parcelableArrayList;
                        if (-1 == i2 && intent != null) {
                            String stringExtra = intent.getStringExtra("selectpkg");
                            bundleExtra = intent.getBundleExtra("transferback");
                            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                            parcelableArrayList = bundleExtra.getParcelableArrayList("locations");
                            dVar.a((LocationInfo) parcelableArrayList.get(0), (LocationInfo) parcelableArrayList.get(1), stringExtra, booleanExtra);
                            return;
                        } else if (4097 == i2) {
                            if (intent.getBooleanExtra("isalways", false)) {
                                com.tencent.mm.plugin.report.service.g.pQN.h(11091, new Object[]{Integer.valueOf(6), Integer.valueOf(2)});
                            } else {
                                com.tencent.mm.plugin.report.service.g.pQN.h(11091, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                            }
                            parcelableArrayList = intent.getBundleExtra("transferback").getParcelableArrayList("locations");
                            LocationInfo locationInfo = (LocationInfo) parcelableArrayList.get(0);
                            LocationInfo locationInfo2 = (LocationInfo) parcelableArrayList.get(1);
                            Parcelable intent3 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (bh.ov(locationInfo.nQA) ? "zh-cn" : locationInfo.nQA), new Object[]{Double.valueOf(locationInfo2.nQx), Double.valueOf(locationInfo2.nQy), Double.valueOf(locationInfo.nQx), Double.valueOf(locationInfo.nQy)})));
                            bundleExtra = new Bundle();
                            bundleExtra.putParcelable("targetintent", intent3);
                            intent2 = new Intent();
                            intent2.setClass(dVar.context, AppChooserUI.class);
                            intent2.putExtra(DownloadSettingTable$Columns.TYPE, 1);
                            intent2.putExtra("title", dVar.context.getResources().getString(R.l.eta));
                            intent2.putExtra("targetintent", intent3);
                            intent2.putExtra("transferback", bundleExtra);
                            intent2.putExtra("scene", 6);
                            ((Activity) dVar.context).startActivityForResult(intent2, 4099);
                            return;
                        } else {
                            return;
                        }
                    case 4099:
                        if (-1 == i2 && intent != null) {
                            String stringExtra2 = intent.getStringExtra("selectpkg");
                            intent2 = new Intent((Intent) intent.getBundleExtra("transferback").getParcelable("targetintent"));
                            intent2.setPackage(stringExtra2);
                            intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                            dVar.context.startActivity(intent2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    public void onDestroy() {
        this.mfB.release();
        this.handler.removeCallbacks(this.nYB);
        this.handler = null;
        ar.CG().b(424, this);
        super.onDestroy();
    }

    protected final String WW() {
        return getString(R.l.etg);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nlE = motionEvent.getX();
                this.kCe = motionEvent.getY();
                this.nVh = System.currentTimeMillis();
                this.kog = false;
                aWG();
                break;
            case 1:
                if (!this.kog) {
                    System.currentTimeMillis();
                }
                aWE();
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.nlE) > 10.0f || Math.abs(motionEvent.getY() - this.kCe) > 10.0f) {
                    this.kog = true;
                    aWD();
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void aWD() {
        if (this.nYy != null) {
            this.nYy.gr(false);
        }
    }

    public void aWE() {
        if (this.nYy != null) {
            this.nYy.gr(true);
        }
    }

    public void aWG() {
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar.getType() != 424) {
            x.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i2 == 0 && i == 0) {
            String my = ab.my(((ab) kVar).Sn().vNZ);
            x.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[]{my});
            this.nYx = my;
            if (!bh.ov(my)) {
                this.nYA = true;
            }
            if (this.type == 9 && !bh.ov(my)) {
                TextView textView = (TextView) findViewById(R.h.cPz);
                textView.setVisibility(0);
                textView.setOnClickListener(new 8(this));
            }
        }
    }
}
