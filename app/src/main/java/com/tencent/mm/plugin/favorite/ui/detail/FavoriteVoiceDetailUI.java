package com.tencent.mm.plugin.favorite.ui.detail;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.favorite.a.i;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.plugin.favorite.ui.base.FavVoiceBaseView;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;

public class FavoriteVoiceDetailUI extends BaseFavDetailReportUI implements a {
    private f mqC;
    private i mqV;
    private FavDetailTitleView mwB;
    private FavDetailFooterView mwC;
    private FavTagEntrance mwD;
    private FavVoiceBaseView mxF;
    private long mxa;

    protected final int getLayoutId() {
        return R.i.dhY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.eeK));
        this.mxa = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mqC = h.getFavItemInfoStorage().db(this.mxa);
        if (this.mqC == null) {
            x.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
            finish();
        } else {
            h(this.mqC);
            this.mwB = (FavDetailTitleView) findViewById(R.h.cgz);
            this.mwB.F(this.mqC);
            this.mwC = (FavDetailFooterView) findViewById(R.h.cgy);
            this.mwC.F(this.mqC);
            this.mqV = new i();
            this.mxF = (FavVoiceBaseView) findViewById(R.h.cWx);
            i.a aVar = this.mxF;
            aVar.mqV = this.mqV;
            aVar.mqV.a(aVar);
            uq p = j.p(this.mqC);
            String h = j.h(p);
            int Ae = j.Ae(p.wcY);
            if (!e.bO(h)) {
                j.o(this.mqC);
            }
            this.mxF.H(h, Ae, p.duration);
            this.mwD = (FavTagEntrance) findViewById(R.h.chi);
            this.mwD.ds(this.mqC.field_localId);
            this.mwD.aN(this.mqC.field_tagProto.wfj);
            setBackBtn(new 1(this));
            addIconOptionMenu(0, R.l.eRi, R.g.bDI, new 2(this));
        }
        h.getFavItemInfoStorage().c(this);
        if (this.mwD != null) {
            h.getFavItemInfoStorage().c(this.mwD);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mxF.stopPlay();
        this.mqV.destroy();
        h.getFavItemInfoStorage().j(this);
        if (this.mwD != null) {
            h.getFavItemInfoStorage().j(this.mwD);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.mxF.aIC();
        this.mqV.pause();
    }

    public final void a(String str, l lVar) {
        this.mqC = h.getFavItemInfoStorage().db(this.mxa);
        if (this.mqC == null) {
            x.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
            finish();
        } else if (this.mqC.field_itemStatus == 10 && lVar != null && lVar.xjN != null && this.mqC.field_favProto.weU.size() > 0) {
            uq p = j.p(this.mqC);
            String h = j.h(p);
            int Ae = j.Ae(p.wcY);
            x.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
            this.mxF.H(h, Ae, p.duration);
        }
    }

    protected final String i(f fVar) {
        if (this.mqC.field_favProto.weU.size() > 0) {
            return String.valueOf(j.p(this.mqC).duration);
        }
        return "0";
    }
}
