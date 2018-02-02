package com.tencent.mm.plugin.emoji.a;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements i {
    final /* synthetic */ i luw;

    i$1(i iVar) {
        this.luw = iVar;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[]{str});
        i.a(this.luw).post(new Runnable(this) {
            final /* synthetic */ i$1 lux;

            {
                this.lux = r1;
            }

            public final void run() {
                this.lux.luw.notifyDataSetChanged();
            }
        });
    }
}
