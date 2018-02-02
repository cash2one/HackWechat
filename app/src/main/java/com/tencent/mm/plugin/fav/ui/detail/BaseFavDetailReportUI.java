package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.f;
import com.tencent.mm.plugin.fav.a.g.a;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public abstract class BaseFavDetailReportUI extends MMActivity {
    public a moJ = new a();
    protected boolean moK;
    private String moL = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.moJ.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
        this.moJ.moj = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
        this.moJ.index = getIntent().getIntExtra("key_detail_fav_index", 0);
        MMLoadScrollView aIl = aIl();
        if (aIl != null) {
            aIl.ztT = new 1(this);
        }
        if (this.moJ.scene == 0) {
            x.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
        }
    }

    public MMLoadScrollView aIl() {
        return null;
    }

    public void onResume() {
        super.onResume();
        if (bh.ov(this.moL)) {
            this.moL = f.SU().hRu;
        }
        x.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", this.moL);
    }

    public void onPause() {
        this.moJ.mnZ = cmZ();
        String str = f.SU().hRu;
        if (!(bh.fu(getClass().getName(), str) || bh.fu(str, this.moL))) {
            a aVar = this.moJ;
            long j = aVar.moa;
            f SU = f.SU();
            aVar.moa = (SU.hRt != null ? ((Long) SU.hRt.get(f.SU().hRu)).longValue() : 0) + j;
        }
        x.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", str, Long.valueOf(this.moJ.mnZ), Long.valueOf(this.moJ.moa));
        super.onPause();
    }

    public final void h(com.tencent.mm.plugin.fav.a.f fVar) {
        if (fVar != null && this.moJ.scene > 0) {
            this.moJ.mnX = (long) fVar.field_id;
            this.moJ.type = fVar.field_type;
            this.moJ.cOY = fVar.field_sourceType;
            this.moJ.timestamp = fVar.field_sourceCreateTime / 1000;
            if (this.moJ.timestamp == 0) {
                this.moJ.timestamp = fVar.field_updateTime / 1000;
            }
            if (this.moJ.timestamp == 0) {
                this.moJ.timestamp = fVar.field_edittime;
            }
            this.moJ.mnY = i(fVar);
            this.moK = true;
        }
    }

    public final void df(long j) {
        com.tencent.mm.plugin.fav.a.f db = ((r) g.k(r.class)).getFavItemInfoStorage().db(j);
        if (db != null) {
            h(db);
        }
    }

    public void onDestroy() {
        if (this.moK) {
            com.tencent.mm.plugin.fav.a.g.a(this.moJ);
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", cmZ()));
        super.onDestroy();
    }

    public String i(com.tencent.mm.plugin.fav.a.f fVar) {
        return "0";
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            long longExtra = intent.getLongExtra("key_activity_browse_time", 0);
            a aVar = this.moJ;
            aVar.moa += longExtra;
            x.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", Long.valueOf(this.moJ.moa), Long.valueOf(longExtra));
        }
        super.onActivityResult(i, i2, intent);
    }
}
