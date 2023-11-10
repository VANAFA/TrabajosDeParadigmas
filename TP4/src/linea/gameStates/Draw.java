package linea.gameStates;

import linea.Linea;

public class Draw extends State {
    
    public Draw(Linea game) {
        super(game);
    }

    @Override
    public String getResult(String result) {
        return result += "It's a draw!";
    }
}
