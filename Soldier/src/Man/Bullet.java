/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Man;

import Man.AnimGLEventListener3.Direction;

/**
 *
 * @author myasd
 */
public class Bullet {
    Direction direction;
    int x,y;
    boolean fired = true ;
    
    
    public Bullet(Direction direction , int x  , int y ){
        this.direction=direction;
        this.x=x;
        this.y=y;
        this.fired = true;
    }
}
