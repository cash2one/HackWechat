package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

class b$a extends OvalShape {
    private RadialGradient Bm;
    private Paint Bn = new Paint();
    private int Bo;
    final /* synthetic */ b Bp;

    public b$a(b bVar, int i, int i2) {
        this.Bp = bVar;
        b.a(bVar, i);
        this.Bo = i2;
        this.Bm = new RadialGradient((float) (this.Bo / 2), (float) (this.Bo / 2), (float) b.a(bVar), new int[]{1023410176, 0}, null, TileMode.CLAMP);
        this.Bn.setShader(this.Bm);
    }

    public final void draw(Canvas canvas, Paint paint) {
        int width = this.Bp.getWidth();
        int height = this.Bp.getHeight();
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.Bo / 2) + b.a(this.Bp)), this.Bn);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.Bo / 2), paint);
    }
}
