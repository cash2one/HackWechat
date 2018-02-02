package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;

class GameCenterUI2$5 implements OnClickListener {
    final /* synthetic */ GameCenterUI2 nnh;

    GameCenterUI2$5(GameCenterUI2 gameCenterUI2) {
        this.nnh = gameCenterUI2;
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof String) && !bh.ov((String) tag)) {
            ap.a(this.nnh.mController.xIM, 10, HardCoderJNI.FUNC_REG_ANR_CALLBACK, 1, c.p(this.nnh.mController.xIM, (String) view.getTag(), "game_center_feedback"), GameCenterUI2.f(this.nnh), null);
        }
    }
}
