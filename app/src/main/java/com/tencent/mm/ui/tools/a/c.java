package com.tencent.mm.ui.tools.a;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c extends a {
    private String jUJ;
    public int jXW;
    public boolean znM = true;
    public WeakReference<EditText> znN;
    private int znO;
    private int znP;
    private ArrayList<InputFilter> znQ;
    public a znR;

    public interface a {
        void aem();

        void amI();

        void uY(String str);
    }

    public c(WeakReference<EditText> weakReference) {
        this.znN = weakReference;
        this.jXW = com.tencent.mm.ui.tools.h.a.zkU;
        this.znM = false;
    }

    public static c d(EditText editText) {
        return new c(new WeakReference(editText));
    }

    public final c fi(int i, int i2) {
        this.znP = i;
        this.znO = i2;
        return this;
    }

    public final c GN(int i) {
        this.znP = 0;
        this.znO = i;
        return this;
    }

    public final void a(a aVar) {
        this.znR = aVar;
        ccj();
    }

    protected final int adc() {
        Object obj;
        if (bh.ov(this.jUJ)) {
            if (this.znN == null) {
                return 1;
            }
            this.jUJ = ((EditText) this.znN.get()).getText().toString().trim();
        }
        int du = h.du(this.jUJ, this.jXW);
        if (du < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            x.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            return 2;
        } else if (du < this.znP) {
            return 1;
        } else {
            if (du > this.znO) {
                return 2;
            }
            return 0;
        }
    }

    protected final void ccj() {
        if (!this.znM) {
            if (this.znN == null) {
                x.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
                return;
            } else if (bh.cA(this.znQ)) {
                ((EditText) this.znN.get()).setFilters(new InputFilter[]{bU(this.znO, this.jXW)});
            } else {
                this.znQ.add(bU(this.znO, this.jXW));
                ((EditText) this.znN.get()).setFilters((InputFilter[]) this.znQ.toArray(new InputFilter[this.znQ.size()]));
            }
        }
        if (this.znR != null) {
            switch (adc()) {
                case 0:
                    this.znR.uY(this.jUJ);
                    return;
                case 1:
                    this.znR.amI();
                    return;
                case 2:
                    this.znR.aem();
                    return;
                default:
                    return;
            }
        }
    }

    public h bU(int i, int i2) {
        return new h(i, i2);
    }
}
