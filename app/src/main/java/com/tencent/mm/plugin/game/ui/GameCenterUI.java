package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.ap;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.i;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameCenterUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.GameCenterUI", "onCreate");
        if (getIntent().getBooleanExtra("game_check_float", false)) {
            int intExtra = getIntent().getIntExtra("game_sourceScene", 0);
            SubCoreGameCenter.aRe();
            t aQp = w.aQp();
            if (aQp != null) {
                aQp.aQm();
                if (!bh.ov(aQp.ncA.url)) {
                    c.a(getBaseContext(), aQp, "game_center_h5_floatlayer");
                }
            }
            c.a(aQp, intExtra);
            finish();
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        i aQb = i.aQb();
        ap apVar = null;
        if (aQb.nbF != null) {
            apVar = aQb.nbF.nhJ;
            if (apVar != null) {
                x.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[]{Integer.valueOf(apVar.ngD), apVar.nfg});
            }
        } else {
            aQb.XH();
        }
        if (apVar != null) {
            Intent intent;
            Bundle extras;
            switch (apVar.ngD) {
                case 0:
                    fH(booleanExtra);
                    break;
                case 1:
                    if (!bh.ov(apVar.nfg)) {
                        Ch(apVar.nfg);
                        break;
                    } else {
                        fH(booleanExtra);
                        break;
                    }
                case 2:
                    intent = new Intent(this, GameOverSeaCenterUI.class);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    startActivity(intent);
                    if (booleanExtra) {
                        overridePendingTransition(R.a.bqe, R.a.bqe);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.xKg, MMFragmentActivity.a.xKh);
                    }
                    qT(6);
                    break;
                case 3:
                    intent = new Intent(this, GameDownloadGuidanceUI.class);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    startActivity(intent);
                    if (booleanExtra) {
                        overridePendingTransition(R.a.bqe, R.a.bqe);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.xKg, MMFragmentActivity.a.xKh);
                    }
                    qT(6);
                    break;
            }
        }
        fH(booleanExtra);
        finish();
    }

    private void fH(boolean z) {
        if (bh.cgC()) {
            x.i("MicroMsg.GameCenterUI", "GP version");
        } else {
            b.a qL = b.qL(getIntent().getIntExtra("game_report_from_scene", 0));
            if (qL.fDt == 2 && !bh.ov(qL.url)) {
                Ch(qL.url);
                return;
            }
        }
        Intent intent = new Intent(this, GameRouteUI.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivity(intent);
        if (z) {
            overridePendingTransition(R.a.bqe, R.a.bqe);
        } else {
            overridePendingTransition(MMFragmentActivity.a.xKg, MMFragmentActivity.a.xKh);
        }
        qT(6);
    }

    private void Ch(String str) {
        qT(7);
        Intent intent = getIntent();
        if (this != null && !bh.ov(str) && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
            int intExtra = intent.getIntExtra("game_report_from_scene", 0);
            SubCoreGameCenter.aRe();
            t aQp = w.aQp();
            String a = p.a(str, aQp);
            if (booleanExtra) {
                p.a(this, a, "game_center_entrance", true, aQp, intExtra);
                SubCoreGameCenter.aRe();
                w.aQo();
            } else {
                p.a(this, a, "game_center_entrance", false, aQp, intExtra);
            }
            finish();
        }
    }

    private void qT(int i) {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
            SubCoreGameCenter.aRe();
            t aQn = w.aQn();
            if (aQn == null) {
                com.tencent.mm.plugin.game.model.ap.a(this, 9, 901, 1, i, 0, com.tencent.mm.plugin.game.model.ap.cL("resource", "0"));
                return;
            }
            aQn.aQm();
            int i2 = aQn.field_msgType;
            if (aQn.field_msgType == 100) {
                i2 = aQn.ncS;
            }
            com.tencent.mm.plugin.game.model.ap.a(this, 9, 901, 1, i, 0, aQn.field_appId, 0, i2, aQn.field_gameMsgId, aQn.ncT, com.tencent.mm.plugin.game.model.ap.cL("resource", String.valueOf(aQn.ncl.nda)));
            SubCoreGameCenter.aRe();
            w.aQo();
        }
    }
}
