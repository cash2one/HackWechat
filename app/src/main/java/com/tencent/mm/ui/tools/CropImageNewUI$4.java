package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class CropImageNewUI$4 implements OnClickListener {
    final /* synthetic */ CropImageNewUI zhm;

    CropImageNewUI$4(CropImageNewUI cropImageNewUI) {
        this.zhm = cropImageNewUI;
    }

    public final void onClick(View view) {
        CropImageView j = CropImageNewUI.j(this.zhm);
        if (j.mTJ == null) {
            x.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
            return;
        }
        float[] fArr = new float[]{(float) (j.mTJ.getWidth() / 2), (float) (j.mTJ.getHeight() / 2)};
        j.getImageMatrix().mapPoints(fArr);
        j.getImageMatrix().postRotate(90.0f, fArr[0], fArr[1]);
        j.setImageBitmap(j.mTJ);
        j.invalidate();
        j.fyR++;
    }
}
