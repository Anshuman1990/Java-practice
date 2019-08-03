/**
 *
 */
package com.language.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author asaha
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JDBCConnection {
    String DatabaseName();

    String DatabaseUserName();

    String DatabasePassword();
}
