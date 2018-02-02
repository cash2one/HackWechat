package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e$a$a;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.model.u.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;

public class GameMessageListUserIconView extends LinearLayout {
    Context mContext;
    u ntd;
    private f<String, Bitmap> nte;

    public GameMessageListUserIconView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public GameMessageListUserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        if (this.ntd == null) {
            this.ntd = new u(this.mContext);
        }
    }

    public final void a(t tVar, LinkedList<h> linkedList, f<String, Bitmap> fVar) {
        if (tVar == null || bh.cA(linkedList)) {
            setVisibility(8);
            return;
        }
        this.nte = fVar;
        setVisibility(0);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bvr);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.f.buo);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.rightMargin = dimensionPixelSize2;
        while (getChildCount() < linkedList.size()) {
            View imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setOnClickListener(this.ntd);
            addView(imageView);
        }
        for (int i = 0; i < getChildCount(); i++) {
            ImageView imageView2 = (ImageView) getChildAt(i);
            if (i < linkedList.size()) {
                imageView2.setVisibility(0);
                h hVar = (h) linkedList.get(i);
                String str;
                Bitmap bitmap;
                if (bh.ov(hVar.ndh)) {
                    str = hVar.userName;
                    if (bh.ov(str)) {
                        b.a(imageView2, str);
                    } else if (this.nte.bt(str)) {
                        bitmap = (Bitmap) this.nte.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            d(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        d(imageView2, str);
                    }
                } else {
                    str = hVar.ndh;
                    if (this.nte.bt(str)) {
                        bitmap = (Bitmap) this.nte.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            f(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        f(imageView2, str);
                    }
                }
                if (bh.ov(hVar.ndk)) {
                    imageView2.setEnabled(false);
                } else {
                    imageView2.setTag(new a(tVar, hVar.ndk, 6));
                    imageView2.setEnabled(true);
                }
            } else {
                imageView2.setVisibility(8);
            }
        }
    }

    private void f(ImageView imageView, String str) {
        e$a$a com_tencent_mm_plugin_game_d_e_a_a = new e$a$a();
        com_tencent_mm_plugin_game_d_e_a_a.hDy = false;
        e.aRV().a(imageView, str, com_tencent_mm_plugin_game_d_e_a_a.aRW(), new 1(this, str));
    }

    private void d(ImageView imageView, String str) {
        Bitmap i = e.aRV().i(imageView, str);
        if (i != null) {
            this.nte.put(str, i);
        }
    }
}
