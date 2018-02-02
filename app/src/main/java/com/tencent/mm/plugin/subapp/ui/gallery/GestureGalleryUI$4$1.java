package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.4;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h$c;

class GestureGalleryUI$4$1 implements h$c {
    final /* synthetic */ 4 rXu;

    GestureGalleryUI$4$1(4 4) {
        this.rXu = 4;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                GestureGalleryUI.a(this.rXu.rXs, this.rXu.rXs.rXj);
                return;
            case 1:
                MMActivity mMActivity = this.rXu.rXs;
                String b = this.rXu.rXs.rXj;
                if (b != null && b.length() != 0) {
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", b);
                    intent.putExtra("Retr_Msg_Type", 0);
                    intent.putExtra("Retr_Compress_Type", 0);
                    b.ifs.l(intent, mMActivity.mController.xIM);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
