package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.widget.g;

class CropImageNewUI$20 implements OnMenuItemClickListener {
    final /* synthetic */ CropImageNewUI zhm;

    CropImageNewUI$20(CropImageNewUI cropImageNewUI) {
        this.zhm = cropImageNewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.zhm, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new p$d(this) {
            final /* synthetic */ CropImageNewUI$20 zhr;

            {
                this.zhr = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 0:
                        intent = new Intent();
                        intent.putExtra("CropImage_OutputPath", this.zhr.zhm.getIntent().getStringExtra("CropImage_OutputPath"));
                        intent.putExtra("OP_CODE", 1);
                        this.zhr.zhm.setResult(-1, intent);
                        this.zhr.zhm.finish();
                        return;
                    case 1:
                        intent = new Intent();
                        intent.putExtra("CropImage_OutputPath", this.zhr.zhm.getIntent().getStringExtra("CropImage_OutputPath"));
                        intent.putExtra("OP_CODE", 2);
                        this.zhr.zhm.setResult(-1, intent);
                        this.zhr.zhm.finish();
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUk();
        return true;
    }
}
