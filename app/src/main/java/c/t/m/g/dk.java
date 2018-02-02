package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.Secure;
import com.tencent.liteav.network.TXCStreamDownloader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class dk extends BroadcastReceiver {
    static boolean d;
    private static final Comparator<ScanResult> q = new 3();
    volatile boolean a;
    final cr b;
    HashSet<String> c;
    volatile Handler e;
    volatile a f;
    volatile List<ScanResult> g;
    Runnable h;
    String i;
    public long j = 30000;
    final byte[] k = new byte[0];
    private final WifiManager l;
    private long m;
    private volatile List<ScanResult> n;
    private Runnable o;
    private boolean p;

    class a extends Handler {
        private /* synthetic */ dk a;

        public a(dk dkVar, Looper looper) {
            this.a = dkVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            synchronized (this.a.k) {
                switch (message.what) {
                    case 1201:
                        this.a.c();
                        break;
                    case 1202:
                        try {
                            List<ScanResult> g = this.a.n;
                            if (g != null && g.size() > 0) {
                                if (this.a.p && cl.a().d("up_wifis")) {
                                    dk.a(this.a, (List) g);
                                    this.a.p = false;
                                }
                                if (this.a.g == null) {
                                    this.a.g = new ArrayList();
                                }
                                int i = 1;
                                this.a.i = "";
                                for (ScanResult scanResult : g) {
                                    int i2;
                                    if (i <= 20) {
                                        this.a.i = this.a.i + scanResult.SSID + "," + scanResult.BSSID + "|";
                                        i2 = i + 1;
                                    } else {
                                        i2 = i;
                                    }
                                    i = i2;
                                }
                                this.a.g.clear();
                                this.a.g.addAll(g);
                                dl.a(this.a.g);
                                if (this.a.g != null && this.a.g.size() > 0) {
                                    Collections.sort(this.a.g, dk.q);
                                    dk.l(this.a);
                                    break;
                                }
                            }
                            if (this.a.p) {
                                this.a.b.c(dr.a);
                            }
                            this.a.i = "";
                            break;
                        } catch (Throwable th) {
                            break;
                        }
                        break;
                }
            }
        }
    }

    public dk(cr crVar) {
        this.b = crVar;
        this.l = crVar.f;
        this.c = new HashSet();
        this.p = true;
        this.o = new 1(this);
        this.h = new 2(this);
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                boolean equals = "android.net.wifi.WIFI_STATE_CHANGED".equals(action);
                if (equals) {
                    a(1201);
                }
                if (equals || "android.net.wifi.SCAN_RESULTS".equals(action)) {
                    this.n = eh.c(this.l);
                    a(1202);
                }
            } catch (Throwable th) {
            }
        }
    }

    private void a(int i) {
        if (this.f != null) {
            this.f.obtainMessage(i).sendToTarget();
        }
    }

    public final void a(long j) {
        Handler handler = this.e;
        Runnable runnable = this.o;
        Looper looper = handler == null ? null : handler.getLooper();
        if (looper != null && looper.getThread().isAlive()) {
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, j);
        }
    }

    final boolean a() {
        if (!eh.b(this.b) || d) {
            return false;
        }
        return eh.b(this.l);
    }

    private void a(List<ScanResult> list) {
        if (list == null || list.size() == 0) {
            c();
        } else if (eh.a) {
            eh.a = false;
            c();
        }
        long j = this.m;
        eh.a(this.l);
        this.b.c(new dr(list, j));
    }

    private void c() {
        int i = 1;
        try {
            int a = eh.a(this.l);
            if (a == 3) {
                a(0);
            } else if (a == 1) {
                i = 0;
                if (!eh.b(this.b)) {
                    if (this.g != null) {
                        this.g.clear();
                    }
                    if (this.e != null) {
                        this.e.sendEmptyMessage(555);
                    }
                }
            } else {
                i = -1;
            }
            try {
                if (VERSION.SDK_INT >= 23 && Secure.getInt(this.b.a.getContentResolver(), "location_mode") == 0) {
                    i = 5;
                }
            } catch (Throwable th) {
            }
            Message message = new Message();
            message.what = 12999;
            message.arg1 = TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS;
            message.arg2 = i;
            this.b.c(message);
        } catch (Throwable th2) {
        }
    }

    static /* synthetic */ void a(dk dkVar, List list) {
        if (list != null && list.size() != 0) {
            int parseLong;
            int currentTimeMillis = (int) ((System.currentTimeMillis() / 86400000) % 5);
            try {
                parseLong = ((int) (Long.parseLong(dkVar.b.b.a().substring(1)) % 5)) + 1;
            } catch (Exception e) {
                parseLong = 1;
            }
            SharedPreferences sharedPreferences = dkVar.b.a.getSharedPreferences("LocationSDK", 0);
            if (currentTimeMillis != parseLong) {
                sharedPreferences.edit().putBoolean("flag_wf", false).apply();
            } else if (!sharedPreferences.getBoolean("flag_wf", false) && dkVar.e != null) {
                try {
                    Message obtainMessage = dkVar.e.obtainMessage(554);
                    Bundle data = obtainMessage.getData();
                    if (data == null) {
                        data = new Bundle();
                    }
                    data.putString("WIFIS", eh.a(list));
                    obtainMessage.setData(data);
                    dkVar.e.sendMessageDelayed(obtainMessage, 3000);
                    sharedPreferences.edit().putBoolean("flag_wf", true).apply();
                } catch (Throwable th) {
                    sharedPreferences.edit().putBoolean("flag_wf", true).apply();
                }
            }
        }
    }

    static /* synthetic */ void l(dk dkVar) {
        List<ScanResult> list = dkVar.g;
        if (dkVar.c == null) {
            dkVar.c = new HashSet();
        }
        if (list == null) {
            return;
        }
        if (dkVar.c.size() == 0) {
            for (ScanResult scanResult : list) {
                dkVar.c.add(scanResult.BSSID + scanResult.level);
            }
            dkVar.m = System.currentTimeMillis();
            dkVar.a((List) list);
            return;
        }
        int size = dkVar.c.size();
        if (size != list.size()) {
            dkVar.c.clear();
            for (ScanResult scanResult2 : list) {
                dkVar.c.add(scanResult2.BSSID + scanResult2.level);
            }
            dkVar.m = System.currentTimeMillis();
            dkVar.a((List) list);
            return;
        }
        for (ScanResult scanResult22 : list) {
            dkVar.c.add(scanResult22.BSSID + scanResult22.level);
        }
        if (size != dkVar.c.size()) {
            dkVar.c.clear();
            for (ScanResult scanResult222 : list) {
                dkVar.c.add(scanResult222.BSSID + scanResult222.level);
            }
            dkVar.m = System.currentTimeMillis();
            dkVar.a((List) list);
        }
    }
}
