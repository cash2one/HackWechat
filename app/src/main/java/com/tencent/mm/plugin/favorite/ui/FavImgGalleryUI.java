package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.favorite.a.e;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.base.d;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@a(3)
public class FavImgGalleryUI extends MMActivity implements OnItemSelectedListener, i {
    private boolean fBV = true;
    private ArrayList<d> jMd;
    private l juS;
    private MMGestureGallery kRW;
    private p.d lET = new 7(this);
    private int msn = 0;
    private a mso;
    private Map<String, mr> msp = new HashMap();
    private c msq = new 2(this);

    static /* synthetic */ void a(FavImgGalleryUI favImgGalleryUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        d pK = favImgGalleryUI.mso.pK(favImgGalleryUI.msn);
        if (pK != null && pK.fve.wdR == 0) {
            if (pK.mvf != null && pK.mvf.aHJ()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favImgGalleryUI.getString(R.l.egz));
            }
            if (pK.mvf != null && pK.mvf.aHK()) {
                arrayList.add(Integer.valueOf(1));
                arrayList2.add(favImgGalleryUI.getString(R.l.egb));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favImgGalleryUI.getString(R.l.egu));
            String h = j.h(pK.fve);
            mr mrVar = (mr) favImgGalleryUI.msp.get(h);
            if (mrVar == null) {
                b mpVar = new mp();
                mpVar.fEA.filePath = h;
                com.tencent.mm.sdk.b.a.xef.m(mpVar);
            } else if (!bh.ov(mrVar.fED.result)) {
                arrayList.add(Integer.valueOf(3));
                arrayList2.add(favImgGalleryUI.getString(com.tencent.mm.plugin.scanner.a.az(mrVar.fED.fqb, mrVar.fED.result) ? R.l.egh : R.l.egg));
            }
            if (favImgGalleryUI.juS == null) {
                favImgGalleryUI.juS = new l(favImgGalleryUI.mController.xIM);
            }
            favImgGalleryUI.juS.rKC = new 5(favImgGalleryUI, arrayList, arrayList2);
            favImgGalleryUI.juS.rKD = favImgGalleryUI.lET;
            favImgGalleryUI.juS.e(new 6(favImgGalleryUI));
            h.a(favImgGalleryUI.mController.xIM, favImgGalleryUI.juS.bBX());
        }
    }

    protected final int getLayoutId() {
        return R.i.dhw;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.fBV = getIntent().getBooleanExtra("show_share", true);
        this.kRW = (MMGestureGallery) findViewById(R.h.ckt);
        this.kRW.setVerticalFadingEdgeEnabled(false);
        this.kRW.setHorizontalFadingEdgeEnabled(false);
        this.kRW.setOnItemSelectedListener(this);
        this.kRW.zlf = new 1(this);
        if (this.fBV) {
            this.kRW.zlg = new 3(this);
        }
        fullScreenNoTitleBar(true);
        this.jMd = new ArrayList();
        this.mso = new a(this, (byte) 0);
        this.kRW.setAdapter(this.mso);
        aJh();
        setBackBtn(new 4(this));
        com.tencent.mm.sdk.b.a.xef.b(this.msq);
        setResult(0, getIntent());
    }

    private void aJh() {
        long longExtra = getIntent().getLongExtra("key_detail_info_id", -1);
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
        List arrayList = new ArrayList();
        f db = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().db(longExtra);
        String str = "MicroMsg.FavImgGalleryUI";
        String str2 = "show one fav info, local id is %d, get from db ok ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(longExtra);
        objArr[1] = Boolean.valueOf(db != null);
        x.i(str, str2, objArr);
        if (!booleanExtra || bh.ov(stringExtra2)) {
            f fVar = db;
        } else {
            Object Af = j.Af(stringExtra2);
        }
        if (Af != null) {
            arrayList.add(Af);
        }
        this.jMd.clear();
        int i = -1;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            fVar = (f) arrayList.get(i2);
            int size2 = fVar.field_favProto.weU.size();
            int i3 = 0;
            while (i3 < size2) {
                int size3;
                uq uqVar = (uq) fVar.field_favProto.weU.get(i3);
                if ((uqVar.bjS != 8 || com.tencent.mm.sdk.platformtools.p.UR(j.h(uqVar))) && (uqVar.bjS == 2 || uqVar.bjS == 8)) {
                    this.jMd.add(new d(fVar, uqVar));
                    if (stringExtra != null && stringExtra.equals(uqVar.mvG)) {
                        size3 = this.jMd.size() - 1;
                        i3++;
                        i = size3;
                    }
                }
                size3 = i;
                i3++;
                i = size3;
            }
            if (stringExtra == null && fVar.field_localId == longExtra) {
                i = this.jMd.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.mso.notifyDataSetChanged();
        this.kRW.post(new 8(this, i));
    }

    protected void onDestroy() {
        getIntent().putExtra("key_activity_browse_time", cmZ());
        com.tencent.mm.sdk.b.a.xef.c(this.msq);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.favorite.h.aIs().a(this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.favorite.h.aIs().b(this);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.msn = i;
        x.d("MicroMsg.FavImgGalleryUI", "pos:" + i);
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).cpS();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final void a(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar != null) {
            x.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", Integer.valueOf(cVar.field_status));
            d pK = this.mso.pK(this.msn);
            if (pK != null && bh.az(cVar.field_dataId, "").equals(pK.fve.mvG)) {
                ag.y(new 9(this, cVar));
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                d pK = this.mso.pK(this.msn);
                if (pK == null) {
                    x.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
                    return;
                }
                com.tencent.mm.plugin.favorite.a.d dVar = new com.tencent.mm.plugin.favorite.a.d();
                if (com.tencent.mm.plugin.favorite.a.d.k(pK.mvf)) {
                    h.bu(this.mController.xIM, getString(R.l.dBN));
                    return;
                }
                x.d("MicroMsg.FavImgGalleryUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
                e.a(this.mController.xIM, r1, pK.mvf, pK.fve, new 10(this, h.a(this.mController.xIM, getString(R.l.efz), false, null)));
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
