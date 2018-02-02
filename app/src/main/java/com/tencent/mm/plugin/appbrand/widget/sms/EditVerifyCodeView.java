package com.tencent.mm.plugin.appbrand.widget.sms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.x;

public class EditVerifyCodeView extends RelativeLayout {
    private EditText kT;
    private ImageView[] kgn;
    private TextView[] kgo;
    OnKeyListener kgp;
    public StringBuilder mBuilder;
    private Context mContext;

    static /* synthetic */ void b(EditVerifyCodeView editVerifyCodeView) {
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        x.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length > 0 && length <= 6) {
            editVerifyCodeView.kgo[length - 1].setVisibility(0);
            editVerifyCodeView.kgo[length - 1].setText(String.valueOf(stringBuilder.charAt(length - 1)));
            editVerifyCodeView.kgn[length - 1].setVisibility(4);
        }
    }

    static /* synthetic */ void c(EditVerifyCodeView editVerifyCodeView) {
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        x.i("MicroMsg.EditVerifyCodeView", "del before str:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length != 0) {
            if (length > 0 && length <= 6) {
                editVerifyCodeView.mBuilder.delete(length - 1, length);
            }
            editVerifyCodeView.kgo[length - 1].setVisibility(4);
            editVerifyCodeView.kgo[length - 1].setText("");
            editVerifyCodeView.kgn[length - 1].setVisibility(0);
            x.i("MicroMsg.EditVerifyCodeView", "del after str:" + editVerifyCodeView.mBuilder);
        }
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBuilder = new StringBuilder();
        this.kgn = new ImageView[6];
        this.kgo = new TextView[6];
        this.kgp = new 3(this);
        init(context);
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBuilder = new StringBuilder();
        this.kgn = new ImageView[6];
        this.kgo = new TextView[6];
        this.kgp = new 3(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(h.ixJ, null);
        TextView textView = (TextView) inflate.findViewById(g.ivw);
        TextView textView2 = (TextView) inflate.findViewById(g.ivx);
        TextView textView3 = (TextView) inflate.findViewById(g.ivy);
        TextView textView4 = (TextView) inflate.findViewById(g.ivz);
        TextView textView5 = (TextView) inflate.findViewById(g.ivA);
        this.kgo[0] = (TextView) inflate.findViewById(g.ivv);
        this.kgo[1] = textView;
        this.kgo[2] = textView2;
        this.kgo[3] = textView3;
        this.kgo[4] = textView4;
        this.kgo[5] = textView5;
        ImageView imageView = (ImageView) inflate.findViewById(g.ivq);
        ImageView imageView2 = (ImageView) inflate.findViewById(g.ivr);
        ImageView imageView3 = (ImageView) inflate.findViewById(g.ivs);
        ImageView imageView4 = (ImageView) inflate.findViewById(g.ivt);
        ImageView imageView5 = (ImageView) inflate.findViewById(g.ivu);
        this.kgn[0] = (ImageView) inflate.findViewById(g.ivp);
        this.kgn[1] = imageView;
        this.kgn[2] = imageView2;
        this.kgn[3] = imageView3;
        this.kgn[4] = imageView4;
        this.kgn[5] = imageView5;
        this.kT = (EditText) inflate.findViewById(g.iwD);
        this.kT.addTextChangedListener(new 1(this));
        this.kT.setKeyListener(new 2(this));
        this.kT.setOnKeyListener(this.kgp);
        addView(inflate, new LayoutParams(-1, -1));
    }

    public final void setText(String str) {
        this.mBuilder.delete(0, this.mBuilder.length());
        this.mBuilder.append(str);
        String stringBuilder = this.mBuilder.toString();
        int length = stringBuilder.length();
        x.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
        int i;
        if (length > 0) {
            for (i = 0; i < length; i++) {
                this.kgo[i].setVisibility(0);
                this.kgo[i].setText(String.valueOf(stringBuilder.charAt(i)));
                this.kgn[i].setVisibility(4);
            }
            return;
        }
        for (i = 0; i < 6; i++) {
            this.kgo[i].setVisibility(4);
            this.kgo[i].setText("");
            this.kgn[i].setVisibility(0);
        }
    }
}
