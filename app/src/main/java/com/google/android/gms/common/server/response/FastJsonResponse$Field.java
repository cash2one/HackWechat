package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.a;
import java.util.Map;

public class FastJsonResponse$Field<I, O> implements SafeParcelable {
    public static final a CREATOR = new a();
    protected final int aOW;
    protected final boolean aOX;
    protected final int aOY;
    protected final boolean aOZ;
    protected final String aPa;
    protected final int aPb;
    protected final Class<? extends FastJsonResponse> aPc;
    protected final String aPd;
    FieldMappingDictionary aPe;
    a<I, O> aPf;
    final int mVersionCode;

    FastJsonResponse$Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
        a aVar = null;
        this.mVersionCode = i;
        this.aOW = i2;
        this.aOX = z;
        this.aOY = i3;
        this.aOZ = z2;
        this.aPa = str;
        this.aPb = i4;
        if (str2 == null) {
            this.aPc = null;
            this.aPd = null;
        } else {
            this.aPc = SafeParcelResponse.class;
            this.aPd = str2;
        }
        if (converterWrapper != null) {
            if (converterWrapper.aOQ != null) {
                aVar = converterWrapper.aOQ;
            } else {
                throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
            }
        }
        this.aPf = aVar;
    }

    public int describeContents() {
        return 0;
    }

    public final int oW() {
        return this.aOW;
    }

    public final boolean oX() {
        return this.aOX;
    }

    public final int oY() {
        return this.aOY;
    }

    public final boolean oZ() {
        return this.aOZ;
    }

    public final String pa() {
        return this.aPa;
    }

    public final int pb() {
        return this.aPb;
    }

    public final Class<? extends FastJsonResponse> pc() {
        return this.aPc;
    }

    final String pd() {
        return this.aPd == null ? null : this.aPd;
    }

    public final Map<String, FastJsonResponse$Field<?, ?>> pe() {
        w.ag(this.aPd);
        w.ag(this.aPe);
        return this.aPe.aP(this.aPd);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field\n");
        stringBuilder.append("            versionCode=").append(this.mVersionCode).append('\n');
        stringBuilder.append("                 typeIn=").append(this.aOW).append('\n');
        stringBuilder.append("            typeInArray=").append(this.aOX).append('\n');
        stringBuilder.append("                typeOut=").append(this.aOY).append('\n');
        stringBuilder.append("           typeOutArray=").append(this.aOZ).append('\n');
        stringBuilder.append("        outputFieldName=").append(this.aPa).append('\n');
        stringBuilder.append("      safeParcelFieldId=").append(this.aPb).append('\n');
        stringBuilder.append("       concreteTypeName=").append(pd()).append('\n');
        if (this.aPc != null) {
            stringBuilder.append("     concreteType.class=").append(this.aPc.getCanonicalName()).append('\n');
        }
        stringBuilder.append("          converterName=").append(this.aPf == null ? "null" : this.aPf.getClass().getCanonicalName()).append('\n');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
