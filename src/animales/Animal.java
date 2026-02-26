/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;

    
        
        /**
     * Crea un nuevo objeto Animal con un código identificativo, fecha de nacimiento, sexo y peso.
     *
     * @param codigo código identificativo del animal, compuesto por 5 caracteres alfanuméricos en minúscula
     * @param fechaNacimiento fecha de nacimiento del animal en formato ISO-8601 (yyyy-MM-dd)
     * @param sexo sexo del animal, 'M' para hembra o 'H' para macho
     * @param peso peso del animal en kilogramos, debe ser mayor que 0
     *
     * @throws IllegalArgumentException si el código no cumple el patrón, el sexo es incorrecto,
     * el peso no es positivo o la fecha no tiene un formato válido correspondiente
     */
    
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }
    /**
 * Devuelve el código identificativo del animal.
 *
 * @return código identificativo del animal
 */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }
    /**
 * Devuelve la fecha de nacimiento del animal.
 *
 * @return fecha de nacimiento en formato ISO-8601 (yyyy-MM-dd)
 */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }
    /**
 * Devuelve el sexo del animal.
 *
 * @return 'M' si es hembra o 'H' si es macho
 */
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }
/**
 * Devuelve el peso actual del animal en kilogramos.
 *
 * @return peso del animal en kg
 */
    public double getPeso() {
        return peso;
    }
/**
 * Modifica el peso del animal.
 *
 * @param peso nuevo peso en kilogramos, debe ser mayor que 0
 * @throws IllegalArgumentException si el peso no es mayor que 0
 */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }
/**
 * Devuelve una representación en texto del animal con sus datos principales.
 *
 * @return cadena de texto con la información del animal
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }
    /**
    * Hace que el animal emita su sonido característico.
    * Este método puede ser sobrescrito por las subclases.
    */
    public abstract String hacerSonido();

    /**
 * Indica que el animal está contento y muestra su comportamiento alegre.
 */
    public abstract String alegrarse();

    /**
 * Indica que el animal se enfada y muestra su comportamiento agresivo.
 */
    public abstract String enfadarse();

    /**
 * Devuelve una cadena que indica qué tipo de animal es.
 *
 * @return texto descriptivo indicando el tipo de animal
 */
    public abstract String queSoy();

}
