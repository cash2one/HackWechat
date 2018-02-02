package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendItemPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private String qhm;
    private int qhn;
    int qho;

    public AddFriendItemPreference(Context context) {
        this(context, null);
    }

    public AddFriendItemPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddFriendItemPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qhm = "";
        this.qhn = -1;
        this.qho = 8;
        this.height = -1;
        this.context = context;
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dnv, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), viewGroup2.getPaddingRight(), viewGroup2.getPaddingBottom());
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.h.cpk);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.jY != null) {
                imageView.setImageDrawable(this.jY);
                imageView.setVisibility(0);
            } else if (this.Kw != 0) {
                imageView.setImageResource(this.Kw);
                imageView.setVisibility(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.cwo);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(R.h.cQE);
        if (textView != null) {
            textView.setVisibility(this.qho);
            textView.setText(this.qhm);
            if (this.qhn != -1) {
                textView.setBackgroundDrawable(a.b(this.context, this.qhn));
            }
        }
    }
}
