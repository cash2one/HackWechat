package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.k.g;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.rtmp.TXLiveConstants;

@a(23)
public class RedirectUI extends Activity {
    private static long gyK = 86400000;
    private boolean fAs = false;
    private long fqm;
    private final af handler = new af();
    private String info = "";
    private int kTK;
    private double nQx = 0.0d;
    private double nQy = 0.0d;
    private boolean nSI = true;
    private String nTq = "";
    private String nTr = "";
    private int nTs;
    private final int nTt = 1;
    private boolean nTu = false;
    private final int nTv = 0;
    private final int nTw = 1;
    private final int nTx = 0;
    private final int nTy = 1;
    private int type = 0;
    private int zoom = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        ar.Hg();
        if ((bh.by(Long.valueOf(bh.c((Long) c.CU().get(81938, null))).longValue()) * 1000 > gyK ? 1 : 0) != 0) {
            com.tencent.mm.az.c.QB().update();
        }
        this.type = getIntent().getIntExtra("map_view_type", -1);
        if (this.type == -1) {
            finish();
        }
        this.fqm = getIntent().getLongExtra("kMsgId", -1);
        this.nTr = getIntent().getStringExtra("map_talker_name");
        x.d("MicroMsg.RedirectUI", "tofutest type: %s", Integer.valueOf(this.type));
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                this.nTq = getIntent().getStringExtra("map_sender_name");
                this.kTK = getIntent().getIntExtra("view_type_key", 1);
                this.nTs = getIntent().getIntExtra("key_get_location_type", 0);
                j(-85.0d, -1000.0d);
                return;
            case 1:
            case 2:
            case 7:
            case 9:
                this.nQx = getIntent().getDoubleExtra("kwebmap_slat", -85.0d);
                this.nQy = getIntent().getDoubleExtra("kwebmap_lng", -1000.0d);
                this.zoom = getIntent().getIntExtra("kwebmap_scale", 0);
                this.info = getIntent().getStringExtra("Kwebmap_locaion");
                j(this.nQx, this.nQy);
                return;
            case 6:
                com.tencent.mm.plugin.location.a.a DB = l.aVv().DB(this.nTr);
                x.i("MicroMsg.RedirectUI", "resume try to enter trackRoom " + (DB != null));
                if (DB != null) {
                    this.nQx = DB.latitude;
                    this.nQy = DB.longitude;
                    this.info = DB.nQt;
                    x.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", Double.valueOf(this.nQx), Double.valueOf(this.nQy), this.info, Integer.valueOf(DB.fAX.size()));
                    this.zoom = 0;
                    j(this.nQx, this.nQy);
                    return;
                }
                j(-1000.0d, -1000.0d);
                return;
            default:
                return;
        }
    }

    private void j(double d, double d2) {
        this.fAs = true;
        Intent w = d.w(this);
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                String str = "MicroMsg.RedirectUI";
                StringBuilder stringBuilder = new StringBuilder("view poi      isHidePoiOversea : ");
                boolean z = bh.getInt(g.zZ().F("ShowConfig", "hidePoiOversea"), 1) == 1;
                x.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : " + z);
                x.d(str, stringBuilder.append(z).toString());
                w.putExtra("intent_map_key", 2);
                break;
            case 1:
            case 2:
            case 7:
                x.d("MicroMsg.RedirectUI", "view normal");
                w.putExtra("intent_map_key", 4);
                break;
            case 6:
                String stringExtra = getIntent().getStringExtra("fromWhereShare");
                x.d("MicroMsg.RedirectUI", "location resume");
                w.putExtra("intent_map_key", 5);
                if (!bh.ov(stringExtra)) {
                    w.putExtra("fromWhereShare", stringExtra);
                    break;
                }
                break;
            case 9:
                w.putExtra("intent_map_key", 4);
                break;
            default:
                x.d("MicroMsg.RedirectUI", "view type error");
                w = null;
                break;
        }
        switch (this.type) {
            case 0:
                w.putExtra("location_scene", 1);
                break;
        }
        if (r.icR) {
            this.handler.postDelayed(new 1(this, w, d, d2), 2000);
        } else {
            a(w, d, d2);
        }
    }

    private void a(Intent intent, double d, double d2) {
        if (intent != null) {
            intent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
            ar.Hg();
            intent.putExtra("kimg_path", c.Fi());
            intent.putExtra("kPoi_url", bh.az(getIntent().getStringExtra("kPoi_url"), ""));
            intent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
            intent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
            intent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
            intent.putExtra("kwebmap_slat", d);
            intent.putExtra("kwebmap_lng", d2);
            intent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
            intent.putExtra("kisUsername", bh.az(getIntent().getStringExtra("kisUsername"), ""));
            intent.putExtra("map_talker_name", this.nTr);
            intent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
            intent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
            b rjVar = new rj();
            rjVar.fJh.fJi = true;
            com.tencent.mm.sdk.b.a.xef.m(rjVar);
            if (this.type == 6) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                if (this.zoom > 0) {
                    intent.putExtra("kwebmap_scale", this.zoom);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 1 || this.type == 2 || this.type == 7 || this.type == 9) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                intent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
                if (this.zoom > 0) {
                    intent.putExtra("kwebmap_scale", this.zoom);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 0) {
                startActivityForResult(intent, 2);
                return;
            } else if (this.type == 3) {
                startActivityForResult(intent, 5);
                return;
            } else if (this.type == 8) {
                startActivityForResult(intent, 6);
                return;
            } else {
                return;
            }
        }
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:" + i);
        if (i2 != -1) {
            finish();
        } else if (intent == null) {
            finish();
        } else {
            LocationIntent locationIntent;
            switch (i) {
                case 2:
                    String str = this.nTr;
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    x.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bDI());
                    b lxVar = new lx();
                    lxVar.fDr.fDt = this.nTs;
                    lxVar.fDr.lat = locationIntent.lat;
                    lxVar.fDr.lng = locationIntent.lng;
                    lxVar.fDr.fzv = locationIntent.fzv;
                    lxVar.fDr.label = locationIntent.label;
                    lxVar.fDr.fDu = locationIntent.nTe;
                    com.tencent.mm.sdk.b.a.xef.m(lxVar);
                    double d = locationIntent.lat;
                    double d2 = locationIntent.lng;
                    int i3 = locationIntent.fzv;
                    String str2 = locationIntent.label;
                    String str3 = locationIntent.nTe;
                    String str4 = locationIntent.vcT;
                    if (str3 == null) {
                        str3 = "";
                    }
                    str3 = "<msg><location x=\"" + d + "\" y=\"" + d2 + "\" scale=\"" + i3 + "\" label=\"" + bh.VG(str2) + "\" poiname=\"" + bh.VG(str3) + "\" infourl=\"" + bh.VG(str4) + "\" maptype=\"0\" /></msg>";
                    x.d("MicroMsg.RedirectUI", "xml " + str3);
                    b orVar = new or();
                    orVar.fGI.fGJ = str;
                    orVar.fGI.content = str3;
                    orVar.fGI.type = 48;
                    orVar.fGI.flags = 0;
                    com.tencent.mm.sdk.b.a.xef.m(orVar);
                    o.a(TXLiveConstants.PLAY_EVT_PLAY_BEGIN, (float) locationIntent.lng, (float) locationIntent.lat, 0);
                    break;
                case 5:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    x.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bDI());
                    if (locationIntent.vcU == 3) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(10822, Integer.valueOf(1), locationIntent.nQB, Integer.valueOf(1));
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.h(10822, Integer.valueOf(1), locationIntent.nQB, Integer.valueOf(0));
                    }
                    intent.putExtra("kwebmap_slat", locationIntent.lat);
                    intent.putExtra("kwebmap_lng", locationIntent.lng);
                    intent.putExtra("kwebmap_scale", locationIntent.fzv);
                    intent.putExtra("Kwebmap_locaion", locationIntent.label);
                    intent.putExtra("kTags", intent.getStringArrayListExtra("kTags"));
                    intent.putExtra("kPoiName", locationIntent.nTe.equals("") ? "" : locationIntent.nTe);
                    break;
                case 6:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    x.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bDI());
                    if (locationIntent.hxN != null) {
                        x.d("MicroMsg.RedirectUI", "addr: " + locationIntent.hxN.toString());
                    }
                    intent.putExtra("key_pick_addr", locationIntent.hxN);
                    break;
            }
            setResult(i2, intent);
            finish();
        }
    }

    protected void onDestroy() {
        this.nSI = false;
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }
}
