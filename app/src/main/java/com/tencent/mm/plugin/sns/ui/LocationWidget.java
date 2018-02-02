package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;

public class LocationWidget extends LinearLayout {
    float biF;
    private int fWj;
    private String fWq;
    private String hKZ;
    private float hxF;
    private float hxG;
    private boolean hxP;
    private Activity iQz;
    private a nQE;
    private String nTe;
    private b nVX;
    private aof oQI;
    private c oQb;
    float oQh;
    private com.tencent.mm.modelgeo.a.a oQt;
    private ImageView rrj;
    private TextView rsl;
    private View rtX;
    private View rtY;
    private int[] rtZ;
    private ImageView[] rua;
    private int rub;
    private TextView ruc;
    private byte[] rud;
    private String rue;
    private String ruf;
    private int rug;
    float ruh;
    int rui;
    a ruj;
    private boolean ruk;
    private b rul;
    private int score;

    public LocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rtZ = new int[]{f.qDm, f.qDn, f.qDo, f.qDp, f.qDq};
        this.rua = new ImageView[5];
        this.hxF = -1000.0f;
        this.hxG = -1000.0f;
        this.rug = 0;
        this.oQI = null;
        this.fWj = 0;
        this.ruh = 0.0f;
        this.oQh = 0.0f;
        this.biF = 0.0f;
        this.rui = -1;
        this.hxP = true;
        this.oQb = c.OP();
        this.ruj = null;
        this.ruk = false;
        this.nQE = new 3(this);
        this.oQt = new 4(this);
        this.rul = null;
        f((MMActivity) context);
    }

    public LocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rtZ = new int[]{f.qDm, f.qDn, f.qDo, f.qDp, f.qDq};
        this.rua = new ImageView[5];
        this.hxF = -1000.0f;
        this.hxG = -1000.0f;
        this.rug = 0;
        this.oQI = null;
        this.fWj = 0;
        this.ruh = 0.0f;
        this.oQh = 0.0f;
        this.biF = 0.0f;
        this.rui = -1;
        this.hxP = true;
        this.oQb = c.OP();
        this.ruj = null;
        this.ruk = false;
        this.nQE = new 3(this);
        this.oQt = new 4(this);
        this.rul = null;
        f((MMActivity) context);
    }

    private void f(MMActivity mMActivity) {
        this.iQz = mMActivity;
        View inflate = View.inflate(mMActivity, getLayoutResource(), this);
        this.rtX = inflate.findViewById(f.qCL);
        this.ruc = (TextView) this.rtX.findViewById(f.cue);
        this.rsl = (TextView) this.rtX.findViewById(f.qCN);
        this.rrj = (ImageView) this.rtX.findViewById(f.qCM);
        this.rtY = inflate.findViewById(f.qDl);
        for (int i = 0; i < 5; i++) {
            this.rua[i] = (ImageView) this.rtY.findViewById(this.rtZ[i]);
            this.rua[i].setOnClickListener(new 1(this, i));
        }
        this.nVX = b.ON();
        this.rtX.setOnClickListener(new 2(this));
        this.ruf = mMActivity.getIntent().getStringExtra("kpoi_id");
        if (!bh.ov(this.ruf)) {
            this.hxF = mMActivity.getIntent().getFloatExtra("k_lat", -1000.0f);
            this.hxG = mMActivity.getIntent().getFloatExtra("k_lng", -1000.0f);
            this.nTe = mMActivity.getIntent().getStringExtra("kpoi_name");
            this.rue = mMActivity.getIntent().getStringExtra("Kpoi_address");
            bzx();
        }
        if (g.Dh().Cy()) {
            this.rub = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsPostPOICommentSwitch"), 0);
        } else {
            this.rub = 0;
        }
        bzv();
    }

    private void bzv() {
        int i = 0;
        x.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", Integer.valueOf(this.rub), this.ruf, Integer.valueOf(this.rug), Integer.valueOf(this.fWj), Boolean.valueOf(bh.cgw()));
        if (bh.cgw() || this.rub == 0 || bh.ov(this.ruf) || this.rug == 1 || (this.fWj & 1) == 0) {
            this.rtY.setVisibility(8);
            return;
        }
        this.rtY.setVisibility(0);
        while (i < this.score) {
            this.rua[i].setImageResource(i.qJn);
            i++;
        }
        for (i = this.score; i < 5; i++) {
            this.rua[i].setImageResource(i.qJm);
        }
    }

    public final void bzw() {
        Intent intent = new Intent();
        intent.putExtra("near_life_scene", 1);
        try {
            intent.putExtra("get_poi_item_buf", this.oQI.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
        }
        if (!bh.ov(this.ruf)) {
            intent.putExtra("get_poi_classify_id", this.ruf);
        } else if (!bh.ov(this.fWq)) {
            intent.putExtra("get_city", this.fWq);
        }
        intent.putExtra("get_lat", this.hxF);
        intent.putExtra("get_lng", this.hxG);
        intent.putExtra("request_id", this.hKZ);
        if (this.ruj != null) {
            ArrayList bzC = this.ruj.bzC();
            if (bzC != null) {
                O(bzC);
                ArrayList arrayList = new ArrayList();
                Iterator it = bzC.iterator();
                while (it.hasNext()) {
                    Exif.a aVar = (Exif.a) it.next();
                    arrayList.add(String.format("%f\n%f", new Object[]{Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude)}));
                }
            }
        }
        d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 10);
    }

    private void O(ArrayList<Exif.a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Exif.a aVar;
            com.tencent.mm.plugin.report.service.g.pQN.k(11139, "1");
            if (((double) Math.abs(-1000.0f - this.hxF)) > 1.0E-6d && ((double) Math.abs(-1000.0f - this.hxG)) > 1.0E-6d) {
                aVar = (Exif.a) arrayList.get(arrayList.size() - 1);
                if (c(aVar.latitude, aVar.longitude, (double) this.hxF, (double) this.hxG)) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(11139, "2");
                }
            }
            int i = 0;
            while (i < arrayList.size()) {
                Object obj;
                for (int i2 = i + 1; i2 < arrayList.size(); i2++) {
                    aVar = (Exif.a) arrayList.get(i);
                    Exif.a aVar2 = (Exif.a) arrayList.get(i2);
                    if (c(aVar.latitude, aVar.longitude, aVar2.latitude, aVar2.longitude)) {
                        com.tencent.mm.plugin.report.service.g.pQN.k(11139, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                        obj = null;
                        break;
                    }
                }
                int i3 = 1;
                if (obj != null) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static boolean c(double d, double d2, double d3, double d4) {
        return r.d(d, d2, d3, d4) > 1000.0d;
    }

    public final void stop() {
        if (this.oQb != null) {
            this.oQb.c(this.oQt);
        }
        if (this.nVX != null) {
            this.nVX.a(this.nQE);
        }
    }

    public final boolean U(Intent intent) {
        if (intent != null) {
            this.rug = intent.getIntExtra("get_poi_classify_type", 0);
            this.fWj = intent.getIntExtra("get_poi_showflag", 0);
            x.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", Integer.valueOf(this.rug));
            this.nTe = bh.az(intent.getStringExtra("get_poi_name"), "");
            this.fWq = bh.az(intent.getStringExtra("get_city"), "");
            this.hxF = intent.getFloatExtra("get_lat", -1000.0f);
            this.hxG = intent.getFloatExtra("get_lng", -1000.0f);
            x.i("MicroMsg.LocationWidget", "check cur lat " + this.ruh + " " + this.oQh);
            this.ruh = intent.getFloatExtra("get_cur_lat", 0.0f);
            this.oQh = intent.getFloatExtra("get_cur_lng", 0.0f);
            this.rui = intent.getIntExtra("get_loctype", -1);
            this.biF = intent.getFloatExtra("get_accuracy", 0.0f);
            this.hxP = intent.getBooleanExtra("get_is_mars", true);
            this.hKZ = intent.getStringExtra("request_id");
            e.SS().a(2003, this.rui != 0, this.hxP, this.hxG, this.hxF, (int) this.biF);
            this.rud = intent.getByteArrayExtra("location_ctx");
            if (!bh.ov(this.nTe)) {
                this.rue = bh.az(intent.getStringExtra("get_poi_address"), "");
                this.ruf = bh.az(intent.getStringExtra("get_poi_classify_id"), "");
                this.oQI = new aof();
                try {
                    this.oQI = (aof) this.oQI.aF(intent.getByteArrayExtra("get_poi_item_buf"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
                    this.oQI = null;
                }
                if (!bh.ov(this.ruf)) {
                    this.oQI = new aof();
                    this.oQI.oPt = this.ruf;
                    this.oQI.ktN = this.rug;
                    this.oQI.fon = this.nTe;
                    this.oQI.oPy.add(new bdo().UA(this.rue));
                }
            } else if (bh.ov(this.fWq)) {
                this.hxF = -1000.0f;
                this.hxG = -1000.0f;
                this.nTe = "";
                this.rue = "";
                this.fWq = "";
                this.ruf = "";
                this.oQI = null;
            } else {
                this.nTe = "";
                this.rue = "";
                this.ruf = "";
                this.oQI = null;
            }
            x.d("MicroMsg.LocationWidget", "label %s poiname %s", this.rue, this.nTe);
            bzx();
            bzv();
            this.rul = new b(this);
            b bVar = this.rul;
            if (intent != null) {
                bVar.index = intent.getIntExtra("report_index", -1);
                bVar.oQk = intent.getLongExtra("first_start_time", 0);
                bVar.oQl = intent.getLongExtra("lastSuccStamp", 0);
                bVar.oQm = intent.getLongExtra("firstSuccStamp", 0);
                bVar.oQn = intent.getIntExtra("reqLoadCnt", 0);
                bVar.nXa = intent.getIntExtra("entry_time", 0);
                bVar.iRN = intent.getStringExtra("search_id");
            }
        }
        return true;
    }

    private void bzx() {
        if (!(this.ruc == null || this.rsl == null)) {
            if (!bh.ov(this.nTe)) {
                this.ruc.setText(this.nTe);
                this.rsl.setVisibility(8);
            } else if (bh.ov(this.fWq)) {
                this.ruc.setText(j.qLA);
                this.rsl.setVisibility(8);
            } else {
                this.ruc.setText(this.fWq);
                this.rsl.setVisibility(8);
            }
        }
        if (bh.ov(this.nTe) && bh.ov(this.fWq)) {
            this.rrj.setImageResource(bzy());
        } else {
            this.rrj.setImageResource(bzz());
        }
    }

    protected int bzy() {
        return i.qJg;
    }

    protected int bzz() {
        return i.qJh;
    }

    public final aoy bzA() {
        aoy com_tencent_mm_protocal_c_aoy = new aoy();
        com_tencent_mm_protocal_c_aoy.vQu = this.hxF;
        com_tencent_mm_protocal_c_aoy.vQt = this.hxG;
        com_tencent_mm_protocal_c_aoy.wvK = 0;
        com_tencent_mm_protocal_c_aoy.score = this.score;
        if (this.rud != null) {
            com_tencent_mm_protocal_c_aoy.wvL = new com.tencent.mm.bq.b(this.rud);
        }
        if (!bh.ov(this.nTe)) {
            com_tencent_mm_protocal_c_aoy.rue = this.rue;
            com_tencent_mm_protocal_c_aoy.nTe = this.nTe;
            com_tencent_mm_protocal_c_aoy.wvH = this.ruf;
            com_tencent_mm_protocal_c_aoy.hvv = this.fWq;
            if (this.rug == 0 || this.rug != 1) {
                com_tencent_mm_protocal_c_aoy.rug = 1;
            } else {
                com_tencent_mm_protocal_c_aoy.rug = 2;
            }
            x.d("MicroMsg.LocationWidget", "getlocation type %d", Integer.valueOf(com_tencent_mm_protocal_c_aoy.rug));
        } else if (!bh.ov(this.fWq)) {
            com_tencent_mm_protocal_c_aoy.hvv = this.fWq;
        }
        if (this.rul != null) {
            String format = String.format("%f/%f", new Object[]{Float.valueOf(com_tencent_mm_protocal_c_aoy.vQu), Float.valueOf(com_tencent_mm_protocal_c_aoy.vQt)});
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("index " + this.rul.index);
            stringBuffer.append("firstStartStamp " + this.rul.oQk);
            stringBuffer.append("lastSuccStamp " + this.rul.oQm);
            stringBuffer.append("firstSuccStamp " + this.rul.oQl);
            stringBuffer.append("reqLoadCnt " + this.rul.oQn);
            stringBuffer.append("classifyId " + this.ruf);
            stringBuffer.append("entryTime " + this.rul.nXa);
            stringBuffer.append("searchId" + this.rul.iRN);
            x.d("MicroMsg.LocationWidget", "report %s", stringBuffer.toString());
            com.tencent.mm.plugin.report.service.g.pQN.h(11135, Integer.valueOf(5), Integer.valueOf(this.rul.index + 1), Long.valueOf(this.rul.oQk), Long.valueOf(this.rul.oQm), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.rul.oQl), Integer.valueOf(this.rul.oQn), format, this.ruf, Integer.valueOf(this.rul.nXa), this.rul.iRN, q.yE());
        }
        bzB();
        return com_tencent_mm_protocal_c_aoy;
    }

    private void bzB() {
        if (this.ruj != null) {
            boolean bzD = this.ruj.bzD();
            ArrayList bzC = this.ruj.bzC();
            if (bzC != null && bzC.size() != 0) {
                Iterator it = bzC.iterator();
                while (it.hasNext()) {
                    int i;
                    Exif.a aVar = (Exif.a) it.next();
                    x.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude));
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf((int) (aVar.latitude * 1000000.0d));
                    objArr[1] = Integer.valueOf((int) (aVar.longitude * 1000000.0d));
                    if (bzD) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(2);
                    gVar.h(11345, objArr);
                }
            }
        }
    }

    protected int getLayoutResource() {
        return com.tencent.mm.plugin.sns.i.g.qCO;
    }
}
