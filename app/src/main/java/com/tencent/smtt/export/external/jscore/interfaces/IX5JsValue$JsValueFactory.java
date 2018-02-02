package com.tencent.smtt.export.external.jscore.interfaces;

public interface IX5JsValue$JsValueFactory {
    String getJsValueClassName();

    IX5JsValue unwrap(Object obj);

    Object wrap(IX5JsValue iX5JsValue);
}
