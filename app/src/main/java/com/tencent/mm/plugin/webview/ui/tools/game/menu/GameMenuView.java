package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;

public class GameMenuView extends LinearLayout {
    private LayoutInflater DF;
    private Context mContext;
    private boolean tGi = false;
    private View tGn;
    private LinearLayout tGo;
    private LinearLayout tGp;
    f tGq;
    c tGr;
    a tGs;

    static /* synthetic */ void a(GameMenuView gameMenuView) {
        int count = gameMenuView.tGq.getCount();
        if (count != 0) {
            View childAt;
            int eB = (gameMenuView.tGi ? com.tencent.mm.bv.a.eB(gameMenuView.mContext) : com.tencent.mm.bv.a.eA(gameMenuView.mContext)) - (com.tencent.mm.bv.a.ab(gameMenuView.mContext, R.f.bxz) * 2);
            int ab = com.tencent.mm.bv.a.ab(gameMenuView.mContext, R.f.bxy);
            int ab2 = com.tencent.mm.bv.a.ab(gameMenuView.mContext, R.f.bxx);
            f fVar = gameMenuView.tGq;
            Object obj = (fVar.rKE == null || fVar.rKE.size() == 0) ? null : (fVar.rKE.size() + 1) / 2 > 4 ? 1 : null;
            int i = obj != null ? gameMenuView.tGi ? (int) (((((double) eB) - (0.375d * ((double) ab2))) - ((double) (ab2 * 4))) / 9.0d) : (int) (((((double) eB) - (0.5d * ((double) ab))) - ((double) (ab * 4))) / 9.0d) : gameMenuView.tGi ? (int) (((double) (eB - (ab2 * 4))) / 8.0d) : (int) (((double) (eB - (ab * 4))) / 8.0d);
            LayoutParams layoutParams = gameMenuView.tGi ? i > 0 ? new LinearLayout.LayoutParams(ab2, (i * 2) + ab2) : new LinearLayout.LayoutParams(ab2, ab2) : i > 0 ? new LinearLayout.LayoutParams((i * 2) + ab, ab) : new LinearLayout.LayoutParams(ab, ab);
            for (eB = 0; eB < count; eB++) {
                View view = gameMenuView.tGq.getView(eB, null, gameMenuView.tGo);
                if (view != null) {
                    view.setOnClickListener(new 2(gameMenuView));
                    view.setLayoutParams(layoutParams);
                    if (eB % 2 == 0) {
                        gameMenuView.tGo.addView(view);
                    } else {
                        gameMenuView.tGp.addView(view);
                    }
                }
            }
            while (true) {
                i = gameMenuView.tGo.getChildCount();
                if (i <= 0) {
                    break;
                }
                childAt = gameMenuView.tGo.getChildAt(i - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.tGo.removeViewAt(i - 1);
            }
            while (true) {
                i = gameMenuView.tGp.getChildCount();
                if (i <= 0) {
                    break;
                }
                childAt = gameMenuView.tGp.getChildAt(i - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.tGp.removeViewAt(i - 1);
            }
            if (gameMenuView.tGo.getChildCount() == 0 && gameMenuView.tGp.getChildCount() == 0) {
                if (gameMenuView.tGs != null) {
                    gameMenuView.tGs.onDismiss();
                }
            } else if (gameMenuView.tGo.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.tGo.getParent()).setVisibility(8);
            } else if (gameMenuView.tGp.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.tGp.getParent()).setVisibility(8);
            }
        }
    }

    public GameMenuView(Context context) {
        boolean z = false;
        super(context, null);
        this.mContext = context;
        this.DF = LayoutInflater.from(this.mContext);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            z = true;
        }
        this.tGi = z;
        initView();
    }

    public GameMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View inflate;
        if (this.tGi) {
            setOrientation(0);
            this.DF.inflate(R.i.dkQ, this, true);
            inflate = this.DF.inflate(R.i.dkN, this, true);
        } else {
            setOrientation(1);
            this.DF.inflate(R.i.dkR, this, true);
            inflate = this.DF.inflate(R.i.dkO, this, true);
        }
        this.tGn = inflate.findViewById(R.h.cmK);
        this.tGo = (LinearLayout) inflate.findViewById(R.h.cmJ);
        this.tGp = (LinearLayout) inflate.findViewById(R.h.cmL);
    }
}
