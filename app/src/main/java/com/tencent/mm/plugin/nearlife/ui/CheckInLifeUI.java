package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI extends BaseLifeUI implements e {
    private String fWq = "";
    private OnClickListener npY = new 1(this);
    private b oQE;
    private b oQF;
    private ArrayList<LatLongData> oQG;
    private b oQH = null;
    private aof oQI;
    private OnClickListener oQJ = new 2(this);
    private a oQK = new 3(this);
    private String oQy = "";

    static /* synthetic */ void a(CheckInLifeUI checkInLifeUI, View view, boolean z) {
        x.d("MicroMsg.CheckInLifeUI", "click tag");
        if (view.getTag() instanceof b.a) {
            LatLongData GB;
            int GC;
            b.a aVar = (b.a) view.getTag();
            com.tencent.mm.plugin.nearlife.b.a aVar2 = aVar.oQA;
            Intent intent = new Intent();
            try {
                intent.putExtra("get_poi_item_buf", aVar2.oPC.toByteArray());
                intent.putExtra("location_ctx", aVar2.oPB.wJD.oz);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            }
            if (z) {
                GB = checkInLifeUI.oQF.GB(aVar.oPt);
                GC = checkInLifeUI.oQF.GC(aVar.oPt);
                checkInLifeUI.a(GC, true, aVar.oPt);
            } else {
                GB = checkInLifeUI.oQE.GB(aVar.oPt);
                GC = checkInLifeUI.oQE.GC(aVar.oPt);
                checkInLifeUI.a(GC, false, aVar.oPt);
            }
            intent.putExtra("report_index", GC);
            intent.putExtra("first_start_time", checkInLifeUI.oQk);
            intent.putExtra("lastSuccStamp", checkInLifeUI.oQm);
            intent.putExtra("firstSuccStamp", checkInLifeUI.oQl);
            intent.putExtra("reqLoadCnt", checkInLifeUI.oQn);
            intent.putExtra("entry_time", checkInLifeUI.nXa);
            intent.putExtra("search_id", aVar2.nXJ);
            intent.putExtra("request_id", aVar2.hKZ);
            if (GB == null) {
                GB = checkInLifeUI.oQf == null ? new LatLongData(-85.0f, -1000.0f) : new LatLongData(checkInLifeUI.oQf.vQu, checkInLifeUI.oQf.vQt);
            }
            x.i("MicroMsg.CheckInLifeUI", "lbs.Type %d", new Object[]{Integer.valueOf(aVar2.ktN)});
            switch (aVar.type) {
                case 0:
                    if (GB != null) {
                        intent.putExtra("get_lat", GB.fzt);
                        intent.putExtra("get_lng", GB.hBL);
                    }
                    if (!bh.ov(checkInLifeUI.fWq)) {
                        intent.putExtra("get_city", checkInLifeUI.fWq);
                    }
                    intent.putExtra("get_poi_classify_type", aVar2.ktN);
                    intent.putExtra("get_poi_address", a.bj(aVar2.oPy));
                    intent.putExtra("get_poi_classify_id", aVar2.oPt);
                    intent.putExtra("get_poi_name", aVar2.fon);
                    intent.putExtra("get_poi_showflag", aVar2.fWj);
                    break;
                case 1:
                    if (GB != null) {
                        intent.putExtra("get_lat", GB.fzt);
                        intent.putExtra("get_lng", GB.hBL);
                    }
                    intent.putExtra("get_city", aVar2.fon);
                    break;
            }
            intent.putExtra("get_cur_lat", checkInLifeUI.oQg);
            intent.putExtra("get_cur_lng", checkInLifeUI.oQh);
            intent.putExtra("get_accuracy", checkInLifeUI.oQj);
            intent.putExtra("get_loctype", checkInLifeUI.oQi);
            intent.putExtra("get_is_mars", checkInLifeUI.hxP);
            checkInLifeUI.setResult(-1, intent);
            checkInLifeUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ewT);
        this.oQH = b.ON();
        this.oQI = new aof();
        this.oQy = getIntent().getStringExtra("get_poi_classify_id");
        try {
            this.oQI = (aof) this.oQI.aF(getIntent().getByteArrayExtra("get_poi_item_buf"));
            if (this.oQI != null) {
                this.oQy = this.oQI.oPt;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            this.oQI = null;
        }
        if (bh.ov(this.oQy)) {
            this.fWq = getIntent().getStringExtra("get_city");
        }
        if (!bh.ov(this.fWq)) {
            this.oQy = this.oQE.dA(this.fWq, "").oPt;
        }
        this.oQE.oQy = this.oQy;
        if (this.oQI != null && !bh.ov(this.oQI.oPt)) {
            b bVar = this.oQE;
            com.tencent.mm.plugin.nearlife.b.a aVar = new com.tencent.mm.plugin.nearlife.b.a("", this.oQI);
            if (bVar.oQw == null) {
                bVar.a(aVar, 1);
            } else {
                bVar.a(aVar, 2);
            }
        }
    }

    public final void bfh() {
        super.bfh();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oQH != null) {
            this.oQH.a(this.oQK);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.doH;
    }

    public final a bff() {
        if (this.oQG == null) {
            this.oQG = J(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.oQE != null) {
            return this.oQE;
        }
        this.oQE = new b(this, this.npY, "viewlist", false);
        if (!(this.oQG == null || this.oQG.size() == 0)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.oQG.get(this.oQG.size() - 1));
            this.oQE.I(arrayList);
            this.oQE.oPS = false;
        }
        return this.oQE;
    }

    public final a bfg() {
        if (this.oQG == null) {
            this.oQG = J(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.oQF != null) {
            return this.oQF;
        }
        this.oQF = new b(this, this.oQJ, "searchlist", true);
        this.oQF.I(this.oQG);
        this.oQF.oPS = true;
        return this.oQF;
    }

    public final void l(double d, double d2) {
        x.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[]{Double.valueOf(d), Double.valueOf(d2)});
        if (this.oQH != null && bh.ov(this.fWq)) {
            this.oQH.a(d, d2, this.oQK);
        }
    }

    private static ArrayList<LatLongData> J(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<LatLongData> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("\n");
            if (2 == split.length) {
                try {
                    arrayList2.add(new LatLongData(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue()));
                } catch (NumberFormatException e) {
                }
            }
        }
        x.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + arrayList2.size());
        return arrayList2;
    }
}
