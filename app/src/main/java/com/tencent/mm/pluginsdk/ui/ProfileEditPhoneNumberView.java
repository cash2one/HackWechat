package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView extends ProfileItemView implements com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a {
    public String vkI;
    public String vkJ;
    public String[] vkK;
    private LinearLayout vkL;
    private boolean vkM = false;
    public a vkN;

    public interface a {
        void asi();

        void cap();
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int bjK() {
        return R.i.dpF;
    }

    public final void init() {
        this.vkL = (LinearLayout) findViewById(R.h.cuO);
    }

    public void clearFocus() {
        for (int i = 1; i < this.vkL.getChildCount(); i++) {
            this.vkL.getChildAt(i).clearFocus();
        }
    }

    public final boolean L(x xVar) {
        this.lFr = xVar;
        return true;
    }

    public final boolean bjL() {
        int i;
        int i2;
        if (bh.ov(this.vkI)) {
            i = 0;
            i2 = 0;
        } else {
            bb(this.vkI, true);
            i = 1;
            i2 = 1;
        }
        if (!bh.ov(this.vkJ)) {
            this.vkK = this.vkJ.split(",");
            while (i2 < this.vkK.length + i) {
                bb(this.vkK[i2 - i].trim(), false);
                i2++;
            }
        }
        if (i2 < 5) {
            bb(null, false);
            this.vkM = false;
        } else {
            this.vkM = true;
        }
        return false;
    }

    public final ArrayList<String> can() {
        int childCount = this.vkL.getChildCount();
        if (childCount == 1) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList(childCount - 1);
        for (int i = 1; i < childCount; i++) {
            String obj = ((MMPhoneNumberEditText) this.vkL.getChildAt(i)).getText().toString();
            if (!bh.ov(obj)) {
                arrayList.add(obj);
            }
        }
        if (!bh.ov(this.vkI)) {
            arrayList.remove(0);
        }
        return arrayList;
    }

    private void cao() {
        if (this.vkN != null) {
            this.vkN.asi();
        }
    }

    public final void f(MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (mMPhoneNumberEditText.vkp) {
            h.a(getContext(), R.l.eph, 0, R.l.epg, R.l.epf, new 1(this, mMPhoneNumberEditText), null);
            return;
        }
        h(mMPhoneNumberEditText);
        if (this.vkM) {
            bb(null, false);
            this.vkM = false;
        }
        cao();
    }

    public final void cai() {
        cao();
    }

    public final void cah() {
        if (this.vkL.getChildCount() - 1 < 5) {
            bb(null, false);
        } else {
            this.vkM = true;
        }
        cao();
    }

    public final void g(MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (this.vkL.getChildCount() - 1 != 1) {
            h(mMPhoneNumberEditText);
            if (this.vkM) {
                bb(null, false);
            }
            this.vkM = false;
            cao();
        }
    }

    private void bb(String str, boolean z) {
        MMPhoneNumberEditText mMPhoneNumberEditText = (MMPhoneNumberEditText) LayoutInflater.from(getContext()).inflate(R.i.dpE, null);
        mMPhoneNumberEditText.setHint(ac.getResources().getString(R.l.dCw));
        if (z) {
            mMPhoneNumberEditText.vkp = true;
            mMPhoneNumberEditText.vkn = mMPhoneNumberEditText.getResources().getDrawable(R.k.dyP);
            mMPhoneNumberEditText.vkn.setBounds(0, 0, mMPhoneNumberEditText.vkn.getIntrinsicWidth(), mMPhoneNumberEditText.vkn.getIntrinsicHeight());
            mMPhoneNumberEditText.setFocusable(false);
            mMPhoneNumberEditText.caf();
        }
        mMPhoneNumberEditText.vko = this;
        mMPhoneNumberEditText.setText(str);
        mMPhoneNumberEditText.setSelection(mMPhoneNumberEditText.getText().length());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, com.tencent.mm.bv.a.fromDPToPix(getContext(), 12), 0, 0);
        this.vkL.addView(mMPhoneNumberEditText, layoutParams);
    }

    private void h(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.vkL.removeView(mMPhoneNumberEditText);
        this.vkL.getChildAt(this.vkL.getChildCount() - 1).requestFocus();
    }
}
