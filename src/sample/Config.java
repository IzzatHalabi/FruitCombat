package sample;

public class Config {

    public final static int STUN_FIXED_TIMER = 100;
    public final static int GUARD_FIXED_TIMER = 40;
    public final static int HIT_FIXED_TIMER = 15;
    public final static int ATTACKING_FIXED_TIMER = 10;

    public final static int SLOW_FIXED_TIMER = 220;

    public final static int PLAYER_1 = 0;
    public final static int PLAYER_2 = 1;
    public final static int STARTING_HP = 100;
    public final static int FLY_SPEED = 70;
    public final static int GRAVITY = 2;

    public final static int MOVE_DIRECTION_LEFT = -1;
    public final static int MOVE_DIRECTION_RIGHT = 1;

    // TODO: Update these later. Most aren't even usable.
    public final static int NO_DAMAGE = 0;
    public final static boolean NO_STUN = false;
    public final static boolean HAS_STUN = true;

    public final static int TOMATO = 1;
    public final static int TOMATO_DAMAGE = 10;
    public final static boolean TOMATO_STUN = NO_STUN ;
    public final static int SPEED = 5;

    public final static int WATERMELON = 2;
    public final static int WATERMELON_DAMAGE = NO_DAMAGE;
    public final static boolean WATERMELON_STUN = HAS_STUN;

    public final static int GUMMY = 3;
    public final static int GUMMY_DAMAGE = NO_DAMAGE;
    public final static int GUMMY_SLOW = 30;
    public final static boolean GUMMY_STUN = NO_STUN;

    public final static int VINE = 4;
    public final static int VINE_DAMAGE = NO_DAMAGE;
    public final static boolean VINE_STUN = NO_STUN;
    public final static int VINE_SPEED = 7;

    public final static int BEAN = 5;
    public final static int BEAN_DAMAGE = 5;
    public final static boolean BEAN_STUN = NO_STUN ;
    public final static int BEAN_SPEED = 7;


    public final static int NUM_PLAYER = 2;
    public final static int NUM_FRUIT_EACH = 3;
    public final static int TOTAL_NUM_FRUIT = NUM_FRUIT_EACH*2;
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
    public final static int P1_POS_X = 100;
    public final static int P2_POS_X = FRAME_WIDTH - PLAYER_WIDTH - P1_POS_X;

    public final static int P1_THROW_START = PLAYER_WIDTH;
    public final static int P2_THROW_START = -FRUIT_WIDTH;

    public final static int DAMAGE_SCORE = -5;
    public final static int STUN_SCORE = -5;
    public final static int GUARD_SCORE = 10;

    // ActionStatusConfig
    public final static int[] P1_IDLE_GROUND = new int[]{0, 3, 0, -40, 40, 80};
    public final static int[] P1_IDLE_FLY = new int[]{290, 65, -15, -37, 32, 80};
    public final static int[] P1_GUARD = new int[]{290, 133, -15, -37, 32, 80};
    public final static int[] P1_ATTACK = new int[]{160, 133, 10, -35, 35, 79};
    public final static int[] P1_STUN = new int[]{62, 68, -30, -40, 32, 79};
    public final static int[] P1_BEING_HIT = new int[]{130, 65, -20, -50, 32, 79};

    public final static int[] P2_IDLE_GROUND = new int[]{290, 3, -10, -40, 35, 80};
    public final static int[] P2_IDLE_FLY = new int[]{0, 65, -10, -40, 35, 80};
    public final static int[] P2_GUARD = new int[]{0, 133, -8, -37, 32, 80};
    public final static int[] P2_ATTACK = new int[]{125, 133, -33, -38, 35, 79};
    public final static int[] P2_STUN = new int[]{230, 65, 12, -47, 32, 79};
    public final static int[] P2_BEING_HIT = new int[]{165, 65, 12, -47, 32, 79};
}
