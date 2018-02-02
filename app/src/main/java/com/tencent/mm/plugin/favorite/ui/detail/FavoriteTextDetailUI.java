package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.k.b;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public class FavoriteTextDetailUI extends BaseFavDetailReportUI {
    private static final int mxj = b.zC();
    private l contextMenuHelper;
    private f mwF;
    private FavDetailTitleView mwT;
    private FavDetailFooterView mwU;
    private FavTagEntrance mwV;
    private long mxa;
    private TextView mxk;
    private ClipboardManager mxl;
    private f mxm;
    private d mxn = new 3(this);

    protected final int getLayoutId() {
        return R.i.dhX;
    }

    protected final MMLoadScrollView aIl() {
        return (MMLoadScrollView) findViewById(R.h.cJg);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mxk = (TextView) findViewById(R.h.bSB);
        this.mwT = (FavDetailTitleView) findViewById(R.h.cgz);
        this.mwU = (FavDetailFooterView) findViewById(R.h.cgy);
        this.mwV = (FavTagEntrance) findViewById(R.h.chi);
        this.mxl = (ClipboardManager) getSystemService("clipboard");
        this.mxa = getIntent().getLongExtra("key_detail_info_id", -1);
        i.CB(5);
        this.contextMenuHelper = new l(this.mController.xIM);
        this.contextMenuHelper.a(this.mxk, this, this.mxn);
        setMMTitle(getString(R.l.eeK));
        setBackBtn(new 1(this));
        addIconOptionMenu(0, R.l.eRi, R.g.bDI, new 2(this));
        h.getFavItemInfoStorage().c(this.mwV);
    }

    protected void onDestroy() {
        h.getFavItemInfoStorage().j(this.mwV);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        aJK();
    }

    protected void onPause() {
        super.onPause();
    }

    private void aJK() {
        this.mwF = h.getFavItemInfoStorage().db(this.mxa);
        h(this.mwF);
        if (this.mwF == null || this.mwF.field_favProto == null) {
            x.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", new Object[]{Long.valueOf(this.mxa)});
            return;
        }
        this.mwV.ds(this.mwF.field_localId);
        this.mwV.aN(this.mwF.field_tagProto.wfj);
        if (this.mxm == null || this.mxm.field_edittime != this.mwF.field_edittime) {
            this.mxm = this.mwF;
            this.mwT.F(this.mwF);
            this.mwU.F(this.mwF);
            this.mxk.setText(this.mwF.field_favProto.desc);
            com.tencent.mm.pluginsdk.ui.d.i.f(this.mxk, 1);
            return;
        }
        x.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, getString(R.l.dEs));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i && -1 == i2) {
            com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(R.l.dGy));
            new af().postDelayed(new 4(this), 250);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final String i(f fVar) {
        return String.valueOf(bh.az(fVar.field_favProto.desc, "").getBytes().length);
    }
}
