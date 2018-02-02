package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public abstract class GameCenterBaseUI extends GameCenterActivity {
    protected int ndn = 0;
    private boolean nmA = true;
    protected boolean nmv = false;
    protected t nmw;
    protected t nmx;
    protected t nmy;
    protected boolean nmz = false;

    static /* synthetic */ void a(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.nmv) {
            SubCoreGameCenter.aRe();
            gameCenterBaseUI.nmw = w.aQn();
            if (gameCenterBaseUI.nmw != null) {
                gameCenterBaseUI.nmw.aQm();
            }
            SubCoreGameCenter.aRe();
            gameCenterBaseUI.nmx = w.aQp();
            if (gameCenterBaseUI.nmx != null) {
                gameCenterBaseUI.nmx.aQm();
            }
        }
        SubCoreGameCenter.aRe();
        gameCenterBaseUI.nmy = w.aQr();
        if (gameCenterBaseUI.nmy != null) {
            gameCenterBaseUI.nmy.aQm();
        }
    }

    static /* synthetic */ void b(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.nmx != null && !gameCenterBaseUI.nmx.field_isHidden && !bh.ov(gameCenterBaseUI.nmx.ncA.url)) {
            gameCenterBaseUI.nmz = true;
            t tVar = gameCenterBaseUI.nmx;
            c.a(gameCenterBaseUI.getBaseContext(), tVar, "game_center_h5_floatlayer");
            int i = tVar.field_msgType;
            if (tVar.field_msgType == 100) {
                i = tVar.ncS;
            }
            ap.a(gameCenterBaseUI, 10, 1006, 1, 1, 0, tVar.field_appId, 0, i, tVar.field_gameMsgId, tVar.ncT, null);
            gameCenterBaseUI.nmx.field_isRead = true;
            SubCoreGameCenter.aRd().c(gameCenterBaseUI.nmx, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ar.Hj()) {
            this.ndn = getIntent().getIntExtra("game_report_from_scene", 0);
            this.nmv = getIntent().getBooleanExtra("from_find_more_friend", false);
            c.Dm().F(new 1(this));
            ap.a(this, 10, 1000, 0, 1, 0, null, this.ndn, 0, null, null, null);
            return;
        }
        x.e("MicroMsg.GameCenterBaseUI", "account not ready");
        finish();
    }

    public void onResume() {
        super.onResume();
        if (ar.Hj()) {
            if (!this.nmA && a.aRT().nwU) {
                a.aRT().nwU = false;
                x.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
                if (!isFinishing()) {
                    finish();
                }
                sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
                Intent intent = new Intent();
                intent.putExtra("game_report_from_scene", 901);
                intent.putExtra("switch_country_no_anim", true);
                d.b(this, "game", ".ui.GameCenterUI", intent);
            }
            this.nmA = false;
            return;
        }
        x.e("MicroMsg.GameCenterBaseUI", "account not ready");
    }

    public final int aRr() {
        return 10;
    }

    public final int aRs() {
        return 1000;
    }

    public final int aRt() {
        return this.ndn;
    }
}
