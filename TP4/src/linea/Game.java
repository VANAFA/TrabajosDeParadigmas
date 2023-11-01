package linea;

public class Game {

  public static void main( String[] args) throws Exception {

    System.out.println( "Dimensiones?");

    Linea game = new Linea( prompt( "Base: " ), prompt( "Altura: " ), prompt( "Select game mode (1-3): " ) );
    

    System.out.println( game.show() );


    while ( !game.isFinished() ) {

      game.playRedAt( prompt( "Juega X " ) - 1 );

      System.out.println( game.show() );

      

      if ( !game.isFinished() ) {

        game.playBlueAt( prompt( "Juega O " ) - 1 );

        System.out.println( game.show() );

      }

    }

    

  }

  private static int prompt( String message ) {

    System.out.print( message );

    return Integer.parseInt( System.console().readLine() );

  }
}

// Para compilar el código ejecutar fuera del paquete linea lo siguiente:

//  javac linea/Linea.java linea/Game.java 

//  Para correr el juego ejecutar los siguiente:

//  java linea.Game 