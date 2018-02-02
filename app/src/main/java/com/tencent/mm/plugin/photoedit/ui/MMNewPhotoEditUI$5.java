package com.tencent.mm.plugin.photoedit.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.api.j;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.sdk.platformtools.x;

class MMNewPhotoEditUI$5 implements j {
    final /* synthetic */ int hHw;
    final /* synthetic */ MMNewPhotoEditUI pdv;

    MMNewPhotoEditUI$5(MMNewPhotoEditUI mMNewPhotoEditUI, int i) {
        this.pdv = mMNewPhotoEditUI;
        this.hHw = i;
    }

    public final void b(Exception exception) {
        MMNewPhotoEditUI.c(this.pdv);
        x.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", new Object[]{exception});
        Toast.makeText(this.pdv, this.pdv.getResources().getString(R.l.eci), 1).show();
        this.pdv.setResult(0);
        this.pdv.finish();
    }

    public final void a(Bitmap bitmap, boolean z) {
        x.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
        try {
            String on = d.on("jpg");
            com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.PNG, on, true);
            x.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", new Object[]{on});
            if (MMNewPhotoEditUI.d(this.pdv)) {
                d.b(on, this.pdv);
            }
            if (!(this.hHw == 0 || bitmap.isRecycled())) {
                bitmap.recycle();
            }
            MMNewPhotoEditUI.a(this.pdv, on);
            if (MMNewPhotoEditUI.e(this.pdv) != JsApiCreateAudioInstance.CTRL_INDEX && MMNewPhotoEditUI.e(this.pdv) != JsApiGetAudioState.CTRL_INDEX) {
                MMNewPhotoEditUI.d(this.pdv, on);
            } else if (this.hHw == 0) {
                MMNewPhotoEditUI.b(this.pdv, on);
                MMNewPhotoEditUI.c(this.pdv);
                MMNewPhotoEditUI.b(this.pdv, 1);
            } else if (this.hHw == 1) {
                MMNewPhotoEditUI.c(this.pdv, on);
                MMNewPhotoEditUI.b(this.pdv, 2);
                Toast.makeText(this.pdv.mController.xIM, this.pdv.getString(R.l.eeC), 1).show();
                MMNewPhotoEditUI.c(this.pdv);
                this.pdv.finish();
            } else if (this.hHw == 2) {
                Toast.makeText(this.pdv.mController.xIM, this.pdv.getString(R.l.edU, new Object[]{e.gHu}), 1).show();
                MMNewPhotoEditUI.b(this.pdv, 3);
                MMNewPhotoEditUI.c(this.pdv);
                this.pdv.finish();
            }
        } catch (Exception e) {
            b(e);
        }
    }
}
