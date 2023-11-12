package linea.gameStates;

import linea.Linea;

public class BlueWon extends State {
    
    public BlueWon(Linea game) {
        super(game);
    }

    @Override
    public String getResult(String result) {
        return result += "Blue won!";
    }
}
