package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.f;
import com.tencent.mm.vending.base.Vending.i;
import com.tencent.mm.vending.f.a;

public abstract class b<_Struct, _Change> extends Vending<_Struct, Integer, _Change> {
    public int mCount = 0;
    public int zBn = 5;
    private a zBo = new a((byte) 0);

    public abstract int czE();

    public abstract _Struct xO(int i);

    protected /* synthetic */ boolean invalidIndex(Object obj) {
        return ((Integer) obj).intValue() < 0;
    }

    protected /* synthetic */ void requestIndexImpl(i iVar, Object obj) {
        Integer num = (Integer) obj;
        int i = this.mCount;
        if (i > 0) {
            fq(Math.min(i - 1, num.intValue()), Math.min(i - 1, num.intValue() + this.zBn));
            fq(Math.max(Math.min(0, num.intValue()), num.intValue()), Math.max(Math.min(0, num.intValue()), num.intValue() - this.zBn));
        }
    }

    protected /* synthetic */ Object resolveAsynchronous(Object obj) {
        return xO(((Integer) obj).intValue());
    }

    public final <T> T get(int i) {
        if (this.mCount != 0) {
            return super.get(Integer.valueOf(i));
        }
        a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
        return null;
    }

    public final void Hn(int i) {
        if (this.mCount == 0) {
            a.e("Vending.ForwardVending", "the count is 0, why call null?", new Object[0]);
        } else {
            super.request(Integer.valueOf(i));
        }
    }

    protected void synchronizing(int i, Object obj) {
        this.mCount = czE();
        a.i("Vending.ForwardVending", "the count %s", new Object[]{Integer.valueOf(this.mCount)});
    }

    private void fq(int i, int i2) {
        int[] iArr;
        int i3 = i >= i2 ? 1 : 0;
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        synchronized (this.zBo) {
            int i4;
            a aVar = this.zBo;
            if (aVar.initialized) {
                int i5 = aVar.Wu;
                i4 = aVar.Wv;
                if (i5 > max || i4 < min) {
                    if (i5 > max + 1 || i4 < min - 1) {
                        aVar.set(min, max);
                    }
                    iArr = new int[]{min, max};
                } else if (min < i5) {
                    if (max > i4) {
                        aVar.set(min, max);
                        iArr = new int[]{min, i5 - 1, i4 + 1, max};
                    } else {
                        aVar.set(min, i4);
                        iArr = new int[]{min, i5 - 1};
                    }
                } else if (max > i4) {
                    aVar.set(i5, max);
                    iArr = new int[]{i4 + 1, max};
                } else {
                    iArr = null;
                }
            } else {
                aVar.set(min, max);
                aVar.initialized = true;
                iArr = new int[]{min, max};
            }
        }
        if (iArr != null) {
            min = i3 != 0 ? iArr.length - 2 : 0;
            while (true) {
                if (i3 != 0) {
                    if (min < 0) {
                        return;
                    }
                } else if (min >= iArr.length) {
                    return;
                }
                int i6 = iArr[min];
                i4 = iArr[min + 1];
                int abs = Math.abs(i6 - i4);
                for (max = 0; max <= abs; max++) {
                    int i7;
                    if (i3 != 0) {
                        i7 = i4 - max;
                    } else {
                        i7 = i6 + max;
                    }
                    f loader = getLoader();
                    Integer valueOf = Integer.valueOf(i7);
                    if (!loader.iHf.get()) {
                        synchronized (loader.zBu) {
                            com.tencent.mm.vending.base.Vending.f.b bVar = (com.tencent.mm.vending.base.Vending.f.b) loader.zBs.get(valueOf);
                            if (bVar == null || bVar == com.tencent.mm.vending.base.Vending.f.b.zBw) {
                                loader.zBs.put(valueOf, com.tencent.mm.vending.base.Vending.f.b.zBx);
                                loader.mVendingHandler.sendMessage(loader.mVendingHandler.obtainMessage(0, valueOf));
                            }
                        }
                    }
                }
                if (i3 != 0) {
                    min -= 2;
                } else {
                    min += 2;
                }
            }
        }
    }

    protected void loaderClear() {
        synchronized (this.zBo) {
            a aVar = this.zBo;
            aVar.Wu = -1;
            aVar.Wv = -1;
            aVar.initialized = false;
        }
    }
}
