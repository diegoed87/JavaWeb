package com.asesoftware.pruebapiloto.utils;


/**
 * Clase con constantes consultadas por diferentes clases de la aplicación
 * 
 * @author GeneradorCRUD
 */

public class UtilConstantes {
	
	public static final String SEPARADOR_HTTP_ORDER_BY = "$";    
    public static final String CARACTER_DE_ESCAPE = "\\";    
    public static final String SEPARADOR_PARAMETROS_CONSULTA = "&";    
    
    //ManejadorCrud
    public static final String NULL_VALUE = "NULL";
    public static final String NOT_NULL_VALUE = "NOT NULL";
    
    //UtilReflection
    public static final String LONG_PRIMITIVE = "long";
    public static final String INT_PRIMITIVE = "int";
    
    //CriteriaSearch
    
    public static final String TYPESAFE_QUERY = "TypesafeQuery";
    
    public static final String TQ_CONDITIONS = "Conditions";
    public static final String TQ_ORDERING = "Ordering";
    public static final String TQ_GROUPING = "Grouping";
    
    
    public static final String EXPRESSION_METHODS = "ExpressionMethods";
    public static final String CRITERIA_METHODS = "CriteriaMethods";
    public static final String COMPOUND_METHODS = "CompoundMethods";
    
    public static final String EX_IS_NULL = "isNull";
    public static final String EX_IS_NOT_NULL = "isNotNull";
    public static final String EX_IN = "in";
    
    public static final String CR_EQUAL = "equal";
    public static final String CR_NOT_EQUAL = "notEqual";
    public static final String CR_GREATER_THAN = "gt";
    public static final String CR_GREATER_EQUAL = "ge";
    public static final String CR_LESS_THAN = "lt";
    public static final String CR_LESS_EQUAL = "le";
    public static final String CR_BETWEEN = "between";
    public static final String CR_LIKE = "like";
	
    public static final String CM_AND = "and";
    public static final String CM_OR = "or";
    public static final String CM_NOT = "not";
    
    public static final String OR_ASC = "asc";
    public static final String OR_DESC = "desc";
    
    public static final String PAGINA_INICIO = "/portalpensionados-web/pages/index.xhtml";
    
    public static final String CERO_STR = "0";
    public static final String UNO_STR = "1";
    public static final String DOS_STR = "2";
    public static final String TRES_STR = "3";
    public static final String CUATRO_STR = "4";
    public static final String CINCO_STR = "5";
    public static final String SEIS_STR = "6";
    public static final String SIETE_STR = "7";
    public static final String OCHO_STR = "8";
    public static final String NUEVE_STR = "9";
    
    public static final String CORREO_AUTENTICACION_ASUNTO = "Clave de acceso pensionados";
    public static final String ALGORITMO_AUTENTICACION = "SHA-256";
    public static final String O2X = "%02x";
    
    public static final String PATH_REPORTE = "C:/reportes/";
    public static final String PATH_FUENTE_REPORTE = "C:/reportes/fuente/";
    public static final String ARCHIVO_CERTIFICADO_PENSION = "pension_mas_ultimos_tres_pagos.jasper";
    public static final String ARCHIVO_CERTIFICADO_INGRESOS_Y_RETENCIONES = "pago_anual_mas_IyR.jasper";
    public static final String PARAMETRO_DOCUMENTO_CERT_PENSION = "p_num_documento";
    public static final String SUBREPORT_DIR = "SUBREPORT_DIR";
    public static final String PARAMETRO_DOCUMENTO_CERT_INGRESOS_RETENCIONES = "num_documento";
    public static final String PARAMETRO_FECHA_CERT_INGRESOS_RETENCIONES = "p_fecha_desde";
    public static final String PREFIJO_NOMBRE_ARCHIVO_CERT_PENSION_PAGOS ="Pensionypagos";
    public static final String PREFIJO_NOMBRE_ARCHIVO_CERT_INGRESOS_RETENCIONES ="Ingresosyretenciones";
    public static final String EXTENSION_PDF = ".pdf";
    
    private UtilConstantes(){}

}
