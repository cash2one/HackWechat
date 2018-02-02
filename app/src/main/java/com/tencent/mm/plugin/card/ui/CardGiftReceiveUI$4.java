package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.b.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class CardGiftReceiveUI$4 implements a {
    final /* synthetic */ CardGiftReceiveUI kSW;

    CardGiftReceiveUI$4(CardGiftReceiveUI cardGiftReceiveUI) {
        this.kSW = cardGiftReceiveUI;
    }

    public final void aW(String str, int i) {
        if (CardGiftReceiveUI.b(this.kSW) == null) {
            x.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
        } else if (bh.ov(str) || bh.ov(CardGiftReceiveUI.b(this.kSW).kKi) || !str.equals(CardGiftReceiveUI.b(this.kSW).kKi)) {
            CardGiftReceiveUI.g(this.kSW).post(new 1(this));
        } else {
            x.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
        }
    }

    public final void fail(String str) {
        x.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:" + str);
    }

    public final void bU(final String str, final String str2) {
        x.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:" + str);
        if (CardGiftReceiveUI.b(this.kSW) == null) {
            x.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
        } else if (bh.ov(str) || bh.ov(CardGiftReceiveUI.b(this.kSW).kKi) || !str.equals(CardGiftReceiveUI.b(this.kSW).kKi)) {
            CardGiftReceiveUI.g(this.kSW).post(new Runnable(this) {
                final /* synthetic */ CardGiftReceiveUI$4 kSX;

                public final void run() {
                    if (CardGiftReceiveUI.f(this.kSX.kSW).getVisibility() != 8) {
                        CardGiftReceiveUI.f(this.kSX.kSW).setVisibility(8);
                    }
                    if (bh.ov(str) || bh.ov(CardGiftReceiveUI.b(this.kSX.kSW).kKj) || !str.equals(CardGiftReceiveUI.b(this.kSX.kSW).kKj)) {
                        CardGiftReceiveUI.h(this.kSX.kSW).setVisibility(8);
                    } else {
                        CardGiftReceiveUI.h(this.kSX.kSW).setVisibility(0);
                    }
                    Bitmap op = j.op(str2);
                    if (op == null) {
                        CardGiftReceiveUI.i(this.kSX.kSW).setImageResource(R.k.dyt);
                    } else {
                        CardGiftReceiveUI.i(this.kSX.kSW).setImageBitmap(op);
                    }
                }
            });
        } else {
            x.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
        }
    }
}
