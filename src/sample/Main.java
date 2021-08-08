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
import sample.Fruits.FruitGroup;
import sample.Players.Player;
import sample.Players.PlayerGroup;
import sample.Controller.Controller;

import static sample.Config.*;

public class Main extends Application {

    public static int time = 0;
    public int timerToStop = 20;

    private Sprite sprite;
    private Controller controller;
    private FruitGroup fruitGroup;
    private PlayerGroup playerGroup;

    ///     START THE GAME BY GOING TO START_STAGE FIRST    ///
    @Override
    public void start(Stage primaryStage) throws Exception {
        gameStage( primaryStage );
    }


    public Main(){

        sprite = new Sprite(
                "images/background2.jpg", "images/advnt_full.png",
                "images/advnt_full2.png", "images/tomato.png",
                "images/watermelon.png", "images/opening.jpg",
                "images/ending.jpg" );

        playerGroup = new PlayerGroup();
        fruitGroup = new FruitGroup(playerGroup);
        controller = new Controller(playerGroup);
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
        Text text1 = new Text( playerGroup.get(PLAYER_1).getName() );
        Text text2 = new Text( playerGroup.get(PLAYER_2).getName());

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
                if (event.getCode() == KeyCode.W) {
                    controller.jump(PLAYER_1);
                }
                else if (event.getCode() == KeyCode.A) {
                    controller.attack(PLAYER_1);
                }
                else if (event.getCode() == KeyCode.D) {
                    controller.specialAttack(PLAYER_1);
                }
                else if (event.getCode() == KeyCode.S) {
                    controller.guard(PLAYER_1);
                }

                /////       PLAYER 2         /////
                if (event.getCode() == KeyCode.UP) {
                    controller.jump(PLAYER_2);
                }
                else if (event.getCode() == KeyCode.LEFT) {
                    controller.attack(PLAYER_2);
                }
                else if (event.getCode() == KeyCode.RIGHT) {
                    controller.specialAttack(PLAYER_2);
                }
                else if (event.getCode() == KeyCode.DOWN) {
                    controller.guard(PLAYER_2);
                }
            }
        });


        Canvas canvas = new Canvas( FRAME_WIDTH, FRAME_HEIGHT );
        GraphicsContext gc = canvas.getGraphicsContext2D();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                time++;
                playerGroup.update();
                fruitGroup.update();

                drawShapes(gc);

                gameOver(this, playerGroup.get(PLAYER_1), playerGroup.get(PLAYER_2), primaryStage);
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
        for (Player player : playerGroup.getPlayers()) {
            sprite.drawSprite_New(gc, player);
        }

        /////   DRAW FRUIT AND CHECK FRUIT TYPE     /////
        for (int i = 0; i < TOTAL_NUM_FRUIT; i++) {
            sprite.drawFruit(gc, fruitGroup.getFruit(i));
        }

        /////   DRAW HITPOINT INDICATOR     /////
        gc.setFill( Color.GREEN );
        for (int i = 0; i < playerGroup.get(PLAYER_1).getHitPoint(); i += 10 )
            gc.fillRect(20 + i, 20, HP_WIDTH, HP_HEIGHT);

        for (int i = 0; i < playerGroup.get(PLAYER_2).getHitPoint(); i += 10 )
            gc.fillRect(FRAME_WIDTH - 120 + i, 20, HP_WIDTH, HP_HEIGHT);

        gc.setStroke( Color.BLACK );
        for ( int i = 0; i < STARTING_HP; i += 10 ) {
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
                playerGroup.get(PLAYER_1).setName( String.valueOf( textField1.getText() ) );
                playerGroup.get(PLAYER_2).setName( String.valueOf( textField2.getText() ) );
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