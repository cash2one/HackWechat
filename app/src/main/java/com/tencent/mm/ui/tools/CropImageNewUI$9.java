package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.ak;

class CropImageNewUI$9 implements OnTouchListener {
    final /* synthetic */ CropImageNewUI zhm;
    final /* synthetic */ ak zhn;

    CropImageNewUI$9(CropImageNewUI cropImageNewUI, ak akVar) {
        this.zhm = cropImageNewUI;
        this.zhn = akVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.zhn.J(200, 200);
                break;
            case 1:
                this.zhn.TG();
                break;
        }
        return false;
    }
}
