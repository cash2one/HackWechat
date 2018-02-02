package com.tencent.mm.plugin.multitalk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class l {
    public volatile Map<String, a> oHn = Collections.synchronizedMap(new HashMap());

    public final synchronized boolean a(MultiTalkVideoView multiTalkVideoView, int[] iArr, int i, int i2, int i3, int i4) {
        boolean z;
        if (multiTalkVideoView == null) {
            x.e("MicroMsg.MT.MultiTalkViewManager", "drawVideo view is null");
            z = false;
        } else if (iArr == null) {
            x.e("MicroMsg.MT.MultiTalkViewManager", "renderVideoBitmap img is null");
            z = false;
        } else if (iArr.length < i * i2) {
            x.e("MicroMsg.MT.MultiTalkViewManager", "img length error %d %d", new Object[]{Integer.valueOf(iArr.length), Integer.valueOf(i * i2)});
            z = false;
        } else if (i != i2) {
            x.e("MicroMsg.MT.MultiTalkViewManager", "imgW != imgH");
            z = false;
        } else {
            a aVar;
            a aVar2 = (a) this.oHn.get(multiTalkVideoView.username);
            if (aVar2 == null) {
                aVar2 = new a(this, (byte) 0);
                this.oHn.put(multiTalkVideoView.username, aVar2);
                aVar = aVar2;
            } else {
                aVar = aVar2;
            }
            aVar.oGY = i3;
            aVar.angle = i4;
            if (aVar.oHq == null || aVar.oHq.getWidth() != i2) {
                aVar.oHq = Bitmap.createBitmap(i2, i2, Config.ARGB_8888);
            }
            aVar.oHq.setPixels(iArr, 0, i2, 0, 0, i2, i2);
            multiTalkVideoView.b(aVar.oHq, aVar.angle, aVar.oGY);
            z = true;
        }
        return z;
    }

    public final boolean a(MultiTalkVideoView multiTalkVideoView, boolean z) {
        if (multiTalkVideoView == null) {
            x.e("MicroMsg.MT.MultiTalkViewManager", "drawAvatar view is null");
            return false;
        }
        a aVar;
        if (this.oHn.containsKey(multiTalkVideoView.username)) {
            aVar = (a) this.oHn.get(multiTalkVideoView.username);
        } else {
            aVar = new a(this, (byte) 0);
            aVar.username = multiTalkVideoView.username;
            this.oHn.put(multiTalkVideoView.username, aVar);
        }
        Bitmap b;
        if (aVar.oHo == null) {
            b = b.bZV().b(multiTalkVideoView.username, multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (b != null && b.getHeight() < b.getWidth()) {
                b = Bitmap.createBitmap(b, 0, 0, b.getHeight(), b.getHeight());
            }
            aVar.oHo = b;
        } else if (z) {
            b = b.bZV().b(multiTalkVideoView.username, multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (b != null && b.getHeight() < b.getWidth()) {
                b = Bitmap.createBitmap(b, 0, 0, b.getHeight(), b.getHeight());
            }
            aVar.oHo = b;
        }
        if (aVar.oHo != null) {
            multiTalkVideoView.b(aVar.oHo, 0, 0);
            return true;
        }
        if (aVar.oHp == null) {
            aVar.oHp = BitmapFactory.decodeResource(multiTalkVideoView.getResources(), R.g.bDO);
        }
        multiTalkVideoView.b(aVar.oHp, 0, 0);
        return true;
    }

    public final void bcP() {
        this.oHn.clear();
    }
}
