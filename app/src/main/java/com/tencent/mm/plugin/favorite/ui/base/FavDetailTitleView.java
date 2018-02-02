package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;

public class FavDetailTitleView extends LinearLayout {
    private ImageView iip;
    private TextView iiq;

    public FavDetailTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.iip = (ImageView) findViewById(R.h.bLL);
        this.iiq = (TextView) findViewById(R.h.cSu);
    }

    public final void F(f fVar) {
        if (fVar != null && fVar.field_favProto != null) {
            CharSequence gv;
            if (14 != fVar.field_type || bh.ov(fVar.field_favProto.title)) {
                this.iip.setVisibility(0);
                vk vkVar = fVar.field_favProto.weS;
                if (vkVar == null || bh.ov(vkVar.wet)) {
                    x.v("MicroMsg.FavDetailTitleView", "display name, from item info user[%s]", new Object[]{fVar.field_fromUser});
                    gv = j.gv(fVar.field_fromUser);
                    b.a(this.iip, fVar.field_fromUser);
                } else {
                    gv = r.gu(vkVar.wet);
                    String gv2;
                    if (q.FS().equals(vkVar.fzO)) {
                        gv2 = j.gv(vkVar.toUser);
                        if (!bh.az(gv2, "").equals(vkVar.toUser)) {
                            gv = gv + " - " + gv2;
                        }
                    } else {
                        gv2 = j.gv(vkVar.fzO);
                        if (!bh.az(gv2, "").equals(vkVar.fzO)) {
                            gv = gv + " - " + gv2;
                        }
                    }
                    x.v("MicroMsg.FavDetailTitleView", "display name, source from[%s] to[%s]", new Object[]{vkVar.fzO, vkVar.toUser});
                    b.a(this.iip, vkVar.wet);
                }
            } else {
                gv = fVar.field_favProto.title;
                this.iip.setVisibility(8);
            }
            this.iiq.setText(i.b(getContext(), gv, this.iiq.getTextSize()));
        }
    }
}
