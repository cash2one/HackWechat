package com.tencent.magicbrush.handler.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

final class e {
    Bitmap bnI;
    d bnJ = new l();
    Rect bnK = new Rect();
    int[] bnL = new int[4];

    e(int i, int i2) {
        if (i <= 0) {
            i = WXMediaMessage.TITLE_LENGTH_LIMIT;
        }
        if (i2 <= 0) {
            i2 = WXMediaMessage.TITLE_LENGTH_LIMIT;
        }
        this.bnI = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        this.bnJ.init(i, i2);
        this.bnK.setEmpty();
    }

    final boolean b(int i, int i2, Rect rect) {
        if (rect == null) {
            return false;
        }
        if (i <= 0 || i2 <= 0) {
            rect.setEmpty();
            return false;
        }
        this.bnJ.a(i, i2, rect);
        if (rect.left < 0 || rect.right < 0 || rect.width() <= 0 || rect.height() <= 0) {
            return false;
        }
        this.bnK.union(rect);
        return true;
    }

    final int width() {
        if (this.bnI != null) {
            return this.bnI.getWidth();
        }
        return 0;
    }

    final int height() {
        if (this.bnI != null) {
            return this.bnI.getHeight();
        }
        return 0;
    }
}
