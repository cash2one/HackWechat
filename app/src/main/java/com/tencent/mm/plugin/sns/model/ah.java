package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import java.util.HashMap;
import java.util.Map;

public final class ah extends a {
    int alpha = 255;
    long mUW;
    boolean mUX = false;
    private Map<String, Boolean> qWX = new HashMap();

    public ah(String str, n nVar, long j) {
        super(str, nVar);
        if (j != 0) {
            this.mUW = j;
            this.qWX.put(str, Boolean.valueOf(true));
            this.mUX = true;
        } else if (!this.qWX.containsKey(str)) {
            this.mUW = SystemClock.uptimeMillis();
            this.qWX.put(str, Boolean.valueOf(true));
            this.mUX = true;
        }
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Bitmap ED = this.har.ED();
        if (i.m(ED)) {
            if (this.mUX) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mUW)) / 150.0f;
                if (this.mUW == 0) {
                    uptimeMillis = 0.0f;
                }
                if (uptimeMillis >= 1.0f) {
                    this.mUX = false;
                } else {
                    hap.setAlpha((int) (uptimeMillis * ((float) this.alpha)));
                    canvas.drawBitmap(ED, null, bounds, hap);
                    invalidateSelf();
                    return;
                }
            }
            hap.setAlpha(this.alpha);
            canvas.drawBitmap(ED, null, bounds, hap);
            return;
        }
        canvas.drawColor(-1118482);
        this.mUW = 0;
    }
}
