package com.tencent.magicbrush.handler.a;

import android.graphics.Rect;
import com.tencent.magicbrush.handler.a.d.a;
import com.tencent.magicbrush.handler.a.d.b;
import com.tencent.magicbrush.handler.a.d.c;
import java.util.ArrayList;
import java.util.Iterator;

final class l implements d {
    private ArrayList<b> boA = new ArrayList();
    private a boB = new a();
    private int boC;
    private c boD = new c();
    private int mHeight;
    private int mWidth;

    l() {
    }

    public final void init(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        reset();
    }

    public final void a(int i, int i2, Rect rect) {
        if (rect != null) {
            if (i <= 0 || i2 <= 0) {
                rect.setEmpty();
                return;
            }
            b bVar;
            int i3;
            c cVar;
            c cVar2 = this.boD;
            cVar2.x = 0;
            cVar2.y = 0;
            cVar2.width = i;
            cVar2.height = i2;
            int i4 = Integer.MAX_VALUE;
            int i5 = -1;
            int i6 = 0;
            int i7 = Integer.MAX_VALUE;
            while (i6 < this.boA.size()) {
                int i8;
                int i9;
                bVar = (b) this.boA.get(i6);
                if (bVar.x + i > this.mWidth - 1) {
                    i8 = -1;
                } else {
                    i3 = bVar.y;
                    i8 = i6;
                    int i10 = i;
                    while (i10 > 0) {
                        bVar = (b) this.boA.get(i8);
                        if (bVar.y > i3) {
                            i3 = bVar.y;
                        }
                        if (i3 + i2 > this.mHeight - 1) {
                            i8 = -1;
                            break;
                        } else {
                            i10 -= bVar.z;
                            i8++;
                        }
                    }
                    i8 = i3;
                }
                if (i8 >= 0) {
                    bVar = (b) this.boA.get(i6);
                    if (i8 + i2 < i7 || (i8 + i2 == i7 && bVar.z > 0 && bVar.z < i4)) {
                        i4 = i8 + i2;
                        i3 = bVar.z;
                        cVar2.x = bVar.x;
                        cVar2.y = i8;
                        i9 = i3;
                        i3 = i4;
                        i4 = i6;
                        i6++;
                        i7 = i3;
                        i5 = i4;
                        i4 = i9;
                    }
                }
                i9 = i4;
                i3 = i7;
                i4 = i5;
                i6++;
                i7 = i3;
                i5 = i4;
                i4 = i9;
            }
            if (i5 == -1) {
                cVar2.x = -1;
                cVar2.y = -1;
                cVar2.width = 0;
                cVar2.height = 0;
                cVar = cVar2;
            } else {
                b bVar2;
                bVar = this.boB.sD();
                bVar.x = cVar2.x;
                bVar.y = cVar2.y + i2;
                bVar.z = i;
                this.boA.add(i5, bVar);
                for (i4 = i5 + 1; i4 < this.boA.size(); i4 = (i4 - 1) + 1) {
                    bVar = (b) this.boA.get(i4);
                    bVar2 = (b) this.boA.get(i4 - 1);
                    if (bVar.x >= bVar2.x + bVar2.z) {
                        break;
                    }
                    i3 = (bVar2.z + bVar2.x) - bVar.x;
                    bVar.x += i3;
                    bVar.z -= i3;
                    if (bVar.z > 0) {
                        break;
                    }
                    this.boB.a((b) this.boA.remove(i4));
                }
                i4 = 0;
                while (i4 < this.boA.size() - 1) {
                    bVar = (b) this.boA.get(i4);
                    bVar2 = (b) this.boA.get(i4 + 1);
                    if (bVar.y == bVar2.y) {
                        bVar.z = bVar2.z + bVar.z;
                        this.boB.a((b) this.boA.remove(i4 + 1));
                        i4--;
                    }
                    i4++;
                }
                this.boC += i * i2;
                cVar = cVar2;
            }
            if (cVar.x < 0 || cVar.y < 0) {
                rect.setEmpty();
            } else {
                rect.set(cVar.x, cVar.y, (cVar.x + i) - 1, (cVar.y + i2) - 1);
            }
        }
    }

    public final void reset() {
        this.boC = 0;
        a aVar = this.boB;
        ArrayList arrayList = this.boA;
        if (!(arrayList == null || arrayList.isEmpty())) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.bnH.offer((b) it.next());
            }
            arrayList.clear();
        }
        b sD = this.boB.sD();
        int i = this.mWidth - 2;
        sD.x = 1;
        sD.y = 1;
        sD.z = i;
        this.boA.add(sD);
    }
}
