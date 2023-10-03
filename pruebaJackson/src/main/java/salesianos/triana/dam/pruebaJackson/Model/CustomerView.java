package salesianos.triana.dam.pruebaJackson.Model;
/*
Esto son las vistas que vamos a tener segun lo que queramos
*/
public class CustomerView {
    //Mostrar toda la información
    public static class CustomerList{}
    //Mostrar información de uno solo
    public static class CustomerDetail extends CustomerList{}
    public static class CustomerEdit{}
}
