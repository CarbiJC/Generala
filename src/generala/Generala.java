package generala;
import javax.swing.*;
class Generala {

	public static void main(String[] args) {
		
		
		int aux=0, puntosTot=0, cambiar=0;
		double ap=0;
		boolean quedar=false;
		String mensaje="";
		
		
		//uso estos booleanos para calcular lo puntos adelante
		boolean escMayor=false, escMenor=false, full=false, poker=false, generala=false;
	
		// ARRAYS PARA INICIALIZAR Y PARA CAMBIAR SI SE QUIERE
		int[]dados= new int[5];
		boolean[] dadoACambiar= new boolean[5];
		
		// CANTIDAD DE INTENTOS PARA CAMBIAR LOS DADOS
		int intentos=3;
		
		//REGLAS
		
		JOptionPane.showMessageDialog(null, "A continuación se presentarán las reglas de la generala.\n"
				+ "Consiste en lanzar 5 dados, y SI SE QUIERE, se le dara la opción al jugador de \n"
				+ "cambiar hasta 3 dados, la idea es juntar la mayor cantidad de puntos posibles", "REGLAS.", JOptionPane.DEFAULT_OPTION);
		JOptionPane.showMessageDialog(null, "Escalera Menor: se forma con 1 - 2 - 3 - 4 - 5\r\n" 
				+ "Escalera Mayor: se forma con 2 - 3 - 4 - 5 - 6\r\n"
				+ "Full: se forma con 3 dados del mismo número y 2 iguales de otro.\r\n"
				+ "Poker: se forma con 4 dados de igual número.\r\n"
				+ "Generala: se forma con 5 dados de igual número.", "PUNTOS.", JOptionPane.DEFAULT_OPTION);
		//APUESTA
		
			
			ap = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese su apuesta.", "APUESTA.",
					JOptionPane.DEFAULT_OPTION, new ImageIcon(Generala.class.getResource("/img/gamble.gif")), null,
					null));
			
		
		//TIRADA DE DADOS 
		
		for (int i = 0; i < 5; i++) {
			dados[i]=(int)(Math.random()*6+1);
			//mostrar los dados
			System.out.println("dado " + (i+1) + " es " + dados[i]);
		}
		
		
		
		//JOptionPane.showMessageDialog(null, "Su primer dado es: " + dados[1], "PRIMER DADO.", JOptionPane.DEFAULT_OPTION);
		
		
		JOptionPane.showMessageDialog(null, "Su primer dado es: " + dados[0], "PRIMER DADO.", JOptionPane.DEFAULT_OPTION, new ImageIcon(Generala.class.getResource("/img/d" + dados[0] + ".png")));
		JOptionPane.showMessageDialog(null, "Su segundo dado es: " + dados[1], "SEGUNDO DADO.", JOptionPane.DEFAULT_OPTION, new ImageIcon(Generala.class.getResource("/img/d" + dados[1] + ".png")));
		JOptionPane.showMessageDialog(null, "Su tercer dado es: " + dados[2], "TERCER DADO.", JOptionPane.DEFAULT_OPTION, new ImageIcon(Generala.class.getResource("/img/d" + dados[2] + ".png")));
		JOptionPane.showMessageDialog(null, "Su cuarto dado es: " + dados[3], "CUARTO DADO.", JOptionPane.DEFAULT_OPTION, new ImageIcon(Generala.class.getResource("/img/d" + dados[3] + ".png")));
		JOptionPane.showMessageDialog(null, "Su quinto dado es: " + dados[4], "QUINTO DADO.", JOptionPane.DEFAULT_OPTION, new ImageIcon(Generala.class.getResource("/img/d" + dados[4] + ".png")));
	
		
		
		//ordenamiento 
		
		 for (int i = 0; i < dados.length - 1; i++) {
	            for (int j = 0; j < dados.length - i - 1; j++) {
	                if (dados[j] > dados[j + 1]) {
	                    int temp = dados[j];
	                    dados[j] = dados[j + 1];
	                    dados[j + 1] = temp;
	                }
	            }

	         //MUESTRA LOS DADOS ORDENADOS
	            
		 }
		 System.out.println("\n/////////////////////////////");
		 System.out.println("\nLos dados ordenados son: " + dados[0] + ", " + dados[1] + ", " + dados[2] + ", " + dados[3]
				 + ", " + dados[4]);
		
		 //pregunta para cambiar
		 
		 
		do {
			if (intentos==3) {
				aux=Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea cambiar un dado?\n1-SI\n2-NO"));
			}else {
				aux=Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea cambiar otro dado?\n1-SI\n2-NO"));
			}
		
		if (aux==1) {
			//PARA QUE EL USUARIO CAMBIE 
			intentos--;
			if (intentos==0) {
				JOptionPane.showMessageDialog(null, "No quedan mas intentos para cambiar los dados", mensaje, JOptionPane.DEFAULT_OPTION);
				break;
			
			}else 
			 do {
                 cambiar = Integer.parseInt(JOptionPane.showInputDialog(null,
                         "Ingrese la posición del dado que desea cambiar (1-5).", "CAMBIO DE DADOS.",
                         JOptionPane.DEFAULT_OPTION));
             } while (cambiar < 1 || cambiar > 5);

             dadoACambiar[cambiar - 1] = true;
         } else if (aux == 2) {
             quedar = true;
         }

     } while (!quedar);

     // cambio de dados seleccionados
     for (int i = 0; i < 5; i++) {
         if (dadoACambiar[i]) {
             dados[i] = (int) (Math.random() * 6 + 1);
             JOptionPane.showMessageDialog(null,
                     "Nuevo valor del dado " + (i + 1) + " es " + dados[i], "CAMBIO DE DADOS",
                     JOptionPane.DEFAULT_OPTION);
             System.out.println("\nNuevo valor del dado " + (i + 1) + ": " + dados[i]);
         }
     }		
			 
		
		//ordenamiento 
		
		 for (int i = 0; i < dados.length - 1; i++) {
	            for (int j = 0; j < dados.length - i - 1; j++) {
	                if (dados[j] > dados[j + 1]) {
	                    int temp = dados[j];
	                    dados[j] = dados[j + 1];
	                    dados[j + 1] = temp;
	                }
	            }

	         //MUESTRA LOS DADOS ORDENADOS
	      
		 }
		 System.out.println("\n/////////////////////////////");
		 System.out.println("\nLos dados ordenados son: " + dados[0] + ", " + dados[1] + ", " + dados[2] + ", " + dados[3]
				 + ", " + dados[4]);
		//PUNTAJE
		
		//comprobacion de escaleras
		//menor
        if (dados[0] == 1 && dados[1] == 2 && dados[2] == 3 && dados[3] == 4 && dados[4] == 5) {
            puntosTot = 20;
            escMenor=true;
            mensaje="Usted obtuvo Escalera Menor.";
            ap=(ap*100)+ap;
        }//comprobacion de mayor
        else if (dados[0] == 2 && dados[1] == 3 && dados[2] == 4 && dados[3] == 5 && dados[4] == 6) {
            puntosTot = 30;
            escMayor=true;
            mensaje="Usted obtuvo Escalera Mayor.";
            ap=(ap*100)+ap;
        }//comprobacion de full
        else if ((dados[0] == dados[1] && dados[1] == dados[2] && dados[3] == dados[4]) ||
                (dados[0] == dados[1] && dados[2] == dados[3] && dados[3] == dados[4])) {
            puntosTot= 35;
            full= true;
            mensaje="Usted obtuvo Full.";
            ap=(ap*200)+ap;
        }// Comprobar si es Poker
        else if (dados[0] == dados[3] || dados[1] == dados[4]) {
            puntosTot= 40;
            poker= true;
            mensaje="Usted obtuvo Poker.";
            ap=(ap*400)+ap;
        }//comprueba la generala
        else if (dados[0] == dados[4]) {
            puntosTot= 50;
           generala= true;
           mensaje="Usted obtuvo generala.";
           ap=(ap*1000)+ap;
        }//cuenta puntos individuales
        else {
            for (int dado : dados) {
                puntosTot+= dado;
                mensaje="No pudo lograr un puntaje establecido por las reglas.\nSe han sumado todos los valores de los dados.";
                
            }
        }
		
		
	
		
		
	JOptionPane.showMessageDialog(null, "Sus puntos totales fueron: " + puntosTot +" \n" + mensaje + "\nUsted recibirá un total de : $" + ap +"0");
	
	System.out.println("\n" + (mensaje));
	

		
		
		
		
	}

}