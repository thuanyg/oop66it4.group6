/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author HOANG TIEN THUAN
 */
public interface DAOInterface<T> {

    public int Insert(T t);

    public int Update(T t);

    public int Delete(T t);

    public ArrayList<T> selectAll();
    
    public T selectById(T t);
    
}
