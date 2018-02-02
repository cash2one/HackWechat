package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.support.v4.app.aj.a;

final class ab {
    static RemoteInput a(a aVar) {
        return new Builder(aVar.getResultKey()).setLabel(aVar.getLabel()).setChoices(aVar.getChoices()).setAllowFreeFormInput(aVar.getAllowFreeFormInput()).addExtras(aVar.getExtras()).build();
    }
}
