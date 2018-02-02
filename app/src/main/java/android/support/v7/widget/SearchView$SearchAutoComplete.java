package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.a.a.a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.InputMethodManager;

public class SearchView$SearchAutoComplete extends AppCompatAutoCompleteTextView {
    SearchView XK;
    private int mThreshold;

    static /* synthetic */ boolean a(SearchView$SearchAutoComplete searchView$SearchAutoComplete) {
        return TextUtils.getTrimmedLength(searchView$SearchAutoComplete.getText()) == 0;
    }

    public SearchView$SearchAutoComplete(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.autoCompleteTextViewStyle);
    }

    public SearchView$SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mThreshold = getThreshold();
    }

    public void setThreshold(int i) {
        super.setThreshold(i);
        this.mThreshold = i;
    }

    protected void replaceText(CharSequence charSequence) {
    }

    public void performCompletion() {
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.XK.hasFocus() && getVisibility() == 0) {
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
            if (SearchView.q(getContext())) {
                SearchView.Xv.a(this);
            }
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        this.XK.gB();
    }

    public boolean enoughToFilter() {
        return this.mThreshold <= 0 || super.enoughToFilter();
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState == null) {
                    return true;
                }
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == 1) {
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    this.XK.clearFocus();
                    SearchView.p(this.XK);
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }
}
