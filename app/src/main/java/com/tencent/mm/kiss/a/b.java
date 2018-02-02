package com.tencent.mm.kiss.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class b {
    private static b gSU;
    public LayoutInflater DF;
    private ConcurrentHashMap<String, c> gST = new ConcurrentHashMap();
    public Looper gSV;
    public af gSW;
    public boolean gSX = false;
    public boolean gSY = false;
    public int mMode = 2;

    private static final class a implements OnAttachStateChangeListener {
        private String gTa;
        private b gTb;
        private b gTc = null;

        public a(String str, b bVar, b bVar2) {
            this.gTa = str;
            this.gTb = bVar;
        }

        public final void onViewAttachedToWindow(View view) {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onViewDetachedFromWindow(View view) {
            c cVar = (c) this.gTb.gST.get(this.gTa);
            if (this.gTb.mMode != 1) {
                b.a(this.gTb, cVar);
            } else if (cVar != null) {
                synchronized (cVar) {
                    cVar.gTe.remove(view);
                    cVar.gTd.add(view);
                }
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public interface b {
    }

    class AnonymousClass1 extends af {
        final /* synthetic */ b gSZ;

        public AnonymousClass1(b bVar, Looper looper) {
            this.gSZ = bVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            x.i("KISS.InflateRecycler", "InflateViewRecycler start %s", Long.valueOf(System.currentTimeMillis()));
            c cVar = (c) message.obj;
            int size = cVar.gTf - cVar.gTd.size();
            int i = cVar.DD;
            x.i("KISS.InflateRecycler", "InflateViewRecycler for %s", cVar.gTa);
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    View inflate = this.gSZ.DF.inflate(i, cVar.gTh, false);
                    synchronized (cVar) {
                        cVar.gTd.add(inflate);
                    }
                    if (!(cVar.gTg == null || cVar.gTg.length == 0)) {
                        for (int i3 = 0; i3 < cVar.gTg.length; i3 += 2) {
                            View findViewById = inflate.findViewById(cVar.gTg[i3]);
                            if (findViewById != null && (findViewById instanceof ViewStub)) {
                                int i4 = cVar.gTg[i3 + 1];
                                if (i4 != 0) {
                                    ((ViewStub) findViewById).setLayoutResource(i4);
                                }
                                ((ViewStub) findViewById).inflate();
                            }
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("KISS.InflateRecycler", e, "pre inflate failed.", new Object[0]);
                    com.tencent.mm.blink.a.j(11, 1);
                }
            }
            x.i("KISS.InflateRecycler", "InflateViewRecycler end %s", Long.valueOf(System.currentTimeMillis()));
            x.i("KISS.InflateRecycler", "preload done");
        }
    }

    static /* synthetic */ void a(b bVar, c cVar) {
        if (bVar.gSX && !bVar.gSY && cVar.gTf > cVar.gTd.size()) {
            bVar.gSW.sendMessage(bVar.gSW.obtainMessage(0, cVar));
        }
    }

    static {
        gSU = null;
        gSU = new b();
    }

    public static b DY() {
        return gSU;
    }

    public final View a(Activity activity, String str, int i) {
        if (this.gSY) {
            x.i("KISS.InflateRecycler", "not support application inflate");
            return activity.getLayoutInflater().inflate(i, null);
        } else if (!this.gSX) {
            return activity.getLayoutInflater().inflate(i, null);
        } else {
            c cVar = (c) this.gST.get(str);
            if (cVar != null) {
                View view;
                synchronized (cVar) {
                    view = (View) cVar.gTd.poll();
                    if (this.mMode == 1) {
                        cVar.gTe.add(view);
                    }
                }
                if (view != null) {
                    x.i("KISS.InflateRecycler", "cache reach %s", str);
                    view.addOnAttachStateChangeListener(new a(str, this, null));
                    return view;
                }
            }
            x.i("KISS.InflateRecycler", "no cache reach %s", str);
            return this.DF.inflate(i, null);
        }
    }

    public final boolean a(String str, int i, int i2, int... iArr) {
        return a(str, i, i2, null, iArr);
    }

    public final boolean a(String str, int i, int i2, ViewGroup viewGroup, int... iArr) {
        if (!this.gSX) {
            return false;
        }
        if (this.gSY) {
            x.i("KISS.InflateRecycler", "not support application inflate");
            return false;
        }
        if (viewGroup != null) {
            if (VERSION.SDK_INT >= 19) {
                Assert.assertFalse(viewGroup.isAttachedToWindow());
            }
            Assert.assertTrue(viewGroup.getParent() == null);
        }
        if (((c) this.gST.get(str)) != null) {
            return false;
        }
        c cVar = new c();
        this.gST.put(str, cVar);
        cVar.gTf = i;
        cVar.gTa = str;
        cVar.DD = i2;
        cVar.gTg = iArr;
        cVar.gTh = viewGroup;
        this.gSW.sendMessage(this.gSW.obtainMessage(0, cVar));
        return true;
    }
}
