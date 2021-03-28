/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 11 de marzo de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.empleo.mundo;

import java.util.ArrayList;

/**
 * Es la clase que se encarga de manejar y organizar los aspirantes <br>
 * <b>inv: </b> <br>
 * aspirantes != null <br>
 * En el vector de aspirantes no hay dos o más con el mismo nombre
 */
public class BolsaDeEmpleo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los aspirantes
     */
    private ArrayList<Aspirante> aspirantes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva bolsa de emplea sin aspirantes.
     */
    public BolsaDeEmpleo() {
        aspirantes = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de aspirantes. La lista retornada no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     *
     * @return lista de aspirantes
     */
    public ArrayList<Aspirante> darAspirantes() {
        ArrayList<Aspirante> copia = new ArrayList<>(aspirantes);
        return copia;
    }

    /**
     * Agrega un nuevo aspirante a la bolsa
     *
     * @param nombreA           El nombre del aspirante - nombreA != null
     * @param profesionA        La profesión del aspirante - profesionA es uno de estos { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA Años de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El teléfono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     * @return Se retornó true si el aspirante fue adicionado o false de lo contrario
     */

    public boolean agregarAspirante(String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA) {
        int aspiranteBuscado = buscarAspirante(nombreA);
        boolean agregado = false;
        if (aspiranteBuscado == -1) {
            Aspirante nuevoAspirante = new Aspirante(nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA);
            aspirantes.add(nuevoAspirante);
            agregado = true;
        }

        return agregado;
    }

    /**
     * Organiza la lista de aspirantes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de aspirantes está ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre() {
        // TODO: Realizar el ejercicio correspondiente

        int n = this.aspirantes.size();
        Aspirante temp;

        System.out.println(this.aspirantes);


        for (int i = 0; i < n; i++) {
            for (int j =  i +1; j < n; j++) {


                if (this.aspirantes.get(j).darNombre().compareToIgnoreCase(this.aspirantes.get(i).darNombre())<0) {

                    temp = this.aspirantes.get(i);

                    this.aspirantes.set(i, this.aspirantes.get(j));
                    this.aspirantes.set(j, temp);

                }
            }
        }

        System.out.println(this.aspirantes);
    }

    /**
     * Organiza la lista de aspirantes por edad usando el algoritmo de selección <br>
     * <b>post: </b>La lista de aspirantes está ordenada por edad
     */
    public void ordenarPorEdad() {
        // TODO: Realizar el ejercicio correspondiente
        int i, j, pos;
        Aspirante menor, tmp;
        int n = this.aspirantes.size();
        for (i = 0; i < n - 1; i++) {
            menor = this.aspirantes.get(i);
            pos = i;
            for (j = i + 1; j < n; j++){
                if (this.aspirantes.get(j).darEdad() < menor.darEdad()) {
                    menor = this.aspirantes.get(j);
                    pos = j;
                }
            }
            if (pos != i){
                tmp = this.aspirantes.get(i);
                this.aspirantes.set(i,this.aspirantes.get(pos));
                this.aspirantes.set(pos,tmp);
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por profesión usando el algoritmo de burbuja <br>
     * <b>post: </b>El conjunto de aspirantes esta ordenado por profesión
     */
    public void ordenarPorProfesion() {
        // TODO: Realizar el ejercicio correspondiente
        int n = this.aspirantes.size();
        Aspirante temp;

        System.out.println(this.aspirantes);


        for (int i = 0; i < n; i++) {
            for (int j =  i +1; j < n; j++) {


                if (this.aspirantes.get(j).darProfesion().compareToIgnoreCase(this.aspirantes.get(i).darProfesion())<0) {

                    temp = this.aspirantes.get(i);

                    this.aspirantes.set(i, this.aspirantes.get(j));
                    this.aspirantes.set(j, temp);

                }
            }
        }

        System.out.println(this.aspirantes);
    }

    /**
     * Organiza la lista de aspirantes por años de experiencia usando el algoritmo de inserción <br>
     * <b>post: </b>La lista de aspirantes está ordenada por años de experiencia
     */
    public void ordenarPorAniosDeExperiencia() {
        // TODO: Realizar el ejercicio correspondiente
        int p, j;
        Aspirante temp;
        int n = this.aspirantes.size();
        for (p = 1; p < n; p++){
            temp = this.aspirantes.get(p);
            j = p - 1;
            while ((j >= 0) && (temp.darAniosExperiencia() < this.aspirantes.get(j).darAniosExperiencia())){
                this.aspirantes.set(j + 1,  this.aspirantes.get(j));
                j--;
            }
            this.aspirantes.set(j + 1,temp);
        }
    }

    /**
     * Busca un Aspirante según su nombre y retorna la posición en la que se encuentra. <br>
     *
     * @param nombre El nombre del aspirante buscado - nombre!=null
     * @return Se retornó la posición donde se encuentra un aspirante con el nombre dado. Si no se encuentra ningún aspirante con ese nombre se retornó -1.
     */
    public int buscarAspirante(String nombre) {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        int i = 0;
        for (Aspirante a: aspirantes) {
            if (a.darNombre().equalsIgnoreCase(nombre)) {
                posicion = i;
            }
            i++;
        }
        return posicion;
    }

    /**
     * Busca un aspirante utilizando una búsqueda binaria. <br>
     * <b>pre: </b> La lista de aspirantes se encuentra ordenada por nombre. <br>
     *
     * @param nombre es el nombre del aspirante que se va a buscar - nombre!=null
     * @return Se retornó la posición del aspirante con el nombre dado. Si el aspirante no existe se retornó -1.
     */
    public int buscarBinarioPorNombre(String nombre) {
        int posicion = -1;
        int ini = 0;
        int fin = aspirantes.size() - 1;

        // TODO: Realizar el ejercicio correspondiente
        this.ordenarPorNombre();
        while (ini <= fin) {
            int m = (ini + fin) / 2;
            if (aspirantes.get(m).darNombre().compareToIgnoreCase(nombre) < 0) {
                System.out.println("Entro a la menor");
                ini = m +1;
            }
            else if (aspirantes.get(m).darNombre().compareToIgnoreCase(nombre) > 0) {
                System.out.println("Entro a la mayor");
                fin = m - 1;
            } else {
                posicion = m;
                return posicion;
            }
        }

        return posicion;
    }


    /**
     * Busca el aspirante que tenga la menor edad en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante más joven. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMasJoven() {
        int posicion = -1;
        // TODO: Realizar el ejercicio correspondiente
        if (this.aspirantes.size() != 0) {
        posicion = 0;
        int i = 0;
        for (Aspirante a: aspirantes) {
            if (a.darEdad() < this.aspirantes.get(posicion).darEdad()) {
                posicion = i;
            }
            i++;
        }
        }

        return posicion;
    }

    /**
     * Busca el aspirante que tenga la mayor edad en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante con más edad. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMayorEdad() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        if (this.aspirantes.size() != 0) {
            posicion = 0;
            int i = 0;
            for (Aspirante a: aspirantes) {
                if (a.darEdad() > this.aspirantes.get(posicion).darEdad()) {
                    posicion = i;
                }
                i++;
            }
        }

        return posicion;
    }

    /**
     * Busca el aspirante con más años de experiencia en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante con mayor experiencia. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMayorExperiencia() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        if (this.aspirantes.size() != 0) {
            posicion = 0;
            int i = 0;
            for (Aspirante a: aspirantes) {
                if (a.darAniosExperiencia() > this.aspirantes.get(posicion).darAniosExperiencia()) {
                    posicion = i;
                }
                i++;
            }
        }

        return posicion;
    }

    /**
     * Contrata a un aspirante.<br>
     * <b>post: </b>Se eliminó el aspirante de la lista de aspirantes.
     *
     * @param nombre El nombre del aspirante a contratar - nombre!=null
     * @return Se retornó true si el aspirante estaba registrado en la bolsa o false de lo contrario
     */
    public boolean contratarAspirante(String nombre) {
        boolean contratado = false;

        // TODO: Realizar el ejercicio correspondiente
        System.out.println( this.aspirantes.get(0));
        if (nombre != null) {
        int i = 0;
        for (Aspirante a: aspirantes) {
            if(a.darNombre().equalsIgnoreCase(nombre)) {
                this.aspirantes.remove(i);
                contratado = true;
                break;
            }
            i++;

        }
        }
        return contratado;
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos años de experiencia <br>
     * son menores a la cantidad de años especificada <br>
     *
     * @param aniosExperiencia La cantidad de años con relación a la cual se van a eliminar los aspirantes. aniosExperiencia>=0
     * @return La cantidad de aspirantes que fueron eliminados
     */
    public int eliminarAspirantesPorExperiencia(int aniosExperiencia) {
        int eliminados = 0;

        int cont = 0;

        System.out.println(aniosExperiencia);
        // TODO: Realizar el ejercicio correspondiente
        if (aniosExperiencia >= 0) {
            ArrayList<Integer> indexAEliminar = new ArrayList<>();

            /*Aquí busco los index de las personas a eliminar según la condición y las agrego
            a una lista */
            for (Aspirante a: aspirantes) {
                if(a.darAniosExperiencia() < aniosExperiencia) {
                    indexAEliminar.add(cont);
                }
                cont++;

            }

            /*Aquí recorro la lista de index creada previamente y elimino los aspirantes según el index obtenido,
             y debido a que con las eliminaciones los index van cambiando,
             resto -1 al index luego de la primera eliminación*/
            if (indexAEliminar.size() > 0) {
                int j = 0;
                for (int index : indexAEliminar) {
                    this.aspirantes.remove(index - j);
                    j = 1;
                }
            }
            eliminados = indexAEliminar.size();
            System.out.println(indexAEliminar);
        }


        return eliminados;
    }

}