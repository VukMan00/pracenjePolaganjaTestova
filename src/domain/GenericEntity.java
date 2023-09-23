/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vuk
 */
public interface GenericEntity extends Serializable{
    
    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();
    
    String getWhereCondition(Object object);
    
    void setId(Integer id);
    
    String getSelectValues();
    
    String getDeleteAndUpdateCondition(Object object);
    
    String getUpdateSetValues(Object object);
    
    String getCreateInsertValues();
    
    String getColumnNamesForCreate();
    
    GenericEntity getNewObject(ResultSet rs) throws SQLException;
    
}
