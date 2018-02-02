package android.support.v7.widget.a;

import android.graphics.Rect;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$h;
import android.support.v7.widget.a.a.a;

class a$1 implements Runnable {
    final /* synthetic */ a aaZ;

    a$1(a aVar) {
        this.aaZ = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        Object obj = null;
        if (this.aaZ.aaD != null) {
            a aVar = this.aaZ;
            if (aVar.aaD != null) {
                int paddingLeft;
                int i;
                int paddingTop;
                a aVar2;
                RecyclerView recyclerView;
                int width;
                int a;
                long currentTimeMillis = System.currentTimeMillis();
                long j = aVar.aaY == Long.MIN_VALUE ? 0 : currentTimeMillis - aVar.aaY;
                RecyclerView$h recyclerView$h = aVar.Va.TV;
                if (aVar.gO == null) {
                    aVar.gO = new Rect();
                }
                recyclerView$h.a(aVar.aaD.VU, aVar.gO);
                if (recyclerView$h.eQ()) {
                    int i2 = (int) (aVar.aaK + aVar.aaI);
                    paddingLeft = (i2 - aVar.gO.left) - aVar.Va.getPaddingLeft();
                    if (aVar.aaI >= 0.0f || paddingLeft >= 0) {
                        if (aVar.aaI > 0.0f) {
                            paddingLeft = ((i2 + aVar.aaD.VU.getWidth()) + aVar.gO.right) - (aVar.Va.getWidth() - aVar.Va.getPaddingRight());
                        }
                    }
                    if (recyclerView$h.eR()) {
                        i = (int) (aVar.aaL + aVar.aaJ);
                        paddingTop = (i - aVar.gO.top) - aVar.Va.getPaddingTop();
                        if (aVar.aaJ >= 0.0f || paddingTop >= 0) {
                            if (aVar.aaJ > 0.0f) {
                                paddingTop = ((i + aVar.aaD.VU.getHeight()) + aVar.gO.bottom) - (aVar.Va.getHeight() - aVar.Va.getPaddingBottom());
                            }
                        }
                        if (paddingLeft != 0) {
                            aVar2 = aVar.aaM;
                            recyclerView = aVar.Va;
                            width = aVar.aaD.VU.getWidth();
                            aVar.Va.getWidth();
                            a = aVar2.a(recyclerView, width, paddingLeft, j);
                        } else {
                            a = paddingLeft;
                        }
                        if (paddingTop != 0) {
                            aVar2 = aVar.aaM;
                            recyclerView = aVar.Va;
                            width = aVar.aaD.VU.getHeight();
                            aVar.Va.getHeight();
                            i = aVar2.a(recyclerView, width, paddingTop, j);
                        } else {
                            i = paddingTop;
                        }
                        if (!(a == 0 && i == 0)) {
                            if (aVar.aaY == Long.MIN_VALUE) {
                                aVar.aaY = currentTimeMillis;
                            }
                            aVar.Va.scrollBy(a, i);
                            obj = 1;
                            if (obj == null) {
                                if (this.aaZ.aaD != null) {
                                    a.a(this.aaZ, this.aaZ.aaD);
                                }
                                this.aaZ.Va.removeCallbacks(this.aaZ.aaR);
                                z.a(this.aaZ.Va, this);
                            }
                        }
                    }
                    paddingTop = 0;
                    if (paddingLeft != 0) {
                        a = paddingLeft;
                    } else {
                        aVar2 = aVar.aaM;
                        recyclerView = aVar.Va;
                        width = aVar.aaD.VU.getWidth();
                        aVar.Va.getWidth();
                        a = aVar2.a(recyclerView, width, paddingLeft, j);
                    }
                    if (paddingTop != 0) {
                        i = paddingTop;
                    } else {
                        aVar2 = aVar.aaM;
                        recyclerView = aVar.Va;
                        width = aVar.aaD.VU.getHeight();
                        aVar.Va.getHeight();
                        i = aVar2.a(recyclerView, width, paddingTop, j);
                    }
                    if (aVar.aaY == Long.MIN_VALUE) {
                        aVar.aaY = currentTimeMillis;
                    }
                    aVar.Va.scrollBy(a, i);
                    obj = 1;
                    if (obj == null) {
                        if (this.aaZ.aaD != null) {
                            a.a(this.aaZ, this.aaZ.aaD);
                        }
                        this.aaZ.Va.removeCallbacks(this.aaZ.aaR);
                        z.a(this.aaZ.Va, this);
                    }
                }
                paddingLeft = 0;
                if (recyclerView$h.eR()) {
                    i = (int) (aVar.aaL + aVar.aaJ);
                    paddingTop = (i - aVar.gO.top) - aVar.Va.getPaddingTop();
                    if (aVar.aaJ > 0.0f) {
                        paddingTop = ((i + aVar.aaD.VU.getHeight()) + aVar.gO.bottom) - (aVar.Va.getHeight() - aVar.Va.getPaddingBottom());
                    }
                }
                paddingTop = 0;
                if (paddingLeft != 0) {
                    aVar2 = aVar.aaM;
                    recyclerView = aVar.Va;
                    width = aVar.aaD.VU.getWidth();
                    aVar.Va.getWidth();
                    a = aVar2.a(recyclerView, width, paddingLeft, j);
                } else {
                    a = paddingLeft;
                }
                if (paddingTop != 0) {
                    aVar2 = aVar.aaM;
                    recyclerView = aVar.Va;
                    width = aVar.aaD.VU.getHeight();
                    aVar.Va.getHeight();
                    i = aVar2.a(recyclerView, width, paddingTop, j);
                } else {
                    i = paddingTop;
                }
                if (aVar.aaY == Long.MIN_VALUE) {
                    aVar.aaY = currentTimeMillis;
                }
                aVar.Va.scrollBy(a, i);
                obj = 1;
                if (obj == null) {
                    if (this.aaZ.aaD != null) {
                        a.a(this.aaZ, this.aaZ.aaD);
                    }
                    this.aaZ.Va.removeCallbacks(this.aaZ.aaR);
                    z.a(this.aaZ.Va, this);
                }
            }
            aVar.aaY = Long.MIN_VALUE;
            if (obj == null) {
                if (this.aaZ.aaD != null) {
                    a.a(this.aaZ, this.aaZ.aaD);
                }
                this.aaZ.Va.removeCallbacks(this.aaZ.aaR);
                z.a(this.aaZ.Va, this);
            }
        }
    }
}
