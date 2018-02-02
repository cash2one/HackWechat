package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.f;

public class VoiceSearchEditText extends EditText {
    private Context context;
    public String kbH = "";
    private OnClickListener tZZ;
    final Drawable yhG = getResources().getDrawable(f.gVf);
    final Drawable yhH = null;
    final Drawable yhI = getResources().getDrawable(f.gUW);
    private boolean yhJ = true;
    private boolean yhK = false;
    private boolean yhL = false;

    static /* synthetic */ void e(VoiceSearchEditText voiceSearchEditText) {
        x.d("MicroMsg.VoiceSearchEditText", "checkView");
        if (voiceSearchEditText.getText().toString().equals("") && voiceSearchEditText.yhK) {
            voiceSearchEditText.yhJ = true;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.yhH, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.yhG, voiceSearchEditText.getCompoundDrawables()[3]);
        } else if (voiceSearchEditText.getText().toString().length() > 0) {
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.yhH, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.yhI, voiceSearchEditText.getCompoundDrawables()[3]);
        } else {
            voiceSearchEditText.yhJ = false;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.yhH, voiceSearchEditText.getCompoundDrawables()[1], null, voiceSearchEditText.getCompoundDrawables()[3]);
        }
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.yhK = false;
        this.yhG.setBounds(0, 0, this.yhG.getIntrinsicWidth(), this.yhG.getIntrinsicHeight());
        this.yhI.setBounds(0, 0, this.yhI.getIntrinsicWidth(), this.yhI.getIntrinsicHeight());
        this.yhJ = true;
        if (this.yhK) {
            setCompoundDrawables(this.yhH, getCompoundDrawables()[1], this.yhG, getCompoundDrawables()[3]);
        } else if (getText().toString().length() > 0) {
            setCompoundDrawables(this.yhH, getCompoundDrawables()[1], this.yhI, getCompoundDrawables()[3]);
        } else {
            setCompoundDrawables(this.yhH, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        }
        setOnTouchListener(new 1(this));
        addTextChangedListener(new 2(this));
        setOnFocusChangeListener(new 3(this));
        if (context instanceof Activity) {
            View currentFocus = ((Activity) context).getCurrentFocus();
            if (currentFocus == null || currentFocus != this) {
                this.yhL = false;
            } else {
                this.yhL = true;
            }
        }
        requestFocus();
    }
}
