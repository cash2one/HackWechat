package com.tencent.mm.ui.tools;

class CropImageNewUI$2 implements Runnable {
    final /* synthetic */ CropImageNewUI zhm;

    CropImageNewUI$2(CropImageNewUI cropImageNewUI) {
        this.zhm = cropImageNewUI;
    }

    public final void run() {
        CropImageNewUI.a(this.zhm, CropImageNewUI.e(this.zhm).zif, CropImageNewUI.e(this.zhm).zid);
        this.zhm.finish();
    }
}
