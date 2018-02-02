package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameDetailUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("game_app_id");
        b.a br = b.br(stringExtra, getIntent().getIntExtra("game_report_from_scene", 0));
        if (br.fDt != 2 || bh.ov(br.url)) {
            int aQa = g.aQa();
            if (aQa == 2) {
                c.ae(this, stringExtra);
            } else if (aQa == 1) {
                c.c(this, getIntent().getExtras());
            } else {
                String cgv = bh.cgv();
                if (bh.ov(cgv) || cgv.toLowerCase().equals("cn")) {
                    c.ae(this, stringExtra);
                } else {
                    c.c(this, getIntent().getExtras());
                }
            }
        } else {
            c.p(getBaseContext(), br.url, "game_center_detail");
        }
        finish();
    }
}
