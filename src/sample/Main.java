package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public final static int NUM_PLAYER = 2;
    public final static int NUM_FRUIT_EACH = 3;
    public final static int PLAYER_WIDTH = 70;
    public final static int PLAYER_HEIGHT = 130;
    public final static int FRUIT_WIDTH = 30;
    public final static int FRUIT_HEIGHT = 30;
    public final static int HP_WIDTH = 10;
    public final static int HP_HEIGHT = 20;
    public final static int FRAME_WIDTH = 800;
    public final static int FRAME_HEIGHT = 600;
    public final static int CLOUD = 140;
    public final static int GROUND = FRAME_HEIGHT - PLAYER_HEIGHT - 75;
    public final static int P1_POSX = 100;
    public final static int P2_POSX = FRAME_WIDTH - PLAYER_WIDTH - P1_POSX;

    public int timerToStop = 20;


    Sprite sprite = new Sprite( "background2.jpg", "advnt_full.png", "advnt_full2.png",
            "tomato.png", "watermelon.png", "opening.jpg", "ending.jpg" );

    ArrayList<Player> player = new ArrayList<Player>();
    FruitGroup fruitGroup[] = new FruitGroup[2];


    ///     START THE GAME BY GOING TO START_STAGE FIRST    ///
    @Override
    public void start(Stage primaryStage) throws Exception {
        gameStage( primaryStage );
    }


    public Main(){

        for ( int i = 0; i < NUM_PLAYER; i++ )
            fruitGroup[i] = new FruitGroup();

        player.add( new Player( Player.PLAYER1, P1_POSX, GROUND ) );
        player.add( new Player( Player.PLAYER2, P2_POSX, GROUND ) );

        for (int i = 0; i < NUM_FRUIT_EACH; i++) {
            fruitGroup[ Player.PLAYER1 ].add( new Fruit(20 + i * FRUIT_WIDTH, 45) );
            fruitGroup[ Player.PLAYER2 ].add( new Fruit (FRAME_WIDTH - 120 + i* FRUIT_WIDTH, 45) );
        }
    }


    public void gameOver( AnimationTimer t, Player p1, Player p2, Stage primaryStage ) {
        if (p1.checkHitPoint() || p2.checkHitPoint()) {
            timerToStop--;
            System.out.println(timerToStop);
            if (timerToStop <= 0){
                HighScore.decidingWinner( p1, p2 );
                t.stop();
                endStage( primaryStage );
            }
        }
    }


    public void gameStage(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, Color.WHITE);

        HBox hBox = new HBox(FRAME_WIDTH - 170);
        Text text1 = new Text( player.get( Player.PLAYER1 ).getName() );
        Text text2 = new Text( player.get( Player.PLAYER2 ).getName());

        text1.setFill( Color.WHITE );
        text1.setStroke( Color.BLACK );
        text2.setFill( Color.WHITE );
        text2.setStroke( Color.BLACK );

        text1.setFont(Font.font("Rockwell Extra Bold", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        text2.setFont(Font.font("Rockwell Extra Bold", FontWeight.NORMAL, FontPosture.REGULAR, 18));

        hBox.setPrefWidth( FRAME_WIDTH );
        hBox.getChildren().addAll( text1, text2 );


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                /////       PLAYER 1      /////
                if ( player.get( Player.PLAYER1 ).statusMove() ) {
                    if (event.getCode() == KeyCode.W) {
                        player.get( Player.PLAYER1 ).fly();
                    }
                    if (event.getCode() == KeyCode.A) {
                        for (int i = 0; i < NUM_FRUIT_EACH; i++) {
                            if (fruitGroup[ Player.PLAYER1 ].getFruitList().get(i).isStandBy()) {
                                fruitGroup[ Player.PLAYER1 ].getFruitList().set(i, player.get( Player.PLAYER1 ).attack( fruitGroup[ Player.PLAYER1 ].getFruitList().get(i) ));
                                break;
                            }
                        }
                    }
                    if (event.getCode() == KeyCode.D) {
                        for (int i = 0; i < NUM_FRUIT_EACH; i++) {
                            if (fruitGroup[ Player.PLAYER1 ].getFruitList().get(i).isStandBy()) {
                                fruitGroup[ Player.PLAYER1 ].getFruitList().set(i, player.get( Player.PLAYER1 ).specialAttack( fruitGroup[ Player.PLAYER1 ].getFruitList().get(i) ));
                                break;
                            }
                        }
                    }
                    if (event.getCode() == KeyCode.S) {
                        if ( player.get( Player.PLAYER1 ).getGuardTimer() <= 0)
                            player.get( Player.PLAYER1 ).guard();
                    }
                }


                /////       PLAYER 2         /////
                if ( player.get( Player.PLAYER2 ).statusMove() ) {
                    if (event.getCode() == KeyCode.UP) {
                        player.get( Player.PLAYER2 ).fly();
                    }
                    if (event.getCode() == KeyCode.LEFT) {
                        for (int i = 0; i < NUM_FRUIT_EACH; i++) {
                            if (fruitGroup[ Player.PLAYER2 ].getFruitList().get(i).isStandBy()) {
                                fruitGroup[ Player.PLAYER2 ].getFruitList().set(i, player.get( Player.PLAYER2 ).attack( fruitGroup[ Player.PLAYER2 ].getFruitList().get(i) ));
                                break;
                            }
                        }
                    }
                    if (event.getCode() == KeyCode.RIGHT) {
                        for (int i = 0; i < NUM_FRUIT_EACH; i++) {
                            if (fruitGroup[ Player.PLAYER2 ].getFruitList().get(i).isStandBy()) {
                                fruitGroup[ Player.PLAYER2 ].getFruitList().set(i, player.get( Player.PLAYER2 ).specialAttack( fruitGroup[ Player.PLAYER2 ].getFruitList().get(i) ));
                                break;
                            }
                        }
                    }
                    if (event.getCode() == KeyCode.DOWN) {
                        if ( player.get( Player.PLAYER2 ).getGuardTimer() <= 0)
                            player.get( Player.PLAYER2 ).guard();
                    }
                }
            }
        });


        Canvas canvas = new Canvas( FRAME_WIDTH, FRAME_HEIGHT );
        GraphicsContext gc = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                drawShapes(gc);

                for ( int i = 0; i < NUM_PLAYER; i++ ) {
                    for (int j = 0; j < NUM_FRUIT_EACH; j++) {
                        fruitGroup[i].getFruitList().get(j).move();
                        fruitGroup[i].getFruitList().get(j).hitCheck( player );
                        fruitGroup[i].getFruitList().get(j).checkOutOfBound();
                    }
                    player.get(i).fall();
                    player.get(i).guardStatus();
                    player.get(i).hitStatus();
                    player.get(i).stunStatus();
                    player.get(i).attackingStatus();
                }
                gameOver(this, player.get( Player.PLAYER1 ), player.get( Player.PLAYER2 ), primaryStage);

            }
        };
        timer.start();

        StackPane stack = new StackPane();
        stack.getChildren().addAll(canvas, hBox);

        root.getChildren().add(stack);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void drawShapes(GraphicsContext gc) {

        /////   DRAW BACKGROUND     /////
        sprite.drawBackground( gc );

        /////   DRAW FLY LIMIT (THE CLOUD)     /////
        gc.setStroke(Color.BLUE);
        gc.strokeLine(0, CLOUD, FRAME_WIDTH, CLOUD);

        /////   DRAW PLAYER BODY AND ACTIONS      /////
        for ( int i = 0; i < NUM_PLAYER; i++) {
            if ( player.get(i).isGuardOn() ) {
                sprite.guard( player.get(i) );
            } else if ( player.get(i).isStunOn() ) {
                sprite.stunned( player.get(i) );
            } else if ( player.get(i).isBeingHit()) {
                sprite.beingHit( player.get(i) );
            } else if ( player.get(i).isAttacking()) {
                sprite.attacking( player.get(i) );
            } else {
                if ( player.get(i).getPos().getY() < GROUND ) {
                    sprite.idleFlying( player.get(i) );
                } else {
                    sprite.idle( player.get(i) );
                }
            }
            gc.setFill(Color.GREEN);
            gc.fillRect( player.get(i).getPos().getX(), player.get(i).getPos().getY(), PLAYER_WIDTH, PLAYER_HEIGHT );
            sprite.drawSprite( gc );
        }

        /////   DRAW FRUIT AND CHECK FRUIT TYPE     /////
        for ( int i = 0; i < NUM_PLAYER; i++ )
            for ( int j = 0; j < NUM_FRUIT_EACH; j++ )
                sprite.drawFruit( gc, fruitGroup[i].getFruitList().get(j) );

        /////   DRAW HITPOINT INDICATOR     /////
        gc.setFill( Color.GREEN );
        for ( int i = 0; i < player.get( Player.PLAYER1 ).getHitPoint(); i += 10 )
            gc.fillRect(20 + i, 20, HP_WIDTH, HP_HEIGHT);

        for ( int i = 0; i < player.get( Player.PLAYER2 ).getHitPoint(); i += 10 )
            gc.fillRect(FRAME_WIDTH - 120 + i, 20, HP_WIDTH, HP_HEIGHT);

        gc.setStroke( Color.BLACK );
        for ( int i = 0; i < Player.STARTING_HP; i += 10 ) {
            gc.strokeRect(20 + i, 20, HP_WIDTH, HP_HEIGHT);
            gc.strokeRect(FRAME_WIDTH - 120 + i, 20, HP_WIDTH, HP_HEIGHT);
        }
    }




    // EXTRA SCREENINGS //
    public void endStage(Stage primaryStage) {
        Group root = new Group();

        Text text1 = new Text();
        text1.setStroke( Color.BLACK );
        text1.setFill( Color.WHITE );
        text1.setText("WINNER");

        Text text2 = new Text();
        text2.setStroke( Color.BLACK );
        text2.setFill( Color.WHITE );
        text2.setText( HighScore.winner.getName() );

        Text text3 = new Text();
        text3.setStroke( Color.BLACK );
        text3.setFill( Color.WHITE );
        text3.setText( "Score: " + String.valueOf( HighScore.winner.getHighScore().getScore() ) );


        //Styling nodes
        text1.setFont(Font.font("Rockwell Extra Bold", FontWeight.NORMAL, FontPosture.REGULAR, 50));
        text2.setFont(Font.font("Rockwell Extra Bold", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        text3.setFont(Font.font("Rockwell Extra Bold", FontWeight.NORMAL, FontPosture.REGULAR, 30));


        // LAYOUT //
        ImageView mv = new ImageView( sprite.getImageBgEnding() );
        mv.setFitWidth( FRAME_WIDTH );
        mv.setFitHeight( FRAME_HEIGHT );


        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(0, 20, 0, 10));


        // SETTING CONTROL  //
        borderPane.setTop( text1 );
        borderPane.setMargin(text1, new Insets(200, 200, 0, 260));

        borderPane.setCenter( text2 );
        borderPane.setMargin(text2, new Insets( 30, 100, 20, 150 ));

        borderPane.setBottom( text3 );
        borderPane.setMargin(text3, new Insets( 20, 100, 100, 290 ));


        // LAST PHASE //
        root.getChildren().addAll(mv, borderPane);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }






    public void startStage( Stage primaryStage ){
        Group root = new Group();

        Text text1 = new Text();
        text1.setText("GET READY");

        Text text2 = new Text();
        text2.setText("Player 1");

        Text text3 = new Text();
        text3.setText("Player 2");

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();

        Button btn = new Button (); //creating button
        btn.setText("Start");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            ///     START THE GAME      ///
            @Override
            public void handle(ActionEvent event) {
                player.get( Player.PLAYER1 ).setName( String.valueOf( textField1.getText() ) );
                player.get( Player.PLAYER2 ).setName( String.valueOf( textField2.getText() ) );
                gameStage( primaryStage );
            }
        });



        GridPane gridPane = new GridPane();
        gridPane.setMinSize(100, 200); //size of pane
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setAlignment(Pos.CENTER);

        //Styling nodes
        btn.setStyle("-fx-background-color: beige; -fx-text-fill: black; -fx-base: orange;");
        btn.setFont(Font.font("Rockwell Extra Bold", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        text1.setStroke( Color.BLACK );
        text1.setFill(Color.WHITE);
        text1.setFont(Font.font("Rockwell Extra Bold",FontWeight.NORMAL, FontPosture.REGULAR, 30));

        text2.setFill(Color.WHITE);
        text2.setFont(Font.font("Cambria",FontWeight.NORMAL, FontPosture.REGULAR, 16));

        text3.setFill(Color.WHITE);
        text3.setFont(Font.font("Cambria",FontWeight.NORMAL, FontPosture.REGULAR, 16));

        //Arranges nodes
        gridPane.add(text2,0,1);
        gridPane.add(text3,0,2);
        gridPane.add(textField1, 1,1);
        gridPane.add(textField2,1,2);

        //layout
        ImageView mv = new ImageView( sprite.getImageBgOpening() );
        mv.setFitWidth( FRAME_WIDTH );
        mv.setFitHeight( FRAME_HEIGHT );

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(0, 20, 0, 10));

        //TOP
        borderPane.setTop( text1 );
        borderPane.setMargin(text1, new Insets(180, 100, 20, 300));

        //CENTER
        borderPane.setCenter( gridPane );
        borderPane.setMargin(gridPane, new Insets(0, 10, 0, 210));

        //BOTTOM
        borderPane.setBottom( btn );
        borderPane.setMargin(btn, new Insets(-60, 100, 100, 360));


        root.getChildren().addAll( mv, borderPane );

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

}