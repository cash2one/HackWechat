package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.InputPreference.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference extends Preference {
    private Context context;
    private String rYa;
    String rYb;
    private OnClickListener rYc;
    OnClickListener rYd;
    private a rYe;
    private TextView rYf;
    private TextView rYg;
    private OnClickListener rYh;

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rYa = "";
        this.rYb = "";
        this.rYc = null;
        this.rYd = null;
        this.rYe = null;
        this.rYf = null;
        this.rYg = null;
        this.rYh = new 1(this);
        this.context = context;
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dnw, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), 0, viewGroup2.getPaddingBottom());
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        view.setOnTouchListener(new 2(this));
        this.rYf = (TextView) view.findViewById(R.h.cdj);
        this.rYg = (TextView) view.findViewById(R.h.cLD);
        this.rYg.setText(this.rYb);
        if (this.rYd != null) {
            this.rYg.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ AddFriendSearchPreference rYi;

                {
                    this.rYi = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        this.rYi.rYd.onClick(view);
                    }
                    return true;
                }
            });
        }
        if (this.rYe != null) {
            Button button = (Button) view.findViewById(R.h.button);
            button.setOnClickListener(this.rYh);
            button.setVisibility(0);
        }
    }
}
