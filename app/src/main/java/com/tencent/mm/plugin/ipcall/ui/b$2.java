package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.protocal.c.bwo;
import java.util.Iterator;

class b$2 implements TextWatcher {
    final /* synthetic */ b nHy;

    b$2(b bVar) {
        this.nHy = bVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int measureText;
        if (this.nHy.nHi.getLayoutParams() != null) {
            int i4;
            Paint paint = this.nHy.nHe.getPaint();
            if ("+".equals(this.nHy.nHe.getText().toString())) {
                measureText = (int) paint.measureText(this.nHy.nHe.getText().toString());
                this.nHy.nHg.setVisibility(8);
                this.nHy.nHj.setVisibility(8);
                i4 = measureText;
            } else {
                measureText = (int) paint.measureText(this.nHy.nHe.getText() + "+");
                this.nHy.nHg.setVisibility(0);
                this.nHy.nHj.setVisibility(0);
                i4 = measureText;
            }
            LayoutParams layoutParams = (LayoutParams) this.nHy.nHi.getLayoutParams();
            layoutParams.width = i4;
            this.nHy.nHi.setLayoutParams(layoutParams);
        }
        String replace = this.nHy.nHe.getText().toString().replace("+", "");
        if (a.Df(replace)) {
            this.nHy.nHj.setText(a.Dc(replace));
            if (this.nHy.nHq != null && this.nHy.nHq.size() > 0) {
                String Dd = a.Dd(replace);
                Iterator it = this.nHy.nHq.iterator();
                while (it.hasNext()) {
                    bwo com_tencent_mm_protocal_c_bwo = (bwo) it.next();
                    if (com_tencent_mm_protocal_c_bwo != null && com_tencent_mm_protocal_c_bwo.hvC.equals(Dd)) {
                        measureText = 1;
                        break;
                    }
                }
                measureText = 0;
            }
            measureText = 0;
        } else {
            this.nHy.nHj.setText(this.nHy.fmM.getString(R.l.eqA));
            measureText = 0;
        }
        if (measureText != 0) {
            this.nHy.nHk.setVisibility(0);
        } else {
            this.nHy.nHk.setVisibility(8);
        }
        if (this.nHy.nHc != null) {
            this.nHy.nHc.CL(replace);
        }
    }

    public final void afterTextChanged(Editable editable) {
        String replace = this.nHy.nHe.getText().toString().replace("+", "");
        if (replace.startsWith("0") || replace.startsWith("*") || replace.startsWith("#")) {
            this.nHy.nHe.setText("+");
            this.nHy.nHn = "+";
        }
    }
}
