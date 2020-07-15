package br.com.app.trinitymobile.utils;

import java.io.Serializable;

public interface AsyntaskResponse<T extends Serializable> {
       void processSaveFinish(T object);
}
