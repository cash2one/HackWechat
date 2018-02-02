package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class WebViewSearchContentInputFooter extends LinearLayout {
    private View tKK;
    private EditText tKL;
    private View tKM;
    private View tKN;
    private View tKO;
    private TextView tKP;
    public a tKQ;

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = inflate(getContext(), R.i.due, this);
        this.tKL = (EditText) inflate.findViewById(R.h.cdj);
        this.tKM = inflate.findViewById(R.h.bWk);
        this.tKN = inflate.findViewById(R.h.cDk);
        this.tKO = inflate.findViewById(R.h.cAh);
        this.tKP = (TextView) inflate.findViewById(R.h.cpK);
        this.tKK = inflate.findViewById(R.h.cpR);
        this.tKM.setOnClickListener(new 1(this));
        this.tKN.setOnClickListener(new 2(this));
        this.tKO.setOnClickListener(new 3(this));
        this.tKL.setOnKeyListener(new 4(this));
        this.tKL.setOnFocusChangeListener(new 5(this));
        this.tKL.addTextChangedListener(new 6(this));
        this.tKL.setSelectAllOnFocus(true);
        reset();
    }

    public final void reset() {
        this.tKP.setText("");
        this.tKN.setEnabled(false);
        this.tKO.setEnabled(false);
    }

    public final void bUR() {
        this.tKL.setText("");
    }

    public boolean isShown() {
        return getVisibility() == 0;
    }

    public final void show() {
        setVisibility(0);
        if (this.tKQ != null) {
            this.tKQ.onShow();
        }
        this.tKL.requestFocus();
        postDelayed(new 7(this), 100);
    }

    public final void hide() {
        Context context = this.tKL.getContext();
        if (context instanceof MMActivity) {
            ((MMActivity) context).df(this.tKL);
        }
        this.tKL.clearFocus();
        setVisibility(8);
        if (this.tKQ != null) {
            this.tKQ.aPu();
        }
    }

    public final void o(int i, int i2, boolean z) {
        boolean z2 = true;
        if (z) {
            boolean z3;
            TextView textView = this.tKP;
            String str = "%d/%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i2 == 0 ? 0 : i + 1);
            objArr[1] = Integer.valueOf(i2);
            textView.setText(String.format(str, objArr));
            View view = this.tKO;
            if (i2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            view.setEnabled(z3);
            View view2 = this.tKN;
            if (i2 <= 0) {
                z2 = false;
            }
            view2.setEnabled(z2);
        }
    }

    public final String bUS() {
        return this.tKL.getText().toString();
    }
}
