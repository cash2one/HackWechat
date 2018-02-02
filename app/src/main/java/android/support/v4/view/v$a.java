package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

class v$a extends SingleLineTransformationMethod {
    private Locale yk;

    public v$a(Context context) {
        this.yk = context.getResources().getConfiguration().locale;
    }

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        CharSequence transformation = super.getTransformation(charSequence, view);
        return transformation != null ? transformation.toString().toUpperCase(this.yk) : null;
    }
}
