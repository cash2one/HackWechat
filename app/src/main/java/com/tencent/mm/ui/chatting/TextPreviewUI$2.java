package com.tencent.mm.ui.chatting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.z;

class TextPreviewUI$2 implements d {
    final /* synthetic */ TextPreviewUI yxT;

    TextPreviewUI$2(TextPreviewUI textPreviewUI) {
        this.yxT = textPreviewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                ((ClipboardManager) this.yxT.mController.xIM.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.a(this.yxT), TextPreviewUI.a(this.yxT)));
                if (TextPreviewUI.b(this.yxT) != null) {
                    TextPreviewUI.b(this.yxT).cqd();
                    TextPreviewUI.b(this.yxT).cqc();
                }
                Toast.makeText(this.yxT.mController.xIM, this.yxT.mController.xIM.getString(R.l.dEt), 0).show();
                return;
            case 1:
                if (TextPreviewUI.b(this.yxT) != null) {
                    TextPreviewUI.b(this.yxT).cqc();
                    z b = TextPreviewUI.b(this.yxT);
                    b.fJl = true;
                    if (b.ygM != null) {
                        b.ygM.yhg.dismiss();
                    }
                    if (b.ygN != null) {
                        b.ygN.yhg.dismiss();
                    }
                    TextPreviewUI.b(this.yxT).eU(0, TextPreviewUI.c(this.yxT).getText().length());
                    TextPreviewUI.b(this.yxT).fJl = false;
                    b = TextPreviewUI.b(this.yxT);
                    b.a(b.ygM);
                    b.a(b.ygN);
                }
                ag.h(new 1(this), 100);
                return;
            case 2:
                TextPreviewUI.b(this.yxT.mController.xIM, TextPreviewUI.a(this.yxT));
                return;
            default:
                return;
        }
    }
}
