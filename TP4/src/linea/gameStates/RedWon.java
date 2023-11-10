package linea.gameStates;

import linea.Linea;

public class RedWon extends State {
    
    public RedWon(Linea game) {
        super(game);
    }

    @Override
    public String getResult(String result) {
        return result += "Red won!";
    }
}
