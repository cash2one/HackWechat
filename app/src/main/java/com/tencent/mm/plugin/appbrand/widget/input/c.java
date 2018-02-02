package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.j;
import java.lang.ref.WeakReference;

public abstract class c<Input extends EditText & z> extends j implements y {
    private final a inputExceedMaxLengthCallback = new n.a(this) {
        final /* synthetic */ c jWM;

        {
            this.jWM = r1;
        }

        public final void aem() {
            if (this.jWM.amv() != null) {
                this.jWM.b(this.jWM.amv().getEditableText());
            }
        }
    };
    public ab jWH;
    public aa jWI;
    final String jWJ;
    public final WeakReference<p> jWK;
    public final OnFocusChangeListener jWL = new OnFocusChangeListener(this) {
        final /* synthetic */ c jWM;

        {
            this.jWM = r1;
        }

        public final void onFocusChange(View view, boolean z) {
            this.jWM.dr(z);
            if (z) {
                m.a((p) this.jWM.jWK.get(), (z) this.jWM.amv());
                ((z) this.jWM.amv()).mc(this.jWM.getInputId());
                m.a(this.jWM.getInputId(), this.jWM);
            }
        }
    };

    public abstract Input amv();

    public abstract Rect amw();

    protected abstract h b(h hVar);

    protected abstract boolean dr(boolean z);

    public abstract int getInputId();

    public abstract boolean uW(String str);

    c(String str, p pVar) {
        this.jWJ = str;
        this.jWK = new WeakReference(pVar);
    }

    public boolean removeSelf() {
        return amx();
    }

    public Input getWidget() {
        return amv();
    }

    public final boolean amx() {
        View amv = amv();
        if (amv == null) {
            return false;
        }
        ((z) amv).b(this.jWL);
        amv.removeTextChangedListener(this);
        ((z) amv).destroy();
        p pVar = (p) this.jWK.get();
        if (pVar == null) {
            return false;
        }
        f fVar = pVar.jDR;
        if (fVar == null) {
            return false;
        }
        fVar.bR(amv);
        return true;
    }

    public boolean isAttachedTo(p pVar) {
        return pVar != null && pVar == this.jWK.get();
    }

    final void a(Editable editable) {
        if (this.jWH != null) {
            this.jWH.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), ab.a.jZk);
        }
    }

    public final void ky(int i) {
        if (this.jWI != null) {
            this.jWI.lT(i);
        }
    }

    public final void afterTextChanged(Editable editable) {
        b(editable);
    }

    private void b(Editable editable) {
        if (this.jWH != null) {
            this.jWH.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), ab.a.jZm);
        }
    }

    public final boolean a(h hVar) {
        h b = b(hVar);
        if (b == null) {
            return false;
        }
        if (b.kbT == null) {
            b.kbT = Integer.valueOf(b.CTRL_INDEX);
        } else if (b.kbT.intValue() <= 0) {
            b.kbT = Integer.valueOf(Integer.MAX_VALUE);
        }
        if (amv() == null) {
            return false;
        }
        com.tencent.mm.ui.tools.a.c GN = n.a(amv()).GN(b.kbT.intValue());
        GN.znM = false;
        GN.jXW = com.tencent.mm.ui.tools.h.a.zkT;
        GN.a(this.inputExceedMaxLengthCallback);
        return true;
    }

    public final void updateValue(String str, Integer num) {
        uW(str);
        Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
        setInputSelection(valueOf.intValue(), valueOf.intValue());
    }

    public final Editable amy() {
        return amv() == null ? null : amv().getEditableText();
    }

    protected final void setInputSelection(int i, int i2) {
        b.a(amv(), i, i2);
    }
}
