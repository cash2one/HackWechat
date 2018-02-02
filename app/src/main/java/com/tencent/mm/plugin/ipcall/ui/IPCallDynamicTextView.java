package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.af;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView extends TextView {
    private af mHandler = new 1(this);
    private int mHeight;
    private String mValue;
    private double nJL;
    private double nJM;
    private double nJN;
    private boolean nJO;
    private int nJP = 4000;
    private int nJQ = 50;
    DecimalFormat nJR = new DecimalFormat("0.00");
    private String nJS = "";
    private String nJT = "";

    static /* synthetic */ void a(IPCallDynamicTextView iPCallDynamicTextView, double d) {
        if (d == iPCallDynamicTextView.nJN) {
            iPCallDynamicTextView.setText(iPCallDynamicTextView.mValue);
        } else {
            iPCallDynamicTextView.setText(iPCallDynamicTextView.nJS + iPCallDynamicTextView.nJR.format(d) + iPCallDynamicTextView.nJT);
        }
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        getViewTreeObserver().addOnGlobalLayoutListener(new 2(this));
    }

    public final void setValue(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            setText(str2);
            return;
        }
        try {
            this.nJM = Double.parseDouble(CS(str));
            this.nJS = "";
            int i = 0;
            while (i < str2.length() && !Character.isDigit(str2.charAt(i))) {
                this.nJS += str2.charAt(i);
                i++;
            }
            this.nJT = "";
            i = str2.length() - 1;
            while (i > 0 && !Character.isDigit(str2.charAt(i))) {
                this.nJT += str2.charAt(i);
                i--;
            }
            try {
                this.nJN = Double.parseDouble(str2.substring(this.nJS.length(), str2.length() - this.nJT.length()));
                this.mValue = str2;
                this.nJL = (this.nJN - this.nJM) / ((double) (this.nJP / this.nJQ));
                if (this.nJL == 0.0d) {
                    setText(str2);
                    return;
                }
                this.nJL = new BigDecimal(this.nJL).setScale(2, 4).doubleValue();
                if (isShown()) {
                    this.mHandler.sendEmptyMessage(1);
                }
            } catch (NumberFormatException e) {
                setText(str2);
            }
        } catch (NumberFormatException e2) {
            setText(str2);
        }
    }

    public static String CS(String str) {
        String str2 = "";
        int i = 0;
        while (i < str.length() && !Character.isDigit(str.charAt(i))) {
            str2 = str2 + str.charAt(i);
            i++;
        }
        String str3 = "";
        i = str.length() - 1;
        while (i > 0 && !Character.isDigit(str.charAt(i))) {
            str3 = str3 + str.charAt(i);
            i--;
        }
        return str.substring(str2.length(), str.length() - str3.length());
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mHeight = getMeasuredHeight();
    }
}
