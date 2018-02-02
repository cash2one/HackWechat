package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CropImageNewUI$17 implements OnMenuItemClickListener {
    final /* synthetic */ CropImageNewUI zhm;
    final /* synthetic */ boolean zhp;
    final /* synthetic */ boolean zhq;

    CropImageNewUI$17(CropImageNewUI cropImageNewUI, boolean z, boolean z2) {
        this.zhm = cropImageNewUI;
        this.zhp = z;
        this.zhq = z2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!this.zhp || !this.zhq) {
            switch (CropImageNewUI.f(this.zhm)) {
                case 1:
                    if (CropImageNewUI.e(this.zhm) == null) {
                        CropImageNewUI.a(this.zhm, CropImageNewUI.j(this.zhm), CropImageNewUI.i(this.zhm));
                        break;
                    }
                    CropImageNewUI.a(this.zhm, CropImageNewUI.e(this.zhm).zif, CropImageNewUI.i(this.zhm));
                    break;
                case 2:
                    CropImageNewUI.k(this.zhm);
                    break;
                case 3:
                    CropImageNewUI.l(this.zhm);
                    break;
                case 4:
                    CropImageNewUI.m(this.zhm);
                    break;
                case 5:
                    CropImageNewUI.n(this.zhm);
                    break;
                default:
                    break;
            }
        }
        CropImageNewUI.a(this.zhm, true);
        return true;
    }
}
