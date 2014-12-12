/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegametwopointo;

import audio.AudioPlayer;
import environment.Environment;
import environment.GraphicsPalette;
import environment.LocationValidatorIntf;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author ilovesoccer127
 */
class SnakeGameTwoPointOEnvironment extends Environment implements GridDrawData, LocationValidatorIntf {

    Grid grid;
    private Snake snake;
    
    public int SLOW_SPEED = 7;
    public int MEDIUM_SPEED = 5;
    public int HIGH_SPEED = 3;
    
    private int moveDelayCounter = 5;
    private int moveDelayLimit = MEDIUM_SPEED;
    private int speedIncreaseCouter = 30;
    private boolean increaseSpeed = false;
    
    private ArrayList<GridObject> gridObjects;

    private Image gameOver, laserCube;
    
    private Score score;

    public SnakeGameTwoPointOEnvironment() {
        
    }
    

    @Override
    public void initializeEnvironment() {
        this.setBackground(new Color(((int) (Math.random() * 255)), ((int) (Math.random() * 255)), ((int) (Math.random() * 255))));
        
        score = new Score();
        score.setPositon(new Point(0,0));
        
        gameOver = ResourceTools.loadImageFromResource("resources/GAMEOVER.gif");
//        laserCube = ResourceTools.loadImageFromResource("resources/LaserCube.gif");
        laserCube = ResourceTools.loadImageFromResource("resources/Laser Cube.gif");
        
        grid = new Grid(100, 80, 10, 10, new Point(0, 0), new Color(0,0,0));

        snake = new Snake();

        snake.setDirection(Direction.RIGHT);
        snake.setDrawData(this);
        snake.setLocationValidator(this);

        //<editor-fold defaultstate="collapsed" desc="Body Points">
        ArrayList<Point> body = new ArrayList<>();
        body.add(new Point(3, 10));
        body.add(new Point(4, 10));
        body.add(new Point(5, 10));
        body.add(new Point(6, 10));

//</editor-fold>
        snake.setBody(body);

        gridObjects = new ArrayList<>();
        //<editor-fold defaultstate="collapsed" desc="Grid Objects">
        gridObjects.add(new GridObject(GridObjectType.HappyFaceSunGlasses, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.HappyFaceSunGlasses, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.HappyFaceSunGlasses, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.HappyFaceSunGlasses, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.HappyFaceSunGlasses, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.HappyFaceSunGlasses, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.LASER_CUBE, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
        gridObjects.add(new GridObject(GridObjectType.PORTAL, new Point(getRandomPoint())));
//</editor-fold>

    }

    @Override
    public void timerTaskHandler() {
        //this.setBackground(new Color(((int) (Math.random() * 255)), ((int) (Math.random() * 255)), ((int) (Math.random() * 255))));
        if (snake != null) {
            // if counter >= limit them reset counter and move snake
            //else increment counter
            if (moveDelayCounter >= moveDelayLimit) {
                this.moveDelayCounter = 0;
                snake.move();
                

            } else {
                moveDelayCounter++;
            }

            if (increaseSpeed) {
                speedIncreaseCouter--;
                if (speedIncreaseCouter <= 0) {
                    moveDelayLimit--;
                    speedIncreaseCouter = 75;
                }
            }

        }

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            grid.setShowCellCoordinates(!grid.getShowCellCoordinates());
        } else if (e.getKeyCode() == KeyEvent.VK_P) {
            snake.togglePaused();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            snake.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            snake.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            snake.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            snake.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            snake.grow(1);
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            AudioPlayer.play("/resources/Laser_Gun.wav");
        }

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);
        }

        if ((snake != null) && (snake.isAlive())) {
            snake.draw(graphics);
        }
        
        if (gridObjects != null) {
            for (GridObject gridObject : gridObjects) {
                if (gridObject.getType() == GridObjectType.HappyFaceSunGlasses) {
                    GraphicsPalette.drawHappyFaceSunGlasses(graphics, grid.getCellSystemCoordinate(gridObject.getLocation()), grid.getCellSize(), Color.yellow);
                } else if (gridObject.getType() == GridObjectType.PORTAL) {
                    GraphicsPalette.drawEntryPortal(graphics, grid.getCellSystemCoordinate(gridObject.getLocation()), grid.getCellSize(), Color.yellow);
//                } else if (gridObject.getType() == GridObjectType.LASER_CUBE) {
//                    graphics.drawImage(laserCube, grid.getRandomGridLocation().x, grid.getRandomGridLocation().y, null );
               }
            }
        }
        if (snake.isDead()) {
//            graphics.drawImage(ResourceTools.loadImageFromResource("resources/GAMEOVER.gif"), 200, 175, null);
            graphics.drawImage(getGameOver(), 200, 175, null);
            
        }
        
        if (score != null) {
            score.draw(graphics);
        }
                
    }
    

    //<editor-fold defaultstate="collapsed" desc="GridDrawData Interface">
    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }

    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }

    @Override
    public Point getCellSystemCorrdinate(Point cellCorrdinate) {
        return grid.getCellSystemCoordinate(cellCorrdinate);
    }
//</editor-fold>

    @Override
    public Point validateLocation(Point point) {

        //<editor-fold defaultstate="collapsed" desc="Edge of the Grid Code">
        if (point.x < 0) {
//           point.x = grid.getColumns() - 1;
            snake.kill();
        }

        if (point.x > grid.getColumns() - 1) {
//            point.x = 0;
            snake.kill();
        }

        if (point.y < 0) {
//            point.y = grid.getRows() - 1;
            snake.kill();
        }

        if (point.y > grid.getRows() - 1) {
//            point.y = 0;
            snake.kill();
        }
//</editor-fold>

        //cheak if the snake hit a grid object then do the thing you want it to do
        // Actions: 
        //hit a LASER_CUBE - grow longer
        //hit a LASER_TRIANGLE - speed up exponentially 
        //hit a LASER_CIRCLE - return to normality 
        //hit a LASER_WALL - die
        //hit self - die
        //look at all the locatios stored in the gridObject ArrayList
        //for each, compare it to the head locaiton storedin the point perameter
        for (GridObject object : gridObjects) {
            if (object.getLocation().equals(point)) {
                System.out.println("HIT = " + object.getType());

                //change speed
                // if moveDelayCounter > 1 then  decrement it~!!!
//                if (moveDelayLimit > 1){
//                    moveDelayLimit--;
//                }
                if (object.getType() == GridObjectType.HappyFaceSunGlasses) {

                    object.setLocation(this.getRandomPoint());
                    increaseSpeed = true;
                    //remove object from the screen
                    snake.grow(3);
                } else if (object.getType() == GridObjectType.PORTAL) {
                    object.setLocation(this.getRandomPoint());
                    //return to normal speed
                    //increaseSpeed = false;
                    //moveDelayLimit = MEDIUM_SPEED;
                    snake.kill();
                    
                    
                }
            }
        }
//        if (snake.validateLocation().equals(point)) {
//            
//        }
        return point;

    }

    private Point getRandomPoint() {
        return new Point((int) (grid.getColumns() * Math.random()), (int) (grid.getRows() * Math.random()));
    }

    //<editor-fold defaultstate="collapsed" desc="GAMEOVER and Laser Cube getters and setters">
    /**
     * @return the gameOver
     */
    public Image getGameOver() {
        return gameOver;
    }
    
    /**
     * @param gameOver the gameOver to set
     */
    public void setGameOver(Image gameOver) {
        this.gameOver = gameOver;
    }
    
    /**
     * @return the laserCube
     */
    public Image getLaserCube() {
        return laserCube;
    }
    
    /**
     * @param laserCube the laserCube to set
     */
    public void setLaserCube(Image laserCube) {
        this.laserCube = laserCube;
    }
//</editor-fold>
}


