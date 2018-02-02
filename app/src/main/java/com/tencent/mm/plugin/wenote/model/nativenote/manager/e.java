package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import java.io.Serializable;

public class e implements Serializable {
    public int Ww;
    public int wq;

    public e(int i, int i2) {
        this.Ww = i;
        this.wq = i2;
        if (this.Ww > this.wq) {
            int i3 = this.wq;
            this.wq = this.Ww;
            this.Ww = i3;
        }
    }

    public e(EditText editText) {
        this(editText.getSelectionStart(), editText.getSelectionEnd());
    }

    public final boolean isEmpty() {
        return this.Ww == this.wq;
    }

    public final e es(int i, int i2) {
        this.Ww = Math.max(0, this.Ww - i);
        this.wq += i2;
        return this;
    }

    public String toString() {
        return "[" + this.Ww + ", " + this.wq + "]";
    }
}
