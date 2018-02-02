package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.c.d;
import java.io.IOException;
import java.io.InputStream;

public class bg$c implements d {
    private final Status bcR;
    private volatile InputStream bfA;
    private volatile ParcelFileDescriptor bfz;
    private volatile boolean mClosed = false;

    public bg$c(Status status, ParcelFileDescriptor parcelFileDescriptor) {
        this.bcR = status;
        this.bfz = parcelFileDescriptor;
    }

    public final InputStream getInputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Cannot access the input stream after release().");
        } else if (this.bfz == null) {
            return null;
        } else {
            if (this.bfA == null) {
                this.bfA = new AutoCloseInputStream(this.bfz);
            }
            return this.bfA;
        }
    }

    public final Status og() {
        return this.bcR;
    }

    public final void release() {
        if (this.bfz != null) {
            if (this.mClosed) {
                throw new IllegalStateException("releasing an already released result.");
            }
            try {
                if (this.bfA != null) {
                    this.bfA.close();
                } else {
                    this.bfz.close();
                }
                this.mClosed = true;
                this.bfz = null;
                this.bfA = null;
            } catch (IOException e) {
            }
        }
    }
}
