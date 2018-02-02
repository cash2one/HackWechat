package android.support.v4.app;

import android.app.PendingIntent;
import android.support.v4.app.aj.a;

public final class ac {

    public static abstract class b {
        abstract a bk();

        abstract long getLatestTimestamp();

        abstract String[] getMessages();

        abstract String[] getParticipants();

        abstract PendingIntent getReadPendingIntent();

        abstract PendingIntent getReplyPendingIntent();
    }
}
