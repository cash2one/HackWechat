package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public final class g extends l implements b {
    public final /* bridge */ /* synthetic */ void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }

    public final /* bridge */ /* synthetic */ boolean a(f fVar, x xVar, boolean z, int i) {
        return super.a(fVar, xVar, z, i);
    }

    public final /* bridge */ /* synthetic */ boolean arS() {
        return super.arS();
    }

    public final /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public g(Context context) {
        super(context, new q(context));
        a.xef.m(new hs());
    }

    public static void aaS() {
        ar.Hg();
        c.Fa().ED("feedsapp");
        ar.Hg();
        c.Fd().WX("feedsapp");
    }

    protected final void clear() {
        aaS();
    }

    protected final void hi(boolean z) {
        Context context = this.context;
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        new ak(new 1(z, null, h.a(context, string, true, null)), false).J(1500, 1500);
    }

    protected final boolean bjz() {
        return (q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
    }

    protected final int XB() {
        return R.o.fbp;
    }

    public final boolean vQ(String str) {
        if ("contact_info_plugin_view".equals(str)) {
            Intent intent = new Intent();
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            d.b(this.context, "sns", ".ui.SnsTimeLineUI", intent);
            return true;
        }
        if ("contact_info_plugin_outsize".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            d.b(this.context, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if ("contact_info_plugin_black".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            d.b(this.context, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (!str.equals("contact_info_plugin_uninstall")) {
            return super.vQ(str);
        }
        h.a(this.context, this.context.getString(R.l.eME), "", this.context.getString(R.l.dGN), this.context.getString(R.l.dEn), new 2(this), null);
        return true;
    }
}
