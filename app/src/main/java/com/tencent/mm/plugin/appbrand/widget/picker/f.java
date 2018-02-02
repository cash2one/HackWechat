package com.tencent.mm.plugin.appbrand.widget.picker;

import android.text.Editable;
import android.text.Editable.Factory;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.mm.compatible.loader.c;

final class f {
    static void a(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                EditText editText = (EditText) new c(numberPicker, "mInputText", null).get();
                if (editText != null) {
                    editText.setEditableFactory(new Factory() {
                        public final Editable newEditable(CharSequence charSequence) {
                            return new 1(this, charSequence);
                        }
                    });
                }
            } catch (Exception e) {
            }
        }
    }
}
