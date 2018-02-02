package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.w.a.g;

public class InputPreference extends Preference {
    private String rYb;
    private a rYe;
    private OnClickListener rYh;
    private String yiN;
    private EditText yiO;
    private Button yiP;
    private OnEditorActionListener yiQ;

    public InputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rYh = new 1(this);
        this.yiQ = new 2(this);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.yiO = (EditText) view.findViewById(g.cdj);
        this.yiO.setHint(this.rYb);
        this.yiO.setOnEditorActionListener(this.yiQ);
        this.yiP = (Button) view.findViewById(g.button);
        this.yiP.setText(this.yiN);
        this.yiP.setOnClickListener(this.rYh);
    }
}
