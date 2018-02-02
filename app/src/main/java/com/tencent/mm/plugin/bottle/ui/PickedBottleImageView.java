package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public class PickedBottleImageView extends ImageView {
    float density;
    private af handler = new af();
    private Paint iYm = new Paint();
    String iconUrl;
    private int kAF;
    String kAQ;
    String kCR;
    Bitmap kDk;
    private Rect kDl = new Rect();
    private RectF kDm = new RectF();
    private View kDn;
    private Runnable kDo = new Runnable(this) {
        final /* synthetic */ PickedBottleImageView kDp;

        {
            this.kDp = r1;
        }

        public final void run() {
            FrameLayout frameLayout = (FrameLayout) this.kDp.getParent();
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.kDp.kDn.getLayoutParams();
            if (frameLayout != null) {
                marginLayoutParams.setMargins(frameLayout.getWidth() / 2, (frameLayout.getHeight() * 530) / 800, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            this.kDp.kDn.setLayoutParams(marginLayoutParams);
            this.kDp.kDn.setVisibility(0);
            this.kDp.clearAnimation();
        }
    };

    public PickedBottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PickedBottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void show(int i) {
        this.kAF = i;
        if (i == 1) {
            setImageResource(R.g.bzS);
            setContentDescription(getContext().getString(R.l.dMO));
            this.kDk = null;
        } else if (i == 3) {
            setImageResource(R.g.bzT);
            setContentDescription(getContext().getString(R.l.dMO));
            this.kDk = null;
        } else if (i == 19990) {
            setImageResource(R.g.bzE);
            this.kDk = m.d(this.kAQ, this.iconUrl, R.g.bEk);
            setContentDescription(getContext().getString(R.l.dMO));
            this.iYm.setAntiAlias(true);
            update();
        } else {
            setImageResource(R.g.bzR);
            this.kDk = null;
            setContentDescription(getContext().getString(R.l.dMP));
        }
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (this.kDn == null) {
            this.kDn = ((View) getParent()).findViewById(R.h.bOv);
        }
        this.kDn.setVisibility(8);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (frameLayout.getHeight() * 270) / 800);
        setLayoutParams(marginLayoutParams);
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.bpS));
        this.handler.postDelayed(this.kDo, 3000);
        setVisibility(0);
    }

    public void setVisibility(int i) {
        if (i == 8) {
            super.clearAnimation();
        }
        if (i == 8 && this.kDn != null) {
            this.handler.removeCallbacks(this.kDo);
            this.kDn.setVisibility(i);
        }
        super.setVisibility(i);
    }

    final void update() {
        boolean z = true;
        if (this.kDk == null || this.kDk.isRecycled()) {
            this.kDk = BitmapFactory.decodeResource(getResources(), R.g.bzZ);
        }
        Bitmap bitmap = this.kDk;
        Matrix matrix = new Matrix();
        matrix.setRotate(-60.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, matrix, paint);
        String str = "MicroMsg.PickedBottleImageView";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        x.d(str, stringBuilder.append(z).append("  degree:-60.0").toString());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        this.kDk = createBitmap;
        Rect rect = this.kDl;
        this.kDl.top = 0;
        rect.left = 0;
        this.kDl.right = this.kDk.getWidth();
        this.kDl.bottom = this.kDk.getHeight();
        this.kDm.left = 40.0f * this.density;
        this.kDm.top = 30.0f * this.density;
        this.kDm.right = 72.0f * this.density;
        this.kDm.bottom = 62.0f * this.density;
    }

    protected void onDraw(Canvas canvas) {
        if (!(19990 != this.kAF || this.kDk == null || this.kDk.isRecycled())) {
            canvas.drawBitmap(this.kDk, this.kDl, this.kDm, this.iYm);
        }
        super.onDraw(canvas);
    }
}
