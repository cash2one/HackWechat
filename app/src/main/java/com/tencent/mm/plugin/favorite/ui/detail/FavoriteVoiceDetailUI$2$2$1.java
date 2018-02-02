package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVoiceDetailUI.2.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

class FavoriteVoiceDetailUI$2$2$1 implements OnClickListener {
    final /* synthetic */ 2 mxI;

    FavoriteVoiceDetailUI$2$2$1(2 2) {
        this.mxI = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        final r a = h.a(this.mxI.mxH.mxG.mController.xIM, this.mxI.mxH.mxG.getString(R.l.dEx), false, null);
        final long j = FavoriteVoiceDetailUI.a(this.mxI.mxH.mxG).field_localId;
        final long j2 = (long) FavoriteVoiceDetailUI.a(this.mxI.mxH.mxG).field_id;
        j.a(FavoriteVoiceDetailUI.a(this.mxI.mxH.mxG).field_localId, new Runnable(this) {
            final /* synthetic */ FavoriteVoiceDetailUI$2$2$1 mxL;

            public final void run() {
                FavoriteVoiceDetailUI.c(this.mxL.mxI.mxH.mxG).moh = true;
                a.dismiss();
                x.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
                this.mxL.mxI.mxH.mxG.finish();
            }
        });
    }
}
