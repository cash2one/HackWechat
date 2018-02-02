package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class SearchView$a {
    Method XF;
    Method XG;
    private Method XH;
    Method XI;

    SearchView$a() {
        try {
            this.XF = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.XF.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.XG = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.XG.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            this.XH = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.XH.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        try {
            this.XI = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
            this.XI.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }

    final void a(AutoCompleteTextView autoCompleteTextView) {
        if (this.XH != null) {
            try {
                this.XH.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
            }
        }
    }
}
