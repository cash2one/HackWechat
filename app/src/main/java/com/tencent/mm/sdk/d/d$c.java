package com.tencent.mm.sdk.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

class d$c extends Handler {
    private static final Object xjf = new Object();
    private boolean jHi;
    private d xiT;
    private boolean xje;
    private Message xjg;
    private d$b xjh;
    private boolean xji;
    private c[] xjj;
    private int xjk;
    private c[] xjl;
    private int xjm;
    private a xjn;
    private b xjo;
    private HashMap<c, c> xjp;
    private c xjq;
    private c xjr;
    private ArrayList<Message> xjs;

    static /* synthetic */ void b(d$c com_tencent_mm_sdk_d_d_c, c cVar) {
        if (com_tencent_mm_sdk_d_d_c.xje) {
            new StringBuilder("setInitialState: initialState=").append(cVar.getName());
        }
        com_tencent_mm_sdk_d_d_c.xjq = cVar;
    }

    static /* synthetic */ void f(d$c com_tencent_mm_sdk_d_d_c) {
        int i = 0;
        for (c cVar : com_tencent_mm_sdk_d_d_c.xjp.values()) {
            int i2 = 0;
            c cVar2;
            while (cVar2 != null) {
                cVar2 = cVar2.xjv;
                i2++;
            }
            if (i >= i2) {
                i2 = i;
            }
            i = i2;
        }
        if (com_tencent_mm_sdk_d_d_c.xje) {
            com_tencent_mm_sdk_d_d_c.xjj = new c[i];
            com_tencent_mm_sdk_d_d_c.xjl = new c[i];
            com_tencent_mm_sdk_d_d_c.cgL();
            com_tencent_mm_sdk_d_d_c.sendMessageAtFrontOfQueue(com_tencent_mm_sdk_d_d_c.obtainMessage(-2, xjf));
        } else {
            com_tencent_mm_sdk_d_d_c.xjj = new c[i];
            com_tencent_mm_sdk_d_d_c.xjl = new c[i];
            com_tencent_mm_sdk_d_d_c.cgL();
            com_tencent_mm_sdk_d_d_c.sendMessageAtFrontOfQueue(com_tencent_mm_sdk_d_d_c.obtainMessage(-2, xjf));
        }
    }

    public final void handleMessage(Message message) {
        if (!this.jHi) {
            if (this.xje) {
                new StringBuilder("handleMessage: E msg.what=").append(message.what);
            }
            this.xjg = message;
            c cVar = null;
            if (this.xji) {
                cVar = s(message);
            } else if (!this.xji && this.xjg.what == -2 && this.xjg.obj == xjf) {
                this.xji = true;
                Dj(0);
            } else {
                throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
            }
            a(cVar, message);
        }
    }

    private void a(c cVar, Message message) {
        b bVar;
        a aVar = this.xjj[this.xjk].xju;
        boolean z = this.xiT.h(this.xjg) && message.obj != xjf;
        if (this.xjh.cgI()) {
            if (this.xjr != null) {
                this.xjh.b(this.xiT, this.xjg, "", cVar, aVar, this.xjr);
            }
        } else if (z) {
            this.xjh.b(this.xiT, this.xjg, "", cVar, aVar, this.xjr);
        }
        c cVar2 = this.xjr;
        c cVar3;
        if (cVar2 != null) {
            bVar = cVar2;
            while (true) {
                this.xjm = 0;
                c cVar4 = (c) this.xjp.get(bVar);
                do {
                    c[] cVarArr = this.xjl;
                    int i = this.xjm;
                    this.xjm = i + 1;
                    cVarArr[i] = cVar4;
                    cVar4 = cVar4.xjv;
                    if (cVar4 == null) {
                        break;
                    }
                } while (!cVar4.ahf);
                if (this.xje) {
                    new StringBuilder("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=").append(this.xjm).append(",curStateInfo: ").append(cVar4);
                }
                a(cVar4);
                Dj(cgK());
                cgJ();
                if (bVar == this.xjr) {
                    break;
                }
                cVar3 = this.xjr;
            }
            this.xjr = null;
        } else {
            cVar3 = cVar2;
        }
        if (bVar != null && bVar == this.xjo) {
            this.xiT.ZF();
            if (this.xiT.xiS != null) {
                getLooper().quit();
                this.xiT.xiS = null;
            }
            this.xiT.xiR = null;
            this.xiT = null;
            this.xjg = null;
            this.xjh.cleanup();
            this.xjj = null;
            this.xjl = null;
            this.xjp.clear();
            this.xjq = null;
            this.xjr = null;
            this.xjs.clear();
            this.jHi = true;
        }
    }

    private final c s(Message message) {
        c cVar = this.xjj[this.xjk];
        if (this.xje) {
            new StringBuilder("processMsg: ").append(cVar.xju.getName());
        }
        Object obj = (message.what == -1 && message.obj == xjf) ? 1 : null;
        if (obj != null) {
            b(this.xjo);
        } else {
            while (!cVar.xju.j(message)) {
                cVar = cVar.xjv;
                if (cVar == null) {
                    this.xiT.i(message);
                    break;
                } else if (this.xje) {
                    new StringBuilder("processMsg: ").append(cVar.xju.getName());
                }
            }
        }
        if (cVar != null) {
            return cVar.xju;
        }
        return null;
    }

    private final void a(c cVar) {
        while (this.xjk >= 0 && this.xjj[this.xjk] != cVar) {
            c cVar2 = this.xjj[this.xjk].xju;
            if (this.xje) {
                new StringBuilder("invokeExitMethods: ").append(cVar2.getName());
            }
            cVar2.exit();
            this.xjj[this.xjk].ahf = false;
            this.xjk--;
        }
    }

    private final void Dj(int i) {
        while (i <= this.xjk) {
            if (this.xje) {
                new StringBuilder("invokeEnterMethods: ").append(this.xjj[i].xju.getName());
            }
            this.xjj[i].xju.enter();
            this.xjj[i].ahf = true;
            i++;
        }
    }

    private final void cgJ() {
        for (int size = this.xjs.size() - 1; size >= 0; size--) {
            Message message = (Message) this.xjs.get(size);
            if (this.xje) {
                new StringBuilder("moveDeferredMessageAtFrontOfQueue; what=").append(message.what);
            }
            sendMessageAtFrontOfQueue(message);
        }
        this.xjs.clear();
    }

    private final int cgK() {
        int i = this.xjk + 1;
        int i2 = i;
        for (int i3 = this.xjm - 1; i3 >= 0; i3--) {
            if (this.xje) {
                new StringBuilder("moveTempStackToStateStack: i=").append(i3).append(",j=").append(i2);
            }
            this.xjj[i2] = this.xjl[i3];
            i2++;
        }
        this.xjk = i2 - 1;
        if (this.xje) {
            new StringBuilder("moveTempStackToStateStack: X mStateStackTop=").append(this.xjk).append(",startingIndex=").append(i).append(",Top=").append(this.xjj[this.xjk].xju.getName());
        }
        return i;
    }

    private final void cgL() {
        if (this.xje) {
            new StringBuilder("setupInitialStateStack: E mInitialState=").append(this.xjq.getName());
        }
        c cVar = (c) this.xjp.get(this.xjq);
        this.xjm = 0;
        while (cVar != null) {
            this.xjl[this.xjm] = cVar;
            cVar = cVar.xjv;
            this.xjm++;
        }
        this.xjk = -1;
        cgK();
    }

    private final c a(c cVar, c cVar2) {
        if (this.xje) {
            new StringBuilder("addStateInternal: E state=").append(cVar.getName()).append(",parent=");
        }
        c cVar3 = (c) this.xjp.get(cVar);
        if (cVar3 == null) {
            cVar3 = new c(this, (byte) 0);
            this.xjp.put(cVar, cVar3);
        }
        if (cVar3.xjv == null || cVar3.xjv == null) {
            cVar3.xju = cVar;
            cVar3.xjv = null;
            cVar3.ahf = false;
            if (this.xje) {
                new StringBuilder("addStateInternal: X stateInfo: ").append(cVar3);
            }
            return cVar3;
        }
        throw new RuntimeException("state already added");
    }

    private d$c(Looper looper, d dVar) {
        super(looper);
        this.jHi = false;
        this.xje = false;
        this.xjh = new d$b();
        this.xjk = -1;
        this.xjn = new a(this, (byte) 0);
        this.xjo = new b(this, (byte) 0);
        this.xjp = new HashMap();
        this.xjs = new ArrayList();
        this.xiT = dVar;
        a(this.xjn, null);
        a(this.xjo, null);
    }

    private final void b(a aVar) {
        this.xjr = (c) aVar;
        if (this.xje) {
            new StringBuilder("transitionTo: destState=").append(this.xjr.getName());
        }
    }
}
