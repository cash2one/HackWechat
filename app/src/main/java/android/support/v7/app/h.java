package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.content.e;
import android.support.v7.view.b;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;
import com.tencent.map.geolocation.TencentLocation;
import java.util.Calendar;

class h extends g {
    private static n GQ;
    private int GR = -100;
    private boolean GS;
    boolean GT = true;

    class a extends b {
        final /* synthetic */ h GU;

        a(h hVar, Callback callback) {
            this.GU = hVar;
            super(hVar, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (this.GU.GT) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            Object aVar = new android.support.v7.view.f.a(this.GU.mContext, callback);
            b startSupportActionMode = this.GU.startSupportActionMode(aVar);
            if (startSupportActionMode != null) {
                return aVar.b(startSupportActionMode);
            }
            return null;
        }
    }

    h(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.GR == -100) {
            this.GR = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    public final boolean cT() {
        this.GS = true;
        int aC = aC(this.GR == -100 ? e.GE : this.GR);
        if (aC == -1) {
            return false;
        }
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i = configuration.uiMode & 48;
        aC = aC == 2 ? 32 : 16;
        if (i == aC) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = aC | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    int aC(int i) {
        Location location = null;
        switch (i) {
            case -100:
                return -1;
            case 0:
                boolean z;
                if (GQ == null) {
                    GQ = new n(this.mContext.getApplicationContext());
                }
                n nVar = GQ;
                a aVar = n.Ig;
                if (n.a(aVar)) {
                    z = aVar.Ii;
                } else {
                    Location t;
                    if (e.b(nVar.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        t = nVar.t(TencentLocation.NETWORK_PROVIDER);
                    } else {
                        t = null;
                    }
                    if (e.b(nVar.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        location = nVar.t("gps");
                    }
                    if (location == null || t == null) {
                        if (location != null) {
                            t = location;
                        }
                    } else if (location.getTime() > t.getTime()) {
                        t = location;
                    }
                    if (t != null) {
                        n.d(t);
                        z = aVar.Ii;
                    } else {
                        int i2 = Calendar.getInstance().get(11);
                        z = i2 < 6 || i2 >= 22;
                    }
                }
                return z ? 2 : 1;
            default:
                return i;
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.GR != -100) {
            bundle.putInt("appcompat:local_night_mode", this.GR);
        }
    }
}
