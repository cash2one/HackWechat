package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.picker.b.a;

class b$a$1 implements OnClickListener {
    final /* synthetic */ int kI;
    final /* synthetic */ o zym;
    final /* synthetic */ a zyn;

    b$a$1(a aVar, int i, o oVar) {
        this.zyn = aVar;
        this.kI = i;
        this.zym = oVar;
    }

    public final void onClick(View view) {
        if (this.zyn.zyj.rKD != null) {
            this.zyn.zyj.rKD.onMMMenuItemSelected(this.zyn.zyj.rKE.getItem(this.kI), this.kI);
        }
        if (!this.zym.wPS) {
            if (((Boolean) a.a(this.zyn).get(Integer.valueOf(this.kI))).booleanValue()) {
                a.a(this.zyn).put(Integer.valueOf(this.kI), Boolean.valueOf(false));
            } else {
                a.a(this.zyn).put(Integer.valueOf(this.kI), Boolean.valueOf(true));
            }
            this.zyn.zyk = a.a(this.zyn);
            this.zyn.notifyDataSetChanged();
        }
    }
}
