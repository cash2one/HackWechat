package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.ui.GameGalleryUI.a;
import com.tencent.mm.ui.MMActivity;

class GameGalleryUI$a$2 implements OnClickListener {
    final /* synthetic */ a nqP;

    GameGalleryUI$a$2(a aVar) {
        this.nqP = aVar;
    }

    public final void onClick(View view) {
        ((MMActivity) this.nqP.mContext).finish();
    }
}
