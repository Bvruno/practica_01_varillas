package com.isil.practica01.util;

public class Constants {
	//Constantes
   public static final String JDBC_CLASS="com.mysql.jdbc.Driver";
   public static final String JDBC_URL="jdbc:mysql://localhost:3306/bruno_db?useSSL=false&&serverTimezone=UTC";
   public static final String JDBC_AUTONAME="mysql_dev";
   public static final String JDBC_PASSWORD="123456";
   
   
    public static final String INSERT_AUTOS_SQL = "INSERT INTO autos" + "  (modelo, color, marca) VALUES "
			+ " (?, ?, ?);";
	public static final String SELECT_AUTO_BY_ID = "select id,modelo,color,marca from autos where id =?";
	public static final String SELECT_ALL_AUTOS = "select * from autos";
	public static final String DELETE_AUTOS_SQL = "delete from autos where id = ?;";
	public static final String UPDATE_AUTOS_SQL = "update autos set modelo = ?,color= ?, marca =? where id = ?;";
   
}
