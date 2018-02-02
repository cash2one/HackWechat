package com.tencent.mm.ui.widget.picker;

import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.NumberPicker;

public enum c {
    ;

    public static void a(NumberPicker numberPicker, Drawable drawable) {
        if (numberPicker != null) {
            try {
                new com.tencent.mm.compatible.loader.c(numberPicker, "mSelectionDivider", null).set(drawable);
            } catch (Exception e) {
            }
        }
    }

    public static EditText b(NumberPicker numberPicker) {
        if (numberPicker == null) {
            return null;
        }
        try {
            return (EditText) new com.tencent.mm.compatible.loader.c(numberPicker, "mInputText", null).get();
        } catch (Exception e) {
            return null;
        }
    }

    public static void c(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                EditText editText = (EditText) new com.tencent.mm.compatible.loader.c(numberPicker, "mInputText", null).get();
                if (editText != null) {
                    editText.setClickable(false);
                    editText.setFocusable(false);
                    editText.setFocusableInTouchMode(false);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void d(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                EditText editText = (EditText) new com.tencent.mm.compatible.loader.c(numberPicker, "mInputText", null).get();
                if (editText != null) {
                    editText.setFilters(new InputFilter[0]);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void e(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                Runnable runnable = (Runnable) new com.tencent.mm.compatible.loader.c(numberPicker, "mSetSelectionCommand", null).get();
                if (runnable != null) {
                    numberPicker.removeCallbacks(runnable);
                }
            } catch (Exception e) {
            }
        }
    }
}
