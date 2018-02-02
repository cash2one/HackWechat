package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

final class a$a {
    public final Uri uri;

    public a$a(Uri uri) {
        this.uri = uri;
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof a$a) ? false : this == obj ? true : v.b(((a$a) obj).uri, this.uri);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.uri});
    }
}
