import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Util {

    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public static void reservamesa(){

        boolean tipo;
        String aux = "";
        TipoPessoa tipoPessoa = inputTipoCliente(); 
        String nome = JOptionPane.showInputDialog("Nome: ");

        Cliente cliente = null;

        switch(tipoPessoa){

            case Fisica:
                String cpf = JOptionPane.showInputDialog("CPF: ");    
                PessoaFisica f = new PessoaFisica(nome, cpf);
                cliente = f;
                break;

            case Juridica:
                String cnpj = JOptionPane.showInputDialog("CNPJ: ");
                PessoaJuridica j = new PessoaJuridica(nome, cnpj);
                cliente = j;
                break;
        }


        while(!aux.equals("sim") && !aux.equals("nao")){
            aux = JOptionPane.showInputDialog("O pagamento será à vista? [Sim/Nao]: ").toLowerCase();
            if(!aux.equals("sim") && !aux.equals("nao")){
                JOptionPane.showMessageDialog(null, "Opa! Tente Novamente!\nCaso tenha dito 'Não' tente novamente sem o acento");
            }
        }
            
        if("s".equals(aux)){
            tipo = true;
        } else {
            tipo = false;        
        }
    
        Reserva reserva = new Reserva(cliente, tipo);
        reserva.setPagamentoAVista(tipo);
    
        reservas.add(reserva);
            
        if(reservas.size() > 6){
            JOptionPane.showMessageDialog(null, "Sem reservas disponíveis \nVocê está na lista de espera!");
        } else{
            JOptionPane.showMessageDialog(null, "Reserva efetuada, Obrigada!");
        }
    } 
    

    public static void pesquisarreserva(){

        if(reservas.size() > 0){
            String aux = JOptionPane.showInputDialog(null, "Informe seu CPF/CNPJ: ");
            int encontrar = conferir(aux);

            if(encontrar >= 0){
                JOptionPane.showMessageDialog(null, "Você possui uma reserva!"); 
            } else{
                JOptionPane.showMessageDialog(null, "Você não possui uma reserva!\nTente Novamente!");     
            }
        } else{
            JOptionPane.showMessageDialog(null, "Opa! Não tem reservas cadastradas\nTente Novamente!");     
        } 
    }
    private static TipoPessoa inputTipoCliente(){

        String tp="";

        while(!tp.equals("f") && !tp.equals("j")){
            tp = JOptionPane.showInputDialog("Tipo de cliente[F/J]: ").toLowerCase();
            if(!tp.equals("f") && !tp.equals("j")){
                JOptionPane.showMessageDialog(null, "Opa! Tente Novamente!\nLembrando que -> F: Físico & J: Jurídico");
            }
        }

        return tp.equals("f") ? TipoPessoa.Fisica : TipoPessoa.Juridica;
    }

    public static void ListaDeEspera(){
        if(reservas.size() > 6){
            for(int i = 0; i < reservas.size(); i++) {
                if(i >= 6){
                    JOptionPane.showMessageDialog(null, "Sua posição na lista de espera é: " + (i-5) + "\n" + reservas.get(i));
                }
            }
        } else{
            JOptionPane.showMessageDialog(null, "Ainda restam revervas disponíveis!");     
        }
         
    }
    public static void imprimirreservas(){
        if(reservas.size() > 0){
            for(int i = 0; i < reservas.size(); i++) {
                if(i < 6){
                    JOptionPane.showMessageDialog(null, reservas.get(i));
                } else{
                    return;
                }  
            }
        } else{
            JOptionPane.showMessageDialog(null, "Opa! Não há reservas!");    
        }
         
    }

    public static int conferir(String aux){

        if(reservas.size() > 0){

            for(int i = 0; i < reservas.size(); i++) {  
                if(reservas.get(i).getCliente() instanceof PessoaFisica){
                    Cliente c = reservas.get(i).getCliente();
                    PessoaFisica pf = (PessoaFisica) (c);
                    if(pf.getCpf().equals(aux)){
                        return i;
                    }
                }
                if(reservas.get(i).getCliente() instanceof PessoaJuridica){
                    Cliente c = reservas.get(i).getCliente();
                    PessoaJuridica pj = (PessoaJuridica) (c);
                    if(pj.getCnpj().equals(aux)){
                        return i;
                    }
                }
            }

        } 

        return -1;
    }
    public static void cancelarreserva(){

        if(reservas.size() > 0){
            String aux = JOptionPane.showInputDialog(null, "Informe seu CPF/CNPJ: ");
            int encontrar = conferir(aux);

            if(encontrar >= 0){
                reservas.remove(encontrar);
                JOptionPane.showMessageDialog(null, "Reserva removida com sucesso!\nVolte Sempre"); 
            } else{
                JOptionPane.showMessageDialog(null, "Opa! Seu CPF/CNPJ não foi encontrado");     
            }
        } else{
            JOptionPane.showMessageDialog(null, "Opa! Não existem reservas cadastradas!");     
        } 
    }
}
