package com.tencent.mm.ui.tools;

class CropImageNewUI$23 implements Runnable {
    final /* synthetic */ CropImageNewUI zhm;

    CropImageNewUI$23(CropImageNewUI cropImageNewUI) {
        this.zhm = cropImageNewUI;
    }

    public final void run() {
        if (this.zhm.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
            this.zhm.finish();
            return;
        }
        CropImageNewUI.e(this.zhm).setVisibility(8);
        CropImageNewUI.p(this.zhm).setVisibility(0);
        CropImageNewUI.q(this.zhm).setVisibility(((Integer) CropImageNewUI.q(this.zhm).getTag()).intValue());
        CropImageNewUI.j(this.zhm).setVisibility(0);
    }
}
