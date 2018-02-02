package c.t.m.g;

import android.os.HandlerThread;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

final class da extends PhoneStateListener {
    volatile boolean a;
    final cr b;
    byte[] c = new byte[0];
    CellLocation d = null;
    SignalStrength e = null;
    ServiceState f = null;
    long g;
    HandlerThread h;
    a i;

    public da(cr crVar) {
        this.b = crVar;
    }

    final void a(int i) {
        try {
            this.b.e.listen(this, i);
        } catch (Exception e) {
        }
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        Object obj = 1;
        super.onServiceStateChanged(serviceState);
        if (serviceState != null) {
            ServiceState serviceState2 = this.f;
            if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
                this.f = serviceState;
                if (this.a) {
                    int i;
                    TelephonyManager telephonyManager;
                    boolean a;
                    Message message;
                    if (this.f != null) {
                        if (this.f.getState() == 0) {
                            i = 1;
                        } else if (this.f.getState() == 1) {
                            i = 0;
                        }
                        telephonyManager = this.b.e;
                        a = ea.a(this.b.a);
                        if (telephonyManager != null) {
                            obj = null;
                        } else if (telephonyManager.getSimState() != 5) {
                            obj = null;
                        }
                        if (a || r1 == null) {
                            i = 0;
                        }
                        message = new Message();
                        message.what = 12999;
                        message.arg1 = 12003;
                        message.arg2 = i;
                        this.b.c(message);
                    }
                    i = -1;
                    telephonyManager = this.b.e;
                    a = ea.a(this.b.a);
                    if (telephonyManager != null) {
                        obj = null;
                    } else if (telephonyManager.getSimState() != 5) {
                        obj = null;
                    }
                    i = 0;
                    message = new Message();
                    message.what = 12999;
                    message.arg1 = 12003;
                    message.arg2 = i;
                    this.b.c(message);
                }
            }
        }
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength != null) {
            try {
                SignalStrength signalStrength2 = this.e;
                int i = this.b.b.a;
                if (signalStrength2 == null || ea.a(i, signalStrength2, signalStrength)) {
                    this.e = signalStrength;
                    a();
                }
            } catch (Exception e) {
                e.toString();
            }
        }
    }

    public final void onCellLocationChanged(CellLocation cellLocation) {
        super.onCellLocationChanged(cellLocation);
        if (a(cellLocation)) {
            this.d = cellLocation;
            a();
            return;
        }
        new StringBuilder("onCellLocationChanged: illegal cell or same cell ").append(cellLocation);
    }

    final boolean a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0 && gsmCellLocation.getLac() == 0) {
                return false;
            }
        } catch (ClassCastException e) {
        }
        if (ea.a(cellLocation) < 0) {
            return false;
        }
        if (ea.a(this.d, cellLocation)) {
            return false;
        }
        boolean z;
        dn a = dn.a(this.b, cellLocation, null);
        if (a == null) {
            z = true;
        } else {
            z = ea.a(a);
        }
        if (z) {
            return true;
        }
        return false;
    }

    private void a() {
        if (this.a && this.d != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((currentTimeMillis - this.g > 2000 ? 1 : null) != null) {
                this.g = currentTimeMillis;
                dn a = dn.a(this.b, this.d, this.e);
                synchronized (this.c) {
                    if (!(this.i == null || a == null)) {
                        Runnable bVar = new b(this.b);
                        bVar.a = a;
                        this.i.post(bVar);
                    }
                }
            }
        }
    }
}
