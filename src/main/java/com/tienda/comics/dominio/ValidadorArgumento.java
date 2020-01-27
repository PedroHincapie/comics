package com.tienda.comics.dominio;

import com.tienda.comics.dominio.excepcion.ExcepcionValorInvalido;
import com.tienda.comics.dominio.excepcion.ExcepcionValorObligatorio;

public final class ValidadorArgumento {

    private ValidadorArgumento() {
    }

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }

    public static void validarPositivo(Double valor, String mensaje) {
        if (valor <= 0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarPositivo(Long valor, String mensaje) {
        if (valor <= 0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
}
