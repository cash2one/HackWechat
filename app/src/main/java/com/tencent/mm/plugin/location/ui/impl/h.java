package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.location.a.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.f;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.1;
import com.tencent.mm.plugin.location.ui.l.3;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Map;

public final class h extends i {
    MyLocationButton nXM;
    m nXO;
    l nXQ;
    private Button nYc;
    private NewMyLocationButton nYd;
    private f nYe;
    private View nYf;
    private boolean nYg = false;
    private g nYh;
    Map<String, String> nYi;
    int nYj;

    static /* synthetic */ void a(h hVar) {
        x.i("MicroMsg.TrackMapUI", "onShare");
        d.w(hVar.activity);
        Intent intent = hVar.activity.getIntent();
        intent.putExtra("intent_map_key", 5);
        intent.putExtra("kwebmap_scale", hVar.nVU.nTd.getZoomLevel());
        a DB = com.tencent.mm.plugin.location.model.l.aVv().DB(hVar.nRR);
        if (DB != null && DB.fAX.size() > 0) {
            intent.putExtra("kwebmap_slat", DB.latitude);
            intent.putExtra("kwebmap_lng", DB.longitude);
            intent.putExtra("Kwebmap_locaion", DB.nQt);
            intent.putExtra("fromWhereShare", "fromTrackButton");
        }
        hVar.activity.startActivity(intent);
        hVar.activity.finish();
    }

    public h(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.Hg();
        this.nYj = ((Integer) c.CU().get(w.a.xvc, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.TrackMapUI", "count: %s", new Object[]{Integer.valueOf(this.nYj)});
    }

    final void aWr() {
        super.aWr();
        if (this.activity.getIntent().getBooleanExtra("KFavLocSigleView", false) && this.activity.getIntent().getBooleanExtra("kFavCanRemark", false)) {
            this.nYg = true;
        }
        x.d("MicroMsg.TrackMapUI", "oldVer %s", new Object[]{Boolean.valueOf(this.nYg)});
        ((TextView) findViewById(R.h.cvZ)).setText(R.l.ctO);
        findViewById(R.h.cSs).setVisibility(8);
        if (!this.nYg) {
            ViewStub viewStub = (ViewStub) findViewById(R.h.ctS);
            viewStub.setOnInflateListener(new 1(this));
            this.nYf = viewStub.inflate();
            findViewById(R.h.ctL).setVisibility(8);
        }
        this.nXO = new m(this.activity, this.nVU.nTd, false);
        this.nXO.nVe = false;
        this.nXO.nVf = false;
        m mVar = this.nXO;
        mVar.nVc = true;
        if (mVar.nUV != null) {
            mVar.nUV.h(null);
            mVar.nUV.g(null);
            mVar.nUV.aWI();
        }
        this.nXO.nUZ = false;
        this.nXQ = new l(this.activity, new 5(this));
        if (this.nYg) {
            boolean z;
            this.nYc = (Button) findViewById(R.h.cPi);
            this.nYc.setVisibility(0);
            this.nYc.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h nYk;

                {
                    this.nYk = r1;
                }

                public final void onClick(View view) {
                    boolean z = q.a.vcw != null && q.a.vcw.DC(this.nYk.nRR);
                    boolean z2;
                    if (q.a.vcp == null || !q.a.vcp.Mr(this.nYk.nRR)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z || !r2) {
                        l lVar = this.nYk.nXQ;
                        if (!l.rO(67589)) {
                            com.tencent.mm.ui.base.h.a(lVar.mContext, lVar.mResources.getString(R.l.etn), "", false, new 1(lVar), new 3(lVar));
                            l.rP(67589);
                            return;
                        } else if (lVar.nUR != null) {
                            lVar.nUR.go(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    b riVar = new ri();
                    riVar.fJc.fJe = true;
                    com.tencent.mm.sdk.b.a.xef.m(riVar);
                    if (this.nYk.nRR.equals(riVar.fJd.fJg)) {
                        com.tencent.mm.ui.base.h.a(this.nYk.activity, this.nYk.getString(R.l.ebD), "", this.nYk.getString(R.l.epk), false, new 1(this));
                    } else {
                        com.tencent.mm.ui.base.h.a(this.nYk.activity, this.nYk.getString(R.l.ebE), "", this.nYk.getString(R.l.epk), false, new 2(this));
                    }
                }
            });
            this.nYc.setEnabled(true);
            if (this.type == 2) {
                z = false;
            } else if (this.type == 3) {
                z = false;
            } else if (this.type == 7) {
                z = false;
            } else if (this.type == 9) {
                z = false;
            } else if (this.fqm != -1) {
                ar.Hg();
                cf dH = c.Fa().dH(this.fqm);
                z = (s.gF(dH.field_talker) || s.hk(dH.field_talker) || com.tencent.mm.storage.x.Wx(dH.field_talker) || com.tencent.mm.storage.x.Wz(dH.field_talker) || com.tencent.mm.storage.x.gy(dH.field_talker)) ? false : true;
            } else {
                z = true;
            }
            if (!z) {
                this.nYc.setVisibility(8);
            }
        } else {
            findViewById(R.h.cPi).setVisibility(8);
        }
        this.nVU.nWi.setOnClickListener(new 7(this));
        String stringExtra;
        if (this.nYg) {
            this.nXM = (MyLocationButton) findViewById(R.h.ctL);
            this.nXM.setOnClickListener(new 10(this));
            if (this.type == 2 && this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                ((MarginLayoutParams) this.nXM.getLayoutParams()).bottomMargin = com.tencent.mm.bv.a.fromDPToPix(this.activity, 80);
            }
            stringExtra = this.activity.getIntent().getStringExtra("kPoi_url");
            if (bh.ov(stringExtra)) {
                this.nVU.nWp.setVisibility(8);
            } else {
                this.nVU.nWp.setVisibility(0);
                this.nVU.nWp.setOnClickListener(new 11(this, stringExtra));
            }
        } else {
            this.nYd = (NewMyLocationButton) this.nYf.findViewById(R.h.cAa);
            this.nYd.setOnClickListener(new 8(this));
            stringExtra = this.activity.getIntent().getStringExtra("kPoi_url");
            if (bh.ov(stringExtra)) {
                this.nVU.nWp.setVisibility(8);
            } else {
                this.nVU.nWp.setVisibility(0);
                this.nVU.nWp.setOnClickListener(new 9(this, stringExtra));
            }
        }
        if (!this.nYg) {
            n nVar = this.nYy;
            int i = R.g.bDs;
            if (nVar.nTc != null && nVar.nVH == null) {
                nVar.nVH = (ImageView) nVar.nTc.findViewById(R.h.ctM);
            }
            nVar.nVH.setImageResource(i);
            this.nYy.nVJ.setVisibility(4);
            this.nYe = new f(this.nVU.nTd, this.activity);
            if (this.nVS.aVl()) {
                if (!(this.nTe == null || this.nTe.equals(""))) {
                    this.nYe.nTe = this.nTe;
                }
                this.nYe.setText(this.nYy.nSB + this.nVS.nQz);
            }
            OnClickListener anonymousClass4 = new OnClickListener(this) {
                final /* synthetic */ h nYk;

                {
                    this.nYk = r1;
                }

                public final void onClick(View view) {
                    x.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
                    this.nYk.fuA = 0;
                    this.nYk.aWF();
                    this.nYk.aWO();
                }
            };
            f fVar = this.nYe;
            fVar.nTh.setOnClickListener(anonymousClass4);
            fVar.nTh.setVisibility(0);
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            keyEvent.getAction();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void aWD() {
        super.aWD();
    }

    public final void aWE() {
        super.aWE();
    }

    public final void aWG() {
        super.aWG();
        x.i("MicroMsg.TrackMapUI", "onDown");
    }

    protected final void aWH() {
        this.nYh = new g(this.activity, g.ztp, false);
        this.nYh.rKC = new 2(this);
        this.nYh.rKD = new 3(this);
        this.nYh.bUk();
    }

    public final boolean d(LocationInfo locationInfo) {
        a DB = com.tencent.mm.plugin.location.model.l.aVv().DB(this.nRR);
        x.i("MicroMsg.TrackMapUI", "resume try to enter trackRoom " + (DB != null));
        if (DB == null) {
            return true;
        }
        if (!bh.ov(DB.nQt) && !bh.ov(locationInfo.nQz) && !DB.nQt.equals(locationInfo.nQz)) {
            return false;
        }
        if (Math.abs(DB.latitude - locationInfo.nQx) >= 0.001d || Math.abs(DB.longitude - locationInfo.nQy) >= 0.001d) {
            return false;
        }
        return true;
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.nXO != null) {
            this.nXO.destroy();
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.nXO != null) {
            this.nXO.onResume();
        }
        if (this.type == 2) {
            b fvVar = new fv();
            fvVar.fvq.fqk = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
            fvVar.fvq.type = 4;
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
            if (fvVar.fvr.auX != null) {
                if (this.nVZ == null) {
                    this.nVZ = new ArrayList();
                } else {
                    this.nVZ.clear();
                }
                this.nVZ.addAll(fvVar.fvr.auX);
                aWn();
            }
        }
    }

    public final void onPause() {
        super.onPause();
        if (this.nXO != null) {
            this.nXO.onPause();
        }
    }
}
