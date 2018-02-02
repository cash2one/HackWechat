package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j.a;

class MallOrderProductListUI$b implements a {
    String kJP;
    ImageView kUM;
    final /* synthetic */ MallOrderProductListUI pci;
    TextView pcj;
    TextView pck;
    TextView pcl;
    TextView pcm;
    TextView pcn;

    private MallOrderProductListUI$b(MallOrderProductListUI mallOrderProductListUI) {
        this.pci = mallOrderProductListUI;
    }

    public final void l(String str, Bitmap bitmap) {
        if (str != null && str.equals(this.kJP)) {
            this.kUM.post(new 1(this, bitmap));
        }
    }
}
