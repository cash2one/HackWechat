package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.api.j;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

class TestVideoEditUI$2 implements j {
    final /* synthetic */ TestVideoEditUI oDv;

    TestVideoEditUI$2(TestVideoEditUI testVideoEditUI) {
        this.oDv = testVideoEditUI;
    }

    public final void b(Exception exception) {
    }

    public final void a(Bitmap bitmap, boolean z) {
        x.i("MicroMsg.TestVideoEditUI", "[onSuccess] w:%s h:%s", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
        try {
            d.a(bitmap, 100, CompressFormat.PNG, e.gHt + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), "png"}), true);
        } catch (IOException e) {
        }
    }
}
