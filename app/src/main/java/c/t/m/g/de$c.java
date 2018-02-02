package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class de$c extends Handler {
    private /* synthetic */ de a;

    public de$c(de deVar, Looper looper) {
        this.a = deVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        Bundle data = message.getData();
        if (data != null) {
            TencentLocationListener c;
            switch (message.what) {
                case 3101:
                case 3103:
                    TencentLocation tencentLocation;
                    int i = data.getInt("error_code");
                    dz dzVar = dz.a;
                    if (i == 0) {
                        tencentLocation = (dz) data.getParcelable("tx_location");
                    } else {
                        Object obj = dzVar;
                    }
                    if (message.what == 3101) {
                        synchronized (de.b(this.a)) {
                            c = de.c(this.a);
                        }
                        if (c != null) {
                            c.onLocationChanged(tencentLocation, i, (String) de.c().get(i));
                            return;
                        }
                        return;
                    } else if (message.what == 3103 && de.y(this.a) != null) {
                        for (TencentLocationListener onLocationChanged : de.y(this.a)) {
                            onLocationChanged.onLocationChanged(tencentLocation, i, (String) de.c().get(i));
                        }
                        de.y(this.a).clear();
                        return;
                    } else {
                        return;
                    }
                case 3102:
                    String string = data.getString("name");
                    int i2 = data.getInt(DownloadInfo.STATUS);
                    String string2 = data.getString("desc");
                    synchronized (de.b(this.a)) {
                        c = de.c(this.a);
                    }
                    if (c != null) {
                        c.onStatusUpdate(string, i2, string2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
