//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.11.07 à 05:43:47 PM CET 
//


package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ccinfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ccinfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="validityDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ccv" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ccinfo", propOrder = {
    "number",
    "validityDate",
    "ccv"
})
@XmlRootElement(name = "ccinfo")
public class Ccinfo {

    @XmlElement(required = true)
    protected String number;
    @XmlElement(required = true)
    protected String validityDate;
    protected int ccv;

    /**
     * Obtient la valeur de la propriété number.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Définit la valeur de la propriété number.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Obtient la valeur de la propriété validityDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidityDate() {
        return validityDate;
    }

    /**
     * Définit la valeur de la propriété validityDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidityDate(String value) {
        this.validityDate = value;
    }

    /**
     * Obtient la valeur de la propriété ccv.
     * 
     */
    public int getCcv() {
        return ccv;
    }

    /**
     * Définit la valeur de la propriété ccv.
     * 
     */
    public void setCcv(int value) {
        this.ccv = value;
    }

}
