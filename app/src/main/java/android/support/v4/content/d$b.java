package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.wcdb.FileUtils;

class d$b {
    final IntentFilter filter;
    final BroadcastReceiver tP;
    boolean tQ;

    d$b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.filter = intentFilter;
        this.tP = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.tP);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.filter);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
