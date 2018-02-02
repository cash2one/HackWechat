package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.f;

public final class a implements f {
    private final a Fo;
    private boolean Fp;
    private final int Fq;
    private final int Fr;

    public interface a {
        void az(int i);
    }

    public final void w(float f) {
        Math.min(1.0f, Math.max(0.0f, f));
    }

    public final void cr() {
        if (this.Fp) {
            az(this.Fr);
        }
    }

    public final void cs() {
        if (this.Fp) {
            az(this.Fq);
        }
    }

    private void az(int i) {
        this.Fo.az(i);
    }
}
