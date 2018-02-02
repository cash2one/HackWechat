package com.tencent.mm.view.d;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements m {
    private com.tencent.mm.aq.a.d.a<String, Bitmap> hEf = new com.tencent.mm.aq.a.d.a(150);

    public final Bitmap iG(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return (Bitmap) this.hEf.get(str);
    }

    public final void c(String str, Bitmap bitmap) {
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            x.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
        } else {
            this.hEf.put(str, bitmap);
        }
    }

    public final void clear() {
        synchronized (this) {
            if (this.hEf != null) {
                Map snapshot = this.hEf.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value : snapshot.entrySet()) {
                        Bitmap bitmap = (Bitmap) value.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            x.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[]{bitmap.toString()});
                        }
                    }
                }
                this.hEf.clear();
            }
        }
    }
}
