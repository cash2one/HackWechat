package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.ag.i;

class ag$f implements i {
    final int id;
    final String packageName;
    final String tag = null;
    final Notification tc;

    public ag$f(String str, int i, String str2, Notification notification) {
        this.packageName = str;
        this.id = i;
        this.tc = notification;
    }

    public final void a(s sVar) {
        sVar.a(this.packageName, this.id, this.tag, this.tc);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
        stringBuilder.append("packageName:").append(this.packageName);
        stringBuilder.append(", id:").append(this.id);
        stringBuilder.append(", tag:").append(this.tag);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
