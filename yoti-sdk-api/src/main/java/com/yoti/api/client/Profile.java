package com.yoti.api.client;

import java.util.Collection;
import java.util.List;

/**
 * Yoti profile for a connect token and application. You can get a hold of one of these by using a {@link YotiClient}.
 */
public interface Profile {

    /**
     * Return typed {@link Attribute} object for a key.
     *
     * @param <T> the type parameter indicating the type of the returned value
     * @param name attribute name
     * @param clazz attribute type
     * @return typed attribute, null if it is not present in the profile
     */
    <T> Attribute<T> getAttribute(String name, Class<T> clazz);

    /**
     * Returns the {@link Attribute} object for the key
     *
     * @param name
     * @return the attribute object, null if it is not present in the profile
     */
    Attribute getAttribute(String name);

    /**
     * Return a list of all the {@link Attribute}s with a name starting with <code>name</code>
     *
     * @param <T>   the type parameter indicating the type of the returned value
     * @param name  attribute name
     * @param clazz attribute type
     * @return typed attribute value, <code>null</code> if there was no match
     */
    <T> List<Attribute<T>> findAttributesStartingWith(String name, Class<T> clazz);

    /**
     * Return the first {@link Attribute} with a name starting with <code>name</code>
     *
     * @param <T>   the type parameter indicating the type of the returned value
     * @param name  attribute name
     * @param clazz attribute type
     * @return typed attribute value, <code>null</code> if there was no match
     */
    <T> Attribute<T> findAttributeStartingWith(String name, Class<T> clazz);

    /**
     * Return all {@link Attribute}s for the profile.
     *
     * @return an unsorted collection of {@link Attribute}s
     */
    Collection<Attribute<?>> getAttributes();

}
