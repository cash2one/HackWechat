package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.plugin.extaccessories.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1 implements ImageWritingListener {
    final /* synthetic */ mz mbX;
    final /* synthetic */ a mbY;

    SubCoreExtAccessories$RegistSpenBuddyEventListener$1(a aVar, mz mzVar) {
        this.mbY = aVar;
        this.mbX = mzVar;
    }

    public void onImageReceived(Bitmap bitmap) {
        x.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
        if (bitmap == null) {
            x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
            this.mbX.fEV.fEW.Sj(null);
        } else if (f.ze()) {
            ar.Ha();
            b bVar = (b) bp.hY("plugin.extaccessories");
            if (bVar == null) {
                x.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
                bVar = new b();
                ar.Ha().a("plugin.extaccessories", bVar);
            }
            String str = System.currentTimeMillis();
            String str2 = (!ar.Hj() || bh.ov(str)) ? "" : bVar.gQi + "image/spen/spen_" + str;
            if (bh.ov(str2)) {
                x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
                this.mbX.fEV.fEW.Sj(null);
                return;
            }
            try {
                if (bitmap.getWidth() > 1000 || bitmap.getHeight() > 1000) {
                    x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
                    if (!(bitmap == createScaledBitmap || createScaledBitmap == null)) {
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                d.a(bitmap, 55, CompressFormat.JPEG, str2, true);
                x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", str2);
                this.mbX.fEV.fEW.Sj(str2);
            } catch (Throwable e) {
                x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", e.getMessage());
                x.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", e, "", new Object[0]);
                this.mbX.fEV.fEW.Sj(null);
            }
        } else {
            x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
            this.mbX.fEV.fEW.Sj(null);
        }
    }
}
