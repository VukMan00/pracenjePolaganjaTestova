/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Vuk
 */
public enum Operation implements Serializable{
    LOGIN,
    CREATE,
    ADD,
    UPDATE,
    DELETE,
    GET,
    GET_ONE
}
