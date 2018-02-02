package com.tencent.mm.ui.chatting.e;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.a.b;
import com.tencent.mm.ui.chatting.a.a.c;
import com.tencent.mm.ui.chatting.gallery.g.a;

class e$10 implements b {
    final /* synthetic */ e yHA;

    e$10(e eVar) {
        this.yHA = eVar;
    }

    public final void a(boolean z, c cVar, int i) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (!z || a.cuF().yDd.size() < 9) {
            if (z) {
                a.cuF().bm(cVar.fEJ);
            } else {
                a.cuF().bn(cVar.fEJ);
            }
            e.c(this.yHA).FH(a.cuF().yDd.size());
            return;
        }
        Toast.makeText(e.b(this.yHA), e.b(this.yHA).getResources().getString(R.l.ely, new Object[]{Integer.valueOf(9)}), 1).show();
        this.yHA.yHv.bj(i);
    }
}
