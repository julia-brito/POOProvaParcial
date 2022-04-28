public class Reserva implements Pagamento{

    private Cliente cliente;
    private boolean pagamentoAVista;

    public Reserva(Cliente cliente, boolean pagamentoAVista){
        this.cliente = cliente;
        this.pagamentoAVista = pagamentoAVista;
    }

    public boolean getpagamentoAVista() {
        return this.pagamentoAVista;
    }

    public void setPagamentoAVista(boolean pagamentoAVista) {
        this.pagamentoAVista = pagamentoAVista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        
        String aux = "";
        
        if(cliente instanceof PessoaFisica){
            aux += "Pessoa Física";
        } else{
            aux += "Pessoa Jurídica"; 
        }

        aux += "\nCliente: " + cliente.getNome(); 

        if(getpagamentoAVista() == true){
            aux += "\nPagamento: À vista";
        } else{
            aux += "\nPagamento: Parcelado";
        }

        return aux;
    }
    

    @Override
    public double calcularPagamento(){
        
        double valor = 3200.00;

        if(pagamentoAVista == true){
            return valor * 0.9;
        } else{
            return valor;
        }
    }

}
