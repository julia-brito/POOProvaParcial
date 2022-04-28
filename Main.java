import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int escolha;

        do{
            escolha = Integer.parseInt(JOptionPane.showInputDialog(menu()));
            if(escolha < 1 || escolha > 5){
                JOptionPane.showMessageDialog(null, "Opção inválida");
            } else{
                switch(escolha){
                    case 1: 
                        Util.reservamesa();
                        break;
                    case 2:
                        Util.pesquisarreserva();
                        break;
                    case 3:
                        Util.imprimirreservas();
                        break;
                    case 4:
                        Util.ListaDeEspera();
                        break;
                    case 5:
                        Util.cancelarreserva();
                        break;
                }
            }

        } while(escolha != 5);
    }

    public static String menu(){

        String aux = "Restaurante SABOR SOFISTICADO";
               aux += "\n1. Reservar mesa";
               aux += "\n2. Pesquisar reserva";
               aux += "\n3. Imprimir reservas";
               aux += "\n4. Imprimir lista de espera";
               aux += "\n5. Cancelar reserva";
        
        return aux;
    }
}