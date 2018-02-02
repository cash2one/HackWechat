package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.m;

public class MMFormSelectorView extends LinearLayout {
    private TextView iiq;
    private int layout;
    private Context mContext;
    private EditText pqM;
    private String title;
    private String vtt;

    @TargetApi(11)
    public MMFormSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.layout = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fag, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(m.gZa, 0);
        if (resourceId != 0) {
            this.title = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(m.gZb, 0);
        if (resourceId != 0) {
            this.vtt = context.getString(resourceId);
        }
        this.layout = obtainStyledAttributes.getResourceId(m.gYZ, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.iiq = (TextView) findViewById(g.title);
        this.pqM = (EditText) findViewById(g.cdj);
        if (this.iiq == null || this.pqM == null) {
            x.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", new Object[]{this.iiq, this.pqM});
            return;
        }
        if (this.title != null) {
            this.iiq.setText(this.title);
        }
        if (this.vtt != null) {
            this.pqM.setHint(this.vtt);
        }
    }
}
