/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import java.util.List;

/**
 *
 * @author Acer
 * @param <EntityType>
 * @param <KeyType>
 */
abstract public class QLRPDAO<EntityType, KeyType> {

    abstract public void insert(EntityType entity);

    abstract public void update(EntityType entity);

    abstract public void delete(KeyType id);

    abstract public EntityType selectebyID(KeyType id);

    abstract public List<EntityType> selectAll();

    abstract public List<EntityType> selectbySql(String sql, Object... args);

}
