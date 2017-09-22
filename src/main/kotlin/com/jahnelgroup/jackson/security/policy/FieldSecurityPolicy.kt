package com.jahnelgroup.jackson.security.policy

import com.fasterxml.jackson.databind.ser.PropertyWriter
import org.springframework.context.ApplicationContextAware

/**
 * Defines the specification for a field security policy.
 *
 * @author Steven Zgaljic
 * @since 1.0.0
 */
interface FieldSecurityPolicy : ApplicationContextAware {

    /**
     * Determines if a user has access to a field. In order to accomplish this it will receive:
     *
     * @param[writer] Jackson [PropertyWriter] for the protected field.
     *
     * @param[target] POJO being serialized
     *
     * @param[targetCreatedByUser] user principal that created (aka, "owns") the target POJO.
     *
     * @param[currentPrincipalUser] current logged-in principal requesting access
     *
     * @return true if the field should be permitted, false if it should denied
     */
    fun permitAccess(
            writer: PropertyWriter,
            target : Any,
            targetCreatedByUser : String?,
            currentPrincipalUser : String?) : Boolean

}