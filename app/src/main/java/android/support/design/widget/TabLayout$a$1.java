package android.support.design.widget;

import android.support.design.widget.TabLayout.a;
import android.support.design.widget.u.c;

class TabLayout$a$1 implements c {
    final /* synthetic */ int kD;
    final /* synthetic */ int kE;
    final /* synthetic */ int kF;
    final /* synthetic */ int kG;
    final /* synthetic */ a kH;

    TabLayout$a$1(a aVar, int i, int i2, int i3, int i4) {
        this.kH = aVar;
        this.kD = i;
        this.kE = i2;
        this.kF = i3;
        this.kG = i4;
    }

    public final void a(u uVar) {
        float animatedFraction = uVar.ls.getAnimatedFraction();
        a.a(this.kH, a.a(this.kD, this.kE, animatedFraction), a.a(this.kF, this.kG, animatedFraction));
    }
}
