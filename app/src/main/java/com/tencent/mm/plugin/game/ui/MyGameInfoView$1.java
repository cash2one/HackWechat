package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;

class MyGameInfoView$1 implements OnClickListener {
    final /* synthetic */ MyGameInfoView nwj;

    MyGameInfoView$1(MyGameInfoView myGameInfoView) {
        this.nwj = myGameInfoView;
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            ap.a(MyGameInfoView.a(this.nwj), 10, 1002, 99, c.p(MyGameInfoView.a(this.nwj), (String) view.getTag(), "game_center_mygame_more"), MyGameInfoView.b(this.nwj), null);
        }
    }
}
