package cl.inacap.reciclag.utils;

public class Utils {

    public static final String TABLA_SOLICITUDES="solicitud";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_LOTES="lotes";
    public static final String CAMPO_DIRECCION="direccion";

    public static final String CREAR_TABLA_SOLICITUD="CREATE TABLE " +
            ""+TABLA_SOLICITUDES+" ("+CAMPO_NOMBRE+" TEXT, "+CAMPO_LOTES+" INTEGER, "
            +CAMPO_DIRECCION+" TEXT)";
}
