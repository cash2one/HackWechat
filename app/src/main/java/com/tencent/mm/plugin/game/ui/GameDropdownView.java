package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.LinkedList;

public class GameDropdownView extends TextView implements OnClickListener, OnDismissListener {
    private Context mContext;
    private b npS;
    private LinkedList<String> npT;
    private int npU = 0;
    private int npV = 0;
    a npW = null;
    View npX = null;
    private OnClickListener npY = new 1(this);

    static /* synthetic */ void a(GameDropdownView gameDropdownView, int i) {
        if (gameDropdownView.npS.getContentView() != null && (gameDropdownView.npS.getContentView() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) gameDropdownView.npS.getContentView();
            if (i <= gameDropdownView.npV && gameDropdownView.npU <= gameDropdownView.npV && (viewGroup.getChildAt(i) instanceof TextView) && (viewGroup.getChildAt(gameDropdownView.npU) instanceof TextView)) {
                ((TextView) viewGroup.getChildAt(gameDropdownView.npU)).setTextColor(gameDropdownView.mContext.getResources().getColor(R.e.bsO));
                ((TextView) viewGroup.getChildAt(i)).setTextColor(gameDropdownView.mContext.getResources().getColor(R.e.btv));
                gameDropdownView.setText((CharSequence) gameDropdownView.npT.get(i));
                if (!(gameDropdownView.npW == null || gameDropdownView.npU == i)) {
                    gameDropdownView.npW.qV(i);
                }
                gameDropdownView.npU = i;
            }
        }
    }

    public GameDropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.npS = new b(context);
        setOnClickListener(this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setVisibility(8);
    }

    public void onClick(View view) {
        if (this.npS.isShowing()) {
            this.npS.dismiss();
        } else if (this.npX == null) {
            this.npS.showAsDropDown(this);
        } else {
            this.npS.showAsDropDown(this.npX);
        }
    }

    public void onDismiss() {
    }

    public final void c(LinkedList<String> linkedList, int i) {
        if (linkedList.size() != 0) {
            this.npT = linkedList;
            this.npV = linkedList.size() - 1;
            if (i < 0 || i > this.npV) {
                this.npU = 0;
            } else {
                this.npU = i;
            }
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.i.dkE, null);
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                String str = (String) linkedList.get(i2);
                TextView textView = (TextView) layoutInflater.inflate(R.i.dkF, linearLayout, false);
                textView.setText(str);
                textView.setOnClickListener(this.npY);
                if (i2 == this.npU) {
                    textView.setTextColor(this.mContext.getResources().getColor(R.e.btv));
                    setText(str);
                }
                linearLayout.addView(textView);
            }
            this.npS.setContentView(linearLayout);
            setVisibility(0);
        }
    }
}
