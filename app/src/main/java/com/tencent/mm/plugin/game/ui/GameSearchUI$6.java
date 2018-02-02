package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.ui.u.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class GameSearchUI$6 implements OnItemClickListener {
    final /* synthetic */ GameSearchUI nvN;

    GameSearchUI$6(GameSearchUI gameSearchUI) {
        this.nvN = gameSearchUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a rb = ((u) adapterView.getAdapter()).rb(i);
        if (!bh.ov(rb.text)) {
            if (bh.ov(rb.appId)) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(rb.text);
                GameSearchUI.b(this.nvN, linkedList);
                GameSearchUI.h(this.nvN);
                return;
            }
            int a;
            switch (rb.actionType) {
                case 1:
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", rb.appId);
                    bundle.putInt("game_report_from_scene", 1402);
                    a = c.a(this.nvN, rb.appId, null, bundle);
                    ap.a(this.nvN, 14, 1402, i, a, rb.appId, GameSearchUI.g(this.nvN), null);
                    return;
                case 2:
                    a = c.p(this.nvN.mController.xIM, rb.nvr, "game_center_detail");
                    ap.a(this.nvN, 14, 1402, i, a, rb.appId, GameSearchUI.g(this.nvN), null);
                    return;
                default:
                    x.e("MicroMsg.GameSearchUI", "unknowed actionType : " + rb.actionType);
                    return;
            }
        }
    }
}
