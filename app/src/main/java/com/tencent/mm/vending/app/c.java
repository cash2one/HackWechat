package com.tencent.mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.f.a;
import junit.framework.Assert;

public final class c implements b {
    private com.tencent.mm.vending.e.c zAR = new com.tencent.mm.vending.e.c();
    private b zBj = b.czG();
    private a zBk;
    private com.tencent.mm.vending.c.b<? extends a> zBl;
    private int zBm = 0;

    private synchronized <T extends com.tencent.mm.vending.c.b<? extends a>> T M(Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        T t;
        if (this.zBl == null) {
            try {
                this.zBl = (com.tencent.mm.vending.c.b) cls.newInstance();
                if (this.zBk == null) {
                    this.zBk = (a) this.zBl.WD();
                }
                czH();
                t = this.zBl;
            } catch (IllegalAccessException e) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            } catch (InstantiationException e2) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            }
        } else if (cls.isInstance(this.zBl)) {
            t = this.zBl;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
    }

    private synchronized <T extends a> T N(Class<? extends a> cls) {
        T t;
        if (this.zBl != null) {
            t = (a) this.zBl.WD();
        } else if (this.zBk == null) {
            try {
                this.zBk = (a) cls.newInstance();
                czH();
                t = this.zBk;
            } catch (InstantiationException e) {
                throw new InternalError("Could not create interactor instance : " + cls.toString());
            } catch (IllegalAccessException e2) {
                throw new InternalError("Could not create interactor instance : " + cls.toString());
            }
        } else if (cls.isInstance(this.zBk)) {
            t = this.zBk;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
    }

    private void czH() {
        if (this.zBj != null) {
            b bVar = this.zBj;
            a aVar = this.zBk;
            if (bVar.zBf.containsKey(this)) {
                a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
                return;
            }
            bVar.zBf.put(this, aVar);
            a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", new Object[]{this, Integer.valueOf(hashCode()), aVar, Looper.myLooper()});
            int i = bVar.zBg.get(hashCode(), 0);
            if (i > 0 && i < 4) {
                if (i > 0) {
                    bVar.zBh.sendMessage(bVar.zBh.obtainMessage(1, aVar));
                }
                if (i >= 2) {
                    bVar.zBh.sendMessage(bVar.zBh.obtainMessage(2, aVar));
                }
                if (i >= 3) {
                    bVar.zBh.sendMessage(bVar.zBh.obtainMessage(3, aVar));
                }
                if (i >= 4) {
                    bVar.zBh.sendMessage(bVar.zBh.obtainMessage(4, aVar));
                }
            }
        }
    }

    private synchronized void A(Intent intent, Context context) {
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.zBk);
        this.zBk.mContext = context;
        this.zBk.zAZ = new com.tencent.mm.vending.d.a(intent);
    }

    public final synchronized a DW() {
        if (this.zBk == null && this.zBj != null) {
            this.zBk = (a) this.zBj.zBf.get(this);
        }
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.zBk);
        return this.zBk;
    }

    public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity activity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        if (!activity.isFinishing() && (VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return M(cls);
        }
        a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[]{activity});
        return null;
    }

    public final <T extends a> T b(Activity activity, Class<? extends a> cls) {
        if (!activity.isFinishing() && (VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return N(cls);
        }
        a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[]{activity});
        return null;
    }

    public final void Hm(int i) {
        this.zBm = i;
        b bVar = this.zBj;
        a aVar = (a) bVar.zBf.get(this);
        if (aVar != null) {
            switch (i) {
                case 1:
                    a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", new Object[]{aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[]{aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    bVar.zBf.remove(this);
                    break;
                default:
                    a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", new Object[]{Integer.valueOf(i), aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    return;
            }
            bVar.zBh.sendMessage(bVar.zBh.obtainMessage(i, aVar));
        }
        bVar.zBg.put(hashCode(), i);
    }

    public final void B(Intent intent, Context context) {
        A(intent, context);
        Hm(1);
    }

    public final void keep(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.zAR.keep(aVar);
    }

    public final void onDestroy() {
        this.zAR.dead();
        Hm(4);
    }
}
