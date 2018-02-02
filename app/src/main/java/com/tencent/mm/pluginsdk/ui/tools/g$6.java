package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.g.d;
import com.tencent.mm.sdk.platformtools.x;

class g$6 implements a {
    final /* synthetic */ g vxl;

    g$6(g gVar) {
        this.vxl = gVar;
    }

    public final void l(String str, final Bitmap bitmap) {
        boolean z = false;
        String str2 = "MicroMsg.ImageEngine";
        String str3 = "on get picture finish, notifyKey[%s], bitmap is null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (bitmap == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.v(str2, str3, objArr);
        if (bitmap != null) {
            this.vxl.vxf.put(str, bitmap);
            final ImageView imageView = (ImageView) this.vxl.vxd.get(str);
            if (imageView != null) {
                this.vxl.vxe.remove(imageView);
                this.vxl.hae.post(new Runnable(this) {
                    final /* synthetic */ g$6 vxp;

                    public final void run() {
                        d.b(imageView, bitmap);
                    }
                });
            }
            this.vxl.vxd.remove(str);
        }
    }
}
