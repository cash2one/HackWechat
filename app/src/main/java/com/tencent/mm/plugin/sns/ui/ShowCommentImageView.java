package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class ShowCommentImageView extends ImageView {
    private static Bitmap rwI;
    private static Bitmap rwJ;
    private static Field rwK;
    private static Field rwL;
    private static boolean rwM = false;
    private boolean rwH = false;

    public ShowCommentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ShowCommentImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private static void init() {
        if (rwK == null || rwL == null) {
            try {
                rwK = View.class.getDeclaredField("mDrawingCache");
                rwL = View.class.getDeclaredField("mUnscaledDrawingCache");
                rwK.setAccessible(true);
                rwL.setAccessible(true);
                rwM = true;
            } catch (Exception e) {
                x.e("MicroMsg.ShowCommentImageView", "init error: %s", new Object[]{e.getMessage()});
                rwM = false;
            }
        }
    }

    public void buildDrawingCache(boolean z) {
        if (rwM) {
            if (this.rwH) {
                A(z, true);
            } else if (iF(z)) {
                super.buildDrawingCache(z);
                return;
            } else {
                Bitmap bitmap = z ? rwJ : rwI;
                if (bitmap == null || bitmap.isRecycled()) {
                    Field field;
                    super.buildDrawingCache(z);
                    if (z) {
                        try {
                            field = rwK;
                        } catch (Exception e) {
                            x.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", new Object[]{e.getMessage()});
                            return;
                        }
                    }
                    field = rwL;
                    bitmap = (Bitmap) field.get(this);
                    String str = "MicroMsg.ShowCommentImageView";
                    String str2 = "getStaticDrawingCache, autoScale: %s, cache==null: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Boolean.valueOf(bitmap == null);
                    x.d(str, str2, objArr);
                    if (bitmap == null) {
                        return;
                    }
                    if (z) {
                        rwJ = bitmap;
                        return;
                    } else {
                        rwI = bitmap;
                        return;
                    }
                }
                A(z, false);
                return;
            }
        }
        super.buildDrawingCache(z);
    }

    private boolean iF(boolean z) {
        if (!rwM) {
            return false;
        }
        Field field;
        if (z) {
            try {
                field = rwK;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShowCommentImageView", e, "", new Object[0]);
                x.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", new Object[]{e.getMessage()});
                return false;
            }
        }
        field = rwL;
        return ((Bitmap) field.get(this)) != null;
    }

    private void A(boolean z, boolean z2) {
        if (z) {
            try {
                Field field = rwK;
            } catch (Exception e) {
                x.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        field = rwL;
        if (z2) {
            field.set(this, null);
            return;
        }
        boolean z3;
        if (z) {
            Object obj = rwJ;
        } else {
            Bitmap bitmap = rwI;
        }
        String str = "MicroMsg.ShowCommentImageView";
        String str2 = "setDrawingCache, autoScale: %s, cache==null: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        if (obj == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        objArr[1] = Boolean.valueOf(z3);
        x.d(str, str2, objArr);
        if (obj != null) {
            field.set(this, obj);
        }
    }

    protected void onDetachedFromWindow() {
        try {
            rwK.set(this, null);
            rwL.set(this, null);
        } catch (Exception e) {
            x.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[]{e.getMessage()});
        }
        super.onDetachedFromWindow();
    }

    public void destroyDrawingCache() {
        super.destroyDrawingCache();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(new 1(this, onClickListener));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            postDelayed(new 2(this), 100);
        } else {
            this.rwH = true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
