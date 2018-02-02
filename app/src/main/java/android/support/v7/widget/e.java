package android.support.v7.widget;

import android.support.v4.e.i.a;
import android.support.v4.e.i.b;
import java.util.ArrayList;
import java.util.List;

final class e implements aa$a {
    private a<b> OR;
    final ArrayList<b> OS;
    final ArrayList<b> OT;
    final a OU;
    Runnable OV;
    final boolean OW;
    final aa OX;
    int OY;

    e(a aVar) {
        this(aVar, (byte) 0);
    }

    private e(a aVar, byte b) {
        this.OR = new b(30);
        this.OS = new ArrayList();
        this.OT = new ArrayList();
        this.OY = 0;
        this.OU = aVar;
        this.OW = false;
        this.OX = new aa(this);
    }

    final void reset() {
        g(this.OS);
        g(this.OT);
        this.OY = 0;
    }

    final void er() {
        aa aaVar = this.OX;
        List list = this.OS;
        while (true) {
            int i;
            Object obj;
            Object obj2;
            int size;
            Object obj3 = null;
            int size2 = list.size() - 1;
            while (size2 >= 0) {
                Object obj4;
                int i2;
                b bVar;
                b bVar2;
                b bVar3;
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                if (((b) list.get(size2)).pK != 8) {
                    obj4 = 1;
                } else if (obj3 != null) {
                    i = size2;
                    if (i != -1) {
                        i2 = i + 1;
                        bVar = (b) list.get(i);
                        bVar2 = (b) list.get(i2);
                        switch (bVar2.pK) {
                            case 1:
                                size2 = 0;
                                if (bVar.Pb < bVar2.OZ) {
                                    size2 = -1;
                                }
                                if (bVar.OZ < bVar2.OZ) {
                                    size2++;
                                }
                                if (bVar2.OZ <= bVar.OZ) {
                                    bVar.OZ += bVar2.Pb;
                                }
                                if (bVar2.OZ <= bVar.Pb) {
                                    bVar.Pb += bVar2.Pb;
                                }
                                bVar2.OZ = size2 + bVar2.OZ;
                                list.set(i, bVar2);
                                list.set(i2, bVar);
                                break;
                            case 2:
                                bVar3 = null;
                                obj = null;
                                if (bVar.OZ < bVar.Pb) {
                                    obj2 = null;
                                    if (bVar2.OZ == bVar.OZ && bVar2.Pb == bVar.Pb - bVar.OZ) {
                                        obj = 1;
                                    }
                                } else {
                                    obj2 = 1;
                                    if (bVar2.OZ == bVar.Pb + 1 && bVar2.Pb == bVar.OZ - bVar.Pb) {
                                        obj = 1;
                                    }
                                }
                                if (bVar.Pb < bVar2.OZ) {
                                    if (bVar.Pb < bVar2.OZ + bVar2.Pb) {
                                        bVar2.Pb--;
                                        bVar.pK = 2;
                                        bVar.Pb = 1;
                                        if (bVar2.Pb != 0) {
                                            break;
                                        }
                                        list.remove(i2);
                                        aaVar.TF.c(bVar2);
                                        break;
                                    }
                                }
                                bVar2.OZ--;
                                if (bVar.OZ <= bVar2.OZ) {
                                    bVar2.OZ++;
                                } else if (bVar.OZ < bVar2.OZ + bVar2.Pb) {
                                    bVar3 = aaVar.TF.a(2, bVar.OZ + 1, (bVar2.OZ + bVar2.Pb) - bVar.OZ, null);
                                    bVar2.Pb = bVar.OZ - bVar2.OZ;
                                }
                                if (obj == null) {
                                    if (obj2 == null) {
                                        if (bVar3 != null) {
                                            if (bVar.OZ > bVar3.OZ) {
                                                bVar.OZ -= bVar3.Pb;
                                            }
                                            if (bVar.Pb > bVar3.OZ) {
                                                bVar.Pb -= bVar3.Pb;
                                            }
                                        }
                                        if (bVar.OZ > bVar2.OZ) {
                                            bVar.OZ -= bVar2.Pb;
                                        }
                                        if (bVar.Pb > bVar2.OZ) {
                                            bVar.Pb -= bVar2.Pb;
                                        }
                                    } else {
                                        if (bVar3 != null) {
                                            if (bVar.OZ >= bVar3.OZ) {
                                                bVar.OZ -= bVar3.Pb;
                                            }
                                            if (bVar.Pb >= bVar3.OZ) {
                                                bVar.Pb -= bVar3.Pb;
                                            }
                                        }
                                        if (bVar.OZ >= bVar2.OZ) {
                                            bVar.OZ -= bVar2.Pb;
                                        }
                                        if (bVar.Pb >= bVar2.OZ) {
                                            bVar.Pb -= bVar2.Pb;
                                        }
                                    }
                                    list.set(i, bVar2);
                                    if (bVar.OZ == bVar.Pb) {
                                        list.set(i2, bVar);
                                    } else {
                                        list.remove(i2);
                                    }
                                    if (bVar3 == null) {
                                        break;
                                    }
                                    list.add(i, bVar3);
                                    break;
                                }
                                list.set(i, bVar2);
                                list.remove(i2);
                                aaVar.TF.c(bVar);
                                break;
                            case 4:
                                obj2 = null;
                                obj = null;
                                if (bVar.Pb < bVar2.OZ) {
                                    bVar2.OZ--;
                                } else if (bVar.Pb < bVar2.OZ + bVar2.Pb) {
                                    bVar2.Pb--;
                                    obj2 = aaVar.TF.a(4, bVar.OZ, 1, bVar2.Pa);
                                }
                                if (bVar.OZ <= bVar2.OZ) {
                                    bVar2.OZ++;
                                } else if (bVar.OZ < bVar2.OZ + bVar2.Pb) {
                                    i3 = (bVar2.OZ + bVar2.Pb) - bVar.OZ;
                                    obj = aaVar.TF.a(4, bVar.OZ + 1, i3, bVar2.Pa);
                                    bVar2.Pb -= i3;
                                }
                                list.set(i2, bVar);
                                if (bVar2.Pb <= 0) {
                                    list.set(i, bVar2);
                                } else {
                                    list.remove(i);
                                    aaVar.TF.c(bVar2);
                                }
                                if (obj2 != null) {
                                    list.add(i, obj2);
                                }
                                if (obj == null) {
                                    break;
                                }
                                list.add(i, obj);
                                break;
                            default:
                                break;
                        }
                    }
                    size = this.OS.size();
                    for (i = 0; i < size; i++) {
                        bVar = (b) this.OS.get(i);
                        switch (bVar.pK) {
                            case 1:
                                b(bVar);
                                break;
                            case 2:
                                i2 = bVar.OZ;
                                i4 = bVar.Pb + bVar.OZ;
                                i3 = -1;
                                size2 = bVar.OZ;
                                i5 = 0;
                                while (size2 < i4) {
                                    obj3 = null;
                                    if (this.OU.aQ(size2) == null || aN(size2)) {
                                        if (i3 == 0) {
                                            a(a(2, i2, i5, null));
                                            obj3 = 1;
                                        }
                                        i3 = 1;
                                    } else {
                                        if (i3 == 1) {
                                            b(a(2, i2, i5, null));
                                            obj3 = 1;
                                        }
                                        i3 = 0;
                                    }
                                    if (obj3 == null) {
                                        i6 = size2 - i5;
                                        size2 = i4 - i5;
                                        i4 = 1;
                                    } else {
                                        i7 = size2;
                                        size2 = i4;
                                        i4 = i5 + 1;
                                        i6 = i7;
                                    }
                                    i5 = i4;
                                    i4 = size2;
                                    size2 = i6 + 1;
                                }
                                if (i5 != bVar.Pb) {
                                    c(bVar);
                                    bVar = a(2, i2, i5, null);
                                }
                                if (i3 != 0) {
                                    b(bVar);
                                    break;
                                } else {
                                    a(bVar);
                                    break;
                                }
                                break;
                            case 4:
                                i3 = bVar.OZ;
                                i5 = bVar.OZ + bVar.Pb;
                                i4 = bVar.OZ;
                                i6 = 0;
                                size2 = i3;
                                i3 = -1;
                                while (i4 < i5) {
                                    if (this.OU.aQ(i4) == null || aN(i4)) {
                                        if (i3 == 0) {
                                            a(a(4, size2, i6, bVar.Pa));
                                            i6 = 0;
                                            size2 = i4;
                                        }
                                        i3 = size2;
                                        size2 = i6;
                                        i6 = 1;
                                    } else {
                                        if (i3 == 1) {
                                            b(a(4, size2, i6, bVar.Pa));
                                            i6 = 0;
                                            size2 = i4;
                                        }
                                        i3 = size2;
                                        size2 = i6;
                                        i6 = 0;
                                    }
                                    i4++;
                                    i7 = i6;
                                    i6 = size2 + 1;
                                    size2 = i3;
                                    i3 = i7;
                                }
                                if (i6 != bVar.Pb) {
                                    obj = bVar.Pa;
                                    c(bVar);
                                    bVar = a(4, size2, i6, obj);
                                }
                                if (i3 != 0) {
                                    b(bVar);
                                    break;
                                } else {
                                    a(bVar);
                                    break;
                                }
                                break;
                            case 8:
                                b(bVar);
                                break;
                        }
                        if (this.OV != null) {
                            this.OV.run();
                        }
                    }
                    this.OS.clear();
                    return;
                } else {
                    obj4 = obj3;
                }
                size2--;
                obj3 = obj4;
            }
            i = -1;
            if (i != -1) {
                i2 = i + 1;
                bVar = (b) list.get(i);
                bVar2 = (b) list.get(i2);
                switch (bVar2.pK) {
                    case 1:
                        size2 = 0;
                        if (bVar.Pb < bVar2.OZ) {
                            size2 = -1;
                        }
                        if (bVar.OZ < bVar2.OZ) {
                            size2++;
                        }
                        if (bVar2.OZ <= bVar.OZ) {
                            bVar.OZ += bVar2.Pb;
                        }
                        if (bVar2.OZ <= bVar.Pb) {
                            bVar.Pb += bVar2.Pb;
                        }
                        bVar2.OZ = size2 + bVar2.OZ;
                        list.set(i, bVar2);
                        list.set(i2, bVar);
                        break;
                    case 2:
                        bVar3 = null;
                        obj = null;
                        if (bVar.OZ < bVar.Pb) {
                            obj2 = null;
                            obj = 1;
                            break;
                        }
                        obj2 = 1;
                        obj = 1;
                        break;
                        if (bVar.Pb < bVar2.OZ) {
                            if (bVar.Pb < bVar2.OZ + bVar2.Pb) {
                                bVar2.Pb--;
                                bVar.pK = 2;
                                bVar.Pb = 1;
                                if (bVar2.Pb != 0) {
                                    list.remove(i2);
                                    aaVar.TF.c(bVar2);
                                    break;
                                }
                                break;
                            }
                        }
                        bVar2.OZ--;
                        if (bVar.OZ <= bVar2.OZ) {
                            bVar2.OZ++;
                        } else if (bVar.OZ < bVar2.OZ + bVar2.Pb) {
                            bVar3 = aaVar.TF.a(2, bVar.OZ + 1, (bVar2.OZ + bVar2.Pb) - bVar.OZ, null);
                            bVar2.Pb = bVar.OZ - bVar2.OZ;
                        }
                        if (obj == null) {
                            list.set(i, bVar2);
                            list.remove(i2);
                            aaVar.TF.c(bVar);
                            break;
                        }
                        if (obj2 == null) {
                            if (bVar3 != null) {
                                if (bVar.OZ >= bVar3.OZ) {
                                    bVar.OZ -= bVar3.Pb;
                                }
                                if (bVar.Pb >= bVar3.OZ) {
                                    bVar.Pb -= bVar3.Pb;
                                }
                            }
                            if (bVar.OZ >= bVar2.OZ) {
                                bVar.OZ -= bVar2.Pb;
                            }
                            if (bVar.Pb >= bVar2.OZ) {
                                bVar.Pb -= bVar2.Pb;
                            }
                        } else {
                            if (bVar3 != null) {
                                if (bVar.OZ > bVar3.OZ) {
                                    bVar.OZ -= bVar3.Pb;
                                }
                                if (bVar.Pb > bVar3.OZ) {
                                    bVar.Pb -= bVar3.Pb;
                                }
                            }
                            if (bVar.OZ > bVar2.OZ) {
                                bVar.OZ -= bVar2.Pb;
                            }
                            if (bVar.Pb > bVar2.OZ) {
                                bVar.Pb -= bVar2.Pb;
                            }
                        }
                        list.set(i, bVar2);
                        if (bVar.OZ == bVar.Pb) {
                            list.remove(i2);
                        } else {
                            list.set(i2, bVar);
                        }
                        if (bVar3 == null) {
                            list.add(i, bVar3);
                            break;
                        }
                        break;
                    case 4:
                        obj2 = null;
                        obj = null;
                        if (bVar.Pb < bVar2.OZ) {
                            bVar2.OZ--;
                        } else if (bVar.Pb < bVar2.OZ + bVar2.Pb) {
                            bVar2.Pb--;
                            obj2 = aaVar.TF.a(4, bVar.OZ, 1, bVar2.Pa);
                        }
                        if (bVar.OZ <= bVar2.OZ) {
                            bVar2.OZ++;
                        } else if (bVar.OZ < bVar2.OZ + bVar2.Pb) {
                            i3 = (bVar2.OZ + bVar2.Pb) - bVar.OZ;
                            obj = aaVar.TF.a(4, bVar.OZ + 1, i3, bVar2.Pa);
                            bVar2.Pb -= i3;
                        }
                        list.set(i2, bVar);
                        if (bVar2.Pb <= 0) {
                            list.remove(i);
                            aaVar.TF.c(bVar2);
                        } else {
                            list.set(i, bVar2);
                        }
                        if (obj2 != null) {
                            list.add(i, obj2);
                        }
                        if (obj == null) {
                            list.add(i, obj);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            size = this.OS.size();
            for (i = 0; i < size; i++) {
                bVar = (b) this.OS.get(i);
                switch (bVar.pK) {
                    case 1:
                        b(bVar);
                        break;
                    case 2:
                        i2 = bVar.OZ;
                        i4 = bVar.Pb + bVar.OZ;
                        i3 = -1;
                        size2 = bVar.OZ;
                        i5 = 0;
                        while (size2 < i4) {
                            obj3 = null;
                            if (this.OU.aQ(size2) == null) {
                                break;
                            }
                            if (i3 == 0) {
                                a(a(2, i2, i5, null));
                                obj3 = 1;
                            }
                            i3 = 1;
                            if (obj3 == null) {
                                i7 = size2;
                                size2 = i4;
                                i4 = i5 + 1;
                                i6 = i7;
                            } else {
                                i6 = size2 - i5;
                                size2 = i4 - i5;
                                i4 = 1;
                            }
                            i5 = i4;
                            i4 = size2;
                            size2 = i6 + 1;
                        }
                        if (i5 != bVar.Pb) {
                            c(bVar);
                            bVar = a(2, i2, i5, null);
                        }
                        if (i3 != 0) {
                            a(bVar);
                            break;
                        } else {
                            b(bVar);
                            break;
                        }
                    case 4:
                        i3 = bVar.OZ;
                        i5 = bVar.OZ + bVar.Pb;
                        i4 = bVar.OZ;
                        i6 = 0;
                        size2 = i3;
                        i3 = -1;
                        while (i4 < i5) {
                            if (this.OU.aQ(i4) == null) {
                                break;
                            }
                            if (i3 == 0) {
                                a(a(4, size2, i6, bVar.Pa));
                                i6 = 0;
                                size2 = i4;
                            }
                            i3 = size2;
                            size2 = i6;
                            i6 = 1;
                            i4++;
                            i7 = i6;
                            i6 = size2 + 1;
                            size2 = i3;
                            i3 = i7;
                        }
                        if (i6 != bVar.Pb) {
                            obj = bVar.Pa;
                            c(bVar);
                            bVar = a(4, size2, i6, obj);
                        }
                        if (i3 != 0) {
                            a(bVar);
                            break;
                        } else {
                            b(bVar);
                            break;
                        }
                    case 8:
                        b(bVar);
                        break;
                }
                if (this.OV != null) {
                    this.OV.run();
                }
            }
            this.OS.clear();
            return;
        }
    }

    final void es() {
        int size = this.OT.size();
        for (int i = 0; i < size; i++) {
            this.OU.e((b) this.OT.get(i));
        }
        g(this.OT);
        this.OY = 0;
    }

    private void a(b bVar) {
        if (bVar.pK == 1 || bVar.pK == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int v = v(bVar.OZ, bVar.pK);
        int i2 = bVar.OZ;
        switch (bVar.pK) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i3 = 1;
        int i4 = v;
        v = i2;
        for (i2 = 1; i2 < bVar.Pb; i2++) {
            Object obj;
            int v2 = v(bVar.OZ + (i * i2), bVar.pK);
            int i5;
            switch (bVar.pK) {
                case 2:
                    if (v2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (v2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                b a = a(bVar.pK, i4, i3, bVar.Pa);
                a(a, v);
                c(a);
                if (bVar.pK == 4) {
                    v += i3;
                }
                i3 = 1;
                i4 = v2;
            }
        }
        Object obj2 = bVar.Pa;
        c(bVar);
        if (i3 > 0) {
            b a2 = a(bVar.pK, i4, i3, obj2);
            a(a2, v);
            c(a2);
        }
    }

    private void a(b bVar, int i) {
        this.OU.d(bVar);
        switch (bVar.pK) {
            case 2:
                this.OU.x(i, bVar.Pb);
                return;
            case 4:
                this.OU.a(i, bVar.Pb, bVar.Pa);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int v(int i, int i2) {
        int i3;
        int size = this.OT.size() - 1;
        int i4 = i;
        while (size >= 0) {
            int i5;
            b bVar = (b) this.OT.get(size);
            if (bVar.pK == 8) {
                int i6;
                if (bVar.OZ < bVar.Pb) {
                    i6 = bVar.OZ;
                    i3 = bVar.Pb;
                } else {
                    i6 = bVar.Pb;
                    i3 = bVar.OZ;
                }
                if (i4 < i6 || i4 > r2) {
                    if (i4 < bVar.OZ) {
                        if (i2 == 1) {
                            bVar.OZ++;
                            bVar.Pb++;
                            i5 = i4;
                        } else if (i2 == 2) {
                            bVar.OZ--;
                            bVar.Pb--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == bVar.OZ) {
                    if (i2 == 1) {
                        bVar.Pb++;
                    } else if (i2 == 2) {
                        bVar.Pb--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        bVar.OZ++;
                    } else if (i2 == 2) {
                        bVar.OZ--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (bVar.OZ <= i4) {
                    if (bVar.pK == 1) {
                        i5 = i4 - bVar.Pb;
                    } else if (bVar.pK == 2) {
                        i5 = bVar.Pb + i4;
                    }
                } else if (i2 == 1) {
                    bVar.OZ++;
                    i5 = i4;
                } else if (i2 == 2) {
                    bVar.OZ--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.OT.size() - 1; i3 >= 0; i3--) {
            bVar = (b) this.OT.get(i3);
            if (bVar.pK == 8) {
                if (bVar.Pb == bVar.OZ || bVar.Pb < 0) {
                    this.OT.remove(i3);
                    c(bVar);
                }
            } else if (bVar.Pb <= 0) {
                this.OT.remove(i3);
                c(bVar);
            }
        }
        return i4;
    }

    private boolean aN(int i) {
        int size = this.OT.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.OT.get(i2);
            if (bVar.pK == 8) {
                if (w(bVar.Pb, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.pK == 1) {
                int i3 = bVar.OZ + bVar.Pb;
                for (int i4 = bVar.OZ; i4 < i3; i4++) {
                    if (w(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void b(b bVar) {
        this.OT.add(bVar);
        switch (bVar.pK) {
            case 1:
                this.OU.z(bVar.OZ, bVar.Pb);
                return;
            case 2:
                this.OU.y(bVar.OZ, bVar.Pb);
                return;
            case 4:
                this.OU.a(bVar.OZ, bVar.Pb, bVar.Pa);
                return;
            case 8:
                this.OU.A(bVar.OZ, bVar.Pb);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    final boolean et() {
        return this.OS.size() > 0;
    }

    final boolean aO(int i) {
        return (this.OY & i) != 0;
    }

    final int aP(int i) {
        return w(i, 0);
    }

    final int w(int i, int i2) {
        int size = this.OT.size();
        int i3 = i;
        while (i2 < size) {
            b bVar = (b) this.OT.get(i2);
            if (bVar.pK == 8) {
                if (bVar.OZ == i3) {
                    i3 = bVar.Pb;
                } else {
                    if (bVar.OZ < i3) {
                        i3--;
                    }
                    if (bVar.Pb <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.OZ > i3) {
                continue;
            } else if (bVar.pK == 2) {
                if (i3 < bVar.OZ + bVar.Pb) {
                    return -1;
                }
                i3 -= bVar.Pb;
            } else if (bVar.pK == 1) {
                i3 += bVar.Pb;
            }
            i2++;
        }
        return i3;
    }

    final void eu() {
        es();
        int size = this.OS.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.OS.get(i);
            switch (bVar.pK) {
                case 1:
                    this.OU.e(bVar);
                    this.OU.z(bVar.OZ, bVar.Pb);
                    break;
                case 2:
                    this.OU.e(bVar);
                    this.OU.x(bVar.OZ, bVar.Pb);
                    break;
                case 4:
                    this.OU.e(bVar);
                    this.OU.a(bVar.OZ, bVar.Pb, bVar.Pa);
                    break;
                case 8:
                    this.OU.e(bVar);
                    this.OU.A(bVar.OZ, bVar.Pb);
                    break;
            }
            if (this.OV != null) {
                this.OV.run();
            }
        }
        g(this.OS);
        this.OY = 0;
    }

    public final b a(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.OR.bG();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.pK = i;
        bVar.OZ = i2;
        bVar.Pb = i3;
        bVar.Pa = obj;
        return bVar;
    }

    public final void c(b bVar) {
        if (!this.OW) {
            bVar.Pa = null;
            this.OR.j(bVar);
        }
    }

    private void g(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c((b) list.get(i));
        }
        list.clear();
    }
}
