package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

final class i {

    static class a implements Factory {
        final k xn;

        a(k kVar) {
            this.xn = kVar;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.xn.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.xn + "}";
        }
    }
}
