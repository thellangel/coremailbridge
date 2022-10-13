
package com.hdsoft.coremailbridge.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>delSmtpAlias complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="delSmtpAlias">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user_at_domain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alias_user_at_domain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "delSmtpAlias", propOrder = {
    "userAtDomain",
    "aliasUserAtDomain"
})
public class DelSmtpAlias {

    @XmlElement(name = "user_at_domain")
    protected String userAtDomain;
    @XmlElement(name = "alias_user_at_domain")
    protected String aliasUserAtDomain;

    /**
     * \u83b7\u53d6userAtDomain\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserAtDomain() {
        return userAtDomain;
    }

    /**
     * \u8bbe\u7f6euserAtDomain\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserAtDomain(String value) {
        this.userAtDomain = value;
    }

    /**
     * \u83b7\u53d6aliasUserAtDomain\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasUserAtDomain() {
        return aliasUserAtDomain;
    }

    /**
     * \u8bbe\u7f6ealiasUserAtDomain\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasUserAtDomain(String value) {
        this.aliasUserAtDomain = value;
    }

}
