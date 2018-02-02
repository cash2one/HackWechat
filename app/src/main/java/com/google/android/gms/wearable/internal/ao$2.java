package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k.b;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class ao$2 implements Runnable {
    final /* synthetic */ Uri bep;
    final /* synthetic */ boolean beq;
    final /* synthetic */ ao bff;
    final /* synthetic */ b bfg;
    final /* synthetic */ String bfh;

    ao$2(ao aoVar, Uri uri, b bVar, boolean z, String str) {
        this.bff = aoVar;
        this.bep = uri;
        this.bfg = bVar;
        this.beq = z;
        this.bfh = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        Log.isLoggable("WearableClient", 2);
        if ("file".equals(this.bep.getScheme())) {
            Object file = new File(this.bep.getPath());
            try {
                ParcelFileDescriptor open = ParcelFileDescriptor.open(file, (this.beq ? 33554432 : 0) | SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                try {
                    ((x) this.bff.oK()).a(new an$i(this.bfg), this.bfh, open);
                    try {
                        open.close();
                        return;
                    } catch (IOException e) {
                        return;
                    }
                } catch (RemoteException e2) {
                    this.bfg.c(new Status(8));
                    return;
                } catch (Throwable th) {
                    try {
                        open.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (FileNotFoundException e4) {
                new StringBuilder("File couldn't be opened for Channel.receiveFile: ").append(file);
                this.bfg.c(new Status(13));
                return;
            }
        }
        this.bfg.c(new Status(10, "Channel.receiveFile used with non-file URI"));
    }
}
