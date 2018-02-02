package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.af.b;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.plugin.appbrand.widget.input.t.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class d extends c<q> {
    final int jWO;
    int jWP = 0;
    q jWQ;
    t jWR;
    h jWS;
    boolean jWT;
    boolean jWU;

    final /* bridge */ /* synthetic */ EditText amv() {
        return this.jWQ;
    }

    d(String str, p pVar, e eVar) {
        super(str, pVar);
        this.jWQ = new q(pVar.mContext);
        b.setNoSystemInputOnEditText(this.jWQ);
        this.jWO = eVar.jWO;
        this.jWP = bh.a((Integer) m.jXN.get(str), 0);
    }

    final int getInputId() {
        return this.jWO;
    }

    public final View getInputPanel() {
        findNumberKeyboard();
        return this.jWR;
    }

    public final boolean adjustPositionOnFocused() {
        return this.jWS != null && af.e(this.jWS.kch);
    }

    public final int getInputPanelMarginBottom() {
        return (this.jWS == null || this.jWS.kce == null) ? 0 : this.jWS.kce.intValue();
    }

    final Rect amw() {
        return new Rect(this.jWS.kbL.intValue(), this.jWS.kbK.intValue(), this.jWS.kbL.intValue() + this.jWS.kbI.intValue(), this.jWS.kbK.intValue() + this.jWS.kbJ.intValue());
    }

    public final h b(h hVar) {
        if (this.jWS == null) {
            this.jWS = hVar;
            if (af.e(hVar.kcp) && this.jWQ != null) {
                this.jWQ.dv(true);
            }
        } else {
            this.jWS.a(hVar);
        }
        if (this.jWQ == null) {
            return null;
        }
        b.a(this.jWQ, this.jWS);
        return this.jWS;
    }

    public final boolean uW(String str) {
        if (this.jWQ == null) {
            return false;
        }
        this.jWQ.r(str);
        return true;
    }

    public final boolean showKeyboard(int i, int i2) {
        if (this.jWQ == null) {
            return false;
        }
        this.jWR = t.bX(((p) this.jWK.get()).getContentView());
        if (this.jWR == null) {
            return false;
        }
        this.jWU = true;
        p pVar = (p) this.jWK.get();
        if (!(pVar == null || pVar.jDS == null)) {
            g.amA().o(pVar.jDS);
        }
        t tVar = this.jWR;
        tVar.jNY.setXMode(this.jWP);
        tVar = this.jWR;
        EditText editText = this.jWQ;
        if (editText != null) {
            if (tVar.kT != editText) {
                tVar.amQ();
            }
            tVar.setInputEditText(editText);
            b.c(tVar.kT);
            tVar.kT.requestFocus();
            tVar.setVisibility(0);
        }
        this.jWR.jYq = new a(this) {
            final /* synthetic */ d jWV;

            {
                this.jWV = r1;
            }

            public final void onDone() {
                this.jWV.a(this.jWV.amy());
                this.jWV.dr(false);
            }
        };
        setInputSelection(i, i2);
        i.a(this.jWK).amC();
        this.jWU = false;
        return true;
    }

    public final boolean hideKeyboard() {
        if (findNumberKeyboard() == null || !isFocused()) {
            return false;
        }
        t tVar = this.jWR;
        tVar.setVisibility(8);
        tVar.amQ();
        x.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[]{this.jWQ});
        if (this.jWQ != null) {
            this.jWQ.setFocusable(false);
            this.jWQ.setFocusableInTouchMode(false);
            this.jWQ.setEnabled(false);
        }
        p pVar = (p) this.jWK.get();
        if (!(pVar == null || pVar.jDS == null)) {
            g.amA().p(pVar.jDS);
        }
        i.a(this.jWK).amD();
        return true;
    }

    private boolean isFocused() {
        if (this.jWQ == null) {
            return false;
        }
        if (this.jWQ.isFocused()) {
            return true;
        }
        if (findNumberKeyboard() != null && findNumberKeyboard().isShown() && this.jWR.kT == this.jWQ) {
            return true;
        }
        return false;
    }

    protected final boolean dr(boolean z) {
        x.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isFocused())});
        if (z) {
            if (!(this.jWU || isFocused())) {
                this.jWU = true;
                showKeyboard(-2, -2);
                this.jWU = false;
            }
        } else if (!this.jWT && isFocused()) {
            this.jWT = true;
            a(amy());
            hideKeyboard();
            amx();
            this.jWT = false;
            this.jWQ = null;
        }
        return true;
    }

    private t findNumberKeyboard() {
        if (this.jWR != null) {
            return this.jWR;
        }
        t bW = t.bW(this.jWQ);
        this.jWR = bW;
        return bW;
    }
}
