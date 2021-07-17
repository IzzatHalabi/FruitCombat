package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class Sprite {

    private Image imageBackground;
    private Image imagePlayer1;
    private Image imagePlayer2;
    private Image imageTomato;
    private Image imageWatermelon;
    private Image imageBgOpening;
    private Image imageBgEnding;
    private PixelReader reader;
    private WritableImage newImage;
    private int width, height;
    private Position imgListPos = new Position();
    private Position spritePos = new Position();
    private Position configPos = new Position();


    public Sprite( String pathBackground, String pathPlayer1, String pathPlayer2, String pathTomato, String pathWatermelon, String pathBgOpening, String pathBgEnding ){
        imageBackground = new Image( pathBackground );
        imagePlayer1 = new Image( pathPlayer1 );
        imagePlayer2 = new Image( pathPlayer2 );
        imageTomato = new Image( pathTomato );
        imageWatermelon = new Image( pathWatermelon );
        imageBgOpening = new Image ( pathBgOpening );
        imageBgEnding = new Image ( pathBgEnding );
    }



    /////       ACTION SPRITE       /////
    public void idle( Player p ){
        if ( p.getPlayerNum() == Player.PLAYER1 )
            organizeImage( imagePlayer1, 0, 3, 0, -40, 40, 80 );
        else
            organizeImage( imagePlayer2, 290, 3, -10, -40, 35, 80 );
        assignPos( p );
    }


    public void idleFlying( Player p ) {
        if ( p.getPlayerNum() == Player.PLAYER1 )
            organizeImage( imagePlayer1, 290, 65, -15, -37, 32, 80 );
        else
            organizeImage( imagePlayer2, 0, 65, -10, -40, 35, 80 );
        assignPos( p );
    }


    public void guard( Player p ){
        if ( p.getPlayerNum() == Player.PLAYER1 )
            organizeImage( imagePlayer1, 290, 133, -15, -37, 32, 80 );
        else
            organizeImage( imagePlayer2, 0, 133, -8, -37, 32, 80 );
        assignPos( p );
    }


    public void attacking( Player p ){
        if ( p.getPlayerNum() == Player.PLAYER1 )
            organizeImage( imagePlayer1, 160, 133, 10, -35, 35, 79 );
        else
            organizeImage( imagePlayer2, 125, 133, -33, -38, 35, 79 );
        assignPos( p );
    }


    public void stunned( Player p ){
        if ( p.getPlayerNum() == Player.PLAYER1 )
            organizeImage( imagePlayer1, 62, 68, -30, -40, 32, 79 );
        else
            organizeImage( imagePlayer2, 230, 65, 12, -47, 32, 79 );
        assignPos( p );
    }


    public void beingHit( Player p ){
        if ( p.getPlayerNum() == Player.PLAYER1 )
            organizeImage( imagePlayer1, 130, 65, -20, -50, 32, 79 );
        else
            organizeImage( imagePlayer2, 165, 65, 12, -47, 32, 79 );
        assignPos( p );
    }



    /////       SELECTING IMAGES FROM SPRITESHEET AND MANAGE THOSE IMAGES       /////
    public void organizeImage( Image imagePlayer, int imgListX, int imgListY, int configX, int configY, int width, int height ){
        reader = imagePlayer.getPixelReader();
        imgListPos.setX( imgListX );
        imgListPos.setY( imgListY );
        configPos.setX( configX );
        configPos.setY( configY );
        this.width = width;
        this.height = height;
    }


    public void assignPos( Player p ){
        newImage = new WritableImage( reader, imgListPos.getX(), imgListPos.getY(), width, height );
        spritePos.setX( p.getPos().getX() + configPos.getX() );
        spritePos.setY( p.getPos().getY() + configPos.getY() );
    }



    /////       DRAWING PART        /////
    public void drawSprite( GraphicsContext gc ){

        /*      the WIDTH and HEIGHT should depend on PLAYER_HEIGHT and PLAYER_WIDTH.
                SO THERE'S A NEED OF ADJUSTMENT

                EG:
        gc.drawImage( newImage, spritePos.getX(), spritePos.getY(), Main.PLAYER_WIDTH, Main.PLAYER_HEIGHT );
        */

        gc.drawImage( newImage, spritePos.getX(), spritePos.getY(), 100, 210 );
    }


    public void drawFruit ( GraphicsContext gc, Fruit f ){
        if ( f.getFruitType() == Fruit.TOMATO )
            gc.drawImage( imageTomato, f.getPos().getX(), f.getPos().getY(), Main.FRUIT_WIDTH,  Main.FRUIT_HEIGHT);
        else
            gc.drawImage( imageWatermelon, f.getPos().getX(), f.getPos().getY(), Main.FRUIT_WIDTH,  Main.FRUIT_HEIGHT);
    }


    public void drawBackground( GraphicsContext gc ){
        gc.drawImage( imageBackground,0,0, Main.FRAME_WIDTH, Main.FRAME_HEIGHT);
    }






    /////       SETTER AND GETTER       /////
    public Image getImageBgOpening() {
        return imageBgOpening;
    }

    public Image getImageBgEnding() {
        return imageBgEnding;
    }
}
