package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.widget.input.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.wcdb.database.SQLiteDatabase;

@SuppressLint({"AppCompatCustomView"})
public class WAGamePanelInputEditText extends EditText {
    public final x jaA;
    private final InputFilter jaB;
    public int jaC;
    private final Factory jaD;

    static /* synthetic */ Spannable a(WAGamePanelInputEditText wAGamePanelInputEditText, Spannable spannable) {
        PInt pInt = new PInt();
        pInt.value = wAGamePanelInputEditText.jaC;
        b cgX = b.cgX();
        wAGamePanelInputEditText.getContext();
        return cgX.a(spannable, Math.round(wAGamePanelInputEditText.getTextSize()), pInt, wAGamePanelInputEditText.jaD);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.editTextStyle);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jaB = new 2(this);
        this.jaC = Integer.MAX_VALUE;
        this.jaD = new 3(this);
        this.jaA = new x(this);
        super.setEditableFactory(new Editable.Factory(this) {
            final /* synthetic */ WAGamePanelInputEditText jaE;

            {
                this.jaE = r1;
            }

            public final Editable newEditable(CharSequence charSequence) {
                return this.jaE.jaA.c((Editable) WAGamePanelInputEditText.a(this.jaE, super.newEditable(charSequence)));
            }
        });
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        if (this.jaB != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i < inputFilterArr.length) {
                inputFilterArr2[i] = inputFilterArr[i];
                i++;
            }
            inputFilterArr2[i] = this.jaB;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions |= SQLiteDatabase.CREATE_IF_NECESSARY;
        return onCreateInputConnection;
    }
}
