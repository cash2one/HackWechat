package com.tencent.mm.plugin.brandservice.ui.base;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.m.a.a;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class BrandServiceSortView$b implements a {
    static Bitmap kHs = null;
    public View contentView;
    String iconUrl;
    ImageView iip;
    TextView kBH;
    public TextView kEY;
    ImageView kGy;
    View kGz;
    String username;

    public BrandServiceSortView$b() {
        y.Mn().a(this);
    }

    public final void asF() {
        if (this.iip != null) {
            Bitmap d = m.d(this.username, this.iconUrl, 0);
            if (d == null) {
                this.iip.setImageResource(R.g.bzZ);
            } else if (bh.ov(this.username) || this.iip.getTag() == null) {
                x.e("MicroMsg.BrandServiceSortView", "error in refreshAvatar, %s", new Object[]{this.username});
            } else if (this.username.equals(this.iip.getTag())) {
                this.iip.setImageBitmap(d);
            }
        }
    }

    public final void ki(String str) {
        if (str != null && str.equals(this.username)) {
            ag.y(new 1(this));
        }
    }
}
