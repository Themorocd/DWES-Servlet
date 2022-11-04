/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class DB {
    private static String usuario = "root";
    private static String clave = "";
    private static String servidor = "localhost:3306";
    private static String bbdd = "ventas_comerciales";
    
    public static ArrayList<Producto> encuentraProducto(String referencia) {

        Producto producto = null;

        ArrayList<Producto> listaProducto = new ArrayList<Producto>();

        String sql = "SELECT * FROM productos where referencia='" + referencia + "'";

        Connection cnn = null;
        
        try {

            cnn = CrearConexion();

            PreparedStatement smt =  cnn.prepareStatement(sql);
            ResultSet rs =  smt.executeQuery();

            while (rs.next()) {

                producto = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getShort(5));
                listaProducto.add(producto);

            }
        } catch (SQLException ex) {
            System.out.println("Controlador JBDC no encontrado" + ex.toString());
        }

        return listaProducto;

    }

    private static Connection CrearConexion() {
        Connection cnn =null;

        try {
            Class.forName("com.mysql.jdbc.Driver");//invocamos el driver
            String url="jdbc:mysql://"+servidor+"/"+bbdd;
            cnn=DriverManager.getConnection(url,usuario,clave);//nos conectamos a la bbdd
        } catch (ClassNotFoundException c) {
            System.out.println("Controlador no encontrado"+c.toString());
        } catch (Exception c){
            System.out.println("Controlador no encontrado"+c.toString());
        }
        return cnn;
    }
    
 public static ArrayList<Producto> consultaProducto() {

        Producto producto = null;

        ArrayList<Producto> listaProducto = new ArrayList<Producto>();

        String sql = "SELECT * FROM productos";

        Connection cnn = null;
        try {

            cnn = CrearConexion();

            PreparedStatement smt =  cnn.prepareStatement(sql);
            ResultSet rs =  smt.executeQuery();

            while (rs.next()) {

                producto = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getShort(5));

                listaProducto.add(producto);

            }
        } catch (SQLException ex) {
            System.out.println("Controlador JBDC no encontrado" + ex.toString());
        }

        return listaProducto;

    }

  public static ArrayList<ventas> consultaVentas(String referencia) {
        ArrayList<ventas> listaVentas = new ArrayList<ventas>();
        Connection cnn = null;
        try {
            cnn = CrearConexion();
            
            String sql = "SELECT comerciales.nombre,productos.nombre,ventas.cantidad,productos.precio,"
                    + "(ventas.cantidad*productos.precio),productos.descuento,"
                    + "((ventas.cantidad*productos.precio)-((ventas.cantidad*productos.precio)*(productos.descuento/100))),"
                    + "ventas.fecha FROM comerciales,productos,ventas "
                    + "where productos.referencia=ventas.refProducto "
                    + "AND comerciales.codigo=ventas.codComercial "
                    + "AND productos.referencia='" + referencia + "'";
            PreparedStatement pst =  cnn.prepareStatement(sql);
            ResultSet rs =  pst.executeQuery(sql);

            while (rs.next()) {
                String comercial = rs.getString(1);
                String producto = rs.getString(2);
                int cantidad = rs.getInt(3);
                double precio = rs.getDouble(4);
                double total = rs.getDouble(5);
                int descuento = rs.getInt(6);
                double totalDescuento = rs.getDouble(7);
                String fecha = rs.getString(8);

                ventas venta = new ventas(fecha, comercial, cantidad, precio, total, descuento, totalDescuento);
                listaVentas.add(venta);
            }
            if (cnn != null) {
                cnn.close();
            }

        } catch (Exception e) {

        }
        return listaVentas;
    }
    public static ArrayList<comerciales> listadoComercial() {

        comerciales comercial = null;

        ArrayList<comerciales> listaComercial = new ArrayList<comerciales>();

        String sql = "SELECT codigo, nombre, salario, hijos FROM comerciales";

        Connection cnn = null;
        try {

            cnn = CrearConexion();

            PreparedStatement smt = cnn.prepareStatement(sql);
            ResultSet rs =  smt.executeQuery();

            while (rs.next()) {

                comercial = new comerciales(rs.getString(1), rs.getString(2), rs.getDouble(3),rs.getInt(4));

                listaComercial.add(comercial);

            }
        } catch (SQLException ex) {
            System.out.println("Controlador JBDC no encontrado" + ex.toString());
        }

        return listaComercial;

    }
    
     public static ArrayList<Producto> listadoProducto() {

        Producto producto = null;

        ArrayList<Producto> listaProducto = new ArrayList<Producto>();

        String sql = "SELECT referencia, nombre, descripcion FROM productos";

        Connection cnn = null;
        try {

            cnn = CrearConexion();

            PreparedStatement smt =  cnn.prepareStatement(sql);
            ResultSet rs =  smt.executeQuery();

            while (rs.next()) {

                producto = new Producto(rs.getString(1), rs.getString(2), rs.getString(3));

                listaProducto.add(producto);

            }
        } catch (SQLException ex) {
            System.out.println("Controlador JBDC no encontrado" + ex.toString());
        }

        return listaProducto;

    }

    public static void insertarVenta(ventas venta) {
         String sql = "INSERT INTO ventas VALUES (?,?,?,?)";

        Connection cnn = null;

        cnn = CrearConexion();

        try {
            PreparedStatement pst = (PreparedStatement) cnn.prepareStatement(sql);

            pst.setString(1, venta.getCodComercial());
            pst.setString(2, venta.getReferenciaProducto());
            pst.setInt(3, venta.getCantidad());
            pst.setString(4, venta.getFecha());

            pst.executeUpdate();
            pst = null;

        } catch (SQLException ex) {

        }
    }
    
    public static usuarios consultaDatos(String sql) {

        usuarios usuario = null;

        Connection cnn = null;
        try {

            cnn = CrearConexion();

            PreparedStatement smt =  cnn.prepareStatement(sql);
            ResultSet rs =  smt.executeQuery();

            while (rs.next()) {

                usuario = new usuarios(rs.getString(2), rs.getString(3));

            }
        } catch (SQLException ex) {
            System.out.println("Controlador JBDC no encontrado" + ex.toString());
        }

        return usuario;

    }

    public static void insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos VALUES (?,?,?,?,?)";

        Connection cnn = null;

        cnn = CrearConexion();

        try {
            PreparedStatement pst = (PreparedStatement) cnn.prepareStatement(sql);

            pst.setString(1, producto.getReferencia());
            pst.setString(2, producto.getNombre());
            pst.setString(3, producto.getDescripcion());
            pst.setDouble(4, producto.getPrecio());
            pst.setInt(5, producto.getDescuento());

            pst.executeUpdate();
            pst = null;

        } catch (SQLException ex) {

        }
    }

    public static int ModificarProducto(Producto producto) {
        
        int correcto = 0;
        
        String sql = "UPDATE productos SET nombre='" + producto.getNombre() + "',descripcion='" + producto.getDescripcion() + "', "
                + "precio='" + producto.getPrecio() + "', descuento='" + producto.getDescuento() + "'"
                + "WHERE referencia='" + producto.getReferencia() + "'";
       
        
        Connection cnn = null;

        cnn = CrearConexion();
        try {
         PreparedStatement pst = (PreparedStatement) cnn.prepareStatement(sql);

           correcto= pst.executeUpdate();
            pst = null;
         } catch (SQLException ex) {

        }
        return correcto;
    }

    public static void altaComercial(comerciales comercial) {
        String sql = "INSERT INTO comerciales VALUES (?,?,?,?,?)";

        Connection cnn = null;

        cnn = CrearConexion();

        try {
            PreparedStatement pst = (PreparedStatement) cnn.prepareStatement(sql);

            pst.setString(1, comercial.getCodigo());
            pst.setString(2, comercial.getNombre());
            pst.setDouble(3, comercial.getSalario());
            pst.setInt(4, comercial.getHijos());
            pst.setString(5, comercial.getFecha());
            
            

            pst.executeUpdate();
            pst = null;

        } catch (SQLException ex) {

        }
    }
    
    
}
