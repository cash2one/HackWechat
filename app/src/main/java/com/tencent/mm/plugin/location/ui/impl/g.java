package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.m$a;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.protocal.c.axm;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.protocal.c.bod;
import com.tencent.mm.protocal.c.brr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends i implements a {
    private com.tencent.mm.modelgeo.a.a gyF = new 4(this);
    private View nTP;
    private m$a nVl = new m$a(this) {
        final /* synthetic */ g nYb;

        {
            this.nYb = r1;
        }
    };
    private Button nXL;
    MyLocationButton nXM;
    private TipSayingWidget nXN;
    m nXO;
    o nXP = l.aVu();
    com.tencent.mm.plugin.location.ui.l nXQ;
    k nXR;
    private i nXS;
    private c nXT = c.OP();
    private ShareHeader nXU;
    private String nXV;
    private long nXW = 0;
    private long nXX = 0;
    private b nXY = new 2(this);
    private o.a nXZ = new o.a(this) {
        final /* synthetic */ g nYb;

        {
            this.nYb = r1;
        }

        public final void aVG() {
            g gVar = this.nYb;
            com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(gVar.activity);
            aVar.EA(R.l.eRw);
            aVar.EC(R.l.dFU).a(new 9(gVar));
            aVar.akx().show();
        }
    };
    private HashMap<String, brr> nYa = new HashMap();
    private WakeLock wakeLock;

    static /* synthetic */ void a(g gVar, bbr com_tencent_mm_protocal_c_bbr) {
        com.tencent.mm.plugin.location.a.a aVar;
        x.d("MicroMsg.ShareMapUI", "refreshSuccess, timeout = %b", new Object[]{Boolean.valueOf(gVar.nXP.fhN)});
        List<brr> list = com_tencent_mm_protocal_c_bbr.wHZ;
        List<brr> linkedList = new LinkedList();
        com.tencent.mm.plugin.location.a.a DB = l.aVv().DB(gVar.nRR);
        if (DB == null) {
            DB = new com.tencent.mm.plugin.location.a.a();
            DB.latitude = -1000.0d;
            DB.longitude = -1000.0d;
            aVar = DB;
        } else {
            aVar = DB;
        }
        LinkedList linkedList2 = new LinkedList();
        for (brr com_tencent_mm_protocal_c_brr : list) {
            brr com_tencent_mm_protocal_c_brr2;
            linkedList2.add(com_tencent_mm_protocal_c_brr2.vIy);
        }
        if (!linkedList2.contains(q.FS())) {
            linkedList2.add(q.FS());
        }
        l.aVv().a(gVar.nRR, linkedList2, aVar.latitude, aVar.longitude, aVar.nQt, "", "");
        for (brr com_tencent_mm_protocal_c_brr22 : list) {
            if (Math.abs(com_tencent_mm_protocal_c_brr22.wTo.vNO) > 180.0d || Math.abs(com_tencent_mm_protocal_c_brr22.wTo.vNP) > 90.0d) {
                brr com_tencent_mm_protocal_c_brr3 = (brr) gVar.nYa.get(com_tencent_mm_protocal_c_brr22.vIy);
                if (com_tencent_mm_protocal_c_brr3 != null) {
                    linkedList.add(com_tencent_mm_protocal_c_brr3);
                    x.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f and use old one %f %f", new Object[]{com_tencent_mm_protocal_c_brr22.vIy, Double.valueOf(com_tencent_mm_protocal_c_brr22.wTo.vNP), Double.valueOf(com_tencent_mm_protocal_c_brr22.wTo.vNO), Double.valueOf(com_tencent_mm_protocal_c_brr3.wTo.vNP), Double.valueOf(com_tencent_mm_protocal_c_brr3.wTo.vNO)});
                } else {
                    x.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f cannot user old one", new Object[]{com_tencent_mm_protocal_c_brr22.vIy, Double.valueOf(com_tencent_mm_protocal_c_brr22.wTo.vNP), Double.valueOf(com_tencent_mm_protocal_c_brr22.wTo.vNO)});
                }
            } else {
                linkedList.add(com_tencent_mm_protocal_c_brr22);
            }
        }
        gVar.nYa.clear();
        for (brr com_tencent_mm_protocal_c_brr222 : linkedList) {
            gVar.nYa.put(com_tencent_mm_protocal_c_brr222.vIy, com_tencent_mm_protocal_c_brr222);
        }
        int size = linkedList.size();
        ArrayList arrayList = new ArrayList();
        arrayList.add(q.FS());
        if (size >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("refreshSuccess, count =  " + size);
            for (int i = 0; i < linkedList.size(); i++) {
                com_tencent_mm_protocal_c_brr222 = (brr) linkedList.get(i);
                stringBuilder.append("[" + com_tencent_mm_protocal_c_brr222.vIy + " ] ");
                stringBuilder.append(com_tencent_mm_protocal_c_brr222.wTo.wEE + " ");
                stringBuilder.append(com_tencent_mm_protocal_c_brr222.wTo.vNP + " ");
                stringBuilder.append(com_tencent_mm_protocal_c_brr222.wTo.vNO + " ");
                arrayList.add(com_tencent_mm_protocal_c_brr222.vIy);
            }
            x.v("MicroMsg.ShareMapUI", "refreshSuccess TrackRoom num: " + stringBuilder.toString());
            if (gVar.nXO != null) {
                gVar.nXO.bb(linkedList);
            }
        }
        if (gVar.nXO.nVa) {
            m mVar = gVar.nXO;
            bod com_tencent_mm_protocal_c_bod = com_tencent_mm_protocal_c_bbr.wIa;
            if (mVar.nVd == null) {
                mVar.nVd = new bod();
            }
            if (com_tencent_mm_protocal_c_bod != null) {
                x.d("MicroMsg.TrackPointViewMgrImpl", "set trackitem  " + com_tencent_mm_protocal_c_bod.vNP + " " + com_tencent_mm_protocal_c_bod.vNO);
                mVar.nVd.wCR = com_tencent_mm_protocal_c_bod.wCR;
                mVar.nVd.vNP = com_tencent_mm_protocal_c_bod.vNP;
                mVar.nVd.vNO = com_tencent_mm_protocal_c_bod.vNO;
            }
        }
        gVar.nXS.F(arrayList);
    }

    public final boolean aWt() {
        return true;
    }

    public g(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.ShareMapUI", "onCreate");
        this.nXW = System.currentTimeMillis();
    }

    final void aWr() {
        super.aWr();
        this.wakeLock = ((PowerManager) this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
        if (this.nYy != null) {
            n nVar = this.nYy;
            nVar.nVI.setVisibility(4);
            nVar.isVisible = false;
        }
        findViewById(R.h.coo).setVisibility(8);
        this.nXM = (MyLocationButton) findViewById(R.h.ctL);
        MyLocationButton myLocationButton = this.nXM;
        myLocationButton.nSL = this.nVU.nTd;
        myLocationButton.nSK.setVisibility(0);
        myLocationButton.nSJ.setVisibility(8);
        c.OP().b(myLocationButton.gyF, true);
        this.nXM.aVN();
        this.nXM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g nYb;

            {
                this.nYb = r1;
            }

            public final void onClick(View view) {
                this.nYb.nXM.aVN();
                this.nYb.nXO.nVe = true;
                this.nYb.nXO.a(this.nYb.nVU.nTd);
                this.nYb.nXO.gp(false);
                com.tencent.mm.plugin.report.service.g.pQN.h(10997, new Object[]{"6", "", Integer.valueOf(0), Integer.valueOf(0)});
            }
        });
        this.nTP = findViewById(R.h.con);
        this.nXU = (ShareHeader) findViewById(R.h.cNL);
        this.nXU.setVisibility(0);
        this.nXS = new i(this.activity, this.nXU.nTA, this.nTP, this.nRR, this.nVU.nTd);
        this.nXS.nTV = new 6(this);
        this.nXP.nRT = this.nXZ;
        if (this.nXO == null) {
            this.nXO = new m(this.activity, this.nVU.nTd, true);
        }
        this.nXO.nVl = this.nVl;
        this.nXO.nUZ = false;
        this.nXQ = new com.tencent.mm.plugin.location.ui.l(this.activity, this);
        this.nXN = (TipSayingWidget) findViewById(R.h.cIM);
        this.nXL = (Button) findViewById(R.h.cNN);
        this.nXL.setVisibility(0);
        this.nXR = new k(this.activity, this.nXL);
        this.nXR.nUI = this.nXS;
        this.nXU.nTB.setOnClickListener(new 7(this));
        this.nXU.nTC.setOnClickListener(new 8(this));
        ((LocationManager) this.activity.getSystemService("location")).isProviderEnabled("gps");
        o oVar = this.nXP;
        LocationInfo locationInfo = this.nVS;
        oVar.nRW = System.currentTimeMillis();
        oVar.hpO = c.OP();
        oVar.hpO.b(oVar.gyF, true);
        if (oVar.nRJ == null) {
            oVar.nRJ = l.aVw();
        }
        oVar.nRJ.a(oVar.nRY);
        if (locationInfo != null) {
            oVar.nRN = locationInfo;
        }
        if (oVar.fAs) {
            x.i("MicorMsg.TrackRefreshManager", "start location " + oVar.nRN.nQx + " " + oVar.nRN.nQy);
        } else {
            oVar.nRL = 1;
            oVar.nRM = new brr();
            oVar.nRM.wTo = new axm();
            oVar.nRM.wTo.vNP = -1000.0d;
            oVar.nRM.wTo.vNO = -1000.0d;
            x.i("MicorMsg.TrackRefreshManager", "start location imp " + oVar.nRN.nQx + " " + oVar.nRN.nQy);
            ar.CG().a(492, oVar);
            ar.CG().a(490, oVar);
            ar.CG().a(491, oVar);
            oVar.fhN = false;
            oVar.fAs = true;
        }
        o oVar2 = this.nXP;
        b bVar = this.nXY;
        Iterator it = oVar2.nRK.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                break;
            }
        }
        oVar2.nRK.add(new WeakReference(bVar));
        this.nXV = this.activity.getIntent().getStringExtra("fromWhereShare");
        x.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[]{this.nXV});
        if (this.nXP.aVz()) {
            x.i("MicroMsg.ShareMapUI", "has join");
            this.nXO.gq(true);
            this.nXR.aVX();
            return;
        }
        int i;
        String FS;
        com.tencent.mm.ae.k bVar2;
        o oVar3 = this.nXP;
        String str = this.nRR;
        if (!bh.ov(this.nXV)) {
            if (this.nXV.equals("fromBanner")) {
                i = 0;
            } else if (!this.nXV.equals("fromPluginLocation")) {
                if (this.nXV.equals("fromPluginTalk")) {
                    i = 2;
                } else if (this.nXV.equals("fromTrackButton")) {
                    i = 3;
                } else if (this.nXV.equals("fromMessage")) {
                    i = 4;
                }
            }
            x.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[]{str});
            oVar3.nRR = str;
            FS = q.FS();
            FS = str.contains("@chatroom") ? str : FS.compareTo(str) <= 0 ? str + FS : FS + str;
            bVar2 = new com.tencent.mm.plugin.location.model.a.b(FS);
            ((amy) bVar2.gJQ.hmg.hmo).rYW = i;
            ar.CG().a(bVar2, 0);
        }
        i = 1;
        x.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[]{str});
        oVar3.nRR = str;
        FS = q.FS();
        if (str.contains("@chatroom")) {
        }
        bVar2 = new com.tencent.mm.plugin.location.model.a.b(FS);
        ((amy) bVar2.gJQ.hmg.hmo).rYW = i;
        ar.CG().a(bVar2, 0);
    }

    public final void onResume() {
        boolean z;
        x.i("MicroMsg.ShareMapUI", "resume");
        super.onResume();
        this.wakeLock.acquire();
        o oVar = this.nXP;
        x.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + oVar.nRP);
        if (oVar.nRP) {
            oVar.nRW = System.currentTimeMillis();
            oVar.hpO.a(oVar.gyF);
            oVar.nRJ.a(oVar.nRY);
        }
        oVar.nRP = false;
        oVar.aVA();
        oVar = this.nXP;
        d dVar = this.nVU.nTd;
        oVar.nRL = oVar.nRQ;
        x.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + oVar.nRL + " %f %f %d ", new Object[]{Double.valueOf(oVar.nQx), Double.valueOf(oVar.nQy), Integer.valueOf(oVar.zoom)});
        if (oVar.nQx == -1000.0d || oVar.nQy == -1000.0d || oVar.zoom == -1) {
            z = false;
        } else {
            dVar.getIController().setCenter(oVar.nQx, oVar.nQy);
            dVar.getIController().setZoom(oVar.zoom);
            z = true;
        }
        if (z) {
            this.nXM.nSM = false;
            this.nXM.aVO();
            this.nXO.nVe = false;
            this.nXO.nUY = true;
        }
        oVar = this.nXP;
        d dVar2 = this.nVU.nTd;
        if (oVar.nRU != -1) {
            dVar2.getIController().setZoom(oVar.nRU);
        }
        if (this.nXT != null) {
            this.nXT.a(this.gyF);
        }
        if (this.nXO != null) {
            this.nXO.onResume();
        }
    }

    public final void onPause() {
        x.i("MicroMsg.ShareMapUI", "pause");
        super.onPause();
        this.wakeLock.release();
        o oVar = this.nXP;
        x.d("MicorMsg.TrackRefreshManager", "pause isShared:" + oVar.nRO);
        if (!oVar.nRO) {
            oVar.hpO.c(oVar.gyF);
            oVar.nRJ.b(oVar.nRY);
            oVar.nRP = true;
            oVar.nRV = true;
        }
        oVar = this.nXP;
        d dVar = this.nVU.nTd;
        oVar.nRQ = oVar.nRL;
        oVar.nRL = 0;
        x.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + oVar.nRQ);
        if (oVar.aVF()) {
            oVar.nQx = (((double) dVar.getMapCenterX()) * 1.0d) / 1000000.0d;
            oVar.nQy = (((double) dVar.getMapCenterY()) * 1.0d) / 1000000.0d;
            oVar.zoom = dVar.getZoom();
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(10997, new Object[]{"17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.nXW)});
        this.nXW = System.currentTimeMillis();
        if (this.nXT != null) {
            this.nXT.c(this.gyF);
        }
        if (this.nXO != null) {
            this.nXO.onPause();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        o oVar = this.nXP;
        b bVar = this.nXY;
        Iterator it = oVar.nRK.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                oVar.nRK.remove(weakReference);
                break;
            }
        }
        this.nXP.nRT = null;
        if (this.nXR != null) {
            Object obj = this.nXR;
            obj.nUH.b(obj);
            VolumeMeter volumeMeter = obj.nUu;
            volumeMeter.nVn = true;
            volumeMeter.huK = false;
            if (volumeMeter.nVr != null) {
                volumeMeter.nVr.getLooper().quit();
                volumeMeter.nVr = null;
            }
        }
        if (this.nXO != null) {
            this.nXO.destroy();
        }
        if (this.nXM != null) {
            c.OP().c(this.nXM.gyF);
        }
        x.i("MicroMsg.ShareMapUI", "onDestory");
    }

    public final void go(boolean z) {
    }

    protected final void aWq() {
        super.aWq();
    }

    public final void aWi() {
        this.nXP.nRU = this.nVU.nTd.getZoom();
        this.activity.finish();
    }

    private void aWC() {
        aWs();
        this.nXO.gq(false);
        this.nXP.stop();
        this.nXP.rM(3);
        k.aWa();
        this.nXP.nRU = this.nVU.nTd.getZoom();
        this.activity.finish();
    }

    public final void aWj() {
        this.nXO.gq(false);
        this.nXP.stop();
        this.nXP.rM(0);
        k.aWa();
        this.activity.finish();
    }

    public final void rQ(int i) {
        if (i == 0) {
            com.tencent.mm.plugin.report.service.g.pQN.h(10997, new Object[]{"8", "", Integer.valueOf(0), Integer.valueOf(0)});
            aWC();
        } else if (i == 1) {
            com.tencent.mm.plugin.report.service.g.pQN.h(10997, new Object[]{"8", "", Integer.valueOf(0), Integer.valueOf(0)});
            aWC();
        } else if (i == 2) {
            aWC();
        }
    }

    public final void aWk() {
        bod com_tencent_mm_protocal_c_bod = this.nXO.nVd;
        if (com_tencent_mm_protocal_c_bod != null) {
            LocationInfo locationInfo = this.nVS;
            locationInfo.nQz = com_tencent_mm_protocal_c_bod.wCR;
            locationInfo.nQy = com_tencent_mm_protocal_c_bod.vNO;
            locationInfo.nQx = com_tencent_mm_protocal_c_bod.vNP;
            if (TextUtils.isEmpty(com_tencent_mm_protocal_c_bod.wCR)) {
                this.nYy.setText("");
            } else {
                this.nYy.setText(com_tencent_mm_protocal_c_bod.wCR);
            }
            this.nYy.b(this.nVS);
            n nVar = this.nYy;
            nVar.nTd.updateLocaitonPinLayout(nVar.nTc, nVar.nQx, nVar.nQy);
            this.nVU.nTd.getIController().animateTo(this.nVS.nQx, this.nVS.nQy);
        }
    }

    public final void onBackPressed() {
        com.tencent.mm.plugin.report.service.g.pQN.h(10997, new Object[]{"11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        this.nXQ.aWh();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void aWD() {
        super.aWD();
        if (this.nXO != null) {
            this.nXO.nVe = false;
            this.nXO.gp(false);
            this.nXM.aVO();
        }
    }

    public final void aWE() {
        super.aWE();
    }

    protected final void aWF() {
        super.aWF();
        com.tencent.mm.plugin.report.service.g.pQN.h(10997, new Object[]{"1", "", Integer.valueOf(0), Integer.valueOf(0)});
    }
}
