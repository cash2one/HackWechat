package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.be;
import com.tencent.mm.plugin.game.ui.n.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;

public class GameCategoryUI extends MMActivity implements e {
    private Dialog jLV;
    private View kgd;
    private int mType;
    private int ndn = 0;
    private int nds = 0;
    private l nlW = new l();
    private ListView nmc;
    private m nmd;
    private boolean nme = false;
    private boolean nmf = false;
    private int nmg;
    private String nmh;
    private a nmi = new 3(this);
    private OnScrollListener nmj = new 4(this);

    static /* synthetic */ void a(GameCategoryUI gameCategoryUI, ae aeVar, boolean z) {
        gameCategoryUI.nmf = aeVar.ndq.niJ;
        if (z) {
            gameCategoryUI.nmd.O(aeVar.ndr);
        } else {
            gameCategoryUI.nmd.P(aeVar.ndr);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("extra_type", 0);
        this.nmg = getIntent().getIntExtra("extra_category_id", 0);
        this.nmh = getIntent().getStringExtra("extra_category_name");
        this.ndn = getIntent().getIntExtra("game_report_from_scene", 0);
        ar.CG().a(1220, this);
        setMMTitle(this.nmh);
        setBackBtn(new 1(this));
        if (!bh.ov(SubCoreGameCenter.aRb())) {
            addIconOptionMenu(0, R.l.eRj, R.k.dvb, new OnMenuItemClickListener(this) {
                final /* synthetic */ GameCategoryUI nmk;

                {
                    this.nmk = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(this.nmk, GameSearchUI.class);
                    switch (this.nmk.mType) {
                        case 1:
                            intent.putExtra("game_report_from_scene", 1602);
                            break;
                        case 2:
                            intent.putExtra("game_report_from_scene", 1502);
                            break;
                    }
                    this.nmk.startActivity(intent);
                    return true;
                }
            });
        }
        this.nmc = (ListView) findViewById(R.h.ckJ);
        this.nmc.setOnItemClickListener(this.nlW);
        this.nlW.qO(this.ndn);
        this.nmc.setOnScrollListener(this.nmj);
        this.nmd = new m(this);
        this.nmd.qO(this.ndn);
        this.nmd.a(this.nmi);
        this.kgd = ((LayoutInflater) this.mController.xIM.getSystemService("layout_inflater")).inflate(R.i.dkI, this.nmc, false);
        this.kgd.setVisibility(8);
        this.nmc.addFooterView(this.kgd);
        this.nmc.setAdapter(this.nmd);
        this.jLV = c.cR(this);
        this.jLV.show();
        aRu();
    }

    public void onDestroy() {
        super.onDestroy();
        ar.CG().b(1220, this);
        this.nmd.clear();
    }

    protected final int getLayoutId() {
        return R.i.djw;
    }

    private void aRu() {
        ar.CG().a(new be(this.nds, this.mType, this.nmg), 0);
        this.nme = true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            ar.Dm().F(new 5(this, ((be) kVar).lMW.hmh.hmo));
            return;
        }
        x.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            x.e("MicroMsg.GameCategoryUI", "error request code");
            return;
        }
        String str = null;
        if (intent != null) {
            str = intent.getStringExtra("game_app_id");
        }
        switch (i2) {
            case 2:
                if (!bh.ov(str)) {
                    this.nmd.Ce(str);
                    this.nmd.Cg(str);
                    return;
                }
                return;
            case 3:
                if (!bh.ov(str)) {
                    this.nmd.Cf(str);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
