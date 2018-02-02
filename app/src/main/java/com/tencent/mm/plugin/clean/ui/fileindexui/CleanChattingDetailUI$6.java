package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;

class CleanChattingDetailUI$6 implements Runnable {
    final /* synthetic */ CleanChattingDetailUI lgF;
    final /* synthetic */ long lgH;

    CleanChattingDetailUI$6(CleanChattingDetailUI cleanChattingDetailUI, long j) {
        this.lgF = cleanChattingDetailUI;
        this.lgH = j;
    }

    public final void run() {
        CleanChattingDetailUI.c(this.lgF).dismiss();
        Intent intent = new Intent();
        intent.putExtra("key_pos", CleanChattingDetailUI.d(this.lgF));
        intent.putExtra("key_delete_size", CleanChattingDetailUI.e(this.lgF));
        this.lgF.setResult(1000, intent);
        h.b(this.lgF, this.lgF.getString(R.l.dTC, new Object[]{bh.bx(this.lgH)}), "", true);
    }
}
