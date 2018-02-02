package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a$a;

public final class b extends a {
    private static com.tencent.mm.ui.base.sortview.a.b kFf;
    protected String iconUrl;
    CharSequence iil;
    protected CharSequence kET;
    protected boolean kEW;
    protected boolean kEX;
    protected String kFg;
    protected String username;

    public b(Object obj, String str) {
        super(6, obj);
        this.kFg = str;
    }

    public final com.tencent.mm.ui.base.sortview.a.b asm() {
        if (kFf == null) {
            kFf = new 1(this);
        }
        return kFf;
    }

    public final a$a asn() {
        return new a();
    }

    public final void a(Context context, a$a com_tencent_mm_ui_base_sortview_a_a, Object... objArr) {
        if (!this.yjT) {
            if (context == null || com_tencent_mm_ui_base_sortview_a_a == null || this.data == null) {
                x.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(com_tencent_mm_ui_base_sortview_a_a instanceof a)) {
                x.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
            } else if (this.data instanceof bfd) {
                bfd com_tencent_mm_protocal_c_bfd = (bfd) this.data;
                try {
                    this.iil = i.b(context, com_tencent_mm_protocal_c_bfd.wsB != null ? com_tencent_mm_protocal_c_bfd.wsB.toString() : "", ((a) com_tencent_mm_ui_base_sortview_a_a).kBH.getTextSize());
                } catch (Exception e) {
                    this.iil = "";
                }
                this.iconUrl = com_tencent_mm_protocal_c_bfd.vUV;
                this.username = com_tencent_mm_protocal_c_bfd.vYI.toString();
            } else {
                x.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
            }
        }
    }
}
