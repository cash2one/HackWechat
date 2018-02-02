package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ac;

class CropImageNewUI$22 implements Runnable {
    final /* synthetic */ CropImageNewUI zhm;

    CropImageNewUI$22(CropImageNewUI cropImageNewUI) {
        this.zhm = cropImageNewUI;
    }

    public final void run() {
        boolean z = false;
        if (CropImageNewUI.e(this.zhm) != null) {
            if (this.zhm.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                Editor edit = this.zhm.getSharedPreferences(ac.cfs(), 0).edit();
                String str = "CropImage_Filter_Show";
                if (CropImageNewUI.e(this.zhm).findViewById(R.h.bZP).getVisibility() == 0) {
                    z = true;
                }
                edit.putBoolean(str, z);
                edit.commit();
            }
            String stringExtra = this.zhm.getIntent().getStringExtra("CropImage_OutputPath");
            if (stringExtra == null) {
                stringExtra = e.gHu + g.s((CropImageNewUI.o(this.zhm) + System.currentTimeMillis()).getBytes()) + "_fiter.jpg";
            }
            Intent intent = new Intent();
            intent.putExtra("CropImage_Compress_Img", true);
            if (CropImageNewUI.e(this.zhm) != null) {
                intent.putExtra("CropImage_filterId", CropImageNewUI.e(this.zhm).qQV);
            }
            if (CropImageNewUI.e(this.zhm).qQV == 0) {
                intent.putExtra("CropImage_OutputPath", CropImageNewUI.o(this.zhm));
                this.zhm.setResult(-1, intent);
            } else if (CropImageNewUI.a(this.zhm, CropImageNewUI.e(this.zhm).zig, stringExtra)) {
                intent.putExtra("CropImage_OutputPath", stringExtra);
                this.zhm.setResult(-1, intent);
            } else {
                this.zhm.setResult(-1);
            }
            this.zhm.finish();
        }
    }
}
