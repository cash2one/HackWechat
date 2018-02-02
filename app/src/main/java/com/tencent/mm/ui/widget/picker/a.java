package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.cb.a.e;
import com.tencent.mm.cb.a.f;
import java.util.ArrayList;

public final class a implements OnGlobalLayoutListener {
    private Button krY;
    private Button krZ;
    private View lCk = View.inflate(this.mContext, f.zzA, null);
    private Context mContext;
    private c yIe = new c(this.mContext);
    private int yIf;
    private BottomSheetBehavior yIg;
    private String[] zxY;
    private int zxZ;
    private OptionPicker zya = ((OptionPicker) this.lCk.findViewById(e.zzo));
    public a zyb;

    static /* synthetic */ void a(a aVar, boolean z, Object obj) {
        if (aVar.zyb != null) {
            aVar.zyb.f(z, obj);
        }
    }

    public a(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.zxY = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this.zya.j(this.zxY);
        this.zxZ = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 288);
        this.krY = (Button) this.lCk.findViewById(e.cBC);
        this.krY.setOnClickListener(new 1(this));
        this.krZ = (Button) this.lCk.findViewById(e.bPo);
        this.krZ.setOnClickListener(new 2(this));
        this.yIe.setContentView(this.lCk);
        this.yIf = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 350);
        this.yIg = BottomSheetBehavior.i((View) this.lCk.getParent());
        if (this.yIg != null) {
            this.yIg.q(this.yIf);
            this.yIg.fj = false;
        }
        this.yIe.setOnDismissListener(new 3(this));
    }

    public final void onGlobalLayout() {
    }

    public final void Hk(int i) {
        if (i != 0) {
            this.zxZ = i;
        }
        LayoutParams layoutParams = (LayoutParams) this.lCk.getLayoutParams();
        layoutParams.height = this.zxZ;
        this.lCk.setLayoutParams(layoutParams);
        this.lCk.invalidate();
    }

    public final void show() {
        if (this.yIe != null) {
            this.yIe.show();
        }
    }

    public final void hide() {
        if (this.yIe != null) {
            this.yIe.dismiss();
        }
    }

    public final void Hl(int i) {
        if (this.zya != null) {
            this.zya.setValue(i);
        }
    }

    public final int czu() {
        if (this.zya != null) {
            return this.zya.getValue();
        }
        return 0;
    }
}
