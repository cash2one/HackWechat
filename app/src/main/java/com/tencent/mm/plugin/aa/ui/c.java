package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.z.q;
import java.util.regex.Pattern;

public final class c extends a {
    private static final Pattern iik = Pattern.compile(",");
    public CharSequence iil;
    public CharSequence iim;
    private b iin = new b(this);
    a iio = new a(this);
    public String username;

    public c(int i) {
        super(2, i);
    }

    public final void bH(Context context) {
        if (this.jLe == null) {
            x.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[]{Integer.valueOf(this.position)});
            return;
        }
        CharSequence c;
        this.username = this.jLe.field_username;
        if (bh.ov(this.fpF)) {
            c = ((b) g.h(b.class)).c(this.jLe);
        } else {
            c = ((b) g.h(b.class)).L(this.jLe.field_username, this.fpF);
        }
        if (q.FS().equals(this.username)) {
            c = c + context.getString(i.uHe);
        }
        this.iil = com.tencent.mm.pluginsdk.ui.d.i.c(context, c, com.tencent.mm.bv.a.aa(context, d.bvK));
    }

    public final a.b WQ() {
        return this.iin;
    }

    protected final a.a WR() {
        return this.iio;
    }
}
