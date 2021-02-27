package ensta;
import java.io.Serializable;
import java.util.List;

import ship.*;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getDesignation(), s.getSize());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            
            boolean ok = false;
            do {
                try {
                    Direction newDirection;
                    switch (res.orientation) {
                        case "n":
                            newDirection = Direction.NORTH;
                            break;
                        case "s":
                            newDirection = Direction.SOUTH;
                            break;
                        case "e":
                            newDirection = Direction.EAST;
                            break;
                        case "w":
                            newDirection = Direction.WEST;
                            break;
                        default:
                            newDirection = Direction.EAST;
                    }


                    s.setDirection(newDirection);
                    board.putShip(s, res.x, res.y);
                    board.print();
                    ok = true;
                }
                catch (Exception e) {
                    System.out.println(e);
                }

            } while (!ok);
            ++i;
            done = i == 5;

            board.print();
        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done = false;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard

            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}