package com.tencent.mm.ui.base;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel.d;

class MMTagPanel$1 implements OnKeyListener {
    final /* synthetic */ MMTagPanel ydR;

    MMTagPanel$1(MMTagPanel mMTagPanel) {
        this.ydR = mMTagPanel;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && 67 == i) {
            x.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", new Object[]{Integer.valueOf(MMTagPanel.a(this.ydR).getSelectionStart()), Integer.valueOf(MMTagPanel.a(this.ydR).getSelectionEnd())});
            boolean z = MMTagPanel.a(this.ydR).getSelectionStart() == 0 && MMTagPanel.a(this.ydR).getSelectionStart() == MMTagPanel.a(this.ydR).getSelectionEnd();
            if (z) {
                this.ydR.aJB();
                if (!(MMTagPanel.b(this.ydR) == null || MMTagPanel.b(this.ydR).isEmpty())) {
                    if (!MMTagPanel.c(this.ydR) && MMTagPanel.d(this.ydR) == null) {
                        MMTagPanel.a(this.ydR, (d) MMTagPanel.b(this.ydR).getLast());
                        this.ydR.a(MMTagPanel.d(this.ydR).yed, false, true);
                        MMTagPanel.a(this.ydR).setCursorVisible(false);
                    } else if (MMTagPanel.d(this.ydR) == null || MMTagPanel.b(this.ydR) == null || MMTagPanel.b(this.ydR).getLast() == null || bh.ov(MMTagPanel.d(this.ydR).yec) || bh.ov(((d) MMTagPanel.b(this.ydR).getLast()).yec) || MMTagPanel.d(this.ydR).yec.equals(((d) MMTagPanel.b(this.ydR).getLast()).yec)) {
                        String str = ((d) MMTagPanel.b(this.ydR).getLast()).yec;
                        this.ydR.removeTag(str);
                        if (MMTagPanel.e(this.ydR) != null) {
                            MMTagPanel.e(this.ydR).yK(str);
                        }
                        this.ydR.cpJ();
                    } else {
                        x.i("MicroMsg.MMTagPanel", "change hight");
                        this.ydR.cpJ();
                        MMTagPanel.a(this.ydR, (d) MMTagPanel.b(this.ydR).getLast());
                        this.ydR.a(MMTagPanel.d(this.ydR).yed, false, true);
                        MMTagPanel.a(this.ydR).setCursorVisible(false);
                    }
                }
            }
        }
        return false;
    }
}
