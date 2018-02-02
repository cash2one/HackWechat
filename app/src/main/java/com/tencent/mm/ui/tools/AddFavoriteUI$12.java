package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class AddFavoriteUI$12 extends af {
    final /* synthetic */ AddFavoriteUI zgJ;

    AddFavoriteUI$12(AddFavoriteUI addFavoriteUI) {
        this.zgJ = addFavoriteUI;
    }

    public final void handleMessage(Message message) {
        AddFavoriteUI.d(this.zgJ);
        if (bh.ov(this.zgJ.filePath) || (bh.VV(this.zgJ.filePath) && !AddFavoriteUI.ZV(this.zgJ.filePath))) {
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
            AddFavoriteUI.g(this.zgJ);
            this.zgJ.finish();
            return;
        }
        AddFavoriteUI.h(this.zgJ);
    }
}
