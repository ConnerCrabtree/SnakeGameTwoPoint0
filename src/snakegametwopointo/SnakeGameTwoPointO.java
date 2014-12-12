/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegametwopointo;

import environment.ApplicationStarter;

/**
 *
 * @author ilovesoccer127
 */
public class SnakeGameTwoPointO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationStarter.run("Snake Game 2.0", new SnakeGameTwoPointOEnvironment());
        //ApplicationStarter.run("Snake Game 2.0", 500, 500, new SnakeGameTwoPointOEnvironment());
    }

}
