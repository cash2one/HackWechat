package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.a.c.g;
import com.tencent.mm.aq.a.d.b;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class m {
    public static String wW(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.CardViewUtil", "toApply is null");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            if ((i + 1) % 4 == 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void a(ImageView imageView, String str, int i, int i2, boolean z) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                imageView.setImageResource(i2);
                return;
            }
            a aVar = new a();
            aVar.hDD = e.bnF;
            o.PB();
            aVar.hDW = null;
            aVar.hDC = com.tencent.mm.plugin.card.model.m.wk(str);
            aVar.hDA = true;
            aVar.hDY = z;
            aVar.hDy = true;
            aVar.hDH = i;
            aVar.hDG = i;
            aVar.hDP = i2;
            o.PA().a(str, imageView, aVar.PK());
        }
    }

    public static void a(final Context context, final ImageView imageView, String str, int i, final int i2, final int i3) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                a(imageView, i2, i3);
                return;
            }
            a aVar = new a();
            aVar.hDD = e.bnF;
            o.PB();
            aVar.hDW = null;
            aVar.hDC = com.tencent.mm.plugin.card.model.m.wk(str);
            aVar.hDA = true;
            aVar.hDY = false;
            aVar.hDy = true;
            aVar.hDH = i;
            aVar.hDG = i;
            aVar.hDP = i2;
            o.PA().a(str, imageView, aVar.PK(), new g() {
                public final void lC(String str) {
                }

                public final Bitmap a(String str, b bVar) {
                    return null;
                }

                public final void a(String str, View view, b bVar) {
                    if (bVar.bitmap != null) {
                        ag.y(new 1(this, bVar.bitmap));
                    } else {
                        m.a(imageView, i2, i3);
                    }
                }
            });
        }
    }

    public static void a(ImageView imageView, int i, int i2) {
        ag.y(new 2(imageView, i, i2));
    }

    public static void a(MMActivity mMActivity, com.tencent.mm.plugin.card.base.b bVar) {
        a(mMActivity, l.wO(bVar.atB().hbM));
    }

    public static void a(MMActivity mMActivity, int i) {
        mMActivity.getSupportActionBar().setBackgroundDrawable(null);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setColor(i);
        mMActivity.getSupportActionBar().setBackgroundDrawable(shapeDrawable);
        View customView = mMActivity.getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(mMActivity.getResources().getColor(R.e.bsL));
            }
            findViewById = customView.findViewById(R.h.bIW);
            if (findViewById != null) {
                ((ImageView) findViewById).setImageResource(R.g.byy);
            }
            findViewById = customView.findViewById(16908308);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.white));
            }
            findViewById = customView.findViewById(16908309);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.white));
            }
            customView.setBackgroundDrawable(shapeDrawable);
        }
    }

    public static void b(MMActivity mMActivity, boolean z) {
        int color = mMActivity.getResources().getColor(R.e.white);
        mMActivity.getSupportActionBar().setBackgroundDrawable(null);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setColor(color);
        mMActivity.getSupportActionBar().setBackgroundDrawable(shapeDrawable);
        View customView = mMActivity.getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null) {
                if (z) {
                    findViewById.setBackgroundColor(mMActivity.getResources().getColor(R.e.bsK));
                } else {
                    findViewById.setVisibility(8);
                }
            }
            findViewById = customView.findViewById(R.h.bIW);
            if (findViewById != null) {
                ((ImageView) findViewById).setImageResource(R.g.bAk);
            }
            findViewById = customView.findViewById(16908308);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.black));
            }
            findViewById = customView.findViewById(16908309);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.black));
            }
            customView.setBackgroundDrawable(shapeDrawable);
        }
    }

    public static void b(TextView textView, int i) {
        switch (i) {
            case 0:
                textView.setText(R.l.dPC);
                return;
            case 1:
                textView.setText(R.l.dPx);
                return;
            case 2:
                textView.setText(R.l.dPA);
                return;
            case 3:
                textView.setText(R.l.dPz);
                return;
            case 4:
                textView.setText(R.l.dPD);
                return;
            case 5:
                textView.setText(R.l.dPE);
                return;
            case 6:
                textView.setText(R.l.dPy);
                return;
            case 7:
                textView.setText(R.l.dPB);
                return;
            default:
                return;
        }
    }
}
