package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.af.a;

final class r extends p {
    r() {
    }

    public final void eE() {
        af.Ws = new a(this) {
            final /* synthetic */ r QA;

            {
                this.QA = r1;
            }

            public final void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }
}
