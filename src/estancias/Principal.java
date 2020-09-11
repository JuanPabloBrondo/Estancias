package estancias;

import estancias.entidades.casaService;
import estancias.entidades.estanciaService;
import estancias.entidades.familiaService;
import java.util.Date;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Bienvenido breu");
        familiaService fS = new familiaService();
        casaService cS = new casaService();
        estanciaService eS = new estanciaService();
        //    Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 
        fS.familiasConMenosDe3Hijos();
//Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
        cS.casaDisponibleAgosto();
        //Imagínate que, como cliente, estás interesado en mandar a tu hijo a una familia, de la que únicamente recuerdas que su nombre 
        //familiar terminaba en ‘y’. Escribe la consulta que te recupere las familias que cumplan tus restricciones.
        fS.familiasQueTerminanEnY();
        // Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
        fS.familiasconhotmail();
        //Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
        eS.listaDeEstancias();
        //Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por 
        //día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.
        cS.casasPrecioActualizadoRU();
        /*/Obtener el número de casas que existen para cada uno de los países diferentes.*/
        cS.CasasPorPais();
        /*Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.*/
        cS.CasasLimpias();
        //Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada
        // y un número de días específico.
        System.out.println("Ingrese el año");
        int anio=leer.nextInt();
        System.out.println("Ingrese el número de mes");
        int mes=leer.nextInt();
        System.out.println("Ingrese el día");
        int dia=leer.nextInt();
        System.out.println("Ingrese los días que se queda");
        int tiempoEstadia=leer.nextInt();
        Date calen=new Date(anio-1900, mes-1, dia);
        cS.casaDisponible(calen,tiempoEstadia);
        
        //Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
        eS.agregarEstancias();
    }
}
