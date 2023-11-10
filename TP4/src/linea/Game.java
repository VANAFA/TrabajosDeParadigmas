package linea;

public class Game {

  public static void main( String[] args) throws Exception {

    System.out.println( "Dimensiones?");

    Linea game = new Linea( promptAsInt( "Base? " ), 

                            promptAsInt( "Altura? " ), 

                            promptAsChar( "Estartegia de Juego: A, B o C? " ) );
    
    boolean bot = promptAsChar( "Jugar contra la computadora? (s/n) " ) == 's';
  
    System.out.println( game.show() );

    while ( !game.finished() ) {

      game.playRedAt( promptAsInt( "Rojas? " ) );

      System.out.println( game.show() );


      if ( !game.finished() ) {

        if ( bot ) {

          new PlayerTwo( game ).play(); 

        } else {

          game.playBlueAt( promptAsInt( "Azul? " ) );
        }

        System.out.println( game.show() );
      }
    }
  }

  private static int promptAsInt( String message ) {

    System.out.print( message );

    return Integer.parseInt( System.console().readLine() );
  }

  private static char promptAsChar( String message ) {

    System.out.print( message );

    return System.console().readLine().charAt( 0 );
  }
}

//  javac linea/Linea.java linea/Game.java 

//  java linea.Game 