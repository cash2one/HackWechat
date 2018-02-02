package com.tencent.mm.ui.i;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;

@SuppressLint({"SetJavaScriptEnabled"})
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class b extends Dialog {
    static final float[] zcb = new float[]{20.0f, 60.0f};
    static final float[] zcc = new float[]{40.0f, 60.0f};
    static final LayoutParams zcd = new LayoutParams(-1, -1);
    private MMWebView juE;
    private String mUrl;
    private ProgressDialog zcf;
    private ImageView zcg;
    private FrameLayout zch;
    private a zqi;

    public b(Context context, String str, a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.zqi = aVar;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zcf = new ProgressDialog(getContext());
        this.zcf.requestWindowFeature(1);
        this.zcf.setMessage(getContext().getString(h.eRz));
        requestWindowFeature(1);
        this.zch = new FrameLayout(getContext());
        this.zcg = new ImageView(getContext());
        this.zcg.setOnClickListener(new 1(this));
        this.zcg.setImageDrawable(getContext().getResources().getDrawable(d.lnL));
        this.zcg.setVisibility(4);
        int intrinsicWidth = this.zcg.getDrawable().getIntrinsicWidth() / 2;
        View linearLayout = new LinearLayout(getContext());
        this.juE = a.cn(getContext());
        this.juE.setVerticalScrollBarEnabled(false);
        this.juE.setHorizontalScrollBarEnabled(false);
        this.juE.setWebViewClient(new b(this, (byte) 0));
        this.juE.getSettings().setJavaScriptEnabled(true);
        this.juE.loadUrl(this.mUrl);
        this.juE.setLayoutParams(zcd);
        this.juE.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.juE);
        this.zch.addView(linearLayout);
        this.zch.addView(this.zcg, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.zch, new ViewGroup.LayoutParams(-1, -1));
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.zqi.onCancel();
        dismiss();
        return true;
    }
}
