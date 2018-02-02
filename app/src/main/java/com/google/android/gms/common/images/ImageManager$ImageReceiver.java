package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.images.ImageManager.c;
import java.util.ArrayList;

final class ImageManager$ImageReceiver extends ResultReceiver {
    private final Uri aMK;
    private final ArrayList<a> aML;
    final /* synthetic */ ImageManager aMM;

    public final void onReceiveResult(int i, Bundle bundle) {
        ImageManager.f(this.aMM).execute(new c(this.aMM, this.aMK, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
    }
}
